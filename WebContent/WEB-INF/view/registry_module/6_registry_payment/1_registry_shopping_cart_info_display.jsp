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
	.regi_cart_doller_edit_dsp { border: 1px solid white; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; text-align: right; color: black; }
	.reg_cart_price_edit_dsp { border: 1px solid white; font: bold 1em/1.25em Georgia; height: 26px; width: 90px; margin-left: 0px; color: black; letter-spacing: 1px; text-align: left; padding-left: 5px; }
	.regi_cart_price_save_dsp { border: 1px solid black; font: bold 1em/1.25em Georgia; height: 26px; width: 90px; margin-left: 0px; color: black; letter-spacing: 1px; text-align: left; padding-left: 5px; }
	.regi_cart_price_con_cur_edit_dsp { border: 1px solid white; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; margin-left: 0px; color: #595959; letter-spacing: 1px; text-align: center; }
	.regi_cart_price_con_cur_save_dsp { border: 1px solid black; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; margin-left: 0px; color: black; letter-spacing: 1px; text-align: center; }
	</style>		
	
	</head>	
  		<body>  	
  		<div id="mainframe" class="section-content"> <div class="container">   
    	<div class="row"> <div class="col-md-2 col-sm-2"></div> <div class="col-md-8 col-sm-8">
<!-- Cart Heading -->
		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
	    <div class="red_my_cart_for_guest_ht_dsp">MY CART</div> </div> </div> </div> </div>	       
<!-- Cart Sub Heading -->
	 	<div class="row top_adjustment_10" style="padding: 20px;"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center" class="red_my_cart_for_guest_suht_dsp">FUND</div> </div> </div> </div> 
		<div align="left" class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="red_my_cart_for_guest_suht_dsp">CONTRIBUTION</div> </div> </div> </div> </div> 	    
	    <div class="row"><div class="red_my_cart_for_guest_div_bar"></div></div>	       		
<!-- Concept Boards Contributed Code Start -->
		<div id="cbContributedDivId">		
		<% 
			if (null != session.getAttribute("cbContributedPaymentSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedPaymentSavingIdList = (ArrayList) session.getAttribute("cbContributedPaymentSavingIdListInSn"); if (null != cbContributedPaymentSavingIdList && cbContributedPaymentSavingIdList.size() > 0) {		
		   	if (null != session.getAttribute("cbContributedAddCartImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedAddCartImageList = (ArrayList) session.getAttribute("cbContributedAddCartImageListInSn"); if (null != cbContributedAddCartImageList && cbContributedAddCartImageList.size() > 0) {
           	if (null != session.getAttribute("cbContributedAddCartNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedAddCartNameList = (ArrayList) session.getAttribute("cbContributedAddCartNameListInSn"); if (null != cbContributedAddCartNameList && cbContributedAddCartNameList.size() > 0) {
           	if (null != session.getAttribute("cbContributedAddCartPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedAddCartPriceList = (ArrayList) session.getAttribute("cbContributedAddCartPriceListInSn"); if (null != cbContributedAddCartPriceList && cbContributedAddCartPriceList.size() > 0) { 
            if (null != session.getAttribute("cbContributedNeedPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbContributedNeedPriceList = (ArrayList) session.getAttribute("cbContributedNeedPriceListInSn"); if (null != cbContributedNeedPriceList && cbContributedNeedPriceList.size() > 0) {
        %>                
        <% 	int count = 0; for(int i = 0; i < cbContributedPaymentSavingIdList.size(); i++){ count = count + (i + 1); byte[] cbContributedProductImageByte = (byte[]) cbContributedAddCartImageList.get(i); String cbContributedProductImage = null;
	    	if(null != cbContributedProductImageByte) {
	    		String cbContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbContributedProductImageByte); cbContributedProductImage = "data:image/jpg;base64," +cbContributedProductImageB64;
	    	}
	        String conteConAmountSt = (String) cbContributedAddCartPriceList.get(i); double regConBoardConPriceDb = Double.parseDouble(conteConAmountSt); String regConBoardConPrice = String.format("%.2f", regConBoardConPriceDb);
        %>  
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=cbContributedProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=cbContributedAddCartNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="cbContributedEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="regi_cart_doller_edit_dsp"></td> <td><input type="text" name="productCount" value="<%=regConBoardConPrice%>" class="reg_cart_price_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cbContributedEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="cbContributedSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="regi_cart_doller_edit_dsp"></td> <td><input type="text" id="regCBContributedPrice<%=count%>" name="regCBContributedAmount" value="<%=conteConAmountSt%>" class="regi_cart_price_save_dsp" onkeypress="return conBorNumeralsOnly(event,this.id);"></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cbContributedSaveButtonDisplay(<%=count%>, <%=cbContributedPaymentSavingIdList.get(i)%>, <%=cbContributedNeedPriceList.get(i)%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedCBContributedInfoDelete(<%=cbContributedPaymentSavingIdList.get(i)%>);"></div> </div>
		</div> </div> </div> </div> 
        <% } %>        
        <% } } } } } } } } } } %>
		</div>		
