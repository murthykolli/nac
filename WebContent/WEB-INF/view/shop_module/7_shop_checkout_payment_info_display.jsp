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
	</style>
	
	<script type="text/javascript">
 	$(document).ready(function() { var payCardNumber1 = '<c:out value="${payCardNumber}"/>'; var payExpMonth1 = '<c:out value="${payExpMonth}"/>'; var payExpYear1 = '<c:out value="${payExpYear}"/>'; var nameOnCard1 = '<c:out value="${nameOnCard}"/>'; var payCvvNumber1 = '<c:out value="${payCvvNumber}"/>'; var ddlYears = $("#payExpYearId"); var currentYear = (new Date()).getFullYear(); 
    for (var i = currentYear; i <= currentYear+50; i++) { var option = $("<option />"); option.html(i); option.val(i); ddlYears.append(option); }
	$("[name=payCardNumber]").val(payCardNumber1); $("[name=payExpMonth]").val(payExpMonth1); $("[name=payExpYear]").val(payExpYear1); $("[name=nameOnCard]").val(nameOnCard1); $("[name=payCvvNumber]").val(payCvvNumber1);
    $('#payCardNumberId').bind("cut copy paste",function(e) { e.preventDefault(); }); var couponCodeStatus1 = '<c:out value="${couponCodeStatus}"/>';
	if(couponCodeStatus1 !== "") { $("#couponCodeStatusID").show(); } else { $("#couponCodeStatusID").hide(); }	    
// Package Payment Gift Card validation
    $("#shopPromoCodeButtId").click(function () { var result = true; var promoCodeValue = $("#shopCouponCodeId").val();          
   	if(promoCodeValue === "") { alert("PLEASE ENTER YOUR GIFT CARD CODE IF YOU HAVE ONE."); result=false; 
    } else { $("[name=payCardNumber]").val($("#payCardNumberId").val()); $("[name=payExpMonth]").val($("#payExpMonthId").val()); $("[name=payExpYear]").val($("#payExpYearId").val()); $("[name=payCvvNumber]").val($("#payCvvNumberId").val()); $("[name=nameOnCard]").val($("#nameOnCardId").val()); } return result; }); });
    </script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container"> <div class="row"> <div class="col-md-1 col-sm-1"></div>
        <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="left" class="red_my_cart_for_guest_ht_dsp">PAYMENT INFO:</div> </div> </div> </div> 
	    <div class="col-md-5 col-sm-5"></div> <div class="col-md-1 col-sm-1"></div> </div> <div class="row"> <div class="col-md-1 col-sm-1"></div>
        <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="left">
		<img src="resources/images/registry/credit_cards_image.png" style="margin-top: 10px;">
		<div class="shpp_tbl_fld_disp" style="margin-top: 20px;">
		<c:if test="${not empty shopPaymentErrorStatus}"> <tr><td align="left"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;"> &nbsp;&nbsp;&nbsp;&nbsp; ${shopPaymentReturnStatus}</font></td></tr> </c:if>
		<div class="full-width "> <div class="shoop_text_dsp">NAME ON CARD:</div>
        <input type="text" name="nameOnCard" id="nameOnCardId" maxlength="50" class="shpp_inp_box_dsp"> </div>
        <div class="full-width "> <div class="shoop_text_dsp">CARD NUMBER:</div>
        <input type="text" name="payCardNumber" maxlength="16" id="payCardNumberId" class="shpp_inp_box_dsp" onkeypress="return numeralsOnly(event);" onchange="return getCreditCardType();"> </div> </div>
		        				        	
		<div class="card-details"> <div class="expiration-month detail">
		<div class="sec_rnd_exp_month_text_dsp">EXP MONTH:</div>
        <select name="payExpMonth" id="payExpMonthId" class="pay_exp_month_display">
        <option value=''>---Month---</option> <option value='01'>January</option> <option value='02'>February</option> <option value='03'>March</option> <option value='04'>April</option> <option value='05'>May</option> <option value='06'>June</option> <option value='07'>July</option> <option value='08'>August</option> <option value='09'>September</option> <option value='10'>October</option> <option value='11'>November</option> <option value='12'>December</option> </select> </div>
        <div class="expiration-year detail"> <div class="sec_rnd_exp_year_text_dsp">EXP YEAR:</div>
        <select name="payExpYear" id="payExpYearId" class="pay_exp_year_display">
        <option value=''>----Year----</option> </select> </div>
        <div class="cvv-number detail">
        <div class="sec_rnd_cvv_num_text_dsp">CVV NUMBER:</div>
        <input type="password" name="payCvvNumber" maxlength="4" id="payCvvNumberId" class="pay_cvv_numb_display"> </div> </div>
        <form action="shopGiftOrPromoCodePaymentInfo" method="POST">
        <div class="sec_rn_gift_code_frm" style="margin-top: 20px;">
        <div class="promo-code"> <div class="sr_pay_promo_text_dsp">GIFT CARD / PROMO CODE:</div>
        <input type="text" name="shopCouponCode" id="shopCouponCodeId" maxlength="8" class="pack_pay_promo_and_gift_inpt_box"> </div>
        <button class="payment_apply_sub_Btn" id="shopPromoCodeButtId">APPLY&nbsp; CODE</button>
        <div id="couponCodeStatusID" style="display: none;">
        <div class="pay_promo_error_text"><p>THE CODE YOU ENTERED IS NOT VALID OR HAS ALREADY BEEN USED</p></div> <div></div> </div>
        <input type="hidden" name="payCardNumber"/> <input type="hidden" name="payExpMonth"/> <input type="hidden" name="payExpYear"/> <input type="hidden" name="payCvvNumber"/> <input type="hidden" name="nameOnCard"/> </div>
        </form> </div> </div> </div> </div> 
        
		<div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="right" class="shpp_right_tb_frame"> <div class="pay_est_pat_total" style="padding-top: 20px;">
		<table class="paymnt_prs_tbl_adj"> <tr> <td class="spcart_pay_est_totl">ESTIMATED TOTAL:</td> <td class="pay_price_shp_tol">$${shopCartTotalPayableStAmountInSn}&nbsp;</td> </tr> </table> </div>
		<div class="reg_gp_tos_pp_total_txt_frame_dsp" style="margin-top: 25px;"> <p class="reg_gp_tos_pp_total_txt_dsp">BY CLICKING 'SUBMIT ORDER', I CONFIRM THAT <br>I HAVE READ AND AGREED TO NOOK+COVE'S <br><a href="shopTermsPopupDisplay" target="_blank" class="reg_gp_tos_pp_txt_dsp">TERMS OF SERVICE</a> AND <a href="shopPrivacyPolicyPopup" target="_blank" class="reg_gp_tos_pp_txt_dsp">PRIVACY POLICY</a>.</p> </div>
		<form action="shopCartPaymentPurchaseToGateway" name="myDesign" method="POST">					
		<div class="top_adjustment_20"><h4><button class="shop_checkout_sub_Buttn" id="guestPaymentInfoButtId">SUBMIT ORDER</button></h4></div>
		<input type="hidden" name="payCardNumber"/> <input type="hidden" name="payExpMonth"/> <input type="hidden" name="payExpYear"/> <input type="hidden" name="payCvvNumber"/> <input type="hidden" name="nameOnCard"/>			        		        
		</form>
		</div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div>        		
		</div> </div>		     
		</body>
</html>