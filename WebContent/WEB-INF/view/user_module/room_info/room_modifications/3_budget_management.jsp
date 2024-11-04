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
  
	<!-- CSS files -->
	<link type="text/css" rel="stylesheet" href="resources/css/0_concepts_rendering_frame_resolution.css" />    

	<script type="text/javascript">
 	$(document).ready(function(){
 		var allBudget = '<c:out value="${allocateBudget}"/>'; 		
 			$("[name=budget]").val(allBudget);
 			$("#BUDGET").css("color","red");
 			$("#BUDGET").css('border-bottom','1px solid red');
 			
		 		
 	 		var itemWallArtVal = '<c:out value="${itemWallArtValue}"/>';
 	 		$("#ART").click(function (){
 	 			if(itemWallArtVal === "") {
 	 				alert("YOU HAVE NOT SELECTED ANY WALL ART. TO ADD WALL ART YOU MAY EDIT YOUR FURNITURE SELECTIONS.");
 	 				$("#ART").css("color","black");
 	 				return false;
 	 			}
 	 		});

 	 		var desnPackgeVal = '<c:out value="${typeOfDesignPack}"/>';
 	 		if(desnPackgeVal === "Full Room Design Package"){        	
 	        	$("#accePackageId").hide();
 	        	$("#fullRoomPackageId").show();
 	        } else {
 	        	$("#fullRoomPackageId").hide();
 	        	$("#accePackageId").show();        	
 	        }

 	 		var designerProImage = '<c:out value="${designerProfileImage}"/>';
 	 		
 	 		if(designerProImage === ""){
 	 			$("#designer_info_disp2").hide();
 	        	$("#designer_info_disp1").show();
 	        } else {
 	        	$("#designer_info_disp2").show();
 	        	$("#designer_info_disp1").hide();        	
 	        }
 	 		
 	    });

	</script>
	
    <script type="text/javascript">	
 	$(document).ready(function(){
 		var desnMessageSt = "<c:out value="${desnMessageCount}"/>";
 		var conceptStatus1 = "<c:out value="${conceptStatus}"/>";
 		var renderingStatus1 = "<c:out value="${renderingStatus}"/>";
 		var secondRenderingStatus1 = "<c:out value="${secondRenderingStatus}"/>";
 		var revisedRenderingStatus1 = "<c:out value="${revisedRenderingStatus}"/>";
 		
 		if(desnMessageSt > 0) { 			
        	$("#desnMessgeId").show();
        	$("#frmDesnMessgeId").show();
        } else {        	
        	$("#desnMessgeId").hide();
        	$("#frmDesnMessgeId").hide();
        }
 		
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
        
        <div class="row" id="fullRoomPackageId" style="display: none">
        <div class="col-md-7 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description cl-main-header">
        			<div class="menu0 text-left">
                    	<ul>
		        			<li class="current"><a href="#"><c:out value="${typeOfSpaceVal}"/></a></li>
		        			<li><a href="fullRmConcepts">CONCEPTS</a><div class="conc_desn_new_img_ds" id="conceptStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmRendering">RENDERING</a><div class="rend_conc_desn_new_img_ds" id="renderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmSecRendering">2nd RENDERING</a><div class="sec_rend_conc_desn_new_img_ds" id="secondRenderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmShopRedir">SHOP</a></li>
		        			<li><a href="messageRed">MESSAGES</a><div class="mess_full_desn_new_img_ds" id="frmDesnMessgeId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
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
                    		<li class="current"><a href="#"><c:out value="${typeOfSpaceVal}"/></a></li>
		        			<li><a href="accConcepts">CONCEPTS</a><div class="conc_desn_new_img_ds" id="conceptStatus1Id" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="accFinalConcepts">FINAL CONCEPT</a><div class="fin_conc_desn_new_img_ds" id="renderingStatus1Id" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="accShopRedir">SHOP</a></li>
		        			<li><a href="messageRed">MESSAGES</a><div class="mess_desn_new_img_ds" id="desnMessgeId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>		        			
        				</ul>
                    </div> <!-- /.menu -->   
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-5 col-sm-6">
        </div> <!-- /.col-md-5 -->
        </div> <!-- /.row -->
                   
        
        <div class="row top_adjustment_80">
        	
        <div class="col-md-2 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="right">
        			<table class="room_sty_dis">
        			<tr class="quest_frame_disp"><td><a href="roomManagement" class="ques_links_disp" id="ROOM">ROOM</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="styleManagement" class="ques_links_disp" id="STYLE">STYLE</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="budgetManagement" class="ques_links_disp" id="BUDGET">BUDGET</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="dimensionsManagement" class="ques_links_disp" id="DIMENSIONS">DIMENSIONS</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="colorManagement" class="ques_links_disp" id="COLOR">COLOR</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="furnitureManagement" class="ques_links_disp" id="FURNITURE">FURNITURE</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="artManagement" class="ques_links_disp" id="ART">ART</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="myRoomManagement" class="ques_links_disp" id="MYROOM">MY ROOM</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="inspirationManagement" class="ques_links_disp" id="INSPIRATION">INSPIRATION</a></td></tr>
        			</table>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-2 -->
        	
        <div class="col-md-5 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center" class="quest_bord_frame">
        			<div class="mod_cl_frm_dis"><font color="black">$</font><input type="text" name="budget" readonly class="mod_cl_input"></div>
        			</div>
        			
        			<form action="budgetModification" name="myDesign" method="get">
					<div class="text-center top_adjustment_30">
					<h4><button class="continue_submit_Btn" id="spaceButtonId">EDIT</button></h4>
					</div>
					<input type="hidden" name="budget">
					</form>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-5 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        	
        <div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description admin_profile_frame_adj">
        			<div id="designer_info_disp1" align="center">
        			<div><p class="des_head_disp1">MEET YOUR DESIGNER!</p></div>
        			
        			<div class="des_frame_disp1"><p class="cl_side_dsn_frs_txt_dsp">You will be assigned <br>your very own <br>designer shortly!</p>
					</div>
					</div>
        			
        			<div id="designer_info_disp2" align="center" style="display: none;">
        			<div><p class="des_head_disp2">MEET YOUR DESIGNER!</p></div>
        			
        			<div class="des_prof_imd_disp" align="center">
					<img class="desn_pro_img_reso_dsp_class" src="data:image/jpg;base64,<c:out value='${designerProfileImage}'/>" >
					</div>
					<div align="center"><p class="des_full_name_disply">${desnFullName}</p></div>
					<div align="center"><p class="des_text_disply2"><font class="des_head_txt_disply">DESIGN PHILOSOPHY: </font>${desnProfileBio}</p></div>
					<div align="center"><p class="des_text_disply2"><font class="des_head_txt_disply">LOCATION: </font>${desnLocation}</p></div>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
        	
        </div> <!-- /.row -->
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
         	
		</body>
</html>