<!-- Concept Boards Contributed Code End --> 
<!-- Concept Boards Individual Code Start -->
		<div id="cbIndividualDivId">		
		<% 
			if (null != session.getAttribute("cbIndividualPaymentSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualPaymentSavingIdList = (ArrayList) session.getAttribute("cbIndividualPaymentSavingIdListInSn"); if (null != cbIndividualPaymentSavingIdList && cbIndividualPaymentSavingIdList.size() > 0) {		
		   	if (null != session.getAttribute("cbIndividualAddCartImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualAddCartImageList = (ArrayList) session.getAttribute("cbIndividualAddCartImageListInSn"); if (null != cbIndividualAddCartImageList && cbIndividualAddCartImageList.size() > 0) {
           	if (null != session.getAttribute("cbIndividualAddCartNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualAddCartNameList = (ArrayList) session.getAttribute("cbIndividualAddCartNameListInSn"); if (null != cbIndividualAddCartNameList && cbIndividualAddCartNameList.size() > 0) {
           	if (null != session.getAttribute("cbIndividualAddCartPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualAddCartPriceList = (ArrayList) session.getAttribute("cbIndividualAddCartPriceListInSn"); if (null != cbIndividualAddCartPriceList && cbIndividualAddCartPriceList.size() > 0) {
            if (null != session.getAttribute("cbIndividualAddCartQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualAddCartQuantityList = (ArrayList) session.getAttribute("cbIndividualAddCartQuantityListInSn"); if (null != cbIndividualAddCartQuantityList && cbIndividualAddCartQuantityList.size() > 0) {
            if (null != session.getAttribute("cbIndividualNeedQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList cbIndividualNeedQuantityList = (ArrayList) session.getAttribute("cbIndividualNeedQuantityListInSn"); if (null != cbIndividualNeedQuantityList && cbIndividualNeedQuantityList.size() > 0) {   
        %>
        <% 	int count = 0; for(int i = 0; i < cbIndividualPaymentSavingIdList.size(); i++){ count = count + (i + 1);
	        byte[] cbIndividualProductImageByte = (byte[]) cbIndividualAddCartImageList.get(i); String cbIndividualProductImage = null;
	    	if(null != cbIndividualProductImageByte) {
	    		String cbIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbIndividualProductImageByte); cbIndividualProductImage = "data:image/jpg;base64," +cbIndividualProductImageB64;
	    	}
	        String conteConAmountSt = (String) cbIndividualAddCartPriceList.get(i); double regConBoardConPriceDb = Double.parseDouble(conteConAmountSt); String regConBoardConPrice = String.format("%.2f", regConBoardConPriceDb);
        %>  
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=cbIndividualProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=cbIndividualAddCartNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="cbIndividualEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="regi_cart_doller_edit_dsp"></td> <td>&nbsp;<%=regConBoardConPrice%>/</td> <td><input type="text" name="productCount" value="<%=cbIndividualAddCartQuantityList.get(i)%>" class="regi_cart_price_con_cur_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cbIndividualEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="cbIndividualSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="regi_cart_doller_edit_dsp"></td> <td>&nbsp;<%=regConBoardConPrice%><font style="color: white;">/</font></td> <td><input type="text" id="regCBIndividualQuantityId<%=count%>" name="regiConBoardNewQuantity" value="<%=cbIndividualAddCartQuantityList.get(i)%>" class="regi_cart_price_con_cur_save_dsp" onkeypress="return numeralsOnly(event);"></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" maxLength="2" onclick="return cbIndividualSaveButtonDisplay(<%=count%>, <%=cbIndividualPaymentSavingIdList.get(i)%>, <%=cbIndividualNeedQuantityList.get(i)%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedCBIndividualInfoDelete(<%=cbIndividualPaymentSavingIdList.get(i)%>);"></div> </div> </div> </div> </div> </div> 
        <% } %>
        <% } } } } } } } } } } } } %>
		</div>		
