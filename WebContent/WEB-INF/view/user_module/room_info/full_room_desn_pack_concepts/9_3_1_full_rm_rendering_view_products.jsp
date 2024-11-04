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

	<!-- CSS files -->
	<link rel="stylesheet" href="resources/css/popup.css" type="text/css">
	<link rel="stylesheet" href="resources/css/shop_your_view_products.css" type="text/css">
	<link type="text/css" rel="stylesheet" href="resources/css/0_concepts_rendering_frame_resolution.css" /> 
	    
	<script type="text/javascript">
 	$(document).ready(function(){
	
    consept1ImagesList =  '<c:out value='${viewProductImagesList}'/>';
    productsCon1NamesList =  '<c:out value='${viewProductNamesList}'/>';
    productsCon1QuantityList =  '<c:out value='${viewProductQuantityList}'/>';
    productsCon1PriceList =  '<c:out value='${viewProductPriceList}'/>';    
    productsCon1DescList =  '<c:out value='${viewProductDescriptionList}'/>';
    productsCon1AssReqStList =  '<c:out value='${viewAssemblyRequiredStatusList}'/>';
    productsCon1IdList =  '<c:out value='${viewProductsIdList}'/>';    
    });	
	</script>    
    
	<script type="text/javascript" src="resources/js/shop_your_view_products.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$(".addCartToProductsClass").click(function(){
			var idOfHiddenInput = $(this).parent().find('input:hidden:first').attr('id');
			
			var productsCon1Id = productsCon1IdList.split("_,_");
			document.popupProductsName.popUpRefName.value = productsCon1Id[idOfHiddenInput];
			document.popupProductsName.noOfProduct.value = 1;			
			
			$("#fullRmRenderingProductId").submit();
	    });		    
	    
	});
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
                            
        <div class="shop_your_room_txt_dsp">SHOP YOUR ROOM</div>
                  
        <div class="row top_adjustment_50">
  <!-- Concept 1 Image -->              	
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">        			
        				<div align="left" class="concept_rend_reso_div_class"><img class="con_img_mou cr_frame_viw_prod_reso_cl" src="data:image/jpg;base64,<c:out value='${concept2UploadedImage}'/>"></div>
        			</div>
        			
        			<div class="row top_adjustment_10">
	        			<div class="col-md-6 col-sm-6">
				        	<div class="service-item">                        
				            	<div class="service-description">
				        			<div align="left">        			
				        				<form action="fullRmRendering" method="get">
										<h4><input class="consepts_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
										</form>
				        			</div> <!-- /.col-md-6 -->				        			
				        		</div> <!-- /.service-description -->
			            	</div> <!-- /.service-item -->               
			        	</div> <!-- /.col-md-6 -->
			        	
			        	<div class="col-md-6 col-sm-6">
				        	<div class="service-item">                        
				            	<div class="service-description">
				        			<div align="right" class="all_shop_adj_dsp_cls">        			
				        				<font class="price_tot_dsp">total : </font> <font class="total_product_price_dsp"><c:out value='${totalProdPriceInDB}'/></font>	
				        			</div>				        			
				        		</div> <!-- /.service-description -->
			            	</div> <!-- /.service-item -->               
			        	</div> <!-- /.col-md-6 -->
				    </div> <!-- /.row -->			
				        	        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
                        
 
  <!-- Products Display -->              	
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">        			
        			        			
  <!-- Products Images Display -->
  					<div class="services">       			
			        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
        				<div align="center"> <div id="shopViewProductsRow1Col1Id"></div> <table id="shopViewProdContRow1Col1Id"></table> </div>        			
			        </div> </div> </div> <!-- /.col-md-4 -->
			        
			        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
        				<div align="center"> <div id="shopViewProductsRow1Col2Id"></div> <table id="shopViewProdContRow1Col2Id"></table> </div>        			
			        </div> </div> </div> <!-- /.col-md-4 -->
			        
			        <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
        				<div align="center"> <div id="shopViewProductsRow1Col3Id"></div> <table id="shopViewProdContRow1Col3Id"></table> </div>        			
			        </div> </div> </div> <!-- /.col-md-4 -->
			        </div> <!-- /.row -->
        			     			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->        	
        
        </div> <!-- /.row -->
        
