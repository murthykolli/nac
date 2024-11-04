
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />	
	<script type="text/javascript">
 	$(document).ready(function() { $("#guestFRCountId").val(1); var guestAddCartReff1 = "<c:out value="${guestAddCartReff}"/>";
 		if(guestAddCartReff1 === "Add To Cart") { alert("This product has been added to your Cart"); } var priceReg = /^[0-9\.]+$/;
 		$("#conBoardProductQuantityId").keyup(function() { if(priceReg.test(this.value)){ $("#conBoardProductQuantityId").css("border-color","black"); } else{ $("#conBoardProductQuantityId").css("border-color","red"); result=false; } }); 	 	
 	 	$('input#conBoardProductQuantityId').keypress(function(e) { if (this.value.length == 0 && e.which == 48 ) { return false; } }); });
	function selectedCBIndividualInfoAddToCart(cbIndividualSavingId, cbIndividualNeedQuantity) { var quantityId = "conBoardProductQuantityId" + cbIndividualSavingId; var indQuantity = $("#"+quantityId).val();
		if((indQuantity == "") || (indQuantity == "0")) { alert("Please enter valid number"); return false }		
		else { var cbIndividualNeedQuantityValue = parseFloat(cbIndividualNeedQuantity); var givenQuantityValue = parseInt(indQuantity); if(givenQuantityValue > cbIndividualNeedQuantityValue) { alert("Please make sure the quantity that you wish to gift is equivalent to or less than the quantity requested."); return false; } } }
	
	$("#finTouchesProductQuantityId").keyup(function() { if(priceReg.test(this.value)){ $("#finTouchesProductQuantityId").css("border-color","black"); } else{ $("#finTouchesProductQuantityId").css("border-color","red"); result=false; } 	 	
	 	$('input#finTouchesProductQuantityId').keypress(function(e) { if (this.value.length == 0 && e.which == 48 ) { return false; } }); });
	function selectedFTIndividualInfoAddToCart(ftIndividualSavingId, ftIndividualNeedQuantity) { var quantityId = "finTouchesProductQuantityId" + ftIndividualSavingId; var indQuantity = $("#"+quantityId).val();
		if((indQuantity == "") || (indQuantity == "0")) { alert("Please enter valid number"); return false }		
		else { var ftIndividualNeedQuantityValue = parseFloat(ftIndividualNeedQuantity); var givenQuantityValue = parseInt(indQuantity); if(givenQuantityValue > ftIndividualNeedQuantityValue) { alert("Please make sure the quantity that you wish to gift is equivalent to or less than the quantity requested."); return false; } } }
		
 	function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0));
 		if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }
    </script>
    
	</head>
	
		<body>			
		<div class="container-fluid" style="margin-top: 75px;">        
        <img src="<c:out value='${guestBackgroungImage}'/>" style="position: relative; top:0px; left:0px; width: 100%; height: 350px; z-index:-1;">       
        <div style="margin-top: -140px; margin-left: 200px;"> <div class="regi_circle_uploaded_image"><div style="font: 1.8em/1.5em Georgia; letter-spacing: 3px; color: black; position: relative; top: 0px; text-align: center;">${regUploadedPhoto}</div></div>
	    <div style="margin-left: 60px; margin-top: -20px;"> <div class="reg_first_and_sec_name_dsp_cl"><c:out value='${regFirstName}'/></div>
		<div class="reg_event_date_dsp_cl"><c:out value='${eventDate}'/></div>		        
		<div class="reg_message_for_guest_dsp_cl" style="pointer-events: none;">${registrantMessage}</div> </div> </div> </div>				
		<div id="mainframe" class="section-content" style="margin-top: 50px;"> <div class="container">               
<!-- SELECTED GIFT CARDS COADING START -->    
        <div class="row" id="allFundsFrameDisplayId"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10"> <div class="row">		        
<!-- 1rd Column -->
		<%	String livingRoomFund = (String)session.getAttribute("livingRoomFundSn");
			if (null != livingRoomFund) { String[] livingRoomCombVal = livingRoomFund.split("__");
				for (int i = 0; i < livingRoomCombVal.length; i++) { String[] livingRoomColumnValue = livingRoomCombVal[i].split("_,_"); double regiGivenAmount1Db = 0;
					if(null != livingRoomColumnValue[1]) { regiGivenAmount1Db = Double.parseDouble(livingRoomColumnValue[1]); }
					int count = (i + 1); String lrColumnCount = livingRoomColumnValue[0]; String totalLivingRoomFundsAmount1 = (String)session.getAttribute("totalLivingRoomFundsAmount"); double totalFundAmount1 = 0;
					if (null != totalLivingRoomFundsAmount1) { String[] totLivingRoomFundAmount = totalLivingRoomFundsAmount1.split("__"); totalFundAmount1 = Double.parseDouble(totLivingRoomFundAmount[i]); }
					double stillNeedAmount1Db = regiGivenAmount1Db - totalFundAmount1; String stillNeedAmount1 = Double.toString(stillNeedAmount1Db); if(stillNeedAmount1Db < 1 && regiGivenAmount1Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/livingroomfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">LIVING ROOM FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount1%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div>  
   		<% } else { %>   			
       	<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/livingroomfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">LIVING ROOM FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="livingroomfund.jpg"> <input type="hidden" name="guestSpaceName" value="LIVING ROOM FUND"> <input type="hidden" name="guSpaceColName" value="living_room"> <input type="hidden" name="guSpaceColCount" value="<%=lrColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount1%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount1%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
   		<% } } } %>   			   			   
