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
    var giftCardPrice1 = '<c:out value="${giftCardPrice}"/>';
    var remGiftCardPrice1 = '<c:out value="${remGiftCardPrice}"/>';
    var totalPaybleAmount1 = '<c:out value="${totalPaybleAmount}"/>';
    var giftCuponCode1 = '<c:out value="${giftCuponCode}"/>';
    var secRenderingAmount1 = '<c:out value="${secRenderingAmount}"/>';
    
    if(giftCardPrice1 === "0.00") {
    	giftCardPrice1 = "";
    }
    
    if(giftCardPrice1 !== "") {
    	var totalPaybleAmount = totalPaybleAmount1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        var giftCardPrice = giftCardPrice1.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#totalPaybleAmountId").html(totalPaybleAmount);
        $("#secRenderDisplayId").show();
        $("#totalGiftCardPriceId").html(giftCardPrice);
    	$("#giftInfoDisplayId").show();
    	$("#incGCTotalAmountId").show();
    	$("#totalPriceId").hide();
    	
    	$("[name=giftCardPrice]").val(giftCardPrice1);
    	$("[name=remGiftCardPrice]").val(remGiftCardPrice1);
    	$("[name=giftCuponCode]").val(giftCuponCode1);    	
    } else {
    	$("#secRenderDisplayId").hide();
    	$("#giftInfoDisplayId").hide();
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
    $("[name=totalPaybleAmount]").val(totalPaybleAmount1);
    $("[name=secRenderingAmount]").val(secRenderingAmount1);
    
    var giftCardStatus1 = '<c:out value="${giftCardStatus}"/>';

    if(giftCardStatus1 !== "") {
    	$("#giftCardStatusId").show();
    } else {
    	$("#giftCardStatusId").hide();
    }
        	
    }); 
    window.onload=function(){ document.getElementById("nameOnCardId").focus(); };
	</script>
	
    <script type="text/javascript">	
 	$(document).ready(function(){
 		var desnMessageSt = "<c:out value="${desnMessageCount}"/>";
 		var conceptStatus1 = "<c:out value="${conceptStatus}"/>";
 		var renderingStatus1 = "<c:out value="${renderingStatus}"/>";
 		var secondRenderingStatus1 = "<c:out value="${secondRenderingStatus}"/>";
 		var revisedRenderingStatus1 = "<c:out value="${revisedRenderingStatus}"/>";
 		
 		if(desnMessageSt > 0) {
        	$("#desnMessgeId").show();        	
        } else {
        	$("#desnMessgeId").hide();
        }
 		
 		if(conceptStatus1 === "Approved for Concepts") { 			
        	$("#conceptStatusId").show();
        } else {
        	$("#conceptStatusId").hide();
        }  

 		if(renderingStatus1 === "Approved for Renderings" || revisedRenderingStatus1 === "Approved for Revised Renderings") {
        	$("#renderingStatusId").show();
        } else {
        	$("#renderingStatusId").hide();
        }  

 		if(secondRenderingStatus1 === "Approved for Second Renderings") {
        	$("#secondRenderingStatusId").show();        	
        } else {
        	$("#secondRenderingStatusId").hide();
        }  

    });
	</script>
    
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        <div class="col-md-9 col-sm-9">
        </div> <!-- /.col-md-9 -->
        <div class="col-md-3 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description  start_new_project_but_adj">
            		<form action="getStartedBuss">
						<h4><button class="start_new_project">START A NEW ROOM</button></h4>
					</form>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
        </div> <!-- /.row --> 
                
        
        <div class="row">
        <div class="col-md-7 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description cl-main-header">
        			<div class="menu0 text-left">
                    	<ul>
		        			<li><a href="myRoomInformationRed"><c:out value="${typeOfSpaceVal}"/></a></li>
		        			<li><a href="fullRmConcepts">CONCEPTS</a><div class="conc_desn_new_img_ds" id="conceptStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmRendering">RENDERING</a><div class="rend_conc_desn_new_img_ds" id="renderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li class="current"><a href="fullRmSecRendering">2nd RENDERING</a><div class="sec_rend_conc_desn_new_img_ds" id="secondRenderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmShopRedir">SHOP</a></li>
		        			<li><a href="messageRed">MESSAGES</a><div class="mess_full_desn_new_img_ds" id="desnMessgeId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
        				</ul>
                    </div> <!-- /.menu -->   
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-5 col-sm-6">
        </div> <!-- /.col-md-5 -->
        </div> <!-- /.row -->
                   
        
        
        <div class="row top_adjustment_40"> 
        
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
                                        <option value=''>Year</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                        <option value="2021">2021</option>
                                        <option value="2022">2022</option>
                                        <option value="2023">2023</option>
                                        <option value="2024">2024</option>
                                        <option value="2025">2025</option>
                                        <option value="2026">2026</option>
                                        <option value="2027">2027</option>
                                        <option value="2028">2028</option>
                                        <option value="2029">2029</option>
                                        <option value="2030">2030</option>
                                        <option value="2031">2031</option>
                                        <option value="2032">2032</option>
                                        <option value="2033">2033</option>
                                        <option value="2034">2034</option>
                                        <option value="2035">2035</option>
                                        <option value="2036">2036</option>
                                        <option value="2037">2037</option>
                                        <option value="2038">2038</option>
                                        <option value="2039">2039</option>
                                        <option value="2040">2040</option>
                                        <option value="2041">2041</option>
                                        <option value="2042">2042</option>
                                        <option value="2043">2043</option>
                                        <option value="2044">2044</option>
                                        <option value="2045">2045</option>
                                        <option value="2046">2046</option>
                                        <option value="2047">2047</option>
                                        <option value="2048">2048</option>
                                        <option value="2049">2049</option>
                                        <option value="2050">2050</option>
                                        <option value="2051">2051</option>
                                        <option value="2052">2052</option>
                                        <option value="2053">2053</option>
                                        <option value="2054">2054</option>
                                        <option value="2055">2055</option>
                                        <option value="2056">2056</option>
                                        <option value="2057">2057</option>
                                        <option value="2058">2058</option>
                                        <option value="2059">2059</option>
                                        <option value="2060">2060</option>
                                        <option value="2061">2061</option>
                                        <option value="2062">2062</option>
                                        <option value="2063">2063</option>
                                        <option value="2064">2064</option>
                                        <option value="2065">2065</option>
                                        <option value="2066">2066</option>
                                        <option value="2067">2067</option>
                                        <option value="2068">2068</option>
                                        <option value="2069">2069</option>
                                        <option value="2070">2070</option>
                                        <option value="2071">2071</option>
                                        <option value="2072">2072</option>
                                        <option value="2073">2073</option>
                                        <option value="2074">2074</option>
                                        <option value="2075">2075</option>
                                        <option value="2076">2076</option>
                                        <option value="2077">2077</option>
                                        <option value="2078">2078</option>
                                        <option value="2079">2079</option>
                                        <option value="2080">2080</option>
                                        <option value="2081">2081</option>
                                        <option value="2082">2082</option>
                                        <option value="2083">2083</option>
                                        <option value="2084">2084</option>
                                        <option value="2085">2085</option>
                                        <option value="2086">2086</option>
                                        <option value="2087">2087</option>
                                        <option value="2088">2088</option>
                                        <option value="2089">2089</option>
                                        <option value="2090">2090</option>
                                        <option value="2091">2091</option>
                                        <option value="2092">2092</option>
                                        <option value="2093">2093</option>
                                        <option value="2094">2094</option>
                                        <option value="2095">2095</option>
                                        <option value="2096">2096</option>
                                        <option value="2097">2097</option>
                                        <option value="2098">2098</option>
                                        <option value="2099">2099</option>
                                        <option value="2100">2100</option>
                                    </select>
                                </div>
                                <div class="cvv-number detail">
                                    <div class="sec_rnd_cvv_num_text_dsp">CVV NUMBER:</div>
                                    
                                    <input type="password" name="payCvvNumber" maxlength="4" id="payCvvNumberId"
                                           class="pay_cvv_numb_display">
                                </div>
                            </div>
			        	
			        	
			        
                            <form action="giftCardInfoChecInRendering">
                                <div class="sec_rn_gift_code_frm">
                                    <div class="promo-code">
                                        <div class="sr_pay_promo_text_dsp">GIFT CARD:</div>
                                        <input type="text" name="payGiftCard" id="payGiftCardId"
                                               class="pack_pay_promo_and_gift_inpt_box">
                                    </div>
                                    <button class="payment_apply_sub_Btn" id="secRenGiftCardButtId">
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
							        <input type="hidden" name="totalPaybleAmount"/>
							        <input type="hidden" name="secRenderingAmount"/>
                                </div>
                            </form>
                            
			        	
			        	
			        <div align="center" class="sec_rn_tot_amount_frm_dsp">
			        <table>
			        <tr id="secRenderDisplayId" style="display: none;">
			        <td class="sec_rnd_gift_amount_text">2ND RENDERING:</td> <td class="sec_rnd_gift_amount_total">&nbsp;$${secRenderingAmount}</td>			        
			        </tr>
			        
			        <tr id="giftInfoDisplayId" style="display: none;">
			        <td class="sec_rnd_gift_amount_text">GIFT CARD:</td> <td class="sec_rnd_gift_amount_total">($<font id="totalGiftCardPriceId"></font>)</td>			        
			        </tr>
			        
			        <tr id="totalPriceId">
			        <td class="sec_rnd_total_pay_text">TOTAL:</td> <td class="sec_rnd_total_pay__price">&nbsp;$${secRenderingAmount}</td>			        
			        </tr>
			        
			        <tr id="incGCTotalAmountId" style="display: none;">
			        <td class="sec_rnd_total_pay_text">TOTAL:</td> <td class="sec_rnd_total_pay__price">&nbsp;$<font id="totalPaybleAmountId"></font></td>			        
			        </tr>
			        </table>
			        </div>
			        
			        <form action="secondRenderingPaymentInfoSaving" name="myDesign" method="POST">
			        <div align="center" class="top_adjustment_40"><h4><button class="continue_submit_Btn" id="secRendPaymentInfoButId">PURCHASE</button></h4></div>
			        
			        <input type="hidden" name="payCardNumber"/>
			        <input type="hidden" name="payExpMonth"/>
			        <input type="hidden" name="payExpYear"/>
			        <input type="hidden" name="payCvvNumber"/>
			        <input type="hidden" name="nameOnCard"/>
			        <input type="hidden" name="totalPaybleAmount"/>
			        <input type="hidden" name="secRenderingAmount"/>
			        
			        <input type="hidden" name="giftCardPrice"/>
			        <input type="hidden" name="remGiftCardPrice"/>
			        <input type="hidden" name="giftCuponCode"/>
			        
					<input type='hidden' name='apiLoginId' value='<%=apiLoginId%>' />
				    <input type='hidden' name='transactionKey' value='<%=transactionKey%>' />
				    <input type='hidden' name='amount' value='<%=amount%>' />			        		        
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

