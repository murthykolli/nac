$(document).ready(function() {  	
	$("#saveDataRefId").click(function (){ var result = true; if($("#messageTextInputId").val() === "") { alert("Please enter a message for your guests."); result=false; } return result; });	
	$("#editedDataRefId").click(function (){ $("#messageSaveDisplayId").show(); $("#messageEditDisplayId").hide(); });
	
	$("#reg_plus_butt_click_id").click(function (){ $("#minus_img_info_display_id").show(); $("#plus_img_info_display_id").hide(); $("#reg_giftcards_info_id").show();
	$('html, body').animate({scrollTop: $('#reg_giftcards_info_id').offset().top}, 0); });
	$("#minus_img_click_id").click(function (){ $("#plus_img_info_display_id").show(); $("#minus_img_info_display_id").hide(); $("#reg_giftcards_info_id").hide(); });
	
	$("#reg_plus_butt_click_id").click(function (){ $("#minus_img_info_display_id").show(); $("#plus_img_info_display_id").hide(); });
	$("#minus_img_click_id").click(function (){ $("#plus_img_info_display_id").show(); $("#minus_img_info_display_id").hide(); });
 	});
 		
	function cashFundsEditRedirection(cashFundsName) {
		location.href = "registryEditCashFund?cashFundsName=" + cashFundsName + "&landingBackRef=Cash Fund Back"; 
	}
	
	function customFundsEditRedirection(regCustomFundsId) {
		location.href = "registryEditCustomFund?regCustomFundId=" + regCustomFundsId + "&landingCFBackRef=Custom Fund Back"; 
	}

	function selectedCashFundContributedInfoDelete(cfContributedSavingId) {
		var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { 
			newAjaxCallForCashFundContributedInfoDelete(cfContributedSavingId);
 		} else { 
 			return false;
 		}							
 	}

	function newAjaxCallForCashFundContributedInfoDelete(cfContributedSavingId) { 
    	$.ajax({
			type : 'POST',
			url : "jSonCashFundLandingContributedInfoDelete?cfContributedSavingId="+cfContributedSavingId,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;				
				$("#cashFundDivId").load(location.href + " #cashFundDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				if(cartCount > 0){
		        	$("#regCartValueDisp").show();
		        	$("#mobCartValueDisp").show();
		        } else {
		        	$("#regCartValueDisp").hide();
		        	$("#mobCartValueDisp").hide();
		        }
			}    	
    	}); 
  	}

	function selectedCustomFundContributedInfoDelete(cfContributedSavingId) {
		var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { 
			newAjaxCallForCustomFundContributedInfoDelete(cfContributedSavingId);
 		} else { 
 			return false;
 		}							
 	}

	function newAjaxCallForCustomFundContributedInfoDelete(cfContributedSavingId) { 
    	$.ajax({
			type : 'POST',
			url : "jSonCustomFundLandingContributedInfoDelete?cfContributedSavingId="+cfContributedSavingId,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;				
				$("#customFundDivId").load(location.href + " #customFundDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				if(cartCount > 0){
		        	$("#regCartValueDisp").show();
		        	$("#mobCartValueDisp").show();
		        } else {
		        	$("#regCartValueDisp").hide();
		        	$("#mobCartValueDisp").hide();
		        }
			}    	
    	}); 
  	}

	function selectedCBContributedInfoDelete(cbContributedSavingId) {
		var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { 
			newAjaxCallForCBContributedInfoDelete(cbContributedSavingId);
 		} else { 
 			return false;
 		}							
 	}

	function newAjaxCallForCBContributedInfoDelete(cbContributedSavingId) { 
    	$.ajax({
			type : 'POST',
			url : "jSonConceptBoardsContributedInfoDelete?regCBCotributedSavingId="+cbContributedSavingId,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;				
				$("#contributedCBDivId").load(location.href + " #contributedCBDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				if(cartCount > 0){
		        	$("#regCartValueDisp").show();
		        	$("#mobCartValueDisp").show();
		        } else {
		        	$("#regCartValueDisp").hide();
		        	$("#mobCartValueDisp").hide();
		        }
			}    	
    	}); 
  	}

	function selectedCBIndividualInfoDelete(cbIndividualSavingId) {
		var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { 
			newAjaxCallForCBIndividualInfoDelete(cbIndividualSavingId);
 		} else { 
 			return false;
 		}							
 	}

	function newAjaxCallForCBIndividualInfoDelete(cbIndividualSavingId) {
		$.ajax({
			type : 'POST',
			url : "jSonConceptBoardsIndividualInfoDelete?regCBIndividualSavingId="+cbIndividualSavingId,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;				
				$("#individualCBDivId").load(location.href + " #individualCBDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				if(cartCount > 0){
		        	$("#regCartValueDisp").show();
		        	$("#mobCartValueDisp").show();
		        } else {
		        	$("#regCartValueDisp").hide();
		        	$("#mobCartValueDisp").hide();
		        }
			}    	
    	}); 
  	}

	function selectedCBIndividualInfoAddToCart(cbIndividualSavingId, cbIndividualNeedQuantity) {
		var quantityId = "conBoardProductQuantityId" + cbIndividualSavingId;
		var indQuantity = $("#"+quantityId).val();
		if((indQuantity == "") || (indQuantity == "0")) { alert("Please enter valid number"); return false }		
		else {
			var cbIndividualNeedQuantityValue = parseFloat(cbIndividualNeedQuantity);
			var givenQuantityValue = parseInt(indQuantity);
			if(givenQuantityValue > cbIndividualNeedQuantityValue) {
	 			alert("Please make sure the quantity that you wish to gift is equivalent to or less than the quantity requested.");
	 			result=false;
	 		} else {
				var cbIndividualCombVal = cbIndividualSavingId + "__" + indQuantity;
				newAjaxCallForCBIndividualInfoAddToCart(cbIndividualCombVal);
	 		}
		}
	}

	function newAjaxCallForCBIndividualInfoAddToCart(cbIndividualCombVal) {
		$.ajax({
			type : 'POST',
			url : "jSonConceptBoardsIndividualInfoAddToCart?regCBIndividualCombVal="+cbIndividualCombVal,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;
				$("#individualCBDivId").load(location.href + " #individualCBDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				alert("This product has been added to your Cart");
				$("#regCartValueDisp").show();
	        	$("#mobCartValueDisp").show();
			}
    	}); 
  	}

	function selectedRoomFundContributedLandingInfoDelete(roomFundColumnCount, roomFundName) {
		var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) {			
			var totalRoomFundInfo = roomFundName + "___" + roomFundColumnCount;
			newAjaxCallForRoomFundContributedLandingInfoDelete(totalRoomFundInfo);
 		} else { 
 			return false;
 		}							
 	}

	function newAjaxCallForRoomFundContributedLandingInfoDelete(totalRoomFundInfo) {
		$.ajax({
			type : 'POST',
			url : "jSonRoomFundContributedLandingInfoDelete?totalRoomFundInfo="+totalRoomFundInfo,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;
				$("#roomFundsDivId").load(location.href + " #roomFundsDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				if(cartCount > 0){
		        	$("#regCartValueDisp").show();
		        	$("#mobCartValueDisp").show();
		        } else {
		        	$("#regCartValueDisp").hide();
		        	$("#mobCartValueDisp").hide();
		        }
			}    	
    	}); 
  	}

	
