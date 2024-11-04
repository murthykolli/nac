window.location.hash=""; window.location.hash=""; window.onhashchange=function(){window.location.hash="";}; window.onload=function(){ window.history.forward(1); };    
/* Concept Boards Contributed Coding */ 
	function cbContributedEditButtonDisplay(count) { $("#cbContributedSaveDivDspId"+count).show(); $("#cbContributedEditDivDspId"+count).hide(); return false; }
	function cbContributedSaveButtonDisplay(count, cbContributedPaymentSavingId, cbContributedNeedPrice) { var regNewContributedPriceVal = $("#regCBContributedPrice"+count).val(); var regNewContributedPriceValue = 0;
		if(regNewContributedPriceVal !== "") { regNewContributedPriceValue = parseFloat(regNewContributedPriceVal); }		
		var cbContributedNeedPriceValue = parseFloat(cbContributedNeedPrice);
		if(regNewContributedPriceValue > 0) {
			if(regNewContributedPriceValue > cbContributedNeedPriceValue) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds( " + cbContributedNeedPriceValue +") requested."); result=false;
	 		} else { var totalContributedInfoValue = cbContributedPaymentSavingId + "__" + regNewContributedPriceVal; newAjaxCallForCBContributedInfoUpdate(totalContributedInfoValue); }			
		} else { alert("Please enter valid amount"); return false; }						
	}
	function newAjaxCallForCBContributedInfoUpdate(totalContributedInfoValue) { 
    	$.ajax({ type : 'POST', url : "jSonAddCartCBContributedValueUpdate?cbContributedInfoValue="+totalContributedInfoValue, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#cbContributedDivId").load(location.href + " #cbContributedDivId"); $("#totalAmountDisplayDivId").load(location.href + " #totalAmountDisplayDivId");
			} }); }
