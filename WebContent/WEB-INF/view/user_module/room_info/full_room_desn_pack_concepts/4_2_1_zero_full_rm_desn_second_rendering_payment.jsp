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
        
		<% String amount = (String)session.getAttribute("totalCheckoutAmountInSn"); %>      	
        
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="center">
			        	
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
			        
			        <form action="zeroSecondRenderingPaymentInfoSaving" name="myDesign" method="POST">
			        <div align="center" class="top_adjustment_40"><h4><button class="continue_submit_Btn" id="secRendPaymentInfoButId">PURCHASE</button></h4></div>
			        			        
			        <input type="hidden" name="totalPaybleAmount"/>
			        <input type="hidden" name="secRenderingAmount"/>
			        
			        <input type="hidden" name="giftCardPrice"/>
			        <input type="hidden" name="remGiftCardPrice"/>
			        <input type="hidden" name="giftCuponCode"/>
			        
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

