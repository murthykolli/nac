
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
	<link rel="stylesheet" href="resources/css/file_upload.css" type="text/css">
	 
	<script type="text/javascript">
 	$(document).ready(function() { var customFundName1 = "<c:out value="${customFundName}"/>"; var cashFundsMessage1 = "<c:out value="${cashFundsMessage}"/>"; var cashFundsAmount1 = "<c:out value="${cashFundsAmount}"/>"; var regCustomFundError1 = "<c:out value="${regCustomFundError}"/>";
 		if(regCustomFundError1 === "Have Custom Name In DB") { alert("A fund with that name already exists. Please rename this fund."); }
 		$("[name=fundName]").val(customFundName1); $("#cashFundsAmountId").val(cashFundsAmount1); $("#cashFundsMessageId").val(cashFundsMessage1); var textFieldRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 -#/_().&amp;]*$/;
 		$("#addRegCFButtonId").click(function () { var result = true;
 		if($("#fundNameId").val() !== "") { $("#cashFundNameIdLabel").css("color","black"); } else { $("#cashFundNameIdLabel").css("color","red"); result=false; } if($("#cashFundsAmountId").val() == "" || $("#cashFundsAmountId").val() == "0") { document.regiAddGift.cashFundReqAmount.value = "2500"; } else { document.regiAddGift.cashFundReqAmount.value = $("#cashFundsAmountId").val(); } document.regiAddGift.cashFundReqMessage.value = $("#cashFundsMessageId").val(); document.regiAddGift.customFundName.value = $("#fundNameId").val(); return result; });
 	 	$("#fundNameId").keyup(function() { if(textFieldRegExp.test(this.value)){ $("#cashFundNameIdLabel").css("color","black"); } else{ $("#cashFundNameIdLabel").css("color","red"); result=false; } }); 	 	 	 	
 	 	var words = $('#cashFundNewNameTextId').text().split(' '); var html = ''; $.each(words, function() { html += '<span class="first_letter_dsp">'+this.substring(0,1)+'</span>'+this.substring(1) + ' '; }); $('#cashFundNewNameTextId').html(html);
 	 	var len = cashFundsMessage1.length; if (len >= 103) { val.value = val.value.substring(0, 100); } else { $('#decCharNum').text(100 - len); $('#incCharNum').text(0 + len); $('#rowHideId').hide(); $('#rowShowId').show(); }
		$('#cashFundMessageTextDisplayId').html(cashFundsMessage1); $("#cashFundsMessageId").on("input", function() { $("#cashFundMessageTextDisplayId").text($(this).val()); }); });
 	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0)); if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }
    function countChar(val) { var len = val.value.length; if (len >= 103) { val.value = val.value.substring(0, 100); } else { $('#decCharNum').text(100 - len); $('#incCharNum').text(0 + len); $('#rowHideId').hide(); $('#rowShowId').show(); } }; 	
    </script>
    
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">        
 <!-- ADD GIFT CARD CONTENT DISPLAY COADING START -->       
        <div class="row">		
 <!-- Left Coding Start -->        
        	<div class="col-md-4 col-sm-4 rfund_box_brdr_dsp">
        	<div align="center" class="top_adjustment_30"> <div class="cash_fund_options_head_text_butt">CASH FUND</div> </div>			
			<div align="center" class="row top_adjustment_35"> <img class="custom_fund_image_dspl" src="<c:out value='${cashFundsImgPathDsp}'/>"> </div>			
			<div id="redUploadImage" align="center" class="reg_cf_edit_img_dsp top_adjustment_10"><font class="cf_fl_edit_img_dsp">E</font>DIT&nbsp; <font class="cf_fl_edit_img_dsp">I</font>MAGE</div>			
        	<div align="left" class="cashfuns_mlmtop_adj"> <div class="reg_cash_fund_sb_text_dsp" id="cashFundNameIdLabel">FUND NAME*:</div> <div><input class="reg_cash_fund_sb_text_box" type="text" name="fundName" id="fundNameId" placeholder="CREATE A CUSTOM FUND"></div>		    	
		    <div class="reg_cash_fund_sb_text_dsp">REQUESTED AMOUNT:</div> <table> <tr> <td><input value="$" readonly class="cashfuns_inputtag_st"></td> <td><input type="text" name="cashFundsAmount" maxLength="5" placeholder="2500" id="cashFundsAmountId" onkeypress="return numeralsOnly(event);" class="cashfuns_input_txtfld_st"></td> </tr> </table>		    
		    <div class="reg_cash_fund_sb_text_dsp">NOTE FOR YOUR GUESTS <font class="reg_cash_fund_opt_text_dsp">(OPTIONAL)</font>:</div>
		    <div><textarea class="cashfuns_textarea_st" maxlength="100" name="cashFundsMessage" id="cashFundsMessageId" onkeyup="countChar(this)" placeholder="TELL YOUR GUESTS WHY YOU WANT THIS ..."></textarea></div>
		    <div id="rowShowId" class="rln_top_mesg_dspl_cl"><div class="rg_billing_bm_num_text_dis cash_fund_pdng_dspl"><font id="incCharNum"></font> / <font id="decCharNum"></font></div></div>
			<div id="rowHideId"><div class="rg_billing_bm_num_text_dis cash_fund_pdng_dspl">0/100</div></div> </div>		    	        
	        <div class="row top_adjustment_50"> <div class="col-md-3 col-sm-3" align="right"> <form action="regCustomFundBack" method="get"> <h4><input class="back_submit_Btn rfund_box_polt_dsp" type="image" title="BACK" src="resources/images/backButton.png"></h4> </form> </div>
		    <div class="col-md-9 col-sm-9"> <div class="text-left rfund_box_polet_dsp">
		    <form action="regCustomCashFundDataEditing" name="regiAddGift" method="POST">
	        <h4><button class="reg_add_con_submit_Btn_dsp" id="addRegCFButtonId">ADD TO REGISTRY</button></h4> <input type="hidden" id="customFundNameId" name="customFundName"> <input type="hidden" id="cashFundReqAmountId" name="cashFundReqAmount"> <input type="hidden" id="cashFundReqMessageId" name="cashFundReqMessage"> <input type="hidden" id="customFundOldNameId" name="customFundOldName" value="${customFundName}"> <input type="hidden" id="cashFundsImgPathDspId" name="cashFundsImgPathDsp" value="${cashFundsImgPathDsp}"> <input type="hidden" id="cashFundImagePathId" name="cashFundImagePath" value="${cashFundImagePath}"> <input type="hidden" id="regCustomFundIdId" name="regCustomFundId" value="${regCustomFundId}"> </form> </div> </div> </div> <div class="shfund_height_cl"></div> </div>        
        
 <!-- Right Coding Start -->       
        	<div class="col-md-8 col-sm-8"> <div class="row"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-1 col-sm-1"> <div align="left" class="right_adjustment_13"><img src="resources/images/registry/reg_guest_img/reg_guest_see_img.png"></div> </div>
		    <div class="col-md-9 col-sm-9"> <div align="left"><p class="regi_guest_see_text_dsp left_adjustment_10">WHAT GUESTS SEE</p></div> </div> <div class="col-md-1 col-sm-1"></div> </div>
	        
