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
	<script type="text/javascript" src="resources/js/admin_new_designer_validation.js"></script>

	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">            
            <div class="row">            
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6">	                
	                <div class="subtitle-section text-center">
                		<h2>NEW DESIGNER</h2>                
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
            		                
	                <form action="newDesignerDataSaving" name="register" method="post">
	                
					<div align="center">
					<table>					
					<c:if test="${not empty regErrorPage}"> 
					<tr><td align="center"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;"> &nbsp;&nbsp;&nbsp;&nbsp; ${regErrorPage}</font></td></tr></c:if>
					
					<tr><td class="dd_txt_field_disply">FIRST NAME:</td></tr>			
					<tr><td><input id="firstNameId" type="text" name="firstName" class="dd_input_box_disply"></td></tr>
			
					<tr><td class="dd_txt_field_disply">LAST NAME:</td></tr>	
					<tr><td><input id="lastNameId" type="text" name="lastName" class="dd_input_box_disply"></td></tr>
			
					<tr><td class="dd_txt_field_disply">EMAIL:</td></tr>	
					<tr><td><input id="userNameId" type="text" name="userName" class="dd_input_box_disply"></td></tr>
			
					<tr><td class="dd_txt_field_disply">PHONE NUMBER:</td></tr>	
					<tr><td><input id="phoneNumberId" type="text" name="phoneNumber" maxLength="12" class="dd_input_box_disply" onkeyup="return phoneFormat (event,phoneNumberId)" onkeypress="return numberonly(event,false)"></td></tr>
					
					<tr><td class="dd_txt_field_disply">PASSWORD:</td></tr>	
					<tr><td><input id="createPasswordId" type="password" name="createPassword" class="dd_input_box_disply"></td></tr>
								
					<tr><td class="dd_txt_field_disply">PERSONAL BIO:</td></tr>	
					<tr><td><textarea id="desnPersonalBioId" name="desnPersonalBio" class="dd_textarea_box_dsplay"></textarea></td></tr>
					
					<tr><td class="dd_txt_field_disply">LOCATION:</td></tr>	
					<tr><td><textarea id="desnLocationId" name="desnLocation" class="dd_textarea_box_dsplay"></textarea></td></tr>
					
					<tr><td class="dd_txt_field_disply">CREDENTIALS:</td></tr>	
					<tr><td><textarea id="desnCredentialId" name="desnCredential" class="dd_textarea_box_dsplay"></textarea></td></tr>
					
					
					<tr><td class="dd_reg_butt_adj"><h4><button class="continue_submit_Btn" id="regButtonId">Register</button></h4></td></tr>
				
					</table>					
					</div>								
					</form>
					
					<div style="margin-top: -37px; margin-left: -235px;">
			        <form action="admDesnDirectory" method="get">
					<h4><input class="back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
					</form> 
			        </div>                
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
