<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/pie_chart_for_admin.js"></script>
	<script>  
        
  	$(document).ready(function () {    
	var designLoginCount1 = '<c:out value='${designLoginCount}'/>';	
	var registryLoginCount1 = '<c:out value='${registryLoginCount}'/>';
	var registryPaymentCount1 = '<c:out value='${registryPaymentCount}'/>';
	var guestPaymentCount1 = '<c:out value='${guestPaymentCount}'/>';
	
	desLoginCount = parseInt(designLoginCount1);
	regLoginCount = parseInt(registryLoginCount1);
	regPaymentCount = parseInt(registryPaymentCount1);
	gstPaymentCount = parseInt(guestPaymentCount1);
		
    RenderPieChart('container', [
                  ['Design Login Users', desLoginCount],
                  ['Registry Login Users', regLoginCount],
                  ['Registry Payment Users', regPaymentCount],                         
                  ['Guest Payment Users',  gstPaymentCount]                      
                  ]);     

     
    function RenderPieChart(elementId, dataList) {
 		   new Highcharts.Chart({
           chart: {
                  renderTo: elementId,
                  plotBackgroundColor: null,
                  plotBorderWidth: null,
                  plotShadow: false
                  }, title: {
                  text: ''
                  },
                  tooltip: {
                  formatter: function () {
                  document.getElementsByClassName('pieChartCl').value = this.point.name;                        	
                  return '<b>' + this.point.name;
                  }
                  },
                  plotOptions: {
                  pie: {
                       allowPointSelect: true,
                       cursor: 'pointer',
                       dataLabels: {                    	
                       enabled: true,
                       color: '#000000',
                       connectorColor: '#000000',
                       formatter: function () {
                       return '<font style="font: bold 1.2em/1.25em Georgia; letter-spacing: 3px;">' + this.point.name + ': ' + this.y + '</font>';                                    
                       }                    
                       }
                  }
                  },
                  series: [{
                        type: 'pie',
                        name: '',
                        data: dataList
                  }]
                });
            };
    });
  	
  	function pieChartClick() {	
	var pieValue = document.getElementsByClassName("pieChartCl").value;	
   	
   	if(pieValue === "Design Login Users") {
   		window.location="adminPackageReg";
   	} else if(pieValue === "Registry Login Users") {
   		window.location="adminRegistryRed";
   	} else if(pieValue === "Registry Payment Users") {
   		window.location="adminRegistryUserPayment";
   	} else if(pieValue === "Guest Payment Users") {
   		window.location="adminGuestUserPayment";
   	} else {
   		
   	}
    } 
  	
    </script>
    
	</head>
	
	<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div>
        
        <div class="col-md-10 col-sm-10" style="border: 1px dotted gray; padding: 45px;">
        	<div class="service-item">                        
            	<div class="service-description">
            	                	
                    <div align="center">
                    	<div id="container" style="min-width: 360px; height: 360px; margin: 0 auto"></div>	                	                             
                    </div>                    
					
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-10 -->
         
        <div class="col-md-1 col-sm-1">
        </div>       		
		</div> <!-- /.row -->
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        	
		</body>
</html>
