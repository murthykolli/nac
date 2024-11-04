<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	
	<!-- CSS files -->
	<link type="text/css" rel="stylesheet" href="resources/css/0_concepts_rendering_frame_resolution.css" /> 
			
    <style type="text/css">
    .buttonstyleClass { background-color: #ff3b3b; color: white; font: bold 0.9em/1.25em sans-serif; cursor:pointer; outline: none; border: none; white-space: nowrap; padding: 10px; outline-style: none; }
    .buttonstyleClass:hover { background-color: #4c4c4c; color: white; outline: none; }
    #mask { position:absolute; left:0; top:0; background-color:#000; display:none;}  
    #profileBox .profileWindow { position:absolute; z-index:9999;}
    #profileBox #profileDialog { height:auto; padding:10px; background-color:#ffffff;}
    
    .fieldBoxClass {border: 1px solid black; width: 200px; height: 20px; padding: 2px; }	
    </style>
        
    <script type="text/javascript">
    $(document).ready(function() {
    var uploadedImages = '<c:out value="${uploadedDesImg}"/>';
    
    if(uploadedImages !== ""){
    $("#photoText").hide();    
    $("#uploadImage").show();    
    }
        
    var phoneNoExp = /^\(?(\d{3})\)?[-]?(\d{3})[-]?(\d{4})$/;
    var messRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 -#/_().&amp;]*$/;
    
    
    var factsAboutDes = '<c:out value="${factsAboutDesn}"/>';    
	$("[name=factsaboutdesigner]").val(factsAboutDes);
	
	var desPhoneNumber = '<c:out value="${desnPhoneNumber}"/>';	
	$("[name=phoneNumber]").val(desPhoneNumber);
	
	   
	$("#uploadButtId").click(function (){    
    var fileName = $("#fileUpload").val();
    
    
	var fileExtension = fileName.replace(/^.*\./, '').toLowerCase();
	if(fileName === ""){
	alert("Please upload designer profile photo");
	return false;
	} else if(!(fileExtension === "png" || fileExtension === "jpg" || fileExtension === "gif" || fileExtension === "jpeg" || fileExtension === "bmp" || fileExtension === "heic" || fileExtension === "heif")){
	alert("Please upload a JPG, JPEG, BMP, HEIC, HEIF, GIF, or PNG file.");
	return false;
	} else {
    return true;
    }
       
	});
		
    });
    
    </script>
    
    <c:if test="${not empty passMessage}">    
    <script type="text/javascript">
    window.alert("Your new Password has been saved"); 
    </script>    
    </c:if>
    
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        
        <div class="col-md-5 col-sm-5">
        	<div class="service-item">                        
            	<div class="service-description">                	
                    <div align="left">   
	                	<h2 class="des_acc_head_txt_ds">MY PROFILE</h2>                             
                    </div>
                    
                    <div align="left">   
	                	<table>
	                		<tr><td class="des_acc_info_txt_ds">NAME:&nbsp;</td> <td class="des_acc_info_value_txt_ds"><c:out value='${desnFullName}'/></td></tr>
	                		<tr><td class="des_acc_info_txt_ds">EMAIL:&nbsp;</td> <td class="des_acc_info_value_txt_ds"><c:out value='${desnerUserName}'/></td></tr>
	                		<tr><td class="des_acc_info_txt_ds">PHONE:&nbsp;</td> <td class="des_acc_info_value_txt_ds"><c:out value='${desnPhoneNumber}'/></td></tr>
	                	</table>
	                	
	                	<table class="top_adjustment_25">
	                		<tr><td class="des_acc_info_txt_ds">DESIGN PHILOSOPHY:</td> <td class="des_acc_info_value_txt_ds"><c:out value='${desnPersonalBio}'/></td></tr>
	                		<%-- <tr><td class="des_acc_info_txt_ds">CREDENTIALS:</td> <td class="des_acc_info_value_txt_ds"><c:out value='${desnCredentials}'/></td></tr> --%>
	                		<tr><td class="des_acc_info_txt_ds">LOCATION:</td> <td class="des_acc_info_value_txt_ds"><c:out value='${desnLocation}'/></td></tr>	                		
	                	</table>
	                	<table>
	                		<tr><td class="des_acc_info_txt_ds"><textarea disabled id="designerFactsId" name="factsaboutdesigner" class="text_area_frame_for_desn_bio"></textarea></td></tr>	                		
	                	</table>
                    </div>
			
					<form action="messageAdmin" name="messageSending" method="get">
					<h4 class="top_adjustment_10"><button class="desn_con_submit_Btn" id="clientMesButtonId">MESSAGE ADMIN ANY CHANGES</button></h4>		
					</form>
					
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-5 -->
        
        <div class="col-md-1 col-sm-1">
        	<div class="service-item">                        
            	<div class="service-description">                	
                    <div align="center" style="background: red; height: 320px; width: 1px; margin-left: 30px;" >   
	                	                          
                    </div>
	
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-1 -->
        
        <div class="col-md-5 col-sm-5">
        	<div class="service-item">                        
            	<div class="service-description">                	
                    <div align="center">   
	                	
	                	
	               	
	       
            <div id="photoText" style="border: 2px dashed gray; width: 130px; height: 130px; text-align: center;"><span style="color: #FF6600; font: 1.2em/1.5em Georgia; letter-spacing: 2px; top: 40px; position: relative;">Upload<br> Image</span></div>
            <div id="uploadImage" style="display:none;"><img class="desn_pro_img_reso_dsp_class" src="data:image/jpg;base64,<c:out value='${uploadedDesImg}'/>"></div>
            
        
        <form action="uploadDesignerProfile" name="fileUpload" method="post" enctype="multipart/form-data">                
			<div class="sp_uploa_img_dis"><h3>UPLOAD YOUR PROFESSIONAL PROFILE PICTURE!</h3></div>
			<div align="center"><input type="file" class="file_upload_dis" name="fileDesnUpload" id="fileUpload" title="Click here to browse your photo."></div>
			<div align="center" class="upload_file_type"><p>You can upload a JPG, GIF, or PNG file.</p></div>
			<div align="center" class="top_adjustment_25"><button class="desn_con_submit_Btn" id="uploadButtId">UPLOAD</button></div>
		</form>
        
        
        
        
                 	
	                	
	                	                             
                    </div>
	
					
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-5 -->
		
		<div class="col-md-1 col-sm-1">
        </div>
                		
		</div> <!-- /.row -->
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        <div id="profileBox">
        <div style="top: 190px; left: 535px; display: none;" id="profileDialog" class="profileWindow">
        <div style="text-align: right;"> <img class="close" src="resources/images/close.png" style="cursor: pointer;"></div><br>
        <form action="uploadDesignerProfile" method="POST" enctype="multipart/form-data">
        <table>
        <tr><td style="font:0.9em/1.5em Arial;">Select a image to upload</td></tr>
        <tr><td><input type="file" title="Click here to browse your image." id="fileUpload" name="fileDesnUpload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td align="center"><input class="buttonstyleClass" type="submit" id="uploadBut" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
  		</div>
  		<div style="width: 1478px; font-size: 32pt; color:white; height: 602px; display: none; opacity: 0.8;" id="mask"></div>
		</div>	
		</body>
</html>