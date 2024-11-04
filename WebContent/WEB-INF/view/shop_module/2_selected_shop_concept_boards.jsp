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
    <link rel="stylesheet" href="resources/css/registry_shop/1_shop_home.css" type="text/css">
    <script type="text/javascript" src="resources/js/popup/shop_popup_cb_products_info_dsp.js"></script>
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
    <link rel="stylesheet" href="resources/css/popup/lightbox_for_registry.css" media="screen"/>
    <script async defer src="//assets.pinterest.com/js/pinit.js"></script>
	
	<script type="text/javascript">	
	$(document).ready(function () { $('.big_top_image_dsp').click(function(){ var viewImgs = $(this).attr("src"); $("#bigTopimageIdDsp").attr("href", viewImgs); });
	$('.big_image_dsp').click(function() { var viewImgs = $(this).attr("src"); var imgId = $(this).attr("id"); $("#"+imgId+"Dsp").attr("href", viewImgs); });
 	var words = $('#cbShopRoomFNameTextId').text().split(' '); var html = ''; $.each(words, function() { html += '<span class="first_letter_dsp">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; }); $('#cbShopRoomFNameTextId').html(html); $("#showArrowClickId").click(function (){ $('html, body').animate({scrollTop: $('#bottomDataDisplayId').offset().top}, 0); }); });		
	function addProductToRegistryLanding() { alert("This product has been added to your Cart"); }		
	</script>
	</head>	
		<body>		
			<div id="mmenu_screen" class="container-fluid main_container top_adjustment_120"> 
				<!-- <div class="row shop_pro_code_bgclr"> <div class="col-md-2 col-sm-2"></div> <div class="col-md-8 col-sm-8"> <div class="row shop_bann_txt_adj"> <div class="col-md-4 col-sm-4">
				<div align="center"> <div class="promo_codes_text">5% OFF $1000 - $1999 (Code: 5OFF)</div> </div> </div>
				<div class="col-md-4 col-sm-4"> <div align="center"> <div class="promo_codes_text">7% OFF $2000 - $2999 (Code: 7OFF)</div> </div> </div>
				<div class="col-md-4 col-sm-4"> <div align="center"> <div class="promo_codes_text">10% OFF $3000+ (Code: 10OFF)</div> </div> </div> </div> </div>
				<div class="col-md-2 col-sm-2"></div> </div> --> 
			</div>				
			<div id="mmenu_screen" class="container-fluid main_container shop_main_fram_adj shop_main_fram_adj"> <div class="row"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10"> <div class="row">        
			<%		    	
				int currentcount = (int) session.getAttribute("shopCBRoomsCountInSn");
				int totalCBProductsCount = (int) session.getAttribute("totalShopCBProductsCountInSn");
			    if(totalCBProductsCount > 0) {			        	
			%> 
			<div class="col-md-1 col-sm-1"> <div align="right"> <div class="shop_arr_adj_tbl"> <% if(currentcount > 0) { %>
			<form action="previousShopCBProductsDisplay"> <input type="image" src="resources/images/registry/rcb_left_arrow_img.png" class="top_adjustment_55"> <input type="hidden" name="shopCBRoomsCount" value="<%=currentcount%>"> <input type="hidden" name="selectedShopRoomName" value="${selectedShopRoomName}"> </form> <% } %> </div> </div> </div>
			<div class="col-md-10 col-sm-10"> <div class="row shop_top_txthd_cl"> <div class="col-md-7 col-sm-7"> <div align="left" class="sreg_dsn_curated_cb_title_text text-left">
			<h4><font class="sreg_dsn_curated_cb_title_fl">C</font><font class="sreg_dsn_curated_cb_title_ll">URATED </font> <font class="sreg_dsn_curated_cb_title_fl">D</font><font class="sreg_dsn_curated_cb_title_ll">ESIGN </font><font class="sreg_dsn_curated_cb_title_fl">B</font><font class="sreg_dsn_curated_cb_title_ll">OARDS</font></h4> </div> </div>
			<div align="right" class="col-md-5 col-sm-5"> <div class="row"> <div align="right" class="col-md-12 col-sm-12 shop_arr_adj_dsppt">
			<form action="shopViewAllDesignsConcepts" method="GET"> <h4><button class="reg_con_cur_bod_submit_Btn" id="addBoardsId"><font class="reg_con_cur_bod_submit_Btn_flt">&nbsp;V</font>IEW <font class="reg_con_cur_bod_submit_Btn_flt">A</font>LL <font class="reg_con_cur_bod_submit_Btn_flt">D</font>ESIGNS&nbsp;</button></h4> <input type="hidden" id="selectedShopRoomNameId" name="selectedShopRoomName" value="${selectedShopRoomName}"> </form> </div> </div> </div> </div>
			<div class="row"> <div class="col-md-12 col-sm-12"> <div class="bot_adjustment_5"> <table class="sreg_dsn_curated_cb_rigtext_dspl shop_tbl_arwdt"><tr> <td class="shop_ar_txt_wws">${selectedShopRoomName}</td> </tr></table> </div> </div> </div> 
			<%
				byte[] conBoardsImageFromDB = (byte[]) session.getAttribute("shopConceptBoardsBigImageInSn");
				String conceptBoardBigImage = null;
				if(null != conBoardsImageFromDB) { String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB); conceptBoardBigImage = "data:image/jpg;base64," +b64; }
			%>
			<div class="row"> <div class="col-md-12 col-sm-12" align="center">
			<a class="example-image-link" id="bigTopimageIdDsp" data-lightbox="example-1"> <img src="<%=conceptBoardBigImage%>" class="big_top_image_dsp big_image_disply_proper_cl left_adjustment_0"> </a> </div> </div> </div>
			<div class="col-md-1 col-sm-1">
			<%		    	
				String shopMostPopularStatus = (String) session.getAttribute("shopMostPopularStatusInSn");
				if(("Most Popular").equals(shopMostPopularStatus)) {	
			%>				    					    		
			<img src="resources/images/shop/most_popular_img.png" width="150" height="150" class="shop_lar_pmtml">				    	
			<% } %> 
			<div align="left" class="shop_arr_adj_tbl">					 			
			<% if(currentcount < (totalCBProductsCount-1)) { %>
				<form action="nextShopCBProductsDisplay"> <input type="image" src="resources/images/registry/rcb_right_arrow_img.png" class="top_adjustment_55"> <input type="hidden" name="shopCBRoomsCount" value="<%=currentcount%>"> <input type="hidden" name="selectedShopRoomName" value="${selectedShopRoomName}"> </form>
			<% } %> </div>
			<img src="resources/images/shop/shop_arrow_img.png" id="showArrowClickId" width="78" height="100" class="shop_rar_pmtmlc"> </div>
			<% } %> </div> </div> <div class="col-md-1 col-sm-1"></div> </div> </div> 
			<div id="mainframe" class="section-content"> <div class="container"> <div class="row bot_adjustment_110"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10 bot_adjustment_95" id="bottomDataDisplayId">	         
	        
<!-- Products List DIsplay Code Start -->		      		
			<% 
				if (null != session.getAttribute("shopProductSavingIdsListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductSavingIdsList = (ArrayList) session.getAttribute("shopProductSavingIdsListInSn"); if (null != shopProductSavingIdsList && shopProductSavingIdsList.size() > 0) {					
				if (null != session.getAttribute("shopProductImages1ListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductImages1List = (ArrayList) session.getAttribute("shopProductImages1ListInSn"); if (null != shopProductImages1List && shopProductImages1List.size() > 0) {						   
				if (null != session.getAttribute("shopProductNamesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductNamesList = (ArrayList) session.getAttribute("shopProductNamesListInSn"); if (null != shopProductNamesList && shopProductNamesList.size() > 0) {					   
				if (null != session.getAttribute("shopProductStoreNamesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductStoreNamesList = (ArrayList) session.getAttribute("shopProductStoreNamesListInSn"); if (null != shopProductStoreNamesList && shopProductStoreNamesList.size() > 0) {						   
				if (null != session.getAttribute("shopProductPricesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductPricesList = (ArrayList) session.getAttribute("shopProductPricesListInSn"); if (null != shopProductPricesList && shopProductPricesList.size() > 0) {					   
				if (null != session.getAttribute("shopProductPopUpValuesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductPopUpValuesList = (ArrayList) session.getAttribute("shopProductPopUpValuesListInSn"); if (null != shopProductPopUpValuesList && shopProductPopUpValuesList.size() > 0) {					
				if (null != session.getAttribute("shopProductImages2ListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductImages2List = (ArrayList) session.getAttribute("shopProductImages2ListInSn"); if (null != shopProductImages2List && shopProductImages2List.size() > 0) {					
				if (null != session.getAttribute("shopProductImages3ListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductImages3List = (ArrayList) session.getAttribute("shopProductImages3ListInSn"); if (null != shopProductImages3List && shopProductImages3List.size() > 0) {					
				if (null != session.getAttribute("shopProductImages4ListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopProductImages4List = (ArrayList) session.getAttribute("shopProductImages4ListInSn"); if (null != shopProductImages4List && shopProductImages4List.size() > 0) {				
			%> 
			<div class="row top_adjustment_120">
			<% for(int i=0; i<shopProductSavingIdsList.size(); i++) { int count = (i + 1); String regiFurnSpecPopUpValuesSt = (String) shopProductPopUpValuesList.get(i); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("\"", "DoubleQuotes"); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("\'", "SingleQuotes"); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("&#034;", "DoubleQuotes");
				regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("&#039;", "SingleQuotes"); byte[] conBoardSmlImagesFromDB = (byte[]) shopProductImages1List.get(i); String conceptBoardsMainImage1 = null; String conceptBoardsSmlImage1 = null;
		        if(null != conBoardSmlImagesFromDB) { String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardSmlImagesFromDB); conceptBoardsMainImage1 = "data:image/jpg;base64," +b64; conceptBoardsSmlImage1 = b64; }		        	
		        byte[] furnSpecProductImage2List = (byte[]) shopProductImages2List.get(i); String conceptBoardsSmlImage2 = null;
		        if(null != furnSpecProductImage2List) { conceptBoardsSmlImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage2List); }		        	
		        byte[] furnSpecProductImage3List = (byte[]) shopProductImages3List.get(i); String conceptBoardsSmlImage3 = null;
		        if(null != furnSpecProductImage3List) { conceptBoardsSmlImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage3List); }		        	
		        byte[] furnSpecProductImage4List = (byte[]) shopProductImages4List.get(i); String conceptBoardsSmlImage4 = null;
		        if(null != furnSpecProductImage4List) { conceptBoardsSmlImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage4List); }
		        String allpopdataRedirection = conceptBoardsSmlImage1 + "_,_" + conceptBoardsSmlImage2 + "_,_" + conceptBoardsSmlImage3 + "_,_" + conceptBoardsSmlImage4 + "_,_" + regiFurnSpecPopUpValuesSt;		        	
			%>
			<div class="col-md-3 col-sm-3 shop_mid_frm_mbd"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
			<img src="<%=conceptBoardsMainImage1%>" id="image<%=count%>Id" onClick="furnamtureSpecProductInfo('<%=allpopdataRedirection%>')" class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" style="cursor: pointer;"> </div> </div> 
			<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">									
			<div class="reg_bott_text_hd_dspl1"><%=shopProductNamesList.get(i)%></div> </div>
			<div class="reg_mid_ita_text_frame_dspl"> <font class="reg_bott_small_ita_text_dspl"><%=shopProductStoreNamesList.get(i)%></font> </div>						
			<div align="left" class="fur_spec_prod_price_dspl"> $<%=shopProductPricesList.get(i)%> </div>
			<div align="center" class="shop_mfrm_mbmt_cl"> <h4><button class="reg_fur_spec_submit_Btn" id="furnamtureSpecProductId" onClick="furnamtureSpecProductInfo('<%=allpopdataRedirection%>')">ADD TO CART</button></h4> </div> </div> </div> </div> </div>		        			        				        	
			<% } %> </div> <% } } } } } } } } } } } } } } } } } } %> </div> </div>	 	
		 	
