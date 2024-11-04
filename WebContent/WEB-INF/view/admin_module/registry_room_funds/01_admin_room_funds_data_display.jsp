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
	<link rel="stylesheet" href="resources/css/admin_registry_gift_received_tablelayout.css" type="text/css" />
	
	<script type="text/javascript">
 	$(document).ready(function() {
 		var roomFundsStatusRef1 = "<c:out value="${roomFundsStatusRef}"/>";
 		if(roomFundsStatusRef1 == "Room Funds Data"){
	    	$("#visibleMyOrderId").show();
	    	$("#notVisibleMyOrderId").hide();
	    } else {
	    	$("#notVisibleMyOrderId").show();
	    	$("#visibleMyOrderId").hide();	    	
	    } 		
 	}); 	
    </script>
    
    <script type="text/javascript">
    $(document).ready(function(){    	        
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='admConBoardManagementId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#1560ac","color":"#FFFFFF","cursor":"pointer"});
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='admConBoardManagementId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#1560ac","color":"#FFFFFF"}); 
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
            
      		<div class="row" style="margin-top: 10px; margin-bottom: 70px;">        
				<div class="col-md-6 col-sm-6">
					<div class="row">        
						<div class="col-md-12 col-sm-12" align="left">
					        <table> <tr>
						        <td><a href="regConceptBoards"><font  class="adm_sub_reg_header_black_text_dsp">All Concepts</font></a></td>
							    <!-- <td style="position: relative; left: 18px;"><a href="adminDesignerConcepts"><font class="adm_sub_reg_header_black_text_dsp">Designer Concepts</font></a></td> -->
							    <td style="position: relative; left: 18px;"><a href="adminRegistryStockCheck"><font class="adm_sub_reg_header_black_text_dsp">Stock Check</font></a></td>				        
						    </tr></table>
					    </div>
					</div>
			   	</div>		   	
		   	
		   		<div class="col-md-6 col-sm-6">
		   			<div class="row">        
						<div class="col-md-12 col-sm-12" align="right">
				        	<table> <tr>
				        	<td style="position: relative; left: -36px;"><a href="adminRoomFunds"><font class="adm_sub_reg_header_red_text_dsp">Room Funds</font></a></td>
					        <td style="position: relative; left: -18px;"><a href="adminCashFunds"><font class="adm_sub_reg_header_black_text_dsp">Cash Funds</font></a></td>
					        <td><a href="adminGiftsReceived"><font class="adm_sub_reg_header_black_text_dsp">Gifts Received</font></a></td>
					        </tr></table>
					    </div>
					</div>
			   	</div>
		   	</div>
		   	
		   	     		
        
<!-- No Records in Gift Received Functionality -->
		<div class="row">
	        <div class="col-md-12 col-sm-12" id="notVisibleMyOrderId" style="display: none;">	        	        	

				<div class="row">
					<div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
						<div align="left">        			
							<div class="registry_prof_title top_adjustment_30"><p class="adm_cash_fund_no_data_text">You have not received any contributions towards any gift received yet.</p></div>
				        </div>
				  	</div></div></div>
				</div>					
		
			</div>
		</div>
        
        
<!-- Gift Received Data Display Functionality -->

		<div class="row" id="visibleMyOrderId" style="display: none; margin-top: -15px;">
			<div class="col-md-12 col-sm-12">
				<div align="right">
					<table>
						<tr>
							<td style="font: bold 1.35em/1.25em Georgia; letter-spacing: 2px; color: black;">Total Funds: </td>
							<td style="font: bold 1.35em/1.25em serif; letter-spacing: 2px; color: black;">&nbsp;${totalRoomFundsCount}</td>
						</tr>
					</table>
				</div>
			</div>
				
			<div class="col-md-12 col-sm-12" style="margin-top: 10px;">
				<div align="right">
					<table>
						<tr>
							<td style="font: bold 1.35em/1.25em Georgia; letter-spacing: 2px; color: #1560ac;">Total Amount: </td>
							<td style="font: bold 1.35em/1.25em serif; letter-spacing: 2px; color: #1560ac;">&nbsp;${totalRoomFundsAmount}</td>
						</tr>
					</table>
				</div>
			</div>
			                
        <form action="#" name="admConBoardMant" id="admConBoardMantId" method="get">      
        <div class="row top_adjustment_20">
        
        <div class="col-md-12 col-sm-12">
        
        <display:table  id="insured_list"  class="tablesorter" name="totalRoomFundsDataSavingList" style="margin-top: 0px; margin-left: 0px; min-width: 1120px;">
        <display:column headerClass="sortDisabled">            
        <display:column property ="totalAmount" title="" style="width:50px; font: bold 1.1em/1.25em sans-serif;" /> 
        </display:column>
        <display:column property ="checkoutPaymentStatus" title="Name" />       
        <display:column property ="guestEmail" title="Gift Name" style="text-transform: uppercase; font: 1.1em/1.25em Georgia;" />
        <display:column property ="status" title="From" />        
        <display:column style="width:120px;" property ="createdDate" title="Date" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="roomFundsPrice" title="Amount" style="font: bold 1.1em/1.25em sans-serif;"  />
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
        
        </form>
        </div>
		
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                
        <script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${totalRoomFundsCount}"/>';        
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