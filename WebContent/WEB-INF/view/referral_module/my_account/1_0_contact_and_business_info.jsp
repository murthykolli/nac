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
		var referralFirstName1 = '<c:out value="${referralFirstName}"/>'; var referralLastName1 = '<c:out value="${referralLastName}"/>'; var referralBusinessName1 = '<c:out value="${referralBusinessName}"/>'; var referralWebsite1 = '<c:out value="${referralWebsite}"/>'; var referralSocialMediaInfo1 = '<c:out value="${referralSocialMediaInfo}"/>'; var referralPhoneNumber1 = '<c:out value="${referralPhoneNumber}"/>'; var referralUserEmail1 = '<c:out value="${referralUserEmail}"/>'; var vendorCategory1 = '<c:out value="${vendorCategory}"/>'; var referralSocialMedia1 = '<c:out value="${referralSocialMedia}"/>'; var otherCategory1 = '<c:out value="${otherCategory}"/>';
 	  	if(vendorCategory1 == "Other") { $("#otherCategoryDspId").show(); $("[name=otherCategory]").val(otherCategory1); } else { $("#otherCategoryDspId").hide(); } 	    
 	    $("[name=referralFirstName]").val(referralFirstName1); $("[name=referralLastName]").val(referralLastName1); $("[name=referralBusinessName]").val(referralBusinessName1); $("[name=referralWebsite]").val(referralWebsite1); $("[name=referralSocialMediaInfo]").val(referralSocialMediaInfo1); $("[name=referralPhoneNumber]").val(referralPhoneNumber1); $("[name=referralUserEmail]").val(referralUserEmail1); $("[name=vendorCategory]").val(vendorCategory1); $("[name=referralSocialMedia]").val(referralSocialMedia1);
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
		<div class="top_adjustment_10"><a href="#" class="reff_left_link_text_red_color">CONTACT &amp; BUSINESS INFO</a></div>
		<div class="top_adjustment_10"><a href="referralShippingInfo" class="reff_left_link_text_black_color">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="referralPasswordInfo" class="reff_left_link_text_black_color">CHANGE PASSWORD</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REFERRALS</h3></div>
		<div class="top_adjustment_10"><a href="myReferralCodeInfo" class="reff_left_link_text_black_color">MY REFERRAL CODE</a></div>
		<div class="top_adjustment_10"><a href="activeReferralsInfo" class="reff_left_link_text_black_color">ACTIVE REFERRALS</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REWARDS</h3></div>
		<div class="top_adjustment_10"><a href="nookAndCoveStoreCredit" class="reff_left_link_text_black_color">N+C STORE CREDIT</a></div>
		<div class="top_adjustment_10"><a href="visaGiftCards" class="reff_left_link_text_black_color">VISA GIFT CARDS</a></div> </div> </div> </div> </div>	        
