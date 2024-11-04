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
			
	<script type="text/javascript">	
 	$(document).ready(function(){

 		var desnPackgeVal = '<c:out value="${typeOfDesignPack}"/>'; 		
 		if(desnPackgeVal === "Full Room Design Package"){        	
        	$("#accePackageId").hide();
        	$("#fullRoomPackageId").show();
        } else {
        	$("#fullRoomPackageId").hide();
        	$("#accePackageId").show();        	
        }
 		
 		var conceptStatus1 = "<c:out value="${conceptStatus}"/>";
 		var renderingStatus1 = "<c:out value="${renderingStatus}"/>";
 		var secondRenderingStatus1 = "<c:out value="${secondRenderingStatus}"/>";
 		var revisedRenderingStatus1 = "<c:out value="${revisedRenderingStatus}"/>";
 		 		
 		if(conceptStatus1 === "Approved for Concepts") { 			
        	$("#conceptStatusId").show();
        	$("#conceptStatus1Id").show();
        } else {
        	$("#conceptStatusId").hide();
        	$("#conceptStatus1Id").hide();
        }  

 		if(renderingStatus1 === "Approved for Renderings" || revisedRenderingStatus1 === "Approved for Revised Renderings") {
        	$("#renderingStatusId").show();
        	$("#renderingStatus1Id").show();
        } else {
        	$("#renderingStatusId").hide();
        	$("#renderingStatus1Id").hide();
        }  

 		if(secondRenderingStatus1 === "Approved for Second Renderings") {
        	$("#secondRenderingStatusId").show();        	
        } else {
        	$("#secondRenderingStatusId").hide();
        }  

    });
	</script>	
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row" style="margin-top: -60px;">
        <div class="col-md-9 col-sm-9">
        </div> <!-- /.col-md-9 -->
        <div class="col-md-3 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description  start_new_project_but_adj">
            		<form action="getStartedBuss">
						<h4><button class="start_new_project">START A NEW ROOM</button></h4>
					</form>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
        </div> <!-- /.row --> 
        
        <div class="row" id="fullRoomPackageId" style="display: none">
        <div class="col-md-7 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description cl-main-header">
        			<div class="menu0 text-left">
                    	<ul>
		        			<li><a href="myRoomInformationRed"><c:out value="${typeOfSpaceVal}"/></a></li>
		        			<li><a href="fullRmConcepts">CONCEPTS</a><div class="conc_desn_new_img_ds" id="conceptStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmRendering">RENDERING</a><div class="rend_conc_desn_new_img_ds" id="renderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmSecRendering">2nd RENDERING</a><div class="sec_rend_conc_desn_new_img_ds" id="secondRenderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmShopRedir">SHOP</a></li>
		        			<li class="current"><a href="messageRed">MESSAGES</a></li>
        				</ul>
                    </div> <!-- /.menu -->   
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-5 col-sm-6">
        </div> <!-- /.col-md-5 -->
        </div> <!-- /.row -->
        
        
        <div class="row" id="accePackageId" style="display: none">
        <div class="col-md-7 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description cl-main-header">
        			<div class="menu0 text-left">
                    	<ul>
                    		<li><a href="myRoomInformationRed"><c:out value="${typeOfSpaceVal}"/></a></li>
		        			<li><a href="accConcepts">CONCEPTS</a><div class="conc_desn_new_img_ds" id="conceptStatus1Id" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="accFinalConcepts">FINAL CONCEPT</a><div class="fin_conc_desn_new_img_ds" id="renderingStatus1Id" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="accShopRedir">SHOP</a></li>
		        			<li class="current"><a href="messageRed">MESSAGES</a></li>		        			
        				</ul>
                    </div> <!-- /.menu -->   
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-5 col-sm-6">
        </div> <!-- /.col-md-5 -->
        </div> <!-- /.row -->
        
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
        
        <div class="row top_adjustment_50">
        	
        <div class="col-md-1 col-sm-1">
        </div>
        	
        <div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description"> 
            	
            	<div class="mess_head_tx_dspl">${designerFullName}</div>
            		<div>   
	                	<img src="resources/images/message_box_frame.jpg" />
                    </div>
            	
            		
            	  <div class="messages messages_display_frame_cl" id="messages">
					<table id="clAndDesnMessageId"></table>					
				  </div>
				  
				  <div class="message_type_display_box_cl">			
						<form action="clientMessageSendToDesigner" name="messageSending" method="post">
						<textarea  name="clientMessage" id="designerMessageForAdminId" class="entry" placeholder="Type message here" style="font: 1.15em/1.25em Georgia; color: black; height: 108px;"></textarea>
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
	 	var desnAndAdminMesList =  '<c:out value='${clientAndDesMessList}'/>';
	 	
	    var desnAndAdminMes = desnAndAdminMesList.split("_,_");
	    var mesInfoDisplayTab = $("#clAndDesnMessageId");
	    
	    for (var i = 0; i < desnAndAdminMes.length; i++){
	    if(desnAndAdminMes[i] !== ""){
	    	var adminAndDesMesg = desnAndAdminMes[i];
	    	
	    	var designerAndAdminMesg1 = adminAndDesMesg.split("__");
	    	var designerAndAdminMesg2 = adminAndDesMesg.split(",_,");
	    	
	    	var rightMessageTextDsp = designerAndAdminMesg1[1];
	    	var rightMessageDateDsp = designerAndAdminMesg1[0];
	    	
	    	var leftMessageTextDsp = designerAndAdminMesg2[1];
	    	var leftMessageDateDsp = designerAndAdminMesg2[0];	    	
	    		    		    	
	    	if(designerAndAdminMesg1.length > 1){    		
		    	mesInfoDisplayTab.append("<div align='left' class='desn_mess_disp_txt'>" + rightMessageTextDsp + "</div>");
		    	mesInfoDisplayTab.append("<div align='left' class='desn_mess_date_disp_txt'>" + rightMessageDateDsp + "</div>");
	 		}
	    	
	    	if(designerAndAdminMesg2.length > 1){    		
		    	mesInfoDisplayTab.append("<div align='right' class='desn_mess_opp_disp_txt'>" + leftMessageTextDsp + "</div>");
		    	mesInfoDisplayTab.append("<div align='right' class='desn_mess_opp_date_disp_txt'>" + leftMessageDateDsp + "</div>");
		 	} 
	    	
	    }
	    }
    
	    var designerStatus = "<c:out value="${noDesignerStatus}"/>";
		if(designerStatus !== ""){
	    	alert("You will be able to message your designer from here as soon as you have been assigned a designer.");            	
	    }
		
		$("#adminMesButtonId").click(function (){	
	        var result = true;
		if($("#designerMessageForAdminId").val() !== ""){			
			result = true;
	        } else{ $("#designerMessageForAdminId").css("border-color","red"); result=false;  } 
		return result;
		});
		
		document.messageSending.elements['clientMessage'].focus();

		$(".messages").animate({ scrollTop: $(document).height() }, "slow");
		  return false;
		  		  
		
	    });
	    </script>
	     
		</body>
</html>