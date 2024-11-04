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
    <link rel="stylesheet" href="resources/css/registry_css/registry_concept_boards.css" type="text/css"> 
    <link rel="stylesheet" href="resources/css/registry_shop/1_shop_home.css" type="text/css">
    <script type="text/javascript" src="resources/js/popup/shop_popup_ft_products_info_dsp.js"></script>
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
    <link rel="stylesheet" href="resources/css/popup/lightbox_for_registry.css" media="screen"/>
    <script async defer src="//assets.pinterest.com/js/pinit.js"></script>
	
	<script type="text/javascript">	
	$(document).ready(function () { var shopFTSelectedCategory1 = "<c:out value="${shopFTSelectedCategory}"/>"; var shopFTSelectedCategoryVal = shopFTSelectedCategory1.replace(" ", "_"); $("#"+shopFTSelectedCategoryVal).css("color","red"); $("#"+shopFTSelectedCategoryVal).css("text-decoration","underline"); });
	
	function typeOfRoomForShop(shopRoomName) { document.shopRoomFormName.selectedShopRoomName.value = shopRoomName; $("#shopRoomFormId").submit(); }
	function typeOfFinishingTouches(finishingTouchesName) { document.finishingTouchesFormName.shopFTSelectedCategory.value = finishingTouchesName; $("#finishingTouchesFormId").submit(); }
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
			
		<div id="mmenu_screen" class="container-fluid main_container ft_view_top_frame_dsp">
			<div class="row top_adjustment_0"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10">
		    <div class="row"> <div class="col-md-2 col-sm-2"> <div class="cb_view_top_pdng_dsp">
			<div class="reg_vconbord_top_radio_but_box ft_view_top_mgtp_mgrt_cl"><font class="reg_con_bord_top_txt_fl">R</font><font class="reg_con_bord_top_txt_ll">OOMS</font></div>
			<div class="cb_view_top_pdnl_mgtp_cl">
			<div id="Living_Room" class="cb_room_selection_text" onclick="typeOfRoomForShop('Living Room');"><font class="cb_room_selection_text_fl">L</font>iving <font class="cb_room_selection_text_fl">R</font>oom</div>
			<div id="Dining_Room" class="cb_room_selection_text" onclick="typeOfRoomForShop('Dining Room');"><font class="cb_room_selection_text_fl">D</font>ining <font class="cb_room_selection_text_fl">R</font>oom</div>
			<div id="Bedroom" class="cb_room_selection_text" onclick="typeOfRoomForShop('Bedroom');"><font class="cb_room_selection_text_fl">B</font>edroom</div>
			<div id="Home_Office" class="cb_room_selection_text" onclick="typeOfRoomForShop('Home Office');"><font class="cb_room_selection_text_fl">H</font>ome <font class="cb_room_selection_text_fl">O</font>ffice</div>
			<div id="Entryway" class="cb_room_selection_text" onclick="typeOfRoomForShop('Entryway');"><font class="cb_room_selection_text_fl">E</font>ntryway</div>
			<div id="Nursery" class="cb_room_selection_text" onclick="typeOfRoomForShop('Nursery');"><font class="cb_room_selection_text_fl">N</font>ursery</div>
			<div id="Kids_Bedroom" class="cb_room_selection_text" onclick="typeOfRoomForShop('Kids Bedroom');"><font class="cb_room_selection_text_fl">K</font>ids <font class="cb_room_selection_text_fl">B</font>edroom</div>
			<div id="Outdoor_Space" class="cb_room_selection_text" onclick="typeOfRoomForShop('Outdoor Space');"><font class="cb_room_selection_text_fl">O</font>utdoor <font class="cb_room_selection_text_fl">S</font>pace</div> </div> 
			
			<div class="reg_vconbord_top_radio_but_box ft_view_top_mgtp_mgrt_cl" style="margin-top: 30px;"><font class="reg_con_bord_top_txt_fl">F</font><font class="reg_con_bord_top_txt_ll">INISHING </font><font class="reg_con_bord_top_txt_fl">T</font><font class="reg_con_bord_top_txt_ll">OUCHES</font></div>
			<div class="cb_view_top_pdnl_mgtp_cl">
			<div id="Curtains" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Curtains');"><font class="cb_room_selection_text_fl">C</font>urtains</div>
			<div id="Bedding" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Bedding');"><font class="cb_room_selection_text_fl">B</font>edding</div>
			<div id="Pillows" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Pillows');"><font class="cb_room_selection_text_fl">P</font>illows</div>
			<div id="Throws" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Throws');"><font class="cb_room_selection_text_fl">T</font>hrows</div>
			<div id="Kitchen_&_Dining" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Kitchen & Dining');"><font class="cb_room_selection_text_fl">K</font>itchen <font class="cb_room_selection_text_fl">&amp; </font> <font class="cb_room_selection_text_fl">D</font>ining</div>
			<div id="Home_Accessories" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Home Accessories');"><font class="cb_room_selection_text_fl">H</font>ome <font class="cb_room_selection_text_fl">A</font>ccessories</div>
			<div id="Mattresses" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Mattresses');"><font class="cb_room_selection_text_fl">M</font>attresses</div>			
			<div id="Lighting" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Lighting');"><font class="cb_room_selection_text_fl">L</font>ighting</div> </div>
			
			</div> </div>
			
			<div class="col-md-8 col-sm-8">			
			<div style="margin-left: 40px; margin-right: 40px;">
			
	    		<div class="row"> <div class="col-md-12 col-sm-12"> <div align="left" class="reg_dsn_curated_cb_title_text text-left"> <h4><font class="reg_dsn_curated_cb_title_fl">C</font><font class="reg_dsn_curated_cb_title_ll">URATED </font> <font class="reg_dsn_curated_cb_title_fl">D</font><font class="reg_dsn_curated_cb_title_ll">ESIGN </font><font class="reg_dsn_curated_cb_title_fl">B</font><font class="reg_dsn_curated_cb_title_ll">OARDS</font></h4> </div> </div></div>
				
				<div style="margin-left: 0px; margin-top: 15px;" align="left" class="reg_dsn_curated_cb_rigtext_dspl"> ${shopFTSelectedCategory} </div>	         
	        
