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
	<link rel="stylesheet" href="resources/css/file_upload.css" type="text/css">
	<link rel="stylesheet" href="resources/css/registry_css/registry_landing.css" type="text/css">
	<script type="text/javascript">
 	$(document).ready(function() { var regiStatus = "<c:out value="${regStatus}"/>"; if(regiStatus === "Done") { $("#makeRegistryVisibleId").hide(); $("#registryIsLiveId").show(); } else { $("#makeRegistryVisibleId").show(); $("#registryIsLiveId").hide(); } }); 	
    </script>    
	</head>	
		<body>		
		<div class="container-fluid top_adjustment_75">  <img src="<c:out value='${guestBackgroungImage}'/>" class="rln_top_img_dsp">                 
        <div class="rln_top_frame_adj_cl"> <div id="redUploadImage"> <div class="regi_circle_uploaded_image"><div class="rln_top_photo_text_cl">${regUploadedPhoto}</div></div> </div>	        
	        <div class="rln_top_three_frames_div_cl"> <table id="visibleStatusRefTableId"> <tbody> <tr> <td class="rln_top_edit_bg_text_cl"> <a href="regEditBackgroundForGuest?regReferance=landingEditBackground" class="reg_ln_access_frame_text_dsp">Edit Background</a> </td> <td class="rln_top_edit_bg_text_cl"> <a href="previewGuestRegistry" class="reg_ln_access_frame_text_dsp" target="_blank">Preview Registry</a> </td> <td class="rln_top_visible_bg_text_cl" id="makeRegistryVisibleId"> <a href="#" onclick="return registryMakeVisibleAccess('Live Status On');" class="reg_ln_access_frame_text_dsp">Registry Is Hidden </a> </td> <td class="rln_top_visible_bg_text_cl" id="registryIsLiveId"> <a href="#" onclick="return registryMakeVisibleAccess('Live Status Off');" class="reg_ln_access_frame_text_dsp">Registry is Live </a> </td> </tr> </tbody></table> </div>        
	        <div class="rln_top_name_dsp_top_div"> <div class="reg_first_and_sec_name_dsp_cl"><c:out value='${regFirstName}'/></div> <div class="reg_event_date_dsp_cl"><c:out value='${eventDate}'/></div>		         
		        <div class="rln_top_msg_dsp_top_div"> <table id="messageEditDisplayId"> <tbody> <tr><td align="left"><div class="reg_ln_message_edit_text_dsp">${registrantMessage}</div></td> <td><button class="reg_message_small_edit_butt rln_top_edit_butt_div" id="editedDataRefId">EDIT</button></td></tr> </tbody></table>			        
			        <form action="saveRegiMessageData?regMesReferance=messageLanding" method="POST"> <table id="messageSaveDisplayId" class="rln_top_mesg_dspl_cl"> <tbody> <tr><td align="left"><input type="text" id="messageTextInputId" name="messageToGuests" maxlength="100" value="${registrantMessage}" class="reg_message_saveinput_tag_dsp"></td> <td align="left"><button class="reg_message_small_sub_butt rln_top_save_butt_div" id="saveDataRefId">SAVE</button></td> </tr> </tbody></table> </form> </div> </div> </div> </div>		      			
		<div id="mainframe" class="section-content" style="margin-top: -19px;">
        <div class="container"> 
<!-- ADD GIFT CARD COADING START -->    
        <div class="row top_adjustment_80" id="plus_img_info_display_id"> <div class="col-md-1 col-sm-1"></div>	 <div class="col-md-10 col-sm-10 reg_land_sub_fram_box_dsp_cl">
	        <div align="center"> <table class="rln_add_gifts_top_adj" id="reg_plus_butt_click_id"><tr> <td><img src="resources/images/registry/preview_reg_imgs/reg_plus_img.png" width="36" height="34"></td> <td><div class="reg_add_gift_text_dly">&nbsp;&nbsp;ADD GIFTS</div></td> </tr></table> </div>	        
        </div> <div class="col-md-1 col-sm-1"></div> </div>                         
 <!-- ADD GIFT CARD CONTENT DISPLAY COADING START -->        
        <div class="row rln_add_gifts_shdsp_adj" id="reg_giftcards_info_id"> <div class="col-md-12 col-sm-12 reg_sub_fram_box_dsp_cl rln_add_gifts_shtb_cl"> 
        	<div align="right"><img src="resources/images/registry/close_img.png" class="rln_add_gifts_imgds_cl" id="minus_img_click_id" onmouseover="this.src='resources/images/registry/close_mo_img.png';" onmouseout="this.src='resources/images/registry/close_img.png';"></div> <div class="row top_adjustment_10 rln_add_gifts_pdlr_cl">	        
	        <div class="regoverview_title_sel text-center rln_add_gifts_titmbt_cl"> <h4><font class="reg_ln_con_cur_brd_fl_dsp">B</font>UILD <font class="reg_ln_con_cur_brd_fl_dsp">Y</font>OUR <font class="reg_ln_con_cur_brd_fl_dsp">R</font>EGISTRY</h4> </div>	              
	        <div class="col-md-12 col-sm-12 reg_butt_frame_box_dsp_cl">  <div class="row top_adjustment_45 rln_add_gifts_pdiadj_cl">	        	
	        	<div class="col-md-4 col-sm-4"> <div align="center"> <form action="designCuratedConceptsBoards"> <button class="sel_build_registry_sbut_butt" id="registryCuratedConButtonId"> <font class="build_reg_but_text_fl_dsp">A</font>DD <br><font class="build_reg_but_text_fl_dsp">F</font>urniture <font class="build_reg_but_text_fl_dsp">&amp; D</font>ecor </button> </form> </div> </div>	        	
	        	<div class="col-md-4 col-sm-4"> <div align="center"> <form action="createRoomFunds"> <button class="sel_build_registry_sbut_butt" id="registryCashFundButtonId"> <font class="build_reg_but_text_fl_dsp">C</font>REATE <br><font class="build_reg_but_text_fl_dsp">R</font>OOM <font class="build_reg_but_text_fl_dsp">F</font>UNDS </button> </form> </div> </div>	        	
	        	<div class="col-md-4 col-sm-4"> <div align="center"> <form action="createCashFunds"> <button class="sel_build_registry_sbut_butt" id="registryCashFundButtonId"> <font class="build_reg_but_text_fl_dsp">C</font>REATE <br><font class="build_reg_but_text_fl_dsp">C</font>ASH <font class="build_reg_but_text_fl_dsp">F</font>UNDS </button> </form> </div> </div> </div> </div>	        
	        <div align="center"> <img class="rln_add_gifts_botimg_dsp" src="resources/images/registry/reg_overview/reg_overview_mid_img.png"> </div> </div> </div> </div>
<!-- Code End --> <!-- SELECTED GIFT CARDS COADING START -->    
        <div class="row top_adjustment_20" id="allFundsFrameDisplayId">
		<div class="col-md-1 col-sm-1"></div>
        <div class="col-md-10 col-sm-10">
	   	<div class="row">		 
		 <div id="roomFundsDivId">		        
