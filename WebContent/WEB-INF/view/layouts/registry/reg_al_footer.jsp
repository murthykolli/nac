<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
 
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico">
    
</head>

<body>
<div class="floating-label-form-group">
</div>

<div class="site-footer">
        <div class="container">            
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="service-item">
                        
                        <div class="service-description">
                        	<div class="footer-box-adj">   
	                            <div class="footer-links">        
			                    <ul>
								<li>
									<a href="home">REGISTRY HOME</a>
								</li>
				
								<li>
									<a href="registrantShoppingCartDisplay">SHOPPING CART</a>
								</li>
								
								<li>
									<a href="registryHowItWorks">HOW IT WORKS</a>
								</li>
								
								<li>
									<a href="registryBenefits">REGISTRY BENEFITS</a>
								</li>
								
								<li>
									<a href="lmDesignServices">DESIGN SERVICES</a>
								</li>
				
								<!-- <li>
									<a href="#">RETURN POLICY</a>
								</li>
				
								<li>
									<a href="registryFrequentlyAskedQuestions">FAQS</a>
								</li> -->
				
								<li>
									<a target="_blank" href="https://blog.nookandcove.com">BLOG</a>
								</li>
								
								<!-- <li>
									<a href="regLogOut">SIGN OUT</a>
								</li> -->
				
								</ul>
								<div style="height: 5px;"></div>
								</div>                           
                        </div>
                   </div> <!-- /.service-description -->
             	</div> <!-- /.service-item -->               
                </div> <!-- /.col-md-3 -->
                
                
                <div class="col-md-6 col-sm-6  col-xs-12">
                    <div class="service-item">
                        
                        <div class="service-description">
                        	<div class="footer-box-adj">                            
                            
                            <ul class="nc-footer-imgs">
                            <li><a href="https://www.facebook.com/nookandcove" target="_blank"><img id="footer-icon-img" src="resources/images/social_media/facebook.png" width="40" height="40" onmouseover="this.src='resources/images/social_media/facebook_mo.png'" onmouseout="this.src='resources/images/social_media/facebook.png'" border="0" alt="facebook"></a></li>
                            <li style="margin-left: 6px;"><a href="https://www.instagram.com/nookandcove" target="_blank"><img src="resources/images/social_media/instagram.png" width="40" height="40" onmouseover="this.src='resources/images/social_media/instagram_mo.png'" onmouseout="this.src='resources/images/social_media/instagram.png'" border="0" alt="instagram"></a></li>
                            <li style="margin-left: 6px;"><a href="https://twitter.com/nookandcove" target="_blank"><img src="resources/images/social_media/twitter.png" width="40" height="40" onmouseover="this.src='resources/images/social_media/twitter_mo.png'" onmouseout="this.src='resources/images/social_media/twitter.png'" border="0" alt="twitter"></a></li>
                            <li style="margin-left: 6px;"><a href="https://www.pinterest.com/nookandcove" target="_blank"><img src="resources/images/social_media/pinterest.png" width="40" height="40" onmouseover="this.src='resources/images/social_media/pinterest_mo.png'" onmouseout="this.src='resources/images/social_media/pinterest.png'" border="0" alt="pinterest"></a></li>
                            </ul>
                            
		                    <div class="footer-links">        
			                    <ul class="contact-footer">
								<li>
									<a href="mailto:hello@nookandcove.com">HELLO@NOOKANDCOVE.COM</a>
								</li>
				
								<li>
									<a href="tel:+18885802030">(888) 488-4630</a>
								</li>
				
								<li>
									<a target="_blank" href="regTermsPopupDisplay">TERMS</a>
								</li>
				
								<li>
									<a target="_blank" href="regPrivacyPolicyPopupDisplay">PRIVACY POLICY</a>
								</li>
										
								</ul>
								<div style="height: 5px;"></div>
								</div>                           
                        </div>
                   </div> <!-- /.service-description -->
             	</div>   <!-- /.service-item -->             
                </div> <!-- /.col-md-3 -->
                
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="service-item">
                        
                        <div class="service-description">                            
                            
                    <table>
                    	<tr><td>
                    		<form action="registryOverview">
								<h4><button class="footerSubmitBtn" style="width: 210px; height: 40px; font: normal 0.95em/1.5em Georgia; letter-spacing: 3px;">MY REGISTRY</button></h4>
							</form>
						</td></tr>
						
						<tr><td>
                    		<form action="registryMyAccount">
								<h4><button class="footerSubmitBtn" style="width: 210px; height: 40px; font: normal 0.95em/1.5em Georgia; letter-spacing: 3px;">MY ACCOUNT</button></h4>
							</form>
						</td></tr>
												
						<tr><td align="center">
							<a href="home"><img src="resources/images/social_media/registry_small_logo.png" class="ft_logo_adj img-responsive" alt="nookandcove"></a>
						</td></tr>					
					</table>

                            
                        </div>
                    </div> <!-- /.service-item -->
                </div> <!-- /.col-md-3 -->
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div> <!-- /.site-footer -->
    
    <script>
  window.addEventListener('load', function() {
    if (window.location.href.indexOf('/shopPaymentSuccess') != -1) {
      var totalValue = jQuery('div.service-description:contains("TOTAL PAYMENT")').text().split(':')[1].replace(/[^0-9.]/g, '');
      var ordeID = jQuery('div.service-description:contains("ORDER NUMBER")').text().split(':')[1].trim()
      gtag('event', 'conversion', {
        'send_to': 'AW-942606255/aYP0CK7gl-ADEK-PvMED',
        'value': parseFloat(totalValue),
        'currency': 'USD',
        'transaction_id': ordeID
      });

    }

    if (window.location.pathname.includes("/registrentInfoSaving")) {
      gtag('event', 'conversion', {
        'send_to': 'AW-942606255/kAMVCJ3Dl-ADEK-PvMED'
      });
    }
  });
</script>		
</body>
</html>
