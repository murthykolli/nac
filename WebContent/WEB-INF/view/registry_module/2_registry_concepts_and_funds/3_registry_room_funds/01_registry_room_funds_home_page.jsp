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
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="resources/css/registry_css/registry_landing.css" type="text/css">
	<link rel="stylesheet" href="resources/css/file_upload.css" type="text/css">
	<link type="text/css" rel="stylesheet" href="resources/css/0_concepts_rendering_frame_resolution.css" />
	
	<script type="text/javascript">
	$(document).ready(function(){
		$('html, body').animate({scrollTop: $('#room_funds_adj_id').offset().top}, 0);        
        var selRoomCashFund1 = "<c:out value="${selRoomCashFund}"/>";        
    	if(selRoomCashFund1 == "Selected Room Cash Fund"){ $("#minus_img_info_display_id").show(); $("#plus_img_info_display_id").hide(); }	
		$("#registryRoomFundButtonId").click(function (){ $('html, body').animate({scrollTop: $('#room_funds_adj_id').offset().top}, 0); });		
		var regBackReffVal1 = "<c:out value="${regBackReffVal}"/>"; if(regBackReffVal1 == "Reg Back Move"){ $("#minus_img_info_display_id").show(); $("#plus_img_info_display_id").hide(); $("#reg_giftcards_info_id").show(); }		
		var regiStatus = "<c:out value="${regStatus}"/>"; if(regiStatus === "Done") { $("#makeRegistryVisibleId").hide(); $("#registryIsLiveId").show(); } else { $("#makeRegistryVisibleId").show(); $("#registryIsLiveId").hide(); }			
	 	});	
    </script>
    
	</head>	
		<body>		
		<div class="container-fluid top_adjustment_75"> <img src="<c:out value='${guestBackgroungImage}'/>" class="rln_top_img_dsp"> <div class="rln_top_frame_adj_cl"> <div id="redUploadImage"> <div class="regi_circle_uploaded_image"><div class="rln_top_photo_text_cl">${regUploadedPhoto}</div></div> </div> <div class="rln_top_three_frames_div_cl">
	        <table id="visibleStatusRefTableId"> <tbody> <tr> <td style="width: 170px; border-right: 1px solid black; padding: 2px 20px; text-align: left;"> <a href="regEditBackgroundForGuest?regReferance=landingEditBackground" class="reg_access_frame_text_dsp">Edit Background</a> </td> <td style="width: 170px; border-right: 1px solid black; padding: 2px 20px; text-align: left;"> <a href="previewGuestRegistry" class="reg_ln_access_frame_text_dsp" target="_blank">Preview Registry</a> </td> <td style="width: 260px; padding: 2px 20px; text-align: left; display: none;" id="makeRegistryVisibleId"> <a href="#" onclick="return registryMakeVisibleAccess('Live Status On');" class="reg_access_frame_text_dsp">Registry Is Hidden </a> </td> <td style="width: 260px; padding: 2px 20px; text-align: left; display: none;" id="registryIsLiveId"> <a href="#" onclick="return registryMakeVisibleAccess('Live Status Off');" class="reg_access_frame_text_dsp">Registry is Live </a> </td> </tr> </tbody></table> </div>	        
	        <div class="rln_top_name_dsp_top_div"> <div class="reg_first_and_sec_name_dsp_cl"><c:out value='${regFirstName}'/></div> <div class="reg_event_date_dsp_cl"><c:out value='${eventDate}'/></div>
		        <div class="rln_top_msg_dsp_top_div"> <table id="messageEditDisplayId"> <tbody> <tr><td align="left"><div class="reg_message_edit_text_dsp">${registrantMessage}</div></td> <td><button class="reg_message_small_edit_butt rln_top_edit_butt_div" id="editedDataRefId">EDIT</button></td></tr> </tbody></table>			        
			        <form action="saveRegiMessageData?regMesReferance=messageRoomfund" method="POST">
			        <table id="messageSaveDisplayId" style="display: none;"> <tbody> <tr><td align="left"><input type="text" id="messageTextInputId" name="messageToGuests" maxlength="100" value="${registrantMessage}" class="reg_message_saveinput_tag_dsp"></td> <td align="left"><button class="reg_message_small_sub_butt rln_top_save_butt_div" id="saveDataRefId">SAVE</button></td> </tr> </tbody></table> </form> </div> </div> </div> </div>        				
					<div id="mainframe" class="section-content" style="margin-top: -20px;"> <div class="container">
            
