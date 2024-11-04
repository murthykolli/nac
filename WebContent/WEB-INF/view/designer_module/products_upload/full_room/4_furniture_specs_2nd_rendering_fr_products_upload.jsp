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

	<!-- JS files -->
	<script type="text/javascript" src="resources/js/furniture_specs_and_renderings_validation.js"></script> 
	
	<script type="text/javascript">
  	var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
  	};
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        	
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center">
        			<p class="prod_uplod_disp_for_Dsn">2nd Rendering - FURNITURE SPECS</p>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
        </div> <!-- /.row -->
        
        
        <form action="furnitureSpecs2ndRenderingFRProdSaving" name="fileUpload" method="post" enctype="multipart/form-data">        
        <div class="row top_adjustment_20">
        
        <div class="col-md-2 col-sm-2">
        </div> <!-- /.col-md-2 -->
        
        <div class="col-md-8 col-sm-8">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center" class="prod_uplod_fur_spec_frame">
        					        			
	        			<table style="width: 720px;">
	        				<tbody>
	        					<tr> <td class="prod_field_txt_disp_in_ds">PRODUCT NAME:</td> <td><input type="text" id="productNameId" name="productName" placeholder="GREY DINING TABLE" class="prod_input_fild_disp_in_ds"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds">PRICE:</td> <td><font class="des_price_doll_sym">$</font><input type="text" id="productPriceId" name="productPrice" placeholder="699.99" class="prod_input_fild_disp_in_ds ds_price_left"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds">RECOMMENDED QUANTITY:</td> <td><input type="text" id="productsQuantityId" name="productsQuantity" placeholder="1" class="prod_input_fild_disp_in_ds ds_price_left"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds">STORE NAME:</td> <td><input type="text" id="storeNameId" name="storeName" placeholder="WEST ELM" class="prod_input_fild_disp_in_ds"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds">URL:</td> <td><input type="text" id="storeURLId" name="storeURL" placeholder="http://www.westelm/diningtable.com" class="prod_input_fild_disp_in_ds"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds">SKU#:</td> <td><input type="text" id="skuNameId" name="skuName" placeholder="SKU" class="prod_input_fild_disp_in_ds"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds">DESCRIPTION (DIMENSIONS/FINISH):</td> <td><input type="text" id="productDescriptionId" name="productDescription" placeholder="29&quot;h x 38&quot;d x 80&quot;w, SOLID OAK FINISH" class="prod_input_fild_disp_in_ds"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds" id="ass_req_status_id">IS ASSEMBLY REQUIRED:</td> <td><p><input type="radio" name="assemblyRequiredStatus" value="ASSEMBLY REQUIRED" class="ass_req_status_cl1 ass_req_status_value"> <font class="ass_req_status_text_cl1">YES</font> <input type="radio" name="assemblyRequiredStatus" value="NO ASSEMBLY REQUIRED" class="ass_req_status_cl2 ass_req_status_value"> <font class="ass_req_status_text_cl2">NO</font></p></td> </tr>
	        					<tr> <td class="prod_row_hight_disp_in_ds"></td> <td></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds">PRODUCT IMAGE:</td> <td><input type="file" name="fileUpload" id="fileUpload" class="prod_file_upload_disp_in_ds" accept="image/*" onchange="loadFile(event)"></td> </tr>
	        					<tr> <td class="prod_field_txt_disp_in_ds">&nbsp;&nbsp;</td> <td>&nbsp;<img id="output" class="desn_prod_file_upload_cl"/></td> </tr>
	        				</tbody>
	        			</table>
	        									   
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-8 -->
        	
        
        <div class="col-md-2 col-sm-2">
        </div> <!-- /.col-md-2 -->
        
                		
		</div> <!-- /.row -->
		
		<div class="row top_adjustment_20">
        
        <div class="col-md-2 col-sm-2">
        </div> <!-- /.col-md-2 -->
        
        <div class="col-md-4 col-sm-4">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
	        			<a href="furnitureSpecs2ndRenderingFRAddNewBackMove"><img title="BACK" class="prod_upload_back_butt_adj" src="resources/images/backButton.png"></a>
	        										   
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
        
        <div class="col-md-4 col-sm-4">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="right">	        			
						<h4><button class="desn_con_submit_Btn" id="furnitureSpecsButtonId">SAVE</button></h4>													   
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
        	
        
        <div class="col-md-2 col-sm-2">
        </div> <!-- /.col-md-2 -->
        
                		
		</div> <!-- /.row -->
		</form>
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        		
		</body>
</html>