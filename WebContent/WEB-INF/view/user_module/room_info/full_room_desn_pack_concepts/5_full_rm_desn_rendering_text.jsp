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
 		
 		if(desnMessageSt > 0) {
        	$("#desnMessgeId").show();        	
        } else {
        	$("#desnMessgeId").hide();
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
		        			<li class="current"><a href="fullRmRendering">RENDERING</a><div class="rend_conc_desn_new_img_ds" id="renderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmSecRendering">2nd RENDERING</a><div class="sec_rend_conc_desn_new_img_ds" id="secondRenderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
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
                	
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			<p class="concpts_txt_dsp">IF YOU HAVE PROVIDED FEEDBACK ON YOUR CONCEPTS AND REQUESTED YOUR ROOM RENDERING, YOUR DESIGNER IS PROBABLY WORKING ON IT RIGHT NOW!</p>
        			
        			<p class="concpts_txt_dsp">TAKE A LOOK AT OUR DESIGN PROCESS TIMELINE BELOW TO GET A BETTER IDEA ON WHEN YOUR RENDERING WILL BE READY.</p>        			
        			
        			</div>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        <div class="col-md-6 col-sm-6">
        </div> <!-- /.col-md-6 -->        
        	
        </div> <!-- /.row -->
        
        
        
 <!-- Concepts text display dynamic code start --> 
       
        <div class="row top_adjustment_40">        	
                	
        <div class="col-md-10 col-sm-10">
        <div class="row">
        	<div class="col-md-1 col-sm-1"></div>
	        <div class="col-md-10 col-sm-10">
	        	<div class="row">
	            	<div class="col-md-3 col-sm-3"></div>
	            	<div class="col-md-1 col-sm-1 conc_red_line_dspl"></div>
	            	<div class="col-md-4 col-sm-4 con_time_line_text_dspl">PROJECT TIMELINE</div>
	            	<div class="col-md-1 col-sm-1 conc_red_line_dspl"></div>
	            	<div class="col-md-3 col-sm-3"></div>
	            </div>
	      	</div>
	     	<div class="col-md-1 col-sm-1"></div> 
	 	</div>
	 	
	 	
	 	<div class="row" style="margin-top: 20px;">
        <div align="center" class="col-md-2 col-sm-2 conp_cen_bold_text_dspl" style="margin-top: 20px;">
        SUBMIT<br>QUESTIONNAIRE
        </div>
	    <div class="col-md-2 col-sm-2"></div>
	    <div align="center" class="col-md-3 col-sm-3 conp_cen_bold_text_dspl" style="margin-top: 20px;">
	    RECEIVE&nbsp; CONCEPT<br>BOARDS    	
	    </div>
	    <div class="col-md-2 col-sm-2"></div>
	    <div align="center" class="col-md-3 col-sm-3 conp_cen_bold_text_dspl">
	    RECEIVE<br>ROOM&nbsp; RENDERING&nbsp; &amp;<br>SHOP&nbsp; THE&nbsp; LOOK
	    </div>
	 	</div>
		 		 	
		 	<div class="row" style="top: -30px; position: relative;">        
		    <div class="col-md-2 col-sm-2 conc_dott_point_dspl" align="center">.<div style="border-top: 2px solid black; top: -18px; left: 35px; position: relative; width: 70px;"></div></div>
		    <div align="center" class="col-md-2 col-sm-2 conp_buss_days_text_dspl" style="margin-top: 28px; margin-left: -15px;">
		    4&nbsp; Business&nbsp; Days 	
		    </div>
		    <div class="col-md-3 col-sm-3 conc_dott_point_dspl" align="center"><div style="border-top: 2px solid black; top: 42px; position: relative;"></div>.</div>
		    <div align="center" class="col-md-2 col-sm-2 conp_buss_days_text_dspl" style="margin-top: 30px; margin-left: -15px;">
		    3&nbsp; Business&nbsp; Days
		    </div>
		    <div class="col-md-3 col-sm-3 conc_dott_point_dspl" align="center"><div style="border-top: 2px solid black; top: 42px; left: -52px; position: relative; width: 110px;"></div>.</div>
		 	</div>		 	
	 	
	 	<div class="row" style="top: -20px; position: relative;">
        <div align="center" class="col-md-2 col-sm-2">
        <img src="resources/images/concepts/concept_text_img01.png">
        </div>
	    <div class="col-md-2 col-sm-2"></div>
	    <div align="center" class="col-md-3 col-sm-3">
	    <img src="resources/images/concepts/concept_text_img02.png">   	
	    </div>
	    <div class="col-md-2 col-sm-2"></div>
	    <div align="center" class="col-md-3 col-sm-3">
	    <img src="resources/images/concepts/concept_text_img03.png">
	    </div>
	 	</div>
	    
        </div> <!-- /.col-md-10 -->
        <div class="col-md-2 col-sm-2"></div>
        </div> <!-- /.row --> 
               
 <!-- Concepts text display dynamic code End --> 
           
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
         	
		</body>
</html>