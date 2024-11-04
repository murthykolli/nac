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
             
    var payCardNumber1 = '<c:out value="${payCardNumber}"/>';
    var payExpMonth1 = '<c:out value="${payExpMonth}"/>';
    var payExpYear1 = '<c:out value="${payExpYear}"/>';    
    var nameOnCard1 = '<c:out value="${nameOnCard}"/>';
    var payCvvNumber1 = '<c:out value="${payCvvNumber}"/>';
    
    $("[name=payCardNumber]").val(payCardNumber1);
    $("[name=payExpMonth]").val(payExpMonth1);
    $("[name=payExpYear]").val(payExpYear1);    
    $("[name=nameOnCard]").val(nameOnCard1);
    $("[name=payCvvNumber]").val(payCvvNumber1);
    $("[name=promoCodePrice]").val(promoCodePrice1);
    $("[name=giftCuponCode]").val(giftCuponCode1);
    
    var giftCardStatus1 = '<c:out value="${giftCardStatus}"/>';
    var promoStatus1 = '<c:out value="${promoStatus}"/>';
    
    if(giftCardStatus1 !== "") {
    	$("#giftCardStatusId").show();
    } else {
    	$("#giftCardStatusId").hide();
    }
    
    if(promoStatus1 !== "") {
    	$("#promoCodeStatusId").show();
    } else {
    	$("#promoCodeStatusId").hide();
    }

    if(packagePrice1 === "385") {
    	$("#promoCodeDisplayId").show();
    } else {
    	$("#promoCodeDisplayId").hide();
    }

    var ddlYears = $("#payExpYearId");        
    var currentYear = (new Date()).getFullYear(); 
    for (var i = currentYear; i <= currentYear+50; i++) {
        var option = $("<option />");
        option.html(i);
        option.val(i);
        ddlYears.append(option);
    }
        	
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
        
        
		<%		
// Sandbox KEY and ID info        
		/*String apiLoginId = "4xKZ87uLb4q5";
		String transactionKey = "5bt2wK786bER9Q65"; */
		        