<!-- 1rd Column -->			
			<% 	String livingRoomFund = (String)session.getAttribute("livingRoomFundSn");
				if (null != livingRoomFund) { String[] livingRoomCombVal = livingRoomFund.split("__");
					for (int i = 0; i < livingRoomCombVal.length; i++) {  String[] livingRoomColumnValue = livingRoomCombVal[i].split("_,_"); double regiGivenAmount1Db = 0;
						if(null != livingRoomColumnValue[1]) { regiGivenAmount1Db = Double.parseDouble(livingRoomColumnValue[1]); }
						int count = (i + 1); String lrColumnCount = livingRoomColumnValue[0];						
						String totalLivingRoomFundsAmount1 = (String)session.getAttribute("totalLivingRoomFundsAmount");						
						double totalFundAmount1 = 0;
						if (null != totalLivingRoomFundsAmount1) { String[] totLivingRoomFundAmount = totalLivingRoomFundsAmount1.split("__"); totalFundAmount1 = Double.parseDouble(totLivingRoomFundAmount[i]); }
						double stillNeedAmount1Db = regiGivenAmount1Db - totalFundAmount1; String stillNeedAmount1 = Double.toString(stillNeedAmount1Db);			
			if(stillNeedAmount1Db < 1 && regiGivenAmount1Db > 0) {	
			%>			  	
            <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/livingroomfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row">
					<div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">LIVING ROOM FUND</div> </div>
						<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount1%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount1%>" type="number"/></font> &nbsp;</div> </div>
						<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
						<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>   			             			
   			<% } else { %>   			
   			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
            <% if(totalFundAmount1 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=lrColumnCount%>, 'LIVING ROOM FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/livingroomfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">LIVING ROOM FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount1%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount1%>" type="number"/></font> &nbsp;</div> </div>
					<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__LIVING ROOM FUND__livingroomfund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>   			   			        
   			<% } } } %>   			     
<!-- 2th Column -->
			<% 	String diningRoomFund = (String)session.getAttribute("diningRoomFundSn");
				if (null != diningRoomFund) { String[] diningRoomCombVal = diningRoomFund.split("__");
					for (int i = 0; i < diningRoomCombVal.length; i++) { String[] diningRoomColumnValue = diningRoomCombVal[i].split("_,_"); double regiGivenAmount2Db = 0;
						if(null != diningRoomColumnValue[1]) { regiGivenAmount2Db = Double.parseDouble(diningRoomColumnValue[1]); }
						int count = (i + 1); String drColumnCount = diningRoomColumnValue[0]; String totalDyningRoomFundsAmount1 = (String)session.getAttribute("totalDyningRoomFundsAmount"); double totalFundAmount2 = 0;
						if (null != totalDyningRoomFundsAmount1) { String[] totDyningRoomFundsAmount1 = totalDyningRoomFundsAmount1.split("__"); totalFundAmount2 = Double.parseDouble(totDyningRoomFundsAmount1[i]); }						
						double stillNeedAmount2Db = regiGivenAmount2Db - totalFundAmount2; String stillNeedAmount2 = Double.toString(stillNeedAmount2Db);			
			if(stillNeedAmount2Db < 1 && regiGivenAmount2Db > 0) {
			%>			 	
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/diningroomfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">DINING ROOM FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount2%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount2%>" type="number"/></font> &nbsp;</div> </div>
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>	 </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>   			
   			<% } else { %>   			    			 
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount2 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=drColumnCount%>, 'DINING ROOM FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/diningroomfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">DINING ROOM FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount2%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount2%>" type="number"/></font> &nbsp;</div> </div>
					<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__DINING ROOM FUND__diningroomfund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	            		        
   			<% } } } %>   			   
<!-- 3th Column -->
			<% 	String bedroomFund = (String)session.getAttribute("bedroomFundSn");
				if (null != bedroomFund) { String[] bedroomCombVal = bedroomFund.split("__");
					for (int i = 0; i < bedroomCombVal.length; i++) { String[] bedroomColumnValue = bedroomCombVal[i].split("_,_"); double regiGivenAmount3Db = 0;
						if(null != bedroomColumnValue[1]) { regiGivenAmount3Db = Double.parseDouble(bedroomColumnValue[1]); }
						int count = (i + 1); String brColumnCount = bedroomColumnValue[0]; String totalBedRoomFundsAmount1 = (String)session.getAttribute("totalBedRoomFundsAmount"); double totalFundAmount3 = 0;
						if (null != totalBedRoomFundsAmount1) { String[] totBedRoomFundsAmount1 = totalBedRoomFundsAmount1.split("__"); totalFundAmount3 = Double.parseDouble(totBedRoomFundsAmount1[i]); }
						double stillNeedAmount3Db = regiGivenAmount3Db - totalFundAmount3; String stillNeedAmount3 = Double.toString(stillNeedAmount3Db);						
			if(stillNeedAmount3Db < 1 && regiGivenAmount3Db > 0) {
			%>			   
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/bedroomfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">BEDROOM FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount3%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount3%>" type="number"/></font> &nbsp;</div> </div>						
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	
   			<% } else { %>   			 
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount3 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=brColumnCount%>, 'BEDROOM FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/bedroomfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">BEDROOM FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount3%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount3%>" type="number"/></font> &nbsp;</div> </div>						
						<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
						<div class="top_adjustment_5" align="right">
						<a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__BEDROOM FUND__bedroomfund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div>
					</div> </div> </div> </div>   			            		        
   			<% } } } %>   			
<!-- 4th Column -->
			<% 	String homeOfficeFund = (String)session.getAttribute("homeOfficeFundSn");
				if (null != homeOfficeFund) { String[] homeOfficeCombVal = homeOfficeFund.split("__");
					for (int i = 0; i < homeOfficeCombVal.length; i++) { String[] homeOfficeColumnValue = homeOfficeCombVal[i].split("_,_"); double regiGivenAmount4Db = 0;
						if(null != homeOfficeColumnValue[1]) { regiGivenAmount4Db = Double.parseDouble(homeOfficeColumnValue[1]); }
						int count = (i + 1); String hoColumnCount = homeOfficeColumnValue[0]; String totalHomeOfficeRoomFundsAmount1 = (String)session.getAttribute("totalHomeOfficeRoomFundsAmount"); double totalFundAmount4 = 0;
						if (null != totalHomeOfficeRoomFundsAmount1) { String[] totHomeOfficeRoomFundsAmount1 = totalHomeOfficeRoomFundsAmount1.split("__"); totalFundAmount4 = Double.parseDouble(totHomeOfficeRoomFundsAmount1[i]); }
						double stillNeedAmount4Db = regiGivenAmount4Db - totalFundAmount4; String stillNeedAmount4 = Double.toString(stillNeedAmount4Db);			
			if(stillNeedAmount4Db < 1 && regiGivenAmount4Db > 0) {										
			%>			  	 
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/homeofficefund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">HOME OFFICE FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount4%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount4%>" type="number"/></font> &nbsp;</div> </div>						
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>	 </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>                
   			<% } else { %>   			 
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount4 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=hoColumnCount%>, 'HOME OFFICE FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/homeofficefund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">HOME OFFICE FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount4%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount4%>" type="number"/></font> &nbsp;</div> </div>						
					<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__HOME OFFICE FUND__homeofficefund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>               
   			<% } } } %>   			
<!-- 5th Column -->
			<% 	String entrywayFund = (String)session.getAttribute("entrywayFundSn");
				if (null != entrywayFund) { String[] entrywayCombVal = entrywayFund.split("__");
					for (int i = 0; i < entrywayCombVal.length; i++) { String[] entrywayColumnValue = entrywayCombVal[i].split("_,_"); double regiGivenAmount5Db = 0;
						if(null != entrywayColumnValue[1]) { regiGivenAmount5Db = Double.parseDouble(entrywayColumnValue[1]); }
						int count = (i + 1); String ewColumnCount = entrywayColumnValue[0]; String totalEntryWayRoomFundsAmount1 = (String)session.getAttribute("totalEntryWayRoomFundsAmount"); double totalFundAmount5 = 0;
						if (null != totalEntryWayRoomFundsAmount1) { String[] totEntryWayRoomFundsAmount1 = totalEntryWayRoomFundsAmount1.split("__"); totalFundAmount5 = Double.parseDouble(totEntryWayRoomFundsAmount1[i]); }
						double stillNeedAmount5Db = regiGivenAmount5Db - totalFundAmount5; String stillNeedAmount5 = Double.toString(stillNeedAmount5Db);			
			if(stillNeedAmount5Db < 1 && regiGivenAmount5Db > 0) {
			%>				
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/entrywayfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">ENTRYWAY FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount5%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount5%>" type="number"/></font> &nbsp;</div> </div>						
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	
   			<% } else { %>   			 
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount5 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=ewColumnCount%>, 'ENTRYWAY FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/entrywayfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row">
					<div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">ENTRYWAY FUND</div> </div>
						<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount5%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount5%>" type="number"/></font> &nbsp;</div> </div>						
						<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
						<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__ENTRYWAY FUND__entrywayfund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>                    
   			<% } } } %>   			 
<!-- 6th Column -->
			<% 	String nurseryFund = (String)session.getAttribute("nurseryFundSn");
				if (null != nurseryFund) { String[] nurseryCombVal = nurseryFund.split("__");
					for (int i = 0; i < nurseryCombVal.length; i++) { String[] nurseryColumnValue = nurseryCombVal[i].split("_,_"); double regiGivenAmount6Db = 0;
						if(null != nurseryColumnValue[1]) { regiGivenAmount6Db = Double.parseDouble(nurseryColumnValue[1]); }
						int count = (i + 1); String nrColumnCount = nurseryColumnValue[0]; String totalNurseryRoomFundsAmount1 = (String)session.getAttribute("totalNurseryRoomFundsAmount"); double totalFundAmount6 = 0;
						if (null != totalNurseryRoomFundsAmount1) { String[] totNurseryRoomFundsAmount1 = totalNurseryRoomFundsAmount1.split("__"); totalFundAmount6 = Double.parseDouble(totNurseryRoomFundsAmount1[i]); }
						double stillNeedAmount6Db = regiGivenAmount6Db - totalFundAmount6; String stillNeedAmount6 = Double.toString(stillNeedAmount6Db);			
			if(stillNeedAmount6Db < 1 && regiGivenAmount6Db > 0) {
			%>			  	
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/nurseryfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">NURSERY FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount6%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount6%>" type="number"/></font> &nbsp;</div> </div>						
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	
   			<% } else { %>   			 
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount6 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=nrColumnCount%>, 'NURSERY FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/nurseryfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">NURSERY FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount6%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount6%>" type="number"/></font> &nbsp;</div> </div>						
					<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__NURSERY FUND__nurseryfund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	        
   			<% } } } %>   			
<!-- 7th Column -->
			<% 	String kidsBedroomFund = (String)session.getAttribute("kidsBedroomFundSn");
				if (null != kidsBedroomFund) { String[] kidsBedroomCombVal = kidsBedroomFund.split("__");
					for (int i = 0; i < kidsBedroomCombVal.length; i++) { String[] kidsBedroomColumnValue = kidsBedroomCombVal[i].split("_,_"); double regiGivenAmount7Db = 0;
						if(null != kidsBedroomColumnValue[1]) { regiGivenAmount7Db = Double.parseDouble(kidsBedroomColumnValue[1]); }
						int count = (i + 1); String kbrColumnCount = kidsBedroomColumnValue[0]; String totalKidsBedRoomRoomFundsAmount1 = (String)session.getAttribute("totalKidsBedRoomRoomFundsAmount"); double totalFundAmount7 = 0;
						if (null != totalKidsBedRoomRoomFundsAmount1) { String[] totKidsBedRoomRoomFundsAmount1 = totalKidsBedRoomRoomFundsAmount1.split("__"); totalFundAmount7 = Double.parseDouble(totKidsBedRoomRoomFundsAmount1[i]); }
						double stillNeedAmount7Db = regiGivenAmount7Db - totalFundAmount7; String stillNeedAmount7 = Double.toString(stillNeedAmount7Db);			
			if(stillNeedAmount7Db < 1 && regiGivenAmount7Db > 0) {
			%>			  
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/kidsbedroomfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">KIDS BEDROOM FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount7%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount7%>" type="number"/></font> &nbsp;</div> </div>
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	
   			<% } else { %>   			 
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount7 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=kbrColumnCount%>, 'KIDS BEDROOM FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/kidsbedroomfund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">KIDS BEDROOM FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount7%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount7%>" type="number"/></font> &nbsp;</div> </div>
					<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__KIDS BEDROOM FUND__kidsbedroomfund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            		        
   			<% } } } %>   			  
<!-- 8th Column -->
			<% 	String playAreaFund = (String)session.getAttribute("playAreaFundSn");
				if (null != playAreaFund) { String[] playAreaCombVal = playAreaFund.split("__");
					for (int i = 0; i < playAreaCombVal.length; i++) { String[] playAreaColumnValue = playAreaCombVal[i].split("_,_"); double regiGivenAmount8Db = 0;
						if(null != playAreaColumnValue[1]) { regiGivenAmount8Db = Double.parseDouble(playAreaColumnValue[1]); }
						int count = (i + 1); String paColumnCount = playAreaColumnValue[0]; String totalPlayAreaRoomFundsAmount1 = (String)session.getAttribute("totalPlayAreaRoomFundsAmount"); double totalFundAmount8 = 0;
						if (null != totalPlayAreaRoomFundsAmount1) { String[] totPlayAreaRoomFundsAmount1 = totalPlayAreaRoomFundsAmount1.split("__"); totalFundAmount8 = Double.parseDouble(totPlayAreaRoomFundsAmount1[i]); }
						double stillNeedAmount8Db = regiGivenAmount8Db - totalFundAmount8; String stillNeedAmount8 = Double.toString(stillNeedAmount8Db);			
			if(stillNeedAmount8Db < 1 && regiGivenAmount8Db > 0) {
			%>			  
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/playareafund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">PLAY AREA FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount8%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount8%>" type="number"/></font> &nbsp;</div> </div>	
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	
   			<% } else { %>   			 
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount8 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=paColumnCount%>, 'PLAY AREA FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/playareafund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">PLAY AREA FUND</div> </div>
						<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount8%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount8%>" type="number"/></font> &nbsp;</div> </div>	
						<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
						<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__PLAY AREA FUND__playareafund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	        
   			<% } } } %>   			
<!-- 9th Column -->
			<% 	String outdoorSpaceFund = (String)session.getAttribute("outdoorSpaceFundSn");
				if (null != outdoorSpaceFund) { String[] outdoorSpaceCombVal = outdoorSpaceFund.split("__");
					for (int i = 0; i < outdoorSpaceCombVal.length; i++) { String[] outdoorSpaceColumnValue = outdoorSpaceCombVal[i].split("_,_"); double regiGivenAmount9Db = 0;
						if(null != outdoorSpaceColumnValue[1]) { regiGivenAmount9Db = Double.parseDouble(outdoorSpaceColumnValue[1]); }
						int count = (i + 1); String odsColumnCount = outdoorSpaceColumnValue[0]; String totalOutDoorSpaceRoomFundsAmount1 = (String)session.getAttribute("totalOutDoorSpaceRoomFundsAmount"); double totalFundAmount9 = 0;
						if (null != totalOutDoorSpaceRoomFundsAmount1) { String[] totOutDoorSpaceRoomFundsAmount1 = totalOutDoorSpaceRoomFundsAmount1.split("__"); totalFundAmount9 = Double.parseDouble(totOutDoorSpaceRoomFundsAmount1[i]); }
						double stillNeedAmount9Db = regiGivenAmount9Db - totalFundAmount9; String stillNeedAmount9 = Double.toString(stillNeedAmount9Db);			
			if(stillNeedAmount9Db < 1 && regiGivenAmount9Db > 0) {
			%>			 	  
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/outdoorspacefund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">OUTDOOR SPACE FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount9%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount9%>" type="number"/></font> &nbsp;</div> </div>	
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>                 
   			<% } else { %>   			  
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount9 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=odsColumnCount%>, 'OUTDOOR SPACE FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/outdoorspacefund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">OUTDOOR SPACE FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount9%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount9%>" type="number"/></font> &nbsp;</div> </div>	
					<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__OUTDOOR SPACE FUND__outdoorspacefund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	 
   			<% } } } %>   			 
<!-- 10th Column -->
			<% 	String otherDreamSpaceFund = (String)session.getAttribute("otherDreamSpaceFundSn");
				if (null != otherDreamSpaceFund) { String[] otherDreamSpaceCombVal = otherDreamSpaceFund.split("__");
					for (int i = 0; i < otherDreamSpaceCombVal.length; i++) { String[] otherDreamSpaceColumnValue = otherDreamSpaceCombVal[i].split("_,_"); double regiGivenAmount10Db = 0;
						if(null != otherDreamSpaceColumnValue[1]) { regiGivenAmount10Db = Double.parseDouble(otherDreamSpaceColumnValue[1]); }
						int count = (i + 1); String odsColumnCount = otherDreamSpaceColumnValue[0]; String totalOtherDreamSpaceRoomFundsAmount1 = (String)session.getAttribute("totalOtherDreamSpaceRoomFundsAmount"); double totalFundAmount10 = 0;
						if (null != totalOtherDreamSpaceRoomFundsAmount1) { String[] totOtherDreamSpaceRoomFundsAmount1 = totalOtherDreamSpaceRoomFundsAmount1.split("__"); totalFundAmount10 = Double.parseDouble(totOtherDreamSpaceRoomFundsAmount1[i]); }
						double stillNeedAmount10Db = regiGivenAmount10Db - totalFundAmount10; String stillNeedAmount10 = Double.toString(stillNeedAmount10Db);			
			if(stillNeedAmount10Db < 1 && regiGivenAmount10Db > 0) {
			%>				
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/otherdreamspacefund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">CUSTOM DESIGN FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount10%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount10%>" type="number"/></font> &nbsp;</div> </div>
					<div align="center" class="rln_roomfund_bgn_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	
   			<% } else { %>   			  
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(totalFundAmount10 < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedRoomFundContributedLandingInfoDelete(<%=odsColumnCount%>, 'CUSTOM DESIGN FUND');" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/otherdreamspacefund.jpg" width="219px" height="220px" > </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1">CUSTOM DESIGN FUND</div> </div>
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=totalFundAmount10%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount10%>" type="number"/></font> &nbsp;</div> </div>
					<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="registryRoomFundsLandingInfoEdit?landingRef=Landing__CUSTOM DESIGN FUND__otherdreamspacefund.jpg" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>            	        
   			<% } } } %>   			
   			</div>
<!-- Code End --> <!-- Cash Funds Coding Start-->		
		<div id="cashFundDivId">
		<% 
			if (null != session.getAttribute("regCashFundsIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsIdList = (ArrayList) session.getAttribute("regCashFundsIdListInSn"); if (null != regCashFundsIdList && regCashFundsIdList.size() > 0) {	       		
		   	if (null != session.getAttribute("regCashFundsImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsImageList = (ArrayList) session.getAttribute("regCashFundsImageListInSn"); if (null != regCashFundsImageList && regCashFundsImageList.size() > 0) {           	
           	if (null != session.getAttribute("regCashFundsNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsNameList = (ArrayList) session.getAttribute("regCashFundsNameListInSn"); if (null != regCashFundsNameList && regCashFundsNameList.size() > 0) {
           	if (null != session.getAttribute("regCashFundsPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsPriceList = (ArrayList) session.getAttribute("regCashFundsPriceListInSn"); if (null != regCashFundsPriceList && regCashFundsPriceList.size() > 0) {
           	if (null != session.getAttribute("regCashFundsContAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsContAmountList = (ArrayList) session.getAttribute("regCashFundsContAmountListInSn"); if (null != regCashFundsContAmountList && regCashFundsContAmountList.size() > 0) {            
            if (null != session.getAttribute("regCashFundsRemAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsRemAmountList = (ArrayList) session.getAttribute("regCashFundsRemAmountListInSn"); if (null != regCashFundsRemAmountList && regCashFundsRemAmountList.size() > 0) {
        %>        
          	<% 	for(int i = 0; i < regCashFundsIdList.size(); i++) { String remAmountInSt = (String) regCashFundsRemAmountList.get(i); String cashFundPriceInSt = (String) regCashFundsPriceList.get(i); double cashFundReqAmountDb = 0;
				if(!("").equals(cashFundPriceInSt) &&  null != cashFundPriceInSt) { cashFundReqAmountDb = Double.parseDouble(cashFundPriceInSt); }          	  
          	  	double cashFundRemAmount = 0; double cashFundRemAmountRef = 0;
			   	if(null != remAmountInSt) { cashFundRemAmount = Double.parseDouble(remAmountInSt); cashFundRemAmountRef = Double.parseDouble(remAmountInSt); } else { cashFundRemAmountRef = cashFundReqAmountDb; }
			   	String stillNeadAmount = null;
			   	if((null != cashFundPriceInSt && !("").equals(cashFundPriceInSt)) && null == remAmountInSt) { stillNeadAmount = cashFundPriceInSt; } else { stillNeadAmount = remAmountInSt; }
			   	String cashFundContAmount = null; double cashFundGiftedAmountDb = 0; String contAmountInSt = (String) regCashFundsContAmountList.get(i);
          	  	if(null != contAmountInSt) { cashFundGiftedAmountDb = Double.parseDouble(contAmountInSt); cashFundContAmount = contAmountInSt; } else { cashFundContAmount = "0"; }
          	  	String cashFundImageDsp = "resources/images/cash_fund_images/big/" + regCashFundsImageList.get(i); String cashFundNeedsAmount = String.format("%.2f", cashFundRemAmountRef);          	  
          	if(cashFundRemAmountRef < 1 && cashFundReqAmountDb > 0 ) {          		
          	%>          	
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=cashFundImageDsp%>" width="219px" height="220px"> </div> </div>				
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=regCashFundsNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=cashFundContAmount%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeadAmount%>" type="number"/></font> &nbsp;</div> </div>							
					<div align="center" class="rln_cashfund_opml_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="regContributeButtonId">CONTRIBUTE</button></h4> </div>						
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>        	
   			<% } else { %>        	
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(cashFundGiftedAmountDb < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedCashFundContributedInfoDelete(<%=regCashFundsIdList.get(i)%>);" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=cashFundImageDsp%>" width="219px" height="220px"> </div> </div>				
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=regCashFundsNameList.get(i)%></div> </div>						
						<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=cashFundContAmount%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeadAmount%>" type="number"/></font> &nbsp;</div> </div>	
						<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
						<div class="top_adjustment_5" align="right"> <a href="#" onclick="cashFundsEditRedirection('<%=regCashFundsNameList.get(i)%>');" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>  			
        <%} } } } } } } } } } } } } } %>
		</div>		
<!-- Cash Funds Coding End--> <!-- Custom Funds Coding Start-->
		<div id="customFundDivId">
		<% 
			if (null != session.getAttribute("regCustomFundsIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsIdList = (ArrayList) session.getAttribute("regCustomFundsIdListInSn"); if (null != regCustomFundsIdList && regCustomFundsIdList.size() > 0) {	       		
		   	if (null != session.getAttribute("regCustomFundsImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsImageList = (ArrayList) session.getAttribute("regCustomFundsImageListInSn"); if (null != regCustomFundsImageList && regCustomFundsImageList.size() > 0) {
           	if (null != session.getAttribute("regCustomFundsNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsNameList = (ArrayList) session.getAttribute("regCustomFundsNameListInSn"); if (null != regCustomFundsNameList && regCustomFundsNameList.size() > 0) {
           	if (null != session.getAttribute("regCustomFundsPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsPriceList = (ArrayList) session.getAttribute("regCustomFundsPriceListInSn"); if (null != regCustomFundsPriceList && regCustomFundsPriceList.size() > 0) {
           	if (null != session.getAttribute("regCustomFundsContAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsContAmountList = (ArrayList) session.getAttribute("regCustomFundsContAmountListInSn"); if (null != regCustomFundsContAmountList && regCustomFundsContAmountList.size() > 0) {
            if (null != session.getAttribute("regCustomFundsRemAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsRemAmountList = (ArrayList) session.getAttribute("regCustomFundsRemAmountListInSn"); if (null != regCustomFundsRemAmountList && regCustomFundsRemAmountList.size() > 0) {
        %>        
          	<% 	for(int i = 0; i < regCustomFundsIdList.size(); i++) { String remAmountInSt = (String) regCustomFundsRemAmountList.get(i); String cashFundPriceInSt = (String) regCustomFundsPriceList.get(i); double cashFundReqAmountDb = 0;
				if(!("").equals(cashFundPriceInSt) &&  null != cashFundPriceInSt) { cashFundReqAmountDb = Double.parseDouble(cashFundPriceInSt); }
          	  	double cashFundRemAmount = 0; double cashFundRemAmountRef = 0;
			   	if(null != remAmountInSt) { cashFundRemAmount = Double.parseDouble(remAmountInSt); cashFundRemAmountRef = Double.parseDouble(remAmountInSt); } else { cashFundRemAmountRef = cashFundReqAmountDb; }			   	
			   	String stillNeadAmount = null;
			   	if((null != cashFundPriceInSt && !("").equals(cashFundPriceInSt)) && null == remAmountInSt) { stillNeadAmount = cashFundPriceInSt; } else { stillNeadAmount = remAmountInSt; }
			   	String cashFundContAmount = null; double custFundGiftedAmountDb = 0; String contAmountInSt = (String) regCustomFundsContAmountList.get(i);
          	  	if(null != contAmountInSt) { custFundGiftedAmountDb = Double.parseDouble(contAmountInSt); cashFundContAmount = contAmountInSt; } else { cashFundContAmount = "0"; }
          	  	String customFundNeedsAmount = String.format("%.2f", cashFundRemAmountRef);          	  
          	if(cashFundRemAmountRef < 1 && cashFundReqAmountDb > 0 ) { 
          	%>          	
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=regCustomFundsImageList.get(i)%>"> </div> </div>				
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=regCustomFundsNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=cashFundContAmount%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeadAmount%>" type="number"/></font> &nbsp;</div> </div>							
					<div align="center" class="rln_cashfund_opml_dsp"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="regContributeButtonId">CONTRIBUTE</button></h4> </div>						
					<div class="top_adjustment_5" align="right"> <a href="#" class="reg_funds_link_edit_dark">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>        	
   			<% } else { %>        	
			<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
			<% if(custFundGiftedAmountDb < 1) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedCustomFundContributedInfoDelete(<%=regCustomFundsIdList.get(i)%>);" > <% } %>			
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=regCustomFundsImageList.get(i)%>" width="219px" height="220px"> </div> </div>				
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=regCustomFundsNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">TOTAL FUNDS GIFTED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=cashFundContAmount%>" type="number"/></font></div> <div class="reg_bott_small_text_dspl1">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeadAmount%>" type="number"/></font> &nbsp;</div> </div>	
					<div align="center"> <h4><button class="reg_ln_no_action_funds_sub_Butt" onclick="alert('You cannot contribute to your own fund. Only a guest can contribute to a fund.'); return false;">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_5" align="right"> <a href="#" onclick="customFundsEditRedirection('<%=regCustomFundsIdList.get(i)%>');" class="reg_bott_funds_link_edit">EDIT</a>&nbsp;&nbsp;</div> </div> </div> </div> </div>        	
        	<% } } %>
        <% } } } } } } } } } } } } %>
		</div>		
<!-- Custom Funds Coding End--> 
<!-- Concept Boards Contributed Products Display Coding Start-->		
		<div id="contributedCBDivId">
		<% 
			if (null != session.getAttribute("cbContributedProductSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedProductSavingIdList = (ArrayList) session.getAttribute("cbContributedProductSavingIdListInSn"); if (null != cbContributedProductSavingIdList && cbContributedProductSavingIdList.size() > 0) {
		   	if (null != session.getAttribute("cbContributedProductImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedProductImageList = (ArrayList) session.getAttribute("cbContributedProductImageListInSn"); if (null != cbContributedProductImageList && cbContributedProductImageList.size() > 0) {
           	if (null != session.getAttribute("cbContributedProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedProductNameList = (ArrayList) session.getAttribute("cbContributedProductNameListInSn"); if (null != cbContributedProductNameList && cbContributedProductNameList.size() > 0) { 
           	if (null != session.getAttribute("cbContributedProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedProductPriceList = (ArrayList) session.getAttribute("cbContributedProductPriceListInSn"); if (null != cbContributedProductPriceList && cbContributedProductPriceList.size() > 0) {
           	if (null != session.getAttribute("cbContributedProductQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedProductQuantityList = (ArrayList) session.getAttribute("cbContributedProductQuantityListInSn"); if (null != cbContributedProductQuantityList && cbContributedProductQuantityList.size() > 0) {
           	if (null != session.getAttribute("cbContributedRemainingAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedRemainingAmountList = (ArrayList) session.getAttribute("cbContributedRemainingAmountListInSn"); if (null != cbContributedRemainingAmountList && cbContributedRemainingAmountList.size() > 0) {
          	if (null != session.getAttribute("cbContributedAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedAmountList = (ArrayList) session.getAttribute("cbContributedAmountListInSn"); if (null != cbContributedAmountList && cbContributedAmountList.size() > 0) {         	   
            if (null != session.getAttribute("cbContributedPaymentStatusListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedPaymentStatusList = (ArrayList) session.getAttribute("cbContributedPaymentStatusListInSn"); if (null != cbContributedPaymentStatusList && cbContributedPaymentStatusList.size() > 0) {         	           
        %>                
        <% 	
        	for(int i = 0; i < cbContributedProductSavingIdList.size(); i++) { byte[] cbContributedProductImageByte = (byte[]) cbContributedProductImageList.get(i); String cbContributedProductImage = null;
	        	if(null != cbContributedProductImageByte) { String cbContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbContributedProductImageByte); cbContributedProductImage = "data:image/jpg;base64," +cbContributedProductImageB64; }
	        	String cbContributedRemAmountSt = (String) cbContributedRemainingAmountList.get(i); double cbContributedRemAmountDb = 0;
	        	if(null != cbContributedRemAmountSt) { cbContributedRemAmountDb = Double.parseDouble(cbContributedRemAmountSt); }
	        	String cbContributedPaymentStatus = (String) cbContributedPaymentStatusList.get(i); String cbContributedStillNeedAmount = String.format("%,.2f", cbContributedRemAmountDb); String cbContributedPriceDbSt = String.format("%,.2f", (Double) cbContributedProductPriceList.get(i));	        	
        %>        
<!-- Concept Boards Contributed Products Completed Payment-->       
        <% if(cbContributedRemAmountDb > 0) { %>        
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
		<% if(!("Contibuted Payment").equals(cbContributedPaymentStatus)) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedCBContributedInfoDelete(<%=cbContributedProductSavingIdList.get(i)%>);" > <% } %>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=cbContributedProductImage%>" width="219px" height="220px"> </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=cbContributedProductNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=cbContributedPriceDbSt%></font><font class="rln_con_all_price_txt_cl">/<%=cbContributedProductQuantityList.get(i)%></font></div> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div>																			
					<div align="center" class="rln_con_cont_ht_dsp"> <form action="regConceptBoardContributedInfoDisplay" method="POST"> <h4><button class="reg_bott_funds_sub_Butt" id="regiContributeButtonId">CONTRIBUTE</button></h4> <input type="hidden" name="regCBCotributedProductSavingId" value="<%=cbContributedProductSavingIdList.get(i)%>"> <input type="hidden" name="regCBCotributedRemainingPrice" value="<%=cbContributedStillNeedAmount%>"> <input type="hidden" name="regCBCotributedProductImage" value="<%=cbContributedProductImage%>"> <input type="hidden" name="regCBCotributedProductName" value="<%=cbContributedProductNameList.get(i)%>"> <input type="hidden" name="regCBCotributedPrice" value="<%=cbContributedAmountList.get(i)%>"> </form> </div>
					<div class="top_adjustment_8" align="right"> <form action="regCBContributedSelectedProductEdit"><input type='submit' class="regi_bott_funds_link_edit" value="EDIT"><input type="hidden" name="regCBCotributedProductSavingId" value="<%=cbContributedProductSavingIdList.get(i)%>"></form> </div>
					<div align="left" class="reg_bott_stlneed_small_text_dsp bot_adjustment_16">STILL NEED:&nbsp;<font class="rln_con_all_boldtxt_dsp">$<%=cbContributedStillNeedAmount%></font></div> </div> </div> </div> </div>         
   		<% } else { %>   		
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=cbContributedProductImage%>" width="219px" height="220px"> </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=cbContributedProductNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text rln_con_all_opat_dsp">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=cbContributedPriceDbSt%></font><font class="rln_con_all_price_txt_cl">/<%=cbContributedProductQuantityList.get(i)%></font></div> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div>																			
					<div align="center" class="rln_con_cont_opht_dsp"> <h4><button class="reg_bott_funds_sub_Butt" id="regiContributeButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_8" align="right"> <input type='submit' class="reg_funds_link_edit_dark" value="EDIT"><input type="hidden" name="regCBCotributedProductSavingId" value="<%=cbContributedProductSavingIdList.get(i)%>"> </div>
					<div align="left" class="reg_bott_stlneed_small_text_dsp  bot_adjustment_16">STILL NEED:&nbsp;<font class="rln_con_all_boldtxt_dsp">$<%=cbContributedStillNeedAmount%></font></div> </div> </div> </div> </div>   		
   		<% } } } } } } } } } } } } } } } } } } %>
		</div>		
<!-- Concept Boards Contributed Products Display Coding End--> <!-- Concept Boards Individual Products Display Coding Start-->		
		<div id="individualCBDivId">
		<% 
			if (null != session.getAttribute("cbIndividualProductSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualProductSavingIdList = (ArrayList) session.getAttribute("cbIndividualProductSavingIdListInSn"); if (null != cbIndividualProductSavingIdList && cbIndividualProductSavingIdList.size() > 0) {
		   	if (null != session.getAttribute("cbIndividualProductImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualProductImageList = (ArrayList) session.getAttribute("cbIndividualProductImageListInSn"); if (null != cbIndividualProductImageList && cbIndividualProductImageList.size() > 0) {
           	if (null != session.getAttribute("cbIndividualProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualProductNameList = (ArrayList) session.getAttribute("cbIndividualProductNameListInSn"); if (null != cbIndividualProductNameList && cbIndividualProductNameList.size() > 0) {
           	if (null != session.getAttribute("cbIndividualProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualProductPriceList = (ArrayList) session.getAttribute("cbIndividualProductPriceListInSn"); if (null != cbIndividualProductPriceList && cbIndividualProductPriceList.size() > 0) {
           	if (null != session.getAttribute("cbIndividualProductQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualProductQuantityList = (ArrayList) session.getAttribute("cbIndividualProductQuantityListInSn"); if (null != cbIndividualProductQuantityList && cbIndividualProductQuantityList.size() > 0) {
           	if (null != session.getAttribute("cbIndividualRemainingQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualRemainingQuantityList = (ArrayList) session.getAttribute("cbIndividualRemainingQuantityListInSn"); if (null != cbIndividualRemainingQuantityList && cbIndividualRemainingQuantityList.size() > 0) {
          	if (null != session.getAttribute("cbIndividualGivenQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualGivenQuantityList = (ArrayList) session.getAttribute("cbIndividualGivenQuantityListInSn"); if (null != cbIndividualGivenQuantityList && cbIndividualGivenQuantityList.size() > 0) {
            if (null != session.getAttribute("cbIndividualPaymentStatusListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualPaymentStatusList = (ArrayList) session.getAttribute("cbIndividualPaymentStatusListInSn"); if (null != cbIndividualPaymentStatusList && cbIndividualPaymentStatusList.size() > 0) {            	
        %>                
        <% 	
        	for(int i = 0; i < cbIndividualProductSavingIdList.size(); i++) { byte[] cbIndividualProductImageByte = (byte[]) cbIndividualProductImageList.get(i); String cbIndividualProductImage = null;
	        	if(null != cbIndividualProductImageByte) { String cbIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbIndividualProductImageByte); cbIndividualProductImage = "data:image/jpg;base64," +cbIndividualProductImageB64; } int cbIndividualRemainingQuantityInt = 0;
	        	if(null != cbIndividualRemainingQuantityList.get(i)) { cbIndividualRemainingQuantityInt = (Integer) cbIndividualRemainingQuantityList.get(i); }
	        	String cbIndividualPaymentStatus = (String) cbIndividualPaymentStatusList.get(i); int cbIndividualPaymentQuantity = (Integer) cbIndividualGivenQuantityList.get(i); int cbIndividualPaymentQuantityInt = 1;
	        	if(cbIndividualPaymentQuantity > 0) { cbIndividualPaymentQuantityInt = cbIndividualPaymentQuantity; }
	        	double cbIndividualProductPriceDb = Double.parseDouble((String) cbIndividualProductPriceList.get(i)); String cbIndividualProductPriceSt = String.format("%,.2f", cbIndividualProductPriceDb);	        	
        %>        
<!-- Concept Boards Individual Products Completed Payment-->       
        <% if(cbIndividualRemainingQuantityInt > 0) { %>        
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
		<% if(!("Individual Payment").equals(cbIndividualPaymentStatus)) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedCBIndividualInfoDelete(<%=cbIndividualProductSavingIdList.get(i)%>);" > <% } %>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=cbIndividualProductImage%>" width="219px" height="220px"> </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=cbIndividualProductNameList.get(i)%></div> </div> 
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=cbIndividualProductPriceSt%></font></div>
					<table class="top_adjustment_6"> <tr><td align="left" class="reg_bott_very_small_text_dsp">REQUESTED:&nbsp;<font class="rln_con_all_boldtxt_dsp"><%=cbIndividualProductQuantityList.get(i)%></font></td> <td align="right" class="reg_bott_very_small_text_dsp">STILL NEED:&nbsp;<font class="rln_con_all_boldtxt_dsp"><%=cbIndividualRemainingQuantityInt%></font></td></tr> </table> </div>						
					<div align="center" class="rln_con_ind_htmt_dsp"> <table> <tr><td><input type="text" name="productQuantity" maxLength="2" id="conBoardProductQuantityId<%=cbIndividualProductSavingIdList.get(i)%>" value="<%=cbIndividualPaymentQuantityInt%>" class="reg_bott_quentity_field_cl" onkeypress="return numeralsOnly(event);">&nbsp;&nbsp;&nbsp;</td> <td><h4><button class="reg_bott_funds_sub_Butt" onclick="return selectedCBIndividualInfoAddToCart(<%=cbIndividualProductSavingIdList.get(i)%>, <%=cbIndividualRemainingQuantityInt%>);">ADD TO CART</button></h4></td></tr> </table> </div>
					<div class="top_adjustment_8" align="right"> <form action="regCBIndividualSelectedProductEdit"><input type='submit' class="regi_bott_funds_link_edit" value="EDIT"><input type="hidden" name="regCBIndividualProductSavingId" value="<%=cbIndividualProductSavingIdList.get(i)%>"> </form> </div> </div> </div> </div> </div>   		
   		<% } else { %>   		
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=cbIndividualProductImage%>" width="219px" height="220px"> </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=cbIndividualProductNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text rln_con_all_opat_dsp">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=cbIndividualProductPriceSt%></font></div>
					<table class="top_adjustment_6"> <tr><td align="left" class="reg_bott_very_small_text_dsp">REQUESTED:&nbsp;<font class="rln_con_all_boldtxt_dsp"><%=cbIndividualProductQuantityList.get(i)%></font></td> <td align="right" class="reg_bott_very_small_text_dsp">STILL NEED:&nbsp;<font class="rln_con_all_boldtxt_dsp"><%=cbIndividualRemainingQuantityInt%></font></td></tr> </table> </div>						
					<div align="center" class="rln_con_addct_ht_dsp"> <table> <tr><td><input type="text" name="productQuantity" id="conBoardProductQuantityId" value="1" class="reg_bott_quentity_field_cl rln_con_ind_opc_dsp">&nbsp;&nbsp;&nbsp;</td> <td><h4><button class="reg_bott_funds_sub_Butt">ADD TO CART</button></h4></td></tr> </table> </div>
					<div class="top_adjustment_8" align="right"> <input type='submit' class="reg_funds_link_edit_dark" value="EDIT"> </div> </div> </div> </div> </div>   		
        <% } } } } } } } } } } } } } } } } } } %>
		</div>		
<!-- Concept Boards Individual Products Display Coding End-->




<!-- Finishing Touches Contributed Products Display Coding Start-->		
		<div id="contributedFTDivId">
		<% 
			if (null != session.getAttribute("ftContributedProductSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedProductSavingIdList = (ArrayList) session.getAttribute("ftContributedProductSavingIdListInSn"); if (null != ftContributedProductSavingIdList && ftContributedProductSavingIdList.size() > 0) {
		   	if (null != session.getAttribute("ftContributedProductImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedProductImageList = (ArrayList) session.getAttribute("ftContributedProductImageListInSn"); if (null != ftContributedProductImageList && ftContributedProductImageList.size() > 0) {
           	if (null != session.getAttribute("ftContributedProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedProductNameList = (ArrayList) session.getAttribute("ftContributedProductNameListInSn"); if (null != ftContributedProductNameList && ftContributedProductNameList.size() > 0) { 
           	if (null != session.getAttribute("ftContributedProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedProductPriceList = (ArrayList) session.getAttribute("ftContributedProductPriceListInSn"); if (null != ftContributedProductPriceList && ftContributedProductPriceList.size() > 0) {
           	if (null != session.getAttribute("ftContributedProductQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedProductQuantityList = (ArrayList) session.getAttribute("ftContributedProductQuantityListInSn"); if (null != ftContributedProductQuantityList && ftContributedProductQuantityList.size() > 0) {
           	if (null != session.getAttribute("ftContributedRemainingAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedRemainingAmountList = (ArrayList) session.getAttribute("ftContributedRemainingAmountListInSn"); if (null != ftContributedRemainingAmountList && ftContributedRemainingAmountList.size() > 0) {
          	if (null != session.getAttribute("ftContributedAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedAmountList = (ArrayList) session.getAttribute("ftContributedAmountListInSn"); if (null != ftContributedAmountList && ftContributedAmountList.size() > 0) {         	   
            if (null != session.getAttribute("ftContributedPaymentStatusListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedPaymentStatusList = (ArrayList) session.getAttribute("ftContributedPaymentStatusListInSn"); if (null != ftContributedPaymentStatusList && ftContributedPaymentStatusList.size() > 0) {         	           
        %>                
        <% 	
        	for(int i = 0; i < ftContributedProductSavingIdList.size(); i++) { byte[] ftContributedProductImageByte = (byte[]) ftContributedProductImageList.get(i); String ftContributedProductImage = null;
	        	if(null != ftContributedProductImageByte) { String ftContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(ftContributedProductImageByte); ftContributedProductImage = "data:image/jpg;base64," +ftContributedProductImageB64; }
	        	String ftContributedRemAmountSt = (String) ftContributedRemainingAmountList.get(i); double ftContributedRemAmountDb = 0;
	        	if(null != ftContributedRemAmountSt) { ftContributedRemAmountDb = Double.parseDouble(ftContributedRemAmountSt); }
	        	String ftContributedPaymentStatus = (String) ftContributedPaymentStatusList.get(i); String ftContributedStillNeedAmount = String.format("%,.2f", ftContributedRemAmountDb); String ftContributedPriceDbSt = String.format("%,.2f", (Double) ftContributedProductPriceList.get(i));	        	
        %>        
<!-- Finishing Touches Contributed Products Completed Payment-->       
        <% if(ftContributedRemAmountDb > 0) { %>        
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
		<% if(!("Contibuted Payment").equals(ftContributedPaymentStatus)) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedFTContributedInfoDelete(<%=ftContributedProductSavingIdList.get(i)%>);" > <% } %>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=ftContributedProductImage%>" width="219px" height="220px"> </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=ftContributedProductNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=ftContributedPriceDbSt%></font><font class="rln_con_all_price_txt_cl">/<%=ftContributedProductQuantityList.get(i)%></font></div> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div>																			
					<div align="center" class="rln_con_cont_ht_dsp"> <form action="finishingTouchesContributedProductAddToCart" method="POST"> <h4><button class="reg_bott_funds_sub_Butt" id="regiContributeButtonId">CONTRIBUTE</button></h4> <input type="hidden" name="regFTCotributedProductSavingId" value="<%=ftContributedProductSavingIdList.get(i)%>"> <input type="hidden" name="regFTCotributedRemainingPrice" value="<%=ftContributedStillNeedAmount%>"> <input type="hidden" name="regFTCotributedProductImage" value="<%=ftContributedProductImage%>"> <input type="hidden" name="regFTCotributedProductName" value="<%=ftContributedProductNameList.get(i)%>"> <input type="hidden" name="regFTCotributedPrice" value="<%=ftContributedAmountList.get(i)%>"> </form> </div>
					<div class="top_adjustment_8" align="right"> <form action="editFinishingTouchesContributedProduct"><input type='submit' class="regi_bott_funds_link_edit" value="EDIT"><input type="hidden" name="regFTCotributedProductSavingId" value="<%=ftContributedProductSavingIdList.get(i)%>"></form> </div>
					<div align="left" class="reg_bott_stlneed_small_text_dsp bot_adjustment_16">STILL NEED:&nbsp;<font class="rln_con_all_boldtxt_dsp">$<%=ftContributedStillNeedAmount%></font></div> </div> </div> </div> </div>         
   		<% } else { %>   		
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=ftContributedProductImage%>" width="219px" height="220px"> </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=ftContributedProductNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text rln_con_all_opat_dsp">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=ftContributedPriceDbSt%></font><font class="rln_con_all_price_txt_cl">/<%=ftContributedProductQuantityList.get(i)%></font></div> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div>																			
					<div align="center" class="rln_con_cont_opht_dsp"> <h4><button class="reg_bott_funds_sub_Butt" id="regiContributeButtonId">CONTRIBUTE</button></h4> </div>
					<div class="top_adjustment_8" align="right"> <input type='submit' class="reg_funds_link_edit_dark" value="EDIT"><input type="hidden" name="regFTCotributedProductSavingId" value="<%=ftContributedProductSavingIdList.get(i)%>"> </div>
					<div align="left" class="reg_bott_stlneed_small_text_dsp  bot_adjustment_16">STILL NEED:&nbsp;<font class="rln_con_all_boldtxt_dsp">$<%=ftContributedStillNeedAmount%></font></div> </div> </div> </div> </div>   		
   		<% } } } } } } } } } } } } } } } } } } %>
		</div>		
<!-- Finishing Touches Contributed Products Display Coding End--> <!-- Finishing Touches Individual Products Display Coding Start-->		
		<div id="individualFTDivId">
		<% 
			if (null != session.getAttribute("ftIndividualProductSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualProductSavingIdList = (ArrayList) session.getAttribute("ftIndividualProductSavingIdListInSn"); if (null != ftIndividualProductSavingIdList && ftIndividualProductSavingIdList.size() > 0) {
		   	if (null != session.getAttribute("ftIndividualProductImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualProductImageList = (ArrayList) session.getAttribute("ftIndividualProductImageListInSn"); if (null != ftIndividualProductImageList && ftIndividualProductImageList.size() > 0) {
           	if (null != session.getAttribute("ftIndividualProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualProductNameList = (ArrayList) session.getAttribute("ftIndividualProductNameListInSn"); if (null != ftIndividualProductNameList && ftIndividualProductNameList.size() > 0) {
           	if (null != session.getAttribute("ftIndividualProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualProductPriceList = (ArrayList) session.getAttribute("ftIndividualProductPriceListInSn"); if (null != ftIndividualProductPriceList && ftIndividualProductPriceList.size() > 0) {
           	if (null != session.getAttribute("ftIndividualProductQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualProductQuantityList = (ArrayList) session.getAttribute("ftIndividualProductQuantityListInSn"); if (null != ftIndividualProductQuantityList && ftIndividualProductQuantityList.size() > 0) {
           	if (null != session.getAttribute("ftIndividualRemainingQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualRemainingQuantityList = (ArrayList) session.getAttribute("ftIndividualRemainingQuantityListInSn"); if (null != ftIndividualRemainingQuantityList && ftIndividualRemainingQuantityList.size() > 0) {
          	if (null != session.getAttribute("ftIndividualGivenQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualGivenQuantityList = (ArrayList) session.getAttribute("ftIndividualGivenQuantityListInSn"); if (null != ftIndividualGivenQuantityList && ftIndividualGivenQuantityList.size() > 0) {
            if (null != session.getAttribute("ftIndividualPaymentStatusListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualPaymentStatusList = (ArrayList) session.getAttribute("ftIndividualPaymentStatusListInSn"); if (null != ftIndividualPaymentStatusList && ftIndividualPaymentStatusList.size() > 0) {            	
        %>                
        <% 	
        	for(int i = 0; i < ftIndividualProductSavingIdList.size(); i++) { byte[] ftIndividualProductImageByte = (byte[]) ftIndividualProductImageList.get(i); String ftIndividualProductImage = null;
	        	if(null != ftIndividualProductImageByte) { String ftIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(ftIndividualProductImageByte); ftIndividualProductImage = "data:image/jpg;base64," +ftIndividualProductImageB64; } int ftIndividualRemainingQuantityInt = 0;
	        	if(null != ftIndividualRemainingQuantityList.get(i)) { ftIndividualRemainingQuantityInt = (Integer) ftIndividualRemainingQuantityList.get(i); }
	        	String ftIndividualPaymentStatus = (String) ftIndividualPaymentStatusList.get(i); int ftIndividualPaymentQuantity = (Integer) ftIndividualGivenQuantityList.get(i); int ftIndividualPaymentQuantityInt = 1;
	        	if(ftIndividualPaymentQuantity > 0) { ftIndividualPaymentQuantityInt = ftIndividualPaymentQuantity; }
	        	double ftIndividualProductPriceDb = Double.parseDouble((String) ftIndividualProductPriceList.get(i)); String ftIndividualProductPriceSt = String.format("%,.2f", ftIndividualProductPriceDb);	        	
        %>        
<!-- Finishing Touches Individual Products Completed Payment-->       
        <% if(ftIndividualRemainingQuantityInt > 0) { %>        
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
		<% if(!("Individual Payment").equals(ftIndividualPaymentStatus)) { %> <input type="image" value="submit" src="resources/images/red_close_button.png" onMouseOver="this.src='resources/images/red_close_button.png'" class="delete_button_display_cl" title="Delete" onclick="return selectedFTIndividualInfoDelete(<%=ftIndividualProductSavingIdList.get(i)%>);" > <% } %>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=ftIndividualProductImage%>" width="219px" height="220px"> </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=ftIndividualProductNameList.get(i)%></div> </div> 
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=ftIndividualProductPriceSt%></font></div>
					<table class="top_adjustment_6"> <tr><td align="left" class="reg_bott_very_small_text_dsp">REQUESTED:&nbsp;<font class="rln_con_all_boldtxt_dsp"><%=ftIndividualProductQuantityList.get(i)%></font></td> <td align="right" class="reg_bott_very_small_text_dsp">STILL NEED:&nbsp;<font class="rln_con_all_boldtxt_dsp"><%=ftIndividualRemainingQuantityInt%></font></td></tr> </table> </div>						
					<div align="center" class="rln_con_ind_htmt_dsp"> <table> <tr><td><input type="text" name="productQuantity" maxLength="2" id="conBoardProductQuantityId<%=ftIndividualProductSavingIdList.get(i)%>" value="<%=ftIndividualPaymentQuantityInt%>" class="reg_bott_quentity_field_cl" onkeypress="return numeralsOnly(event);">&nbsp;&nbsp;&nbsp;</td> <td><h4><button class="reg_bott_funds_sub_Butt" onclick="return selectedFTIndividualInfoAddToCart(<%=ftIndividualProductSavingIdList.get(i)%>, <%=ftIndividualRemainingQuantityInt%>);">ADD TO CART</button></h4></td></tr> </table> </div>
					<div class="top_adjustment_8" align="right"> <form action="editFinishingTouchesIndividualProduct"><input type='submit' class="regi_bott_funds_link_edit" value="EDIT"><input type="hidden" name="regFTIndividualProductSavingId" value="<%=ftIndividualProductSavingIdList.get(i)%>"> </form> </div> </div> </div> </div> </div>   		
   		<% } else { %>   		
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp">
				<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=ftIndividualProductImage%>" width="219px" height="220px"> </div> </div>
				<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=ftIndividualProductNameList.get(i)%></div> </div>						
					<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text rln_con_all_opat_dsp">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=ftIndividualProductPriceSt%></font></div>
					<table class="top_adjustment_6"> <tr><td align="left" class="reg_bott_very_small_text_dsp">REQUESTED:&nbsp;<font class="rln_con_all_boldtxt_dsp"><%=ftIndividualProductQuantityList.get(i)%></font></td> <td align="right" class="reg_bott_very_small_text_dsp">STILL NEED:&nbsp;<font class="rln_con_all_boldtxt_dsp"><%=ftIndividualRemainingQuantityInt%></font></td></tr> </table> </div>						
					<div align="center" class="rln_con_addct_ht_dsp"> <table> <tr><td><input type="text" name="productQuantity" id="conBoardProductQuantityId" value="1" class="reg_bott_quentity_field_cl rln_con_ind_opc_dsp">&nbsp;&nbsp;&nbsp;</td> <td><h4><button class="reg_bott_funds_sub_Butt">ADD TO CART</button></h4></td></tr> </table> </div>
					<div class="top_adjustment_8" align="right"> <input type='submit' class="reg_funds_link_edit_dark" value="EDIT"> </div> </div> </div> </div> </div>   		
        <% } } } } } } } } } } } } } } } } } } %>
		</div>		
<!-- Finishing Touches Individual Products Display Coding End-->


	 
	  	</div> </div> <div class="col-md-1 col-sm-1"></div> </div>                   
<!-- SELECTED GIFT CARDS COADING END -->	    	
		</div></div>				  
        <div id="boxes"> <div class="rln_popup_frame_dsp" id="mask"> </div> <div align="center" style="padding: 20px; display: none;  width: 760px; z-index: 10001; overflow-y: hidden; position:fixed; left: 50%; top: 50%; -ms-transform: translate(-50%,-50%); -moz-transform:translate(-50%,-50%); -webkit-transform: translate(-50%,-50%); transform: translate(-50%,-50%);" id="dialog" class="window"> <div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" class="rln_pop_cl_img_adj"></a></div> <div class="rln_pop_uplph_txt_cl">Upload Your Photo</div>    	
		<div id="lorem" class="rln_pop_pad_adj"> <form action="uploadRegistrantProfile?uploadImgReferance=landingImageUpload" method="POST" enctype="multipart/form-data">
		<table class="rln_pop_table_frm_adj"> <tbody><tr><td><input type="file" onchange="readURL(event)" name="regPhotoUpload" id="fileUpload" title="Click here to browse your photo." class="rln_pop_table_bgc_cl"></td></tr>
		<tr class="rln_pop_tr_heights_cl"><td></td></tr> <tr><td><font>You can upload a JPG, JPEG, BMP, HEIC, HEIF, GIF, or PNG file.</font></td></tr> <tr class="rln_pop_tr_heights_cl"><td></td></tr> <tr><td>This image can be seen by any guest on our website viewing or searching for your registry.</td></tr> <tr class="rln_pop_tr_heightm_cl"><td></td></tr> <tr><td><input type="checkbox" name="accept" id="accept"> <div class="rln_pop_mlt_txt_cl">I own the image I am uploading and confirm that this image compiles with the <br>NOOK + COVE Upload Terms of Use.</div></td></tr> <tr class="rln_pop_tr_heighth_cl"><td></td></tr> <tr><td><button class="uploaded_submit_Btn_for_regi" id="photoUploadBut">UPLOAD</button></td></tr> <tr class="rln_pop_tr_heightvs_cl"><td></td></tr> </tbody></table> </form> </div> </div> </div>		
		
		<script type="text/javascript" src="resources/js/registry/registry_landing.js"></script>
		<script type="text/javascript" src="resources/js/file_upload.js"></script>
		<script type="text/javascript" src="resources/js/json-minified.js"></script>
		</body>
</html>