<!-- 2th Column -->
		<%	String diningRoomFund = (String)session.getAttribute("diningRoomFundSn");
			if (null != diningRoomFund) { String[] diningRoomCombVal = diningRoomFund.split("__");
				for (int i = 0; i < diningRoomCombVal.length; i++) { String[] diningRoomColumnValue = diningRoomCombVal[i].split("_,_"); double regiGivenAmount2Db = 0;
					if(null != diningRoomColumnValue[1]) { regiGivenAmount2Db = Double.parseDouble(diningRoomColumnValue[1]); }
					int count = (i + 1); String drColumnCount = diningRoomColumnValue[0]; String totalDyningRoomFundsAmount1 = (String)session.getAttribute("totalDyningRoomFundsAmount"); double totalFundAmount2 = 0;
					if (null != totalDyningRoomFundsAmount1) { String[] totDyningRoomFundsAmount1 = totalDyningRoomFundsAmount1.split("__"); totalFundAmount2 = Double.parseDouble(totDyningRoomFundsAmount1[i]); }						
					double stillNeedAmount2Db = regiGivenAmount2Db - totalFundAmount2; String stillNeedAmount2 = Double.toString(stillNeedAmount2Db); if(stillNeedAmount2Db < 1 && regiGivenAmount2Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/diningroomfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">DINING ROOM FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount2%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
   		<% } else { %>
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/diningroomfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">DINING ROOM FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="diningroomfund.jpg"> <input type="hidden" name="guestSpaceName" value="DINING ROOM FUND"> <input type="hidden" name="guSpaceColName" value="dining_room"> <input type="hidden" name="guSpaceColCount" value="<%=drColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount2%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount2%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } } } %>   			   
<!-- 3th Column -->
		<% 	String bedroomFund = (String)session.getAttribute("bedroomFundSn");
			if (null != bedroomFund) { String[] bedroomCombVal = bedroomFund.split("__");
				for (int i = 0; i < bedroomCombVal.length; i++) { String[] bedroomColumnValue = bedroomCombVal[i].split("_,_"); double regiGivenAmount3Db = 0;
					if(null != bedroomColumnValue[1]) { regiGivenAmount3Db = Double.parseDouble(bedroomColumnValue[1]); }
					int count = (i + 1); String brColumnCount = bedroomColumnValue[0]; String totalBedRoomFundsAmount1 = (String)session.getAttribute("totalBedRoomFundsAmount"); double totalFundAmount3 = 0;
					if (null != totalBedRoomFundsAmount1) { String[] totBedRoomFundsAmount1 = totalBedRoomFundsAmount1.split("__"); totalFundAmount3 = Double.parseDouble(totBedRoomFundsAmount1[i]); }
					double stillNeedAmount3Db = regiGivenAmount3Db - totalFundAmount3; String stillNeedAmount3 = Double.toString(stillNeedAmount3Db); if(stillNeedAmount3Db < 1 && regiGivenAmount3Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/bedroomfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">BEDROOM FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount3%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } else { %>
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/bedroomfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">BEDROOM FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="bedroomfund.jpg"> <input type="hidden" name="guestSpaceName" value="BEDROOM FUND"> <input type="hidden" name="guSpaceColName" value="bedroom"> <input type="hidden" name="guSpaceColCount" value="<%=brColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount3%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount3%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } } } %>   			
<!-- 4th Column -->
		<% 	String homeOfficeFund = (String)session.getAttribute("homeOfficeFundSn");
			if (null != homeOfficeFund) { String[] homeOfficeCombVal = homeOfficeFund.split("__");
				for (int i = 0; i < homeOfficeCombVal.length; i++) { String[] homeOfficeColumnValue = homeOfficeCombVal[i].split("_,_"); double regiGivenAmount4Db = 0;
				if(null != homeOfficeColumnValue[1]) { regiGivenAmount4Db = Double.parseDouble(homeOfficeColumnValue[1]); }
				int count = (i + 1); String hoColumnCount = homeOfficeColumnValue[0]; String totalHomeOfficeRoomFundsAmount1 = (String)session.getAttribute("totalHomeOfficeRoomFundsAmount"); double totalFundAmount4 = 0;
				if (null != totalHomeOfficeRoomFundsAmount1) { String[] totHomeOfficeRoomFundsAmount1 = totalHomeOfficeRoomFundsAmount1.split("__"); totalFundAmount4 = Double.parseDouble(totHomeOfficeRoomFundsAmount1[i]); }
				double stillNeedAmount4Db = regiGivenAmount4Db - totalFundAmount4; String stillNeedAmount4 = Double.toString(stillNeedAmount4Db); if(stillNeedAmount4Db < 1 && regiGivenAmount4Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/homeofficefund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">HOME OFFICE FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount4%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } else { %>   			 
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/homeofficefund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">HOME OFFICE FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="homeofficefund.jpg"> <input type="hidden" name="guestSpaceName" value="HOME OFFICE FUND"> <input type="hidden" name="guSpaceColName" value="home_office"> <input type="hidden" name="guSpaceColCount" value="<%=hoColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount4%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount4%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } } } %>   			
<!-- 5th Column -->
		<% 	String entrywayFund = (String)session.getAttribute("entrywayFundSn");
			if (null != entrywayFund) { String[] entrywayCombVal = entrywayFund.split("__");
				for (int i = 0; i < entrywayCombVal.length; i++) { String[] entrywayColumnValue = entrywayCombVal[i].split("_,_"); double regiGivenAmount5Db = 0;
				if(null != entrywayColumnValue[1]) { regiGivenAmount5Db = Double.parseDouble(entrywayColumnValue[1]); }
				int count = (i + 1); String ewColumnCount = entrywayColumnValue[0]; String totalEntryWayRoomFundsAmount1 = (String)session.getAttribute("totalEntryWayRoomFundsAmount"); double totalFundAmount5 = 0;
				if (null != totalEntryWayRoomFundsAmount1) { String[] totEntryWayRoomFundsAmount1 = totalEntryWayRoomFundsAmount1.split("__"); totalFundAmount5 = Double.parseDouble(totEntryWayRoomFundsAmount1[i]); }
				double stillNeedAmount5Db = regiGivenAmount5Db - totalFundAmount5; String stillNeedAmount5 = Double.toString(stillNeedAmount5Db); if(stillNeedAmount5Db < 1 && regiGivenAmount5Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/entrywayfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">ENTRYWAY FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount5%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 			
        <% } else { %>   			 
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/entrywayfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">ENTRYWAY FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="entrywayfund.jpg"> <input type="hidden" name="guestSpaceName" value="ENTRYWAY FUND"> <input type="hidden" name="guSpaceColName" value="entryway"> <input type="hidden" name="guSpaceColCount" value="<%=ewColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount5%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount5%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div>			
        <% } } } %>   			 
<!-- 6th Column -->
		<% 	String nurseryFund = (String)session.getAttribute("nurseryFundSn");
			if (null != nurseryFund) { String[] nurseryCombVal = nurseryFund.split("__");
				for (int i = 0; i < nurseryCombVal.length; i++) { String[] nurseryColumnValue = nurseryCombVal[i].split("_,_"); double regiGivenAmount6Db = 0;
				if(null != nurseryColumnValue[1]) { regiGivenAmount6Db = Double.parseDouble(nurseryColumnValue[1]); }
				int count = (i + 1); String nrColumnCount = nurseryColumnValue[0]; String totalNurseryRoomFundsAmount1 = (String)session.getAttribute("totalNurseryRoomFundsAmount"); double totalFundAmount6 = 0;
				if (null != totalNurseryRoomFundsAmount1) { String[] totNurseryRoomFundsAmount1 = totalNurseryRoomFundsAmount1.split("__"); totalFundAmount6 = Double.parseDouble(totNurseryRoomFundsAmount1[i]); }
				double stillNeedAmount6Db = regiGivenAmount6Db - totalFundAmount6; String stillNeedAmount6 = Double.toString(stillNeedAmount6Db); if(stillNeedAmount6Db < 1 && regiGivenAmount6Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/nurseryfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">NURSERY FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount6%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 			
        <% } else { %>
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/nurseryfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">NURSERY FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="nurseryfund.jpg"> <input type="hidden" name="guestSpaceName" value="NURSERY FUND"> <input type="hidden" name="guSpaceColName" value="nursery"> <input type="hidden" name="guSpaceColCount" value="<%=nrColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount6%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount6%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 			
        <% } } } %>   			
