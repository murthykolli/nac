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

	<style type="text/css">
	.centered {
	  	position: relative; top: 50%; left: 50%; transform: translate(-50%, -50%); font: 0.83em/1.5em Georgia; letter-spacing: 2px; color: black; text-transform: uppercase; 
	}
	.centered:hover {
	  	position: relative; top: 50%; left: 50%; transform: translate(-50%, -50%); font: 0.83em/1.5em Georgia; letter-spacing: 2px; color: red; text-transform: uppercase; 
	}
	</style>
	
	<script type="text/javascript">
 	$(document).ready(function(){
 		
 		var typeofRoom = '<c:out value="${selectedSpace}"/>';
 		var signUpStatus = '<c:out value="${signUpStatus}"/>';
 		
 		if(signUpStatus !== "") {
 			alert("This is signup redirection");
 		}
 		
 		$("#spaceButtonId").click(function (){
 	    var result = true;
 	    var otherValue = $("#otherId").val();
 	    if(otherValue !== "") {
 	    	document.myDesign.typeOfSpace.value = $("#otherId").val();
 	    } 	   
 	    
 		if($("#typeOfSpaceId").val() !== ""){ result = true;
 	    } else{ alert("Please select a room you would like help with. You can also fill in the blank under 'Other' to request a space not mentioned here."); result=false; } 
 		return result;
 		});
 		
        $(".space").each(function(){
        $(this).click(function(){
        var cliStatus="";
        $(".space").on('mouseover',function(){
        $(this).css("border-color","#ff3b3b");
        });
        $(".space").on('mouseout',function(){
        $(this).css("border-color","#808080");
        });
        if($("#"+this.id+" img").attr("class") === "selected"){
        cliStatus="none";
        $("#typeOfSpaceId").val("");
        $("#"+this.id+" img").attr("class","");
        $(this).css("border-color","#808080");
        }
        if(cliStatus !== "none"){
        cliStatus="";
        $(".space").css("border-color","#808080");
        $(".space img").attr("class","");
        $(this).css("border-color","#ff3b3b");
        $("#"+this.id+" img").attr("class","selected");
        $(this).unbind('mouseover').unbind('mouseout');
        }
        });
        $(this).on('mouseover',function(){
        $(this).css("border-color","#ff3b3b");
        });
        $(this).on('mouseout',function(){
        $(this).css("border-color","#808080");
        });});

	
		$("#"+typeofRoom).css("border-color","#ff3b3b").unbind('mouseover').unbind('mouseout');
        $("#"+typeofRoom+" img").attr("class","selected");
        document.myDesign.typeOfSpace.value = typeofRoom;
        if(typeofRoom !=="LIVING_ROOM" && typeofRoom !=="DINING_ROOM" && typeofRoom !=="BEDROOM" && typeofRoom !=="HOME_OFFICE" && typeofRoom !=="REC_ROOM" && typeofRoom !=="NURSERY" && typeofRoom !=="KIDS_BEDROOM" && typeofRoom !=="PLAYROOM" && typeofRoom !=="OUTDOOR_SPACE") {
        	$("[name=otherName]").val(typeofRoom);
        	$(".space-other-box").css("border-color","#ff3b3b");
        }
        
        		
        });

	function typtOfSpace(spaceName) {		
		if(spaceName === "OTHER") {
			$(".space").css("border-color","#808080");
			document.myDesign.typeOfSpace.value = "";
			$(".space-other-box").css("border-color","#ff3b3b");
		} else {
			document.myDesign.typeOfSpace.value = spaceName;
			$("[name=otherName]").val("");
			$(".space-other-box").css("border-color","#808080");
		}
	}
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content get-started">
   		<div class="container">
        <div class="row">
        <div class="spe-title-section text-center">
        	<h4>WHAT SPACE WOULD YOU LIKE HELP WITH?</h4>
        </div> <!-- /.title-section -->
        </div> <!-- /.row -->
                
        <div class="services">
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="LIVING_ROOM" onclick="typtOfSpace('LIVING_ROOM');"><img
                            src="resources/images/space_images/LIVING_ROOM.png" width="161" height="130"><div class="centered">LIVING ROOM</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="DINING_ROOM" onclick="typtOfSpace('DINING_ROOM');"><img
                            src="resources/images/space_images/DINING_ROOM.png" width="161" height="130"><div class="centered">DINING ROOM</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="BEDROOM" onclick="typtOfSpace('BEDROOM');"><img
                            src="resources/images/space_images/BEDROOM.png" width="161" height="130"><div class="centered">BEDROOM</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="HOME_OFFICE" onclick="typtOfSpace('HOME_OFFICE');"><img
                            src="resources/images/space_images/HOME_OFFICE.png" width="161" height="130"><div class="centered">HOME OFFICE</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="REC_ROOM" onclick="typtOfSpace('REC_ROOM');"><img
                            src="resources/images/space_images/REC_ROOM.png" width="161" height="130"><div class="centered">ENTRYWAY</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="NURSERY" onclick="typtOfSpace('NURSERY');"><img
                            src="resources/images/space_images/NURSERY.png" width="161" height="130"><div class="centered">NURSERY</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="KIDS_BEDROOM" onclick="typtOfSpace('KIDS_BEDROOM');"><img
                            src="resources/images/space_images/KIDS_BEDROOM.png" width="161" height="130"><div class="centered">KIDS BEDROOM</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="PLAYROOM" onclick="typtOfSpace('PLAYROOM');"><img
                            src="resources/images/space_images/PLAYROOM.png" width="161" height="130"><div class="centered">PLAY ROOM</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space" id="OUTDOOR_SPACE" onclick="typtOfSpace('OUTDOOR_SPACE');"><img
                            src="resources/images/space_images/OUTDOOR_SPACE.png" width="161" height="130"><div class="centered">OUTDOOR SPACE</div></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="space-other-box"><input type="text" id="otherId" name="otherName"
                                                        class="space_input_box" placeholder="OTHER"
                                                        onclick="typtOfSpace('OTHER');"></div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div> <!-- /.services -->				
		
		<div class="row top_adjustment_50">
            <div class="col-md-12 col-sm-12">
                <form action="selectedSpace" name="myDesign" method="get">
                    <div class="text-center">
                        <h4>
                            <button class="continue_submit_Btn" id="spaceButtonId">CONTINUE</button>
                        </h4>
                    </div>
                    <input type="hidden" id="typeOfSpaceId" name="typeOfSpace">
                </form>
            </div> <!-- /.col-md-12 -->
        </div> <!-- /.row -->
    	</div> <!-- /.container -->
		</div> <!-- /.Main Frame -->	
        
        <div style="display: none;">
        <p>LIVING ROOM   DINING ROOM   BEDROOM  HOME OFFICE  REC ROOM  NURSERY  KIDS BEDROOM  PLAYROOM   OUTDOOR SPACE</p>
        </div>
    	    	
		</body>
</html>