<!-- ADD GIFT CARD COADING START -->    
        <div class="row top_adjustment_80" id="plus_img_info_display_id"> <div class="col-md-12 col-sm-12 reg_sub_fram_box_dsp_cl all_funds_padddsp_cl"> <div align="center">
			<table class="rln_add_gifts_top_adj" id="reg_plus_butt_click_id"><tr> <td><img src="resources/images/registry/preview_reg_imgs/reg_plus_img.png" width="36" height="34"></td> <td><div class="reg_add_gift_text_dly">&nbsp;&nbsp;ADD GIFTS</div></td> </tr></table> </div> </div> </div>        
        
 <!-- ADD GIFT CARD CONTENT DISPLAY COADING START -->
        <div class="row top_adjustment_80" style="display: none;" id="minus_img_info_display_id"> <div class="col-md-12 col-sm-12 reg_sub_fram_box_dsp_cl all_funds_padbt_cl"> <div align="right"><img src="resources/images/registry/close_img.png" class="rln_add_gifts_imgds_cl" id="minus_img_click_id" onmouseover="this.src='resources/images/registry/close_mo_img.png';" onmouseout="this.src='resources/images/registry/close_img.png';"></div> <div class="row top_adjustment_10 rln_add_gifts_pdlr_cl">
	        <div class="regoverview_title_sel text-center rln_add_gifts_titmbt_cl"> <h4><font class="reg_con_cur_brd_fl_dsp">B</font>UILD <font class="reg_con_cur_brd_fl_dsp">Y</font>OUR <font class="reg_con_cur_brd_fl_dsp">R</font>EGISTRY</h4> </div>	              
	        <div class="col-md-12 col-sm-12 reg_butt_frame_box_dsp_cl"> <div class="row top_adjustment_45 rln_add_gifts_pdiadj_cl"> <div class="col-md-4 col-sm-4"> <div align="center">
	        	<form action="designCuratedConceptsBoards"> <button class="sel_build_registry_sbut_butt" id="registryCuratedConButtonId"> <font class="build_reg_but_text_fl_dsp">A</font>DD <br><font class="build_reg_but_text_fl_dsp">F</font>urniture <font class="build_reg_but_text_fl_dsp">&amp; D</font>ecor </button> </form> </div> </div>	        	
	        	<div class="col-md-4 col-sm-4"> <div align="center"> <button class="sel_build_registry_mo_sbut_butt" id="registryRoomFundButtonId"> <font class="build_reg_but_text_fl_dsp">C</font>REATE <br><font class="build_reg_but_text_fl_dsp">R</font>OOM <font class="build_reg_but_text_fl_dsp">F</font>UNDS </button> </div> </div>
	        	<div class="col-md-4 col-sm-4"> <div align="center"> <form action="createCashFunds"> <button class="sel_build_registry_sbut_butt" id="registryCashFundButtonId"> <font class="build_reg_but_text_fl_dsp">C</font>REATE <br><font class="build_reg_but_text_fl_dsp">C</font>ASH <font class="build_reg_but_text_fl_dsp">F</font>UNDS </button> </form> </div> </div> </div> </div>
	        	<div align="center">
	        	<img class="rln_add_gifts_botimg_dsp" src="resources/images/registry/reg_overview/reg_overview_mid_img.png"> </div> </div> </div> </div>

