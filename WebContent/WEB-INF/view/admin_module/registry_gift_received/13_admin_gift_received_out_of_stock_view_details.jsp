
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<style type="text/css">
	.admin_gr_left_text_dsp { font: 500 1.5em/1.75em Georgia; letter-spacing: 1px; color: black; text-align: right; }
	.admin_gr_right_text_dsp { font: bold 1.35em/1.8em Georgia; letter-spacing: 1px; color: black; text-align: left; left: 10px; position: relative; }
	
	.reg_add_bank_acc_saving_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; padding: 10px 40px; outline: none; border: none; font: 500 1.4em/1.15em Georgia; letter-spacing: 3px;  box-shadow: 2px 3px #888888; }
	.reg_add_bank_acc_saving_subt_Btn:hover { background-color: #2c2c2c; }
	
	a.admin_prod_link_cl { color : #12528e; text-decoration: none; }
	a.admin_prod_link_cl:hover { color : red;}
	</style>
	
	<script type="text/javascript">
 	$(document).ready(function() {
 		var cbIndividualProductQuantity1 = "<c:out value="${cbIndividualProductQuantity}"/>";
 		if(cbIndividualProductQuantity1 === "") {
	    	$("#contributedQuantityId").hide();	    	
	    } else {
	    	$("#contributedQuantityId").show(); 	
	    } 
 		
 		var cbIndividualProductLink1 = "<c:out value="${cbIndividualProductLink}"/>";
 		var productLinkValue = cbIndividualProductLink1.substring(0, 30) + "...";
 		$("#productLinkValueId").html(productLinkValue);
 	}); 	
    </script>
		
	</head>
	
		<body>
				
		<div id="mainframe" class="section-content">
        <div class="container">
      
      	<div class="row">
	        <div class="col-md-1 col-sm-1"></div>
	
			<div class="col-md-10 col-sm-10"style="border: 2px solid #41719c; padding: 30px;">
				
				<div class="row">
					
					<table style="margin-top: 20px; margin-left: 30px;"> <tbody>
						<tr> <td class="admin_gr_left_text_dsp"> Product Name: </td>  <td class="admin_gr_right_text_dsp"> ${cbIndividualProductName} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Store: </td>  <td class="admin_gr_right_text_dsp"> ${cbIndividualProductStore} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Selected Option: </td>  <td class="admin_gr_right_text_dsp"> ${cbIndividualProductHeading} </td> </tr>
						<tr style="display: none;" id="contributedQuantityId"> <td class="admin_gr_left_text_dsp"> Quantity: </td>  <td class="admin_gr_right_text_dsp"> ${cbIndividualProductQuantity} </td> </tr>
						<tr style="height: 20px;"> <td> </td>  <td> </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Price: </td>  <td class="admin_gr_right_text_dsp"> ${cbIndividualProductPrice} </td> </tr>
						<tr style="height: 20px;"> <td> </td>  <td> </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Link: </td>  <td class="admin_gr_right_text_dsp"> <a target="_blank" class="admin_prod_link_cl" href="${cbIndividualProductLink}"> <font id="productLinkValueId"></font> </a> </td> </tr>
						<tr style="height: 20px;"> <td> </td>  <td> </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Name: </td>  <td class="admin_gr_right_text_dsp"> ${registrantFullName} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Shipping Address: </td>  <td class="admin_gr_right_text_dsp"> ${registrantShippingAddress} ${registrantApartment}, ${registrantCity}, ${registrantState}, ${registrantZip}. </td> </tr>
						
						<tr> <td class="admin_gr_left_text_dsp"> Contact number: </td>  <td class="admin_gr_right_text_dsp"> ${registrantPhoneNumber} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Email: </td>  <td class="admin_gr_right_text_dsp"> ${registrantEmail} </td> </tr>
						
					</tbody> </table>
					
					<div style="margin-top: 60px; margin-bottom: 50px;" align="center">
					<table> <tbody>
						<tr>
							<td><form action="adminGiftsReceivedOutOfStock"><div align="left" style="margin-left: 15px;"><button class="reg_add_bank_acc_saving_subt_Btn" id="cfBankInfoSavingButtId">Back to Out of Stock</button></div> </form></td>
							
						</tr>
					</tbody></table>
					</div>
					
					
					
					
						
				</div>			
			</div>
			
			<div class="col-md-1 col-sm-1"></div>
		</div>	        
        		
		</div> </div>		     
		</body>
</html>