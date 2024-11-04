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
    window.onload=function(){ document.register.elements['securityPin'].focus(); };    
    </script>
	</head>	
		<body>		
		<div id="mainframe" class="section-content"> <div class="container">
		<div class="subtitle-section text-center">  <h2>Security PIN</h2> </div> 
		<div class="services"> <div class="service-item"> <div class="service-description text-center bot_adjustment_40">
		<form action="regForgotPassSecPinChecking" name="register" method="post">
		<div align="center">
		<table> <c:if test="${not empty forPassSeqPinErrorPage}"> <tr> <td align="center"><img src="resources/images/warning.gif" class="reg_login_abs_cl"> <font class="reg_login_error_msg_dsp"> &nbsp;&nbsp;&nbsp;&nbsp; ${forPassSeqPinErrorPage}</font></td> </tr> <tr class="reg_login_tr_smheight"><td></td></tr> </c:if>
		<c:if test="${not empty secPinMessage}"> <tr id="logOutMsgId"> <td><font class="reg_login_logout_msg_dsp"> ${secPinMessage}</font> </td> </tr> <tr class="reg_login_tr_height"><td></td></tr> </c:if>
		<tr> <td class="txt_field_disp">Security PIN:</td> </tr>
		<tr> <td><input type="text" class="input_box_disp" id="securityPinId" name="securityPin" maxLength="8"></td> </tr>
		<tr><td class="txt_field_disp">New password:</td> </tr>
		<tr> <td><input type="password" class="input_box_disp" id="newPasswordId" name="newPassword"> </td> </tr>
		<tr><td class="txt_field_disp">Confirm password:</td> </tr>
		<tr> <td><input type="password" class="input_box_disp" id="confirmPasswordId" name="confirmPassword"> </td> </tr>						                                		
		<tr class="reg_login_tr_height"><td></td></tr>		
		<tr> <td class="login_butt_adj"> <h4> <button class="continue_submit_Btn" id="secPinButtonId">Save Password</button> </h4> </td> </tr> </table>
		</div>
		</form>
		</div> </div> </div> </div> </div>		
		</body>	
</html>