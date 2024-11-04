	$(document).ready(function() {

    var nameRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; 
    var emailRegExp = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var phoneRegExp = /^\(?(\d{3})\)?[-]?(\d{3})[-]?(\d{4})$/;
    var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
    var zipRegExp = /^\d{5}$/;
    var addrReg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.@/&;,-]*$/;
        
// Sign up button validation

    $("#referralSignUpDataId").click(function (){
    var result = true; 
             
    if(nameRegExp.test($("#referralFirstNameId").val())){ $("#referralFirstNameId").css("border-color","#696969");
    } else{ $("#referralFirstNameId").css("border-color","red"); result=false; }
        
    if(nameRegExp.test($("#referralLastNameId").val())){$("#referralLastNameId").css("border-color","#696969");
    } else{ $("#referralLastNameId").css("border-color","red"); result=false; }
      
    if(nameRegExp.test($("#vendorCategoryId").val())){$("#vendorCategoryId").css("border-color","#696969");
    } else{ $("#vendorCategoryId").css("border-color","red"); result=false; }
    
    if($("#vendorCategoryId").val() === "Other") {    	
    	if(nameRegExp.test($("#otherCategoryId").val())){$("#otherCategoryId").css("border-color","#696969");
        } else{ $("#otherCategoryId").css("border-color","red"); result=false; }
    }
        
    if(emailRegExp.test($("#referralUserEmailId").val())){ $("#referralUserEmailId").css("border-color","#696969");
    } else{ $("#referralUserEmailId").css("border-color","red"); result=false; }

    if(phoneRegExp.test($("#referralPhoneNumberId").val())){$("#referralPhoneNumberId").css("border-color","#696969");
    } else{ $("#referralPhoneNumberId").css("border-color","red"); result=false; }
    
    if(nameRegExp.test($("#referralBusinessNameId").val())){$("#referralBusinessNameId").css("border-color","#696969");
    } else{ $("#referralBusinessNameId").css("border-color","red"); result=false; }
    
    if(addrReg.test($("#referralStreetAddressId").val())){$("#referralStreetAddressId").css("border-color","#696969");
    } else{ $("#referralStreetAddressId").css("border-color","red"); result=false; }

    if(nameRegExp.test($("#referralCityNameId").val())){$("#referralCityNameId").css("border-color","#696969");
    } else{ $("#referralCityNameId").css("border-color","red"); result=false; }

    if(nameRegExp.test($("#referralStateNameId").val())){$("#referralStateNameId").css("border-color","#696969");
    } else{ $("#referralStateNameId").css("border-color","red"); result=false; }

    if(zipRegExp.test($("#referralZipCodeId").val())){$("#referralBusinessNameId").css("border-color","#696969");
    } else{ $("#referralZipCodeId").css("border-color","red"); result=false; }
    
    return result;
    });
        
// Sign Up keyboard validations
        
    $("#referralFirstNameId").keyup(function(){
    if(nameRegExp.test(this.value)){ $(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });
        
    $("#referralLastNameId").keyup(function(){
    if(nameRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });
        
    $("#referralUserEmailId").keyup(function(){
    if(emailRegExp.test(this.value)){ $(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    $("#referralPhoneNumberId").keyup(function(){
    if(phoneRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });
    
    $("#referralBusinessNameId").keyup(function(){
    if(nameRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });    

    $("#vendorCategoryId").click(function(){    	
    if(nameRegExp.test(this.value)){$(this).css("border-color","#696969"); 
    if(this.value === "Other") { $("#otherCategoryDspId").show(); } else { $("#otherCategoryDspId").hide(); }
    } else{ $(this).css("border-color","red"); $("#otherCategoryDspId").hide();
    } });

    $("#otherCategoryId").keyup(function(){
    if(nameRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });
    
    $("#referralStreetAddressId").keyup(function(){
    if(addrReg.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    $("#referralCityNameId").keyup(function(){
    if(nameRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    $("#referralStateNameId").click(function(){
    if(nameRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    $("#referralZipCodeId").keyup(function(){
    if(zipRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });
    
 // Referral Forgot Password validation

    $("#referralForgotPassButtonId").click(function () {
    var result = true; 
    if(emailRegExp.test($("#referralUserEmailId").val())){ $("#referralUserEmailId").css("border-color","#696969");
    } else{ $("#referralUserEmailId").css("border-color","red"); result=false; }
    return result;
    });

// Referral Security Pin validation

    $("#referralSecurityPinButtonId").click(function () {
    var result = true; 
    var secPinRegExp = /^[a-zA-Z0-9]{8}$/;
    if(secPinRegExp.test($("#securityPinId").val())){ $("#securityPinId").css("border-color","#696969");
    } else{ $("#securityPinId").css("border-color","red"); result=false; }

    if(passRegExp.test($("#newPasswordId").val())){$("#newPasswordId").css("border-color","#696969");
    } else{ $("#newPasswordId").css("border-color","red"); result=false; }

    if($("#newPasswordId").val() === $("#confirmPasswordId").val() && $("#confirmPasswordId").val() !== ""){$("#confirmPasswordId").css("border-color","#696969");
    } else{ $("#confirmPasswordId").css("border-color","red"); result=false; }
           
    return result;
    });
    
 // Forgot password Security PIN keyboard validations
        
    $("#securityPinId").keyup(function(){
    var secPinRegExp = /^[a-zA-Z0-9]{8}$/;
    if(secPinRegExp.test(this.value)){ $(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    }; });

    $("#newPasswordId").keyup(function(){
    if(passRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    $("#confirmPasswordId").keyup(function(){
    if(($('#newPasswordId').val()) === ($('#confirmPasswordId').val())){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    $("#newPasswordId").change(function(){
    var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
    if(!(passRegExp.test(this.value))){
    alert("PASSWORD MUST BE A MINIMUM OF 8 CHARACTERS WITH AT LEAST ONE DIGIT OR A SPECIAL CHARACTER.");
    }; });

//  Referral Login validation

    $("#referralLoginButtonId").click(function () {
    var result = true;        
    if(emailRegExp.test($("#referralUserEmailId").val())){ $("#referralUserEmailId").css("border-color","#696969");
    } else{ $("#referralUserEmailId").css("border-color","red"); result=false; }

    if(passRegExp.test($("#referralPasswordId").val())){$("#referralPasswordId").css("border-color","#696969");
    } else{ $("#referralPasswordId").css("border-color","red"); result=false; }
              
    return result;
    });
        
    $("#referralPasswordId").keyup(function(){
    if(passRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });
    

	$("#savePassChangesButtId").click(function (){
	var result = true;	

	if(passRegExp.test($("#currentReferralPasswordId").val())){$("#currentReferralPasswordId").css("border-color","gray");
	} else{ $("#currentReferralPasswordId").css("border-color","red"); result=false; }

	if(passRegExp.test($("#newReferralPasswordId").val())){$("#newReferralPasswordId").css("border-color","gray");
	} else{ $("#newReferralPasswordId").css("border-color","red"); result=false; }

	if($("#newReferralPasswordId").val() === $("#verifyReferralPasswordId").val() && $("#verifyReferralPasswordId").val() !== ""){$("#verifyReferralPasswordId").css("border-color","gray");
	} else{ $("#verifyReferralPasswordId").css("border-color","red"); result=false; }
	       
	return result;
	});
	

    $("#currentReferralPasswordId").keyup(function(){
    if(passRegExp.test(this.value)){$("#currentReferralPasswordId").css("border-color","gray");
    } else{ $("#currentReferralPasswordId").css("border-color","red");
    } });

    $("#newReferralPasswordId").keyup(function(){
    if(passRegExp.test(this.value)){$("#newReferralPasswordId").css("border-color","gray");
    } else{ $("#newReferralPasswordId").css("border-color","red");
    } });

    $("#verifyReferralPasswordId").keyup(function(){
    if(($('#newReferralPasswordId').val()) === ($('#verifyReferralPasswordId').val())){$("#verifyReferralPasswordId").css("border-color","gray");
    } else{ $("#verifyReferralPasswordId").css("border-color","red");
    } });

    $("#newReferralPasswordId").change(function(){
    var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
    if(!(passRegExp.test(this.value))){
    alert("Password must be a minimum of 8 characters with at least one digit or special character");
    }; });
    

    
    $("#referralContactInfoUpdateId").click(function (){
    var result = true; 
             
    if(nameRegExp.test($("#referralFirstNameId").val())){ $("#referralFirstNameId").css("border-color","#696969");
    } else{ $("#referralFirstNameId").css("border-color","red"); result=false; }
        
    if(nameRegExp.test($("#referralLastNameId").val())){$("#referralLastNameId").css("border-color","#696969");
    } else{ $("#referralLastNameId").css("border-color","red"); result=false; }
      
    if(nameRegExp.test($("#vendorCategoryId").val())){$("#vendorCategoryId").css("border-color","#696969");
    } else{ $("#vendorCategoryId").css("border-color","red"); result=false; }
    
    if($("#vendorCategoryId").val() === "Other") {    	
    	if(nameRegExp.test($("#otherCategoryId").val())){$("#otherCategoryId").css("border-color","#696969");
        } else{ $("#otherCategoryId").css("border-color","red"); result=false; }
    }
        
    if(emailRegExp.test($("#referralUserEmailId").val())){ $("#referralUserEmailId").css("border-color","#696969");
    } else{ $("#referralUserEmailId").css("border-color","red"); result=false; }

    if(phoneRegExp.test($("#referralPhoneNumberId").val())){$("#referralPhoneNumberId").css("border-color","#696969");
    } else{ $("#referralPhoneNumberId").css("border-color","red"); result=false; }
    
    if(nameRegExp.test($("#referralBusinessNameId").val())){$("#referralBusinessNameId").css("border-color","#696969");
    } else{ $("#referralBusinessNameId").css("border-color","red"); result=false; }
    
    return result;
    });
    

    
    $("#referralShippingInfoUpdateId").click(function (){
    var result = true;
    
    if(addrReg.test($("#referralStreetAddressId").val())){$("#referralStreetAddressId").css("border-color","#696969");
    } else{ $("#referralStreetAddressId").css("border-color","red"); result=false; }

    if(nameRegExp.test($("#referralCityNameId").val())){$("#referralCityNameId").css("border-color","#696969");
    } else{ $("#referralCityNameId").css("border-color","red"); result=false; }

    if(nameRegExp.test($("#referralStateNameId").val())){$("#referralStateNameId").css("border-color","#696969");
    } else{ $("#referralStateNameId").css("border-color","red"); result=false; }

    if(zipRegExp.test($("#referralZipCodeId").val())){$("#referralBusinessNameId").css("border-color","#696969");
    } else{ $("#referralZipCodeId").css("border-color","red"); result=false; }
    
    return result;
    });
    

    });
    
  

    function checkFirstChar(key, txt){
    if(key === 32 && txt.value.length<=0){
    return false;
    }
    else if(txt.value.length>0){
    if(txt.value.charCodeAt(0) === 32){
    txt.value=txt.value.substring(1,txt.value.length);
    return true;
    }
    }    
    return true;
    }

	function numeralsOnly(evt) {
	evt = (evt) ? evt : event;
	var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
	((evt.which) ? evt.which : 0));
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	return false;
	}
	return true;
	}

	function phoneFormat (e,input) {
	evt = e || window.event; /* firefox uses reserved object e for event */
	var pressedkey = evt.which || evt.keyCode;
	var BlockedKeyCodes = new Array(0,8,27,13,9); //8 is backspace key
	var len = BlockedKeyCodes.length;
	var block = false;
	var str = '';
	for (i=0; i<len; i++){
	str=BlockedKeyCodes[i].toString();
	if (str.indexOf(pressedkey) >=0 ) block=true;
	}
	if (block) return true;
	s = input.value;
	if (s.charAt(0) =='+') return false;
	filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{}ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
	var i;
	var returnString = '';
	for (i = 0; i < s.length; i++) {
	var c = s.charAt(i);
	if ((filteredValues.indexOf(c) == -1) & (returnString.length <  12 )) {
	if (returnString.length==3) returnString +='-';
	if (returnString.length==7) returnString +='-';
	returnString += c;
	}
	}
	input.value = returnString;
	return false;
	}

        