<!-- 7th Column -->
		<% 	String kidsBedroomFund = (String)session.getAttribute("kidsBedroomFundSn");
			if (null != kidsBedroomFund) { String[] kidsBedroomCombVal = kidsBedroomFund.split("__");
				for (int i = 0; i < kidsBedroomCombVal.length; i++) { String[] kidsBedroomColumnValue = kidsBedroomCombVal[i].split("_,_"); double regiGivenAmount7Db = 0;
				if(null != kidsBedroomColumnValue[1]) { regiGivenAmount7Db = Double.parseDouble(kidsBedroomColumnValue[1]); }
				int count = (i + 1); String kbrColumnCount = kidsBedroomColumnValue[0]; String totalKidsBedRoomRoomFundsAmount1 = (String)session.getAttribute("totalKidsBedRoomRoomFundsAmount"); double totalFundAmount7 = 0;
				if (null != totalKidsBedRoomRoomFundsAmount1) { String[] totKidsBedRoomRoomFundsAmount1 = totalKidsBedRoomRoomFundsAmount1.split("__"); totalFundAmount7 = Double.parseDouble(totKidsBedRoomRoomFundsAmount1[i]); }
				double stillNeedAmount7Db = regiGivenAmount7Db - totalFundAmount7; String stillNeedAmount7 = Double.toString(stillNeedAmount7Db); if(stillNeedAmount7Db < 1 && regiGivenAmount7Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/kidsbedroomfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">KIDS BEDROOM FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount7%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 			
        <% } else { %>
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/kidsbedroomfund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">KIDS BEDROOM FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="kidsbedroomfund.jpg"> <input type="hidden" name="guestSpaceName" value="KIDS BEDROOM FUND"> <input type="hidden" name="guSpaceColName" value="kids_bedroom"> <input type="hidden" name="guSpaceColCount" value="<%=kbrColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount7%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount7%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 			
        <% } } } %>   			  
<!-- 8th Column -->
		<% 	String playAreaFund = (String)session.getAttribute("playAreaFundSn");
			if (null != playAreaFund) { String[] playAreaCombVal = playAreaFund.split("__");
				for (int i = 0; i < playAreaCombVal.length; i++) { String[] playAreaColumnValue = playAreaCombVal[i].split("_,_"); double regiGivenAmount8Db = 0;
				if(null != playAreaColumnValue[1]) { regiGivenAmount8Db = Double.parseDouble(playAreaColumnValue[1]); }
				int count = (i + 1); String paColumnCount = playAreaColumnValue[0]; String totalPlayAreaRoomFundsAmount1 = (String)session.getAttribute("totalPlayAreaRoomFundsAmount"); double totalFundAmount8 = 0;
				if (null != totalPlayAreaRoomFundsAmount1) { String[] totPlayAreaRoomFundsAmount1 = totalPlayAreaRoomFundsAmount1.split("__"); totalFundAmount8 = Double.parseDouble(totPlayAreaRoomFundsAmount1[i]); }
				double stillNeedAmount8Db = regiGivenAmount8Db - totalFundAmount8; String stillNeedAmount8 = Double.toString(stillNeedAmount8Db); if(stillNeedAmount8Db < 1 && regiGivenAmount8Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/playareafund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">PLAY AREA FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount8%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div>			
        <% } else { %>
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/playareafund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">PLAY AREA FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="playareafund.jpg"> <input type="hidden" name="guestSpaceName" value="PLAY AREA FUND"> <input type="hidden" name="guSpaceColName" value="play_area"> <input type="hidden" name="guSpaceColCount" value="<%=paColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount8%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount8%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 			
        <% } } } %>   			
<!-- 9th Column -->
		<% 	String outdoorSpaceFund = (String)session.getAttribute("outdoorSpaceFundSn");
			if (null != outdoorSpaceFund) { String[] outdoorSpaceCombVal = outdoorSpaceFund.split("__");
				for (int i = 0; i < outdoorSpaceCombVal.length; i++) { String[] outdoorSpaceColumnValue = outdoorSpaceCombVal[i].split("_,_"); double regiGivenAmount9Db = 0;
				if(null != outdoorSpaceColumnValue[1]) { regiGivenAmount9Db = Double.parseDouble(outdoorSpaceColumnValue[1]); }
				int count = (i + 1); String odsColumnCount = outdoorSpaceColumnValue[0]; String totalOutDoorSpaceRoomFundsAmount1 = (String)session.getAttribute("totalOutDoorSpaceRoomFundsAmount"); double totalFundAmount9 = 0;
				if (null != totalOutDoorSpaceRoomFundsAmount1) { String[] totOutDoorSpaceRoomFundsAmount1 = totalOutDoorSpaceRoomFundsAmount1.split("__"); totalFundAmount9 = Double.parseDouble(totOutDoorSpaceRoomFundsAmount1[i]); }
				double stillNeedAmount9Db = regiGivenAmount9Db - totalFundAmount9; String stillNeedAmount9 = Double.toString(stillNeedAmount9Db); if(stillNeedAmount9Db < 1 && regiGivenAmount9Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl"> <div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/outdoorspacefund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">OUTDOOR SPACE FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount9%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 			
        <% } else { %>
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/outdoorspacefund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">OUTDOOR SPACE FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="outdoorspacefund.jpg"> <input type="hidden" name="guestSpaceName" value="OUTDOOR SPACE FUND"> <input type="hidden" name="guSpaceColName" value="outdoor_space"> <input type="hidden" name="guSpaceColCount" value="<%=odsColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount9%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount9%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 		
        <% } } } %>   			  
<!-- 10th Column -->
		<% 	String otherDreamSpaceFund = (String)session.getAttribute("otherDreamSpaceFundSn");
			if (null != otherDreamSpaceFund) { String[] otherDreamSpaceCombVal = otherDreamSpaceFund.split("__");
				for (int i = 0; i < otherDreamSpaceCombVal.length; i++) { String[] otherDreamSpaceColumnValue = otherDreamSpaceCombVal[i].split("_,_"); double regiGivenAmount10Db = 0;
				if(null != otherDreamSpaceColumnValue[1]) { regiGivenAmount10Db = Double.parseDouble(otherDreamSpaceColumnValue[1]); }
				int count = (i + 1); String odsColumnCount = otherDreamSpaceColumnValue[0]; String totalOtherDreamSpaceRoomFundsAmount1 = (String)session.getAttribute("totalOtherDreamSpaceRoomFundsAmount"); double totalFundAmount10 = 0;
				if (null != totalOtherDreamSpaceRoomFundsAmount1) { String[] totOtherDreamSpaceRoomFundsAmount1 = totalOtherDreamSpaceRoomFundsAmount1.split("__"); totalFundAmount10 = Double.parseDouble(totOtherDreamSpaceRoomFundsAmount1[i]); }
				double stillNeedAmount10Db = regiGivenAmount10Db - totalFundAmount10; String stillNeedAmount10 = Double.toString(stillNeedAmount10Db); if(stillNeedAmount10Db < 1 && regiGivenAmount10Db > 0) {
		%>
		<div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl" src="resources/images/registry/roomandfundimages/otherdreamspacefund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">CUSTOM DESIGN FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount10%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } else { %>
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1" src="resources/images/registry/roomandfundimages/otherdreamspacefund.jpg" width="219px" height="220px" > </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1">CUSTOM DESIGN FUND</div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="spaceContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestSpaceNameImg" value="otherdreamspacefund.jpg"> <input type="hidden" name="guestSpaceName" value="CUSTOM DESIGN FUND"> <input type="hidden" name="guSpaceColName" value="other_dream_space"> <input type="hidden" name="guSpaceColCount" value="<%=odsColumnCount%>"> <input type="hidden" name="guStillNeedAmount" value="<%=stillNeedAmount10%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeedAmount10%>" type="number"/></font> &nbsp;</div></div> </div> </div> </div>
        <% } } } %>   			
