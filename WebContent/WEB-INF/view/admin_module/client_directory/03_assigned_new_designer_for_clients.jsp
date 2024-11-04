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
    function assignValues(curObj, selVal){    
    var designer = $(curObj).parent().prev('td').find(".designerSelect").val();    
    if(designer === ""){
	    alert("Please select a Designer");
	    return false;
    } else{
    	document.designerClients.clientInfoSavingId.value = selVal;
		document.designerClients.designerInfoSavingId.value = designer;
		document.forms["designerClientsId"].submit();
		return true;
    }  
    }
    </script>
       
    <script type="text/javascript">
    $(document).ready(function(){
    	$('#insured_list tr').each(function() {
    		$('.newDesnStatusCl:contains("ASSIGNED")').css('color', 'green');		
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
        
        <div class="col-md-6 col-sm-6">
        <div class="adm_new_cl_head_txt_dsp" align="left">ADMIN CHANGE DESIGN FOR CLIENT</div>
        </div>
        <div class="col-md-4 col-sm-4">
        <div class="adm_new_cl_sub_txt_dsp" align="right">Total assigned clients: <b id="displayCount" class="new_clients_no_dsp"></b></div>
        </div>
                
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
         
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="admin_gift_card_management">
		<a href="admClientDirectory"><font class="pendGiftCardCurrentTab">&nbsp;CLIENT DIRECTORY&nbsp;</font></a> </div>
		
		<div class="admin_gift_card_current_management">
		<a href="admAssignNewDesignerForClients"><font class="pendGiftCardCurrentTab">&nbsp;CHANGE DESIGN&nbsp;<font color="yellow">-&nbsp;${assiClientsCount}&nbsp;</font></font></a> </div>
		</div>
                        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <form action="adminAssignedNewDesignerInfoSaving" name="designerClients" id="designerClientsId" method="get">      
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
                		    
        <display:table  id="insured_list"  class="tablesorter" name="assNewDsnForclientsSavingList" style="margin-top: 0px; margin-left: 0px;">
        <display:column />
        <display:column style="width:150px; text-transform: uppercase;" property ="typeOfStyle" title="CLIENT NAME"/>        
        <display:column style="width:70px;" property ="createdDate" title="DATE" format="{0,date,MM/dd/yyyy}"/>        
        <display:column property ="designPackage" title="DESIGN PACKAGE" />
        <display:column property ="typeOfSpace" title="ROOM" />        
        <display:column class="newDesnStatusCl" style="font-weight: bold;" property ="status" title="STATUS" />
        <display:column headerClass="sortDisabled" title="DESIGNERS">
           
           <select class="designerSelect" style="width:166px;" name="designerName">
	       <option value="">----Select Designer----</option>
	       		        	       
		   <c:forEach var="desFullName" items="${desnFullName}">		   		   	   
		   <option value="${desFullName.designerInfoSavingId}">${desFullName.designerFullName}</option> </c:forEach>		   
		   </select>
            
           </display:column>
           <display:column>
           <input type="button" class="admn_new_clients_submit_Btn" value="ASSIGN" onclick="assignValues(this, '${insured_list.clientInfoSavingId}');">
           </display:column>
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
		
		<input type="hidden" id="clientInfoSavingId" name="clientInfoSavingId">
		<input type="hidden" id="designerInfoSavingId" name="designerInfoSavingId">
		
        <font color="white" id="text" size="3"></font>			            
		</div> <!-- /.col-md-10 -->
				
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
		
        </div> <!-- /.row -->
        </form>
                      
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                     
        <script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${assNewDsnForclientsListCount}"/>';        
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

        </script>
        
        <script type="text/javascript" src="resources/js/tablelayout.js"></script>
                	
		</body>
</html>