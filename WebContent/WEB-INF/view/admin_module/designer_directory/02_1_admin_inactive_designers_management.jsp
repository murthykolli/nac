<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="images/ico/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="resources/css/designer_tablelayout.css" type="text/css" />
	
    <script type="text/javascript">
    $(document).ready(function(){
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='designerInfoSavingId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF","cursor":"pointer"});
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='designerInfoSavingId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF"}); 
    		    $(this).find("input[name='designerInfoSavingId']").prop("checked",true);
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
    pagerHtml += '<input type="button"  style="position: relative; left: -10px; top: 12px; outline: none;" id="cmdPrevId" name="Prev" value="<-- View Prev" onclick="' + pagerName + '.prev();" class="pg-normal"/>  &nbsp; &nbsp; ';
    pagerHtml += '</td><td width="635">&nbsp;<td>';

    pagerHtml += '<td  align="right">';
    pagerHtml += '<input type="button" style="position: relative; left: 80px; top: 12px; outline: none;" id="cmdNextId" name="Next" value="View Next -->" onclick="'+pagerName+'.next();" class="pg-normal"/>';
    pagerHtml += '</td></tr></table>';
    element.innerHTML = pagerHtml;
    }; }

    </script>
    
	</head>
	
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
               
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-5 col-sm-5">
        <div class="adm_new_cl_head_txt_dsp" align="left">INACTIVE DESIGNERS</div>
        </div>
        <div class="col-md-5 col-sm-5">
        <div class="adm_new_cl_sub_txt_dsp" align="right">Total designers: <b id="displayCount" class="new_clients_no_dsp"></b></div>
        </div>
                
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="admin_gift_card_management">
		<a href="admDesnDirectory"><font class="pendGiftCardCurrentTab">&nbsp;DESIGNER DIRECTORY&nbsp;</font></a> </div>
		
		<div class="admin_gift_card_current_management">
		<a href="admInactiveDesigners"><font class="pendGiftCardCurrentTab">&nbsp;INACTIVE DESIGNERS&nbsp;</font></a> </div>
		</div>
                        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <div id="designerInfoDisplayID" style="display: none;">                 
        <form action="inactiveDesignersDirectory" name="designerClients" id="designerClientsId" method="get">      
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        
        <display:table  id="insured_list"  class="tablesorter" name="inactiveDesignersSavingList" style="margin-top: 0px; margin-left: 0px;">
        <display:column headerClass="sortDisabled"><label>            
        <input type="radio" style=" cursor: pointer;" onclick="changeColor(this);" name="designerInfoSavingId" value="${insured_list.userId}"/><span></span></label>
        </display:column>
        <display:column property ="createdDate" title="START DATE" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="updatedDate" title="END DATE" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="firstName" title="DESIGNER NAME"/>
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
		<input type="hidden" name="inactiveDesignerRef"/> 		            
		</div> <!-- /.col-md-10 -->
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
		
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_20">
        <div class="col-md-4 col-sm-4">
        </div> <!-- /.col-md-4 --> 
        
		<div class="col-md-2 col-sm-2 text-center">
		<h4><button class="admin_cl_dir_submit_Btn" id="viewProfileId" onclick="return profile();">PROFILE</button></h4>
		</div>
		
		<div class="col-md-2 col-sm-2 text-center">
		<h4><button class="admin_cl_dir_submit_Btn" id="viewActiveId" style="margin-left: 6px;" onclick="return active();">ACTIVE</button></h4>
		</div>
		
		<div class="col-md-4 col-sm-4">
        </div> <!-- /.col-md-4 -->        
        </div> <!-- /.row -->
        </form>
        </div>
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        
        <script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${inactiveDesignersListCount}"/>';
        if(count > 0) {
        	document.getElementById("designerInfoDisplayID").style.display = "block";        	
        }
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

        function profile(){
	        document.designerClients.inactiveDesignerRef.value = "Inactive Designer Profile";
	        var designerInfoSavingIds="";        
		        for(var k=0; k < document.designerClients.designerInfoSavingId.length; k++) {
			        if(document.designerClients.designerInfoSavingId[k].checked){
			        	designerInfoSavingIds=document.designerClients.designerInfoSavingId[k].value;        
			        }
		        }
	    
	        if(document.designerClients.designerInfoSavingId.checked){
	        	designerInfoSavingIds=document.designerClients.designerInfoSavingId.value;
	        }
	        
	        if(designerInfoSavingIds === ""){
	        	window.alert("Please select a designer");
	        return false;
	        } 
        }

        function active(){
	        document.designerClients.inactiveDesignerRef.value = "Active Designer";
	        var designerInfoSavingIds="";        
		        for(var k=0; k < document.designerClients.designerInfoSavingId.length; k++) {
			        if(document.designerClients.designerInfoSavingId[k].checked){
			        	designerInfoSavingIds=document.designerClients.designerInfoSavingId[k].value;        
			        }
		        }
	    
	        if(document.designerClients.designerInfoSavingId.checked){
	        	designerInfoSavingIds=document.designerClients.designerInfoSavingId.value;
	        }
	        
	        if(designerInfoSavingIds === ""){
	        	window.alert("Please select a designer");
	        return false;
	        } 
        }
        
        </script>
        
        <script type="text/javascript" src="resources/js/tablelayout.js"></script>
                	
		</body>
</html>