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
    
	<script type="text/javascript">
	    $(document).ready(function() { var selectedShopRoomName1 = "<c:out value="${selectedShopRoomName}"/>"; var selectedShopRoomNameVal = selectedShopRoomName1.replace(" ", "_"); $("#"+selectedShopRoomNameVal).css("color","red"); $("#"+selectedShopRoomNameVal).css("text-decoration","underline"); });
		function typeOfRoomForShop(roomName) { document.shopRoomSelectFormName.selectedShopRoomName.value = roomName; $("#shopSelRoomFormId").submit(); }	
		function viewProductsForRegistry(id, count) { document.viewProductsFormName.registryShopViewProducts.value = id; document.viewProductsFormName.shopCBRoomsCount.value = count; $("#viewProductsFormNameId").submit(); }
		function typeOfFinishingTouches(finishingTouchesName) { document.finishingTouchesFormName.finishingTouchesName.value = finishingTouchesName; $("#finishingTouchesFormId").submit(); }
	</script>
	</head>	
		<body>		
		<div id="mmenu_screen" class="container-fluid main_container top_adjustment_120"> 
			<!-- <div class="row shop_pro_code_bgclr"> <div class="col-md-2 col-sm-2"></div> <div class="col-md-8 col-sm-8"> <div class="row shop_bann_txt_adj"> <div class="col-md-4 col-sm-4">
			<div align="center"> <div class="spromo_codes_text">5% OFF $1000 - $1999 (Code: 5OFF)</div> </div> </div>					      	
			<div class="col-md-4 col-sm-4"> <div align="center"> <div class="spromo_codes_text">7% OFF $2000 - $2999 (Code: 7OFF)</div> </div> </div>					      	
			<div class="col-md-4 col-sm-4"> <div align="center"> <div class="spromo_codes_text">10% OFF $3000+ (Code: 10OFF)</div> </div> </div> </div> </div> <div class="col-md-2 col-sm-2"></div> </div> --> 
		</div>
		<div id="mmenu_screen" class="container-fluid main_container shop_main_fram_adj"> <div class="row top_adjustment_0"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10"> <div class="row"> <div class="col-md-2 col-sm-2"> <div class="shop_pdng_dspl">
		<div class="sreg_con_bord_top_radio_but_box shop_vdc_mtmrcl"><font class="sreg_con_bord_top_txt_fl">R</font><font class="sreg_con_bord_top_txt_ll">OOMS</font></div> <div class="shop_vdc_pdlmtop">
		<div id="Living_Room" class="scb_room_selection_text" onclick="typeOfRoomForShop('Living Room');"><font class="scb_room_selection_text_fl">L</font>iving <font class="scb_room_selection_text_fl">R</font>oom</div>
		<div id="Dining_Room" class="scb_room_selection_text" onclick="typeOfRoomForShop('Dining Room');"><font class="scb_room_selection_text_fl">D</font>ining <font class="scb_room_selection_text_fl">R</font>oom</div>
		<div id="Bedroom" class="scb_room_selection_text" onclick="typeOfRoomForShop('Bedroom');"><font class="scb_room_selection_text_fl">B</font>edroom</div>
		<div id="Home_Office" class="scb_room_selection_text" onclick="typeOfRoomForShop('Home Office');"><font class="scb_room_selection_text_fl">H</font>ome <font class="scb_room_selection_text_fl">O</font>ffice</div>
		<div id="Entryway" class="scb_room_selection_text" onclick="typeOfRoomForShop('Entryway');"><font class="scb_room_selection_text_fl">E</font>ntryway</div>
		<div id="Nursery" class="scb_room_selection_text" onclick="typeOfRoomForShop('Nursery');"><font class="scb_room_selection_text_fl">N</font>ursery</div>
		<div id="Kids_Bedroom" class="scb_room_selection_text" onclick="typeOfRoomForShop('Kids Bedroom');"><font class="scb_room_selection_text_fl">K</font>ids <font class="scb_room_selection_text_fl">B</font>edroom</div>
		<div id="Outdoor_Space" class="scb_room_selection_text" onclick="typeOfRoomForShop('Outdoor Space');"><font class="scb_room_selection_text_fl">O</font>utdoor <font class="scb_room_selection_text_fl">S</font>pace</div>
									        	
		<div style="border-bottom: 1px solid black; padding-bottom: 3px; width: auto; margin-left: 6px; width: 125px; margin-top: 6px; margin-bottom: 15px;"></div>										
		<div id="Finishing_Touches" class="scb_room_selection_text" onclick="typeOfFinishingTouches('Finishing Touches');"><font class="scb_room_selection_text_fl">F</font>inishing <font class="scb_room_selection_text_fl">T</font>ouches</div>
		</div> </div> </div>
		<div class="col-md-10 col-sm-10"> <div class="row shop_vdc_mtppdnbt"> <div class="col-md-12 col-sm-12"> <div align="left" class="sreg_dsn_curated_cb_title_text text-left">
		<h4><font class="sreg_dsn_curated_cb_title_fl">C</font><font class="sreg_dsn_curated_cb_title_ll">URATED </font> <font class="sreg_dsn_curated_cb_title_fl">D</font><font class="sreg_dsn_curated_cb_title_ll">ESIGN </font><font class="sreg_dsn_curated_cb_title_fl">B</font><font class="sreg_dsn_curated_cb_title_ll">OARDS</font></h4> </div> </div> </div>
		<div class="row"> <div class="col-md-9 col-sm-9"> <div align="left" class="sreg_dsn_curated_cb_rigtext_dspl left_adjustment_1"> ${selectedShopRoomName} </div> </div>
		<div class="col-md-3 col-sm-3"> <div align="right" class="sreg_dsn_curated_cb_rigtext_dspl"> <font style="font: bold 1.15em/0.9em Georgia;">${totalShopCBProductsCount}</font> <font class="shop_vdc_hdfnt">R</font>ESULTS </div> </div> </div>
		<div class="top_adjustment_0">
		<% 
			if (null != session.getAttribute("shopViewDesignsCBIdsListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopViewDesignsCBIdsList = (ArrayList) session.getAttribute("shopViewDesignsCBIdsListInSn"); if (null != shopViewDesignsCBIdsList && shopViewDesignsCBIdsList.size() > 0) {
			if (null != session.getAttribute("shopViewDesignsCBImagesListInSn")) { @SuppressWarnings("rawtypes") ArrayList shopViewDesignsCBImagesList = (ArrayList) session.getAttribute("shopViewDesignsCBImagesListInSn"); if (null != shopViewDesignsCBImagesList && shopViewDesignsCBImagesList.size() > 0) {						   
		%>
		<div class="row top_adjustment_5">
		<%
			for(int i=0; i<shopViewDesignsCBIdsList.size(); i++) { int count = (i + 1); byte[] conBoardsImagesFromDB = (byte[]) shopViewDesignsCBImagesList.get(i); String conceptBoardsBigImage = null;
			if(null != conBoardsImagesFromDB) { String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImagesFromDB); conceptBoardsBigImage = "data:image/jpg;base64," +b64; }					
		%>
		<div class="col-md-6 col-sm-6" id="imageDspId<%=count%>" style="margin-bottom: 30px;">		        	
		<div onclick="viewProductsForRegistry('<%=shopViewDesignsCBIdsList.get(i)%>', '<%=i%>');">
		<div class="simage_mouse_over_dsp" align="center"> <img src="<%=conceptBoardsBigImage%>" class="simage_disply_proper_cl">
		<div class="middle"> <div class="text">VIEW</div> </div> </div> </div> </div>			        
		<% } %> </div>
		<% } } } } %> </div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div> </div>
		
        <form action="shopViewAllDesignsConcepts" id="shopSelRoomFormId" name="shopRoomSelectFormName" method="GET"> <input type="hidden" id="selectedShopRoomNameId" name="selectedShopRoomName"> </form>
        <form action="viewShopDesignSelectedConcepts" id="viewProductsFormNameId" name="viewProductsFormName" method="GET">
        <input type="hidden" id="registryShopViewProductsId" name="registryShopViewProducts"> <input type="hidden" id="shopCBRoomsCountId" name="shopCBRoomsCount"> <input type="hidden" id="selectedShopRoomNameId" name="selectedShopRoomName" value="${selectedShopRoomName}">
        <%-- <input type="hidden" id="registryStyleNameId" name="registryStyleName" value="${registryStyleName}"> <input type="hidden" id="registryPriceId" name="registryPrice" value="${registryPrice}"> --%>               
        </form>
        <form action="shopSelectedFinishingTouches" id="finishingTouchesFormId" name="finishingTouchesFormName" method="POST"> 
      		<input type="hidden" id="finishingTouchesNameId" name="finishingTouchesName"> 
      		<input type="hidden" id="registryCBRoomCountId" name="registryCBRoomCount" value="0"> 
      	</form>            
		</body>
</html>
