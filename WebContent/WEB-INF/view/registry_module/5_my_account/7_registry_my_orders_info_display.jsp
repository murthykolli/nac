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
	.cl_add_cart_prod_img_disy_div_res { width: 130px; min-height: 60px; object-fit: scale-down; position: relative; object-position: 50% 50%; overflow: auto; overflow-y: hidden; }
	</style>	
	<script type="text/javascript">
 	$(document).ready(function() { var regSuccSave1 = "<c:out value="${regSuccSave}"/>";		
	    if(regSuccSave1 == "Have Order"){ $("#visibleMyOrderId").show(); $("#notVisibleMyOrderId").hide(); } else { $("#notVisibleMyOrderId").show(); $("#visibleMyOrderId").hide(); } });
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
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">MY ORDERS</a></div>
		<div class="top_adjustment_10"><a href="regiGiftsReceivedDsp" class="regi_prof_left_link_text_dspl">GIFTS RECEIVED</a></div>
		<div class="top_adjustment_10"><a href="regiRoomFundsDsp" class="regi_prof_left_link_text_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
	    <div class="col-md-9 col-sm-9" id="notVisibleMyOrderId" style="display: none;">	        	        	
<!-- No register heading text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>My Orders</h2></div> </div> </div></div></div> </div>
<!-- No register text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><p class="regi_prof_left_sub_nor_text">You have not placed any orders yet. Go ahead and give yourself a gift!</p></div> </div> </div></div></div> </div>					
<!-- No register button display -->
		<div class="row top_adjustment_40"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<form action="registryOverview">
		<div align="left"> <table><tr><td><h4><button class="reg_profile_save_subt_Btn" id="eventInfoChangesButtId">SHOP REGISTRY</button></h4></td></tr> </table> </div>
		</form> </div></div></div> </div> </div>			
<!-- Visible My Order display -->
		<div class="col-md-9 col-sm-9" id="visibleMyOrderId" style="display: none; border-left: 1px solid red; margin-left: -1px; padding-bottom: 40px;">
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>My Orders</h2></div> </div> </div></div></div> </div>
		<div class="row" style="width: 800px; margin-left: 50px; margin-top: 15px; padding: 10px;"> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">GIFT</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">AMOUNT</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">DATE</div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> <div align="center" class="my_acc_room_cash_fund_hd_dsp">ORDER NUMBER</div> </div> </div> </div> </div> 	    
	    <div class="row" style="width: 800px; margin-left: 50px;"><div class="red_my_cart_for_guest_div_bar"></div></div>			
