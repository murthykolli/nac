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
    <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=sessionTimeOut" />
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
    
    <!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-NTF9B88');</script>
	<!-- End Google Tag Manager -->
	
    <script type="text/javascript">
    $(document).ready(function(){
    var totCartItemsCount = "<c:out value="${totalCartItemsCount}"/>";
    
        if(totCartItemsCount > 0){
        	$("#cartValueDisp").show();
        	$("#mobCartValueDisp").show();
        } else {
        	$("#cartValueDisp").hide();
        	$("#mobCartValueDisp").hide();
        }
    });
    </script>
      
  <script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-100598676-1', 'auto');
  ga('send', 'pageview');
  </script>
</head>

<body>

<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NTF9B88"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<div id="home">
        <div class="site-header">
            <div class="top-header" >                
            </div> <!-- /.top-header -->
            <div class="main-header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-2 col-sm-2 col-xs-2">
                            <div class="logo">
                                <h1><a href="design" title="Nook and Cove"><img src="resources/images/logo.png" alt="nookandcove" style="vertical-align: middle; margin-top: 12px;"></a></h1>
                            </div> <!-- /.logo -->
                        </div> <!-- /.col-md-2 -->
                        
                        <div class="col-md-5 col-sm-5 col-xs-5">
                            <div class="menu text-left hidden-sm hidden-xs after_login_header_adj">
                                <ul>
                                    <li class="current"><a href="howItWorks">&nbsp;HOW IT WORKS&nbsp;</a></li>
                                    <li><a href="pricing">&nbsp;PRICING&nbsp;</a></li>
                                    <li><a href="portfolio">&nbsp;GALLERY&nbsp;</a></li>
                                    <li><a href="gift">&nbsp;GIFT&nbsp;</a></li>                                         
                                </ul>
                            </div> <!-- /.menu -->
                        </div> <!-- /.col-md-5 -->                        
                                                
                        <div class="col-md-5 col-sm-5 col-xs-5">
                            <div class="menu text-right hidden-sm hidden-xs">
                                <ul>
                                	<li id="paymentCartDisplayId">
									<a href="paymentCartInfoDisp"><img src="resources/images/payment_cart_img.jpg" alt="shoppingcart"> <font id="roundShapId"><span id="cartValueDisp" style="display: none;">${totalCartItemsCount}</span></font></a>
									</li>
									<li><font id="nameDisplay">&nbsp;${flName}&nbsp;</font></li>
                            		<li><a href="clientsInformationDisplay">&nbsp;MY ROOMS&nbsp;</a></li>
                            		<!-- <li style="border-left: 1px solid red;">&nbsp;</li> -->
                                    <li><a href="logOut">&nbsp;SIGN OUT</a></li>
                                </ul>
                            </div> <!-- /.menu -->
                        </div> <!-- /.col-md-5 -->
                        
                    </div> <!-- /.row -->
                    <div class="responsive-menu text-right visible-xs visible-sm">
                        <a href="#" class="toggle-menu fa fa-bars"></a>
                        	<div class="menu">
                            	<ul>
                                    <li class="current"><a href="howItWorks">HOW IT WORKS</a></li>
                                    <li><a href="pricing">PRICING</a></li>
                                    <li><a href="portfolio">GALLERY</a></li>
                                    <li><a href="gift">GIFT</a></li>                                         
                                </ul>

								<ul>
                                	<li id="paymentCartDisplayId">
									<a href="paymentCartInfoDisp"><img src="resources/images/payment_cart_img.jpg" alt="shoppingcart"> <font id="roundShapId"><span id="mobCartValueDisp" style="display: none;">${totalCartItemsCount}</span></font></a>
									</li>
                            		<li><a href="clientsInformationDisplay">MY ROOMS</a>&nbsp;</li>
                            		<!-- <li style="border-left: 1px solid red;">&nbsp;</li> -->
                                    <li><a href="logOut">SIGN OUT</a></li>
                                </ul>
                        </div> <!-- /.menu -->
                    </div> <!-- /.responsive-menu -->
                </div> <!-- /.container -->
            </div> <!-- /.header -->
        </div> <!-- /.site-header -->
    </div> <!-- /#home -->
	
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/js/main_js/plugins.js"></script>
    <script src="resources/js/main_js/custom.js"></script>
    		
</body>
</html>
