<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="images/ico/favicon.ico" type="image/x-icon">
	
    <script type="text/javascript">
    $(document).ready(function(){    	        
    	var totalPrice = '<c:out value="${guestTotalAmount}"/>';
 	    var formatPrice = totalPrice.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
 	    $("#totalFundsPriceId").html(formatPrice);
 	    
 		var cashFundUploadImg1 = "<c:out value="${cashFundUploadImg}"/>";
 		var cashFundName1 = "<c:out value="${cashFundName}"/>";
 		
 		if(cashFundUploadImg1 !== ""){
 	    	$("#newUploadImage").show();
 	    	$("#oldUploadImage").hide();
 	    	$("#newSmallUploadImage").show();
 	    	$("#oldSmallUploadImage").hide();
 	    }
 		 		
 		if(cashFundName1 !== ""){
 			$("#fundNameNew").show();
 	    	$("#fundNameOld").hide();
 		} else {
 			$("#fundNameOld").show();
 	    	$("#fundNameNew").hide();
 		}
 		
 		var fullRoomDesignDisplay = "<c:out value="${guestFullRoomCount}"/>";
 		if(fullRoomDesignDisplay !== ""){
 			$("#fullRoomDesignDisplayId").show();
 		} else {
 			$("#fullRoomDesignDisplayId").hide();
 		}

 		var accDesignDisplay = "<c:out value="${guestAccPackCount}"/>";
 		if(accDesignDisplay !== ""){
 			$("#accDesignDisplayId").show();
 		} else {
 			$("#accDesignDisplayId").hide();
 		}

 		var cashFundDisplay = "<c:out value="${guestCashFundPrice}"/>";
 		if(cashFundDisplay !== ""){
 			$("#cashFundDisplayId").show();
 		} else {
 			$("#cashFundDisplayId").hide();
 		}
    });

    </script>
    
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
         
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="adm_new_cl_head_txt_dsp" align="left">REVIEW &amp; PLACE ORDER:</div>
        </div>
                
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
         
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 -->
        <div class="col-md-3 col-sm-3" style="border-right: 1px solid black;">
        <div class="adm_reg_paym_hd_txt_dsp">BILLING INFO</div>        
        <div class="adm_reg_paym_txt_dsp">${guestBillFullName}</div>
        <div class="adm_reg_paym_txt_dsp">${guestPayAddress}</div>
        <div class="adm_reg_paym_txt_dsp">${guestStAddress}</div>
        <div class="adm_reg_paym_txt_dsp">${guestCountry}</div>       
        <div class="adm_reg_paym_txt_dsp">${guestBillPhNumber}</div>
        </div>
        
        <div class="col-md-3 col-sm-3" style="border-right: 1px solid black;">
        <div style="margin-left: 10px;">
        <div class="adm_reg_paym_hd_txt_dsp">PAYMENT METHOD</div>        
        <div class="adm_reg_paym_txt_dsp">${guestNameOnCard}</div>
        <div class="adm_reg_paym_txt_dsp">${guestAccountType}</div>
        <div class="adm_reg_paym_txt_dsp">${guestPayCardNumber}</div>
        <div class="adm_reg_paym_txt_dsp">${guestPayExpDate}</div>
        <div class="adm_reg_paym_txt_dsp">&nbsp;&nbsp;</div>
        </div> 
        </div> 
        <div class="col-md-4 col-sm-4" style="border-left: 1px solid black; margin-left: -1px;">
        <div style="margin-left: 10px;">
        <div class="adm_reg_paym_hd_txt_dsp">GIFT MESSAGE</div>        
        <div class="adm_reg_paym_txt_dsp">${guestMessage}</div>
        </div> 
        </div>         
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        
        <div class="row">
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 -->
        <div class="col-md-10 col-sm-10">               
        <div style="border-bottom: 1px dotted #999; width: auto; margin-top: 25px; margin-bottom: 25px;"></div>
        <div class="adm_reg_paym_hd_txt_dsp">PAYMENT OUTPUT</div> 
        </div>         
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 -->
        <div class="col-md-3 col-sm-3" style="border-right: 1px solid black;">
        <div class="adm_reg_paym_txt_dsp">Transaction Number: <br>${guestTransactionNo}</div>
        </div>
        
        <div class="col-md-3 col-sm-3" style="border-right: 1px solid black;">
        <div style="margin-left: 10px;">
        <div class="adm_reg_paym_txt_dsp">Authorization Code: <br>${guestAuthorizeCode}</div>
        </div> 
        </div> 
        <div class="col-md-4 col-sm-4" style="border-left: 1px solid black; margin-left: -1px;">
        <div style="margin-left: 10px;">
        <div class="adm_reg_paym_txt_dsp">Payment Status: <br>${guestCheckoutPaymentSt}</div>
        </div> 
        </div>         
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        
        <div class="row">
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 -->
        <div class="col-md-10 col-sm-10">               
        <div style="width: auto; margin-top: 20px; margin-bottom: 20px;"></div>
        <div class="adm_reg_paym_hd_txt_dsp">ORDER DETAILS</div> 
        </div>         
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 -->
        <div class="col-md-10 col-sm-10">
        
        
