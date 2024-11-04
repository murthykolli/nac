<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<html>
	<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
	<style type="text/css">
	.cl_add_cart_prod_img_disy_div_res { width: 130px; min-height: 60px; object-fit: scale-down; position: relative; object-position: 50% 50%; overflow: auto; overflow-y: hidden; }
	.regi_shipping_sml_text_dsp { font: 1em/1.5em Georgia; color: black; letter-spacing: 0px; }
	.reg_ship_lb_text_cl { font: 1.1em/1.5em Georgia; color: black; letter-spacing: 1px; text-align: right; }
	.reg_shipping_input_text_field { background-color: white; border: 1px solid gray; width: 280px; height: 30px; font: 500 0.95em/1.5em Georgia; text-align: left; letter-spacing: 1px; color: black; margin-bottom: 15px; margin-left: 7px; }
	</style>	    
	<script type="text/javascript">
	$(document).ready(function(){
	    var nameRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; var emailRegExp = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/; var zipRegExp = /^\d{5}$/; var numbRegExp = /^[0-9]+$/; var phoneRegExp = /^\(?(\d{3})\)?[-]?(\d{3})[-]?(\d{4})$/; var addrReg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.@/&;,-]*$/;
	    $("#shippingInfoSavingButtId").click(function (){ var result = true;	
	    	if(addrReg.test($("#regShippingAddressId").val())){ $("#regShippingAddressId").css("border-color","black"); } else{ $("#regShippingAddressId").css("border-color","red"); result=false; }	    	
	    	if(addrReg.test($("#regShippingApartmentId").val())){ $("#regShippingApartmentId").css("border-color","black"); } else{ $("#regShippingApartmentId").css("border-color","red"); result=false; }	    	
	    	if(nameRegExp.test($("#regShippingCityId").val())){ $("#regShippingCityId").css("border-color","black"); } else{ $("#regShippingCityId").css("border-color","red"); result=false; }	    	
	    	if(nameRegExp.test($("#regShippingStateId").val())){ $("#regShippingStateId").css("border-color","black"); } else{ $("#regShippingStateId").css("border-color","red"); result=false; }	    	
	    	if(zipRegExp.test($("#regShippingZipCodeId").val())){ $("#regShippingZipCodeId").css("border-color","black"); } else{ $("#regShippingZipCodeId").css("border-color","red"); result=false; }	    	
	    	if(phoneRegExp.test($("#regShippingPhoneNumberId").val())){ $("#regShippingPhoneNumberId").css("border-color","black"); } else{ $("#regShippingPhoneNumberId").css("border-color","red"); result=false; }	    			
	    	return result;
	    	});
		    $("#regShippingAddressId").keyup(function(){ if(addrReg.test(this.value)){ $(this).css("border-color","black"); } else{ $(this).css("border-color","red"); } });
		    $("#regShippingApartmentId").keyup(function(){ if(addrReg.test(this.value)){ $(this).css("border-color","black"); } else{ $(this).css("border-color","red"); } });		    
		    $("#regShippingCityId").keyup(function(){ if(nameRegExp.test(this.value)){ $(this).css("border-color","black"); } else{ $(this).css("border-color","red"); } });		    
		    $("#regShippingStateId").click(function (){ if($("#billStateId").val() !== ""){ $(this).css("border-color","black"); } else{ $(this).css("border-color","red"); } });		    
		    $("#regShippingZipCodeId").keyup(function(){ if(zipRegExp.test(this.value)){ $(this).css("border-color","black"); } else{ $(this).css("border-color","red"); } });		    
		    $("#regShippingPhoneNumberId").keyup(function(){ if(phoneRegExp.test(this.value)){ $(this).css("border-color","black"); } else{ $(this).css("border-color","red"); } });		    
		    var regShippingAddress1 = "<c:out value="${regShippingAddress}"/>"; var regShippingApartment1 = "<c:out value="${regShippingApartment}"/>"; var regShippingCity1 = "<c:out value="${regShippingCity}"/>"; var regShippingState1 = "<c:out value="${regShippingState}"/>"; var regShippingZipCode1 = "<c:out value="${regShippingZipCode}"/>"; var regShippingPhoneNumber1 = "<c:out value="${regShippingPhoneNumber}"/>";		    
		    $("[name=regShippingAddress]").val(regShippingAddress1); $("[name=regShippingApartment]").val(regShippingApartment1); $("[name=regShippingCity]").val(regShippingCity1); $("[name=regShippingState]").val(regShippingState1); $("[name=regShippingZipCode]").val(regShippingZipCode1); $("[name=regShippingPhoneNumber]").val(regShippingPhoneNumber1); 	 		
	 });	
		function checkFirstChar(key, txt) { if(key == 32 && txt.value.length<=0) { return false; } else if(txt.value.length>0) { if(txt.value.charCodeAt(0) == 32) { txt.value=txt.value.substring(1,txt.value.length); return true; } } return true; }		
		function numeralsOnly(evt) { evt = (evt) ? evt : event; var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.regShippingCityIdkeyCode : ((evt.which) ? evt.which : 0)); if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; } return true; }		
		function phoneFormat (e,input) { evt = e || window.event; var pressedkey = evt.which || evt.keyCode; var BlockedKeyCodes = new Array(0,8,27,13,9); var len = BlockedKeyCodes.length; var block = false; var str = '';
		for (i=0; i<len; i++){ str=BlockedKeyCodes[i].toString(); if (str.indexOf(pressedkey) >=0 ) block=true; }
		if (block) return true; s = input.value; if (s.charAt(0) =='+') return false; filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{}ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\''; var i; var returnString = '';
		for (i = 0; i < s.length; i++) { var c = s.charAt(i); if ((filteredValues.indexOf(c) == -1) & (returnString.length <  12 )) { if (returnString.length==3) returnString +='-'; if (returnString.length==7) returnString +='-'; returnString += c; } } input.value = returnString; return false; }	    
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
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="regiMyOrderDsp" class="regi_prof_left_link_text_dspl">MY ORDERS</a></div>
		<div class="top_adjustment_10"><a href="regiGiftsReceivedDsp" class="regi_prof_left_link_text_dspl">GIFTS RECEIVED</a></div>
		<div class="top_adjustment_10"><a href="regiRoomFundsDsp" class="regi_prof_left_link_text_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>	        
