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
	
	<script type="text/javascript">	
	$(document).ready(function () { var registrySpaceRoom1 = "<c:out value="${registrySpaceRoom}"/>"; var registrySpaceRoomVal = registrySpaceRoom1.replace(" ", "_"); $("#"+registrySpaceRoomVal).css("color","red"); $("#"+registrySpaceRoomVal).css("text-decoration","underline"); });		
	function typeOfRoom(roomName) { document.regRoomSelect.registrySpaceRoom.value = roomName; $("#roomImgsFormId").submit(); }	
	function viewProductsForRegistry(id, count) { document.viewProductsFormName.registryViewProducts.value = id; document.viewProductsFormName.registryCBRoomCount.value = count; $("#viewProductsFormNameId").submit(); }
	function typeOfFinishingTouches(finishingTouchesName) { document.finishingTouchesFormName.finishingTouchesName.value = finishingTouchesName; $("#finishingTouchesFormId").submit(); }
	</script>
	</head>
	
		<body>		
			<div id="mmenu_screen" class="container-fluid main_container cb_view_top_frame_dsp">
			<div class="row top_adjustment_0"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10">
		    <div class="row"> <div class="col-md-2 col-sm-2"> <div class="cb_view_top_pdng_dsp">
			<div class="reg_vconbord_top_radio_but_box cb_view_top_mgtp_mgrt_cl"><font class="reg_con_bord_top_txt_fl">R</font><font class="reg_con_bord_top_txt_ll">OOMS</font></div>
			<div class="cb_view_top_pdnl_mgtp_cl">
			<div id="Living_Room" class="cb_room_selection_text" onclick="typeOfRoom('Living Room');"><font class="cb_room_selection_text_fl">L</font>iving <font class="cb_room_selection_text_fl">R</font>oom</div>
			<div id="Dining_Room" class="cb_room_selection_text" onclick="typeOfRoom('Dining Room');"><font class="cb_room_selection_text_fl">D</font>ining <font class="cb_room_selection_text_fl">R</font>oom</div>
			<div id="Bedroom" class="cb_room_selection_text" onclick="typeOfRoom('Bedroom');"><font class="cb_room_selection_text_fl">B</font>edroom</div>
			<div id="Home_Office" class="cb_room_selection_text" onclick="typeOfRoom('Home Office');"><font class="cb_room_selection_text_fl">H</font>ome <font class="cb_room_selection_text_fl">O</font>ffice</div>
			<div id="Entryway" class="cb_room_selection_text" onclick="typeOfRoom('Entryway');"><font class="cb_room_selection_text_fl">E</font>ntryway</div>
			<div id="Nursery" class="cb_room_selection_text" onclick="typeOfRoom('Nursery');"><font class="cb_room_selection_text_fl">N</font>ursery</div>
			<div id="Kids_Bedroom" class="cb_room_selection_text" onclick="typeOfRoom('Kids Bedroom');"><font class="cb_room_selection_text_fl">K</font>ids <font class="cb_room_selection_text_fl">B</font>edroom</div>
			<div id="Outdoor_Space" class="cb_room_selection_text" onclick="typeOfRoom('Outdoor Space');"><font class="cb_room_selection_text_fl">O</font>utdoor <font class="cb_room_selection_text_fl">S</font>pace</div>
										        	
			<div style="border-bottom: 1px solid black; padding-bottom: 3px; width: auto; margin-left: 6px; width: 125px; margin-top: 6px; margin-bottom: 15px;"></div>										
			<div id="Finishing_Touches" class="cb_room_selection_text" onclick="typeOfFinishingTouches('Finishing Touches');"><font class="cb_room_selection_text_fl">F</font>inishing <font class="cb_room_selection_text_fl">T</font>ouches</div>
			
			</div> </div> </div>
			<div class="col-md-10 col-sm-10"> <div class="row" style="margin-top: 0px; padding-bottom: 15px;"> <div class="col-md-6 col-sm-6"> <div align="left" class="reg_dsn_curated_cb_title_text text-left"> <h4><font class="reg_dsn_curated_cb_title_fl">C</font><font class="reg_dsn_curated_cb_title_ll">URATED </font> <font class="reg_dsn_curated_cb_title_fl">D</font><font class="reg_dsn_curated_cb_title_ll">ESIGN </font><font class="reg_dsn_curated_cb_title_fl">B</font><font class="reg_dsn_curated_cb_title_ll">OARDS</font></h4> </div> </div>
			<div align="right" class="col-md-6 col-sm-6"> <div class="row" style="position: relative; top: 10px; left: -15px;"> <table> <tbody> <tr>
			<td style="position: relative; left: -20px;"> <form action="createRoomFunds"> <h4><button class="reg_vcon_bod_submit_Btn" id="addBoardsId"><font class="reg_vcon_bod_submit_Btn_flt">&nbsp;A</font>DD <font class="reg_vcon_bod_submit_Btn_flt">R</font>OOM <font class="reg_vcon_bod_submit_Btn_flt">F</font>UNDS&nbsp;</button></h4> </form> </td>
			<td> <form action="createCashFunds"> <h4><button class="reg_vcon_bod_submit_Btn" id="addBoardsId"><font class="reg_vcon_bod_submit_Btn_flt">&nbsp;A</font>DD <font class="reg_vcon_bod_submit_Btn_flt">C</font>ASH <font class="reg_vcon_bod_submit_Btn_flt">F</font>UNDS&nbsp;</button></h4> </form> </td> </tr> </tbody> </table> </div> </div> </div>
			<div class="row"> <div class="col-md-9 col-sm-9"> <div style="margin-left: 0px;" align="left" class="reg_dsn_curated_cb_rigtext_dspl"> ${registrySpaceRoom} </div> </div>
			<div class="col-md-3 col-sm-3"> <div align="right" class="reg_dsn_curated_cb_rigtext_dspl"> <font style="font: bold 1.15em/0.9em Georgia;">${regTotalResultsCount}</font> <font style="font: 1.25em/1.25em Georgia;">R</font>ESULTS </div> </div> </div> <div class="top_adjustment_5">		        	
		    <%	if (null != session.getAttribute("registryViewDesignsCBIdsListInSn")) { @SuppressWarnings("rawtypes") ArrayList registryViewDesignsCBIdsList = (ArrayList) session.getAttribute("registryViewDesignsCBIdsListInSn"); if (null != registryViewDesignsCBIdsList && registryViewDesignsCBIdsList.size() > 0) {
				if (null != session.getAttribute("registryViewDesignsCBImagesListInSn")) { @SuppressWarnings("rawtypes") ArrayList registryViewDesignsCBImagesList = (ArrayList) session.getAttribute("registryViewDesignsCBImagesListInSn"); if (null != registryViewDesignsCBImagesList && registryViewDesignsCBImagesList.size() > 0) {						   
			%> <div class="row">
			<% 	for(int i=0; i<registryViewDesignsCBIdsList.size(); i++) { int count = (i + 1); byte[] conBoardsImagesFromDB = (byte[]) registryViewDesignsCBImagesList.get(i); String conceptBoardsBigImage = null;
			    if(null != conBoardsImagesFromDB) { String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(conBoardsImagesFromDB); conceptBoardsBigImage = "data:image/jpg;base64," +b64; }					
			%>
			<div class="col-md-6 col-sm-6" id="imageDspId<%=count%>" style="margin-bottom: 30px;"> <div onclick="viewProductsForRegistry('<%=registryViewDesignsCBIdsList.get(i)%>', '<%=i%>');">
			<div class="cb_vimage_mouse_over_dsp" align="center"> <img src="<%=conceptBoardsBigImage%>" class="image_disply_proper_cl">
			<div class="middle"> <div class="text">VIEW</div> </div> </div> </div> </div>			        
		 	<% } %> </div>
		 	<% } } } } %>
			</div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div> </div>        
	        <form action="registryViewAllDesigns" id="roomImgsFormId" name="regRoomSelect" method="POST">
                <input type="hidden" id="registrySpaceRoomId" name="registrySpaceRoom">               
            </form>
	        <form action="viewDesignSelectedConcepts" id="viewProductsFormNameId" name="viewProductsFormName" method="POST">
                <input type="hidden" id="registryViewProductsId" name="registryViewProducts"> <input type="hidden" id="registryCBRoomCountId" name="registryCBRoomCount"> <input type="hidden" id="registrySpaceRoomId" name="registrySpaceRoom" value="${registrySpaceRoom}">      
            </form>
            <form action="registrySelectedFinishingTouches" id="finishingTouchesFormId" name="finishingTouchesFormName" method="POST"> <input type="hidden" id="finishingTouchesNameId" name="finishingTouchesName"> <input type="hidden" id="registryCBRoomCountId" name="registryCBRoomCount" value="0"> </form>            
		</body>
</html>
