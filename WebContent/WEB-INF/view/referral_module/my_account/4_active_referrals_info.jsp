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
 	$(document).ready(function() { var referralDataReff1 = "<c:out value="${referralDataReff}"/>"; 		
	    if(referralDataReff1 == "Referral Orders"){ $("#activeReferralTextId").show(); $("#activeReferralDataId").hide(); } else { $("#activeReferralTextId").hide(); $("#activeReferralDataId").show(); }
 	}); 	 	 	
 	window.addEventListener( "pageshow", function ( event ) { var historyPage = event.persisted || (typeof window.performance != "undefined" && window.performance.navigation.type === 2); if ( historyPage ) { window.location.reload(); }
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
		<div class="top_adjustment_10"><a href="myReferralCodeInfo" class="reff_left_link_text_black_color">MY REFERRAL CODE</a></div>
		<div class="top_adjustment_10"><a href="#" class="reff_left_link_text_red_color">ACTIVE REFERRALS</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REWARDS</h3></div>
		<div class="top_adjustment_10"><a href="nookAndCoveStoreCredit" class="reff_left_link_text_black_color">N+C STORE CREDIT</a></div>
		<div class="top_adjustment_10"><a href="visaGiftCards" class="reff_left_link_text_black_color">VISA GIFT CARDS</a></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
		<div class="col-md-9 col-sm-9 reff_right_side_bar_dspl">
	    <div class="service-item"> <div class="service-description"> <div align="left" class="reff_right_frame_adj_disp">	
		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="reff_top_left_main_hd_cl"><h2>Active Referrals</h2></div> </div> </div> </div> </div> </div>
		<div class="row top_adjustment_35" style="display: none;" id="activeReferralTextId">
		<div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description">
		<div align="left"><div><p class="my_referral_code_text">You do not have any active referrals currently.</p></div>
		<div style="height: 250px;"></div> </div> </div></div></div> </div>
		<div style="display: none;" id="activeReferralDataId"> <div class="row top_adjustment_35"> <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div align="center" class="referrals_user_hd_text_dsp"><br>CLIENT NAME</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="referrals_user_hd_text_dsp"><br>DATE</div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description">
		<div align="center" class="referrals_user_hd_text_dsp">$3500 GIFTS RECEIVED</div> </div> </div> </div> 
		<div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description">
		<div align="center" class="referrals_user_hd_text_dsp">PLEASE SELECT<br>YOUR REWARDS</div> </div> </div> </div> </div>
		<div class="referrals_act_div_hor_bar"></div>
		<% 	String activeReferralUserInfoData = (String)session.getAttribute("activeReferralUserInfoDataInSn");	 		
			if (null != activeReferralUserInfoData) { String[] activeReferralUserInfoDataSt = activeReferralUserInfoData.split("__");
			for (int i = 0; i < activeReferralUserInfoDataSt.length; i++) {						
				String[] activeReferralUserDataList = activeReferralUserInfoDataSt[i].split(",_,"); String registrantsUserId = activeReferralUserDataList[0]; String clientFullName = activeReferralUserDataList[1]; String createdDate = activeReferralUserDataList[2]; String referralPriceStatus = activeReferralUserDataList[3];										
		%>
		<div class="row referrals_act_div_hor_bar" > <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
		<div style="height: 90px;"><div class="ref_reward_sel_sml_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=clientFullName%></div></div> </div> </div> </div> 
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"><div class="ref_reward_sel_sml_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=createdDate%></div></div> </div> </div> </div> 
		<% if(("READY TO BYE").equals(referralPriceStatus)) { %>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"><div class="ref_reward_sel_sml_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img alt="" src="resources/images/referral/referral_tick_mark_img.png"></div></div> </div> </div> </div> 
		<div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"> <div class="ref_reward_sel_sml_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">
		<div><form action="rewardsNookAndCoveCredit"><h4><button class="ref_act_gift_cards_sub_buttn" id="nookAndCoveCreditId" onclick="return confirm('Please confirm that you have selected Nook+Cove $100 Credit for your rewards.');">Nook+Cove $100 Credit</button></h4> <input type="hidden" name="registrantUserId" value="<%=registrantsUserId%>"> <input type="hidden" name="registrantFullName" value="<%=clientFullName%>"> </form></div>
		<div class=" top_adjustment_15"><form action="rewardsVisaGiftCards"><h4><button class="ref_act_gift_cards_sub_buttn" id="vizaGiftCardId" onclick="return confirm('Please confirm that you have selected a Visa $100 Gift Card for your rewards.');">Visa $100 Gift Card</button></h4> <input type="hidden" name="registrantUserId" value="<%=registrantsUserId%>"> <input type="hidden" name="registrantFullName" value="<%=clientFullName%>"> </form> </div> </div> </div> </div> </div> </div> 
		<% } else if(("NOT YET").equals(referralPriceStatus)) { %>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"><div class="ref_reward_sel_sml_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=referralPriceStatus%></div></div> </div> </div> </div> 
		<div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"> <div class="ref_reward_sel_sml_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">
		<div><h4><button class="ref_disa_gift_cards_sub_buttn" id="nookAndCoveCreditId">Nook+Cove $100 Credit</button></h4></div>
		<div class=" top_adjustment_15"><h4><button class="ref_disa_gift_cards_sub_buttn" id="visaGiftCardId">Visa $100 Gift Card</button></h4></div> </div> </div> </div> </div> </div> 							
		<% } else { if(("Nook and Cove Credit").equals(referralPriceStatus)) { %>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"><div class="ref_reward_sel_sml_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">REFERRAL CLOSED</div></div> </div> </div> </div> 
		<div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"><div class="ref_reward_sel_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">Nook + Cove $100<br>Credit Selected</div></div> </div> </div> </div> 
		<% } else { %>
		<div class="col-md-2 col-sm-2"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"><div class="ref_reward_sel_sml_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">REFERRAL CLOSED</div></div> </div> </div> </div> 
		<div class="col-md-5 col-sm-5"> <div class="service-item"> <div class="service-description" align="center">
		<div style="height: 90px;"><div class="ref_reward_sel_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">Visa $100<br>Gift Cards Selected</div></div> </div> </div> </div> 
		<% } } %>						
		</div> 
		<% } } %>
		</div> </div> </div> </div> </div> </div>		
		</div> </div>		     
		</body>
</html>