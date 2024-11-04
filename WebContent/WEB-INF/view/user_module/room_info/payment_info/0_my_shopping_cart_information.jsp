<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    <script type="text/javascript" src="resources/js/json-minified.js" ></script> 
    <script type="text/javascript" src="resources/js/popup/01_all_popup_window_display.js" ></script>   

	<!-- CSS files -->
	<link type="text/css" rel="stylesheet" href="resources/css/0_concepts_rendering_frame_resolution.css" /> 
		
	
	<script type="text/javascript">
	var produtValue;
    $(document).ready(function(){
    var totalPrice = '<c:out value="${totalProductsAmount}"/>';
    var formatPrice = totalPrice.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    $("#TotalProductPriceId").html(formatPrice);
    
    $('.productCountClass').keypress(function(e){
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
    return false;
    }
    /* 
    if (this.value.length == 0 && e.which == 48 ){
    return false;
    } */
    });
        
    var prodRowId;
    $(".productCountClass").click(function(){    	
    	var prodSavingHdId1 = $(this).parent().find('input:hidden:first').attr('id');    	
        if(produtValue === "" && prodSavingHdId1 !== prodRowId) {
    		alert("Please enter number of products");
    		$(this).blur();
    		return false;
    	} else if(produtValue > 0 && prodSavingHdId1 !== prodRowId) {
    		alert("Please save modified products");
    		$(this).blur();
    		return false;
    	} else {        
	    	$(".productCountClass").keyup(function(){    	
	    	var prodSavingHdId = $(this).parent().find('input:hidden:first').attr('id');    	    	
	    	$(this).focus();
	    	prodRowId = prodSavingHdId;
	    	produtValue = $(this).val();
	    	if(produtValue === "0") {
	    		alert("Please enter valid number");
	        }
	    	});
    	}
   	}); 
    
    $('.priceDisplayCl1').hide();
    $('.priceDisplayCl1').css("padding-top","20px");
        
    });
    
    function newAjaxDeleteCall(productId){
    	if (confirm("Are you sure you want to delete this product?") == true) {                
    	
    	$.ajax({    		
			type : 'POST',
			url : "deleteProductFromCart?addClientProductsToCartSavingId="+productId,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {				
				window.location = 'paymentCartInfoDisp';
			    return true;								
			} });    	
	    } else {
	    	return false;
	    }
    }
    
    function newAjaxSaveCall(productId){
    	
    	if(produtValue === "") {
    		alert("Please enter number of products");
    		return false;
    	} else if(produtValue === "0") {
    		alert("Please enter valid number");
    		return false;
        } else {    	
    	$.ajax({    		
			type : 'POST',
			url : "addProductsToCart?addClientProductsToCartSavingId="+productId+"&productCount="+produtValue,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {				
				window.location = 'paymentCartInfoDisp';
			    return true;								
			} }); 
    	}
    }
    
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
                
        <div class="row">
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
            		<div class="shop_your_room_txt_dsp">MY SHOPPING CART</div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description cl-main-header">
            	
        			<div class="menu2 text-right">
                    	<ul>
                    		<li><a href="clientsInformationDisplay">KEEP SHOPPING</a>&nbsp;</li>
                    		<li style="border-left: 1px solid red;">&nbsp;</li>
		        			<li><a href="proceedToCheckout">PROCEED TO CHECKOUT&nbsp;&nbsp;</a></li>		        				
        				</ul>
                    </div> <!-- /.menu -->   
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->                
        </div> <!-- /.row -->
                   
        
        <div class="row top_adjustment_50">        	
                	
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
            		<div class="row">
	            		<div class="col-md-2 col-sm-2">
				        	<div class="service-item">                        
				            	<div class="service-description">
				            		<div class="shopping_cart_txt_dsp">PRODUCT</div>
				                </div> <!-- /.service-description -->
				            </div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-2 -->
				        
				        <div class="col-md-5 col-sm-5">
				        	<div class="service-item">                        
				            	<div class="service-description">
				            		<div class="shopping_cart_txt_dsp">NAME</div>
				                </div> <!-- /.service-description -->
				            </div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-5 -->
				        
				        <div class="col-md-2 col-sm-2">
				        	<div class="service-item">                        
				            	<div class="service-description">
				            		<div class="shopping_cart_txt_dsp">QUANTITY</div>
				                </div> <!-- /.service-description -->
				            </div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-2 -->
				        
				        <div class="col-md-3 col-sm-3">
				        	<div class="service-item">                        
				            	<div class="service-description">
				            		<div class="shopping_cart_txt_dsp">PRICE</div>
				                </div> <!-- /.service-description -->
				            </div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-3 -->
				    </div> <!-- /.row -->
        			
        				<div class="shopping_cart_div_bar"></div>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
        
        
				
		<% if (null != session.getAttribute("product_Saving_Ids_List")) {
		   @SuppressWarnings("rawtypes")
	       ArrayList productSavingIdsList = (ArrayList) session.getAttribute("product_Saving_Ids_List");
	       if (null != productSavingIdsList && productSavingIdsList.size() > 0) {
		
		   if (null != session.getAttribute("product_Images_List")) {
		   @SuppressWarnings("rawtypes")
           ArrayList productImagesList = (ArrayList) session.getAttribute("product_Images_List");
           if (null != productImagesList && productImagesList.size() > 0) {

           if (null != session.getAttribute("product_Name_List")) {
    	   @SuppressWarnings("rawtypes")
           ArrayList productNameList = (ArrayList) session.getAttribute("product_Name_List");
           if (null != productNameList && productNameList.size() > 0) { 

           if (null != session.getAttribute("product_Price_List")) {
    	   @SuppressWarnings("rawtypes")
           ArrayList productPriceList = (ArrayList) session.getAttribute("product_Price_List");
           if (null != productPriceList && productPriceList.size() > 0) { 

           if (null != session.getAttribute("product_Count_List")) {
    	   @SuppressWarnings("rawtypes")
           ArrayList productCountList = (ArrayList) session.getAttribute("product_Count_List");
           if (null != productCountList && productCountList.size() > 0) {

           if (null != session.getAttribute("product_TotalPrice_List")) {
    	   @SuppressWarnings("rawtypes")
           ArrayList productTotalPriceList = (ArrayList) session.getAttribute("product_TotalPrice_List");
           if (null != productTotalPriceList && productTotalPriceList.size() > 0) {
        %>
        
        <% for(int i=0;i<productCountList.size(); i++){  %>        	
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
            		<div class="row top_adjustment_30">
	            		<div class="col-md-2 col-sm-2">
				        	<div class="service-item">                        
				            	<div class="service-description">
				            		<div align="center"><img align="middle" class="cl_add_cart_prod_img_disy_div_res" src="data:image/jpg;base64,<%=productImagesList.get(i)%>" ></div>
				                </div> <!-- /.service-description -->
				            </div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-2 -->
				        
				        <div class="col-md-5 col-sm-5">
				        	<div class="service-item">                        
				            	<div class="service-description">
				            		<div class="shopping_cart_desc_text"><%=productNameList.get(i)%></div>
				                </div> <!-- /.service-description -->
				            </div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-5 -->
				        
				        <div class="col-md-2 col-sm-2">
				        	<div class="service-item">                        
				            	<div class="service-description">
				            		<div align="center">
				            		
				            		<input class="shop_cart_input_box productCountClass" type="text" id="productCountId<%=productSavingIdsList.get(i)%>" name="productCount" value="<%=productCountList.get(i)%>" > <input type="hidden" id="<%=productSavingIdsList.get(i)%>" value="<%=productSavingIdsList.get(i)%>"></div>
				            		
				            		<div align="center" class="shp_update_dsp top_adjustment_15"><a href="#" onclick="return newAjaxSaveCall('<%=productSavingIdsList.get(i)%>');">UPDATE</a></div>
				            		<div align="center" class="shp_remove_dsp top_adjustment_5"><a href="#" onclick="return newAjaxDeleteCall('<%=productSavingIdsList.get(i)%>');">REMOVE</a></div>
				                </div> <!-- /.service-description -->
				            </div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-2 -->
				        
				        <div class="col-md-3 col-sm-3">
				        	<div class="service-item">                        
				            	<div class="service-description">
				            		<div class="shopping_cart_dy_bold_price_text">$<%=productTotalPriceList.get(i)%></div>
				            		<div class="shopping_cart_dy_price_text priceDisplayCl<%=productCountList.get(i)%>">$<%=productPriceList.get(i)%>/ITEM</div>
				                </div> <!-- /.service-description -->
				            </div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-3 -->
				    </div> <!-- /.row -->
        			
        				<div class="shopping_cart_sub_div_bar"></div>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
        <% } %>
        
        
        <% } } } } } } } } } } } }%>
        
        <div class="col-md-7 col-sm-7" style="margin-top: -5px;">
		   	<div class="service-item">                        
		       	<div class="service-description">
		       		<div align="left"><p class="shopin_cat_txt_spy">THE SHOPPING CART IS A TEMPORARY PLACE TO HOLD A LIST OF YOUR ITEMS. PRODUCTS ARE SUBJECT TO AVAILABILITY AND PRICING CHANGES.</p>		       		
		       		</div>
		       	</div> <!-- /.service-description -->
		 	</div> <!-- /.service-item -->             
		</div> <!-- /.col-md-7 -->
		
		<div class="col-md-5 col-sm-5">
		</div>
        
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_10">
        <div class="col-md-5 col-sm-5">
        </div><!-- /.col-md-5 -->
        
        <div class="col-md-7 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="right">
			        <div class="est_pat_total">
			        <table class="prs_tbl_adj">
			        	<tr>
			        		<td class="est_totl">ESTIMATED TOTAL:</td> <td class="price_shp_tol">$<font id="TotalProductPriceId"></font></td>
			        	</tr>
			        </table>
			        </div>
			        
			        <div><a class="excTaxtShippingPopupImg exc_tax_ship" href="#">EXCLUDES TAX &amp; SHIPPING</a></div>
			        </div>
			       
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_40">
        	<div class="col-md-7 col-sm-7">
            </div>
            <div class="col-md-2 col-sm-2" align="right">
            <p class="keep_sho_cart_text" style="position: relative; top: 15px; left: 40px; padding-bottom: 20px;"><a href="clientsInformationDisplay">KEEP SHOPPING</a></p>
            </div>
            <div class="col-md-3 col-sm-3" align="right">
            <form action="proceedToCheckout" method="get"><h4><button class="continue_submit_Btn" id="shippingId">CHECKOUT</button></h4></form>
            </div>
		
		</div> <!-- /.row --> 
		
		
        <div class="row top_adjustment_20">
        <div class="col-md-8 col-sm-8">
		   	<div class="service-item">                        
		       	<div class="service-description">		       		
		       		<div align="left" class="shopin_Big_box_dsp">
		       		<p class="shopin_cat_bott_txt_spy">TAXES &amp; SHIPPING FEES ARE NOT INCLUDED IN YOUR ESTIMATED TOTAL.</p>
		       		<p class="shopin_cat_bott_txt_spy btt_txt_top_adj_cls">ONCE YOU SUBMIT YOUR ORDER WITH US, WITHIN ONE BUSINESS DAY WE <br>WILL SEND YOU AN ITEMIZED ACCOUNT OF TAXES AND SHIPPING FEES FOR <br>EACH ITEM IN YOUR ORDER.</p>
		       		<p class="shopin_cat_bott_txt_spy btt_txt_top_adj_cls">YOU HAVE THE OPTION TO REVIEW AND APPROVE ALL FEES AND TAXES <br>BEFORE WE PLACE ORDERS WITH INDIVIDUAL VENDORS. YOUR ORDER WILL <br>BE PUT ON HOLD UNTIL YOU APPROVE YOUR ORDER.</p>
		       		<p class="shopin_cat_bott_txt_spy btt_txt_top_adj_cls">YOU CAN ALSO WAIVE YOUR OPTION TO SEE TAX AND SHIPPING FEES <br>BEFORE PLACING YOUR ORDER. THIS WILL ALLOW US TO PLACE YOUR ORDER <br>THE SAME BUSINESS DAY.</p>
		       		</div>
		       	</div> <!-- /.service-description -->
		 	</div> <!-- /.service-item -->             
		</div> <!-- /.col-md-8 -->
		
		<div class="col-md-4 col-sm-4">
		   	<div class="service-item">                        
		       	<div class="service-description">
		       		<div align="right" class="shopin_best_pri_img"><a href="#"><img src="resources/images/concepts/best_price_img.jpg" title="WE HONOR VENDOR PROMOS/DISCOUNTS THAT ARE APPLICABLE TO YOUR ORDER. WE MAKE SURE YOU GET THE BEST PRICE ON ALL YOUR ORDERS."></a></div>
		       	</div> <!-- /.service-description -->
		 	</div> <!-- /.service-item -->             
		</div> <!-- /.col-md-4 -->
				        
        </div> <!-- /.row -->      
                
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
         	
		<div align="center" id="popupTotalWindowBoxId">
        <div align="center" style="display: none; left:0px; top:0px;" id="imageBackgroundDspId" class="window">        
        <div align="center" class="popup_backgrond_img_display_cl">
        <div align="center"><img class="close popup_close_butt_dsp" src="resources/images/popup_close.png" title="Close"></div>
        <div align="center"><img class="popup_only_image_display_cl" id="bigPortfolio" src="" ></div>
        </div>
        </div>
        <div align="center" class="popup_big_backgrond_display_cl" id="popUpBigMaskWindowId" style="display: none;"></div>
        </div>
		</body>
</html>