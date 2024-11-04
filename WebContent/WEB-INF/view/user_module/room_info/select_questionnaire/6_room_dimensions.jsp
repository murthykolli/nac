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
    
	<script type="text/javascript">
	/* function numeralsOnly(e) {
        var key; var keychar;
        if (window.event) key = window.event.keyCode;
        else if (e) key = e.which;
        else return true;
        keychar = String.fromCharCode(key);
        if ((key === null) || (key === 0) || (key === 8) ||  (key === 9) || (key === 13) || (key === 27) || keychar === "x" || keychar === "X" || keychar === "," || keychar === ";") return true;
        else if ((("0123456789").indexOf(keychar) > -1)) return true;
        else return false;
        } */
	
	$(document).ready(function(){
			    
	    $("#dimentionButtonId").click(function (){	    	
	    	document.myDesign.dimension.value = $("#dimensionId").val();	    	
	    });
	    
	    var spaceDimension = '<c:out value="${spaceDimension}"/>';
	    $("[name=dimension]").val(spaceDimension);
		
	});

	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content room-styles">
    	<div class="container">
        <div class="dimn-title-section text-center">
        <h4>WHAT ARE THE ROOM'S DIMENSIONS?</h4>                
        </div> <!-- /.title-section --> 
        
        <div class="services" style="margin-top: 10px;">
		      	<div class="service-item">                        
		           	<div align="center" class="service-description">
		           		<div align="center" class="dimention_adj" style="top: 140px; left: 0px;position: relative;"><p><input type="text" id="dimensionId" class="dimention_input_box" name="dimension" placeholder="10 x 20"></p></div>
		           		<img src="resources/images/dimention/dimention.png">		           							
		       	   </div> <!-- /.service-description -->
		    	</div> <!-- /.service-item -->               
			</div>           
           
        
        <div class="form-nav">
            <form action="dimensionBackMove" method="get">
                <h4><input class="back_submit_Btn" type="image" title="BACK"
                           src="resources/images/backButton.png"></h4>
            </form>
            <form action="roomDimensions" name="myDesign" method="get">
                <h4>
                    <button class="continue_submit_Btn" id="dimentionButtonId">CONTINUE</button>
                </h4>
                <input type="hidden" id="dimensionValId" name="dimension">
            </form>
        </div>				
		
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
    	    	
		</body>
</html>