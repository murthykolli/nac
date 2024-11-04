<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
 
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico">
    <script type="text/javascript" src="resources/js/popup/lightbox-2.6.min.js" ></script>
    <link rel="stylesheet" href="resources/css/popup/lightbox.css" media="screen"/>
     
    <script type="text/javascript">	
    function nextPageDesplay(pageNo) { 		
		var pagNo = parseInt(pageNo);
		var pageNum = pagNo - 1;
		$("#pageDisplyId"+pageNo).show();
		$("#pageDisplyId"+pageNum).hide();		
	}     

    function previousPageDesplay(pageNo) {    	
		var pagNo = parseInt(pageNo);
		var pageNum = pagNo + 1;
		$("#pageDisplyId"+pageNo).show();
		$("#pageDisplyId"+pageNum).hide();
	} 
	</script>
	<style type="text/css">
	img {
	cursor: pointer;
	}
	</style>	  
</head>

	<body>
			
	<div id="mainframe" class="section-content">
  		<div class="container"> 
  		
  		<div class="services" style="padding-bottom: 20px;">
            <div class="service-item">
                <div align="center" class="service-description" style="margin-top: -50px;">
                	<div class="gallery_heading_text_dsp">                    
                    <h1>conceptualize. visualize. realize your dream space...</h1>
                    </div>                    
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->            
        </div>
              
       
               		        
<!-- 1st Page Display Code -->                  
        <div class="row" id="pageDisplyId1">
            <div class="col-md-1 col-sm-1"></div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/1_living_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/1_living_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/1_living_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/1_living_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309" >
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('2');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->        
       
                      		        
<!-- 2nd Page Display Code -->                  
        <div class="row" id="pageDisplyId2" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('1');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/2_reading_nook_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/2_reading_nook_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/2_reading_nook_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/2_reading_nook_rendering_rp_sml.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('3');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row --> 
       
                      		        
<!-- 3rd Page Display Code -->                  
        <div class="row" id="pageDisplyId3" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('2');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/3_bedroom_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/3_bedroom_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/3_bedroom_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/3_bedroom_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('4');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
           
                      		        
<!-- 4rd Page Display Code -->                  
        <div class="row" id="pageDisplyId4" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('3');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/4_dining_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/4_dining_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/4_dining_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/4_dining_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('5');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row --> 
           
                      		        
<!-- 5th Page Display Code -->                  
        <div class="row" id="pageDisplyId5" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('4');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/5_nursery_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/5_nursery_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/5_nursery_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/5_nursery_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('6');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
            
                      		        
<!-- 6th Page Display Code -->                  
        <div class="row" id="pageDisplyId6" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('5');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/6_basement_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/6_basement_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/6_basement_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/6_basement_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('7');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
            
                      		        
<!-- 7th Page Display Code -->                  
        <div class="row" id="pageDisplyId7" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('6');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/7_bedroom_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/7_bedroom_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/7_bedroom_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/7_bedroom_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('8');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
           
                      		        
<!-- 8th Page Display Code -->                  
        <div class="row" id="pageDisplyId8" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('7');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/8_dining_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/8_dining_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/8_dining_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/8_dining_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('9');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row --> 
            
                      		        
<!-- 9th Page Display Code -->                  
        <div class="row" id="pageDisplyId9" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('8');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/9_living_room_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/9_living_room_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/9_living_room_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/9_living_room_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('10');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row --> 
          
                      		        
<!-- 9th Page Display Code -->                  
        <div class="row" id="pageDisplyId9" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('8');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/9_living_room_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/9_living_room_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/9_living_room_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/9_living_room_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('10');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
          
                      		        
<!-- 10th Page Display Code -->                  
        <div class="row" id="pageDisplyId10" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('9');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/10_living_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/10_living_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/10_living_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/10_living_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('11');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row --> 
         
                      		        
<!-- 11th Page Display Code -->                  
        <div class="row" id="pageDisplyId11" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('10');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/11_living_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/11_living_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/11_living_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/11_living_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('12');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
        
                      		        
<!-- 12th Page Display Code -->                  
        <div class="row" id="pageDisplyId12" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('11');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/12_play_area_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/12_play_area_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/12_play_area_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/12_play_area_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('13');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row --> 
         
                      		        
<!-- 13th Page Display Code -->                  
        <div class="row" id="pageDisplyId13" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('12');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/13_bedroom_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/13_bedroom_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/13_bedroom_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/13_bedroom_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('14');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
         
                      		        
<!-- 14th Page Display Code -->                  
        <div class="row" id="pageDisplyId14" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('13');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/14_living_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/14_living_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/14_living_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/14_living_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('15');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
        
                      		        
<!-- 15th Page Display Code -->                  
        <div class="row" id="pageDisplyId15" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('14');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/15_living_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/15_living_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/15_living_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/15_living_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('16');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
        
                      		        
<!-- 16th Page Display Code -->                  
        <div class="row" id="pageDisplyId16" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('15');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/16_dining_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/16_dining_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/16_dining_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/16_dining_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('17');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
         
                      		        
<!-- 17th Page Display Code -->                  
        <div class="row" id="pageDisplyId17" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('16');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/17_bedroom_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/17_bedroom_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/17_bedroom_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/17_bedroom_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('18');"></div>
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
         
                      		        
<!-- 18th Page Display Code -->                  
        <div class="row" id="pageDisplyId18" style="display: none;">
            <div class="col-md-1 col-sm-1">
            	<div align="left"><img align="left" src="outsideImages/gallery/gallery_left_arrow_img.png" class="pf_left_cl_image_adj" onclick="previousPageDesplay('17');"></div>
            </div>	        	            
        	<div class="col-md-4 col-sm-4" style="margin-top: 40px;">
        	<a class="example-image-link" href="outsideImages/gallery/gallery_imgs/18_nursery_concept_lp.jpg" data-lightbox="example-1">
        		<img src="outsideImages/gallery/gallery_imgs/18_nursery_concept_lp.jpg" width="365" height="205">
        	</a>
        		<div align="right" style="margin-top: 12px;"><font class="gallery_con_sl_smltext_lfsdsp">C</font><font class="gallery_con_smltext_lfsdsp">ONCEPT</font></div>        		             
            </div>
            
            <div class="col-md-6 col-sm-6">
            	<div style="border-left: 1px solid red; margin-left: -15px; padding-bottom: 8px;">
            <a class="example-image-link" href="outsideImages/gallery/gallery_imgs/18_nursery_rendering_rp.jpg" data-lightbox="example-1">	
            	<img src="outsideImages/gallery/gallery_imgs/18_nursery_rendering_rp.jpg" style="margin-left: 20px;" width="550" height="309">
            </a>
            	</div> 
            	<div align="right" style="margin-top: 7px;"><font class="gallery_con_sl_smltext_lfsdsp">R</font><font class="gallery_con_smltext_lfsdsp">ENDERING</font></div>       		             
            </div>                            
                                            
            <div class="col-md-1 col-sm-1">
            	<!-- <div align="right"><img src="outsideImages/gallery/gallery_right_arrow_img.png" class="pf_right_cl_image_adj" onclick="nextPageDesplay('19');"></div> -->
	        </div> <!-- /.col-md-1 -->    
        </div> <!-- /.row -->
       
       
       
       
       
       
       
       
    
 		</div> <!-- /.container -->
    </div> <!-- /.site-footer -->
	
</body>
</html>