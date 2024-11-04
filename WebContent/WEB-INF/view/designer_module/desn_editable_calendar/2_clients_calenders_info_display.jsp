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
	$(document).ready(function(){ 		
	 	var textFieldRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 \-#:?|+<>={}!$%&*'()"_.@/&;,-]*$/; 
	 	
	 	$("#createDesCalSavingButId").click(function (){ 		
	    var result = true;		
		if($("#clientMonthId").val() !== "" && $("#clientYearId").val() !== ""){
			$("#clientDateIdLabel").css("color","#5c5c5c");		
	    } else{ $("#clientDateIdLabel").css("color","red"); result=false; }
		
		return result;
		}); 	

	 	$("#clientMonthId").click(function(){ 	
	 	if(textFieldRegExp.test(this.value) && $("#clientMonthId").val() !== "" && $("#clientDayId").val() !== "" && $("#clientYearId").val() !== ""){ $("#clientDateIdLabel").css("color","#5c5c5c");
	    } else{ $("#clientDateIdLabel").css("color","red"); result=false; } 	
	 	});

	 	$("#clientYearId").click(function(){ 	
	 	if(textFieldRegExp.test(this.value) && $("#clientMonthId").val() !== "" && $("#clientDayId").val() !== "" && $("#clientYearId").val() !== ""){ $("#clientDateIdLabel").css("color","#5c5c5c");
	    } else{ $("#clientDateIdLabel").css("color","red"); result=false; } 	
	 	});

	});
    </script>
	 
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        	
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
        </div> <!-- /.row -->
               
        <div class="row top_adjustment_20">
        
        <div class="col-md-4 col-sm-4">
        	<div class="service-item">                        
            	<div class="service-description">
            	<form action="designerClientNotesDataTakeFromDB" method="post">
            	<div class="row">        
        			<div class="col-md-12 col-sm-12">
        			<div align="left">
			            	
			            	<table><tbody>
			            	<tr><td class="dsn_cre_caln_text_dsp">CLIENT DATE: <font id="clientDateIdLabel" class="dsn_reqird_caln_text_dsp">required</font></td></tr>
			            	</tbody></table>
							<table><tbody>
							<tr>
							<td><select id="clientMonthId" name="clientMonth" class="dsn_calen_select_sub_box1"> 
						    <option value=''>-------Month-------</option>
						    <option value='1'>January</option>
						    <option value='2'>February</option>
						    <option value='3'>March</option>
						    <option value='4'>April</option>
						    <option value='5'>May</option>
						    <option value='6'>June</option>
						    <option value='7'>July</option>
						    <option value='8'>August</option>
						    <option value='9'>September</option>
						    <option value='10'>October</option>
						    <option value='11'>November</option>
						    <option value='12'>December</option>
							</select></td>
														
							<td><select id="clientYearId" name="clientYear" class="dsn_calen_select_sub_box3">
							<option value=''>-----Year-----</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
							<option value="2021">2021</option>
							<option value="2022">2022</option>
							<option value="2023">2023</option>
							<option value="2024">2024</option>
							<option value="2025">2025</option>
							<option value="2026">2026</option>
							<option value="2027">2027</option>
							<option value="2028">2028</option>
							<option value="2029">2029</option>
							<option value="2030">2030</option>
							<option value="2031">2031</option>
							<option value="2032">2032</option>
							<option value="2033">2033</option>
							<option value="2034">2034</option>
							<option value="2035">2035</option>
							<option value="2036">2036</option>
							<option value="2037">2037</option>
							<option value="2038">2038</option>
							<option value="2039">2039</option>
							<option value="2040">2040</option>
							<option value="2041">2041</option>
							<option value="2042">2042</option>
							<option value="2043">2043</option>
							<option value="2044">2044</option>
							<option value="2045">2045</option>
							<option value="2046">2046</option>
							<option value="2047">2047</option>
							<option value="2048">2048</option>
							<option value="2049">2049</option>
							<option value="2050">2050</option>
							<option value="2051">2051</option>
							<option value="2052">2052</option>
							<option value="2053">2053</option>
							<option value="2054">2054</option>
							<option value="2055">2055</option>
							<option value="2056">2056</option>
							<option value="2057">2057</option>
							<option value="2058">2058</option>
							<option value="2059">2059</option>
							<option value="2060">2060</option>
							<option value="2061">2061</option>
							<option value="2062">2062</option>
							<option value="2063">2063</option>
							<option value="2064">2064</option>
							<option value="2065">2065</option>
							<option value="2066">2066</option>
							<option value="2067">2067</option>
							<option value="2068">2068</option>
							<option value="2069">2069</option>
							<option value="2070">2070</option>
							<option value="2071">2071</option>
							<option value="2072">2072</option>
							<option value="2073">2073</option>
							<option value="2074">2074</option>
							<option value="2075">2075</option>
							<option value="2076">2076</option>
							<option value="2077">2077</option>
							<option value="2078">2078</option>
							<option value="2079">2079</option>
							<option value="2080">2080</option>
							<option value="2081">2081</option>
							<option value="2082">2082</option>
							<option value="2083">2083</option>
							<option value="2084">2084</option>
							<option value="2085">2085</option>
							<option value="2086">2086</option>
							<option value="2087">2087</option>
							<option value="2088">2088</option>
							<option value="2089">2089</option>
							<option value="2090">2090</option>
							<option value="2091">2091</option>
							<option value="2092">2092</option>
							<option value="2093">2093</option>
							<option value="2094">2094</option>
							<option value="2095">2095</option>
							<option value="2096">2096</option>
							<option value="2097">2097</option>
							<option value="2098">2098</option>
							<option value="2099">2099</option>
							<option value="2100">2100</option>    
							</select></td></tr>
														
							</tbody></table>
							</div></div></div>
							
							<div class="row top_adjustment_30">                			
							<div class="col-md-2 col-sm-2 text-right">
							<a href="designerClients"><img class="back_submit_Btn" src="resources/images/backButton.png"></a>
							</div>
							
							<div class="col-md-10 col-sm-10 text-left">
							<h4><button class="management_submit_Btn" style="margin-left: -10px;" id="createDesCalSavingButId">SAVE</button></h4>
							</div>	     
					        </div> <!-- /.row -->
					        </form>
			            	
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
               
        
        <div class="col-md-8 col-sm-8">
        </div> <!-- /.col-md-8 -->
        </div> <!-- /.row -->
                        		
		          
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
		</body>
</html>