<!-- Left Code End -->	        
	    <div class="col-md-9 col-sm-9 reff_right_side_bar_dspl"> <div class="service-item"> <div class="service-description"> <div align="left" class="reff_right_frame_adj_disp">	
		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="reff_top_left_main_hd_cl"><h2>Contact &amp; Business Info</h2></div> </div> </div> </div> </div> </div>
		<form action="referralContactInfoUpdate" method="post">
	    <table class="table_width_dsp top_adjustment_15"> <tbody>
	    <tr> <td class="reff_txt_field_disp">FIRST NAME*:</td> <td class="reff_txt_field_disp text_frame_adj_cl">LAST NAME*:</td> </tr>
	    <tr> <td><input type="text" name="referralFirstName" id="referralFirstNameId" class="reff_input_box_disp" onkeyup = "checkFirstChar(event.keyCode, this);" onkeydown = "return checkFirstChar(event.keyCode, this);"></td> <td class="text_frame_adj_cl"><input id="referralLastNameId" class="reff_input_box_disp" type="text" name="referralLastName" onkeyup = "checkFirstChar(event.keyCode, this);" onkeydown = "return checkFirstChar(event.keyCode, this);"></td> </tr>
	    </tbody></table>
	    <table class="table_big_width_dsp"> <tbody>
	    <tr> <td class="reff_txt_field_disp">BUSINESS NAME*:</td> </tr>
	    <tr> <td><input type="text" name="referralBusinessName" id="referralBusinessNameId" class="reff_input_box_disp"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">WEBSITE:</td> </tr>
	    <tr> <td><input type="text" name="referralWebsite" id="referralWebsiteId" class="reff_input_box_disp"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">VENDOR CATEGORY*:</td> </tr>
	    <tr> <td><select name="vendorCategory" id="vendorCategoryId" class="reff_input_box_disp"> <option value=''> ---------------- Please Select Vendor Category --------------- </option>	<option value='Florist'>Florist</option> <option value='Venue'>Venue</option> <option value='Wedding Planner'>Wedding Planner</option> <option value='Photographer'>Photographer</option> <option value='Videographer'>Videographer</option> <option value='Wedding Cakes'>Wedding Cakes</option> <option value='Hair Makeup'>Hair &amp; Makeup</option> <option value='Wedding Dress'>Wedding Dress</option> <option value='Wedding Decor'>Wedding Decor</option> <option value='Other' >Other</option></select></td> </tr>
	    <tr style="display: none; position: relative; top: 15px;" id="otherCategoryDspId"> <td style="padding-bottom: 15px;"><input type="text" name="otherCategory" id="otherCategoryId" placeholder="Other Category" maxLength="60" class="reff_input_box_disp" onkeyup = "checkFirstChar(event.keyCode, this);" onkeydown = "return checkFirstChar(event.keyCode, this);"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">FACEBOOK PAGE OR INSTAGRAM HANDLE:</td> </tr>
	    <tr> <td><input type="text" name="referralSocialMediaInfo" id="referralSocialMediaInfoId" class="reff_input_box_disp"></td> </tr>
	    </tbody></table>
	    <c:if test="${not empty refErrorPage}"> <table class="table_width_dsp"> <tr style="position: relative; top: 20px;"><td></td> <td><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 0.9em/1.25em sans-serif; "> &nbsp;&nbsp;&nbsp;&nbsp; ${refErrorPage}</font></td></tr> <tr><td style="height: 15px;"></td></tr> </table> </c:if>
	    <table class="table_width_dsp"> <tbody>	            				
	    <tr> <td class="reff_txt_field_disp">EMAIL*:</td> <td class="reff_txt_field_disp text_frame_adj_cl">PHONE NUMBER*:</td> </tr>
	    <tr> <td><input type="text" name="referralUserEmail" id="referralUserEmailId" class="reff_input_box_disp" onkeyup = "checkFirstChar(event.keyCode, this);" onkeydown = "return checkFirstChar(event.keyCode, this);"></td> <td class="text_frame_adj_cl"> <input type="text" name="referralPhoneNumber" id="referralPhoneNumberId" maxLength="12" class="reff_input_box_disp" onchange="return phoneFormat (event,referralPhoneNumberId);" onkeydown="return numeralsOnly(event);" onkeyup="return phoneFormat (event,referralPhoneNumberId)" onkeypress="return numeralsOnly(event);"> </td> </tr>
	    </tbody></table>
	    <table class="table_big_width_dsp"> <tbody>
	    <tr> <td class="reff_txt_field_disp">HOW DID YOU HEAR ABOUT THE REFERRAL PROGRAM?:</td> </tr>
	    <tr> <td><select name="referralSocialMedia" id="referralSocialMediaId" class="reff_input_box_disp"> <option value=''> -------------------- Please Select One---- --------------- </option>	<option value='Instagram'>Instagram</option> <option value='Facebook'>Facebook</option> <option value='Pinterest'>Pinterest</option> <option value='Twitter'>Twitter</option> <option value='Blog'>Blog</option> <option value='Email'>Email</option> <option value='Google Search'>Google Search</option></select></td> </tr>	            					            				
	    </tbody></table>
	    <div class="top_adjustment_50"> <h4><button class="ref_htrpw_signup_sub_buttn" id="referralContactInfoUpdateId">SAVE</button></h4> </div>
	    </form> </div> </div> </div> </div> </div> </div> </div>		     
		</body>
</html>