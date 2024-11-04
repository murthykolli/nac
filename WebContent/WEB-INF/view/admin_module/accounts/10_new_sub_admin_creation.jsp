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
	<script type="text/javascript" src="resources/js/new_designer_validation.js"></script>
	
	</head>
		
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">            
            <div class="row">            
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6">	                
	                <div class="subtitle-section text-center">
                		<h2>CREATE SUB ADMIN</h2>                
            		</div> <!-- /.title-section -->
            	</div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->               
            </div> <!-- /.row -->          
			
			<div class="row top_adjustment_30">
			
			<div class="col-md-4">
        	</div> <!-- /.col-md-4-->
        	
			<div class="col-md-4 col-sm-6">
        		<div class="service-item">                        
            		<div class="service-description text-center">
            		                
	                <form action="createSubAdminDataSaving" name="register" method="post">
	                
					<div align="center">
					<table>					
					<c:if test="${not empty regErrorPage}"> 
					<tr><td align="center"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;"> &nbsp;&nbsp;&nbsp;&nbsp; ${regErrorPage}</font></td></tr></c:if>
					
					<tr><td class="txt_field_disp">FIRST NAME:</td></tr>			
					<tr><td><input id="firstNameId" class="input_box_disp" type="text" name="firstName"></td></tr>
			
					<tr><td class="txt_field_disp">LAST NAME:</td></tr>	
					<tr><td><input id="lastNameId" class="input_box_disp" type="text" name="lastName"></td></tr>
			
					<tr><td class="txt_field_disp">EMAIL:</td></tr>	
					<tr><td><input id="userNameId" class="input_box_disp" type="text" name="userName"></td></tr>
			
					<tr><td class="txt_field_disp">PASSWORD:</td></tr>	
					<tr><td><input id="createPasswordId" class="input_box_disp" type="password" name="createPassword"></td></tr>
			
					<!-- <tr><td class="txt_field_disp">VERIFY PASSWORD:</td></tr>	
					<tr><td><input id="verifyPasswordId" class="input_box_disp" type="password" name="verifyPassword"></td></tr> -->
					
					<tr><td style="height: 40px;"></td></tr>
					
					<tr><td class="login_butt_adj"><h4><button style="margin-left: 50px;" class="continue_submit_Btn" id="createSubAdminId">SAVE</button></h4></td></tr>
				
					</table>					
					</div>								
					</form>
					
					<div style="margin-top: -37px; margin-left: -320px;"><form action="subAdminsListDsp" method="get">
					<h4><input class="dash_board_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
					</form></div>                
         	   		</div> <!-- /.service-description -->
            	</div> <!-- /.service-item -->               
        	</div> <!-- /.col-md-4 -->
                
            <div class="col-md-4 col-sm-6">                    
            </div> <!-- /.col-md-4 -->               
            </div> <!-- /.row -->            
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
		
		</body>
</html>