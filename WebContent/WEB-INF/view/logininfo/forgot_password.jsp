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
    window.onload=function(){ document.register.elements['userName'].focus(); };    
    </script>

	</head>	
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">            
            <div class="row">            
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6 login-frame">                
	                <form action="forgotPasswordSendingToEmail" name="register">
	                <div class="subtitle-section text-center">
                	<h2>FORGOT PASSWORD</h2>                
            		</div> <!-- /.title-section -->
					
					<div align="center">
					<table>					
					<c:if test="${not empty forPassErrorPage}"> <tr><td><img src="resources/images/warning.gif" alt="nookandcove warning" style="position: absolute;"> <font style="color: #c00002; font: 1.1em/1.25em sans-serif; "> &nbsp;&nbsp;&nbsp;&nbsp; ${forPassErrorPage}</font></td></tr> </c:if>
				
					<tr><td><input type="text" id="userEmailId" name="userName" placeholder="Email"> </td></tr>
			
					<tr><td><h4><button class="mainsubmitBtn" id="forgotPassButtonId">Email me a Pin</button></h4></td></tr>
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