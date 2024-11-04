<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/css/file_upload.css" type="text/css">
	 	
	<style type="text/css">
	.radio_container { display: block; position: relative; padding-left: 25px; margin-bottom: 12px; font: 1.2em/0.9em Georgia; letter-spacing: 1px; color: black; cursor: pointer; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; }
	.radio_container input { position: absolute; opacity: 0; cursor: pointer; }
	.radio_checkmark { position: absolute; top: 0; left: 0; height: 15px; width: 15px; background-color: #c2c2c2; border-radius: 50%; border: none; box-shadow: inset 2px -2px 4px rgba(0,0,0,0.6); -moz-box-shadow: inset 2px -2px 4px rgba(0,0,0,0.6); -webkit-box-shadow: inset 2px -2px 4px rgba(0,0,0,0.6); -o-box-shadow: inset 2px -2px 4px rgba(0,0,0,0.6); }
	.radio_container:hover input ~ .radio_checkmark { background-color: #36669b; }
	.radio_container:hover { color: #36669b; text-decoration: underline; outline: none; }
	.radio_container input:checked ~ .radio_checkmark { background-color: #36669b; none; }
	.radio_checkmark:after { content: ""; position: absolute; display: none; }
	.radio_container input:checked ~ .radio_checkmark:after { display: block; }
	.radio_container .radio_checkmark:after { top: 5px; left: 5px; width: 5px; height: 5px; border-radius: 50%; background: #36669b; }
	
	.radio_ft_container { display: block; position: relative; padding-left: 25px; margin-bottom: 12px; font: 1.2em/0.9em Georgia; letter-spacing: 1px; color: black; cursor: pointer; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; }
	.radio_ft_container input { position: absolute; opacity: 0; cursor: pointer; }
	.radio_ft_checkmark { position: absolute; top: 0; left: 0; height: 14px; width: 14px; background-color: #c2c2c2; border-radius: 50%; border: none; box-shadow: inset 2px -2px 4px rgba(0,0,0,0.6); -moz-box-shadow: inset 2px -2px 4px rgba(0,0,0,0.6); -webkit-box-shadow: inset 2px -2px 4px rgba(0,0,0,0.6); -o-box-shadow: inset 2px -2px 4px rgba(0,0,0,0.6); }
	.radio_ft_container:hover input ~ .radio_ft_checkmark { background-color: red; }
	.radio_ft_container:hover { color: red; text-decoration: underline; outline: none; }
	.radio_ft_container input:checked ~ .radio_ft_checkmark { background-color: red; none; }
	.radio_ft_checkmark:after { content: ""; position: absolute; display: none; }
	.radio_ft_container input:checked ~ .radio_ft_checkmark:after { display: block; }
	.radio_ft_container .radio_ft_checkmark:after { top: 5px; left: 5px; width: 5px; height: 5px; border-radius: 50%; background: red; }
	 
	.image_mouse_over_dsp { position: relative; }
	.image_disply_proper_cl { height: 120px; width: 195px; object-fit: scale-down; position: relative; object-position: 50% 50%; object-position: 0 0; overflow: auto; overflow-y: hidden; overflow-x: hidden; }
	.reg_dsn_curated_ft_rs_img_dsp { width: 195px; background-color: white; box-shadow: -4px 4px 5px 0px #797979; height: auto; border: 1px solid #d2d2d2; }
	.middle { transition: .5s ease; opacity: 0; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); -ms-transform: translate(-50%, -50%); text-align: center; }
	.image_mouse_over_dsp:hover .image { opacity: 0.3; filter: alpha(opacity=50); cursor: pointer; outline: none; }
	.image_mouse_over_dsp:hover .middle { opacity: 1; }
	.edit_text_cl { background-color: red; font: bold 1.0em/0.25em Georgia; letter-spacing: 1px; color: white; padding: 12px 24px; border: 1px solid white; }
	
	.view_show_image_disply_cl { width: 746px; object-fit: scale-down; position: relative; object-position: 50% 50%; object-position: 0 0; overflow: auto; overflow-y: hidden; overflow-x: hidden; }
	
	.adm_reg_con_bod_ft_submit_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: red; color: white; display: inline-block; text-transform: uppercase; padding: 6px 36px; outline: none; border: none; font: 500 1.3em/1.5em Georgia; letter-spacing: 2px; cursor: pointer; }
	.adm_reg_con_bod_ft_submit_Btn:hover { background-color: #767171; cursor: pointer; }
	.reg_dsn_curated_ft_title_sel h4 { font: 500 1.25em/1.25em Georgia; color: black; display: block; border-bottom: 1px solid red; padding-bottom: 5px; letter-spacing: 2px; margin-left: 10px; margin-right: 10px; max-width: 275px; }
	</style>
	
	
	
	
	<script type="text/javascript">
	$(document).ready(function () {
		
// Radio Button Value Hold Functionality	    
	    var finishingTouchesRBName1 = "<c:out value="${finishingTouchesRBName}"/>";
	    	    
        if(finishingTouchesRBName1) {
        	$('.radio_container').removeAttr('style');
        	var $radio = $('input[name=typeOfRoomInReg][value="' + finishingTouchesRBName1 + '"]').prop('checked', true).trigger('change');
        	$radio.closest('.radio_container') .css('color','#36669b');
        	$radio.closest('.radio_container') .css('text-decoration','underline');
        	$("#radioLabelNalId").html(finishingTouchesRBName1);	                
        }

// Check Box Value Hold Functionality        
	    var finishingTouchesCBName1 = "<c:out value="${finishingTouchesCBName}"/>";
	    	finishingTouchesCBName1 = finishingTouchesCBName1.replace(/\&amp;/g,"&");
	    	
	    	if(finishingTouchesCBName1) {
	        	$('.radio_ft_container').removeAttr('style');
	        	var $radio = $('input[name=finishingTouchesCBName][value="' + finishingTouchesCBName1 + '"]').prop('checked', true).trigger('change');
	        	$radio.closest('.radio_ft_container') .css('color','red');
	        	$radio.closest('.radio_ft_container') .css('text-decoration','underline');
	        	$("#checkBoxStyleLabelValId").html(finishingTouchesCBName1);	                
	        }   
	    
	});
	
	function typeOfRoom(roomName) { 		
		document.admRoomSelect.adminRegistryRoom.value = roomName;
        $("#roomImgsFormId").submit();
	}
	
	function adminFinTouchesImageUpload(admnUploadImg) {
		$("#finishingTouchesImageId").val(admnUploadImg);
		$("#editImgsFTFormSubmitId").submit();
	}

	function typeOfFinTouches(finishingTouches) {        
        document.adminFTCBSelect.adminFTCBValuesList.value = finishingTouches;
		$("#selCheckBoxSubmitId").submit();		
	}

	function typeOfFinishingTouches(finishingTouches) { 		
		document.admSelectedFT.finishingTouchesRBName.value = finishingTouches;
		$("#admSelectedFTId").submit();
	}
	</script>
	
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
           
        	<div class="row" style="margin-top: 10px; margin-bottom: 60px;">        
				<div class="col-md-6 col-sm-6">
					<div class="row">        
						<div class="col-md-12 col-sm-12" align="left">
					        <table> <tr>
						        <td><a href="regConceptBoards"><font  class="adm_sub_reg_header_red_text_dsp">All Concepts</font></a></td>
							    <!-- <td style="position: relative; left: 18px;"><a href="adminDesignerConcepts"><font class="adm_sub_reg_header_black_text_dsp">Designer Concepts</font></a></td> -->
							    <td style="position: relative; left: 18px;"><a href="adminRegistryStockCheck"><font class="adm_sub_reg_header_black_text_dsp">Stock Check</font></a></td>				        
						    </tr></table>
					    </div>
					</div>
			   	</div>		   	
		   	
		   		<div class="col-md-6 col-sm-6">
		   			<div class="row">        
						<div class="col-md-12 col-sm-12" align="right">
				        	<table> <tr>
				        	<td style="position: relative; left: -36px;"><a href="adminRoomFunds"><font class="adm_sub_reg_header_black_text_dsp">Room Funds</font></a></td>
					        <td style="position: relative; left: -18px;"><a href="adminCashFunds"><font class="adm_sub_reg_header_black_text_dsp">Cash Funds</font></a></td>
					        <td><a href="adminGiftsReceived"><font class="adm_sub_reg_header_black_text_dsp">Gifts Received</font></a></td>
					        </tr></table>
					    </div>
					</div>
			   	</div>
		   	</div>
        
        	<div class="row">        
		        <div class="col-md-12 col-sm-12">
		        <div class="adm_con_bod_text_hd_dsp">CONCEPT BOARDS</div>
		        </div>
		   	</div>
		        
	        <div class="row">        
		        <div class="col-md-3 col-sm-3">
		        	<div class="reg_dsn_cur_con_bord_top_frame">
		        		<div style="padding: 15px;">
			        		<div class="reg_dsn_cur_con_bord_bot_bar">Rooms</div>
			        		<div style="padding-left: 5px; margin-top: 20px;">
				        		<label class="radio_container">Living Room
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Living Room');" value="Living Room">
								  <span class="radio_checkmark"></span>
								</label>
								
								<label class="radio_container">Dining Room
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Dining Room');" value="Dining Room">
								  <span class="radio_checkmark"></span>
								</label>
								
								<label class="radio_container">Bedroom
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Bedroom');" value="Bedroom">
								  <span class="radio_checkmark"></span>
								</label>
								
								<label class="radio_container">Home Office
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Home Office');" value="Home Office">
								  <span class="radio_checkmark"></span>
								</label>
								
								<label class="radio_container">Entryway
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Entryway');" value="Entryway">
								  <span class="radio_checkmark"></span>
								</label>
								
								<label class="radio_container">Nursery
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Nursery');" value="Nursery">
								  <span class="radio_checkmark"></span>
								</label>
								
								<label class="radio_container">Kids Bedroom
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Kids Bedroom');" value="Kids Bedroom">
								  <span class="radio_checkmark"></span>
								</label>
								
								<!-- <label class="radio_container">Playroom
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Playroom');" value="Playroom">
								  <span class="radio_checkmark"></span>
								</label> -->
								
								<label class="radio_container">Outdoor Space
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfRoom('Outdoor Space');" value="Outdoor Space">
								  <span class="radio_checkmark"></span>
								</label>
				        		
								<div class="reg_dsn_con_bord_and_ft_bot_bar"></div>
								
								<label class="radio_container">Finishing Touches
								  <input type="radio" name="typeOfRoomInReg" onclick="typeOfFinishingTouches('Finishing Touches');" value="Finishing Touches">
								  <span class="radio_checkmark"></span>
								</label>
								
				        	</div>
			        	</div>
		        	
		        	</div>
		        	
		        	
		        	<div class="reg_dsn_cur_con_bord_top_frame" style="margin-top: 30px;">
		        		<div style="padding: 15px;">
			        		<div class="reg_dsn_cur_con_bord_bot_bar">Finishing Touches</div>
			        		<div style="padding-left: 5px; margin-top: 20px;">
				        		<label class="radio_ft_container">Curtains
								  <input type="radio" name="finishingTouchesCBName" onclick="typeOfFinTouches('Curtains');" value="Curtains">
								  <span class="radio_ft_checkmark"></span>
								</label>
								
								<label class="radio_ft_container">Bedding
								  <input type="radio" name="finishingTouchesCBName" onclick="typeOfFinTouches('Bedding');" value="Bedding">
								  <span class="radio_ft_checkmark"></span>
								</label>
								
								<label class="radio_ft_container">Pillows
								  <input type="radio" name="finishingTouchesCBName" onclick="typeOfFinTouches('Pillows');" value="Pillows">
								  <span class="radio_ft_checkmark"></span>
								</label>
								
								<label class="radio_ft_container">Throws
								  <input type="radio" name="finishingTouchesCBName" onclick="typeOfFinTouches('Throws');" value="Throws">
								  <span class="radio_ft_checkmark"></span>
								</label>
								
								<label class="radio_ft_container">Kitchen &amp; Dining
								  <input type="radio" name="finishingTouchesCBName" onclick="typeOfFinTouches('Kitchen & Dining');" value="Kitchen & Dining">
								  <span class="radio_ft_checkmark"></span>
								</label>
								
								<label class="radio_ft_container">Home Accessories
								  <input type="radio" name="finishingTouchesCBName" onclick="typeOfFinTouches('Home Accessories');" value="Home Accessories">
								  <span class="radio_ft_checkmark"></span>
								</label>
								
								<label class="radio_ft_container">Mattresses
								  <input type="radio" name="finishingTouchesCBName" onclick="typeOfFinTouches('Mattresses');" value="Mattresses">
								  <span class="radio_ft_checkmark"></span>
								</label>
								
								<label class="radio_ft_container">Lighting
								  <input type="radio" name="finishingTouchesCBName" onclick="typeOfFinTouches('Lighting');" value="Lighting">
								  <span class="radio_ft_checkmark"></span>
								</label>
								
				        	</div>
			        	</div>
		        	
		        	</div>
		        			        			        	
		        	<!-- <div style="margin-top: 30px;">
		        		<button class="reg_dsn_curated_con_boards_sbut" id="uncheckFTCkBox">
	        				<font class="reg_fst_lt_bigft">C</font>LEAR <font class="reg_fst_lt_bigft">A</font>LL <font class="reg_fst_lt_bigft">F</font>ILTERS
	        			</button>
		        	</div> -->
		        </div>
		         
		        <div class="col-md-9 col-sm-9">
		        	
		        	<div class="row" style="margin-top: -8px; padding-bottom: 10px;">
		        	<div class="col-md-5 col-sm-5">
		        	<div align="left" class="reg_dsn_curated_ft_title_sel text-left">
			            <h4><font class="reg_dsn_curated_cb_ftl_bigft">C</font>URATED <font class="reg_dsn_curated_cb_ftl_bigft">D</font>ESIGN <font class="reg_dsn_curated_cb_ftl_bigft">B</font>OARDS</h4>
			        </div>
			        </div>
			        
			        <div align="right" class="col-md-4 col-sm-4">
			        <!-- <form action="adminRegAddNewBoards">
			        <h4><button class="adm_reg_con_bod_ft_submit_Btn" id="addBoardsId" style="margin-right: -12px;">ADD BOARDS</button></h4>
			        </form> -->
			        </div>
			        
			        <div align="right" class="col-md-3 col-sm-3">
			        <form action="adminRegAddNewFinishingTouches">
			        <h4><button class="adm_reg_con_bod_ft_submit_Btn" id="addBoardsId">&nbsp;&nbsp;ADD F.T &nbsp;&nbsp;</button></h4>
			        </form>
			        </div>
			        </div>
		        	
		        	<div class="row">
			        	<div class="col-md-12 col-sm-12">
					        <div style="margin-top: 0px; margin-left: 0px; margin-bottom: 10px;">
					        <table style="width: 850px; min-height: 30px;" class="reg_dsn_curated_cb_rigtext_dspl"><tr>
					        <td style="width: 200px; white-space: nowrap; font-weight: bold;"><font id="radioLabelNalId"></font></td> 
					        <td style="width: 530px; color: red; font-style: italic;">&nbsp;&nbsp;&nbsp;<font id="checkBoxStyleLabelValId"></font></td> <td align="right" style="width: 120px;"><font style="font: bold 1.25em/0.9em Georgia;">${admnRegTotalResultCount}</font> <font style="text-transform: capitalize;">Results</font></td></tr></table>
					        
					        </div>			        
			        	</div>
		        	</div>
		        	
		        			
					<% if (null != session.getAttribute("admFinishingTouchesIdsList")) {
					   @SuppressWarnings("rawtypes")
				       ArrayList admnRegConBdRoomIdsList = (ArrayList) session.getAttribute("admFinishingTouchesIdsList");
				       if (null != admnRegConBdRoomIdsList && admnRegConBdRoomIdsList.size() > 0) {
						   
					   if (null != session.getAttribute("admFinishingTouchesImagesList")) {
					   @SuppressWarnings("rawtypes")
			           ArrayList admnRegConBdRoomImagesList = (ArrayList) session.getAttribute("admFinishingTouchesImagesList");
					   if (null != admnRegConBdRoomImagesList && admnRegConBdRoomImagesList.size() > 0) {						   
			    	%>
					 
					<div class="row">
					<% for(int i=0; i<admnRegConBdRoomIdsList.size(); i++) { int count = (i + 1);%>
			        	<div class="col-md-3 col-sm-3" id="imageDspId<%=count%>" style="margin-bottom: 30px;">		        	
			        	<div class="reg_dsn_curated_ft_rs_img_dsp">
				        	<div class="image_mouse_over_dsp" align="center">
				        	<a class="example-image-link" onClick = "adminFinTouchesImageUpload(<%=admnRegConBdRoomIdsList.get(i)%>);" style="cursor: pointer;" >
				        	<img src="data:image/jpg;base64,<%=admnRegConBdRoomImagesList.get(i)%>" align="middle" id="<%=admnRegConBdRoomIdsList.get(i)%>" class="image_disply_proper_cl">
				        	</a>
				        		<div class="middle">
		    						<div class="edit_text_cl">EDIT</div>
		  						</div>
		  					</div>
			        	</div>
			        	</div>		        			        				        	
			        
		 			<% } %>
		 			</div>
		 			<!-- <div align="left">
		 			<input type="image" style="cursor:pointer; display: none;" id="prev_image" src="resources/images/previous.png" >
		 			</div>
		 			<div align="right">
 					<input type="image" style="cursor:pointer;" id="next_image" src="resources/images/next.png" >
 					</div> -->
		 
		 			<% } } } } %>       	
		        				        
			        
		        </div>
	        
	        </div>
	        
	        <form action="selectedRoomAndStyleRed" id="roomImgsFormId" name="admRoomSelect" method="get">
                <input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom">
                <input type="hidden" id="adminRegistryStyleId" name="adminRegistryStyle">                 
            </form>
            
	        <form action="selectedCBFinishingTouchesRed" id="selCheckBoxSubmitId" name="adminFTCBSelect" method="POST">
                <input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom" value="${adminRegistryRoom}">
                <input type="hidden" id="adminRegistryStyleId" name="adminRegistryStyle" value="${adminRegistryStyle}">
                <input type="hidden" id="adminRegistryPriceId" name="adminRegistryPrice" value="${adminRegistryPrice}">
                <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName" value="${finishingTouchesRBName}">
                <input type="hidden" id="adminFTCBValuesListId" name="adminFTCBValuesList">               
            </form>
                  
	        <form action="unCheckFinishingTouchesCheckBoxes" id="unCheckFinToucheseFormId" method="get">
                <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName" value="${finishingTouchesRBName}">                                
            </form>
            
			<form action="selectedFinishingTouchesRed" id="admSelectedFTId" name="admSelectedFT" method="POST">
                <input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom" value="${adminRegistryRoom}">
                <input type="hidden" id="adminRegistryStyleId" name="adminRegistryStyle" value="${adminRegistryStyle}">
                <input type="hidden" id="adminRegistryPriceId" name="adminRegistryPrice" value="${adminRegistryPrice}">
                <input type="hidden" id="adminFTCBValuesListId" name="adminFTCBValuesList" value="${adminFTCBValuesList}">
                <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName">
            </form>
        
        </div>
        </div>
        
        
        <form action="selectedFinishingTouchesImageEdit" id="editImgsFTFormSubmitId" method="POST">		
			<input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom" value="${adminRegistryRoom}">
	        <input type="hidden" id="adminRegistryStyleId" name="adminRegistryStyle" value="${adminRegistryStyle}">
	        <input type="hidden" id="adminRegistryPriceId" name="adminRegistryPrice" value="${adminRegistryPrice}">
	        <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName" value="${finishingTouchesRBName}">
	        <input type="hidden" id="adminFTCBValuesListId" name="adminFTCBValuesList" value="${adminFTCBValuesList}">
			<input type="hidden" id="finishingTouchesImageId" name="finishingTouchesImage">
		</form>
		
		</body>
</html>
