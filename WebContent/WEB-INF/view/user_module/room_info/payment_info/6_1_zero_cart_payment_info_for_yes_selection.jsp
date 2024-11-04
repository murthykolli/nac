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
    
	<script type="text/javascript">
	var produtValue;
    $(document).ready(function(){   
    var giftCardPrice1 = '<c:out value="${giftCardPrice}"/>';
    var totalPaybleAmount1 = '<c:out value="${totalPaybleAmount}"/>';
    
    if(giftCardPrice1 === "0.00") {
    	giftCardPrice1 = "";
    }
    
    if(giftCardPrice1 !== "") {
    	var totalPaybleAmount = totalPaybleAmount1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        var giftCardPrice = giftCardPrice1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#totalPaybleAmountId").html(totalPaybleAmount);
        $("#totalGiftCardPriceId").html(giftCardPrice);
    	
        $("#productsDisplayId").show();
    	$("#giftInfoDisplayId").show();
    	$("#incGCTotalAmountId").show();
    	$("#onlyProdPriceDisplayId").hide();   	
    } else {
    	$("#productsDisplayId").hide();
    	$("#giftInfoDisplayId").hide();
    	$("#incGCTotalAmountId").hide();
    	$("#onlyProdPriceDisplayId").show();
    }
      	
    });
    </script>
	    
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
                 
        
		<% String amount = (String)session.getAttribute("totalCheckoutAmountInSn"); %>      	
          
		<div class="row">
                
        
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
            	
            	<div align="center" class="shpp_right_tb_frame">
			        
			        <div class="pay_est_pat_total">
			        			        
			        <table class="paymnt_prs_tbl_adj">
			        	
			        	<tr id="productsDisplayId" style="display: none;">
			        		<td class="spcart_pay_est_totl">PRODUCTS:</td> <td class="spcart_paymt_price_tol_dsp">$${totalProductsAmount}&nbsp;</td>
			        	</tr>
			        	
			        	<tr id="giftInfoDisplayId" style="display: none;">
			        		<td class="spcart_pay_est_totl">GIFT CARD:</td> <td class="spcart_paymt_price_tol_dsp">($<font id="totalGiftCardPriceId"></font>)<font id="allEstTotalDispId" style="display: none;"></font>&nbsp;</td>
			        	</tr>
			        	
			        	<tr id="onlyProdPriceDisplayId">
			        		<td class="spcart_pay_est_totl">ESTIMATED TOTAL:</td> <td class="pay_price_shp_tol">$${totalProductsAmount}&nbsp;</td>
			        	</tr>
			        	
			        	<tr id="incGCTotalAmountId" style="display: none;">
			        		<td class="spcart_pay_est_totl">ESTIMATED TOTAL:</td> <td class="pay_price_shp_tol">$<font id="totalPaybleAmountId"></font>&nbsp;</td>
			        	</tr>
			        </table>
			        </div>
			        
			        <form action="zeroCartPaymentPurchaseToGateway" name="myDesign" method="POST">					
			        <div class="top_adjustment_40"><h4><button class="continue_submit_Btn" id="cartPaymentInfoButId">SUBMIT ORDER</button></h4></div>
			        			        
				    <input type='hidden' name='amount' value='<%=amount%>' />			        		        
			        </form>
			        
			        </div>
            	           	
			       
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
                        
        </div> <!-- /.row -->
              
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                        	
		</body>
</html>

