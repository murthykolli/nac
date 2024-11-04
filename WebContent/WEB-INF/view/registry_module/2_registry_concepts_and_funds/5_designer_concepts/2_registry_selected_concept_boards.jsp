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
	<script type="text/javascript" src="resources/js/popup/registry_popup_products_info_dsp.js"></script>
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
    <link rel="stylesheet" href="resources/css/popup/lightbox_for_registry.css" media="screen"/>
	
	<script type="text/javascript">	
	$(document).ready(function () { 
		$("#enableGroupOffId").click(function () { $("#enableGroupOffId").hide(); $("#enableGroupOnId").show(); $("#enableGroupGiftId").val(""); });	
		$("#enableGroupOnId").click(function () { $("#enableGroupOffId").show(); $("#enableGroupOnId").hide(); $("#enableGroupGiftId").val("Enable Group Gift"); });		
		$('.big_top_image_dsp').click(function() { var viewImgs = $(this).attr("src"); $("#bigTopimageIdDsp").attr("href", viewImgs); });	
		$('.big_image_dsp').click(function() { var viewImgs = $(this).attr("src"); var imgId = $(this).attr("id"); $("#"+imgId+"Dsp").attr("href", viewImgs); });
 	 	var words = $('#cbRoomFNameTextId').text().split(' '); var html = ''; $.each(words, function() { html += '<span class="first_letter_dsp">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; });
 	 	$('#cbRoomFNameTextId').html(html); $("#showArrowClickId").click(function (){ $('html, body').animate({scrollTop: $('#bottomDataDisplayId').offset().top}, 0); }); });		
	function addProductToRegistryLanding() { alert("This product has been added to your Registry"); }		
	</script>
	
	</head>	
		<body>	
		<div id="mmenu_screen" class="container-fluid main_container reg_con_brd_top_frame_mtb_cl">
		    <div class="row"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10"> <div class="row">        
			<% int currentcount = (int) session.getAttribute("registryCBRoomCountInSn"); int totalCBProductsCount = (int) session.getAttribute("totalCBProductsCountInSn"); if(totalCBProductsCount > 0) { %> 
		    <div class="col-md-1 col-sm-1"> <div align="right"> <div class="reg_con_brd_lftc_adj_cl">
		    <div class="reg_con_brd_lftc_mltp_cl">				        
			<div align="right" class="reg_con_bor_txt_flsc_mltp_cl">DESIGN PRICE STARTING <br><font class="reg_con_brd_lft_wtsp_cl">AT $${allProductsTotalPrice}</font></div>
			<div align="right" class="reg_con_bor_txt_lft_cl">APPROX. ${guestsWatchedCount} GUESTS TO FULFILL THIS LOOK.</div>			
			<div align="right" class="top_adjustment_15"><a href="resources/images/registry/cb_learn_more_image.png" class="example-image-link reg_cb_bor_learn_more" data-lightbox="example-1">LEARN MORE</a></div> </div> 
			
			<% 	if(currentcount > 0) { %>
			<form action="previousCBProductsDisplay"> <input type="image" src="resources/images/registry/rcb_left_arrow_img.png"> <input type="hidden" name="registryCBRoomCount" value="<%=currentcount%>"> <input type="hidden" name="registrySpaceRoom" value="${registrySpaceRoom}"> </form> 
			<% } else { %> 
			<div style="height: 90px;"></div>
			<% } %>
			</div> </div>
			</div>
			
			<div class="col-md-10 col-sm-10"> <div class="row" style="margin-top: -8px; padding-bottom: 15px;"> <div class="col-md-7 col-sm-7"> <div align="left" class="reg_dsn_curated_cb_title_text text-left"> <h4><font class="reg_dsn_curated_cb_title_fl">C</font><font class="reg_dsn_curated_cb_title_ll">URATED </font> <font class="reg_dsn_curated_cb_title_fl">D</font><font class="reg_dsn_curated_cb_title_ll">ESIGN </font><font class="reg_dsn_curated_cb_title_fl">B</font><font class="reg_dsn_curated_cb_title_ll">OARDS</font></h4> </div> </div>
			<div align="right" class="col-md-5 col-sm-5"> <div class="row"> <div align="right" class="col-md-12 col-sm-12" style="position: relative; top: 20px;">
			<form action="registryViewAllDesigns" method="POST"> <h4><button class="reg_con_cur_bod_submit_Btn" id="addBoardsId"><font class="reg_con_cur_bod_submit_Btn_flt">&nbsp;V</font>IEW <font class="reg_con_cur_bod_submit_Btn_flt">A</font>LL <font class="reg_con_cur_bod_submit_Btn_flt">D</font>ESIGNS&nbsp;</button></h4> <input type="hidden" id="registrySpaceRoomId" name="registrySpaceRoom" value="${registrySpaceRoom}"> </form>
			</div> </div> </div> </div>
			<div class="row"> <div class="col-md-12 col-sm-12"> <div class="bot_adjustment_5"> <table style="width: 950px; min-height: 30px; height: auto;" class="reg_dsn_curated_cb_rigtext_dspl"><tr> <td style="width: 300px; white-space: nowrap;" id="cbRoomFNameTextId">${registrySpaceRoom}</td> </tr></table> </div> </div> </div>
			<% 	byte[] conBoardsImageFromDB = (byte[]) session.getAttribute("conceptBoardsBigImage"); String conceptBoardBigImage = null; 
				if(null != conBoardsImageFromDB) { String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImageFromDB); conceptBoardBigImage = "data:image/jpg;base64," +b64; } %>
				<div class="row"> <div class="col-md-12 col-sm-12" align="center"> <a class="example-image-link" id="bigTopimageIdDsp" data-lightbox="example-1"> <img src="<%=conceptBoardBigImage%>" class="big_top_image_dsp big_image_disply_proper_cl left_adjustment_0"> </a> </div> </div> </div>
				<div class="col-md-1 col-sm-1"> <div align="left" class="rcb_rt_htadj_cl">
				<% if(currentcount < (totalCBProductsCount-1)) { %>
				<form action="nextCBProductsDisplay"> <input type="image" src="resources/images/registry/rcb_right_arrow_img.png"> <input type="hidden" name="registryCBRoomCount" value="<%=currentcount%>"> <input type="hidden" name="registrySpaceRoom" value="${registrySpaceRoom}"> </form> <% } %> </div> <img src="resources/images/shop/shop_arrow_img.png" id="showArrowClickId" width="78" height="100" class="rcb_rt_img_adj_cl"> </div>
			    <% } %> 
				</div>		          		
		    	</div> <div class="col-md-1 col-sm-1"></div> </div> </div>		
			         
		<div id="mainframe" class="section-content"> <div class="container">	        
	    <div class="row top_adjustment_0"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10 rcb_mtop_ht_adj_cl" id="bottomDataDisplayId">	         
	        
<!-- Products List DIsplay Code Start -->		      		
				<% 	if (null != session.getAttribute("regFurnSpecSavingIdList")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecSavingIdList = (ArrayList) session.getAttribute("regFurnSpecSavingIdList"); if (null != regiFurnSpecSavingIdList && regiFurnSpecSavingIdList.size() > 0) {
					if (null != session.getAttribute("regFurnSpecProductImageList")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecProductImageList = (ArrayList) session.getAttribute("regFurnSpecProductImageList"); if (null != regiFurnSpecProductImageList && regiFurnSpecProductImageList.size() > 0) {
					if (null != session.getAttribute("regFurnSpecProductNameList")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecProductNameList = (ArrayList) session.getAttribute("regFurnSpecProductNameList"); if (null != regiFurnSpecProductNameList && regiFurnSpecProductNameList.size() > 0) {
					if (null != session.getAttribute("regFurnSpecStoreNameList")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecStoreNameList = (ArrayList) session.getAttribute("regFurnSpecStoreNameList"); if (null != regiFurnSpecStoreNameList && regiFurnSpecStoreNameList.size() > 0) {
					if (null != session.getAttribute("regFurnSpecProductPriceList")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecProductPriceList = (ArrayList) session.getAttribute("regFurnSpecProductPriceList"); if (null != regiFurnSpecProductPriceList && regiFurnSpecProductPriceList.size() > 0) {
					if (null != session.getAttribute("regFurnSpecPopUpValuesList")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecPopUpValuesList = (ArrayList) session.getAttribute("regFurnSpecPopUpValuesList"); if (null != regiFurnSpecPopUpValuesList && regiFurnSpecPopUpValuesList.size() > 0) {
					if (null != session.getAttribute("regFurnSpecProductImage2List")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecProductImage2List = (ArrayList) session.getAttribute("regFurnSpecProductImage2List"); if (null != regiFurnSpecProductImage2List && regiFurnSpecProductImage2List.size() > 0) {
					if (null != session.getAttribute("regFurnSpecProductImage3List")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecProductImage3List = (ArrayList) session.getAttribute("regFurnSpecProductImage3List"); if (null != regiFurnSpecProductImage3List && regiFurnSpecProductImage3List.size() > 0) {
					if (null != session.getAttribute("regFurnSpecProductImage4List")) { @SuppressWarnings("rawtypes") ArrayList regiFurnSpecProductImage4List = (ArrayList) session.getAttribute("regFurnSpecProductImage4List"); if (null != regiFurnSpecProductImage4List && regiFurnSpecProductImage4List.size() > 0) {			
				%>							
				<div class="row top_adjustment_115">
				<% for(int i=0; i<regiFurnSpecSavingIdList.size(); i++) { int count = (i + 1);
					String regiFurnSpecPopUpValuesSt = (String) regiFurnSpecPopUpValuesList.get(i); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("\"", "DoubleQuotes"); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("\'", "SingleQuotes"); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("&#034;", "DoubleQuotes"); regiFurnSpecPopUpValuesSt = regiFurnSpecPopUpValuesSt.replace("&#039;", "SingleQuotes"); byte[] conBoardSmlImagesFromDB = (byte[]) regiFurnSpecProductImageList.get(i); String conceptBoardsMainImage1 = null; String conceptBoardsSmlImage1 = null;
		        	if(null != conBoardSmlImagesFromDB) { String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardSmlImagesFromDB); conceptBoardsMainImage1 = "data:image/jpg;base64," +b64; conceptBoardsSmlImage1 = b64; }		        	
		        	byte[] furnSpecProductImage2List = (byte[]) regiFurnSpecProductImage2List.get(i); String conceptBoardsSmlImage2 = null;
		        	if(null != furnSpecProductImage2List) { conceptBoardsSmlImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage2List); }		        	
		        	byte[] furnSpecProductImage3List = (byte[]) regiFurnSpecProductImage3List.get(i); String conceptBoardsSmlImage3 = null;
		        	if(null != furnSpecProductImage3List) { conceptBoardsSmlImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage3List); }		        	
		        	byte[] furnSpecProductImage4List = (byte[]) regiFurnSpecProductImage4List.get(i); String conceptBoardsSmlImage4 = null;
		        	if(null != furnSpecProductImage4List) { conceptBoardsSmlImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage4List); }
		        	String allpopdataRedirection = conceptBoardsSmlImage1 + "_,_" + conceptBoardsSmlImage2 + "_,_" + conceptBoardsSmlImage3 + "_,_" + conceptBoardsSmlImage4 + "_,_" + regiFurnSpecPopUpValuesSt;
		        %>
					<div class="col-md-3 col-sm-3 rcb_midfrm_mbot_adj_cl"> <div class="reg_landing_images_and_text_frame">
					<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img src="<%=conceptBoardsMainImage1%>" id="image<%=count%>Id" onClick="furnamtureSpecProductInfo('<%=allpopdataRedirection%>')" class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1 rcb_midfrm_cur_pot_adj_cl"> </div> </div>
					<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=regiFurnSpecProductNameList.get(i)%></div> </div>
					<div class="reg_mid_ita_text_frame_dspl"> <font class="reg_bott_small_ita_text_dspl"><%=regiFurnSpecStoreNameList.get(i)%></font> </div>						
					<div align="left" class="fur_spec_prod_price_dspl"> $<%=regiFurnSpecProductPriceList.get(i)%> </div>
					<div align="center" class="rcb_midfrm_mbottp_adj_cl"> <h4><button class="reg_fur_spec_submit_Btn" id="furnamtureSpecProductId" onClick="furnamtureSpecProductInfo('<%=allpopdataRedirection%>')">ADD TO REGISTRY</button></h4> </div> </div> </div> </div> </div>		        			        				        	
				<% } %>
			 	</div>			 			
			 	<% } } } } } } } } } } } } } } } } } } %>
		        </div> <div class="col-md-1 col-sm-1"></div> </div>	 	
		 	
