<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> 
<![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang="en"> 
<![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
    <meta name="author" content="nookandcove">
    <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=registrantSessionTimeOut" />
    <meta name="google-site-verification" content="_sQVDlCJ6aFkqAoNhHqtnJvUQ1Z5M6PkJJly8qe4ZyQ" />
    
    <!-- CSS Bootstrap & Custom -->
    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="resources/css/main_css/nookandcove-main.css">
    <link rel="stylesheet" href="resources/css/main_css/font-awesome.min.css">
        
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
    
    <!-- JavaScripts -->
    <script src="resources/js/main_js/jquery-1.10.2.min.js"></script>
    <!--[if lt IE 8]>
	<div style=' clear: both; text-align:center; position: relative;'>
            <a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" alt="" /></a>
        </div>
    <![endif]-->    
    
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=G-LEBSZCG2T2"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());
	  gtag('config', 'G-LEBSZCG2T2');
	</script>

    <script type="text/javascript">
    $(document).ready(function(){
    var totalRegCartItemsCount = "<c:out value="${regTotalCartItems}"/>";
    
        if(totalRegCartItemsCount > 0){
        	$("#regCartValueDisp").show();
        	$("#mobCartValueDisp").show();
        } else {
        	$("#regCartValueDisp").hide();
        	$("#mobCartValueDisp").hide();
        }
    });
    </script>
        
	<style type="text/css">
	@font-face { font-family: 'Allura-Regular'; src: url('resources/sitefonts/Allura-Regular.ttf') format('truetype'); }
	@font-face { font-family: 'CochocibScriptLatinPro'; src: url('resources/sitefonts/CochocibScriptLatinPro.otf') format('truetype'); }
	.reg_logo_text_font { font: bold 1.3em CochocibScriptLatinPro; color: black;letter-spacing: 0px; text-transform: capitalize; left: -10px; top: 3px; position: relative; white-space: nowrap; }
	
	.dropdown_sub_menu { position: absolute; top: 90%; left: -10%; z-index: 1000; display: none; float: left; min-width: 200px; height: 110px; padding: 5px 0px; margin: 2px 0px 0; list-style: none; background-color: white; -webkit-box-shadow: 0px 1px 1px #999; -moz-box-shadow: 0px 1px 1px #999; box-shadow: 0px 1px 1px #999; }
	.dropdown_sub_menu>li>a { display: block; padding: 3px 5px; clear: both; text-align: left; line-height: 2; white-space: nowrap; text-decoration: none; }
	li:hover .dropdown_sub_menu{ display: block; }
	</style>
	
	<!-- Global site tag (gtag.js) - Google Ads: 942606255 -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=AW-942606255"></script>
	<script>
  	window.dataLayer = window.dataLayer || [];
  	function gtag(){dataLayer.push(arguments);}
  	gtag('js', new Date());
  	gtag('config', 'AW-942606255');
	</script>
	
</head>

<body style="overflow-x: hidden">

<div id="home">
        <div class="site-header">
            <div class="top-header" >                
            </div> <!-- /.top-header -->
            <div class="main-header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-xs-4">
                            <div class="logo">
                                <h1><a href="#" title="Nook and Cove Registry">
                                <img src="resources/images/logo.png" alt="NookandCove Logo"> <font class="reg_logo_text_font desktop">Shop &amp; Registry</font> </a></h1>
                            </div> <!-- /.logo -->
                        </div> <!-- /.col-md-4 -->
                        
                        <div class="col-md-8 col-sm-8 col-xs-8">
                            <div class="menu text-right hidden-sm hidden-xs">
                                <ul>
                                	<li>&nbsp;
									<a href="registrantShoppingCartDisplay"><img src="resources/images/payment_cart_img.jpg" alt="shoppingcart"> <font id="roundShapId"><span id="regCartValueDisp" style="display: none;"><font id="regCartCountDesktopId">${regTotalCartItems}</font></span></font></a>
									</li>
									
									<li class="current"><a href="registryOverview">&nbsp;MY REGISTRY&nbsp;</a></li>
                                    <li><a href="registryMyAccount">&nbsp;MY ACCOUNT&nbsp;</a></li>
                                	<li class="dropdown"> <a href="#" class="dropdown-toggle">LEARN MORE</a> <span data-toggle="dropdown" class="caret"></span>
			          					<ul class="dropdown_sub_menu">
			            					<li><a href="registryHowItWorks" style="text-align: left; position: relative; left: -54px; top: 0px;">&nbsp;HOW IT WORKS&nbsp;</a></li>
			            					<li><a href="registryBenefits" style="text-align: left; position: relative; left: -14px; top: 5px;">&nbsp;REGISTRY BENEFITS&nbsp;</a></li>
			            					<li><a href="lmDesignServices" style="text-align: left; position: relative; left: -34px; top: 10px;">&nbsp;DESIGN SERVICES&nbsp;</a></li>		            
			          					</ul>
		        					</li>                                	
                            		<li><font class="regNameDisplay" id="regFullNameDis">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${regFirstNames}&nbsp;</font></li>
                                    <li><a href="regLogOut">&nbsp;SIGN OUT&nbsp;</a></li>
                                </ul>
                            </div> <!-- /.menu -->
                        </div> <!-- /.col-md-8 -->
                        
                    </div> <!-- /.row -->
                    <%-- <div class="responsive-menu text-right visible-xs visible-sm">
                        <a href="#" class="toggle-menu fa fa-bars"></a>
                        <div class="menu">
                            <ul>
                            	<li>&nbsp;
								<a href="registrantShoppingCartDisplay"><img src="resources/images/payment_cart_img.jpg" alt="shoppingcart"> <font id="roundShapId"><span id="mobCartValueDisp" style="display: none;"><font id="regCartCountMobileId">${regTotalCartItems}</font></span></font></a>
								</li>
								                            	 
                            	<li class="current"><a href="registryOverview">&nbsp;&nbsp;MY REGISTRY&nbsp;&nbsp;</a></li>
                                <li><a href="registryMyAccount">MY ACCOUNT</a></li>
                                <li> <a href="#">LEARN MORE</a></li>
				          			<li><a href="registryHowItWorks" style="margin-left: 20px;">HOW IT WORKS</a></li>
			            			<li><a href="registryBenefits" style="margin-left: 20px;">REGISTRY BENEFITS</a></li>
                                
                            	<li><font class="regNameDisplay" id="regFullNameDis">${regFirstNames}</font></li>
                                <li><a href="regLogOut">SIGN OUT</a></li>
                           </ul>
                        </div>
                    </div> --%> 
                </div> <!-- /.container -->
            </div> <!-- /.header -->
        </div> <!-- /.site-header -->
    </div> <!-- /#home -->
	
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/js/main_js/plugins.js"></script>
    <script src="resources/js/main_js/custom.js"></script>
     			
</body>
</html>
