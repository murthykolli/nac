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
	<script type="text/javascript">
 	$(document).ready(function() { var regOrderReff1 = "<c:out value="${regiMAOrderReff}"/>"; 		
	    if(regOrderReff1 == "Have Order"){ $("#visibleMyOrderId").show(); $("#notVisibleMyOrderId").hide(); } else { $("#notVisibleMyOrderId").show(); $("#visibleMyOrderId").hide(); } });
    </script>    
	</head>	
		<body>				
		<div id="mainframe" class="section-content"> <div class="container">
       	<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="registry_prof_my_acc_title"><h2>MY ACCOUNT</h2></div> </div> </div> </div> </div> </div>    	
<!-- Left Code Start -->
      	<div class="row top_adjustment_30">
        <div class="col-md-3 col-sm-3 regi_prof_left_side_box_dspl"> <div class="service-item"> <div class="service-description"> <div align="left">        			
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
		<div class="top_adjustment_10"><a href="regiGiftsReceivedDsp" class="regi_prof_left_link_text_dspl">GIFTS RECEIVED</a></div>
		<div class="top_adjustment_10"><a href="regiRoomFundsDsp" class="regi_prof_left_link_text_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>
<!-- Left Code End -->
	    <div class="col-md-9 col-sm-9" id="notVisibleMyOrderId" style="display: none;">	        	        	
<!-- No register heading text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Store Credit</h2></div> </div> </div> </div> </div> </div> 
<!-- No register text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><p class="regi_prof_left_sub_nor_text">You do not have any store credit at this time.</p></div> </div> </div> </div> </div> </div> </div>			
<!-- Visible My Order display -->			
		<div class="col-md-9 col-sm-9" id="visibleMyOrderId" style="display: none; border-left: 1px solid red; margin-left: -1px; padding-bottom: 40px;">
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Store Credit</h2></div> </div> </div> </div> </div> </div> 
		<div class="row" style="width: 800px; margin-left: 50px; margin-top: 30px; padding: 10px;">
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">GIFT</div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"></div>
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">CREDIT</div> </div> </div> </div> </div> 	    
	    <div class="row" style="width: 800px; margin-left: 50px;"><div class="red_my_cart_for_guest_div_bar"></div></div>			   	       
<!-- Cart Sub Heading -->				 		
	 	<% 	String roomFundDataForStoreCredit = (String)session.getAttribute("roomFundDataForStoreCreditSn");
			if (null != roomFundDataForStoreCredit) { String[] roomFundDataForStoreCreditSt = roomFundDataForStoreCredit.split("__");
				for (int i = 0; i < roomFundDataForStoreCreditSt.length; i++) {						
					String[] roomFundDataForStoreCreditList = roomFundDataForStoreCreditSt[i].split(",_,"); String regRoomImage = roomFundDataForStoreCreditList[0]; String regRoomName = roomFundDataForStoreCreditList[1]; double regRoomPriceDb = Double.parseDouble(roomFundDataForStoreCreditList[2]); String regRoomPrice = String.format("%,.2f", regRoomPriceDb);
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" src="resources/images/registry/roomandfundimages/<%=regRoomImage%>" style="object-fit: scale-down; width: 100px;"></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regRoomName%></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=regRoomPrice%></div></div> </div> </div> </div> </div> 
		<% } } %>					   	       

