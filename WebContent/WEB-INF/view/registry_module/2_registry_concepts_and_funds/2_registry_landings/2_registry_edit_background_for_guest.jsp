<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon"/>
	<link rel="stylesheet" href="resources/css/file_upload.css" type="text/css">
	<link rel="stylesheet" href="resources/css/registry_css/registry_landing.css" type="text/css">
	
	<script type="text/javascript">
 	$(document).ready(function(){
 		var regBackgroundUploadImage = '<c:out value="${regBackgroundUploadImageInSn}"/>';
 		if(regBackgroundUploadImage !== "") { $("#uploadBGImageDisplayId").css("opacity","0.2"); $("#uploadBGImageDisplayId").css('box-shadow', '0 5px 10px 0 rgba(0, 0, 0, 0.4), 0 6px 15px 0 rgba(0, 0, 0, 0.35)'); $("#uploadImageDisplayId").show(); $("#uploadTextDisplayId").hide(); } else { var guestBackgroungImage1 = '<c:out value="${guestBackgroungImage}"/>'; var guestBackgroungImage1Val = guestBackgroungImage1.split("/"); var guestBackgroungImageVal = guestBackgroungImage1Val[2].split("."); $("#"+guestBackgroungImageVal).css("opacity","0.2"); $("#"+guestBackgroungImageVal).css('box-shadow', '0 5px 10px 0 rgba(0, 0, 0, 0.4), 0 6px 15px 0 rgba(0, 0, 0, 0.35)'); $("#uploadTextDisplayId").show(); $("#uploadImageDisplayId").hide(); } 		 		 		
 	});
 	function ediBackgroundForGuest(bgImgName) { $(".reg_edit_background_frame").css("opacity","1"); $(".reg_edit_background_frame").css('box-shadow', '0 2px 2px 0 rgba(0, 0, 0, 0.3), 0 2px 5px 0 rgba(0, 0, 0, 0.25)'); document.myDesign.bgImageName.value = bgImgName; $("#bgImgFormId").submit(); }
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content room-styles"> <div class="container">
        <div class="reg_edit_backg_image_text2_cl text-center"> <h4><font class="reg_edit_backg_image_text1_cl">P</font>LEASE&nbsp; <font class="reg_edit_backg_image_text1_cl">S</font>ELECT&nbsp; A&nbsp; <font class="reg_edit_backg_image_text1_cl">B</font>ACKGROUND&nbsp; FOR&nbsp; <font class="reg_edit_backg_image_text1_cl">Y</font>OUR&nbsp; <font class="reg_edit_backg_image_text1_cl">R</font>EGISTRY</h4> </div>
        
<!-- 1st Row Images Display -->
        <div class="row top_adjustment_60"> <div class="col-md-4 col-sm-4">
			<div id="redBackGroundImageUpload"> <div class="reg_edit_background_frame" id="uploadBGImageDisplayId"> <div id="uploadImageDisplayId" class="rln_top_mesg_dspl_cl"> <img src="<c:out value='${regBackgroundUploadImageInSn}'/>" width="355" height="82"> </div>
			<div id="uploadTextDisplayId" class="reg_edit_backg_htbg_cl"> <div align="center"> <div class="reg_edit_backg_self_upph1_cl"> Upload Your Own Photo </div> <div class="reg_edit_backg_self_upph2_cl"> (Recommended: 1500 x 350 pixels) </div> </div> </div> </div> </div> </div>	        
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image2" onclick="ediBackgroundForGuest('reg_guest_show_image2');"> <img src="outsideImages/backgroundImages/reg_guest_show_image2.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image3" onclick="ediBackgroundForGuest('reg_guest_show_image3');"> <img src="outsideImages/backgroundImages/reg_guest_show_image3.png" width="355" height="82"></div> </div> </div> </div> </div>
        
<!-- 2nd Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image4" onclick="ediBackgroundForGuest('reg_guest_show_image4');"> <img src="outsideImages/backgroundImages/reg_guest_show_image4.png" width="355" height="82"></div> </div> </div> </div>	      	
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image5" onclick="ediBackgroundForGuest('reg_guest_show_image5');"> <img src="outsideImages/backgroundImages/reg_guest_show_image5.png" width="355" height="82"></div> </div> </div> </div>        
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image6" onclick="ediBackgroundForGuest('reg_guest_show_image6');"> <img src="outsideImages/backgroundImages/reg_guest_show_image6.png" width="355" height="82"></div> </div></div> </div> </div>
        
<!-- 3rd Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image7" onclick="ediBackgroundForGuest('reg_guest_show_image7');"> <img src="outsideImages/backgroundImages/reg_guest_show_image7.png" width="355" height="82"></div> </div> </div> </div>        
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image8" onclick="ediBackgroundForGuest('reg_guest_show_image8');"> <img src="outsideImages/backgroundImages/reg_guest_show_image8.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image9" onclick="ediBackgroundForGuest('reg_guest_show_image9');"> <img src="outsideImages/backgroundImages/reg_guest_show_image9.png" width="355" height="82"></div> </div></div> </div> </div>
             
