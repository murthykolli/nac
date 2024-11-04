
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script type="text/javascript">
 	$(document).ready(function() {
 		var clientFirstName1 = "<c:out value="${clientFirstName}"/>";
		var clientLastName1 = "<c:out value="${clientLastName}"/>";
		var clientUserEmail1 = "<c:out value="${clientUserEmail}"/>";
		
		$("[name=clientFirstName]").val(clientFirstName1);
		$("[name=clientLastName]").val(clientLastName1);
		$("[name=clientUserEmail]").val(clientUserEmail1);
		

	    var nameRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; 
	    var emailRegExp = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
	    
	    $("#saveChangesButtId").click(function (){
	    var result = true; 
	    
	    if(nameRegExp.test($("#clientFirstNameId").val())){ $("#clientFirstNameId").css("border-color","gray");
	    } else{ $("#clientFirstNameId").css("border-color","red"); result=false; }
        
	    if(nameRegExp.test($("#clientLastNameId").val())){ $("#clientLastNameId").css("border-color","gray");
	    } else{ $("#clientLastNameId").css("border-color","red"); result=false; }
        
	    if(emailRegExp.test($("#clientUserEmail").val())){ $("#clientUserEmail").css("border-color","gray");
	    } else{ $("#clientUserEmail").css("border-color","red"); result=false; }
 
	    return result;
	    });
	        
	// Sign Up keyboard validations
	        
	    $("#clientFirstNameId").keyup(function(){
	    if(nameRegExp.test(this.value)){ $(this).css("border-color","gray");
	    } else{ $(this).css("border-color","red");
	    } });
	        
	    $("#clientLastNameId").keyup(function(){
	    if(nameRegExp.test(this.value)){$(this).css("border-color","gray");
	    } else{ $(this).css("border-color","red");
	    } });
	        
	    $("#clientUserEmail").keyup(function(){
	    if(emailRegExp.test(this.value)){ $(this).css("border-color","gray");
	    } else{ $(this).css("border-color","red");
	    } });
	    
	    var clientSuccPage1 = "<c:out value="${clientSuccPage}"/>";
	    if(clientSuccPage1 == "Account Data Saved") {
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
									<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">CONTACT INFO</a></div>
									<div class="top_adjustment_10"><a href="clientPasswordChange" class="regi_prof_left_link_text_dspl">CHANGE PASSWORD</a></div>
									
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
												<div class="registry_prof_title top_adjustment_30"><h2>Contact Info</h2></div>
						        			</div>
						        		</div>
						        	</div>
						        </div>
					    	</div>
					    	
					    	
			        		<form action="clientAccountInfoUpdate" method="post">			        
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
			
			                                <tr><td class="reg_pr_input_text_disp">FIRST NAME:</td></tr>
			                                <tr><td><input class="reg_pr_input_text_field" id="clientFirstNameId" type="text" name="clientFirstName"/></td></tr>
			
			                                <tr><td class="reg_pr_input_text_disp">LAST NAME:</td></tr>
			                                <tr><td><input class="reg_pr_input_text_field" id="clientLastNameId" type="text" name="clientLastName"/></td></tr>
			
			                                <tr><td class="reg_pr_input_text_disp">EMAIL:</td></tr>
			                                <tr><td><input class="reg_pr_input_text_field" id="clientUserEmail" type="text" name="clientUserEmail"/></td></tr>
			
											<tr style="height: 25px;"><td></td></tr>
			                                <tr><td><h4><button class="reg_profile_save_subt_Btn" id="saveChangesButtId">SAVE CHANGES</button></h4></td></tr>
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