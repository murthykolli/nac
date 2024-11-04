<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    <script type="text/javascript" src="resources/js/referral_login/referral_signup_validation.js"></script>
	<link rel="stylesheet" href="resources/css/referral_login/referral_login.css">		
    <script type="text/javascript">
        window.location.hash = ""; window.location.hash = ""; window.onhashchange = function () { window.location.hash = ""; }; window.onload = function () { window.history.forward(1); }; window.onload = function () { document.login.elements['userName'].focus(); };
        function removeLogOutMsg() { document.getElementById("logOutMsgId").style.display = 'none'; }        
    </script>
</head>
	<body>
	<div id="mainframe" class="section-content"> <div class="container">
		<div class="row top_adjustment_40"> <div class="col-md-7 col-sm-7"> <div class="service-item"> <div class="service-description"> <div class="top_adjustment_50 referral_left_text_frame">
	    <div> <h2> <font class="referral_login_hd_text_dis">Registry &nbsp;</font> <font class="referral_login_hdsub_text_dsp">REFERRAL PROGRAM</font> </h2> </div>
	    <div class="top_adjustment_30" style="width: 450px;"> <p class="referral_login_small_text_dsp">Our referral program is open to all Wedding Professionals! Simply refer a client to the Nook+Cove Registry with your unique referral code and earn either Nook+Cove credit that you can use to purchase anything on our website or Visa gift cards! <a href="referralLearnMore" class="referral_lm_text_dsp">Learn More</a></p> </div>
	    <div class="top_adjustment_50"> <form action="referralFormCreation"> <h4><button class="referral_signup_sub_buttn" id="referralSignUpId">SIGN UP NOW</button></h4> </form> </div> </div> </div> </div> </div>
	    <div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description"> <div class="referral_right_login_frame">
	    <div align="center" class="top_adjustment_5"><font class="referral_login_hd_fl_dsp">R</font><font class="referral_login_hd_nl_dsp">EFERRAL </font><font class="referral_login_hd_fl_dsp">P</font><font class="referral_login_hd_nl_dsp">ROGRAM </font><font class="referral_login_hd_fl_dsp">S</font><font class="referral_login_hd_nl_dsp">IGN </font> <font class="referral_login_hd_fl_dsp">I</font><font class="referral_login_hd_nl_dsp">N</font></div>
	    <form action="referralLoginVerification" name="login" method="post"> <div class="top_adjustment_30" align="center">
	    <table> <c:if test="${not empty referralErrorStatus}"> <tr> <td align="center"><img src="resources/images/warning.gif" alt="nookandcove warning" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;"> &nbsp;&nbsp;&nbsp;&nbsp; ${referralErrorStatus}</font></td> </tr> </c:if>
	    <c:if test="${not empty logOutMessage}"> <tr id="logOutMsgId"> <td><font style="font: 1.1em/1.25em Georgia; letter-spacing: 2px; white-space: nowrap; color: #2b81ee; margin-top: -8px; width: 300px;"> ${logOutMessage}</font> </td> </tr> </c:if>
	    <tr> <td class="txt_field_disp">EMAIL:</td> </tr>
	    <tr> <td><input type="text" class="reff_input_box_disp" id="referralUserEmailId" name="referralUserEmail" onclick="removeLogOutMsg();"></td> </tr>
		<tr> <td class="txt_field_disp">PASSWORD:</td> </tr>
	    <tr> <td><input type="password" class="reff_input_box_disp" id="referralPasswordId" name="referralPassword"> </td> </tr> <tr style="height: 20px;"><td></td></tr>
		<tr> <td class="login_txt_display">FORGOT YOUR PASSWORD?<span class="login_link_disp"><a href="refferalForgotPassword">CLICK HERE</a></span></td> </tr>
		<tr> <td class="login_butt_adj"> <h4> <button class="referral_signin_sub_buttn" id="referralLoginButtonId">SIGN IN</button> </h4> </td> </tr> </table> </div> </form> </div> </div> </div> </div> </div>		
		<div align="center"><img alt="Refferal Login Image" src="resources/images/referral/referral_login_image.png" style="position: absolute; margin-top: -17%; margin-left: -6.2%;"></div> <div class="top_adjustment_20"></div>        
    </div> </div>
	</body>
</html>