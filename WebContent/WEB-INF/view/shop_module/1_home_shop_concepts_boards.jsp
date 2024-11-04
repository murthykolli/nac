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
    <link rel="stylesheet" href="resources/css/registry_shop/1_shop_home.css" type="text/css">
    <style type="text/css">
	@font-face { font-family: 'Handycheera'; src: url('resources/sitefonts/Handycheera Regular.otf') format('truetype'); }
	.tick_mark_dsp { font: 1.1em/1.4em Georgia; }
	.ft_img_text_dsp { font: 1.12em/1.4em Georgia; margin-left: 5px; }
	.rfuns_frame_htd_cls { height: 35px; }
	
	</style>
    </head>	
		<body>
		<div id="mainframe" class="section-content"> <div class="container">       
        <div id="concept_boards_adj_id"> <div class="row"> <div class="shop_conct_brd_heading_dsp text-left shop_top_txt_adj">
		<h4><font class="shop_con_board_fl_dsp">C</font>URATED <font class="shop_con_board_fl_dsp">D</font>ESIGN <font class="shop_con_board_fl_dsp">B</font>OARDS</h4> </div>
		<div class="shop_desn_con_brd_sub_txt_cl text-left"> Browse by rooms and shop furniture and decor pieces from professionally curated design boards. </div>
		
		<div class="row"> <div class="col-md-12 col-sm-12 top_adjustment_35">
		<table> <tbody> <tr> <td> <div class="reg_image_and_text_frame_dsp_cl right_adjustment_0" onclick="typeOfRoomForShop('Living Room');">			
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/living_room_cdb.png" width="210" height="210" > </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">L</font>IVING <font class="regi_cb_bott_name_text_fl_dspl">R</font>OOM</div> </div> </div> </div> </div> </td>			   		
		<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomForShop('Dining Room');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/dining_room_cdb.png" width="210" height="210" > </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">D</font>INING <font class="regi_cb_bott_name_text_fl_dspl">R</font>OOM</div> </div> </div> </div> </div> </td>			   		
		<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomForShop('Bedroom');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/bedroom_cdb.png" width="210" height="210" > </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">B</font>EDROOM</div> </div> </div> </div> </div> </td>			   		
		<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomForShop('Home Office');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/home_office_cdb.png" width="210" height="210" > </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">H</font>OME <font class="regi_cb_bott_name_text_fl_dspl">O</font>FFICE</div> </div> </div> </div> </div> </td> 
		<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomForShop('Entryway');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/entryway_cdb.png" width="210" height="210" > </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">E</font>NTRYWAY</div> </div> </div> </div> </div> </td>
		</tr>		
		<tr class="rfuns_frame_htd_cls"></tr>		
		<tr> 			   		
		<td> <div class="reg_image_and_text_frame_dsp_cl right_adjustment_0" onclick="typeOfRoomForShop('Nursery');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/nursery_cdb.png" width="210" height="210" > </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">N</font>URSERY</div> </div> </div> </div> </div> </td>			   		
		<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomForShop('Kids Bedroom');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/kids_bedroom_cdb.png" width="210" height="210" > </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">K</font>IDS <font class="regi_cb_bott_name_text_fl_dspl">B</font>EDROOM</div> </div> </div> </div> </div> </td>			   		
		<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfRoomForShop('Outdoor Space');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> <img src="resources/images/curated_design_boards_images/outdoor_space_cdb.png" width="210" height="210" > </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">O</font>UTDOOR <font class="regi_cb_bott_name_text_fl_dspl">S</font>PACE</div> </div> </div> </div> </div> </td>
		
		<td> <div class="reg_image_and_text_frame_dsp_cl left_adjustment_25" onclick="typeOfFinishingTouches('Finishing Touches');"> <div class="row"> <div class="col-md-12 col-sm-12 reg_funds_topimage_frame_cl" align="center"> 
			<table style="position: relative; top: 10px; left: 12px;">
				<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Curtains</font></td></tr>
				<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Bedding</font></td></tr>
				<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Pillows</font></td></tr>
				<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Throws</font></td></tr>				
				<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Kitchen &amp; Dining</font></td></tr>
				<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Home Accessories</font></td></tr>
				<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;Mattresses</font></td></tr>
				<tr><td><span class="tick_mark_dsp">&#10003;</span></td> <td><font class="ft_img_text_dsp">&nbsp;&amp; More</font></td></tr>
			</table>
		</div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_funds_bottom_text_frame_cl"> <div class="reg_funds_botsub_middle_text_cl"> <div class="regi_cb_bott_name_text_nl_dspl"><font class="regi_cb_bott_name_text_fl_dspl">F</font>INISHING <font class="regi_cb_bott_name_text_fl_dspl">T</font>OUCHES</div> </div> </div> </div> </div> 
		</td>
		
		</tr> </tbody> </table> </div>
		<div class="col-md-2 col-sm-2"></div> </div> </div> </div> </div> </div>
		
		<script type="text/javascript">		
			function typeOfRoomForShop(shopRoomName) { document.shopRoomFormName.selectedShopRoomName.value = shopRoomName; $("#shopRoomFormId").submit(); }
			function typeOfFinishingTouches(finishingTouchesName) { document.finishingTouchesFormName.finishingTouchesName.value = finishingTouchesName; $("#finishingTouchesFormId").submit(); }
		</script>
		
		<!-- <form action="registryShopSelectedRoom" id="shopRoomFormId" name="shopRoomFormName" method="GET"> -->
		<form action="shopViewAllDesignsConcepts" id="shopRoomFormId" name="shopRoomFormName" method="GET">
        	<input type="hidden" id="selectedShopRoomNameId" name="selectedShopRoomName">
        	<input type="hidden" id="shopCBRoomsCountId" name="shopCBRoomsCount" value="0">              
      	</form>
      	<form action="shopSelectedFinishingTouches" id="finishingTouchesFormId" name="finishingTouchesFormName" method="POST"> 
      		<input type="hidden" id="finishingTouchesNameId" name="finishingTouchesName"> 
      		<input type="hidden" id="registryCBRoomCountId" name="registryCBRoomCount" value="0"> 
      	</form>
		
		</body>
</html>
