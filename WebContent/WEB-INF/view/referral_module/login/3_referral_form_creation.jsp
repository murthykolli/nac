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
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    <script type="text/javascript" src="resources/js/login_reg_validation.js"></script>
	<link rel="stylesheet" href="resources/css/referral_login/referral_login.css">
	<script type="text/javascript" src="resources/js/referral_login/referral_signup_validation.js"></script>
		
	<script type="text/javascript">
 	$(document).ready(function() { 		
		var referralFirstName1 = '<c:out value="${referralFirstName}"/>'; var referralLastName1 = '<c:out value="${referralLastName}"/>'; var referralBusinessName1 = '<c:out value="${referralBusinessName}"/>'; var referralWebsite1 = '<c:out value="${referralWebsite}"/>'; var referralSocialMediaInfo1 = '<c:out value="${referralSocialMediaInfo}"/>'; var referralPhoneNumber1 = '<c:out value="${referralPhoneNumber}"/>'; var referralUserEmail1 = '<c:out value="${referralUserEmail}"/>'; var vendorCategory1 = '<c:out value="${vendorCategory}"/>'; var otherCategory1 = '<c:out value="${otherCategory}"/>';
 	  	var referralSocialMedia1 = '<c:out value="${referralSocialMedia}"/>'; var referralStreetAddress1 = '<c:out value="${referralStreetAddress}"/>'; var referralStreetLine1 = '<c:out value="${referralStreetLine}"/>'; var referralCityName1 = '<c:out value="${referralCityName}"/>'; var referralStateName1 = '<c:out value="${referralStateName}"/>'; var referralZipCode1 = '<c:out value="${referralZipCode}"/>'; 	  	
 	  	if(vendorCategory1 == "Other") { $("#otherCategoryDspId").show(); $("[name=otherCategory]").val(otherCategory1); } else { $("#otherCategoryDspId").hide(); } 	    
 	    $("[name=referralFirstName]").val(referralFirstName1); $("[name=referralLastName]").val(referralLastName1); $("[name=referralBusinessName]").val(referralBusinessName1); $("[name=referralWebsite]").val(referralWebsite1); $("[name=referralSocialMediaInfo]").val(referralSocialMediaInfo1); $("[name=referralPhoneNumber]").val(referralPhoneNumber1); $("[name=referralUserEmail]").val(referralUserEmail1); $("[name=vendorCategory]").val(vendorCategory1); 	   	
 	   	$("[name=referralSocialMedia]").val(referralSocialMedia1); $("[name=referralStreetAddress]").val(referralStreetAddress1); $("[name=referralStreetLine]").val(referralStreetLine1); $("[name=referralCityName]").val(referralCityName1); $("[name=referralStateName]").val(referralStateName1); $("[name=referralZipCode]").val(referralZipCode1);	    
 	});
 	</script> 	
