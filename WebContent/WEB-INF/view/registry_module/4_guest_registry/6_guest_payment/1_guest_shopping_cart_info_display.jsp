<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
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
	.guest_cart_doller_edit_dsp { border: 1px solid white; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; text-align: right; color: black; }
	.guest_cart_price_edit_dsp { border: 1px solid white; font: bold 1em/1.25em Georgia; height: 26px; width: 90px; margin-left: 0px; color: black; letter-spacing: 1px; text-align: left; padding-left: 5px; }
	.guest_cart_price_save_dsp { border: 1px solid black; font: bold 1em/1.25em Georgia; height: 26px; width: 90px; margin-left: 0px; color: black; letter-spacing: 1px; text-align: left; padding-left: 5px; }
	.guest_cart_price_con_cur_edit_dsp { border: 1px solid white; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; margin-left: 0px; color: #595959; letter-spacing: 1px; text-align: center; }
	.guest_cart_price_con_cur_save_dsp { border: 1px solid black; font: bold 1em/1.25em Georgia; height: 26px; width: 26px; margin-left: 0px; color: black; letter-spacing: 1px; text-align: center; }
	</style>
	<script type="text/javascript"> window.location.hash=""; window.location.hash=""; window.onhashchange=function(){window.location.hash="";}; window.onload=function(){ window.history.forward(1); }; </script>    
	<script type="text/javascript">	
 	$(document).ready(function() { 		
		$("a#sendReqToSpaceId").click(function() { $("#editRegSubmitId").submit(); }); var cashFundDisplay = "<c:out value="${cashFundValueInSn}"/>";
 		if(cashFundDisplay !== "") { $("#cashFundDisplayId").show(); } else { $("#cashFundDisplayId").hide(); } 		
 		$("#cashFundEditButtDspId").click(function() { $("#cashFundSaveDivDspId").show(); $("#cashFundEditDivDspId").hide(); });
 		$("#cashFundSaveButtDspId").click(function() { var guestCashFundNewPrice = $("#gustCashFundNewPriceId").val(); var guestsCashFundNewPrice = 0;
 			if(guestCashFundNewPrice !== "") { guestsCashFundNewPrice = parseInt(guestCashFundNewPrice); }
 			if(guestsCashFundNewPrice < 1) { alert("Please enter valid amount"); return false; } }); }); 		
/* Concept Boards Contributed Coding */	 
	function cbContributedEditButtonDisplay(count) { $("#cbContributedSaveDivDspId"+count).show(); $("#cbContributedEditDivDspId"+count).hide(); return false; }
 	function cbContributedSaveButtonDisplay(count, cbContributedPaymentSavingId, cbContributedNeedPrice) { var regNewContributedPriceVal = $("#guestCBContributedPrice"+count).val(); var regNewContributedOldPriceVal = $("#guestCBContributedOldPrice"+count).val(); var regNewContributedPriceValue = 0;
 		if(regNewContributedPriceVal !== "") { regNewContributedPriceValue = parseFloat(regNewContributedPriceVal); } var cbContributedNeedPriceValue = parseFloat(cbContributedNeedPrice);
		if(regNewContributedPriceValue > 0) { if(regNewContributedPriceValue > cbContributedNeedPriceValue) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds( " + cbContributedNeedPriceValue +") requested."); result=false;
	 	} else { var totalContributedInfoValue = cbContributedPaymentSavingId + "__" + regNewContributedPriceVal + "__" + regNewContributedOldPriceVal; newAjaxCallForCBContributedInfoUpdate(totalContributedInfoValue); } } else { alert("Please enter valid amount"); return false; } }
	function newAjaxCallForCBContributedInfoUpdate(totalContributedInfoValue) { 
		$.ajax({ type : 'POST', url : "jSonAddCartGuestCBContributedValueUpdate?cbContributedInfoValue="+totalContributedInfoValue, dataType : 'json', async : true, cache: false,
 			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#contributedCBDivId").load(location.href + " #contributedCBDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); }    	
 	    }); }
/* Concept Boards Individual Coding */ 		 
	function cbIndividualEditButtonDisplay(count) { $("#cbIndividualSaveDivDspId"+count).show(); $("#cbIndividualEditDivDspId"+count).hide(); return false; }
 	function cbIndividualSaveButtonDisplay(count, cbIndividualPaymentSavingId, cbIndividualNeedQuantity) { var regNewIndividualQuantityVal = $("#guestCBIndividualQuantityId"+count).val(); var regOldIndividualQuantityVal = $("#guestCBIndividualOldQuantityId"+count).val(); var regOldIndividualPriceVal = $("#guestCBIndividualOldPriceId"+count).val(); var regNewIndividualQuantityValue = 0;
 	if(regNewIndividualQuantityVal !== "") { regNewIndividualQuantityValue = parseInt(regNewIndividualQuantityVal); } var cbIndividualNeedQuantityValue = parseFloat(cbIndividualNeedQuantity);  		
  	if(regNewIndividualQuantityValue > 0) { if(regNewIndividualQuantityValue > cbIndividualNeedQuantityValue) { alert("Please make sure the quantity that you wish to gift is equivalent to or less than the quantity( " + cbIndividualNeedQuantityValue +") requested."); result=false; } else { var totalIndividualInfoValue = cbIndividualPaymentSavingId + "__" + regNewIndividualQuantityVal + "__" + regOldIndividualQuantityVal + "__" + regOldIndividualPriceVal; newAjaxCallForCBIndividualInfoUpdate(totalIndividualInfoValue); }
  	} else { alert("Please enter valid quantity"); return false; } }

 	function newAjaxCallForCBIndividualInfoUpdate(totalIndividualInfoValue) { 
 	  	$.ajax({ type : 'POST', url : "jSonAddCartGuestCBIndividualValueUpdate?cbIndividualInfoValue="+totalIndividualInfoValue, dataType : 'json', async : true, cache: false,
 	  	  	success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#individualCBDivId").load(location.href + " #individualCBDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); }    	
 		}); }	