<!-- Cart Sub Heading -->
	 		<div class="row top_adjustment_10" style="padding: 20px;">
	        	<div class="col-md-4 col-sm-4">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center" class="red_my_cart_for_guest_suht_dsp">FUND</div>
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-4 -->
				
				<div align="left" class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description">					    	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				
				<div class="col-md-2 col-sm-2"></div>
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center" class="red_my_cart_for_guest_suht_dsp">CONTRIBUTION</div>
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->					
			        
			</div> <!-- /.row -->	    
	        			
	        <div class="row"><div class="red_my_cart_for_guest_div_bar"></div></div>
	        
        	 		
	 		<% 	String regSelSpaceAllInfo = (String)session.getAttribute("guestSelSpaceAllInfoInSn");	
				if (null != regSelSpaceAllInfo) {
					String[] regSelSpaceAllInfoList = regSelSpaceAllInfo.split("__");
					for (int i = 0; i < regSelSpaceAllInfoList.length; i++) {
						String[] regSelSpaceInfoList = regSelSpaceAllInfoList[i].split(",_,");
						String spaceImage = regSelSpaceInfoList[0];
						String spaceName = regSelSpaceInfoList[1];
						String spacePrice = regSelSpaceInfoList[2];
						String spaceColName = regSelSpaceInfoList[3];
						String spaceColCount = regSelSpaceInfoList[4];
			%>
				<div class="row red_cart_guest_sub_div_bar">
	        	<div class="col-md-4 col-sm-4">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center"><img src="<%=spaceImage%>" style="margin-top: 0px;"></div>
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-4 -->
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description" align="center">
						<div style="height: 65px; border: 1px solid white;"><div class="shop_cart_rn_text_dsp"><%=spaceName%></div></div>					    	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				
				<div class="col-md-2 col-sm-2"></div>
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center" class="red_my_cart_for_guest_reg_amt_dsp top_adjustment_10">$&nbsp;<%=spacePrice%></div>					    	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				</div> <!-- /.row -->
				
				<% } } %>
									
					       
<!-- Full Room Cart Sub Heading -->			
				<div class="row red_cart_guest_sub_div_bar" id="fullRoomDesignDisplayId" style="display: none;">
	        	<div class="col-md-4 col-sm-4">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center"><img src="resources/images/registry/reg_guest_img/reg_full_room_big_img.png" style="margin-top: 0px;"></div>
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-4 -->
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description" align="center">
						<div style="height: 65px; border: 1px solid white;"><div class="shop_cart_rn_text_dsp">FULL ROOM DESIGN PACKAGE</div></div>					    	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				
				<div class="col-md-2 col-sm-2"></div>
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center" class="red_my_cart_for_guest_reg_amt_dsp top_adjustment_10">&nbsp;&nbsp;&nbsp;$&nbsp;185/<font style="color: #696969;">${guestFullRoomCount}</font></div>					    	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				</div> <!-- /.row -->
					       
