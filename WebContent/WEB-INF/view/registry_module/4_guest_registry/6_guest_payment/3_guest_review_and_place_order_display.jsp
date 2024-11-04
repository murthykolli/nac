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
 	$(document).ready(function() { var totalFundsAmount1 = '<c:out value="${totalFundsAmountInSn}"/>'; var totalPayableAmount1 = '<c:out value="${totalPayableAmountInSn}"/>'; var totFundsAmount = totalFundsAmount1.replace(/\B(?=(\d{3})+(?!\d))/g, ","); $("#totalFundsAmountId").html(totFundsAmount); var totPayableAmount = totalPayableAmount1.replace(/\B(?=(\d{3})+(?!\d))/g, ","); $("#totalPayableAmountId").html(totPayableAmount); 

	 	var defaultCouponPrice = '<c:out value="${defaultCouponPriceInSn}"/>';
	 	var defaultCouponPriceDb = parseFloat(defaultCouponPrice);
	 	if(defaultCouponPriceDb > 0) { $('#defaultCouponPriceId').show(); } else { $('#defaultCouponPriceId').hide(); }
	 	/* var totalHandlingFees = '<c:out value="${totalHandlingFeesInSn}"/>'; var shippingAmountSt = '<c:out value="${shippingAmount}"/>'; var stateTaxAmountSt = '<c:out value="${stateTaxAmount}"/>';
	 	if(totalHandlingFees === "0.00") { $('#totalHandlingFeesId').hide(); } else { $('#totalHandlingFeesId').show(); }
	 	if(shippingAmountSt === "0.00") { $('#shippingAmountId').hide(); } else { $('#shippingAmountId').show(); }
	 	if(stateTaxAmountSt === "0.00") { $('#stateTaxAmountId').hide(); } else { $('#stateTaxAmountId').show(); } */
 	});
    </script>
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">        
        <div class="row"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description">
	    <div align="left" class="red_my_cart_for_guest_ht_dsp">REVIEW &amp; PLACE ORDER:</div> </div> </div> </div>	        
	    <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description">
	    <div align="right" class="rg_bill_rs_text_hd_dis">ORDER SUMMARY</div> </div> </div> </div> 
	    <div class="col-md-1 col-sm-1"></div> </div>	        
        <form action="regGuestPaymentInfoRed" method="post">
        <div class="row top_adjustment_20"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="left">
	    <div align="left" class="red_my_cart_for_guest_ht_dsp">BILLING INFO&nbsp;&nbsp;&nbsp;<a href="guestFundsCheckOutNow"><font class="shop_cart_rn_editl_text_dsp">EDIT</font></a></div>
	    <table style="margin-top: 20px;"> <tbody>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${billNameOnCard}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${billAddress1}&nbsp;${billAddress2}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${billCity},&nbsp;${billState}&nbsp;${billZip}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${billCountry}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${guestFullName}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${guestPhNumber}</td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${guestEmail}</td> </tr>
		<tr style="height: 20px;"> <td></td> </tr>
		<tr> <td class="rg_bill_review_pl_ord_text_dis">${guestUserFullName}</td> </tr> </tbody> </table>
		<div style="border-bottom: 1px solid black; margin-top: 30px; margin-bottom: 30px;"></div>
		<div align="left" class="red_my_cart_for_guest_ht_dsp">GIFT MESSAGE</div>
		<div style="margin-top: 20px;"> <p class="rg_bill_review_mess_ord_text_dis">${treasuredGiftMess}</p> </div> </div> </div> </div> </div>
	    <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div align="right">
	    <div><a href="regGuestMyShoppingCart"><font class="shop_cart_rn_editl_text_dsp">EDIT MY ORDER</font></a></div>
	    <div class="rg_billing_pay_div_info_txt_frm_dis" style="margin-top: 15px;">
		<table class="rg_billing_pay_tb_info_txt_frm_dis" style="margin-top: -15px;">
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;SUBTOTAL:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$<font id="totalFundsAmountId"></font>&nbsp;</td></tr>
		<tr id="defaultCouponPriceId" class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;5% DISCOUNT:</td> <td class="reg_gpay_pad_botline_dsp" align="right">($${defaultCouponStPriceInSn})&nbsp;</td></tr>
		
		<!-- <tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;TAX:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${stateTaxAmount}&nbsp;</td></tr>
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;SHIPPING:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${shippingAmount}&nbsp;</td></tr> -->
		
		<tr class="rg_bill_pay_row_info_txt_dis" align="left"><td class="reg_gpay_pad_botline_dsp">&nbsp;HANDLING FEES:</td> <td class="reg_gpay_pad_botline_dsp" align="right">$${totalHandlingFeesInSn}&nbsp;</td></tr>
		<tr><td align="left" class="reg_gf_pay_tbtext_red_dsp_dsp">&nbsp;TOTAL:</td> <td class="reg_gf_pay_tbtext_red_dsp_dsp" align="right">$<font id="totalPayableAmountId"></font>&nbsp;</td></tr> </table></div>
		<table style="margin-top: 45px;"><tr> <td><a href="guestRegistryMyAccount"><font class="shop_cart_rn_editl_text_dsp" style="position: relative; top: 10px;">KEEP SHOPPING</font>&nbsp;&nbsp;&nbsp;</a></td>
		<td><h4><button class="reg_box_fund__gs_sub_Buttn" id="guestBillingInfoButtonId">CONTINUE</button></h4></td></tr></table>
		<div style="margin-top: 60px;"><img src="resources/images/registry/authorize_net_img.png" width="120" height="100"></div> </div> </div> </div> </div>	     	
	    <div class="col-md-1 col-sm-1"></div> </div>
        </form>	
		</div> </div>		     
		</body>
</html>