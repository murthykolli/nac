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
	.top_left_adj1 {
	  position: relative; top: 45px; left: 50px; font: 0.83em/1.5em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase;
	}
	.top_left_adj2 {
	  position: relative; top: 45px; left: 49px; font: 0.83em/1.5em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase;
	}
	.top_left_adj3 {
	  position: relative; top: 45px; left: 45px; font: 0.83em/1.5em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase;
	}
	.top_left_adj4 {
	  position: relative; top: 45px; left: 19px; font: 0.83em/1.5em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase;
	}	
	</style>
	
	<script type="text/javascript">
 	$(document).ready(function(){
 		
 		$("#styleButtonId").click(function (){	
 	    var result = true;
 	    
 	    var otherValue = $("#otherId").val();
	    if(otherValue !== "") {
	    	document.myDesign.typeOfStyle.value = $("#otherId").val();
	    } 	    
 		return result;
 		});
 		

		$(".style").each(function(){
        $(this).click(function(){
        var cliStatus="";
        $(".style").on('mouseover',function(){
        $(this).css("opacity","0.3");
        $(this).css('border', 'solid 2px white');
        });
        $(".style").on('mouseout',function(){
        $(this).css("opacity","1");
        $(this).css('border', 'solid 2px white');
        });
        if($("#"+this.id+" img").attr("class") === "selected"){
        cliStatus="none";
        $("#typeOfStyleId").val("");
        $("#"+this.id+" img").attr("class","");
        $(this).css("opacity","1");
        }
        if(cliStatus !== "none"){
        cliStatus="";
        $(".style").css("opacity","1");
        $(".style").css('border', 'solid 2px white');
        $(".style img").attr("class","");
        $(this).css("opacity","0.3");
        $(this).css('border', 'solid 2px red');        
        $("#"+this.id+" img").attr("class","selected");
        $(this).unbind('mouseover').unbind('mouseout');
        }
        });
        
        $(this).on('mouseover',function(){
        $(this).css("opacity","0.3");
        $(this).css('border', 'solid 2px white');
        });
        $(this).on('mouseout',function(){
        $(this).css("opacity","1");
        $(this).css('border', 'solid 2px white');
        });});
 		
		
		var typeofStyle = '<c:out value="${selectedStyle}"/>';
        $("#"+typeofStyle).css("opacity","0.3").unbind('mouseover').unbind('mouseout');
        $("#"+typeofStyle).css("border","solid 2px red").unbind('mouseover').unbind('mouseout');
        $("#"+typeofStyle+" img").attr("class","selected");
        document.myDesign.typeOfStyle.value = typeofStyle;
        
        if(typeofStyle !== "CLASSIC" && typeofStyle !== "MODERN" && typeofStyle !== "ECLECTIC" && typeofStyle !== "CONTEMPORARY" && typeofStyle !== "NOT_SURE") {
        	$("[name=otherName]").val(typeofStyle);
        	$(".sty-box-frame").css("border-color","#ff3b3b");        	
        } else if (typeofStyle === "NOT_SURE") {
        	$(".style-oth-box2").css("border-color","#ff3b3b");
        }
	
 	});

 	function typeOfStyle(styleName) { 		
 		if(styleName === "OTHER") {
 			$(".style").css("opacity","1");
 			$(".style").css('border', 'solid 2px white');
			document.myDesign.typeOfStyle.value = "";
			$(".sty-box-frame").css("border-color","#ff3b3b");
			$(".style-oth-box2").css("border-color","#808080");
 		} else if(styleName === "NOT_SURE") {
 			$(".style").css("opacity","1");
 			$(".style").css('border', 'solid 2px white');
			document.myDesign.typeOfStyle.value = styleName;
			$(".style-oth-box2").css("border-color","#ff3b3b");
			$(".sty-box-frame").css("border-color","#808080");
 		} else {
			document.myDesign.typeOfStyle.value = styleName;
			$("[name=otherName]").val("");
			$(".sty-box-frame").css("border-color","#808080");
			$(".style-oth-box2").css("border-color","#808080");
 		}
	}
	</script>
	</head>
	
		<body>
