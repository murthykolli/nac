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
    <link rel="stylesheet" href="resources/css/main_css/admin_nookandcove-main.css">
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
 		var adminMBNewImgDsp1 = "<c:out value="${adminMBNewImgDsp}"/>";
 		
 		if(adminMBNewImgDsp1 === "NEW") {
        	$("#adminMessgeId").show();        	
        } else {
        	$("#adminMessgeId").hide();
        }

 		var newClientsCount1 = "<c:out value="${newClientsCount}"/>";
 		var giftCardsCount1 = "<c:out value="${giftCardsCount}"/>";
 		var purchasesItemsCount1 = "<c:out value="${purchasesItemsCount}"/>";

 		if(newClientsCount1 > 0) {
        	$("#newClientsShowId").show();        	
        } else {
        	$("#newClientsShowId").hide();
        }

 		if(giftCardsCount1 > 0) {
        	$("#giftCardShowId").show();        	
        } else {
        	$("#giftCardShowId").hide();
        }

 		if(purchasesItemsCount1 > 0) {
        	$("#purchasesShowId").show();        	
        } else {
        	$("#purchasesShowId").hide();
        }

 		var mainAdminId1 = "<c:out value="${mainAdminId}"/>"; 		
 		if(mainAdminId1 === "1") {
        	$("#adminAccountsDspId").show();        	
        } else {
        	$("#adminAccountsDspId").hide();
        }
    });
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
                                <h1><a href="admDesnAndRegistryHome" title="Nook and Cove"><img src="resources/images/logo.png"></a></h1>
                            </div> <!-- /.logo -->
                        </div> <!-- /.col-md-2 -->
                        
                        <div class="col-md-8 col-sm-8 col-xs-8">
                            <div class="menu text-left hidden-sm hidden-xs after_login_header_adj">
                                <ul>
                                	<li><a href="regConceptBoards"><font class="reg_header_text_bcdsp">REGISTRY</font></a></li>
                                    <li><a href="admNewClients">NEW CLIENTS</a>
                                    	<font id="newClientsShowId" style="background-color: red; border-radius: 3px; color: white; font: bold 0.74em/1.25em sans-serif; text-align: center; padding: 2px; padding-left: 4px; padding-right: 4px; position: relative; left: -7px; top: -10px; display: none;">${newClientsCount}</font> </li>
                                    <li><a href="admClientDirectory">CLIENT DIR</a></li>
                                    <li><a href="admDesnDirectory">DESIGNER DIR</a>
                                    <font style="position: relative; margin-left: -40px; top: -18px; display: none;" id="adminMessgeId"><img src="resources/images/designer/desn_new_img.png"></font>
                                    </li>
                                    <li><a href="promoCodeDisplay">PROMO</a></li>
                                    <li><a href="amnGiftCards">GIFT</a>
                                    	<font id="giftCardShowId" style="background-color: red; border-radius: 3px; color: white; font: bold 0.74em/1.25em sans-serif; text-align: center; padding: 2px; padding-left: 4px; padding-right: 4px; position: relative; left: -7px; top: -10px; display: none;">${giftCardsCount}</font> </li> 
                                    <li class="current"><a href="admnPurchases">PURCHASES</a>
                                    	<font id="purchasesShowId" style="background-color: red; border-radius: 3px; color: white; font: bold 0.74em/1.25em sans-serif; text-align: center; padding: 2px; padding-left: 4px; padding-right: 4px; position: relative; left: -7px; top: -10px; display: none;">${purchasesItemsCount}</font> </li>            
                                </ul>
                            </div> <!-- /.menu -->
                        </div> <!-- /.col-md-8 -->                        
                                                
                        <div class="col-md-2 col-sm-2 col-xs-2">
                            <div class="menu text-right hidden-sm hidden-xs">
                                <ul>
									<li><font id="nameDisplay">${flName}</font></li>
                            		<li style="display: none;" id="adminAccountsDspId"><a href="admnAccounts"><img src="resources/images/admin/accounts.png" title="Accounts" onmouseover="this.src='resources/images/admin/accountsMO.png'" onmouseout="this.src='resources/images/admin/accounts.png'" border="0"></a></li>
                            		<li style="border-left: 1px solid red;">&nbsp;</li>
                                    <li><a href="logOut"><img src="resources/images/admin/logout.png" title="Logout" onmouseover="this.src='resources/images/admin/logoutMO.png'" onmouseout="this.src='resources/images/admin/logout.png'" border="0"></a></li>
                                </ul>
                            </div> <!-- /.menu -->
                        </div> <!-- /.col-md-2 -->
                        
                    </div> <!-- /.row -->
                    <div class="responsive-menu text-right visible-xs visible-sm">
                        <a href="#" class="toggle-menu fa fa-bars"></a>
                        	<div class="menu">
                            	<ul>
                            		<li><a href="regConceptBoards"><font class="reg_header_text_bcdsp">REGISTRY</font></a></li>
                                    <li><a href="admNewClients">NEW CLIENTS</a></li>
                                    <li><a href="admClientDirectory">CLIENT DIR</a></li>
                                    <li><a href="admDesnDirectory">DESIGNER DIR</a></li>
                                    <li><a href="promoCodeDisplay">PROMO</a></li>
                                    <li><a href="amnGiftCards">GIFT</a></li> 
                                    <li class="current"><a href="admnPurchases">PURCHASES</a></li>            
                                </ul>

								<ul>
									<li><font id="nameDisplay">${flName}</font></li>
                            		<li style="display: none;" id="adminAccountsDspId"><a href="admnAccounts"><img src="resources/images/admin/accounts.png" title="Accounts" onmouseover="this.src='resources/images/admin/accountsMO.png'" onmouseout="this.src='resources/images/admin/accounts.png'" border="0"></a></li>
                            		<li style="border-left: 1px solid red;">&nbsp;</li>
                                    <li><a href="logOut"><img src="resources/images/admin/logout.png" title="Logout" onmouseover="this.src='resources/images/admin/logoutMO.png'" onmouseout="this.src='resources/images/admin/logout.png'" border="0"></a></li>
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