<!-- Code End --> <!-- Cash Funds Coding Start-->		
		<% 
			if (null != session.getAttribute("regCashFundsIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsIdList = (ArrayList) session.getAttribute("regCashFundsIdListInSn"); if (null != regCashFundsIdList && regCashFundsIdList.size() > 0) {	       		
		   	if (null != session.getAttribute("regCashFundsImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsImageList = (ArrayList) session.getAttribute("regCashFundsImageListInSn"); if (null != regCashFundsImageList && regCashFundsImageList.size() > 0) {           	
           	if (null != session.getAttribute("regCashFundsNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsNameList = (ArrayList) session.getAttribute("regCashFundsNameListInSn"); if (null != regCashFundsNameList && regCashFundsNameList.size() > 0) {
           	if (null != session.getAttribute("regCashFundsPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsPriceList = (ArrayList) session.getAttribute("regCashFundsPriceListInSn"); if (null != regCashFundsPriceList && regCashFundsPriceList.size() > 0) {
           	if (null != session.getAttribute("regCashFundsContAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsContAmountList = (ArrayList) session.getAttribute("regCashFundsContAmountListInSn"); if (null != regCashFundsContAmountList && regCashFundsContAmountList.size() > 0) {            
            if (null != session.getAttribute("regCashFundsRemAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsRemAmountList = (ArrayList) session.getAttribute("regCashFundsRemAmountListInSn"); if (null != regCashFundsRemAmountList && regCashFundsRemAmountList.size() > 0) {
            if (null != session.getAttribute("regCashFundsMessagesListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCashFundsMessagesList = (ArrayList) session.getAttribute("regCashFundsMessagesListInSn"); if (null != regCashFundsMessagesList && regCashFundsMessagesList.size() > 0) {
        %>
        <% 	for(int i = 0; i < regCashFundsIdList.size(); i++) { String remAmountInSt = (String) regCashFundsRemAmountList.get(i); String cashFundPriceInSt = (String) regCashFundsPriceList.get(i); double cashFundReqAmountDb = 0;
			if(!("").equals(cashFundPriceInSt) &&  null != cashFundPriceInSt) { cashFundReqAmountDb = Double.parseDouble(cashFundPriceInSt); }          	  
          	double cashFundRemAmount = 0; double cashFundRemAmountRef = 0; 
          	if(null != remAmountInSt) { cashFundRemAmount = Double.parseDouble(remAmountInSt); cashFundRemAmountRef = Double.parseDouble(remAmountInSt); } else { cashFundRemAmountRef = cashFundReqAmountDb; } String stillNeadAmount = null;
			if((null != cashFundPriceInSt && !("").equals(cashFundPriceInSt)) && null == remAmountInSt) { stillNeadAmount = cashFundPriceInSt; } else { stillNeadAmount = remAmountInSt; }
			String cashFundContAmount = null; String contAmountInSt = (String) regCashFundsContAmountList.get(i);
          	if(null != contAmountInSt) { cashFundContAmount = contAmountInSt; } else { cashFundContAmount = "0"; }
          	String cashFundImageDsp = "resources/images/cash_fund_images/big/" + regCashFundsImageList.get(i); String cashFundNeedsAmount = String.format("%.2f", cashFundRemAmountRef);
         	if(cashFundRemAmountRef < 1 && cashFundReqAmountDb > 0 ) {          		
      	%>
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">			
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=cashFundImageDsp%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=regCashFundsNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeadAmount%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } else { %>
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=cashFundImageDsp%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=regCashFundsNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="guestCashFundContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="registryCashFundsId" value="<%=regCashFundsIdList.get(i)%>"> <input type="hidden" name="registryCashFundsImage" value="<%=regCashFundsImageList.get(i)%>"> <input type="hidden" name="registryCashFundsName" value="<%=regCashFundsNameList.get(i)%>"> <input type="hidden" name="registryCashFundsNeedAmount" value="<%=cashFundNeedsAmount%>"> <input type="hidden" name="registryCashFundsMessage" value="<%=regCashFundsMessagesList.get(i)%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeadAmount%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
   		<% } } %>
        <% } } } } } } } } } } } } } } %>
