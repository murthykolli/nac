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

	<script type="text/javascript">
	history.pushState(null, document.title, location.href);
	window.addEventListener('popstate', function (event) {
	history.pushState(null, document.title, location.href);
	});
	window.onload=function(){ document.getElementById("nameOnCardId").focus(); };
	</script>
    
	<script type="text/javascript">
	var produtValue;
    $(document).ready(function(){    
    var giftCardPrice1 = '<c:out value="${giftCardPrice}"/>';
    var remGiftCardPrice1 = '<c:out value="${remGiftCardPrice}"/>';
    var totalPaybleAmount1 = '<c:out value="${totalPaybleAmount}"/>';
    var giftCuponCode1 = '<c:out value="${giftCuponCode}"/>';
    var packagePrice1 = '<c:out value="${packagePrice}"/>';
    var promoCodePrice1 = '<c:out value="${promoCodePrice}"/>';
    if(giftCardPrice1 === "0.00") {
    	giftCardPrice1 = "";
    }
    
    if(giftCardPrice1 !== "" && promoCodePrice1 !== "") {
    	var totalPaybleAmount = totalPaybleAmount1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        var giftCardPrice = giftCardPrice1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#totalPaybleAmountId").html(totalPaybleAmount);
        $("#totalGiftCardPriceId").html(giftCardPrice);
    	$("#giftInfoDisplayId").show();
    	$("#discountAmountDisplayId").show();
    	$("#packageDisplayId").show();
    	$("#incGCTotalAmountId").show();
    	$("#totalPriceId").hide();
    	$("[name=giftCardPrice]").val(giftCardPrice1);
    	$("[name=remGiftCardPrice]").val(remGiftCardPrice1);
    	$("[name=giftCuponCode]").val(giftCuponCode1);
    	$("[name=promoCodePrice]").val(promoCodePrice1);
    } else if(giftCardPrice1 !== "" && promoCodePrice1 === "") {
    	var totalPaybleAmount = totalPaybleAmount1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        var giftCardPrice = giftCardPrice1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#totalPaybleAmountId").html(totalPaybleAmount);
        $("#totalGiftCardPriceId").html(giftCardPrice);
    	$("#giftInfoDisplayId").show();
    	$("#packageDisplayId").show();
    	$("#incGCTotalAmountId").show();
    	$("#totalPriceId").hide();
    	$("[name=giftCardPrice]").val(giftCardPrice1);
    	$("[name=remGiftCardPrice]").val(remGiftCardPrice1);
    	$("[name=giftCuponCode]").val(giftCuponCode1);
    	$("[name=promoCodePrice]").val(promoCodePrice1);
    } else if(promoCodePrice1 !== "" && giftCardPrice1 === "") {
    	var totalPaybleAmount = totalPaybleAmount1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#totalPaybleAmountId").html(totalPaybleAmount);        
    	$("#discountAmountDisplayId").show();
    	$("#packageDisplayId").show();
    	$("#totalPriceId").hide();
    	$("#incGCTotalAmountId").show();
    	$("[name=promoCodePrice]").val(promoCodePrice1);
    	$("[name=giftCuponCode]").val(giftCuponCode1);
    } else {    	
    	$("#giftInfoDisplayId").hide();
    	$("#discountAmountDisplayId").hide();
    	$("#packageDisplayId").hide();
    	$("#incGCTotalAmountId").hide();
    	$("#totalPriceId").show();
    }
    
    $("[name=promoCodePrice]").val(promoCodePrice1);
    $("[name=giftCuponCode]").val(giftCuponCode1);
           	
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
			        <div align="center"><p class="sec_rend_pay_info_disp">PAYMENT INFO:</p></div>
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
        
        
		<% String amount = (String)session.getAttribute("totalCheckoutAmountInSn"); %>       	
        
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="center">
			        	<div align="center" class="sec_rn_tot_amount_frm_dsp">
                                <table>
                                    <tr id="packageDisplayId" style="display: none;">
                                        <td class="sec_rnd_gift_amount_text">PACKAGE:</td>
                                        <td class="sec_rnd_gift_amount_total">&nbsp;$${packagePriceFm}</td>
                                    </tr>

                                    <tr id="discountAmountDisplayId" style="display: none;">
                                        <td class="sec_rnd_gift_amount_text">DISCOUNT:</td>
                                        <td class="sec_rnd_gift_amount_total">($${promoCodePrice})</td>
                                    </tr>

                                    <tr id="giftInfoDisplayId" style="display: none;">
                                        <td class="sec_rnd_gift_amount_text">GIFT CARD:</td>
                                        <td class="sec_rnd_gift_amount_total">($<font id="totalGiftCardPriceId"></font>)
                                        </td>
                                    </tr>

                                    <tr id="totalPriceId">
                                        <td class="sec_rnd_total_pay_text">TOTAL:</td>
                                        <td class="sec_rnd_total_pay__price">&nbsp;$${packagePriceFm}</td>
                                    </tr>

                                    <tr id="incGCTotalAmountId" style="display: none;">
                                        <td class="sec_rnd_total_pay_text">TOTAL:</td>
                                        <td class="sec_rnd_total_pay__price">&nbsp;$<font
                                                id="totalPaybleAmountId"></font></td>
                                    </tr>
                                </table>
                            </div>

                            <form action="zeroPaymentInfoSaving" name="myDesign" method="POST">
                                <div align="center" class="top_adjustment_40">
                                    <h4>
                                        <button class="continue_submit_Btn" id="desnPackPaymentButId">PURCHASE</button>
                                    </h4>
                                </div>

                                <input type="hidden" name="giftCardPrice"/>
                                <input type="hidden" name="remGiftCardPrice"/>
                                <input type="hidden" name="giftCuponCode"/>
                                <input type="hidden" name="promoCodePrice"/>
                                <input type='hidden' name='amount' value='<%=amount%>'/>
                            </form>

                        </div>

                    </div> <!-- /.service-description -->
                </div> <!-- /.service-item -->
            </div> <!-- /.col-md-12 -->

        </div> <!-- /.row -->

    </div> <!-- /.container -->
</div> <!-- /.Main Frame -->
                        	
		</body>
</html>

