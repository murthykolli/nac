
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
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="resources/css/registry_css/registry_landing.css" type="text/css">
	  
	<script type="text/javascript">
 	$(document).ready(function(){		
 		$("#regDecCount").click(function () { var regCountVal = $("#regCountValId").val(); regCountVal = parseInt(regCountVal);
 		if(regCountVal > 1) { var reqAmtId = "requestedAmountId" + regCountVal; var reqAmtValId = "requestedAmount" + regCountVal; $("#"+reqAmtId).hide(); $("#"+reqAmtValId).val(""); totVal = regCountVal - 1; $("#regCountValId").val(totVal); } }); 		
 		$("#regIncCount").click(function () { var regCountVal = $("#regCountValId").val(); regCountVal = parseInt(regCountVal);
 	 	if(regCountVal < 5) { totVal = regCountVal + 1; $("#regCountValId").val(totVal); var reqAmtId = "requestedAmountId" + totVal; $("#"+reqAmtId).show(); } }); 		
 		var selectedRFCountAndAmount = "<c:out value="${selSpaceCountAndAmount}"/>";
 		if(selectedRFCountAndAmount !== "") { var separateRFCountAndAmount = selectedRFCountAndAmount.split("__");
 			for (var i = 0; i < separateRFCountAndAmount.length; i++) { var separateRFColumnValues = separateRFCountAndAmount[i].split("_,_"); $("#requestedAmount"+(i+1)).val(separateRFColumnValues[1]); $("#requestedAmountId"+(i+1)).show(); } $("#regCountValId").val(parseInt(separateRFCountAndAmount.length));
 		} else { $("#regCountValId").val(1); } 		
 		$("#addRegistryButtonId").click(function () { var requestedAmount1 = $("#requestedAmount1").val(); var requestedAmount2 = $("#requestedAmount2").val(); var requestedAmount3 = $("#requestedAmount3").val(); var requestedAmount4 = $("#requestedAmount4").val(); var requestedAmount5 = $("#requestedAmount5").val();
 		if(requestedAmount1 == "" || requestedAmount1 == "0") { requestedAmount1 = "2500"; }
 		if(requestedAmount2 == "" || requestedAmount2 == "0") { requestedAmount2 = "2500"; }
 		if(requestedAmount3 == "" || requestedAmount3 == "0") { requestedAmount3 = "2500"; }
 		if(requestedAmount4 == "" || requestedAmount4 == "0") { requestedAmount4 = "2500"; }
 		if(requestedAmount5 == "" || requestedAmount5 == "0") { requestedAmount5 = "2500"; } 			
 		if($("#regCountValId").val() == 1) { var combVal = "1" + "_,_" + requestedAmount1; document.regiAddGift.selSpaceCountAndAmount.value = combVal;
 		} else if($("#regCountValId").val() == 2) { var combVal = "1" + "_,_" + requestedAmount1 + "__" + "2" + "_,_" + requestedAmount2; document.regiAddGift.selSpaceCountAndAmount.value = combVal;
 		} else if($("#regCountValId").val() == 3) { var combVal = "1" + "_,_" + requestedAmount1 + "__" + "2" + "_,_" + requestedAmount2 + "__" + "3" + "_,_" + requestedAmount3; document.regiAddGift.selSpaceCountAndAmount.value = combVal;
 		} else if($("#regCountValId").val() == 4) { var combVal = "1" + "_,_" + requestedAmount1 + "__" + "2" + "_,_" + requestedAmount2 + "__" + "3" + "_,_" + requestedAmount3 + "__" + "4" + "_,_" + requestedAmount4; document.regiAddGift.selSpaceCountAndAmount.value = combVal;
 		} else if($("#regCountValId").val() == 5) { var combVal = "1" + "_,_" + requestedAmount1 + "__" + "2" + "_,_" + requestedAmount2 + "__" + "3" + "_,_" + requestedAmount3 + "__" + "4" + "_,_" + requestedAmount4 + "__" + "5" + "_,_" + requestedAmount5; document.regiAddGift.selSpaceCountAndAmount.value = combVal; } });

 	 	var words = $('#roomFundNewNameTextId').text().split(' '); var html = '';
 	 	$.each(words, function() { html += '<span class="first_letter_dsp">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; }); $('#roomFundNewNameTextId').html(html); });
 	
 	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0));
 		if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }
    </script>
    
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">        
 <!-- ADD GIFT CARD CONTENT DISPLAY COADING START -->
        <div class="row">		
 <!-- Left Coding Start -->        
        <div class="col-md-4 col-sm-4 rfund_brdrt_dsp_cl"> <div align="center" class="top_adjustment_30"> <div class="ad_options_head_text_butt">${titleOfTheRoomFund}</div> </div>
        <div class="row top_adjustment_50"> <div class="col-md-3 col-sm-3"></div> <div class="col-md-2 col-sm-2"> <div align="left" class="reg_operator_text_disp" id="regDecCount">-</div> </div>
		<div class="col-md-2 col-sm-2" align="center"> <input class="reg_operator_value_box_disp" id="regCountValId" type="text" readonly value="" name="regCount"/> </div>
		<div class="col-md-2 col-sm-2"> <div align="center" class="reg_operator_text_disp" id="regIncCount">+</div> </div> <div class="col-md-3 col-sm-3"></div> </div>	        	        
	    <div class="row top_adjustment_10"> <div class="col-md-12 col-sm-12" align="center"> <div class="reg_all_gstrooms_sb_text_dsp">REQUESTED AMOUNT 1:</div>
		<table> <tr> <td><input value="$" readonly class="reg_all_gstrooms_lsdoller_text"></td> <td><input type="text" name="requestedAmount1" maxLength="5" id="requestedAmount1" placeholder="2500" class="reg_all_gstrooms_lsinput_text" onkeypress="return numeralsOnly(event);"></td> </tr> </table> </div> </div>
		<div class="row top_adjustment_10 rln_top_mesg_dspl_cl" id="requestedAmountId2"> <div class="col-md-12 col-sm-12" align="center"> <div class="reg_all_gstrooms_sb_text_dsp">REQUESTED AMOUNT 2:</div> 
		<table> <tr> <td><input value="$" readonly class="reg_all_gstrooms_lsdoller_text"></td> <td><input type="text" name="requestedAmount2" maxLength="5" id="requestedAmount2" placeholder="2500" class="reg_all_gstrooms_lsinput_text" onkeypress="return numeralsOnly(event);"></td> </tr> </table> </div> </div>
		<div class="row top_adjustment_10 rln_top_mesg_dspl_cl" id="requestedAmountId3"> <div class="col-md-12 col-sm-12" align="center"> <div class="reg_all_gstrooms_sb_text_dsp">REQUESTED AMOUNT 3:</div>
		<table> <tr> <td><input value="$" readonly class="reg_all_gstrooms_lsdoller_text"></td> <td><input type="text" name="requestedAmount3" maxLength="5" id="requestedAmount3" placeholder="2500" class="reg_all_gstrooms_lsinput_text" onkeypress="return numeralsOnly(event);"></td> </tr> </table> </div> </div>
		<div class="row top_adjustment_10 rln_top_mesg_dspl_cl" id="requestedAmountId4"> <div class="col-md-12 col-sm-12" align="center"> <div class="reg_all_gstrooms_sb_text_dsp">REQUESTED AMOUNT 4:</div>
		<table> <tr> <td><input value="$" readonly class="reg_all_gstrooms_lsdoller_text"></td> <td><input type="text" name="requestedAmount4" maxLength="5" id="requestedAmount4" placeholder="2500" class="reg_all_gstrooms_lsinput_text" onkeypress="return numeralsOnly(event);"></td> </tr> </table> </div> </div>
		<div class="row top_adjustment_10 rln_top_mesg_dspl_cl" id="requestedAmountId5"> <div class="col-md-12 col-sm-12" align="center"> <div class="reg_all_gstrooms_sb_text_dsp">REQUESTED AMOUNT 5:</div>
		<table> <tr> <td><input value="$" readonly class="reg_all_gstrooms_lsdoller_text"></td> <td><input type="text" name="requestedAmount5" maxLength="5" id="requestedAmount5" placeholder="2500" class="reg_all_gstrooms_lsinput_text" onkeypress="return numeralsOnly(event);"></td> </tr> </table> </div> </div>
	    
	    <div class="row top_adjustment_50"> <div class="col-md-3 col-sm-3" align="right">
		<form action="regSpaceBackMove" method="get"> <h4><input class="back_submit_Btn rfund_box_polt_dsp" type="image" title="BACK" src="resources/images/backButton.png"></h4> </form> </div>
		<div class="col-md-9 col-sm-9"> <div class="text-left rfund_box_polet_dsp">
		<form action="registryRoomFoundInfoSaving" name="regiAddGift" method="POST">
	    <h4><button class="reg_add_con_submit_Btn_dsp" id="addRegistryButtonId">ADD TO REGISTRY</button></h4> <input type="hidden" id="selSpaceCountAndAmountId" name="selSpaceCountAndAmount"> <input type="hidden" id="nameOfTheRoomFundId" name="nameOfTheRoomFund" value="${nameOfTheRoomFund}">
	    </form> </div> </div> </div> <div class="rfund_heightmore_dsp_cl"></div> </div>        
        
 <!-- Right Coding Start -->       
        <div class="col-md-8 col-sm-8"> <div class="row"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-1 col-sm-1"> <div align="left" class="right_adjustment_13"><img src="resources/images/registry/reg_guest_img/reg_guest_see_img.png"></div> </div>
		<div class="col-md-9 col-sm-9"> <div align="left"><p class="regi_guest_see_text_dsp left_adjustment_10">WHAT GUESTS SEE</p></div> </div> <div class="col-md-1 col-sm-1"></div> </div>
	        
<!-- Box display coding -->	        
		<div class="row top_adjustment_20 rfund_blpdb_pl_dsp"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10 reg_guest_rbox_bord_dsp"> <div align="left"> <div class="row top_adjustment_30">
		<div class="col-md-4 col-sm-4"> <div class="row" align="center" style="margin-top: 0px;"> <div><img src="resources/images/registry/roomandfundimages/${imageOfTheRoomFund}" class="room_fund_guest_image_dsp"></div> </div> </div>
		<div class="col-md-4 col-sm-4 reg_guest_rsbox_red_dvd"> <div align="center" id="roomFundNewNameTextId" class="room_fund_side_hdtext_dsp top_adjustment_30">${nameOfTheRoomFund}</div> </div>				        		        
		<div class="col-md-2 col-sm-2"> <img src="resources/images/registry/reg_guest_img/reg_gift_group_img.png" class="rfund_mgtpml_pl_dsp"> </div>
		<div class="col-md-2 col-sm-2"> <div class="reg_guest_gg_text_dsp">THIS IS A GROUP GIFT</div> </div> </div>
		<div class="row top_adjustment_80"> <div class="col-md-4 col-sm-4"> <div align="center" class="reg_guest_fund_rstest_dsp"><p>CONTRIBUTE ANY AMOUNT TOWARDS THE ${nameOfTheRoomFund}:</p></div> </div> <div align="center" class="col-md-4 col-sm-4" >						
		<table> <tr> <td><input value="$" readonly class="reg_guest_rsdoller_dsp"></td> <td><input value="" readonly name="fundAmount" class="reg_guest_rsinput_amount_fld"></td> </tr> </table> </div>
		<div class="col-md-4 col-sm-4"> <div class="text-center"> <h4><button class="reg_add_cont_submit_Btn_dspl" id="contRegistryButtonId">CONTRIBUTE</button></h4> </div> </div> </div>
		<div class="row"> <div class="col-md-12 col-sm-12 reg_guest_rs_bott_box_dsp"> <div class="rfund_height_dsp_cl"></div> </div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div> </div> </div> </div></div>		
		</body>
</html>