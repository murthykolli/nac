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
	
	<style type="text/css">
	.referral_admin_submit_btn { font: 500 1.7em/1.5em Georgia;  vertical-align: middle; background-color: #1f4e79; color: white; display: inline-block; padding: 7px 60px;  outline: none; border: none; letter-spacing: 1px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.referral_admin_submit_btn:hover { background-color: red; color: white; cursor: pointer; }
	
	.admin_reff_text_field_disp{ font: 1.2em/1.25em Georgia; letter-spacing: 1px; color: black; padding-left: 5px; }
	.admin_reff_big_text_field_disp{ font: 1.2em/1.25em Georgia; letter-spacing: 1px; color: black; margin-top: 6px; background-color: white; border: 2px solid #595959; padding: 15px; width: 600px; height: 250px; }
	
	</style>	
	 
    <script type="text/javascript">       
   	window.onload = function () {
    	document.referralFormName.elements['adminReferralNote'].focus();
   	};

    </script>
    	
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        	<form action="adminNoteInfoSaving" name="referralFormName">
      		<div class="row" style="margin-top: -20px; margin-bottom: 50px;">
      			<div class="col-md-2 col-sm-2"></div>
      		        
				<div class="col-md-8 col-sm-8" align="center">				
					<table style="margin-top: 0px;"> 
		      			<tr> <td align="left" class="admin_reff_text_field_disp">Note:</td> </tr>
		      			<tr> <td align="left"><textarea name="adminReferralNote" class="admin_reff_big_text_field_disp"></textarea></td> </tr>
												
					</table>
						            
				</div>
		
				<div class="col-md-2 col-sm-2"></div>
		   			   		
		   	</div>
		   	
		   	
	        <div class="row top_adjustment_70">
	        <div class="col-md-2 col-sm-2"></div>
	        
	        <div class="col-md-8 col-sm-8" align="center">
		        <table> <tbody>
			        <tr>
			        	<td><button class="referral_admin_submit_btn">Save</button></td>
					</tr>
				</tbody> </table>
			
			</div>
			
			<div class="col-md-2 col-sm-2"></div>
	        </div> <!-- /.row -->
	        <input type="hidden" name="referralUserId" value="${referralUserId}">
	        </form>
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                
            	
		</body>
</html>