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

	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
         
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-5 col-sm-5">
        <div class="adm_new_cl_head_txt_dsp" align="left">CHANGE PASSWORD</div>
        </div>
        
        <div class="col-md-5 col-sm-5">
        </div>
              
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
         
        <div class="row top_adjustment_5">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
                
        
        <div class="col-md-5 col-sm-5">
        <div class="desn_profile_frame_dsp" align="center">
        <form action="adminChangePasswordSavingInDB" name="register" method="post">
        <table>					
		<c:if test="${not empty changePasswordError}"> 
		<tr><td align="center"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;"> &nbsp;&nbsp;&nbsp;&nbsp; ${changePasswordError}</font></td></tr></c:if>
					
		<tr><td class="dd_txt_field_disply">CURRENT PASSWORD:</td></tr>	
		<tr><td><input id="currentPasswordID" type="password" name="currentPassword" class="dd_input_box_disply"></td></tr>
		
		<tr><td class="dd_txt_field_disply">NEW PASSWORD:</td></tr>	
		<tr><td><input id="newPasswordID" type="password" name="newPassword" class="dd_input_box_disply"></td></tr>
					
		<tr><td class="dd_txt_field_disply">CONFIRM PASSWORD:</td></tr>	
		<tr><td><input id="confirmPasswordID" type="password" name="confirmPassword" class="dd_input_box_disply"></td></tr>
					
		<tr><td class="dd_profile_butt_adj"><h4><button class="continue_submit_Btn" id="adminChangePassButtonId">SAVE</button></h4></td></tr>
		</table>
		</form>
        </div>
        </div>
        
        <div class="col-md-5 col-sm-5">
        </div> <!-- /.col-md-5 --> 
              
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="adm_new_cl_head_txt_dsp" align="left">
        <form action="admnAccounts" method="get">
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
