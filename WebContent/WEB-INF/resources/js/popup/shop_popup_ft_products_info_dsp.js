var furnamtureSpecProductValue;
$(document).ready(function() {
	furnamtureSpecProductValue = function(combiValues) {
		$('html, body').animate({ scrollTop: 0 }, 'fast');
		$( "#mainframe" ).animate({ marginTop: "120px"}, 500 );
		$("#hidePriceFromGuestId").prop("checked", false);
		$("[name=productQuantity]").val("1");		
	var conSeptValues = combiValues.split("_,_");	
	var image1Val = "data:image/jpg;base64,"+conSeptValues[0]+"";
	var image2Val = "data:image/jpg;base64,"+conSeptValues[1]+"";
	var image3Val = "data:image/jpg;base64,"+conSeptValues[2]+"";
	var image4Val = "data:image/jpg;base64,"+conSeptValues[3]+"";
	$('img#bigImgDsplayCl').attr('src', image1Val);
	$('img#popupImage1Id').attr('src', image1Val);
	$('img#popupImage2Id').attr('src', image2Val);
	$('img#popupImage3Id').attr('src', image3Val);
	$('img#popupImage4Id').attr('src', image4Val);	
	$("#shopFTProductImageId").val(image1Val);
	
	if(conSeptValues[1] === "null") {
		$("#popupImage2Id").hide();    	
	} else {
		$("#popupImage2Id").show();
	}
	if(conSeptValues[2] === "null") {
		$("#popupImage3Id").hide();    	
	} else {
		$("#popupImage3Id").show();
	}
	if(conSeptValues[3] === "null") {
		$("#popupImage4Id").hide();    	
	} else {
		$("#popupImage4Id").show();
	}
	$("#shopFTProductNameDspId").html(conSeptValues[4]);
	$("#shopFTProductNameId").val(conSeptValues[4]);
	$("#shopFTProductInfoSavingId").val(conSeptValues[5]);
		
/*Allocate Values to Price, description and heading*/

	$("#shopFTProductDescriptionId").val(conSeptValues[16]);
	$("#regProductDesc1ID").html(conSeptValues[16]);
	$("#regSizeDsplID").html(conSeptValues[6]);
	$("#regPriceDesp1ID").html(conSeptValues[7]);
	$("#shopFTProductSizeId").val(conSeptValues[6]);
	$("#shopFTProductPriceId").val(conSeptValues[7]);
		
/*Heading Radio Buttons Display Code*/
	
	var htmlVal;
	$('#selectedSizeId')[0].options.length = 0;	
	if(conSeptValues[6] !== "" && conSeptValues[6] !== null) {
		var conSeptValuesLt1 = conSeptValues[6];
		conSeptValuesLt1 = conSeptValuesLt1.replace(/"/g,"D"); conSeptValuesLt1 = conSeptValuesLt1.replace(/'/g,"S");
		$("#bdValueOptionHideId").hide();
		var priceVal7 = conSeptValues[7].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		var sizePriceComb1 = priceVal7 + "__" + conSeptValuesLt1;    	
    	htmlVal = '<option value="'+sizePriceComb1+'">'+conSeptValues[6]+'</option>';
    	$("#selectedSizeId").append(htmlVal);    	
	}
		
	if(conSeptValues[8] !== "") {
		var conSeptValuesLt2 = conSeptValues[8];
		conSeptValuesLt2 = conSeptValuesLt2.replace(/"/g,"D"); conSeptValuesLt2 = conSeptValuesLt2.replace(/'/g,"S");
		var priceVal9 = conSeptValues[9].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		var sizePriceComb2 = priceVal9 + "__" + conSeptValuesLt2;
		htmlVal = '<option value="'+sizePriceComb2+'">'+conSeptValues[8]+'</option>';
		$("#selectedSizeId").append(htmlVal);
	}
	
	if(conSeptValues[10] !== "") {
		var conSeptValuesLt3 = conSeptValues[10];
		conSeptValuesLt3 = conSeptValuesLt3.replace(/"/g,"D"); conSeptValuesLt3 = conSeptValuesLt3.replace(/'/g,"S");
		var priceVal11 = conSeptValues[11].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		var sizePriceComb3 = priceVal11 + "__" + conSeptValuesLt3;
		htmlVal = '<option value="'+sizePriceComb3+'">'+conSeptValues[10]+'</option>';
    	$("#selectedSizeId").append(htmlVal);
	}
	
	if(conSeptValues[12] !== "") {
		var conSeptValuesLt4 = conSeptValues[12];
		conSeptValuesLt4 = conSeptValuesLt4.replace(/"/g,"D"); conSeptValuesLt4 = conSeptValuesLt4.replace(/'/g,"S");
		var priceVal13 = conSeptValues[13].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		var sizePriceComb4 = priceVal13 + "__" + conSeptValuesLt4;
		htmlVal = '<option value="'+sizePriceComb4+'">'+conSeptValues[12]+'</option>';
    	$("#selectedSizeId").append(htmlVal);
	}
	
	if(conSeptValues[14] !== "") {
		var conSeptValuesLt5 = conSeptValues[14];
		conSeptValuesLt5 = conSeptValuesLt5.replace(/"/g,"D"); conSeptValuesLt5 = conSeptValuesLt5.replace(/'/g,"S");
		var priceVal15 = conSeptValues[15].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		var sizePriceComb5 = priceVal15 + "__" + conSeptValuesLt5;
		htmlVal = '<option value="'+sizePriceComb5+'">'+conSeptValues[14]+'</option>';
    	$("#selectedSizeId").append(htmlVal);
	}
	$("#shopFTProductStoreNameDspId").html(conSeptValues[17]);
	$("#shopFTProductStoreNameId").html(conSeptValues[17]);	
	
	if((conSeptValues[6] !== "") || (conSeptValues[8] !== "") || (conSeptValues[10] !== "") || (conSeptValues[12] !== "") || (conSeptValues[14] !== "") ) {
		$("#sizeTableDisplayId").show();
	} else {
		$("#sizeTableDisplayId").hide();
	}

	$("#popupImage1Id").css({"border-bottom": "red", "border-weight":"1px", "border-style":"solid"});
	$("#popupImage2Id").css({"border-bottom": "white", "border-weight":"1px", "border-style":"solid"});
	$("#popupImage3Id").css({"border-bottom": "white", "border-weight":"1px", "border-style":"solid"});
	$("#popupImage4Id").css({"border-bottom": "white", "border-weight":"1px", "border-style":"solid"});
	
			var id = '#dialog';
			var maskHeight = $(document).height();
			var maskWidth = $(window).width();
			$('#mask').css({'width':maskWidth,'height':maskHeight});
			$('#mask').fadeIn(100);	
			$('#mask').fadeTo("fast",0.9);
			var winH = $(window).height();
			var winW = $(window).width();
			$(id).css('top',  winH/2-$(id).height()/2);
			$(id).css('left', winW/2-$(id).width()/2);
			$(id).fadeIn(100);
			$('.window .close').click(function (e) {
			e.preventDefault();

			$('#mask').hide();
			$('.window').hide();
			});
			$('#mask').click(function () {
			$(this).hide();
			$('.window').hide();
			});	
		}
	
	
	$(".smlImgClickCl").each(function(){		
		$(this).click(function(){			
			$(".smlImgClickCl").css({"border-bottom": "white", "border-weight":"1px", "border-style":"solid"});
			$("#bigImgDsplayCl").attr("src",$(this).attr("src"));
			var currentId = $(this).attr("id");
			$("#"+currentId).css({"border-bottom": "red", "border-weight":"1px", "border-style":"solid"});
		});
	});
	
	$('#selectedSizeId').on('change', function() {		
		var selectedSizeList = $(this).val();
		selectedSizeList = selectedSizeList.replace(/[S]/g ,"'");
		selectedSizeList = selectedSizeList.replace(/[D]/g ,"\"");
		var selectedSizeValue = selectedSizeList.split("__");
		var selPriceValue = selectedSizeValue[0];
		var selSizeValue = selectedSizeValue[1];
		$("#displayDBPriceID").hide();
		$("#displaySelectPriceID").show();
		$("#shopFTProductPriceID").html(selPriceValue);
		$("#shopFTProductSizeId").val(selSizeValue);
		$("#shopFTProductPriceId").val(selPriceValue);		
	});
	
	});

	function furnamtureSpecProductInfo(combiValues) {
		combiValues = combiValues.replace(/DoubleQuotes/g, "\"");
		combiValues = combiValues.replace(/SingleQuotes/g, "\'");		
		furnamtureSpecProductValue(combiValues);
	}