<!-- Concept Boards Contributed Products My Account Payment Display Coding-->			
		<% 
		   	if (null != session.getAttribute("regCBContributedProductIdsList")) { @SuppressWarnings("rawtypes") ArrayList regiCBContributedProductIdsList = (ArrayList) session.getAttribute("regCBContributedProductIdsList"); if (null != regiCBContributedProductIdsList && regiCBContributedProductIdsList.size() > 0) {		
		   	if (null != session.getAttribute("regCBContributedProductImageList")) { @SuppressWarnings("rawtypes") ArrayList regiCBContributedProductImageList = (ArrayList) session.getAttribute("regCBContributedProductImageList"); if (null != regiCBContributedProductImageList && regiCBContributedProductImageList.size() > 0) {
           	if (null != session.getAttribute("regCBContributedProductNameList")) { @SuppressWarnings("rawtypes") ArrayList regiCBContributedProductNameList = (ArrayList) session.getAttribute("regCBContributedProductNameList"); if (null != regiCBContributedProductNameList && regiCBContributedProductNameList.size() > 0) {
           	if (null != session.getAttribute("regCBContributedProductAmountList")) { @SuppressWarnings("rawtypes") ArrayList regiCBContributedProductAmountList = (ArrayList) session.getAttribute("regCBContributedProductAmountList"); if (null != regiCBContributedProductAmountList && regiCBContributedProductAmountList.size() > 0) {
           	if (null != session.getAttribute("regCBContributedProductQuantityList")) { @SuppressWarnings("rawtypes") ArrayList regiCBContributedProductQuantityList = (ArrayList) session.getAttribute("regCBContributedProductQuantityList"); if (null != regiCBContributedProductQuantityList && regiCBContributedProductQuantityList.size() > 0) {
           	if (null != session.getAttribute("regCBContributedProductStartDateList")) { @SuppressWarnings("rawtypes") ArrayList regiCBContributedProductStartDateList = (ArrayList) session.getAttribute("regCBContributedProductStartDateList"); if (null != regiCBContributedProductStartDateList && regiCBContributedProductStartDateList.size() > 0) {
           	if (null != session.getAttribute("regCBContributedProductOrderNoList")) { @SuppressWarnings("rawtypes") ArrayList regiCBContributedProductOrderNoList = (ArrayList) session.getAttribute("regCBContributedProductOrderNoList"); if (null != regiCBContributedProductOrderNoList && regiCBContributedProductOrderNoList.size() > 0) {
        %>		
		<% for(int i=0; i<regiCBContributedProductIdsList.size(); i++) { 
			byte[] cbContributedProductImageByte = (byte[]) regiCBContributedProductImageList.get(i); String cbContributedProductImage = null;
        	if(null != cbContributedProductImageByte) {
        		String cbContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbContributedProductImageByte); cbContributedProductImage = "data:image/jpg;base64," +cbContributedProductImageB64;
        	}
        	double contributedPriceDb = Double.parseDouble((String) regiCBContributedProductAmountList.get(i)); String contributedPriceSt = String.format("%,.2f", contributedPriceDb);
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" class="cl_add_cart_prod_img_disy_div_res" src="<%=cbContributedProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiCBContributedProductNameList.get(i)%></div></div> </div> </div> </div>  						
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=contributedPriceSt%></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiCBContributedProductStartDateList.get(i)%></div></div> </div> </div> </div>  
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiCBContributedProductOrderNoList.get(i)%></div></div> </div> </div> </div>  </div> 
		<% } %>        
        <% } } } } } } } } } } } } } } %>					
<!-- Concept Boards Individual Products My Account Payment Display Coding-->		
		<% 
		   	if (null != session.getAttribute("regCBIndividualProductIdsList")) { @SuppressWarnings("rawtypes") ArrayList regiCBIndividualProductIdsList = (ArrayList) session.getAttribute("regCBIndividualProductIdsList"); if (null != regiCBIndividualProductIdsList && regiCBIndividualProductIdsList.size() > 0) {		
		   	if (null != session.getAttribute("regCBIndividualProductImageList")) { @SuppressWarnings("rawtypes") ArrayList regiCBIndividualProductImageList = (ArrayList) session.getAttribute("regCBIndividualProductImageList"); if (null != regiCBIndividualProductImageList && regiCBIndividualProductImageList.size() > 0) {
           	if (null != session.getAttribute("regCBIndividualProductNameList")) { @SuppressWarnings("rawtypes") ArrayList regiCBIndividualProductNameList = (ArrayList) session.getAttribute("regCBIndividualProductNameList"); if (null != regiCBIndividualProductNameList && regiCBIndividualProductNameList.size() > 0) {
           	if (null != session.getAttribute("regCBIndividualProductAmountList")) { @SuppressWarnings("rawtypes") ArrayList regiCBIndividualProductAmountList = (ArrayList) session.getAttribute("regCBIndividualProductAmountList"); if (null != regiCBIndividualProductAmountList && regiCBIndividualProductAmountList.size() > 0) {
           	if (null != session.getAttribute("regCBIndividualProductStartDateList")) { @SuppressWarnings("rawtypes") ArrayList regiCBIndividualProductStartDateList = (ArrayList) session.getAttribute("regCBIndividualProductStartDateList"); if (null != regiCBIndividualProductStartDateList && regiCBIndividualProductStartDateList.size() > 0) {
           	if (null != session.getAttribute("regCBIndividualProductOrderNoList")) { @SuppressWarnings("rawtypes") ArrayList regiCBIndividualProductOrderNoList = (ArrayList) session.getAttribute("regCBIndividualProductOrderNoList"); if (null != regiCBIndividualProductOrderNoList && regiCBIndividualProductOrderNoList.size() > 0) {
        %>
		<% for(int i=0; i<regiCBIndividualProductIdsList.size(); i++){ 
			byte[] cbIndividualProductImageByte = (byte[]) regiCBIndividualProductImageList.get(i); String cbIndividualProductImage = null;
        	if(null != cbIndividualProductImageByte) {
        		String cbIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbIndividualProductImageByte); cbIndividualProductImage = "data:image/jpg;base64," +cbIndividualProductImageB64;
        	}        	
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;"> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" class="cl_add_cart_prod_img_disy_div_res" src="<%=cbIndividualProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiCBIndividualProductNameList.get(i)%></div></div> </div> </div> </div>  					
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=regiCBIndividualProductAmountList.get(i)%></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiCBIndividualProductStartDateList.get(i)%></div></div> </div> </div> </div>  
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiCBIndividualProductOrderNoList.get(i)%></div></div> </div> </div> </div> </div> 
		<% } %>
        <% } } } } } } } } } } } } %>
        