<!-- Box display coding -->	        
		    <div class="row top_adjustment_20"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10 reg_guest_rbox_bord_dsp"> <div align="left"> <div class="row top_adjustment_30">
			<div class="col-md-4 col-sm-4"> <div class="row" align="center" style="margin-top: 0px;"> <div><img src="<c:out value='${cashFundsImgPathDsp}'/>"class="custm_fund_guest_image_dspl"></div> </div> </div>
			<div class="col-md-4 col-sm-4 reg_guest_rsbox_red_dvd"> <div align="center" id="cashFundNewNameTextId" class="cash_fund_side_hdtext_dsp top_adjustment_27">${customFundName}</div> </div>				        		        
			<div class="col-md-2 col-sm-2"> <img src="resources/images/registry/reg_guest_img/reg_gift_group_img.png" class="rfund_mgtpml_pl_dsp"> </div>
			<div class="col-md-2 col-sm-2"> <div class="reg_guest_gg_text_dsp">THIS IS A GROUP GIFT</div> </div> </div>			        
			<div class="row top_adjustment_80"> <div class="col-md-4 col-sm-4"> <div align="center" class="reg_guest_fund_rstest_dsp">CONTRIBUTE ANY <br>AMOUNT TOWARDS <br>THIS FUND:</div> </div>
			<div align="center" class="col-md-4 col-sm-4" > <table> <tr> <td><input value="$" readonly class="reg_guest_rsdoller_dsp"></td>  <td><input value="" readonly name="gustFundAmount" class="reg_guest_rsinput_amount_fld"></td> </tr> </table> </div>
			<div class="col-md-4 col-sm-4"> <div class="text-center"> <h4><button class="reg_add_cont_submit_Btn_dspl" id="contRegistryButtonId">CONTRIBUTE</button></h4> </div> </div> </div>
			<div class="row"> <div class="col-md-12 col-sm-12 reg_guest_rs_bott_box_dsp"> <div align="center" class="cash_fund_gs_bott_box_htext_dsp rfund_height_dsp_cl"><font id="cashFundMessageTextDisplayId"></font></div> </div> </div> </div> </div> <div class="col-md-1 col-sm-1"></div> </div> </div> </div> </div></div>		
		
		<div id="boxes"> <div class="rln_popup_frame_dsp" id="mask"></div>        
        <div align="center" style="padding: 20px; display: none;  width: 760px; z-index: 10001; overflow-y: hidden; position:fixed; left: 50%; top: 50%; -ms-transform: translate(-50%,-50%); -moz-transform:translate(-50%,-50%); -webkit-transform: translate(-50%,-50%); transform: translate(-50%,-50%);" id="dialog" class="window">
    	<div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" class="rln_pop_cl_img_adj"></a></div>    
		<div id="lorem" class="rln_pop_pad_adj">
		<div class="rln_pop_uplph_txt_cl">Upload Cash Fund Image</div><br>
		<form action="landingEditImageUploadCustomFund" method="POST" enctype="multipart/form-data">
		<table class="rln_pop_table_frm_adj">
		<tbody><tr><td><input type="file" onchange="readURL(event)" name="regPhotoUpload" id="fileUpload" title="Click here to browse your photo." class="rln_pop_table_bgc_cl"></td></tr>
		<tr class="custmfund_popup_height"><td></td></tr>
		<tr><td>You can upload a JPG, GIF, or PNG file.</td></tr>
		<tr class="rln_pop_tr_heightvs_cl"><td></td></tr>
		<tr><td>This image can be seen by any guest on our website viewing or searching for your registry.</td></tr>
		<tr class="rln_pop_tr_heightvs_cl"><td></td></tr>
		<tr><td><input type="checkbox" name="accept" id="accept"> <div class="rln_pop_mlt_txt_cl">I own the image I am uploading and confirm that this image compiles with the NOOK + COVE Upload Terms of Use.</div></td></tr>
		<tr class="shfund_height_cl"><td></td></tr>
		<tr><td><button class="continue_submit_Btn_for_regy" id="photoUploadBut">UPLOAD</button></td></tr>
		<tr class="rln_pop_tr_heights_cl"><td></td></tr>
		</tbody></table>
		<input type="hidden" id="regCustomFundIdId" name="regCustomFundId" value="${regCustomFundId}">
		</form> </div> </div> </div>		
		
		<script type="text/javascript" src="resources/js/file_upload.js"></script>
		
		</body>
</html>