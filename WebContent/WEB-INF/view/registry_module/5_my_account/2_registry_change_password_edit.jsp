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
 	$(document).ready(function() { 		
	 	var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;		
		$("#savePassChangesButtId").click(function () { var result = true;
		if(passRegExp.test($("#currentPasswordId").val())){$("#currentPasswordId").css("border-color","gray"); } else{ $("#currentPasswordId").css("border-color","red"); result=false; }
		if(passRegExp.test($("#newPasswordId").val())){$("#newPasswordId").css("border-color","gray"); } else{ $("#newPasswordId").css("border-color","red"); result=false; }
		if($("#newPasswordId").val() === $("#verifyPasswordId").val() && $("#verifyPasswordId").val() !== ""){$("#verifyPasswordId").css("border-color","gray"); } else{ $("#verifyPasswordId").css("border-color","red"); result=false; }		       
		return result;
		});
	    $("#currentPasswordId").keyup(function(){ if(passRegExp.test(this.value)){$("#currentPasswordId").css("border-color","gray"); } else{ $("#currentPasswordId").css("border-color","red"); } });
	    $("#newPasswordId").keyup(function(){ if(passRegExp.test(this.value)){$("#newPasswordId").css("border-color","gray"); } else{ $("#newPasswordId").css("border-color","red"); } });
	    $("#verifyPasswordId").keyup(function(){ if(($('#newPasswordId').val()) === ($('#verifyPasswordId').val())){$("#verifyPasswordId").css("border-color","gray"); } else{ $("#verifyPasswordId").css("border-color","red"); } });
	    $("#newPasswordId").change(function(){ var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
	    if(!(passRegExp.test(this.value))){ alert("Password must be a minimum of 8 characters with at least one digit or special character"); }; });
	    var regSuccSave1 = "<c:out value="${regSuccSave}"/>";
	    if(regSuccSave1 == "Password Saved") { alert("Your Changes Have Been Saved") }		
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
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">CHANGE PASSWORD</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>EVENT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryEventInfoChange" class="regi_prof_left_link_text_dspl">EVENT INFO</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>REGISTRY SETTINGS</h3></div>
		<div class="top_adjustment_10"><a href="registryURLInfoChange" class="regi_prof_left_link_text_dspl">URL</a></div>
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
		<div class="registry_prof_title top_adjustment_30"><h2>Change Password</h2></div> </div> </div> </div> </div> </div>
		<form action="registrantPasswordInfoUpdate" method="post">			        
		<div class="row top_adjustment_20"> <div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description reg_pro_left_adj_disp"> <div align="left">
		<table><c:if test="${not empty changePasswordError}">
		<tr><td align="left"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;">&nbsp;&nbsp;&nbsp;&nbsp; ${changePasswordError}</font></td></tr>
        <tr><td style="height: 10px;"></td></tr> </c:if>                                	
	    <tr><td class="reg_pr_input_text_disp">CURRENT PASSWORD:</td></tr>
	    <tr><td><input class="reg_pr_input_text_field" type="password" id="currentPasswordId" name="currentPassword"/></td></tr>
		<tr><td class="reg_pr_input_text_disp">NEW PASSWORD:</td></tr>
	    <tr><td><input class="reg_pr_input_text_field" type="password" id="newPasswordId" name="newPassword"/></td></tr>
		<tr><td class="reg_pr_input_text_disp">VERIFY PASSWORD:</td></tr>
	    <tr><td><input class="reg_pr_input_text_field" type="password" id="verifyPasswordId" name="verifyPassword"/></td></tr>
		<tr style="height: 25px;"><td></td></tr>
	    <tr><td><h4><button class="reg_profile_save_subt_Btn" id="savePassChangesButtId">SAVE CHANGES</button></h4></td></tr>
		</table> </div> </div> </div> </div> <div class="col-md-6 col-sm-6"> </div> </div>
		</form> </div> </div> </div> </div> </div> </div>		     
		</body>
</html>