<!-- Pop up Code Start -->		 	
		<div id="boxes"> <div class="regcb_popup_wt_htd_cl" id="mask"></div>        
        <div align="center" style="width: 78%; height: 95%; display: none; margin-top: -0.8%; padding: 20px; z-index: 10001; position:fixed; left: 50%; top: 50%; -ms-transform: translate(-3%,0%); -moz-transform:translate(-3%,0%); -webkit-transform: translate(-3%,0%); transform: translate(-3%,0%)" id="dialog" class="window">
   		<div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" class="shop_puclose_ctlp"></a></div>   		
   		<div class="container-fluid">
        <div class="row"> 
   		
   		<div class="col-md-6 col-sm-6">
   			<div class="row"> 		
			<div class="col-md-12 col-sm-12 col-xs-12"> 
				<img id="bigImgDsplayCl" class="popup_bigimage_dsp"> 
			</div>
			</div>
		
			<div class="popup_sml_img_frame">    			
				<div class="row">
				<div class="col-md-1 col-sm-1"></div>
				<div class="col-md-10 col-sm-10">
					<div class="row"> 
						<div class="col-md-3 col-sm-3"> <img class="smlImgClickCl" id="popupImage1Id"> </div>
						<div class="col-md-3 col-sm-3"> <img class="smlImgClickCl" id="popupImage2Id"> </div>				        	
						<div class="col-md-3 col-sm-3"> <img class="smlImgClickCl" id="popupImage3Id"> </div>
						<div class="col-md-3 col-sm-3"> <img class="smlImgClickCl" id="popupImage4Id"> </div>
					</div>
				</div>
				<div class="col-md-1 col-sm-1"></div>
				</div> 
			</div>
		</div>
					        
		<div class="col-md-6 col-sm-6 regicb_popup_mtppdn">
		<form action="shopSelectedCBProductsAddToCart" method="POST">
		<div class="reg_popup_prod_name_hd top_adjustment_10"><font id="shopProductNameDspId"></font></div>
		<div class="reg_popup_prod_store_name_hd"><font id="shopProductStoreNameDspId"></font></div>
		<div class="reg_popup_prod_price_hd" id="displaySelectPriceID" style="display: none;">$<font id="shopProductPriceID"></font></div>			        	
		<div class="reg_popup_prod_price_hd" id="displayDBPriceID">$<font id="regPriceDesp1ID"></font></div>
		
		<div class="regi_sc_enbl_gg_text_dsp">BETTER PRICE GUARANTEE&nbsp;&nbsp; <div class="mytooltip1" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer;" class="fa">&#xf059;</i>
	    	<span class="mytext1" style="margin-top: -40px;"> We'll not only match the retailer's listed price on their website, but we offer an automatic 5% off the product at checkout! <br><br>No coupon code needed </span> </div>
	    </div>
	    
		<div class="regi_popup_prdt_sub_frame"> <div align="left" class="reg_popup_prod_quantity_hd top_adjustment_15">QUANTITY</div>
		<div align="left"> <select id="productQuantityId" name="productQuantity" class="reg_popup_prod_sele_box_quantity"> 
		<option value="1">1</option> <option value="2">2</option> <option value="3">3</option> <option value="4">4</option> <option value="5">5</option> <option value="6">6</option> <option value="7">7</option> <option value="8">8</option> <option value="9">9</option> <option value="10">10</option> </select> </div>
		<div class="reg_popup_prod_quantity_hd top_adjustment_15"> <div style="margin-top: 15px;" id="sizeTableDisplayId">
		<table> <tr> <td align="left" class="reg_popup_prod_quantity_hd shop_popup_sel_txt">SELECT: &nbsp;</td><tr>
		<tr><td align="left"> <select id="selectedSizeId" class="reg_popup_prod_sel_box_size bot_adjustment_8" name="registrySize"> </select> </td></tr> </table> </div>
		<div class="top_adjustment_25"> <button class="shop_add_to_cart_sub_butt" onclick="addProductToRegistryLanding()">ADD TO CART</button> </div> </div> </div>
		 <div class="top_adjustment_25"> <div class="reg_popup_prod_quantity_hd" style="font-weight: bold;">DESCRIPTION</div>
		<div class="reg_popup_prod_quantity_hd bot_adjustment_5" id="productDescShowHide1ID"><font id="regProductDesc1ID"></font></div> </div>
		<input type="hidden" id="shopProductInfoSavingId" name="shopCBProductsSavingId"> <input type="hidden" name="selectedShopRoomName" value="${selectedShopRoomName}">			        	
		<%-- <input type="hidden" name="registryViewProducts" value="${registryViewProducts}"> --%> <!-- <input type="hidden" id="shopProductStoreNameId" name="shopProductStoreName"> --> <!-- <input type="hidden" id="shopProductDescriptionId" name="shopProductDescription"> -->
		<input type="hidden" name="registryPrice" value="${registryPrice}"> <input type="hidden" id="shopProductSizeId" name="shopProductSize"> <input type="hidden" id="shopProductPriceId" name="shopProductPrice"> <input type="hidden" id="shopProductNameId" name="shopProductName"> <input type="hidden" id="shopProductImageId" name="shopProductImage"> </form> 
		</div> </div> </div> </div> </div>   
<!-- Pop up Code End -->       
        </div> </div>           
		</body>
</html>