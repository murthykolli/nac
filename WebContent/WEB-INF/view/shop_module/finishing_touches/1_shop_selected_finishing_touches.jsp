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
    <link rel="stylesheet" href="resources/css/registry_css/registry_finishing_touches.css" type="text/css">
    <link rel="stylesheet" href="resources/css/registry_css/registry_concept_boards.css" type="text/css">	
	
	<script type="text/javascript">	
	$(document).ready(function () { var registrySpaceRoom1 = "<c:out value="${registrySpaceRoom}"/>"; var registrySpaceRoomVal = registrySpaceRoom1.replace(" ", "_"); $("#"+registrySpaceRoomVal).css("color","red"); $("#"+registrySpaceRoomVal).css("text-decoration","underline"); });
	function typeOfRoomForShop(shopRoomName) { document.shopRoomFormName.selectedShopRoomName.value = shopRoomName; $("#shopRoomFormId").submit(); }
	function viewProductsForRegistry(id, count) { document.viewProductsFormName.registryViewProducts.value = id; document.viewProductsFormName.registryCBRoomCount.value = count; $("#viewProductsFormNameId").submit(); }
	function typeOfFinishingTouches(finishingTouchesName) { document.finishingTouchesFormName.shopFTSelectedCategory.value = finishingTouchesName; $("#finishingTouchesFormId").submit(); }
	</script>
	</head>
	
		<body>		
			<div id="mmenu_screen" class="container-fluid main_container cb_view_top_frame_dsp">
			<div class="row top_adjustment_0"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10">
		    <div class="row"> <div class="col-md-2 col-sm-2"> <div class="cb_view_top_pdng_dsp">
			<div class="reg_vconbord_top_radio_but_box cb_view_top_mgtp_mgrt_cl"><font class="reg_con_bord_top_txt_fl">R</font><font class="reg_con_bord_top_txt_ll">OOMS</font></div>
			<div class="cb_view_top_pdnl_mgtp_cl">
			<div id="Living_Room" class="cb_room_selection_text" onclick="typeOfRoomForShop('Living Room');"><font class="cb_room_selection_text_fl">L</font>iving <font class="cb_room_selection_text_fl">R</font>oom</div>
			<div id="Dining_Room" class="cb_room_selection_text" onclick="typeOfRoomForShop('Dining Room');"><font class="cb_room_selection_text_fl">D</font>ining <font class="cb_room_selection_text_fl">R</font>oom</div>
			<div id="Bedroom" class="cb_room_selection_text" onclick="typeOfRoomForShop('Bedroom');"><font class="cb_room_selection_text_fl">B</font>edroom</div>
			<div id="Home_Office" class="cb_room_selection_text" onclick="typeOfRoomForShop('Home Office');"><font class="cb_room_selection_text_fl">H</font>ome <font class="cb_room_selection_text_fl">O</font>ffice</div>
			<div id="Entryway" class="cb_room_selection_text" onclick="typeOfRoomForShop('Entryway');"><font class="cb_room_selection_text_fl">E</font>ntryway</div>
			<div id="Nursery" class="cb_room_selection_text" onclick="typeOfRoomForShop('Nursery');"><font class="cb_room_selection_text_fl">N</font>ursery</div>
			<div id="Kids_Bedroom" class="cb_room_selection_text" onclick="typeOfRoomForShop('Kids Bedroom');"><font class="cb_room_selection_text_fl">K</font>ids <font class="cb_room_selection_text_fl">B</font>edroom</div>
			<div id="Outdoor_Space" class="cb_room_selection_text" onclick="typeOfRoomForShop('Outdoor Space');"><font class="cb_room_selection_text_fl">O</font>utdoor <font class="cb_room_selection_text_fl">S</font>pace</div> </div> 
			
			<div class="reg_vconbord_top_radio_but_box cb_view_top_mgtp_mgrt_cl" style="margin-top: 30px;"><font class="reg_con_bord_top_txt_fl">F</font><font class="reg_con_bord_top_txt_ll">INISHING </font><font class="reg_con_bord_top_txt_fl">T</font><font class="reg_con_bord_top_txt_ll">OUCHES</font></div>
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
			</div> </div> <div class="col-md-1 col-sm-1"></div> </div> </div>        
	       	<form action="shopViewAllDesignsConcepts" id="shopRoomFormId" name="shopRoomFormName" method="GET">
        		<input type="hidden" id="selectedShopRoomNameId" name="selectedShopRoomName">
        		<input type="hidden" id="shopCBRoomsCountId" name="shopCBRoomsCount" value="0">              
      		</form>
	       	
	       	<form action="shopFinTouchesSelectedProducts" id="finishingTouchesFormId" name="finishingTouchesFormName" method="POST">
                <input type="hidden" id="shopFTSelectedCategoryId" name="shopFTSelectedCategory">               
            </form>             
		</body>
</html>
