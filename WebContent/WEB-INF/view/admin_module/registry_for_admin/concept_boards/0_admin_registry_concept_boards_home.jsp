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
	
	.checkbox_container_for_price { display: block; position: relative; padding-left: 25px; margin-bottom: 12px; font: 1.2em/0.9em Georgia; letter-spacing: 1px; color: black; cursor: pointer; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none; }	
	.checkbox_container_for_price input { position: absolute; opacity: 0; cursor: pointer; height: 0; width: 0; }	
	.ckbox_checkmark { position: absolute; top: 0; left: 0; height: 15px; width: 15px; background-color: #f2f2f2; border: 1px solid #8b8b8b; }	
	.checkbox_container_for_price:hover input ~ .ckbox_checkmark { background-color: #36669b; border: 1px solid #0a3180; }
	.checkbox_container_for_price:hover { color: #36669b; outline: none; }	
	.checkbox_container_for_price input:checked ~ .ckbox_checkmark { background-color: #36669b; border: 1px solid #0a3180; }	
	.ckbox_checkmark:after { content: ""; position: absolute; display: none; }	
	.checkbox_container_for_price input:checked ~ .ckbox_checkmark:after { display: block; }	
	.checkbox_container_for_price .ckbox_checkmark:after { left: 4px; top: 1px; width: 5px; height: 10px; border: solid white; border-width: 0 3px 3px 0; -webkit-transform: rotate(45deg); -ms-transform: rotate(45deg); transform: rotate(45deg); }	
	.reg_dsn_curated_cb_rigtext_dspl:first-of-type::first-letter { font: 1.25em/1.25em Georgia; color: black; }
	
	.image_mouse_over_dsp { position: relative; }
	.image_disply_proper_cl { width: auto; height: 230px; object-fit: scale-down; position: relative; object-position: 50% 50%; object-position: 0 0; overflow: auto; overflow-y: hidden; overflow-x: hidden; }
	.middle { transition: .5s ease; opacity: 0; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); -ms-transform: translate(-50%, -50%); text-align: center; }
	.image_mouse_over_dsp:hover .image { opacity: 0.3; filter: alpha(opacity=50); cursor: pointer; outline: none; }
	.image_mouse_over_dsp:hover .middle { opacity: 1; }
	.edit_text_cl { background-color: #36669b; font: 500 1em/0.25em Georgia; letter-spacing: 2px; color: white; padding: 14px 24px; }
	
	.view_show_image_disply_cl { width: 746px; object-fit: scale-down; position: relative; object-position: 50% 50%; object-position: 0 0; overflow: auto; overflow-y: hidden; overflow-x: hidden; }
	.adm_reg_con_bod_ft_submit_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: red; color: white; display: inline-block; text-transform: uppercase; padding: 6px 36px; outline: none; border: none; font: 500 1.3em/1.5em Georgia; letter-spacing: 2px; cursor: pointer; }
	.adm_reg_con_bod_ft_submit_Btn:hover { background-color: #767171; cursor: pointer; }
	.reg_dsn_curated_ft_title_sel h4 { font: 500 1.25em/1.25em Georgia; color: black; display: block; border-bottom: 1px solid red; padding-bottom: 5px; letter-spacing: 2px; margin-left: 10px; margin-right: 10px; max-width: 275px; }
	</style>
	
	<script type="text/javascript">
	    $(document).ready(function(){
	    	$('input:radio').each(function () {
	    		if($(this).is(':checked')) {
	    			var radioValue = $("input[name='typeOfRoomInReg']:checked").val();
	    			if(radioValue){
		            	$('.radio_container').removeAttr('style');
		            	var $radio = $(this).closest('div').find('input[type="radio"]:checked');	            	
		            	$radio.closest('.radio_container') .css('color','#36669b');
		            	$radio.closest('.radio_container') .css('text-decoration','underline');
		            	$("#radioLabelNalId").html(radioValue);		                
		            } 
	    		} 
	    	});
	    		    	
	    	$('input:checkbox').each(function () {	    		
	    		var radioValue = $("input[name='typeOfStyleInReg']:checked").val();	    		
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
	                
	                $.each($("input[name='typeOfStyleInReg']:checked"), function(){ 
	                    favorite.push($(this).val());
	                });	                
	                $("#checkBoxStyleLabelValId").html(favorite.join(", "));
	            }
	            
	            /* Price Validation in Jquery */
	            
	            var radioValue1 = $("input[name='typeOfPriceInReg']:checked").val();	            
	            var favorite1 = [];
	            if(radioValue1){	            	
	                if($(this).prop("checked") == true){		            	
		            	var $checkbox = $(this).closest('div').find('input[type="checkbox"]:checked');		            	
		            	$checkbox.closest('.checkbox_container_for_price') .css('color','#36669b');		            	
	              	} else {
	              		$('.checkbox_container_for_price').removeAttr('style');
		            	var $checkbox = $(this).closest('div').find('input[type="checkbox"]:checked');
		            	$checkbox.closest('.checkbox_container_for_price') .css('color','#36669b');
	              	}
	                
	                $.each($("input[name='typeOfPriceInReg']:checked"), function(){ 
	                    favorite1.push($(this).val());
	                });	                
	                $("#checkBoxPriceLabelValId").html(favorite1.join(", "));
	            }
	            	            
	    	});
	    		    	
	    	
	        $("input[type='radio']").click(function(){
	            var radioValue = $("input[name='typeOfRoomInReg']:checked").val();
	            if(radioValue){
	            	$('.radio_container').removeAttr('style');
	            	var $radio = $(this).closest('div').find('input[type="radio"]:checked');	            	
	            	$radio.closest('.radio_container') .css('color','#36669b');
	            	$radio.closest('.radio_container') .css('text-decoration','underline');
	            	$("#radioLabelNalId").html(radioValue);	                
	            } 
	        });
	        
	        $("input[type='checkbox']").click(function(){	        	
	            var checkboxValue = $("input[name='typeOfStyleInReg']:checked").val();
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
	                
	                $.each($("input[name='typeOfStyleInReg']:checked"), function(){ 
	                    favorite.push($(this).val());
	                });	                
	                $("#checkBoxStyleLabelValId").html(favorite.join(", "));	                
	            }
	            
	            /* Price Validation in Jquery */
	            
	            var checkboxValue1 = $("input[name='typeOfPriceInReg']:checked").val();
	            var favorite1 = [];
	            if(checkboxValue1){
	            	if($(this).prop("checked") == true){		            	
		            	var $checkbox = $(this).closest('div').find('input[type="checkbox"]:checked');		            	
		            	$checkbox.closest('.checkbox_container_for_price') .css('color','#36669b');		            	
	              	} else {
	              		$('.checkbox_container_for_price').removeAttr('style');
		            	var $checkbox = $(this).closest('div').find('input[type="checkbox"]:checked');
		            	$checkbox.closest('.checkbox_container_for_price') .css('color','#36669b');
	              	}
	                
	                $.each($("input[name='typeOfPriceInReg']:checked"), function(){ 
	                    favorite1.push($(this).val());
	                });	                
	                $("#checkBoxPriceLabelValId").html(favorite1.join(", "));
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
		
	    $("#uncheckCkBox").click(function(){
	    	$('.checkbox_container').removeAttr('style');
	    	$('.checkbox_container_for_price').removeAttr('style');
	    	$("#checkBoxStyleLabelValId").html("");
	    	$("#checkBoxPriceLabelValId").html("");
	        $('input[name=typeOfStyleInReg]').attr('checked', false);
	        $('input[name=typeOfPriceInReg]').attr('checked', false);
	        $("#unCheckStyleAndPriceFormId").submit();
	    });
		
	});
	</script>
	
	<script type="text/javascript">
	$(document).ready(function () {
		/* var admnRoomsCount1 = "<c:out value="${admnRegTotalResultCount}"/>";
		var admnRoomsCount = parseInt(admnRoomsCount1);
		$('#imageDspId1').show();
	    $('#imageDspId2').show();
	    $('#imageDspId3').show();
	    $('#imageDspId4').show();
	    $('#prev_image').hide();
	    if(admnRoomsCount <= 4) {
	    	$('#next_image').hide();
	    }
	    var count = 4;
	    var maxCount = 4;
	    $('#next_image').click(function () {
	    	for(i = (count+1); i <= (maxCount+4) && i <= admnRoomsCount; i++) {
	    		var imageDsplId = "imageDspId"+i;
	    		$("#"+imageDsplId).show();
	        	count = count + 1;
	    	}
	    	var imageDsprId = "imageDspId"+maxCount;
        	$("#imageDspId"+maxCount).hide();
        	$("#imageDspId"+(maxCount-1)).hide();
        	$("#imageDspId"+(maxCount-2)).hide();
        	$("#imageDspId"+(maxCount-3)).hide();
	    	maxCount = maxCount + 4;	    	
	    	$('#prev_image').show();
	        if(count == admnRoomsCount){
	            $('#next_image').hide();
	        }
	    });
	    $('#prev_image').click(function () {
	    	for(i = count; i > (maxCount-4); i--) {
	    		var imageDsplId = "imageDspId"+i;
	    		$("#"+imageDsplId).hide();
	        	count = count - 1;	        	
	    	}
	    	maxCount = maxCount - 4;
	    	var imageDsprId = "imageDspId"+maxCount;
        	$("#imageDspId"+maxCount).show();
        	$("#imageDspId"+(maxCount-1)).show();
        	$("#imageDspId"+(maxCount-2)).show();
        	$("#imageDspId"+(maxCount-3)).show();        	
	    	$('#next_image').show();
	        if(count == 4){
	            $('#prev_image').hide();
	        }
	    }); */
	    
	    
// Radio Button Value Hold Functionality	    
	    var adminRegistryRoom1 = "<c:out value="${adminRegistryRoom}"/>";
        if(adminRegistryRoom1) {
        	$('.radio_container').removeAttr('style');
        	var $radio = $('input[name=typeOfRoomInReg][value="' + adminRegistryRoom1 + '"]').prop('checked', true).trigger('change');
        	$radio.closest('.radio_container') .css('color','#36669b');
        	$radio.closest('.radio_container') .css('text-decoration','underline');
        	$("#radioLabelNalId").html(adminRegistryRoom1);	                
        }

// Check Box Value Hold Functionality        
	    var adminRegistryStyle1 = "<c:out value="${adminRegistryStyle}"/>";
	    if(adminRegistryStyle1) {
        	var checkboxList = [];
        	var checkboxListVal = adminRegistryStyle1.split(",");
        	$('.checkbox_container').removeAttr('style');       	
        	
        	for(i=0; i<checkboxListVal.length; i++) {
        		var $checkbox = $('input[name=typeOfStyleInReg][value="' + checkboxListVal[i] + '"]').prop('checked', true).trigger('change');
            	$checkbox.closest('.checkbox_container') .css('color','#36669b');
            	$checkbox.closest('.checkbox_container') .css('text-decoration','underline');
        		checkboxList.push(checkboxListVal[i]);
            }        	
            $("#checkBoxStyleLabelValId").html(checkboxList.join(", "));        	                
        }
	    
	    /* Price Validation in Jquery */
	    
	    var adminRegistryPrice1 = "<c:out value="${adminRegistryPrice}"/>";
	    if(adminRegistryPrice1) {
        	var checkboxList1 = [];
        	var checkboxListVal1 = adminRegistryPrice1.split(",");
        	$('.checkbox_container_for_price').removeAttr('style');       	
        	
        	for(i=0; i<checkboxListVal1.length; i++) {
        		var $checkbox = $('input[name=typeOfPriceInReg][value="' + checkboxListVal1[i] + '"]').prop('checked', true).trigger('change');
            	$checkbox.closest('.checkbox_container_for_price') .css('color','#36669b');
            	$checkbox.closest('.checkbox_container_for_price') .css('text-decoration','underline');
        		checkboxList1.push(checkboxListVal1[i]);
            }        	
            $("#checkBoxPriceLabelValId").html(checkboxList1.join(", "));        	                
        }
	    
	    if(adminRegistryStyle1 !== "" && adminRegistryPrice1 !== "") {
        	$("#bothDisplayId").show();
        } else {
        	$("#bothDisplayId").hide();
        }
	    
	});
	
	function typeOfRoom(roomName) { 		
		document.admRoomSelect.adminRegistryRoom.value = roomName;
        $("#roomImgsFormId").submit();
	}
	
	function adminRegImageUpload(admnUploadImg) {
		$("#conceptImagesId").val(admnUploadImg);
		$("#editImgsFormSubmitId").submit();
	}

	function typeOfStyle() { 
        var checkboxList = [];
        $.each($("input[name='typeOfStyleInReg']:checked"), function(){ 
        	checkboxList.push($(this).val());
        	checkboxList.join(", ");
        });
        document.admStyleSelect.adminRegistryStyle.value = checkboxList;
		$("#styleImgsFormId").submit();		
	}

	function typeOfPrice() { 
        var checkboxList = [];
        $.each($("input[name='typeOfPriceInReg']:checked"), function(){ 
        	checkboxList.push($(this).val());
        	checkboxList.join(", ");
        });
        document.admPriceSelect.adminRegistryPrice.value = checkboxList;
		$("#priceImgsFormId").submit();
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
			        		<div class="reg_dsn_cur_con_bord_bot_bar">Style</div>
			        		<div style="padding-left: 5px; margin-top: 20px;">
				        		<label class="checkbox_container">Modern/Contemporary
								  <input type="checkbox" name="typeOfStyleInReg" onclick="typeOfStyle();" value="Modern/Contemporary">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Classic/Traditional
								  <input type="checkbox" name="typeOfStyleInReg" onclick="typeOfStyle();" value="Classic/Traditional">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Eclectic/Boho
								  <input type="checkbox" name="typeOfStyleInReg" onclick="typeOfStyle();" value="Eclectic/Boho">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Coastal
								  <input type="checkbox" name="typeOfStyleInReg" onclick="typeOfStyle();" value="Coastal">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container">Glam/Lux
								  <input type="checkbox" name="typeOfStyleInReg" onclick="typeOfStyle();" value="Glam/Lux">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<!-- <label class="checkbox_container">Industrial
								  <input type="checkbox" name="typeOfStyleInReg" onclick="typeOfStyle();" value="Industrial">
								  <span class="ckbox_checkmark"></span>
								</label> -->
								
								<label class="checkbox_container">Rustic
								  <input type="checkbox" name="typeOfStyleInReg" onclick="typeOfStyle();" value="Rustic">
								  <span class="ckbox_checkmark"></span>
								</label>
				        
				        	</div>
			        	</div>
		        	
		        	</div>
		        	
		        	<div class="reg_dsn_cur_con_bord_midd_frame" style="margin-top: 30px;">
		        		<div style="padding: 15px;">
			        		<div class="reg_dsn_cur_con_bord_bot_bar">Price</div>
			        		<div style="padding-left: 5px; margin-top: 20px;">
				        		<label class="checkbox_container_for_price">$1,500 - $5,000
								  <input type="checkbox" name="typeOfPriceInReg" onclick="typeOfPrice();" value="1500 - 5000">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container_for_price">$5,000 - $10,000
								  <input type="checkbox" name="typeOfPriceInReg" onclick="typeOfPrice();" value="5000 - 10000">
								  <span class="ckbox_checkmark"></span>
								</label>
								
								<label class="checkbox_container_for_price">$10,000+
								  <input type="checkbox" name="typeOfPriceInReg" onclick="typeOfPrice();" value="10000+">
								  <span class="ckbox_checkmark"></span>
								</label>
												        
				        	</div>
			        	</div>
		        	
		        	</div>
		        	
		        	<div style="margin-top: 30px;">
		        		<button class="reg_dsn_curated_con_boards_sbut" id="uncheckCkBox">
	        				<font class="reg_fst_lt_bigft">C</font>LEAR <font class="reg_fst_lt_bigft">A</font>LL <font class="reg_fst_lt_bigft">F</font>ILTERS
	        			</button>
		        	</div>
		        </div>
		         
		        <div class="col-md-9 col-sm-9">
		        	
		        	<div class="row" style="margin-top: -8px; padding-bottom: 10px;">
		        	<div class="col-md-7 col-sm-7">
		        	<div align="left" class="reg_dsn_curated_ft_title_sel text-left">
			            <h4><font class="reg_dsn_curated_cb_ftl_bigft">C</font>URATED <font class="reg_dsn_curated_cb_ftl_bigft">D</font>ESIGN <font class="reg_dsn_curated_cb_ftl_bigft">B</font>OARDS</h4>
			        </div>
			        </div>
			        <div align="right" class="col-md-5 col-sm-5">
			        <form action="adminRegAddNewBoards">
			        <h4><button class="adm_reg_con_bod_ft_submit_Btn" id="addBoardsId">ADD BOARDS</button></h4>
			        </form>
			        </div>
			        
			        <!-- <div align="right" class="col-md-2 col-sm-2">
			        <form action="adminRegAddNewFinishingTouches">
			        <h4><button class="add_ft_reg_con_bod_submit_Btn" id="addBoardsId">ADD FT</button></h4>
			        </form>
			        </div> -->
			        </div>
		        	
		        	<div class="row" style="margin-bottom: 25px;">
			        	<div class="col-md-12 col-sm-12">
					        <div style="margin-top: 15px; margin-left: 0px;">
					        <table style="width: 850px; min-height: 30px; height: auto;" class="reg_dsn_curated_cb_rigtext_dspl"><tr>
					        <td style="width: 170px; white-space: nowrap;"><font id="radioLabelNalId"></font></td> <td style="width: 570px;"><font id="checkBoxStyleLabelValId"></font> <font style="display: none; font: 1.3em/1.25em Georgia;" id="bothDisplayId">, </font> <font id="checkBoxPriceLabelValId" style="font: 1.3em/1.25em Georgia;"></font></td> <td align="right" style="width: 120px;"><font style="font: bold 1.25em/0.9em Georgia;">${admnRegTotalResultCount}</font> <font style="text-transform: capitalize;">Results</font></td>
					        </tr></table>
					        
					        </div>			        
			        	</div>
		        	</div>
		        	
		        			
					<% if (null != session.getAttribute("admnRegConBdRoomIdsListInSn")) {
					   @SuppressWarnings("rawtypes")
				       ArrayList admnRegConBdRoomIdsList = (ArrayList) session.getAttribute("admnRegConBdRoomIdsListInSn");
				       if (null != admnRegConBdRoomIdsList && admnRegConBdRoomIdsList.size() > 0) {
						   
					   if (null != session.getAttribute("admnRegConBdRoomImagesListInSn")) {
					   @SuppressWarnings("rawtypes")
			           ArrayList admnRegConBdRoomImagesList = (ArrayList) session.getAttribute("admnRegConBdRoomImagesListInSn");
					   if (null != admnRegConBdRoomImagesList && admnRegConBdRoomImagesList.size() > 0) {						   
			    	%>
					 
					<div class="row" style="max-height: 785px; overflow-y: scroll;">
					<% for(int i=0; i<admnRegConBdRoomIdsList.size(); i++) { int count = (i + 1);%>
			        	<div class="col-md-6 col-sm-6" id="imageDspId<%=count%>" style="margin-bottom: 30px;">		        	
			        	<div class="reg_dsn_curated_cb_rs_imgs_dsp">
				        	<div class="image_mouse_over_dsp" align="center">
				        	<a class="example-image-link" onClick = "adminRegImageUpload(<%=admnRegConBdRoomIdsList.get(i)%>);" style="cursor: pointer;" >
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
            
	        <form action="selectedStyleAndRoomRed" id="styleImgsFormId" name="admStyleSelect" method="get">
                <input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom" value="${adminRegistryRoom}">
                <input type="hidden" id="adminRegistryStyleId" name="adminRegistryStyle">
                <input type="hidden" id="adminRegistryPriceId" name="adminRegistryPrice" value="${adminRegistryPrice}">                 
            </form>
            
	        <form action="selectedStyleRoomAndPriceRed" id="priceImgsFormId" name="admPriceSelect" method="get">
                <input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom" value="${adminRegistryRoom}">
                <input type="hidden" id="adminRegistryStyleId" name="adminRegistryStyle" value="${adminRegistryStyle}">
                <input type="hidden" id="adminRegistryPriceId" name="adminRegistryPrice">                 
            </form>
                        
	        <form action="unCheckStyleAndPriceBoxesRed" id="unCheckStyleAndPriceFormId" method="get">
                <input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom" value="${adminRegistryRoom}">                                
            </form>
            
			<form action="selectedFinishingTouchesRed" id="admSelectedFTId" name="admSelectedFT" method="POST">
                <input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom" value="${adminRegistryRoom}">
                <input type="hidden" id="adminRegistryStyleId" name="adminRegistryStyle" value="${adminRegistryStyle}">
                <input type="hidden" id="adminRegistryPriceId" name="adminRegistryPrice" value="${adminRegistryPrice}">
                <input type="hidden" id="finishingTouchesRBNameId" name="finishingTouchesRBName">
            </form>
        
        </div>
        </div>
        
        
        <form action="selectedRoomAndStyleImageUpload" id="editImgsFormSubmitId" method="get">		
		<input type="hidden" id="adminRegistryRoomId" name="adminRegistryRoom" value="${adminRegistryRoom}">
		<input type="hidden" id="conceptImagesId" name="conceptImagesName">
		</form>
		
		</body>
</html>
