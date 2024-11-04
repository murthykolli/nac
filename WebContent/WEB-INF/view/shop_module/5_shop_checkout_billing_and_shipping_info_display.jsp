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
	<script type="text/javascript" src="resources/js/shop_billing_and_shipping_address_validation.js" ></script>
	
	<script type="text/javascript">
 	$(document).ready(function() { var shopBillingFullName1 = "<c:out value="${shopBillingFullName}"/>"; var shopBillingAddress11 = "<c:out value="${shopBillingAddress1}"/>"; var shopBillingAddress21 = "<c:out value="${shopBillingAddress2}"/>"; var shopBillingCity1 = "<c:out value="${shopBillingCity}"/>"; var shopBillingState1 = "<c:out value="${shopBillingState}"/>"; var shopBillingZip1 = "<c:out value="${shopBillingZip}"/>";
	if(shopBillingFullName1 != "") { $("[name=shopBillingFullName]").val(shopBillingFullName1); $("[name=shopBillingAddress1]").val(shopBillingAddress11); $("[name=shopBillingAddress2]").val(shopBillingAddress21); $("[name=shopBillingCity]").val(shopBillingCity1); $("[name=shopBillingState]").val(shopBillingState1); $("[name=shopBillingZip]").val(shopBillingZip1); } 	 	
	var shopShippingFullName1 = '<c:out value="${shopShippingFullName}"/>'; var shopShippingAddress11 = '<c:out value="${shopShippingAddress1}"/>'; var shopShippingAddress21 = '<c:out value="${shopShippingAddress2}"/>'; var shopShippingCity1 = '<c:out value="${shopShippingCity}"/>'; var shopShippingState1 = '<c:out value="${shopShippingState}"/>'; var shopShippingZip1 = '<c:out value="${shopShippingZip}"/>'; 	    
 	var shopCheckBoxStatus1 = '<c:out value="${shopCheckBoxStatus}"/>'; var shopUserFullName1 = '<c:out value="${shopUserFullName}"/>'; var shopUserEmail1 = '<c:out value="${shopUserEmail}"/>'; var shopUserPhNumber1 = '<c:out value="${shopUserPhNumber}"/>'; 	    
 	$("[name=shopShippingFullName]").val(shopShippingFullName1); $("[name=shopShippingAddress1]").val(shopShippingAddress11); $("[name=shopShippingAddress2]").val(shopShippingAddress21); $("[name=shopShippingCity]").val(shopShippingCity1); $("[name=shopShippingState]").val(shopShippingState1);
 	$("[name=shopShippingZip]").val(shopShippingZip1); $("[name=shopUserFullName]").val(shopUserFullName1); $("[name=shopUserEmail]").val(shopUserEmail1); $("[name=shopUserPhNumber]").val(shopUserPhNumber1); if(shopCheckBoxStatus1 === "on"){ $("#checkCopyBillToShippId").attr("checked",true); } });
    </script> 	
	<style type="text/css">
	.shop_checkout_sub_Buttn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; text-transform: uppercase; outline: none; border: none; font: normal 1.05em/2.25em Georgia; letter-spacing: 2px; height: 36px; width: 240px; margin-top: 5px; }
	.shop_checkout_sub_Buttn:hover { background-color: #595959; }
	</style>	
	</head>
	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container"> <div class="row"> <div class="col-md-1 col-sm-1"></div>        
	    <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description">
	    <div align="left" class="red_my_cart_for_guest_ht_dsp">BILLING INFO</div> </div> </div> </div>
	    <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description">
	    <div align="right" class="rg_bill_rs_text_hd_dis">ORDER SUMMARY</div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div>	        
        <form action="shopBillAndShipInfoSaving" method="post">
        <div class="row top_adjustment_20"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-5 col-sm-5">
<!-- Billing Address -->
	    <div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">
		<table class="rg_billing_tbl_fld_disp"> <tr> <td class="rg_billing_textf_dis">FULL NAME*:</td> </tr>
		<tr> <td><input type="text" name="shopBillingFullName" id="shopBillingFullNameId" class="rg_billing_inp_box_dsp"></td> </tr>
		<tr><td class="rg_billing_textf_dis">ADDRESS 1*:</td> </tr>
		<tr> <td><input type="text" name="shopBillingAddress1" id="shopBillingAddress1Id" class="rg_billing_inp_box_dsp"></td> </tr>
		<tr> <td class="rg_billing_textf_dis">ADDRESS 2:</td> </tr>
		<tr> <td><input type="text" name="shopBillingAddress2" id="shopBillingAddress2Id" class="rg_billing_inp_box_dsp"></td> </tr>
		<tr> <td class="rg_billing_textf_dis">CITY*:</td> </tr>
		<tr> <td><input type="text" name="shopBillingCity" id="shopBillingCityId" class="rg_billing_inp_box_dsp"></td> </tr>
		<tr> <td class="rg_billing_textf_dis">STATE*:</td> <td class="rg_billing_textf_dis"><font class="rg_billing_ib_zip_text_dsp">ZIP*:</font></td> </tr>
		<tr> <td><select name="shopBillingState" id="shopBillingStateId" class="rg_billing_ib_state_dsp"> <option value="">------State Name------</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select></td> 
		<td><input type="text" name="shopBillingZip" maxLength="5" id="shopBillingZipId" class="rg_billing_ib_zip_dsp" onkeypress="return numeralsOnly(event);"></td> </tr>
		<tr> <td class="rg_billing_textf_dis">COUNTRY:</td> </tr>
		<tr> <td><input type="text" name="billCountry" id="billCountryId" value="UNITED STATES" class="rg_billing_ib_country_dsp"></td> </tr>
		<tr><td class="rg_billing_textf_dis">EMAIL*:</td> </tr>
		<tr> <td><input type="text" name="shopUserEmail" id="shopUserEmailId" class="rg_billing_inp_box_dsp"></td> </tr> </table> </div> </div> </div> </div> </div>	        	
<!-- Shipping Address -->
		<div class="row top_adjustment_40"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left" class="red_my_cart_for_guest_ht_dsp">SHIPPING INFO</div> </div> </div> </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">
		<table style="width: 400px; margin-top: 20px;"> <tr> <td class="billing_check_with_sa_text"><input type="checkbox" name="shopCheckBoxStatus" id="checkCopyBillToShippId"><font class="billing_check_with_sa_frame_adj">Billing Address is same as Shipping Address</font></td> </tr> </table>	
		<table style="width: 400px; margin-top: 0px;"> <tr> <td class="shoop_text_dsp">FULL NAME*:</td> </tr>
		<tr> <td><input type="text" name="shopShippingFullName" id="shopShippingFullNameId" class="shpp_inp_box_dsp"></td> </tr>
		<tr> <td class="shoop_text_dsp">ADDRESS 1*:</td> </tr>
		<tr> <td><input type="text" name="shopShippingAddress1" id="shopShippingAddress1Id" class="shpp_inp_box_dsp"></td> </tr>
		<tr> <td class="shoop_text_dsp">ADDRESS 2:</td> </tr>
		<tr> <td><input type="text" name="shopShippingAddress2" id="shopShippingAddress2Id" class="shpp_inp_box_dsp"></td> </tr>
		<tr> <td class="shoop_text_dsp">CITY*:</td> </tr>
		<tr> <td><input type="text" name="shopShippingCity" id="shopShippingCityId" class="shpp_inp_box_dsp"></td> </tr>
		<tr> <td class="shoop_text_dsp">STATE*:</td> <td class="shoop_text_dsp"><font class="shoop_text_zip_dsp">ZIP*:</font></td> </tr>
		<tr> <td><select name="shopShippingState" id="shopShippingStateId" class="shpp_inp_box_state"> <option value="">------State Name------</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select></td> 
		<td><input type="text" name="shopShippingZip" maxLength="5" id="shopShippingZipId" class="shpp_inp_box_zip" onkeypress="return numeralsOnly(event);"></td> </tr>
		<tr> <td class="shoop_text_dsp">COUNTRY:</td> </tr>
		<tr> <td><input type="text" name="shipCountry" id="shipCountryId" value="UNITED STATES" class="shpp_inp_box_country_dsp"></td> </tr>
		<tr> <td class="shoop_text_dsp">PHONE NUMBER*:</td> </tr>
		<tr> <td><input type="text" name="shopUserPhNumber" maxLength="12" id="shopUserPhNumberId" class="shpp_inp_box_dsp" onchange="return phoneFormat (event,shopUserPhNumberId);" onkeydown="return numeralsOnly(event);" onkeyup="return phoneFormat (event,shopUserPhNumberId)" onkeypress="return numeralsOnly(event);"></td> </tr> </table> </div> </div> </div> </div> </div> </div>
	     	
	    <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="right">
	    <div><a href="shopShoppingCartInfoDisplay"><font class="shop_cart_rn_editl_text_dsp">EDIT MY ORDER</font></a></div>
	    <div class="rg_billing_pay_div_info_txt_frm_dis" style="margin-top: 15px;"> <table class="rg_billing_pay_tb_info_txt_frm_dis" style="margin-top: -15px;">
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;SUBTOTAL:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shopCartTotalProductStAmountInSn}&nbsp;</td></tr>
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;5% DISCOUNT:</td> <td class="reg_gpay_pad_botline_dsp" align="right">($${defaultCouponPriceInSn})&nbsp;</td></tr>
		<!-- <tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;TAX:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shoppingCartStateTaxStAmountInSn}&nbsp;</td></tr>
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;SHIPPING:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shoppingCartShippingStAmountInSn}&nbsp;</td></tr> -->
		<!-- <tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;HANDLING FEES:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shoppingCartHandlingFeeInSn}&nbsp;</td></tr> -->
		<tr><td align="left" class="reg_gf_pay_tbtext_dsp_dsp">&nbsp;TOTAL:</td> <td class="reg_gf_pay_tbtext_dsp_dsp" align="right">$${shopCartTotalPayableStAmountInSn}&nbsp;</td></tr> </table></div>	        			
	    <table style="margin-top: 45px;"><tr>
		<td><a href="registryShop"><font class="shop_cart_rn_editl_text_dsp" style="position: relative; top: 12px;">KEEP SHOPPING</font>&nbsp;&nbsp;&nbsp;</a></td>
		<td><h4><button class="shop_checkout_sub_Buttn" id="shopBillingAndShippingInfoButtonId">REVIEW ORDER</button></h4></td></tr></table>
		<div style="margin-top: 60px;"><img src="resources/images/registry/authorize_net_img.png" width="120" height="100"></div> </div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div>
        </form>        		
		</div> </div>		     
		</body>
</html>