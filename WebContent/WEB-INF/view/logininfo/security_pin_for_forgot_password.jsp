<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    window.onload=function(){ document.register.elements['securityPin'].focus(); };    
    </script> 

	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">            
            <div class="row">            
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6 login-frame">                
	                <form action="forgotPassSecPinChecking" name="register" method="post">
	                <div class="subtitle-section text-center">
                	<h2>Security PIN</h2>                
            		</div> <!-- /.title-section -->
					
					<div align="center">
					<table>								
					<c:if test="${not empty forPassSeqPinErrorPage}"> <tr><td><img src="resources/images/warning.gif" alt="nookandcove warning" style="position: absolute;"> <font style="color: #c00002; font: 1.1em/1.25em sans-serif; "> &nbsp;&nbsp;&nbsp;&nbsp; ${forPassSeqPinErrorPage}</font></td></tr> </c:if>
			        <c:if test="${not empty secPinMessage}"> <tr id="logOutMsgId"><td><font style="font: 1.05em/1.25em sans-serif; white-space: nowrap; color: #2b81ee; position: absolute; margin-top: 5px; width: 270px;"> ${secPinMessage}</font></td></tr> </c:if>
					<tr><td style="height: 15px;"></td></tr>		
					<tr><td><input type="text" id="securityPinId" name="securityPin" maxLength="8" placeholder="Security PIN"> </td></tr>
					<tr><td><input id="newPasswordId" type="password" name="newPassword" placeholder="New password"> </td></tr>
					<tr><td><input id="confirmPasswordId" type="password" name="confirmPassword" placeholder="Confirm password"> </td></tr>
			
					<tr><td style="height: 25px;"></td></tr>
					<tr><td><h4><button class="mainsubmitBtn" id="secPinButtonId">Save Password</button></h4></td></tr>
					</table>
					</div>			
					</form>		                   
                </div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->               
            </div> <!-- /.row -->            
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
		
		</body>
</html>