<!-- Concept 2nd row Image -->
        <div class="services">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow2Col1Id"> </div> <table id="shopViewProdContRow2Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow2Col2Id"> </div> <table id="shopViewProdContRow2Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow2Col3Id"> </div> <table id="shopViewProdContRow2Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow2Col4Id"> </div> <table id="shopViewProdContRow2Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow2Col5Id"> </div> <table id="shopViewProdContRow2Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow2Col6Id"> </div> <table id="shopViewProdContRow2Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 3rd row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow3Col1Id"></div> <table id="shopViewProdContRow3Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow3Col2Id"></div> <table id="shopViewProdContRow3Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow3Col3Id"></div> <table id="shopViewProdContRow3Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow3Col4Id"></div> <table id="shopViewProdContRow3Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow3Col5Id"></div> <table id="shopViewProdContRow3Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow3Col6Id"></div> <table id="shopViewProdContRow3Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
                
<!-- Concept 4th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow4Col1Id"></div> <table id="shopViewProdContRow4Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow4Col2Id"></div> <table id="shopViewProdContRow4Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow4Col3Id"></div> <table id="shopViewProdContRow4Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow4Col4Id"></div> <table id="shopViewProdContRow4Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow4Col5Id"></div> <table id="shopViewProdContRow4Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow4Col6Id"></div> <table id="shopViewProdContRow4Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
                
<!-- Concept 5th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow5Col1Id"></div> <table id="shopViewProdContRow5Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow5Col2Id"></div> <table id="shopViewProdContRow5Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow5Col3Id"></div> <table id="shopViewProdContRow5Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow5Col4Id"></div> <table id="shopViewProdContRow5Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow5Col5Id"></div> <table id="shopViewProdContRow5Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow5Col6Id"></div> <table id="shopViewProdContRow5Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
                
<!-- Concept 6th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow6Col1Id"></div> <table id="shopViewProdContRow6Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow6Col2Id"></div> <table id="shopViewProdContRow6Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow6Col3Id"></div> <table id="shopViewProdContRow6Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow6Col4Id"></div> <table id="shopViewProdContRow6Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow6Col5Id"></div> <table id="shopViewProdContRow6Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow6Col6Id"></div> <table id="shopViewProdContRow6Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 7th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow7Col1Id"></div> <table id="shopViewProdContRow7Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow7Col2Id"></div> <table id="shopViewProdContRow7Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow7Col3Id"></div> <table id="shopViewProdContRow7Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow7Col4Id"></div> <table id="shopViewProdContRow7Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow7Col5Id"></div> <table id="shopViewProdContRow7Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow7Col6Id"></div> <table id="shopViewProdContRow7Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 8th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow8Col1Id"></div> <table id="shopViewProdContRow8Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow8Col2Id"></div> <table id="shopViewProdContRow8Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow8Col3Id"></div> <table id="shopViewProdContRow8Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow8Col4Id"></div> <table id="shopViewProdContRow8Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow8Col5Id"></div> <table id="shopViewProdContRow8Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow8Col6Id"></div> <table id="shopViewProdContRow8Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 9th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow9Col1Id"></div> <table id="shopViewProdContRow9Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow9Col2Id"></div> <table id="shopViewProdContRow9Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow9Col3Id"></div> <table id="shopViewProdContRow9Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow9Col4Id"></div> <table id="shopViewProdContRow9Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow9Col5Id"></div> <table id="shopViewProdContRow9Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow9Col6Id"></div> <table id="shopViewProdContRow9Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 10th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow10Col1Id"></div> <table id="shopViewProdContRow10Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow10Col2Id"></div> <table id="shopViewProdContRow10Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow10Col3Id"></div> <table id="shopViewProdContRow10Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow10Col4Id"></div> <table id="shopViewProdContRow10Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow10Col5Id"></div> <table id="shopViewProdContRow10Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow10Col6Id"></div> <table id="shopViewProdContRow10Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
         