<div id="mainframe" class="section-content room-styles">
    <div class="container">

        <div class="style-title-section text-center">
            <h4>WHAT STYLE ARE YOU MORE DRAWN TO?</h4>
        </div> <!-- /.title-section -->
        <div class="services">
            <div class="service-item">
                <div class="service-description"><div class="top_left_adj1">CLASSIC</div>
                    <div class="style" id="CLASSIC" onclick="typeOfStyle('CLASSIC');"><img
                            src="resources/images/style_images/classic.jpg" width="161" height="305"></div>

                    <div align="center" class="top_adjustment_18"><a class="styleOfProductsPopupImg1 style_link_dis"
                                                                     href="#">&nbsp;EXPLORE&nbsp;</a></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description"><div class="top_left_adj2">MODERN</div>
                    <div class="style" id="MODERN" onclick="typeOfStyle('MODERN');"><img
                            src="resources/images/style_images/modern.jpg" width="161" height="305"></div>

                    <div align="center" class="top_adjustment_18"><a class="styleOfProductsPopupImg2 style_link_dis"
                                                                     href="#">&nbsp;EXPLORE&nbsp;</a></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description"><div class="top_left_adj3">ECLECTIC</div>
                    <div class="style" id="ECLECTIC" onclick="typeOfStyle('ECLECTIC');"><img
                            src="resources/images/style_images/eclectic.jpg" width="161" height="305"></div>

                    <div align="center" class="top_adjustment_18"><a class="styleOfProductsPopupImg3 style_link_dis"
                                                                     href="#">&nbsp;EXPLORE&nbsp;</a></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description"><div class="top_left_adj4">CONTEMPORARY</div>
                    <div class="style" id="CONTEMPORARY" onclick="typeOfStyle('CONTEMPORARY');"><img
                            src="resources/images/style_images/contemporary.jpg" width="161" height="305"></div>

                    <div align="center" class="top_adjustment_18"><a class="styleOfProductsPopupImg4 style_link_dis"
                                                                     href="#">&nbsp;EXPLORE&nbsp;</a></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="style-oth-box sty-box-frame"><input type="text" id="otherId" name="otherName"
                                                                    class="style_input_box" placeholder="OTHER"
                                                                    onclick="typeOfStyle('OTHER');"></div>
                    <div class="style-oth-box2 sty-top-adjust"><p onclick="typeOfStyle('NOT_SURE');">I'M NOT SURE<br>WHAT
                        MY<br>DESIGN STYLE<br>IS</p></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->

        </div>
        
        <div class="form-nav">
            <form action="styleBackMove" method="get">
                <h4><input class="back_submit_Btn" type="image" title="BACK"
                           src="resources/images/backButton.png"></h4>
                <input type="hidden" name="typeOfSpace"
                       value="<c:out value='${selectedSpace}'/>">
            </form>
            <form action="selectedStyle" name="myDesign" method="get">
                <h4>
                    <button class="continue_submit_Btn" id="styleButtonId">CONTINUE</button>
                </h4>
                <input type="hidden" id="typeOfStyleId" name="typeOfStyle">
                <input type="hidden" name="typeOfSpace"
                       value="<c:out value='${selectedSpace}'/>">
            </form>
        </div>
        
    </div> <!-- /.container -->
</div> <!-- /.Main Frame -->

<div style="display: none;">
    <p>CLASSIC MODERN ECLECTIC CONTEMPORARY</p>
    <p>CLASSIC DESIGN : A DESIGN STYLE THAT IS MORE TRADITIONAL YET TIMELESS IN ITS APPROACH. PATTERNED AND LAYERED
        FABRICS, FINE CARVED WOOD FURNITURE AND SYMMETRY ARE ALL CHARACTERISTICS OF THIS STYLE.</p>
    <p>MODERN DESIGN : MODERN DESIGN IS ROOTED IN MINIMAL AND STREAMLINED FURNITURE WITH IMPORTANCE GIVEN TO FORM AND
        FUNCTION. MID-CENTURY MODERN AND SCANDINAVIAN DESIGN FALL INTO THIS CATEGORY.</p>
    <p>CONTEMPORARY DESIGN : BOLD DESIGN WITH CONSIDERATION FOR CURRENT TRENDS IS KEY WITH CONTEMPORARY DESIGN.
        FURNITURE WITH CLEAN LINES LEND TO ACASUAL ATMOSPHERE THAT IS PREVALENT IN CONTEMPORARY DESIGN.</p>
    <p>ECLECTIC DESIGN : ECLECTIC STYLE BORROWS FROM A VARIETY OF DESIGN STYLES AND ERAS. CURATING A SPACE WITH
        PATTERNS, TEXTURES AND COLORS THAT FLOW AND COMPLEMENT ONE ANOTHER IS KEY IN PERFECTING AN ECLECTIC SENSE OF
        STYLE.</p>
</div>


<div align="center" id="popupTotalWindowBoxId">
    <div align="center" style="display: none; left:0px; top:0px;" id="imageBackgroundDspId" class="window">
        <div align="center" class="popup_backgrond_img_display_cl">
            <div align="center"><img class="close popup_close_butt_dsp" src="resources/images/popup_close.png"
                                     title="Close"></div>
            <div align="center"><img class="popup_only_image_display_cl" id="bigPortfolio" src=""></div>
        </div>
    </div>
    <div align="center" class="popup_big_backgrond_display_cl" id="popUpBigMaskWindowId" style="display: none;"></div>
</div>

</body>
</html>