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
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
	<script type="text/javascript">
 	$(document).ready(function() { var textFieldRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 -#/_().&amp;]*$/;
	 	$("#urlInfoChangesButtId").click(function (){ var result = true;    
		if($("#regAddressId").val() !== ""){ $("#regAddressId").css("border-color","gray"); } else{ $("#regAddressId").css("border-color","red"); result=false; } return result; });
	 	$("#regAddressId").change(function(){ if(textFieldRegExp.test(this.value)){ $("#regAddressId").css("border-color","gray"); } else{ $("#regAddressId").css("border-color","gray"); result=false; } });	 		    
	    var regAddress1 = "<c:out value="${regAddress}"/>"; $("[name=regAddress]").val(regAddress1); var regSuccSave1 = "<c:out value="${regSuccSave}"/>";
	    if(regSuccSave1 == "URL Info Saved") { alert("Your Changes Have Been Saved"); }	    
	    var regStatus1 = "<c:out value="${regStatus}"/>";
	    if(regStatus1 == "Done"){ $("#visibleTextDispId").show(); $("#notVisibleTextDispId").hide(); } else { $("#notVisibleTextDispId").show(); $("#visibleTextDispId").hide(); }		
 	});
    </script>    
	</head>	
		<body>				
		<div id="mainframe" class="section-content"> <div class="container">      
      	<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="registry_prof_my_acc_title"><h2>MY ACCOUNT</h2></div> </div> </div> </div> </div> </div>    
<!-- Left Code Start -->
      	<div class="row top_adjustment_30"> <div class="col-md-3 col-sm-3 regi_prof_left_side_box_dspl"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>ACCOUNT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryMyAccount" class="regi_prof_left_link_text_dspl">CONTACT INFO</a></div>
		<div class="top_adjustment_10"><a href="registryPasswordChange" class="regi_prof_left_link_text_dspl">CHANGE PASSWORD</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>EVENT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryEventInfoChange" class="regi_prof_left_link_text_dspl">EVENT INFO</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>REGISTRY SETTINGS</h3></div>
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">URL</a></div>
		<div class="top_adjustment_10"><a href="registryPrivacyInfoChange" class="regi_prof_left_link_text_dspl">PRIVACY</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>GIFT TRACKER</h3></div>
		<div class="top_adjustment_10"><a href="regiShippingInfoDsp" class="regi_prof_left_link_text_dspl">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="regiMyOrderDsp" class="regi_prof_left_link_text_dspl">MY ORDERS</a></div>
		<div class="top_adjustment_10"><a href="regiGiftsReceivedDsp" class="regi_prof_left_link_text_dspl">GIFTS RECEIVED</a></div>
		<div class="top_adjustment_10"><a href="regiRoomFundsDsp" class="regi_prof_left_link_text_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
        <div class="col-md-9 col-sm-9"> <div class="service-item"> <div class="service-description">	        			
	    <div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description reg_pro_left_adj_disp"> <div align="left">        			
		<div class="registry_prof_title top_adjustment_30"><h2>URL</h2></div> </div> </div> </div> </div> </div>
		<form action="registrantURLInfoUpdate" method="post">			        
		<div class="row top_adjustment_20"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description reg_pro_left_adj_disp"> <div align="left">
		<table><c:if test="${not empty regErrorPage}"> <tr><td align="left"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;">&nbsp;&nbsp;&nbsp;&nbsp; ${regErrorPage}</font></td></tr>
        <tr><td style="height: 10px;"></td></tr> </c:if></table>
	    <div class="regi_prof_left_sub_hd_text top_adjustment_10"><h4>What do you want your address to be?</h4></div>
		<div class="regi_prof_left_sub_nor_text top_adjustment_20">https://www.nookandcove.com/registry/<input class="reg_pr_input_text_field" id="regAddressId" type="text" name="regAddress"/></div>
		<div class="regi_prof_left_sub_hd_text top_adjustment_45"><h4>Your URL:</h4></div>
		<div class="regi_prof_left_sub_nor_text top_adjustment_20">https://www.nookandcove.com/registry/<font style="font-weight: bold;">${regAddress}</font></div>
		<div class="regi_prof_left_sub_ital_text top_adjustment_20">Guests <font id="notVisibleTextDispId">cannot</font><font id="visibleTextDispId" style="display: none;">can now</font> visit or shop your registry. Change <a href="registryPrivacyInfoChange" class="reg_prof_left_sub_ital_a_text">Privacy Settings</a></div>
		<table> <tr style="height: 45px;"><td></td></tr>
	    <tr><td><h4><button class="reg_profile_save_subt_Btn" id="urlInfoChangesButtId">SAVE CHANGES</button></h4></td></tr>
		</table> </div> </div> </div> </div> </div>
		</form> </div> </div> </div> </div> </div> </div>		     
		</body>
</html>