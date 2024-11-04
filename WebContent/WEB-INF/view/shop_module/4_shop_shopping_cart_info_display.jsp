<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
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
	
	<style type="text/css">
	.shop_cart_doller_edit_dsp { border: 1px solid white; background: white; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; text-align: right; color: black; }
	.shop_cart_price_con_cur_edit_dsp { border: 1px solid white; background: white; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; margin-left: 0px; color: #595959; letter-spacing: 1px; text-align: center; }
	.shop_cart_price_con_cur_save_dsp { border: 1px solid black; background: white; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; margin-left: 0px; color: black; letter-spacing: 1px; text-align: center; }
	.shop_checkout_sub_Buttn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; text-transform: uppercase; outline: none; border: none; font: normal 1.05em/2.25em Georgia; letter-spacing: 2px; height: 36px; width: 240px; margin-top: 5px; }
	.shop_checkout_sub_Buttn:hover { background-color: #595959; }
	</style>
	
	<script type="text/javascript"> window.location.hash=""; window.location.hash=""; window.onhashchange=function(){window.location.hash="";}; window.onload=function(){ window.history.forward(1); }; 
/* Shop Concept Boards Add Cart Coding */ 		 
	function shopCBProductsValEditButtonDisplay(count) { $("#cbShopProductsSaveDivDspId"+count).show(); $("#cbShopProductsEditDivDspId"+count).hide(); return false; }
 	function cbShopProductsInfoSaveButtonDisplay(count, shopsCBProductsSavingId) { var shopCBProductGivenQuantityVal = $("#shopCBProductGivenQuantityId"+count).val(); var shopCBProductOldQuantityVal = $("#shopCBProductOldQuantityId"+count).val(); var shopCBProductsPriceValue = $("#shopCBProductsPriceId"+count).val(); var shopCBProductGivenQuantityValue = 0;
 	if(shopCBProductGivenQuantityVal !== "") { shopCBProductGivenQuantityValue = parseInt(shopCBProductGivenQuantityVal); } 		
  	if(shopCBProductGivenQuantityValue > 0) { var totalShopCBProductInfoValue = shopsCBProductsSavingId + "__" + shopCBProductGivenQuantityVal + "__" + shopCBProductOldQuantityVal + "__" + shopCBProductsPriceValue; newAjaxCallForShopCBProductsInfoUpdate(totalShopCBProductInfoValue);
  	} else { alert("Please enter valid quantity"); return false; } }
 	
 	function newAjaxCallForShopCBProductsInfoUpdate(totalShopCBProductInfoValue) { 
 	  	$.ajax({ type : 'POST', url : "jSonAddCartShopCBProductsValueUpdate?shopCBProductInfoValue="+totalShopCBProductInfoValue, dataType : 'json', async : true, cache: false,
 	  	success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj);
 	  	$("#shopCartProductsDspId").load(location.href + " #shopCartProductsDspId"); $("#totalShopCBAmountDivId").load(location.href + " #totalShopCBAmountDivId"); $("#shopHeadCartCountId").load(location.href + " #shopHeadCartCountId"); } }); 
 	}	
/* Shop Concept Boards Products Info Delete Coding */ 		
 	function selectedShopCBProductsInfoDelete(shopsCBProductsSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?"); if (confMessageVar == true) { newAjaxCallForShopCBProductsInfoDelete(shopsCBProductsSavingId); } else { return false; } }
 	function newAjaxCallForShopCBProductsInfoDelete(shopsCBProductsSavingId) { 
 	   	$.ajax({ type : 'POST', url : "jSonShopCBProductsInfoDelete?shopCBProductsSavingId="+shopsCBProductsSavingId, dataType : 'json', async : true, cache: false,
 		success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
 		if(cartCount > 0) { $("#shopCartProductsDspId").load(location.href + " #shopCartProductsDspId"); $("#totalShopCBAmountDivId").load(location.href + " #totalShopCBAmountDivId"); $("#shopHeadCartCountId").load(location.href + " #shopHeadCartCountId");
 		} else { window.location = 'registryShop'; } } }); } 
 	
 	/* Shop Finishing Touches Add Cart Coding */ 		 
	function shopFTProductsValEditButtonDisplay(count) { $("#ftShopProductsSaveDivDspId"+count).show(); $("#ftShopProductsEditDivDspId"+count).hide(); return false; }
 	function ftShopProductsInfoSaveButtonDisplay(count, shopsFTProductsSavingId) { var shopFTProductGivenQuantityVal = $("#shopFTProductGivenQuantityId"+count).val(); var shopFTProductOldQuantityVal = $("#shopFTProductOldQuantityId"+count).val(); var shopFTProductsPriceValue = $("#shopFTProductsPriceId"+count).val(); var shopFTProductGivenQuantityValue = 0;
 	if(shopFTProductGivenQuantityVal !== "") { shopFTProductGivenQuantityValue = parseInt(shopFTProductGivenQuantityVal); } 		
  	if(shopFTProductGivenQuantityValue > 0) { var totalShopFTProductInfoValue = shopsFTProductsSavingId + "__" + shopFTProductGivenQuantityVal + "__" + shopFTProductOldQuantityVal + "__" + shopFTProductsPriceValue; newAjaxCallForShopFTProductsInfoUpdate(totalShopFTProductInfoValue);
  	} else { alert("Please enter valid quantity"); return false; } }
 	
 	function newAjaxCallForShopFTProductsInfoUpdate(totalShopFTProductInfoValue) { 
 	  	$.ajax({ type : 'POST', url : "jSonAddCartShopFTProductsValueUpdate?shopFTProductInfoValue="+totalShopFTProductInfoValue, dataType : 'json', async : true, cache: false,
 	  	success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj);
 	  	$("#shopCartFTProductsDspId").load(location.href + " #shopCartFTProductsDspId"); $("#totalShopCBAmountDivId").load(location.href + " #totalShopCBAmountDivId"); $("#shopHeadCartCountId").load(location.href + " #shopHeadCartCountId"); } }); 
 	}	