<!-- Cash Funds Coding End--> <!-- Custom Funds Coding Start-->		
		<% 
			if (null != session.getAttribute("regCustomFundsIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsIdList = (ArrayList) session.getAttribute("regCustomFundsIdListInSn"); if (null != regCustomFundsIdList && regCustomFundsIdList.size() > 0) {	       		
		   	if (null != session.getAttribute("regCustomFundsImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsImageList = (ArrayList) session.getAttribute("regCustomFundsImageListInSn"); if (null != regCustomFundsImageList && regCustomFundsImageList.size() > 0) {           	
           	if (null != session.getAttribute("regCustomFundsNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsNameList = (ArrayList) session.getAttribute("regCustomFundsNameListInSn"); if (null != regCustomFundsNameList && regCustomFundsNameList.size() > 0) {
           	if (null != session.getAttribute("regCustomFundsPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsPriceList = (ArrayList) session.getAttribute("regCustomFundsPriceListInSn"); if (null != regCustomFundsPriceList && regCustomFundsPriceList.size() > 0) {
           	if (null != session.getAttribute("regCustomFundsContAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsContAmountList = (ArrayList) session.getAttribute("regCustomFundsContAmountListInSn"); if (null != regCustomFundsContAmountList && regCustomFundsContAmountList.size() > 0) {            
            if (null != session.getAttribute("regCustomFundsRemAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsRemAmountList = (ArrayList) session.getAttribute("regCustomFundsRemAmountListInSn"); if (null != regCustomFundsRemAmountList && regCustomFundsRemAmountList.size() > 0) {
            if (null != session.getAttribute("regCustomFundsMessagesListInSn")) { @SuppressWarnings("rawtypes") ArrayList regCustomFundsMessagesList = (ArrayList) session.getAttribute("regCustomFundsMessagesListInSn"); if (null != regCustomFundsMessagesList && regCustomFundsMessagesList.size() > 0) {
        %>        
        <% 	for(int i = 0; i < regCustomFundsIdList.size(); i++) { String remAmountInSt = (String) regCustomFundsRemAmountList.get(i); String cashFundPriceInSt = (String) regCustomFundsPriceList.get(i); double cashFundReqAmountDb = 0;
			if(!("").equals(cashFundPriceInSt) &&  null != cashFundPriceInSt) { cashFundReqAmountDb = Double.parseDouble(cashFundPriceInSt); }
			double cashFundRemAmount = 0; double cashFundRemAmountRef = 0;
			if(null != remAmountInSt) { cashFundRemAmount = Double.parseDouble(remAmountInSt); cashFundRemAmountRef = Double.parseDouble(remAmountInSt); } else { cashFundRemAmountRef = cashFundReqAmountDb; } String stillNeadAmount = null;
			if((null != cashFundPriceInSt && !("").equals(cashFundPriceInSt)) && null == remAmountInSt) { stillNeadAmount = cashFundPriceInSt; } else { stillNeadAmount = remAmountInSt; }
			String cashFundContAmount = null; String contAmountInSt = (String) regCustomFundsContAmountList.get(i);
          	if(null != contAmountInSt) { cashFundContAmount = contAmountInSt; } else { cashFundContAmount = "0"; }
          	String customFundNeedsAmount = String.format("%.2f", cashFundRemAmountRef); if(cashFundRemAmountRef < 1 && cashFundReqAmountDb > 0 ) { 
     	%>
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">			
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=regCustomFundsImageList.get(i)%>"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=regCustomFundsNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeadAmount%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } else { %>
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame">
		<div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=regCustomFundsImageList.get(i)%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=regCustomFundsNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> <div align="center">
		<form action="guestCustomFundContributeInfoRed" method="POST"><h4><button class="reg_bott_funds_sub_Butt" id="addToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="registryCashFundsId" value="<%=regCustomFundsIdList.get(i)%>"> <input type="hidden" name="registryCashFundsImage" value="<%=regCustomFundsImageList.get(i)%>"> <input type="hidden" name="registryCashFundsName" value="<%=regCustomFundsNameList.get(i)%>"> <input type="hidden" name="registryCashFundsNeedAmount" value="<%=customFundNeedsAmount%>"> <input type="hidden" name="registryCashFundsMessage" value="<%=regCustomFundsMessagesList.get(i)%>"> </form> </div>
		<div class="reg_bst_still_need_dspl">STILL NEED: <font class="reg_bott_small_price_text_dspl1">&nbsp;$<fmt:formatNumber value="<%=stillNeadAmount%>" type="number"/></font> &nbsp;</div> </div> </div> </div> </div> 
        <% } } %>
        <% } } } } } } } } } } } } } } %>
<!-- Custom Funds Coding End--> 
<!-- Concept Boards Contributed Products Display Coding Start-->		
		<% 
			if (null != session.getAttribute("guestCBContributedProductSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBContributedProductSavingIdList = (ArrayList) session.getAttribute("guestCBContributedProductSavingIdListInSn"); if (null != guestCBContributedProductSavingIdList && guestCBContributedProductSavingIdList.size() > 0) {	       		
		   	if (null != session.getAttribute("guestCBContributedProductImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBContributedProductImageList = (ArrayList) session.getAttribute("guestCBContributedProductImageListInSn"); if (null != guestCBContributedProductImageList && guestCBContributedProductImageList.size() > 0) {
           	if (null != session.getAttribute("guestCBContributedProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBContributedProductNameList = (ArrayList) session.getAttribute("guestCBContributedProductNameListInSn"); if (null != guestCBContributedProductNameList && guestCBContributedProductNameList.size() > 0) {
           	if (null != session.getAttribute("guestCBContributedProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBContributedProductPriceList = (ArrayList) session.getAttribute("guestCBContributedProductPriceListInSn"); if (null != guestCBContributedProductPriceList && guestCBContributedProductPriceList.size() > 0) {
           	if (null != session.getAttribute("guestCBContributedProductQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBContributedProductQuantityList = (ArrayList) session.getAttribute("guestCBContributedProductQuantityListInSn"); if (null != guestCBContributedProductQuantityList && guestCBContributedProductQuantityList.size() > 0) {        	   
           	if (null != session.getAttribute("guestCBContributedRemainingAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBContributedRemainingAmountList = (ArrayList) session.getAttribute("guestCBContributedRemainingAmountListInSn"); if (null != guestCBContributedRemainingAmountList && guestCBContributedRemainingAmountList.size() > 0) {        		   
          	if (null != session.getAttribute("guestCBContributedAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBContributedAmountList = (ArrayList) session.getAttribute("guestCBContributedAmountListInSn"); if (null != guestCBContributedAmountList && guestCBContributedAmountList.size() > 0) {         	         	           
        %>                
        <% 	
        	for(int i = 0; i < guestCBContributedProductSavingIdList.size(); i++) { byte[] guestCBContributedProductImageByte = (byte[]) guestCBContributedProductImageList.get(i); String guestCBContributedProductImage = null;
	        if(null != guestCBContributedProductImageByte) { String guestCBContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(guestCBContributedProductImageByte); guestCBContributedProductImage = "data:image/jpg;base64," +guestCBContributedProductImageB64; }
	        String guestCBContributedRemAmountSt = (String) guestCBContributedRemainingAmountList.get(i); double guestCBContributedRemAmountDb = 0;
	        if(null != guestCBContributedRemAmountSt) { guestCBContributedRemAmountDb = Double.parseDouble(guestCBContributedRemAmountSt); }
	        String cbContributedStillNeedAmount = String.format("%,.2f", guestCBContributedRemAmountDb); String cbContributedPriceDbSt = String.format("%,.2f", (Double) guestCBContributedProductPriceList.get(i));        		        	
        %>        
<!-- Concept Boards Contributed Products Completed Payment-->       
        <% if(guestCBContributedRemAmountDb > 0) { %>        
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=guestCBContributedProductImage%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=guestCBContributedProductNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=cbContributedPriceDbSt%></font><font style="color: #2c2c2c; font: bold 1.05em/1.25em Georgia; top: 2px; position: relative;">/<%=guestCBContributedProductQuantityList.get(i)%></font></div>
		<div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center" style="margin-top: 0px; height: 30px;">
		<form action="guestConceptBoardContributedInfoDisplay" method="POST">
		<h4><button class="reg_bott_funds_sub_Butt" id="regiAddToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestCBCotributedProductSavingId" value="<%=guestCBContributedProductSavingIdList.get(i)%>"> <input type="hidden" name="guestCBCotributedRemainingPrice" value="<%=cbContributedStillNeedAmount%>"> <input type="hidden" name="guestCBCotributedProductImage" value="<%=guestCBContributedProductImage%>"> <input type="hidden" name="guestCBCotributedProductName" value="<%=guestCBContributedProductNameList.get(i)%>"> <input type="hidden" name="guestCBCotributedPrice" value="<%=guestCBContributedAmountList.get(i)%>"> </form> </div>						
		<div align="left" class="reg_bst_still_need_dspl">STILL NEED:&nbsp;<font style="font-weight: bold;">$<%=cbContributedStillNeedAmount%></font></div> </div> </div> </div> </div> 
   		<% } else {%>
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=guestCBContributedProductImage%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=guestCBContributedProductNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text" style="opacity: 0.7;">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=cbContributedPriceDbSt%></font><font style="color: #2c2c2c; font: bold 1.05em/1.25em Georgia; top: 2px; position: relative;">/<%=guestCBContributedProductQuantityList.get(i)%></font></div>
		<div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center" style="margin-top: 0px; height: 30px;"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="regiAddToCartButtonId">CONTRIBUTE</button></h4> </div>						
		<div align="left" class="reg_bst_still_need_dspl">STILL NEED:&nbsp;<font style="font-weight: bold;">$<%=cbContributedStillNeedAmount%></font></div> </div> </div> </div> </div> 
   		<% } } %>        
        <% } } } } } } } } } } } } } } %>		
