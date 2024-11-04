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

</head>

<body>
<div id="mainframe" class="section-content">
    <div class="container">

        <div class="subtitle-section text-center">
            <h2>REGISTER</h2>
        </div> <!-- /.title-section -->

        <div class="services">
            <div class="service-item">
                <div class="service-description text-center">

                    <form action="registrationDataSaving" name="register" method="post">

                        <div align="center" style="margin-top: -30px;">
                            <table>
                                <c:if test="${not empty regErrorPage}">
                                    <tr>
                                        <td align="center"><img src="resources/images/warning.gif" alt="nookandcove warning"
                                                                style="position: absolute;"> <font
                                                style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;">
                                            &nbsp;&nbsp;&nbsp;&nbsp; ${regErrorPage}</font></td>
                                    </tr>
                                </c:if>

                                <tr>
                                    <td class="txt_field_disp">FIRST NAME:</td>
                                </tr>
                                <tr>
                                    <td><input id="firstNameId" class="input_box_disp" type="text" name="firstName">
                                    </td>
                                </tr>

                                <tr>
                                    <td class="txt_field_disp">LAST NAME:</td>
                                </tr>
                                <tr>
                                    <td><input id="lastNameId" class="input_box_disp" type="text" name="lastName"></td>
                                </tr>

                                <tr>
                                    <td class="txt_field_disp">EMAIL:</td>
                                </tr>
                                <tr>
                                    <td><input id="userNameId" class="input_box_disp" type="text" name="userName"></td>
                                </tr>

                                <tr>
                                    <td class="txt_field_disp">PASSWORD:</td>
                                </tr>
                                <tr>
                                    <td><input id="createPasswordId" class="input_box_disp" type="password"
                                               name="createPassword"></td>
                                </tr>

                                <!-- <tr><td class="txt_field_disp">VERIFY PASSWORD:</td></tr>
                                <tr><td><input id="verifyPasswordId" class="input_box_disp" type="password" name="verifyPassword"></td></tr> -->

                                <tr>
                                    <td class="login_txt_display">ALREADY HAVE AN ACCOUNT?<span class="login_link_disp"><a
                                            href="alreadyHaveAnAccount">SIGN IN HERE</a></span></td>
                                </tr>

                                <tr>
                                    <td class="login_butt_adj">
                                        <h4>
                                            <button class="continue_submit_Btn" id="regButtonId">SIGN UP</button>
                                        </h4>
                                    </td>
                                </tr>

                            </table>
                        </div>
                    </form>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div>
    </div> <!-- /.container -->
</div> <!-- /.Main Frame -->

</body>
</html>