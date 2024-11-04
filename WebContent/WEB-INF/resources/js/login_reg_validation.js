    $(document).ready(function(){

    var nameRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; 
    var emailRegExp = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
        
// Sign up button validation

    $("#regButtonId").click(function (){
    var result = true; 
             
    if(nameRegExp.test($("#firstNameId").val())){ $("#firstNameId").css("border-color","#696969");
    } else{ $("#firstNameId").css("border-color","red"); result=false; }
        
    if(nameRegExp.test($("#lastNameId").val())){$("#lastNameId").css("border-color","#696969");
    } else{ $("#lastNameId").css("border-color","red"); result=false; }
        
    if(emailRegExp.test($("#userNameId").val())){ $("#userNameId").css("border-color","#696969");
    } else{ $("#userNameId").css("border-color","red"); result=false; }

    if(passRegExp.test($("#createPasswordId").val())){$("#createPasswordId").css("border-color","#696969");
    } else{ $("#createPasswordId").css("border-color","red"); result=false; }

    /*if($("#createPasswordId").val() === $("#verifyPasswordId").val() && $("#verifyPasswordId").val() !== ""){$("#verifyPasswordId").css("border-color","#696969");
    } else{ $("#verifyPasswordId").css("border-color","red"); result=false; }*/
       
    return result;
    });
        
// Sign Up keyboard validations
        
    $("#firstNameId").keyup(function(){
    if(nameRegExp.test(this.value)){ $(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });
        
    $("#lastNameId").keyup(function(){
    if(nameRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });
        
    $("#userNameId").keyup(function(){
    if(emailRegExp.test(this.value)){ $(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    $("#createPasswordId").keyup(function(){
    if(passRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    /*$("#verifyPasswordId").keyup(function(){
    if(($('#createPasswordId').val()) === ($('#verifyPasswordId').val())){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });*/

    $("#createPasswordId").change(function(){
    var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
    if(!(passRegExp.test(this.value))){
    alert("PASSWORD MUST BE A MINIMUM OF 8 CHARACTERS WITH AT LEAST ONE DIGIT OR A SPECIAL CHARACTER.");
    }; });

// Sign in button validation

    $("#loginButtonId").click(function (){
    var result = true;              
        
    if(emailRegExp.test($("#userEmailId").val())){ $("#userEmailId").css("border-color","#696969");
    } else{ $("#userEmailId").css("border-color","red"); result=false; }

    if(passRegExp.test($("#passwordId").val())){$("#passwordId").css("border-color","#696969");
    } else{ $("#passwordId").css("border-color","red"); result=false; }
    
    return result;
    });

// Sign in keyboard validations
        
    $("#userEmailId").keyup(function(){
    if(emailRegExp.test(this.value)){ $(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

    $("#passwordId").keyup(function(){
    if(passRegExp.test(this.value)){$(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

// Forgot password button validation

    $("#forgotPassButtonId").click(function () {
    var result = true;              
        
    if(emailRegExp.test($("#userEmailId").val())){ $("#userEmailId").css("border-color","#696969");
    } else{ $("#userEmailId").css("border-color","red"); result=false; }

    return result;
    });

// Forgot password keyboard validations
        
    $("#userEmailId").keyup(function(){
    if(emailRegExp.test(this.value)){ $(this).css("border-color","#696969");
    } else{ $(this).css("border-color","red");
    } });

// Forgot password Security PIN button validation

    $("#secPinButtonId").click(function (){
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
    
 // Change Password button validation

    $("#ChangePassButtonId").click(function (){
    var result = true; 
    if(passRegExp.test($("#currentPasswordID").val())){$("#currentPasswordID").css("border-bottom-color","black");
    } else{ $("#currentPasswordID").css("border-bottom-color","red"); result=false; }

    if(passRegExp.test($("#newPasswordID").val())){$("#newPasswordID").css("border-bottom-color","black");
    } else{ $("#newPasswordID").css("border-bottom-color","red"); result=false; }

    if(passRegExp.test($("#confirmPasswordID").val())){$("#confirmPasswordID").css("border-bottom-color","black");
    } else{ $("#confirmPasswordID").css("border-bottom-color","red"); result=false; }
       
    return result;
    });
   
 // Change Password keyboard valIDations
        
    $("#currentPasswordID").keyup(function(){
    if(passRegExp.test(this.value)){$(this).css("border-bottom-color","black");
    } else{ $(this).css("border-bottom-color","red");
    } });

    $("#newPasswordID").keyup(function(){
    if(passRegExp.test(this.value)){$(this).css("border-bottom-color","black");
    } else{ $(this).css("border-bottom-color","red");
    } });

    $("#confirmPasswordID").keyup(function(){
    if(($('#newPasswordID').val()) === ($('#confirmPasswordID').val())){$(this).css("border-bottom-color","black");
    } else{ $(this).css("border-bottom-color","red");
    } });

    $("#newPasswordID").change(function(){
    var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
    if(!(passRegExp.test(this.value))){
    alert("PASSWORD MUST BE A MINIMUM OF 8 CHARACTERS WITH AT LEAST ONE DIGIT OR A SPECIAL CHARACTER.");
    }; });

    });
        