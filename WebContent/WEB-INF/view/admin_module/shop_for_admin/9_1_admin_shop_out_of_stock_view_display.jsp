
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<style type="text/css">
	.admin_gr_left_text_dsp { font: 500 1.5em/1.75em Georgia; letter-spacing: 1px; color: black; text-align: right; }
	.admin_gr_right_text_dsp { font: bold 1.35em/1.8em Georgia; letter-spacing: 1px; color: black; text-align: left; left: 10px; position: relative; }
	
	.reg_add_bank_acc_saving_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #f2f2f2; color: black; display: inline-block; padding: 10px 40px; outline: none; border: none; font: 500 1.4em/1.15em Georgia; letter-spacing: 3px; box-shadow: 3px 3px 3px #c5c5c5; }
	.reg_add_bank_acc_saving_subt_Btn:hover { background-color: #ff3b3b; color: white; }
	
	a.admin_prod_link_cl { color : #12528e; text-decoration: none; }
	a.admin_prod_link_cl:hover { color : red;}
	
	.admin_shop_product_image { outline: none; width: 250px; height: 100%; object-fit: scale-down; position: relative; object-position: 50% 50%; }
	</style>
	
	<script type="text/javascript">
 	$(document).ready(function() { 		
 		var shopStoreUrl1 = "<c:out value="${shopStoreUrl}"/>";
 		var productLinkValue = shopStoreUrl1.substring(0, 30) + "...";
 		$("#productLinkValueId").html(productLinkValue);
 	}); 	
    </script>
	
	</head>
	
		<body>
				
		<div id="mainframe" class="section-content">
        <div class="container">
      
      	<div class="row">
	        
			<div class="col-md-12 col-sm-12"style="border: 2px solid #41719c; padding: 40px;">				
				<div class="row">
					<div class="col-md-9 col-sm-9">
					<table style="margin-top: 30px; margin-left: 30px;"> <tbody>
						<tr> <td class="admin_gr_left_text_dsp"> Product Name: </td>  <td class="admin_gr_right_text_dsp"> ${shopProductName} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Store: </td>  <td class="admin_gr_right_text_dsp"> ${shopStoreName} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Selected Option: </td>  <td class="admin_gr_right_text_dsp"> ${shopProductSize} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Quantity: </td>  <td class="admin_gr_right_text_dsp"> ${shopQuantity} </td> </tr>
						<tr style="height: 20px;"> <td> </td>  <td> </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Price: </td>  <td class="admin_gr_right_text_dsp"> ${shopProductPrice} </td> </tr>
						<tr style="height: 20px;"> <td> </td>  <td> </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Link: </td>  <td class="admin_gr_right_text_dsp"> <a target="_blank" class="admin_prod_link_cl" href="${shopStoreUrl}"> <font id="productLinkValueId"></font> </a> </td> </tr>
						<tr style="height: 20px;"> <td> </td>  <td> </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Name: </td>  <td class="admin_gr_right_text_dsp"> ${shopShipFullName} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Shipping Address: </td>  <td class="admin_gr_right_text_dsp"> ${shopShippingAddress} </td> </tr>
						
						<tr> <td class="admin_gr_left_text_dsp"> Contact number: </td>  <td class="admin_gr_right_text_dsp"> ${shopUserPhoneNumber} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Email: </td>  <td class="admin_gr_right_text_dsp"> ${shopUserEmail} </td> </tr>
						
					</tbody> </table>
					</div>
					<div class="col-md-3 col-sm-3">
						<img class="admin_shop_product_image" src="data:image/jpg;base64,${shopProductImage}">
					</div>
				</div>					
					
				<div class="col-md-12 col-sm-12">
					<div style="margin-top: 50px; margin-bottom: 40px;" align="center">
						<table> <tbody>
							<tr>
								<td><form action="adminShopOutOfStock"><div align="left" style="margin-left: 15px;"><button class="reg_add_bank_acc_saving_subt_Btn" id="cfBankInfoSavingButtId">Back Move</button></div> <input type="hidden" name="shopCBProductsManagementId" value="${shopCBProductsManagementId}"> </form></td>
							</tr>
						</tbody></table>
					</div>
						
				</div>			
			</div>
						
		</div>	        
        		
		</div> </div>		     
		</body>
</html>