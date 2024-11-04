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
	@font-face {font-family: "Bradley Hand ITC";
    src: url("//db.onlinewebfonts.com/t/240f5365316d9d6acce08753b5a3a28d.eot");
    src: url("//db.onlinewebfonts.com/t/240f5365316d9d6acce08753b5a3a28d.eot?#iefix") format("embedded-opentype"),
    url("//db.onlinewebfonts.com/t/240f5365316d9d6acce08753b5a3a28d.woff2") format("woff2"),
    url("//db.onlinewebfonts.com/t/240f5365316d9d6acce08753b5a3a28d.woff") format("woff"),
    url("//db.onlinewebfonts.com/t/240f5365316d9d6acce08753b5a3a28d.ttf") format("truetype"),
    url("//db.onlinewebfonts.com/t/240f5365316d9d6acce08753b5a3a28d.svg#Bradley Hand ITC") format("svg");
	}
	</style>
	 
	<script type="text/javascript">
    $(document).ready(function() {
    var clientFirstRequest1 = '<c:out value="${clientFirstRequest}"/>';
    
    if(clientFirstRequest1 === "Request For Client"){
    	$("#requestInActiveModeId").show();
    	$("#requestActiveModeId").hide();
    } else {
    	$("#requestActiveModeId").show();
    	$("#requestInActiveModeId").hide();
    }

    });
    </script>
    
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row" style="margin-top: -40px;">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        <div class="col-md-10 col-sm-10">
        <div align="right"><a class="desn_arch_clients_cl" href="desnArchiveClientsInfo">ARCHIVE CLIENTS</a></div>
        </div>
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        </div>
        
        <div class="row">
        
        <div class="col-md-8 col-sm-8">
        	<div class="service-item">                        
            	<div class="service-description">
            	                	
                    <div align="left">
                    	<font style="font: bold 0.90em/1.05em Bradley Hand ITC; color: #1d356b; position: relative; top: 68px; left: 95px;"><c:out value='${dsnFirstName}'/>, </font>   
	                	<img src="resources/images/designer/deisgner_first_time_client_request.jpg">	                	                             
                    </div>                    
					
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-8 -->
        
        <div class="col-md-4 col-sm-4">
        	<div class="service-item">                        
            	<div class="service-description">
            	                	
                    <div align="center" id="requestActiveModeId">
                    <div class="des_first_time_req_txt_ds"><p>CLICK ON THE BUTTON BELOW IF YOU ARE READY TO GET STARTED WITH YOUR VERY FIRST CLIENT!</p></div>
                    <div style="margin-top: 20px; margin-bottom: 10px;"><img src="resources/images/designer/design_butt_arrow.png"></div>
                    	<div style="margin-top: 0px; margin-left: 0px;">
		                	<form action="newClientRequestToAdmin">
		                	<h4><button class="req_new_client_submit_Btn" id="reqClientButtId">REQUEST CLIENT</button></h4>
		                	</form>
	                	</div>                             
                    </div>
                    
                    <div align="center" style="display: none;" id="requestInActiveModeId">
                    <div class="des_first_time_req_txt_ds"><p>WE'VE RECEIVED YOUR REQUEST. WE WILL MATCH YOU WITH A CLIENT AS SOON AS POSSIBLE!</p></div>
                    <div style="margin-top: 20px; margin-bottom: 10px;"><img src="resources/images/designer/design_butt_arrow.png"></div>
                    	<div style="margin-top: 0px; margin-left: 0px;">
		                	<form action="newClientRequestToAdmin">
		                	<h4><button class="req_new_client_submit_Btn" id="reqClientButtId" style="opacity: 0.3; cursor: not-allowed; pointer-events: none;">REQUEST CLIENT</button></h4>
		                	</form>
	                	</div>                             
                    </div>                    
					
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
        
                		
		</div> <!-- /.row -->
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        	
		</body>
</html>