<!-- Left Code End -->
	    <div class="col-md-9 col-sm-9">	        	        	
<!-- No register heading text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<div align="left"> <div class="registry_prof_title top_adjustment_30"><h2>Shipping Information</h2></div> </div> </div></div></div> </div>
<!-- No register text display -->
		<div class="row"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp"> <div align="left">        			
		<div class="registry_prof_title top_adjustment_30"><p class="regi_shipping_sml_text_dsp">Where would you like your gifts shipped?</p></div>
		<div class="registry_prof_title top_adjustment_10"><p class="regi_shipping_sml_text_dsp">When a guest buys you a gift, you get to decide whether to ship now or ship later under the <a href="regiGiftsReceivedDsp" class="reg_prof_left_sub_ital_a_text">Gifts Received</a> tab.</p></div> </div> </div></div></div> </div>					
<!-- No register button display -->
		<div class="row top_adjustment_40"> <div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
		<form action="registrantShippingInfoSaving">
		<div align="left"> <table> <tr> <td class="reg_ship_lb_text_cl">Address: </td> <td><input type="text" name="regShippingAddress" id="regShippingAddressId" class="reg_shipping_input_text_field"/></td> </tr>
		<tr> <td class="reg_ship_lb_text_cl">Apartment/Suite: </td> <td><input type="text" name="regShippingApartment" id="regShippingApartmentId" class="reg_shipping_input_text_field"/></td> </tr>
		<tr> <td class="reg_ship_lb_text_cl">City: </td> <td><input type="text" name="regShippingCity" id="regShippingCityId" class="reg_shipping_input_text_field"/></td> </tr>
		<tr> <td class="reg_ship_lb_text_cl">State: </td> <td><select name="regShippingState" id="regShippingStateId" class="reg_shipping_input_text_field"> <option value="">---------------State Name---------------</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select></td> </tr>
		<tr> <td class="reg_ship_lb_text_cl">Zip Code: </td> <td><input type="text" name="regShippingZipCode" id="regShippingZipCodeId" class="reg_shipping_input_text_field" maxLength="5" onkeypress="return numeralsOnly(event);"/></td> </tr>
		<tr> <td class="reg_ship_lb_text_cl">Phone Number: </td> <td><input type="text" name="regShippingPhoneNumber" id="regShippingPhoneNumberId" maxLength="12" class="reg_shipping_input_text_field" onchange="return phoneFormat (event,regShippingPhoneNumberId);" onkeydown="return numeralsOnly(event);" onkeyup="return phoneFormat (event,regShippingPhoneNumberId)" onkeypress="return numeralsOnly(event);"/></td> </tr>
		<tr style="height: 20px;"><td></td> <td></td></tr>
		<tr><td></td><td><h4><button class="reg_profile_save_subt_Btn" id="shippingInfoSavingButtId" style=" margin-left: 7px; width: 160px;">SAVE</button></h4></td></tr>	
		</table> </div>
		</form> </div></div></div> </div> </div> </div> </div> </div>		     
		</body>
</html>