<!-- Registry And Guest Concept Board Individual Coding-->				
		<% 
		   	if (null != session.getAttribute("rgConceptBoardACStoreCreditIdsList")) { @SuppressWarnings("rawtypes") ArrayList rgConBoardACStoreCreditIdsList = (ArrayList) session.getAttribute("rgConceptBoardACStoreCreditIdsList"); if (null != rgConBoardACStoreCreditIdsList && rgConBoardACStoreCreditIdsList.size() > 0) {		
		   	if (null != session.getAttribute("rgConceptBoardACStoreCreditImageList")) { @SuppressWarnings("rawtypes") ArrayList rgConBoardACStoreCreditImageList = (ArrayList) session.getAttribute("rgConceptBoardACStoreCreditImageList"); if (null != rgConBoardACStoreCreditImageList && rgConBoardACStoreCreditImageList.size() > 0) {
           	if (null != session.getAttribute("rgConceptBoardACStoreCreditNameList")) { @SuppressWarnings("rawtypes") ArrayList rgConBoardACStoreCreditNameList = (ArrayList) session.getAttribute("rgConceptBoardACStoreCreditNameList"); if (null != rgConBoardACStoreCreditNameList && rgConBoardACStoreCreditNameList.size() > 0) {
           	if (null != session.getAttribute("rgConceptBoardACStoreCreditAmountList")) { @SuppressWarnings("rawtypes") ArrayList rgConBoardACStoreCreditAmountList = (ArrayList) session.getAttribute("rgConceptBoardACStoreCreditAmountList"); if (null != rgConBoardACStoreCreditAmountList && rgConBoardACStoreCreditAmountList.size() > 0) { 
        %>
		<% for(int i=0; i<rgConBoardACStoreCreditIdsList.size(); i++) { byte[] cbIndividualProductImageByte = (byte[]) rgConBoardACStoreCreditImageList.get(i); String cbIndividualProductImage = null;
        	if(null != cbIndividualProductImageByte) {
        		String cbIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbIndividualProductImageByte); cbIndividualProductImage = "data:image/jpg;base64," +cbIndividualProductImageB64;
        	}					
		%>		
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" src="<%=cbIndividualProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=rgConBoardACStoreCreditNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=rgConBoardACStoreCreditAmountList.get(i)%></div></div> </div> </div> </div> </div> 
		<% } } } } } } } } } %>
			   	       
<!-- Registry And Guest Concept Board Contributed Coding-->				
		<% 
		   	if (null != session.getAttribute("rgConceptBoardContStoreCreditIdsList")) { @SuppressWarnings("rawtypes") ArrayList rgConBoardContStoreCreditIdsList = (ArrayList) session.getAttribute("rgConceptBoardContStoreCreditIdsList"); if (null != rgConBoardContStoreCreditIdsList && rgConBoardContStoreCreditIdsList.size() > 0) {		
		   	if (null != session.getAttribute("rgConceptBoardContStoreCreditImageList")) { @SuppressWarnings("rawtypes") ArrayList rgConBoardContStoreCreditImageList = (ArrayList) session.getAttribute("rgConceptBoardContStoreCreditImageList"); if (null != rgConBoardContStoreCreditImageList && rgConBoardContStoreCreditImageList.size() > 0) {
           	if (null != session.getAttribute("rgConceptBoardContStoreCreditNameList")) { @SuppressWarnings("rawtypes") ArrayList rgConBoardContStoreCreditNameList = (ArrayList) session.getAttribute("rgConceptBoardContStoreCreditNameList"); if (null != rgConBoardContStoreCreditNameList && rgConBoardContStoreCreditNameList.size() > 0) {
           	if (null != session.getAttribute("rgConceptBoardContStoreCreditAmountList")) { @SuppressWarnings("rawtypes") ArrayList rgConBoardContStoreCreditAmountList = (ArrayList) session.getAttribute("rgConceptBoardContStoreCreditAmountList"); if (null != rgConBoardContStoreCreditAmountList && rgConBoardContStoreCreditAmountList.size() > 0) { 
        %>
		<% for(int i=0; i<rgConBoardContStoreCreditIdsList.size(); i++) { byte[] cbContributedProductImageByte = (byte[]) rgConBoardContStoreCreditImageList.get(i); String cbContributedProductImage = null;
        	if(null != cbContributedProductImageByte) { String cbContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbContributedProductImageByte); cbContributedProductImage = "data:image/jpg;base64," +cbContributedProductImageB64;
        	}
		%>		
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" src="<%=cbContributedProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=rgConBoardContStoreCreditNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=rgConBoardContStoreCreditAmountList.get(i)%></div></div> </div> </div> </div> </div> 
		<% } } } } } } } } } %>
		