<!-- Pop up Code Start -->		 	
	<div id="boxes"> <div class="regcb_popup_wt_htd_cl" id="mask"></div>        
        <div align="center" style="width: 78%; height: 95%; display: none; margin-top: -0.8%; padding: 20px; z-index: 10001; position:fixed; left: 50%; top: 50%; -ms-transform: translate(-3%,0%); -moz-transform:translate(-3%,0%); -webkit-transform: translate(-3%,0%); transform: translate(-3%,0%)" id="dialog" class="window">
   		<div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" class="rcb_popup_cls_adj_cl"></a></div>   		
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
		<form action="registrySelectedCBdInfoSaving" method="POST">
		<div class="reg_popup_prod_name_hd"><font id="regProductNameID"></font></div>
		<div class="reg_popup_prod_store_name_hd"><font id="regProductStoreNameID"></font></div>
		<div class="reg_popup_prod_price_hd" id="displaySelectPriceID" style="display: none;">$<font id="regSelectedPriceID"></font></div>			        	
		<div class="reg_popup_prod_price_hd" id="displayDBPriceID">$<font id="regPriceDesp1ID"></font></div>
		
		<div class="regi_sc_enbl_gg_text_dsp">BETTER PRICE GUARANTEE&nbsp;&nbsp; <div class="mytooltip1" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer;" class="fa">&#xf059;</i>
	    	<span class="mytext1" style="margin-top: -40px;"> We'll not only match the retailer's listed price on their website, but we offer an automatic 5% off the product at checkout! <br><br>No coupon code needed </span> </div>
	    </div>
	    
		<div class="regi_popup_prdt_sub_frame"> <div align="left" class="reg_popup_prod_quantity_hd top_adjustment_40">QUANTITY</div>
		<div align="left"> <select id="productQuantityId" name="productQuantity" class="reg_popup_prod_sele_box_quantity"> <option value="1">1</option> <option value="2">2</option> <option value="3">3</option> <option value="4">4</option> <option value="5">5</option> <option value="6">6</option> <option value="7">7</option> <option value="8">8</option> <option value="9">9</option> <option value="10">10</option> </select> </div>
		<div class="reg_popup_prod_quantity_hd top_adjustment_15" style="margin-top: 15px;">
		<div id="enableGGTextDspYesId"> <div class="reg_sc_enb_gg_text_dsp">ENABLE GROUP GIFTING&nbsp;&nbsp; <div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer;" class="fa">&#xf059;</i>
	    <span class="mytext" style="margin-top: -105px;"> Receive cash contributions towards this item and purchase once the total has been met. <br><br>A nominal tax and shipping fee will be added to the group gift goal to ensure you have enough funds to purchase. <br><br>The group gifting feature cannot be disabled once contributions towards a gift have begun.</span> </div> </div> </div>
      	<div id="enableGGTextDspNoId" style="display: none;">
      	<div class="reg_sc_enb_gg_text_dsp">ENABLE GROUP GIFTING&nbsp;&nbsp; <div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer;" class="fa">&#xf059;</i>
	    <span class="mytext" style="margin-top: -15px;"> Either one or multiple guests have already contributed towards this item, therefore you can no longer disable the Group Gifting feature. </span> </div> </div> </div>
      	<div id="enableGGButtonDspYesId"> <div style="margin-top: 20px; cursor: pointer;" id="enableGroupOnId"> <div class="rcb_popup_bgbrd_frame_cl"> <div class="rcb_popup_bgrds_dsp"></div> </div> </div>
		<div style="margin-top: 20px; display: none; cursor: pointer;" id="enableGroupOffId"> <div class="rcb_popup_sec_bgbrd_frame"> <div class="rcb_popup_sec_bgrds_dsp"></div> </div> </div> </div>
		<div id="enableGGButtonDspNoId" style="display: none;"> <div style="margin-top: 20px; cursor: pointer;" id="enableGroupOn1Id"> <div class="rcb_popup_bgbrd_frame_cl"> <div class="rcb_popup_bgrds_dsp"></div> </div> </div>
		<div style="margin-top: 20px; display: none; cursor: pointer;" id="enableGroupOff1Id"> <div class="rcb_popup_sec_bgbrd_frame"> <div class="rcb_popup_sec_bgrds_dsp"></div> </div> </div> </div>
		<div class="top_adjustment_15" id="sizeTableDisplayId">
		<table> <tr> <td align="left" class="reg_popup_prod_quantity_hd" style="margin-top: 0px;font: 1em/1.25em Georgia; letter-spacing: 1px;">SELECT: &nbsp;</td><tr> <tr><td align="left"> <select id="selectedSizeId" class="reg_popup_prod_sel_box_size bot_adjustment_8" name="registrySize"> </select> </td></tr> </table> </div>
		<div class="top_adjustment_25"> <button class="regi_add_to_registry_sbut" onclick="addProductToRegistryLanding()">ADD TO REGISTRY</button> </div> </div> </div>
		<div class="top_adjustment_15"> <div class="reg_popup_prod_quantity_hd">DESCRIPTION</div> <div class="reg_popup_prod_quantity_hd bot_adjustment_7" id="productDescShowHide1ID"><font id="regProductDesc1ID"></font></div> </div>
		<input type="hidden" id="enableGroupGiftId" name="groupGiftRefferanceValue"> <input type="hidden" id="productInfoSavingId" name="productInfoSavingInfo"> <input type="hidden" name="registrySpaceRoom" value="${registrySpaceRoom}"> <input type="hidden" name="registryStyleName" value="${registryStyleName}"> <input type="hidden" name="registryViewProducts" value="${registryViewProducts}"> <input type="hidden" name="registryPrice" value="${registryPrice}"> <input type="hidden" id="regProductSizeId" name="regProductHeading"> <input type="hidden" id="registryPriceId" name="regProductPrice"> <input type="hidden" id="registryDescriptionId" name="registryDescription">
		</form>
		</div> </div> </div> </div> </div>   
<!-- Pop up Code End -->
       
        </div> </div>          
		</body>
</html>
