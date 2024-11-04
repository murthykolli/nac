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
	.reg_sc_popup_prod_name_hd { font: normal 1.15em/1.5em Georgia; text-align: left; letter-spacing: 1px; color: black; margin-top: -5px; padding-bottom: 15px; text-transform: uppercase; }
	.reg_sc_popup_prod_price_hd { font: bold 1.2em/1.25em Georgia; text-align: left; letter-spacing: 1px; color: black; margin-top: 0px; padding-bottom: 15px; text-transform: uppercase; }
	.reg_sc_popup_prod_quantity_hd { font: normal 0.95em/1.5em Georgia; text-align: left; letter-spacing: 1px; color: black; margin-top: 0px; padding-bottom: 15px; text-transform: uppercase; }
	.reg_sc_enb_gg_text_dsp { font: normal 0.95em/1.5em Georgia; text-align: left; letter-spacing: 1px; color: black; margin-top: 0px; text-transform: uppercase; }
	.reg_lnd_popup_prod_store_name_hd { font: italic 1.05em/1.25em Georgia; text-align: left; letter-spacing: 2px; color: black; margin-top: 0px; padding-bottom: 15px; }
	</style>	
<!-- Pop up CSS Code Start -->
	<style type="text/css">
	#popupImage1Id { border-bottom: 1px solid white; padding-bottom: 5px; }
	#popupImage2Id { border-bottom: 1px solid white; padding-bottom: 5px; }
	#popupImage3Id { border-bottom: 1px solid white; padding-bottom: 5px; }
	#popupImage4Id { border-bottom: 1px solid white; padding-bottom: 5px; }	
	.mytooltip .mytext { visibility: hidden; width: 320px; background-color: #3c3c3c; color: #fff; z-index: 1; top: -37px; left: 170%; border-radius: 6px; padding: 15px; position: absolute; font: normal 1.15em/1.5em Georgia; text-align: left; letter-spacing: 1px; text-transform: capitalize; box-shadow: 4px 4px #bababa; }
    .mytooltip { position: relative; display: inline-block; margin-left: 50px; } 
    .mytooltip .mytext:after { content: ""; position: absolute; top: 50%; right: 100%; margin-top: -5px; border-width: 6px; border-style: solid; border-color: transparent #3c3c3c transparent transparent; }
    .mytooltip:hover .mytext { visibility: visible; }
    .reg_popup_pro_sub_left_frame_dsp { height: 300px; margin-top: 0px; vertical-align: middle; margin-bottom: 30px; }
    .reg_popup_pro_big_image_disl { height: 310px; object-fit: scale-down; position: relative; object-position: 50% 50%; overflow: auto; overflow-y: hidden; overflow-x: hidden; width: 100%; }    	
	}
	</style>
	
	<script type="text/javascript">	
	$(document).ready(function () {	
	$("#enableGroupOffId").click(function () { $("#enableGroupOffId").hide(); $("#enableGroupOnId").show(); $("#enableGroupGiftId").val(""); });
	$("#enableGroupOnId").click(function () { $("#enableGroupOffId").show(); $("#enableGroupOnId").hide(); $("#enableGroupGiftId").val("Enable Group Gift"); });			
	$('#selectedSizeId').on('change', function() {		
		var selectedSizeList = $(this).val(); selectedSizeList = selectedSizeList.replace(/[S]/g ,"'"); selectedSizeList = selectedSizeList.replace(/[D]/g ,"\""); var selectedSizeValue = selectedSizeList.split("__"); var selPriceValue = selectedSizeValue[0]; var selSizeValue = selectedSizeValue[1];
		$("#displayDBPriceID").hide(); $("#displaySelectPriceID").show(); $("#regSelectedPriceID").html(selPriceValue); $("#regProductSizeId").val(selSizeValue); $("#registryPriceId").val(selPriceValue); });	
	var conSeptValuesQut1 = "<c:out value="${productSize}"/>"; var conSeptValuesLet1 = "<c:out value="${productSize}"/>"; conSeptValuesQut1 = conSeptValuesQut1.replace(/&amp;#034;/g,"\""); conSeptValuesQut1 = conSeptValuesQut1.replace(/&amp;#039;/g,"'"); conSeptValuesLet1 = conSeptValuesLet1.replace(/&amp;#034;/g,"D"); conSeptValuesLet1 = conSeptValuesLet1.replace(/&amp;#039;/g,"S"); var htmlValue = '<option value="'+conSeptValuesLet1+'">'+conSeptValuesQut1+'</option>'; $("#bdValueOptionHideId").append(htmlValue); });
	</script>
	
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container"> <div class="row"> <div class="col-md-12 col-sm-12" style="margin-top: -30px; margin-left: -15px;">
        <div align="right"> <a href="registryOverview"><img src="resources/images/registry/close_img.png" onmouseover="this.src='resources/images/registry/close_mo_img.png'" onmouseout="this.src='resources/images/registry/close_img.png'" border="0" title="CLOSE"></a></div> </div> </div>
        <div class="row" style="padding: 20px;"> <div class="col-md-5 col-sm-5"> <div class="reg_popup_pro_sub_left_frame_dsp"> <img id="bigImgDsplayCl" class="reg_popup_pro_big_image_disl"> </div>
		<div class="row"> <div class="col-md-3 col-sm-3"> <img class="smlImgClickCl" id="popupImage1Id"> </div>					       	
		<div class="col-md-3 col-sm-3"> <img class="smlImgClickCl" id="popupImage2Id"> </div>					        	
		<div class="col-md-3 col-sm-3"> <img class="smlImgClickCl" id="popupImage3Id"> </div>
		<div class="col-md-3 col-sm-3"> <img class="smlImgClickCl" id="popupImage4Id"> </div> </div> </div>
		<div class="col-md-7 col-sm-7"> <div style="padding-left: 10px;">
		<form action="finTouchesSelectedProductDataUpdate" method="POST">
		<div class="reg_sc_popup_prod_name_hd"><font id="regProductNameID"></font></div>
		<div class="reg_lnd_popup_prod_store_name_hd"><font id="regProductStoreNameID"></font></div>
		<div class="reg_sc_popup_prod_price_hd" id="displaySelectPriceID" style="display: none;">$<font id="regSelectedPriceID"></font></div>			        	
		<div class="reg_sc_popup_prod_price_hd" id="displayDBPriceID">$${productsPrice}</div>
		<div class="reg_popup_prod_sub_frame_dsp">
		<div align="left" class="reg_sc_popup_prod_quantity_hd" style="margin-top: 5px;">QUANTITY</div>
		<div align="left"> <select id="productQuantityId" name="productQuantity" class="reg_popup_prod_sel_box_qunty"> 
		<option value="1">1</option> <option value="2">2</option> <option value="3">3</option> <option value="4">4</option> <option value="5">5</option> <option value="6">6</option> <option value="7">7</option> <option value="8">8</option> <option value="9">9</option> <option value="10">10</option> </select> </div>
		<div class="reg_sc_popup_prod_quantity_hd" style="margin-top: 20px;">
		<div id="enableGGTextDspYesId"> <div class="reg_sc_enb_gg_text_dsp">ENABLE GROUP GIFTING&nbsp;&nbsp; <div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer;" class="fa">&#xf059;</i>
	    <span class="mytext" style="margin-top: -115px;"> Receive cash contributions towards this item and purchase once the total has been met. <br><br>A nominal tax and shipping fee will be added to the group gift goal to ensure you have enough funds to purchase. <br><br>The group gifting feature cannot be disabled once contributions towards a gift have begun. </span> </div> </div> </div>
      	<div id="enableGGTextDspNoId" style="display: none;"> <div class="reg_sc_enb_gg_text_dsp">ENABLE GROUP GIFTING&nbsp;&nbsp; <div class="mytooltip" style="margin-left: 0px;"><i style="font-size: 18px; cursor: pointer;" class="fa">&#xf059;</i>
	    <span class="mytext" style="margin-top: -15px;"> Either one or multiple guests have already contributed towards this item, therefore you can no longer disable the Group Gifting feature. </span> </div> </div> </div>
      	<div id="enableGGButtonDspYesId"> <div style="margin-top: 20px; cursor: pointer;" id="enableGroupOnId">
		<div style="background: #bfbfbf; border: 1px solid #bfbfbf; width: 60px; height: 19px; border-radius: 25px; box-shadow: inset 6px 6px 6px -6px black;">
		<div style="height: 16px; width: 16px; background-color: #fff; border-radius: 50%; display: inline-block; margin-left: 5px; margin-top: 1px; "></div> </div> </div>
		<div style="margin-top: 20px; display: none; cursor: pointer;" id="enableGroupOffId">
		<div style="background: #00b050; border: 1px solid #00b050; width: 60px; height: 19px; border-radius: 25px; box-shadow: inset 6px 6px 6px -6px black;">
		<div style="height: 16px; width: 16px; background-color: #fff; border-radius: 50%; display: inline-block; margin-left: 35px; margin-top: 1px; "></div> </div> </div> </div>
		<div id="enableGGButtonDspNoId" style="display: none;"> <div style="margin-top: 20px; cursor: pointer;" id="enableGroupOn1Id">
		<div style="background: #bfbfbf; border: 1px solid #bfbfbf; width: 60px; height: 19px; border-radius: 25px; box-shadow: inset 6px 6px 6px -6px black;">
		<div style="height: 16px; width: 16px; background-color: #fff; border-radius: 50%; display: inline-block; margin-left: 5px; margin-top: 1px; "></div> </div> </div>
		<div style="margin-top: 20px; display: none; cursor: pointer;" id="enableGroupOff1Id">
		<div style="background: #00b050; border: 1px solid #00b050; width: 60px; height: 19px; border-radius: 25px; box-shadow: inset 6px 6px 6px -6px black;">
		<div style="height: 16px; width: 16px; background-color: #fff; border-radius: 50%; display: inline-block; margin-left: 35px; margin-top: 1px; "></div> </div> </div> </div>
		<div style="margin-top: 15px;" id="sizeTableDisplayId">
		<table> <tr> <td align="left" class="reg_popup_prod_quantity_hd" style="margin-top: 0px;font: 1em/1.25em Georgia; letter-spacing: 1px;">SELECT: &nbsp;</td><tr>
		<tr><td align="left"> <select id="selectedSizeId" class="reg_popup_prod_sel_box_size" name="registrySize" style="margin-top: -8px;"> <option id="bdValueOptionHideId"></option> </select> </td></tr> </table> </div>
		<div style="margin-top: 25px;"> <button class="regi_add_to_registry_sbut">ADD TO REGISTRY</button> </div> </div> </div>
		<div style="margin-top: 15px;"> <div class="reg_sc_popup_prod_quantity_hd">DESCRIPTION</div>
		<div class="reg_sc_popup_prod_quantity_hd">${productsDescription}</div> </div>
		<input type="hidden" id="enableGroupGiftId" name="groupGiftRefferanceValue"> <input type="hidden" id="productInfoSavingId" name="ftProductsInfoSavingId"> <input type="hidden" id="regProductSizeId" name="productHeading"> <input type="hidden" id="registryPriceId" name="productPrice"> <input type="hidden" id="productDescriptionId" name="productDescription">
		</form> </div> </div> </div> </div> </div>
        
        <script type="text/javascript">        
        $(document).ready(function() { $("#enableGroupOffId").hide(); $("#enableGroupOnId").show(); $("#enableGroupOn1Id").show(); $("#enableGroupOff1Id").hide(); $("#enableGroupGiftId").val(""); $("#hidePriceFromGuestId").prop("checked", false); $("[name=productQuantity]").val("1"); var totalProdPopUpValues = "<c:out value="${totalProdPopUpValuesList}"/>"; var conSeptValues = totalProdPopUpValues.split("_,_"); $("#regProductNameID").html(conSeptValues[0]);	
		var image1Val = "data:image/jpg;base64,"+conSeptValues[1]+""; var image2Val = "data:image/jpg;base64,"+conSeptValues[2]+""; var image3Val = "data:image/jpg;base64,"+conSeptValues[3]+""; var image4Val = "data:image/jpg;base64,"+conSeptValues[4]+"";
		$('img#bigImgDsplayCl').attr('src', image1Val); $('img#popupImage1Id').attr('src', image1Val); $('img#popupImage2Id').attr('src', image2Val); $('img#popupImage3Id').attr('src', image3Val); $('img#popupImage4Id').attr('src', image4Val);
		if(conSeptValues[2] === "null") { $("#popupImage2Id").hide(); } else { $("#popupImage2Id").show(); }
		if(conSeptValues[3] === "null") { $("#popupImage3Id").hide(); } else { $("#popupImage3Id").show(); }
		if(conSeptValues[4] === "null") { $("#popupImage4Id").hide(); } else { $("#popupImage4Id").show(); }
		$("#productInfoSavingId").val(conSeptValues[5]);		
	/*Heading Radio Buttons Display Code*/			
		var htmlVal;		
		if(conSeptValues[6] !== "") { var conSeptValuesCon1 = conSeptValues[6]; var conSeptValuesLt1 = conSeptValues[6];
			conSeptValuesCon1 = conSeptValuesCon1.replace(/&amp;#034;/g,"\""); conSeptValuesCon1 = conSeptValuesCon1.replace(/&amp;#039;/g,"'"); conSeptValuesLt1 = conSeptValuesLt1.replace(/&amp;#034;/g,"D"); conSeptValuesLt1 = conSeptValuesLt1.replace(/&amp;#039;/g,"S");
			$("#bdValueOptionHideId").hide(); var priceVal7 = conSeptValues[7].replace(/\B(?=(\d{3})+(?!\d))/g, ","); var sizePriceComb1 = priceVal7 + "__" + conSeptValuesLt1; htmlVal = '<option value="'+sizePriceComb1+'">'+conSeptValuesCon1+'</option>'; $("#selectedSizeId").append(htmlVal);    	
		}			
		if(conSeptValues[8] !== "") { var conSeptValuesCon2 = conSeptValues[8]; var conSeptValuesLt2 = conSeptValues[8];
			conSeptValuesCon2 = conSeptValuesCon2.replace(/&amp;#034;/g,"\""); conSeptValuesCon2 = conSeptValuesCon2.replace(/&amp;#039;/g,"'"); conSeptValuesLt2 = conSeptValuesLt2.replace(/&amp;#034;/g,"D"); conSeptValuesLt2 = conSeptValuesLt2.replace(/&amp;#039;/g,"S");
			var priceVal9 = conSeptValues[9].replace(/\B(?=(\d{3})+(?!\d))/g, ","); var sizePriceComb2 = priceVal9 + "__" + conSeptValuesLt2; htmlVal = '<option value="'+sizePriceComb2+'">'+conSeptValuesCon2+'</option>'; $("#selectedSizeId").append(htmlVal);
		}		
		if(conSeptValues[10] !== "") { var conSeptValuesCon3 = conSeptValues[10]; var conSeptValuesLt3 = conSeptValues[10];
			conSeptValuesCon3 = conSeptValuesCon3.replace(/&amp;#034;/g,"\""); conSeptValuesCon3 = conSeptValuesCon3.replace(/&amp;#039;/g,"'"); conSeptValuesLt3 = conSeptValuesLt3.replace(/&amp;#034;/g,"D"); conSeptValuesLt3 = conSeptValuesLt3.replace(/&amp;#039;/g,"S");
			var priceVal11 = conSeptValues[11].replace(/\B(?=(\d{3})+(?!\d))/g, ","); var sizePriceComb3 = priceVal11 + "__" + conSeptValuesLt3; htmlVal = '<option value="'+sizePriceComb3+'">'+conSeptValuesCon3+'</option>'; $("#selectedSizeId").append(htmlVal);
		}		
		if(conSeptValues[12] !== "") { var conSeptValuesCon4 = conSeptValues[12]; var conSeptValuesLt4 = conSeptValues[12];
			conSeptValuesCon4 = conSeptValuesCon4.replace(/&amp;#034;/g,"\""); conSeptValuesCon4 = conSeptValuesCon4.replace(/&amp;#039;/g,"'"); conSeptValuesLt4 = conSeptValuesLt4.replace(/&amp;#034;/g,"D"); conSeptValuesLt4 = conSeptValuesLt4.replace(/&amp;#039;/g,"S");
			var priceVal13 = conSeptValues[13].replace(/\B(?=(\d{3})+(?!\d))/g, ","); var sizePriceComb4 = priceVal13 + "__" + conSeptValuesLt4; htmlVal = '<option value="'+sizePriceComb4+'">'+conSeptValuesCon4+'</option>'; $("#selectedSizeId").append(htmlVal);
		}		
		if(conSeptValues[14] !== "") { var conSeptValuesCon5 = conSeptValues[14]; var conSeptValuesLt5 = conSeptValues[14];
			conSeptValuesCon5 = conSeptValuesCon5.replace(/&amp;#034;/g,"\""); conSeptValuesCon5 = conSeptValuesCon5.replace(/&amp;#039;/g,"'"); conSeptValuesLt5 = conSeptValuesLt5.replace(/&amp;#034;/g,"D"); conSeptValuesLt5 = conSeptValuesLt5.replace(/&amp;#039;/g,"S");
			var priceVal15 = conSeptValues[15].replace(/\B(?=(\d{3})+(?!\d))/g, ","); var sizePriceComb5 = priceVal15 + "__" + conSeptValuesLt5; htmlVal = '<option value="'+sizePriceComb5+'">'+conSeptValuesCon5+'</option>'; $("#selectedSizeId").append(htmlVal);
		}
		if((conSeptValues[6] !== "") || (conSeptValues[8] !== "") || (conSeptValues[10] !== "") || (conSeptValues[12] !== "") || (conSeptValues[14] !== "") ) { $("#sizeTableDisplayId").show(); } else { $("#sizeTableDisplayId").hide(); }
		if(conSeptValues[18] === "Contributed") { $("#enableGroupOffId").show(); $("#enableGroupOnId").hide(); $("#enableGroupGiftId").val("Enable Group Gift"); $("#productQuantityId").val(conSeptValues[19]); } else { $("#enableGroupGiftId").val(""); $("#productQuantityId").val(conSeptValues[19]); } $("#regProductStoreNameID").html(conSeptValues[21]);		
		if(conSeptValues[17] === "This transaction has been approved.") { $("#enableGGTextDspYesId").hide(); $("#enableGGTextDspNoId").show(); $("#enableGGButtonDspYesId").hide(); $("#enableGGButtonDspNoId").show(); if(conSeptValues[18] === "Contributed") { $("#enableGroupOff1Id").show(); $("#enableGroupOn1Id").hide(); } else { $("#enableGroupOff1Id").hide(); $("#enableGroupOn1Id").show(); } $("#selectedSizeId").attr("disabled","disabled");
	 	} else { $("#enableGGButtonDspYesId").show(); $("#enableGGButtonDspNoId").hide(); $("#enableGroupOffId").click(function () { $("#enableGroupOffId").hide(); $("#enableGroupOnId").show(); $("#enableGroupGiftId").val(""); }); $("#enableGroupOnId").click(function () { $("#enableGroupOffId").show(); $("#enableGroupOnId").hide(); $("#enableGroupGiftId").val("Enable Group Gift"); }); }
		$(".smlImgClickCl").each(function() { $("#popupImage1Id").css({"border-bottom": "red", "border-weight":"1px", "border-style":"solid"});
		$(this).click(function() { $(".smlImgClickCl").css({"border-bottom": "white", "border-weight":"1px", "border-style":"solid"}); $("#bigImgDsplayCl").attr("src",$(this).attr("src")); var currentId = $(this).attr("id"); $("#"+currentId).css({"border-bottom": "red", "border-weight":"1px", "border-style":"solid"}); }); });
		var productSize1 = "<c:out value="${productSize}"/>"; var priceValue = "<c:out value="${productsPrice}"/>"; var productCount = "<c:out value="${productsCount}"/>"; var enableGroupGifts = "<c:out value="${enableGroupGift}"/>"; var hidePriceGuests = "<c:out value="${hidePriceGuest}"/>";		
		productSize1 = productSize1.replace(/\&amp;/g,"&"); productSize1 = productSize1.replace(/&#034;/g,"\""); productSize1 = productSize1.replace(/&#039;/g,"'"); productSize1 = productSize1.replace(/&lt;/g,"<"); productSize1 = productSize1.replace(/&gt;/g,">");
		
		if(enableGroupGifts === "Enable Group Gift") { $("#enableGroupOffId").show(); $("#enableGroupOff1Id").show(); $("#enableGroupOnId").hide(); $("#enableGroupOn1Id").hide(); $("#enableGroupGiftId").val("Enable Group Gift"); }
		if(hidePriceGuests === "Hide Price From Guest") { $("#hidePriceFromGuestId").prop("checked", true); }		
		$("#regProductSizeId").val(productSize1); $("#registryPriceId").val(priceValue); $("#regProductOPPriceID").html(priceValue.replace(/\B(?=(\d{3})+(?!\d))/g, ",")); $("#selectedSizeId").val(productSize1); $("[name=productQuantity]").val(productCount);
		$('#productQuantityId').on('change', function() {		
			if(conSeptValues[17] === "This transaction has been approved.") { var regContributedQuantity = conSeptValues[20]; var contributedQuantityDb = parseFloat(regContributedQuantity); var requestedQuantity = parseFloat(this.value);	
				if(contributedQuantityDb > requestedQuantity) { alert("You can not reduce the quantity requested to a lesser value than what guests have already gifted."); $("#productQuantityId").val(requestedQuantity); } } }); });
    	</script>    	
		</body>
</html>
