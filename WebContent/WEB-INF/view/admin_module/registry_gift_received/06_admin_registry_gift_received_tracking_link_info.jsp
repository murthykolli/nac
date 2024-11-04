
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
	
	.reg_add_bank_acc_saving_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; padding: 10px 40px; outline: none; border: none; font: 500 1.4em/1.15em Georgia; letter-spacing: 3px;  box-shadow: 2px 3px #888888; }
	.reg_add_bank_acc_saving_subt_Btn:hover { background-color: #2c2c2c; }
	
	a.admin_prod_link_cl { color : #12528e; text-decoration: none; }
	a.admin_prod_link_cl:hover { color : red;}
	</style>
			
	<script type="text/javascript">
 	$(document).ready(function() {
 		var urlRegExp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
 		
 		$("#adminGRTrackingSavingButtId").click(function (){
 		var result = true;
 		if($("#adminGRTrackingLinkURLId").val() !== ""){ $("#adminGRTrackingLinkURLId").css("border-color","#41719c");
	    } else{ $("#adminGRTrackingLinkURLId").css("border-color","red"); result = false; }

	    return result;
	    });

 	 	$("#adminGRTrackingLinkURLId").keyup(function(){ 	
 	 	if(urlRegExp.test(this.value)){ $("#adminGRTrackingLinkURLId").css("border-color","#41719c");
 	    } else{ $("#adminGRTrackingLinkURLId").css("border-color","red"); return false; } 	
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
					<form action="adminGRTrackingLinkUpdate">
					<table style="margin-top: 30px; margin-left: 30px;"> <tbody>
						<tr> <td class="admin_gr_left_text_dsp" style="top: 62px; position: relative;"> Tracking Link: </td>  <td class="admin_gr_right_text_dsp"> <div><textarea name="adminGRTrackingLinkURL" id="adminGRTrackingLinkURLId" style="height: 120px;" class="tracking_text_area_box_dsp"></textarea></div></td> </tr>
						
						
					</tbody> </table>
					
					<div style="margin-top: 60px; margin-bottom: 50px;" align="center">
					<table> <tbody>
						<tr>
							<td><div align="left" style="margin-left: -20px;"><a href="adminGiftsReceivedOrdered"> <img src="resources/images/backButton.png" style="position: relative; top: 3px;"> </a></div></td>
							<td><div align="left" style="margin-left: 15px;"><button class="reg_add_bank_acc_saving_subt_Btn" id="adminGRTrackingSavingButtId">Save</button></div> </td>
						</tr>
					</tbody></table>
					<input type="hidden" name="giftReceivedManagementId" value="${giftReceivedManagementId}">
					<input type="hidden" name="bothCBAndFTRefName" value="${bothCBAndFTRefName}">
					</div>
					</form>
						
				</div>			
			</div>
			
			<div class="col-md-1 col-sm-1"></div>
		</div>	        
        		
		</div> </div>		     
		</body>
</html>