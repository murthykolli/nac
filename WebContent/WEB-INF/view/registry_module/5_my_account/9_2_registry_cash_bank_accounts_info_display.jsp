<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
	<script type="text/javascript" src="resources/js/registry_cash_fund_add_bank_validation.js" ></script>	
	<style type="text/css">
	.reg_cf_add_bc_small_test_cl { font: 500 0.90em/1.15em Georgia; letter-spacing: 1px; color: black; }
	.reg_cf_add_bc_mid_test_cl { font: 500 1em/1.15em Georgia; letter-spacing: 1px; color: black; }
	.cf_input_same_boxes_text_dsp { font: 500 0.90em/1.15em Georgia; letter-spacing: 1px; color: black; }
	.cf_input_same_boxes_dsp { border: 1px solid #494949; width: 100%; height: 36px; margin-top: 7px; letter-spacing: 2px; color: black; font: 1.15em/1.25em Georgia; max-width: 100%; box-shadow: 1px 1px 2px #bcbcbc; padding-left: 15px; }
	.cf_input_sel_boxes_dsp { background: white; border: 1px solid #494949; width: 100%; max-width: 100%; height: 36px; font: 1.15em/1.25em Georgia; letter-spacing: 2px; color: black; box-shadow: 1px 1px 2px #bcbcbc; padding-left: 15px; }	
	.reg_add_bank_acc_saving_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; padding: 10px 40px; outline: none; border: none; font: 500 1.4em/1.15em Georgia; letter-spacing: 3px;  box-shadow: 2px 3px #888888; }
	.reg_add_bank_acc_saving_subt_Btn:hover { background-color: #2c2c2c; }
	</style>	
	<script type="text/javascript">
 	$(document).ready(function() {
 		var cashFundRoutingNumber1 = "<c:out value="${cashFundRoutingNumber}"/>"; var cashFundAccountNumber1 = "<c:out value="${cashFundAccountNumber}"/>"; var cashFundFirstName1 = "<c:out value="${cashFundFirstName}"/>"; var cashFundLastName1 = "<c:out value="${cashFundLastName}"/>"; var cashFundStreetAddress1 = "<c:out value="${cashFundStreetAddress}"/>"; var cashFundAptOrUnit1 = "<c:out value="${cashFundAptOrUnit}"/>"; var cashFundCity1 = "<c:out value="${cashFundCity}"/>"; var cashFundState1 = "<c:out value="${cashFundState}"/>"; var cashFundZipCode1 = "<c:out value="${cashFundZipCode}"/>"; var cashFundPhoneNumber1 = "<c:out value="${cashFundPhoneNumber}"/>"; 		
 		$("[name=cashFundRoutingNumber]").val(cashFundRoutingNumber1); $("[name=cashFundAccountNumber]").val(cashFundAccountNumber1); $("[name=cashFundFirstName]").val(cashFundFirstName1); $("[name=cashFundLastName]").val(cashFundLastName1); $("[name=cashFundStreetAddress]").val(cashFundStreetAddress1); $("[name=cashFundAptOrUnit]").val(cashFundAptOrUnit1); $("[name=cashFundCity]").val(cashFundCity1); $("[name=cashFundState]").val(cashFundState1); $("[name=cashFundZipCode]").val(cashFundZipCode1); $("[name=cashFundPhoneNumber]").val(cashFundPhoneNumber1);
	});
    </script>
	</head>	
		<body>				
		<div id="mainframe" class="section-content"> <div class="container">      
      	<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="registry_prof_my_acc_title"><h2>MY ACCOUNT</h2></div> </div> </div> </div> </div> </div>
<!-- Left Code Start -->
      	<div class="row top_adjustment_30"> <div class="col-md-3 col-sm-3 regi_prof_left_side_box_dspl"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>ACCOUNT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryMyAccount" class="regi_prof_left_link_text_dspl">CONTACT INFO</a></div>
		<div class="top_adjustment_10"><a href="registryPasswordChange" class="regi_prof_left_link_text_dspl">CHANGE PASSWORD</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>EVENT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryEventInfoChange" class="regi_prof_left_link_text_dspl">EVENT INFO</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>REGISTRY SETTINGS</h3></div>
		<div class="top_adjustment_10"><a href="registryURLInfoChange" class="regi_prof_left_link_text_dspl">URL</a></div>
		<div class="top_adjustment_10"><a href="registryPrivacyInfoChange" class="regi_prof_left_link_text_dspl">PRIVACY</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>GIFT TRACKER</h3></div>
		<div class="top_adjustment_10"><a href="regiShippingInfoDsp" class="regi_prof_left_link_text_dspl">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="regiMyOrderDsp" class="regi_prof_left_link_text_dspl">MY ORDERS</a></div>
		<div class="top_adjustment_10"><a href="regiGiftsReceivedDsp" class="regi_prof_left_link_text_dspl">GIFTS RECEIVED</a></div>
		<div class="top_adjustment_10"><a href="regiRoomFundsDsp" class="regi_prof_left_link_text_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_hover_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
<!-- Visible My Order display -->
		<div class="col-md-9 col-sm-9"style="border-left: 1px solid red; margin-left: -1px; padding-bottom: 40px;">
		<div class="row" style="width: 780px; margin-left: 50px; margin-top: 17px;"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description">
		<div align="left"><img src="resources/images/cash_fund_images/back_accounts_top_img.png"></div> </div> </div> </div>
		<div class="row" style="margin-top: 60px; margin-left: 5px;"> <div class="col-md-12 col-sm-12">
		<div class="reg_cf_add_bc_small_test_cl">Bank of America customers, please make sure you are using the routing number for electronic payments.</div> </div> </div>
		<form action="cashFundBankAccountInfoSaving" method="post">
		<div class="row" style="margin-top: 30px; margin-left: 5px;">
		<div class="col-md-6 col-sm-6"> <div class="cf_input_same_boxes_text_dsp" id="cashFundRoutingNumberLabel">ROUTING NUMBER (9 DIGITS)*:</div>
		<div><input type="text" name="cashFundRoutingNumber" maxLength="9" id="cashFundRoutingNumberId" class="cf_input_same_boxes_dsp" onkeypress="return numeralsOnly(event);" ></div> </div>
		<div class="col-md-6 col-sm-6">
		<div class="cf_input_same_boxes_text_dsp" id="cashFundAccountNumberLabel">ACCOUNT NUMBER (3-17 DIGITS)*:</div>
		<div><input type="text" name="cashFundAccountNumber" maxLength="13" id="cashFundAccountNumberId" class="cf_input_same_boxes_dsp" onkeypress="return numeralsOnly(event);"></div> </div> </div>
		<div class="row" style="margin-top: 60px; margin-left: 5px;">
		<div class="col-md-12 col-sm-12">
		<div class="reg_cf_add_bc_mid_test_cl">The personal identity information entered below must match that of the bank account's owner. If you have a joint bank account, please only enter one person's name.</div> </div> </div>
		<div class="row" style="margin-top: 30px; margin-left: 5px;">
		<div class="col-md-6 col-sm-6">
		<div class="cf_input_same_boxes_text_dsp" id="cashFundFirstNameLabel">FIRST NAME*:</div>
		<div><input type="text" name="cashFundFirstName" id="cashFundFirstNameId" class="cf_input_same_boxes_dsp"></div> </div>
		<div class="col-md-6 col-sm-6">
		<div class="cf_input_same_boxes_text_dsp" id="cashFundLastNameLabel">LAST NAME*:</div>
		<div><input type="text" name="cashFundLastName" id="cashFundLastNameId" class="cf_input_same_boxes_dsp"></div> </div> </div>
		<div class="row" style="margin-top: 30px; margin-left: 5px;">
		<div class="col-md-10 col-sm-10">
		<div class="cf_input_same_boxes_text_dsp" id="cashFundStreetAddressLabel">STREET ADDRESS*:</div>
		<div><input type="text" name="cashFundStreetAddress" id="cashFundStreetAddressId" class="cf_input_same_boxes_dsp"></div> </div>
		<div class="col-md-2 col-sm-2">
		<div class="cf_input_same_boxes_text_dsp">APT/UNIT:</div>
		<div><input type="text" name="cashFundAptOrUnit" id="cashFundAptOrUnitId" class="cf_input_same_boxes_dsp"></div> </div> </div>
		<div class="row" style="margin-top: 30px; margin-left: 5px;">
		<div class="col-md-5 col-sm-5">
		<div class="cf_input_same_boxes_text_dsp" id="cashFundCityLabel">CITY*</div>
		<div><input type="text" name="cashFundCity" id="cashFundCityId" class="cf_input_same_boxes_dsp"></div> </div>
		<div class="col-md-5 col-sm-5">
		<div class="cf_input_same_boxes_text_dsp" id="cashFundStateLabel">STATE*:</div>
		<div><select name="cashFundState" id="cashFundStateId" class="cf_input_sel_boxes_dsp"> <option value="">------State Name------</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select></div> </div>
		<div class="col-md-2 col-sm-2">
		<div class="cf_input_same_boxes_text_dsp" id="cashFundZipCodeLabel">ZIP CODE*:</div>
		<div><input type="text" name="cashFundZipCode" maxLength="5" id="cashFundZipCodeId" class="cf_input_same_boxes_dsp" onkeypress="return numeralsOnly(event);"></div> </div> </div>
		<div class="row" style="margin-top: 30px; margin-left: 5px;">
		<div class="col-md-6 col-sm-6">
		<div class="cf_input_same_boxes_text_dsp" id="cashFundPhoneNumberLabel">PHONE NUMBER*:</div>
		<div><input type="text" name="cashFundPhoneNumber" maxLength="12" id="cashFundPhoneNumberId" class="cf_input_same_boxes_dsp" onchange="return phoneFormat (event,cashFundPhoneNumberId);" onkeydown="return numeralsOnly(event);" onkeyup="return phoneFormat (event,cashFundPhoneNumberId)" onkeypress="return numeralsOnly(event);"></div> </div>
		<div class="col-md-6 col-sm-6"> </div> </div>
		<div class="row" style="margin-top: 50px; margin-left: 5px;">
		<div class="col-md-12 col-sm-12">
		<div><button class="reg_add_bank_acc_saving_subt_Btn" id="cfBankInfoSavingButtId">SAVE</button></div> </div> </div>
		</form>	
		</div> </div> </div> </div> </div>		     
		</body>
</html>