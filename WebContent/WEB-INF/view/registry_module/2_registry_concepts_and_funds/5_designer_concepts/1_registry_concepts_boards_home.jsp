<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="resources/css/registry_css/registry_landing.css" type="text/css">
	<link rel="stylesheet" href="resources/css/file_upload.css" type="text/css">
	<link type="text/css" rel="stylesheet" href="resources/css/0_concepts_rendering_frame_resolution.css" />
	<style type="text/css">
	@font-face { font-family: 'Handycheera'; src: url('resources/sitefonts/Handycheera Regular.otf') format('truetype'); }
	.tick_mark_dsp { font: 1.1em/1.4em Georgia; }
	.ft_img_text_dsp { font: 1.12em/1.4em Georgia; margin-left: 5px; }
	
	</style>
	<script type="text/javascript">
 	$(document).ready(function(){
 		$('html, body').animate({scrollTop: $('#concept_boards_adj_id').offset().top}, 0); 		
        var desnCurConBoards1 = "<c:out value="${desnCurConBoards}"/>"; if(desnCurConBoards1 == "Design Curated Con Boards"){ $("#minus_img_info_display_id").show(); $("#plus_img_info_display_id").hide(); }    	
    	$("#registryCuratedConButtonId").click(function (){ $('html, body').animate({scrollTop: $('#concept_boards_adj_id').offset().top}, 0); });
    	var regiStatus = "<c:out value="${regStatus}"/>"; if(regiStatus === "Done") { $("#makeRegistryVisibleId").hide(); $("#registryIsLiveId").show(); } else { $("#makeRegistryVisibleId").show(); $("#registryIsLiveId").hide(); }    	
     	});	
    </script>
    
	</head>	
		<body>		
		<div class="container-fluid top_adjustment_75"> <img src="<c:out value='${guestBackgroungImage}'/>" class="rln_top_img_dsp">                 
        <div class="rln_top_frame_adj_cl"> <div id="redUploadImage"> <div class="regi_circle_uploaded_image"><div class="rln_top_photo_text_cl">${regUploadedPhoto}</div></div> </div> <div class="rln_top_three_frames_div_cl">
	    <table id="visibleStatusRefTableId"> <tbody> <tr> <td style="width: 170px; border-right: 1px solid black; padding: 2px 20px; text-align: left;"> <a href="regEditBackgroundForGuest?regReferance=landingEditBackground" class="reg_access_frame_text_dsp">Edit Background</a> </td> <td style="width: 170px; border-right: 1px solid black; padding: 2px 20px; text-align: left;"> <a href="previewGuestRegistry" class="reg_ln_access_frame_text_dsp" target="_blank">Preview Registry</a> </td> <td style="width: 260px; padding: 2px 20px; text-align: left; display: none;" id="makeRegistryVisibleId"> <a href="#" onclick="return registryMakeVisibleAccess('Live Status On');" class="reg_access_frame_text_dsp">Registry Is Hidden </a> </td> <td style="width: 260px; padding: 2px 20px; text-align: left; display: none;" id="registryIsLiveId"> <a href="#" onclick="return registryMakeVisibleAccess('Live Status Off');" class="reg_access_frame_text_dsp">Registry is Live </a> </td> </tr> </tbody></table> </div>
	     	<div class="rln_top_name_dsp_top_div"> <div class="reg_first_and_sec_name_dsp_cl"><c:out value='${regFirstName}'/></div> <div class="reg_event_date_dsp_cl"><c:out value='${eventDate}'/></div>		         
		        <div class="rln_top_msg_dsp_top_div"> <table id="messageEditDisplayId"> <tbody> <tr><td align="left"><div class="reg_message_edit_text_dsp">${registrantMessage}</div></td> <td><button class="reg_message_small_edit_butt rln_top_edit_butt_div" id="editedDataRefId">EDIT</button></td></tr> </tbody></table>
			    <form action="saveRegiMessageData?regMesReferance=messageLanding" method="POST">
			    <table id="messageSaveDisplayId" style="display: none;"> <tbody> <tr><td align="left"><input type="text" id="messageTextInputId" name="messageToGuests" maxlength="100" value="${registrantMessage}" class="reg_message_saveinput_tag_dsp"></td> <td align="left"><button class="reg_message_small_sub_butt rln_top_save_butt_div" id="saveDataRefId">SAVE</button></td> </tr> </tbody></table> </form> </div> </div> </div> </div>							
		<div id="mainframe" class="section-content" style="margin-top: -20px;"> <div class="container">
    