<!-- Concept Boards Individual Code End -->
<!-- Finishing Touches Contributed Code Start -->
		<div id="ftContributedDivId">		
		<% 
			if (null != session.getAttribute("ftContributedPaymentSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedPaymentSavingIdList = (ArrayList) session.getAttribute("ftContributedPaymentSavingIdListInSn"); if (null != ftContributedPaymentSavingIdList && ftContributedPaymentSavingIdList.size() > 0) {		
		   	if (null != session.getAttribute("ftContributedAddCartImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedAddCartImageList = (ArrayList) session.getAttribute("ftContributedAddCartImageListInSn"); if (null != ftContributedAddCartImageList && ftContributedAddCartImageList.size() > 0) {
           	if (null != session.getAttribute("ftContributedAddCartNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedAddCartNameList = (ArrayList) session.getAttribute("ftContributedAddCartNameListInSn"); if (null != ftContributedAddCartNameList && ftContributedAddCartNameList.size() > 0) {
           	if (null != session.getAttribute("ftContributedAddCartPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedAddCartPriceList = (ArrayList) session.getAttribute("ftContributedAddCartPriceListInSn"); if (null != ftContributedAddCartPriceList && ftContributedAddCartPriceList.size() > 0) { 
            if (null != session.getAttribute("ftContributedNeedPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftContributedNeedPriceList = (ArrayList) session.getAttribute("ftContributedNeedPriceListInSn"); if (null != ftContributedNeedPriceList && ftContributedNeedPriceList.size() > 0) {
        %>                
        <% 	int count = 0; for(int i = 0; i < ftContributedPaymentSavingIdList.size(); i++){ count = count + (i + 1); byte[] ftContributedProductImageByte = (byte[]) ftContributedAddCartImageList.get(i); String ftContributedProductImage = null;
	    	if(null != ftContributedProductImageByte) {
	    		String ftContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(ftContributedProductImageByte); ftContributedProductImage = "data:image/jpg;base64," +ftContributedProductImageB64;
	    	}
	        String conteConAmountSt = (String) ftContributedAddCartPriceList.get(i); double regConBoardConPriceDb = Double.parseDouble(conteConAmountSt); String regConBoardConPrice = String.format("%.2f", regConBoardConPriceDb);
        %>  
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=ftContributedProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=ftContributedAddCartNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="ftContributedEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="regi_cart_doller_edit_dsp"></td> <td><input type="text" name="productCount" value="<%=regConBoardConPrice%>" class="reg_cart_price_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return ftContributedEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="ftContributedSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="regi_cart_doller_edit_dsp"></td> <td><input type="text" id="regFTContributedPrice<%=count%>" name="regFTContributedAmount" value="<%=conteConAmountSt%>" class="regi_cart_price_save_dsp" onkeypress="return conBorNumeralsOnly(event,this.id);"></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return ftContributedSaveButtonDisplay(<%=count%>, <%=ftContributedPaymentSavingIdList.get(i)%>, <%=ftContributedNeedPriceList.get(i)%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedFTContributedInfoDelete(<%=ftContributedPaymentSavingIdList.get(i)%>);"></div> </div>
		</div> </div> </div> </div> 
        <% } %>        
        <% } } } } } } } } } } %>
		</div>		