<!-- Concept Boards Contributed Products My Account Payment Display Coding-->			
		<% 
		   	if (null != session.getAttribute("regFTContributedProductIdsList")) { @SuppressWarnings("rawtypes") ArrayList regiFTContributedProductIdsList = (ArrayList) session.getAttribute("regFTContributedProductIdsList"); if (null != regiFTContributedProductIdsList && regiFTContributedProductIdsList.size() > 0) {		
		   	if (null != session.getAttribute("regFTContributedProductImageList")) { @SuppressWarnings("rawtypes") ArrayList regiFTContributedProductImageList = (ArrayList) session.getAttribute("regFTContributedProductImageList"); if (null != regiFTContributedProductImageList && regiFTContributedProductImageList.size() > 0) {
           	if (null != session.getAttribute("regFTContributedProductNameList")) { @SuppressWarnings("rawtypes") ArrayList regiFTContributedProductNameList = (ArrayList) session.getAttribute("regFTContributedProductNameList"); if (null != regiFTContributedProductNameList && regiFTContributedProductNameList.size() > 0) {
           	if (null != session.getAttribute("regFTContributedProductAmountList")) { @SuppressWarnings("rawtypes") ArrayList regiFTContributedProductAmountList = (ArrayList) session.getAttribute("regFTContributedProductAmountList"); if (null != regiFTContributedProductAmountList && regiFTContributedProductAmountList.size() > 0) {
           	if (null != session.getAttribute("regFTContributedProductQuantityList")) { @SuppressWarnings("rawtypes") ArrayList regiFTContributedProductQuantityList = (ArrayList) session.getAttribute("regFTContributedProductQuantityList"); if (null != regiFTContributedProductQuantityList && regiFTContributedProductQuantityList.size() > 0) {
           	if (null != session.getAttribute("regFTContributedProductStartDateList")) { @SuppressWarnings("rawtypes") ArrayList regiFTContributedProductStartDateList = (ArrayList) session.getAttribute("regFTContributedProductStartDateList"); if (null != regiFTContributedProductStartDateList && regiFTContributedProductStartDateList.size() > 0) {
           	if (null != session.getAttribute("regFTContributedProductOrderNoList")) { @SuppressWarnings("rawtypes") ArrayList regiFTContributedProductOrderNoList = (ArrayList) session.getAttribute("regFTContributedProductOrderNoList"); if (null != regiFTContributedProductOrderNoList && regiFTContributedProductOrderNoList.size() > 0) {
        %>		
		<% for(int i=0; i<regiFTContributedProductIdsList.size(); i++) { 
			byte[] cbContributedProductImageByte = (byte[]) regiFTContributedProductImageList.get(i); String cbContributedProductImage = null;
        	if(null != cbContributedProductImageByte) {
        		String cbContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbContributedProductImageByte); cbContributedProductImage = "data:image/jpg;base64," +cbContributedProductImageB64;
        	}
        	double contributedPriceDb = Double.parseDouble((String) regiFTContributedProductAmountList.get(i)); String contributedPriceSt = String.format("%,.2f", contributedPriceDb);
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" class="cl_add_cart_prod_img_disy_div_res" src="<%=cbContributedProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiFTContributedProductNameList.get(i)%></div></div> </div> </div> </div>  						
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=contributedPriceSt%></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiFTContributedProductStartDateList.get(i)%></div></div> </div> </div> </div>  
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiFTContributedProductOrderNoList.get(i)%></div></div> </div> </div> </div>  </div> 
		<% } %>        
        <% } } } } } } } } } } } } } } %>					