<!-- Registry And Guest Finishing Touches Individual Coding-->				
		<% 
		   	if (null != session.getAttribute("rgFinishingTouchesACStoreCreditIdsList")) { @SuppressWarnings("rawtypes") ArrayList rgFinTouchesACStoreCreditIdsList = (ArrayList) session.getAttribute("rgFinishingTouchesACStoreCreditIdsList"); if (null != rgFinTouchesACStoreCreditIdsList && rgFinTouchesACStoreCreditIdsList.size() > 0) {		
		   	if (null != session.getAttribute("rgFinishingTouchesACStoreCreditImageList")) { @SuppressWarnings("rawtypes") ArrayList rgFinTouchesACStoreCreditImageList = (ArrayList) session.getAttribute("rgFinishingTouchesACStoreCreditImageList"); if (null != rgFinTouchesACStoreCreditImageList && rgFinTouchesACStoreCreditImageList.size() > 0) {
           	if (null != session.getAttribute("rgFinishingTouchesACStoreCreditNameList")) { @SuppressWarnings("rawtypes") ArrayList rgFinTouchesACStoreCreditNameList = (ArrayList) session.getAttribute("rgFinishingTouchesACStoreCreditNameList"); if (null != rgFinTouchesACStoreCreditNameList && rgFinTouchesACStoreCreditNameList.size() > 0) {
           	if (null != session.getAttribute("rgFinishingTouchesACStoreCreditAmountList")) { @SuppressWarnings("rawtypes") ArrayList rgFinTouchesACStoreCreditAmountList = (ArrayList) session.getAttribute("rgFinishingTouchesACStoreCreditAmountList"); if (null != rgFinTouchesACStoreCreditAmountList && rgFinTouchesACStoreCreditAmountList.size() > 0) { 
        %>
		<% for(int i=0; i<rgFinTouchesACStoreCreditIdsList.size(); i++) { byte[] ftIndividualProductImageByte = (byte[]) rgFinTouchesACStoreCreditImageList.get(i); String ftIndividualProductImage = null;
        	if(null != ftIndividualProductImageByte) {
        		String ftIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(ftIndividualProductImageByte); ftIndividualProductImage = "data:image/jpg;base64," +ftIndividualProductImageB64;
        	}					
		%>		
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" src="<%=ftIndividualProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=rgFinTouchesACStoreCreditNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=rgFinTouchesACStoreCreditAmountList.get(i)%></div></div> </div> </div> </div> </div> 
		<% } } } } } } } } } %>
				   	       
<!-- Registry And Guest Finishing Touches Contributed Coding-->				
		<% 
		   	if (null != session.getAttribute("rgFinishingTouchesContStoreCreditIdsList")) { @SuppressWarnings("rawtypes") ArrayList rgFinTouchesContStoreCreditIdsList = (ArrayList) session.getAttribute("rgFinishingTouchesContStoreCreditIdsList"); if (null != rgFinTouchesContStoreCreditIdsList && rgFinTouchesContStoreCreditIdsList.size() > 0) {		
		   	if (null != session.getAttribute("rgFinishingTouchesContStoreCreditImageList")) { @SuppressWarnings("rawtypes") ArrayList rgFinTouchesContStoreCreditImageList = (ArrayList) session.getAttribute("rgFinishingTouchesContStoreCreditImageList"); if (null != rgFinTouchesContStoreCreditImageList && rgFinTouchesContStoreCreditImageList.size() > 0) {
           	if (null != session.getAttribute("rgFinishingTouchesContStoreCreditNameList")) { @SuppressWarnings("rawtypes") ArrayList rgFinTouchesContStoreCreditNameList = (ArrayList) session.getAttribute("rgFinishingTouchesContStoreCreditNameList"); if (null != rgFinTouchesContStoreCreditNameList && rgFinTouchesContStoreCreditNameList.size() > 0) {
           	if (null != session.getAttribute("rgFinishingTouchesContStoreCreditAmountList")) { @SuppressWarnings("rawtypes") ArrayList rgFinTouchesContStoreCreditAmountList = (ArrayList) session.getAttribute("rgFinishingTouchesContStoreCreditAmountList"); if (null != rgFinTouchesContStoreCreditAmountList && rgFinTouchesContStoreCreditAmountList.size() > 0) { 
        %>
		<% for(int i=0; i<rgFinTouchesContStoreCreditIdsList.size(); i++) { byte[] ftContributedProductImageByte = (byte[]) rgFinTouchesContStoreCreditImageList.get(i); String ftContributedProductImage = null;
        	if(null != ftContributedProductImageByte) { String ftContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(ftContributedProductImageByte); ftContributedProductImage = "data:image/jpg;base64," +ftContributedProductImageB64;
        	}
		%>		
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" src="<%=ftContributedProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=rgFinTouchesContStoreCreditNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=rgFinTouchesContStoreCreditAmountList.get(i)%></div></div> </div> </div> </div> </div> 
		<% } } } } } } } } } %>
		
