<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">
		
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left" style="position: absolute; margin-top: 100px;">
        			<img src="resources/images/designer/message_background_img.png" />
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
            		
		</div> <!-- /.row -->
        
        <div class="row">
        
        <div class="col-md-1 col-sm-1">
        </div>
        	
        <div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description"> 
            	
            	<div class="adm_cl_desn_mess_head_tx_dspl">
            	<table><tbody>
            	<tr><td style="width: 230px; color: #00a9f1;" align="left"><font color="white">C: </font>${clientFirstName}</td>
            	<td style="width: 230px; color: red;" align="right"><font color="white">D: </font>${designerFirstName}</td></tr>
            	</tbody></table>
            	
            	</div>
            		<div>   
	                	<img src="resources/images/admin/admin_message_box_frame.png" />
                    </div>
            	
            		
            	  <div class="admin_messages message_frame_adj" id="admin_messages">
					<table id="clientAndDesnMessageId"></table>					
				  </div>
				  
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
		
		<div class="col-md-1 col-sm-1">
        </div>
                		
		</div> <!-- /.row -->
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
		
		<script type="text/javascript">
	 	$(document).ready(function(){	 		
	 	var clientAndDesMesList =  '<c:out value='${clientAndDesMessList}'/>';
	 	var clientAndDesnMes = clientAndDesMesList.split("_,_");
	    var mesInfoDisplayTab = $("#clientAndDesnMessageId");
	    
	    for (var i = 0; i < clientAndDesnMes.length; i++){
	    if(clientAndDesnMes[i] !== ""){
	    	var clientAndDesnMesg = clientAndDesnMes[i];
	    	
	    	var clientAndDesnMesg1 = clientAndDesnMesg.split("__");
	    	var clientAndDesnMesg2 = clientAndDesnMesg.split(",_,");
	    		    	
	    	if(clientAndDesnMesg1.length > 1){    		
		    	mesInfoDisplayTab.append("<div align='right' class='ad_desn_cl_mess_opp_disp_txt'>" + clientAndDesnMesg1[1] + "</div>");
		    	mesInfoDisplayTab.append("<div align='right' class='desn_mess_opp_date_disp_txt'>" + clientAndDesnMesg1[0] + "</div>");
	 		}
	    	
	    	if(clientAndDesnMesg2.length > 1){    		
		    	mesInfoDisplayTab.append("<div align='left' class='ad_desn_cl_mess_disp_txt'>" + clientAndDesnMesg2[1] + "</div>");
		    	mesInfoDisplayTab.append("<div align='left' class='desn_mess_date_disp_txt'>" + clientAndDesnMesg2[0] + "</div>");
		 	} 
	    	
	    }
	    }
		
		$(".admin_messages").animate({ scrollTop: $(document).height() }, "slow");
		  return false;		  		  
		
	    });	 	
	 		 	
	    </script>
	    
		</body>
</html>