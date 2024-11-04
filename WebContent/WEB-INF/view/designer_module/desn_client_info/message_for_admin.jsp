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
        
        <div class="row" style="margin-top: -60px;">
        
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
            	
            	<div class="mess_head_tx_dspl">ADMIN</div>
            		<div>   
	                	<img src="resources/images/message_box_frame.jpg" />
                    </div>
            	
            		
            	  <div class="messages messages_display_frame_cl" id="messages">
					<table id="clAndDesnMessageId"></table>					
				  </div>
				  
				  <div class="message_type_display_box_cl">			
						<form action="designerMessageSendToAdmin" name="messageSending" method="post">
						<textarea  name="designerMessageForAdmin" id="designerMessageForAdminId" class="entry" placeholder="Type message here" style="font: 1.15em/1.25em Georgia; color: black; height: 108px;"></textarea>
						<input type="image" id="adminMesButtonId" src="resources/images/designer/message-submit.png" title="SEND" class="message_send_butt_display_cl">
						</form>
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
	 	var desnAndAdminMesList =  '<c:out value='${desAndAdminMessList}'/>';
	 	
	    var desnAndAdminMes = desnAndAdminMesList.split("_,_");
	    var mesInfoDisplayTab = $("#clAndDesnMessageId");
	    
	    for (var i = 0; i < desnAndAdminMes.length; i++){
	    if(desnAndAdminMes[i] !== ""){
	    	var adminAndDesMesg = desnAndAdminMes[i];
	    	
	    	var designerAndAdminMesg1 = adminAndDesMesg.split("__");
	    	var designerAndAdminMesg2 = adminAndDesMesg.split(",_,");
	    	
	    	var leftMessageTextDsp = designerAndAdminMesg2[1];
	    	var leftMessageDateDsp = designerAndAdminMesg2[0];	    	
	    		    	
	    	var rightMessageTextDsp = designerAndAdminMesg1[1];
	    	var rightMessageDateDsp = designerAndAdminMesg1[0];
	    	
	    		    	
	    	if(designerAndAdminMesg2.length > 1){    		
		    	mesInfoDisplayTab.append("<div align='left' class='desn_mess_disp_txt'>" + leftMessageTextDsp + "</div>");
		    	mesInfoDisplayTab.append("<div align='left' class='desn_mess_date_disp_txt'>" + leftMessageDateDsp + "</div>");
	 		}
	    	
	    	if(designerAndAdminMesg1.length > 1){    		
		    	mesInfoDisplayTab.append("<div align='right' class='desn_mess_opp_disp_txt'>" + rightMessageTextDsp + "</div>");
		    	mesInfoDisplayTab.append("<div align='right' class='desn_mess_opp_date_disp_txt'>" + rightMessageDateDsp + "</div>");
		 	} 
	    	
	    }
	    }

		$("#adminMesButtonId").click(function (){	
	        var result = true;
		if($("#designerMessageForAdminId").val() !== ""){			
			result = true;
	        } else{ $("#designerMessageForAdminId").css("border-color","red"); result=false;  } 
		return result;
		});
		
		document.messageSending.elements['designerMessageForAdmin'].focus();

		$(".messages").animate({ scrollTop: $(document).height() }, "slow");
		  return false;
		  		  
		
	    });
	    </script>
	    
		</body>
</html>