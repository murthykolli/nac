<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<html>
	<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
	<style type="text/css">
	.reg_transfer_now_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; width: 115px; outline: none; border: none; font: 500 1.2em/1.15em Georgia; letter-spacing: 1px; height: 32px; box-shadow: 2px 5px 5px -3px #292929; }
	.reg_transfer_now_subt_Btn:hover { background-color: #2c2c2c; }
	a.convert_to_store_credit_cl { font: 500 1.1em/1.35em Georgia; letter-spacing: 1px; color: black; text-decoration: underline; cursor: pointer; }
	a.convert_to_store_credit_cl:hover { color: red; text-decoration: underline; cursor: pointer; }
	.reg_cb_disable_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #767171; color: white; display: inline-block; width: 115px; outline: none; border: none; font: 500 1.2em/1.15em Georgia; letter-spacing: 1px; height: 32px; box-shadow: 2px 5px 5px -3px #292929; opacity: 0.7; cursor: not-allowed; }	
	a.track_link_cl { font: italic 1.15em/1.25em Georgia; color: #1560ac; text-decoration: underline; background: white; }
	a.track_link_cl:hover {color: red; text-decoration: underline; }	
	a.con_still_date_dsp_cl { font: 500 1.05em/1.25em Georgia; letter-spacing: 1px; color: black; text-decoration: underline; cursor: pointer; }
	a.con_still_date_dsp_cl:hover { color: red; text-decoration: underline; cursor: pointer; }
	.my_acc_contributed_hd_text_dsp { font: bold 0.98em/1.2em Georgia; letter-spacing: 2px; color: black; vertical-align: middle; }
	.cont_disable_stcre_cl { font: 500 1.05em/1.25em Georgia; letter-spacing: 1px; color: gray; text-decoration: underline; opacity: 0.7; cursor: not-allowed; }
	.concept_board_frame_cl { position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%); }	
	.mytooltip .mytext { visibility: hidden; width: 280px; background-color: #1f4e79; color: #fff; z-index: 1; top: -37px; right: 170%; border-radius: 6px; padding: 16px; position: absolute; font: normal 1.15em/1.35em Georgia; text-align: right; letter-spacing: 1px; box-shadow: -4px 4px #bababa; }
    .mytooltip { position: relative; display: inline-block; margin-left: 50px; } 
    .mytooltip .mytext:after { content: ""; position: absolute; top: 50%; left: 100%; margin-top: -5px; border-width: 6px; border-style: solid; border-color: transparent transparent transparent #3c3c3c; }
    .mytooltip:hover .mytext { visibility: visible; }
	</style>	
	<script type="text/javascript">
 	$(document).ready(function() {
 		var regConBoardAddCartValue = "<c:out value="${regConBoardAddCartValueInSn}"/>"; var guestConBoardAddCartValue = "<c:out value="${guestConBoardAddCartValueInSn}"/>";
 		if((regConBoardAddCartValue == "Have RCB Add Cart Data") || (guestConBoardAddCartValue == "Have GCB Add Cart Data")){ $("#visibleGiftsReceivedId").show(); $("#notVisibleGiftsReceivedId").hide(); $("#notVisibleTipsDspId").hide(); } else { $("#notVisibleGiftsReceivedId").show(); $("#visibleGiftsReceivedId").hide(); $("#notVisibleTipsDspId").show(); }
 		var regConBoardContributeValue = "<c:out value="${regConBoardContributeValueInSn}"/>";
 		if(regConBoardContributeValue == "Have RCB Contribute Data"){ $("#visibleGroupGiftId").show(); $("#notVsibleGroupGiftId").hide(); $("#notVisibleTipsDspId").hide(); } else { $("#notVsibleGroupGiftId").show(); $("#visibleGroupGiftId").hide(); $("#notVisibleTipsDspId").show(); }
 	});
    </script>    
	</head>	
		<body>				
		<div id="mainframe" class="section-content"> <div class="container">      
      	<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="registry_prof_my_acc_title"><h2>MY ACCOUNT</h2></div> </div> </div> </div> </div> </div>
<!-- Left Code Start -->
      	<div class="row top_adjustment_30"> <div class="col-md-3 col-sm-3 regi_prof_left_side_box_dspl"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>ACCOUNT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryMyAccount" class="regi_prof_left_link_text_dspl">CONTACT INFO</a></div>
		<div class="top_adjustment_10"><a href="registryPasswordChange" class="regi_prof_left_link_text_dspl">CHANGE PASSWORD</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>EVENT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryEventInfoChange" class="regi_prof_left_link_text_dspl">EVENT INFO</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>REGISTRY SETTINGS</h3></div>
		<div class="top_adjustment_10"><a href="registryURLInfoChange" class="regi_prof_left_link_text_dspl">URL</a></div>
		<div class="top_adjustment_10"><a href="registryPrivacyInfoChange" class="regi_prof_left_link_text_dspl">PRIVACY</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>GIFT TRACKER</h3></div>
		<div class="top_adjustment_10"><a href="regiShippingInfoDsp" class="regi_prof_left_link_text_dspl">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="regiMyOrderDsp" class="regi_prof_left_link_text_dspl">MY ORDERS</a></div>
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">GIFTS RECEIVED</a></div>
		<div class="top_adjustment_10"><a href="regiRoomFundsDsp" class="regi_prof_left_link_text_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
	    <div class="col-md-9 col-sm-9" style="border-left: 1px solid red; margin-left: -1px; padding-bottom: 30px;">
		<div class="row" id="notVisibleGiftsReceivedId" style="display: none; padding-bottom: 30px;"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Gifts Received</h2></div> </div>
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><p class="regi_prof_left_sub_nor_text">You have not received any gifts yet.</p></div> </div> </div></div></div> </div>							
<!-- Add Cart Code Display -->
		<div class="row" id="visibleGiftsReceivedId" style="display: none; padding-bottom: 30px;"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Gifts Received</h2></div> </div> </div></div></div>
		<div class="row" style="width: 800px; margin-left: 50px; margin-top: 30px; padding: 10px;"> <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">GIFT</div> </div> </div> </div> <div class="col-md-2 col-sm-2"></div>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">AMOUNT</div> </div> </div> </div>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">FROM</div> </div> </div> </div>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">DATE</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">STATUS</div> </div> </div> </div> </div> 	    
        <div class="row" style="width: 800px; margin-left: 50px;"><div class="red_my_cart_for_guest_div_bar"></div></div>				
<!-- Guest Design Curated Concept Boards Add Cart Coding -->						
		<% 
		   	if (null != session.getAttribute("guestConceptBoardPaymentIdsList")) { @SuppressWarnings("rawtypes") ArrayList guestConBoardPaymentIdsList = (ArrayList) session.getAttribute("guestConceptBoardPaymentIdsList"); if (null != guestConBoardPaymentIdsList && guestConBoardPaymentIdsList.size() > 0) {		
		   	if (null != session.getAttribute("guestConceptBoardPaymentImageList")) { @SuppressWarnings("rawtypes") ArrayList guestConBoardPaymentImageList = (ArrayList) session.getAttribute("guestConceptBoardPaymentImageList"); if (null != guestConBoardPaymentImageList && guestConBoardPaymentImageList.size() > 0) {
          	if (null != session.getAttribute("guestConceptBoardPaymentNameList")) { @SuppressWarnings("rawtypes") ArrayList guestConBoardPaymentNameList = (ArrayList) session.getAttribute("guestConceptBoardPaymentNameList"); if (null != guestConBoardPaymentNameList && guestConBoardPaymentNameList.size() > 0) {
           	if (null != session.getAttribute("guestConceptBoardPaymentAmountList")) { @SuppressWarnings("rawtypes") ArrayList guestConBoardPaymentAmountList = (ArrayList) session.getAttribute("guestConceptBoardPaymentAmountList"); if (null != guestConBoardPaymentAmountList && guestConBoardPaymentAmountList.size() > 0) {
            if (null != session.getAttribute("guestConceptBoardPaymentStartDateList")) { @SuppressWarnings("rawtypes") ArrayList guestConBoardPaymentStartDateList = (ArrayList) session.getAttribute("guestConceptBoardPaymentStartDateList"); if (null != guestConBoardPaymentStartDateList && guestConBoardPaymentStartDateList.size() > 0) {               	
           	if (null != session.getAttribute("guestCBNameList")) { @SuppressWarnings("rawtypes") ArrayList guestsCBNameList = (ArrayList) session.getAttribute("guestCBNameList"); if (null != guestsCBNameList && guestsCBNameList.size() > 0) {           	   	
            if (null != session.getAttribute("guestCBGiftReceivedStatusList")) { @SuppressWarnings("rawtypes") ArrayList gustCBGiftReceivedStatusList = (ArrayList) session.getAttribute("guestCBGiftReceivedStatusList"); if (null != gustCBGiftReceivedStatusList && gustCBGiftReceivedStatusList.size() > 0) {               	
            if (null != session.getAttribute("guestGRTrackingLinksList")) { @SuppressWarnings("rawtypes") ArrayList gustGRTrackingLinksList = (ArrayList) session.getAttribute("guestGRTrackingLinksList"); if (null != gustGRTrackingLinksList && gustGRTrackingLinksList.size() > 0) {            	
            if (null != session.getAttribute("guestGRBOTillDatesList")) { @SuppressWarnings("rawtypes") ArrayList gustGRBOTillDatesList = (ArrayList) session.getAttribute("guestGRTrackingLinksList"); if (null != gustGRBOTillDatesList && gustGRBOTillDatesList.size() > 0) {       
        %>
		<% for(int i=0; i<guestConBoardPaymentIdsList.size(); i++) { 
			byte[] cbIndividualProductsImageByte = (byte[]) guestConBoardPaymentImageList.get(i); String cbIndividualProductsImage = null;
        	if(null != cbIndividualProductsImageByte) {
        		String cbIndividualProductsImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbIndividualProductsImageByte); cbIndividualProductsImage = "data:image/jpg;base64," +cbIndividualProductsImageB64;
        	} String guestCBIndGiftRecStatus = (String) gustCBGiftReceivedStatusList.get(i);        	
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;"> <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="concept_board_frame_cl"><img align="middle" src="<%=cbIndividualProductsImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl concept_board_frame_cl"><%=guestConBoardPaymentNameList.get(i)%></div></div> </div> </div> </div> 								
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp concept_board_frame_cl">$<%=guestConBoardPaymentAmountList.get(i)%><%-- <font style="color: #696969;">/<%=guestConBoardPaymentQuantityList.get(i)%></font> --%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl"><%=guestsCBNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl"><%=guestConBoardPaymentStartDateList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<% if(("No Action").equals(guestCBIndGiftRecStatus)) { %>
		<div style="height: 50px; margin-top: 22px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><form action="guestMACBIndividualShopNow"><button class="reg_transfer_now_subt_Btn" onclick="return confirm('Please confirm that you would like us to place the order for this gift at this time.');">Ship Now</button> <input type="hidden" name="guestCBIndividualShopNowRef" value="<%=guestConBoardPaymentIdsList.get(i)%>"> </form> </div></td> <td></td> </tr>
		<tr style="height: 20px;"><td></td></tr>
	    <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><a href="guestMACBIndividualConToStoreCredit?regConToStoreCreditRef=<%=guestConBoardPaymentIdsList.get(i)%>" class="convert_to_store_credit_cl" onclick="return confirm('Please confirm that you would like to convert the total gift amount to store credit at this time.');">Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</a></div></td>
		<td style="position: relative; left: 10px; top: -55px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -40px;"> You can request to have your gift shipped now or you can convert the gift amount to store credit that can be used on Nook+Cove for any product at any time. </span></div> </td> </tr> </tbody> </table> </div>
		<% } else if(("Converted to Store Credit").equals(guestCBIndGiftRecStatus)) { %>
		<div style="height: 50px; margin-top: 48px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=guestCBIndGiftRecStatus%></div></td>
		<td style="position: relative; left: 10px; top: -45px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -20px;"> Your store credit details can be found under the 'Store Credit' tab under 'Gifts' to your left. </span>
		</div></td> </tr> </tbody> </table> </div>
		<% } else if(("Order Processing").equals(guestCBIndGiftRecStatus)) { %>
		<div style="height: 100px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=guestCBIndGiftRecStatus%></div></div>
		<% } else if(("Ordered").equals(guestCBIndGiftRecStatus)) { %>
		<div style="height: 100px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=guestCBIndGiftRecStatus%></div></div>
		<% } else if(("Tracking").equals(guestCBIndGiftRecStatus)) { %>
		<div style="height: 100px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=gustGRTrackingLinksList.get(i)%></div></div>
		<% } else if(("Delivered").equals(guestCBIndGiftRecStatus)) { %>
		<div style="height: 100px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=guestCBIndGiftRecStatus%></div></div>
		<% } else if(("Back Ordered Till").equals(guestCBIndGiftRecStatus)) { %>
		<div style="height: 50px; margin-top: 25px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=guestCBIndGiftRecStatus%>&nbsp;<%=gustGRBOTillDatesList.get(i)%> </div></td> <td></td> </tr>
		<tr style="height: 20px;"><td></td></tr>
	    <tr><td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><a href="guestMACBIndividualConToStoreCredit?regConToStoreCreditRef=<%=guestConBoardPaymentIdsList.get(i)%>" class="con_still_date_dsp_cl" onclick="return confirm('Please confirm that you would like to convert the total gift amount to store credit at this time.');">Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</a></div></td>
		<td style="position: relative; left: 10px; top: -55px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -65px;"> This product is on back order till the date provided. You can either wait for the product to become available or you can convert the gift amount to store credit at this time to shop for something else. </span></div> </td> </tr> </tbody> </table> </div>
		<% } else if(("Converted to Store Credit Due to Out of Stock").equals(guestCBIndGiftRecStatus)) { %>
		<div style="height: 50px; margin-top: 50px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=guestCBIndGiftRecStatus%></div></td>
		<td style="position: relative; left: 10px; top: -100px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -65px;"> This product is no longer in stock therefore the gift amount has been converted into store credit. Generally we replace out of stock products with similar products that can be found in our concept boards. </span> </div></td> </tr> </tbody> </table> </div>
		<% } %> </div> </div> </div> </div> 
		<% } %>
        <% } } } } } } } } } } } } } } } } } } %>			
<!-- Registry Design Curated Concept Boards Add Cart Coding -->			
		<% 
		   	if (null != session.getAttribute("regConceptBoardPaymentIdsList")) { @SuppressWarnings("rawtypes") ArrayList regConctBoardPaymentIdsList = (ArrayList) session.getAttribute("regConceptBoardPaymentIdsList"); if (null != regConctBoardPaymentIdsList && regConctBoardPaymentIdsList.size() > 0) {		
		   	if (null != session.getAttribute("regConceptBoardPaymentImageList")) { @SuppressWarnings("rawtypes") ArrayList regConctBoardPaymentImageList = (ArrayList) session.getAttribute("regConceptBoardPaymentImageList"); if (null != regConctBoardPaymentImageList && regConctBoardPaymentImageList.size() > 0) {
           	if (null != session.getAttribute("regConceptBoardPaymentNameList")) { @SuppressWarnings("rawtypes") ArrayList regConctBoardPaymentNameList = (ArrayList) session.getAttribute("regConceptBoardPaymentNameList"); if (null != regConctBoardPaymentNameList && regConctBoardPaymentNameList.size() > 0) {
           	if (null != session.getAttribute("regConceptBoardPaymentAmountList")) { @SuppressWarnings("rawtypes") ArrayList regConctBoardPaymentAmountList = (ArrayList) session.getAttribute("regConceptBoardPaymentAmountList"); if (null != regConctBoardPaymentAmountList && regConctBoardPaymentAmountList.size() > 0) {
            if (null != session.getAttribute("regConceptBoardPaymentStartDateList")) { @SuppressWarnings("rawtypes") ArrayList regConctBoardPaymentStartDateList = (ArrayList) session.getAttribute("regConceptBoardPaymentStartDateList"); if (null != regConctBoardPaymentStartDateList && regConctBoardPaymentStartDateList.size() > 0) {               	
           	if (null != session.getAttribute("registrantNameList")) { @SuppressWarnings("rawtypes") ArrayList registrantNamesList = (ArrayList) session.getAttribute("registrantNameList"); if (null != registrantNamesList && registrantNamesList.size() > 0) {           	   	
            if (null != session.getAttribute("registrantCBGiftReceivedStatusList")) { @SuppressWarnings("rawtypes") ArrayList regCBGiftReceivedStatusList = (ArrayList) session.getAttribute("registrantCBGiftReceivedStatusList"); if (null != regCBGiftReceivedStatusList && regCBGiftReceivedStatusList.size() > 0) {               	
            if (null != session.getAttribute("regGRTrackingLinksList")) { @SuppressWarnings("rawtypes") ArrayList regiGRTrackingLinksList = (ArrayList) session.getAttribute("regGRTrackingLinksList"); if (null != regiGRTrackingLinksList && regiGRTrackingLinksList.size() > 0) {               	
            if (null != session.getAttribute("regGRBOTillDatesList")) { @SuppressWarnings("rawtypes") ArrayList regiGRBOTillDatesList = (ArrayList) session.getAttribute("regGRBOTillDatesList"); if (null != regiGRBOTillDatesList && regiGRBOTillDatesList.size() > 0) {          
        %>
		<% for(int i=0; i<regConctBoardPaymentIdsList.size(); i++) { 
			byte[] cbIndividualProductImageByte = (byte[]) regConctBoardPaymentImageList.get(i); String cbIndividualProductImage = null;
        	if(null != cbIndividualProductImageByte) {
        		String cbIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbIndividualProductImageByte); cbIndividualProductImage = "data:image/jpg;base64," +cbIndividualProductImageB64;
        	} String regCBIndGiftRecStatus = (String) regCBGiftReceivedStatusList.get(i);        	
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;"> <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="concept_board_frame_cl"><img align="middle" src="<%=cbIndividualProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl"><%=regConctBoardPaymentNameList.get(i)%></div></div> </div> </div> </div> 								
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp concept_board_frame_cl">$<%=regConctBoardPaymentAmountList.get(i)%><%-- <font style="color: #696969;">/<%=regConctBoardPaymentQuantityList.get(i)%></font> --%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl"><%=registrantNamesList.get(i)%></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl"><%=regConctBoardPaymentStartDateList.get(i)%></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<% if(("No Action").equals(regCBIndGiftRecStatus)) { %>
		<div style="height: 50px; margin-top: 22px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><form action="registryMACBIndividualShopNow"><button class="reg_transfer_now_subt_Btn" onclick="return confirm('Please confirm that you would like us to place the order for this gift at this time.');">Ship Now</button> <input type="hidden" name="registryCBIndividualShopNowRef" value="<%=regConctBoardPaymentIdsList.get(i)%>"> </form> </div></td> <td></td> </tr>
		<tr style="height: 20px;"><td></td></tr>
	    <tr><td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><a href="regMACBIndividualConToStoreCredit?regConToStoreCreditRef=<%=regConctBoardPaymentIdsList.get(i)%>" class="convert_to_store_credit_cl" onclick="return confirm('Please confirm that you would like to convert the total gift amount to store credit at this time.');">Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</a></div></td>
		<td style="position: relative; left: 10px; top: -55px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -40px;"> You can request to have your gift shipped now or you can convert the gift amount to store credit that can be used on Nook+Cove for any product at any time. </span></div> </td> </tr> </tbody> </table> </div>					    
		<% } else if(("Converted to Store Credit").equals(regCBIndGiftRecStatus)) { %>
		<div style="height: 50px; margin-top: 48px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=regCBIndGiftRecStatus%></div></td>
		<td style="position: relative; left: 10px; top: -45px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -20px;"> Your store credit details can be found under the 'Store Credit' tab under 'Gifts' to your left. </span> </div></td> </tr> </tbody> </table> </div>
		<% } else if(("Order Processing").equals(regCBIndGiftRecStatus)) { %>
		<div style="height: 100px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=regCBIndGiftRecStatus%></div></div>
		<% } else if(("Ordered").equals(regCBIndGiftRecStatus)) { %>
		<div style="height: 100px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=regCBIndGiftRecStatus%></div></div>
		<% } else if((("Tracking").equals(regCBIndGiftRecStatus))) { %>
		<div style="height: 100px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=regiGRTrackingLinksList.get(i)%></div></div>
		<% } else if((("Delivered").equals(regCBIndGiftRecStatus))) { %>
		<div style="height: 100px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=regCBIndGiftRecStatus%></div></div>
		<% } else if((("Back Ordered Till").equals(regCBIndGiftRecStatus))) { %>					
		<div style="height: 50px; margin-top: 25px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=regCBIndGiftRecStatus%>&nbsp;<%=regiGRBOTillDatesList.get(i)%> </div></td> <td></td> </tr>
		<tr style="height: 20px;"><td></td></tr>
	    <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><a href="regMACBIndividualConToStoreCredit?regConToStoreCreditRef=<%=regConctBoardPaymentIdsList.get(i)%>" class="con_still_date_dsp_cl" onclick="return confirm('Please confirm that you would like to convert the total gift amount to store credit at this time.');">Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</a></div></td>
		<td style="position: relative; left: 10px; top: -55px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -65px;"> This product is on back order till the date provided. You can either wait for the product to become available or you can convert the gift amount to store credit at this time to shop for something else. </span></div> </td> </tr> </tbody> </table> </div>
		<% } else if((("Converted to Store Credit Due to Out of Stock").equals(regCBIndGiftRecStatus))) { %>
		<div style="height: 50px; margin-top: 50px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=regCBIndGiftRecStatus%></div></td>
		<td style="position: relative; left: 10px; top: -100px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -65px;"> This product is no longer in stock therefore the gift amount has been converted into store credit. Generally we replace out of stock products with similar products that can be found in our concept boards. </span> </div></td> </tr> </tbody> </table> </div>
		<% } %>
		</div> </div> </div> </div> 
		<% } %>        
        <% } } } } } } } } } } } } } } } } } } %> </div>												
		<div class="row" id="notVsibleGroupGiftId" style="display: none;">
		<div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Group Gifts</h2></div> </div>
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><p class="regi_prof_left_sub_nor_text">You have not received any contributions towards any group gifts yet.</p></div> </div> </div></div></div> </div>			
<!-- Contribute Code Visible Group Gift display -->			
		<div class="row" id="visibleGroupGiftId" style="display: none; padding-bottom: 30px;"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Group Gifts</h2></div> </div> </div> </div> </div>
		<div class="row" style="width: 800px; margin-left: 50px; margin-top: 30px; padding-bottom: 10px;">
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">GIFT</div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-8 col-sm-8"> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">TOTAL</div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">FROM</div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">DATE</div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp" style="white-space: nowrap;">AMOUNT</div> </div> </div> </div> </div> </div>  
	    <div class="row" style="width: 800px; margin-left: 50px;"><div class="red_my_cart_for_guest_div_bar"></div></div>	        				
