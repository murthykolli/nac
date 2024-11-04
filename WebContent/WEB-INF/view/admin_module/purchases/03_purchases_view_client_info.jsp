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
		
    <style type="text/css">    
    .main_head_text_display {
    font: normal 1em/1.25em Georgia; text-align: left; color: black; margin-top: 0px; margin-left: 5px; padding-bottom: 6px;
    }
    .side_headding_text_dsp {
    font: normal 0.9em/1.25em Georgia; text-align: left; color: black; margin-top: 0px; white-space: nowrap;
    }
    .value_text_display {
    font: bold 0.9em/1.25em Georgia; text-align: left; color: black; margin-top: 0px; white-space: nowrap;
    }
    .cl_head_text_display {
    font: bold 1em/1.25em Georgia; text-align: left; color: black; margin-top: 0px; white-space: nowrap;
    }
    
    .frame_display_for_pur {
    min-width: 200px;
    max-width: 900px;
    background-color: white;
    display: table-cell;
    word-wrap: break-word;
    word-break: break-word;
    border: 2px solid black;    
}    
    </style>
     
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
         
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="adm_new_cl_head_txt_dsp" align="left">CLIENT INFO</div>
        </div>
              
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_15">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div class="purchases_clients_info_frame_dsp">
                	
                	
				        <div class="row">				        		
						<div class="col-md-12 col-sm-12">
				        	<div class="service-item">                        
				            	<div class="service-description">                        
				                	<div align="left">
				                	 <p class="admn_pur_cl_bold_hd_text_dsp">${clientFullName}</p>                	 
					                </div>
				            	</div> <!-- /.service-description -->
				        	</div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-12 -->		
				        </div> <!-- /.row -->
        
                	    <div class="row top_adjustment_10">
                	    <div class="col-md-3 col-sm-3">
			        	<div class="service-item">                        
			            	<div class="service-description">                        
			                	<div align="left">
			                	 <p class="admn_pur_cl_nrm_text_dsp">Email:</p> 
			                	 <p class="admn_pur_cl_nrm_text_dsp">Phone Number:</p>
			                	 <p class="admn_pur_cl_nrm_text_dsp">Shipping Address:</p>
			                	 <p class="admn_pur_cl_nrm_text_dsp">Billing Address:</p>			                	 
				                </div>
			            	</div> <!-- /.service-description -->
			        	</div> <!-- /.service-item -->               
			        </div> <!-- /.col-md-3 -->
			        
			        <div class="col-md-9 col-sm-9">
			        	<div class="service-item">                        
			            	<div class="service-description">                        
			                	<div align="left">
			                	<p class="admn_pur_cl_bold_text_dsp">${userName}</p> 
			                	<p class="admn_pur_cl_bold_text_dsp">${phoneNumber}</p>
			                	<p class="admn_pur_cl_bold_text_dsp">${shipAddress1}&nbsp;${shipAddress2},&nbsp;${shipCity},&nbsp;${shipState}&nbsp;${shipZip}</p>
			                	<p class="admn_pur_cl_bold_text_dsp">${billAddress1}&nbsp;${billAddress2},&nbsp;${billCity},&nbsp;${billState}&nbsp;${billZip}</p>			                	
				                </div>
			            	</div> <!-- /.service-description -->
			        	</div> <!-- /.service-item -->               
			        </div> <!-- /.col-md-9 -->			           
                	</div> <!-- /.row --> 
                	
                	
                	
				        <div class="row top_adjustment_15">				        		
						<div class="col-md-12 col-sm-12">
				        	<div class="service-item">                        
				            	<div class="service-description">                        
				                	<div align="left">
				                	 <p class="admn_pur_cl_bold_hd_text_dsp">CC Info:</p>                	 
					                </div>
				            	</div> <!-- /.service-description -->
				        	</div> <!-- /.service-item -->               
				        </div> <!-- /.col-md-12 -->		
				        </div> <!-- /.row -->
                	
                	<div class="row top_adjustment_10">
                	    <div class="col-md-3 col-sm-3">
			        	<div class="service-item">                        
			            	<div class="service-description">                        
			                	<div align="left">
			                	 <p class="admn_pur_cl_nrm_text_dsp">Card Type:</p>
			                	 <p class="admn_pur_cl_nrm_text_dsp">Card Number:</p>
			                	 <p class="admn_pur_cl_nrm_text_dsp">CVV:</p>
			                	 <p class="admn_pur_cl_nrm_text_dsp">Expiration Date:</p>
			                	 <p class="admn_pur_cl_nrm_text_dsp">(MMYYYY)</p>
				                </div>
			            	</div> <!-- /.service-description -->
			        	</div> <!-- /.service-item -->               
			        </div> <!-- /.col-md-3 -->
			        
			        <div class="col-md-9 col-sm-9">
			        	<div class="service-item">                        
			            	<div class="service-description">                        
			                	<div align="left">
			                	<p class="admn_pur_cl_bold_text_dsp">${cardType}&nbsp;</p>
			                	<p class="admn_pur_cl_bold_text_dsp">${payCardNumber}&nbsp;</p>
			                	<p class="admn_pur_cl_bold_text_dsp">${payCvvNumber}&nbsp;</p>
			                	<p class="admn_pur_cl_bold_text_dsp">${expDate}&nbsp;</p>   
				                </div>
			            	</div> <!-- /.service-description -->
			        	</div> <!-- /.service-item -->               
			        </div> <!-- /.col-md-9 -->			           
                	</div> <!-- /.row -->
                	                	 
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-10 -->		
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        
         
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <form action="admnPurchases" method="get">
		<h4><input class="back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
		</form> 
        </div>
              
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
                 
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
		</body>
</html>