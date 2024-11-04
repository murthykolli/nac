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
 		var desnMessageSt = "<c:out value="${desnMessageCount}"/>";
 		var conceptStatus1 = "<c:out value="${conceptStatus}"/>";
 		var renderingStatus1 = "<c:out value="${renderingStatus}"/>";
 		var secondRenderingStatus1 = "<c:out value="${secondRenderingStatus}"/>";
 		var revisedRenderingStatus1 = "<c:out value="${revisedRenderingStatus}"/>";
 		var desnUserIdRef1 = "<c:out value="${desnUserIdRef}"/>";
 		 		
 		if(desnMessageSt > 0) {
        	$("#desnMessgeId").show();        	
        } else {
        	$("#desnMessgeId").hide();
        }
 		
 		if(desnUserIdRef1 === "No Designer Yet") {
        	$("#desnUserIdRefId").hide();
        	$("#desnUserIdRefTextId").show();
        } else {
        	$("#desnUserIdRefId").show();
        	$("#desnUserIdRefTextId").hide();
        }
 		
 		if(conceptStatus1 === "Approved for Concepts") { 			
        	$("#conceptStatusId").show();
        } else {
        	$("#conceptStatusId").hide();
        }  

 		if(renderingStatus1 === "Approved for Renderings" || revisedRenderingStatus1 === "Approved for Revised Renderings") {
        	$("#renderingStatusId").show();
        } else {
        	$("#renderingStatusId").hide();
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
        
        <div class="row">
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
                
        
        <div class="row">
        <div class="col-md-7 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description cl-main-header">
        			<div class="menu0 text-left">
                    	<ul>
		        			<li><a href="myRoomInformationRed"><c:out value="${typeOfSpaceVal}"/></a></li>
		        			<li><a href="fullRmConcepts">CONCEPTS</a><div class="conc_desn_new_img_ds" id="conceptStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmRendering">RENDERING</a><div class="rend_conc_desn_new_img_ds" id="renderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li class="current"><a href="fullRmSecRendering">2nd RENDERING</a><div class="sec_rend_conc_desn_new_img_ds" id="secondRenderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmShopRedir">SHOP</a></li>
		        			<li><a href="messageRed">MESSAGES</a><div class="mess_full_desn_new_img_ds" id="desnMessgeId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
        				</ul>
                    </div> <!-- /.menu -->
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-5 col-sm-6">
        </div> <!-- /.col-md-5 -->
        </div> <!-- /.row -->
                   
        
        <div class="row top_adjustment_50">        	
                	
        <div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			<p class="sec_rend_concpts_txt_dsp">IF YOU LOVE BOTH OF YOUR CONCEPTS AND ARE HAVING A HARD <br>TIME CHOOSING BETWEEN THEM, YOU MIGHT WANT TO CONSIDER <br>PURCHASING A 2ND RENDERING FOR <b style="font-weight: bold;">$49</b>.</p>        			
        			<p class="sec_rend_concpts_txt_dsp">SEEING BOTH OF YOUR CONCEPTS AS RENDERINGS TAILORED TO <br>YOUR SPACE MIGHT MAKE IT EASIER FOR YOU TO DECIDE AS TO  <br>WHICH ONE IS A BETTER FIT FOR YOU.</p>
        			</div>
        			
        			<div align="left" id="desnUserIdRefTextId" style="display: none;">
        			<p class="sec_rend_concpts_txt_dsp">Once you start the design process you will have the option to purchase a second rendering here.</p>        			
        			<p class="sec_rend_concpts_txt_dsp">Sit tight while your designer works their magic on your concept boards!</p>
        			</div>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-5 col-sm-5">
        </div> <!-- /.col-md-5 -->        
        	
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_70">        	
                	
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left" id="desnUserIdRefId" style="display: none;">
        			<form action="secRenderingConsPaymentRed">
        			<div class="con_sub_butt_adjmnt" > <h4><button class="full_rm_cons_submit_Btn" id="spaceButtonId">PURCHASE 2ND ROOM RENDERING</button></h4> </div>
        			<input type="hidden" name="secRenderPrice" value="49"/>
        			</form>
        			</div>        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        </div> <!-- /.row --> 
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
         	
		</body>
</html>