<!-- Bottom frame code -->		
		<div class="row red_my_acc_guest_bott_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-2 col-sm-2"> </div> 
		<div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description">
		<div style="height: 72px;"><div align="right" class="my_acc_store_credit_text_dsp" style="font: bold 1.08em/1.5em Georgia; letter-spacing: 3px; position: relative; top: 50%; left: 50%; transform: translate(-50%, -50%); color: black;">TOTAL STORE CREDIT</div></div> </div> </div> </div> 
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 72px;"><div align="center" class="my_acc_room_fund_red_price_text_dsp" style="font: bold 1.15em/1.5em Georgia; letter-spacing: 2px; position: relative; top: 50%; left: 50%; transform: translate(-50%, -50%); color: black;">$&nbsp;${allTotalGiftAmount}</div></div> </div> </div> </div> </div> 
		
		<div class="row red_my_acc_guest_bott_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-12 col-sm-12" style="margin-top: 10px;"> <div class="service-item"> <div class="service-description">
		<table> <tbody><tr><td><font style="font: bold 1.7em/1.25em Georgia; letter-spacing: 3px; color: black;">Custom Gift Card Code:</font></td>
		<td><font style="font: bold 1.5em/1.25em Georgia; letter-spacing: 3px; color: #3762af;">&nbsp;&nbsp;${registrantGiftCardCode}</font></td> </tr> </tbody></table> </div> </div> </div> </div> 
		<div class="row" style="width: 800px; margin-left: 50px; margin-top: 15px; padding: 10px;">
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-10 col-sm-10">				
		<div class="row" style="border-bottom: 1px solid #999; padding-bottom: 20px;"> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">&nbsp; <br>DATE</div> </div> </div> </div> 
		<div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">&nbsp; <br>AMOUNT</div> </div> </div> </div> 					
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">CREDIT <br>AVAILABLE</div> </div> </div> </div> </div>
		<div class="row" style="border-bottom: 1px solid #999; padding: 35px 5px;">
		
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center"><div align="center" style="background: #999999; height: 1px; width: 40px; margin-top: 10px;"></div></div> </div> </div> </div> 
		<div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">TOTAL STORE CREDIT</div> </div> </div> </div> 					
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp" style="font: bold 1.1em/1.25em Georgia; letter-spacing: 3px; color: black;">$${totalGiftedAmount}</div> </div> </div> </div> </div>   

<!-- Redeemed Amount Coding Display -->
		<% 	String regiCustomGiftCardUsedData = (String)session.getAttribute("regCustomGiftCardUsedData");	 		
			if (null != regiCustomGiftCardUsedData) { String[] regiCustomGiftCardUsedDataSt = regiCustomGiftCardUsedData.split("__");
				for (int i = 0; i < regiCustomGiftCardUsedDataSt.length; i++) {						
					String[] regiCustomGiftCardUsedDataList = regiCustomGiftCardUsedDataSt[i].split("_,_"); String giftedDate = regiCustomGiftCardUsedDataList[0]; String giftedAmount = regiCustomGiftCardUsedDataList[1];
		%>
		<div class="row" style="border-bottom: 1px solid #999; padding: 35px 5px;">
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp"><%=giftedDate%></div> </div> </div> </div> 
		<div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">REDEEMED AMOUNT</div> </div> </div> </div> 					
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp" style="font: bold 1.1em/1.25em Georgia; letter-spacing: 3px; color: red;">$<%=giftedAmount%></div> </div> </div> </div> </div>
		<% } } %>			
		<div class="row" style="border-bottom: 1px solid #999; padding: 35px 5px;">
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp"></div> </div> </div> </div> 
		<div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp" style="font: bold 1.1em/1.25em Georgia; letter-spacing: 3px; color: black;">REMAINING AMOUNT</div> </div> </div> </div> 					
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp" style="font: bold 1.1em/1.25em Georgia; letter-spacing: 3px; color: black;">$${totalCreditAmount}</div> </div> </div> </div></div> </div> </div> </div> </div> </div> </div>		     
		</body>
</html>