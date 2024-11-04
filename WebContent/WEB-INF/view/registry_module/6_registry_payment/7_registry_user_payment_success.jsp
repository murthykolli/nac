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
    .order_number_text_dsp { font: bold 1.06em/1.25em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; vertical-align: middle; margin-left: -10px; padding-bottom: 10px; }
    .order_number_first_text_dsp { font: bold 1.25em/1.25em Georgia; letter-spacing: 2px; color: black; }    
    .heading_sub_text_dsp { font: 1.06em/1.25em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; vertical-align: middle; margin-left: -10px; padding-bottom: 10px; }
    .heading_sub_first_text_dsp { font: 1.35em/1.25em Georgia; letter-spacing: 2px; color: black; }    
    .main_heading_text_dsp { font: bold 1.8em/1.25em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; vertical-align: middle; margin-left: -10px; padding-bottom: 10px; }
    .main_heading_first_text_dsp { font: bold 1.4em/1.25em Georgia; letter-spacing: 2px; color: black; }    
    .sub_total_text_dsp { font: 500 1.08em/1.5em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; }    
    .reg_home_Butn_dspl { display: block; margin: 0px auto; vertical-align: middle; background-color: red; color: white; display: inline-block; padding: 7px 30px; outline: none; border: none; font: 500 1.2em/1.5em Georgia; letter-spacing: 3px; margin-left: -10px; }
	.reg_home_Butn_dspl:hover { background-color: #2c2c2c; }
    </style>    	
	<script type="text/javascript">
 	$(document).ready(function() { var paymentOrderNumber1 = '<c:out value="${paymentOrderNumber}"/>';
	    if(paymentOrderNumber1 !== "") { $("#orderNumberDisplayId").show(); $("#totalPriceDisplayId").show(); } else { $("#orderNumberDisplayId").hide(); $("#orderNumberDisplayId").show(); }
	}); 	
    </script>	
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">
        <div class="row"> <div class="col-md-12 col-sm-12" style="margin-left: 30px;">
	    <div class="row top_adjustment_30"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" class="main_heading_text_dsp"><font class="main_heading_first_text_dsp">T</font>HANK YOU FOR YOUR ORDER!</div> </div> </div> </div> </div>
		<div class="row" style="margin-top: -8px;"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" class="heading_sub_text_dsp"><font class="heading_sub_first_text_dsp">Y</font>OU WILL RECEIVE AN EMAIL SHORTLY WITH A RECEIPT FOR THIS ORDER.</div> </div> </div> </div> </div> </div> </div>
        <div class="row"> <div class="col-md-6 col-sm-6" style="margin-left: 30px;">
	    <div class="row top_adjustment_25" style="display: none;" id="orderNumberDisplayId">
		<div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" class="order_number_text_dsp"><font class="order_number_first_text_dsp">O</font>RDER <font class="order_number_first_text_dsp">N</font>UMBER:&nbsp;${paymentOrderNumber}</div> </div> </div> </div> </div>		
<!-- Cart Total Value Code -->
	 	<div class="row top_adjustment_20" style="display: none;" id="totalPriceDisplayId">	        	
		<div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" style="margin-left: -10px;"><div class="sub_total_text_dsp">TOTAL PAYMENT:&nbsp;$${totalPaybleAmountForEmailInSn}</div></div> </div> </div> </div> </div> 
		<div class="row top_adjustment_60"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div align="left" class="service-description">
        <form action="registryOverview">
        <h4> <button class="reg_home_Butn_dspl" id="createRegistryButtonId">Back to Registry</button> </h4>
		</form> </div> </div> </div> </div> </div>		
		<div class="col-md-6 col-sm-6"></div> </div>		
		<% 
			session.setAttribute("totalPaybleAmountForEmailInSn", null); session.setAttribute("cbContributedPaymentSavingIdListInSn", null); session.setAttribute("cbIndividualPaymentSavingIdListInSn", null);
		%>        				          
        </div> </div>        
		</body>
</html>