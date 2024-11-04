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
	.room_fund_guest_image_dsp { height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%; overflow: auto; overflow-y: hidden; overflow-x: hidden; width: 100%; }
	.room_fund_side_hdtext_dsp { font: normal 1.0em/1.5em Georgia; color: black; letter-spacing: 2px; text-align: center; vertical-align: middle; text-transform: uppercase; }
	.first_letter_dsp { font-size: 22px; }
	.room_fund_rs_bott_box_htext_dsp { font: normal 1em/1.5em Georgia; color: black; letter-spacing: 2px; text-align: center; padding: 25px; text-transform: uppercase; }
	</style>	
	<script type="text/javascript">
 	$(document).ready(function() { var priceReg = /^[0-9]+$/; 		 		
 		$("#contGuestRegButtonId").click(function () { var result = true; 		    
	 		if(priceReg.test($("#guestFundAmountId").val())){ $("#guestFundAmountId").css("border-color","black"); var gustRoomFundNeedAmount1 = "<c:out value="${guStillNeedAmount}"/>"; var guestRoomFundNeedAmount1 = gustRoomFundNeedAmount1.replace(",",""); var guestRoomFundNeedAmountDb = parseFloat(guestRoomFundNeedAmount1); var roomFundCotributedPriceDb = parseFloat($("#guestFundAmountId").val());	 		
	 		if(roomFundCotributedPriceDb > guestRoomFundNeedAmountDb) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds requested."); result=false; } } else{ $("#guestFundAmountId").css("border-color","red"); result=false; } return result; });
 	 	$("#guestFundAmountId").keyup(function() { 	
 	 	if(priceReg.test(this.value)){ $("#guestFundAmountId").css("border-color","black"); } else{ $("#guestFundAmountId").css("border-color","red"); result=false; } }); 	 	
 	 	var gueStillNeedAmount1 = "<c:out value="${guStillNeedAmount}"/>"; var guStillNeedAmount1 = gueStillNeedAmount1.replace(",",""); var gueStillNeedAmount = parseInt(guStillNeedAmount1);
 	 	if(gueStillNeedAmount > 0) { $("#gueStillNeedAmountId").show(); } else { $("#gueStillNeedAmountId").hide(); }	 	
 	 	var words = $('#roomFundNewNameTextId').text().split(' '); var html = ''; $.each(words, function() { html += '<span class="first_letter_dsp">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; }); $('#roomFundNewNameTextId').html(html); });
 	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0)); if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }
    </script>
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">       
<!-- Box display coding -->	        
		<div class="row"> <div class="col-md-2 col-sm-2"></div> <div class="col-md-8 col-sm-8 reg_guest_rbox_bord_dsp"> <div align="left"> <div class="row top_adjustment_20"> <div class="col-md-4 col-sm-4">
		<div class="row" align="center" style="margin-top: 0px;"> <div><img src="resources/images/registry/roomandfundimages/${guestSpaceNameImg}"class="room_fund_guest_image_dsp"></div> </div> </div>
		<div class="col-md-4 col-sm-4 reg_guest_rsbox_red_dvd"> <div align="center" style="margin-top: 38px;" id="roomFundNewNameTextId" class="room_fund_side_hdtext_dsp">${guestSpaceName}</div> </div>
		<div class="col-md-2 col-sm-2"> <img src="resources/images/registry/reg_guest_img/reg_gift_group_img.png" style="margin-top: 15px; margin-left: 13px;"> </div>
		<div class="col-md-2 col-sm-2"> <div class="reg_guest_gg_text_dsp">THIS IS A GROUP GIFT</div> </div> </div>
		<div class="row top_adjustment_80"> <div class="col-md-4 col-sm-4"> <div align="center" class="reg_guest_fund_rstest_dsp"><p>CONTRIBUTE ANY AMOUNT TOWARDS THE ${guestSpaceName}:</p></div> </div>
		<form action="regSpacePriceInfoAddToCart" method="POST">
		<div align="center" class="col-md-4 col-sm-4" > <table> <tr> <td><input value="$" readonly class="reg_guest_rsdoller_dsp"></td> 
		<td><input type="text" name="guestFundAmount" id="guestFundAmountId" class="reg_guest_rsinput_amount_fld_cl" onkeypress="return numeralsOnly(event);"></td> </tr> </table>
		<div class="reg_guest_st_need_amt_text" id="gueStillNeedAmountId" style="display: none;">STILL NEEDS: $${guStillNeedAmount}</div> </div>
		<div class="col-md-4 col-sm-4"> <div class="text-left"> <h4><button class="reg_guest_cont_Butn_dspl" id="contGuestRegButtonId">CONTRIBUTE</button></h4> </div> </div>
		<input type="hidden" name="guSpaceColName" value="${guSpaceColName}"> <input type="hidden" name="guSpaceColCount" value="${guSpaceColCount}"> <input type="hidden" name="guestSpaceNameImg" value="${guestSpaceNameImg}"> <input type="hidden" name="guestSpaceName" value="${guestSpaceName}"> <input type="hidden" name="roomFundNeedPrice" value="${guStillNeedAmount}">
		</form> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_guest_rs_bott_box_dsp"> <div style="height: 70px;"></div> </div> </div> </div> </div> <div class="col-md-2 col-sm-2"></div> </div> </div> </div>		     
		</body>
</html>