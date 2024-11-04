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
	<script type="text/javascript">
 	$(document).ready(function() {
 		var regFirstName1 = "<c:out value="${regFirstName}"/>"; var coRegFirstName1 = "<c:out value="${coRegFirstName}"/>"; var regLastName1 = "<c:out value="${regLastName}"/>"; var coRegLastName1 = "<c:out value="${coRegLastName}"/>"; var regUserName1 = "<c:out value="${regUserName}"/>";		
		$("[name=regFirstName]").val(regFirstName1); $("[name=coRegFirstName]").val(coRegFirstName1); $("[name=regLastName]").val(regLastName1); $("[name=coRegLastName]").val(coRegLastName1); $("[name=regUserName]").val(regUserName1);
	    var nameRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; var emailRegExp = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;	    
	    $("#saveChangesButtId").click(function () { var result = true;	    
	    if(nameRegExp.test($("#regFirstNameId").val())){ $("#regFirstNameId").css("border-color","gray"); } else{ $("#regFirstNameId").css("border-color","red"); result=false; }        
	    if(nameRegExp.test($("#regLastNameId").val())){ $("#regLastNameId").css("border-color","gray"); } else{ $("#regLastNameId").css("border-color","red"); result=false; }         
	    if(emailRegExp.test($("#regEmailId").val())){ $("#regEmailId").css("border-color","gray"); } else{ $("#regEmailId").css("border-color","red"); result=false; } 
	    return result;
	    });	        
	// Sign Up keyboard validations	        
	    $("#regFirstNameId").keyup(function() { if(nameRegExp.test(this.value)){ $(this).css("border-color","gray"); } else{ $(this).css("border-color","red"); } });
	    $("#regLastNameId").keyup(function() { if(nameRegExp.test(this.value)){$(this).css("border-color","gray"); } else{ $(this).css("border-color","red"); } });	        
	    $("#regEmailId").keyup(function() { if(emailRegExp.test(this.value)){ $(this).css("border-color","gray"); } else{ $(this).css("border-color","red"); } });
	    var regSuccSave1 = "<c:out value="${regSuccSave}"/>";
	    if(regSuccSave1 == "Account Data Saved") { alert("Your Changes Have Been Saved") }		
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
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">CONTACT INFO</a></div>
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
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>	        
<!-- Left Code End -->	        
	    <div class="col-md-9 col-sm-9"> <div class="service-item"> <div class="service-description">	        			
	    <div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description reg_pro_left_adj_disp"> <div align="left">        			
		<div class="registry_prof_title top_adjustment_30"><h2>Contact Info</h2></div> </div> </div> </div> </div> </div>
		<form action="registrantAccountInfoUpdate" method="post">			        
		<div class="row top_adjustment_20"> <div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description reg_pro_left_adj_disp"> <div align="left">
		<div class="registry_prof_sub_title"><h2>REGISTRANT'S INFORMATION:</h2></div>
		<table> <c:if test="${not empty regErrorPage}">
        <tr><td align="left"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;">&nbsp;&nbsp;&nbsp;&nbsp; ${regErrorPage}</font></td></tr>
        <tr><td style="height: 10px;"></td></tr> </c:if>
		<tr><td class="reg_pr_input_text_disp">FIRST NAME:</td></tr>
	    <tr><td><input class="reg_pr_input_text_field" id="regFirstNameId" type="text" name="regFirstName"/></td></tr>
		<tr><td class="reg_pr_input_text_disp">LAST NAME:</td></tr>
	    <tr><td><input class="reg_pr_input_text_field" id="regLastNameId" type="text" name="regLastName"/></td></tr>
		<tr><td class="reg_pr_input_text_disp">EMAIL:</td></tr>
	    <tr><td><input class="reg_pr_input_text_field" id="regEmailId" type="text" name="regUserName"/></td></tr>
		<tr style="height: 25px;"><td></td></tr>
	    <tr><td><h4><button class="reg_profile_save_subt_Btn" id="saveChangesButtId">SAVE CHANGES</button></h4></td></tr>
		</table></div> </div> </div> </div>
		<div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description"> <div align="left">
		<div class="registry_prof_sub_title"><h2>CO-REGISTRANTS'S INFORMATION</h2></div>
		<table> <tr><td class="reg_pr_input_text_disp">FIRST NAME:</td></tr>
	    <tr><td><input class="reg_pr_input_text_field" type="text" name="coRegFirstName" id="coRegFirstNameId"/></td></tr>
		<tr><td class="reg_pr_input_text_disp">LAST NAME:</td></tr>
	    <tr><td><input class="reg_pr_input_text_field" type="text" name="coRegLastName" id="coRegLastNameId"/></td></tr>
		</table> </div> </div> </div> </div> </div>
		</form> </div> </div> </div> </div> </div> </div> 		     
		</body>
</html>