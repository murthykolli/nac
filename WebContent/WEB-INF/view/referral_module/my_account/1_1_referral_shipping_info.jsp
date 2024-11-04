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
 	$(document).ready(function(){ 		
 	  	var referralStreetAddress1 = '<c:out value="${referralStreetAddress}"/>'; var referralStreetLine1 = '<c:out value="${referralStreetLine}"/>'; var referralCityName1 = '<c:out value="${referralCityName}"/>'; var referralStateName1 = '<c:out value="${referralStateName}"/>'; var referralZipCode1 = '<c:out value="${referralZipCode}"/>'; 	  	
 	  	$("[name=referralStreetAddress]").val(referralStreetAddress1); $("[name=referralStreetLine]").val(referralStreetLine1); $("[name=referralCityName]").val(referralCityName1); $("[name=referralStateName]").val(referralStateName1); $("[name=referralZipCode]").val(referralZipCode1);
	    var refDataSuccSavedReff1 = "<c:out value="${refDataSuccSavedReff}"/>"; 
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
		<div class="top_adjustment_10"><a href="#" class="reff_left_link_text_red_color">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="referralPasswordInfo" class="reff_left_link_text_black_color">CHANGE PASSWORD</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REFERRALS</h3></div>
		<div class="top_adjustment_10"><a href="myReferralCodeInfo" class="reff_left_link_text_black_color">MY REFERRAL CODE</a></div>
		<div class="top_adjustment_10"><a href="activeReferralsInfo" class="reff_left_link_text_black_color">ACTIVE REFERRALS</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REWARDS</h3></div>
		<div class="top_adjustment_10"><a href="nookAndCoveStoreCredit" class="reff_left_link_text_black_color">N+C STORE CREDIT</a></div>
		<div class="top_adjustment_10"><a href="visaGiftCards" class="reff_left_link_text_black_color">VISA GIFT CARDS</a></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
		<div class="col-md-9 col-sm-9 reff_right_side_bar_dspl">
	    <div class="service-item"> <div class="service-description"> <div align="left" class="reff_right_frame_adj_disp">	
		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="reff_top_left_main_hd_cl"><h2>Shipping Info</h2></div> </div> </div> </div> </div> </div>
		<form action="referralShippingInfoUpdate" method="post">
	    <table class="table_big_width_dsp" style="margin-top: 2px;"> <tbody>
	    <tr> <td class="reff_txt_field_disp">STREET ADDRESS*:</td> </tr>
	    <tr> <td><input type="text" name="referralStreetAddress" id="referralStreetAddressId" class="reff_input_box_disp"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">ADDRESS LINE 2:</td> </tr>
	    <tr> <td><input type="text" name="referralStreetLine" id="referralStreetLineId" class="reff_input_box_disp"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">CITY*:</td> </tr>
	    <tr> <td><input type="text" name="referralCityName" id="referralCityNameId" class="reff_input_box_disp"></td> </tr>	            				
	    </tbody></table>
	    <table class="table_width_dsp"> <tbody>	            				
	    <tr> <td class="reff_txt_field_disp">STATE*:</td> <td class="reff_txt_field_disp text_frame_adj_cl">ZIPCODE*:</td> </tr>
	    <tr> <td><select name="referralStateName" id="referralStateNameId" class="reff_input_small_box_disp"> <option value="">------State Name------</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select></td>
	    <td class="text_frame_adj_cl"><input type="text" name="referralZipCode" maxLength="5" id="referralZipCodeId" class="reff_input_small_box_disp" onkeypress="return numeralsOnly(event);"></td> </tr>
	    </tbody></table>
	    <div class="top_adjustment_50"> <h4><button class="ref_htrpw_signup_sub_buttn" id="referralShippingInfoUpdateId">SAVE</button></h4> </div>
	    </form> </div> </div> </div> </div> </div>		
		</div> </div>		     
		</body>
</html>