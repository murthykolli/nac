<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	  
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    
    <style type="text/css">
    .buttonstyleClass { background-color: #ff3b3b; color: white; font: bold 0.9em/1.25em sans-serif; cursor:pointer; outline: none; border: none; white-space: nowrap; padding: 10px; outline-style: none; }
    .buttonstyleClass:hover { background-color: #4c4c4c; color: white; outline: none; }
    #mask { position:absolute; left:0; top:0; background-color:#000; display:none;}  
    #profileBox .profileWindow { position:absolute; z-index:9999;}
    #profileBox #profileDialog { height:auto; padding:10px; background-color:#ffffff;}
    
    .fieldBoxClass {border: 1px solid black; width: 200px; height: 20px; padding: 2px; }	
    </style>
        
    <script type="text/javascript">
    $(document).ready(function() {
    var uploadedImages = '<c:out value="${uploadedDesImg}"/>';
    
    if(uploadedImages !== ""){
    $("#photoText").hide();    
    $("#uploadImage").show();    
    }
        
    $(".photoupload").click(function(){
    $('#mask').css({'width': $(window).width(),'height': $(document).height()});	
    $('#mask').fadeIn(100);	
	$('#mask').fadeTo("fast",0.8);
	$('#profileDialog').fadeIn(500);
	$('.profileWindow .close').click(function (e) {
	e.preventDefault();
	$('#mask, .profileWindow').hide();
    });		
    });

    $("#uploadBut").click(function(){
	var fileName = $("#fileUpload").val();
	var fileExtension = fileName.replace(/^.*\./, '').toLowerCase();
	if(fileName === ""){
	alert("Pleae select a image to upload.");
	return false;
	} else if(!(fileExtension === "png" || fileExtension === "jpg" || fileExtension === "gif" || fileExtension === "jpeg" || fileExtension === "bmp" || fileExtension === "pdf" || fileExtension === "heic" || fileExtension === "heif")){
		alert("Please upload a JPG, JPEG, BMP, HEIC, HEIF, PDF, GIF, or PNG file.");
	return false;
	} else {
    return true;
    }            
    });
    
    var phoneNoExp = /^\(?(\d{3})\)?[-]?(\d{3})[-]?(\d{4})$/;
    var messRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 -#/_().&amp;]*$/;
    
    $("#saveDataId").click(function(){
    var result = true;	
    
    if(uploadedImages === ""){
    alert("Pleae upload your photo first.");
    result = false;
    }
    
    if(messRegExp.test($("#designerFactsId").val())){ $("#designerFactsId").css("border-color","black");
    } else{ $("#designerFactsId").css("border-color","red"); result = false; }        
    
    if(phoneNoExp.test($("#phoneNumberId").val()) && $("#phoneNumberId").val() !== "000-000-0000"){ $("#phoneNumberId").css("border-color","black");
    } else{ $("#phoneNumberId").css("border-color","red"); result = false; }
    
    return result;    
    });
    
    $("#designerFactsId").keyup(function(){
    if(messRegExp.test(this.value)){ $(this).css("border-color","black");
    } else{ $(this).css("border-color","red");
    } });
    
    $("#phoneNumberId").keyup(function(){
    if(phoneNoExp.test(this.value)){ $(this).css("border-color","black");
    } else{ $(this).css("border-color","red");
    } });
    
    var factsAboutDes = '<c:out value="${factsAboutDesn}"/>';    
	$("[name=factsaboutdesigner]").val(factsAboutDes);
	
	var desPhoneNumber = '<c:out value="${desnPhoneNumber}"/>';	
	$("[name=phoneNumber]").val(desPhoneNumber);
	
	var desWaitingForClient = '<c:out value="${desWaitingForClientReq}"/>';
	if(desWaitingForClient === "") {
		$("#desWaitingForClientId").show();	
	} else {
		$("#desWaitingForClientId").hide();
	}
	
    });

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
    if (s.charAt(0) ==='+') return false;
    filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{}ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
    var i;
    var returnString = '';
    for (i = 0; i < s.length; i++) {
    var c = s.charAt(i);
    if ((filteredValues.indexOf(c) === -1) & (returnString.length <  12 )) {
    if (returnString.length===3) returnString +='-';
    if (returnString.length===7) returnString +='-';
    returnString += c;
    }; }
    input.value = returnString;
    return false;
    }

    function numberonly(e, decimal) {
    var key;
    var keychar;
    if (window.event) { key = window.event.keyCode; } else if (e) { key = e.which; } else { return true; }
    keychar = String.fromCharCode(key);
    if ((key===null) || (key===0) || (key===8) ||  (key===9) || (key===13) || (key===27) ) {
    return true;
    } else if ((("0123456789").indexOf(keychar) > -1)) {
    return true;
    } else if (decimal && (keychar === ".")) {
    return true;
    } else if (keychar === "-") {
    return true;
    } else
    return false;
    }
    
    </script>
    
    <c:if test="${not empty passMessage}">    
    <script type="text/javascript">
    window.alert("Your new Password has been saved"); 
    </script>    
    </c:if>
    
	</head>
	
		<body>		
		<div id="shadowImgId">
        <div style="background-color: white; min-height: 450px; height: auto;">
        <div style="margin-top: 80px;margin-left: 60px;">
        <form action="requestNewClientForAdmin">
        <div id="desWaitingForClientId" style="margin-left: 650px; position: absolute; margin-top: 110px; display: none;">
        <button class="buttonstyleClass">REQUEST NEW CLIENT</button>
        </div>
        </form>    
        
        <div style="background: red; width: 1px; height: 260px; margin-left: 607px; position: absolute; margin-top: 25px;"></div>
        
        <form action="uploadDesInfoSaving" method="get">    
        <table style="margin-top: 20px;margin-left: 15px;">
        	<tr><td colspan="5"><span style="font:bold 1em/1.5em sans-serif;">My Profile</span></td></tr>
            <tr style="height: 5px;"><td colspan="5"></td></tr>
            <tr style="font: 0.8em/1.25em sans-serif;">
            <td id="photoText" class="photoupload" style="border: 2px dashed gray; width: 150px; height: 130px; text-align: center; cursor: pointer;"><span style="color: #FF6600;">Upload<br> Image</span></td>
            <td id="uploadImage" class="photoupload" style="cursor: pointer;display:none;"><img src="data:image/jpg;base64,<c:out value='${uploadedDesImg}'/>" style="width: 150px; height: 130px; border: 2px solid gray;"></td>
            <td style="width: 20px;"></td>
            <td style="vertical-align: top; text-align: center;">Quirky facts about you:<br>(Max 100 characters)</td>
            <td><textarea id="designerFactsId" name="factsaboutdesigner" maxLength="100" cols="35" rows="8" style="width: 230px; height: 130px; border: 2px solid gray;"></textarea></td></tr>
        </table>
            
        <table style="margin-top: 50px;font: 0.8em/1.25em sans-serif;">        	
        <tr><td><input id="phoneNumberId" type="text" name="phoneNumber" maxLength="12" placeholder="Phone Number" class="fieldBoxClass" onkeyup="return phoneFormat (event,phoneNumberId)" onkeypress="return numberonly(event,false)"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        <tr><td><a href="changePassword" style="text-decoration:none; cursor:pointer; outline: none;color: #000; font: 1.05em/1.25em Verdana,Geneva,Arial,Helvetica,sans-serif;" onmouseover="this.style.color='#ff3b3b';" onmouseout="this.style.color='#000';" >Change Password</a></td></tr>
        <tr style="height: 5px;"><td></td></tr>
        </table>
            
        <div style="height: 1px; background: red; width: 595px; margin-top: 10px;"></div>
        <button id="saveDataId" class="buttonstyleClass" style="margin-top: 30px;">SAVE&nbsp;</button>
        </form>
        
        </div> <br><br><br><br>        
        </div>
        </div>
        
        
        <div id="profileBox">
        <div style="top: 190px; left: 535px; display: none;" id="profileDialog" class="profileWindow">
        <div style="text-align: right;"> <img class="close" src="resources/images/close.png" style="cursor: pointer;"></div><br>
        <form action="uploadDesignerProfile" method="POST" enctype="multipart/form-data">
        <table>
        <tr><td style="font:0.9em/1.5em Arial;">Select a image to upload</td></tr>
        <tr><td><input type="file" title="Click here to browse your image." id="fileUpload" name="fileDesnUpload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td align="center"><input class="buttonstyleClass" type="submit" id="uploadBut" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
  		</div>
  		<div style="width: 1478px; font-size: 32pt; color:white; height: 602px; display: none; opacity: 0.8;" id="mask"></div>
		</div>	
		</body>
</html>