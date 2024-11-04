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
    <link rel="stylesheet" href="resources/css/registry_css/registry_static.css">
	<script type="text/javascript" src="resources/js/login_reg_validation.js"></script>
	<script type="text/javascript">
	history.pushState(null, null, location.href); history.back(); history.forward(); window.onpopstate = function () { history.go(1); }; window.onload=function(){ document.login.elements['userName'].focus(); }; function removeLogOutMsg() { document.getElementById("logOutMsgId").style.display='none'; }        
    </script>    
	</head>	
		<body>
		
		<div id="mainframe" class="section-content"> <div class="container">
		<div class="subtitle-section text-center">  <h2>SIGN IN</h2> </div> 
		<div class="services"> <div class="service-item"> <div class="service-description text-center bot_adjustment_40">
		<form action="registryLoginVerification" name="login" method="post">
		<div align="center">
		<table> <c:if test="${not empty errorPage}"> <tr> <td align="center"><img src="resources/images/warning.gif" class="reg_login_abs_cl"> <font class="reg_login_error_msg_dsp"> &nbsp;&nbsp;&nbsp;&nbsp; ${errorPage}</font></td> </tr> </c:if>
		<c:if test="${not empty logOutMessage}"> <tr id="logOutMsgId"> <td><font class="reg_login_logout_msg_dsp"> ${logOutMessage}</font> </td> </tr> </c:if>
		<tr> <td class="txt_field_disp">EMAIL:</td> </tr>
		<tr> <td><input type="text" id="userEmailId" name="regUserName" class="input_box_disp" onclick="removeLogOutMsg();"></td> </tr>
		<tr><td class="txt_field_disp">PASSWORD:</td> </tr>
		<tr> <td><input type="password" class="input_box_disp" id="passwordId" name="password"> </td> </tr>						                                		
		<tr class="reg_login_tr_height"><td></td></tr>
		<tr> <td class="login_txt_display">FORGOT YOUR PASSWORD?<span class="login_link_disp"><a href="registryForgotPassword">CLICK HERE</a></span></td> </tr>
		<tr class="reg_login_tr_height"><td></td></tr>		
		<tr> <td align="center"><span class="referral_user_login_link"><a href="referralUserLogin">Referral Program Login</a></span></td> </tr>
		<tr class="reg_login_tr_height"><td></td></tr>
		<tr> <td class="login_butt_adj"> <h4> <button class="continue_submit_Btn" id="loginButtonId">SIGN IN</button> </h4> </td> </tr> </table>
		</div>
		<input type="hidden" name="loginRedirectRef" value="My Registry">
		</form>
		</div> </div> </div> </div> </div>				
		</body>
</html>