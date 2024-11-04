<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
 
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/resources/images/ico/favicon.ico">  
    
	<script type="text/javascript">
    window.location.hash=""; window.location.hash="";
    window.onhashchange=function(){window.location.hash="";};    
    window.onload=function(){ window.history.forward(1); };    
    </script>
</head>

<body>
	<div id="mainframe" class="section-content">
		<div class="container">            
            <div class="text-center payment_suc-title-section">
            <h4>THANK YOU FOR YOUR PURCHASE!</h4>
            </div>
            <div class="services">
		      	<div class="service-item">                        
		           	<div align="center" class="service-description">
		           		<p class="fin_ques_dsp_title_cl">GET READY FOR A FUN AND EXCITING DESIGN EXPERIENCE WITH YOUR PERSONAL DESIGNER! WE WILL MATCH YOU WITH A DESIGNER SHORTY BUT DON'T FORGET TO FINISH YOUR QUESTIONNAIRE AS SOON AS POSSIBLE.</p>					
		       	   </div> <!-- /.service-description -->
		    	</div> <!-- /.service-item -->               
			</div>
		       
        <div class="row top_adjustment_60">
            <div class="col-md-12 col-sm-12">
                <form action="paymentSuccessRed" name="myDesign" method="get">
                    <div class="text-center">
                        <h4>
                            <button class="continue_submit_Btn" id="paySucButtonId">CONTINUE MY QUESTIONNAIRE</button>
                        </h4>
                    </div>
                </form>
            </div> <!-- /.col-md-12 -->
        </div> <!-- /.row -->
             
        </div> <!-- /.container -->
    </div> <!-- /.site-footer -->
		
</body>
</html>