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
    $(document).ready(function () {
    var typeOfDeliveryMethod = '<c:out value="${typeOfDeliveryMethod}"/>';
        
    if(typeOfDeliveryMethod === "Gift Box") {
    	$(".addressDataClass").show();    
    } else {
    	$(".emailDataClass").show();
    }
    
    });
    </script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
         
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="adm_new_cl_head_txt_dsp" align="left">GIFT CARDS</div>
        </div>
              
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_20">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_gc_view_bold_hd_text_dsp"><c:out value='${yourName}'/></p>                	 
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-10 -->		
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
         
        <div class="row top_adjustment_15">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
	                	<table>
	                	 <tr><td class="admn_gc_view_nrm_text_dsp" style="height: 25px;">Package:</td></tr> 
	                	 <tr><td class="admn_gc_view_nrm_text_dsp" style="height: 25px;">Price:</td></tr>
	                	 <tr><td class="admn_gc_view_nrm_text_dsp" style="height: 25px;">Merchandise Credit:</td></tr>
	                	 <tr><td class="admn_gc_view_nrm_text_dsp" style="height: 25px;">Type Of Gift Card:</td></tr>
	                	 <tr><td class="admn_gc_view_nrm_text_dsp" style="height: 25px;">Your Email:</td></tr>
	                	 </table>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
	                	<table>
	                	<tr><td class="admn_gc_view_bold_text_dsp" style="height: 25px;"><c:out value='${typeOfPackage}'/></td></tr> 
	                	<tr><td class="admn_gc_view_bold_text_dsp" style="height: 25px;"><c:out value='${packagePrice}'/></td></tr>
	                	<tr><td class="admn_gc_view_bold_text_dsp" style="height: 25px;"><c:out value='${merchandiseCredit}'/></td></tr>
	                	<tr><td class="admn_gc_view_bold_text_dsp" style="height: 25px;"><c:out value='${typeOfGiftcard}'/></td></tr>
	                	<tr><td class="admn_gc_view_bold_text_dsp" style="height: 25px;"><c:out value='${yourEmail}'/></td></tr>
	                	</table>   
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->		
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_15">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_gc_view_nrm_text_dsp addressDataClass" style="display: none;">Gift box or email:</p> 
                	 <p class="admn_gc_view_nrm_text_dsp emailDataClass" style="display: none;">Gift box or email:</p>
                	 <p class="admn_gc_view_nrm_text_dsp addressDataClass" style="display: none;">Name:</p>
                	 <p class="admn_gc_view_nrm_text_dsp addressDataClass" style="display: none;">Address:</p>
                	 <p class="admn_gc_view_nrm_text_dsp emailDataClass" style="display: none;">Name:</p>
                	 <p class="admn_gc_view_nrm_text_dsp emailDataClass" style="display: none;">Email:</p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<p class="admn_gc_view_bold_text_dsp addressDataClass" style="display: none;">Gift box</p> 
                	<p class="admn_gc_view_bold_text_dsp emailDataClass" style="display: none;">Email</p>
                	<p class="admn_gc_view_bold_text_dsp addressDataClass" style="display: none;">${giftRecipientName}</p>
                	<p class="admn_gc_view_bold_text_dsp addressDataClass" style="display: none;">${giftRecipientAddress}, ${giftRecipientCity}, ${giftRecipientState}</p>
                	<p class="admn_gc_view_bold_text_dsp addressDataClass" style="display: none;">USA ${recZipCode}</p>
                	<p class="admn_gc_view_bold_text_dsp emailDataClass" style="display: none;">${recEmailarName}</p>
                	<p class="admn_gc_view_bold_text_dsp emailDataClass" style="display: none;">${recEmailarAddress}</p>
                	</div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->		
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_15">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_gc_view_nrm_text_dsp">Gift Message:</p> 
                	 </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<p class="admn_gc_view_bold_text_dsp">${giftMessage}</p> 
                	</div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->		
        </div> <!-- /.row -->
        
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_gc_view_nrm_text_dsp">Delivery Date:</p>
                	 </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<p class="admn_gc_view_bold_text_dsp">${deliveryDate}</p>
                	</div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
		<div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->		
        </div> <!-- /.row -->
        
               
        <div class="row top_adjustment_50">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-3 col-sm-3">
		<div class="row">
		<div class="col-md-2 col-sm-2">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<form action="giftBoxBackMove" method="get">
					<h4><input class="dash_board_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
					</form>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item --> 
        </div> <!-- /.col-md-2 -->              
        
        <div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<form action="giftCouponSendToUser" method="get">
                	<h4><button class="admin_cl_dir_submit_Btn" id="viewMessageId">SENT</button></h4>
					</form>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->
        </div> <!-- /.col-md-10 -->
        </div>
        </div> <!-- /.col-md-4 -->
        
        <div class="col-md-7 col-sm-7">        	              
        </div> <!-- /.col-md-7 -->
		
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->                      
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
		</body>
</html>
