
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/furniture_specs_and_3d_render_validation.js"></script>
	<link rel="stylesheet" href="resources/css/tablelayout.css" type="text/css" />
	  
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
    
	<style type="text/css">	
	.mainHeaddings { font: bold 1.02em/1.25em Serif, Georgia; color: #2c2c2c; }

	.buttonstyleClass { background-color: #ff3b3b; color: white; font: bold 1em/1.25em sans-serif; cursor:pointer; outline: none; border: none; white-space: nowrap; padding: 10px; outline-style: none; }

	.buttonstyleClass:hover { background-color: #4c4c4c; color: white; outline: none; }
        
    #spaceImgList img.uploadImgs { width: 80px; height: 50px; border: 1px solid gray; cursor: pointer; margin-top: 5px;}
      
    #spaceImgList img.delete { width: 20px; height: 20px; cursor: pointer; margin-top:-2px; margin-left: 70px; position:absolute;}
	</style>
	
	   
    <script type="text/javascript">
    $(document).ready(function(){    	        
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='furnSpec1RefId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF","cursor":"pointer"});
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='furnSpec1RefId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF"}); 
    		    $(this).find("input[name='furnSpec1RefId']").prop("checked",true);
    		    });
    		    
    var furnSpecs1Count = 	'<c:out value="${furnitureSpecs1Count}"/>';
    
    if(furnSpecs1Count > 0) {
    	$("#furnSpecs1DisplayID").show();
    	$("#inputDataDisplayId").hide();
    	$("#addButtonDisplayId").show();
    } else{
    	$("#inputDataDisplayId").show();
    	$("#addButtonDisplayId").hide();
    }
    
    $("#addButtonId").click(function (){
    	$("#inputDataDisplayId").show();
    	$("#addButtonDisplayId").hide();
    });
    
    });

    </script>

    <script type="text/javascript">
    function Pager(tableName, itemsPerPage) {
    this.tableName = tableName;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;
    this.pages = 0;
    this.inited = false;

    this.showRecords = function(from, to) {
    var rows = document.getElementById(tableName).rows;
    for (var i = 1; i < rows.length; i++) {
    if ((i < from) || (i > to))
    rows[i].style.display = 'none';
    else
    rows[i].style.display = '';
    } };

    this.showPage = function(pageNumber) {
    if (! this.inited) {
    return;
    }

    this.currentPage = pageNumber;
    var from = (pageNumber - 1) * itemsPerPage + 1;
    var to = from + itemsPerPage - 1;
    this.showRecords(from, to);
    };

    this.prev = function() {
    if (this.currentPage > 1) {
    this.showPage(this.currentPage - 1);
    }
    
    if(this.currentPage === 1) {
    document.getElementById("cmdPrevId").style.display = "none";
    document.getElementById("cmdNextId").style.display = "";
    }  
    
    if(this.currentPage < this.pages) {
    document.getElementById("cmdNextId").style.display = "";
    } };

    this.next = function() {
    if (this.currentPage < this.pages) {
    this.showPage(this.currentPage + 1);
    }
    
    document.getElementById("cmdPrevId").style.display = "";    
    if(this.currentPage === this.pages) {
    document.getElementById("cmdNextId").style.display = "none";
    } };

    this.init = function() {
    var rows = document.getElementById(tableName).rows;
    var records = (rows.length - 1);
    this.pages = Math.ceil(records / itemsPerPage);
    this.inited = true;
    }

    this.showPageNav = function(pagerName, positionId) {
    if (! this.inited) {
    return;
    }
    
    var element = document.getElementById(positionId);
    var pagerHtml ='<table border="0" id="navigation" align="left"> <tr><td align="right" width="131">';
    pagerHtml += '<input type="button"  style="position: relative; left: 100px; top: 0px; outline: none;" id="cmdPrevId" name="Prev" value="<-- View Prev" onclick="' + pagerName + '.prev();" class="pg-normal"/>  &nbsp; &nbsp; ';
    pagerHtml += '</td><td width="635">&nbsp;<td>';

    pagerHtml += '<td  align="right">';
    pagerHtml += '<input type="button" style="position: relative; left: 0px; top: 0px; outline: none;" id="cmdNextId" name="Next" value="View Next -->" onclick="'+pagerName+'.next();" class="pg-normal"/>';
    pagerHtml += '</td></tr></table>';
    element.innerHTML = pagerHtml;
    }; }

    </script>

	</head>
	
		<body>		
		<div id="shadowImgId">			

		<div class="clearfix" style="background-color: white; min-height: 300px; height: auto;">
		
		<form action="furnitureSpecs1DataSavingInDB" name="fileUpload" method="post" enctype="multipart/form-data">
		<div align="center" style="margin-top: 30px; margin-left: 0px;"><font class="mainHeaddings" style=" border-bottom: 1px solid red; padding-bottom: 5px;">&nbsp;&nbsp;CONCEPT #1 FURNITURE SPECS&nbsp;&nbsp;</font></div>
		
		
		
		<div id="furnSpecs1DisplayID" align="center" style="margin-top: 40px; margin-left: 0px; display: none;">
        <table style="font: 1.0em/1.25em sans-serif; margin-top: 0px; margin-left: 0px; width: 815px;"><tr><td align="left" style="padding-left: 47px;"><b><c:out value="${clientFullName}"/></b></td> <td align="right" style="color: #494949;">Total products: <b id="displayCount" style="color: red; font-weight: normal;"></b>&nbsp;</td> </tr> </table>
             
        <display:table  id="insured_list"  class="tablesorter" name="furnitureSpecs1SavingList" style="margin-top: 0px; margin-left: 0px;">
        <display:column headerClass="sortDisabled"><label>            
        <input type="radio" style=" cursor: pointer;" onclick="changeColor(this);" name="furnSpec1RefId" value="${insured_list.clientProductsUploadedByDesignerSavingId}"/><span></span></label>
        </display:column>
        <display:column style="width:70px;" property ="createdDate" title="Start Date" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="productName" title="Product Name"/>
        <display:column property ="productPrice" title="Product Price"/>
        <display:column property ="storeName" title="Store Name"/>
        <display:column property ="storeURL" title="Store URL"/>
        </display:table>        
        
		<script type="text/javascript">highlightTableRows("insured_list");</script>			
            
            <input type="hidden" name="tableLengthName" id="tableLengthId" value="displayCount"/>
            <div id="pageNavPosition"></div>
            <script type="text/javascript"><!--
            var pager = new Pager('insured_list', 10);
            pager.init();
            pager.showPageNav('pager', 'pageNavPosition');
            pager.showPage(1);
            //--></script>		
		<div class="clearfix"></div>
		
		<font color="white" id="text" size="3"></font>
        
        <div align="left" style="left: -55px; top: -1px; position: relative; width: 450px;">
		<table style="margin-top: 0px; margin-left: 0px; font: 0.9em/2em sans-serif;">		
		<tr><td><button class="buttonstyleClass" onclick="return deleteProducts();" style="margin-top: 0px; margin-left: 0px;">DELETE</button></td></tr>
		</table>
		</div>
		
		</div>		
        
		
		
		<div id="inputDataDisplayId" style="display: none;">		
		<div style="margin-top: 25px; margin-left: 200px; background-color: white; border: 1px dotted black; width: 500px; padding-right: 70px; padding-top: 25px; padding-bottom: 20px;">
		<table style="margin-top: 0px; margin-left: 130px; font: 0.9em/2em sans-serif;">
		<tr><td><p align="right" style="color: black;">Product Name:&nbsp;</p><td>
		<td><input type="text" id="productNameId" name="productName" placeholder="Product Name" style="border-bottom: 1px solid black;  border-top: 2px solid white; border-left: 2px solid white;  border-right: 2px solid white; width: 220px; height: 18px; top: -15px; position: relative;"></td></tr>
		
		<tr style="top: -15px; position: relative;"><td><p align="right" style="color: black;">Product Price:&nbsp;</p><td>
		<td><font style="position: absolute; margin-top: -17px; margin-left: -8px; color: black;">$</font><input type="text" id="productPriceId" name="productPrice" placeholder="Product Price" style="border-bottom: 1px solid black;  border-top: 2px solid white; border-left: 2px solid white;  border-right: 2px solid white; width: 220px; height: 18px; top: -15px; position: relative;"></td></tr>
		
		<tr style="top: -30px; position: relative;"><td><p align="right" style="color: black;">Store Name:&nbsp;</p><td>
		<td><input type="text" id="storeNameId" name="storeName" placeholder="Store Name" style="border-bottom: 1px solid black;  border-top: 2px solid white; border-left: 2px solid white;  border-right: 2px solid white; width: 220px; height: 18px; top: -15px; position: relative;"></td></tr>
		
		<tr style="top: -45px; position: relative;"><td><p align="right" style="color: black;">Store URL:&nbsp;</p><td>
		<td><input type="text" id="storeURLId" name="storeURL" placeholder="Store URL" style="border-bottom: 1px solid black;  border-top: 2px solid white; border-left: 2px solid white;  border-right: 2px solid white; width: 220px; height: 18px; top: -15px; position: relative;"></td></tr>
		</table>
		
		<table style="margin-top: -60px; margin-left: 60px; font: 0.9em/2em sans-serif; white-space: nowrap;">
		<tr><td>Upload product image:&nbsp;
		<td><input type="file" name="fileUpload" id="fileUpload" style="background-color:white;"></td></tr>
		</table>
				
		</div>
		
		<div align="right" style="width: 500px; margin-left: 275px; margin-top: 20px;">
		<table style="margin-top: 0px; margin-left: 0px; font: 0.9em/2em sans-serif;">		
		<tr><td><button class="buttonstyleClass" id="furnitureSpecsButtonId" style="margin-top: 0px; margin-left: 0px;">SAVE</button></td></tr>
		</table>
		</div>
		</div>
		
		<input type="hidden" name="productRefType"/>
			
		</form>
		
		<div align="left" style="margin-left: 110px; margin-top: -47px; position: absolute; width: 110px;">
		<form action="designerProdBackMove" method="get">
		<table style="margin-top: 0px; margin-left: 0px; font: 0.9em/2em sans-serif;">		
		<tr><td><button class="buttonstyleClass" style="margin-top: 0px; margin-left: 0px;">BACK</button>&nbsp;&nbsp;</td>	</tr>
		</table>
		</form>
		</div>
		
		<div id="addButtonDisplayId" align="right" style="left: 440px; top: -47px; position: relative; width: 450px; display: none;">
		<table style="margin-top: 0px; margin-left: 0px; font: 0.9em/2em sans-serif;">		
		<tr><td><button class="buttonstyleClass" id="addButtonId" style="margin-top: 0px; margin-left: 0px;">Add Products</button></td></tr>
		</table>
		</div>
		<br><br><br><br>		
		</div>
		</div>
		
		<script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${furnitureSpecs1Count}"/>';        
        var  numnerOfDocuments = eval(count);
        if(numnerOfDocuments < 11) {
        if(document.getElementById("cmdNextId") != null) {
        document.getElementById("cmdNextId").style.display = "none";
        }
        if(document.getElementById("cmdPrevId") != null) {
        document.getElementById("cmdPrevId").style.display = "none";
        }
        }    
        else {
        document.getElementById("cmdPrevId").style.display = "none";
        document.getElementById("cmdNextId").style.display = "";
        }
        var ele =document.getElementById("displayCount");
        var countele = document.createTextNode(count);
        ele.appendChild(countele);        
        };
        
        function deleteProducts(){
	        document.fileUpload.productRefType.value = "Delete Product";
	        var furnSpec1RefIds="";        
		        for(var k=0; k < document.fileUpload.furnSpec1RefId.length; k++) {
			        if(document.fileUpload.furnSpec1RefId[k].checked){
			        	furnSpec1RefIds=document.fileUpload.furnSpec1RefId[k].value;        
			        }
		        }
	    
	        if(document.fileUpload.furnSpec1RefId.checked){
	        	furnSpec1RefIds=document.fileUpload.furnSpec1RefId.value;
	        }
	        
	        if(furnSpec1RefIds === ""){
	        	window.alert("Please select a product");
	        return false;
	        } 
        } 
        </script>
        
        <script type="text/javascript" src="resources/js/tablelayout.js"></script>
		                	
		</body>
</html>