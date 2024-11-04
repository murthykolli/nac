<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />	
	<style type="text/css">
	.cash_fund_guest_image_dsp { height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%; overflow: auto; overflow-y: hidden; overflow-x: hidden; width: 100%; }
	.cash_fund_rs_bott_box_htext_dsp { font: normal 1em/1.5em Georgia; color: black; letter-spacing: 2px; text-align: center; padding: 25px; text-transform: uppercase; }
    .cash_fund_gs_bott_box_htext_dsp { font: normal 1em/1.5em Georgia; color: black; letter-spacing: 2px; text-align: center; padding: 25px; text-transform: uppercase; }
    .cash_fund_gs_bott_box_htext_dsp::first-letter { font: normal 1.25em/1.5em Georgia; color: black;  }
    .cash_fund_side_hdtext_dsp { font: normal 1.0em/1.5em Georgia; color: black; letter-spacing: 2px; text-align: center; vertical-align: middle; text-transform: uppercase; }
    .first_letter_dsp { font-size: 22px;}
	</style>	
	<script type="text/javascript">
 	$(document).ready(function() { var cashFundsMessage1 = "<c:out value="${cashFundsMessage}"/>"; var priceReg = /^[0-9]+$/; 		
 		$("#contGuestRegButtonId").click(function () { var result = true; 		    
	 		if(priceReg.test($("#contributeAmountId").val())){ $("#contributeAmountId").css("border-color","black"); var guetCashFundNeedAmount1 = "<c:out value="${regCashFundsNeedAmount}"/>"; var guestCashFundNeedAmount1 = guetCashFundNeedAmount1.replace(",",""); var guestCashFundNeedAmountDb = parseFloat(guestCashFundNeedAmount1); var cashFundCotributedPriceDb = parseFloat($("#contributeAmountId").val());	 		
	 		if(cashFundCotributedPriceDb > guestCashFundNeedAmountDb) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds requested."); result=false; } } else{ $("#contributeAmountId").css("border-color","red"); result=false; } return result; });
 	 	$("#contributeAmountId").keyup(function() { if(priceReg.test(this.value)){ $("#contributeAmountId").css("border-color","black"); } else{ $("#contributeAmountId").css("border-color","red"); result=false; } });
 	 	var words = $('#cashFundNewNameTextId').text().split(' '); var html = '';
 	 	$.each(words, function() { html += '<span class="first_letter_dsp">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; });
 	 	$('#cashFundNewNameTextId').html(html); var regCashFundsNeedAmount1 = "<c:out value="${regCashFundsNeedAmount}"/>";
 	 	if(regCashFundsNeedAmount1 !== "null") { $("#cashFundStillNeedShowId").show(); } else { $("#cashFundStillNeedShowId").hide(); } $('#cashFundMessageTextDisplayId').html(cashFundsMessage1); 	 	
 	});
 	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0)); if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }
    </script>
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">        
<!-- Box display coding -->	        
		<div class="row top_adjustment_20"> <div class="col-md-2 col-sm-2"></div> <div class="col-md-8 col-sm-8 reg_guest_rbox_bord_dsp">
		<div align="left"> <div class="row top_adjustment_30"> <div class="col-md-4 col-sm-4"> <div class="row" align="center" style="margin-top: 0px;">
		<div><img src="${registryCashFundsImage}"class="cash_fund_guest_image_dsp"></div> </div> </div>
		<div class="col-md-4 col-sm-4 reg_guest_rsbox_red_dvd"> <div align="center" style="margin-top: 38px;" id="cashFundNewNameTextId" class="cash_fund_side_hdtext_dsp">${cashFundNewName}</div> </div>
		<div class="col-md-2 col-sm-2"> <img src="resources/images/registry/reg_guest_img/reg_gift_group_img.png" style="margin-top: 15px; margin-left: 13px;"> </div>
		<div class="col-md-2 col-sm-2"> <div class="reg_guest_gg_text_dsp">THIS IS A GROUP GIFT</div> </div> </div>
		<div class="row top_adjustment_80"> <div class="col-md-4 col-sm-4">
		<div align="center" class="reg_guest_fund_rstest_dsp">CONTRIBUTE ANY <br>AMOUNT TOWARDS <br>THIS FUND:</div> </div>
		<form action="guestCashFundInfoAddToCart" method="POST">
		<div align="center" class="col-md-4 col-sm-4" > <table> <tr> <td><input value="$" readonly class="reg_guest_rsdoller_dsp"></td> 
		<td><input type="text" name="contributeAmount" id="contributeAmountId" class="reg_guest_rsinput_amount_fld_cl" onkeypress="return numeralsOnly(event);"></td> </tr> </table>
		<div id="cashFundStillNeedShowId" style="display: none;" class="reg_guest_st_need_amt_text">STILL NEEDS: $${regCashFundsNeedAmount}</div> </div>
		<div class="col-md-4 col-sm-4"> <div class="text-center"> <h4><button class="reg_guest_cont_Butn_dspl" id="contGuestRegButtonId">CONTRIBUTE</button></h4> </div> </div>
		<input type="hidden" name="registryCashFundsId" value="${registryCashFundContId}"> <input type="hidden" name="cashFundsName" value="${cashFundNewName}"> <input type="hidden" name="registryCashFundsImage" value="${registryCashFundsImage}"> <input type="hidden" name="guestCashFundsNeedAmount" value="${regCashFundsNeedAmount}">
		</form> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_guest_rs_bott_box_dsp">
		<div align="center" class="cash_fund_gs_bott_box_htext_dsp" style="min-height: 70px;"><font id="cashFundMessageTextDisplayId"></font></div> </div> </div> </div> </div> <div class="col-md-2 col-sm-2"></div> </div> </div> </div>		     
		</body>
</html>