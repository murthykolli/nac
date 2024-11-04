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

    	$('#insured_list tr').each(function() {
    		$('.desnStatusCl:contains("HAVE A CLIENT")').css('color', 'green');
    		$('.newUploadsAlertCl:contains("YES")').css('color', 'red');
    		$('.desnMessageCl:contains("NEW")').css('color', 'red');
    	});
    	
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='designerInfoSavingId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF","cursor":"pointer"});
    		    $('.desnStatusCl:contains("HAVE A CLIENT")').css('color', 'green');
    		    $('.newUploadsAlertCl:contains("YES")').css('color', 'red');
        		$('.desnMessageCl:contains("NEW")').css('color', 'red');
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='designerInfoSavingId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    $('.desnStatusCl:contains("HAVE A CLIENT")').css('color', 'green');
    		    $('.newUploadsAlertCl:contains("YES")').css('color', 'red');
        		$('.desnMessageCl:contains("NEW")').css('color', 'red');
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF"}); 
    		    $(this).find("input[name='designerInfoSavingId']").prop("checked",true);
    		    $('.desnStatusCl:contains("HAVE A CLIENT")').css('color', 'green');
    		    $('.newUploadsAlertCl:contains("YES")').css('color', 'red');
        		$('.desnMessageCl:contains("NEW")').css('color', 'red');
    		    });
    
    var inactiveDesCount =  '<c:out value='${inactiveDesnCount}'/>';
   	
    if(inactiveDesCount > 0) {
        $("#inactiveDesnDspId").show();
    } else {
    	$("#inactiveDesnDspId").hide();
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
    var pagerHtml ='<table border="0" id="navigation" align="left"> <tr><td align="right" width="131">';
    pagerHtml += '<input type="button"  style="position: relative; left: -10px; top: 12px; outline: none;" id="cmdPrevId" name="Prev" value="<-- View Prev" onclick="' + pagerName + '.prev();" class="pg-normal"/>  &nbsp; &nbsp; ';
    pagerHtml += '</td><td width="635">&nbsp;<td>';

    pagerHtml += '<td  align="right">';
    pagerHtml += '<input type="button" style="position: relative; left: 80px; top: 12px; outline: none;" id="cmdNextId" name="Next" value="View Next -->" onclick="'+pagerName+'.next();" class="pg-normal"/>';
    pagerHtml += '</td></tr></table>';
    element.innerHTML = pagerHtml;
    }; }

    var desAlStatus = "<c:out value="${desnClientAlStatus}"/>";    
    if(desAlStatus === "No") {
    	alert("Admin not allocated any clients for this designer");
    }
    
    </script>
    
    <c:if test="${not empty passMessage}">    
    <script type="text/javascript">
    window.alert("Your new Password has been saved"); 
    </script>    
    </c:if>
    
    <c:if test="${not empty dataChanged}">    
    <script type="text/javascript">
    window.alert("Your updated data has been saved"); 
    </script>    
    </c:if>
    
	</head>
	
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
         
          
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <form action="addNewDesigner" name="newDesigner" id="newDesignerId" method="get">
        <div class="col-md-10 col-sm-10">
        <h4><button class="admin_add_new_dsn_submit_Btn" id="viewClientId">ADD NEW DESIGNER</button></h4>
		</div>
		</form>
		                        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-5 col-sm-5">
        <div class="adm_new_cl_head_txt_dsp" align="left">DESIGNER DIRECTORY</div>
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
        <div class="admin_gift_card_current_management">
		<a href="admDesnDirectory"><font class="pendGiftCardCurrentTab">&nbsp;DESIGNER DIRECTORY&nbsp;</font></a> </div>
		
		<div class="admin_gift_card_management" id="inactiveDesnDspId" style="display: none;">
		<a href="admInactiveDesigners"><font class="pendGiftCardCurrentTab">&nbsp;INACTIVE DESIGNERS&nbsp;</font></a> </div>
		</div>
                        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <div id="designerInfoDisplayID" style="display: none;">                 
        <form action="designerDirectoryForClients" name="designerClients" id="designerClientsId" method="get">      
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        
        <display:table  id="insured_list"  class="tablesorter" name="designerDirectorySavingList" style="margin-top: 0px; margin-left: 0px;">
        <display:column headerClass="sortDisabled"><label>            
        <input type="radio" style=" cursor: pointer;" onclick="changeColor(this);" name="designerInfoSavingId" value="${insured_list.userId}"/><span></span></label>
        </display:column>
        <display:column property ="createdDate" title="START DATE" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="firstName" title="DESIGNER NAME"/>
        <display:column class="desnStatusCl" style="font-weight: bold;" property ="desnLocation" title="DESIGNER STATUS" />        
        <display:column class="newUploadsAlertCl" property ="adminType" style="color: red;" title="NEW UPLOADS" />
        <display:column class="desnMessageCl" property ="password" style="color: red;" title="DESIGNER MESSAGE" />
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
		<input type="hidden" name="designerClientType"/> 		            
		</div> <!-- /.col-md-10 -->
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
		
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_20">
        <div class="col-md-2 col-sm-2">
        </div> <!-- /.col-md-3 --> 
        		
		<div class="col-md-2 col-sm-2 text-center">
		<h4><button class="admin_cl_dir_submit_Btn" id="viewClientId" onclick="return view();">VIEW</button></h4>
		</div>
		
		<div class="col-md-2 col-sm-2 text-left">
		<h4><button class="admin_cl_dir_submit_Btn" style="margin-left: -16px;" id="viewMessageId" onclick="return message();">MESSAGE</button></h4>
		</div>
		
		<div class="col-md-2 col-sm-2 text-center">
		<h4><button class="admin_cl_dir_submit_Btn" id="viewProfileId" onclick="return profile();">PROFILE</button></h4>
		</div>
		
		<div class="col-md-2 col-sm-2 text-center">
		<h4><button class="admin_cl_dir_submit_Btn" style="margin-left: 8px;" id="viewInactiveId" onclick="return inactive();">INACTIVE</button></h4>
		</div>
		
		<div class="col-md-2 col-sm-2">
        </div> <!-- /.col-md-3 -->        
        </div> <!-- /.row -->
        </form>
        </div>
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        
        <script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${designerDirectoryListCount}"/>';
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

        function view(){
	        document.designerClients.designerClientType.value = "View Designer Client";
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

        function message(){
	        document.designerClients.designerClientType.value = "Designer Client Message";
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

        function profile(){
	        document.designerClients.designerClientType.value = "Edit Designer Profile";
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

        function inactive(){
	        document.designerClients.designerClientType.value = "Inactive Designer";
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