</head>
	<body>
	<div id="mainframe" class="section-content"> <div class="container">
		<div class="row top_adjustment_0"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
	    <div> <h2> <font class="referral_login_hd_text_dis">Registry &nbsp;</font> <font class="referral_login_hdsub_text_dsp"><font class="ref_login_hdsub_fl_text_dsp">R</font>EFERRAL <font class="ref_login_hdsub_fl_text_dsp">P</font>ROGRAM <font class="ref_login_hdsub_fl_text_dsp">A</font>PPLICATION</font> </h2> </div> </div> </div> </div> </div>
		<form action="referralFormInfoSaving" method="post">
		<div class="row top_adjustment_30"> <div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description"> <div>	            		
	    <table class="table_width_dsp"> <tbody>
	    <tr> <td class="reff_txt_field_disp">FIRST NAME*:</td> <td class="reff_txt_field_disp text_frame_adj_cl">LAST NAME*:</td> </tr>
	    <tr> <td><input type="text" name="referralFirstName" id="referralFirstNameId" class="reff_input_small_box_disp" onkeyup = "checkFirstChar(event.keyCode, this);" onkeydown = "return checkFirstChar(event.keyCode, this);"></td> <td class="text_frame_adj_cl"><input id="referralLastNameId" class="reff_input_small_box_disp" type="text" name="referralLastName" onkeyup = "checkFirstChar(event.keyCode, this);" onkeydown = "return checkFirstChar(event.keyCode, this);"></td> </tr> </tbody></table>
	    <table class="table_big_width_dsp"> <tbody>
	    <tr> <td class="reff_txt_field_disp">BUSINESS NAME*:</td> </tr> <tr> <td><input type="text" name="referralBusinessName" id="referralBusinessNameId" class="reff_input_box_disp"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">WEBSITE:</td> </tr> <tr> <td><input type="text" name="referralWebsite" id="referralWebsiteId" class="reff_input_box_disp"></td> </tr>	            				
	    <tr> <td class="reff_txt_field_disp">VENDOR CATEGORY*:</td> </tr> <tr> <td><select name="vendorCategory" id="vendorCategoryId" class="reff_input_box_disp"> <option value=''> ---------------- Please Select Vendor Category --------------- </option>	<option value='Florist'>Florist</option> <option value='Venue'>Venue</option> <option value='Wedding Planner'>Wedding Planner</option> <option value='Photographer'>Photographer</option> <option value='Videographer'>Videographer</option> <option value='Wedding Cakes'>Wedding Cakes</option> <option value='Hair Makeup'>Hair &amp; Makeup</option> <option value='Wedding Dress'>Wedding Dress</option> <option value='Wedding Decor'>Wedding Decor</option> <option value='Other' >Other</option></select></td> </tr>	            				
	    <tr style="display: none; position: relative; top: 15px;" id="otherCategoryDspId"> <td style="padding-bottom: 15px;"><input type="text" name="otherCategory" id="otherCategoryId" placeholder="Other Category" maxLength="60" class="reff_input_box_disp" onkeyup = "checkFirstChar(event.keyCode, this);" onkeydown = "return checkFirstChar(event.keyCode, this);"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">FACEBOOK PAGE OR INSTAGRAM HANDLE:</td> </tr> <tr> <td><input type="text" name="referralSocialMediaInfo" id="referralSocialMediaInfoId" class="reff_input_box_disp"></td> </tr> </tbody></table>	            			
	    <c:if test="${not empty refErrorPage}"> <table class="table_width_dsp"> <tr style="position: relative; top: 20px;"><td></td> <td><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 0.9em/1.25em sans-serif; "> &nbsp;&nbsp;&nbsp;&nbsp; ${refErrorPage}</font></td></tr> <tr><td style="height: 15px;"></td></tr> </table> </c:if>
	    <table class="table_width_dsp"> <tbody>	            				
	    <tr> <td class="reff_txt_field_disp">EMAIL*:</td> <td class="reff_txt_field_disp text_frame_adj_cl">PHONE NUMBER*:</td> </tr>
	    <tr> <td><input type="text" name="referralUserEmail" id="referralUserEmailId" class="reff_input_small_box_disp" onkeyup = "checkFirstChar(event.keyCode, this);" onkeydown = "return checkFirstChar(event.keyCode, this);"></td> <td class="text_frame_adj_cl"> <input type="text" name="referralPhoneNumber" id="referralPhoneNumberId" maxLength="12" class="reff_input_small_box_disp" onchange="return phoneFormat (event,referralPhoneNumberId);" onkeydown="return numeralsOnly(event);" onkeyup="return phoneFormat (event,referralPhoneNumberId)" onkeypress="return numeralsOnly(event);"> </td> </tr> </tbody></table>
	    <table class="table_big_width_dsp"> <tbody>
	    <tr> <td class="reff_txt_field_disp">HOW DID YOU HEAR ABOUT THE REFERRAL PROGRAM?:</td> </tr>
	    <tr> <td><select name="referralSocialMedia" id="referralSocialMediaId" class="reff_input_box_disp"> <option value=''> -------------------- Please Select One---- --------------- </option>	<option value='Instagram'>Instagram</option> <option value='Facebook'>Facebook</option> <option value='Pinterest'>Pinterest</option> <option value='Twitter'>Twitter</option> <option value='Blog'>Blog</option> <option value='Email'>Email</option> <option value='Google Search'>Google Search</option></select></td> </tr> </tbody></table>
	    <div class="top_adjustment_40"> <h4><button class="ref_htrpw_signup_sub_buttn" id="referralSignUpDataId">SUBMIT</button></h4> </div> </div> </div> </div> </div>	        
	    
	    <div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description"> <div style="margin-top: 35px;">
	    <div class="referral_add_text_dsp">Please provide us with your mailing address so that we can ship out your welcome package as soon as you are approved. Thank you!</div>            			
	    <table class="table_big_width_dsp" style="margin-top: 2px;"> <tbody>
	    <tr> <td class="reff_txt_field_disp">STREET ADDRESS*:</td> </tr>
	    <tr> <td><input type="text" name="referralStreetAddress" id="referralStreetAddressId" class="reff_input_box_disp"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">ADDRESS LINE 2:</td> </tr>
	    <tr> <td><input type="text" name="referralStreetLine" id="referralStreetLineId" class="reff_input_box_disp"></td> </tr>
	    <tr> <td class="reff_txt_field_disp">CITY*:</td> </tr>
	    <tr> <td><input type="text" name="referralCityName" id="referralCityNameId" class="reff_input_box_disp"></td> </tr> </tbody></table>
	    <table class="table_width_dsp"> <tbody>	            				
	    <tr> <td class="reff_txt_field_disp">STATE*:</td> <td class="reff_txt_field_disp text_frame_adj_cl">ZIPCODE*:</td> </tr>
	    <tr> <td><select name="referralStateName" id="referralStateNameId" class="reff_input_small_box_disp"> <option value="">------State Name------</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select></td>
	    <td class="text_frame_adj_cl"><input type="text" name="referralZipCode" maxLength="5" id="referralZipCodeId" class="reff_input_small_box_disp" onkeypress="return numeralsOnly(event);"></td> </tr> </tbody></table> </div> </div> </div> </div> </div>		
	    </form> <div class="top_adjustment_10"></div>        
    </div> </div>
</body>
</html>