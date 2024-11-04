<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<link rel="stylesheet" href="resources/css/portfolio_gift.css" type="text/css">
	  
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    
	<style type="text/css">		
	.buttonstyleClass { background-color: #ff3b3b; color: white; font: bold 0.9em/1.25em sans-serif; cursor:pointer; outline: none; border: none; white-space: nowrap; padding: 10px; outline-style: none; }

	.buttonstyleClass:hover { background-color: #4c4c4c; color: white; outline: none; }
	
	.inspiredImgs{ width: 130px; height: 150px; border: 1px solid gray;}

    .checkboxList { position: relative; }

    .checkboxList label { background: none repeat scroll 0 0 #F2F2F2; cursor: pointer; height: 20px; left: 0; position: absolute; top: 0; width: 20px;}
        
    .checkboxList label.bluebox:after { border: 3px solid black; border-top: none; border-right: none;}
       
    .checkboxList label:after { content: ''; position: absolute; width: 12px; height: 5px; background: transparent; top: 5px; left: 3px;
            opacity: 0; border: 3px solid red;border-top: none; border-right: none; -webkit-transform: rotate(-45deg); -moz-transform: rotate(-45deg);
            -o-transform: rotate(-45deg); -ms-transform: rotate(-45deg);transform: rotate(-45deg);
    }

    .checkboxList input[type="checkbox"]:checked + label:after { opacity: 1;}
	</style>
		
	<script type="text/javascript">
 	$(document).ready(function(){

		//Modern Style room images
        
        var modernInspStyle = '<c:out value='${modernInsStyle}'/>';
        var modInspStyle = modernInspStyle.split("_,_");
              
        var modernInsTab = $("#modInspRoomImages");
        modernInsTab.append("<tr>");
           	
        for (var i = 0; i < modInspStyle.length; i++){
        if(modInspStyle[i] !== ""){
        	$("#modInspImgsCountId").html(modInspStyle.length);
        var modenInspImage = "data:image/jpg;base64," + modInspStyle[i];        
        modernInsTab.append("<td style='padding-right: 10px;'><img src=" + modenInspImage + " class='portfolios inspiredImgs'></td>");
        }
        }
        modernInsTab.append("</tr>");
        
        //for room images
        
        var roomImage =  '<c:out value='${uploadPhForDes}'/>';
        var roomImg = roomImage.split("_,_");
        var roomTab = $("#roomImages");
        roomTab.append("<tr>");
        for (var i = 0; i < roomImg.length; i++){
        if(roomImg[i] !== ""){
        var uploadedSpImage = "data:image/jpg;base64," + roomImg[i];
        roomTab.append("<td style='padding-right: 10px;'><img src=" + uploadedSpImage + " class='portfolios inspiredImgs'></td>");
        }
        }
        roomTab.append("</tr>");
        
        //for inspiration images
        
        var inspireImage =  '<c:out value='${insUploadPhoto}'/>';        
        var inspireImg = inspireImage.split("_,_");
        var inspirationTab = $("#inspirationImages");
        inspirationTab.append("<tr>");
        for (var i = 0; i < inspireImg.length; i++){
        if(inspireImg[i] !== ""){
        var uploadedInsImage = "data:image/jpg;base64," + inspireImg[i];
        inspirationTab.append("<td style='padding-right: 10px;'><img src=" + uploadedInsImage + " class='portfolios inspiredImgs'></td>");
        }
        }
        inspirationTab.append("</tr>");
        
        var desProfileImg =  '<c:out value='${desProfileImage}'/>';
        
        if(desProfileImg != "") {
        $("#DesStatusId").show();
        }
        
        	$(".portfolios").click(function(){
            window.scrollTo(0,0);            
            $("#bigPortfolio").attr("src",$(this).attr("src")).css({'display': 'block', 'height': $(window).height()-60 ,'width': $("body").innerWidth()-15});
        	$('#portfolioMask').css({'width':$(window).width(),'height':$(document).height()});
        	$('#portfolioMask').fadeIn(100);	
        	$('#portfolioMask').fadeTo("fast",0.9);
        	$("#dialog").fadeIn(500);
        	$('.window .close').click(function(e) {
        	e.preventDefault();
        	$('#portfolioMask, .window').hide();
        	});
        	});
        	
        	var clUpSpImgCount = "<c:out value="${uploadPhForDesCount}"/>";
        	var insUpSpImgCount = "<c:out value="${insUploadPhotoCount}"/>";
            if(clUpSpImgCount > 0){
            	$("#spImgCountDivId").show();            	
            }
            if(insUpSpImgCount > 0){
            	$("#insImgCountDivId").show();            	
            }
            
            var clCheckList = "<c:out value="${clientCheckList}"/>";
            $("[name='clientCheckList']").each(function (){    	
            if(clCheckList.indexOf($(this).val()) !== -1){    
            $(this).attr("checked",true);   
            }   
            });
            
            var cl3DRenderReqStatus =  '<c:out value='${cl3DRenderRequestStatus}'/>';
            
            if(cl3DRenderReqStatus !== "") {
            $("#client3DRendReqId").show();
            }

	    	var budgetFee = '<c:out value="${budgetVal}"/>';
	        var budgetPrice = budgetFee.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	        $("#budgetPriceId").html(budgetPrice);
        });
        </script>
	
	</head>
	
		<body>		
		<div id="shadowImgId">
		<div class="clearfix" style="background-color: white; min-height: 345px; height: auto;">
				
		<div style="min-height: 300px; height: auto;"><br><br><br><br>

		<table style="background-color: #f2f2f2; margin-top: 0px; margin-left: 50px; width: 860px; height: 28px; text-transform: uppercase; font: 0.9em/1.25em sans-serif;">
		<tr><td align="left" style="text-transform: uppercase;"><c:out value='${clientFullName}'/></td>
		<td align="center"><c:out value='${typeOfSpaceVal}'/> - <c:out value='${designPackageVal}'/> - <c:out value='${createdDate}'/></td></tr>
		</table><br>
                
                <div style="margin-left: 660px;margin-top: -5px;position: absolute;">
                <form action="adminUpdateCheckListInDB" method="post">
                <table style="border: 2px solid gray;background: #f2f2f2;padding: 10px;font: 0.8em/1.25em sans-serif;width: 250px;">
                	
                    <tr><td></td><td><span style="font:bold 1.3em/1.5em sans-serif;">CLIENT CHECKLIST</span></td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList" style="border: 2px solid gray;"><input type="checkbox" id="option1" name="clientCheckList" value="InitialContact"><label for="option1"></label></div></td>
                    <td style="padding-left:5px;">Initial Contact w/ Client</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList" style="border: 2px solid #00a9f1;"><input type="checkbox" id="option2" name="clientCheckList" value="FurnitureorConcepts"><label for="option2" class="bluebox"></label></div></td>
                    <td style="padding-left:5px;color: #00A9F1;">Submit Furniture/ Concepts to Admin</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList" style="border: 2px solid gray;"><input type="checkbox" id="option3" name="clientCheckList" value="FollowUpClient"><label for="option3"></label></div></td>
                    <td style="padding-left:5px;">Follow Up With Client</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList" style="border: 2px solid #00a9f1;"><input type="checkbox" id="option4" name="clientCheckList" value="Furnitureor3DRendering"><label for="option4" class="bluebox"></label></div></td>
                    <td style="padding-left:5px;color: #00A9F1;">Submit Furniture/ 3D Rendering to Admin</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList" style="border: 2px solid gray;"><input type="checkbox" id="option5" name="clientCheckList" value="FinalFollowUp"><label for="option5"></label></div></td>
                    <td style="padding-left:5px;">Final Follow up</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList" style="border: 2px solid #00a9f1;"><input type="checkbox" id="option6" name="clientCheckList" value="UpdateFurniture"><label for="option6" class="bluebox"></label></div></td>
                    <td style="padding-left:5px;color: #00A9F1;">Update Furniture List if Required</td></tr>
                    
                    <tr><td></td><td><button class="buttonstyleClass" style="margin-top: 20px; margin-left: 0px; font: bold 0.9em/1.25em sans-serif;">SAVE</button></td></tr>
                    </table>
                	
                
                </form>
                <form action="conceptsAnd3DRenderingRe" method="get">
                  <button class="buttonstyleClass" style="margin-top: 10px; margin-left: 0px;width: 250px; font: bold 0.9em/1.25em sans-serif;">CONCEPTS / 3D RENDERING</button>
                </form>  
                </div>

		<table style="margin-top: 0px; margin-left: 50px; font: 0.9em/1.25em sans-serif;">		
		<tr style="height: 10px;"> <td> </td> </tr>
		<tr> <td style="white-space: nowrap; width: 170px;">Room: </td>  <td><b> <c:out value='${typeOfSpaceVal}'/> </b></td> </tr>
		<tr> <td style="white-space: nowrap; width: 170px;">Style: </td>  <td><b> <c:out value='${typeOfStyleVal}'/> </b></td> </tr>
		<tr> <td style="white-space: nowrap; width: 170px;">Budget: </td>  <td><b> <font id="budgetPriceId"></font> </b></td> </tr>
		</table>

		<table style="margin-top: 15px; margin-left: 50px; font: 0.9em/1.25em sans-serif;">
		<tr> <td colspan="5">Selected Images: <font color="red"><font id="modInspImgsCountId"></font></font></td> </tr></table>
        
		<div style="margin-top: 15px; margin-left: 50px; width: 575px; overflow-x: auto; overflow-y: hidden;">        
     	<table id="modInspRoomImages"></table> 
		</div>

		<table style="margin-top: 15px; margin-left: 50px; font: 0.9em/1.25em sans-serif;">
		<tr> <td style="white-space: nowrap; width: 170px;">Room Dimensions: </td>  <td><b> <c:out value='${aboutSpaceDimnVal}'/> </b></td> </tr>
		<tr> <td style="white-space: nowrap; width: 170px;">Requirements: </td>  <td><b> <c:out value='${typeOfFriendlyVal}'/> </b></td> </tr>		
		</table>

		<table style="margin-top: 15px; margin-left: 50px; font: 0.9em/1.25em sans-serif;">
        <tr> <td colspan="5">Room Images: <font id="spImgCountDivId" color="red" style="display: none;"><c:out value='${uploadPhForDesCount}'/></font></td> </tr></table>
        <div style="margin-top: 15px; margin-left: 50px; width: 850px; overflow-x: auto; overflow-y: hidden;">        
     	<table id="roomImages"></table> 
		</div>

		<table style="margin-top: 15px; margin-left: 50px; font: 0.9em/1.25em sans-serif; width: 855px;">
		<tr> <td style="white-space: nowrap; width: 170px;">Items Needed: </td>  <td><b> <c:out value='${allItemsVal}'/> </b></td> </tr>		
		</table>
		
		<table style="margin-top: 15px; margin-left: 50px; font: 0.9em/1.25em sans-serif;">
        <tr> <td colspan="5">Inspiration Images: <font id="insImgCountDivId" color="red" style="display: none;"><c:out value='${insUploadPhotoCount}'/></font></td> </tr></table>
        <div style="margin-top: 15px; margin-left: 50px; width: 850px; overflow-x: auto; overflow-y: hidden;">        
     	<table id="inspirationImages"></table> 
		</div> 

		<table id="client3DRendReqId" style="margin-top: 15px; margin-left: 50px; font: 0.9em/1.25em sans-serif; width: 855px; display: none;">
		<tr> <td style="white-space: nowrap; width: 170px;">Client 3D rendering Request: </td>  <td><b>Client waiting for 3D rendering design</b></td> </tr>		
		</table>

		</div><br><br><br><br>
				
		</div>
		</div>
		
		
		<div id="portfolioBoxes">
        <div style="display: none; left:0px; top:0px;" id="dialog" class="window">
        <div style="text-align: right;">
        <img class="close" src="resources/images/close.png" style="cursor: pointer; padding-bottom: 5px;" title="Close">
        </div>
  
        <div style="border: 2px solid gray;margin-top: -5px;">
        <img id="bigPortfolio" src="" style="display: none;">
        </div>
        </div>
        <div id="portfolioMask" style="width: 1478px; font-size: 32pt; color:white; height: 602px; display: none; opacity: 0.8;"></div>
        </div>
		</body>
</html>