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
	<link rel="stylesheet" href="resources/css/admin_registry_login_info_tablelayout.css" type="text/css" />
	
	<style type="text/css">
	.adm_ar_submit_butt_dsp { font: 1.4em/1.25em Georgia; letter-spacing: 2px; color: black; background: white; padding: 8px 30px; border: 1px solid red; text-transform: capitalize; }
	.adm_ar_submit_butt_dsp:hover { color: white; background: red; }
	
	.number_circle_format { border-radius: 50%; background: #1560ac; border: 2px solid #1560ac; color: white; padding: 0.35em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.10em/1.0em sans-serif; }
	.number_circle_format:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	.number_circle_format_value { overflow: visible; height: 0; margin-top: -1em; }
	
	.number_circle_format_mo { border-radius: 50%; background: #203864; border: 2px solid #203864; color: white; padding: 0.35em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.10em/1.0em sans-serif; }
	.number_circle_format_mo:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	
	.number_circle_gc_format { border-radius: 50%; background: #369143; border: 2px solid #369143; color: white; padding: 0.35em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.10em/1.0em sans-serif; }
	.number_circle_gc_format:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	.number_circle_gc_format_mo { border-radius: 50%; background: #176b23; border: 2px solid #176b23; color: white; padding: 0.35em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.10em/1.0em sans-serif; }
	.number_circle_gc_format_mo:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	.adm_cash_fund_no_data_text { font: 2em/1.25em Georgia; letter-spacing: 2px; color: black; }
	.new_clients_no_dsp { font: bold 1.4em/1.25em Georgia; letter-spacing: 1px; color: red; }
	</style>
	    
    <script type="text/javascript">
    $(document).ready(function(){    	        
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='registrantUserLoginInfoId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#1560ac","color":"#FFFFFF","cursor":"pointer"});
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='registrantUserLoginInfoId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    $("#emailDisplayId").find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#1560ac","color":"#FFFFFF"}); 
    		    $(this).find("input[name='registrantUserLoginInfoId']").prop("checked",true);
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
    pagerHtml += '<input type="button" style="position: relative; left: 260px; top: 12px; outline: none;" id="cmdNextId" name="Next" value="View Next -->" onclick="'+pagerName+'.next();" class="pg-normal"/>';
    pagerHtml += '</td></tr></table>';
    element.innerHTML = pagerHtml;
    }; }

    </script>
    
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
            
      		<div class="row" style="margin-top: 0px; margin-bottom: 70px;">        
				<div class="col-md-6 col-sm-6">
					<div class="row">        
						<div class="col-md-12 col-sm-12" align="left">
					        <table> <tr>
						        <td><a href="#"><font  class="adm_sub_reg_header_red_text_dsp">Live Clients</font></a></td>
							    <td style="position: relative; left: 18px;"><a href="registryArchiveStatusRed"><font class="adm_sub_reg_header_black_text_dsp">Archive Clients - <font style="font: bold 1.0em/1.25em Georgia;">${adminRegArchiveCount}</font></font></a></td>							    				        
						    </tr></table>
					    </div>
					</div>
			   	</div>
		   		<div class="col-md-6 col-sm-6">
			   		<div align="right">
						<div class="adm_new_cl_sub_txt_dsp" align="right">Total users: <b id="displayCount" class="new_clients_no_dsp"></b></div>
					</div>
		   		</div>
		   	</div>
		   	
		   	
      		
		   	
                
        
<!-- Gift Received Data Display Functionality -->

		<div class="row" style="margin-top: -35px;">
			               
        <form action="adminRegistryArchiveStatusUpdate" name="registrantLoginInfoForm" id="registrantLoginInfoFormId" method="get">      
        <div class="row">
        
        <div class="col-md-12 col-sm-12">
        
        <display:table  id="insured_list"  class="tablesorter" name="adminRegistryLiveStatusSavingList" style="margin-top: 0px; margin-left: 0px; min-width: 1155px;">
        <display:column headerClass="sortDisabled">            
        	<label> <input type="radio" style=" cursor: pointer;" onclick="changeColor(this);" name="registrantUserLoginInfoId" value="${insured_list.registrantUserId}"/><span></span></label>        
        </display:column>
        <display:column property ="regFirstName" title="REGISTRY NAME" />
        <display:column property ="coRegFirstName" title="CO-REG NAME" />        
        <display:column property ="regUserName" style="font: 1.3em/1.25em Georgia; color: #00a9f1;" title="EMAIL" />
        <display:column property ="eventType" title="EVENT TYPE" />
        <display:column property ="eventDate" title="EVENT DATE" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="status" style="font: bold 1.2em/1.25em Georgia; color: green;" title="LIVE STATUS" />
        <display:column property ="regSocialMedia" title="HOW TO KNOW" />
        <display:column style="width:120px;" property ="createdDate" title="START DATE" format="{0,date,MM/dd/yyyy}" />
        </display:table>
                
		<script type="text/javascript">highlightTableRows("insured_list");</script>			
               
        <script>
        $(document).ready(function() {
        	$("#insured_list").tablesorter({widthFixed: true, widgets: ['pager']}).tablesorterPager({container: $("#pager")});
        } );
        </script>
        
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
		 		            
		</div> <!-- /.col-md-12 -->
		
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_50">
        <div class="col-md-12 col-sm-12" align="center">
        <table> <tbody>
        <tr>
		<td><button class="adm_ar_submit_butt_dsp" onclick="return archive();">Convert to Archive</button></td>		
		</tr>
		</tbody> </table>
		
		</div>
		<div class="col-md-1 col-sm-1"></div>       
        </div> <!-- /.row -->        
        </form>
             
        </div>
		
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                
        <script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${adminRegistryLiveStatusListCount}"/>';        
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

        function archive(){
        	var registrantUserLoginInfoIds="";        
		        for(var k=0; k < document.registrantLoginInfoForm.registrantUserLoginInfoId.length; k++) {
			        if(document.registrantLoginInfoForm.registrantUserLoginInfoId[k].checked){
			        	registrantUserLoginInfoIds=document.registrantLoginInfoForm.registrantUserLoginInfoId[k].value;        
			        }
		        }
	    
	        if(document.registrantLoginInfoForm.registrantUserLoginInfoId.checked){
	        	registrantUserLoginInfoIds=document.registrantLoginInfoForm.registrantUserLoginInfoId.value;
	        }
	        
	        if(registrantUserLoginInfoIds === ""){
	        	window.alert("Please select the client.");
	        return false;
	        } 
        }
               
        </script>
        
        <script type="text/javascript" src="resources/js/tablelayout.js"></script>
                	
		</body>
</html>