/*FInishing Touches JS Code*/
	

	function selectedFTContributedInfoDelete(ftContributedSavingId) {
		var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { 
			newAjaxCallForFTContributedInfoDelete(ftContributedSavingId);
 		} else { 
 			return false;
 		}							
 	}

	function newAjaxCallForFTContributedInfoDelete(ftContributedSavingId) { 
    	$.ajax({
			type : 'POST',
			url : "jSonFinishingTouchesContributedInfoDelete?regFTCotributedSavingId="+ftContributedSavingId,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;				
				$("#contributedFTDivId").load(location.href + " #contributedFTDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				if(cartCount > 0){
		        	$("#regCartValueDisp").show();
		        	$("#mobCartValueDisp").show();
		        } else {
		        	$("#regCartValueDisp").hide();
		        	$("#mobCartValueDisp").hide();
		        }
			}    	
    	}); 
  	}

	function selectedFTIndividualInfoDelete(ftIndividualSavingId) {
		var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { 
			newAjaxCallForFTIndividualInfoDelete(ftIndividualSavingId);
 		} else { 
 			return false;
 		}							
 	}

	function newAjaxCallForFTIndividualInfoDelete(ftIndividualSavingId) {
		$.ajax({
			type : 'POST',
			url : "jSonFinishingTouchesIndividualInfoDelete?regFTIndividualSavingId="+ftIndividualSavingId,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;				
				$("#individualFTDivId").load(location.href + " #individualFTDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				if(cartCount > 0){
		        	$("#regCartValueDisp").show();
		        	$("#mobCartValueDisp").show();
		        } else {
		        	$("#regCartValueDisp").hide();
		        	$("#mobCartValueDisp").hide();
		        }
			}    	
    	}); 
  	}

	function selectedFTIndividualInfoAddToCart(ftIndividualSavingId, ftIndividualNeedQuantity) {
		var quantityId = "conBoardProductQuantityId" + ftIndividualSavingId;
		var indQuantity = $("#"+quantityId).val();
		if((indQuantity == "") || (indQuantity == "0")) { alert("Please enter valid number"); return false }		
		else {
			var ftIndividualNeedQuantityValue = parseFloat(ftIndividualNeedQuantity);
			var givenQuantityValue = parseInt(indQuantity);
			if(givenQuantityValue > ftIndividualNeedQuantityValue) {
	 			alert("Please make sure the quantity that you wish to gift is equivalent to or less than the quantity requested.");
	 			result=false;
	 		} else {
				var ftIndividualCombVal = ftIndividualSavingId + "__" + indQuantity;
				newAjaxCallForFTIndividualInfoAddToCart(ftIndividualCombVal);
	 		}
		}
	}

	function newAjaxCallForFTIndividualInfoAddToCart(ftIndividualCombVal) {
		$.ajax({
			type : 'POST',
			url : "jSonFinishingTouchesIndividualInfoAddToCart?regFTIndividualCombVal="+ftIndividualCombVal,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var cartCount = data[0].JSonObj;
				$("#individualFTDivId").load(location.href + " #individualFTDivId");				
				$("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId");
				$("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				alert("This product has been added to your Cart");
				$("#regCartValueDisp").show();
	        	$("#mobCartValueDisp").show();
			}
    	}); 
  	}

	function registryMakeVisibleAccess(liveStatus) {		
			newAjaxCallForRegistryMakeVisibleAccess(liveStatus);					
 	}

	function newAjaxCallForRegistryMakeVisibleAccess(liveStatus) { 
    	$.ajax({
			type : 'POST',
			url : "jSonRegistryMakeVisibleAccess?liveStatusRef="+liveStatus,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result);				
				var data=JSON.parse(jsonStrObj);
				var regiStatus = data[0].JSonObj;
				if(regiStatus === "Done") { $("#makeRegistryVisibleId").hide(); $("#registryIsLiveId").show(); } else { $("#makeRegistryVisibleId").show(); $("#registryIsLiveId").hide(); }				
			}    	
    	}); 
  	}

 	function numeralsOnly(evt) {
 		evt = (evt) ? evt : event;
 		var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
 		((evt.which) ? evt.which : 0));
 		if (charCode > 31 && (charCode < 48 || charCode > 57)) {
 		return false;
 		}
 		return true;
 	}