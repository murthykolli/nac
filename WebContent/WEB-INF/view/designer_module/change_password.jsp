<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/login_reg_validation.js"></script>
  
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    
	<style type="text/css">	
	.fieldBoxClass { border-bottom: 1px solid black;  border-top: 2px solid white; border-left: 2px solid white;  border-right: 2px solid white; width: 280px; height: 24px; margin-top: 3px; }

	.regBoxClass { border: 1px solid black; width: 350px; min-height: 215px; height: auto; margin-left: 304px; margin-top: 50px; }
	
	.mainHeaddings { margin-left: 42px; margin-top: 20px; font: bold 1.25em/1.25em Serif, Georgia; color: #2c2c2c; white-space: nowrap; text-align: center; }

	.buttonstyleClass { background-color: #ff3b3b; color: white; font: bold 1em/1.25em sans-serif; cursor:pointer; outline: none; border: none; white-space: nowrap; padding: 10px; outline-style: none; }

	.buttonstyleClass:hover { background-color: #4c4c4c; color: white; outline: none; }

	</style>
	   
	</head>
	
		<body>		
		<div id="shadowImgId">
		<div class="clearfix" style="background-color: white; min-height: 350px; height: auto;">				
		<div class="regBoxClass">
		
		<form action="changePasswordInDb" name="register" method="post">
		<div class="mainHeaddings" style="margin-top: 10px; margin-left: 0px;">Change Password</div>

		<table style="margin-top: 20px; margin-left: 30px;">
		
		<c:if test="${not empty changePasswordError}"> <tr><td><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: #c00002; font: 0.9em/1.25em sans-serif; "> &nbsp;&nbsp;&nbsp;&nbsp; ${changePasswordError}</font></td></tr> </c:if>
        				
		<tr><td><input id="currentPasswordID" type="password" name="currentPassword" placeholder="Current password" class="fieldBoxClass"> </td></tr>
		<tr><td><input id="newPasswordID" type="password" name="newPassword" placeholder="New password" class="fieldBoxClass"> </td></tr>
		<tr><td><input id="confirmPasswordID" type="password" name="confirmPassword" placeholder="Confirm password" class="fieldBoxClass"> </td></tr>
		<tr><td><button class="buttonstyleClass" id="ChangePassButtonId" style="margin-top: 35px;">Save Password</button></td></tr>
		</table><br><br>
		</form>

		</div><br><br><br>		
		</div>
		</div>	
		</body>
</html>