/* Shop Finishing Touches Products Info Delete Coding */ 		
 	function selectedShopFTProductsInfoDelete(shopsFTProductsSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?"); if (confMessageVar == true) { newAjaxCallForShopFTProductsInfoDelete(shopsFTProductsSavingId); } else { return false; } }
 	function newAjaxCallForShopFTProductsInfoDelete(shopsFTProductsSavingId) { 
 	   	$.ajax({ type : 'POST', url : "jSonShopFTProductsInfoDelete?shopFTProductsSavingId="+shopsFTProductsSavingId, dataType : 'json', async : true, cache: false,
 		success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
 		if(cartCount > 0) { $("#shopCartFTProductsDspId").load(location.href + " #shopCartFTProductsDspId"); $("#totalShopCBAmountDivId").load(location.href + " #totalShopCBAmountDivId"); $("#shopHeadCartCountId").load(location.href + " #shopHeadCartCountId");
 		} else { window.location = 'registryShop'; } } }); } 
 	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0)); if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }
 	function conBorNumeralsOnly(evt,id) { try { var charCode = (evt.which) ? evt.which : event.keyCode; if(charCode==46) { var txt=document.getElementById(id).value; if(!(txt.indexOf(".") > -1)) { return true; } }
 	if (charCode > 31 && (charCode < 48 || charCode > 57) ) return false; return true; } catch(w) { alert(w); } } 	
    </script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container"> <div class="row"> <div class="col-md-2 col-sm-2"></div> <div class="col-md-8 col-sm-8">	        
<!-- Cart Heading -->
	    <div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
	    <div class="red_my_cart_for_guest_ht_dsp">Shopping Cart</div> </div> </div> </div> </div>	       
<!-- Cart Sub Heading -->
	 	<div class="row top_adjustment_10" style="padding: 20px 0px;"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center" class="red_my_cart_for_guest_suht_dsp">PRODUCT</div> </div> </div> </div> 
		<div align="left" class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="red_my_cart_for_guest_suht_dsp">PRICE</div> </div> </div> </div> </div> 	    
	    <div class="row"><div class="red_my_cart_for_guest_div_bar"></div></div>     
	        						       
