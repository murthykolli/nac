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
	
	$(document).ready(function(){
		
	    $("#subQuestButtonId").click(function (){	    	
	    	document.myDesign.clAskedDesignerName.value = $("#clAskedDesignerNameId").val();
	    	var otherOptVal = $("#otherNameId").val();
	    	if(otherOptVal != "") {
	    		$("#clHearAboutUsId").val(otherOptVal);
	    	}	    	    	
	    });

	    $(".chooseOptionSelCl").click(function (){	    
	    	$("#otherTextFieldId").hide();
	    	var chooseVal = $(this).val();	    	
	    	$("#clHearAboutUsId").val(chooseVal);
	    	$("#otherNameId").val(null);
	    });
	    
	    $("#otherOptionSelId").click(function (){
	    	var otherVal = $(this).val();	    	
	    	if(otherVal === "Other") {
	        	$("#otherTextFieldId").show();
	        	$("#clHearAboutUsId").val(null);
	        } else {
	        	$("#otherTextFieldId").hide();
	        }	    	
	    });
	});

	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
               
        <div class="just-abt-fin-title-section text-center">
        <h4>JUST ABOUT FINISHED!</h4>                
        </div> <!-- /.title-section -->
         
         <div class="services" align="center" style="margin-top: 50px; margin-left: 220px; margin-right: 220px;">         
         <div align="center" class="just_abt_fin_body_text"><p>HAVE YOU WORKED WITH ONE OF OUR DESIGNERS BEFORE THAT YOU REALLY LIKED?</p></div>
		 </div>
         
         <div class="services" align="center" style="margin-top: 40px; margin-left: 200px; margin-right: 200px;">         
         <div align="center" class="just_abt_fin_body_text"><p>IS THERE A CERTAIN DESIGNER THAT YOU WOULD LIKE TO SPECIFICALLY REQUEST?</p></div>
         </div>
         
         <div class="services" align="center" style="margin-top: 50px; margin-left: 150px; margin-right: 150px;">         
         <div align="center"><p class="just_abt_fin_inp_text">LET US KNOW : <input id="clAskedDesignerNameId" type="text" name="clAskedDesignerName" placeholder="DESIGNER'S NAME" class="just_abt_inputbox_disp"></p></div>
         </div>
         
         <div class="services" align="center" style="margin-top: 50px; margin-left: 150px; margin-right: 150px;">         
         <table>
         <tr><td class="just_abt_fin_inp_text">AND LASTLY, HOW DID YOU HEAR ABOUT US? :&nbsp;</td> 
         	 <td><select name="chooseOneOption" id="chooseOneOptionId" class="just_abt_selectbox_disl">
         	 	 	<option value=''>-------Select one-------</option> <option value='Instagram' class='chooseOptionSelCl'>Instagram</option> <option value='Facebook' class='chooseOptionSelCl'>Facebook</option> <option value='Pinterest' class='chooseOptionSelCl'>Pinterest</option> <option value='YouTube' class='chooseOptionSelCl'>YouTube</option> <option value='Google' class='chooseOptionSelCl'>Google</option> <option value='Thumbtack' class='chooseOptionSelCl'>Thumbtack</option> <option value='Houzz' class='chooseOptionSelCl'>Houzz</option> <option value='Yelp' class='chooseOptionSelCl'>Yelp</option> <option value='Other' id='otherOptionSelId'>Other</option>                                        
             </select>
    	 </td></tr>
    	 <tr style="height: 25px;"><td></td><td></td></tr>
    	 <tr style="display: none;" id="otherTextFieldId"><td class="just_abt_fin_inp_text" style="text-align: right;">Other&nbsp;:&nbsp;</td> 
         	 <td><input id="otherNameId" type="text" name="otherName" class="just_abt_selectbox_disl">
    	 </td></tr>
         
         
         </table>
         </div>
                
        <div class="row top_adjustment_60">		 
        
        <div class="col-md-12 col-sm-12" align="center">        
        	<div class="service-item">                        
            	<div class="service-description">
            	<table><tbody> <tr><td>
            			<form action="reDirShareInspirationUpImgs" method="get">
						<h4><input class="back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
						</form> 
            	   </td>             	
                   <td> <div align="left" class="cont_butt_adj">   
	                	<form action="justAboutFinishedQuestionnaire" name="myDesign" method="get">
						<h4><button class="continue_submit_Btn" id="subQuestButtonId" style="white-space: nowrap;">SUBMIT QUESTIONNAIRE</button></h4>
						<input type="hidden" id="clAskedDesignerNameValId" name="clAskedDesignerName">
						<input type="hidden" id="clHearAboutUsId" name="clHearAboutUs">
						</form>                             
                    </div> </td></tr>
                    
                    <tr><td></td><td><div align="left" class="just_abt_bott_text"><p>(YOU CAN ALWAYS EDIT YOUR ANSWERS VIA <br>YOUR DASHBOARD)</p></div></td></tr>
                    </tbody></table>
                    
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->        
        </div> <!-- /.col-md-6 -->
               		
		</div> <!-- /.row -->   
             
                  
        
         
			          
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
    	    	
		</body>
</html>