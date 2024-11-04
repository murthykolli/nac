
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<style type="text/css">
	.admin_gr_left_text_dsp { font: 500 1.5em/1.75em Georgia; letter-spacing: 1px; color: black; text-align: right; }
	.admin_gr_right_text_dsp { font: bold 1.35em/1.8em Georgia; letter-spacing: 1px; color: black; text-align: left; left: 10px; position: relative; }
	.tracking_text_area_box_dsp { border: 2px solid #41719c; background: #F2F2F2; width: 600px; letter-spacing: 1px; color: black; font: 1.0em/1.25em Georgia; box-shadow: 1px 1px 2px #bcbcbc; padding: 8px 12px; }
	
	.shop_admin_sub_menu_btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #f2f2f2; color: black; display: inline-block; padding: 10px 50px; outline: none; border: none; font: 500 1.4em/1.15em Georgia; letter-spacing: 3px;  box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.shop_admin_sub_menu_btn:hover { background-color: #ff3b3b; color: white; }
	
	a.admin_prod_link_cl { color : #12528e; text-decoration: none; }
	a.admin_prod_link_cl:hover { color : red;}
	</style>
			
	<script type="text/javascript">
 	$(document).ready(function() {
 		var urlRegExp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
 		
 		$("#adminShopTrackingSavingButtId").click(function (){
 		var result = true;
 		if($("#adminShopTrackingLinkURLId").val() !== ""){ $("#adminShopTrackingLinkURLId").css("border-color","#41719c");
	    } else{ $("#adminShopTrackingLinkURLId").css("border-color","red"); result = false; }

	    return result;
	    });

 	 	$("#adminShopTrackingLinkURLId").keyup(function(){ 	
 	 	if(urlRegExp.test(this.value)){ $("#adminShopTrackingLinkURLId").css("border-color","#41719c");
 	    } else{ $("#adminShopTrackingLinkURLId").css("border-color","red"); return false; } 	
 	 	});
	     	    
 	});
    </script>
	
	</head>
	
		<body>
				
		<div id="mainframe" class="section-content">
        <div class="container">
      
      	<div class="row">
	        <div class="col-md-1 col-sm-1"></div>
	
			<div class="col-md-10 col-sm-10" style="border: 2px solid #41719c; padding: 40px;">
				
				<div class="row">
					<form action="adminShopTrackingLinkUpdate">
					<table style="margin-top: 30px; margin-left: 30px;"> <tbody>
						<tr> <td class="admin_gr_left_text_dsp" style="top: 62px; position: relative;"> Tracking Link: </td>  <td class="admin_gr_right_text_dsp"> <div><textarea name="adminShopTrackingLinkURL" id="adminShopTrackingLinkURLId" style="height: 120px;" class="tracking_text_area_box_dsp"></textarea></div></td> </tr>
						
						
					</tbody> </table>
					
					<div style="margin-top: 60px; margin-bottom: 50px;" align="center">
					<table> <tbody>
						<tr>
							<td><div align="left" style="margin-left: -20px;"><a href="adminShopOrdered"> <img src="resources/images/backButton.png" style="position: relative; top: 3px;"> </a></div></td>
							<td><div align="left" style="margin-left: 15px;"><button class="shop_admin_sub_menu_btn" id="adminShopTrackingSavingButtId">Save</button></div> </td>
						</tr>
					</tbody></table>
					<input type="hidden" name="shopCBProductsManagementId" value="${shopCBProductsManagementId}">
					</div>
					</form>
						
				</div>			
			</div>
			
			<div class="col-md-1 col-sm-1"></div>
		</div>	        
        		
		</div> </div>		     
		</body>
</html>