<!-- Acc Pack Cart Sub Heading -->			
				<div class="row red_cart_guest_sub_div_bar" id="accDesignDisplayId" style="display: none;">
	        	<div class="col-md-4 col-sm-4">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center"><img src="resources/images/registry/reg_guest_img/reg_acc_pack_big_img.png" style="margin-top: 0px;"></div>
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-4 -->
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description" align="center">
						<div style="height: 65px; border: 1px solid white;"><div class="shop_cart_rn_text_dsp">ACCESSORIES PACKAGE</div></div>					    	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				
				<div class="col-md-2 col-sm-2"></div>
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center" class="red_my_cart_for_guest_reg_amt_dsp top_adjustment_10">&nbsp;$&nbsp;85/<font style="color: #696969;">${guestAccPackCount}</font></div>
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				</div> <!-- /.row -->
						   				   
<!-- Cash Fund Cart Sub Heading -->			
				<div class="row red_cart_guest_sub_div_bar" id="cashFundDisplayId" style="display: none;">
	        	<div class="col-md-4 col-sm-4">
					<div class="service-item">                        
						<div class="service-description">
						<div id="oldSmallUploadImage" align="center"><img src="resources/images/registry/reg_guest_img/guest_cash_fund_img.png" width="70" height="65" style="margin-top: 0px;"></div>							
							<div id="newSmallUploadImage" align="center" style="display: none;"><img src="data:image/jpg;base64,<c:out value='${cashFundUploadImg}'/>" height="65" width="130" style="margin-top: 0px;"></div>
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-4 -->
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description" align="center">
						<div style="height: 65px; border: 1px solid white;">
						<div align="center" class="shop_cart_rn_text_dsp" id="fundNameOld">OUR DREAM ADVENTURE</div>
				        <div align="center" class="shop_cart_rn_text_dsp" style="display: none;" id="fundNameNew"><c:out value='${cashFundName}'/></div></div>					    	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				
				<div class="col-md-2 col-sm-2"></div>
				
				<div class="col-md-3 col-sm-3">
					<div class="service-item">                        
						<div class="service-description">
					    	<div align="center" class="red_my_cart_for_guest_reg_amt_dsp top_adjustment_10">$&nbsp;${guestCashFundPrice}</div>
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-3 -->
				</div> <!-- /.row -->
        
        	
<!-- Cart Total Value Code -->

	 		<div class="row top_adjustment_30">
	        	<div class="col-md-1 col-sm-1">					            
				</div> <!-- /.col-md-7 -->
				<div class="col-md-6 col-sm-6">
				<form action="adminGuestUserPayment" method="get">
	                <h4><input class="back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png" style="position: relative; left: 8px; top: 15px;"></h4>
	            </form>					            
				</div> <!-- /.col-md-6 -->
				
				<div class="col-md-5 col-sm-5">
					<div class="service-item">                        
						<div align="right" class="service-description" style="background: #e7e6e6; padding: 20px; border: 1px solid #dddbdb;">
					    	<table style="position: relative; left: -30px;"><tr><td><font class="red_my_cart_gst_val_dsp">&nbsp;SUBTOTAL:&nbsp;</font></td> <td><font class="red_my_cart_for_guest_reg_amt_dsp">$&nbsp;<font id="totalFundsPriceId"></font></font></td></tr></table>					    	
					   	</div> <!-- /.service-description -->
					</div> <!-- /.service-item -->               
				</div> <!-- /.col-md-5 -->									        
			</div> <!-- /.row -->
			
                
        </div> 
        <div class="col-md-1 col-sm-1"></div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
                           
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                
           	
		</body>
</html>