
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
 	$(document).ready(function() { var cashFundName1 = "<c:out value="${cashFundName}"/>";
 		$("#addRegCFButtonId").click(function () { var result = true; if(cashFundName1 == "Romantic Dinner" || cashFundName1 == "Wine Tasting") {
	 	 	if($("#cashFundsAmount1Id").val() == "" || $("#cashFundsAmount1Id").val() == 0) { document.regiAddGift.cashFundReqAmount.value = "200"; } else { document.regiAddGift.cashFundReqAmount.value = $("#cashFundsAmount1Id").val(); }
 	 		} else if(cashFundName1 == "Couples Spa Day" || cashFundName1 == "Sunset Sail") { if($("#cashFundsAmount2Id").val() == "" || $("#cashFundsAmount2Id").val() == 0) { document.regiAddGift.cashFundReqAmount.value = "500"; } else { document.regiAddGift.cashFundReqAmount.value = $("#cashFundsAmount2Id").val(); }
 	 		} else { if($("#cashFundsAmount3Id").val() == "" || $("#cashFundsAmount3Id").val() == 0) { document.regiAddGift.cashFundReqAmount.value = "2500"; } else { document.regiAddGift.cashFundReqAmount.value = $("#cashFundsAmount3Id").val(); } } document.regiAddGift.cashFundReqMessage.value = $("#cashFundsMessageId").val(); return result;
 		}); 		
 		if(cashFundName1 == "Romantic Dinner" || cashFundName1 == "Wine Tasting") { $('#firstFieldsDisplayId').show(); $('#secondFieldsDisplayId').hide(); $('#thiredFieldsDisplayId').hide();
		} else if(cashFundName1 == "Couples Spa Day" || cashFundName1 == "Sunset Sail") { $('#firstFieldsDisplayId').hide(); $('#secondFieldsDisplayId').show(); $('#thiredFieldsDisplayId').hide();
		} else { $('#firstFieldsDisplayId').hide(); $('#secondFieldsDisplayId').hide(); $('#thiredFieldsDisplayId').show(); } 		
 	 	var words = $('#cashFundNameBigId').text().split(' '); var html = '';
 	 	$.each(words, function() { html += '<span class="cash_fund_big_name">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; }); $('#cashFundNameBigId').html(html); var words = $('#cashFundNameSmlId').text().split(' '); var html = '';
 	 	$.each(words, function() { html += '<span class="cash_fund_sml_name">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; }); $('#cashFundNameSmlId').html(html); $("#cashFundsMessageId").on("input", function(){ $("#cashFundMessageTextDisplayId").text($(this).val()); }); 
 	});
 	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0)); if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }    
    function countChar(val) { var len = val.value.length; if (len >= 103) { val.value = val.value.substring(0, 100); } else { $('#decCharNum').text(100 - len); $('#incCharNum').text(0 + len); $('#rowHideId').hide(); $('#rowShowId').show(); } };    
    </script>
    
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">        
 <!-- ADD GIFT CARD CONTENT DISPLAY COADING START -->       
        <div class="row">
 <!-- Left Coding Start -->        
        <div class="col-md-4 col-sm-4 rfund_box_brdr_dsp"> <div align="center" class="top_adjustment_30"> <div class="cash_fund_options_head_text_butt">CASH FUND</div> </div>
		<div align="center" class="row top_adjustment_35"> <img class="cash_fund_image_dsp" src="<c:out value='${cashFundsImgPathDsp}'/>"> </div> <div align="center" id="cashFundNameBigId" class="cash_fund_hdtext_dsp top_adjustment_30">${cashFundName}</div> <div align="left" class="cashfuns_mlmtop_adj"> <div class="reg_cash_fund_sb_text_dsp">REQUESTED AMOUNT:</div>
		<table class="rln_top_mesg_dspl_cl" id="firstFieldsDisplayId"> <tr> <td><input value="$" readonly class="cashfuns_inputtag_st"></td> <td><input type="text" name="cashFundsAmount" maxLength="5" placeholder="200" onkeypress="return numeralsOnly(event);" id="cashFundsAmount1Id" class="cashfuns_input_txtfld_st"></td> </tr> </table>
		<table class="rln_top_mesg_dspl_cl" id="secondFieldsDisplayId"> <tr> <td><input value="$" readonly class="cashfuns_inputtag_st"></td> <td><input type="text" name="cashFundsAmount" maxLength="5" placeholder="500" onkeypress="return numeralsOnly(event);" id="cashFundsAmount2Id" class="cashfuns_input_txtfld_st"></td> </tr> </table>
		<table class="rln_top_mesg_dspl_cl" id="thiredFieldsDisplayId"> <tr> <td><input value="$" readonly class="cashfuns_inputtag_st"></td> <td><input type="text" name="cashFundsAmount" maxLength="5" placeholder="2500" onkeypress="return numeralsOnly(event);" id="cashFundsAmount3Id" class="cashfuns_input_txtfld_st"></td> </tr> </table>
		<div class="reg_cash_fund_sb_text_dsp">NOTE FOR YOUR GUESTS <font class="reg_cash_fund_opt_text_dsp">(OPTIONAL)</font>:</div> <div><textarea class="cashfuns_textarea_st" maxlength="100" name="cashFundsMessage" id="cashFundsMessageId" onkeyup="countChar(this)" placeholder="TELL YOUR GUESTS WHY YOU WANT THIS ..."></textarea></div>
		<div id="rowShowId" class="rln_top_mesg_dspl_cl"><div class="rg_billing_bm_num_text_dis cash_fund_pdng_dspl"><font id="incCharNum"></font> / <font id="decCharNum"></font></div></div> <div id="rowHideId"><div class="rg_billing_bm_num_text_dis cash_fund_pdng_dspl">0/100</div></div> </div>
		<div class="row top_adjustment_50"> <div class="col-md-3 col-sm-3" align="right"> 
		<form action="createCashFunds" method="get"> <h4><input class="back_submit_Btn rfund_box_polt_dsp" type="image" title="BACK" src="resources/images/backButton.png"></h4> </form> </div>
		<div class="col-md-9 col-sm-9"> <div class="text-left rfund_box_polet_dsp">
		<form action="regTopCashFundsInfoSaving" name="regiAddGift" method="get"> <h4><button class="reg_add_con_submit_Btn_dsp" id="addRegCFButtonId">ADD TO REGISTRY</button></h4> <input type="hidden" id="cashFundNameId" name="cashFundsName" value="${cashFundName}"> <input type="hidden" id="cashFundReqAmountId" name="cashFundReqAmount"> <input type="hidden" id="cashFundReqMessageId" name="cashFundReqMessage"> <input type="hidden" id="cashFundsImageNameId" name="cashFundsImageName" value="${cashFundsImagePath}"> </form> </div> </div> </div>
        <div class="shfund_height_cl"></div> </div>        
        
 <!-- Right Coding Start -->       
        <div class="col-md-8 col-sm-8"> <div class="row"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-1 col-sm-1"> <div align="left" class="right_adjustment_13"><img src="resources/images/registry/reg_guest_img/reg_guest_see_img.png"></div> </div>
		<div class="col-md-9 col-sm-9"> <div align="left"><p class="regi_guest_see_text_dsp left_adjustment_10">WHAT GUESTS SEE</p></div> </div> <div class="col-md-1 col-sm-1"></div> </div>
	        
<!-- Box display coding -->	        
		    <div class="row top_adjustment_20"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10 reg_guest_rbox_bord_dsp"> <div align="left">		        
			<div class="row top_adjustment_30"> <div class="col-md-4 col-sm-4"> <div class="row" align="center" style="margin-top: 0px;"> <div><img src="<c:out value='${cashFundsImgPathDsp}'/>" height="100" width="100"></div> </div> </div> <div class="col-md-4 col-sm-4 reg_guest_rsbox_red_dvd"> <div align="center" id="cashFundNameSmlId" class="cash_fund_side_hdtext_dsp top_adjustment_38">${cashFundName}</div> </div>		        
			<div class="col-md-2 col-sm-2"> <img src="resources/images/registry/reg_guest_img/reg_gift_group_img.png" class="rfund_mgtpml_pl_dsp"> </div> <div class="col-md-2 col-sm-2"> <div class="reg_guest_gg_text_dsp">THIS IS A GROUP GIFT</div> </div> </div>
			<div class="row top_adjustment_80"> <div class="col-md-4 col-sm-4"> <div align="center" class="reg_guest_fund_rstest_dsp">CONTRIBUTE ANY <br>AMOUNT TOWARDS <br>THIS FUND:</div> </div> <div align="center" class="col-md-4 col-sm-4" > 
			<table> <tr> <td><input value="$" readonly class="reg_guest_rsdoller_dsp"></td> <td><input value="" readonly name="gustFundAmount" class="reg_guest_rsinput_amount_fld"></td> </tr> </table> </div>
			<div class="col-md-4 col-sm-4"> <div class="text-center"> <h4><button class="reg_add_cont_submit_Btn_dspl" id="contRegistryButtonId">CONTRIBUTE</button></h4> </div> </div> </div>
			<div class="row"> <div class="col-md-12 col-sm-12 reg_guest_rs_bott_box_dsp"> <div align="center" class="cash_fund_gs_bott_box_htext_dsp rfund_height_dsp_cl"><font id="cashFundMessageTextDisplayId"></font></div> </div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div> </div> </div> </div></div>			
		</body>
</html>