<!-- ADD GIFT CARD COADING START -->    
        <div class="row top_adjustment_80" id="plus_img_info_display_id"> <div class="col-md-12 col-sm-12 reg_sub_fram_box_dsp_cl all_funds_padddsp_cl"> <div align="center">
			<table class="rln_add_gifts_top_adj" id="reg_plus_butt_click_id"><tr> <td><img src="resources/images/registry/preview_reg_imgs/reg_plus_img.png" width="36" height="34"></td> <td><div class="reg_add_gift_text_dly">&nbsp;&nbsp;ADD GIFTS</div></td> </tr></table> </div> </div> </div>        
        
 <!-- ADD GIFT CARD CONTENT DISPLAY COADING START -->
        <div class="row top_adjustment_80" style="display: none;" id="minus_img_info_display_id"> <div class="col-md-12 col-sm-12 reg_sub_fram_box_dsp_cl all_funds_padbt_cl"> <div align="right"><img src="resources/images/registry/close_img.png" class="rln_add_gifts_imgds_cl" id="minus_img_click_id" onmouseover="this.src='resources/images/registry/close_mo_img.png';" onmouseout="this.src='resources/images/registry/close_img.png';"></div> <div class="row rln_add_gifts_pdlr_cl">	        
	        <div class="regoverview_title_sel text-center rln_add_gifts_titmbt_cl"> <h4><font class="reg_con_cur_brd_fl_dsp">B</font>UILD <font class="reg_con_cur_brd_fl_dsp">Y</font>OUR <font class="reg_con_cur_brd_fl_dsp">R</font>EGISTRY</h4> </div>	              
	        <div class="col-md-12 col-sm-12 reg_butt_frame_box_dsp_cl"> <div class="row top_adjustment_45 rln_add_gifts_pdiadj_cl"> <div class="col-md-4 col-sm-4">
	        	<div align="center"> <button class="sel_build_registry_mo_sbut_butt" id="registryCuratedConButtonId"> <font class="build_reg_but_text_fl_dsp">A</font>DD <br><font class="build_reg_but_text_fl_dsp">F</font>urniture <font class="build_reg_but_text_fl_dsp">&amp; D</font>ecor </button> </div> </div>	        	
	        	<div class="col-md-4 col-sm-4"> <div align="center"> <form action="createRoomFunds"> <button class="sel_build_registry_sbut_butt" id="registryRoomFundButtonId"> <font class="build_reg_but_text_fl_dsp">C</font>REATE <br><font class="build_reg_but_text_fl_dsp">R</font>OOM <font class="build_reg_but_text_fl_dsp">F</font>UNDS </button> </form> </div> </div>
	        	<div class="col-md-4 col-sm-4"> <div align="center"> <form action="createCashFunds"> <button class="sel_build_registry_sbut_butt" id="registryCashFundButtonId"> <font class="build_reg_but_text_fl_dsp">C</font>REATE <br><font class="build_reg_but_text_fl_dsp">C</font>ASH <font class="build_reg_but_text_fl_dsp">F</font>UNDS </button> </form> </div> </div> </div> </div>
	        	<div align="center"> <img class="rln_add_gifts_botimg_dsp" src="resources/images/registry/reg_overview/reg_overview_mid_img.png"> </div> </div> </div> </div>

