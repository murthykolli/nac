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
    
    var shipFullName1 = '<c:out value="${shipFullName}"/>';
    var shipAddress01 = '<c:out value="${shipAddress1}"/>';
    var shipAddress02 = '<c:out value="${shipAddress2}"/>';
    var shipCity1 = '<c:out value="${shipCity}"/>';
    var shipState1 = '<c:out value="${shipState}"/>';
    var shipZip1 = '<c:out value="${shipZip}"/>';    
    var shipPhNumber1 = '<c:out value="${shipPhNumber}"/>';
    
    $("[name=shipFullName]").val(shipFullName1);
    $("[name=shipAddress1]").val(shipAddress01);
    $("[name=shipAddress2]").val(shipAddress02);
    $("[name=shipCity]").val(shipCity1);
    $("[name=shipState]").val(shipState1);
    $("[name=shipZip]").val(shipZip1);    
    $("[name=shipPhNumber]").val(shipPhNumber1);
      
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
			        <div align="left"><p class="ship_info_disp">SHIPPING INFO:</p></div>
			        
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
			        			<td class="ship_fram_divd1" id="shopping_cart_bar_id"></td> <td class="ship_fram_divd2" id="shipping_bar_id"></td> <td class="ship_fram_divd3"></td> <td class="ship_fram_divd4"></td> <td class="ship_fram_divd5"></td>
			        		</tr>
			        	</table>
			        </div>
			       
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
		
		</div> <!-- /.row -->
		
		
		
		
		<div class="row">
        <form action="shippingInfoSavingInDB" method="post">
        <div class="col-md-5 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="left">
			        <table class="shpp_tbl_fld_disp">
			        	<tr>
			        		<td><div style="width: 400px;"></div></td>
			        	</tr>
			        	<tr>
			        		<td class="shoop_text_dsp">FULL NAME:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="shipFullName" id="shipFullNameId" class="shpp_inp_box_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">ADDRESS 1:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="shipAddress1" id="shipAddress1Id" class="shpp_inp_box_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">ADDRESS 2:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="shipAddress2" id="shipAddress2Id" class="shpp_inp_box_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">CITY:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="shipCity" id="shipCityId" class="shpp_inp_box_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">STATE:</td> <td class="shoop_text_dsp"><font class="shoop_text_zip_dsp">ZIP:</font></td>
			        	</tr>
			        	<tr>
			        		<td><select name="shipState" id="shipStateId" class="shpp_inp_box_state"> <option value="">------State Name------</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select></td> 
			        		
			        		<td><input type="text" name="shipZip" maxLength="5" id="shipZipId" class="shpp_inp_box_zip" onkeypress="return numeralsOnly(event);"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">COUNTRY:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="shipCountry" id="shipCountryId" value="UNITED STATES" class="shpp_inp_box_country_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">PHONE NUMBER:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="shipPhNumber" maxLength="12" id="shipPhNumberId" class="shpp_inp_box_dsp" onchange="return phoneFormat (event,shipPhNumberId);" onkeydown="return numeralsOnly(event);" onkeyup="return phoneFormat (event,shipPhNumberId)" onkeypress="return numeralsOnly(event);"></td>
			        	</tr>
			        </table>
			        </div>
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-5 -->
        
        
        <div class="col-md-7 col-sm-6">
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
			        
			        <div class="top_adjustment_30"><h4><button class="continue_submit_Btn" id="shippingInfoButtonId">CONTINUE</button></h4></div>	
			        </div>
			       
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        </form>
        
        
		<div class="bill_paymnt_but_div_adj desktop">   
	    	<form action="paymentCartInfoDisp" method="get">
				<h4><input class="payment_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
			</form>
		</div>
		
		</div> <!-- /.row -->
		
		<div class="mobile" style="margin-top: -90px;">   
	    	<form action="paymentCartInfoDisp" method="get">
				<h4><input class="payment_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
			</form>
		</div>
		
		    
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