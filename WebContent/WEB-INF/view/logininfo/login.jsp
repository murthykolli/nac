<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">

    <!-- JavaScripts -->
    <script type="text/javascript" src="resources/js/login_reg_validation.js"></script>

    <script type="text/javascript">
        window.location.hash = "";
        window.location.hash = "";
        window.onhashchange = function () {
            window.location.hash = "";
        };
        window.onload = function () {
            window.history.forward(1);
        };

        window.onload = function () {
            document.login.elements['userName'].focus();
        };

        function removeLogOutMsg() {
            document.getElementById("logOutMsgId").style.display = 'none';
        }

        $(document).ready(function(){
        	$("input[name=loginRedirectRef][value='My Design Process']").prop("checked",true);
        });
    </script>

</head>
<body>

<div id="mainframe" class="section-content">
    <div class="container">

        <div class="subtitle-section text-center">
            <h2>SIGN IN</h2>
        </div> <!-- /.title-section -->
        <div class="services">
            <div class="service-item">
                <div class="service-description text-center" style="margin-top: -40px;">
                    <form action="loginVerification" name="login" method="post">
                        <div align="center">
                            <table>
                                <c:if test="${not empty errorPage}">
                                    <tr>
                                        <td align="center"><img src="resources/images/warning.gif" alt="nookandcove warning"
                                                                style="position: absolute;"> <font
                                                style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;">
                                            &nbsp;&nbsp;&nbsp;&nbsp; ${errorPage}</font></td>
                                    </tr>
                                </c:if>
                                <c:if test="${not empty logOutMessage}">
                                    <tr id="logOutMsgId">
                                        <td><font
                                                style="font: 1.1em/1.25em Georgia; letter-spacing: 2px; white-space: nowrap; color: #2b81ee; position: absolute; margin-top: -10px; width: 280px;"> ${logOutMessage}</font>
                                        </td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td class="txt_field_disp">EMAIL:</td>
                                </tr>
                                <tr>
                                    <td><input type="text" class="input_box_disp" id="userEmailId" name="userName"
                                               onclick="removeLogOutMsg();"></td>
                                </tr>

                                <tr>
                                    <td class="txt_field_disp">PASSWORD:</td>
                                </tr>
                                <tr>
                                    <td><input type="password" class="input_box_disp" id="passwordId" name="password">
                                    </td>
                                </tr>
                                
                                <tr style="height: 20px; display: none;"><td></td></tr>
                                
                                <tr style="display: none;">
                                    <td class="login_radio_text_disp"><input type="radio" name="loginRedirectRef" value="My Design Process"><span class="login_radio_text_position">I WANT TO SIGN IN TO MY <font class="login_radio_boldtext_dsp">DESIGN PROCESS</font></span></td>
                                </tr>
                                
                                <tr style="display: none;">
                                    <td class="login_radio_text_disp"><input type="radio" name="loginRedirectRef" value="My Registry"><span class="login_radio_text_position">I WANT TO SIGN IN TO MY <font class="login_radio_boldtext_dsp">REGISTRY</font></span></td>
                                </tr>

								<tr style="height: 20px;"><td></td></tr>
								
                                <tr>
                                    <td class="login_txt_display">FORGOT YOUR PASSWORD?<span class="login_link_disp"><a
                                            href="forgotPassword">CLICK HERE</a></span></td>
                                </tr>

                                <tr>
                                    <td class="login_butt_adj">
                                        <h4>
                                            <button class="continue_submit_Btn" id="loginButtonId">SIGN IN</button>
                                        </h4>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </form>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div>
        
        <div class="desktop">
        	<c:if test="${not empty errorPage}">
		        <div style="position: absolute; margin-top: -247px; margin-left: 0px;">
		        <img src="/resources/images/registry/both_login_image.png">
		        </div>
	        </c:if>
	 	</div>
	 	
        
    </div> <!-- /.container -->
</div> <!-- /.Main Frame -->

</body>
</html>