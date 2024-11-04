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
		<div class="top_adjustment_10"><a href="regiGiftsReceivedDsp" class="regi_prof_left_link_text_dspl">GIFTS RECEIVED</a></div>
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>
<!-- Left Code End -->
	    <div class="col-md-9 col-sm-9" id="notVisibleMyOrderId" style="display: none;">	        	        	
<!-- No register heading text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Room Funds</h2></div> </div> </div> </div> </div> </div>
<!-- No register text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><p class="regi_prof_left_sub_nor_text">You have not received any contributions towards any room funds yet.</p></div> </div> </div> </div> </div> </div> </div>
<!-- Visible My Order display -->
		<div class="col-md-9 col-sm-9" id="visibleMyOrderId" style="display: none; border-left: 1px solid red; margin-left: -1px; padding-bottom: 40px;">
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Room Funds</h2></div> </div> </div> </div> </div> </div> 
		<div class="row" style="width: 800px; margin-left: 50px; margin-top: 30px; padding: 10px;">
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">GIFT</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">FROM</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">DATE</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">AMOUNT</div> </div> </div> </div> </div>	    
	    <div class="row" style="width: 800px; margin-left: 50px;"><div class="red_my_cart_for_guest_div_bar"></div></div>			   	       
<!-- Guest Coding Display -->				 		
	 	<% 	int guestTotalPrice = 0; String guestRoomFundsPaymentInfo = (String)session.getAttribute("guestRoomFundsPaymentInfoSn");
			if (null != guestRoomFundsPaymentInfo) { String[] guestRoomFundsPaymentSt = guestRoomFundsPaymentInfo.split("_&&_");
				for (int i = 0; i < guestRoomFundsPaymentSt.length; i++) { String[] guestRoomFundsPaymentStList = guestRoomFundsPaymentSt[i].split("_&_"); String guestFromName = guestRoomFundsPaymentStList[1]; String guestStDate = guestRoomFundsPaymentStList[2]; String[] guestRoomPayInfoList = guestRoomFundsPaymentStList[0].split("__");
					for (int l = 0; l < guestRoomPayInfoList.length; l++) { String[] guestRoomPayInfoSt = guestRoomPayInfoList[l].split(",_,"); String guestSpaceImage = guestRoomPayInfoSt[0]; String guestSpaceName = guestRoomPayInfoSt[1]; double regRoomPriceDb = Double.parseDouble(guestRoomPayInfoSt[2]); String guestSpacePrice = String.format("%.2f", regRoomPriceDb);
						if(guestRoomPayInfoSt[2] != null) { int guestProdAmount = Integer.parseInt(guestRoomPayInfoSt[2]); guestTotalPrice = guestTotalPrice + guestProdAmount; }							
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img align="middle" src="resources/images/registry/roomandfundimages/<%=guestSpaceImage%>" style="object-fit: scale-down; width: 100px;"></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestSpaceName%></div></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestFromName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestStDate%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=guestSpacePrice%></div></div> </div> </div> </div> </div> 
		<% } } } double regiTotRoomPriceDb = Double.valueOf(guestTotalPrice); String totalAmount = String.format("%.2f", regiTotRoomPriceDb); %>
		<div class="row red_my_acc_guest_bott_div_bar" style="width: 800px; margin-left: 50px;"> <div class="col-md-6 col-sm-6"> </div> 
																
		<div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div style="height: 72px;"><div align="center" class="my_acc_room_fund_red_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">TOTAL ROOM <br>FUNDS AVAILABLE</div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 72px;"><div align="center" class="my_acc_room_fund_red_price_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=totalAmount%></div></div> </div> </div> </div> </div> </div> </div> </div> </div>		     
		</body>
</html>