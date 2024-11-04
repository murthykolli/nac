<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/pie_chart_for_admin.js"></script>
	<script>  
        
  	$(document).ready(function () {    
	var gfCount = '<c:out value='${allGiftCardsCount}'/>';	
	var pakCount = '<c:out value='${packgePaymentCount}'/>';
	var renCount = '<c:out value='${renderingPaymentCount}'/>';
	var shCount = '<c:out value='${purchasesItemsCount}'/>';
	
	gfCount = parseInt(gfCount);
	pakCount = parseInt(pakCount);
	renCount = parseInt(renCount);
	shCount = parseInt(shCount);
		
    RenderPieChart('container', [
                  ['Gift Card', gfCount],
                  ['Package', pakCount],
                  ['2nd Rendering', renCount],                         
                  ['Shopping Cart',  shCount]                      
                  ]);     

    /* $('#btnPieChart').click(function(){
    var data = [
               ['Gift Card', 40],
               ['Package', 20],
               {
               name: 'Shopping Cart',
               y: 30,
               sliced: true,
               selected: true
               },
               ['2 nd Rendering', 10]                      
               ];

    RenderPieChart('container', data);
    }); */
     
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
   	
   	if(pieValue === "Gift Card") {
   		window.location="allGiftCardsDailyReportsRed";
   	} else if(pieValue === "Package") {
   		window.location="allPackageDailyReportsRed";
   	} else if(pieValue === "2nd Rendering") {
   		window.location="allRenderingDailyReportsRed";
   	} else if(pieValue === "Shopping Cart") {
   		window.location="allShoppingCartDailyReportsRed";
   	} else {
   		
   	}
    } 
  	
    </script>
    
    <c:if test="${not empty adminPassMessage}">    
    <script type="text/javascript">
    window.alert("Your new Password has been saved"); 
    </script>    
    </c:if>
    	
	</head>
	
	<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row" style="margin-top: -30px;">
        <div class="col-md-1 col-sm-1">
        </div>
        <div class="col-md-5 col-sm-5">
        </div>
        
        <div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">
                    <div align="right">
                    	<a href="adminChangePassword" class="admin_profile_dsp"><img id="subAdminImg01" src="resources/images/admin/admin_change_password.png">&nbsp;&nbsp; <span onMouseOver="this.style.color='red';document.getElementById('subAdminImg01').src='resources/images/admin/admin_change_password_MO.png';" onMouseOut="this.style.color='black';document.getElementById('subAdminImg01').src='resources/images/admin/admin_change_password.png';">CHANGE PASSWORD</span></a>                    		                             
                    </div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-2 -->
        
        <div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">
                    <div align="left">
                    	<a href="createSubAdmin" class="admin_profile_dsp"><img id="subAdminImg02" src="resources/images/admin/sub_admin.png">&nbsp; <span onMouseOver="this.style.color='red';document.getElementById('subAdminImg02').src='resources/images/admin/sub_admin_MO.png';" onMouseOut="this.style.color='black';document.getElementById('subAdminImg02').src='resources/images/admin/sub_admin.png';">CREATE SUB ADMIN <font class="sub_admins_count_dsp"> - ${subAdminsCount}</font></span></a>
                    </div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
           		
		</div> <!-- /.row -->
           
        <div class="row top_adjustment_50">
        <div class="col-md-1 col-sm-1">
        </div>
        
        <div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">
            	                	
                    <div align="center">
                    	<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>	                	                             
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
