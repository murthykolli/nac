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
	<script type="text/javascript" src="resources/js/popup/registry_finishing_touches_popup_products_info.js"></script>
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
    <link rel="stylesheet" href="resources/css/popup/lightbox_for_registry.css" media="screen"/>
	
	<script type="text/javascript">	
	$(document).ready(function () {
		var regFTSelectedCategory1 = "<c:out value="${regFTSelectedCategory}"/>"; regFTSelectedCategory1 = regFTSelectedCategory1.replace("&amp; ", ""); 
		var regFTSelectedCategoryVal = regFTSelectedCategory1.replace(" ", "_"); $("#"+regFTSelectedCategoryVal).css("color","red"); $("#"+regFTSelectedCategoryVal).css("text-decoration","underline");		
	
		$("#enableGroupOffId").click(function () { $("#enableGroupOffId").hide(); $("#enableGroupOnId").show(); $("#enableGroupGiftId").val(""); });	
		$("#enableGroupOnId").click(function () { $("#enableGroupOffId").show(); $("#enableGroupOnId").hide(); $("#enableGroupGiftId").val("Enable Group Gift"); });		
		$('.big_top_image_dsp').click(function() { var viewImgs = $(this).attr("src"); $("#bigTopimageIdDsp").attr("href", viewImgs); });	
		$('.big_image_dsp').click(function() { var viewImgs = $(this).attr("src"); var imgId = $(this).attr("id"); $("#"+imgId+"Dsp").attr("href", viewImgs); });
 	 	var words = $('#cbRoomFNameTextId').text().split(' '); var html = ''; $.each(words, function() { html += '<span class="first_letter_dsp">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; });
 	 	$('#cbRoomFNameTextId').html(html); $("#showArrowClickId").click(function (){ $('html, body').animate({scrollTop: $('#bottomDataDisplayId').offset().top}, 0); }); });		
		
	function addProductToRegistryLanding() { alert("This product has been added to your Registry"); }
	
	function typeOfRoom(roomName) { document.regRoomSelect.registrySpaceRoom.value = roomName; $("#roomImgsFormId").submit(); }	
	function viewProductsForRegistry(id, count) { document.viewProductsFormName.registryViewProducts.value = id; document.viewProductsFormName.registryCBRoomCount.value = count; $("#viewProductsFormNameId").submit(); }
	function typeOfFinishingTouches(finishingTouchesName) { document.finishingTouchesFormName.regFTSelectedCategory.value = finishingTouchesName; $("#finishingTouchesFormId").submit(); }
	</script>
	
	</head>
	
	</head>	
		<body>
			
			<div id="mmenu_screen" class="container-fluid main_container cb_view_top_frame_dsp">
			<div class="row top_adjustment_0"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10">
		    <div class="row"> <div class="col-md-2 col-sm-2"> <div class="cb_view_top_pdng_dsp">
			<div class="reg_vconbord_top_radio_but_box ft_view_top_mgtp_mgrt_cl"><font class="reg_con_bord_top_txt_fl">R</font><font class="reg_con_bord_top_txt_ll">OOMS</font></div>
			<div class="cb_view_top_pdnl_mgtp_cl">
			<div id="Living_Room" class="cb_room_selection_text" onclick="typeOfRoom('Living Room');"><font class="cb_room_selection_text_fl">L</font>iving <font class="cb_room_selection_text_fl">R</font>oom</div>
			<div id="Dining_Room" class="cb_room_selection_text" onclick="typeOfRoom('Dining Room');"><font class="cb_room_selection_text_fl">D</font>ining <font class="cb_room_selection_text_fl">R</font>oom</div>
			<div id="Bedroom" class="cb_room_selection_text" onclick="typeOfRoom('Bedroom');"><font class="cb_room_selection_text_fl">B</font>edroom</div>
			<div id="Home_Office" class="cb_room_selection_text" onclick="typeOfRoom('Home Office');"><font class="cb_room_selection_text_fl">H</font>ome <font class="cb_room_selection_text_fl">O</font>ffice</div>
			<div id="Entryway" class="cb_room_selection_text" onclick="typeOfRoom('Entryway');"><font class="cb_room_selection_text_fl">E</font>ntryway</div>
			<div id="Nursery" class="cb_room_selection_text" onclick="typeOfRoom('Nursery');"><font class="cb_room_selection_text_fl">N</font>ursery</div>
			<div id="Kids_Bedroom" class="cb_room_selection_text" onclick="typeOfRoom('Kids Bedroom');"><font class="cb_room_selection_text_fl">K</font>ids <font class="cb_room_selection_text_fl">B</font>edroom</div>
			<div id="Outdoor_Space" class="cb_room_selection_text" onclick="typeOfRoom('Outdoor Space');"><font class="cb_room_selection_text_fl">O</font>utdoor <font class="cb_room_selection_text_fl">S</font>pace</div> </div> 
			
			<div class="reg_vconbord_top_radio_but_box ft_view_top_mgtp_mgrt_cl" style="margin-top: 30px;"><font class="reg_con_bord_top_txt_fl">F</font><font class="reg_con_bord_top_txt_ll">INISHING </font><font class="reg_con_bord_top_txt_fl">T</font><font class="reg_con_bord_top_txt_ll">OUCHES</font></div>
			<div class="cb_view_top_pdnl_mgtp_cl">
			<div id="Curtains" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Curtains');"><font class="cb_room_selection_text_fl">C</font>urtains</div>
			<div id="Bedding" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Bedding');"><font class="cb_room_selection_text_fl">B</font>edding</div>
			<div id="Pillows" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Pillows');"><font class="cb_room_selection_text_fl">P</font>illows</div>
			<div id="Throws" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Throws');"><font class="cb_room_selection_text_fl">T</font>hrows</div>
			<div id="Kitchen_Dining" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Kitchen & Dining');"><font class="cb_room_selection_text_fl">K</font>itchen <font class="cb_room_selection_text_fl">&amp; </font> <font class="cb_room_selection_text_fl">D</font>ining</div>
			<div id="Home_Accessories" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Home Accessories');"><font class="cb_room_selection_text_fl">H</font>ome <font class="cb_room_selection_text_fl">A</font>ccessories</div>
			<div id="Mattresses" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Mattresses');"><font class="cb_room_selection_text_fl">M</font>attresses</div>			
			<div id="Lighting" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Lighting');"><font class="cb_room_selection_text_fl">L</font>ighting</div> </div>
			
			</div> </div>
			
			<div class="col-md-8 col-sm-8">			
			<div style="margin-left: 40px; margin-right: 40px;">
			
	    		<div class="row"> <div class="col-md-6 col-sm-6"> <div align="left" class="reg_dsn_curated_cb_title_text text-left"> <h4><font class="reg_dsn_curated_cb_title_fl">C</font><font class="reg_dsn_curated_cb_title_ll">URATED </font> <font class="reg_dsn_curated_cb_title_fl">D</font><font class="reg_dsn_curated_cb_title_ll">ESIGN </font><font class="reg_dsn_curated_cb_title_fl">B</font><font class="reg_dsn_curated_cb_title_ll">OARDS</font></h4> </div> </div>
	    		<div align="right" class="col-md-6 col-sm-6"> <div class="row" style="position: relative; top: 10px; left: -15px;"> <table> <tbody> <tr>
				<td style="position: relative; left: -20px;"> <form action="createRoomFunds"> <h4><button class="reg_vcon_bod_submit_Btn" id="addBoardsId"><font class="reg_vcon_bod_submit_Btn_flt">&nbsp;A</font>DD <font class="reg_vcon_bod_submit_Btn_flt">R</font>OOM <font class="reg_vcon_bod_submit_Btn_flt">F</font>UNDS&nbsp;</button></h4> </form> </td>
				<td> <form action="createCashFunds"> <h4><button class="reg_vcon_bod_submit_Btn" id="addBoardsId"><font class="reg_vcon_bod_submit_Btn_flt">&nbsp;A</font>DD <font class="reg_vcon_bod_submit_Btn_flt">C</font>ASH <font class="reg_vcon_bod_submit_Btn_flt">F</font>UNDS&nbsp;</button></h4> </form> </td> </tr> </tbody> </table> </div> </div></div>
				
				<div style="margin-left: 0px; margin-top: 15px;" align="left" class="reg_dsn_curated_cb_rigtext_dspl"> ${regFTSelectedCategory} </div>	         
	        
<!-- Products List DIsplay Code Start -->		      		
				<% 	if (null != session.getAttribute("regFTProductIdsListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductSavingIdList = (ArrayList) session.getAttribute("regFTProductIdsListInSn"); if (null != regFTProductSavingIdList && regFTProductSavingIdList.size() > 0) {
					if (null != session.getAttribute("regFTProductImage1ListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductImageList = (ArrayList) session.getAttribute("regFTProductImage1ListInSn"); if (null != regFTProductImageList && regFTProductImageList.size() > 0) {
					if (null != session.getAttribute("regFTProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductNameList = (ArrayList) session.getAttribute("regFTProductNameListInSn"); if (null != regFTProductNameList && regFTProductNameList.size() > 0) {
					if (null != session.getAttribute("regFTProductStoreNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductStoreNameList = (ArrayList) session.getAttribute("regFTProductStoreNameListInSn"); if (null != regFTProductStoreNameList && regFTProductStoreNameList.size() > 0) {
					if (null != session.getAttribute("regFTProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductPriceList = (ArrayList) session.getAttribute("regFTProductPriceListInSn"); if (null != regFTProductPriceList && regFTProductPriceList.size() > 0) {
					if (null != session.getAttribute("regFTProductPopUpValuesListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductPopUpValuesList = (ArrayList) session.getAttribute("regFTProductPopUpValuesListInSn"); if (null != regFTProductPopUpValuesList && regFTProductPopUpValuesList.size() > 0) {
					if (null != session.getAttribute("regFTProductImage2ListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductImage2List = (ArrayList) session.getAttribute("regFTProductImage2ListInSn"); if (null != regFTProductImage2List && regFTProductImage2List.size() > 0) {
					if (null != session.getAttribute("regFTProductImage3ListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductImage3List = (ArrayList) session.getAttribute("regFTProductImage3ListInSn"); if (null != regFTProductImage3List && regFTProductImage3List.size() > 0) {
					if (null != session.getAttribute("regFTProductImage4ListInSn")) { @SuppressWarnings("rawtypes") ArrayList regFTProductImage4List = (ArrayList) session.getAttribute("regFTProductImage4ListInSn"); if (null != regFTProductImage4List && regFTProductImage4List.size() > 0) {			
				%>							
				<div class="row top_adjustment_20">
				<% for(int i=0; i<regFTProductSavingIdList.size(); i++) { int count = (i + 1);
					String regFTProductPopUpValuesSt = (String) regFTProductPopUpValuesList.get(i); regFTProductPopUpValuesSt = regFTProductPopUpValuesSt.replace("\"", "DoubleQuotes"); regFTProductPopUpValuesSt = regFTProductPopUpValuesSt.replace("\'", "SingleQuotes"); regFTProductPopUpValuesSt = regFTProductPopUpValuesSt.replace("&#034;", "DoubleQuotes"); regFTProductPopUpValuesSt = regFTProductPopUpValuesSt.replace("&#039;", "SingleQuotes"); byte[] conBoardSmlImagesFromDB = (byte[]) regFTProductImageList.get(i); String finTouchesMainImage1 = null; String finTouchesSmlImage1 = null;
		        	if(null != conBoardSmlImagesFromDB) { String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardSmlImagesFromDB); finTouchesMainImage1 = "data:image/jpg;base64," +b64; finTouchesSmlImage1 = b64; }		        	
		        	byte[] furnSpecProductImage2List = (byte[]) regFTProductImage2List.get(i); String finTouchesSmlImage2 = null;
		        	if(null != furnSpecProductImage2List) { finTouchesSmlImage2 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage2List); }		        	
		        	byte[] furnSpecProductImage3List = (byte[]) regFTProductImage3List.get(i); String finTouchesSmlImage3 = null;
		        	if(null != furnSpecProductImage3List) { finTouchesSmlImage3 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage3List); }		        	
		        	byte[] furnSpecProductImage4List = (byte[]) regFTProductImage4List.get(i); String finTouchesSmlImage4 = null;
		        	if(null != furnSpecProductImage4List) { finTouchesSmlImage4 = javax.xml.bind.DatatypeConverter.printBase64Binary(furnSpecProductImage4List); }
		        	String allpopdataRedirection = finTouchesSmlImage1 + "_,_" + finTouchesSmlImage2 + "_,_" + finTouchesSmlImage3 + "_,_" + finTouchesSmlImage4 + "_,_" + regFTProductPopUpValuesSt;
		        %>
					<div class="col-md-3 col-sm-3 rcb_midfrm_mbot_adj_cl"> <div class="reg_landing_images_and_text_frame">
					<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center"> <img src="<%=finTouchesMainImage1%>" id="image<%=count%>Id" onClick="furnamtureSpecProductInfo('<%=allpopdataRedirection%>')" class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1 rcb_midfrm_cur_pot_adj_cl"> </div> </div>
					<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1"> <div class="reg_bott_text_hd_dspl1"><%=regFTProductNameList.get(i)%></div> </div>
					<div class="reg_mid_ita_text_frame_dspl"> <font class="reg_bott_small_ita_text_dspl"><%=regFTProductStoreNameList.get(i)%></font> </div>						
					<div align="left" class="fur_spec_prod_price_dspl"> $<%=regFTProductPriceList.get(i)%> </div>
					<div align="center" class="rcb_midfrm_mbottp_adj_cl"> <h4><button class="reg_fur_spec_submit_Btn" id="furnamtureSpecProductId" onClick="furnamtureSpecProductInfo('<%=allpopdataRedirection%>')">ADD TO REGISTRY</button></h4> </div> </div> </div> </div> </div>		        			        				        	
				<% } %>
			 	</div>			 			
			 	<% } } } } } } } } } } } } } } } } } } %>
		      
        	</div> </div> </div>
			
		</div> <div class="col-md-1 col-sm-1"></div> </div> </div>
		
		  
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
		<form action="regFinTouchesSelectedProdInfoSaving" method="POST">
		<div class="reg_popup_prod_name_hd"><font id="regProductNameID"></font></div>
		<div class="reg_popup_prod_store_name_hd"><font id="regProductStoreNameID"></font></div>
		<div class="reg_popup_prod_price_hd" id="displaySelectPriceID" style="display: none;">$<font id="regSelectedPriceID"></font></div>			        	
		<div class="reg_popup_prod_price_hd" id="displayDBPriceID">$<font id="regPriceDesp1ID"></font></div>
		
		<div class="regi_sc_enbl_gg_text_dsp">BETTER PRICE GUARANTEE&nbsp;&nbsp; <div class="mytooltip1" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer;" class="fa">&#xf059;</i>
	    	<span class="mytext1" style="margin-top: -40px;"> We'll not only match the retailer's listed price on their website, but we offer an automatic 5% off the product at checkout! <br><br>No coupon code needed </span> </div>
	    </div>
	    
		<div class="regi_popup_prdt_sub_frame"> <div align="left" class="reg_popup_prod_quantity_hd top_adjustment_5">QUANTITY</div>
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
		<input type="hidden" id="enableGroupGiftId" name="groupGiftRefferanceValue"> <input type="hidden" id="productInfoSavingId" name="ftProductsInfoSavingId"> <input type="hidden" name="registrySpaceRoom" value="${registrySpaceRoom}"> <input type="hidden" name="registryStyleName" value="${registryStyleName}"> <input type="hidden" name="registryViewProducts" value="${registryViewProducts}"> <input type="hidden" name="registryPrice" value="${registryPrice}"> <input type="hidden" id="regProductSizeId" name="productHeading"> <input type="hidden" id="registryPriceId" name="productPrice"> <input type="hidden" id="productDescriptionId" name="productDescription">
		<input type="hidden" name="regFTSelectedCategory" value="${regFTSelectedCategory}">
		</form>
		</div> </div> </div> </div> </div>
<!-- Pop up Code End -->
       
       	<form action="registryViewAllDesigns" id="roomImgsFormId" name="regRoomSelect" method="POST">
        	<input type="hidden" id="registrySpaceRoomId" name="registrySpaceRoom">               
       	</form>
            
	  	<form action="regFinTouchesSelectedProducts" id="finishingTouchesFormId" name="finishingTouchesFormName" method="POST">
        	<input type="hidden" id="regFTSelectedCategoryId" name="regFTSelectedCategory">               
       	</form>
	       	        
		</body>
</html>
