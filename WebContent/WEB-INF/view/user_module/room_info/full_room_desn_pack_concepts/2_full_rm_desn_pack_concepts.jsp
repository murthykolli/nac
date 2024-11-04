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
	<link type="text/css" rel="stylesheet" href="resources/css/popup/lightbox.css" />
	<script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
			
	<script type="text/javascript">
	function newAjaxCon3RendCall(likeValue){
		
    	$.ajax({    		
			type : 'POST',
			url : "fullRmConceptsLikeUpdate?status="+likeValue,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {												
			} });	    
    }
    </script>
    
	<script type="text/javascript">
	var likeImagesValue;
 	$(document).ready(function(){
 		likeImagesValue = "<c:out value="${likeImagesValues}"/>";
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
	  
	<script type="text/javascript">
 	$(document).ready(function(){
 		
        	$(".conceptsRenderingPopupDspCl").click(function(){
             
            var idOfHiddenInput = $(this).parent().find('input:hidden:first').attr('id');
            
            var imgRedValue;
            if(idOfHiddenInput === "image1Id") {
            	var image1Path = "<c:out value='${concept1UploadedImage}'/>";            
                imgRedValue = "data:image/jpg;base64," + image1Path;
            } else if(idOfHiddenInput === "image2Id") {
            	var image2Path = "<c:out value='${concept2UploadedImage}'/>";            
                imgRedValue = "data:image/jpg;base64," + image2Path;
            }
            
            $.conceptsRenderingPopup(imgRedValue);
        	});
        	
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
		        			<li class="current"><a href="fullRmConcepts">CONCEPTS</a><div class="conc_desn_new_img_ds" id="conceptStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
		        			<li><a href="fullRmRendering">RENDERING</a><div class="rend_conc_desn_new_img_ds" id="renderingStatusId" style="display: none;"><img src="resources/images/designer/desn_new_img.png"></div></li>
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
         
  <!-- Concept 1 Coding -->              	
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			
        			<div class="row">
        			<div class="col-md-4 col-sm-4">
        			<div align="left"><p class="concepts_dssl_text">CONCEPT #1</p></div>
        			</div> <!-- /.col-md-4 -->
        			
        			<div class="col-md-8 col-sm-8">
        			<div align="right"><p class="concepts_dssl_text">RATE THIS CONCEPT <img class="con_like_img_mou" id="add1FavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="remove1FavConept3" src="resources/images/concepts/like_img.png">   <img class="con_like_img_mou" id="add1FavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="remove1FavConept2" src="resources/images/concepts/like_img.png">   <img class="con_like_img_mou" id="add1FavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="remove1FavConept1" src="resources/images/concepts/like_img.png"> </p></div>
        			</div> <!-- /.col-md-8 -->        			        			
        			</div> <!-- /.row -->
        			
        			
        			<div class="row top_adjustment_10">
        			<div class="col-md-12 col-sm-12">
        			<div align="left"><img class="con_img_mou concept_rend_reso_class" src="data:image/jpg;base64,<c:out value='${concept1UploadedImage}'/>"></div>
        			</div> <!-- /.col-md-12 -->
        			</div> <!-- /.row -->
        			
        			
        			<div class="row top_adjustment_20">
        			<div class="col-md-4 col-sm-4">
        			<div align="left"><a href="fullRmConcept1ViewShopProducts" class="concepts_links_ds">VIEW PRODUCTS</a></div>
        			</div> <!-- /.col-md-6 -->
        			
        			<div class="col-md-8 col-sm-8">
        			<div align="right">
        			<a class="example-image-link" href="data:image/jpg;base64,<c:out value='${concept1UploadedImage}'/>" data-lightbox="example-1">
        			<img class="con_max_pos_ms conceptsRenderingPopupDspCl" src="resources/images/concepts/maxmise_img.png"> <input id="image1Id" type='hidden'/>
        			</a>
        			</div>
        			</div> <!-- /.col-md-8 -->
        			</div> <!-- /.row -->
        			
        			</div>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->
        
        
        
 
  <!-- Concept 2 Coding -->              	
        <div class="col-md-6 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			
        			<div class="row">
        			<div class="col-md-4 col-sm-4">
        			<div align="left"><p class="concepts_dssl_text">CONCEPT #2</p></div>
        			</div> <!-- /.col-md-4 -->
        			
        			<div class="col-md-8 col-sm-8">
        			<div align="right"><p class="concepts_dssl_text">RATE THIS CONCEPT <img class="con_like_img_mou" id="add2FavConept3" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="remove2FavConept3" src="resources/images/concepts/like_img.png">   <img class="con_like_img_mou" id="add2FavConept2" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="remove2FavConept2" src="resources/images/concepts/like_img.png">   <img class="con_like_img_mou" id="add2FavConept1" src="resources/images/concepts/like_mo_img.png" style="display: none;"> <img class="con_like_img_mou" id="remove2FavConept1" src="resources/images/concepts/like_img.png"> </p></div>
        			</div> <!-- /.col-md-8 -->        			        			
        			</div> <!-- /.row -->
        			
        			
        			<div class="row top_adjustment_10">
        			<div class="col-md-12 col-sm-12">
        			<div align="left"><img class="con_img_mou concept_rend_reso_class" src="data:image/jpg;base64,<c:out value='${concept2UploadedImage}'/>"></div>
        			</div> <!-- /.col-md-12 -->
        			</div> <!-- /.row -->
        			
        			
        			<div class="row top_adjustment_20">
        			<div class="col-md-4 col-sm-4">
        			<div align="left"><a href="fullRmConcept2ViewShopProducts" class="concepts_links_ds">VIEW PRODUCTS</a></div>
        			</div> <!-- /.col-md-6 -->
        			
        			<div class="col-md-8 col-sm-8">
        			<div align="right">
        			<a class="example-image-link" href="data:image/jpg;base64,<c:out value='${concept2UploadedImage}'/>" data-lightbox="example-2">
        			<img class="con_max_pos_ms conceptsRenderingPopupDspCl" src="resources/images/concepts/maxmise_img.png"> <input id="image2Id" type='hidden'/>
        			</a>
        			</div>
        			</div> <!-- /.col-md-8 -->
        			</div> <!-- /.row -->
        			
        			</div>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-6 -->    
        	
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_50">
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        	
                	
        <div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center">        			
        			<img src="resources/images/full_room_concepts/full_rm_concepts.png">        			        			        			
        			</div>
        			<table class="flm_rm_table_dsp">
        			<tr> <td class="fl_rm_rend1_but_adj">
        			<form action="renderingConsRequest">
        			<div class="text-center con_sub_butt_adjmnt" > <h4><button class="full_rm_cons_submit_Btn" id="spaceButtonId">&nbsp;&nbsp;ROOM RENDERING PLEASE!&nbsp;&nbsp;</button></h4> </div>
        			</form></td>
        			
        			<td class="fl_rm_rend2_but_adj">
        			<form action="secRenderingConsRequest">
        			<div class="text-center con_sub_butt_adjmnt" > <h4><button class="full_rm_cons_submit_Btn" id="spaceButtonId">2 ROOM RENDERINGS PLEASE!</button></h4> </div>
        			<input type="hidden" name="secRenderPrice" value="49"/>
        			</form>
        			</td></tr>
        			</table>
        			
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-8 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        	
        </div> <!-- /.row -->
              
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
		<script type="text/javascript" src="resources/js/json-minified.js" ></script>
    	<script type="text/javascript" src="resources/js/concepts_like_images_display.js" ></script>
    	
		</body>
</html>