/* Concept Boards Individual Coding */	 
  	function cbIndividualEditButtonDisplay(count) { $("#cbIndividualSaveDivDspId"+count).show(); $("#cbIndividualEditDivDspId"+count).hide(); return false; }
  	function cbIndividualSaveButtonDisplay(count, cbIndividualPaymentSavingId, cbIndividualNeedQuantity) { var regNewIndividualPriceVal = $("#regCBIndividualQuantityId"+count).val(); var regNewIndividualPriceValue = 0;
  		if(regNewIndividualPriceVal !== "") { regNewIndividualPriceValue = parseInt(regNewIndividualPriceVal); }
  		var cbIndividualNeedQuantityValue = parseFloat(cbIndividualNeedQuantity);  		
  		if(regNewIndividualPriceValue > 0) {
  			if(regNewIndividualPriceValue > cbIndividualNeedQuantityValue) { alert("Please make sure the quantity that you wish to gift is equivalent to or less than the quantity( " + cbIndividualNeedQuantityValue +") requested."); result=false;
	 		} else { var totalIndividualInfoValue = cbIndividualPaymentSavingId + "__" + regNewIndividualPriceVal; newAjaxCallForCBIndividualInfoUpdate(totalIndividualInfoValue); }
  		} else { alert("Please enter valid quantity"); return false; }  		 	  	
  	}
  	function newAjaxCallForCBIndividualInfoUpdate(totalIndividualInfoValue) { 
	    $.ajax({ type : 'POST', url : "jSonAddCartCBIndividualValueUpdate?cbIndividualInfoValue="+totalIndividualInfoValue, dataType : 'json', async : true, cache: false,
  	  	success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#cbIndividualDivId").load(location.href + " #cbIndividualDivId"); $("#totalAmountDisplayDivId").load(location.href + " #totalAmountDisplayDivId"); $("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId"); $("#regCartCountMobileId").load(location.href + " #regCartCountMobileId"); }    	
    	}); }
	function selectedCBContributedInfoDelete(cbContributedPaymentSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { newAjaxCallForCBContributedInfoDelete(cbContributedPaymentSavingId); } else { return false; } }
	function newAjaxCallForCBContributedInfoDelete(cbContributedPaymentSavingId) {
		$.ajax({ type : 'POST', url : "jSonCBContributedInfoDelete?regCBContributedPaymentSavingId="+cbContributedPaymentSavingId, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
				if(cartCount > 0) { $("#cbContributedDivId").load(location.href + " #cbContributedDivId"); $("#totalAmountDisplayDivId").load(location.href + " #totalAmountDisplayDivId"); $("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId"); $("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				} else { window.location = 'registryOverview'; } } }); }
	function selectedCBIndividualInfoDelete(cbIndividualPaymentSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { newAjaxCallForCBIndividualInfoDelete(cbIndividualPaymentSavingId); } else { return false; } }
	function newAjaxCallForCBIndividualInfoDelete(cbIndividualPaymentSavingId) { 
    	$.ajax({ type : 'POST', url : "jSonCBIndividualInfoDelete?regCBIndividualPaymentSavingId="+cbIndividualPaymentSavingId, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
				if(cartCount > 0) { $("#cbIndividualDivId").load(location.href + " #cbIndividualDivId"); $("#totalAmountDisplayDivId").load(location.href + " #totalAmountDisplayDivId"); $("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId"); $("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				} else { window.location = 'registryOverview'; }				
			} }); }
	
	/* Finishing Touches Contributed Coding */ 
	function ftContributedEditButtonDisplay(count) { $("#ftContributedSaveDivDspId"+count).show(); $("#ftContributedEditDivDspId"+count).hide(); return false; }
	function ftContributedSaveButtonDisplay(count, ftContributedPaymentSavingId, ftContributedNeedPrice) { var regNewContributedPriceVal = $("#regFTContributedPrice"+count).val(); var regNewContributedPriceValue = 0;
		if(regNewContributedPriceVal !== "") { regNewContributedPriceValue = parseFloat(regNewContributedPriceVal); }		
		var ftContributedNeedPriceValue = parseFloat(ftContributedNeedPrice);
		if(regNewContributedPriceValue > 0) {
			if(regNewContributedPriceValue > ftContributedNeedPriceValue) { alert("Please make sure the amount you wish to gift is equivalent or less than the remaining balance of funds( " + ftContributedNeedPriceValue +") requested."); result=false;
	 		} else { var totalContributedInfoValue = ftContributedPaymentSavingId + "__" + regNewContributedPriceVal; newAjaxCallForFTContributedInfoUpdate(totalContributedInfoValue); }			
		} else { alert("Please enter valid amount"); return false; }						
	}
	function newAjaxCallForFTContributedInfoUpdate(totalContributedInfoValue) { 
    	$.ajax({ type : 'POST', url : "jSonAddCartFTContributedValueUpdate?ftContributedInfoValue="+totalContributedInfoValue, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#ftContributedDivId").load(location.href + " #ftContributedDivId"); $("#totalAmountDisplayDivId").load(location.href + " #totalAmountDisplayDivId");
			} }); }
/* Finishing Touches Individual Coding */	 
  	function ftIndividualEditButtonDisplay(count) { $("#ftIndividualSaveDivDspId"+count).show(); $("#ftIndividualEditDivDspId"+count).hide(); return false; }
  	function ftIndividualSaveButtonDisplay(count, ftIndividualPaymentSavingId, ftIndividualNeedQuantity) { var regNewIndividualPriceVal = $("#regFTIndividualQuantityId"+count).val(); var regNewIndividualPriceValue = 0;
  		if(regNewIndividualPriceVal !== "") { regNewIndividualPriceValue = parseInt(regNewIndividualPriceVal); }
  		var ftIndividualNeedQuantityValue = parseFloat(ftIndividualNeedQuantity);  		
  		if(regNewIndividualPriceValue > 0) {
  			if(regNewIndividualPriceValue > ftIndividualNeedQuantityValue) { alert("Please make sure the quantity that you wish to gift is equivalent to or less than the quantity( " + ftIndividualNeedQuantityValue +") requested."); result=false;
	 		} else { var totalIndividualInfoValue = ftIndividualPaymentSavingId + "__" + regNewIndividualPriceVal; newAjaxCallForFTIndividualInfoUpdate(totalIndividualInfoValue); }
  		} else { alert("Please enter valid quantity"); return false; }  		 	  	
  	}
  	function newAjaxCallForFTIndividualInfoUpdate(totalIndividualInfoValue) { 
	    $.ajax({ type : 'POST', url : "jSonAddCartFTIndividualValueUpdate?ftIndividualInfoValue="+totalIndividualInfoValue, dataType : 'json', async : true, cache: false,
  	  	success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); $("#ftIndividualDivId").load(location.href + " #ftIndividualDivId"); $("#totalAmountDisplayDivId").load(location.href + " #totalAmountDisplayDivId"); $("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId"); $("#regCartCountMobileId").load(location.href + " #regCartCountMobileId"); }    	
    	}); }
	function selectedFTContributedInfoDelete(ftContributedPaymentSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { newAjaxCallForFTContributedInfoDelete(ftContributedPaymentSavingId); } else { return false; } }
	function newAjaxCallForFTContributedInfoDelete(ftContributedPaymentSavingId) {
		$.ajax({ type : 'POST', url : "jSonFTContributedInfoDelete?regFTContributedPaymentSavingId="+ftContributedPaymentSavingId, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
				if(cartCount > 0) { $("#ftContributedDivId").load(location.href + " #ftContributedDivId"); $("#totalAmountDisplayDivId").load(location.href + " #totalAmountDisplayDivId"); $("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId"); $("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				} else { window.location = 'registryOverview'; } } }); }
	function selectedFTIndividualInfoDelete(ftIndividualPaymentSavingId) { var confMessageVar = confirm("Are you sure you want to delete this?");
		if (confMessageVar == true) { newAjaxCallForFTIndividualInfoDelete(ftIndividualPaymentSavingId); } else { return false; } }
	function newAjaxCallForFTIndividualInfoDelete(ftIndividualPaymentSavingId) { 
    	$.ajax({ type : 'POST', url : "jSonFTIndividualInfoDelete?regFTIndividualPaymentSavingId="+ftIndividualPaymentSavingId, dataType : 'json', async : true, cache: false,
			success : function(result) { var jsonStrObj=JSON.stringify(result); var data=JSON.parse(jsonStrObj); var cartCount = data[0].JSonObj;
				if(cartCount > 0) { $("#ftIndividualDivId").load(location.href + " #ftIndividualDivId"); $("#totalAmountDisplayDivId").load(location.href + " #totalAmountDisplayDivId"); $("#regCartCountDesktopId").load(location.href + " #regCartCountDesktopId"); $("#regCartCountMobileId").load(location.href + " #regCartCountMobileId");
				} else { window.location = 'registryOverview'; }				
			} }); }
	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0));
	if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }
 	function conBorNumeralsOnly(evt,id) {
   	try{ var charCode = (evt.which) ? evt.which : event.keyCode; 	  
 	if(charCode==46){ var txt=document.getElementById(id).value; if(!(txt.indexOf(".") > -1)){ return true; } }
 	if (charCode > 31 && (charCode < 48 || charCode > 57) ) return false; return true; }catch(w){ alert(w); } }