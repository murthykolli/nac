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
    
	<!-- CSS files -->
	<link type="text/css" rel="stylesheet" href="resources/css/0_concepts_rendering_frame_resolution.css" />
	<link type="text/css" rel="stylesheet" href="resources/css/popup/lightbox.css" />
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>  
	
		
	<script type="text/javascript">
	function newAjaxCon3RendCall(likeValue){
		
    	$.ajax({    		
			type : 'POST',
			url : "finalConceptLikeUpdate?status="+likeValue,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {												
			} });	    
    }
    </script>
    
	<script type="text/javascript">
	var likeImagesValue;
 	$(document).ready(function(){
 		likeImagesValue = "<c:out value="${likeImagesValues}"/>"; 		
		var likeImagesValues = likeImagesValue.split(" ");
 		
 		if(likeImagesValues[0] === "1"){ $("#removeFinalFavConept3").hide(); $("#addFinalFavConept3").show(); } 
        else if(likeImagesValues[0] === "2"){ $("#removeFinalFavConept2").hide(); $("#addFinalFavConept2").show(); $("#removeFinalFavConept3").hide(); $("#addFinalFavConept3").show(); } 
        else if(likeImagesValues[0] === "3"){ $("#removeFinalFavConept1").hide(); $("#addFinalFavConept1").show(); $("#removeFinalFavConept2").hide(); $("#addFinalFavConept2").show(); $("#removeFinalFavConept3").hide(); $("#addFinalFavConept3").show(); } 
        else{ }
 		
 		var con3LikeVal;		
 	    $("#removeFinalFavConept1").click(function(){ con3LikeVal = "3 Likes"; $("#removeFinalFavConept1").hide(); $("#addFinalFavConept1").show(); $("#removeFinalFavConept2").hide(); $("#addFinalFavConept2").show(); $("#removeFinalFavConept3").hide(); $("#addFinalFavConept3").show(); newAjaxCon3RendCall(con3LikeVal); });
 	    $("#addFinalFavConept1").click(function(){	con3LikeVal = "2 Likes"; $("#removeFinalFavConept1").show(); $("#addFinalFavConept1").hide(); newAjaxCon3RendCall(con3LikeVal); });

 	    $("#removeFinalFavConept2").click(function(){ con3LikeVal = "2 Likes"; $("#removeFinalFavConept2").hide(); $("#addFinalFavConept2").show(); $("#removeFinalFavConept3").hide(); $("#addFinalFavConept3").show(); newAjaxCon3RendCall(con3LikeVal); });
 	    $("#addFinalFavConept2").click(function(){	con3LikeVal = "1 Like"; $("#removeFinalFavConept2").show(); $("#addFinalFavConept2").hide(); $("#removeFinalFavConept1").show(); $("#addFinalFavConept1").hide(); newAjaxCon3RendCall(con3LikeVal); });

 	    $("#removeFinalFavConept3").click(function(){ con3LikeVal = "1 Like";	$("#removeFinalFavConept3").hide(); $("#addFinalFavConept3").show(); newAjaxCon3RendCall(con3LikeVal); });
 	    $("#addFinalFavConept3").click(function(){	con3LikeVal = "No Likes"; $("#removeFinalFavConept1").show(); $("#addFinalFavConept1").hide(); $("#removeFinalFavConept2").show(); $("#addFinalFavConept2").hide(); $("#removeFinalFavConept3").show(); $("#addFinalFavConept3").hide(); newAjaxCon3RendCall(con3LikeVal); });
    });
	</script>
	
    <script type="text/javascript">	
 	$(document).ready(function(){
 		var desnMessageSt = "<c:out value="${desnMessageCount}"/>";
 		var conceptStatus1 = "<c:out value="${conceptStatus}"/>";
 		var renderingStatus1 = "<c:out value="${renderingStatus}"/>";
 		
 		if(desnMessageSt > 0) {
        	$("#desnMessgeId").show();        	
        } else {
        	$("#desnMessgeId").hide();
        }

 		if(conceptStatus1 === "Approved for Concepts") {
        	$("#conceptStatusId").show();        	
        } else {
        	$("#conceptStatusId").hide();
        }  

 		if(renderingStatus1 === "Approved for Renderings") {
        	$("#renderingStatusId").show();        	
        } else {
        	$("#renderingStatusId").hide();
        }  
 
    });
	</script>
	 
	<script type="text/javascript">
 	$(document).ready(function(){
 		
        	$(".conceptsRenderingPopupDspCl").click(function(){
            
            var idOfHiddenInput = $(this).parent().find('input:hidden:first').attr('id');
            
            var imgRedValue;
            if(idOfHiddenInput === "image1Id") {
            	var image1Path = "<c:out value='${concept3UploadedImage}'/>";            
                imgRedValue = "data:image/jpg;base64," + image1Path;
            }
            
            $.conceptsRenderingPopup(imgRedValue);
        	});
        	
    });
    </script>
	  
	</head>
    	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        <div class="col-md-9 col-sm-9">
        </div> <!-- /.col-md-9 -->
        <div class="col-md-3 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description  start_new_project_but_adj">
            		<form action="getStartedBuss">
						<h4><button class="start_new_project">START A NEW ROOM</button></h4>
					</form>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
        </div> <!-- /.row --> 
                
        
        <div class="row">
        <div class="col-md-7 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description cl-main-header">
        			<div class="menu0 text-left">
                    	<ul>
                    		<li><a href="myRoomInformationRed"><c:out value="${typeOfSpaceVal}"/></a></li>
		        			<li><a href="accConcepts">CONCEPTS</a><div class="mess_desn_new_img_ds" id="conceptStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li class="current"><a href="accFinalConcepts">FINAL CONCEPT</a><div class="fin_conc_desn_new_img_ds" id="renderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="accShopRedir">SHOP</a></li>
		        			<li><a href="messageRed">MESSAGES</a><div class="mess_desn_new_img_ds" id="desnMessgeId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>		        			
        				</ul>
        				
                    </div> <!-- /.menu -->   
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-5 col-sm-6">
        </div> <!-- /.col-md-5 -->
        </div> <!-- /.row -->
                   
        
        
        <div class="row top_adjustment_50">        	
         
  <!-- Concept 1 Coding -->              	
        <div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			
        			<div class="row">
        			<div class="col-md-4 col-sm-4">
        			<div align="left"><p class="concepts_dssl_text">REVISED CONCEPT</p></div>
        			</div> <!-- /.col-md-4 -->
        			
        			<div class="col-md-8 col-sm-8">
        			<div align="right"><p class="concepts_dssl_text">RATE THIS CONCEPT <img class="con_like_img_mou" id="addFinalFavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="removeFinalFavConept3" src="resources/images/concepts/like_img.png">   <img class="con_like_img_mou" id="addFinalFavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="removeFinalFavConept2" src="resources/images/concepts/like_img.png">   <img class="con_like_img_mou" id="addFinalFavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="removeFinalFavConept1" src="resources/images/concepts/like_img.png"> </p></div>
        			</div> <!-- /.col-md-8 -->        			        			
        			</div> <!-- /.row -->
        			
        			
        			<div class="row top_adjustment_10">
        			<div class="col-md-12 col-sm-12">
        			<div align="left"><img class="con_img_mou concept_rend_sng_img_reso_class" src="data:image/jpg;base64,<c:out value='${concept3UploadedImage}'/>"></div>
        			</div> <!-- /.col-md-12 -->
        			</div> <!-- /.row -->
        			
        			
        			<div class="row top_adjustment_20">
        			<div class="col-md-4 col-sm-4">
        			<div align="left"><a href="finalConceptViewShopProducts" class="concepts_links_ds">VIEW PRODUCTS</a></div>
        			</div> <!-- /.col-md-6 -->
        			
        			<div class="col-md-8 col-sm-8">
        			<div align="right">
        			<a class="example-image-link" href="data:image/jpg;base64,<c:out value='${concept3UploadedImage}'/>" data-lightbox="example-1">
        			<img class="con_max_pos_ms conceptsRenderingPopupDspCl" src="resources/images/concepts/maxmise_img.png"> <input id="image1Id" type='hidden'/>
        			</a>
        			</div>
        			</div> <!-- /.col-md-7 -->
        			</div> <!-- /.row -->
        			
        			</div>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-8 -->
        
                       	
        <div class="col-md-5 col-sm-5">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="right" class="final_cont_side_box_dspy top_adjustment_150">
        			<p class="concpts_bottom_txt_dsp">DO YOU LOVE WHAT YOU SEE AND CAN'T</p>
        			<p class="concpts_bottom_txt_dsp">WAIT TO BRING YOUR SPACE TOGETHER?</p>
        			<p class="concpts_bottom_txt_dsp">SHOP YOUR ROOM TODAY!</p>        			
        			</div>
        			<form action="finalConceptViewShopProducts">
        			<div class="text-center final_con_sub_butt_adjmnt" > <h4><button class="continue_submit_Btn" id="spaceButtonId">SHOP MY ROOM</button></h4> </div>
        			</form>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-5 -->    
        	
        </div> <!-- /.row -->
        
              
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        
        
		<script type="text/javascript" src="resources/js/json-minified.js" ></script>
    	
		</body>
</html>