<!-- 4th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image10" onclick="ediBackgroundForGuest('reg_guest_show_image10');"> <img src="outsideImages/backgroundImages/reg_guest_show_image10.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image11" onclick="ediBackgroundForGuest('reg_guest_show_image11');"> <img src="outsideImages/backgroundImages/reg_guest_show_image11.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image12" onclick="ediBackgroundForGuest('reg_guest_show_image12');"> <img src="outsideImages/backgroundImages/reg_guest_show_image12.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 5th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image13" onclick="ediBackgroundForGuest('reg_guest_show_image13');"> <img src="outsideImages/backgroundImages/reg_guest_show_image13.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image14" onclick="ediBackgroundForGuest('reg_guest_show_image14');"> <img src="outsideImages/backgroundImages/reg_guest_show_image14.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image15" onclick="ediBackgroundForGuest('reg_guest_show_image15');"> <img src="outsideImages/backgroundImages/reg_guest_show_image15.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 6th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image16" onclick="ediBackgroundForGuest('reg_guest_show_image16');"> <img src="outsideImages/backgroundImages/reg_guest_show_image16.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image17" onclick="ediBackgroundForGuest('reg_guest_show_image17');"> <img src="outsideImages/backgroundImages/reg_guest_show_image17.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image18" onclick="ediBackgroundForGuest('reg_guest_show_image18');"> <img src="outsideImages/backgroundImages/reg_guest_show_image18.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 7th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image19" onclick="ediBackgroundForGuest('reg_guest_show_image19');"> <img src="outsideImages/backgroundImages/reg_guest_show_image19.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image20" onclick="ediBackgroundForGuest('reg_guest_show_image20');"> <img src="outsideImages/backgroundImages/reg_guest_show_image20.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image21" onclick="ediBackgroundForGuest('reg_guest_show_image21');"> <img src="outsideImages/backgroundImages/reg_guest_show_image21.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 8th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image22" onclick="ediBackgroundForGuest('reg_guest_show_image22');"> <img src="outsideImages/backgroundImages/reg_guest_show_image22.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image23" onclick="ediBackgroundForGuest('reg_guest_show_image23');"> <img src="outsideImages/backgroundImages/reg_guest_show_image23.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image24" onclick="ediBackgroundForGuest('reg_guest_show_image24');"> <img src="outsideImages/backgroundImages/reg_guest_show_image24.png" width="355" height="82"></div> </div> </div> </div> </div>
                 
<!-- 9th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image25" onclick="ediBackgroundForGuest('reg_guest_show_image25');"> <img src="outsideImages/backgroundImages/reg_guest_show_image25.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image26" onclick="ediBackgroundForGuest('reg_guest_show_image26');"> <img src="outsideImages/backgroundImages/reg_guest_show_image26.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image27" onclick="ediBackgroundForGuest('reg_guest_show_image27');"> <img src="outsideImages/backgroundImages/reg_guest_show_image27.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 10th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image28" onclick="ediBackgroundForGuest('reg_guest_show_image28');"> <img src="outsideImages/backgroundImages/reg_guest_show_image28.png" width="355" height="82"></div> </div> </div> </div> 
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image29" onclick="ediBackgroundForGuest('reg_guest_show_image29');"> <img src="outsideImages/backgroundImages/reg_guest_show_image29.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image30" onclick="ediBackgroundForGuest('reg_guest_show_image30');"> <img src="outsideImages/backgroundImages/reg_guest_show_image30.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 11th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image31" onclick="ediBackgroundForGuest('reg_guest_show_image31');"> <img src="outsideImages/backgroundImages/reg_guest_show_image31.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image32" onclick="ediBackgroundForGuest('reg_guest_show_image32');"> <img src="outsideImages/backgroundImages/reg_guest_show_image32.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image33" onclick="ediBackgroundForGuest('reg_guest_show_image33');"> <img src="outsideImages/backgroundImages/reg_guest_show_image33.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 12th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image34" onclick="ediBackgroundForGuest('reg_guest_show_image34');"> <img src="outsideImages/backgroundImages/reg_guest_show_image34.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image35" onclick="ediBackgroundForGuest('reg_guest_show_image35');"> <img src="outsideImages/backgroundImages/reg_guest_show_image35.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image36" onclick="ediBackgroundForGuest('reg_guest_show_image36');"> <img src="outsideImages/backgroundImages/reg_guest_show_image36.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 13th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image37" onclick="ediBackgroundForGuest('reg_guest_show_image37');"> <img src="outsideImages/backgroundImages/reg_guest_show_image37.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image38" onclick="ediBackgroundForGuest('reg_guest_show_image38');"> <img src="outsideImages/backgroundImages/reg_guest_show_image38.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image39" onclick="ediBackgroundForGuest('reg_guest_show_image39');"> <img src="outsideImages/backgroundImages/reg_guest_show_image39.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 14th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image40" onclick="ediBackgroundForGuest('reg_guest_show_image40');"> <img src="outsideImages/backgroundImages/reg_guest_show_image40.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image41" onclick="ediBackgroundForGuest('reg_guest_show_image41');"> <img src="outsideImages/backgroundImages/reg_guest_show_image41.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image42" onclick="ediBackgroundForGuest('reg_guest_show_image42');"> <img src="outsideImages/backgroundImages/reg_guest_show_image42.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 15th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image43" onclick="ediBackgroundForGuest('reg_guest_show_image43');"> <img src="outsideImages/backgroundImages/reg_guest_show_image43.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image44" onclick="ediBackgroundForGuest('reg_guest_show_image44');"> <img src="outsideImages/backgroundImages/reg_guest_show_image44.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image45" onclick="ediBackgroundForGuest('reg_guest_show_image45');"> <img src="outsideImages/backgroundImages/reg_guest_show_image45.png" width="355" height="82"></div> </div></div> </div> </div>
                 
