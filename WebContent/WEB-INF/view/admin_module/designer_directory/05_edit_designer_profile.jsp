<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="images/ico/favicon.ico" type="image/x-icon">
	
	<script type="text/javascript" src="resources/js/new_designer_validation.js"></script>

	<script type="text/javascript">
    $(document).ready(function(){    	        
    	var firstName1 = '<c:out value="${firstName}"/>';
    	var lastName1 = '<c:out value="${lastName}"/>';
    	var userName1 = '<c:out value="${userName}"/>';
    	var phoneNumber1 = '<c:out value="${phoneNumber}"/>';
    	var desnPersonalBio1 = '<c:out value="${desnPersonalBio}"/>';
    	var desnLocation1 = '<c:out value="${desnLocation}"/>';
    	var desnCredential1 = '<c:out value="${desnCredential}"/>';
    	   	
    	$("[name=firstName]").val(firstName1);
    	$("[name=lastName]").val(lastName1);
    	$("[name=userName]").val(userName1);
    	$("[name=phoneNumber]").val(phoneNumber1);
    	$("[name=desnPersonalBio]").val(desnPersonalBio1);
    	$("[name=desnLocation]").val(desnLocation1);
    	$("[name=desnCredential]").val(desnCredential1);
    });

    </script>

	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
         
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-5 col-sm-5">
        <div class="adm_new_cl_head_txt_dsp" align="left">CHANGE PROFILE</div>
        </div>
        
        <div class="col-md-5 col-sm-5">
        <div class="adm_new_cl_head_txt_dsp" align="left">CHANGE PASSWORD</div>
        </div>
              
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
         
        <div class="row top_adjustment_5">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-5 col-sm-5">
        <div class="desn_profile_frame_dsp" align="center">
        <form action="editDesignerDataSaving" name="register" method="post">
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
										
		<tr><td class="dd_txt_field_disply">PERSONAL BIO:</td></tr>	
		<tr><td><textarea id="desnPersonalBioId" name="desnPersonalBio" class="dd_textarea_box_dsplay"></textarea></td></tr>
					
		<tr><td class="dd_txt_field_disply">LOCATION:</td></tr>	
		<tr><td><textarea id="desnLocationId" name="desnLocation" class="dd_textarea_box_dsplay"></textarea></td></tr>
					
		<tr><td class="dd_txt_field_disply">CREDENTIALS:</td></tr>	
		<tr><td><textarea id="desnCredentialId" name="desnCredential" class="dd_textarea_box_dsplay"></textarea></td></tr>
					
		<tr><td class="dd_profile_butt_adj"><h4><button class="continue_submit_Btn" id="editDesnButtonId">SAVE</button></h4></td></tr>
		</table>
		</form>
        </div>
        </div>
        
        <div class="col-md-5 col-sm-5">
        <div class="desn_profile_frame_dsp" align="center">
        <form action="desnChangePasswordInDb" name="register" method="post">
        <table>					
		<c:if test="${not empty changePasswordError}"> 
		<tr><td align="center"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;"> &nbsp;&nbsp;&nbsp;&nbsp; ${changePasswordError}</font></td></tr></c:if>
					
		<tr><td class="dd_txt_field_disply">CURRENT PASSWORD:</td></tr>	
		<tr><td><input id="currentPasswordID" type="password" name="currentPassword" class="dd_input_box_disply"></td></tr>
		
		<tr><td class="dd_txt_field_disply">NEW PASSWORD:</td></tr>	
		<tr><td><input id="newPasswordID" type="password" name="newPassword" class="dd_input_box_disply"></td></tr>
					
		<tr><td class="dd_txt_field_disply">CONFIRM PASSWORD:</td></tr>	
		<tr><td><input id="confirmPasswordID" type="password" name="confirmPassword" class="dd_input_box_disply"></td></tr>
					
		<tr><td class="dd_profile_butt_adj"><h4><button class="continue_submit_Btn" id="desChangePassButtonId">SAVE</button></h4></td></tr>
		</table>
		</form>
        </div>
        </div>
              
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="adm_new_cl_head_txt_dsp" align="left">
        <form action="admDesnDirectory" method="get">
		<h4><input class="dash_board_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
		</form>
        </div>
        </div>
                      
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
         
         		      
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->	
		</body>
</html>
