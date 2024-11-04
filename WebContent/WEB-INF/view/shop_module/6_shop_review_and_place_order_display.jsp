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
	
	<style type="text/css">
	.shop_checkout_sub_Buttn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; text-transform: uppercase; outline: none; border: none; font: normal 1.05em/2.25em Georgia; letter-spacing: 2px; height: 36px; width: 200px; margin-top: 5px; }
	.shop_checkout_sub_Buttn:hover { background-color: #595959; }
	</style>
	
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container"> <div class="row"> <div class="col-md-1 col-sm-1"></div>
        <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="left" class="red_my_cart_for_guest_ht_dsp">REVIEW &amp; PLACE ORDER:</div> </div> </div> </div> 
		<div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="right" class="rg_bill_rs_text_hd_dis">ORDER SUMMARY</div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div> 
	    <form action="shopCheckoutPaymentInfo" method="post">
        <div class="row top_adjustment_20"> <div class="col-md-1 col-sm-1"></div>
        <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="left">
	    <div align="left" class="red_my_cart_for_guest_ht_dsp">BILLING INFO&nbsp;&nbsp;&nbsp;<a href="shopCheckoutBillShippInfo"><font class="shop_cart_rn_editl_text_dsp">EDIT</font></a></div>
	    <table style="margin-top: 20px;"> <tbody>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${shopBillingFullName}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${shopBillingAddress1}&nbsp;${shopBillingAddress2}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${shopBillingCity},&nbsp;${shopBillingState}&nbsp;${shopBillingZip}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">UNITED STATES</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${shopUserEmail}</td> </tr> </tbody> </table>
		<div style="border-bottom: 1px solid black; margin-top: 30px; margin-bottom: 30px; margin-right: 80px;"></div>
		<div align="left" class="red_my_cart_for_guest_ht_dsp">SHIPPING INFO&nbsp;&nbsp;&nbsp;<a href="shopCheckoutBillShippInfo"><font class="shop_cart_rn_editl_text_dsp">EDIT</font></a></div>
	    <table style="margin-top: 20px;"> <tbody>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${shopShippingFullName}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${shopShippingAddress1}&nbsp;${shopShippingAddress2}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${shopShippingCity},&nbsp;${shopShippingState}&nbsp;${shopShippingZip}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">UNITED STATES</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${shopUserPhNumber}</td> </tr> </tbody> </table> </div> </div> </div> </div>
	     	
	    <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="right">
	    <div><a href="shopShoppingCartInfoDisplay"><font class="shop_cart_rn_editl_text_dsp">EDIT MY ORDER</font></a></div>
	    <div class="rg_billing_pay_div_info_txt_frm_dis" style="margin-top: 15px;">
		<table class="rg_billing_pay_tb_info_txt_frm_dis" style="margin-top: -15px;">
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;SUBTOTAL:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shopCartTotalProductStAmountInSn}&nbsp;</td></tr>
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;5% DISCOUNT:</td> <td class="reg_gpay_pad_botline_dsp" align="right">($${defaultCouponPriceInSn})&nbsp;</td></tr>
		<!-- <tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;TAX:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shoppingCartStateTaxStAmountInSn}&nbsp;</td></tr>
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;SHIPPING:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shoppingCartShippingStAmountInSn}&nbsp;</td></tr> -->
		<!-- <tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;HANDLING FEES:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shoppingCartHandlingFeeInSn}&nbsp;</td></tr> -->
		<tr><td align="left" class="reg_gf_pay_tbtext_red_dsp_dsp">&nbsp;TOTAL:</td> <td class="reg_gf_pay_tbtext_red_dsp_dsp" align="right">$${shopCartTotalPayableStAmountInSn}&nbsp;</td></tr> </table></div>	        			
	    <table style="margin-top: 45px;"><tr>
		<td><a href="registryShop"><font class="shop_cart_rn_editl_text_dsp" style="position: relative; top: 12px;">KEEP SHOPPING</font>&nbsp;&nbsp;&nbsp;</a></td>
		<td><h4><button class="shop_checkout_sub_Buttn" id="shopBillingAndShippingInfoButtonId">CONTINUE</button></h4></td></tr></table>
		<div style="margin-top: 60px;"><img src="resources/images/registry/authorize_net_img.png" width="120" height="100"></div> </div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div>
        </form>        		
		</div> </div>		     
		</body>
</html>