<!-- Concept Boards Contributed Products Display Coding End--> <!-- Concept Boards Individual Products Display Coding Start-->		
		<div id="individualCBDivId">
		<% 
			if (null != session.getAttribute("guestCBIndividualProductSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBIndividualProductSavingIdList = (ArrayList) session.getAttribute("guestCBIndividualProductSavingIdListInSn"); if (null != guestCBIndividualProductSavingIdList && guestCBIndividualProductSavingIdList.size() > 0) {	       		
		   	if (null != session.getAttribute("guestCBIndividualProductImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBIndividualProductImageList = (ArrayList) session.getAttribute("guestCBIndividualProductImageListInSn"); if (null != guestCBIndividualProductImageList && guestCBIndividualProductImageList.size() > 0) {
           	if (null != session.getAttribute("guestCBIndividualProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBIndividualProductNameList = (ArrayList) session.getAttribute("guestCBIndividualProductNameListInSn"); if (null != guestCBIndividualProductNameList && guestCBIndividualProductNameList.size() > 0) {
           	if (null != session.getAttribute("guestCBIndividualProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBIndividualProductPriceList = (ArrayList) session.getAttribute("guestCBIndividualProductPriceListInSn"); if (null != guestCBIndividualProductPriceList && guestCBIndividualProductPriceList.size() > 0) {
           	if (null != session.getAttribute("guestCBIndividualProductQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBIndividualProductQuantityList = (ArrayList) session.getAttribute("guestCBIndividualProductQuantityListInSn"); if (null != guestCBIndividualProductQuantityList && guestCBIndividualProductQuantityList.size() > 0) {        	   
           	if (null != session.getAttribute("guestCBIndividualRemainingQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBIndividualRemainingQuantityList = (ArrayList) session.getAttribute("guestCBIndividualRemainingQuantityListInSn"); if (null != guestCBIndividualRemainingQuantityList && guestCBIndividualRemainingQuantityList.size() > 0) {        		   
          	if (null != session.getAttribute("guestCBIndividualGivenQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestCBIndividualGivenQuantityList = (ArrayList) session.getAttribute("guestCBIndividualGivenQuantityListInSn"); if (null != guestCBIndividualGivenQuantityList && guestCBIndividualGivenQuantityList.size() > 0) {         		
        %>                
        <% 	
        	for(int i = 0; i < guestCBIndividualProductSavingIdList.size(); i++) { byte[] guestCBIndividualProductImageByte = (byte[]) guestCBIndividualProductImageList.get(i); String guestCBIndividualProductImage = null;
	        if(null != guestCBIndividualProductImageByte) { String guestCBIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(guestCBIndividualProductImageByte); guestCBIndividualProductImage = "data:image/jpg;base64," +guestCBIndividualProductImageB64; } int guestCBIndividualRemainingQuantityInt = 0;
	        if(null != guestCBIndividualRemainingQuantityList.get(i)) { guestCBIndividualRemainingQuantityInt = (Integer) guestCBIndividualRemainingQuantityList.get(i); }
	        int guestCBIndividualPaymentQuantity = (Integer) guestCBIndividualGivenQuantityList.get(i); int guestCBIndividualPaymentQuantityInt = 1;
	        if(guestCBIndividualPaymentQuantity > 0) { guestCBIndividualPaymentQuantityInt = guestCBIndividualPaymentQuantity; }
	        double cbIndividualProductPriceDb = Double.parseDouble((String) guestCBIndividualProductPriceList.get(i)); String cbIndividualProductPriceSt = String.format("%,.2f", cbIndividualProductPriceDb);
        %>        
<!-- Concept Boards Individual Products Completed Payment-->       
        <% if(guestCBIndividualRemainingQuantityInt > 0) { %>        
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=guestCBIndividualProductImage%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=guestCBIndividualProductNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=cbIndividualProductPriceSt%></font></div> </div> 
		<div align="center" style="margin-top: -1px; height: 30px;">
		<form action="guestConceptBoardIndividualInfoDisplay" method="POST">
		<table> <tr><td><input type="text" name="productQuantity" maxLength="2" id="conBoardProductQuantityId<%=guestCBIndividualProductSavingIdList.get(i)%>" value="<%=guestCBIndividualPaymentQuantityInt%>" class="reg_bott_quentity_field_cl" onkeypress="return numeralsOnly(event);">&nbsp;&nbsp;&nbsp;</td>
		<td><h4><button class="reg_bott_funds_sub_Butt" id="guestCBIndividualButtonId" onclick="return selectedCBIndividualInfoAddToCart(<%=guestCBIndividualProductSavingIdList.get(i)%>, <%=guestCBIndividualRemainingQuantityInt%>);">ADD TO CART</button></h4></td></tr>
		<tr> <td><input type="hidden" name="guestCBIndividualProductSavingId" value="<%=guestCBIndividualProductSavingIdList.get(i)%>"> <input type="hidden" name="guestCBIndividualProductPrice" value="<%=guestCBIndividualProductPriceList.get(i)%>"> <input type="hidden" name="guestCBIndividualProductName" value="<%=guestCBIndividualProductNameList.get(i)%>"> <input type="hidden" name="guestCBIndividualProductImage" value="<%=guestCBIndividualProductImage%>"> <input type="hidden" name="guestCBIndividualNeedQuantity" value="<%=guestCBIndividualRemainingQuantityInt%>"> </td> </tr> </table> </form> </div>						
		<div align="left" class="reg_bst_still_need_bot_dspl">STILL NEED:&nbsp;<font style="font-weight: bold;"><%=guestCBIndividualRemainingQuantityInt%></font></div> </div> </div> </div> </div>   		
   		<% } else {%>   		
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=guestCBIndividualProductImage%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=guestCBIndividualProductNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text" style="opacity: 0.7;">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=cbIndividualProductPriceSt%></font></div> </div> 
		<div align="center" style="margin-top: -1px; height: 30px;">
		<table> <tr><td><input type="text" name="productQuantity" id="conBoardProductQuantityId" value="1" class="reg_bott_quentity_field_cl" style="opacity: 0.5;">&nbsp;&nbsp;&nbsp;</td>
		<td><h4><button class="reg_pur_bott_funds_sub_Butt" id="regiAddToCartButtonId">ADD TO CART</button></h4></td></tr> </table> </div>						
		<div align="left" class="reg_bst_still_need_bot_dspl">STILL NEED:&nbsp;<font style="font-weight: bold;"><%=guestCBIndividualRemainingQuantityInt%></font></div> </div> </div> </div> </div>         
   		<% } } %>        
        <% } } } } } } } } } } } } } } %>
		</div>		
