<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">    

	<script type="text/javascript">
    $(document).ready(function() { 
    	
    $("#furnitureSpecsDeleteButId").click(function(){
    	var selectedProd = $("input[type='radio'][name='productName']:checked");    	
    	if (selectedProd.length > 0) {    		
    		document.myDesign.storeName.value = selectedProd.val();    	    
    	} else {
    		alert("Please select one product");
    		return false;
    	}    	
    });
    
    $("#furnitureSpecsEditButId").click(function(){
    	var selectedProd = $("input[type='radio'][name='productName']:checked");    	
    	if (selectedProd.length > 0) {    		
    		document.designerForm.finishingTouchesSavingId.value = selectedProd.val();    	    
    	} else {
    		alert("Please select one product");
    		return false;
    	} 
    });
    });

    </script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        
        <div class="col-md-3 col-sm-3">
        </div> <!-- /.col-md-3 -->
        	
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center">
        			<p class="prod_uplod_disp_mana_for_ardcfs">FINISHING TOUCHES - FURNITURE SPECS</p>
        			</div>        			        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        <div class="col-md-3 col-sm-3">
        </div> <!-- /.col-md-3 -->
        </div> <!-- /.row -->
                
        <div class="row top_adjustment_30">
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
        <div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center" class="prod_uplod_fur_spec_display_frame_ardcfs">
        			
        				<div class="row top_adjustment_10">
		        			<div class="col-md-4 col-sm-4">
					        	<div class="service-item">                        
					            	<div class="service-description">
					        			<div align="center" class="totl_prodc_display_frame_ardcfs">
					        				<div class="totl_prodc_text_display_in_ardcfs"><c:out value='${prodTotalCount}'/></div>	        									   
					        			</div>        
					                </div> <!-- /.service-description -->
					            </div> <!-- /.service-item -->               
					        </div> <!-- /.col-md-4 -->
					        
					        		
							<% if (null != session.getAttribute("finishingTouchesIdList")) {
							   @SuppressWarnings("rawtypes")
						       ArrayList finishingTouchesIdsList = (ArrayList) session.getAttribute("finishingTouchesIdList");
						       if (null != finishingTouchesIdsList && finishingTouchesIdsList.size() > 0) {
							
							   if (null != session.getAttribute("finishingTouchesProductNameList")) {
							   @SuppressWarnings("rawtypes")
					           ArrayList ftProductNameList = (ArrayList) session.getAttribute("finishingTouchesProductNameList");
					           if (null != ftProductNameList && ftProductNameList.size() > 0) {
					        %>
					        <div class="col-md-8 col-sm-8">
					        	<div class="service-item">                        
					            	<div class="service-description">
					        			<div align="left" class="produt_cont_disp_frame_ardcfs">
					        			<table> <tbody>
						        			<% for(int i=0;i<finishingTouchesIdsList.size(); i++){  %>
						        			<tr><td style="padding-top: 5px;"><input class="radio_butt_adj_inprod_ardcfs" type="radio" id="productNameId" name="productName" value="<%=finishingTouchesIdsList.get(i)%>"><font class="prodct_text_display_in_ardcfs">&nbsp;&nbsp;PRODUCT NAME:</font>&nbsp;&nbsp;</td> <td class="prodc_value_text_display_in_ardcfs"><%=ftProductNameList.get(i)%></td></tr>
						        			<% } %>
					        			</tbody></table>	        									   
					        			</div>        
					                </div> <!-- /.service-description -->
					            </div> <!-- /.service-item -->               
		        			</div> <!-- /.col-md-8 -->
		        			<% } } } } %>
		        		</div> <!-- /.row -->	
        				        									   
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-10 -->
        	
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
                		
		</div> <!-- /.row -->
		
		<div class="row top_adjustment_30">
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
        <div class="col-md-2 col-sm-2">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
	        			<a href="backToDsnFinishingTouchesRed"><img title="BACK" class="prod_upload_back_butt_adj" src="resources/images/backButton.png"></a>
	        										   
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-2 -->
        
        <div class="col-md-2 col-sm-2"></div>
        
        <div class="col-md-6 col-sm-6">
	        <div class="row">
	        	<div class="col-md-1 col-sm-1">
        		</div> <!-- /.col-md-1 -->
              
		        <div class="col-md-4 col-sm-4">
		        	<div class="service-item">                        
		            	<div class="service-description">
		            		<form action="designerFinishingTouchesDataDelete" name="myDesign" method="get">
		        			<div align="center">	        			
								<h4><button class="ardcfs_con_submit_Btn" id="furnitureSpecsDeleteButId">DELETE</button></h4>													   
		        			</div>
		        			<input type="hidden" id="storeNameId" name="storeName">
		        			</form>        
		                </div> <!-- /.service-description -->
		            </div> <!-- /.service-item -->               
		        </div> <!-- /.col-md-4 -->
		        
		        <div class="col-md-3 col-sm-3">
		        	<div class="service-item">                        
		            	<div class="service-description">
		            		<form action="designerFinishingTouchesEditProducts" name="designerForm" method="get">
		        			<div align="left">	        			
								<h4><button class="ardcfs_con_submit_Btn" id="furnitureSpecsEditButId" style="width: 141px; margin-left: -13px;">EDIT</button></h4>													   
		        			</div>
		        			<input type="hidden" id="finishingTouchesSavingId" name="finishingTouchesSavingId">
		        			</form>        
		                </div> <!-- /.service-description -->
		            </div> <!-- /.service-item -->               
		        </div> <!-- /.col-md-3 -->
		        
		        <div class="col-md-4 col-sm-4">
		        	<div class="service-item">                        
		            	<div class="service-description">
		            		<form action="designerFinishingTouchesAddNewProducts">
		        			<div align="right">	        			
								<h4><button class="ardcfs_con_submit_Btn" id="furnitureSpecsButtonId">ADD NEW</button></h4>													   
		        			</div>
		        			</form>        
		                </div> <!-- /.service-description -->
		            </div> <!-- /.service-item -->               
		        </div> <!-- /.col-md-2 -->
	        </div> <!-- /.row -->
        </div> <!-- /.col-md-6 -->
        	
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
                		
		</div> <!-- /.row -->
		         
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        		
		</body>
</html>