
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script type="text/javascript">
 	$(document).ready(function() {
 		
	 	var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
		
		$("#savePassChangesButtId").click(function (){
		var result = true;	

		if(passRegExp.test($("#currentPasswordId").val())){$("#currentPasswordId").css("border-color","gray");
		} else{ $("#currentPasswordId").css("border-color","red"); result=false; }

		if(passRegExp.test($("#newPasswordId").val())){$("#newPasswordId").css("border-color","gray");
		} else{ $("#newPasswordId").css("border-color","red"); result=false; }

		if($("#newPasswordId").val() === $("#verifyPasswordId").val() && $("#verifyPasswordId").val() !== ""){$("#verifyPasswordId").css("border-color","gray");
		} else{ $("#verifyPasswordId").css("border-color","red"); result=false; }
		       
		return result;
		});
		

	    $("#currentPasswordId").keyup(function(){
	    if(passRegExp.test(this.value)){$("#currentPasswordId").css("border-color","gray");
	    } else{ $("#currentPasswordId").css("border-color","red");
	    } });

	    $("#newPasswordId").keyup(function(){
	    if(passRegExp.test(this.value)){$("#newPasswordId").css("border-color","gray");
	    } else{ $("#newPasswordId").css("border-color","red");
	    } });

	    $("#verifyPasswordId").keyup(function(){
	    if(($('#newPasswordId').val()) === ($('#verifyPasswordId').val())){$("#verifyPasswordId").css("border-color","gray");
	    } else{ $("#verifyPasswordId").css("border-color","red");
	    } });

	    $("#newPasswordId").change(function(){
	    var passRegExp = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
	    if(!(passRegExp.test(this.value))){
	    alert("Password must be a minimum of 8 characters with at least one digit or special character");
	    }; });
	    

	    var clientSuccPage1 = "<c:out value="${clientSuccPage}"/>";
	    if(clientSuccPage1 == "Password Saved") {
	    	alert("Your Changes Have Been Saved")
	    }	    
		
 	});
    </script>
    
	</head>
	
		<body>
				
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
	        <div class="col-md-1 col-sm-1"></div>
	        <div class="col-md-10 col-sm-10">
	            
	            <div class="row">
			        <div class="col-md-8 col-sm-8">
			        	<div class="service-item">                        
			            	<div class="service-description">
			        			<div align="left">        			
									<div class="registry_prof_title"><h2>MY ACCOUNT</h2></div>
			        			</div>
			        		</div>
			        	</div>
			        </div>
			        
			        <div class="col-md-4 col-sm-4">
			        	<div class="service-item">                        
			            	<div class="service-description">
			        			<div align="right">        			
									<font style="text-transform: uppercase; color: #3c3c3c; font: bold 1.05em/1.5em Georgia; letter-spacing: 2px;">WELCOME &nbsp;</font><font style="color: #2c82ef; font: bold 1.05em/1.5em Georgia; letter-spacing: 2px;">${flName}</font></div>
			        			</div>
			        		</div>
			        	</div>
			        </div>   	
		    
		<!-- Left Code Start -->
		      	<div class="row top_adjustment_30">
			        <div class="col-md-4 col-sm-4">
			        	<div class="service-item">                        
			            	<div class="service-description">
			        			<div align="left">        			
									<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>ACCOUNT DETAILS</h3></div>
									<div class="top_adjustment_10"><a href="clientMyAccount" class="regi_prof_left_link_text_dspl">CONTACT INFO</a></div>
									<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">CHANGE PASSWORD</a></div>
									
									<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>ROOM DETAILS</h3></div>
									<div class="top_adjustment_10"><a href="clientsInformationDisplay" class="regi_prof_left_link_text_dspl">MY ROOMS</a></div>
									<div class="top_adjustment_10"><a href="paymentCartInfoDisp" class="regi_prof_left_link_text_dspl">MY SHOPPING CART</a></div>
									
			        			</div>
			        		</div>
			        	</div>
			        </div>
			        
		<!-- Left Code End -->
		
			        
			        <div class="col-md-8 col-sm-8" style="border-left: 1px solid red;">
			        	<div class="service-item">                        
			            	<div class="service-description">	        			
			        			
			        		<div class="row">
			        			<div class="col-md-2 col-sm-2"></div>
						        <div class="col-md-10 col-sm-10">
						        	<div class="service-item">                        
						            	<div class="service-description">
						        			<div align="left">        			
												<div class="registry_prof_title top_adjustment_30"><h2>Change Password</h2></div>
						        			</div>
						        		</div>
						        	</div>
						        </div>
					    	</div>
					    	
					    	<form action="clientPasswordInfoUpdate" method="post">			        
					        <div class="row top_adjustment_20">
						        <div class="col-md-2 col-sm-2"></div>
						        <div class="col-md-10 col-sm-10">
						        	<div class="service-item">                        
						            	<div class="service-description">
											<div align="left">
											
											<table>
		                                	<c:if test="${not empty clientErrorPage}">
		                                    <tr><td align="left"><img src="resources/images/warning.gif" style="position: absolute;"> <font style="color: red; font: 1.1em/1.25em Georgia; letter-spacing: 2px;">&nbsp;&nbsp;&nbsp;&nbsp; ${clientErrorPage}</font></td></tr>
		                                    <tr><td style="height: 10px;"></td></tr>
			                                </c:if>
		                                	
			                                <tr><td class="reg_pr_input_text_disp">CURRENT PASSWORD:</td></tr>
			                                <tr><td><input class="reg_pr_input_text_field" type="password" id="currentPasswordId" name="currentPassword"/></td></tr>
			
			                                <tr><td class="reg_pr_input_text_disp">NEW PASSWORD:</td></tr>
			                                <tr><td><input class="reg_pr_input_text_field" type="password" id="newPasswordId" name="newPassword"/></td></tr>
			
			                                <tr><td class="reg_pr_input_text_disp">VERIFY PASSWORD:</td></tr>
			                                <tr><td><input class="reg_pr_input_text_field" type="password" id="verifyPasswordId" name="verifyPassword"/></td></tr>
			
											<tr style="height: 25px;"><td></td></tr>
			                                <tr><td><h4><button class="reg_profile_save_subt_Btn" id="savePassChangesButtId">SAVE CHANGES</button></h4></td></tr>
											<tr style="height: 36px;"><td></td></tr>
			                            	</table>									
											</div>			        			
						        		</div>
						        	</div>
						        </div>					        
					        </div>
					        </form>
					    				        			
			        		</div>
			        	</div>
			        </div>
		    	</div>
    	
    		</div>
			<div class="col-md-1 col-sm-1"></div>
			</div>        
        		
		</div> </div>		     
		</body>
	
</html>