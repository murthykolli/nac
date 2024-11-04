
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<style type="text/css">
	.admin_gr_left_text_dsp { font: 500 1.5em/1.75em Georgia; letter-spacing: 1px; color: black; text-align: right; }
	.admin_gr_right_text_dsp { font: bold 1.35em/1.8em Georgia; letter-spacing: 1px; color: black; text-align: left; left: 10px; position: relative; }
	
	a.admin_prod_link_cl { color : #12528e; text-decoration: none; }
	a.admin_prod_link_cl:hover { color : red;}
	.back_order_text_area_box_dsp { border: 2px solid #41719c; background: #F2F2F2; width: 400px; letter-spacing: 1px; color: black; font: 0.80em/1.15em Georgia; box-shadow: 1px 1px 2px #bcbcbc; padding: 8px 12px; }
	
	.back_order_saving_subt_btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #f2f2f2; color: black; display: inline-block; padding: 5px 20px; outline: none; border: none; font: 500 1.15em/1.15em Georgia; letter-spacing: 2px; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.back_order_saving_subt_btn:hover { background-color: #ff3b3b; color: white; }
	.rg_billing_bm_num_text_dis { font: 500 1.25em/1.25em Georgia; letter-spacing: 2px; color: black; text-align: right; text-transform: uppercase; }
	
	.shop_admin_sub_menu_btn { font: 500 1.6em/1.5em Georgia;  vertical-align: middle; background-color: #f2f2f2; color: black; display: inline-block; padding: 8px 40px;  outline: none; border: none; letter-spacing: 3px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.shop_admin_sub_menu_btn:hover { background-color: #ff3b3b; color: white; }
	</style>
			
	<script type="text/javascript">
 	$(document).ready(function() {
 		var urlRegExp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
 		
 		$("#shopBackOrderSavingButtId").click(function (){
 		var result = true;
 		if($("#shopBackOrderedTextId").val() !== ""){ $("#shopBackOrderedTextId").css("border-color","#41719c");
	    } else{ $("#shopBackOrderedTextId").css("border-color","red"); result = false; }

	    return result;
	    });

 	 	$("#shopBackOrderedTextId").keyup(function(){ 	
 	 	if(this.value !== ""){ $("#shopBackOrderedTextId").css("border-color","#41719c");
 	    } else{ $("#shopBackOrderedTextId").css("border-color","red"); return false; } 	
 	 	});
 	 	
 	   	var shopBackOrderedText1 = "<c:out value="${shopBackOrderedText}"/>";
 	   	$("[name=shopBackOrderedText]").val(shopBackOrderedText1);

 	 	var len = shopBackOrderedText1.length;
 	 	if (len >= 303) {
 	    	val.value = val.value.substring(0, 300);
 	  	} else {
 	    	$('#decCharNum').text(300 - len);
 	        $('#incCharNum').text(0 + len);
 	        $('#rowHideId').hide();
 	        $('#rowShowId').show();
 		}

 		var shopStoreUrl1 = "<c:out value="${shopStoreUrl}"/>";
 		var productLinkValue = shopStoreUrl1.substring(0, 30) + "...";
 		$("#productLinkValueId").html(productLinkValue);
 	 	 	    
 	});
    </script>
       
	<script>
      function countChar(val) {
        var len = val.value.length;        
        if (len >= 303) {
          val.value = val.value.substring(0, 300);
        } else {
          $('#decCharNum').text(300 - len);
          $('#incCharNum').text(0 + len);
          $('#rowHideId').hide();
          $('#rowShowId').show();
        }
      };
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
						<tr> <td class="admin_gr_left_text_dsp"> Product Name: </td>  <td class="admin_gr_right_text_dsp"> ${shopProductName} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Store: </td>  <td class="admin_gr_right_text_dsp"> ${shopStoreName} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Selected Option: </td>  <td class="admin_gr_right_text_dsp"> ${shopProductSize} </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Quantity: </td>  <td class="admin_gr_right_text_dsp"> ${shopQuantity} </td> </tr>
						<tr style="height: 20px;"> <td> </td>  <td> </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Price: </td>  <td class="admin_gr_right_text_dsp"> ${shopProductPrice} </td> </tr>
						<tr style="height: 20px;"> <td> </td>  <td> </td> </tr>
						<tr> <td class="admin_gr_left_text_dsp"> Link: </td>  <td class="admin_gr_right_text_dsp"> <a target="_blank" class="admin_prod_link_cl" href="${shopStoreUrl}"> <font id="productLinkValueId"></font> </a> </td> </tr>
						
					</tbody> </table>
					
					<form action="adminShopBackOrderedTextUpdate">
					<table style="margin-top: 20px; margin-left: 135px;"> <tbody>
						<tr> <td class="admin_gr_left_text_dsp"> <textarea name="shopBackOrderedText" placeholder="Text Box ..." id="shopBackOrderedTextId" maxLength="300" style="height: 100px;" class="back_order_text_area_box_dsp" onkeyup="countChar(this)"></textarea> </td>  
						<td class="admin_gr_right_text_dsp"><button class="back_order_saving_subt_btn" id="shopBackOrderSavingButtId" style="position: relative; left: 10px; top: 85px;">Save</button></td> </tr>
						
						<tr id="rowShowId" style="display: none;"><td style="padding: 5px;" class="rg_billing_bm_num_text_dis"><font id="incCharNum"></font> / <font id="decCharNum"></font></td></tr>
					    <tr id="rowHideId"><td style="padding: 5px;" class="rg_billing_bm_num_text_dis">0/300</td></tr>						
					</tbody> </table>
					<input type="hidden" name="shopCBProductsManagementId" value="${shopCBProductsManagementId}">
					</form>
					
					<div style="margin-top: 60px; margin-bottom: 50px;" align="center">
					<table> <tbody>
						<tr>
							<td><div align="left" style="margin-left: -20px;"><a href="adminShopBackOrdered"> <img src="resources/images/backButton.png" style="position: relative; top: 3px;"> </a></div></td>
							<td><form action="adminShopBackOrderedModifyDate"><div align="left" style="margin-left: 18px;"><button class="shop_admin_sub_menu_btn" id="cfBankInfoSavingButtId">Modify Date</button></div> <input type="hidden" name="shopCBProductsManagementId" value="${shopCBProductsManagementId}"> </form></td>
							<td><form action="adminShopBackInStockStatusUpdate"><div align="left" style="margin-left: 23px;"><button class="shop_admin_sub_menu_btn" id="cfBankInfoSavingButtId">Back In Stock</button></div> <input type="hidden" name="shopCBProductsManagementId" value="${shopCBProductsManagementId}"> </form></td>
							<td><form action="adminShopOutOfStockStatusUpdate"><div align="left" style="margin-left: 23px;"><button class="shop_admin_sub_menu_btn" id="cfBankInfoSavingButtId">Out of Stock</button></div> <input type="hidden" name="shopCBProductsManagementId" value="${shopCBProductsManagementId}"> </form></td>
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