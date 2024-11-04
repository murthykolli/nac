<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="resources/css/file_upload.css" type="text/css">	
	<script type="text/javascript">
 	$(document).ready(function() { var regStatus1 = "<c:out value="${regStatus}"/>";		
	    if(regStatus1 == "Done"){ $("#visibleImagesDispId").show(); $("#notVisibleImagesDispId").hide(); } else { $("#notVisibleImagesDispId").show(); $("#visibleImagesDispId").hide(); }	    
	    var regSuccSave1 = "<c:out value="${regSuccSave}"/>";
	    if(regSuccSave1 == "Visible To Guest" && regStatus1 == "Done") { $('#mask').css({'width': $(window).width(),'height': $(document).height()}); $('#mask').fadeIn(100); $('#mask').fadeTo("fast",0.8); $('#dialog').fadeIn(500); $('.window .close').click(function (e) { e.preventDefault(); $('#mask, .window').hide(); }); status = "Done"; }		
 	});    
	function myFunction() { var copyText = document.getElementById("myInput"); copyText.select(); document.execCommand("copy"); return false; }
	</script>
	</head>	
		<body>				
		<div id="mainframe" class="section-content"> <div class="container">      
      	<div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="registry_prof_my_acc_title"><h2>MY ACCOUNT</h2></div> </div> </div> </div> </div> </div>    
<!-- Left Code Start -->
      	<div class="row top_adjustment_30"> <div class="col-md-3 col-sm-3 regi_prof_left_side_box_dspl"> <div class="service-item"> <div class="service-description"> <div align="left">        			
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>ACCOUNT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryMyAccount" class="regi_prof_left_link_text_dspl">CONTACT INFO</a></div>
		<div class="top_adjustment_10"><a href="registryPasswordChange" class="regi_prof_left_link_text_dspl">CHANGE PASSWORD</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>EVENT DETAILS</h3></div>
		<div class="top_adjustment_10"><a href="registryEventInfoChange" class="regi_prof_left_link_text_dspl">EVENT INFO</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>REGISTRY SETTINGS</h3></div>
		<div class="top_adjustment_10"><a href="registryURLInfoChange" class="regi_prof_left_link_text_dspl">URL</a></div>
		<div class="top_adjustment_10"><a href="#" class="regi_prof_left_link_text_hover_dspl">PRIVACY</a></div>
		<div class="regi_prof_left_hd_text_dspl top_adjustment_30"><h3>GIFT TRACKER</h3></div>
		<div class="top_adjustment_10"><a href="regiShippingInfoDsp" class="regi_prof_left_link_text_dspl">SHIPPING INFO</a></div>
		<div class="top_adjustment_10"><a href="regiMyOrderDsp" class="regi_prof_left_link_text_dspl">MY ORDERS</a></div>
		<div class="top_adjustment_10"><a href="regiGiftsReceivedDsp" class="regi_prof_left_link_text_dspl">GIFTS RECEIVED</a></div>
		<div class="top_adjustment_10"><a href="regiRoomFundsDsp" class="regi_prof_left_link_text_dspl">ROOM FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiCashFundsDsp" class="regi_prof_left_link_text_dspl">CASH FUNDS</a></div>
		<div class="top_adjustment_10"><a href="regiStoreCreditDsp" class="regi_prof_left_link_text_dspl">STORE CREDIT</a></div>
		<div style="height: 35px;"></div> </div> </div> </div> </div>	        
<!-- Left Code End -->	        
        <div class="col-md-9 col-sm-9"> <div class="service-item"> <div class="service-description">	        			
	    <div class="row"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description reg_pro_left_adj_disp"> <div align="left">        			
		<div class="registry_prof_title top_adjustment_30"><h2>Privacy Settings</h2></div> </div> </div> </div> </div> </div>
		<form action="registrantURLInfoUpdate" method="post">			        
		<div class="row top_adjustment_20"> <div class="col-md-12 col-sm-12"> <div class="service-item"> <div class="service-description reg_pro_left_adj_disp"> <div align="left">
		<div class="regi_prof_left_sub_hd_text top_adjustment_10"><h4>Visibility:</h4></div>
		<div class="row top_adjustment_20" id="notVisibleImagesDispId" style="display: none;">
		<div class="col-md-1 col-sm-1"> <div class="regi_prof_left_sub_nor_text top_adjustment_5"><a href="regGiveVisibleToGuest"><img src="resources/images/registry/visible_butt/reg_visible_red.png" style="margin-left: -5px;"></a></div> </div>
		<div class="col-md-11 col-sm-11"> <div class="regi_prof_left_sub_hd_text"><h4>Your Registry is <font color="red">Not</font> Visible</h4></div>
		<div class="regi_prof_left_sub_nor_text top_adjustment_5">Guests cannot visit or shop your registry.</div> </div> </div>
		<div class="row top_adjustment_20" id="visibleImagesDispId" style="display: none;">
		<div class="col-md-1 col-sm-1"> <div class="regi_prof_left_sub_nor_text top_adjustment_5"><a href="regNotGiveVisibleToGuest"><img src="resources/images/registry/visible_butt/reg_visible_green.png" style="margin-left: -5px;"></a></div> </div>
		<div class="col-md-11 col-sm-11"> <div class="regi_prof_left_sub_hd_text"><h4>Your Registry is Visible</h4></div>
		<div class="regi_prof_left_sub_nor_text top_adjustment_5">Guests can visit and shop your registry.</div> </div> </div> </div> </div> </div> </div> </div>
		</form> </div> </div> </div> </div> </div> </div>
		
		<div id="boxes"> <div style="width: 1478px; height: 602px; display: none; opacity: 0.1; z-index: 10001;" id="mask"></div>        
        <div align="center" style="padding: 20px; display: none;  width: 650px; z-index: 10001; overflow-y: hidden; position:fixed; left: 50%; top: 50%; -ms-transform: translate(-50%,-50%); -moz-transform:translate(-50%,-50%); -webkit-transform: translate(-50%,-50%); transform: translate(-50%,-50%);" id="dialog" class="window">
    	<div id="popupfoot" class="close"> <a href="#"><img src="resources/images/close.png" style="cursor: pointer; top: -10px; left: 0px;  position: relative;"></a></div>        
		<div align="center" style="font: bold 1.1em/1.5em Georgia; margin-top: 50px; letter-spacing: 3px; color: black;">YOU'RE LIVE!</div>
		<div align="center" style="font: normal 0.70em/1.5em Georgia; margin-top: 20px; letter-spacing: 2px; color: black;">GUESTS CAN NOW SEE AND SHOP YOUR REGISTRY.</div>
		<div align="center" style=" margin-top: 20px;">
		<table><tr> <td style="font: normal 0.70em/1.5em Georgia; letter-spacing: 1px; color: black;">https://www.nookandcove.com/registry/<font style="font-weight: bold;">${regAddress}</font></td> </tr></table></div>
		<div align="center" style="margin-top: 50px; margin-bottom: 30px;"><table><tr><td><a href="previewGuestRegistry"><button class="reg_popup_dsp_save_subt_Btn" id="urlInfoChangesButtId">VIEW YOUR REGISTRY</button></a></td>
	    <td><a href="registryOverview"><button class="reg_popup_dsp_save_subt_Btn" id="urlInfoChangesButtId" style="margin-left: 20px;">ADD MORE GIFTS</button></a></td></tr></table></div>
		</div> </div>     
		</body>
</html>