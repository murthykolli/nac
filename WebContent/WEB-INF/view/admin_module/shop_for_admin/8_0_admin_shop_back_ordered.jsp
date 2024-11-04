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
	<link rel="stylesheet" href="resources/css/admin_shop_cb_tablelayout.css" type="text/css" />
	
	<style type="text/css">
	.shop_admin_submit_btn { font: 500 1.7em/1.5em Georgia;  vertical-align: middle; background-color: #f2f2f2; color: black; display: inline-block; padding: 7px 50px;  outline: none; border: none; letter-spacing: 2px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.shop_admin_submit_btn:hover { background-color: #ff3b3b; color: white; cursor: pointer; }
	
	.number_circle_format { border-radius: 50%; background-color: #1560ac; border: 2px solid #1560ac; color: white; padding: 0.4em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.10em/1.0em sans-serif; }
	.number_circle_format:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	.number_circle_format_value { overflow: visible; height: 0; margin-top: -1em; }
	
	.number_circle_format_mo { border-radius: 50%; background-color: green; border: 2px solid green; color: white; padding: 0.4em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.10em/1.0em sans-serif; }
	.number_circle_format_mo:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	
	.shop_admin_sub_menu_btn { font: 500 1.6em/1.5em Georgia;  vertical-align: middle; background-color: #f2f2f2; color: black; display: inline-block; padding: 7px 25px;  outline: none; border: none; letter-spacing: 1px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.shop_admin_sub_menu_btn:hover { background-color: #ff3b3b; color: white; cursor: pointer; }
	.shop_admin_sub_menu_red_btn { font: 500 1.6em/1.5em Georgia; vertical-align: middle; background-color: red; color: white; display: inline-block; padding: 7px 25px;  outline: none; border: none; letter-spacing: 1px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	
	</style>
	
	
	<script type="text/javascript">
 	$(document).ready(function() { 		
 		var shopDataVisibleStatus1 = "<c:out value="${shopDataVisibleStatus}"/>";
 		if(shopDataVisibleStatus1 == "Data Visible"){
	    	$("#visibleShopOrderId").show();
	    	$("#unVisibleShopOrderId").hide();
	    } else {
	    	$("#unVisibleShopOrderId").show();
	    	$("#visibleShopOrderId").hide();	    	
	    } 		
 	}); 	
    </script>
    
    <script type="text/javascript">
    $(document).ready(function(){    	        
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='shopCBProductsManagementId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff4949","color":"#FFFFFF","cursor":"pointer"});
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='shopCBProductsManagementId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff4949","color":"#FFFFFF"}); 
    		    $(this).find("input[name='shopCBProductsManagementId']").prop("checked",true);
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
				<div class="col-md-7 col-sm-7">
					<table style="margin-top: 0px;"> 
		      			<tr>
							<td align="left" style="position: relative; left: 120px;"><div class="number_circle_format"><div class="number_circle_format_value">${shopPurchasesCount}</div></div></td>
							<td align="left" style="position: relative; left: 250px;"><div class="number_circle_format"><div class="number_circle_format_value">${shopOrderedCount}</div></div></td>
							<td align="left" style="position: relative; left: 380px;"><div class="number_circle_format"><div class="number_circle_format_value">${shopTrackingCount}</div></div></td>
							<td align="left" style="position: relative; left: 520px;"><div class="number_circle_format"><div class="number_circle_format_value">${shopDeliveredCount}</div></div></td>
						</tr>
					</table>
							
					<table style="margin-top: 6px;"> 
						<tr>
							<td><a href="adminShopPurchases"><font  class="shop_admin_sub_menu_btn">Purchases</font></a></td>
							<td style="position: relative; left: 20px;"><a href="adminShopOrdered"><font  class="shop_admin_sub_menu_btn">Ordered</font></a></td>
							<td style="position: relative; left: 40px;"><a href="adminShopTracking"><font  class="shop_admin_sub_menu_btn">Tracking</font></a></td>
							<td style="position: relative; left: 60px;"><a href="adminShopDelivered"><font  class="shop_admin_sub_menu_btn">Delivered</font></a></td>				        
						</tr>
					</table>
			   	</div>		   	
		   	
		   		<div class="col-md-5 col-sm-5" align="right">
		   			<table> 
		      			<tr>
		      				<td align="left" style="position: relative; left: -180px;"><div class="number_circle_format_mo"><div class="number_circle_format_value">${shopBackOrderedCount}</div></div></td>
							<td align="left" style="position: relative; left: -5px;"><div class="number_circle_format"><div class="number_circle_format_value">${shopOutOfStockCount}</div></div></td>						
						</tr>
					</table>
					
		   			<table style="margin-top: 6px;"> 
		   				<tr>
				        	<td style="position: relative; left: -20px;"><a href="adminShopBackOrdered"><font  class="shop_admin_sub_menu_red_btn">Back Ordered</font></a></td>
				        	<td style="position: relative; left: 0px;"><a href="adminShopOutOfStock"><font  class="shop_admin_sub_menu_btn">Out of Stock</font></a></td>
						</tr>
					</table>
			   	</div>
		   	</div>
		   	
		   			   	
        
<!-- No Records in Gift Received Functionality -->
		<div class="row">
	        <div class="col-md-12 col-sm-12" id="unVisibleShopOrderId" style="display: none;">	        	        	

				<div class="row">
					<div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
						<div align="left">        			
							<div class="registry_prof_title top_adjustment_30"><p class="adm_cash_fund_no_data_text">You have not received any shop data yet.</p></div>
				        </div>
				  	</div></div></div>
				</div>					
		
			</div>
		</div>
        
        
<!-- Gift Received Data Display Functionality -->

		<div class="row" id="visibleShopOrderId" style="display: none; margin-top: -30px;">
			<div class="col-md-12 col-sm-12">
				<div align="right">
					<table>
						<tr>
							<td style="font: bold 1.35em/1.25em Georgia; letter-spacing: 2px; color: black;">Total Orders: </td>
							<td style="font: bold 1.35em/1.25em serif; letter-spacing: 2px; color: black;">&nbsp;${shopBackOrderedCount}</td>
						</tr>
					</table>
				</div>
			</div>
				
			                
        <form action="dminShopBackOrderedViewDetails" name="shopCBFormName" id="shopCBFormNameId" method="get">      
        <div class="row top_adjustment_10">
        
        <div class="col-md-12 col-sm-12">
        
        <display:table  id="insured_list"  class="tablesorter" name="shopCBProductInfoSavingList" style="margin-top: 0px; margin-left: 0px; min-width: 1120px;">
        <display:column headerClass="sortDisabled">            
        	<label> <input type="radio" style=" cursor: pointer;" onclick="changeColor(this);" name="shopCBProductsManagementId" value="${insured_list.shopConceptBoardsProductsInfoSavingId}"/><span></span></label>        
        </display:column>
        <display:column style="width:120px;" property ="createdDate" title="Date" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="storeName" title="Name" />       
        <display:column property ="productName" title="Product" />
        <display:column property ="productPrice" title="Price" />      
        
        <display:column property ="transactionNumber" title="Order No." />
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
		<td><button class="shop_admin_submit_btn" onclick="return viewDetails();">View Details</button></td>		
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
        var count = '<c:out value="${shopBackOrderedCount}"/>';        
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

        function viewDetails(){
        	var shopCBProductsManagementIds="";        
		        for(var k=0; k < document.shopCBFormName.shopCBProductsManagementId.length; k++) {
			        if(document.shopCBFormName.shopCBProductsManagementId[k].checked){
			        	shopCBProductsManagementIds=document.shopCBFormName.shopCBProductsManagementId[k].value;        
			        }
		        }
	    
	        if(document.shopCBFormName.shopCBProductsManagementId.checked){
	        	shopCBProductsManagementIds=document.shopCBFormName.shopCBProductsManagementId.value;
	        }
	        
	        if(shopCBProductsManagementIds === ""){
	        	window.alert("Please select an order.");
	        return false;
	        } 
        }
               
        </script>
        
        <script type="text/javascript" src="resources/js/tablelayout.js"></script>
                	
		</body>
</html>