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

        if(likeImagesValues[2] === "1"){ $("#addFinalFavConept3").show(); } 
        else if(likeImagesValues[2] === "2"){ $("#addFinalFavConept2").show();$("#addFinalFavConept3").show(); } 
        else if(likeImagesValues[2] === "3"){ $("#addFinalFavConept1").show(); $("#addFinalFavConept2").show(); $("#addFinalFavConept3").show(); } 
        else{ }
        
        var concept1UploadedImg = "<c:out value="${concept1UploadedImage}"/>";
        var concept2UploadedImg = "<c:out value="${concept2UploadedImage}"/>";
        var concept3UploadedImg = "<c:out value="${concept3UploadedImage}"/>";
        
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
        

        var desnUploadedProd1Count = "<c:out value="${desnUploadedProducts1Count}"/>";
        var desnUploadedProd2Count = "<c:out value="${desnUploadedProducts2Count}"/>";
        var desnUploadedProd3Count = "<c:out value="${desnUploadedProducts3Count}"/>";
        
        var adminAppConceptStatus1 = "<c:out value="${adminAppConceptStatus}"/>";
        var adminAppRenderingsStatus1 = "<c:out value="${adminAppRenderingsStatus}"/>";

        if(adminAppConceptStatus1 !== "") {
        	$("#concept1ApprTickMarkId").show();
        	$("#concept2ApprTickMarkId").show();
        } else {
        	$("#concept1ApprTickMarkId").hide();
        	$("#concept2ApprTickMarkId").hide();
        }
        
        if(adminAppRenderingsStatus1 !== "") {
        	$("#roomRendApprTickMarkId").show();
        } else {
        	$("#roomRendApprTickMarkId").hide();
        }
        
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
        
        var desnSubmitConceptStatus1 = "<c:out value="${desnSubmitConceptStatus}"/>";
        var desnSubmitRenderingsStatus1 = "<c:out value="${desnSubmitRenderingsStatus}"/>";
                
		if(desnSubmitConceptStatus1 !== ""){			
		} else{ 
	       	$("#uploadButnCon1Id").attr("disabled","disabled");
		   	$("#uploadButnCon1Id").css("opacity","0.3");
		   	$("#uploadButnCon1Id").css("cursor","not-allowed");
	    } 
	       
		if(desnSubmitConceptStatus1 !== ""){			
		} else{ 
	       	$("#uploadButnCon2Id").attr("disabled","disabled");
		   	$("#uploadButnCon2Id").css("opacity","0.3");
		   	$("#uploadButnCon2Id").css("cursor","not-allowed");	       	  
	    }
		   
		if(desnSubmitConceptStatus1 !== ""){			
		} else{ 
	       	$("#uploadButnFinalConId").attr("disabled","disabled");
		   	$("#uploadButnFinalConId").css("opacity","0.3");
		   	$("#uploadButnFinalConId").css("cursor","not-allowed");	       	  
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
            	var image2Path = "<c:out value='${concept3UploadedImage}'/>";            
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
        	
        <div class="col-md-9 col-sm-9">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			<p class="package_info_disp_for_Dsn"><c:out value='${clientFullName}'/> - <c:out value='${typeOfSpaceVal}'/> - <font>ACCESSORIES PACKAGE</font> - <c:out value='${createdDate}'/></p>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-9 -->
        	
        <div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="right">
        			<p class="dsn_rs_pack_info_tx_disp_for_Dsn"><c:out value='${designerFullName}'/></p>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
        </div> <!-- /.row -->
        
        
                
        <div class="row top_adjustment_20">
        
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left" class="desn_acc_upload_con_rend_frame1">
	        			
	        			<div class="row">
	        				<div align="center" class="col-md-6 col-sm-6">
					        	<div class="service-item">                        
					            	<div class="service-description">
					            		<div align="center">
					            			<div style="height: 10px; margin-top: 10px;" class="dsn_uplod_pos_adj1"><table><tr><td><img id="add1FavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"></td> <td><img id="add1FavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td> <td><img id="add1FavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td></tr></table></div>
					            			<div class="desn_concept_head_text dsn_uplod_pos_adj1">CONCEPT #1</div>
					            			<div id="uploadDBImgDsp1Id" class="upload_img_desn_disp_frame dsn_uplod_pos_adj1"></div>
					            			<div id="uploadImgDsp1Id" style="display: none" class="upload_db_img_desn_disp_frame dsn_uplod_pos_adj1"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${concept1UploadedImage}'/>" width="220" height="100"></div>
					            			<form action="adminApprovedForAccConcepts1Red" method="get">
					            			<div class="top_adjustment_15 dsn_uplod_pos_adj1"><h4><button class="image_upload_files_submit_Btn" id="uploadButnCon1Id">APPROVE</button></h4>
					            			<img id="concept1ApprTickMarkId" src="resources/images/admin_tick_mark.png" style="display: none;" class="full_dd_tick_mark_img_adj">
					            			</div>
					            			</form>
					            			<div class="top_adjustment_15 dsn_uplod_pos_adj1"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image1Id" type='hidden'/></div>
					            			<div class="top_adjustment_20 dsn_uplod_pos_adj1 dsn_furn_spec_txt_dsp">FURNITURE SPECS</div>
					            			<div id="product1CountId" class="dsn_uplod_pos_adj1 dsn_furn_spec_num_dsp">0</div>
					            			<div id="productDb1CountId" style="display: none" class="dsn_uplod_pos_adj1 dsn_furn_spec_num_dsp"><c:out value='${desnUploadedProducts1Count}'/></div>
					            			<form action="desnUploadedAccConcept1ViewProducts">
					            			<div class="top_adjustment_5 dsn_uplod_pos_adj1"><h4><button class="upload_files_submit_Btn">VIEW</button></h4></div>
					            			</form>
					            		</div>
					            	</div> <!-- /.service-description -->
						        </div> <!-- /.service-item -->               
						    </div> <!-- /.col-md-6 -->
						    						    
						    <div align="center" class="col-md-6 col-sm-6">
					        	<div class="service-item">                        
					            	<div class="service-description">
					            		<div align="center">
					            			<div style="height: 10px; margin-top: 10px;" class="dsn_uplod_pos_adj2"><table><tr><td><img id="add2FavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"></td> <td><img id="add2FavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td> <td><img id="add2FavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td></tr></table></div>
					            			<div class="desn_concept_head_text dsn_uplod_pos_adj2">CONCEPT #2</div>
					            			<div id="uploadDBImgDsp2Id" class="upload_img_desn_disp_frame dsn_uplod_pos_adj2"></div>
					            			<div id="uploadImgDsp2Id" style="display: none" class="upload_db_img_desn_disp_frame dsn_uplod_pos_adj2"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${concept2UploadedImage}'/>" width="220" height="100"></div>
					            			<form action="adminApprovedForAccConcepts2Red" method="get">
					            			<div class="top_adjustment_15 dsn_uplod_pos_adj2"><h4><button class="image_upload_files_submit_Btn" id="uploadButnCon2Id">APPROVE</button></h4>
					            			<img id="concept2ApprTickMarkId" src="resources/images/admin_tick_mark.png" style="display: none;" class="full_dd_tick_mark_img_adj">
					            			</div>
					            			</form>
					            			<div class="top_adjustment_15 dsn_uplod_pos_adj2"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image2Id" type='hidden'/></div>
					            			<div class="top_adjustment_20 dsn_uplod_pos_adj2 dsn_furn_spec_txt_dsp">FURNITURE SPECS</div>
					            			<div id="product2CountId" class="dsn_uplod_pos_adj2 dsn_furn_spec_num_dsp">0</div>
					            			<div id="productDb2CountId" style="display: none" class="dsn_uplod_pos_adj2 dsn_furn_spec_num_dsp"><c:out value='${desnUploadedProducts2Count}'/></div>
					            			<form action="desnUploadedAccConcept2ViewProducts">
					            			<div class="top_adjustment_5 dsn_uplod_pos_adj2"><h4><button class="upload_files_submit_Btn">VIEW</button></h4></div>
					            			</form>
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
        	
        <div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left" class="desn_acc_upload_con_rend_frame2">
        				<div align="center">
        					<div style="height: 10px; margin-top: 10px;"><table><tr><td><img id="addFinalFavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"></td> <td><img id="addFinalFavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td> <td><img id="addFinalFavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none; margin-left: 5px;"></td></tr></table></div>
					    	<div class="desn_concept_head_text">FINAL CONCEPT</div>
					    	<div id="uploadDBImgDsp3Id" class="upload_img_desn_disp_frame"></div>
					    	<div id="uploadImgDsp3Id" style="display: none" class="upload_db_img_desn_disp_frame"><img class="con_img_mou" src="data:image/jpg;base64,<c:out value='${concept3UploadedImage}'/>" width="220" height="100"></div>
					    	<form action="adminApprovedForFinalConceptsRed" method="get">
					    	<div class="top_adjustment_15"><h4><button class="image_upload_files_submit_Btn" id="uploadButnFinalConId">APPROVE</button></h4>
					    	<img id="roomRendApprTickMarkId" src="resources/images/admin_tick_mark.png" style="display: none;" class="full_dd_tick_mark_img_adj">
					    	</div>
					    	</form>
					    	<div class="top_adjustment_15"><a class="view_img_for_desn conceptsRenderingPopupDspCl" href="#">VIEW</a>  <input id="image3Id" type='hidden'/></div>
					    	<div class="top_adjustment_20 dsn_furn_spec_txt_dsp">FURNITURE SPECS</div>
					    	<div id="product3CountId" class="dsn_furn_spec_num_dsp">0</div>
					    	<div id="productDb3CountId" style="display: none" class="dsn_furn_spec_num_dsp"><c:out value='${desnUploadedProducts3Count}'/></div>
					    	<form action="desnUploadedFinalConceptsViewProducts">
					    	<div class="top_adjustment_5"><h4><button class="upload_files_submit_Btn">VIEW</button></h4></div>
					    	</form>
					    	 			
					    </div>
					    
        			</div>
        			        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
           
        <div class="col-md-3 col-sm-3">        	               
        </div> <!-- /.col-md-3 -->
                         	
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_25">		 
        
        <div class="col-md-4 col-sm-4">
        <div class="row">
        <div class="col-md-1 col-sm-1">        
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">   
	                	<form action="adminApprovedConceptsAndRenderings" method="get">
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
        
        
        <script type="text/javascript" src="resources/js/popup/01_all_popup_window_display.js" ></script>		 
		 
		<div align="center" id="popupTotalWindowBoxId">
        <div align="center" style="display: none; left:0px; top:0px;" id="imageBackgroundDspId" class="window">
        
        <div align="center" class="popup_backgrond_img_display_cl">
        <div align="center"><img class="close popup_close_butt_dsp" src="resources/images/popup_close.png" alt="Close" title="Close"></div>
        <div align="center"><img class="popup_only_image_display_cl" id="bigConceptsRendPopupImgId" src="" ></div>
        </div>
        </div>
        <div align="center" class="popup_big_backgrond_display_cl" id="popUpBigMaskWindowId" style="display: none;"></div>
        </div>
                 
		</body>
</html>