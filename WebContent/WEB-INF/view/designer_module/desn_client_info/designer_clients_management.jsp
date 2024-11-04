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
	
    <style type="text/css">    
    #mask { position:absolute; left:0; top:0; background-color:#000; display:none;}  
    #profileBox .profileWindow { position:absolute; z-index:9999;}
    #profileBox #profileDialog { height:auto; padding:10px; background-color:#ffffff;}
    </style>
        
    <script type="text/javascript">
    $(document).ready(function(){
    	$('#insured_list tr').each(function() {  		
    		$('.messageCl:contains("NEW")').css('color', 'red');
    		$('.newAlertCl:contains("YES")').css('color', 'red');		
    	});
    	
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='desCliens']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF","cursor":"pointer"});
    		    $('.messageCl:contains("NEW")').css('color', 'red');
        		$('.newAlertCl:contains("YES")').css('color', 'red');
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='desCliens']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    $('.messageCl:contains("NEW")').css('color', 'red');
        		$('.newAlertCl:contains("YES")').css('color', 'red');
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF"}); 
    		    $(this).find("input[name='desCliens']").prop("checked",true);
    		    $('.messageCl:contains("NEW")').css('color', 'red');
        		$('.newAlertCl:contains("YES")').css('color', 'red');        		
    		    });
    		    
    		    var reqNewClientStatus = '<c:out value="${reqNewClientsStatus}"/>';    		    
    		    if(reqNewClientStatus !== "") {    		    	
    		    	$("#viewNewReqId").attr("disabled","disabled");
    		    	$("#viewNewReqId").css("opacity","0.3");
    		    	$("#viewNewReqId").css("cursor","not-allowed");
    		    }
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
    var pagerHtml ='<table border="0" id="navigation" align="left"> <tr><td align="left" width="131">';
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
        
        <div class="row" style="margin-top: -40px;">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        <div class="col-md-10 col-sm-10">
        <!-- <div align="right"><a class="desn_arch_clients_cl" href="desnEditableCalendarForClients">EDITABLE CALENDAR</a></div> -->
        <div align="right"><a class="desn_arch_clients_cl" href="desnArchiveClientsInfo">ARCHIVE CLIENTS</a></div>
        </div>
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        </div>
        
        <form action="viewClientMessageInfo" name="designerClients" id="designerClientsId" method="get">
                    
        <div class="row" style="margin-top: 40px;">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">               
                          
        <display:table id="insured_list" class="tablesorter" name="designerClientsSavingList">
        <display:column headerClass="sortDisabled"><label>            
        <input type="radio" style=" cursor: pointer;" onclick="changeColor(this);" name="desCliens" value="${insured_list.clientInfoSavingId}, ${insured_list.designerInfoSavingId}"/><span></span></label>
        </display:column>
        <display:column style="width: 150px;" property ="createdDate" title="START DATE" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="typeOfStyle" title="CLIENT NAME"/>
        <display:column property ="designPackage" title="DESIGN PACKAGE" />
        <display:column class="messageCl" style="color: red;" property ="typeOfItemsList" title="MESSAGES" />
        <display:column class="newAlertCl" style="color: red;" property ="moreAboutSpace" title="NEW ALERT" />
        <%-- <display:column property ="roomStatus" title="ROOM STATUS" /> --%>
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
		            
		</div> <!-- /.col-md-10 -->
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
		
        </div> <!-- /.row --> 
        
        
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-4 col-sm-6 text-left">
		<div style="margin-left: 60px;">
		<h4><button class="management_submit_Btn" id="viewClientId" onclick="return viewClient();">VIEW PROJECT DETAILS</button></h4>
		</div>
		</div>
	
		<div class="col-md-3 col-sm-6 text-center">
		<div style="margin-left: -87px;">
		<h4><button class="management_submit_Btn" id="viewMessageId" onclick="return viewMessage();">VIEW MESSAGES</button></h4>
		</div>
		</div>
		
		<div class="col-md-3 col-sm-6 text-left">
		<div style="margin-left: -78px;">
		<h4><button class="req_new_cl_submit_Btn" id="viewNewReqId">REQUEST NEW CLIENT</button></h4>
		</div>
		</div>
		
        <font color="white" id="text" size="3"></font>
		 
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        <div class="row top_adjustment_25">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-4 col-sm-4 text-left">
		<div style="margin-left: 60px;">
		<h4><button class="management_submit_Btn" id="viewClientId" onclick="return archive();">ARCHIVE</button></h4>
		</div>
		</div>
	
		<div class="col-md-7 col-sm-7">
        </div> <!-- /.col-md-7 -->        
        </div> <!-- /.row -->
        
        <input type="hidden" name="clientMessageRefType"/>		
        </form>
        
        
        <div class="row top_adjustment_20">
        <div class="col-md-8 col-sm-8">
        </div> <!-- /.col-md-8 --> 
        		
		<div class="col-md-3 col-sm-6 text-left">
		<div style="margin-left: -78px; margin-top: -60px;">
		<form action="newClientRequestCancelFromAdmin">
		<h4><button class="req_cancel_cl_submit_Btn" id="cancelReqBUttId">CANCEL REQUEST</button></h4>
		</form>
		</div>
		</div>
		
        <font color="white" id="text" size="3"></font>
		 
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        
        <script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${desnClientsCount}"/>';
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

        function viewClient(){
	        document.designerClients.clientMessageRefType.value = "View Client";
	        var desClienss="";        
		        for(var k=0; k < document.designerClients.desCliens.length; k++) {
			        if(document.designerClients.desCliens[k].checked){
			        	desClienss=document.designerClients.desCliens[k].value;        
			        }
		        }
	    
	        if(document.designerClients.desCliens.checked){
	        	desClienss=document.designerClients.desCliens.value;
	        }
	        
	        if(desClienss === ""){
	        	window.alert("Please select a client");
	        return false;
	        } 
        }        

        function viewMessage(){
	        document.designerClients.clientMessageRefType.value = "View Message";
	        var desClienss="";        
		        for(var k=0; k < document.designerClients.desCliens.length; k++) {
			        if(document.designerClients.desCliens[k].checked){
			        	desClienss=document.designerClients.desCliens[k].value;        
			        }
		        }
	    
	        if(document.designerClients.desCliens.checked){
	        	desClienss=document.designerClients.desCliens.value;
	        }
	        
	        if(desClienss === ""){
	        	window.alert("Please select a client");
	        return false;
	        } 
        }

        function archive(){
	        document.designerClients.clientMessageRefType.value = "Archive Clients";
	        var desClienss="";        
		        for(var k=0; k < document.designerClients.desCliens.length; k++) {
			        if(document.designerClients.desCliens[k].checked){
			        	desClienss=document.designerClients.desCliens[k].value;        
			        }
		        }
	    
	        if(document.designerClients.desCliens.checked){
	        	desClienss=document.designerClients.desCliens.value;
	        }
	        
	        if(desClienss === ""){
	        	window.alert("Please select a client");
	        return false;
	        } 
        }
        
        </script>
        
        <script type="text/javascript" src="resources/js/tablelayout.js"></script>
                	
		</body>
</html>