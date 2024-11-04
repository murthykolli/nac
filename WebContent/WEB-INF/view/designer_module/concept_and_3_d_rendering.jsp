<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/multiple_file_uploads.js"></script>
	  
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    
	<style type="text/css">		
	.buttonstyleClass, .buttonUploadClass { background-color: #ff3b3b; color: white; font: bold 0.9em/1.25em sans-serif; cursor:pointer; outline: none; border: none; white-space: nowrap; padding: 10px; outline-style: none; }
	.buttonstyleClass:hover, .buttonUploadClass:hover { background-color: #4c4c4c; color: white; outline: none; }
	.SubmitButtonstyleClass { background-color: #ff3b3b; color: white; font: bold 0.9em/1.25em sans-serif; cursor:pointer; outline: none; border: none; white-space: nowrap; padding: 10px; outline-style: none; }
	.SubmitButtonstyleClass:hover { background-color: #4c4c4c; color: white; outline: none; }
    .uploadHeads{ font: bold 0.85em/1.5em sans-serif; }
    .uploadDivs{ width: 160px; height: 100px; border: 2px solid gray; background-color: #f2f2f2; }
    #mask { position:absolute; left:0; top:0; background-color:#000; display:none;}  
    #imageBox .imageWindow { position:absolute; z-index:9999;}
    #imageBox #imageDialog { height:auto; padding:10px; background-color:#ffffff;}	
	</style>
	
	<script type="text/javascript">
    $(document).ready(function() {
    var concept1Upload = '<c:out value="${concept1UploadPh}"/>';    
    var concept2Upload = '<c:out value="${concept2UploadPh}"/>';
    var threeDRenderingUpload = '<c:out value="${threeDRenderingUploadPh}"/>';
        
    var furnitureSpecs1Upload = '<c:out value="${furnitureSpecs1UploadPh}"/>';
    var furnitureSpecs2Upload = '<c:out value="${furnitureSpecs2UploadPh}"/>';
    var furnitureSpecs3Upload = '<c:out value="${furnitureSpecs3UploadPh}"/>';
    
    var client3DRendReqStatus = '<c:out value="${client3DRenderingReqStatus}"/>';
    
    if(client3DRendReqStatus !== "" && threeDRenderingUpload === ""){
    	alert("Client waiting for 3D rendering design.");
    }
    
    if(concept1Upload !== ""){
    	$("#concept1Img").show();
    }
    
    if(concept2Upload !== ""){
    	$("#concept2Img").show();
    }
    
    if(threeDRenderingUpload !== ""){
    	$("#3dRenderingImg").show();
    }
    
    if(furnitureSpecs1Upload !== ""){
    $("#furSpec1Img").attr("src",furnitureSpecs1Upload).show();
    }
    
    if(furnitureSpecs2Upload !== ""){
    $("#furSpec2Img").attr("src",furnitureSpecs2Upload).show();
    }
    
    if(furnitureSpecs3Upload !== ""){
    $("#furSpec3Img").attr("src",furnitureSpecs3Upload).show();
    }
    
    var constApprovalStatus = '<c:out value="${admConseptApprovalStatus}"/>'; 
    var rendergApprovalStatus = '<c:out value="${admRenderingApprovalStatus}"/>'; 
    
    if(constApprovalStatus === "" && rendergApprovalStatus === "" ){
    	$("#conceptApprovalID").show();
    } else if(constApprovalStatus !== "" && rendergApprovalStatus === "" ){    	
    	$("#renderingApprovalID").show();
    }
    
    var furnitureSpecs1Count = '<c:out value="${furnSpecs1ProductsText}"/>';
	var furnitureSpecs2Count = '<c:out value="${furnSpecs2ProductsText}"/>';
	var furnitureSpecs3Count = '<c:out value="${furnSpecs3ProductsText}"/>';
	
	if(furnitureSpecs1Count > 0){
    	$("#fornitureSpec1ID").show();
    }
    
    if(furnitureSpecs2Count > 0){
    	$("#fornitureSpec2ID").show();
    }
    
    if(furnitureSpecs3Count > 0){
    	$("#fornitureSpec3ID").show();
    }
    
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
		</table><br><br>
				
		<table style="margin-left: 90px;"><tr>
            <td style="border: 2px solid gray;">
            <table style="text-align: center;margin:20px 30px 30px;">
            <tr><td><span class="uploadHeads">CONCEPT #1</span></td></tr>
            <tr id="concept1Row" ><td><div class="uploadDivs"><img id="concept1Img" src="data:image/jpg;base64,<c:out value='${concept1UploadPh}'/>" style="display: none;width: 160px;height: 100px;"></div></td></tr>
            <tr><td><button class="buttonstyleClass" style="margin-top: 5px;" id="uploadButn1">UPLOAD</button></td></tr>
            <tr style="height: 30px;"><td></td></tr>
            <tr><td><span class="uploadHeads">FURNITURE SPECS</span></td></tr>
            <tr id="furSpec1Row"><td><div class="uploadDivs"><font id="fornitureSpec1ID" style="top: 25px; position: relative; font: bold 2.5em/1.25em sans-serif; color: #2b81ee; display: none;"><c:out value='${furnSpecs1ProductsText}'/></font></div></td></tr>
            <tr><td>
            <form action="imageUploadFurnitureSpecs1" method="POST" id="furSpec1Form">
            <button class="buttonstyleClass" style="margin-top: 5px;" id="uploadButn4">UPLOAD</button>
            </form>
            </td></tr>
            </table>
            </td>
            
            <td style="width: 25px;"></td>
            
            <td style="border: 2px solid gray;">
            <table style="text-align: center;margin:20px 30px 30px;">
            <tr><td><span class="uploadHeads">CONCEPT #2</span></td></tr>
            <tr id="concept2Row"><td><div class="uploadDivs"><img id="concept2Img" src="data:image/jpg;base64,<c:out value='${concept2UploadPh}'/>" style="display: none;width: 160px;height: 100px;"></div></td></tr>
            <tr><td><button class="buttonstyleClass" style="margin-top: 5px;" id="uploadButn2">UPLOAD</button></td></tr>
            <tr style="height: 30px;"><td></td></tr>
            <tr><td><span class="uploadHeads">FURNITURE SPECS</span></td></tr>
            <tr id="furSpec2Row"><td><div class="uploadDivs"><font id="fornitureSpec2ID" style="top: 25px; position: relative; font: bold 2.5em/1.25em sans-serif; color: #2b81ee; display: none;"><c:out value='${furnSpecs2ProductsText}'/></font></div></td></tr>
            <tr><td>
            <form action="imageUploadFurnitureSpecs2" method="POST" id="furSpec1Form">
            <button class="buttonstyleClass" style="margin-top: 5px;" id="uploadButn5">UPLOAD</button>
            </form>
            </td></tr>
            </table>
            </td>
            
            <td style="width: 25px;"></td>

            <td style="border: 2px solid gray;">
            <table style="text-align: center;margin:20px 30px 30px;">
            <tr><td><span class="uploadHeads">3D RENDERING</span></td></tr>
            <tr id="3dRenderingRow"><td><div class="uploadDivs"><img id="3dRenderingImg" src="data:image/jpg;base64,<c:out value='${threeDRenderingUploadPh}'/>" style="display: none;width: 160px;height: 100px;"></div></td></tr>
            <tr><td><button class="buttonstyleClass" style="margin-top: 5px;" id="uploadButn3">UPLOAD</button></td></tr>
            <tr style="height: 30px;"><td></td></tr>
            <tr><td><span class="uploadHeads">FURNITURE SPECS</span></td></tr>
            <tr id="furSpec3Row"><td><div class="uploadDivs"><font id="fornitureSpec3ID" style="top: 25px; position: relative; font: bold 2.5em/1.25em sans-serif; color: #2b81ee; display: none;"><c:out value='${furnSpecs3ProductsText}'/></font></div></td></tr>
            <tr><td>
            <form action="imageUploadFurnitureSpecs3" method="POST" id="furSpec1Form">
            <button class="buttonstyleClass" style="margin-top: 5px;" id="uploadButn6">UPLOAD</button>
            </form>
            </td></tr>
            </table>
        	</td> </tr>
        </table> <br> <br>
            
	
		<form action="clientProfileAndDataSubmitRed" name="designerClients" id="designerClientsId" method="get">
		<div align="center">
		<table  style="font: 1.0em/1.25em sans-serif; margin-top: 10px; margin-left: 0px;">
		<tr><td><button class="SubmitButtonstyleClass" onclick="return clientProfile();"> CLIENT PROFILE </button>&nbsp; &nbsp;</td>
		<td id="conceptApprovalID" style="display: none;"><button class="SubmitButtonstyleClass" onclick="return conceptApproval();"> CONCEPT APPROVAL</button>&nbsp; &nbsp;</td>
		<td id="renderingApprovalID" style="display: none;"><button class="SubmitButtonstyleClass" onclick="return renderingApproval();"> 3D RENDERING APPROVAL </button></td> 
		</tr> </table>
		</div>
		<input type="hidden" name="clientProfileSubRefType"/>
		</form>

		</div><br><br><br>
				
		</div>
		</div>
		
		
		
		<div id="imageBox">
        <div style="top: 195px; left: 535px; display: none;" id="imageDialog" class="imageWindow">
        <div style="text-align: right;"> <img class="close" src="resources/images/close.png" style="cursor: pointer;"></div>
        
        <form action="imageUploadConcept1" method="POST" enctype="multipart/form-data" id="concept1Form" class="uploadForms">
        <table>
        <tr><td style="font:0.9em/1.5em Arial;">Select a image to upload</td></tr>
        <tr><td><input type="file" title="Click here to browse your image." id="concept1Upload" name="concept1Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="buttonUploadClass" type="submit" id="buttonUpload1" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="imageUploadConcept2" method="POST" enctype="multipart/form-data" id="concept2Form" class="uploadForms">
        <table>
        <tr><td style="font:0.9em/1.5em Arial;">Select a image to upload</td></tr>
        <tr><td><input type="file" title="Click here to browse your image." id="concept2Upload" name="concept2Upload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="buttonUploadClass" type="submit" id="buttonUpload2" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
        
        <form action="imageUpload3dRendering" method="POST" enctype="multipart/form-data" id="3dRenderingForm" class="uploadForms">
        <table>
        <tr><td style="font:0.9em/1.5em Arial;">Select a image to upload</td></tr>
        <tr><td><input type="file" title="Click here to browse your image." id="3dRendeingUpload" name="thDRendeingUpload"></td></tr>
        <tr style="height: 20px;"><td></td></tr>
        <tr><td style="text-align: center;"><input class="buttonUploadClass" type="submit" id="buttonUpload3" value="UPLOAD"></td></tr>
        <tr style="height: 10px;"><td></td></tr>
        </table>
        </form>
                
        </div>
        <div style="width: 1478px; font-size: 32pt; color:white; height: 602px; display: none; opacity: 0.8;" id="mask"></div>
		</div>
		
		<script type="text/javascript">
		function clientProfile(){
	        document.designerClients.clientProfileSubRefType.value = "Client Profile";	        
        }
		
		function conceptApproval(){
			 document.designerClients.clientProfileSubRefType.value = "Concept Approval";
			 var concept1Upload = '<c:out value="${concept1UploadPh}"/>';    
			 var concept2Upload = '<c:out value="${concept2UploadPh}"/>';
			 var furnitureSpecs1 = '<c:out value="${furnSpecs1ProductsText}"/>';
			 var furnitureSpecs2 = '<c:out value="${furnSpecs2ProductsText}"/>';
			 if(concept1Upload !== "" && concept2Upload !== "" && furnitureSpecs1 > 0 && furnitureSpecs2 > 0){
				return true; 
			 } else {
				 alert("Please upload all concepts and furniture specs");
				 return false;
			 }
			 
        }
        
        function renderingApproval(){
        	 document.designerClients.clientProfileSubRefType.value = "Rendering Approval";
        	 var threeDRenderingUpload = '<c:out value="${threeDRenderingUploadPh}"/>';        	 
			 var furnitureSpecs3 = '<c:out value="${furnSpecs3ProductsText}"/>';			 
			 if(threeDRenderingUpload !== "" && furnitureSpecs3 > 0){
				return true; 
			 } else {
				 alert("Please upload all 3D Rendering and furniture spec");
				 return false;
			 }
        }

        </script>
		</body>
</html>