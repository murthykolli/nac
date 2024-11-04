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
	
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
         
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-8 col-sm-8">
        <div class="adm_new_cl_head_txt_dsp" align="left">DESIGNER PROFILE</div>
        </div>
            
        <div class="col-md-3 col-sm-3">
        </div> <!-- /.col-md-3 --> 
        </div> <!-- /.row -->
         
        <div class="row top_adjustment_5">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-8 col-sm-8">
        <div class="desn_profile_frame_dsp" align="center">
        <table>
		<tr><td class="dd_txt_field_disply">FIRST NAME:</td> <td class="add_text_fields_names_disply">${firstName}</td></tr>
		<tr><td class="dd_txt_field_disply">LAST NAME:</td>  <td class="add_text_fields_names_disply">${lastName}</td></tr>
		<tr><td class="dd_txt_field_disply">EMAIL:</td>  <td class="add_text_fields_data_disply">${userName}</td></tr>
		<tr><td class="dd_txt_field_disply">PHONE NUMBER:</td>  <td class="add_text_fields_data_disply">${phoneNumber}</td></tr>
		<tr><td class="dd_txt_field_disply">PERSONAL BIO:</td>  <td class="add_text_fields_data_disply">${desnPersonalBio}</td></tr>
		<tr><td class="dd_txt_field_disply">LOCATION:</td>  <td class="add_text_fields_data_disply">${desnLocation}</td></tr>
		<tr><td class="dd_txt_field_disply">CREDENTIALS:</td>  <td class="add_text_fields_data_disply">${desnCredential}</td></tr>
		</table>
		</div>
        </div>
             
        <div class="col-md-3 col-sm-3">
        </div> <!-- /.col-md-3 --> 
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="adm_new_cl_head_txt_dsp" align="left">
        <form action="admInactiveDesigners" method="get">
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
