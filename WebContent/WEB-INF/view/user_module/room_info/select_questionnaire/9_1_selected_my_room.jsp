<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    
     <!-- JS files -->
	<script type="text/javascript" src="resources/js/json-minified.js" ></script>    

	<!-- CSS files -->
	<link type="text/css" rel="stylesheet" href="resources/css/jquery.lightbox-0.5.css" />
	
	<script type="text/javascript">
               
 	$(document).ready(function(){
 		var uploadedImages = '<c:out value="${uploadedImgInDB}"/>';        
        var clientUpImgIdList = '<c:out value="${clientUploadImgId}"/>';        
       
	$("#uploadBut").click(function (){	
    var result = true;
   
    if(clUploadedImgsCount < 8) {    	
    	result = true;
    } else {
    	alert("You can only upload 8 images at this time. ");
    	result = false;
    }
    var fileName = $("#fileUpload").val();
    var fileExtension = fileName.replace(/^.*\./, '').toLowerCase();
	if(fileName === ""){ alert("PLEASE CHOOSE AN IMAGE FILE TO UPLOAD.");
	result = false;
    } else if(!(fileExtension === "png" || fileExtension === "jpg" || fileExtension === "gif" || fileExtension === "jpeg")){
    alert("Please upload a JPG, GIF, or PNG file. ");
    return false;
    }
	return result;
	});
	

	$("#abtSpaceButtonId").click(function (){    	
    	document.myDesign.moreAboutSpace.value = $("#moreAboutSpaceId").val();
    });
	
	var moreAboutSpaces = '<c:out value="${moreAboutSpace}"/>';
    $("[name=moreAboutSpace]").val(moreAboutSpaces);
	
        var uploadedImage = uploadedImages.split("_,_");
        var clientUpImgId = clientUpImgIdList.split("_,_");
        
        var imgsLength = clientUpImgId.length;
        
        var tab1 = $("#spaceImg1List");
        var tab2 = $("#spaceImg2List");
                                
        for (var i = 0; i < 4 && i < imgsLength; i++){
        if(uploadedImage[i] !== ""){
        var imageFormat = "data:image/jpg;base64," + uploadedImage[i];        
        var str = "<div class='col-md-3'> <div class='service-item'> <div class='service-description img_div_wdt' align='left'> " +    	         	
				  "<p id='gallery'> <a href=" + imageFormat + "> <img src=" + imageFormat + " class='uploadImgs'></a></p> <img class='delete' title='Delete' src='resources/images/red_close_button.png' onclick=deleteImage('" + clientUpImgId[i] + "');></div></div></div>";
        tab1.append(str);       
        }
        }        
            
        for (var i = 4; i < imgsLength; i++){
        if(uploadedImage[i] !== ""){
        var imageFormat = "data:image/jpg;base64," + uploadedImage[i];        
        var str = "<div class='col-md-3'> <div class='service-item'> <div class='service-description img_div_wdt img_div2_top_adj' align='left'> " +    	         	
				  "<p id='gallery'> <a href=" + imageFormat + "> <img src=" + imageFormat + " class='uploadImgs'></a></p> <img class='delete' title='Delete' src='resources/images/red_close_button.png' onclick=deleteImage('" + clientUpImgId[i] + "');></div></div></div>";
        tab2.append(str);       
        }
        }       
        
    });
    
 // function for deleting image
    function deleteImage(clImgUploadId){	 
       newAjaxCall(clImgUploadId);
    };
    
    var clUploadedImgsCount = '<c:out value="${clUploadedImgsCount}"/>';
    function newAjaxCall(deletedImage){    	
    	$.ajax({
			type : 'POST',
			url : "deleteImageFromDBJSON?deleteImage="+deletedImage,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data = JSON.parse(return_result);
				
				for(var i=0;i<data.length;i++){
					var value1 = data[i].JSonSpObj1;
					var value2 = data[i].JSonSpObj2;
					
					var uploadedImage = value1.split("_,_");
					var clientUpImgId = value2.split("_,_");
										
					var imgsLength = clientUpImgId.length;
					clUploadedImgsCount = imgsLength;
					
					$("#spaceImg1List div").remove();
					$("#spaceImg2List div").remove();
			        var tab1 = $("#spaceImg1List");			        
			        var tab2 = $("#spaceImg2List");
			        
			        for (var i = 0; i < 4 && i < imgsLength; i++){			        	
			        if(uploadedImage[i] !== ""){
			        var imageFormat = "data:image/jpg;base64," + uploadedImage[i];        
			        var str = "<div class='col-md-3'> <div class='service-item'> <div class='service-description img_div_wdt' align='left'> " +    	         	
							  "<p id='gallery'> <a href=" + imageFormat + "> <img src=" + imageFormat + " class='uploadImgs'></a></p> <img class='delete' title='Delete' src='resources/images/red_close_button.png' onclick=deleteImage('" + clientUpImgId[i] + "');></div></div></div>";
			        tab1.append(str);			       
			        }
			        }        
			            
			        for (var i = 4; i < imgsLength; i++){
			        if(uploadedImage[i] !== ""){			        	
			        var imageFormat = "data:image/jpg;base64," + uploadedImage[i];        
			        var str = "<div class='col-md-3'> <div class='service-item'> <div class='service-description img_div_wdt img_div2_top_adj' align='left'> " +    	         	
							  "<p id='gallery'> <a href=" + imageFormat + "> <img id='gallery' src=" + imageFormat + " class='uploadImgs'></a></p> <img class='delete' title='Delete' src='resources/images/red_close_button.png' onclick=deleteImage('" + clientUpImgId[i] + "');></div></div></div>";
			        tab2.append(str);			       
			        }
			        }			       		       				
				} 
			} 
    	}); 
    }
     
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container"> 
                
        <div class="about_space_title-section text-center">
        <h4>TELL US MORE ABOUT YOUR SPACE!</h4>                
        </div> <!-- /.title-section -->
           
        <div class="row top_adjustment_40">
        <div class="col-md-3">
        </div> <!-- /.col-md-3-->
        	
        	
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			
        			<form action="uploadImagesInDB" name="fileUpload" method="post" enctype="multipart/form-data">                
				   
				   	<div class="sp_uploa_img_dis"><h3>Upload photos of your space for your designer </h3></div>
					
					<div class="row top_adjustment_50">
					<div class="col-md-8" style="padding-bottom: 20px;">
					<div align="left"><input type="file" class="file_upload_dis" name="fileUpload" id="fileUpload" title="Click here to browse your photo."></div>
					</div>
					
					<div class="col-md-4">
					<div align="right"><button class="continue_submit_Btn" id="uploadBut">UPLOAD</button></div>
					</div>
					</div>

					<div class="upload_file_type"><p>You can upload a JPG, GIF, or PNG file.</p></div>
					</form>

                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        <div class="col-md-3">        
        </div> <!-- /.col-md-3-->
        </div> <!-- /.row -->
                
                       
        <div class="row">
        <div class="col-md-4">
        </div> <!-- /.col-md-4-->        	
        
        <div align="center" class="col-md-4">       	
        	<table id="spaceImg1List"></table>
        </div> <!-- /.col-md-4-->
                
        <div class="col-md-4">        
        </div> <!-- /.col-md-4-->
        </div> <!-- /.row -->
        
                        
        <div class="row">
        <div class="col-md-4">
        </div> <!-- /.col-md-4-->        	
        
        <div align="center" class="col-md-4">       	
        	<table id="spaceImg2List"></table>
        </div> <!-- /.col-md-4-->        
        
        <div class="col-md-4">        
        </div> <!-- /.col-md-4-->
        </div> <!-- /.row --> 
        
        
		<div class="row top_adjustment_40">
       
        <div class="col-md-3 col-sm-3">        	              
        </div> <!-- /.col-md-3 -->	
        
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div align="center" class="service-description more_abt_text">
            		<p>ANYTHING ELSE YOU WOULD LIKE TO SHARE:</p>
         	   </div> <!-- /.service-description -->
         	   
         	   <div align="center" class="service-description">
            		<textarea name="moreAboutSpace" id="moreAboutSpaceId" placeholder="I NEED MY SPACE TO BE PET FRIENDLY ..." class="item-text_area_box-disp"></textarea>
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        <div class="col-md-3 col-sm-3"> 
        </div> <!-- /.col-md-3 -->
        </div> <!-- /.row --> 
		
        
        <div class="form-nav">
            <form action="aboutSpaceImgBackMove" method="get">
                <h4><input class="back_submit_Btn" type="image" title="BACK"
                           src="resources/images/backButton.png"></h4>
            </form>
            <form action="aboutSpaceDataSaving" name="myDesign" method="get">
                <h4>
                    <button class="continue_submit_Btn" id="abtSpaceButtonId">CONTINUE</button>
                </h4>
                <input type="hidden" id="moreAboutSpaceId" name="moreAboutSpace">
            </form>
        </div>
         		   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
    	    
    	<script type="text/javascript" src="resources/js/jquery.lightbox-0.5.js"></script>
	    
		<script type="text/javascript">
		    $(function() { $('#gallery a').lightBox(); });
		</script>	
		</body>
</html>