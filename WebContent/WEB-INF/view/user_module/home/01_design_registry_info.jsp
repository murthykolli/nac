<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
        
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
    
    <!-- CSS files -->
    <link rel="stylesheet" type="text/css" href="resources/css/date_picker.css" />
    
    <!-- JS files -->
    <script type="text/javascript" src="resources/js/date_picker_min.js"></script>
    <script type="text/javascript" src="resources/js/designer_registry_validation.js"></script>
    
    <script type="text/javascript">

    $(window).ready(function(){
		$(".datepicker").datepicker({changeMonth: true,changeYear: true});
	});
    </script>
	</head>	
		<body>		
		
		<div id="mainframe" class="section-content">
        <div class="container">            
            <div class="row top_adjustment_10">            
                <div class="col-md-1 col-sm-1">                    
                </div> <!-- /.col-md-1 -->
                
                <div class="col-md-10 col-sm-10">
	        		<div class="service-item">                        
	            		<div class="service-description text-center">
	            			<img src="resources/images/designer_registry/designer_registry_img.png">
	            		
	            			<form action="registryInfoEmailSending">
			            		<div class="dsn_reg_table_frm_disly">
			            		<table>
			            			<tr> <td class="reg_text_fld_disp">NAME:</td> <td class="reg_text_fld_disp"><font class="reg_dsn_left_row_adj1">EMAIL:</font></td> </tr>
			            			<tr> <td><input type="text" name="registerName" id="registerName" class="regbig_feild_adjestmnt"></td> <td><input type="text" name="registerEmail" id="registerEmail" class="regbig_feild_adjestmnt reg_dsn_left_row_adj1"></td> </tr>	            			
			            		</table>
			            		
			            		<table>
			            			<tr> <td class="reg_text_fld_disp">EVENT:</td> <td class="reg_text_fld_disp"><font class="reg_dsn_left_row_adj0">EVENT DATE:</font></td> <td class="reg_text_fld_disp"><font class="reg_dsn_left_row_adj1">PHONE (OPTIONAL):</font></td> </tr>
			            			<tr> <td><input type="text" name="registerEvent" class="regsmall1_feild_adjestmnt"></td> <td><input type="text" name="registerEventDate" readonly class="datepicker regsmall2_feild_adjestmnt reg_dsn_left_row_adj0"></td> <td><input type="text" name="registerPhoneNumber" maxLength="12" id="phoneNumberId" class="regbig_feild_adjestmnt reg_dsn_left_row_adj1" onkeyup="return phoneFormat (event,phoneNumberId)" onkeypress="return numberonly(event,false)"></td> </tr>	            			
			            		</table>
			            		<table class="top_adjustment_40">
			            			<tr> <td><h4><button class="dsn_reg_submit_Btn" id="regDesnSubmitValId">SUBMIT</button></h4></td> </tr>		            				            			
			            		</table>
			            		</div>
		            		</form>
	            		</div> <!-- /.service-description -->
	            	</div> <!-- /.service-item -->               
        		</div> <!-- /.col-md-10 -->
                
                <div class="col-md-1 col-sm-1">                    
                </div> <!-- /.col-md-1 -->            
            </div> <!-- /.row -->            
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
		
		<div style="display: none;">DESIGH REGISTRY <br> THE REGISTRY AT NOOK AND COVE IS LIKE NO OTHER! YOUR PERSONAL DESIGNER 
									WILL WORK CLOSELY WITH YOU IN CURATING SPACES WITH BEAUTIFUL NEW FURNITURE AND DECOR PIECES 
									HANDPICKED JUST FOR YOU! ADD THESE ITEMS TO YOUR REGISTRY AND LET YOUR GUESTS BE PART OF A 
									UNIQUE EXPERIENCE IN CREATING A BEAUTIFUL NEW BEGINNING! <br>
									PROVIDE US WITH SOME INFORMATION ABOUT YOUR EVENT TO LEARN MORE ABOUT THE REGISTRY!
		</div>
		</body>
</html>