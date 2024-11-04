
 	function stockCheckItemStatusUpdate(productRowId, itemStatusRef) {
 		var scItemCombValue = productRowId + "__"+ itemStatusRef;
 		newAjaxStockCheckItemStatusUpdate(scItemCombValue);
	}
 	
 	function newAjaxStockCheckItemStatusUpdate(scItemCombValue) { 
    	$.ajax({ type : 'POST', url : "jSonStockCheckItemStatusUpdate?scItemCombVal="+scItemCombValue, dataType : 'json', async : true, cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result); 
				var data=JSON.parse(jsonStrObj);
				$("#statusUpdateReffId").load(location.href + " #statusUpdateReffId");
			} 
    	}); 
    }
 	
 	function stockCheckPrice1Update(scItemOldPrice, productRowId) {
 		var newPriceId = "scProductPrice1Update" + productRowId + "Id";
 		var scItemNewPrice = $("#"+newPriceId).val();
 		var stPriceUpdateCombValue = scItemNewPrice + "__"+ scItemOldPrice + "__"+ productRowId;
 		scItemNewPrice = scItemNewPrice.replace(",", "");
 		var scItemNewPriceDb = parseFloat(scItemNewPrice);
 		if(scItemNewPriceDb > 0) {
 			newAjaxStockCheckPrice1Update(stPriceUpdateCombValue);
 		} else {
 			alert("Please enter valid price.");
 		}
 		return false;
	}

 	function newAjaxStockCheckPrice1Update(stPriceUpdateCombValue) { 
    	$.ajax({ type : 'POST', url : "jSonStockCheckPrice1Update?stPrice1UpdateCombVal="+stPriceUpdateCombValue, dataType : 'json', async : true, cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result); 
				var data=JSON.parse(jsonStrObj);
				$("#statusUpdateReffId").load(location.href + " #statusUpdateReffId");
			} 
    	}); 
    }

 	function stockCheckPrice2Update(scItemOldPrice, productRowId) {
 		var newPriceId = "scProductPrice2Update" + productRowId + "Id";
 		var scItemNewPrice = $("#"+newPriceId).val();
 		var stPriceUpdateCombValue = scItemNewPrice + "__"+ scItemOldPrice + "__"+ productRowId;
 		scItemNewPrice = scItemNewPrice.replace(",", "");
 		var scItemNewPriceDb = parseFloat(scItemNewPrice);
 		if(scItemNewPriceDb > 0) {
 			newAjaxStockCheckPrice2Update(stPriceUpdateCombValue);
 		} else {
 			alert("Please enter valid price.");
 		}
 		return false;
	}

 	function newAjaxStockCheckPrice2Update(stPriceUpdateCombValue) { 
    	$.ajax({ type : 'POST', url : "jSonStockCheckPrice2Update?stPrice2UpdateCombVal="+stPriceUpdateCombValue, dataType : 'json', async : true, cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result); 
				var data=JSON.parse(jsonStrObj);
				$("#statusUpdateReffId").load(location.href + " #statusUpdateReffId");
			} 
    	}); 
    }

 	function stockCheckPrice3Update(scItemOldPrice, productRowId) {
 		var newPriceId = "scProductPrice3Update" + productRowId + "Id";
 		var scItemNewPrice = $("#"+newPriceId).val();
 		var stPriceUpdateCombValue = scItemNewPrice + "__"+ scItemOldPrice + "__"+ productRowId;
 		scItemNewPrice = scItemNewPrice.replace(",", "");
 		var scItemNewPriceDb = parseFloat(scItemNewPrice);
 		if(scItemNewPriceDb > 0) {
 			newAjaxStockCheckPrice3Update(stPriceUpdateCombValue);
 		} else {
 			alert("Please enter valid price.");
 		}
 		return false;
	}

 	function newAjaxStockCheckPrice3Update(stPriceUpdateCombValue) { 
    	$.ajax({ type : 'POST', url : "jSonStockCheckPrice3Update?stPrice3UpdateCombVal="+stPriceUpdateCombValue, dataType : 'json', async : true, cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result); 
				var data=JSON.parse(jsonStrObj);
				$("#statusUpdateReffId").load(location.href + " #statusUpdateReffId");
			} 
    	}); 
    }

 	function stockCheckPrice4Update(scItemOldPrice, productRowId) {
 		var newPriceId = "scProductPrice4Update" + productRowId + "Id";
 		var scItemNewPrice = $("#"+newPriceId).val();
 		var stPriceUpdateCombValue = scItemNewPrice + "__"+ scItemOldPrice + "__"+ productRowId;
 		scItemNewPrice = scItemNewPrice.replace(",", "");
 		var scItemNewPriceDb = parseFloat(scItemNewPrice);
 		if(scItemNewPriceDb > 0) {
 			newAjaxStockCheckPrice4Update(stPriceUpdateCombValue);
 		} else {
 			alert("Please enter valid price.");
 		}
 		return false;
	}

 	function newAjaxStockCheckPrice4Update(stPriceUpdateCombValue) { 
    	$.ajax({ type : 'POST', url : "jSonStockCheckPrice4Update?stPrice4UpdateCombVal="+stPriceUpdateCombValue, dataType : 'json', async : true, cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result); 
				var data=JSON.parse(jsonStrObj);
				$("#statusUpdateReffId").load(location.href + " #statusUpdateReffId");
			} 
    	}); 
    }

 	function stockCheckPrice5Update(scItemOldPrice, productRowId) { 		
 		var newPriceId = "scProductPrice5Update" + productRowId + "Id";
 		var scItemNewPrice = $("#"+newPriceId).val();
 		var stPriceUpdateCombValue = scItemNewPrice + "__"+ scItemOldPrice + "__"+ productRowId;
 		scItemNewPrice = scItemNewPrice.replace(",", "");
 		var scItemNewPriceDb = parseFloat(scItemNewPrice);
 		if(scItemNewPriceDb > 0) {
 			newAjaxStockCheckPrice5Update(stPriceUpdateCombValue);
 		} else {
 			alert("Please enter valid price.");
 		}
 		return false;
	}

 	function newAjaxStockCheckPrice5Update(stPriceUpdateCombValue) { 
    	$.ajax({ type : 'POST', url : "jSonStockCheckPrice5Update?stPrice5UpdateCombVal="+stPriceUpdateCombValue, dataType : 'json', async : true, cache: false,
			success : function(result) {
				var jsonStrObj=JSON.stringify(result); 
				var data=JSON.parse(jsonStrObj);
				$("#statusUpdateReffId").load(location.href + " #statusUpdateReffId");
			} 
    	}); 
    }
 	
 	function numeralsOnly(evt,id) {
 		try{
 	        var charCode = (evt.which) ? evt.which : event.keyCode; 	  
 	        if(charCode==46){
 	            var txt=document.getElementById(id).value;
 	            if(!(txt.indexOf(".") > -1)){ 		
 	                return true;
 	            }
 	        }
 	        if (charCode > 31 && (charCode < 48 || charCode > 57) )
 	            return false;
 	        return true;
 		}catch(w){
 			alert(w);
 		}
 	}

