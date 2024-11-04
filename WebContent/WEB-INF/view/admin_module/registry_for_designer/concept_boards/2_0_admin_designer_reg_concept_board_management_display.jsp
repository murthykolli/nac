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
	<link rel="stylesheet" href="resources/css/admin_registry_tablelayout.css" type="text/css" />
	
    <script type="text/javascript">
    $(document).ready(function(){    	        
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='admConBoardManagementId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF","cursor":"pointer"});
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='admConBoardManagementId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff3f3f","color":"#FFFFFF"}); 
    		    $(this).find("input[name='admConBoardManagementId']").prop("checked",true);
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
            
        	<div class="row" style="margin-top: 10px; margin-bottom: 80px;">        
				<div class="col-md-6 col-sm-6">
					<div class="row">        
						<div class="col-md-12 col-sm-12" align="left">
					        <table> <tr>
						        <td><a href="regConceptBoards"><font  class="adm_sub_reg_header_black_text_dsp">All Concepts</font></a></td>
							    <td style="position: relative; left: 18px;"><a href="adminDesignerConcepts"><font class="adm_sub_reg_header_red_text_dsp">Designer Concepts</font></a></td>
							    <td style="position: relative; left: 36px;"><a href="adminRegistryStockCheck"><font class="adm_sub_reg_header_black_text_dsp">Stock Check</font></a></td>				        
						    </tr></table>
					    </div>
					</div>
			   	</div>		   	
		   	
		   		<div class="col-md-6 col-sm-6">
		   			<div class="row">        
						<div class="col-md-12 col-sm-12" align="right">
				        	<table> <tr>
				        	<td style="position: relative; left: -36px;"><a href="adminRoomFunds"><font class="adm_sub_reg_header_black_text_dsp">Room Funds</font></a></td>
					        <td style="position: relative; left: -18px;"><a href="adminCashFunds"><font class="adm_sub_reg_header_black_text_dsp">Cash Funds</font></a></td>
					        <td><a href="adminGiftsReceived"><font class="adm_sub_reg_header_black_text_dsp">Gifts Received</font></a></td>
					        </tr></table>
					    </div>
					</div>
			   	</div>
		   	</div>
        
        <div class="row">
        
        <div class="col-md-6 col-sm-6">
	        <div class="row">
	        <div class="col-md-5 col-sm-5">
	        <div class="adm_new_cl_head_txt_dsp" align="left">CONCEPT BOARDS</div>
	        </div>
	                
	        <div class="col-md-7 col-sm-7">
	        <!-- <form action="adminDesignerRegAddNewFinishingTouches">
			<h4><button class="add_ft_reg_con_bod_submit_Btn" style="margin-top: -6px;" id="addBoardsId">ADD FT</button></h4>
			</form> -->
			</div>
			</div>
		</div>
		
        <div class="col-md-6 col-sm-6">
        <div class="adm_new_cl_sub_txt_dsp" align="right">Total rooms: <b id="displayCount" class="new_clients_no_dsp"></b></div>
        </div>
         
        </div> <!-- /.row -->
                
        <form action="adminDesignerRegConceptBoardsManagementRedirect" name="admConBoardMant" id="admConBoardMantId" method="get">      
        <div class="row top_adjustment_30">
        
        <div class="col-md-12 col-sm-12">
        
        <display:table  id="insured_list"  class="tablesorter" name="designerRegConceptBoardsManagementSavingList" style="margin-top: 0px; margin-left: 0px; min-width: 1120px;">
        <display:column headerClass="sortDisabled"><label>            
        <input type="radio" style=" cursor: pointer;" onclick="changeColor(this);" name="admConBoardManagementId" value="${insured_list.adminRegistryConceptBoardsSavingId}"/><span></span></label>
        </display:column>
        <display:column style="width:120px;" property ="createdDate" title="START DATE" format="{0,date,MM/dd/yyyy}" />        
        <display:column property ="room" title="ROOM" />
        <display:column property ="style" title="STYLE" />
        <display:column property ="designerName" title="DESIGNER NAME" />
        <display:column property ="mostPopularCB" title="CB Status" />
        <display:column property ="furnitureSpecsCount" title="SPECS COUNT" />
        <display:column property ="adminApprovalStatus" title="APPROVAL STATUS" />
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
        
        <div class="row top_adjustment_20">
        <div class="col-md-2 col-sm-2"></div>
        
        <div class="col-md-8 col-sm-8">
        <div class="row">
        <div class="col-md-4 col-sm-4 text-center">
		<h4><button class="admin_con_boards_submit_Bttn" id="viewMessageId" onclick="return modifyRoom();">MODIFY ROOM</button></h4>
		</div>
				
		<div class="col-md-4 col-sm-4 text-center">
		<h4><button class="admin_con_boards_submit_Bttn" id="viewMessageId" onclick="return deleteRoom();">DELETE ROOM</button></h4>
		</div>
		
		<div class="col-md-4 col-sm-4 text-center">
		<h4><button class="admin_con_boards_submit_Bttn" id="viewMessageId" onclick="return approvedStatus();">APPROVE</button></h4>
		</div>
		</div>
		
		</div>
		<div class="col-md-2 col-sm-2"></div>       
        </div> <!-- /.row -->
        <input type="hidden" name="typeOfRoomSelection"/>
        </form>
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                
        <script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${designerRegConceptBoardsManagementListCount}"/>';        
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

        function modifyRoom(){
        	document.admConBoardMant.typeOfRoomSelection.value = "Modified Room";
	        var admConBoardManagementIds="";        
		        for(var k=0; k < document.admConBoardMant.admConBoardManagementId.length; k++) {
			        if(document.admConBoardMant.admConBoardManagementId[k].checked){
			        	admConBoardManagementIds=document.admConBoardMant.admConBoardManagementId[k].value;        
			        }
		        }
	    
	        if(document.admConBoardMant.admConBoardManagementId.checked){
	        	admConBoardManagementIds=document.admConBoardMant.admConBoardManagementId.value;
	        }
	        
	        if(admConBoardManagementIds === ""){
	        	window.alert("Please select a room");
	        return false;
	        } 
        }

        function approvedStatus(){
        	document.admConBoardMant.typeOfRoomSelection.value = "Approved Status";
	        var admConBoardManagementIds="";        
		        for(var k=0; k < document.admConBoardMant.admConBoardManagementId.length; k++) {
			        if(document.admConBoardMant.admConBoardManagementId[k].checked){
			        	admConBoardManagementIds=document.admConBoardMant.admConBoardManagementId[k].value;        
			        }
		        }
	    
	        if(document.admConBoardMant.admConBoardManagementId.checked){
	        	admConBoardManagementIds=document.admConBoardMant.admConBoardManagementId.value;
	        }
	        
	        if(admConBoardManagementIds === ""){
	        	window.alert("Please select a room");
	        return false;
	        } 
        }

        function deleteRoom(){
        	document.admConBoardMant.typeOfRoomSelection.value = "Deleted Room";
        	var admConBoardManagementIds="";        
	        for(var k=0; k < document.admConBoardMant.admConBoardManagementId.length; k++) {
		        if(document.admConBoardMant.admConBoardManagementId[k].checked){
		        	admConBoardManagementIds=document.admConBoardMant.admConBoardManagementId[k].value;        
		        }
	        }
    
	        if(document.admConBoardMant.admConBoardManagementId.checked){
	        	admConBoardManagementIds=document.admConBoardMant.admConBoardManagementId.value;
	        }
            if(admConBoardManagementIds != "") {
            	var where_to= confirm("Do you want to delete this room?");
	            if (where_to) {
	            	return true;
	            }
	            else {
	            	return false;
	            }            	
            }
            else {
            	window.alert("Please select a room");
                return false;
            }
        }
        
        </script>
        
        <script type="text/javascript" src="resources/js/tablelayout.js"></script>
                	
		</body>
</html>