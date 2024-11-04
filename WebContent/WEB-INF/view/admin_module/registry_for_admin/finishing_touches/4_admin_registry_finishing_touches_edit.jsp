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
	<script type="text/javascript" src="resources/js/admin_registry_finishing_touches_edit_validation.js"></script>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
			
	    var productCategory1 = '<c:out value="${productCategory}"/>';
	    var productName1 = '<c:out value="${productName}"/>';
	    var productSize11 = '<c:out value="${productSize1}"/>';
	    var productSize12 = '<c:out value="${productSize2}"/>';
	    var productSize13 = '<c:out value="${productSize3}"/>';
	    var productSize14 = '<c:out value="${productSize4}"/>';
	    var productSize15 = '<c:out value="${productSize5}"/>';
	    var productDescription11 = '<c:out value="${productDescription1}"/>';
	    /* var productDescription12 = '<c:out value="${productDescription2}"/>';
	    var productDescription13 = '<c:out value="${productDescription3}"/>';
	    var productDescription14 = '<c:out value="${productDescription4}"/>';
	    var productDescription15 = '<c:out value="${productDescription5}"/>'; */
	    var productPrice11 = '<c:out value="${productPrice1}"/>';
	    var productPrice12 = '<c:out value="${productPrice2}"/>';
	    var productPrice13 = '<c:out value="${productPrice3}"/>';
	    var productPrice14 = '<c:out value="${productPrice4}"/>';
	    var productPrice15 = '<c:out value="${productPrice5}"/>';
	    var storeName1 = '<c:out value="${storeName}"/>';
	    var storeUrl1 = '<c:out value="${storeUrl}"/>';
	    var skuName1 = '<c:out value="${skuName}"/>';
	    var brandName1 = '<c:out value="${brandName}"/>';
	    	    
	    productName1 = productName1.replace(/\&amp;/g,"&"); productName1 = productName1.replace(/&#034;/g,"\""); productName1 = productName1.replace(/&#039;/g,"'"); productName1 = productName1.replace(/&lt;/g,"<"); productName1 = productName1.replace(/&gt;/g,">");
	    productDescription11 = productDescription11.replace(/\&amp;/g,"&"); productDescription11 = productDescription11.replace(/&#034;/g,"\""); productDescription11 = productDescription11.replace(/&#039;/g,"'"); productDescription11 = productDescription11.replace(/&lt;/g,"<"); productDescription11 = productDescription11.replace(/&gt;/g,">");
	    productSize11 = productSize11.replace(/\&amp;/g,"&"); productSize11 = productSize11.replace(/&#034;/g,"\""); productSize11 = productSize11.replace(/&#039;/g,"'"); productSize11 = productSize11.replace(/&lt;/g,"<"); productSize11 = productSize11.replace(/&gt;/g,">");
		productSize12 = productSize12.replace(/\&amp;/g,"&"); productSize12 = productSize12.replace(/&#034;/g,"\""); productSize12 = productSize12.replace(/&#039;/g,"'"); productSize12 = productSize12.replace(/&lt;/g,"<"); productSize12 = productSize12.replace(/&gt;/g,">");
		productSize13 = productSize13.replace(/\&amp;/g,"&"); productSize13 = productSize13.replace(/&#034;/g,"\""); productSize13 = productSize13.replace(/&#039;/g,"'"); productSize13 = productSize13.replace(/&lt;/g,"<"); productSize13 = productSize13.replace(/&gt;/g,">");
		productSize14 = productSize14.replace(/\&amp;/g,"&"); productSize14 = productSize14.replace(/&#034;/g,"\""); productSize14 = productSize14.replace(/&#039;/g,"'"); productSize14 = productSize14.replace(/&lt;/g,"<"); productSize14 = productSize14.replace(/&gt;/g,">");
		productSize15 = productSize15.replace(/\&amp;/g,"&"); productSize15 = productSize15.replace(/&#034;/g,"\""); productSize15 = productSize15.replace(/&#039;/g,"'"); productSize15 = productSize15.replace(/&lt;/g,"<"); productSize15 = productSize15.replace(/&gt;/g,">");	    
	    brandName1 = brandName1.replace(/\&amp;/g,"&"); brandName1 = brandName1.replace(/&#034;/g,"\""); brandName1 = brandName1.replace(/&#039;/g,"'"); brandName1 = brandName1.replace(/&lt;/g,"<"); brandName1 = brandName1.replace(/&gt;/g,">");
	    storeName1 = storeName1.replace(/\&amp;/g,"&"); storeName1 = storeName1.replace(/&#034;/g,"\""); storeName1 = storeName1.replace(/&#039;/g,"'"); storeName1 = storeName1.replace(/&lt;/g,"<"); storeName1 = storeName1.replace(/&gt;/g,">");
		storeUrl1 = storeUrl1.replace(/\&amp;/g,"&"); storeUrl1 = storeUrl1.replace(/&#034;/g,"\""); storeUrl1 = storeUrl1.replace(/&#039;/g,"'"); storeUrl1 = storeUrl1.replace(/&lt;/g,"<"); storeUrl1 = storeUrl1.replace(/&gt;/g,">");
		skuName1 = skuName1.replace(/\&amp;/g,"&"); skuName1 = skuName1.replace(/&#034;/g,"\""); skuName1 = skuName1.replace(/&#039;/g,"'"); skuName1 = skuName1.replace(/&lt;/g,"<"); skuName1 = skuName1.replace(/&gt;/g,">");
	    	    
	    $("[name=productCategory]").val(productCategory1);
	    $("[name=productName]").val(productName1);
	    $("[name=productSize1]").val(productSize11);
	    $("[name=productSize2]").val(productSize12);
	    $("[name=productSize3]").val(productSize13);
	    $("[name=productSize4]").val(productSize14);
	    $("[name=productSize5]").val(productSize15);
	    $("[name=productDescription1]").val(productDescription11);
	    /* $("[name=productDescription2]").val(productDescription12);
	    $("[name=productDescription3]").val(productDescription13);
	    $("[name=productDescription4]").val(productDescription14);
	    $("[name=productDescription5]").val(productDescription15); */
	    $("[name=productPrice1]").val(productPrice11);
	    $("[name=productPrice2]").val(productPrice12);
	    $("[name=productPrice3]").val(productPrice13);
	    $("[name=productPrice4]").val(productPrice14);
	    $("[name=productPrice5]").val(productPrice15);
	    $("[name=storeName]").val(storeName1);
	    $("[name=storeUrl]").val(storeUrl1);
	    $("[name=skuName]").val(skuName1);
	    $("[name=brandName]").val(brandName1);
	    
	    if(productPrice12 != "") {
	 		$(".addProductsButtCl1Dsp").hide();
	 		$(".addProductsButtCl2Dsp").show();
	 		$(".addProductsCl2Dsp").show();	 			
	 	}
	 		
	    if(productPrice13 != "") {
	 		$(".addProductsButtCl1Dsp").hide();
	 		$(".addProductsButtCl2Dsp").hide();
	 		$(".addProductsButtCl3Dsp").show();
	 		$(".addProductsCl2Dsp").show();
	 		$(".addProductsCl3Dsp").show();
	    }
	 		
	    if(productPrice14 != "") {
	 		$(".addProductsButtCl1Dsp").hide();
	 		$(".addProductsButtCl2Dsp").hide();
	 		$(".addProductsButtCl3Dsp").hide();
	 		$(".addProductsButtCl4Dsp").show();
	 		$(".addProductsCl2Dsp").show();
	 		$(".addProductsCl3Dsp").show();
	 		$(".addProductsCl4Dsp").show();
	    }
	 		
	    if(productPrice15 != "") {
	 		$(".addProductsButtCl1Dsp").hide();
	 		$(".addProductsButtCl2Dsp").hide();
	 		$(".addProductsButtCl3Dsp").hide();
	 		$(".addProductsButtCl4Dsp").hide();
	 		$(".addProductsButtCl5Dsp").show();
	 		$(".addProductsCl2Dsp").show();
	 		$(".addProductsCl3Dsp").show();
	 		$(".addProductsCl4Dsp").show();
	 		$(".addProductsCl5Dsp").show();
	    }
	    var productUploadedImage11 = '<c:out value="${productUploadedImage1}"/>';
	    var productUploadedImage12 = '<c:out value="${productUploadedImage2}"/>';
	    var productUploadedImage13 = '<c:out value="${productUploadedImage3}"/>';
	    var productUploadedImage14 = '<c:out value="${productUploadedImage4}"/>';
	    var productUploadImage1 = ""; var productUploadImage2 = ""; var productUploadImage3 = ""; var productUploadImage4 = "";
	    if(productUploadedImage11 !== "") {
	    	$("#productUploadImage1ID").val("Have Value");	    	
	    }
	    if(productUploadedImage12 !== "") {
	    	$("#productUploadImage2ID").val("Have Value");
	    }
	    if(productUploadedImage13 !== "") {
	    	$("#productUploadImage3ID").val("Have Value");
	    }
	    if(productUploadedImage14 !== "") {
	    	$("#productUploadImage4ID").val("Have Value");
	    }
	    
	    if(productUploadedImage11 != "") {
	    	var selmgPath1 = "data:image/jpg;base64,<c:out value="${productUploadedImage1}"/>";
	    	$("#output1").attr("src", selmgPath1);	    	
	    	delImageVale1 = "Have";
	    	$("#image1BorderDisplayId").show();	    	
	    }

	    if(productUploadedImage12 != "") {
	    	var selmgPath2 = "data:image/jpg;base64,<c:out value="${productUploadedImage2}"/>";
	    	$("#output2").attr("src", selmgPath2);	    	
	    	delImageVale2 = "Have";
	    	$("#image2BorderDisplayId").show();
	    }

	    if(productUploadedImage13 != "") {
	    	var selmgPath3 = "data:image/jpg;base64,<c:out value="${productUploadedImage3}"/>";
	    	$("#output3").attr("src", selmgPath3);	    	
	    	delImageVale3 = "Have";
	    	$("#image3BorderDisplayId").show();
	    }

	    if(productUploadedImage14 != "") {
	    	var selmgPath4 = "data:image/jpg;base64,<c:out value="${productUploadedImage4}"/>";
	    	$("#output4").attr("src", selmgPath4);	    	
	    	delImageVale4 = "Have";
	    	$("#image4BorderDisplayId").show();
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
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center">
        			<p class="prod_uplod_disp_for_admcb">FINISHING TOUCHES - FURNITURE SPECS</p>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
        </div> <!-- /.row -->
        
        
        <form action="adminFinishingTouchesModifiedDataUpdate" name="fileUpload" method="post" enctype="multipart/form-data">        
        <div class="row top_adjustment_20">
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
        <div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center" class="prod_uplod_fur_spec_frame_for_admcb">
        					        			
	        			<table style="width: 860px;">
	        				<tbody>
	        					<tr> <td class="prod_field_txt_disp_for_admcb">CATEGORY:</td> 
	        					<td><select id="productCategoryId" name="productCategory" class="prod_select_box_fild_disp_in_admcb"> 
								<option value=''>-------------------Select Category-------------------</option>	
							    <option value='Curtains'>Curtains</option>							    
							    <option value='Bedding'>Bedding</option>
							    <option value='Pillows'>Pillows</option>
							    <option value='Throws'>Throws</option>
							    <option value='Kitchen & Dining'>Kitchen &nbsp; Dining</option>
							    <option value='Home Accessories'>Home Accessories</option>
							    <option value='Mattresses'>Mattresses</option>
							    <option value='Lighting'>Lighting</option>							    
								</select></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_for_admcb">PRODUCT NAME:</td> <td><input type="text" id="productNameId" name="productName" maxLength="46" placeholder="GREY DINING TABLE" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					<tr class="addProductsCl1Dsp"> <td class="prod_field_txt_disp_for_admcb">DESCRIPTION (DIMENSIONS/FINISH):</td> <td><input type="text" id="productDescription1Id" name="productDescription1" placeholder="29&quot;h x 38&quot;d x 80&quot;w, SOLID OAK FINISH" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					
	        					<tr class="addProductsCl1Dsp"> <td class="prod_field_txt_disp_for_admcb">SELECT 1:</td> <td><input type="text" id="productSize1Id" name="productSize1" placeholder="SELECT" class="prod_input_fild_disp_in_admcb"></td> </tr>	        						        					
	        					<tr class="addProductsCl1Dsp"> <td class="prod_field_txt_disp_for_admcb">PRICE 1:</td> <td><input type="text" id="productPrice1Id" name="productPrice1" placeholder="49.99" class="prod_input_fild_disp_in_admcb ds_price_left"></td> </tr>
	        					<tr class="addProductsButtCl1Dsp"> <td class="prod_field_txt_disp_for_admcb">&nbsp;</td> <td style="padding-top: 15px; padding-bottom: 30px;"><button class="adn_reg_add_boards_upload_subt_Btn" id="clickAddProducts1Id" style="width: 200px; margin-left: 20px;">ADD</button></td> </tr>
	        					
	        					<tr class="addProductsCl2Dsp" style="display: none; height: 25px;"> <td></td></tr>
	        					<tr class="addProductsCl2Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">SELECT 2:</td> <td><input type="text" id="productSize2Id" name="productSize2" placeholder="SELECT" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					<!-- <tr class="addProductsCl2Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">DESCRIPTION (DIMENSIONS/FINISH) 2:</td> <td><input type="text" id="productDescription2Id" name="productDescription2" placeholder="29&quot;h x 38&quot;d x 80&quot;w, SOLID OAK FINISH" class="prod_input_fild_disp_in_admcb"></td> </tr> -->	        					
	        					<tr class="addProductsCl2Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">PRICE 2:</td> <td><input type="text" id="productPrice2Id" name="productPrice2" placeholder="49.99" class="prod_input_fild_disp_in_admcb ds_price_left"></td> </tr>
	        					<tr class="addProductsButtCl2Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">&nbsp;</td> <td style="padding-top: 15px; padding-bottom: 30px;"><button class="adn_reg_add_boards_upload_subt_Btn" id="clickAddProducts2Id" style="width: 200px; margin-left: 20px;">ADD</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="resources/images/red_close_button.png" id="clickRemoveProducts2Id" title="REMOVE" style=" cursor: pointer;"></td> </tr>
	        					
	        					<tr class="addProductsCl3Dsp" style="display: none; height: 25px;"> <td></td></tr>
	        					<tr class="addProductsCl3Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">SELECT 3:</td> <td><input type="text" id="productSize3Id" name="productSize3" placeholder="SELECT" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					<!-- <tr class="addProductsCl3Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">DESCRIPTION (DIMENSIONS/FINISH) 3:</td> <td><input type="text" id="productDescription3Id" name="productDescription3" placeholder="29&quot;h x 38&quot;d x 80&quot;w, SOLID OAK FINISH" class="prod_input_fild_disp_in_admcb"></td> </tr> -->	        					
	        					<tr class="addProductsCl3Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">PRICE 3:</td> <td><input type="text" id="productPrice3Id" name="productPrice3" placeholder="49.99" class="prod_input_fild_disp_in_admcb ds_price_left"></td> </tr>
	        					<tr class="addProductsButtCl3Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">&nbsp;</td> <td style="padding-top: 15px; padding-bottom: 30px;"><button class="adn_reg_add_boards_upload_subt_Btn" id="clickAddProducts3Id" style="width: 200px; margin-left: 20px;">ADD</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="resources/images/red_close_button.png" id="clickRemoveProducts3Id" title="REMOVE" style=" cursor: pointer;"></td> </tr>
	        					
	        					<tr class="addProductsCl4Dsp" style="display: none; height: 25px;"> <td></td></tr>
	        					<tr class="addProductsCl4Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">SELECT 4:</td> <td><input type="text" id="productSize4Id" name="productSize4" placeholder="SELECT" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					<!-- <tr class="addProductsCl4Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">DESCRIPTION (DIMENSIONS/FINISH) 4:</td> <td><input type="text" id="productDescription4Id" name="productDescription4" placeholder="29&quot;h x 38&quot;d x 80&quot;w, SOLID OAK FINISH" class="prod_input_fild_disp_in_admcb"></td> </tr> -->	        					
	        					<tr class="addProductsCl4Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">PRICE 4:</td> <td><input type="text" id="productPrice4Id" name="productPrice4" placeholder="49.99" class="prod_input_fild_disp_in_admcb ds_price_left"></td> </tr>
	        					<tr class="addProductsButtCl4Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">&nbsp;</td> <td style="padding-top: 15px; padding-bottom: 30px;"><button class="adn_reg_add_boards_upload_subt_Btn" id="clickAddProducts4Id" style="width: 200px; margin-left: 20px;">ADD</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="resources/images/red_close_button.png" id="clickRemoveProducts4Id" title="REMOVE" style=" cursor: pointer;"></td> </tr>
	        					
	        					<tr class="addProductsCl5Dsp" style="display: none; height: 25px;"> <td></td></tr>
	        					<tr class="addProductsCl5Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">SELECT 5:</td> <td><input type="text" id="productSize5Id" name="productSize5" placeholder="SELECT" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					<!-- <tr class="addProductsCl5Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">DESCRIPTION (DIMENSIONS/FINISH) 5:</td> <td><input type="text" id="productDescription5Id" name="productDescription5" placeholder="29&quot;h x 38&quot;d x 80&quot;w, SOLID OAK FINISH" class="prod_input_fild_disp_in_admcb"></td> </tr> -->	        					
	        					<tr class="addProductsCl5Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">PRICE 5:</td> <td><input type="text" id="productPrice5Id" name="productPrice5" placeholder="49.99" class="prod_input_fild_disp_in_admcb ds_price_left"></td> </tr>	        					
	        					<tr class="addProductsButtCl5Dsp" style="display: none;"> <td class="prod_field_txt_disp_for_admcb">&nbsp;</td> <td style="padding-top: 15px; padding-bottom: 30px;"><img src="resources/images/red_close_button.png" style="margin-left: 20px; cursor: pointer;" id="clickRemoveProducts5Id" title="REMOVE"></td> </tr>
	        					
	        					<tr> <td class="prod_field_txt_disp_for_admcb">BRAND:</td> <td><input type="text" id="brandNameId" name="brandName" placeholder="BRAND" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_for_admcb">STORE NAME:</td> <td><input type="text" id="storeNameId" name="storeName" maxLength="20" placeholder="WEST ELM" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_for_admcb">URL:</td> <td><input type="text" id="storeURLId" name="storeUrl" placeholder="http://www.westelm/diningtable.com" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_for_admcb">SKU#:</td> <td><input type="text" id="skuNameId" name="skuName" placeholder="RD32424" class="prod_input_fild_disp_in_admcb"></td> </tr>
	        					</tbody>
	        			</table>
	        			
	        			<table style="margin-top: 40px; margin-left: -230px;">
	        				<tbody>	        					
	        					<tr> <td class="prod_field_txt_disp_for_admcb">PRODUCT IMAGE 1:</td> <td style="position: relative; left: 15px;"><input type="file" name="productUploadedImage1" id="productUploadedImage1" class="prod_file_upload_disp_for_admcb" accept="image/*" onchange="loadFile1(event)"></td> 
	        					<td><div id="image1BorderDisplayId" style="display: none;"><img id="output1" class="desn_prod_file_upload_arcb" width="100" height="80"/> <img src="resources/images/red_close_button.png" id="removeUPImg1Id" title="REMOVE" style="cursor: pointer; position: relative; margin-left: -15px; margin-top: -55px;"> </div> </td></tr>
	        					<tr style="height: 20px;"><td></td><td></td><td></td></tr>
	        						        					
	        					<tr> <td class="prod_field_txt_disp_for_admcb">PRODUCT IMAGE 2:</td> <td style="position: relative; left: 15px;"><input type="file" name="productUploadedImage2" id="productUploadedImage2" class="prod_file_upload_disp_for_admcb" accept="image/*" onchange="loadFile2(event)"></td>
	        					<td><div id="image2BorderDisplayId" style="display: none;"><img id="output2" class="desn_prod_file_upload_arcb" width="100" height="80"/> <img src="resources/images/red_close_button.png" id="removeUPImg2Id" title="REMOVE" style="cursor: pointer; position: relative; margin-left: -15px; margin-top: -55px;"> </div> </td> </tr>
	        					<tr style="height: 20px;"><td></td><td></td><td></td></tr>
	        					
	        					<tr> <td class="prod_field_txt_disp_for_admcb">PRODUCT IMAGE 3:</td> <td style="position: relative; left: 15px;"><input type="file" name="productUploadedImage3" id="productUploadedImage3" class="prod_file_upload_disp_for_admcb" accept="image/*" onchange="loadFile3(event)"></td>
	        					<td><div id="image3BorderDisplayId" style="display: none;"><img id="output3" class="desn_prod_file_upload_arcb" width="100" height="80"/> <img src="resources/images/red_close_button.png" id="removeUPImg3Id" title="REMOVE" style="cursor: pointer; position: relative; margin-left: -15px; margin-top: -55px;"> </div> </td> </tr>
	        					<tr style="height: 20px;"><td></td><td></td><td></td></tr>
	        					
	        					<tr> <td class="prod_field_txt_disp_for_admcb">PRODUCT IMAGE 4:</td> <td style="position: relative; left: 15px;"><input type="file" name="productUploadedImage4" id="productUploadedImage4" class="prod_file_upload_disp_for_admcb" accept="image/*" onchange="loadFile4(event)"></td>
	        					<td><div id="image4BorderDisplayId" style="display: none;"><img id="output4" class="desn_prod_file_upload_arcb" width="100" height="80"/> <img src="resources/images/red_close_button.png" id="removeUPImg4Id" title="REMOVE" style="cursor: pointer; position: relative; margin-left: -15px; margin-top: -55px;"> </div> </td> </tr>
	        				</tbody>
	        			</table>
	        					        									   
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-10 -->
        	
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
                		
		</div> <!-- /.row -->
		
		<div class="row top_adjustment_30">
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
        <div class="col-md-5 col-sm-5">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
	        			<a href="redirectAdminFinishingTouchesDisplay"><img title="BACK" class="prod_upload_back_butt_adj_for_admcb" src="resources/images/backButton.png"></a>
	        										   
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
        
        <div class="col-md-5 col-sm-5">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="right">	        			
						<h4><button class="admn_reg_cont_bd_submit_btn" id="admFTFurnitureSpecsEditButtId">SAVE</button></h4>													   
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
        	
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
                		
		</div> <!-- /.row -->
		
		<input type="hidden" name="productUploadImage1" id="productUploadImage1ID"/>
		<input type="hidden" name="productUploadImage2" id="productUploadImage2ID"/>
		<input type="hidden" name="productUploadImage3" id="productUploadImage3ID"/>
		<input type="hidden" name="productUploadImage4" id="productUploadImage4ID"/>
		</form>
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        		
		</body>
</html>