<!-- Code End --> <!-- ADD GIFT CARD CONTENT DISPLAY COADING START -->        
       	<div id="room_funds_adj_id" class="rfuns_frame_tp_adj"> <div class="rfuns_frame_pdntp_adj"> <div class="row">				
	   		<div class="reg_con_cur_brd_heading_dsp text-left rfuns_frame_mbtm_adj"> <h4><font class="reg_con_cur_brd_fl_dsp">R</font>OOM <font class="reg_con_cur_brd_fl_dsp">F</font>UNDS </h4> </div>
				<div class="regi_room_funds_sub_main_txt_dsp text-left"> Create a room fund for any space that you want to decorate at a later time.&nbsp; <a href="lmDesignServices" class="rf_hiw_link_dsplay">Learn More</a> </div>			        
			        <div class="regi_room_funds_sub_txt_dsp text-left rfuns_frame_mtop_cls"> Note: All Room Funds (funds listed below) will be converted to Nook+Cove credit that can be used on the website at any time. </div>
				
		<!-- Start Room FUnds Images DIsplay Coding Start -->				
				<div class="col-md-12 col-sm-12 top_adjustment_35"> <table> <tbody> <tr> <td>		
					<div class="reg_image_and_text_frame_dsp_cl right_adjustment_13" onclick="typeOfRoomFund('livingRoomFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="livingRoomFormId">			
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/livingroomfund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="reg_room_fund_bott_nam0e_text_nl"><font class="regi_room_fund_bott_name_text_fl">L</font>IVING <font class="regi_room_fund_bott_name_text_fl">R</font>OOM <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="livingRoom" /> <input type="hidden" name="nameOfTheRoomFund" value="LIVING ROOM FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="livingroomfund.jpg" />
						</form>	 </div> </td>				
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('diningRoomFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="diningRoomFormId">		
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/diningroomfund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_room_fund_bott_name_text_nl"><font class="regi_room_fund_bott_name_text_fl">D</font>INING <font class="regi_room_fund_bott_name_text_fl">R</font>OOM <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="dining_room" /> <input type="hidden" name="nameOfTheRoomFund" value="DINING ROOM FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="diningroomfund.jpg" />
						</form> </div> </td>				
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('bedRoomFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="bedRoomFormId">			
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/bedroomfund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_room_fund_bott_name_text_nl"><font class="regi_room_fund_bott_name_text_fl">B</font>EDROOM <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="bedroom" /> <input type="hidden" name="nameOfTheRoomFund" value="BEDROOM FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="bedroomfund.jpg" />
						</form> </div> </td>				
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('homeOfficeFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="homeOfficeFormId">			
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/homeofficefund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_room_fund_bott_name_text_nl"><font class="regi_room_fund_bott_name_text_fl">H</font>OME <font class="regi_room_fund_bott_name_text_fl">O</font>FFICE <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="home_office" /> <input type="hidden" name="nameOfTheRoomFund" value="HOME OFFICE FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="homeofficefund.jpg" />
						</form> </div> </td>				
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('entrywayFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="entrywayFormId">			
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/entrywayfund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_room_fund_bott_name_text_nl"><font class="regi_room_fund_bott_name_text_fl">E</font>NTRYWAY <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="entryway" /> <input type="hidden" name="nameOfTheRoomFund" value="ENTRYWAY FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="entrywayfund.jpg" />
						</form> </div> </td> </tr>				
				<tr class="rfuns_frame_htd_cls"></tr>				
				<tr> <td> <div class="reg_image_and_text_frame_dsp_cl right_adjustment_13" onclick="typeOfRoomFund('nurseryFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="nurseryFormId">			
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/nurseryfund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_room_fund_bott_name_text_nl"><font class="regi_room_fund_bott_name_text_fl">N</font>URSERY <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="nursery" /> <input type="hidden" name="nameOfTheRoomFund" value="NURSERY FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="nurseryfund.jpg" />
						</form> </div> </td>				
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('kidsBedRoomFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="kidsBedRoomFormId">			
						<div class="row"> <div class="col-md-12 col-smStart Room FUnds Images DIsplay Coding Start-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/kidsbedroomfund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_room_fund_bott_name_text_nl"><font class="regi_room_fund_bott_name_text_fl">K</font>IDS <font class="regi_room_fund_bott_name_text_fl">B</font>EDROOM <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="kids_bedroom" /> <input type="hidden" name="nameOfTheRoomFund" value="KIDS BEDROOM FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="kidsbedroomfund.jpg" />
						</form> </div> </td>				
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('outDoorSpaceFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="outDoorSpaceFormId">			
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/outdoorspacefund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_room_fund_bott_name_text_nl"><font class="regi_room_fund_bott_name_text_fl">O</font>UTDOOR <font class="regi_room_fund_bott_name_text_fl">S</font>PACE <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="outdoor_space" /> <input type="hidden" name="nameOfTheRoomFund" value="OUTDOOR SPACE FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="outdoorspacefund.jpg" />
						</form> </div> </td>				
				<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomFund('otherDreamSpaceFormId');">
						<form action="registryRoomFundsInfoDisplay" method="post" id="otherDreamSpaceFormId">			
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/registry/roomandfundimages/otherdreamspacefund.jpg" width="210" height="210" > </div> </div>
						<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_room_fund_bott_name_text_nl"><font class="regi_room_fund_bott_name_text_fl">C</font>USTOM <font class="regi_room_fund_bott_name_text_fl">D</font>ESIGN <font class="regi_room_fund_bott_name_text_fl">F</font>UND</div> </div> </div> </div>
						<input type="hidden" name="regSpaceName" value="other_dream_space" /> <input type="hidden" name="nameOfTheRoomFund" value="CUSTOM DESIGN FUND" /> <input type="hidden" name="imageOfTheRoomFund" value="otherdreamspacefund.jpg" />
						</form> </div> </td> </tr> </tbody> </table>
				</div> </div> </div> </div>
<!-- END CODING -->    
		</div> </div>		
		  
        <div id="boxes"> <div class="rln_popup_frame_dsp" id="mask"></div> <div align="center" style="padding: 20px; display: none;  width: 760px; z-index: 10001; overflow-y: hidden; position:fixed; left: 50%; top: 50%; -ms-transform: translate(-50%,-50%); -moz-transform:translate(-50%,-50%); -webkit-transform: translate(-50%,-50%); transform: translate(-50%,-50%);" id="dialog" class="window"> <div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" class="rln_pop_cl_img_adj"></a></div> <div class="rln_pop_uplph_txt_cl">Upload Your Photo</div> <div id="lorem" class="rln_pop_pad_adj">		
		<form action="uploadRegistrantProfile?uploadImgReferance=roomFundImageUpload" method="POST" enctype="multipart/form-data">
		<table class="rln_pop_table_frm_adj"> <tbody><tr><td><input type="file" onchange="readURL(event)" name="regPhotoUpload" id="fileUpload" title="Click here to browse your photo." class="rln_pop_table_bgc_cl"></td></tr> <tr class="rln_pop_tr_heights_cl"><td></td></tr>
		<tr><td><font>You can upload a JPG, JPEG, BMP, HEIC, HEIF, PDF, GIF, or PNG file.</font></td></tr> <tr class="rln_pop_tr_heights_cl"><td></td></tr> <tr><td>This image can be seen by any guest on our website viewing or searching for your registry.</td></tr> <tr class="rln_pop_tr_heightm_cl"><td></td></tr> <tr><td><input type="checkbox" name="accept" id="accept"> <div class="rln_pop_mlt_txt_cl">I own the image I am uploading and confirm that this image compiles with the <br>NOOK + COVE Upload Terms of Use.</div></td></tr>
		<tr class="rln_pop_tr_heighth_cl"><td></td></tr> <tr><td><button class="uploaded_submit_Btn_for_regi" id="photoUploadBut">UPLOAD</button></td></tr> <tr class="rln_pop_tr_heightvs_cl"><td></td></tr> </tbody></table>
		</form>
		</div> </div> </div>
		
		<script type="text/javascript">		
			function typeOfRoomFund(roomFundFormId) { $("#"+roomFundFormId).submit(); }
		</script>
		
		<script type="text/javascript" src="resources/js/registry/registry_landing.js"></script>
		<script type="text/javascript" src="resources/js/file_upload.js"></script>
		</body>
</html>