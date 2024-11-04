<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="images/ico/favicon.ico" type="image/x-icon">
    <script type="text/javascript" src="resources/js/popup/01_all_popup_window_display.js" ></script>
    
	<style type="text/css">
	.centered {
	  	position: relative; z-index: 1000; top: 50%; left: 50%; transform: translate(-50%, -50%); font: 0.83em/1.5em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; padding-bottom: 5px; 
	}
	.centered:hover {
	  	position: relative; top: 50%; left: 50%; transform: translate(-50%, -50%); font: 0.83em/1.5em Georgia; letter-spacing: 2px; color: red; text-transform: uppercase; 
	}
	</style>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
			    
	    $("#colorButtonId").click(function (){	    	
	    	document.myDesign.typeOfColor.value = typeOfColor;
	    	document.myDesign.likeColor.value = $("#likeColorId").val();
	    	document.myDesign.dislikeColor.value = $("#dislikeColorId").val();
	    });
	    
	    var typeOfColor;
	    $(".color_disp_1").click(function (){	    	
	    	typeOfColor = "NEUTRALS";
	    	$(".color_disp_1").css("border-color","#ff3b3b");
	    	$(".color_disp_2").css("border-color","#494949");
	    	$(".color_disp_3").css("border-color","#494949");
	    	$(".color_disp_4").css("border-color","#494949");
	    });
	    
	    $(".color_disp_2").click(function (){	    	
	    	typeOfColor = "POPS OF COLOR";
	    	$(".color_disp_1").css("border-color","#494949");
	    	$(".color_disp_2").css("border-color","#ff3b3b");
	    	$(".color_disp_3").css("border-color","#494949");
	    	$(".color_disp_4").css("border-color","#494949");
	    });
	    
	    $(".color_disp_3").click(function (){	    	
	    	typeOfColor = "LOTS OF COLOR";
	    	$(".color_disp_1").css("border-color","#494949");
	    	$(".color_disp_2").css("border-color","#494949");
	    	$(".color_disp_3").css("border-color","#ff3b3b");
	    	$(".color_disp_4").css("border-color","#494949");
	    });
	    
	    $(".color_disp_4").click(function (){	    	
	    	typeOfColor = "DESIGNER CHOICE";
	    	$(".color_disp_1").css("border-color","#494949");
	    	$(".color_disp_2").css("border-color","#494949");
	    	$(".color_disp_3").css("border-color","#494949");
	    	$(".color_disp_4").css("border-color","#ff3b3b");
	    });
	    
	    var typeOfColor = '<c:out value="${typeOfColor}"/>';
	    var likeColor = '<c:out value="${likeColor}"/>';
	    var dislikeColor = '<c:out value="${dislikeColor}"/>';
	    
	    if(typeOfColor !== "" && typeOfColor === "NEUTRALS") {
	    	$(".color_disp_1").css("border-color","#ff3b3b");
	    	typeOfColor = "NEUTRALS";
	    } else if(typeOfColor !== "" && typeOfColor === "POPS OF COLOR") {
	    	$(".color_disp_2").css("border-color","#ff3b3b");
	    	typeOfColor = "POPS OF COLOR";
	    } else if(typeOfColor !== "" && typeOfColor === "LOTS OF COLOR") {
	    	$(".color_disp_3").css("border-color","#ff3b3b");
	    	typeOfColor = "LOTS OF COLOR";
	    } else if(typeOfColor !== "" && typeOfColor === "DESIGNER CHOICE") {
	    	$(".color_disp_4").css("border-color","#ff3b3b");
	    	typeOfColor = "DESIGNER CHOICE";
	    }
	    
	    $("[name=likeColor]").val(likeColor);
	    $("[name=dislikeColor]").val(dislikeColor);
		
	});

	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="feel_color_title-section text-center">
        <h4>HOW DO YOU FEEL ABOUT COLOR?</h4>                
        </div> <!-- /.title-section -->
        
        <div class="text-center color_text_display">
        <h3>I LIKE ...</h3>                
        </div> <!-- /.title-section -->
            
        <div class="services" style="margin-top: 50px;">
        <div style="margin-bottom: 25px;">
        	<div class="service-item">                        
            	<div align="center" class="service-description color_disp_1">
            		<img src="resources/images/color_imgs/color_01.png"><div class="centered">NEUTRALS</div>			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div align="center" class="top_adjustment_15"><a class="colorOfProductsPopupImg1 style_link_dis" href="#">&nbsp;EXPLORE&nbsp;</a></div>               
        </div> <!-- /.col-md-3 -->	
        
        <div style="margin-bottom: 25px;">
        	<div class="service-item">                        
            	<div align="center" class="service-description color_disp_2">
            		<img src="resources/images/color_imgs/color_02.png"><div class="centered">POPS OF COLOR</div>
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div align="center" class="top_adjustment_15"><a class="colorOfProductsPopupImg2 style_link_dis" href="#">&nbsp;EXPLORE&nbsp;</a></div>               
        </div> <!-- /.col-md-3 -->
        
        <div style="margin-bottom: 25px;">
        	<div class="service-item">                        
            	<div align="center" class="service-description color_disp_3">
            		<img src="resources/images/color_imgs/color_03.png"><div class="centered">LOTS OF COLOR</div>
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div align="center" class="top_adjustment_15"><a class="colorOfProductsPopupImg3 style_link_dis" href="#">&nbsp;EXPLORE&nbsp;</a></div>               
        </div> <!-- /.col-md-3 -->
        
        <div style="margin-bottom: 25px;">
        	<div class="service-item">                        
            	<div align="center" class="service-description color_disp_4">
            	<div align="center" style="min-width: 210px; padding: 20px; min-height: 154px;">I WANT TO SEE <br>WHAT MY <br>DESIGNER <br>COMES UP WITH <br>FOR ME!</div>
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div align="center" class="top_adjustment_15">&nbsp;</div>             
        </div> <!-- /.col-md-3 -->
        </div> 
        
        <div class="services" align="center" style="margin-top: -10px; margin-left: 250px; margin-right: 250px;">        
        	<div class="service-item">                        
            	<div align="center" class="service-description">
            		<input type="text" name="likeColor" id="likeColorId" placeholder="COLORS I LOVE" class="color-inputbox-disp">
         	   </div> <!-- /.service-description -->
         	   
         	   <div align="center" class="service-description">
            		<input type="text" name="dislikeColor" id="dislikeColorId" placeholder="COLORS I DISLIKE" class="color-inputbox-disp">
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div>
                
        <div class="form-nav">
            <form action="colorManagement" method="get">
                <h4><input class="modi_back_submit_Btn" type="image" title="BACK"
                           src="resources/images/backButton.png"></h4>
            </form>
            <form action="colorManagement" name="myDesign" method="get">
			<h4><button class="continue_submit_Btn" id="colorButtonId">SAVE</button></h4>
			<input type="hidden" id="typeOfColorValId" name="typeOfColor">
			<input type="hidden" id="likeColorValId" name="likeColor">
			<input type="hidden" id="dislikeColorValId" name="dislikeColor">
			</form>
        </div>
        			          
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        <div style="display: none;">
        <p>NEUTRALS  POPS OF COLOR  LOTS OF COLOR   I WANT TO SEE WHAT MY DESIGNER COMES UP WITH FOR ME!</p>
        </div>
    	<script type="text/javascript" src="resources/js/popup/01_all_popup_window_display.js" ></script>
    		
		<div align="center" id="popupTotalWindowBoxId">
        <div align="center" style="display: none; left:0px; top:0px;" id="imageBackgroundDspId" class="window">        
        <div align="center" class="popup_backgrond_img_display_cl">
        <div align="center"><img class="close popup_close_butt_dsp" src="resources/images/popup_close.png" alt="Close" title="Close"></div>
        <div align="center"><img class="popup_only_image_display_cl" id="bigPortfolio" src="" ></div>
        </div>
        </div>
        <div align="center" class="popup_big_backgrond_display_cl" id="popUpBigMaskWindowId" style="display: none;"></div>
        </div>
		</body>
</html>