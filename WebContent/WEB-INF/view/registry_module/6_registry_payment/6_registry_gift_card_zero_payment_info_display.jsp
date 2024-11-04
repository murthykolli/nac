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
 	$(document).ready(function() { 		 
	    var payCardNumber1 = '<c:out value="${payCardNumber}"/>'; var payExpMonth1 = '<c:out value="${payExpMonth}"/>'; var payExpYear1 = '<c:out value="${payExpYear}"/>'; var nameOnCard1 = '<c:out value="${nameOnCard}"/>'; var payCvvNumber1 = '<c:out value="${payCvvNumber}"/>'; var ddlYears = $("#payExpYearId"); var currentYear = (new Date()).getFullYear(); 
        for (var i = currentYear; i <= currentYear+50; i++) { var option = $("<option />"); option.html(i); option.val(i); ddlYears.append(option); }
	    $("[name=payCardNumber]").val(payCardNumber1); $("[name=payExpMonth]").val(payExpMonth1); $("[name=payExpYear]").val(payExpYear1); $("[name=nameOnCard]").val(nameOnCard1); $("[name=payCvvNumber]").val(payCvvNumber1);	    	    
	    var giftCardStatus1 = '<c:out value="${giftCardStatus}"/>';
	    if(giftCardStatus1 !== "") { $("#giftCardStatusId").show(); } else { $("#giftCardStatusId").hide(); }	    	    
// Package Payment Gift Card validation
        $("#regiPayGiftCardButtId").click(function (){ var result = true; var giftCodeValue = $("#regGiftCardCouponCodeId").val();          
          	if(giftCodeValue === ""){ alert("PLEASE ENTER YOUR GIFT CARD CODE IF YOU HAVE ONE."); result=false; } else { $("[name=payCardNumber]").val($("#payCardNumberId").val()); $("[name=payExpMonth]").val($("#payExpMonthId").val()); $("[name=payExpYear]").val($("#payExpYearId").val()); $("[name=payCvvNumber]").val($("#payCvvNumberId").val()); $("[name=nameOnCard]").val($("#nameOnCardId").val()); } return result; });
 	}); 	
    </script>
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">        
        <div class="row"> <div class="col-md-1 col-sm-1"></div>
        <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description">
	    <div align="left" class="red_my_cart_for_guest_ht_dsp">PAYMENT INFO:</div> </div> </div> </div> 
	    <div class="col-md-5 col-sm-5"></div> <div class="col-md-1 col-sm-1"></div> </div>	 		 		    
        <div class="row"> <div class="col-md-1 col-sm-1"></div>
        <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="left" style="margin-top: 25px;"> </div> </div> </div> </div> 
        <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="right" class="shpp_right_tb_frame">
		<div class="pay_est_pat_total" style="padding-top: 20px;">
		<table class="paymnt_prs_tbl_adj"> <tr> <td class="gift_cart_pay_est_totl">TOTAL:</td> <td class="gift_pay_price_shp_tol">$${shoppingCartTotalAmountInSn}&nbsp;</td> </tr>
        <tr> <td class="gift_cart_pay_est_totl">GIFT CARD:</td> <td class="gift_pay_price_shp_tol">$${giftCardPrice}&nbsp;</td> </tr> </table>
        <table style="background: black; height: 1px; width: 350px; left: -25px; position: relative; "></table>
        <table class="paymnt_prs_tbl_adj"> <tr> <td class="gift_cart_pay_est_totl">TOTAL AMOUNT:</td> <td class="gift_card_pay_price_shp_tol">$${totalPaybleAmount}&nbsp;</td> </tr> </table> </div>
		<div class="reg_gp_tos_pp_total_txt_frame_dsp" style="margin-top: 25px;"> <p class="reg_gp_tos_pp_total_txt_dsp">BY CLICKING 'SUBMIT ORDER', I CONFIRM THAT <br>I HAVE READ AND AGREED TO NOOK+COVE'S <br><a href="shopTermsPopupDisplay" target="_blank" class="reg_gp_tos_pp_txt_dsp">TERMS OF SERVICE</a> AND <a href="shopPrivacyPolicyPopup" target="_blank" class="reg_gp_tos_pp_txt_dsp">PRIVACY POLICY</a>.</p> </div>
		<form action="registrantGiftCardZeroPaymentPurchaseToGateway" name="myDesign" method="POST">					
		<div class="top_adjustment_20"><h4><button class="reg_box_fund__gs_sub_Buttn" id="guestPaymentInfoButtId">SUBMIT ORDER</button></h4></div>
		<input type="hidden" name="payCardNumber"/> <input type="hidden" name="payExpMonth"/> <input type="hidden" name="payExpYear"/> <input type="hidden" name="payCvvNumber"/> <input type="hidden" name="nameOnCard"/> <input type="hidden" name="giftCardPrice" value="${giftCardPrice}"/> <input type="hidden" name="totalPaybleAmount" value="${shoppingCartTotalAmountStInSn}"/> <input type="hidden" name="regGiftCardCouponCode" value="${regGiftCardCouponCode}"/>			        
		</form> </div> </div> </div> </div> 
	    <div class="col-md-1 col-sm-1"></div> </div>		
		</div> </div>		     
		</body>
</html>