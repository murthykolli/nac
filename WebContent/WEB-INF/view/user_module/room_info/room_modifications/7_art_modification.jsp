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

		$(".typeOfArt").each(function(){
        $(this).click(function(){
        var cliStatus="";
        $(".typeOfArt").on('mouseover',function(){
        $(this).css("opacity","0.3");
        $(this).css('border', 'solid 2px white');
        });
        $(".typeOfArt").on('mouseout',function(){
        $(this).css("opacity","1");
        $(this).css('border', 'solid 2px white');
        });
        if($("#"+this.id+" img").attr("class") === "selected"){
        cliStatus="none";
        $("#typeOfStyleId").val("");
        $("#"+this.id+" img").attr("class","");
        $(this).css("opacity","1");
        $(this).css('border', 'solid 2px white');
        }
        if(cliStatus !== "none"){
        cliStatus="";
        $(".typeOfArt").css("opacity","1");
        $(".typeOfArt").css('border', 'solid 2px white');
        $(".typeOfArt img").attr("class","");
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
 		
		
		var typeOfArt = '<c:out value="${typeOfArt}"/>';        
        document.myDesign.typeOfArt.value = typeOfArt;
        
        if(typeOfArt ==="DESIGNER_CHOICE") {        	
        	$(".type_of_art_cho").css("border-color","#ff3b3b");        	
        } else {
        	$("#"+typeOfArt).css("opacity","0.3").unbind('mouseover').unbind('mouseout');
        	$("#"+typeOfArt).css("border","solid 2px red").unbind('mouseover').unbind('mouseout');
            $("#"+typeOfArt+" img").attr("class","selected");
        }
	
 	});

 	function typtOfArtAppeals(typeOfArt) { 		
 		if(typeOfArt === "DESIGNER_CHOICE") {
 			$(".typeOfArt").css("opacity","1");
 			$(".typeOfArt").css('border', 'solid 2px white');
			document.myDesign.typeOfArt.value = typeOfArt;
			$(".type_of_art_cho").css("border-color","#ff3b3b");
 		} else {
			document.myDesign.typeOfArt.value = typeOfArt;			
			$(".type_of_art_cho").css("border-color","#808080");
 		}
	}
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="art_appl_title-section text-center">
        <h4>WHAT TYPE OF ART APPEALS TO YOU?</h4>                
        </div> <!-- /.title-section -->
        
        <div class="text-center color_text_display">
        <h3>I LIKE ...</h3>                
        </div> <!-- /.title-section -->
         
         <div class="services" style="margin-top: 50px;">         
        	<div class="service-item">                        
            	<div class="service-description">
	        		<div class="typeOfArt" id="FINE_ART" onclick="typtOfArtAppeals('FINE_ART');" ><img src="resources/images/art_appeals/type_of_art_appe_01.png"></div>
	        		<div align="center"><p class="app_art_text_dis">FINE ART</p></div>
        	    </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        
        	<div class="service-item">                        
            	<div class="service-description">
        			<div class="typeOfArt" id="ABSTRACT" onclick="typtOfArtAppeals('ABSTRACT');" ><img src="resources/images/art_appeals/type_of_art_appe_02.png"></div>
        			<div align="center"><p class="app_art_text_dis">ABSTRACT</p></div>
            	</div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        
        	<div class="service-item">                        
            	<div class="service-description">
        			<div class="typeOfArt" id="PHOTOGRAPHY" onclick="typtOfArtAppeals('PHOTOGRAPHY');" ><img src="resources/images/art_appeals/type_of_art_appe_03.png"></div>
        			<div align="center"><p class="app_art_text_dis">PHOTOGRAPHY</p></div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        
        	<div class="service-item">                        
            	<div class="service-description">
        			<div class="typeOfArt" id="VINTAGE" onclick="typtOfArtAppeals('VINTAGE');" ><img src="resources/images/art_appeals/type_of_art_appe_04.png"></div>
        			<div align="center"><p class="app_art_text_dis">VINTAGE</p></div>       
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        
        	<div class="service-item">                        
            	<div class="service-description">
        			<div class="typeOfArt" id="KIDS_ART" onclick="typtOfArtAppeals('KIDS_ART');" ><img src="resources/images/art_appeals/type_of_art_appe_05.png"></div>
        			<div align="center"><p class="app_art_text_dis">KIDS ART</p></div>       
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        
        	<div class="service-item">                        
            	<div class="service-description">
        			<div class="typeOfArt" id="ORIGINAL_ART" onclick="typtOfArtAppeals('ORIGINAL_ART');" ><img src="resources/images/art_appeals/type_of_art_appe_06.png"></div>
        			<div align="center"><p class="app_art_text_dis">ORIGINAL ART</p></div>       
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div>
        
        <div class="services" align="center" style="margin-top: 40px; margin-left: 215px; margin-right: 215px;">
        	<div class="service-item">                        
            	<div class="service-description text-center">
	        		<div align="center" class="type_of_art_cho" id="DESIGNER_CHOICE" onclick="typtOfArtAppeals('DESIGNER_CHOICE');" >
	        		<p class="art_appl_text_sel_box">I WILL LEAVE IT UP TO MY DESIGNER TO FIND THE BEST FIT FOR THE SPACE!</p>
	        		</div>
        	    </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div>
         
        <div class="form-nav">
            <form action="artManagement" method="get">
                <h4><input class="modi_back_submit_Btn" type="image" title="BACK"
                           src="resources/images/backButton.png"></h4>
            </form>
            <form action="artManagement" name="myDesign" method="get">
			<h4><button class="continue_submit_Btn" id="styleButtonId">SAVE</button></h4>
			<input type="hidden" id="typeOfArtId" name="typeOfArt">
			</form>
        </div>
        
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        <div style="display: none;">
        <p>I WILL LEAVE IT UP TO MY DESIGNER TO FIND THE BEST FIT FOR THE SPACE!</p>
        </div>
    	    	
		</body>
</html>