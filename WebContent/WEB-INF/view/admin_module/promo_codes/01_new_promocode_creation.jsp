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
    
   		var nameRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; 
   		var numbRegExp = /^[0-9]+$/;
        
        $("#promoCodeSaveId").click(function (){
        var result = true; 
        
        if(nameRegExp.test($("#promoCodeId").val())){ $("#promoCodeId").css("border-color","black");
        } else{ $("#promoCodeId").css("border-color","red"); result=false;
        }
        
        if(numbRegExp.test($("#discountId").val())){ $("#discountId").css("border-color","black");
        } else{ $("#discountId").css("border-color","red"); result=false;
        }
        		
        return result;
        });

        $("#promoCodeId").keyup(function(){
        if(nameRegExp.test(this.value)){ $(this).css("border-color","black");
        } else{ $(this).css("border-color","red");
        } });

        $("#discountId").keyup(function(){
        if(numbRegExp.test(this.value)){ $(this).css("border-color","black");
        } else{ $(this).css("border-color","red");
        } });
        
    	});
        
        </script>
	
	</head>
	
		<body>		
		
		<div id="mainframe" class="section-content">
        <div class="container">            
            <div class="row">            
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6">	                
	                <div class="subtitle-section text-center">
                		<h2>NEW PROMO CODE</h2>                
            		</div> <!-- /.title-section -->
            	</div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->               
            </div> <!-- /.row -->          
			
			<div class="row top_adjustment_30">
			
			<div class="col-md-4">
        	</div> <!-- /.col-md-4-->
        	
			<div class="col-md-4 col-sm-6">
        		<div class="service-item">                        
            		<div class="service-description text-center">		
					<form action="promoCodeDataSaving" name="promoCode" method="get">
					<div align="center">
					<table>					
					<tr><td class="txt_field_disp">Promo Code:</td></tr>		
					<tr><td><input type="text" class="input_box_disp" id="promoCodeId" name="promoCode"> </td></tr>
					
					<tr><td class="txt_field_disp">Discount in %:</td></tr>
					<tr><td><input type="text" class="input_box_disp" id="discountId" name="discount"> </td></tr>
					
					<tr><td class="txt_field_disp">Note:</td></tr>
					<tr><td><input type="text" class="input_box_disp" id="promoNoteId" name="promoNote"> </td></tr>
					
					<tr><td class="promo_code_butt_adj"><h4><button class="continue_submit_Btn" id="promoCodeSaveId">SAVE</button></h4></td></tr>
					</table>
					</div>			
					</form>                
         	   		</div> <!-- /.service-description -->
            	</div> <!-- /.service-item -->               
        	</div> <!-- /.col-md-4 -->
                
            <div class="col-md-4 col-sm-6">                    
            </div> <!-- /.col-md-4 -->               
            </div> <!-- /.row -->            
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->		
		</body>
		
		</body>
</html>
