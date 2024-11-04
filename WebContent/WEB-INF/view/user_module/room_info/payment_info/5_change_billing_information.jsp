<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon"> 
    <script type="text/javascript" src="resources/js/shipping_billing_validation.js" ></script>
    
	
	<script type="text/javascript">
	var produtValue;
    $(document).ready(function(){
    
    var billFullName1 = '<c:out value="${billFullName}"/>';
    var billAddress01 = '<c:out value="${billAddress1}"/>';
    var billAddress02 = '<c:out value="${billAddress2}"/>';
    var billCity1 = '<c:out value="${billCity}"/>';
    var billState1 = '<c:out value="${billState}"/>';
    var billZip1 = '<c:out value="${billZip}"/>';    
    var billPhNumber1 = '<c:out value="${billPhNumber}"/>';
        
    $("[name=billFullName]").val(billFullName1);
    $("[name=billAddress1]").val(billAddress01);
    $("[name=billAddress2]").val(billAddress02);
    $("[name=billCity]").val(billCity1);
    $("[name=billState]").val(billState1);
    $("[name=billZip]").val(billZip1);    
    $("[name=billPhNumber]").val(billPhNumber1);
      	
    });    
	</script>
	</head>
		
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        <div class="row">
        
        <div class="col-md-3 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
			        
			       
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->            
                
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">            	
			        <div align="center" class="bill_frame_disply">
			        <div align="right" class="bill_close_but_disp"><a href="changeAllInfosCloseBut"><img src="resources/images/close.png"></a></div>
			        
			        <form action="changeBillingInfoSaving" method="post">
			        <table class="billing_tbl_fld_disp">
			        	<tr>
			        		<td class="billing_info_hd_disp">BILLING ADDRESS:</td>
			        	</tr>
			        	<tr>
			        		<td class="shoop_text_dsp">FULL NAME:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="billFullName" id="billFullNameId" class="shpp_inp_box_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">ADDRESS 1:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="billAddress1" id="billAddress1Id" class="shpp_inp_box_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">ADDRESS 2:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="billAddress2" id="billAddress2Id" class="shpp_inp_box_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">CITY:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="billCity" id="billCityId" class="shpp_inp_box_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">STATE:</td> <td class="shoop_text_dsp"><font class="shoop_text_zip_dsp">ZIP:</font></td>
			        	</tr>
			        	<tr>
			        		<td><select name="billState" id="billStateId" class="shpp_inp_box_state"> <option value="">------State Name------</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select></td> 
			        		
			        		<td><input type="text" name="billZip" maxLength="5" id="billZipId" class="shpp_inp_box_zip" onkeypress="return numeralsOnly(event);"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">COUNTRY:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="billCountry" id="billCountryId" value="UNITED STATES" class="shpp_inp_box_country_dsp"></td>
			        	</tr>
			        	
			        	<tr>
			        		<td class="shoop_text_dsp">PHONE NUMBER:</td>
			        	</tr>
			        	<tr>
			        		<td><input type="text" name="billPhNumber" maxLength="12" id="billPhNumberId" class="shpp_inp_box_dsp" onchange="return phoneFormat (event,billPhNumberId);" onkeydown="return numeralsOnly(event);" onkeyup="return phoneFormat (event,billPhNumberId)" onkeypress="return numeralsOnly(event);"></td>
			        	</tr>
			        </table>
			        <div class="top_adjustment_40"><h4><button class="continue_submit_Btn" id="changeBillingButtId">SAVE</button></h4></div>
			        </form>
			        </div>
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        
        <div class="col-md-3 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
			        
			       
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		</div> <!-- /.row -->
		
		
		
		
		
		      
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
    	    	
		</body>
</html>