// Production KEY and ID info
        String apiLoginId = "8ZRdf85ukH";
        String transactionKey = "4TJf59933hfGv6wF";
        
        String amount = (String)session.getAttribute("totalCheckoutAmountInSn");        
        %>       	
        
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="center">
			        <div class="shpp_tbl_fld_disp">	        
			        
			        	<c:if test="${not empty paymentValStatus}"> <tr><td align="left"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;"> &nbsp;&nbsp;&nbsp;&nbsp; ${paymentReturnStatus}</font></td></tr> </c:if>
			        
			        	<div class="full-width ">
                                    <div class="shoop_text_dsp">NAME ON CARD:</div>
                                    <input type="text" name="nameOnCard" id="nameOnCardId" class="shpp_inp_box_dsp">
                                </div>
                                <div class="full-width ">
                                    <div class="shoop_text_dsp">CARD NUMBER:</div>
                                    <input type="text" name="payCardNumber" maxlength="16" id="payCardNumberId"
                                           class="shpp_inp_box_dsp" onkeypress="return numeralsOnly(event);"
                                           onchange="return getCreditCardType();">
                                </div>
                            </div>

                            <div class="card-details">
                                <div class="expiration-month detail">

                                    <div class="sec_rnd_exp_month_text_dsp">EXP MONTH:</div>
                                    <select name="payExpMonth" id="payExpMonthId" class="pay_exp_month_display">
                                        <option value=''>Month</option>
                                        <option value='01'>January</option>
                                        <option value='02'>February</option>
                                        <option value='03'>March</option>
                                        <option value='04'>April</option>
                                        <option value='05'>May</option>
                                        <option value='06'>June</option>
                                        <option value='07'>July</option>
                                        <option value='08'>August</option>
                                        <option value='09'>September</option>
                                        <option value='10'>October</option>
                                        <option value='11'>November</option>
                                        <option value='12'>December</option>
                                    </select>
                                </div>
                                                                
                                <div class="expiration-year detail">
                                    <div class="sec_rnd_exp_year_text_dsp">EXP YEAR:</div>
                                    <select name="payExpYear" id="payExpYearId" class="pay_exp_year_display">
                                        <option value=''>----Year----</option>                                        
                                    </select>
                                </div>
                                
                                <div class="cvv-number detail">
                                    <div class="sec_rnd_cvv_num_text_dsp">CVV NUMBER:</div>
                                    <input type="password" name="payCvvNumber" maxlength="4" id="payCvvNumberId"
                                           class="pay_cvv_numb_display">
                                </div>
                            </div>
			       
                            <div id="promoCodeDisplayId">
                                <form action="promoCodePayInPackgeRed" method="post">
                                    <div class="rev_ord_promo_code_frm">
                                        <div class="promo-code">
                                            <div class="pay_promo_text_dsp">PROMO CODE:</div>
                                            <input type="text" name="payPromoCode" id="payPromoCodeId"
                                                   class="pack_pay_promo_and_gift_inpt_box">
                                        </div>
                                        <button class="payment_apply_sub_Btn" id="packagePayPromoCodeButtId">APPLY&nbsp; CODE
                                        </button>
                                        <div id="promoCodeStatusId" style="display: none;">
                                            <div class="pay_promo_error_text"><p>THE CODE YOU ENTERED IS NOT VALID OR
                                                HAS EXPIRED</p></div>
                                        </div>
                                        <input type="hidden" name="payCardNumber"/>
                                        <input type="hidden" name="payExpMonth"/>
                                        <input type="hidden" name="payExpYear"/>
                                        <input type="hidden" name="nameOnCard"/>
                                        <input type="hidden" name="giftCardPrice"/>
                                        <input type="hidden" name="giftCuponCode"/>
                                        <input type="hidden" name="payCvvNumber"/>
                                    </div>
                                </form>
                            </div>

                            <form action="giftCardPayInPackgeRed" method="post">
                                <div class="sec_rn_gift_code_frm">
                                    <div class="promo-code">
                                        <div class="sr_pay_promo_text_dsp">GIFT CARD:</div>
                                        <input type="text" name="payGiftCard" id="payGiftCardId"
                                               class="pack_pay_promo_and_gift_inpt_box">
                                    </div>
                                    <button class="payment_apply_sub_Btn" id="packagePayGiftCardButtId">
                                        APPLY&nbsp; CODE
                                    </button>
                                    <div id="giftCardStatusId" style="display: none;">
                                        <div class="pay_promo_error_text"><p>THE CODE YOU ENTERED IS NOT VALID OR HAS
                                            ALREADY BEEN USED</p></div>
                                        <div></div>

                                    </div>
                                    <input type="hidden" name="payCardNumber"/>
                                    <input type="hidden" name="payExpMonth"/>
                                    <input type="hidden" name="payExpYear"/>
                                    <input type="hidden" name="nameOnCard"/>
                                    <input type="hidden" name="payCvvNumber"/>
                                    <input type="hidden" name="promoCodePrice"/>
                                </div>
                            </form>
			        
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

                            <form action="paymentInfoSaving" name="myDesign" method="POST">
                                <div align="center" class="top_adjustment_40">
                                    <h4>
                                        <button class="continue_submit_Btn" id="desnPackPaymentButId">PURCHASE</button>
                                    </h4>
                                </div>

                                <input type="hidden" name="payCardNumber"/>
                                <input type="hidden" name="payExpMonth"/>
                                <input type="hidden" name="payExpYear"/>
                                <input type="hidden" name="payCvvNumber"/>
                                <input type="hidden" name="nameOnCard"/>

                                <input type="hidden" name="giftCardPrice"/>
                                <input type="hidden" name="remGiftCardPrice"/>
                                <input type="hidden" name="giftCuponCode"/>
                                <input type="hidden" name="promoCodePrice"/>

                                <input type='hidden' name='apiLoginId' value='<%=apiLoginId%>'/>
                                <input type='hidden' name='transactionKey' value='<%=transactionKey%>'/>
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

