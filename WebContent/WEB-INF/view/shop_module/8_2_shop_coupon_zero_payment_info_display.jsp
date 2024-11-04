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
	<script type="text/javascript" src="resources/js/reg_guest_billing_validation.js" ></script>
	
	<style type="text/css">
	.shop_checkout_sub_Buttn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; text-transform: uppercase; outline: none; border: none; font: normal 1.05em/2.25em Georgia; letter-spacing: 2px; height: 36px; width: 260px; margin-top: 5px; }
	.shop_checkout_sub_Buttn:hover { background-color: #595959; }
	.reg_terms_policy_txt_dsp { font: 0.85em/1.25em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; }	
	.shop_payment_tbl_adj { width: 360px; text-align: center; }
	.shop_pay_est_pay_frame_dsp { background: #e8e8e8; min-height: 70px; height: auto; width: 420px; padding : 15px; }
	.shop_cart_pay_est_totl { font: 1em/1.25em Georgia; letter-spacing: 1px; color: black; text-align: right; text-transform: uppercase; padding-top: 10px; padding-bottom: 10px; }
	.shop_pay_price_shp_tol { font: bold 1.15em/1.25em Georgia; letter-spacing: 1px; color: black; text-align: right; text-transform: uppercase; padding-top: 10px; padding-bottom: 10px; padding-right: 30px; }
	</style>
	
	<script type="text/javascript">
 	$(document).ready(function() {
	    var payCardNumber1 = '<c:out value="${payCardNumber}"/>'; var payExpMonth1 = '<c:out value="${payExpMonth}"/>'; var payExpYear1 = '<c:out value="${payExpYear}"/>'; var nameOnCard1 = '<c:out value="${nameOnCard}"/>'; var payCvvNumber1 = '<c:out value="${payCvvNumber}"/>'; var ddlYears = $("#payExpYearId"); var currentYear = (new Date()).getFullYear(); 
        for (var i = currentYear; i <= currentYear+50; i++) { var option = $("<option />"); option.html(i); option.val(i); ddlYears.append(option); }	    
	    $("[name=payCardNumber]").val(payCardNumber1); $("[name=payExpMonth]").val(payExpMonth1); $("[name=payExpYear]").val(payExpYear1); $("[name=nameOnCard]").val(nameOnCard1); $("[name=payCvvNumber]").val(payCvvNumber1);
        $('#payCardNumberId').bind("cut copy paste",function(e) { e.preventDefault(); });	    
	    var couponCodeStatus1 = '<c:out value="${couponCodeStatus}"/>';
	    if(couponCodeStatus1 !== "") { $("#couponCodeStatusID").show(); } else { $("#couponCodeStatusID").hide(); }	    
// Package Payment Gift Card validation
        $("#shopPromoCodeButtId").click(function () { var result = true; var promoCodeValue = $("#shopCouponCodeId").val();          
          	if(promoCodeValue === ""){ alert("PLEASE ENTER YOUR GIFT CARD CODE IF YOU HAVE ONE."); result=false; 
          	} else { $("[name=payCardNumber]").val($("#payCardNumberId").val()); $("[name=payExpMonth]").val($("#payExpMonthId").val()); $("[name=payExpYear]").val($("#payExpYearId").val()); $("[name=payCvvNumber]").val($("#payCvvNumberId").val()); $("[name=nameOnCard]").val($("#nameOnCardId").val()); } return result; }); });
    </script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container"> <div class="row"> <div class="col-md-1 col-sm-1"></div>        
	    <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="left" class="red_my_cart_for_guest_ht_dsp">PAYMENT INFO:</div> </div> </div> </div> 
	    <div class="col-md-5 col-sm-5"></div> <div class="col-md-1 col-sm-1"> </div> </div> <div class="row"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> </div> </div> </div> 
        <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="right" class="shpp_right_tb_frame"> <div class="shop_pay_est_pay_frame_dsp" align="center">
		<table class="shop_payment_tbl_adj" style="margin-top: 0px;"> <tr> <td class="shop_cart_pay_est_totl" align="right">TOTAL AMOUNT:</td> <td class="shop_pay_price_shp_tol">$${shopCartTotalProductStAmountInSn}&nbsp;</td> </tr>
		<tr> <td class="shop_cart_pay_est_totl" align="right">DISCOUNT:</td> <td class="shop_pay_price_shp_tol">$${shopCouponCodeStPriceInSn}&nbsp;</td> </tr>
		<tr style="border-bottom: 1px solid black; height: 15px;"> <td></td> <td></td> </tr> <tr style="height: 14px;"> <td></td> <td></td> </tr>
		<tr> <td class="shop_cart_pay_est_totl" align="right">ESTIMATED TOTAL:</td> <td class="shop_pay_price_shp_tol">$${shopCartTotalPayableStAmountInSn}&nbsp;</td> </tr> </table> </div>
		<div class="reg_gp_tos_pp_total_txt_frame_dsp" style="margin-top: 25px;"> <p class="reg_gp_tos_pp_total_txt_dsp">BY CLICKING 'SUBMIT ORDER', I CONFIRM THAT <br>I HAVE READ AND AGREED TO NOOK+COVE'S <br><a href="shopTermsPopupDisplay" target="_blank" class="reg_gp_tos_pp_txt_dsp">TERMS OF SERVICE</a> AND <a href="shopPrivacyPolicyPopup" target="_blank" class="reg_gp_tos_pp_txt_dsp">PRIVACY POLICY</a>.</p> </div>
		<form action="shopCouponZeroPaymentPurchaseToGateway" name="myDesign" method="POST">					
		<div class="top_adjustment_20"><h4><button class="shop_checkout_sub_Buttn" id="guestPaymentInfoButtId">SUBMIT ORDER</button></h4></div>
		<input type="hidden" name="payCardNumber"/> <input type="hidden" name="payExpMonth"/> <input type="hidden" name="payExpYear"/> <input type="hidden" name="payCvvNumber"/> <input type="hidden" name="nameOnCard"/>
		<input type="hidden" name="shopPercentageValue" value="${shopPercentageValue}"/> <input type="hidden" name="shopDiscountPrice" value="${shopDiscountPrice}"/> <input type="hidden" name="shopCouponCodeRef" value="${shopCouponCodeRef}"/> <input type="hidden" name="referralUserDisplayReff" value="${referralUserDisplayReff}"/> </form> </div> </div> </div> </div>  
	    <div class="col-md-1 col-sm-1"> </div> </div> </div> </div> 		     
		</body>
</html>