<!-- Products List DIsplay Code Start -->		      		
			<% 
				if (null != session.getAttribute("shopFTProductSavingIdsListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductSavingIdsList = (ArrayList) session.getAttribute("shopFTProductSavingIdsListInSn"); if (null != shopFTProductSavingIdsList && shopFTProductSavingIdsList.size() > 0) {			
				if (null != session.getAttribute("shopFTProductImages1ListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductImages1List = (ArrayList) session.getAttribute("shopFTProductImages1ListInSn"); if (null != shopFTProductImages1List && shopFTProductImages1List.size() > 0) {						   
				if (null != session.getAttribute("shopFTProductNamesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductNamesList = (ArrayList) session.getAttribute("shopFTProductNamesListInSn"); if (null != shopFTProductNamesList && shopFTProductNamesList.size() > 0) {					   
				if (null != session.getAttribute("shopFTProductStoreNamesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductStoreNamesList = (ArrayList) session.getAttribute("shopFTProductStoreNamesListInSn"); if (null != shopFTProductStoreNamesList && shopFTProductStoreNamesList.size() > 0) {						   
				if (null != session.getAttribute("shopFTProductPricesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductPricesList = (ArrayList) session.getAttribute("shopFTProductPricesListInSn"); if (null != shopFTProductPricesList && shopFTProductPricesList.size() > 0) {					   
				if (null != session.getAttribute("shopFTProductPopUpValuesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductPopUpValuesList = (ArrayList) session.getAttribute("shopFTProductPopUpValuesListInSn"); if (null != shopFTProductPopUpValuesList && shopFTProductPopUpValuesList.size() > 0) {					
				if (null != session.getAttribute("shopFTProductImages2ListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductImages2List = (ArrayList) session.getAttribute("shopFTProductImages2ListInSn"); if (null != shopFTProductImages2List && shopFTProductImages2List.size() > 0) {					
				if (null != session.getAttribute("shopFTProductImages3ListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductImages3List = (ArrayList) session.getAttribute("shopFTProductImages3ListInSn"); if (null != shopFTProductImages3List && shopFTProductImages3List.size() > 0) {					
				if (null != session.getAttribute("shopFTProductImages4ListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopFTProductImages4List = (ArrayList) session.getAttribute("shopFTProductImages4ListInSn"); if (null != shopFTProductImages4List && shopFTProductImages4List.size() > 0) {				
			%> 
			<div class="row top_adjustment_20">
			<% for(int i=0; i<shopFTProductSavingIdsList.size(); i++) { int count = (i + 1); String regiFurnSpecPopUpValuesSt = (String) shopFTProductPopUpValuesList.get(i); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("\"", "DoubleQuotes"); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("\'", "SingleQuotes"); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("&#034;", "DoubleQuotes");
				regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("&#039;", "SingleQuotes"); byte[] conBoardSmlImagesFromDB = (byte[]) shopFTProductImages1List.get(i); String conceptBoardsMainImage1 = null; String conceptBoardsSmlImage1 = null;
		        if(null != conBoardSmlImagesFromDB) { String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardSmlImagesFromDB); conceptBoardsMainImage1 = "data:image/jpg;base64," +b64; conceptBoardsSmlImage1 = b64; }		        	
		        byte[] furnSpecProductImage2List = (byte[]) shopFTProductImages2List.get(i); String conceptBoardsSmlImage2 = null;
		        if(null != furnSpecProductImage2List) { conceptBoardsSmlImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage2List); }		        	
		        byte[] furnSpecProductImage3List = (byte[]) shopFTProductImages3List.get(i); String conceptBoardsSmlImage3 = null;
		        if(null != furnSpecProductImage3List) { conceptBoardsSmlImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage3List); }		        	
		        byte[] furnSpecProductImage4List = (byte[]) shopFTProductImages4List.get(i); String conceptBoardsSmlImage4 = null;
		        if(null != furnSpecProductImage4List) { conceptBoardsSmlImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage4List); }
		        String allpopdataRedirection = conceptBoardsSmlImage1 + "_,_" + conceptBoardsSmlImage2 + "_,_" + conceptBoardsSmlImage3 + "_,_" + conceptBoardsSmlImage4 + "_,_" + regiFurnSpecPopUpValuesSt;		        	
			%>
			<div class="col-md-3 col-sm-3 shop_mid_frm_mbd"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
			<img src="<%=conceptBoardsMainImage1%>" id="image<%=count%>Id" onClick="furnamtureSpecProductInfo('<%=allpopdataRedirection%>')" class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" style="cursor: pointer;"> </div> </div> 
			<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">									
			<div class="reg_bott_text_hd_dspl1"><%=shopFTProductNamesList.get(i)%></div> </div>
			<div class="reg_mid_ita_text_frame_dspl"> <font class="reg_bott_small_ita_text_dspl"><%=shopFTProductStoreNamesList.get(i)%></font> </div>						
			<div align="left" class="fur_spec_prod_price_dspl"> $<%=shopFTProductPricesList.get(i)%> </div>
			<div align="center" class="shop_mfrm_mbmt_cl"> <h4><button class="reg_fur_spec_submit_Btn" id="furnamtureSpecProductId" onClick="furnamtureSpecProductInfo('<%=allpopdataRedirection%>')">ADD TO CART</button></h4> </div> </div> </div> </div> </div>		        			        				        	
			<% } %> </div> <% } } } } } } } } } } } } } } } } } } %>
		      
        	</div> </div> </div>
			
		</div> <div class="col-md-1 col-sm-1"></div> </div> </div>
		
			
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
		<form action="shopSelectedFTProductsAddToCart" method="POST">
		<div class="reg_popup_prod_name_hd top_adjustment_10"><font id="shopFTProductNameDspId"></font></div>
		<div class="reg_popup_prod_store_name_hd"><font id="shopFTProductStoreNameDspId"></font></div>
		<div class="reg_popup_prod_price_hd" id="displaySelectPriceID" style="display: none;">$<font id="shopFTProductPriceID"></font></div>			        	
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
		<input type="hidden" id="shopFTProductInfoSavingId" name="shopFTProductsSavingId"> <input type="hidden" name="selectedShopRoomName" value="${selectedShopRoomName}">			        	
		<%-- <input type="hidden" name="registryViewProducts" value="${registryViewProducts}"> --%> <!-- <input type="hidden" id="shopFTProductStoreNameId" name="shopFTProductStoreName"> --> <!-- <input type="hidden" id="shopFTProductDescriptionId" name="shopFTProductDescription"> -->
		<input type="hidden" name="registryPrice" value="${registryPrice}"> <input type="hidden" id="shopFTProductSizeId" name="shopFTProductSize"> <input type="hidden" id="shopFTProductPriceId" name="shopFTProductPrice"> <input type="hidden" id="shopFTProductNameId" name="shopFTProductName"> <input type="hidden" id="shopFTProductImageId" name="shopFTProductImage"> <input type="hidden" name="shopFTSelectedCategory" value="${shopFTSelectedCategory}"> </form> 
		</div> </div> </div> </div> </div>   
<!-- Pop up Code End --> 

		<form action="shopViewAllDesignsConcepts" id="shopRoomFormId" name="shopRoomFormName" method="GET">
        	<input type="hidden" id="selectedShopRoomNameId" name="selectedShopRoomName">
        	<input type="hidden" id="shopCBRoomsCountId" name="shopCBRoomsCount" value="0">              
      	</form>
	       	
	    <form action="shopFinTouchesSelectedProducts" id="finishingTouchesFormId" name="finishingTouchesFormName" method="POST">
        	<input type="hidden" id="shopFTSelectedCategoryId" name="shopFTSelectedCategory">               
        </form>           
		</body>
</html>