<!-- Registry Design Curated Concept Boards Contribute Coding -->						
		<% 
		   	if (null != session.getAttribute("regConceptBoardContributePaymentIdsList")) { @SuppressWarnings("rawtypes") ArrayList regConBoardContributePaymentIdsList = (ArrayList) session.getAttribute("regConceptBoardContributePaymentIdsList"); if (null != regConBoardContributePaymentIdsList && regConBoardContributePaymentIdsList.size() > 0) {		
		   	if (null != session.getAttribute("regConceptBoardContributePaymentImageList")) { @SuppressWarnings("rawtypes") ArrayList regConBoardContributePaymentImageList = (ArrayList) session.getAttribute("regConceptBoardContributePaymentImageList"); if (null != regConBoardContributePaymentImageList && regConBoardContributePaymentImageList.size() > 0) {
           	if (null != session.getAttribute("regConceptBoardContributePaymentNameList")) { @SuppressWarnings("rawtypes") ArrayList regConBoardContributePaymentNameList = (ArrayList) session.getAttribute("regConceptBoardContributePaymentNameList"); if (null != regConBoardContributePaymentNameList && regConBoardContributePaymentNameList.size() > 0) {
            if (null != session.getAttribute("regConceptBoardContributeTotalPriceList")) { @SuppressWarnings("rawtypes") ArrayList regConBoardContributeTotalPriceList = (ArrayList) session.getAttribute("regConceptBoardContributeTotalPriceList"); if (null != regConBoardContributeTotalPriceList && regConBoardContributeTotalPriceList.size() > 0) {
           	if (null != session.getAttribute("regConceptBoardTotalContributedDataList")) { @SuppressWarnings("rawtypes") ArrayList regConBoardTotalContributedDataList = (ArrayList) session.getAttribute("regConceptBoardTotalContributedDataList"); if (null != regConBoardTotalContributedDataList && regConBoardTotalContributedDataList.size() > 0) {          		
            if (null != session.getAttribute("registryAndGuestCBGiftReceivedStatusList")) { @SuppressWarnings("rawtypes") ArrayList regAndGuestCBGiftReceivedStatusList = (ArrayList) session.getAttribute("registryAndGuestCBGiftReceivedStatusList"); if (null != regAndGuestCBGiftReceivedStatusList && regAndGuestCBGiftReceivedStatusList.size() > 0) {               	
            if (null != session.getAttribute("regContGRTrackingLinksList")) { @SuppressWarnings("rawtypes") ArrayList regiContGRTrackingLinksList = (ArrayList) session.getAttribute("regContGRTrackingLinksList"); if (null != regiContGRTrackingLinksList && regiContGRTrackingLinksList.size() > 0) {                   	
            if (null != session.getAttribute("regContGRBOTillDatesList")) { @SuppressWarnings("rawtypes") ArrayList regiContGRBOTillDatesList = (ArrayList) session.getAttribute("regContGRBOTillDatesList"); if (null != regiContGRBOTillDatesList && regiContGRBOTillDatesList.size() > 0) {            	
        %>
		<% for(int i=0; i<regConBoardContributePaymentIdsList.size(); i++) { 
			byte[] cbContributedProductImageByte = (byte[]) regConBoardContributePaymentImageList.get(i); String cbContributedProductImage = null;
        	if(null != cbContributedProductImageByte) {
        		String cbContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbContributedProductImageByte); cbContributedProductImage = "data:image/jpg;base64," +cbContributedProductImageB64;
        	} double totalProductAmountDb = Double.parseDouble((String) regConBoardContributeTotalPriceList.get(i)); String totalProductAmountSt = String.format("%,.2f", totalProductAmountDb);
		%>
		<div class="row" style="width: 800px; margin-left: 50px; border-bottom: 1px solid #696969; padding-top: 30px; padding-bottom: 20px;">
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="concept_board_frame_cl"><img align="middle" src="<%=cbContributedProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl"><%=regConBoardContributePaymentNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp concept_board_frame_cl">$<%=totalProductAmountSt%></div></div> </div> </div> </div> 							
		<div class="col-md-6 col-sm-6">
		<%	String regConBoardTotalContributedDataSt = (String) regConBoardTotalContributedDataList.get(i); String[] regConBoardTotalContDataDspSt = regConBoardTotalContributedDataSt.split("__"); double originalTotalAmountDb = Double.parseDouble((String) regConBoardContributeTotalPriceList.get(i)); String cbButtonStatus = null; double totalContrAmount = 0; String contNoActionDsp = null;
			for(int a=0; a<regConBoardTotalContDataDspSt.length; a++) {
				String[] regConBoardContributedData = regConBoardTotalContDataDspSt[a].split("_,_"); String regFullName = regConBoardContributedData[0]; String regDate = regConBoardContributedData[1]; String regGivenPrice = regConBoardContributedData[2]; String contributedStatusRef = regConBoardContributedData[3]; double remAmount = Double.parseDouble(regGivenPrice); String regGivenPriceSt = String.format("%,.2f", remAmount); totalContrAmount = totalContrAmount + remAmount; String contributedCBStatusCh = (String) regAndGuestCBGiftReceivedStatusList.get(i);
		%>
	 	<div class="row" style="width: auto; margin-left: 0px; border-bottom: 1px solid #999; padding-top: 30px; padding-bottom: 10px">
		<div class="col-md-4 col-sm-4"> <div style="height: 40px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl"><%=regFullName%></div></div> </div> 
		<div class="col-md-4 col-sm-4"> <div style="height: 40px;"><div class="my_acc_room_fund_text_dsp concept_board_frame_cl"><%=regDate%></div></div> </div> 
		<div class="col-md-4 col-sm-4"> <% if(("Converted to Store Credit").equals(contributedCBStatusCh) && ("Converted to Store Credit").equals(contributedStatusRef)) { %>										
		<div style="height: 40px;"><div class="my_acc_room_fund_bold_text_dsp concept_board_frame_cl">
		<div style="margin-top: 0px; font: bold 0.97em/1.15em Georgia; white-space: nowrap; letter-spacing: 0px; text-transform: capitalize; color: #a0a0a0;">Store Credit</div>
		<div style="margin-top: 5px; color: #a0a0a0;">$<%=regGivenPriceSt%></div> </div></div>
		<% } else { contNoActionDsp = "No Action"; %>
		<div style="height: 30px;"><div class="my_acc_room_fund_bold_text_dsp concept_board_frame_cl">$<%=regGivenPriceSt%></div></div>
		<% } %> </div> </div>					 					
		<% } double remainingAmountDb = originalTotalAmountDb - totalContrAmount; String stillNeedContAmount = String.format("%,.2f", remainingAmountDb); String contributedCBStatus = (String) regAndGuestCBGiftReceivedStatusList.get(i); String fullfillContAmount = String.format("%,.2f", totalContrAmount); %>
		<% if(("Converted to Store Credit").equals(contributedCBStatus)) { %>
		<div class="row" style="width: auto; margin-top: 20px;"> <div class="col-md-8 col-sm-8"></div> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description" align="center">
		<% if(("No Action").equals(contNoActionDsp)) { %>
		<div style="height: 60px;">	<div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl" style="font: 500 1.0em/1.5em Georgia;">
		<a href="regMACBContributedConToStoreCredit?regConToStoreCreditRef=<%=regConBoardContributePaymentIdsList.get(i)%>" class="con_still_date_dsp_cl" onclick="return confirm('Please confirm that you would like to convert the total gift amount to store credit at this time.');">Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</a> </div></div>
		<% } else { %>
		<div style="height: 60px;">	<div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl" style="font: 500 1.0em/1.5em Georgia;">
		<div class="cont_disable_stcre_cl" >Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</div> </div></div>
		<% } %> </div> </div> </div> </div>
		<% } else { %>			
		<div class="row" style="width: auto; margin-top: 20px;"> <div class="col-md-8 col-sm-8"> <div class="service-item"> <div class="service-description" align="center">
		<% if(remainingAmountDb > 0) { %>
		<div style="height: 30px;">	<div class="my_acc_contributed_hd_text_dsp" style="position: relative; top: 50%; left: 50%; transform: translate(-50%, -50%);">
		<div align="right">STIL NEED</div> </div></div>	
		<% } else { %>
		<div style="height: 30px;">	<div class="my_acc_contributed_hd_text_dsp" style="position: relative; top: 50%; left: 50%; transform: translate(-50%, -50%);">
		<div align="right"><img src="resources/images/registry/contributed_tick_mark_img.png" style="position: relative; top: -5px;">FULLFILLED</div> </div></div>
		<% } %> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description" align="center">
		<% if(remainingAmountDb > 0) { %>
		<div style="height: 30px;"><div class="my_acc_room_fund_bold_text_dsp concept_board_frame_cl" style="color: red;">$<%=stillNeedContAmount%></div></div>
		<% } else { %>
		<div style="height: 30px;"><div class="my_acc_room_fund_bold_text_dsp concept_board_frame_cl" style="color: black;">$<%=fullfillContAmount%></div></div>
		<% } %> </div> </div> </div> </div>
		<div class="row" style="width: auto; margin-top: 20px;"> <div class="col-md-8 col-sm-8"></div> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description" align="center">
		<% if(("No Action").equals(contributedCBStatus)) { if(remainingAmountDb > 0) {  %>									
		<div style="height: 80px;">	<div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl">
		<div style="margin-top: 30px; margin-bottom: 15px;"><button class="reg_cb_disable_subt_Btn">Ship Now</button></div>
		<a href="regMACBContributedConToStoreCredit?regConToStoreCreditRef=<%=regConBoardContributePaymentIdsList.get(i)%>" class="convert_to_store_credit_cl" onclick="return confirm('Please confirm that you would like to convert the total gift amount to store credit at this time.');">Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</a> </div></div>	
		<% } else { %>									
		<div style="height: 80px; margin-top: 25px; margin-bottom: 5px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><form action="regMACBContributedShopNow"><button class="reg_transfer_now_subt_Btn" onclick="return confirm('Please confirm that you would like us to place the order for this gift at this time.');">Ship Now</button> <input type="hidden" name="regCBContributedShopNowRef" value="<%=regConBoardContributePaymentIdsList.get(i)%>"> </form> </div></td> <td></td> </tr>
		<tr style="height: 20px;"><td></td></tr>
		<tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><a href="regMACBContributedConToStoreCredit?regConToStoreCreditRef=<%=regConBoardContributePaymentIdsList.get(i)%>" class="convert_to_store_credit_cl" onclick="return confirm('Please confirm that you would like to convert the total gift amount to store credit at this time.');">Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</a></div></td>
		<td style="position: relative; left: 10px; top: -55px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -40px;"> You can request to have your gift shipped now or you can convert the gift amount to store credit that can be used on Nook+Cove for any product at any time. </span></div> </td> </tr> </tbody> </table> </div>
		<% } } else if(("Order Processing").equals(contributedCBStatus)) { %>
		<div style="height: 35px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=contributedCBStatus%></div></div>
		<% } else if(("Ordered").equals(contributedCBStatus)) { %>
		<div style="height: 30px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=contributedCBStatus%></div></div>
		<% } else if((("Tracking").equals(contributedCBStatus))) { %>
		<div style="height: 30px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=regiContGRTrackingLinksList.get(i)%></div></div>
		<% } else if((("Delivered").equals(contributedCBStatus))) { %>
		<div style="height: 30px;"><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=contributedCBStatus%></div></div>
		<% } else if((("Back Ordered Till").equals(contributedCBStatus))) { %>
		<div style="height: 80px; margin-top: 25px; margin-bottom: 5px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=contributedCBStatus%>&nbsp;<%=regiContGRBOTillDatesList.get(i)%> </div></td> <td></td> </tr>
		<tr style="height: 20px;"><td></td></tr>
		<tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><a href="regMACBContributedConToStoreCreditInBOTD?regConToStoreCreditRef=<%=regConBoardContributePaymentIdsList.get(i)%>" class="con_still_date_dsp_cl" onclick="return confirm('Please confirm that you would like to convert the total gift amount to store credit at this time.');">Convert&nbsp;&nbsp;To <br>Store&nbsp;&nbsp;Credit</a></div></td>
		<td style="position: relative; left: 10px; top: -55px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -65px;"> This product is on back order till the date provided. You can either wait for the product to become available or you can convert the gift amount to store credit at this time to shop for something else. </span></div> </td> </tr> </tbody> </table> </div>
		<% } else if((("Converted to Store Credit Due to Out of Stock").equals(contributedCBStatus))) { %>
		<div style="height: 60px; margin-top: 60px; margin-bottom: 5px;">
		<table> <tbody> <tr> <td><div class="my_acc_guest_rev_link_bold_text_dsp concept_board_frame_cl"><%=contributedCBStatus%></div></td>
		<td style="position: relative; left: 10px; top: -100px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -65px;"> This product is no longer in stock therefore the gift amount has been converted into store credit. Generally we replace out of stock products with similar products that can be found in our concept boards. </span> </div></td> </tr> </tbody> </table> </div>
		<%  }  %>	
		</div> </div> </div> </div>
	    <% } %> </div> </div>				
		<% } %>                
        <% } } } } } } } } } } } } } } } } %> </div>
<!-- Tips Code Display -->	           
		<div class="row top_adjustment_70" id="notVisibleTipsDspId" style="display: none; padding-bottom: 50px;">
		<div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="my_acc_tips_box_sh_dsp">
		<div class="my_acc_tips_box_hd_text_dsp">Tips:</div>
		<div class="my_acc_tips_box_sub_text_dsp">1.&nbsp;&nbsp;&nbsp;Make sure your registry is visible to guests by checking your &nbsp;&nbsp;&nbsp;<a href="registryPrivacyInfoChange" class="my_acc_tips_box_sub_text_link_dsp">Privacy Settings</a></div>
		<div class="my_acc_tips_box_sub_text_dsp">2.&nbsp;&nbsp;&nbsp;Make sure you are sharing the correct URL with your guests.</div>
		<div class="my_acc_tips_box_sub_text_dsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Check your registry's &nbsp;&nbsp;&nbsp;<a href="registryURLInfoChange" class="my_acc_tips_box_sub_text_link_dsp">URL</a></div> </div> </div> </div> </div> </div> </div> 							
		</div> </div> </div> </div>		     
		</body>
</html>