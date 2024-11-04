
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/date_picker_min.js"></script>    
    <link rel="stylesheet" type="text/css" href="resources/css/date_picker.css" />
    
	<style type="text/css">
	.admin_gr_left_text_dsp { font: 500 1.5em/1.75em Georgia; letter-spacing: 1px; color: black; text-align: right; }
	.admin_gr_right_text_dsp { font: bold 1.35em/1.8em Georgia; letter-spacing: 1px; color: black; text-align: left; left: 10px; position: relative; }
	.tracking_text_area_box_dsp { border: 2px solid #41719c; background: #F2F2F2; width: 250px; letter-spacing: 1px; color: black; font: 1.0em/1.25em Georgia; box-shadow: 1px 1px 2px #bcbcbc; padding: 8px 12px; }
	
	.reg_add_bank_acc_saving_subt_Btn { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; padding: 10px 40px; outline: none; border: none; font: 500 1.4em/1.15em Georgia; letter-spacing: 3px;  box-shadow: 2px 3px #888888; }
	.reg_add_bank_acc_saving_subt_Btn:hover { background-color: #2c2c2c; }
	
	a.admin_prod_link_cl { color : #12528e; text-decoration: none; }
	a.admin_prod_link_cl:hover { color : red;}
	</style>
			
	<script type="text/javascript">
 	$(document).ready(function() {
 		
 		$("#adminGRBackOrderedDateButtId").click(function (){
 		var result = true;
 		if($("#adminGRBackOrderedDateId").val() !== ""){ $("#adminGRBackOrderedDateId").css("border-color","#41719c");
	    } else{ $("#adminGRBackOrderedDateId").css("border-color","red"); result = false; }

	    return result;
	    });

 	 	$("#adminGRBackOrderedDateId").keyup(function(){ 	
 	 	if(this.value !== ""){ $("#adminGRBackOrderedDateId").css("border-color","#41719c");
 	    } else{ $("#adminGRBackOrderedDateId").css("border-color","red"); return false; } 	
 	 	});
 	 	 	 	
 	    $(".datepicker").datepicker({minDate:0}); 
	     	    
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
					<form action="adminGRBackOrderedDateUpdate">
					<table style="margin-top: 30px; margin-left: 30px;"> <tbody>
						<tr> <td class="admin_gr_left_text_dsp" style="top: 0px; position: relative;"> Back Ordered Date: </td>  
						<td class="admin_gr_right_text_dsp"> <div><input type="text" name="adminGRBackOrderedDate" readonly id="adminGRBackOrderedDateId" style="height: 30px;" class="datepicker tracking_text_area_box_dsp"></div></td> </tr>
						
						
					</tbody> </table>
					
					<div style="margin-top: 60px; margin-bottom: 50px;" align="center">
					<table> <tbody>
						<tr>
							<td><div align="left" style="margin-left: -20px;"><a href="adminGiftsReceivedShipNow"> <img src="resources/images/backButton.png" style="position: relative; top: 3px;"> </a></div></td>
							<td><div align="left" style="margin-left: 15px;"><button class="reg_add_bank_acc_saving_subt_Btn" id="adminGRBackOrderedDateButtId">Save</button></div> </td>
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