<!-- Concept Boards Individual Products Display Coding End-->
<!-- Finishing Touches Contributed Products Display Coding Start-->		
		<% 
			if (null != session.getAttribute("guestFTContributedProductSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTContributedProductSavingIdList = (ArrayList) session.getAttribute("guestFTContributedProductSavingIdListInSn"); if (null != guestFTContributedProductSavingIdList && guestFTContributedProductSavingIdList.size() > 0) {	       		
		   	if (null != session.getAttribute("guestFTContributedProductImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTContributedProductImageList = (ArrayList) session.getAttribute("guestFTContributedProductImageListInSn"); if (null != guestFTContributedProductImageList && guestFTContributedProductImageList.size() > 0) {
           	if (null != session.getAttribute("guestFTContributedProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTContributedProductNameList = (ArrayList) session.getAttribute("guestFTContributedProductNameListInSn"); if (null != guestFTContributedProductNameList && guestFTContributedProductNameList.size() > 0) {
           	if (null != session.getAttribute("guestFTContributedProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTContributedProductPriceList = (ArrayList) session.getAttribute("guestFTContributedProductPriceListInSn"); if (null != guestFTContributedProductPriceList && guestFTContributedProductPriceList.size() > 0) {
           	if (null != session.getAttribute("guestFTContributedProductQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTContributedProductQuantityList = (ArrayList) session.getAttribute("guestFTContributedProductQuantityListInSn"); if (null != guestFTContributedProductQuantityList && guestFTContributedProductQuantityList.size() > 0) {        	   
           	if (null != session.getAttribute("guestFTContributedRemainingAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTContributedRemainingAmountList = (ArrayList) session.getAttribute("guestFTContributedRemainingAmountListInSn"); if (null != guestFTContributedRemainingAmountList && guestFTContributedRemainingAmountList.size() > 0) {        		   
          	if (null != session.getAttribute("guestFTContributedAmountListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTContributedAmountList = (ArrayList) session.getAttribute("guestFTContributedAmountListInSn"); if (null != guestFTContributedAmountList && guestFTContributedAmountList.size() > 0) {         	         	           
        %>                
        <% 	
        	for(int i = 0; i < guestFTContributedProductSavingIdList.size(); i++) { byte[] guestFTContributedProductImageByte = (byte[]) guestFTContributedProductImageList.get(i); String guestFTContributedProductImage = null;
	        if(null != guestFTContributedProductImageByte) { String guestFTContributedProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(guestFTContributedProductImageByte); guestFTContributedProductImage = "data:image/jpg;base64," +guestFTContributedProductImageB64; }
	        String guestFTContributedRemAmountSt = (String) guestFTContributedRemainingAmountList.get(i); double guestFTContributedRemAmountDb = 0;
	        if(null != guestFTContributedRemAmountSt) { guestFTContributedRemAmountDb = Double.parseDouble(guestFTContributedRemAmountSt); }
	        String ftContributedStillNeedAmount = String.format("%,.2f", guestFTContributedRemAmountDb); String ftContributedPriceDbSt = String.format("%,.2f", (Double) guestFTContributedProductPriceList.get(i));        		        	
        %>        
<!-- Finishing Touches Contributed Products Completed Payment-->       
        <% if(guestFTContributedRemAmountDb > 0) { %>        
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=guestFTContributedProductImage%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=guestFTContributedProductNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=ftContributedPriceDbSt%></font><font style="color: #2c2c2c; font: bold 1.05em/1.25em Georgia; top: 2px; position: relative;">/<%=guestFTContributedProductQuantityList.get(i)%></font></div>
		<div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center" style="margin-top: 0px; height: 30px;">
		<form action="guestFinishingTouchesContributedInfoDisplay" method="POST">
		<h4><button class="reg_bott_funds_sub_Butt" id="regiAddToCartButtonId">CONTRIBUTE</button></h4>
		<input type="hidden" name="guestFTCotributedProductSavingId" value="<%=guestFTContributedProductSavingIdList.get(i)%>"> <input type="hidden" name="guestFTCotributedRemainingPrice" value="<%=ftContributedStillNeedAmount%>"> <input type="hidden" name="guestFTCotributedProductImage" value="<%=guestFTContributedProductImage%>"> <input type="hidden" name="guestFTCotributedProductName" value="<%=guestFTContributedProductNameList.get(i)%>"> <input type="hidden" name="guestFTCotributedPrice" value="<%=guestFTContributedAmountList.get(i)%>"> </form> </div>						
		<div align="left" class="reg_bst_still_need_dspl">STILL NEED:&nbsp;<font style="font-weight: bold;">$<%=ftContributedStillNeedAmount%></font></div> </div> </div> </div> </div> 
   		<% } else {%>
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=guestFTContributedProductImage%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=guestFTContributedProductNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text" style="opacity: 0.7;">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=ftContributedPriceDbSt%></font><font style="color: #2c2c2c; font: bold 1.05em/1.25em Georgia; top: 2px; position: relative;">/<%=guestFTContributedProductQuantityList.get(i)%></font></div>
		<div class="reg_bott_small_text_dspl1">CONTRIBUTE WHAT YOU WISH</div> </div> 
		<div align="center" style="margin-top: 0px; height: 30px;"> <h4><button class="reg_pur_bott_funds_sub_Butt" id="regiAddToCartButtonId">CONTRIBUTE</button></h4> </div>						
		<div align="left" class="reg_bst_still_need_dspl">STILL NEED:&nbsp;<font style="font-weight: bold;">$<%=ftContributedStillNeedAmount%></font></div> </div> </div> </div> </div> 
   		<% } } %>        
        <% } } } } } } } } } } } } } } %>		
