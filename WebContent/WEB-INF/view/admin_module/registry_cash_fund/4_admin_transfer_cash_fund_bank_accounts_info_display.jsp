
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<style type="text/css">
	.reg_cf_add_bc_small_test_cl { font: 500 0.90em/1.15em Georgia; letter-spacing: 1px; color: black; }
	.reg_cf_add_bc_mid_test_cl { font: 500 1em/1.15em Georgia; letter-spacing: 1px; color: black; }
	.cf_input_same_boxes_text_dsp { font: 500 1.15em/1.15em Georgia; letter-spacing: 2px; color: black; }
	.cf_input_same_boxes_dsp { border: 1px solid #494949; width: 100%; height: 36px; margin-top: 10px; letter-spacing: 2px; color: black; font: 1.18em/1.25em Georgia; max-width: 100%; box-shadow: 1px 1px 2px #bcbcbc; padding-left: 15px; }
	.cf_input_sel_boxes_dsp { background: white; border: 1px solid #494949; width: 100%; max-width: 100%; height: 36px; font: 1.15em/1.25em Georgia; letter-spacing: 2px; color: black; box-shadow: 1px 1px 2px #bcbcbc; padding-left: 15px; }
	
	.reg_add_bank_acc_saving_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; padding: 10px 40px; outline: none; border: none; font: 500 1.4em/1.15em Georgia; letter-spacing: 3px;  box-shadow: 2px 3px #888888; }
	.reg_add_bank_acc_saving_subt_Btn:hover { background-color: #2c2c2c; }
	</style>
	
	
	<script type="text/javascript">
 	$(document).ready(function() {
 		var cashFundRoutingNumber1 = "<c:out value="${cashFundRoutingNumber}"/>";
 		var cashFundAccountNumber1 = "<c:out value="${cashFundAccountNumber}"/>";
 		var cashFundFirstName1 = "<c:out value="${cashFundFirstName}"/>";
 		var cashFundLastName1 = "<c:out value="${cashFundLastName}"/>";
 		var cashFundStreetAddress1 = "<c:out value="${cashFundStreetAddress}"/>";
 		var cashFundAptOrUnit1 = "<c:out value="${cashFundAptOrUnit}"/>";
 		var cashFundCity1 = "<c:out value="${cashFundCity}"/>";
 		var cashFundState1 = "<c:out value="${cashFundState}"/>";
 		var cashFundZipCode1 = "<c:out value="${cashFundZipCode}"/>";
 		var cashFundPhoneNumber1 = "<c:out value="${cashFundPhoneNumber}"/>";
 		
 		$("[name=cashFundRoutingNumber]").val(cashFundRoutingNumber1);
 		$("[name=cashFundAccountNumber]").val(cashFundAccountNumber1);
 		$("[name=cashFundFirstName]").val(cashFundFirstName1);
 		$("[name=cashFundLastName]").val(cashFundLastName1);
 		$("[name=cashFundStreetAddress]").val(cashFundStreetAddress1);
 		$("[name=cashFundAptOrUnit]").val(cashFundAptOrUnit1);
 		$("[name=cashFundCity]").val(cashFundCity1);
 		$("[name=cashFundState]").val(cashFundState1);
 		$("[name=cashFundZipCode]").val(cashFundZipCode1);
 		$("[name=cashFundPhoneNumber]").val(cashFundPhoneNumber1);
 		
 	});
	
    </script>
    
	</head>
	
		<body>
				
		<div id="mainframe" class="section-content">
        <div class="container">
      
      	<div class="row">
	        <div class="col-md-1 col-sm-1"></div>
	
			<div class="col-md-10 col-sm-10"style="border: 2px solid #41719c; padding: 40px;">
				
				<div class="row" style="width: 900px;">
					
					<form action="cashFundTransferCompletedStatusUpdate" method="post">
					<div class="row" style="margin-top: 30px; margin-left: 5px;">
						<div class="col-md-6 col-sm-6">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundRoutingNumberLabel">ROUTING NUMBER (9 DIGITS)*:</div>
							<div><input type="text" name="cashFundRoutingNumber" maxLength="9" readonly id="cashFundRoutingNumberId" class="cf_input_same_boxes_dsp" onkeypress="return numeralsOnly(event);" ></div>
						</div>
						
						<div class="col-md-6 col-sm-6">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundAccountNumberLabel">ACCOUNT NUMBER (3-17 DIGITS)*:</div>
							<div><input type="text" name="cashFundAccountNumber" maxLength="13" readonly id="cashFundAccountNumberId" class="cf_input_same_boxes_dsp" onkeypress="return numeralsOnly(event);"></div>
						</div>
					</div>
									
					<div class="row" style="margin-top: 40px; margin-left: 5px;">
						<div class="col-md-6 col-sm-6">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundFirstNameLabel">FIRST NAME*:</div>
							<div><input type="text" name="cashFundFirstName" id="cashFundFirstNameId" readonly class="cf_input_same_boxes_dsp"></div>
						</div>
						
						<div class="col-md-6 col-sm-6">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundLastNameLabel">LAST NAME*:</div>
							<div><input type="text" name="cashFundLastName" id="cashFundLastNameId" readonly class="cf_input_same_boxes_dsp"></div>
						</div>
					</div>
										
					<div class="row" style="margin-top: 40px; margin-left: 5px;">
						<div class="col-md-10 col-sm-10">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundStreetAddressLabel">STREET ADDRESS*:</div>
							<div><textarea name="cashFundStreetAddress" id="cashFundStreetAddressId" style="height: 80px;" readonly class="cf_input_same_boxes_dsp"></textarea></div>
						</div>
						
						<div class="col-md-2 col-sm-2">
							<div class="cf_input_same_boxes_text_dsp">APT/UNIT:</div>
							<div><input type="text" name="cashFundAptOrUnit" readonly id="cashFundAptOrUnitId" class="cf_input_same_boxes_dsp"></div>
						</div>
					</div>
										
					<div class="row" style="margin-top: 30px; margin-left: 5px;">
						<div class="col-md-5 col-sm-5">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundCityLabel">CITY*</div>
							<div><input type="text" name="cashFundCity" id="cashFundCityId" readonly class="cf_input_same_boxes_dsp"></div>
						</div>
						
						<div class="col-md-5 col-sm-5">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundStateLabel">STATE*:</div>
							<div><input type="text" name="cashFundState" id="cashFundStateId" readonly class="cf_input_same_boxes_dsp"></div>							
						</div>
						
						<div class="col-md-2 col-sm-2">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundZipCodeLabel">ZIP CODE*:</div>
							<div><input type="text" name="cashFundZipCode" maxLength="5" readonly id="cashFundZipCodeId" class="cf_input_same_boxes_dsp" onkeypress="return numeralsOnly(event);"></div>
						</div>
					</div>
										
					<div class="row" style="margin-top: 40px; margin-left: 5px;">
						<div class="col-md-6 col-sm-6">
							<div class="cf_input_same_boxes_text_dsp" id="cashFundPhoneNumberLabel">PHONE NUMBER*:</div>
							<div><input type="text" name="cashFundPhoneNumber" readonly maxLength="12" id="cashFundPhoneNumberId" class="cf_input_same_boxes_dsp" onchange="return phoneFormat (event,cashFundPhoneNumberId);" onkeydown="return numeralsOnly(event);" onkeyup="return phoneFormat (event,cashFundPhoneNumberId)" onkeypress="return numeralsOnly(event);"></div>
						</div>
						
						<div class="col-md-6 col-sm-6"> </div>
					</div>
										
					<div class="row" style="margin-top: 60px; margin-bottom: 30px;">
					<div class="col-md-3 col-sm-3"></div>
						<div class="col-md-6 col-sm-6">
							<div class="row">							
								<div class="col-md-2 col-sm-2" align="right">
									<a href="adminCashFundTransferRequested"> <img src="resources/images/backButton.png" style="position: relative; left: 8px; top: 5px;"> </a>								
								</div>
								<div class="col-md-10 col-sm-10">
								<div align="left"><button class="reg_add_bank_acc_saving_subt_Btn" onclick="return confirm('Are you sure transfer is complete?');" id="cfBankInfoSavingButtId">TRANSFER COMPLETE</button></div>
								</div>
							</div>
						</div>
					<div class="col-md-3 col-sm-3"></div>
					</div>
					
					<input type="hidden" name="registryCashFundId" value="${registryCashFundId}">
					<input type="hidden" name="typeOfCashFundName" value="${typeOfCashFundName}">
					
					</form>	
						
				</div>			
			</div>
			
			<div class="col-md-1 col-sm-1"></div>
		</div>	        
        		
		</div> </div>		     
		</body>
</html>