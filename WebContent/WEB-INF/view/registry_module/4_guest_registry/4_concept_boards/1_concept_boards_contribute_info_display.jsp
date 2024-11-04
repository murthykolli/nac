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
	.reg_cb_contributed_image_dsp { height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%; overflow: auto; overflow-y: hidden; overflow-x: hidden; width: 100%; }
	.reg_cb_contributed_bott_box_htext_dsp { font: normal 1em/1.5em Georgia; color: black; letter-spacing: 2px; text-align: center; padding: 25px; text-transform: uppercase; }
    .reg_cb_contributed_name_dsp { font: normal 1.0em/1.5em Georgia; color: black; letter-spacing: 2px; text-align: center; vertical-align: middle; text-transform: uppercase; }
    .first_letter_dsp { font-size: 22px;}
	</style>	
	<script type="text/javascript">
 	$(document).ready(function() { var priceReg = /^[0-9\.]+$/;
 		$("#contRegistryButtonId").click(function () { var result = true; 		    
	 		if(priceReg.test($("#guestFundAmountId").val())){ $("#guestFundAmountId").css("border-color","black"); var guetCBCotributedNeedPrice = "<c:out value="${guestCBCotributedRemainingPrice}"/>"; var guestCBCotributedNeedPrice = guetCBCotributedNeedPrice.replace(",",""); var cbCotributedNeedPriceDb = parseFloat(guestCBCotributedNeedPrice); var cbCotributedPriceDb = parseFloat($("#guestFundAmountId").val());	 		
	 		if(cbCotributedPriceDb > cbCotributedNeedPriceDb) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds requested."); result=false; } } else{ $("#guestFundAmountId").css("border-color","red"); result=false; } return result; }); 		
 	 	$("#guestFundAmountId").keyup(function() { if(priceReg.test(this.value)){ $("#guestFundAmountId").css("border-color","black"); } else{ $("#guestFundAmountId").css("border-color","red"); result=false; } }); 	 	
 	 	$('input#guestFundAmountId').keypress(function(e) { if (this.value.length == 0 && e.which == 48 ){ return false; } }); 	 	
 	 	var regStillNeedAmount1 = "<c:out value="${guestCBCotributedRemainingPrice}"/>"; var regiStillNeedAmount = parseInt(regStillNeedAmount1);
 	 	if(regiStillNeedAmount > 0) { $("#regStillNeedAmountId").show(); } else { $("#regStillNeedAmountId").hide(); } 	 	
 	 	var words = $('#cbontributedNewNameTextId').text().split(' '); var html = '';
 	 	$.each(words, function() { html += '<span class="first_letter_dsp">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; }); $('#cbontributedNewNameTextId').html(html);
 	});
 	function numeralsOnly(evt,id) { try{ var charCode = (evt.which) ? evt.which : event.keyCode; if(charCode==46){ var txt=document.getElementById(id).value; if(!(txt.indexOf(".") > -1)){ return true; } } if (charCode > 31 && (charCode < 48 || charCode > 57) ) return false; return true; }catch(w){ alert(w); } } 	
    </script>
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">
<!-- Box display coding -->	        
		<div class="row top_adjustment_40"> <div class="col-md-2 col-sm-2"></div> <div class="col-md-8 col-sm-8 reg_guest_rbox_bord_dsp"> <div align="left">		        
		<div class="row top_adjustment_30"> <div class="col-md-4 col-sm-4"> <div class="row" align="center" style="margin-top: 0px;">
		<div><img src="${guestCBCotributedProductImage}" class="reg_cb_contributed_image_dsp"></div> </div> </div>
		<div class="col-md-4 col-sm-4 reg_guest_rsbox_red_dvd"> <div align="center" style="margin-top: 38px;" id="cbontributedNewNameTextId" class="reg_cb_contributed_name_dsp">${guestCBCotributedProductName}</div> </div>
		<div class="col-md-2 col-sm-2"> <img src="resources/images/registry/reg_guest_img/reg_gift_group_img.png" style="margin-top: 15px; margin-left: 13px;"> </div>
		<div class="col-md-2 col-sm-2"> <div class="reg_guest_gg_text_dsp">THIS IS A GROUP GIFT</div> </div> </div>
		<div class="row top_adjustment_80"> <div class="col-md-4 col-sm-4"> <div align="center" class="reg_guest_fund_rstest_dsp"><p>CONTRIBUTE ANY AMOUNT TOWARDS THE ${guestCBCotributedProductName}:</p></div> </div>
		<form action="guestConBoardContributedDataUpdate" method="POST">
		<div align="center" class="col-md-4 col-sm-4" > <table> <tr> <td><input value="$" readonly class="reg_guest_rsdoller_dsp"></td> 
		<td><input type="text" name="guestFundAmount" id="guestFundAmountId" class="reg_guest_rsinput_amount_fld_cl" onkeypress="return numeralsOnly(event,this.id);"></td> </tr> </table>
		<div class="reg_guest_st_need_amt_text" id="regStillNeedAmountId" style="display: none;">STILL NEEDS: $${guestCBCotributedRemainingPrice}</div> </div>
		<div class="col-md-4 col-sm-4"> <div class="text-center"> <h4><button class="reg_guest_cont_Butn_dspl" id="contRegistryButtonId">CONTRIBUTE</button></h4> </div> </div>
		<input type="hidden" name="guestConceptBoardContProductId" value="${guestCBCotributedProductSavingId}"> <input type="hidden" name="guestCBCotributedProductName" value="${guestCBCotributedProductName}"> <input type="hidden" name="guestCBCotributedProductImage" value="${guestCBCotributedProductImage}"> <input type="hidden" name="guestCBCotributedNeedPrice" value="${guestCBCotributedRemainingPrice}">
		</form> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_guest_rs_bott_box_dsp"> <div style="min-height: 70px;"></div>
		<!-- <div align="center" class="reg_cb_contributed_bott_box_htext_dsp"><font style="font-size: 21px;">Y</font>OUR CONTRIBUTION WILL GO TOWARDS A BEAUTIFULLY DESIGNED <br>SPACE BY ONE OF NOOK + COVE'S TALENTED DESIGNERS!</div> -->
		</div> </div> </div> </div> <div class="col-md-2 col-sm-2"></div> </div> </div> </div>		     
		</body>
</html>