<!-- Shop Concept Board Products Info coding -->			
		<div id="shopCartProductsDspId">	 		
	 	<%
	 		String shopCBProductCartValue = (String)session.getAttribute("shopCBProductCartValueListInSn");	 		
			if (null != shopCBProductCartValue) { String[] shopCBProductCartValueList = shopCBProductCartValue.split("__"); int count = 0;
			for (int i = 0; i < shopCBProductCartValueList.length; i++) { String guestCustomFundContValueDsp = shopCBProductCartValueList[i]; String[] shopCBProductCartValueComb = shopCBProductCartValueList[i].split("_,_"); String shopCBProductId = shopCBProductCartValueComb[0]; String shopCBProductQuantity = shopCBProductCartValueComb[1]; String shopCBProductAmount = shopCBProductCartValueComb[2]; String shopCBProductName = shopCBProductCartValueComb[3];
			String shopCBProductImage = shopCBProductCartValueComb[4]; double shopCBProductAmountDb = Double.parseDouble(shopCBProductAmount); String shopCBProductAmountSt = String.format("%.2f", shopCBProductAmountDb); count = count + (i + 1);
		%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=shopCBProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=shopCBProductName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="cbShopProductsEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="shop_cart_doller_edit_dsp"></td> <td>&nbsp;<%=shopCBProductAmountSt%>/</td> <td><input type="text" name="productCount" value="<%=shopCBProductQuantity%>" class="shop_cart_price_con_cur_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return shopCBProductsValEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="cbShopProductsSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="shop_cart_doller_edit_dsp"></td> <td>&nbsp;<%=shopCBProductAmountSt%><font style="color: white;">/</font></td> <td><input type="text" maxLength="2" id="shopCBProductGivenQuantityId<%=count%>" name="shopCBProductGivenQuantity" value="<%=shopCBProductQuantity%>" class="shop_cart_price_con_cur_save_dsp" onkeypress="return numeralsOnly(event);"></td> </tr> 
		<tr> <td><input type="hidden" id="shopCBProductOldQuantityId<%=count%>" name="shopCBProductOldQuantity" value="<%=shopCBProductQuantity%>"></td>  <td><input type="hidden" id="shopCBProductsPriceId<%=count%>" name="shopCBProductsPrice" value="<%=shopCBProductAmountSt%>"></td></tr></table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cbShopProductsInfoSaveButtonDisplay(<%=count%>, <%=shopCBProductId%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedShopCBProductsInfoDelete(<%=shopCBProductId%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>
		    						       
<!-- Shop Finishing Touches Products Info coding -->			
		<div id="shopCartFTProductsDspId">	 		
	 	<%
	 		String shopFTProductCartValue = (String)session.getAttribute("shopFTProductCartValueListInSn");	 		
			if (null != shopFTProductCartValue) { String[] shopFTProductCartValueList = shopFTProductCartValue.split("__"); int count = 0;
			for (int i = 0; i < shopFTProductCartValueList.length; i++) { String guestCustomFundContValueDsp = shopFTProductCartValueList[i]; String[] shopFTProductCartValueComb = shopFTProductCartValueList[i].split("_,_"); String shopFTProductId = shopFTProductCartValueComb[0]; String shopFTProductQuantity = shopFTProductCartValueComb[1]; String shopFTProductAmount = shopFTProductCartValueComb[2]; String shopFTProductName = shopFTProductCartValueComb[3];
			String shopFTProductImage = shopFTProductCartValueComb[4]; double shopFTProductAmountDb = Double.parseDouble(shopFTProductAmount); String shopFTProductAmountSt = String.format("%.2f", shopFTProductAmountDb); count = count + (i + 1);
		%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=shopFTProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=shopFTProductName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="ftShopProductsEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="shop_cart_doller_edit_dsp"></td> <td>&nbsp;<%=shopFTProductAmountSt%>/</td> <td><input type="text" name="productCount" value="<%=shopFTProductQuantity%>" class="shop_cart_price_con_cur_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return shopFTProductsValEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="ftShopProductsSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="shop_cart_doller_edit_dsp"></td> <td>&nbsp;<%=shopFTProductAmountSt%><font style="color: white;">/</font></td> <td><input type="text" maxLength="2" id="shopFTProductGivenQuantityId<%=count%>" name="shopFTProductGivenQuantity" value="<%=shopFTProductQuantity%>" class="shop_cart_price_con_cur_save_dsp" onkeypress="return numeralsOnly(event);"></td> </tr> 
		<tr> <td><input type="hidden" id="shopFTProductOldQuantityId<%=count%>" name="shopFTProductOldQuantity" value="<%=shopFTProductQuantity%>"></td>  <td><input type="hidden" id="shopFTProductsPriceId<%=count%>" name="shopFTProductsPrice" value="<%=shopFTProductAmountSt%>"></td></tr></table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return ftShopProductsInfoSaveButtonDisplay(<%=count%>, <%=shopFTProductId%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedShopFTProductsInfoDelete(<%=shopFTProductId%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>
						
<!-- Cart Total Value Code -->
	 	<div class="row top_adjustment_30"> <div class="col-md-7 col-sm-7"> </div>
		<div class="col-md-5 col-sm-5"> <div class="service-item">                        
		<div align="center" class="service-description" style="background: #e7e6e6; padding: 20px; border: 1px solid #dddbdb;">
		<table style="position: relative;"><tr><td><font class="red_my_cart_gst_val_dsp">&nbsp;SUBTOTAL:&nbsp;</font></td> <td><font class="red_my_cart_for_guest_reg_amt_dsp"><font id="totalShopCBAmountDivId">$&nbsp;${totalShopProductPriceStInSn}</font></font></td></tr></table> </div> </div> </div> </div>			      
<!-- Cart Submit Button Code -->		
	 	<div class="row"> <div align="left" class="col-md-4 col-sm-4">
	    <img src="resources/images/registry/authorize_net_img.png" width="120" height="100"> </div> 
		<div class="col-md-8 col-sm-8 top_adjustment_30"> <div class="service-item"> <div align="right" class="service-description">
		<table><tr> <td><a href="registryShop"><font class="shop_cart_rn_editl_text_dsp" style="position: relative; top: 12px;">KEEP SHOPPING</font>&nbsp;&nbsp;&nbsp;</a></td>
		<td><form action="shopCheckoutBillShippInfo" method="get"><h4><button class="shop_checkout_sub_Buttn" id="shippingId">CHECKOUT NOW</button></h4></form></td></tr></table> </div> </div> </div> </div> </div>	
		<div class="col-md-2 col-sm-2"></div>
		</div> </div> </div>
		<script type="text/javascript" src="resources/js/json-minified.js"></script>		     
		</body>
</html>