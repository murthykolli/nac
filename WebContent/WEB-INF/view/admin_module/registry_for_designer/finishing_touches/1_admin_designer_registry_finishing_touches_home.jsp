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
	.radio_container .radio_checkmark:after { top: 5px; left: 5px; width: 5px; height: 5px; border-radius: 50%; background: white; }
	/* label.radio_container:focus-within { color: #36669b; text-decoration: underline; outline: none; } */
	 
	.checkbox_container { display: block; position: relative; padding-left: 25px; margin-bottom: 12px; font: 1.2em/0.9em Georgia; letter-spacing: 1px; color: black; cursor: pointer; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; }	
	.checkbox_container input { position: absolute; opacity: 0; cursor: pointer; height: 0; width: 0; }	
	.ckbox_checkmark { position: absolute; top: 0; left: 0; height: 15px; width: 15px; background-color: #f2f2f2; border: 1px solid #8b8b8b; }	
	.checkbox_container:hover input ~ .ckbox_checkmark { background-color: #36669b; border: 1px solid #0a3180; }
	.checkbox_container:hover { color: #36669b; outline: none; }	
	.checkbox_container input:checked ~ .ckbox_checkmark { background-color: #36669b; border: 1px solid #0a3180; }	
	.ckbox_checkmark:after { content: ""; position: absolute; display: none; }	
	.checkbox_container input:checked ~ .ckbox_checkmark:after { display: block; }	
	.checkbox_container .ckbox_checkmark:after { left: 4px; top: 1px; width: 5px; height: 10px; border: solid white; border-width: 0 3px 3px 0; -webkit-transform: rotate(45deg); -ms-transform: rotate(45deg); transform: rotate(45deg); }	
	.reg_dsn_curated_cb_rigtext_dspl:first-of-type::first-letter { font: 1.25em/1.25em Georgia; color: black; }
	
	.image_mouse_over_dsp { position: relative; }
	.image_disply_proper_cl { width: auto; height: 230px; object-fit: scale-down; position: relative; object-position: 50% 50%; object-position: 0 0; overflow: auto; overflow-y: hidden; overflow-x: hidden; }
	.middle { transition: .5s ease; opacity: 0; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); -ms-transform: translate(-50%, -50%); text-align: center; }
	.image_mouse_over_dsp:hover .image { opacity: 0.3; filter: alpha(opacity=50); cursor: pointer; outline: none; }
	.image_mouse_over_dsp:hover .middle { opacity: 1; }
	.edit_text_cl { background-color: #36669b; font: 500 1em/0.25em Georgia; letter-spacing: 2px; color: white; padding: 14px 24px; }
	
	.view_show_image_disply_cl { width: 746px; object-fit: scale-down; position: relative; object-position: 50% 50%; object-position: 0 0; overflow: auto; overflow-y: hidden; overflow-x: hidden; }
	</style>
	
	<script type="text/javascript">
	    $(document).ready(function(){
	    	  	
	    	$('input:checkbox').each(function () {	    		
	    		var radioValue = $("input[name='finishingTouchesCBName']:checked").val();	    		
	            var favorite = [];	            
	            if(radioValue){	            	
	                if($(this).prop("checked") == true){		            	
		            	var $checkbox = $(this).closest('div').find('input[type="checkbox"]:checked');		            	
		            	$checkbox.closest('.checkbox_container') .css('color','#36669b');		            	
	              	} else {
	              		$('.checkbox_container').removeAttr('style');
		            	var $checkbox = $(this).closest('div').find('input[type="checkbox"]:checked');
		            	$checkbox.closest('.checkbox_container') .css('color','#36669b');
	              	}
	                
	                $.each($("input[name='finishingTouchesCBName']:checked"), function(){ 
	                    favorite.push($(this).val());
	                });	                
	                $("#checkBoxStyleLabelValId").html(favorite.join(", "));
	            }
	            	            	            
	    	});
	    		    	
	    	
	        $("input[type='checkbox']").click(function(){	        	
	            var checkboxValue = $("input[name='finishingTouchesCBName']:checked").val();
	            var favorite = [];
	            if(checkboxValue){	            	
	            	if($(this).prop("checked") == true){		            	
		            	var $checkbox = $(this).closest('div').find('input[type="checkbox"]:checked');		            	
		            	$checkbox.closest('.checkbox_container') .css('color','#36669b');		            	
	              	} else {
	              		$('.checkbox_container').removeAttr('style');
		            	var $checkbox = $(this).closest('div').find('input[type="checkbox"]:checked');
		            	$checkbox.closest('.checkbox_container') .css('color','#36669b');
	              	}
	                
	                $.each($("input[name='finishingTouchesCBName']:checked"), function(){ 
	                    favorite.push($(this).val());
	                });	                
	                $("#checkBoxStyleLabelValId").html(favorite.join(", "));	                
	            }
	            	            	            	            
	        });
	        	        
	    });
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('.image').click(function(){			
			var viewImgs = $(this).attr("src");
			var imgId = $(this).attr("id");
			$("#"+imgId+"Dsp").attr("href", viewImgs);
		});
		
	    $("#uncheckFTCkBox").click(function(){
	    	$('.checkbox_container').removeAttr('style');
	    	$("#checkBoxStyleLabelValId").html("");
	    	$('input[name=finishingTouchesCBName]').attr('checked', false);
	        $("#unCheckFinToucheseFormId").submit();
	    });
		
	});
	</script>
	
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
        	var checkboxList = [];
        	var checkboxListVal = finishingTouchesCBName1.split(",");
        	$('.checkbox_container').removeAttr('style');       	
        	
        	for(i=0; i<checkboxListVal.length; i++) {
        		var $checkbox = $('input[name=finishingTouchesCBName][value="' + checkboxListVal[i] + '"]').prop('checked', true).trigger('change');
            	$checkbox.closest('.checkbox_container') .css('color','#36669b');
            	$checkbox.closest('.checkbox_container') .css('text-decoration','underline');
        		checkboxList.push(checkboxListVal[i]);
            }        	
            $("#checkBoxStyleLabelValId").html(checkboxList.join(", "));        	                
        }	    
	    
	});
	
	function typeOfRoom(roomName) { 		
		document.admRoomSelect.designerRegistryRoom.value = roomName;
        $("#roomImgsFormId").submit();
	}
	
	function adminFinTouchesImageUpload(admnUploadImg) {
		$("#finishingTouchesImageId").val(admnUploadImg);
		$("#editImgsFTFormSubmitId").submit();
	}

	function typeOfFinTouches() { 
        var checkboxList = [];
        $.each($("input[name='finishingTouchesCBName']:checked"), function(){ 
        	checkboxList.push($(this).val());
        	checkboxList.join(", ");
        });
        document.adminFTCBSelect.designerFTCBValuesList.value = checkboxList;
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
						        <td><a href="regConceptBoards"><font  class="adm_sub_reg_header_black_text_dsp">All Concepts</font></a></td>
							    <td style="position: relative; left: 18px;"><a href="adminDesignerConcepts"><font class="adm_sub_reg_header_red_text_dsp">Designer Concepts</font></a></td>
							    <td style="position: relative; left: 36px;"><a href="adminRegistryStockCheck"><font class="adm_sub_reg_header_black_text_dsp">Stock Check</font></a></td>				        
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
				        		<label class="checkbox_container">Decorative Objects
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Decorative Objects">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Pillows
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Pillows">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Vases
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Vases">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Candles
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Candles">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Accent Trays
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Accent Trays">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Mirrors
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Mirrors">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Lighting
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Lighting">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Art &amp; Wall Decor
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Art & Wall Decor">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Office Accessories
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Office Accessories">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Organization/Storage
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Organization/Storage">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Curtains &amp; Hardware
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Curtains & Hardware">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Floral/Plants
								  <input type="checkbox" name="finishingTouchesCBName" onclick="typeOfFinTouches();" value="Floral/Plants">
								  <span class="ckbox_checkmark"></span>
								</label>
				        
				        	</div>
			        	</div>
		        	
		        	</div>
		        			        			        	
		        	<div style="margin-top: 30px;">
		        		<button class="reg_dsn_curated_con_boards_sbut" id="uncheckFTCkBox">
	        				<font class="reg_fst_lt_bigft">C</font>LEAR <font class="reg_fst_lt_bigft">A</font>LL <font class="reg_fst_lt_bigft">F</font>ILTERS
	        			</button>
		        	</div>
		        </div>
		         
		        <div class="col-md-9 col-sm-9">
		        	
		        	<div class="row" style="margin-top: -8px; padding-bottom: 10px;">
		        	<div class="col-md-7 col-sm-7">
		        	<div align="left" class="reg_dsn_curated_cb_title_sel text-left">
			            <h4><font class="reg_dsn_curated_cb_ftl_bigft">D</font>ESIGNER <font class="reg_dsn_curated_cb_ftl_bigft">C</font>URATED <font class="reg_dsn_curated_cb_ftl_bigft">C</font>ONCEPT <font class="reg_dsn_curated_cb_ftl_bigft">B</font>OARDS</h4>
			        </div>
			        </div>
			        
			        <div align="right" class="col-md-3 col-sm-3">
			        <form action="adminDesignerRegAddNewBoards">
			        <h4><button class="adm_reg_con_bod_submit_Btn" id="addBoardsId">ADD BOARDS</button></h4>
			        </form>
			        </div>
			        
			        <div align="right" class="col-md-2 col-sm-2">
			        <form action="adminDesignerRegAddNewFinishingTouches">
			        <h4><button class="add_ft_reg_con_bod_submit_Btn" id="addBoardsId">ADD FT</button></h4>
			        </form>
			        </div>
			        </div>
		        	
		        	<div class="row">
			        	<div class="col-md-12 col-sm-12">
					        <div style="margin-top: 15px; margin-left: 0px; margin-bottom: 25px;">
					        <table style="width: 850px; min-height: 30px;" class="reg_dsn_curated_cb_rigtext_dspl"><tr>
					        <td style="width: 200px; white-space: nowrap;"><font id="radioLabelNalId"></font></td> 
					        <td style="width: 530px;"><font id="checkBoxStyleLabelValId"></font></td> <td align="right" style="width: 120px;"><font style="font: bold 1.25em/0.9em Georgia;">${adminDesignerRegTotalResultCount}</font> <font style="text-transform: capitalize;">Results</font></td></tr></table>
					        
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
					 
					<div class="row" style="max-height: 785px; overflow-y: scroll;">
					<% for(int i=0; i<admnRegConBdRoomIdsList.size(); i++) { int count = (i + 1);%>
			        	<div class="col-md-6 col-sm-6" id="imageDspId<%=count%>" style="margin-bottom: 30px;">		        	
			        	<div class="reg_dsn_curated_cb_rs_imgs_dsp">
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
	        
	        <form action="adminDesignerSelectedRoomAndStyleRed" id="roomImgsFormId" name="admRoomSelect" method="get">
                <input type="hidden" id="designerRegistryRoomId" name="designerRegistryRoom">
                <input type="hidden" id="designerRegistryStyleId" name="designerRegistryStyle">                 
            </form>
            
	        <form action="adminDesignerSelectedCBFinishingTouchesRed" id="selCheckBoxSubmitId" name="adminFTCBSelect" method="POST">
                <input type="hidden" id="designerRegistryRoomId" name="designerRegistryRoom" value="${designerRegistryRoom}">
                <input type="hidden" id="designerRegistryStyleId" name="designerRegistryStyle" value="${designerRegistryStyle}">
                <input type="hidden" id="designerRegistryPriceId" name="designerRegistryPrice" value="${designerRegistryPrice}">
                <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName" value="${finishingTouchesRBName}">
                <input type="hidden" id="designerFTCBValuesListId" name="designerFTCBValuesList">               
            </form>
                  
	        <form action="adminDesignerUnCheckFinishingTouchesCheckBoxes" id="unCheckFinToucheseFormId" method="get">
                <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName" value="${finishingTouchesRBName}">                                
            </form>
            
			<form action="adminDesignerSelectedFinishingTouchesRed" id="admSelectedFTId" name="admSelectedFT" method="POST">
                <input type="hidden" id="designerRegistryRoomId" name="designerRegistryRoom" value="${designerRegistryRoom}">
                <input type="hidden" id="designerRegistryStyleId" name="designerRegistryStyle" value="${designerRegistryStyle}">
                <input type="hidden" id="designerRegistryPriceId" name="designerRegistryPrice" value="${designerRegistryPrice}">
                <input type="hidden" id="designerFTCBValuesListId" name="designerFTCBValuesList" value="${designerFTCBValuesList}">
                <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName">
            </form>
        
        </div>
        </div>
        
        
        <form action="adminDesignerSelectedFinishingTouchesImageEdit" id="editImgsFTFormSubmitId" method="POST">		
			<input type="hidden" id="designerRegistryRoomId" name="designerRegistryRoom" value="${designerRegistryRoom}">
	        <input type="hidden" id="designerRegistryStyleId" name="designerRegistryStyle" value="${designerRegistryStyle}">
	        <input type="hidden" id="designerRegistryPriceId" name="designerRegistryPrice" value="${designerRegistryPrice}">
	        <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName" value="${finishingTouchesRBName}">
	        <input type="hidden" id="designerFTCBValuesListId" name="designerFTCBValuesList" value="${designerFTCBValuesList}">
			<input type="hidden" id="finishingTouchesImageId" name="finishingTouchesImage">
		</form>
		
		</body>
</html>
