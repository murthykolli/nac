
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
    <link rel="stylesheet" href="resources/css/popup/lightbox.css" media="screen"/>
    
	<style type="text/css">
	.adm_sub_cash_fund_sub_butt { font: 1.7em/1.25em Georgia; letter-spacing: 3px; color: black; background: white; padding: 10px 40px; border: 1px solid red; }
	.adm_sub_cash_fund_sub_butt:hover { color: white; background: red; }
	
	.adm_cash_fund_no_data_text { font: 2em/1.25em Georgia; letter-spacing: 2px; color: black; }
	
	.number_circle_format { border-radius: 50%; background: #203864; border: 2px solid #203864; color: white; padding: 0.35em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.25em/1.0em Arial, sans-serif; }
	.number_circle_format_value { overflow: visible; height: 0; margin-top: -1em; }
	.number_circle_format:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	</style>
	
	<script type="text/javascript">
 	$(document).ready(function() {
 		var cashFundsStatus1 = "<c:out value="${cashFundsStatus}"/>";
 		if(cashFundsStatus1 == "No Cash Funds"){
	    	$("#visibleMyOrderId").show();
	    	$("#notVisibleMyOrderId").hide();
	    } else {
	    	$("#notVisibleMyOrderId").show();
	    	$("#visibleMyOrderId").hide();	    	
	    }
 		
 	});
 	
 	function cashFundsInfoViewDetails(){
 		var cashFundSavingId = document.adminCashFundsName.registryCashFundId.value;
 		if(cashFundSavingId !== "" && cashFundSavingId !== null) {
 			var typeOfFundNameId = "typeOfFundNameId"+cashFundSavingId;
 	 		var typeOfFundsName = document.getElementById(typeOfFundNameId).value;
 			document.adminCashFundsName.typeOfCashFundName.value = typeOfFundsName;
 			return true;
 		} else {
 			alert("Please select a Cash Fund.");
 			return false; 			
 		}
 	}
 	
    </script>
    
	</head>
	
		<body>
				
		<div id="mainframe" class="section-content">
        <div class="container">
      	
      		<div class="row" style="margin-top: 10px; margin-bottom: 70px;">        
				<div class="col-md-6 col-sm-6">
					<div class="row">        
						<div class="col-md-12 col-sm-12" align="left">
					        <table> <tr>
						        <td><a href="regConceptBoards"><font  class="adm_sub_reg_header_black_text_dsp">All Concepts</font></a></td>
							    <!-- <td style="position: relative; left: 18px;"><a href="adminDesignerConcepts"><font class="adm_sub_reg_header_black_text_dsp">Designer Concepts</font></a></td> -->
							    <td style="position: relative; left: 18px;"><a href="adminRegistryStockCheck"><font class="adm_sub_reg_header_black_text_dsp">Stock Check</font></a></td>				        
						    </tr></table>
					    </div>
					</div>
			   	</div>		   	
		   	
		   		<div class="col-md-6 col-sm-6">
		   			<div class="row">        
						<div class="col-md-12 col-sm-12" align="right">
				        	<table> <tr>
				        	<td style="position: relative; left: -36px;"><a href="adminRoomFunds"><font class="adm_sub_reg_header_black_text_dsp">Room Funds</font></a></td>
					        <td style="position: relative; left: -18px;"><a href="adminCashFunds"><font class="adm_sub_reg_header_red_text_dsp">Cash Funds</font></a></td>
					        <td><a href="adminGiftsReceived"><font class="adm_sub_reg_header_black_text_dsp">Gifts Received</font></a></td>
					        </tr></table>
					    </div>
					</div>
			   	</div>
		   	</div>
		   	
		   	
      		<div class="row" style="margin-top: 10px; margin-bottom: 60px;">        
				<div class="col-md-12 col-sm-12">
					<table> <tr>
						<td align="right" style="position: relative; left: 130px;"><div class="number_circle_format"><div class="number_circle_format_value">${totalPendingFundsCount}</div></div></td>
						<td align="right" style="position: relative; left: 345px;"><div class="number_circle_format"><div class="number_circle_format_value">${totalClearedNotRequestedCount}</div></div></td>
						<td align="right" style="position: relative; left: 545px;"><div class="number_circle_format"><div class="number_circle_format_value">${totalTransferRequestedCount}</div></div></td>
						<td align="right" style="position: relative; left: 730px;"><div class="number_circle_format"><div class="number_circle_format_value">${totalTransferCompletedCount}</div></div></td>				        
					</tr></table>
					
					<table style="margin-top: 12px;"> <tr>
						<td><a href="adminCashFunds"><font  class="adm_cf_sub_header_black_text_dsp">Funds Pending</font></a></td>
						<td style="position: relative; left: 18px;"><a href="adminCashFundClearedNotRequested"><font class="adm_cf_sub_header_black_text_dsp">Cleared Not Requested</font></a></td>
						<td style="position: relative; left: 36px;"><a href="#"><font class="adm_cf_sub_header_red_text_dsp">Transfer Requested</font></a></td>
						<td style="position: relative; left: 54px;"><a href="adminCashFundTransferComplete"><font class="adm_cf_sub_header_black_text_dsp">Transfer Complete</font></a></td>				        
					</tr></table>					
			   	</div>		   	
		   	</div>
        
<!-- No Records in Cash FUnd Functionality -->
		<div class="row">
	        <div class="col-md-12 col-sm-12" id="notVisibleMyOrderId" style="display: none;">	        	        	

				<div class="row">
					<div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
						<div align="left">        			
							<div class="registry_prof_title top_adjustment_30"><p class="adm_cash_fund_no_data_text">You have not received any contributions towards any cash funds yet.</p></div>
				        </div>
				  	</div></div></div>
				</div>					
		
			</div>
		</div>
        
        
<!-- Cash FUnds Data Display Functionality -->

		<div class="row" id="visibleMyOrderId" style="display: none;">
			<div class="col-md-12 col-sm-12">				
			<form action="adminTransferCompleteCashFunds" method="POST" name="adminCashFundsName">					
				<div class="row" style="margin-top: 30px; padding: 10px;">
				<div class="col-md-1 col-sm-1">
					<div class="row">
						<div class="col-md-12 col-sm-12"></div>
					</div>
				</div>
				
				<div class="col-md-11 col-sm-11" style="border-bottom: 2px solid #999; padding-bottom: 10px;">
					<div class="row">
						<div class="col-md-2 col-sm-2">
							<div class="service-item">                        
								<div class="service-description">
							    	<div align="center" class="my_acc_room_cash_fund_hd_dsp">GIFT</div>
							   	</div> <!-- /.service-description -->
							</div> <!-- /.service-item -->               
						</div> <!-- /.col-md-2 -->
						
						<div class="col-md-2 col-sm-2"></div>
						
						<div class="col-md-2 col-sm-2">
							<div class="service-item">                        
								<div class="service-description">
							    	<div align="center" class="my_acc_room_cash_fund_hd_dsp">AMOUNT</div>
							   	</div> <!-- /.service-description -->
							</div> <!-- /.service-item -->               
						</div> <!-- /.col-md-2 -->
						
						<div class="col-md-2 col-sm-2">
							<div class="service-item">                        
								<div class="service-description">
							    	<div align="center" class="my_acc_room_cash_fund_hd_dsp">TO</div>
							   	</div> <!-- /.service-description -->
							</div> <!-- /.service-item -->               
						</div> <!-- /.col-md-2 -->
						
						<div class="col-md-2 col-sm-2">
							<div class="service-item">                        
								<div class="service-description">
							    	<div align="center" class="my_acc_room_cash_fund_hd_dsp">FROM</div>
							   	</div> <!-- /.service-description -->
							</div> <!-- /.service-item -->               
						</div> <!-- /.col-md-2 -->
						
						<div class="col-md-2 col-sm-2">
							<div class="service-item">                        
								<div class="service-description">
							    	<div align="center" class="my_acc_room_cash_fund_hd_dsp">DATE</div>
							   	</div> <!-- /.service-description -->
							</div> <!-- /.service-item -->               
						</div> <!-- /.col-md-2 -->					
				</div>
			</div>     				   
			</div> <!-- /.row -->	    
	                	
							   	       
<!-- Guest Cash Funds Coding -->
				 		
	 		<% 	String guestCashFundsPaymentInfo = (String)session.getAttribute("adminGuestTransferRequestedCashFunds");	 		
				if (null != guestCashFundsPaymentInfo) {					
					String[] guestCashFundsPaymentSt = guestCashFundsPaymentInfo.split("__");
					for (int i = 0; i < guestCashFundsPaymentSt.length; i++) {						
						String[] guestCashFundsPaymentStList = guestCashFundsPaymentSt[i].split(",_,");								
						String guestSpaceImage = guestCashFundsPaymentStList[0];
						String guestSpaceName = guestCashFundsPaymentStList[1];
						String guestSpacePrice = guestCashFundsPaymentStList[2];
						String guestFullName = guestCashFundsPaymentStList[3];
						String guestStDate = guestCashFundsPaymentStList[4];
						String guestCashFundId = guestCashFundsPaymentStList[5];
						String registyFullName = guestCashFundsPaymentStList[6];
						
			%>
				
			<div class="row">
			<div class="col-md-1 col-sm-1">
				<div class="row" style="padding: 20px 5px;">				
				<div class="col-md-1 col-sm-1">
					<div class="service-item">                        
						<div class="service-description">
						<div style="height: 120px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">
							<input type="radio" name="registryCashFundId" value="<%=guestCashFundId%>"> <input type="hidden" name="typeOfFundName" id="typeOfFundNameId<%=guestCashFundId%>" value="Guest Cash Fund">	
						</div></div>									 	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-1 -->
				</div>
			</div>
			
			<div class="col-md-11 col-sm-11">				
				<div class="row" style="border-bottom: 1px solid #999; padding: 20px 5px;">				
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img src="<%=guestSpaceImage%>" style="object-fit: scale-down; width: 120px;"></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->
					
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description" align="center">
							<div style="height: 120px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestSpaceName%></div></div>					    	
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->								
									
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=guestSpacePrice%></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->
					
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=registyFullName%></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->
					
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestFullName%></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->
					
					
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=guestStDate%></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->			
				</div>
				
			</div>					
			</div> <!-- /.row -->
				
			<% } } %>
			
			<%-- 	
			   	       
<!-- Registrant Cash Funds Coding -->
				 		
	 		<% 	String registrantCashFundsPaymentInfo = (String)session.getAttribute("adminRegistryTransferRequestedCashFunds");	 		
				if (null != registrantCashFundsPaymentInfo) {					
					String[] registrantCashFundsPaymentSt = registrantCashFundsPaymentInfo.split("__");
					for (int i = 0; i < registrantCashFundsPaymentSt.length; i++) {						
						String[] registrantCashFundsPaymentStList = registrantCashFundsPaymentSt[i].split(",_,");								
						String regiSpaceImage = registrantCashFundsPaymentStList[0];
						String regiSpaceName = registrantCashFundsPaymentStList[1];
						String regiSpacePrice = registrantCashFundsPaymentStList[2];
						String regiFullName = registrantCashFundsPaymentStList[3];
						String regiStDate = registrantCashFundsPaymentStList[4];
						String regiCashFundId = registrantCashFundsPaymentStList[5];
						
			%>
					
			<div class="row">
			<div class="col-md-1 col-sm-1">
				<div class="row" style="padding: 20px 5px;">				
				<div class="col-md-1 col-sm-1">
					<div class="service-item">                        
						<div class="service-description">
						<div style="height: 120px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">
							<input type="radio" name="registryCashFundId" value="<%=regiCashFundId%>"> <input type="hidden" name="typeOfFundName" id="typeOfFundNameId<%=regiCashFundId%>" value="Registry Cash Fund">
						</div></div>										 	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-1 -->
				</div>
			</div>
			
			<div class="col-md-11 col-sm-11">				
				<div class="row" style="border-bottom: 1px solid #999; padding: 20px 5px;">				
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><img src="<%=regiSpaceImage%>" style="object-fit: scale-down; width: 120px;"></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->
					
					<div class="col-md-3 col-sm-3">
						<div class="service-item">                        
							<div class="service-description" align="center">
							<div style="height: 120px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiSpaceName%></div></div>					    	
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-3 -->								
									
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div class="my_acc_room_fund_bold_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);">$&nbsp;<%=regiSpacePrice%></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->
					
					<div class="col-md-3 col-sm-3">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiFullName%></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-3 -->
					
					<div class="col-md-2 col-sm-2">
						<div class="service-item">                        
							<div class="service-description">
						    	<div style="height: 120px;"><div class="my_acc_room_fund_text_dsp" style="position: relative; float: left; top: 50%; left: 50%; transform: translate(-50%, -50%);"><%=regiStDate%></div></div>
						   	</div> <!-- /.service-description -->
						</div> <!-- /.service-item -->               
					</div> <!-- /.col-md-2 -->			
				</div>
				
			</div>					
			</div> <!-- /.row -->
				
				
			<% } } %>
			 --%>
			
			<div class="row top_adjustment_60">        		
				<div class="col-md-12 col-sm-12 text-center">
					<h4><button class="adm_sub_cash_fund_sub_butt" id="viewClientId" onclick="return cashFundsInfoViewDetails();">View Details</button></h4> 
				</div>
			</div>
			<input type="hidden" name="typeOfCashFundName">
			</form>							
			</div>
			
			
		</div>
		        
        
		</div> </div>		     
		</body>
</html>