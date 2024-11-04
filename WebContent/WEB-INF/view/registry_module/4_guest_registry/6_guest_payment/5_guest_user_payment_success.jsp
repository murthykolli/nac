<!DOCTYPE html>
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
	<script type="text/javascript"> history.pushState(null, null, location.href); history.back(); history.forward(); window.onpopstate = function () { history.go(1); }; </script>    
    <style>
    .succ_total_amount_bold_text_dsp { font: bold 1.5em/1.5em Georgia; letter-spacing: 1px; color: black; text-align: center; text-transform: uppercase; vertical-align: middle; }
    .succ_total_amount_nor_text_dsp { font: 1.1em/1.5em Georgia; letter-spacing: 1px; color: black; text-align: right; text-transform: uppercase; vertical-align: middle; }
    .order_number_text_dsp { font: bold 1.06em/1.25em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; vertical-align: middle; margin-left: -10px; padding-bottom: 10px; }
    .order_number_first_text_dsp { font: bold 1.25em/1.25em Georgia; letter-spacing: 2px; color: black; }    
    .heading_sub_text_dsp { font: 1.04em/1.25em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; vertical-align: middle; margin-left: -10px; padding-bottom: 10px; }
    .heading_sub_first_text_dsp { font: 1.25em/1.25em Georgia; letter-spacing: 2px; color: black; }    
    .main_heading_text_dsp { font: bold 1.7em/1.25em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; vertical-align: middle; margin-left: -10px; padding-bottom: 10px; }
    .main_heading_first_text_dsp { font: bold 1.3em/1.25em Georgia; letter-spacing: 2px; color: black; }    
    .sub_total_text_dsp { font: 1.08em/1.5em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; }    
    .reg_home_Butn_dspl { display: block; margin: 0px auto; vertical-align: middle; background-color: red; color: white; display: inline-block; padding: 7px 30px; outline: none; border: none; font: 500 1.2em/1.5em Georgia; letter-spacing: 3px; margin-left: -10px; }
	.reg_home_Butn_dspl:hover { background-color: #2c2c2c; }
    </style>    	
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">        
        <div class="row"> <div class="col-md-12 col-sm-12" style="margin-left: 30px;">
	    <div class="row top_adjustment_30"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" class="main_heading_text_dsp"><font class="main_heading_first_text_dsp">T</font>HANK YOU FOR YOUR ORDER!</div> </div> </div> </div> </div>
		<div class="row" style="margin-top: -5px;"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" class="heading_sub_text_dsp"><font class="heading_sub_first_text_dsp">T</font>HE REGISTRY RECIPIENT(S) WILL RECEIVE AN EMAIL LETTING THEM KNOW ABOUT YOUR GIFT. <font class="heading_sub_first_text_dsp">Y</font>OU WILL ALSO RECEIVE AN EMAIL SHORTLY WITH A RECEIPT FOR THIS ORDER.</div> </div> </div> </div> </div> </div> </div>
        <div class="row"> <div class="col-md-6 col-sm-6" style="margin-left: 30px;">
	    <div class="row top_adjustment_25"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" class="order_number_text_dsp"><font class="order_number_first_text_dsp">O</font>RDER <font class="order_number_first_text_dsp">N</font>UMBER:&nbsp;${paymentOrderNumber}</div> </div> </div> </div> </div>
			
		<div class="row top_adjustment_20"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" style="margin-left: -10px;"><div class="sub_total_text_dsp">TOTAL PAYMENT:&nbsp;$${totalPaybleAmountForEmailInSn}</div></div> </div> </div> </div> </div> 
        <div class="row top_adjustment_60"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div align="left" class="service-description">
        <form action="home">
        <h4> <button class="reg_home_Butn_dspl" id="createRegistryButtonId">HOME</button> </h4>
		</form> </div> </div> </div> </div> </div> <div class="col-md-6 col-sm-6"></div> </div>		
		<% 
			session.setAttribute("guestRoomFundsPaymentInfoInSn", null); session.setAttribute("guestCashFundsPaymentInfoInSn", null); session.setAttribute("guestCustomFundsPaymentInfoInSn", null); session.setAttribute("guestCBContributedPaymentInfoInSn", null); session.setAttribute("guestCBIndividualPaymentInfoInSn", null); session.setAttribute("totalPaybleAmountForEmailInSn", null);
		%>
        </div> </div>        
		</body>
</html>