<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/pie_chart_for_admin.js"></script>
	<script>  
        
  	$(document).ready(function () {    
  	var fullRmCount = '<c:out value='${fullRoomCount}'/>';	
  	var accPackCount = '<c:out value='${accPackageCount}'/>';
  	var totGiftCards = '<c:out value='${totalGiftCards}'/>';
  	var totGiftAmount = '<c:out value='${totalGiftAmount}'/>';
  	var orderStCount = '<c:out value='${orderStatusCount}'/>';
  	var deliveryStCount = '<c:out value='${deliveryStatusCount}'/>';
	var weekDayCount = '<c:out value='${weekDaysCount}'/>';
	var weekEndCount = '<c:out value='${weekEndsCount}'/>';
	$("#totalGiftAmountID").html(totGiftAmount.replace(/\B(?=(\d{3})+(?!\d))/g, ","));
		
	fullRmCount = parseInt(fullRmCount);
	accPackCount = parseInt(accPackCount);
	totGiftCards = parseInt(totGiftCards);
	orderStCount = parseInt(orderStCount);
	deliveryStCount = parseInt(deliveryStCount);
	weekDayCount = parseInt(weekDayCount);
	weekEndCount = parseInt(weekEndCount);
	
	if(totGiftCards > 0) {
		$("#haveGiftCardsId").show();
		$("#noGiftCardsId").hide();		
	} else {
		$("#haveGiftCardsId").hide();
		$("#noGiftCardsId").show();
	}
		
    RenderPieChart('container', [
				  ['Total Clients', totGiftCards],                         
                  ['Place My Order Count', fullRmCount],
                  ['Do Not Place My Order Count', accPackCount],
                  ['Ordered Status Count', orderStCount],
                  ['Delivered Status Count', deliveryStCount],
                  ['week Days Count', weekDayCount],
                  ['week Ends Count', weekEndCount]
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
                  bar: {
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
                        type: 'bar',
                        name: '',
                        data: dataList
                  }]
                });
            };
    });
  	
    </script>   
	</head>
	
	<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row" style="margin-top: -50px;">
        <div class="col-md-1 col-sm-1">
        </div>
        <div class="col-md-7 col-sm-7">
        </div>
        
        <div class="col-md-4 col-sm-4">
        	<div class="service-item">                        
            	<div class="service-description">
                    <div align="right">
                    	<a href="adminPurchasesForAcc" class="admin_all_giftCard_info_dsp">ALL SHOPPING CART INFO </a>
                    </div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->                  		
		</div> <!-- /.row -->
        
        <div class="row" style="margin-top: 30px;">
        <div class="col-md-1 col-sm-1">
        </div>
        <div class="col-md-2 col-sm-2" align="center">
        <div><a href="allShoppingCartDailyReportsRed" class="admin_all_giftCard_links_dsp">DAILY</a></div>
        </div>
        
        <div class="col-md-2 col-sm-2" align="center">
        <div><a href="allShoppingCartWeeklyReportsRed" class="admin_all_giftCard_links_dsp">WEEKLY</a></div>
        </div>
        
        <div class="col-md-2 col-sm-2" align="center">
        <div><a href="allShoppingCartMonthlyReportsRed" class="admin_all_giftCard_links_dsp">MONTHLY</a></div>
        </div>
        
        <div class="col-md-2 col-sm-2" align="center">
        <div><a href="allShoppingCartQuarterlyReportsRed" class="selected_type_giftCard__dsp">QUARTERLY</a></div>
        </div>
        
        <div class="col-md-2 col-sm-2" align="center">
        <div><a href="allShoppingCartYearlyReportsRed" class="admin_all_giftCard_links_dsp">YEARLY</a></div>
        </div>
                
        <div class="col-md-1 col-sm-1">
        </div>
           		
		</div> <!-- /.row -->
		
        <div class="row" style="margin-top: 10px;">
        <div class="col-md-1 col-sm-1">
        </div>
        <div class="col-md-10 col-sm-10" align="center">
        <div style="border: 1px solid black;"></div>
        </div>        
                
        <div class="col-md-1 col-sm-1">
        </div>
           		
		</div> <!-- /.row -->
		
        <div class="row" style="margin-top: 40px;">
        <div class="col-md-1 col-sm-1">
        </div>
        <div class="col-md-5 col-sm-5" align="left">
        <div class="adm_new_cl_head_txt_dsp">SHOPPING CART QUARTERLY REPORTS</div>
        </div>
        
        <div class="col-md-5 col-sm-5" align="right">
        <div class="adm_new_cl_sub_txt_dsp" align="right">TOTAL AMOUNT: <b class="new_clients_no_dsp" id="totalGiftAmountID"></b></div>
        </div>
        
        <div class="col-md-1 col-sm-1">
        </div>
           		
		</div> <!-- /.row -->
           
        <div class="row top_adjustment_40">
        <div class="col-md-1 col-sm-1">
        </div>
        
        <div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">
            	                	
                    <div align="center" style="display: none;" id="haveGiftCardsId">
                    	<div id="container" style="min-width: 350px; height: 350px; margin: 0 auto"></div>	                	                             
                    </div>
                    
                    <div align="center" style="display: none;" id="noGiftCardsId">
                    	<div class="no_giftcards_text_dsp">NO ONE CREATED SHOPPING CART THIS QUARTER </div>	                	                             
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