<!-- Finishing Touches Contributed Code End --> 
<!-- Finishing Touches Individual Code Start -->
		<div id="ftIndividualDivId">		
		<% 
			if (null != session.getAttribute("ftIndividualPaymentSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualPaymentSavingIdList = (ArrayList) session.getAttribute("ftIndividualPaymentSavingIdListInSn"); if (null != ftIndividualPaymentSavingIdList && ftIndividualPaymentSavingIdList.size() > 0) {		
		   	if (null != session.getAttribute("ftIndividualAddCartImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualAddCartImageList = (ArrayList) session.getAttribute("ftIndividualAddCartImageListInSn"); if (null != ftIndividualAddCartImageList && ftIndividualAddCartImageList.size() > 0) {
           	if (null != session.getAttribute("ftIndividualAddCartNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualAddCartNameList = (ArrayList) session.getAttribute("ftIndividualAddCartNameListInSn"); if (null != ftIndividualAddCartNameList && ftIndividualAddCartNameList.size() > 0) {
           	if (null != session.getAttribute("ftIndividualAddCartPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualAddCartPriceList = (ArrayList) session.getAttribute("ftIndividualAddCartPriceListInSn"); if (null != ftIndividualAddCartPriceList && ftIndividualAddCartPriceList.size() > 0) {
            if (null != session.getAttribute("ftIndividualAddCartQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualAddCartQuantityList = (ArrayList) session.getAttribute("ftIndividualAddCartQuantityListInSn"); if (null != ftIndividualAddCartQuantityList && ftIndividualAddCartQuantityList.size() > 0) {
            if (null != session.getAttribute("ftIndividualNeedQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList ftIndividualNeedQuantityList = (ArrayList) session.getAttribute("ftIndividualNeedQuantityListInSn"); if (null != ftIndividualNeedQuantityList && ftIndividualNeedQuantityList.size() > 0) {   
        %>
        <% 	int count = 0; for(int i = 0; i < ftIndividualPaymentSavingIdList.size(); i++){ count = count + (i + 1);
	        byte[] ftIndividualProductImageByte = (byte[]) ftIndividualAddCartImageList.get(i); String ftIndividualProductImage = null;
	    	if(null != ftIndividualProductImageByte) {
	    		String ftIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(ftIndividualProductImageByte); ftIndividualProductImage = "data:image/jpg;base64," +ftIndividualProductImageB64;
	    	}
	        String conteConAmountSt = (String) ftIndividualAddCartPriceList.get(i); double regConBoardConPriceDb = Double.parseDouble(conteConAmountSt); String regConBoardConPrice = String.format("%.2f", regConBoardConPriceDb);
        %>  
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=ftIndividualProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=ftIndividualAddCartNameList.get(i)%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="ftIndividualEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="regi_cart_doller_edit_dsp"></td> <td>&nbsp;<%=regConBoardConPrice%>/</td> <td><input type="text" name="productCount" value="<%=ftIndividualAddCartQuantityList.get(i)%>" class="regi_cart_price_con_cur_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return ftIndividualEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="ftIndividualSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="regi_cart_doller_edit_dsp"></td> <td>&nbsp;<%=regConBoardConPrice%><font style="color: white;">/</font></td> <td><input type="text" id="regFTIndividualQuantityId<%=count%>" name="regiConBoardNewQuantity" value="<%=ftIndividualAddCartQuantityList.get(i)%>" class="regi_cart_price_con_cur_save_dsp" onkeypress="return numeralsOnly(event);"></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" maxLength="2" onclick="return ftIndividualSaveButtonDisplay(<%=count%>, <%=ftIndividualPaymentSavingIdList.get(i)%>, <%=ftIndividualNeedQuantityList.get(i)%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedFTIndividualInfoDelete(<%=ftIndividualPaymentSavingIdList.get(i)%>);"></div> </div> </div> </div> </div> </div> 
        <% } %>
        <% } } } } } } } } } } } } %>
		</div>		
<!-- Finishing Touches Individual Code End --> 
<!-- Cart Total Value Code -->
	 	<div class="row top_adjustment_30"> <div class="col-md-7 col-sm-7"> </div> 
		<div class="col-md-5 col-sm-5"> <div class="service-item">                        
		<div align="right" class="service-description" style="background: #e7e6e6; padding: 20px; border: 1px solid #dddbdb;">
		<table style="position: relative; left: -30px;"><tr><td><font class="red_my_cart_gst_val_dsp">&nbsp;SUBTOTAL:&nbsp;</font></td> <td><font class="regi_my_cart_info_frame_dsp"><font id="totalAmountDisplayDivId">$&nbsp;${shoppingCartTotalAmountInSn}</font></font></td></tr></table> </div> </div> </div> </div>			      
<!-- Cart Submit Button Code -->			
	 	<div class="row"> <div align="left" class="col-md-4 col-sm-4">
	    <img src="resources/images/registry/authorize_net_img.png" width="120" height="100"> </div> 
		<div class="col-md-8 col-sm-8 top_adjustment_30">
		<div class="service-item"> <div align="right" class="service-description">
		<table><tr> <td><a href="registryOverview"><font class="shop_cart_rn_editl_text_dsp" style="position: relative; top: 10px;">KEEP SHOPPING</font>&nbsp;&nbsp;&nbsp;</a></td>
		<td><form action="registrantFundsCheckOutContact" method="get"><h4><button class="reg_box_fund__gs_sub_Buttn" id="shippingId">CHECKOUT NOW</button></h4></form></td></tr></table> </div> </div> </div> </div> </div>
       	<div class="col-md-2 col-sm-2"></div> </div>			
		</div> </div>
		<script type="text/javascript" src="resources/js/registry/registry_shopping_cart.js"></script>
		<script type="text/javascript" src="resources/js/json-minified.js"></script>		     
		</body>
</html>