<!-- 16th Row Images Display -->
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image46" onclick="ediBackgroundForGuest('reg_guest_show_image46');"> <img src="outsideImages/backgroundImages/reg_guest_show_image46.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image47" onclick="ediBackgroundForGuest('reg_guest_show_image47');"> <img src="outsideImages/backgroundImages/reg_guest_show_image47.png" width="355" height="82"></div> </div> </div> </div>
	        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image48" onclick="ediBackgroundForGuest('reg_guest_show_image48');"> <img src="outsideImages/backgroundImages/reg_guest_show_image48.png" width="355" height="82"></div> </div></div> </div> </div>        
        <div class="row top_adjustment_35"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description"> <div class="reg_edit_background_frame" id="reg_guest_show_image1" onclick="ediBackgroundForGuest('reg_guest_show_image1');"> <img src="outsideImages/backgroundImages/reg_guest_show_image1.png" width="355" height="82"></div> </div> </div> </div>      	
		<div class="col-md-8 col-sm-8"></div> </div>
                
        <div class="form-nav reg_edit_backg_mrg_cl"> <form action="regEditBackgroundImageSave" id="bgImgFormId" name="myDesign" method="get"> <input type="hidden" id="bgImageNameId" name="bgImageName"> <input type="hidden" id="regiReferanceId" name="regiReferance" value="${regiReferance}"> </form> </div> </div> </div>
				  
        <div id="boxes"> <div class="rln_popup_frame_dsp" id="mask"></div> <div align="center" style="padding: 20px; display: none;  width: 760px; z-index: 10001; overflow-y: hidden; position:fixed; left: 50%; top: 50%; -ms-transform: translate(-50%,-50%); -moz-transform:translate(-50%,-50%); -webkit-transform: translate(-50%,-50%); transform: translate(-50%,-50%);" id="dialog" class="window">
        <div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" class="rln_pop_cl_img_adj"></a></div> <div class="rln_pop_uplph_txt_cl">Upload Your Photo</div><div id="lorem" class="rln_pop_pad_adj">		
		<form action="registrantBackgroundImageUpload" method="POST" enctype="multipart/form-data">
		<table class="rln_pop_table_frm_adj"> <tbody><tr><td><input type="file" onchange="readURL(event)" name="regBackgroundUploadImage" id="fileUpload" title="Click here to browse your photo." class="rln_pop_table_bgc_cl"></td></tr> <tr class="rln_pop_tr_heights_cl"><td></td></tr> <tr><td><font>You can upload a JPG, JPEG, BMP, HEIC, HEIF, PDF, GIF, or PNG file.</font></td></tr> <tr class="rln_pop_tr_heights_cl"><td></td></tr> <tr><td>This image can be seen by any guest on our website viewing or searching for your registry.</td></tr> <tr class="rln_pop_tr_heightm_cl"><td></td></tr>
		<tr><td><input type="checkbox" name="accept" id="accept"> <div class="rln_pop_mlt_txt_cl">I own the image I am uploading and confirm that this image compiles with the <br>NOOK + COVE Upload Terms of Use.</div></td></tr> <tr class="rln_pop_tr_heighth_cl"><td></td></tr> <tr><td><button class="uploaded_submit_Btn_for_regi" id="photoUploadBut">UPLOAD</button></td></tr> <tr class="rln_pop_tr_heightvs_cl"><td></td></tr> </tbody></table> </form> </div> </div> </div>		
		
		<script type="text/javascript" src="resources/js/file_upload.js"></script>
		</body>
</html>