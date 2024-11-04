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
    </script>        
	</head>
		<body>				
		<div id="mainframe" class="section-content"> <div class="container">          
<!-- Left Code Start -->
      	<div class="row top_adjustment_0"> <div class="col-md-3 col-sm-3"> <div class="service-item"><div class="service-description"><div align="left">	        			
		<div class="row">  <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left">  <div class="reff_top_left_main_hd_cl"><h2>MY ACCOUNT</h2></div> </div> </div> </div> </div> </div>          			
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>ACCOUNT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="referralContactInfo" class="reff_left_link_text_black_color">CONTACT &amp; BUSINESS INFO</a></div>
		<div class="top_adjustment_10"><a href="referralShippingInfo" class="reff_left_link_text_black_color">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="referralPasswordInfo" class="reff_left_link_text_black_color">CHANGE PASSWORD</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REFERRALS</h3></div>
		<div class="top_adjustment_10"><a href="myReferralCodeInfo" class="reff_left_link_text_black_color">MY REFERRAL CODE</a></div>
		<div class="top_adjustment_10"><a href="activeReferralsInfo" class="reff_left_link_text_black_color">ACTIVE REFERRALS</a></div>
		<div class="reff_left_sub_hd_text_cl top_adjustment_30"><h3>REWARDS</h3></div>
		<div class="top_adjustment_10"><a href="#" class="reff_left_link_text_red_color">N+C STORE CREDIT</a></div>
		<div class="top_adjustment_10"><a href="visaGiftCards" class="reff_left_link_text_black_color">VISA GIFT CARDS</a></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
		<div class="col-md-9 col-sm-9 reff_right_side_bar_dspl"> <div class="service-item"> <div class="service-description">	        			
		<div align="left" class="reff_right_frame_adj_disp">	
		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"><div class="service-description">
		<div align="left"> <div class="reff_top_left_main_hd_cl"><h2>Nook+Cove Store Credit</h2></div> </div> </div> </div> </div> </div>
		<div class="row top_adjustment_35" style="display: none;" id="activeReferralTextId">
		<div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description">
		<div align="left"> <p class="my_referral_code_text">You do not have any store credit at this time.</p>
		<div style="height: 250px;"></div> </div> </div> </div> </div> </div>
		<div style="display: none;" id="activeReferralDataId">
		<div class="row top_adjustment_35"> <div class="col-md-9 col-sm-9">
		<div class="row"> <div class="col-md-9 col-sm-9"> <div class="service-item service_item_align"> <div class="service-description">
		<div align="center" class="referrals_nc_sc_hd_text_dsp">CLIENT NAME</div> </div> </div> </div>
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div align="center" class="referrals_nc_sc_hd_text_dsp">REWARDS</div> </div> </div> </div> </div>
		<div class="referrals_act_div_hor_bar" style="margin-top: 0px;"></div>	
		<div class="col-md-3 col-sm-3"></div> </div> </div>
		<div class="row"> <div class="col-md-9 col-sm-9">
		<% 	String referralNookAndCoveStoreCreditInfo = (String)session.getAttribute("referralNookAndCoveStoreCreditInfoInSn");	 		
			if (null != referralNookAndCoveStoreCreditInfo) { String[] referralNookAndCoveStoreCreditInfoSt = referralNookAndCoveStoreCreditInfo.split("__");
			for (int i = 0; i < referralNookAndCoveStoreCreditInfoSt.length; i++) {						
			String[] referralNookAndCoveStoreCreditDataList = referralNookAndCoveStoreCreditInfoSt[i].split(",_,"); String clientFullName = referralNookAndCoveStoreCreditDataList[0]; String rewardPrice = referralNookAndCoveStoreCreditDataList[1];					
		%>
		<div class="row referrals_act_div_hor_bar">
		<div class="col-md-9 col-sm-9"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 50px;"><div class="referrals_nc_sc_hd_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=clientFullName%></div></div> </div> </div> </div>
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description" align="center">
		<div style="height: 50px;"><div class="referrals_nc_sc_hd_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$<%=rewardPrice%></div></div> </div> </div> </div> </div>
		<% } } %> </div>
		<div class="col-md-3 col-sm-3"></div> </div>							
		<div class="row top_adjustment_35"> <div class="col-md-9 col-sm-9">						    
		<div class="row"> <div class="col-md-9 col-sm-9"> <div class="service-item service_item_align"> <div class="service-description">
		<div align="right" class="referrals_nc_sc_bhd_text_dsp">TOTAL STORE CREDIT:</div> </div> </div> </div>
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div align="center" class="referrals_nc_sc_bhd_text_dsp">$${totalRewardPriceInSt}</div> </div> </div> </div> </div>
		<div class="col-md-3 col-sm-3"></div> </div> </div>
		<div class="row top_adjustment_50"> <div class="col-md-12 col-sm-12"> <div class="service-item service_item_align"> <div class="service-description">
		<div align="left" class="refe_custom_gc_btext_dsp">Custom Gift Card Code: <font style="color: #3762af;">${referralCustomGiftCard}</font></div> </div> </div> </div> </div>
		<div class="row top_adjustment_30"> 
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div align="center" class="referrals_nc_sc_hd_text_dsp">DATE</div> </div> </div> </div>
		<div class="col-md-6 col-sm-6"> <div class="service-item service_item_align"> <div class="service-description">
		<div align="center" class="referrals_nc_sc_hd_text_dsp">AMOUNT</div> </div> </div> </div>
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div align="center" class="referrals_nc_sc_hd_text_dsp">CREDIT AVAILABLE</div> </div> </div> </div> </div>
		<div class="row referrals_div_hor_bar"> </div>
		<div class="row top_adjustment_0"> 
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 40px;"><div class="referrals_nc_sc_hd_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><div style="border-bottom: 1px solid black; width: 35px;"></div></div></div> </div> </div> </div>
		<div class="col-md-6 col-sm-6"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 40px;"><div class="referrals_nc_sc_hd_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">TOTAL STORE CREDIT</div></div> </div> </div> </div>
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 40px;"><div class="ref_custom_gc_btext_dspl" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$${totalCreditAmount}</div></div> </div> </div> </div> </div>
		<div class="row referrals_div_hor_bar"> </div>
		<% 	String referralShopPaymentInfoValue = (String)session.getAttribute("referralShopPaymentInfoValueInSn");
			if (null != referralShopPaymentInfoValue) { String[] referralShopPaymentInfoSt = referralShopPaymentInfoValue.split("__");
			for (int i = 0; i < referralShopPaymentInfoSt.length; i++) {						
			String[] referralShopPaymentInfoDataList = referralShopPaymentInfoSt[i].split(",_,"); String createDate = referralShopPaymentInfoDataList[0]; String ravailableAmount = referralShopPaymentInfoDataList[1];			
		%>
		<div class="row top_adjustment_0">								
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 40px;"><div class="referrals_nc_sc_hd_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=createDate%></div></div> </div> </div> </div>
		<div class="col-md-6 col-sm-6"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 40px;"><div class="referrals_nc_sc_hd_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">REDEEMED AMOUNT</div></div> </div> </div> </div>
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 40px;"><div class="ref_custom_gc_btext_dspl" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%); color: red;">$<%=ravailableAmount%></div></div> </div> </div> </div> </div>
		<div class="row referrals_div_hor_bar"> </div>							
		<% } } %>
		<div class="row top_adjustment_0"> 
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 66px;"><div class="referrals_nc_sc_hd_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"></div></div> </div> </div> </div>
		<div class="col-md-6 col-sm-6"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 66px;"><div class="ref_custom_gc_btext_dspl" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">REMAINING AMOUNT</div></div> </div> </div> </div>
		<div class="col-md-3 col-sm-3"> <div class="service-item service_item_align"> <div class="service-description">
		<div style="height: 66px;"><div class="ref_custom_gc_amt_btext_dspl" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$${remainingCreditAmount}</div></div> </div> </div> </div> </div>
		<div class="row referrals_div_hor_bar"> </div>
		</div> </div> </div> </div> </div> </div>
		</div> </div>		     
		</body>
</html>