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
	var produtValue;
    $(document).ready(function(){    
    var totalPaybleAmount1 = '<c:out value="${totalGiftCardPrice}"/>';
    var promoCodePrice1 = '<c:out value="${promoCodePrice}"/>';
    var totalPrice1 = '<c:out value="${totalPrice}"/>';
    
    if(totalPaybleAmount1 !== "" && promoCodePrice1 !== "") {
    	var totalPaybleAmount = totalPaybleAmount1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#totalPaybleAmountId").html(totalPaybleAmount);        
    	$("#discountAmountDisplayId").show();
    	$("#onlyGCPriceDisplayId").show();    	
    	$("#totalGCAndPromoAmountId").show();
    	$("#totalGCAmountId").hide();
    } else {
    	$("#discountAmountDisplayId").hide();
    	$("#onlyGCPriceDisplayId").hide();    	
    	$("#totalGCAndPromoAmountId").hide();
    	$("#totalGCAmountId").show();
    }
    
    var typeOfPackage1 = '<c:out value="${typeOfPackage}"/>';
    var packagePrice1 = '<c:out value="${packagePrice}"/>';
    var merchandiseCredit1 = '<c:out value="${merchandiseCredit}"/>';
    var typeOfGiftcard1 = '<c:out value="${typeOfGiftcard}"/>';
    var typeOfDelivery1 = '<c:out value="${typeOfDelivery}"/>';
    var giftRecipientName1 = '<c:out value="${giftRecipientName}"/>';
    var giftRecipientAddress1 = '<c:out value="${giftRecipientAddress}"/>';
    var giftRecipientCity1 = '<c:out value="${giftRecipientCity}"/>';
    var giftRecipientState1 = '<c:out value="${giftRecipientState}"/>';
    var giftRecipientZipCode1 = '<c:out value="${giftRecipientZipCode}"/>';
    var recEmailarName1 = '<c:out value="${recEmailarName}"/>';
    var recEmailarAddress1 = '<c:out value="${recEmailarAddress}"/>';
    var yourName1 = '<c:out value="${yourName}"/>';
    var yourEmail1 = '<c:out value="${yourEmail}"/>';
    var giftMessage1 = '<c:out value="${giftMessage}"/>';
    var deliveryDate1 = '<c:out value="${deliveryDate}"/>';
        
    $("[name=typeOfPackage]").val(typeOfPackage1);
    $("[name=packagePrice]").val(packagePrice1);
    $("[name=merchandiseCredit]").val(merchandiseCredit1);
    $("[name=typeOfGiftcard]").val(typeOfGiftcard1);
    $("[name=typeOfDelivery]").val(typeOfDelivery1);
    $("[name=giftRecipientName]").val(giftRecipientName1);
    $("[name=giftRecipientAddress]").val(giftRecipientAddress1);
    $("[name=giftRecipientCity]").val(giftRecipientCity1);
    $("[name=giftRecipientState]").val(giftRecipientState1);
    $("[name=giftRecipientZipCode]").val(giftRecipientZipCode1);
    $("[name=recEmailarName]").val(recEmailarName1);
    $("[name=recEmailarAddress]").val(recEmailarAddress1);
    $("[name=yourName]").val(yourName1);
    $("[name=yourEmail]").val(yourEmail1);
    $("[name=giftMessage]").val(giftMessage1);
    $("[name=deliveryDate]").val(deliveryDate1);
    $("[name=totalPrice]").val(totalPrice1);    
    $("[name=promoCodePrice]").val(promoCodePrice1);
    
    var promoStatus1 = '<c:out value="${promoStatus}"/>';
    
    if(promoStatus1 !== "") {
    	$("#promoCodeStatusId").show();
    } else {
    	$("#promoCodeStatusId").hide();
    }
        	
    });
    window.onload=function(){ document.getElementById("nameOnCardId").focus(); };
	</script>
	
	<!-- <script type="text/javascript">
	<extraOptions>
    <![CDATA[x_duplicate_window=10]]>
  	</extraOptions>
	</script> -->
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
       
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="center">
			        
                        <div align="center" class="sec_rn_tot_amount_frm_dsp">
                            <table>
                                <tr id="onlyGCPriceDisplayId" style="display: none;">
                                    <td class="sec_rnd_gift_amount_text">GIFT CARD:</td>
                                    <td class="sec_rnd_gift_amount_total">&nbsp;$${totalPrice}</td>
                                </tr>

                                <tr id="discountAmountDisplayId" style="display: none;">
                                    <td class="sec_rnd_gift_amount_text">DISCOUNT:</td>
                                    <td class="sec_rnd_gift_amount_total">($${promoCodePrice})</td>
                                </tr>

                                <tr id="totalGCAmountId">
                                    <td class="sec_rnd_total_pay_text">TOTAL:</td>
                                    <td class="sec_rnd_total_pay__price">&nbsp;$${totalGiftCardPrice}</td>
                                </tr>

                                <tr id="totalGCAndPromoAmountId" style="display: none;">
                                    <td class="sec_rnd_total_pay_text">TOTAL:</td>
                                    <td class="sec_rnd_total_pay__price">&nbsp;$<font
                                            id="totalPaybleAmountId"></font></td>
                                </tr>
                            </table>
                        </div>
			        	
                        <form action="giftCardPromoCodePaymentInfoSaving" name="myDesign" method="POST">
                            <div align="center" class="top_adjustment_40">
                                <h4>
                                    <button class="continue_submit_Btn" id="desnPackPaymentButId">PURCHASE</button>
                                </h4>
                            </div>

                            <input type="hidden" name="typeOfPackage"/>
                            <input type="hidden" name="packagePrice"/>
                            <input type="hidden" name="merchandiseCredit"/>
                            <input type="hidden" name="typeOfGiftcard"/>
                            <input type="hidden" name="typeOfDelivery"/>
                            <input type="hidden" name="giftRecipientName"/>
                            <input type="hidden" name="giftRecipientAddress"/>
                            <input type="hidden" name="giftRecipientCity"/>
                            <input type="hidden" name="giftRecipientState"/>
                            <input type="hidden" name="giftRecipientZipCode"/>
                            <input type="hidden" name="recEmailarName"/>
                            <input type="hidden" name="recEmailarAddress"/>
                            <input type="hidden" name="yourName"/>
                            <input type="hidden" name="yourEmail"/>
                            <input type="hidden" name="giftMessage"/>
                            <input type="hidden" name="deliveryDate"/>
                            <input type="hidden" name="totalPrice"/>
                            <input type="hidden" name="promoCodePrice"/>
                            <input type='hidden' name='amount' value='<%=amount%>'/>
                        </form>

                    </div>

                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div> <!-- /.row -->

    </div> <!-- /.container -->
</div> <!-- /.Main Frame -->
                        	
		</body>
</html>