/* Concept Boards Contributed Delete Coding */ 		 
	function selectedCBContributedInfoDelete(cbContributedPaymentSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?"); if (confMessageVar == true) { newAjaxCallForCBContributedInfoDelete(cbContributedPaymentSavingId); } else { return false; } }
 	function newAjaxCallForCBContributedInfoDelete(cbContributedPaymentSavingId) { $.ajax({ type : 'POST', url : "jSonGuestCBContributedInfoDelete?regCBContributedPaymentSavingId="+cbContributedPaymentSavingId, dataType : 'json', async : true, cache: false,
 			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
 				if(cartCount > 0) { $("#contributedCBDivId").load(location.href + " #contributedCBDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); } else { window.location = 'guestRegistryMyAccount'; }				
 			} }); }	
/* Concept Boards Individual Delete Coding */ 		
 	function selectedCBIndividualInfoDelete(cbIndividualPaymentSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?"); if (confMessageVar == true) { newAjaxCallForCBIndividualInfoDelete(cbIndividualPaymentSavingId); } else { return false; } }
 	function newAjaxCallForCBIndividualInfoDelete(cbIndividualPaymentSavingId) { 
 	   	$.ajax({ type : 'POST', url : "jSonGuestCBIndividualInfoDelete?regCBIndividualPaymentSavingId="+cbIndividualPaymentSavingId, dataType : 'json', async : true, cache: false,
 			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
 				if(cartCount > 0) { $("#individualCBDivId").load(location.href + " #individualCBDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); } else { window.location = 'guestRegistryMyAccount'; }				
 			} }); }
 	
/* Finishing Touches Contributed Coding */	 
	function ftContributedEditButtonDisplay(count) { $("#ftContributedSaveDivDspId"+count).show(); $("#ftContributedEditDivDspId"+count).hide(); return false; }
 	function ftContributedSaveButtonDisplay(count, ftContributedPaymentSavingId, ftContributedNeedPrice) { var regNewContributedPriceVal = $("#guestFTContributedPrice"+count).val(); var regNewContributedOldPriceVal = $("#guestFTContributedOldPrice"+count).val(); var regNewContributedPriceValue = 0;
 		if(regNewContributedPriceVal !== "") { regNewContributedPriceValue = parseFloat(regNewContributedPriceVal); } var ftContributedNeedPriceValue = parseFloat(ftContributedNeedPrice);
		if(regNewContributedPriceValue > 0) { if(regNewContributedPriceValue > ftContributedNeedPriceValue) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds( " + ftContributedNeedPriceValue +") requested."); result=false;
	 	} else { var totalContributedInfoValue = ftContributedPaymentSavingId + "__" + regNewContributedPriceVal + "__" + regNewContributedOldPriceVal; newAjaxCallForFTContributedInfoUpdate(totalContributedInfoValue); } } else { alert("Please enter valid amount"); return false; } }
	function newAjaxCallForFTContributedInfoUpdate(totalContributedInfoValue) { 
		$.ajax({ type : 'POST', url : "jSonAddCartGuestFTContributedValueUpdate?ftContributedInfoValue="+totalContributedInfoValue, dataType : 'json', async : true, cache: false,
 			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#contributedFTDivId").load(location.href + " #contributedFTDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); }    	
 	    }); }
/* Finishing Touches Individual Coding */ 		 
	function ftIndividualEditButtonDisplay(count) { $("#ftIndividualSaveDivDspId"+count).show(); $("#ftIndividualEditDivDspId"+count).hide(); return false; }
 	function ftIndividualSaveButtonDisplay(count, ftIndividualPaymentSavingId, ftIndividualNeedQuantity) { var regNewIndividualQuantityVal = $("#guestFTIndividualQuantityId"+count).val(); var regOldIndividualQuantityVal = $("#guestFTIndividualOldQuantityId"+count).val(); var regOldIndividualPriceVal = $("#guestFTIndividualOldPriceId"+count).val(); var regNewIndividualQuantityValue = 0;
 	if(regNewIndividualQuantityVal !== "") { regNewIndividualQuantityValue = parseInt(regNewIndividualQuantityVal); } var ftIndividualNeedQuantityValue = parseFloat(ftIndividualNeedQuantity);  		
  	if(regNewIndividualQuantityValue > 0) { if(regNewIndividualQuantityValue > ftIndividualNeedQuantityValue) { alert("Please make sure the quantity that you wish to gift is equivalent to or less than the quantity( " + ftIndividualNeedQuantityValue +") requested."); result=false; } else { var totalIndividualInfoValue = ftIndividualPaymentSavingId + "__" + regNewIndividualQuantityVal + "__" + regOldIndividualQuantityVal + "__" + regOldIndividualPriceVal; newAjaxCallForFTIndividualInfoUpdate(totalIndividualInfoValue); }
  	} else { alert("Please enter valid quantity"); return false; } }

 	function newAjaxCallForFTIndividualInfoUpdate(totalIndividualInfoValue) { 
 	  	$.ajax({ type : 'POST', url : "jSonAddCartGuestFTIndividualValueUpdate?ftIndividualInfoValue="+totalIndividualInfoValue, dataType : 'json', async : true, cache: false,
 	  	  	success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#individualFTDivId").load(location.href + " #individualFTDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); }    	
 		}); }	
/* Finishing Touches Contributed Delete Coding */ 		 
	function selectedFTContributedInfoDelete(ftContributedPaymentSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?"); if (confMessageVar == true) { newAjaxCallForFTContributedInfoDelete(ftContributedPaymentSavingId); } else { return false; } }
 	function newAjaxCallForFTContributedInfoDelete(ftContributedPaymentSavingId) { $.ajax({ type : 'POST', url : "jSonGuestFTContributedInfoDelete?regFTContributedPaymentSavingId="+ftContributedPaymentSavingId, dataType : 'json', async : true, cache: false,
 			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
 				if(cartCount > 0) { $("#contributedFTDivId").load(location.href + " #contributedFTDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); } else { window.location = 'guestRegistryMyAccount'; }				
 			} }); }	
/* Finishing Touches Individual Delete Coding */ 		
 	function selectedFTIndividualInfoDelete(ftIndividualPaymentSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?"); if (confMessageVar == true) { newAjaxCallForFTIndividualInfoDelete(ftIndividualPaymentSavingId); } else { return false; } }
 	function newAjaxCallForFTIndividualInfoDelete(ftIndividualPaymentSavingId) { 
 	   	$.ajax({ type : 'POST', url : "jSonGuestFTIndividualInfoDelete?regFTIndividualPaymentSavingId="+ftIndividualPaymentSavingId, dataType : 'json', async : true, cache: false,
 			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
 				if(cartCount > 0) { $("#individualFTDivId").load(location.href + " #individualFTDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); } else { window.location = 'guestRegistryMyAccount'; }				
 			} }); }
 	
 	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0)); if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }
 	function conBorNumeralsOnly(evt,id) { try{ var charCode = (evt.which) ? evt.which : event.keyCode; if(charCode==46){ var txt=document.getElementById(id).value; if(!(txt.indexOf(".") > -1)){ return true; } } if (charCode > 31 && (charCode < 48 || charCode > 57) ) return false; return true; }catch(w){ alert(w); } } 	
 	function roomEditButtonDisplay(count) { $("#roomSaveDivDspId"+count).show(); $("#roomEditDivDspId"+count).hide(); return false; }

 	function roomFundsSaveButtonDisplay(count, roomFundColumnCount, oldRoomfundPrice, roomFundsNeedPrice) { var guestRoomNewPrice = $("#gustRoomNewPriceId"+count).val(); var roomFundImage = $("#roomFundImageId"+count).val(); var roomFundName = $("#roomFundNameId"+count).val(); var roomFundColumnName = $("#roomFundColumnNameId"+count).val(); var guestRoomNewPriceInt = 0;
 		if(guestRoomNewPrice !== "") { guestRoomNewPriceInt = parseFloat(guestRoomNewPrice); }
 		var roomFundsNeedPriceSt = roomFundsNeedPrice.toFixed(2); var roomFundsNeedPriceDb = parseFloat(roomFundsNeedPrice);
		if(guestRoomNewPriceInt > 0) { if(guestRoomNewPriceInt > roomFundsNeedPriceDb) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds( " + roomFundsNeedPriceDb +") requested."); result=false; } else {
	 	var totalRoomFundInfo = roomFundImage + "___" + roomFundName + "___" + roomFundColumnName + "___" + roomFundColumnCount + "___" + oldRoomfundPrice + "___" + guestRoomNewPriceInt + "___" + roomFundsNeedPriceSt; newAjaxCallForRoomFundContributeUpdate(totalRoomFundInfo); }			
		} else { alert("Please enter valid amount"); return false; } }

	function newAjaxCallForRoomFundContributeUpdate(totalRoomFundInfo) { 
    	$.ajax({ type : 'POST', url : "jSonRoomFundContributeValueUpdate?roomFundsName="+totalRoomFundInfo, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#roomFundDivId").load(location.href + " #roomFundDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId");
			} }); }
	function selectedRoomFundsInfoDelete(count) { var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { var selectedRoomTotalInfo = $("#selectedRoomtotalInfoId"+count).val(); var oldRoomFundPrice = $("#oldRoomFundPriceId"+count).val(); var totalRoomFundInfo = selectedRoomTotalInfo + "___" + oldRoomFundPrice; newAjaxCallForRoomFundContributeInfoDelete(totalRoomFundInfo); } else { return false; } }
	function newAjaxCallForRoomFundContributeInfoDelete(totalRoomFundInfo) { 
    	$.ajax({ type : 'POST', url : "jSonRoomFundContributeInfoDelete?roomFundsName="+totalRoomFundInfo, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
				if(cartCount > 0) { $("#roomFundDivId").load(location.href + " #roomFundDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); } else { window.location = 'guestRegistryMyAccount'; }				
			} }); }
 	function conBoardProductEditButtonDisplay(count) { $("#conBoardProductSaveDivDspId"+count).show(); $("#conBoardProductEditDivDspId"+count).hide(); return false; }
 	function conBoardProductSaveButtonDisplay(count) { var guestConBoardNewQuantity = $("#gustConBoardNewQuantityId"+count).val(); var guestsConBoardNewQuantity = 0;
		if(guestConBoardNewQuantity !== "") { guestsConBoardNewQuantity = parseInt(guestConBoardNewQuantity); }
		if(guestsConBoardNewQuantity < 1) { alert("Please enter valid product quantity"); return false; } }
 	function conBoardContProductEditButtonDisplay(count) { $("#conBoardContProductSaveDivDspId"+count).show(); $("#conBoardContProductEditDivDspId"+count).hide(); return false; }

 	function conBoardContProductSaveButtonDisplay(count) { var gustConBoardContPrice = $("#gustConBoardContPriceId"+count).val(); var guestConBoardContPrice = 0;
		if(gustConBoardContPrice !== "") { guestConBoardContPrice = parseInt(gustConBoardContPrice); }
		if(guestConBoardContPrice < 1) { alert("Please enter valid product quantity"); return false; } }

	function cashFundsEditButtonDisplay(count) { $("#cashFundsSaveDivDspId"+count).show(); $("#cashFundsEditDivDspId"+count).hide(); return false; }
	function customFundsEditButtonDisplay(count) { $("#customFundsSaveDivDspId"+count).show(); $("#customFundsEditDivDspId"+count).hide(); return false; }	 	
	function cashFundsSaveButtonDisplay(count, cashFundId, cashFundsNeedPrice) { var regNewCashFundPriceVal = $("#registCashFundNewPrice"+count).val(); var guestCashFundNewPriceInt = 0;
 		if(regNewCashFundPriceVal !== "") { guestCashFundNewPriceInt = parseFloat(regNewCashFundPriceVal); } var cashFundsNeedPriceDb = parseFloat(cashFundsNeedPrice);
		if(guestCashFundNewPriceInt > 0) { if(guestCashFundNewPriceInt > cashFundsNeedPriceDb) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds( " + cashFundsNeedPriceDb +") requested."); result=false; } else {
	 			var totalCashFundInfo = cashFundId + "__" + guestCashFundNewPriceInt; newAjaxCallForCFContributeUpdate(totalCashFundInfo); }			
		} else { alert("Please enter valid amount"); return false; } }
	
	function newAjaxCallForCFContributeUpdate(totalCashFundInfo) { 
    	$.ajax({ type : 'POST', url : "jSonCashFundContributeValueUpdate?cashFundName="+totalCashFundInfo, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#cashFundDivId").load(location.href + " #cashFundDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId");
			} }); }
	
	function customFundsSaveButtonDisplay(count, customFundId, customFundsNeedPrice) { var regNewCustomFundPriceVal = $("#registCustomFundNewPrice"+count).val(); var guestCustomFundNewPriceInt = 0;
 		if(regNewCustomFundPriceVal !== "") { guestCustomFundNewPriceInt = parseFloat(regNewCustomFundPriceVal); } var customFundsNeedPriceDb = parseFloat(customFundsNeedPrice);
		if(guestCustomFundNewPriceInt > 0) { if(guestCustomFundNewPriceInt > customFundsNeedPriceDb) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds( " + customFundsNeedPriceDb +") requested."); result=false; } else {
	 			var totalCustomFundInfo = customFundId + "__" + guestCustomFundNewPriceInt; newAjaxCallForCustomFContributeUpdate(totalCustomFundInfo); }			
		} else { alert("Please enter valid amount"); return false; } }

	function newAjaxCallForCustomFContributeUpdate(totalCustomFundInfo) { 
		$.ajax({ type : 'POST', url : "jSonCustomFundContributeValueUpdate?cashFundName="+totalCustomFundInfo, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#customFundDivId").load(location.href + " #customFundDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); } }); }
 	
	function selectedCashFundsInfoDelete(cashFundId) { var confMessageVar = confirm("Are you sure you want to delete this?"); if (confMessageVar == true) { newAjaxCallForCFContributeInfoDelete(cashFundId); } else { return false; } }

	function newAjaxCallForCFContributeInfoDelete(cashFundInfo) { 
    	$.ajax({ type : 'POST', url : "jSonCashFundContributeInfoDelete?cashFundName="+cashFundInfo, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
				if(cartCount > 0) { $("#cashFundDivId").load(location.href + " #cashFundDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); } else { window.location = 'guestRegistryMyAccount'; } } }); }

	function selectedCustomFundsInfoDelete(cashFundId) { var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { newAjaxCallForCustomContributeInfoDelete(cashFundId); } else { return false; } }

	function newAjaxCallForCustomContributeInfoDelete(cashFundInfo) { 
    	$.ajax({ type : 'POST', url : "jSonCustomFundContributeInfoDelete?cashFundName="+cashFundInfo, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
				if(cartCount > 0) { $("#customFundDivId").load(location.href + " #customFundDivId"); $("#totalFundAmountDivId").load(location.href + " #totalFundAmountDivId"); $("#guestCartDspId").load(location.href + " #guestCartDspId"); $("#guestCartMobDspId").load(location.href + " #guestCartMobDspId"); } else { window.location = 'guestRegistryMyAccount'; }				
			} }); }
    </script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">       
        <div class="row"> <div class="col-md-2 col-sm-2"></div> <div class="col-md-8 col-sm-8">	        
<!-- Cart Heading -->
	  	<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
	    <div class="red_my_cart_for_guest_ht_dsp">MY CART</div> </div> </div> </div> </div>
<!-- Cart Sub Heading -->
	 	<div class="row top_adjustment_10" style="padding: 20px;"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center" class="red_my_cart_for_guest_suht_dsp"></div> </div> </div> </div> 
		<div align="left" class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> </div> </div> </div> <div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="red_my_cart_for_guest_suht_dsp">CONTRIBUTION</div> </div> </div> </div> </div> 	    
	    <div class="row"><div class="red_my_cart_for_guest_div_bar"></div></div>	        	       
<!-- Cart Room Funds Coding -->
		<div id="roomFundDivId">	 		
	 	<% 	String cartGuestUserRegInfo = (String)session.getAttribute("guestRoomFundsCartInfoInSn");	 		
			if (null != cartGuestUserRegInfo) { String[] noOfCartRegInfoList = cartGuestUserRegInfo.split("__"); int count = 0;
				for (int i = 0; i < noOfCartRegInfoList.length; i++) {
					String singleRoomDataDsp = noOfCartRegInfoList[i]; String[] guestCartInfoList = noOfCartRegInfoList[i].split(",_,"); String spaceImage = guestCartInfoList[0]; String spaceName = guestCartInfoList[1]; String spacePrice = guestCartInfoList[2]; String spaceColName = guestCartInfoList[3]; String spaceColCount = guestCartInfoList[4]; String roomFundsNeedPrice = guestCartInfoList[5]; double gustRoomFundAmountDb = Double.parseDouble(spacePrice); String guestRoomFundAmount = String.format("%.2f", gustRoomFundAmountDb); count = count + (i + 1);
			%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="resources/images/registry/roomandfundimages/<%=spaceImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=spaceName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> <div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="roomEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" name="productCount" value="<%=guestRoomFundAmount%>" class="guest_cart_price_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return roomEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="roomSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" id="gustRoomNewPriceId<%=count%>" name="gustRoomNewPrice" value="<%=spacePrice%>" class="guest_cart_price_save_dsp" onkeypress="return numeralsOnly(event);"></td> </tr> </table>
		<input type="hidden" name="roomFundImage" id="roomFundImageId<%=count%>" value="<%=spaceImage%>"> <input type="hidden" name="roomFundName" id="roomFundNameId<%=count%>" value="<%=spaceName%>"> <input type="hidden" name="roomFundColumnName" id="roomFundColumnNameId<%=count%>" value="<%=spaceColName%>">					    	
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return roomFundsSaveButtonDisplay(<%=count%>, <%=spaceColCount%>, <%=spacePrice%>, <%=roomFundsNeedPrice%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5">
		<input type="hidden" name="selectedRoomtotalInfo" id="selectedRoomtotalInfoId<%=count%>" value="<%=singleRoomDataDsp%>"> <input type="hidden" name="oldRoomFundPrice" id="oldRoomFundPriceId<%=count%>" value="<%=spacePrice%>">
		<input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedRoomFundsInfoDelete(<%=count%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>									       
<!-- Cart Cash Fund coding -->
		<div id="cashFundDivId">	 		
	 	<%	String guestCashFundContValue = (String)session.getAttribute("guestCashFundContValueInSn");	 		
			if (null != guestCashFundContValue) { String[] guestCashFundContValueList = guestCashFundContValue.split("__"); int count = 0;
				for (int i = 0; i < guestCashFundContValueList.length; i++) {
					String guestCashFundContValueDsp = guestCashFundContValueList[i]; String[] guestCashFundContValueComb = guestCashFundContValueList[i].split("_,_"); String guestCashFundId = guestCashFundContValueComb[0]; String guestCashFundImage = guestCashFundContValueComb[1]; String guestCashFundName = guestCashFundContValueComb[2]; String gustCashFundAmount = guestCashFundContValueComb[3]; String gustCashFundNeedAmount = guestCashFundContValueComb[4]; double gustCashFundAmountDb = Double.parseDouble(gustCashFundAmount); String guestCashFundAmount = String.format("%.2f", gustCashFundAmountDb); count = count + (i + 1);
		%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=guestCashFundImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestCashFundName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="cashFundsEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" name="productCount" value="<%=guestCashFundAmount%>" class="guest_cart_price_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cashFundsEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="cashFundsSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" id="registCashFundNewPrice<%=count%>" name="guestFundAmount" value="<%=gustCashFundAmount%>" class="guest_cart_price_save_dsp" onkeypress="return numeralsOnly(event,this.id);"></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cashFundsSaveButtonDisplay(<%=count%>, <%=guestCashFundId%>, <%=gustCashFundNeedAmount%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedCashFundsInfoDelete(<%=guestCashFundId%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>					       
<!-- Cart Custom Fund coding -->			
		<div id="customFundDivId">	 		
	 	<% 	String guestCustomFundContValue = (String)session.getAttribute("guestCustomFundContValueInSn");	 		
			if (null != guestCustomFundContValue) { String[] guestCustomFundContValueList = guestCustomFundContValue.split("__"); int count = 0;
				for (int i = 0; i < guestCustomFundContValueList.length; i++) {
					String guestCustomFundContValueDsp = guestCustomFundContValueList[i]; String[] guestCustomFundContValueComb = guestCustomFundContValueList[i].split("_,_"); String guestCustomFundId = guestCustomFundContValueComb[0]; String guestCustomFundImage = guestCustomFundContValueComb[1]; String guestCustomFundName = guestCustomFundContValueComb[2]; String gustCustomFundAmount = guestCustomFundContValueComb[3]; String gustCustomFundNeedAmount = guestCustomFundContValueComb[4]; double gustCustomFundAmountDb = Double.parseDouble(gustCustomFundAmount); String guestCustomFundAmount = String.format("%.2f", gustCustomFundAmountDb); count = count + (i + 1);
		%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=guestCustomFundImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestCustomFundName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="customFundsEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" name="productCount" value="<%=guestCustomFundAmount%>" class="guest_cart_price_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return customFundsEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="customFundsSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" id="registCustomFundNewPrice<%=count%>" name="guestFundAmount" value="<%=gustCustomFundAmount%>" class="guest_cart_price_save_dsp" onkeypress="return numeralsOnly(event,this.id);"></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return customFundsSaveButtonDisplay(<%=count%>, <%=guestCustomFundId%>, <%=gustCustomFundNeedAmount%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedCustomFundsInfoDelete(<%=guestCustomFundId%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>											       
<!-- Guest Concept Board Contributed coding -->			
		<div id="contributedCBDivId">	 		
	 	<% 	String guestCBContributedCartValue = (String)session.getAttribute("guestCBContributedCartValueInSn");	 		
			if (null != guestCBContributedCartValue) { String[] guestCBContributedCartValueList = guestCBContributedCartValue.split("__"); int count = 0;
				for (int i = 0; i < guestCBContributedCartValueList.length; i++) {
					String guestCustomFundContValueDsp = guestCBContributedCartValueList[i]; String[] guestCBContributedCartValueComb = guestCBContributedCartValueList[i].split("_,_"); String guestCBContributedProductId = guestCBContributedCartValueComb[0]; String guestCBContributedProductAmount = guestCBContributedCartValueComb[1]; String guestCBContributedProductName = guestCBContributedCartValueComb[2]; String guestCBContributedProductImage = guestCBContributedCartValueComb[3]; String guestCBContributedNeedPrice = guestCBContributedCartValueComb[4].replace(",", ""); double guestCBContributedProductAmountDb = Double.parseDouble(guestCBContributedProductAmount); String guestCBContributedAmount = String.format("%.2f", guestCBContributedProductAmountDb); count = count + (i + 1);
		%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=guestCBContributedProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestCBContributedProductName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="cbContributedEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" name="productCount" value="<%=guestCBContributedAmount%>" class="guest_cart_price_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cbContributedEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="cbContributedSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" id="guestCBContributedPrice<%=count%>" name="regCBContributedAmount" value="<%=guestCBContributedAmount%>" class="guest_cart_price_save_dsp" onkeypress="return conBorNumeralsOnly(event,this.id);"></td> </tr> 
		<tr> <td><input type="hidden" id="guestCBContributedOldPrice<%=count%>" name="regCBContributedOldAmount" value="<%=guestCBContributedAmount%>"></td></tr></table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cbContributedSaveButtonDisplay(<%=count%>, <%=guestCBContributedProductId%>, <%=guestCBContributedNeedPrice%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedCBContributedInfoDelete(<%=guestCBContributedProductId%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>										       
<!-- Guest Concept Board Individual coding -->			
		<div id="individualCBDivId">	 		
	 	<% 	String guestCBIndividualCartValue = (String)session.getAttribute("guestCBIndividualCartValueInSn");	 		
			if (null != guestCBIndividualCartValue) { String[] guestCBIndividualCartValueList = guestCBIndividualCartValue.split("__"); int count = 0;
				for (int i = 0; i < guestCBIndividualCartValueList.length; i++) {
					String guestCustomFundContValueDsp = guestCBIndividualCartValueList[i]; String[] guestCBIndividualCartValueComb = guestCBIndividualCartValueList[i].split("_,_"); String guestCBIndividualProductId = guestCBIndividualCartValueComb[0]; String guestCBIndividualProductQuantity = guestCBIndividualCartValueComb[1]; String guestCBIndividualProductAmount = guestCBIndividualCartValueComb[2]; String guestCBIndividualProductName = guestCBIndividualCartValueComb[3]; String guestCBIndividualProductImage = guestCBIndividualCartValueComb[4]; String guestCBIndividualNeedQuantity = guestCBIndividualCartValueComb[5]; double guestCBIndividualProductAmountDb = Double.parseDouble(guestCBIndividualProductAmount); String guestCBIndividualAmount = String.format("%.2f", guestCBIndividualProductAmountDb); count = count + (i + 1);
		%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=guestCBIndividualProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestCBIndividualProductName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="cbIndividualEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td>&nbsp;<%=guestCBIndividualAmount%>/</td> <td><input type="text" name="productCount" value="<%=guestCBIndividualProductQuantity%>" class="guest_cart_price_con_cur_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cbIndividualEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="cbIndividualSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td>&nbsp;<%=guestCBIndividualAmount%><font style="color: white;">/</font></td> <td><input type="text" maxLength="2" id="guestCBIndividualQuantityId<%=count%>" name="regiConBoardNewQuantity" value="<%=guestCBIndividualProductQuantity%>" class="guest_cart_price_con_cur_save_dsp" onkeypress="return numeralsOnly(event);"></td> </tr> 
		<tr> <td><input type="hidden" id="guestCBIndividualOldQuantityId<%=count%>" name="regCBContributedOldQuantity" value="<%=guestCBIndividualProductQuantity%>"></td>  <td><input type="hidden" id="guestCBIndividualOldPriceId<%=count%>" name="regCBContributedOldPrice" value="<%=guestCBIndividualAmount%>"></td></tr></table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return cbIndividualSaveButtonDisplay(<%=count%>, <%=guestCBIndividualProductId%>, <%=guestCBIndividualNeedQuantity%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedCBIndividualInfoDelete(<%=guestCBIndividualProductId%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>
		
<!-- Guest Finishing Touches Contributed coding -->			
		<div id="contributedFTDivId">	 		
	 	<% 	String guestFTContributedCartValue = (String)session.getAttribute("guestFTContributedCartValueInSn");	 		
			if (null != guestFTContributedCartValue) { String[] guestFTContributedCartValueList = guestFTContributedCartValue.split("__"); int count = 0;
				for (int i = 0; i < guestFTContributedCartValueList.length; i++) {
					String guestCustomFundContValueDsp = guestFTContributedCartValueList[i]; String[] guestFTContributedCartValueComb = guestFTContributedCartValueList[i].split("_,_"); String guestFTContributedProductId = guestFTContributedCartValueComb[0]; String guestFTContributedProductAmount = guestFTContributedCartValueComb[1]; String guestFTContributedProductName = guestFTContributedCartValueComb[2]; String guestFTContributedProductImage = guestFTContributedCartValueComb[3]; String guestFTContributedNeedPrice = guestFTContributedCartValueComb[4].replace(",", ""); double guestFTContributedProductAmountDb = Double.parseDouble(guestFTContributedProductAmount); String guestFTContributedAmount = String.format("%.2f", guestFTContributedProductAmountDb); count = count + (i + 1);
		%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=guestFTContributedProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestFTContributedProductName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="ftContributedEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" name="productCount" value="<%=guestFTContributedAmount%>" class="guest_cart_price_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return ftContributedEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="ftContributedSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td><input type="text" id="guestFTContributedPrice<%=count%>" name="regFTContributedAmount" value="<%=guestFTContributedAmount%>" class="guest_cart_price_save_dsp" onkeypress="return conBorNumeralsOnly(event,this.id);"></td> </tr> 
		<tr> <td><input type="hidden" id="guestFTContributedOldPrice<%=count%>" name="regFTContributedOldAmount" value="<%=guestFTContributedAmount%>"></td></tr></table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return ftContributedSaveButtonDisplay(<%=count%>, <%=guestFTContributedProductId%>, <%=guestFTContributedNeedPrice%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedFTContributedInfoDelete(<%=guestFTContributedProductId%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>										       
<!-- Guest Finishing Touches Individual coding -->			
		<div id="individualFTDivId">	 		
	 	<% 	String guestFTIndividualCartValue = (String)session.getAttribute("guestFTIndividualCartValueInSn");	 		
			if (null != guestFTIndividualCartValue) { String[] guestFTIndividualCartValueList = guestFTIndividualCartValue.split("__"); int count = 0;
				for (int i = 0; i < guestFTIndividualCartValueList.length; i++) {
					String guestCustomFundContValueDsp = guestFTIndividualCartValueList[i]; String[] guestFTIndividualCartValueComb = guestFTIndividualCartValueList[i].split("_,_"); String guestFTIndividualProductId = guestFTIndividualCartValueComb[0]; String guestFTIndividualProductQuantity = guestFTIndividualCartValueComb[1]; String guestFTIndividualProductAmount = guestFTIndividualCartValueComb[2]; String guestFTIndividualProductName = guestFTIndividualCartValueComb[3]; String guestFTIndividualProductImage = guestFTIndividualCartValueComb[4]; String guestFTIndividualNeedQuantity = guestFTIndividualCartValueComb[5]; double guestFTIndividualProductAmountDb = Double.parseDouble(guestFTIndividualProductAmount); String guestFTIndividualAmount = String.format("%.2f", guestFTIndividualProductAmountDb); count = count + (i + 1);
		%>
		<div class="row red_cart_guest_sub_div_bar"> <div class="col-md-4 col-sm-4"> <div class="service-item"> <div class="service-description">
		<div align="center"><img src="<%=guestFTIndividualProductImage%>" style="margin-top: 0px; width: 100%; height: 100px; object-fit: scale-down; position: relative; object-position: 50% 50%;"></div> </div> </div> </div> 
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 85px;"><div class="shop_cart_rn_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestFTIndividualProductName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"></div>
		<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="regi_my_cart_info_frame_dsp">
		<div id="ftIndividualEditDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td>&nbsp;<%=guestFTIndividualAmount%>/</td> <td><input type="text" name="productCount" value="<%=guestFTIndividualProductQuantity%>" class="guest_cart_price_con_cur_edit_dsp" readonly></td> </tr> </table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return ftIndividualEditButtonDisplay(<%=count%>);" class="shopp_cart_edit_butt_dsp" value="EDIT"></div> </div>
		<div style="display: none;" id="ftIndividualSaveDivDspId<%=count%>">
		<table> <tr> <td><input value="$" readonly class="guest_cart_doller_edit_dsp"></td> <td>&nbsp;<%=guestFTIndividualAmount%><font style="color: white;">/</font></td> <td><input type="text" maxLength="2" id="guestFTIndividualQuantityId<%=count%>" name="regiFinTouchesNewQuantity" value="<%=guestFTIndividualProductQuantity%>" class="guest_cart_price_con_cur_save_dsp" onkeypress="return numeralsOnly(event);"></td> </tr> 
		<tr> <td><input type="hidden" id="guestFTIndividualOldQuantityId<%=count%>" name="regFTContributedOldQuantity" value="<%=guestFTIndividualProductQuantity%>"></td>  <td><input type="hidden" id="guestFTIndividualOldPriceId<%=count%>" name="regFTContributedOldPrice" value="<%=guestFTIndividualAmount%>"></td></tr></table>
		<div align="center" class="top_adjustment_5"><input type="submit" onclick="return ftIndividualSaveButtonDisplay(<%=count%>, <%=guestFTIndividualProductId%>, <%=guestFTIndividualNeedQuantity%>);" class="shopp_cart_edit_butt_dsp" value="SAVE"> </div> </div>
		<div align="center" class="top_adjustment_5"><input type='submit' class="shopp_cart_edit_butt_dsp" value="DELETE" onclick="return selectedFTIndividualInfoDelete(<%=guestFTIndividualProductId%>);"></div> </div> </div> </div> </div> </div> 
		<% } } %> </div>				
<!-- Cart Total Value Code -->
	 	<div class="row top_adjustment_30"> <div class="col-md-7 col-sm-7"> </div> 
		<div class="col-md-5 col-sm-5"> <div class="service-item">                        
		<div align="center" class="service-description" style="background: #e7e6e6; padding: 20px; border: 1px solid #dddbdb;">
		<table style="position: relative;"><tr><td><font class="red_my_cart_gst_val_dsp">&nbsp;SUBTOTAL:&nbsp;</font></td> <td><font class="red_my_cart_for_guest_reg_amt_dsp"><font id="totalFundAmountDivId">$&nbsp;${totalGuestFundAmountInSn}</font></font></td></tr></table> </div> </div> </div> </div>			      
<!-- Cart Submit Button Code -->			
	 	<div class="row"> <div align="left" class="col-md-4 col-sm-4"> <img src="resources/images/registry/authorize_net_img.png" width="120" height="100"> </div> 
		<div class="col-md-8 col-sm-8 top_adjustment_30"> <div class="service-item"> <div align="right" class="service-description">
		<table><tr> <td><a href="guestRegistryMyAccount"><font class="shop_cart_rn_editl_text_dsp" style="position: relative; top: 10px;">KEEP SHOPPING</font>&nbsp;&nbsp;&nbsp;</a></td>
		<td><form action="guestFundsCheckOutNow" method="get"><h4><button class="reg_box_fund__gs_sub_Buttn" id="shippingId">CHECKOUT NOW</button></h4></form></td></tr></table> </div> </div> </div> </div> </div>
       	<div class="col-md-2 col-sm-2"></div> </div> </div> </div>
       	 
		<script type="text/javascript" src="resources/js/json-minified.js"></script>		     
		</body>
</html>