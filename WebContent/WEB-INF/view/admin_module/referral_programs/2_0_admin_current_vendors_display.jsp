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
	.referral_admin_submit_btn { font: 500 1.6em/1.5em Georgia;  vertical-align: middle; background-color: #1f4e79; color: white; display: inline-block; padding: 7px 33px;  outline: none; border: none; letter-spacing: 2px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.referral_admin_submit_btn:hover { background-color: red; color: white; cursor: pointer; }
	
	.number_circle_format { border-radius: 50%; background-color: #dbdbdb; color: black; border: 2px solid #d2d2d2; padding: 0.4em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.10em/1.0em sans-serif; }
	.number_circle_format:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	.number_circle_format_value { overflow: visible; height: 0; margin-top: -1em; }
	
	.number_circle_format_mo { border-radius: 50%; background-color: #1560ac; border: 2px solid #1560ac; color: white; padding: 0.4em; display: inline-flex; align-items: center; justify-content: center; font: bold 1.10em/1.0em sans-serif; }
	.number_circle_format_mo:after { content: ''; display: block; height: 0; width: 100%; padding-bottom: 100%; }
	
	.shop_admin_sub_menu_btn { font: 500 1.6em/1.5em Georgia;  vertical-align: middle; background-color: #f2f2f2; color: black; display: inline-block; padding: 7px 25px;  outline: none; border: none; letter-spacing: 1px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	.shop_admin_sub_menu_btn:hover { background-color: red; color: white; cursor: pointer; }
	.shop_admin_sub_menu_red_btn { font: 500 1.6em/1.5em Georgia; vertical-align: middle; background-color: red; color: white; display: inline-block; padding: 7px 25px;  outline: none; border: none; letter-spacing: 1px; cursor: pointer; box-shadow: 3px 3px 3px #c5c5c5; white-space: nowrap; }
	
	</style>
	
	
	<script type="text/javascript">
 	$(document).ready(function() {
 		var refrDataVisibleStatus1 = "<c:out value="${refrDataVisibleStatus}"/>";
 		if(refrDataVisibleStatus1 == "Data Visible"){
	    	$("#visibleShopOrderId").show();
	    	$("#unVisibleShopOrderId").hide();
	    } else {
	    	$("#unVisibleShopOrderId").show();
	    	$("#visibleShopOrderId").hide();	    	
	    }
 		
 		var vendorClientsRef1 = "<c:out value="${vendorClientsRef}"/>";
 		if(vendorClientsRef1 == "Vendor Clients") {
 			alert("No vendor clients selected Referral User."); 			
 		}
 	}); 	
    </script>
    
    <script type="text/javascript">
    $(document).ready(function(){    	        
        $("#insured_list tr").not(':first').hover(
    		    function () {
    		    if(!$(this).find("input[name='referralUserId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff4949","color":"#FFFFFF","cursor":"pointer"});
    		    } },
    		    function () {
    		    if(!$(this).find("input[name='referralUserId']").is(':checked')){
    		    $(this).find('td:not(:first-child)').css({"background-color":"","color":"#000000"});
    		    } } );
    		    $("#insured_list tr").not(':first').click(function(){
    		    $("#insured_list tr td:not(:first-child)").css({"background-color":"","color":"#000000"});   
    		    $(this).find('td:not(:first-child)').css({"background-color":"#ff4949","color":"#FFFFFF"}); 
    		    $(this).find("input[name='referralUserId']").prop("checked",true);
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
    pagerHtml += '<input type="button" style="position: relative; left: 10px; top: 12px; outline: none;" id="cmdNextId" name="Next" value="View Next -->" onclick="'+pagerName+'.next();" class="pg-normal"/>';
    pagerHtml += '</td></tr></table>';
    element.innerHTML = pagerHtml;
    }; }

    </script>
    
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
            
      		<div class="row" style="margin-top: -20px; margin-bottom: 70px;">
      			<div class="col-md-2 col-sm-2"></div>
      		        
				<div class="col-md-8 col-sm-8">				
					<table style="margin-top: 0px;"> 
		      			<tr>
							<td align="left" style="position: relative; left: 180px;"><div class="number_circle_format"><div class="number_circle_format_value">${adminNewApplicantsCount}</div></div></td>
							<td align="left" style="position: relative; left: 392px;"><div class="number_circle_format_mo"><div class="number_circle_format_value">${adminCurrentVendorsCount}</div></div></td>
							<td align="left" style="position: relative; left: 551px;"><div class="number_circle_format"><div class="number_circle_format_value">${adminVisaGiftCardsCount}</div></div></td>
						</tr>
					</table>
							
					<table style="margin-top: 6px;"> 
						<tr>
							<td><a href="adminNewApplicants"><font  class="shop_admin_sub_menu_btn">New Applicants</font></a></td>
							<td style="position: relative; left: 20px;"><a href="adminCurrentVendors"><font class="shop_admin_sub_menu_red_btn">Current Vendors</font></a></td>
							<td style="position: relative; left: 40px;"><a href="adminVisaGiftCards"><font class="shop_admin_sub_menu_btn">Visa Gift Cards</font></a></td>				        
						</tr>
					</table>
			   	 		            
				</div>
		
				<div class="col-md-2 col-sm-2"></div>
		   			   		
		   	</div>
		   	
		   			   	
        
<!-- No Records in Gift Received Functionality -->
		<div class="row">
	        <div class="col-md-12 col-sm-12" id="unVisibleShopOrderId" style="display: none;">	        	        	

				<div class="row">
					<div class="col-md-12 col-sm-12"><div class="service-item"><div class="service-description reg_pro_left_adj_disp">
						<div align="left">        			
							<div class="registry_prof_title top_adjustment_30"><p class="adm_cash_fund_no_data_text">You have not received any referral clients data yet.</p></div>
				        </div>
				  	</div></div></div>
				</div>					
		
			</div>
		</div>
        
        
<!-- Gift Received Data Display Functionality -->

		<div class="row" id="visibleShopOrderId" style="display: none; margin-top: -40px;">						
			                
        <form action="adminCurrentApplicantsInfo" name="referralUserFormName" id="referralUserFormNameId" method="get">      
        <div class="row">
        <div class="col-md-2 col-sm-2"></div>
        
        <div class="col-md-8 col-sm-8">
        
        <display:table  id="insured_list"  class="tablesorter" name="adminCurrentVendorsInfoSavingList" style="margin-top: 0px; margin-left: 0px; width: 750px;">
        <display:column headerClass="sortDisabled" style="width: 50px;">            
        	<label> <input type="radio" style=" cursor: pointer;" onclick="changeColor(this);" name="referralUserId" value="${insured_list.referralUserId}"/><span></span></label>        
        </display:column>
        <display:column style="width:100px;" property ="createdDate" title="Date" format="{0,date,MM/dd/yyyy}" />
        <display:column property ="referralFirstName" title="Name" />
        <display:column property ="referralCouponCode" title="Vendor Code" />
        <display:column property ="wpStatus" title="WP" />
        <display:column style="width:230px;" property ="referralLastName" title="No. of Clients" />        
        </display:table>
                
		<script type="text/javascript">highlightTableRows("insured_list");</script>			
               
        <script>
        $(document).ready(function() {
        	$("#insured_list").tablesorter({widthFixed: true, widgets: ['pager']}).tablesorterPager({container: $("#pager")});
        } );
        </script>       
            
            <div id="pageNavPosition"></div>
            <script type="text/javascript"><!--
            var pager = new Pager('insured_list', 10);
            pager.init();
            pager.showPageNav('pager', 'pageNavPosition');
            pager.showPage(1);
            //--></script>		
		<div class="clearfix"></div>
			
        <font color="white" id="text" size="3"></font>
		 		            
		</div>
		
		<div class="col-md-2 col-sm-2"></div>
		
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_50">
        <div class="col-md-2 col-sm-2"></div>
        
        <div class="col-md-8 col-sm-8" align="center">
        <table> <tbody>
        <tr>
		<td style="position: relative; left: -20px;"><button class="referral_admin_submit_btn" onclick="return viewWPSent();">WP Sent</button></td>
		<td style="position: relative; left: 0px;"><button class="referral_admin_submit_btn" onclick="return viewVendorDetails();">View Vendor Details</button></td>
		<td style="position: relative; left: 20px;"><button class="referral_admin_submit_btn" onclick="return viewVendorClients();">View Vendor Clients</button></td>		
		</tr>
		</tbody> </table>
		
		</div>
		
		<div class="col-md-2 col-sm-2"></div>
        </div> <!-- /.row -->
        <input type="hidden" name="currentApplicantsRef"/>        
        </form>
             
        </div>
		
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
                
        <script type="text/javascript">
        window.onload = function(){
        var count = '<c:out value="${adminCurrentVendorsCount}"/>';        
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

        function viewWPSent() {
        	document.referralUserFormName.currentApplicantsRef.value = "View WP Sent";
        	var referralUserIds="";        
		        for(var k=0; k < document.referralUserFormName.referralUserId.length; k++) {
			        if(document.referralUserFormName.referralUserId[k].checked){
			        	referralUserIds=document.referralUserFormName.referralUserId[k].value;        
			        }
		        }
	    
	        if(document.referralUserFormName.referralUserId.checked){
	        	referralUserIds=document.referralUserFormName.referralUserId.value;
	        }
	        
	        if(referralUserIds === ""){
	        	window.alert("Please select an applicant.");
	        return false;
	        } 
        }

        function viewVendorDetails() {
        	document.referralUserFormName.currentApplicantsRef.value = "View Vendor Details";
        	var referralUserIds="";        
		        for(var k=0; k < document.referralUserFormName.referralUserId.length; k++) {
			        if(document.referralUserFormName.referralUserId[k].checked){
			        	referralUserIds=document.referralUserFormName.referralUserId[k].value;        
			        }
		        }
	    
	        if(document.referralUserFormName.referralUserId.checked){
	        	referralUserIds=document.referralUserFormName.referralUserId.value;
	        }
	        
	        if(referralUserIds === ""){
	        	window.alert("Please select an applicant.");
	        return false;
	        } 
        }
        
        function viewVendorClients() {
        	document.referralUserFormName.currentApplicantsRef.value = "View Vendor Clients";
        	var referralUserIds="";        
		        for(var k=0; k < document.referralUserFormName.referralUserId.length; k++) {
			        if(document.referralUserFormName.referralUserId[k].checked){
			        	referralUserIds=document.referralUserFormName.referralUserId[k].value;        
			        }
		        }
	    
	        if(document.referralUserFormName.referralUserId.checked){
	        	referralUserIds=document.referralUserFormName.referralUserId.value;
	        }
	        
	        if(referralUserIds === ""){
	        	window.alert("Please select an applicant.");
	        return false;
	        } 
        }
               
        </script>
        
        <script type="text/javascript" src="resources/js/tablelayout.js"></script>
                	
		</body>
</html>