<!-- Concept 11th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow11Col1Id"></div> <table id="shopViewProdContRow11Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow11Col2Id"></div> <table id="shopViewProdContRow11Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow11Col3Id"></div> <table id="shopViewProdContRow11Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow11Col4Id"></div> <table id="shopViewProdContRow11Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow11Col5Id"></div> <table id="shopViewProdContRow11Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow11Col6Id"></div> <table id="shopViewProdContRow11Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 12th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow12Col1Id"></div> <table id="shopViewProdContRow12Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow12Col2Id"></div> <table id="shopViewProdContRow12Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow12Col3Id"></div> <table id="shopViewProdContRow12Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow12Col4Id"></div> <table id="shopViewProdContRow12Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow12Col5Id"></div> <table id="shopViewProdContRow12Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow12Col6Id"></div> <table id="shopViewProdContRow12Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 13th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow13Col1Id"></div> <table id="shopViewProdContRow13Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow13Col2Id"></div> <table id="shopViewProdContRow13Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow13Col3Id"></div> <table id="shopViewProdContRow13Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow13Col4Id"></div> <table id="shopViewProdContRow13Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow13Col5Id"></div> <table id="shopViewProdContRow13Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow13Col6Id"></div> <table id="shopViewProdContRow13Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 14th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow14Col1Id"></div> <table id="shopViewProdContRow14Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow14Col2Id"></div> <table id="shopViewProdContRow14Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow14Col3Id"></div> <table id="shopViewProdContRow14Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow14Col4Id"></div> <table id="shopViewProdContRow14Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow14Col5Id"></div> <table id="shopViewProdContRow14Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow14Col6Id"></div> <table id="shopViewProdContRow14Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 15th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow15Col1Id"></div> <table id="shopViewProdContRow15Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow15Col2Id"></div> <table id="shopViewProdContRow15Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow15Col3Id"></div> <table id="shopViewProdContRow15Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow15Col4Id"></div> <table id="shopViewProdContRow15Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow15Col5Id"></div> <table id="shopViewProdContRow15Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow15Col6Id"></div> <table id="shopViewProdContRow15Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 16th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow16Col1Id"></div> <table id="shopViewProdContRow16Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow16Col2Id"></div> <table id="shopViewProdContRow16Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow16Col3Id"></div> <table id="shopViewProdContRow16Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow16Col4Id"></div> <table id="shopViewProdContRow16Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow16Col5Id"></div> <table id="shopViewProdContRow16Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow16Col6Id"></div> <table id="shopViewProdContRow16Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
       
<!-- Concept 17th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow17Col1Id"></div> <table id="shopViewProdContRow17Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow17Col2Id"></div> <table id="shopViewProdContRow17Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow17Col3Id"></div> <table id="shopViewProdContRow17Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow17Col4Id"></div> <table id="shopViewProdContRow17Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow17Col5Id"></div> <table id="shopViewProdContRow17Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow17Col6Id"></div> <table id="shopViewProdContRow17Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
        
<!-- Concept 18th row Image -->
        <div class="row">  
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow18Col1Id"></div> <table id="shopViewProdContRow18Col1Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow18Col2Id"></div> <table id="shopViewProdContRow18Col2Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow18Col3Id"></div> <table id="shopViewProdContRow18Col3Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow18Col4Id"></div> <table id="shopViewProdContRow18Col4Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow18Col5Id"></div> <table id="shopViewProdContRow18Col5Id"></table> </div>			
        </div> </div> </div>
        
        <div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
        	<div align="center"> <div id="shopViewProductsRow18Col6Id"></div> <table id="shopViewProdContRow18Col6Id"></table> </div>			
        </div> </div> </div>
        </div> <!-- /.row -->
                      
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
       
    <div id="boxes">
	
	<div style="width: 100%; height:100%; display: none; opacity: 0.1; z-index: 10001;" id="mask">  	
  	</div>
			
  	<div style="display: none; width: 1000px; z-index: 10001; margin-top: 0px;" id="dialog" class="window">
  		
  	  	
  	<div class="row">
  	
	<div class="col-md-5 col-sm-5">	
	  
    <div id="lorem" class="view_popup_frame_bottom_adj">
    <img class="all_dsn_prod_bigimg_reso_div_cls popup_frame_bck_adj" id="productImageID">   
    </div>
    </div>
      
    <div class="col-md-6 col-sm-6">
    <div class="prod_con_pop_text"><font id="productNameID"></font></div>
    <div class="qty_con_pop_text">RECOMMENDED QUANTITY: <font id="productQuantityID"></font></div>
    <div class="price_con_pop_text">$<font id="productPriceID"></font></div>
    
    <div class="descr_con_pop_text"><p id="productDescID"></p></div>
    <div class="ass_req_st_con_pop_text"><p id="productAssReqID"></p></div>
    
    <form action="fullRmRenderingProductAddToCart" name="popupProductsName" method="get" id="fullRmRenderingProductId">
    <table class="table_con_pop_text">
    <tr><td><input id="noOfProductsId" type="text" name="noOfProduct" style="width: 40px; border: 2px solid #595959; height: 24px;" onkeypress="return numeralsOnly(event);">&nbsp;QUANTITY</td></tr>
    <tr style="height: 20px;"><td></td></tr>
    <tr><td><h4><button class="popup_add_cart_butt" id="productSubmitId">ADD TO CART</button></h4></td></tr>    
    </table>
    <input type="hidden" id="popUpRefNameId" name="popUpRefName">    
    </form>
    </div>
    
    
    <div class="col-md-1 col-sm-1">	
	<div id="popupfoot" align="right" class="closeBut" style="position: fixed;"> <a href="#"><img src="resources/images/close.png" style="background: white; cursor: pointer; top: 10px; left: 10px; position: relative;"></a></div>
	</div>
    </div>
    
    </div>  
    
	</div>
		</body>
</html>