<!-- Finishing Touches Contributed Products Display Coding End--> <!-- Finishing Touches Individual Products Display Coding Start-->		
		<div id="individualFTDivId">
		<% 
			if (null != session.getAttribute("guestFTIndividualProductSavingIdListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTIndividualProductSavingIdList = (ArrayList) session.getAttribute("guestFTIndividualProductSavingIdListInSn"); if (null != guestFTIndividualProductSavingIdList && guestFTIndividualProductSavingIdList.size() > 0) {	       		
		   	if (null != session.getAttribute("guestFTIndividualProductImageListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTIndividualProductImageList = (ArrayList) session.getAttribute("guestFTIndividualProductImageListInSn"); if (null != guestFTIndividualProductImageList && guestFTIndividualProductImageList.size() > 0) {
           	if (null != session.getAttribute("guestFTIndividualProductNameListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTIndividualProductNameList = (ArrayList) session.getAttribute("guestFTIndividualProductNameListInSn"); if (null != guestFTIndividualProductNameList && guestFTIndividualProductNameList.size() > 0) {
           	if (null != session.getAttribute("guestFTIndividualProductPriceListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTIndividualProductPriceList = (ArrayList) session.getAttribute("guestFTIndividualProductPriceListInSn"); if (null != guestFTIndividualProductPriceList && guestFTIndividualProductPriceList.size() > 0) {
           	if (null != session.getAttribute("guestFTIndividualProductQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTIndividualProductQuantityList = (ArrayList) session.getAttribute("guestFTIndividualProductQuantityListInSn"); if (null != guestFTIndividualProductQuantityList && guestFTIndividualProductQuantityList.size() > 0) {        	   
           	if (null != session.getAttribute("guestFTIndividualRemainingQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTIndividualRemainingQuantityList = (ArrayList) session.getAttribute("guestFTIndividualRemainingQuantityListInSn"); if (null != guestFTIndividualRemainingQuantityList && guestFTIndividualRemainingQuantityList.size() > 0) {        		   
          	if (null != session.getAttribute("guestFTIndividualGivenQuantityListInSn")) { @SuppressWarnings("rawtypes") ArrayList guestFTIndividualGivenQuantityList = (ArrayList) session.getAttribute("guestFTIndividualGivenQuantityListInSn"); if (null != guestFTIndividualGivenQuantityList && guestFTIndividualGivenQuantityList.size() > 0) {         		
        %>                
        <% 	
        	for(int i = 0; i < guestFTIndividualProductSavingIdList.size(); i++) { byte[] guestFTIndividualProductImageByte = (byte[]) guestFTIndividualProductImageList.get(i); String guestFTIndividualProductImage = null;
	        if(null != guestFTIndividualProductImageByte) { String guestFTIndividualProductImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(guestFTIndividualProductImageByte); guestFTIndividualProductImage = "data:image/jpg;base64," +guestFTIndividualProductImageB64; } int guestFTIndividualRemainingQuantityInt = 0;
	        if(null != guestFTIndividualRemainingQuantityList.get(i)) { guestFTIndividualRemainingQuantityInt = (Integer) guestFTIndividualRemainingQuantityList.get(i); }
	        int guestFTIndividualPaymentQuantity = (Integer) guestFTIndividualGivenQuantityList.get(i); int guestFTIndividualPaymentQuantityInt = 1;
	        if(guestFTIndividualPaymentQuantity > 0) { guestFTIndividualPaymentQuantityInt = guestFTIndividualPaymentQuantity; }
	        double ftIndividualProductPriceDb = Double.parseDouble((String) guestFTIndividualProductPriceList.get(i)); String ftIndividualProductPriceSt = String.format("%,.2f", ftIndividualProductPriceDb);
        %>        
<!-- Finishing Touches Individual Products Completed Payment-->       
        <% if(guestFTIndividualRemainingQuantityInt > 0) { %>        
   		<div class="col-md-3 col-sm-3 top_adjustment_30"> <div class="reg_landing_images_and_text_frame"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_image_dsp_center_align_cl1 reg_cash_fund_top_image_dsp1" src="<%=guestFTIndividualProductImage%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=guestFTIndividualProductNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=ftIndividualProductPriceSt%></font></div> </div> 
		<div align="center" style="margin-top: -1px; height: 30px;">
		<form action="guestFinishingTouchesIndividualInfoDisplay" method="POST">
		<table> <tr><td><input type="text" name="productQuantity" maxLength="2" id="finTouchesProductQuantityId<%=guestFTIndividualProductSavingIdList.get(i)%>" value="<%=guestFTIndividualPaymentQuantityInt%>" class="reg_bott_quentity_field_cl" onkeypress="return numeralsOnly(event);">&nbsp;&nbsp;&nbsp;</td>
		<td><h4><button class="reg_bott_funds_sub_Butt" id="guestFTIndividualButtonId" onclick="return selectedFTIndividualInfoAddToCart(<%=guestFTIndividualProductSavingIdList.get(i)%>, <%=guestFTIndividualRemainingQuantityInt%>);">ADD TO CART</button></h4></td></tr>
		<tr> <td><input type="hidden" name="guestFTIndividualProductSavingId" value="<%=guestFTIndividualProductSavingIdList.get(i)%>"> <input type="hidden" name="guestFTIndividualProductPrice" value="<%=guestFTIndividualProductPriceList.get(i)%>"> <input type="hidden" name="guestFTIndividualProductName" value="<%=guestFTIndividualProductNameList.get(i)%>"> <input type="hidden" name="guestFTIndividualProductImage" value="<%=guestFTIndividualProductImage%>"> <input type="hidden" name="guestFTIndividualNeedQuantity" value="<%=guestFTIndividualRemainingQuantityInt%>"> </td> </tr> </table> </form> </div>						
		<div align="left" class="reg_bst_still_need_bot_dspl">STILL NEED:&nbsp;<font style="font-weight: bold;"><%=guestFTIndividualRemainingQuantityInt%></font></div> </div> </div> </div> </div>   		
   		<% } else {%>   		
        <div class="col-md-3 col-sm-3 top_adjustment_30"> <img src="resources/images/registry/reg_purchases_image.png" class="reg_pur_dsp_img_cl">
		<div class="reg_hide_image_and_text_frame_dsp"> <div class="row"> <div class="col-md-12 col-sm-12 reg_image_top_frame_align_cl1" align="center">
		<img class="reg_pur_image_dsp_center_align_cl reg_cash_fund_top_image_dsp1" src="<%=guestFTIndividualProductImage%>" width="219px" height="220px"> </div> </div> 
		<div class="row"> <div class="col-md-12 col-sm-12 reg_text_bottom_frame_align_cl1"> <div align="left" class="reg_sub_div_middle_text_disp1">
		<div class="reg_bott_text_hd_dspl1"><%=guestFTIndividualProductNameList.get(i)%></div> </div> 
		<div class="reg_mid_text_frame_dspl"> <div class="reg_bott_small_price_red_text" style="opacity: 0.7;">PRICE: <font class="reg_bott_small_price_no_dspl">&nbsp;$<%=ftIndividualProductPriceSt%></font></div> </div> 
		<div align="center" style="margin-top: -1px; height: 30px;">
		<table> <tr><td><input type="text" name="productQuantity" id="finTouchesProductQuantityId" value="1" class="reg_bott_quentity_field_cl" style="opacity: 0.5;">&nbsp;&nbsp;&nbsp;</td>
		<td><h4><button class="reg_pur_bott_funds_sub_Butt" id="regiAddToCartButtonId">ADD TO CART</button></h4></td></tr> </table> </div>						
		<div align="left" class="reg_bst_still_need_bot_dspl">STILL NEED:&nbsp;<font style="font-weight: bold;"><%=guestFTIndividualRemainingQuantityInt%></font></div> </div> </div> </div> </div>         
   		<% } } %>        
        <% } } } } } } } } } } } } } } %>
		</div>		
<!-- Finishing Touches Individual Products Display Coding End-->
	  	</div> </div> <div class="col-md-1 col-sm-1"></div> </div>                   
<!-- SELECTED GIFT CARDS COADING END -->           	
		</div> </div>
		</body>
</html>