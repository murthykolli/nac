<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/css/file_upload.css" type="text/css">
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
    <link rel="stylesheet" href="resources/css/popup/lightbox_for_registry.css" media="screen"/>
		
	<script type="text/javascript">
 	$(document).ready(function() {
	    
 		$("#saveBoardButtId").click(function (){
 		var result = true; 
	    if($("#designerRegistryRoomId").val() !== ""){ $("#designerRegistryRoomLabelId").css("color","black");
	    } else{ $("#designerRegistryRoomLabelId").css("color","red"); result=false; }

        $('#designerRegistryStyleId :selected').each(function(i, sel) {
        	if($(sel).val() !== ""){ $("#designerRegistryStyleLabelId").css("color","black");
    	    } else{ $("#designerRegistryStyleLabelId").css("color","red"); result=false; }            
        }); 
        
	    if($("#designerRegistryPriceId").val() !== ""){ $("#designerRegistryPriceLabelId").css("color","black");
	    } else{ $("#designerRegistryPriceLabelId").css("color","red"); result=false; }
 
	    return result;
	    });
	        
	// Sign Up keyboard validations
	        
	    $("#designerRegistryRoomId").change(function(){
	    if(this.value !== ""){ $("#designerRegistryRoomLabelId").css("color","black");
	    } else{ $("#designerRegistryRoomLabelId").css("color","red");
	    } });
	        
	    $("#designerRegistryStyleId").change(function(){
	    if(this.value !== ""){$("#designerRegistryStyleLabelId").css("color","black");
	    } else{ $("#designerRegistryStyleLabelId").css("color","red");
	    } });
	    
	    $("#designerRegistryPriceId").change(function(){
	    if(this.value !== ""){ $("#designerRegistryPriceLabelId").css("color","black");
	    } else{ $("#designerRegistryPriceLabelId").css("color","red");
	    } });
	    
	    var designerRegistryRoom1 = "<c:out value="${designerRegistryRoom}"/>";
	    var designerRegistryStyle1 = "<c:out value="${designerRegistryStyle}"/>";
	    var designerRegistryPrice1 = "<c:out value="${designerRegistryPrice}"/>";
	    var conceptBoardsImage1 = "<c:out value="${conceptBoardsImage}"/>";
	    $("[name=designerRegistryRoom]").val(designerRegistryRoom1);
	    $("[name=designerRegistryPrice]").val(designerRegistryPrice1);

	    $.each(designerRegistryStyle1.split(","), function(i,e){
	        $("#designerRegistryStyleId option[value='" + e + "']").prop("selected", true);
	    });
	    
	    if(designerRegistryRoom1 !== "" && designerRegistryStyle1 !== "") {
	    	$("#uploadImageButtIdShow").show();
	    	
	    } else {
	    	$("#uploadImageButtIdShow").hide();
	    }
	    if(conceptBoardsImage1 !== "") {	    	
	    	$("#uploadFrameDisplayId").hide();
	    	$("#uploadImageDisplayId").show();
	    	$("#uploadImageInfoIdShow").show();
	    } else {	    	
	    	$("#uploadFrameDisplayId").show();
	    	$("#uploadImageDisplayId").hide();
	    	$("#uploadImageInfoIdShow").hide();
	    }
	    
	    $('#regUploadImageId').click(function() {			
			var viewImgPath = "data:image/jpg;base64,<c:out value="${conceptBoardsImage}"/>";			
			$("#regUploadImageId").attr("href", viewImgPath);
		});

	    var mostPopularCB1 = "<c:out value="${mostPopularCB}"/>";
	    if(mostPopularCB1 === "Most Popular"){    
	        $("#mostPopularCBId").attr("checked",true);   
	    }
	    	    
 	});
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
        		<div class="col-md-1 col-sm-1"></div>
        		<div class="col-md-10 col-sm-10">
		        	<div class="row">        
				        <div class="col-md-12 col-sm-12">
				        <div class="adm_con_bod_text_hd_dsp">CONCEPT BOARDS</div>
				        </div>
				   	</div>
				        
			        <div class="row" style="margin-top: 50px;">	                
				        <div class="col-md-6 col-sm-6">
				        	<form action="designerConceptBoardsDataSaving" method="post">		        	
				        	<table>		                                	
					        <tr><td class="adn_reg_add_boards_inptext_dsp" id="designerRegistryRoomLabelId">ROOM:&nbsp;&nbsp;</td>
					        <td><select id="designerRegistryRoomId" name="designerRegistryRoom" class="adn_reg_add_boards_inpfield_dsp"> <option value=''> -------------- Select -------------- </option> <option value='Living Room'>Living Room</option> <option value='Dining Room'>Dining Room</option> <option value='Bedroom'>Bedroom</option> <option value='Home Office'>Home Office</option> <option value='Entryway'>Entryway</option> <option value='Nursery'>Nursery</option> <option value='Kids Bedroom'>Kids Bedroom</option> <option value='Outdoor Space'>Outdoor Space</option> </select></td></tr>
					
					        <tr><td class="adn_reg_add_boards_inptext_dsp" id="designerRegistryStyleLabelId" style="position: relative; top: -82px;">STYLE:&nbsp;&nbsp;</td>
					        <td><select id="designerRegistryStyleId" name="designerRegistryStyle" size="7" multiple="multiple" class="adn_reg_add_boards_inpfield_dsp"> <option value=''> -------------- Select -------------- </option> <option value='Modern/Contemporary'>Modern/Contemporary</option> <option value='Classic/Traditional'>Classic/Traditional</option> <option value='Eclectic/Boho'>Eclectic/Boho</option> <option value='Coastal'>Coastal</option> <option value='Glam/Lux'>Glam/Lux</option> <option value='Rustic'>Rustic</option> </select></td></tr>
					        					        					        
					        <tr><td class="adn_reg_add_boards_inptext_dsp" id="designerRegistryPriceLabelId">PRICE:&nbsp;&nbsp;</td>
					        <td><select id="designerRegistryPriceId" name="designerRegistryPrice" class="adn_reg_add_boards_inpfield_dsp"> <option value=''> -------------- Select -------------- </option> <option value='1500 - 5000'>$1,500 - $5,000</option> <option value='5000 - 10000'>$5,000 - $10,000</option> <option value='10000+'>$10,000+</option> </select></td></tr>
					        
					        <tr><td></td>
					        <td><input type="checkbox" name="mostPopularCB" id="mostPopularCBId" value="Most Popular"><font class="adn_reg_add_boards_inptext_dsp">&nbsp;&nbsp;Most popular</font></td></tr>
					        
					        </table>
							
							<table style="margin-top: 40px;"> 
							<tr><td style="width: 120px;"></td>
							<td>
					        <a href="regConceptBoards"><img title="BACK" class="prod_upload_back_butt_adj" src="resources/images/backButton.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;		
					        </td> 
					        
					        <td><h4><button class="adn_reg_add_boards_save_subt_Btn" id="saveBoardButtId">SAVE</button></h4></td></tr>
							</table>
							<input type="hidden" name="designerFullName" value="${designerFullName}">
				        	</form>       	
				        	
				        </div>
				         
				        <div class="col-md-6 col-sm-6">
				        	<div align="center" style="margin-top: -36px;">
				        	
				        	<div class="adn_reg_add_conboard_hdtext_dsp">CONCEPT BOARD</div>
				        	<div id="uploadFrameDisplayId" style="border: 2px dashed #516c81; height: 136px; width: 280px; margin-top: 10px; background: #d9d9d9;"></div>
				        	<img id="uploadImageDisplayId" src="data:image/jpg;base64,<c:out value='${conceptBoardsImage}'/>" style="display: none; margin-top: 10px; width: 280px; height: 136px; object-fit: scale-down; position: relative; object-position: 50% 50%; overflow: auto; overflow-y: hidden; " >
				        	</div>
				        	
				        	
				        	<div align="center" style="margin-top: 15px; display: none;" id="uploadImageButtIdShow"><button class="adn_reg_add_boards_upload_subt_Btn" id="photoupload">UPLOAD</button></div>
				        	
				        	<div style="display: none;" id="uploadImageInfoIdShow">				        	
				        	<div align="center" style="margin-top: 15px;">
				        	<a class="example-image-link adn_reg_add_boards_view_text_dsp" id="regUploadImageId" data-lightbox="example-1">				        	
				        	VIEW
				        	</a>				        	
				        	</div>
				        					        					        	
				        	<div align="center" style="margin-top: 15px;" class="adn_reg_add_boards_furspc_text_dsp">FURNITURE SPECS</div>
				        	
				        	<div align="center" style="margin-top: 15px;" class="adn_reg_add_boards_furspc_no_dsp">${prodTotalCount}</div>
				        	
				        	<div align="center" style="margin-top: 15px;">
				        	<form action="designerRedConFurnitureSpectsUpload">
				        	<button class="adn_reg_add_boards_upload_subt_Btn" id="saveBoardButtId">UPLOAD</button>
				        	</form>
				        	</div>
				        	</div>
				        </div>
				        
				        
			        </div>
			  	</div>
			  	<div class="col-md-1 col-sm-1"></div>
			</div>
        
        </div>
        </div>
        
        
        <div id="boxes">
        <div style="width: 1478px; height: 602px; display: none; opacity: 0.1; z-index: 10001;" id="mask"></div>
        
        <div style="top: 80px; left: 400px; display: none; padding-bottom: 30px; padding-top: 20px; width: 560px; z-index: 10001; overflow-y: hidden;" id="dialog" class="window">
    	<div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" style="cursor: pointer; top: -10px; left: 0px;  position: relative;"></a></div>
    
		<div id="lorem" style="border:2px solid gray; margin-top: 30px; margin-left: 10px; margin-right: 10px; "><br>
		<div style="font:bold 1.2em/1.5em Georgia; margin-left:30px; color: black;">Upload Your Photo</div>
		<form action="designerRedConceptSpcBoardUpload" method="POST" enctype="multipart/form-data">
		<table style="margin-left: 30px; margin-right: 10px; margin-top: 15px; width: 450px; color: #2c2c2c; font: 0.8em/1.15em Georgia; color: black;">
		<tbody><tr><td><input type="file" onchange="readURL(event)" name="regPhotoUpload" id="fileUpload" title="Click here to browse your photo." style="background-color:white;"></td></tr>
		<tr style="height: 7px;"><td></td></tr>
		<tr><td>You can upload a JPG, JPEG, BMP, HEIC, HEIF, GIF, or PNG file.</td></tr>
		<tr style="height: 10px;"><td></td></tr>
		<tr><td>This image can be seen by any guest on our website viewing or searching for your registry.</td></tr>
		<tr style="height: 10px;"><td></td></tr>
		<tr><td><input type="checkbox" name="accept" id="accept"> <div style="margin-left:30px;margin-top:-20px">I own the image I am uploading and confirm that this image compiles with the NOOK + COVE Upload Terms of Use.</div></td></tr>
		<tr style="height: 20px;"><td></td></tr>
		<tr><td><button class="continue_submit_Btn_for_regy" id="photoUploadBut">UPLOAD</button></td></tr>
		<tr style="height: 15px;"><td></td></tr>
		</tbody></table>
		</form>
		</div>
		</div>
		</div>		
		
		<script type="text/javascript" src="resources/js/file_upload.js"></script>
		</body>
</html>
