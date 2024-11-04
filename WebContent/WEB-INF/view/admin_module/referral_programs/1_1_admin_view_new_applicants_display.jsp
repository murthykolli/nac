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
	.referral_admin_submit_btn { font: 500 1.7em/1.5em Georgia;  vertical-align: middle; background-color: #1f4e79; color: white; display: inline-block; padding: 7px 45px;  outline: none; border: none; letter-spacing: 1px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.referral_admin_submit_btn:hover { background-color: red; color: white; cursor: pointer; }
	
	.admin_reff_text_field_disp{ font: 1.15em/1.25em Georgia; letter-spacing: 1px; color: black; text-transform: uppercase; padding-top: 35px; padding-right: 25px; }
	.admin_reff_big_text_field_disp{ font: 1.2em/1.25em Georgia; letter-spacing: 1px; color: black; text-transform: uppercase; padding-top: 25px; padding-left: 10px; border-bottom: 1px solid #1560ac; padding-bottom: 7px; width: 500px; }
	
	</style>	
	
	<script type="text/javascript">
 	$(document).ready(function(){ 		
		
 	   	var vendorCategory1 = '<c:out value="${vendorCategory}"/>';
 	  	var otherCategory1 = '<c:out value="${otherCategory}"/>';
 	  	if(vendorCategory1 == "Other") {
 	  		$("#otherCategoryDspId").show(); 	  		
 	  	} else {
 	  		$("#otherCategoryDspId").hide();
 	  	}
 	  	
 	  	var adminApprovalRef1 = "<c:out value="${adminApprovalRef}"/>";
	    if(adminApprovalRef1 == "Admin Approved") {
	    	alert("Your system generated password have been saved and sent mail to selected user.")
	    }

 	  	var adminDonotApprovalRef1 = "<c:out value="${adminDonotApprovalRef}"/>";
	    if(adminDonotApprovalRef1 == "Admin Donot Approved") {
	    	alert("Admin not approved selected user right now!")
	    }
	    var adminReferralNote1 = "<c:out value="${adminReferralNote}"/>";
	    $("#adminViewNoteId").click(function () {
		    if(adminReferralNote1 === "") {
		    	alert("Admin not given any note right now!");
		    	return false;
			}
		});    
 	   		    
 	});
 	</script>
 	
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        
      		<div class="row" style="margin-top: -30px; margin-bottom: 50px;">
      			<div class="col-md-2 col-sm-2"></div>
      		        
				<div class="col-md-8 col-sm-8">				
					<table style="margin-top: 0px;"> 
		      			<tr> <td align="right" class="admin_reff_text_field_disp">FIRST NAME*:</td> <td class="admin_reff_big_text_field_disp" align="left">${referralFirstName}</td> </tr>
						<tr> <td align="right" class="admin_reff_text_field_disp">LAST NAME*:</td> <td class="admin_reff_big_text_field_disp" align="left">${referralLastName}</td> </tr>
						<tr> <td align="right" class="admin_reff_text_field_disp">BUSINESS NAME*:</td> <td class="admin_reff_big_text_field_disp" align="left">${referralBusinessName}</td> </tr>
						<tr> <td align="right" class="admin_reff_text_field_disp">WEBSITE:</td> <td class="admin_reff_big_text_field_disp" align="left">${referralWebsite}</td> </tr>
						<tr> <td align="right" class="admin_reff_text_field_disp">VENDOR CATEGORY*:</td> <td class="admin_reff_big_text_field_disp" align="left">${vendorCategory}</td> </tr>
						<tr style="display: none;" id="otherCategoryDspId"> <td align="right" class="admin_reff_text_field_disp">OTHER CATEGORY*:</td> <td class="admin_reff_big_text_field_disp" align="left">${otherCategory}</td> </tr>
						<tr> <td align="right" class="admin_reff_text_field_disp">FACEBOOK PAGE OR INSTAGRAM HANDLE:</td> <td class="admin_reff_big_text_field_disp" align="left">${referralSocialMediaInfo}</td> </tr>
						<tr> <td align="right" class="admin_reff_text_field_disp">EMAIL*:</td> <td class="admin_reff_big_text_field_disp" align="left">${referralUserEmail}</td> </tr>
						<tr> <td align="right" class="admin_reff_text_field_disp">PHONE NUMBER*:</td> <td class="admin_reff_big_text_field_disp" align="left">${referralPhoneNumber}</td> </tr>
							
						
					</table>
						            
				</div>
		
				<div class="col-md-2 col-sm-2"></div>
		   			   		
		   	</div>
		   	
		   	
	        <div class="row top_adjustment_70">
	        
	        <div class="col-md-12 col-sm-12" align="center">
		        <table> <tbody>
			        <tr>
			        <td style="position: relative; left: -40px;"> <a href="adminNewApplicants"><img title="BACK" class="prod_upload_back_butt_adj" src="resources/images/backButton.png"></a> </td> 
					<td style="position: relative; left: -20px;"><form action="adminApproveToReferralUser"><button class="referral_admin_submit_btn">Approve</button><input type="hidden" name="referralUserId" value="${referralUserId}"></form></td>
					<td style="position: relative; left: 0px;"><form action="adminDonotApproveToReferralUser"><button class="referral_admin_submit_btn">Don't Approve</button><input type="hidden" name="referralUserId" value="${referralUserId}"></form></td>		
					<td style="position: relative; left: 20px;"><form action="adminViewNoteReferralInfo"><button id="adminViewNoteId" class="referral_admin_submit_btn">View Note</button><input type="hidden" name="referralUserId" value="${referralUserId}"></form></td>
					<td style="position: relative; left: 40px;"><form action="adminDeleteReferralUser"><button id="adminViewNoteId" class="referral_admin_submit_btn" onclick="return confirm('Are you sure you want to delete selected referral user?');">Delete</button><input type="hidden" name="referralUserId" value="${referralUserId}"></form></td>
					</tr>
				</tbody> </table>
			
			</div>
			
	        </div> <!-- /.row -->
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                
            	
		</body>
</html>