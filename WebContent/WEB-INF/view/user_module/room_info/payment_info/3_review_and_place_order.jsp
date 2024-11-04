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
    <script type="text/javascript" src="resources/js/shipping_billing_validation.js" ></script>
    <script type="text/javascript" src="resources/js/popup/01_all_popup_window_display.js" ></script>
    
	
	<script type="text/javascript">
	var produtValue;
    $(document).ready(function(){
    	var totalPrice = '<c:out value="${totalProductsAmount}"/>';
        var formatPrice = totalPrice.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#TotalProductPriceId").html(formatPrice);

    var reviewOrderStatus1 = '<c:out value="${reviewOrderStatus}"/>';
    $("[name='reviewOrderStatus']").each(function (){    	
        if(reviewOrderStatus1.indexOf($(this).val()) !== -1){    
        $(this).attr("checked",true);   
        }   
    });
         	
    });    
	</script>
	</head>
		
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">            
        <div class="row">
        
        <div class="col-md-5 col-sm-6 top_adjustment_20">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="left"><p class="ship_info_disp">REVIEW &amp; PLACE ORDER:</p></div>
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-5 -->
        
        
        <div class="col-md-7 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div>
			        	<table class="main_tb_frame">
			        		<tr>
			        			<td class="ship_text_sep1">SHOPPING CART</td> <td class="ship_text_sep2">SHIPPING</td> <td class="ship_text_sep3">BILLING</td> <td class="ship_text_sep4">REVIEW</td> <td class="ship_text_sep5">PAYMENT</td>
			        		</tr>
			        		
			        		<tr>
			        			<td class="ship_fram_divd1" id="shopping_cart_bar_id"></td> <td class="ship_fram_divd2" id="shipping_bar_id"></td> <td class="ship_fram_divd3" id="billing_bar_id"></td> <td class="ship_fram_divd4" id="review_bar_id"></td> <td class="ship_fram_divd5"></td>
			        		</tr>
			        	</table>
			        </div>
			       
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
		
		</div> <!-- /.row -->
		
				
		<div class="row">
		
        <div class="col-md-6 col-sm-6">
        <div class="row">
        
<!-- SHIPPING INFO -->        
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="left">
			        <table class="riv_pls_order_disp">
			        	<tr>
			        		<td class="pls_ord_head_ds">SHIPPING INFO &nbsp;&nbsp;<a class="bill_add_change_disp" href="changeShippingInfo">CHANGE</a></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp">${shipFullName}</td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>${shipAddress1}</p></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>${shipAddress2}</p></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>${shipCity},&nbsp;${shipState}&nbsp;${shipZip}</p></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>UNITED STATES</p></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>${shipPhNumber}</p></td>		        		
			        	</tr>			        	
			        	
			        </table>
			        </div>
			        
			        <div class="review_and_pls_ord_div"></div>
			        
<!-- BILLING INFO -->

					<div align="left">
			        <table class="riv_pls_order_bill_disp">
			        	<tr>
			        		<td class="pls_ord_head_ds">BILLING INFO &nbsp;&nbsp;<a class="bill_add_change_disp" href="changeBillingInfo">CHANGE</a></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp">${billFullName}</td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>${billAddress1}</p></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>${billAddress2}</p></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>${billCity},&nbsp;${billState}&nbsp;${billZip}</p></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>UNITED STATES</p></td>			        		
			        	</tr>
			        	
			        	<tr>
			        		<td class="pls_ord_text_dsp"><p>${billPhNumber}</p></td>		        		
			        	</tr>			        	
			        	
			        </table>
			        </div>
			        <div class="review_and_pls_ord_div"></div>  
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->       
         
        </div> <!-- /.row -->
            
        </div> <!-- /.col-md-6 -->
         
           
<!-- ORDER DETAILS --> 
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="right" class="shpp_right_tb_frame">
			        <div><a class="edt_my_ord" href="paymentCartInfoDisp">EDIT MY ORDER</a></div>
			        
			        <div class="est_pat_total">
			        <table class="prs_tbl_adj">
			        	<tr style="position: relative; left: 0px; top: 3px;">
			        		<td class="est_totl">ESTIMATED TOTAL:</td> <td class="pay_price_shp_tol">$<font id="TotalProductPriceId"></font>&nbsp;</td>
			        	</tr>
			        </table>
			        </div>
			        
			        <div><a class="excTaxtShippingPopupImg exc_tax_ship" href="#">EXCLUDES TAX &amp; SHIPPING</a></div>
			        
			        <form action="reviewPlaceOrderDataSaving" name="reviewPlaceOrder" method="post">
					<div align="right" class="top_adjustment_40">
					<table>
					<tr class="place_my_order_dsp_cl"><td> <p class="revi_pla_or_head_text_cl" id="revi_pla_or_head_text_id">PLEASE SELECT ONE: </p></td></tr>
			        <tr class="place_my_order_dsp_cl"><td> <input type="radio" name="reviewOrderStatus" class="review_orde_st_cls" value="Place My Order"><p class="plsMyordTextDsp" id="place_my_order_dsp_id">YOU CAN PLACE MY ORDER BEFORE SENDING ME INFO <br>ON TAX &amp; SHIPPING FEES </p></td></tr>
			        <tr style="height: 20px;"><td></td></tr>
			        <tr class="do_not_place_my_order_dsp_cl"><td> <input type="radio" name="reviewOrderStatus" class="review_orde_st_cls" value="Do Not Place My Order"><p class="plsMyordTextDsp" id="do_not_place_my_order_dsp_id">DO NOT PLACE MY ORDER UNTIL I APPROVE TAXES &amp; <br>SHIPPING FEES ON MY ORDER </p></td></tr>
			        </table></div>
			        
			        <div align="right" class="top_adjustment_30">
					<a href="#" class="excTaxtShippingPopupImg rev_ord_learn_more_cl">LEARN MORE</a>
					</div>
			        
			        <div class="top_adjustment_40"><h4><button class="continue_submit_Btn" id="revPlaceOrdButtonId">CONTINUE</button></h4></div>
			        </form>
			        
			        <div class="subm_place_order_pay_but_div_adj">   
	                	<form action="paymentReviewBackMove" method="post">
							<h4><input class="payment_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
						</form>
					</div>
								        	
			        </div>
			       
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
				
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