<!-- Code End --> <!-- DESIGNER CURATED CONCEPT BOARDS COADING START -->       
        <div id="concept_boards_adj_id" class="rfuns_frame_tp_adj"> <div class="rfuns_frame_pdntp_adj"> <div class="row">        
			<div class="reg_con_cur_brd_heading_dsp text-left rfuns_frame_mbtm_adj"> <h4><font class="reg_con_cur_brd_fl_dsp">C</font>URATED <font class="reg_con_cur_brd_fl_dsp">D</font>ESIGN <font class="reg_con_cur_brd_fl_dsp">B</font>OARDS</h4> </div>		        
		    <div class="regi_dsn_con_cur_sub_txt_dsp text-left"> Browse by rooms and add furniture and decor pieces from professionally curated design boards. </div>
		    <div class="regi_dsn_con_cur_sub_txt_dsp text-left"> You decide when gifts ships! </div>
		        
		<!-- DESIGNER CURATED CONCEPT BOARDS COADING Bottom Images --> 		       
		       	<div class="row"> <div class="col-md-12 col-sm-12 top_adjustment_35"> <table> <tbody> <tr> <td> <div class="reg_image_and_text_frame_dsp_cl right_adjustment_0" onclick="typeOfRoomFund('Living Room');">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/living_room_cdb.png" width="210" height="210" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">L</font>IVING <font class="regi_cb_bott_name_text_fl_dspl">R</font>OOM</div> </div> </div> </div> </div> </td>			   		
			    <td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('Dining Room');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/dining_room_cdb.png" width="210" height="210" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">D</font>INING <font class="regi_cb_bott_name_text_fl_dspl">R</font>OOM</div> </div> </div> </div> </div> </td>			   		
			    <td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('Bedroom');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/bedroom_cdb.png" width="210" height="210" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">B</font>EDROOM</div> </div> </div> </div> </div> </td>			   		
			    <td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('Home Office');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/home_office_cdb.png" width="210" height="210" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">H</font>OME <font class="regi_cb_bott_name_text_fl_dspl">O</font>FFICE</div> </div> </div> </div> </div> </td> 
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('Entryway');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/entryway_cdb.png" width="210" height="210" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">E</font>NTRYWAY</div> </div> </div> </div> </div> </td>
				</tr>				
				<tr class="rfuns_frame_htd_cls"></tr>				
				<tr> 			   		
			    <td> <div class="reg_image_and_text_frame_dsp_cl right_adjustment_0" onclick="typeOfRoomFund('Nursery');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/nursery_cdb.png" width="210" height="210" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">N</font>URSERY</div> </div> </div> </div> </div> </td>			   		
			    <td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('Kids Bedroom');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/kids_bedroom_cdb.png" width="210" height="210" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">K</font>IDS <font class="regi_cb_bott_name_text_fl_dspl">B</font>EDROOM</div> </div> </div> </div> </div> </td>			   		
			    <td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('Outdoor Space');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/outdoor_space_cdb.png" width="210" height="210" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">O</font>UTDOOR <font class="regi_cb_bott_name_text_fl_dspl">S</font>PACE</div> </div> </div> </div> </div> </td>
				
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfFinishingTouches('Finishing Touches');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> 
					<table style="position: relative; top: 10px; left: 12px;">
					<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Curtains</font></td></tr>
					<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Bedding</font></td></tr>
					<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Pillows</font></td></tr>
					<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Throws</font></td></tr>				
					<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Kitchen &amp; Dining</font></td></tr>
					<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Home Accessories</font></td></tr>
					<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Mattresses</font></td></tr>
					<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;&amp; More</font></td></tr>
					</table>
				</div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">F</font>INISHING <font class="regi_cb_bott_name_text_fl_dspl">T</font>OUCHES</div> </div> </div> </div> </div> 
				</td>
				
				</tr> </tbody> </table> </div>
		        </div> </div> </div> </div> </div></div>		
		  
        <div id="boxes"> <div class="rln_popup_frame_dsp" id="mask"></div> <div align="center" style="padding: 20px; display: none;  width: 760px; z-index: 10001; overflow-y: hidden; position:fixed; left: 50%; top: 50%; -ms-transform: translate(-50%,-50%); -moz-transform:translate(-50%,-50%); -webkit-transform: translate(-50%,-50%); transform: translate(-50%,-50%);" id="dialog" class="window"> <div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" class="rln_pop_cl_img_adj"></a></div> <div class="rln_pop_uplph_txt_cl">Upload Your Photo</div> <div id="lorem" class="rln_pop_pad_adj">		
		<form action="uploadRegistrantProfile?uploadImgReferance=conceptBoardsImageUpload" method="POST" enctype="multipart/form-data">
		<table class="rln_pop_table_frm_adj"> <tbody><tr><td><input type="file" onchange="readURL(event)" name="regPhotoUpload" id="fileUpload" title="Click here to browse your photo." class="rln_pop_table_bgc_cl"></td></tr> <tr class="rln_pop_tr_heights_cl"><td></td></tr> <tr><td><font>You can upload a JPG, JPEG, BMP, HEIC, HEIF, PDF, GIF, or PNG file.</font></td></tr> <tr class="rln_pop_tr_heights_cl"><td></td></tr>
		<tr><td>This image can be seen by any guest on our website viewing or searching for your registry.</td></tr> <tr class="rln_pop_tr_heightm_cl"><td></td></tr> <tr><td><input type="checkbox" name="accept" id="accept"> <div class="rln_pop_mlt_txt_cl">I own the image I am uploading and confirm that this image compiles with the <br>NOOK + COVE Upload Terms of Use.</div></td></tr> <tr class="rln_pop_tr_heighth_cl"><td></td></tr> <tr><td><button class="uploaded_submit_Btn_for_regi" id="photoUploadBut">UPLOAD</button></td></tr> <tr class="rln_pop_tr_heightvs_cl"><td></td></tr> </tbody></table>
		</form>
		</div> </div> </div>		
		
		<script type="text/javascript">		
			function typeOfRoomFund(roomFundName) { document.regRoomFundsSelect.registrySpaceRoom.value = roomFundName; $("#roomFundsFormId").submit(); }
			function typeOfFinishingTouches(finishingTouchesName) { document.finishingTouchesFormName.finishingTouchesName.value = finishingTouchesName; $("#finishingTouchesFormId").submit(); }
		</script>
		
		<form action="registryViewAllDesigns" id="roomFundsFormId" name="regRoomFundsSelect" method="POST"> <input type="hidden" id="registrySpaceRoomId" name="registrySpaceRoom"> <input type="hidden" id="registryCBRoomCountId" name="registryCBRoomCount" value="0"> </form>
		<form action="registrySelectedFinishingTouches" id="finishingTouchesFormId" name="finishingTouchesFormName" method="POST"> <input type="hidden" id="finishingTouchesNameId" name="finishingTouchesName"> <input type="hidden" id="registryCBRoomCountId" name="registryCBRoomCount" value="0"> </form>
		
		<script type="text/javascript" src="resources/js/registry/registry_landing.js"></script>
		<script type="text/javascript" src="resources/js/file_upload.js"></script>
		</body>
</html>
