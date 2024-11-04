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
	function numeralsOnly(e) {
        var key; var keychar;
        if (window.event) key = window.event.keyCode;
        else if (e) key = e.which;
        else return true;
        keychar = String.fromCharCode(key);
        if ((key === null) || (key === 0) || (key === 8) ||  (key === 9) || (key === 13) || (key === 27) || keychar === "x" || keychar === "X" || keychar === "," || keychar === ";") return true;
        else if ((("0123456789").indexOf(keychar) > -1)) return true;
        else return false;
        }
	
	$(document).ready(function(){
		
	    $("#budgetButtonId").click(function (){	    	
	    	if(boxVal === "NOT SURE YET") {
	    		document.myDesign.budget.value = "NOT SURE YET";
	    	} else {
	    		document.myDesign.budget.value = $("#budgetId").val();
	    	}
	    });
	    
	    
	    $("#budgetId").click(function (){	    	
	    	$(".budget_Disp_box").css("border-color","black");	    	
	    });
	    
	    var boxVal;
	    $(".budget_Disp_box").click(function (){	    	
	    	$("[name=allocatedBudget]").val("");
	    	$(".budget_Disp_box").css("border-color","red");
	    	boxVal = "NOT SURE YET";
	    });
	    
		var alcBudget = '<c:out value="${allocateBudget}"/>';
		
		if(alcBudget > 0) {
			$("[name=allocatedBudget]").val(alcBudget);
			$("[name=budget]").val(alcBudget);
		} else if (alcBudget === "NOT SURE YET") {
			$(".budget_Disp_box").css("border-color","red");
			$("[name=budget]").val(alcBudget);
		} else {
			$("[name=budget]").val(alcBudget);
		}
		
	});

	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">            
              
	    <div class="bud-sp-title-section text-center">
        <h4>WHAT IS YOUR BUDGET FOR THE SPACE?</h4>                
        </div> <!-- /.title-section -->
        
        <div class="row">
            <div class="col-md-3 col-sm-3">
            </div>
            
            <div class="col-md-2 col-sm-2">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="left"><img src="resources/images/budget/budget_lights.png"></div>
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-2 -->
        
        <div class="col-md-2 col-sm-2">
        	<div class="service-item">                        
            	<div class="service-description">
			        <div align="left" style=" margin-top: 50px;">
			        <div class="bud_input_div_box_dsp bud_input_div_box_dsp_frame"><input type="text" id="budgetId" name="allocatedBudget"
                                                              class="bud_input_box_dsp" placeholder="0" onkeypress="return numeralsOnly(event);"></div>
			        </div>
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-2 -->
        
        <div class="col-md-5 col-sm-5">
        </div>
        </div>
        
                
        <div class="row top_adjustment_140">
        <div class="col-md-8 col-sm-8">
        	<div class="service-item">                        
            	<div align="right" class="service-description" style="padding-bottom: 200px;">
			        <div class="budget_text_sel_box bud_frame_adjust"><p>I'M NOT SURE YET - I WILL DECIDE <br>AT A LATER POINT</p></div>
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-8 -->
        
        <div class="col-md-4 col-sm-4">
        	<div class="service-item">                        
            	<div align="left" class="service-description">
			        <div align="left" style="margin-top: -250px; margin-left: -30px;"><img src="resources/images/budget/budget_tree.png"></div>
			        
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-it-->
       </div>
       </div>
       
        <div class="form-nav">
            <form action="budgetManagement" method="get">
                <h4><input class="modi_back_submit_Btn" type="image" title="BACK"
                           src="resources/images/backButton.png"></h4>
            </form>
            <form action="budgetManagement" name="myDesign" method="get">
                <h4>
                    <button class="continue_submit_Btn" id="budgetButtonId">SAVE</button>
                </h4>
                <input type="hidden" id="budgetValId" name="budget">
            </form>
        </div>
        						          
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
    	    	
		</body>
</html>