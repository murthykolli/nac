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
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
    <link rel="stylesheet" href="resources/css/popup/lightbox.css" media="screen"/>    
	<style type="text/css">
	.reg_transfer_now_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; padding: 7px 18px; outline: none; border: none; font: 500 1.25em/1.15em Georgia; letter-spacing: 2px;  box-shadow: 2px 3px #888888; }
	.reg_transfer_now_subt_Btn:hover { background-color: #2c2c2c; }
	.reg_add_bank_acc_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; padding: 7px 18px; outline: none; border: none; font: 500 1.05em/1.15em Georgia; letter-spacing: 2px;  box-shadow: 2px 3px #888888; }
	.reg_add_bank_acc_subt_Btn:hover { background-color: #2c2c2c; }
	a.reg_ma_add_bank_acc_cl { font: 500 0.90em/1.15em Georgia; letter-spacing: 2px; color: black; text-decoration: underline; cursor: pointer; }
	a.reg_ma_add_bank_acc_cl:hover { color: red; text-decoration: underline; cursor: pointer; }	
	.mytooltip .mytext { visibility: hidden; width: 280px; background-color: #1f4e79; color: #fff; z-index: 1; top: -37px; right: 170%; border-radius: 6px; padding: 16px; position: absolute; font: normal 1.15em/1.35em Georgia; text-align: left; letter-spacing: 1px; box-shadow: -4px 4px #bababa; }
    .mytooltip { position: relative; display: inline-block; margin-left: 50px; } 
    .mytooltip .mytext:after { content: ""; position: absolute; top: 50%; left: 100%; margin-top: -5px; border-width: 6px; border-style: solid; border-color: transparent transparent transparent #3c3c3c; }
    .mytooltip:hover .mytext { visibility: visible; }    
	</style>	
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
		<div class="top_adjustment_10"><a href="regiRoomFundsDsp" class="regi_prof_left_link_text_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
        <div class="col-md-9 col-sm-9" id="notVisibleMyOrderId" style="display: none;">	        	        	
<!-- No register heading text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Cash Funds</h2></div> </div> </div></div></div> </div>
<!-- No register text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><p class="regi_prof_left_sub_nor_text">You have not received any contributions towards any cash funds yet.</p></div> </div> </div></div></div> </div> </div>
<!-- Visible My Order display -->
		<div class="col-md-9 col-sm-9" id="visibleMyOrderId" style="display: none; border-left: 1px solid red; margin-left: -1px; padding-bottom: 40px;">
		<div class="row" style="margin-top: -20px;"> <div class="col-md-6 col-sm-6"> <div align="left"> <div class="registry_prof_title">&nbsp;</div> </div> </div>
		<div class="col-md-6 col-sm-6"> <div align="right"><div><a class="example-image-link reg_ma_add_bank_acc_cl" href="resources/images/cash_fund_images/cash_fund_view_fees.png" data-lightbox="example-1">FEES &amp; INFO</a></div> </div> </div> </div>
		<div class="row" style="margin-top: 15px;"> <div class="col-md-6 col-sm-6"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title"><h2>Cash Funds</h2></div> </div> </div></div></div>
		<div class="col-md-6 col-sm-6"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<form action="regiCashFundsBankAccounts">
		<div align="right"> <div><button class="reg_add_bank_acc_subt_Btn">Add Bank Account</button></div> </div>
		</form> </div></div></div> </div>
		<div class="row" style="width: 800px; margin-left: 50px; margin-top: 30px; padding: 10px;">
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">GIFT</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">AMOUNT</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">FROM</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="my_acc_room_cash_fund_hd_dsp">DATE</div> </div> </div> </div> 					
		<div class="col-md-2 col-sm-2"></div> </div> 	    
	    <div class="row" style="width: 800px; margin-left: 50px;"><div class="red_my_cart_for_guest_div_bar"></div></div>							   	       
<!-- Guest Cash Funds Coding -->				 		
	 	<% 	String guestCashFundsPaymentInfo = (String)session.getAttribute("guestCashFundsPaymentInfoSn");	 		
			if (null != guestCashFundsPaymentInfo) { String[] guestCashFundsPaymentSt = guestCashFundsPaymentInfo.split("__");
				for (int i = 0; i < guestCashFundsPaymentSt.length; i++) {						
					String[] guestCashFundsPaymentStList = guestCashFundsPaymentSt[i].split(",_,"); String guestSpaceImage = guestCashFundsPaymentStList[0]; String guestSpaceName = guestCashFundsPaymentStList[1]; String guestSpacePrice = guestCashFundsPaymentStList[2]; String guestFullName = guestCashFundsPaymentStList[3]; String guestStDate = guestCashFundsPaymentStList[4]; String guestCFStatus = guestCashFundsPaymentStList[5]; String gusCFPaymentInfoSavingId = guestCashFundsPaymentStList[6];
		%>
		<div class="row red_cart_guest_sub_div_bar" style="width: 800px; margin-left: 50px;">
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img src="<%=guestSpaceImage%>" style="object-fit: scale-down; width: 100px;"></div></div> </div> </div> </div>  
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestSpaceName%></div></div> </div> </div> </div> 							
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=guestSpacePrice%></div></div> </div> </div> </div>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestFullName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestStDate%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<% if(("Funds Pending").equals(guestCFStatus)) { %>							
		<div style="height: 100px;"><div align="center" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%); font: bold 0.90em/1.35em Georgia; letter-spacing: 1px; color: black;">
		<table><tr><td>FUNDS<br>PENDING</td>
		<td style="position: relative; left: 10px; top: 8px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -35px;"> It generally takes 2-3 business days for the funds that your guest has gifted you to clear on their end. Once it clears you will be able to transfer those funds to your account. </span> </div></td> </tr></table> </div></div>
		<% } else if(("Transfer Now").equals(guestCFStatus)) { %>
		<form action="guestTransferRequestUpdate"><div style="height: 100px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><button class="reg_transfer_now_subt_Btn" onclick="return confirm('Please confirm that you want to transfer these funds at this time.');">Transfer Now</button></div></div><input type="hidden" name="guestCFPaymentInfoSavingId" value="<%=gusCFPaymentInfoSavingId%>"></form>
		<% } else if(("Transfer Requested").equals(guestCFStatus)) { %>
		<div style="height: 100px;"><div align="center" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%); font: bold 0.90em/1.35em Georgia; letter-spacing: 1px; color: black;">
		<table><tr><td><img src="resources/images/cash_fund_images/cf_transfer_complete_img.png" width="77px" height="70px"></td>
		<td style="position: relative; left: 10px; top: 8px;"><div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer; " class="fa">&#xf059;</i>
		<span class="mytext" style="margin-top: -45px;"> We have received your request and will be initiating the transfer shortly. <br><br> Please allow 3-5 business days for transfers to process and to receive your funds.</span>
		</div></td> </tr></table> </div></div>
		<% } else if(("Transfer Completed").equals(guestCFStatus)) { %>
		<div style="height: 100px;"><div align="center" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%); font: bold 0.90em/1.35em Georgia; letter-spacing: 1px; color: black;">
		<table><tr><td>TRANSFER<br>COMPLETE</td> </tr></table> </div></div>
		<% } %>
		</div> </div> </div> </div> 
		<% } } %>
		</div> </div> </div> </div>		     
		</body>
</html>