<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <head>
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
    <script type="text/javascript" src="resources/js/login_reg_validation.js"></script>
	<link rel="stylesheet" href="resources/css/referral_login/referral_my_account.css">
	<link rel="stylesheet" href="resources/css/referral_login/referral_login.css">
	<script type="text/javascript" src="resources/js/referral_login/referral_signup_validation.js"></script>		
	<script type="text/javascript">
 	$(document).ready(function(){ var refDataSuccSavedReff1 = "<c:out value="${refDataSuccSavedReff}"/>";
	    if(refDataSuccSavedReff1 == "Account Data Saved") { alert("Your Changes Have Been Saved") }	    
 	});
 	</script> 	
 </head>
		<body>				
		<div id="mainframe" class="section-content"> <div class="container">          
<!-- Left Code Start -->
      	<div class="row top_adjustment_0"> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description"> <div align="left">	        			
		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="reff_top_left_main_hd_cl"><h2>MY ACCOUNT</h2></div> </div> </div> </div> </div> </div>          			
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>ACCOUNT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="referralContactInfo" class="reff_left_link_text_black_color">CONTACT &amp; BUSINESS INFO</a></div>
		<div class="top_adjustment_10"><a href="referralShippingInfo" class="reff_left_link_text_black_color">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="referralPasswordInfo" class="reff_left_link_text_black_color">CHANGE PASSWORD</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REFERRALS</h3></div>
		<div class="top_adjustment_10"><a href="#" class="reff_left_link_text_red_color">MY REFERRAL CODE</a></div>
		<div class="top_adjustment_10"><a href="activeReferralsInfo" class="reff_left_link_text_black_color">ACTIVE REFERRALS</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REWARDS</h3></div>
		<div class="top_adjustment_10"><a href="nookAndCoveStoreCredit" class="reff_left_link_text_black_color">N+C STORE CREDIT</a></div>
		<div class="top_adjustment_10"><a href="visaGiftCards" class="reff_left_link_text_black_color">VISA GIFT CARDS</a></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
		<div class="col-md-9 col-sm-9 reff_right_side_bar_dspl"> <div class="service-item"> <div class="service-description"> <div align="left" class="reff_right_frame_adj_disp">	
		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="reff_top_left_main_hd_cl"><h2>My Referral Code</h2></div> </div> </div> </div> </div> </div>
		<div class="top_adjustment_30" style="width: 650px">
		<p class="my_referral_code_text">Here is your <font class="my_referral_code_text_bold">UNIQUE REFERRAL CODE</font> that you can share with your clients:</p>
		<p class="my_referral_unq_code_text top_adjustment_35">${uniqueRefferalCode}</p>
		<p class="my_referral_code_text top_adjustment_35">When your client creates a registry account, they will be prompted to add a referral code if they have one.</p>
		<p class="my_referral_code_text top_adjustment_35">As soon as a registry account is created with your referral code, your account will reflect that under the 'Active Referrals' tab to the right.</p>
		</div> </div> </div> </div> </div> </div>		
		</div> </div>		     
		</body>
</html>