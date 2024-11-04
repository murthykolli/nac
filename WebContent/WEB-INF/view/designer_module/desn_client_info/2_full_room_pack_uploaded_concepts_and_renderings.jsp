<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">   

	<script type="text/javascript" src="resources/js/designer_multiple_file_uploads.js"></script>
		
		
	<style type="text/css">		
	#mask { position:absolute; left:0; top:0; background-color:#000; display:none;}  
    #imageBox .imageWindow { position:absolute; z-index:9999;}
    #imageBox #imageDialog { height:auto; padding:10px; background-color:#ffffff;}	
	</style>
	
	<script type="text/javascript">	
 	$(document).ready(function(){
 		var likeImagesValue = "<c:out value="${likeImagesValues}"/>";
 		likeImagesValues = likeImagesValue.split("_");
 		
 		if(likeImagesValues[0] === "1"){ $("#add1FavConept3").show(); } 
        else if(likeImagesValues[0] === "2"){ $("#add1FavConept2").show(); $("#add1FavConept3").show(); } 
        else if(likeImagesValues[0] === "3"){ $("#add1FavConept1").show(); $("#add1FavConept2").show(); $("#add1FavConept3").show(); } 
        else{ }
        
        if(likeImagesValues[1] === "1"){ $("#add2FavConept3").show(); } 
        else if(likeImagesValues[1] === "2"){ $("#add2FavConept2").show(); $("#add2FavConept3").show(); } 
        else if(likeImagesValues[1] === "3"){ $("#add2FavConept1").show(); $("#add2FavConept2").show(); $("#add2FavConept3").show(); } 
        else{ }

        if(likeImagesValues[2] === "1"){ $("#add1RendFavConept3").show(); } 
        else if(likeImagesValues[2] === "2"){ $("#add1RendFavConept2").show();$("#add1RendFavConept3").show(); } 
        else if(likeImagesValues[2] === "3"){ $("#add1RendFavConept1").show(); $("#add1RendFavConept2").show(); $("#add1RendFavConept3").show(); } 
        else{ }
        
        if(likeImagesValues[3] === "1"){ $("#add2RendFavConept3").show(); } 
        else if(likeImagesValues[3] === "2"){ $("#add2RendFavConept2").show();$("#add2RendFavConept3").show(); } 
        else if(likeImagesValues[3] === "3"){ $("#add2RendFavConept1").show(); $("#add2RendFavConept2").show(); $("#add2RendFavConept3").show(); } 
        else{ }

        if(likeImagesValues[4] === "1"){ $("#add3RendFavConept3").show(); } 
        else if(likeImagesValues[4] === "2"){ $("#add3RendFavConept2").show();$("#add3RendFavConept3").show(); } 
        else if(likeImagesValues[4] === "3"){ $("#add3RendFavConept1").show(); $("#add3RendFavConept2").show(); $("#add3RendFavConept3").show(); } 
        else{ }
        
        
        var concept1UploadedImg = "<c:out value="${concept1UploadedImage}"/>";
        var concept2UploadedImg = "<c:out value="${concept2UploadedImage}"/>";
        var concept3UploadedImg = "<c:out value="${uploadedRmrend1Image}"/>";
        var concept4UploadedImg = "<c:out value="${uploadedRmrend2Image}"/>";
        var concept5UploadedImg = "<c:out value="${uploadedRevrend1Image}"/>";
        var concept6UploadedImg = "<c:out value="${uploadedRevrend2Image}"/>";
        var concept7UploadedImg = "<c:out value="${uploadedSecRend1Image}"/>";
        var concept8UploadedImg = "<c:out value="${uploadedSecRend2Image}"/>";
        
        if(concept1UploadedImg !== "") {
        	$("#uploadImgDsp1Id").show();
        	$("#uploadDBImgDsp1Id").hide();
        } else {
        	$("#uploadImgDsp1Id").hide();
        	$("#uploadDBImgDsp1Id").show();
        }

        if(concept2UploadedImg !== "") {
        	$("#uploadImgDsp2Id").show();
        	$("#uploadDBImgDsp2Id").hide();
        } else {
        	$("#uploadImgDsp2Id").hide();
        	$("#uploadDBImgDsp2Id").show();
        }

        if(concept3UploadedImg !== "") {
        	$("#uploadImgDsp3Id").show();
        	$("#uploadDBImgDsp3Id").hide();
        } else {
        	$("#uploadImgDsp3Id").hide();
        	$("#uploadDBImgDsp3Id").show();
        }
        

        if(concept4UploadedImg !== "") {
        	$("#uploadImgDsp4Id").show();
        	$("#uploadDBImgDsp4Id").hide();
        } else {
        	$("#uploadImgDsp4Id").hide();
        	$("#uploadDBImgDsp4Id").show();
        }
        

        if(concept5UploadedImg !== "") {
        	$("#uploadImgDsp5Id").show();
        	$("#uploadDBImgDsp5Id").hide();
        } else {
        	$("#uploadImgDsp5Id").hide();
        	$("#uploadDBImgDsp5Id").show();
        }
        

        if(concept6UploadedImg !== "") {
        	$("#uploadImgDsp6Id").show();
        	$("#uploadDBImgDsp6Id").hide();
        } else {
        	$("#uploadImgDsp6Id").hide();
        	$("#uploadDBImgDsp6Id").show();
        }


        if(concept7UploadedImg !== "") {
        	$("#uploadImgDsp7Id").show();
        	$("#uploadDBImgDsp7Id").hide();
        } else {
        	$("#uploadImgDsp7Id").hide();
        	$("#uploadDBImgDsp7Id").show();
        }


        if(concept8UploadedImg !== "") {
        	$("#uploadImgDsp8Id").show();
        	$("#uploadDBImgDsp8Id").hide();
        } else {
        	$("#uploadImgDsp8Id").hide();
        	$("#uploadDBImgDsp8Id").show();
        }
        

        var desnUploadedProd1Count = "<c:out value="${desnUploadedProducts1Count}"/>";
        var desnUploadedProd2Count = "<c:out value="${desnUploadedProducts2Count}"/>";
        var desnUploadedProd3Count = "<c:out value="${desnUploadedProducts3Count}"/>";
        var desnUploadedProd4Count = "<c:out value="${desnUploadedProducts4Count}"/>";
        var desnUploadedProd5Count = "<c:out value="${desnUploadedProducts5Count}"/>";
        
        if(desnUploadedProd1Count !== "") {
        	$("#productDb1CountId").show();
        	$("#product1CountId").hide();
        } else {
        	$("#productDb1CountId").hide();
        	$("#product1CountId").show();
        }

        if(desnUploadedProd2Count !== "") {
        	$("#productDb2CountId").show();
        	$("#product2CountId").hide();
        } else {
        	$("#productDb2CountId").hide();
        	$("#product2CountId").show();
        }

        if(desnUploadedProd3Count !== "") {
        	$("#productDb3CountId").show();
        	$("#product3CountId").hide();
        } else {
        	$("#product3CountId").hide();
        	$("#productDb3CountId").show();
        }

        if(desnUploadedProd4Count !== "") {
        	$("#productDb4CountId").show();
        	$("#product4CountId").hide();
        } else {
        	$("#product4CountId").hide();
        	$("#productDb4CountId").show();
        }

        if(desnUploadedProd5Count !== "") {
        	$("#productDb5CountId").show();
        	$("#product5CountId").hide();
        } else {
        	$("#product5CountId").hide();
        	$("#productDb5CountId").show();
        }
        
        var designConceptsStatus1 = "<c:out value="${designConceptsStatus}"/>";
        var adminConceptsStatus1 = "<c:out value="${adminConceptsStatus}"/>";
        var designRenderingStatus1 = "<c:out value="${designRenderingStatus}"/>";
        var adminRenderingStatus1 = "<c:out value="${adminRenderingStatus}"/>";        
        var designRevRenderingStatus1 = "<c:out value="${designRevRenderingStatus}"/>";
        var adminRevRenderingStatus1 = "<c:out value="${adminRevRenderingStatus}"/>";
        var designSecRenderingStatus1 = "<c:out value="${designSecRenderingStatus}"/>";
        var adminSecRenderingStatus1 = "<c:out value="${adminSecRenderingStatus}"/>";
        
        if(designConceptsStatus1 !== "" && adminConceptsStatus1 !== "") {
        	$("#conBlueTickMarkId").hide();
        	$("#conGreenTickMarkId").show();
        } else if(designConceptsStatus1 !== "" && adminConceptsStatus1 === "") {
        	$("#conBlueTickMarkId").show();
        	$("#conGreenTickMarkId").hide();
        }  else {
        	$("#conBlueTickMarkId").hide();
        	$("#conGreenTickMarkId").hide();
        }

        if(designRenderingStatus1 !== "" && adminRenderingStatus1 !== "") {
        	$("#renBlueTickMarkId").hide();
        	$("#renGreenTickMarkId").show();
        } else if(designRenderingStatus1 !== "" && adminRenderingStatus1 === "") {
        	$("#renBlueTickMarkId").show();
        	$("#renGreenTickMarkId").hide();
        }  else {
        	$("#renBlueTickMarkId").hide();
        	$("#renGreenTickMarkId").hide();
        }

        if(designRevRenderingStatus1 !== "" && adminRevRenderingStatus1 !== "") {
        	$("#revRendBlueTickMarkId").hide();
        	$("#revRendGreenTickMarkId").show();
        } else if(designRevRenderingStatus1 !== "" && adminRevRenderingStatus1 === "") {
        	$("#revRendBlueTickMarkId").show();
        	$("#revRendGreenTickMarkId").hide();
        }  else {
        	$("#revRendBlueTickMarkId").hide();
        	$("#revRendGreenTickMarkId").hide();
        }

        if(designSecRenderingStatus1 !== "" && adminSecRenderingStatus1 !== "") {
        	$("#secRendBlueTickMarkId").hide();
        	$("#secRendGreenTickMarkId").show();
        } else if(designSecRenderingStatus1 !== "" && adminSecRenderingStatus1 === "") {
        	$("#secRendBlueTickMarkId").show();
        	$("#secRendGreenTickMarkId").hide();
        }  else {
        	$("#secRendBlueTickMarkId").hide();
        	$("#secRendGreenTickMarkId").hide();
        }
        
        var secRenPaymentStatus1 = "<c:out value="${secRenPaymentStatus}"/>";
        if(secRenPaymentStatus1 !== "") {
        	$("#secRenderingStatusId").show();
        } else {
        	$("#secRenderingStatusId").hide();
        }
        
    });
	</script>
	 
	<script type="text/javascript">
 	$(document).ready(function(){
 		
        	$(".conceptsRenderingPopupDspCl").click(function(){
             
            var idOfHiddenInput = $(this).parent().find('input:hidden:first').attr('id');
            
            var imgRedValue;
            if(idOfHiddenInput === "image1Id") {
            	var image1Path = "<c:out value='${concept1UploadedImage}'/>";            
                imgRedValue = "data:image/jpg;base64," + image1Path;
            } else if(idOfHiddenInput === "image2Id") {
            	var image2Path = "<c:out value='${concept2UploadedImage}'/>";            
                imgRedValue = "data:image/jpg;base64," + image2Path;
            } else if(idOfHiddenInput === "image3Id") {
            	var image2Path = "<c:out value='${uploadedRmrend1Image}'/>";            
                imgRedValue = "data:image/jpg;base64," + image2Path;
            } else if(idOfHiddenInput === "image4Id") {
            	var image2Path = "<c:out value='${uploadedRmrend2Image}'/>";            
                imgRedValue = "data:image/jpg;base64," + image2Path;
            } else if(idOfHiddenInput === "image5Id") {
            	var image2Path = "<c:out value='${uploadedRevrend1Image}'/>";            
                imgRedValue = "data:image/jpg;base64," + image2Path;
            } else if(idOfHiddenInput === "image6Id") {
            	var image2Path = "<c:out value='${uploadedRevrend2Image}'/>";            
                imgRedValue = "data:image/jpg;base64," + image2Path;
            } else if(idOfHiddenInput === "image7Id") {
            	var image2Path = "<c:out value='${uploadedSecRend1Image}'/>";            
                imgRedValue = "data:image/jpg;base64," + image2Path;
            } else if(idOfHiddenInput === "image8Id") {
            	var image2Path = "<c:out value='${uploadedSecRend2Image}'/>";            
                imgRedValue = "data:image/jpg;base64," + image2Path;
            }
            
            $.conceptsRenderingPopup(imgRedValue);
        	});
        	
    });
    </script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        	
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			<p class="package_info_disp_for_Dsn"><c:out value='${clientFullName}'/> - <c:out value='${typeOfSpaceVal}'/> - <font>FULL ROOM PACKAGE</font> - <c:out value='${createdDate}'/></p>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
        </div> <!-- /.row -->
        
        
                
        <div class="row top_adjustment_20">
        
        <div class="col-md-4 col-sm-4">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left" class="desn_full_upload_cons_only_frame">
	        			
	        			<div class="row">
	        				<div align="center" class="col-md-6 col-sm-6">
					        	<div class="service-item">                        
					            	<div class="service-description">
					            		<div align="center" class="full_frame_con1_dsp">
					            			<div style="height: 10px; margin-top: 10px;" class="dsn_ful_uplod_pos_adj1"><table><tr><td><img id="add1FavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"></td> <td><img id="add1FavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td> <td><img id="add1FavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td></tr></table></div>
					            			<div class="full_desn_concept_head_text dsn_ful_uplod_pos_adj1">CONCEPT #1</div>
					            			<div id="uploadDBImgDsp1Id" class="full_upload_img_desn_disp_frame dsn_ful_uplod_pos_adj1"></div>
					            			<div id="uploadImgDsp1Id" style="display: none" class="full_upload_db_img_desn_disp_frame dsn_ful_uplod_pos_adj1"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${concept1UploadedImage}'/>" width="130" height="100"></div>
					            			<div class="top_adjustment_15 dsn_ful_uplod_pos_adj1"><h4><button class="full_rm_image_upload_files_submit_Btn" id="uploadButn1">UPLOAD</button></h4></div>
					            			<div class="top_adjustment_15 dsn_ful_uplod_pos_adj1"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image1Id" type='hidden'/></div>
					            			<div class="top_adjustment_20 dsn_ful_uplod_pos_adj1 dsn_furn_spec_txt_dsp">FURNITURE SPECS</div>
					            			<div id="product1CountId" class="dsn_ful_uplod_pos_adj1 dsn_furn_spec_num_dsp">0</div>
					            			<div id="productDb1CountId" style="display: none" class="dsn_ful_uplod_pos_adj1 dsn_furn_spec_num_dsp"><c:out value='${desnUploadedProducts1Count}'/></div>
					            			<form action="furnitureSpecsFullRmConcepts1ProdUp">
					            			<div class="top_adjustment_5 dsn_ful_uplod_pos_adj1"><h4><button class="upload_files_submit_Btn">UPLOAD</button></h4></div>
					            			</form>
					            		</div>
					            	</div> <!-- /.service-description -->
						        </div> <!-- /.service-item -->               
						    </div> <!-- /.col-md-6 -->
						    						    
						    <div align="center" class="col-md-6 col-sm-6">
					        	<div class="service-item">                        
					            	<div class="service-description">
					            		<div align="center" class="full_frame_con2_dsp">
					            			<div style="height: 10px; margin-top: 10px;" class="dsn_ful_uplod_pos_adj2"><table><tr><td><img id="add2FavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"></td> <td><img id="add2FavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td> <td><img id="add2FavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td></tr></table></div>
					            			<div class="full_desn_concept_head_text dsn_ful_uplod_pos_adj2">CONCEPT #2</div>
					            			<div id="uploadDBImgDsp2Id" class="full_upload_img_desn_disp_frame dsn_ful_uplod_pos_adj2"></div>
					            			<div id="uploadImgDsp2Id" style="display: none" class="full_upload_db_img_desn_disp_frame dsn_ful_uplod_pos_adj2"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${concept2UploadedImage}'/>" width="130" height="100"></div>
					            			<div class="top_adjustment_15 dsn_ful_uplod_pos_adj2"><h4><button class="full_rm_image_upload_files_submit_Btn" id="uploadButn2">UPLOAD</button></h4></div>
					            			<div class="top_adjustment_15 dsn_ful_uplod_pos_adj2"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image2Id" type='hidden'/></div>
					            			<div class="top_adjustment_20 dsn_ful_uplod_pos_adj2 dsn_furn_spec_txt_dsp">FURNITURE SPECS</div>
					            			<div id="product2CountId" class="dsn_ful_uplod_pos_adj2 dsn_furn_spec_num_dsp">0</div>
					            			<div id="productDb2CountId" style="display: none" class="dsn_ful_uplod_pos_adj2 dsn_furn_spec_num_dsp"><c:out value='${desnUploadedProducts2Count}'/></div>
					            			<form action="furnitureSpecsFullRmConcepts2ProdUp">
					            			<div class="top_adjustment_5 dsn_ful_uplod_pos_adj2"><h4><button class="upload_files_submit_Btn">UPLOAD</button></h4></div>
					            			</form>
					            		</div>
					            	</div> <!-- /.service-description -->
						        </div> <!-- /.service-item -->               
						    </div> <!-- /.col-md-6 -->
						    
						    <div class="desn_divider_bar_dsp full_divd_frame_bar_dsp"></div>
	        			</div> <!-- /.row -->
	        			
	        			
	        			<!-- Submit to Admin Button DIV -->
	        			<div class="row">
	        				<div align="center" class="col-md-12 col-sm-12">
					        	<div class="service-item">                        
					            	<div class="service-description">
					            	
					            		<div align="center" class="top_adjustment_40">
					            		<form action="designerSubmitFullRoomConceptsToAdmin">
					            			<h4><button class="upload_files_submit_Btn" onclick="return fullRoomConceptsSubmitToAdmin();">SUBMIT TO ADMIN</button></h4>
					            			<font id="conBlueTickMarkId" style="position: absolute; margin-top: -20px; margin-left: 107px; display: none;"><img src="resources/images/desn_blue_img_tick_mark.png"></font> <font id="conGreenTickMarkId" style="position: absolute; margin-top: -20px; margin-left: 107px; display: none;"><img src="resources/images/desn_green_img_tick_mark.png"></font>
					            		</form>
					            		</div>
					            	
					            	</div> <!-- /.service-description -->
						        </div> <!-- /.service-item -->               
						    </div> <!-- /.col-md-12 -->
						</div> <!-- /.row -->
	        			        			
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
        	
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left" class="desn_full_upload_rends_only_frame">
	        			
	        			<div class="row">
	        				<div align="center" class="col-md-6 col-sm-6">
					        	<div class="service-item">                        
					            	<div class="service-description">
					            		<div align="center">
					            			<div style="height: 10px; margin-top: 10px;" class="dsn_uplod_pos_adj1"><table><tr><td><img id="add1RendFavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"></td> <td><img id="add1RendFavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td> <td><img id="add1RendFavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td></tr></table></div>
					            			<div class="desn_concept_head_text dsn_uplod_pos_adj1">ROOM RENDERING</div>
					            			
					            			<div class="row">
		        								<div align="right" class="col-md-6 col-sm-6">
							            			<div id="uploadDBImgDsp3Id" class="upload_full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj1"></div>
							            			<div id="uploadImgDsp3Id" style="display: none" class="upload_db__full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj1"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${uploadedRmrend1Image}'/>" width="100" height="100"></div>
							            			
							            			<div class="top_adjustment_15 dsn_full_uplod_pos_adj1"><h4><button class="full_rm_image_upload_files_submit_Btn" id="uploadButn3">UPLOAD</button></h4></div>
							            			<div class="top_adjustment_15 dsn_full_uplod_view_pos_adj1"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image3Id" type='hidden'/></div>
							            		</div> <!-- /.col-md-6 -->
							            	
		        								<div align="left" class="col-md-6 col-sm-6">
							            			<div id="uploadDBImgDsp4Id" class="upload_full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj2"></div>
							            			<div id="uploadImgDsp4Id" style="display: none" class="upload_db__full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj2"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${uploadedRmrend2Image}'/>" width="100" height="100"></div>
							            			
							            			<div class="top_adjustment_15 dsn_full_uplod_pos_adj2"><h4><button class="full_rm_image_upload_files_submit_Btn" id="uploadButn4">UPLOAD</button></h4></div>
							            			<div class="top_adjustment_15 dsn_full_uplod_view_pos_adj2"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image4Id" type='hidden'/></div>
							            		</div> <!-- /.col-md-6 -->
							            	</div> <!-- /.row -->		
					            			
					            			<div class="top_adjustment_20 dsn_uplod_pos_adj1 dsn_furn_spec_txt_dsp">FURNITURE SPECS</div>
					            			<div id="product3CountId" class="dsn_uplod_pos_adj1 dsn_furn_spec_num_dsp">0</div>
					            			<div id="productDb3CountId" style="display: none" class="dsn_uplod_pos_adj1 dsn_furn_spec_num_dsp"><c:out value='${desnUploadedProducts3Count}'/></div>
					            			<form action="furnitureSpecsFullRmRoomRenderingProdUp">
					            			<div class="top_adjustment_5 dsn_uplod_pos_adj1"><h4><button class="upload_files_submit_Btn">UPLOAD</button></h4></div>
					            			</form>
					            			
					            			
					            			<!-- Submit to Admin Button DIV -->
					            			<div class="top_adjustment_40">
					            			<form action="designerSubmitFullRoomRenderingsToAdmin">
					            			<div class="dsn_uplod_pos_adj1"><h4><button class="upload_files_submit_Btn" onclick="return fullRoomRenderingsSubmitToAdmin();">SUBMIT TO ADMIN</button></h4></div>
					            			<font id="renBlueTickMarkId" style="position: absolute; margin-top: -20px; margin-left: 115px; display: none;"><img src="resources/images/desn_blue_img_tick_mark.png"></font> <font id="renGreenTickMarkId" style="position: absolute; margin-top: -20px; margin-left: 115px; display: none;"><img src="resources/images/desn_green_img_tick_mark.png"></font>
					            			</form>
					            			</div>
					            		</div>
					            	</div> <!-- /.service-description -->
						        </div> <!-- /.service-item -->               
						    </div> <!-- /.col-md-6 -->
						    						    
						    <div align="center" class="col-md-6 col-sm-6">
					        	<div class="service-item">                        
					            	<div class="service-description">
					            		<div align="center">
					            			<div style="height: 10px; margin-top: 10px;" class="dsn_uplod_pos_adj2"><table><tr><td><img id="add2RendFavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"></td> <td><img id="add2RendFavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td> <td><img id="add2RendFavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td></tr></table></div>
					            			<div class="desn_concept_head_text dsn_uplod_pos_adj2">REVISED RENDERING</div>
					            			
					            			<div class="row">
		        								<div align="right" class="col-md-6 col-sm-6" style="margin-left: -13px;">
							            			<div id="uploadDBImgDsp5Id" class="upload_full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj1"></div>
							            			<div id="uploadImgDsp5Id" style="display: none" class="upload_db__full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj1"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${uploadedRevrend1Image}'/>" width="100" height="100"></div>
							            			
							            			<div class="top_adjustment_15 dsn_full_uplod_pos_adj1"><h4><button class="full_rm_image_upload_files_submit_Btn" id="uploadButn5">UPLOAD</button></h4></div>
							            			<div class="top_adjustment_15 dsn_full_uplod_view_pos_adj1"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image5Id" type='hidden'/></div>
							            		</div> <!-- /.col-md-6 -->
							            	
		        								<div align="left" class="col-md-6 col-sm-6">
							            			<div id="uploadDBImgDsp6Id" class="upload_full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj2"></div>
							            			<div id="uploadImgDsp6Id" style="display: none" class="upload_db__full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj2"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${uploadedRevrend2Image}'/>" width="100" height="100"></div>
							            			
							            			<div class="top_adjustment_15 dsn_full_uplod_pos_adj2"><h4><button class="full_rm_image_upload_files_submit_Btn" id="uploadButn6">UPLOAD</button></h4></div>
							            			<div class="top_adjustment_15 dsn_full_uplod_view_pos_adj2"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image6Id" type='hidden'/></div>
							            		</div> <!-- /.col-md-6 -->
							            	</div> <!-- /.row -->		
					            			
					            			<div class="top_adjustment_20 dsn_uplod_pos_adj2 dsn_furn_spec_txt_dsp">FURNITURE SPECS</div>
					            			<div id="product4CountId" class="dsn_uplod_pos_adj2 dsn_furn_spec_num_dsp">0</div>
					            			<div id="productDb4CountId" style="display: none" class="dsn_uplod_pos_adj2 dsn_furn_spec_num_dsp"><c:out value='${desnUploadedProducts4Count}'/></div>
					            			<form action="furnitureSpecsFullRmRevisedRenderingProdUp">
					            			<div class="top_adjustment_5 dsn_uplod_pos_adj2"><h4><button class="upload_files_submit_Btn">UPLOAD</button></h4></div>
					            			</form>
					            			
					            			
					            			<!-- Submit to Admin Button DIV -->
					            			<div class="top_adjustment_40">
					            			<form action="designerSubmitFullRoomRevisedRenderingsToAdmin">
					            			<div class="dsn_uplod_pos_adj2"><h4><button class="upload_files_submit_Btn" onclick="return fullRoomRevRenderingsSubmitToAdmin();">SUBMIT TO ADMIN</button></h4></div>
					            			<font id="revRendBlueTickMarkId" style="position: absolute; margin-top: -20px; margin-left: 100px; display: none;"><img src="resources/images/desn_blue_img_tick_mark.png"></font> <font id="revRendGreenTickMarkId" style="position: absolute; margin-top: -20px; margin-left: 100px; display: none;"><img src="resources/images/desn_green_img_tick_mark.png"></font>
					            			</form>
					            			</div>
					            			
					            		</div>
					            	</div> <!-- /.service-description -->
						        </div> <!-- /.service-item -->               
						    </div> <!-- /.col-md-6 -->
						    
						    <div class="desn_divider_bar_dsp"></div>
	        			</div> <!-- /.row -->
	        			        			
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        <div class="col-md-2 col-sm-2">
        <div class="service-item" style="display: none;" id="secRenderingStatusId">                        
	        <div class="service-description"> 
	        	<div class="desn_full_upload_sec_rend_only_frame" align="center">
	        		<div style="margin-left: -7px;">
	        		<div style="height: 10px; margin-top: 10px;" class="sec_rn_dsn_uplod_pos_adj2"><table><tr><td><img id="add3RendFavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"></td> <td><img id="add3RendFavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td> <td><img id="add3RendFavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td></tr></table></div>
	        		<div class="desn_concept_head_text sec_rn_dsn_uplod_pos_adj2">2ND ROOM RENDERING</div>
	        		
	        		<div class="row" style="margin-left: 4px;">
			        								<div align="right" class="col-md-6 col-sm-6" style="margin-left: -13px;">
			        		<div id="uploadDBImgDsp7Id" class="upload_full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj1"></div>
			        		<div id="uploadImgDsp7Id" style="display: none" class="upload_db__full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj1"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${uploadedSecRend1Image}'/>" width="100" height="100"></div>
			        		
			        		<div class="top_adjustment_15 dsn_full_uplod_pos_adj1"><h4><button class="full_rm_image_upload_files_submit_Btn" id="uploadButn7">UPLOAD</button></h4></div>
			        		<div class="top_adjustment_15 dsn_full_uplod_view_pos_adj1" style="margin-right: 10px;"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image7Id" type='hidden'/></div>
			        	</div> <!-- /.col-md-6 -->
			        
			        								<div align="left" class="col-md-6 col-sm-6">
			        		<div id="uploadDBImgDsp8Id" class="upload_full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj2"></div>
			        		<div id="uploadImgDsp8Id" style="display: none" class="upload_db__full_rend_img_desn_disp_frame dsn_sm_full_uplod_pos_adj2"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${uploadedSecRend2Image}'/>" width="100" height="100"></div>
			        		
			        		<div class="top_adjustment_15 dsn_full_uplod_pos_adj2"><h4><button class="full_rm_image_upload_files_submit_Btn" id="uploadButn8">UPLOAD</button></h4></div>
			        		<div class="top_adjustment_15 dsn_full_uplod_view_pos_adj2"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image8Id" type='hidden'/></div>
			        	</div> <!-- /.col-md-6 -->
			        </div> <!-- /.row -->		
	        		
	        		<div class="top_adjustment_20 sec_rn_dsn_uplod_pos_adj2 dsn_furn_spec_txt_dsp">FURNITURE SPECS</div>
	        		<div id="product5CountId" class="sec_rn_dsn_uplod_pos_adj2 dsn_furn_spec_num_dsp">0</div>
	        		<div id="productDb5CountId" style="display: none" class="sec_rn_dsn_uplod_pos_adj2 dsn_furn_spec_num_dsp"><c:out value='${desnUploadedProducts5Count}'/></div>
	        		<form action="furnitureSpecsFullRm2ndRenderingProdUp">
	        		<div class="top_adjustment_5 sec_rn_dsn_uplod_pos_adj2"><h4><button class="upload_files_submit_Btn">UPLOAD</button></h4></div>
	        		</form>
	        		
	        		<!-- Submit to Admin Button DIV -->
					<div class="top_adjustment_40">
					<form action="designerSubmitFullRoom2ndRenderingsToAdmin">
					<div class="sec_rn_dsn_uplod_pos_adj2"><h4><button class="upload_files_submit_Btn" onclick="return fullRoom2ndRenderingsSubmitToAdmin();">SUBMIT TO ADMIN</button></h4></div>
					<font id="secRendBlueTickMarkId" style="position: absolute; margin-top: -20px; margin-left: 110px; display: none;"><img src="resources/images/desn_blue_img_tick_mark.png"></font> <font id="secRendGreenTickMarkId" style="position: absolute; margin-top: -20px; margin-left: 110px; display: none;"><img src="resources/images/desn_green_img_tick_mark.png"></font>
					</form>
					</div>
					            			
	        	</div>
	        	</div>
	        </div> <!-- /.service-description -->
		</div> <!-- /.service-item -->
        </div>
                         	
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_25">		 
        
        <div class="col-md-4 col-sm-4">
        <div class="row">
        <div class="col-md-1 col-sm-1">        
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">   
	                	<form action="fullStyleManagement" method="get">
						<h4><input class="dash_board_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
						</form>                             
                    </div>                    
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div> <!-- /.col-md-1 -->               
               
        <div class="col-md-11 col-sm-11">
        	<div class="service-item">                        
            	<div class="service-description">                	
                    <div align="left" class="des_concept_butt_adj">   
	                	<!-- <form action="designerSubmitRendAndRevRendToAdmin" name="myDesign" method="get">
						<h4><button class="desn_con_submit_Btn" id="styleButtonId" onclick="return submitToAdmin();">SUBMIT TO ADMIN</button></h4>
						</form> -->                             
                    </div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-11 -->
        </div> <!-- /.row -->
        </div> <!-- /.col-md-4 -->
               
        
        <div class="col-md-8 col-sm-8">
        </div> <!-- /.col-md-8 -->
                		
		</div> <!-- /.row -->
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        <div id="imageBox">
        <div style="top: 195px; left: 535px; display: none;" id="imageDialog" class="imageWindow">
        <div style="text-align: right;"> <img class="close" src="resources/images/close.png" style="cursor: pointer; opacity: 1;"></div>
        
        <form action="fullRoomUploadConcept1Images" method="POST" enctype="multipart/form-data" id="concept1Form" class="uploadForms">
        <table style="width: 320px;">
        <tr><td class="sel_upload_img_txt_ds">Select a image to upload</td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input type="file" title="Click here to browse your image." id="concept1Upload" name="concept1Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="fullRoombuttonUploadClass dsgn_upload_img_adj_butt" type="submit" id="buttonUpload1" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="fullRoomUploadConcept2Images" method="POST" enctype="multipart/form-data" id="concept2Form" class="uploadForms">
        <table>
        <tr><td class="sel_upload_img_txt_ds">Select a image to upload</td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input type="file" title="Click here to browse your image." id="concept2Upload" name="concept2Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="fullRoombuttonUploadClass dsgn_upload_img_adj_butt" type="submit" id="buttonUpload2" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="fullRoomUploadRendering1Images" method="POST" enctype="multipart/form-data" id="rendering1Form" class="uploadForms">
        <table>
        <tr><td class="sel_upload_img_txt_ds">Select a image to upload</td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input type="file" title="Click here to browse your image." id="rendeing1Upload" name="rendeing1Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="fullRoombuttonUploadClass dsgn_upload_img_adj_butt" type="submit" id="buttonUpload3" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="fullRoomUploadRendering2Images" method="POST" enctype="multipart/form-data" id="rendering2Form" class="uploadForms">
        <table>
        <tr><td class="sel_upload_img_txt_ds">Select a image to upload</td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input type="file" title="Click here to browse your image." id="rendeing2Upload" name="rendeing2Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="fullRoombuttonUploadClass dsgn_upload_img_adj_butt" type="submit" id="buttonUpload4" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="fullRoomUploadRevRendering1Images" method="POST" enctype="multipart/form-data" id="revRendering1Form" class="uploadForms">
        <table>
        <tr><td class="sel_upload_img_txt_ds">Select a image to upload</td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input type="file" title="Click here to browse your image." id="revRendeing1Upload" name="revRendeing1Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="fullRoombuttonUploadClass dsgn_upload_img_adj_butt" type="submit" id="buttonUpload5" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="fullRoomUploadRevRendering2Images" method="POST" enctype="multipart/form-data" id="revRendering2Form" class="uploadForms">
        <table>
        <tr><td class="sel_upload_img_txt_ds">Select a image to upload</td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input type="file" title="Click here to browse your image." id="revRendeing2Upload" name="revRendeing2Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="fullRoombuttonUploadClass dsgn_upload_img_adj_butt" type="submit" id="buttonUpload6" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="fullRoomUploadSecRendConcept1Images" method="POST" enctype="multipart/form-data" id="secRendering1Form" class="uploadForms">
        <table>
        <tr><td class="sel_upload_img_txt_ds">Select a image to upload</td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input type="file" title="Click here to browse your image." id="secRendeing1Upload" name="secRendeing1Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="fullRoombuttonUploadClass dsgn_upload_img_adj_butt" type="submit" id="buttonUpload7" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="fullRoomUploadSecRendConcept2Images" method="POST" enctype="multipart/form-data" id="secRendering2Form" class="uploadForms">
        <table>
        <tr><td class="sel_upload_img_txt_ds">Select a image to upload</td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input type="file" title="Click here to browse your image." id="secRendeing2Upload" name="secRendeing2Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="fullRoombuttonUploadClass dsgn_upload_img_adj_butt" type="submit" id="buttonUpload8" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
                
        <table class="uploadForms" id="modelWindowFrameId">
        <tr><td class="sel_upload_img_txt_ds"><img src="resources/images/designer/desn_pupup_notice.png "/></td></tr>
        <tr><td class="sel_upload_img_txt_ds"><input class="upload_files_submit_Btn" type="submit" onclick="return uploadSuccess('Yes');" value="OK"></td></tr>        
        </table>
                
        </div>
        <div style="width: 1478px; font-size: 32pt; color:white; height: 602px; display: none; opacity: 0.8;" id="mask"></div>
		</div>
        
        <script type="text/javascript" src="resources/js/popup/01_all_popup_window_display.js" ></script>
		 
		 
		<div align="center" id="popupTotalWindowBoxId">
        <div align="center" style="display: none; left:0px; top:0px;" id="imageBackgroundDspId" class="window">
        
        <div align="center" class="popup_backgrond_img_display_cl">
        <div align="center"><img class="close popup_close_butt_dsp" src="resources/images/popup_close.png" title="Close"></div>
        <div align="center"><img class="popup_only_image_display_cl" id="bigConceptsRendPopupImgId" src="" ></div>
        </div>
        </div>
        <div align="center" class="popup_big_backgrond_display_cl" id="popUpBigMaskWindowId" style="display: none;"></div>
        </div>
        
		
		<script type="text/javascript">		
		
		function fullRoomConceptsSubmitToAdmin(){
			
			var concept1UploadedImgVal = "<c:out value="${concept1UploadedImage}"/>";
	        var concept2UploadedImgVal = "<c:out value="${concept2UploadedImage}"/>";
	        
			var desnUploadedProd1CountVal = "<c:out value="${desnUploadedProducts1Count}"/>";
	        var desnUploadedProd2CountVal = "<c:out value="${desnUploadedProducts2Count}"/>";
	        
	        if(concept1UploadedImgVal !== "" && concept2UploadedImgVal !== "" && desnUploadedProd1CountVal > 0 && desnUploadedProd2CountVal > 0){
				alert("Submitted concepts and furniture specs to Admin");
					return true;
			} else {
					alert("Please upload concepts and furniture specs");
					return false;
			} 				
        } 
		

		function fullRoomRenderingsSubmitToAdmin(){
			
			var concept3UploadedImgVal = "<c:out value="${uploadedRmrend1Image}"/>";	        
			var desnUploadedProd3CountVal = "<c:out value="${desnUploadedProducts3Count}"/>";
	        
	        if(concept3UploadedImgVal !== "" && desnUploadedProd3CountVal > 0){
				alert("Submitted room renderings and furniture specs to Admin");
					return true; 
			} else {
				alert("Please upload room renderings and furniture specs");
				return false;
			}	        	
        } 
		

		function fullRoomRevRenderingsSubmitToAdmin(){
			
			var concept5UploadedImgVal = "<c:out value="${uploadedRevrend1Image}"/>";
	        var desnUploadedProd4CountVal = "<c:out value="${desnUploadedProducts4Count}"/>";
	        
			if(concept5UploadedImgVal !== "" && desnUploadedProd4CountVal > 0){
				alert("Submitted revised renderings and furniture specs to Admin");
				return true; 
			} else {
				alert("Please upload revised renderings and furniture specs");
				return false;
			}	        	
        } 
		

		function fullRoom2ndRenderingsSubmitToAdmin(){
			
			var concept7UploadedImgVal = "<c:out value="${uploadedSecRend1Image}"/>";
	        var desnUploadedProd5CountVal = "<c:out value="${desnUploadedProducts5Count}"/>";
	        
			if(concept7UploadedImgVal !== "" && desnUploadedProd5CountVal > 0){
				alert("Submitted second renderings and furniture specs to Admin");
				return true; 
			} else {
				alert("Please upload second renderings and furniture specs");
				return false;
			}	        
        } 
        </script>
		
		<!-- <script type="text/javascript">		
		function submitToAdmin(){
			
			var concept1UploadedImgVal = "<c:out value="${concept1UploadedImage}"/>";
	        var concept2UploadedImgVal = "<c:out value="${concept2UploadedImage}"/>";
	        var concept3UploadedImgVal = "<c:out value="${uploadedRmrend1Image}"/>";
	        var concept4UploadedImgVal = "<c:out value="${uploadedRmrend2Image}"/>";
	        var concept5UploadedImgVal = "<c:out value="${uploadedRevrend1Image}"/>";
	        var concept6UploadedImgVal = "<c:out value="${uploadedRevrend2Image}"/>";
	        var concept7UploadedImgVal = "<c:out value="${uploadedSecRend1Image}"/>";
	        var concept8UploadedImgVal = "<c:out value="${uploadedSecRend2Image}"/>";
		
			var desnUploadedProd1CountVal = "<c:out value="${desnUploadedProducts1Count}"/>";
	        var desnUploadedProd2CountVal = "<c:out value="${desnUploadedProducts2Count}"/>";
	        var desnUploadedProd3CountVal = "<c:out value="${desnUploadedProducts3Count}"/>";
	        var desnUploadedProd4CountVal = "<c:out value="${desnUploadedProducts4Count}"/>";
	        var desnUploadedProd5CountVal = "<c:out value="${desnUploadedProducts5Count}"/>";
	        
	        var designConceptStatus = "<c:out value="${designConceptsStatus}"/>";
	        var designRenderingsStatus = "<c:out value="${designRenderingStatus}"/>";
	        var designRevRenderingsStatus = "<c:out value="${designRevRenderingStatus}"/>";
	        var designSecRenderingsStatus = "<c:out value="${designSecRenderingStatus}"/>";
	        
	        if(designConceptStatus == "" && designRenderingsStatus == "" && designRevRenderingsStatus == "" && designSecRenderingsStatus == "") {
				if(concept1UploadedImgVal !== "" && concept2UploadedImgVal !== "" && desnUploadedProd1CountVal > 0 && desnUploadedProd2CountVal > 0){
					alert("Submitted concepts and furniture specs to Admin");
					//modelwindowDisplay();
					return true;
				} else {
					alert("Please upload concepts and furniture specs");
					return false;
				 }
	        } else if(designConceptStatus !== "" && designRenderingsStatus == "" && designRevRenderingsStatus == "" && designSecRenderingsStatus == "") {		 
				 if(concept3UploadedImgVal !== "" && desnUploadedProd3CountVal > 0){
					 alert("Submitted room renderings and furniture specs to Admin");
					 //modelwindowDisplay();
					return true; 
				 } else {
					alert("Please upload room renderings and furniture specs");
					return false;
				 }
	        } else if(designConceptStatus !== "" && designRenderingsStatus !== "" && designRevRenderingsStatus == "" && designSecRenderingsStatus == "") {		 
				 if(concept5UploadedImgVal !== "" && desnUploadedProd4CountVal > 0){
					 alert("Submitted revised renderings and furniture specs to Admin");
					 //modelwindowDisplay();
					return true; 
				 } else {
					alert("Please upload revised renderings and furniture specs");
					return false;
				 }
	        } else if(designConceptStatus !== "" && designRenderingsStatus !== "" && designRevRenderingsStatus !== "" && designSecRenderingsStatus == "") {		 
				 if(concept7UploadedImgVal !== "" && desnUploadedProd5CountVal > 0){
					alert("Submitted second renderings and furniture specs to Admin");
					//modelwindowDisplay();
					return true; 
				 } else {
					alert("Please upload second renderings and furniture specs");
					modelwindowDisplay();
					return false;
				 }
	        } else {
	        	return false;
			 }	 
				
        }        
        </script> -->
		
		</body>
</html>