<!-- Concept Boards Individual Products My Account Payment Display Coding-->		
		<% 
		   	if (null != session.getAttribute("regFTIndividualProductIdsList")) { @SuppressWarnings("rawtypes") ArrayList regiFTIndividualProductIdsList = (ArrayList) session.getAttribute("regFTIndividualProductIdsList"); if (null != regiFTIndividualProductIdsList && regiFTIndividualProductIdsList.size() > 0) {		
		   	if (null != session.getAttribute("regFTIndividualProductImageList")) { @SuppressWarnings("rawtypes") ArrayList regiFTIndividualProductImageList = (ArrayList) session.getAttribute("regFTIndividualProductImageList"); if (null != regiFTIndividualProductImageList && regiFTIndividualProductImageList.size() > 0) {
           	if (null != session.getAttribute("regFTIndividualProductNameList")) { @SuppressWarnings("rawtypes") ArrayList regiFTIndividualProductNameList = (ArrayList) session.getAttribute("regFTIndividualProductNameList"); if (null != regiFTIndividualProductNameList && regiFTIndividualProductNameList.size() > 0) {
           	if (null != session.getAttribute("regFTIndividualProductAmountList")) { @SuppressWarnings("rawtypes") ArrayList regiFTIndividualProductAmountList = (ArrayList) session.getAttribute("regFTIndividualProductAmountList"); if (null != regiFTIndividualProductAmountList && regiFTIndividualProductAmountList.size() > 0) {
           	if (null != session.getAttribute("regFTIndividualProductStartDateList")) { @SuppressWarnings("rawtypes") ArrayList regiFTIndividualProductStartDateList = (ArrayList) session.getAttribute("regFTIndividualProductStartDateList"); if (null != regiFTIndividualProductStartDateList && regiFTIndividualProductStartDateList.size() > 0) {
           	if (null != session.getAttribute("regFTIndividualProductOrderNoList")) { @SuppressWarnings("rawtypes") ArrayList regiFTIndividualProductOrderNoList = (ArrayList) session.getAttribute("regFTIndividualProductOrderNoList"); if (null != regiFTIndividualProductOrderNoList && regiFTIndividualProductOrderNoList.size() > 0) {
        %>
		<% for(int i=0; i<regiFTIndividualProductIdsList.size(); i++){ 
			byte[] cbIndividualProductImageByte = (byte[]) regiFTIndividualProductImageList.get(i); String cbIndividualProductImage = null;
        	if(null != cbIndividualProductImageByte) {
        		String cbIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbIndividualProductImageByte); cbIndividualProductImage = "data:image/jpg;base64," +cbIndividualProductImageB64;
        	}        	
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;"> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" class="cl_add_cart_prod_img_disy_div_res" src="<%=cbIndividualProductImage%>" style="object-fit: scale-down; width: 100px;" ></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiFTIndividualProductNameList.get(i)%></div></div> </div> </div> </div>  					
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=regiFTIndividualProductAmountList.get(i)%></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiFTIndividualProductStartDateList.get(i)%></div></div> </div> </div> </div>  
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiFTIndividualProductOrderNoList.get(i)%></div></div> </div> </div> </div> </div> 
		<% } %>
        <% } } } } } } } } } } } } %>
        		
		</div> </div> </div> </div>		     
		</body>
</html>