/*

$(document).ready(function() { 
 		var priceReg = /^[0-9\.]+$/;

 		$("#stCheckPriceSaveButton1Id").click(function (){
 			var result = true; 		    
	 		if(priceReg.test($("#stockCheckProductPrice1Id").val())){
	 			$("#stockCheckProductPrice1Id").css("border-color","#006fbc"); $("#dollerFrame1Id").css("border-color","#006fbc");
	 	    } else{ $("#stockCheckProductPrice1Id").css("border-color","red"); $("#dollerFrame1Id").css("border-color","red"); result=false; }			
	 		return result;
 		});
 
 	 	$("#stockCheckProductPrice1Id").keyup(function(){ 	
 	 	if(priceReg.test(this.value)){ $("#stockCheckProductPrice1Id").css("border-color","#006fbc"); $("#dollerFrame1Id").css("border-color","#006fbc");
 	    } else{ $("#stockCheckProductPrice1Id").css("border-color","red"); $("#dollerFrame1Id").css("border-color","red"); result=false; } 	
 	 	});
 	 	

 		$("#stCheckPriceSaveButton2Id").click(function (){
 			var result = true; 		    
	 		if(priceReg.test($("#stockCheckProductPrice2Id").val())){ $("#stockCheckProductPrice2Id").css("border-color","#006fbc"); $("#dollerFrame2Id").css("border-color","#006fbc");
	 	    } else{ $("#stockCheckProductPrice2Id").css("border-color","red"); $("#dollerFrame2Id").css("border-color","red"); result=false; }			
	 		return result;
 		});

 	 	$("#stockCheckProductPrice2Id").keyup(function(){ 	
 	 	if(priceReg.test(this.value)){ $("#stockCheckProductPrice2Id").css("border-color","#006fbc"); $("#dollerFrame2Id").css("border-color","#006fbc");
 	    } else{ $("#stockCheckProductPrice2Id").css("border-color","red"); $("#dollerFrame2Id").css("border-color","red"); result=false; } 	
 	 	});
 		

 		$("#stCheckPriceSaveButton3Id").click(function (){
 			var result = true; 		    
	 		if(priceReg.test($("#stockCheckProductPrice3Id").val())){ $("#stockCheckProductPrice3Id").css("border-color","#006fbc"); $("#dollerFrame3Id").css("border-color","#006fbc");
	 	    } else{ $("#stockCheckProductPrice3Id").css("border-color","red"); $("#dollerFrame3Id").css("border-color","red"); result=false; }			
	 		return result;
 		});

 	 	$("#stockCheckProductPrice3Id").keyup(function(){ 	
 	 	if(priceReg.test(this.value)){ $("#stockCheckProductPrice3Id").css("border-color","#006fbc"); $("#dollerFrame3Id").css("border-color","#006fbc");
 	    } else{ $("#stockCheckProductPrice3Id").css("border-color","red"); $("#dollerFrame3Id").css("border-color","red"); result=false; } 	
 	 	});
 	 	

 		$("#stCheckPriceSaveButton4Id").click(function (){
 			var result = true; 		    
	 		if(priceReg.test($("#stockCheckProductPrice4Id").val())){ $("#stockCheckProductPrice4Id").css("border-color","#006fbc"); $("#dollerFrame4Id").css("border-color","#006fbc");
	 	    } else{ $("#stockCheckProductPrice4Id").css("border-color","red"); $("#dollerFrame4Id").css("border-color","red"); result=false; }			
	 		return result;
 		});

 	 	$("#stockCheckProductPrice4Id").keyup(function(){ 	
 	 	if(priceReg.test(this.value)){ $("#stockCheckProductPrice4Id").css("border-color","#006fbc"); $("#dollerFrame4Id").css("border-color","#006fbc");
 	    } else{ $("#stockCheckProductPrice4Id").css("border-color","red"); $("#dollerFrame4Id").css("border-color","red"); result=false; } 	
 	 	});
 	 	

 		$("#stCheckPriceSaveButton5Id").click(function (){
 			var result = true; 		    
	 		if(priceReg.test($("#stockCheckProductPrice5Id").val())){ $("#stockCheckProductPrice5Id").css("border-color","#006fbc"); $("#dollerFrame5Id").css("border-color","#006fbc");
	 	    } else{ $("#stockCheckProductPrice5Id").css("border-color","red"); $("#dollerFrame5Id").css("border-color","red"); result=false; }			
	 		return result;
 		});

 	 	$("#stockCheckProductPrice5Id").keyup(function(){ 	
 	 	if(priceReg.test(this.value)){ $("#stockCheckProductPrice5Id").css("border-color","#006fbc"); $("#dollerFrame5Id").css("border-color","#006fbc");
 	    } else{ $("#stockCheckProductPrice5Id").css("border-color","red"); $("#dollerFrame5Id").css("border-color","red"); result=false; } 	
 	 	}); 
 		 	
 	});
 	*/
 	