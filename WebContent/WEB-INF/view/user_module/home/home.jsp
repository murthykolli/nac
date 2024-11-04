<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="p:domain_verify" content="24fd01ba581947cc853f88b16cdc72de"/>

    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon"/>

    <script type="text/javascript">
        history.pushState(null, document.title, location.href);
        window.addEventListener('popstate', function (event) {
            history.pushState(null, document.title, location.href);
        });
    </script>

	<style type="text/css">
	@font-face { font-family: 'AR BERKLEY'; src: url('resources/sitefonts/ARBERKLEY.ttf') format('truetype'); }
	#home-page .room-design .blocks .packages .package .price { font-size: 4em; font-style: italic; font-weight:900; font-family: "AR BERKLEY"; margin-top: auto; }
	
	.design_home_top_img_big_mobile_txt_dsp h1 { font: bold 1.5em/1.5em Georgia; text-align: center; letter-spacing: 2px; color: black; text-transform: uppercase; }
	.design_home_top_img_big_txt_dsp h1 { font: bold 2em/1.5em Georgia; text-align: right; letter-spacing: 2px; color: black; text-transform: uppercase; }
	.design_home_top_img_sml_mobile_text_dsp h3 { font: 0.85em/1.5em Georgia; text-align: center; letter-spacing: 2px; color: black; text-transform: uppercase; margin-top: 15px; }
	.design_home_top_img_sml_text_dsp h3 { font: 1em/1.5em Georgia; text-align: right; letter-spacing: 2px; color: black; text-transform: uppercase; margin-top: 15px; }
	.design_home_getstarted_sub_butt { display: block; margin: 0px auto; vertical-align: middle; background-color: #ff3b3b; color: white; display: inline-block; text-transform: uppercase; padding: 0.68em 2.3em; outline: none; border: none; font: 500 1em/1.25em Georgia; letter-spacing: 4px;	background-position: 50% 50%; background-repeat:no-repeat; box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22); } 
	.design_home_getstarted_sub_butt:hover { background-color: #393939; color: white }	
	</style>
</head>

<body>
	<div align="center" class="container-fluid desktop">	            	
		<img src="outsideImages/home_images/design_home_image.jpg" style="position: relative; top: -5px; left: 0px; width:100%; height:100%; z-index:-1;">
		
		<div align="right" style="position: absolute; margin-top: -28.7%; margin-left: 54%;">
			<div style="padding: 30px; height: auto; width: 105%; background: rgba(255,255,255, 0.8);">
				<div align="right" style="margin-top: -10px;">
					<div class="design_home_top_img_big_txt_dsp"><h1>The Smart</h1></div>
					<div class="design_home_top_img_big_txt_dsp"><h1>way to decorate</h1></div>
                
					<div class="design_home_top_img_sml_text_dsp" style="margin-top: -10px;"><h3>Interior Design Services For a Flat Fee</h3></div>
					
					<div style="margin-top: 25px; margin-bottom: 5px;"><form action="#"> <h4><button class="design_home_getstarted_sub_butt">GET&nbsp; STARTED</button></h4> </form></div>
				</div>
			</div>	        
		</div>
	</div>
	
	<div align="center" class="container-fluid mobile">	            	
		<img src="outsideImages/home_images/design_home_image.jpg" style="position: relative; top: -5px; left: 0px; width:100%; height:100%; z-index:-1;">
		
		<div align="center">
			<div style="padding: 25px; height: auto; width: 105%; background: rgba(255,255,255, 0.8);">
				<div align="center" style="margin-top: -10px;">
					<div class="design_home_top_img_big_mobile_txt_dsp"><h1>The Smart way to decorate</h1></div>
                
					<div class="design_home_top_img_sml_mobile_text_dsp" style="margin-top: -10px;"><h3>Interior Design Services For a Flat Fee</h3></div>
					
					<div style="margin-top: 25px; margin-bottom: 5px;"><form action="#"> <h4><button class="design_home_getstarted_sub_butt">GET&nbsp; STARTED</button></h4> </form></div>
				</div>
			</div>	        
		</div>
	</div>
	
<div id="home-page">    
    <!-- <div class="box hero gray background">
        <img class="bed" src="outsideImages/home_images/home-bed.jpg"/>
        <div class="center">
            <img class="chandelier" src="outsideImages/home_images/home-chandelier.jpg"/>
            <form action="#" >
                <h1>The Smart way to decorate</h1>
                <h3>Interior Design Services For a Flat Fee</h3>
                <h4 class="get-started-button desktop">
                    <button class="home_page_submit_button" style="margin-bottom: 30px;">get started!</button>
                </h4>
            </form>
        </div>
        <img class="chairs" src="outsideImages/home_images/home-chairs.jpg"/>
        <form action="#" class="mobile">
            <h4 class="get-started-button">
                <button class="home_page_submit_button" style="margin-bottom: 30px;">get started!</button>
            </h4>
        </form>
    </div> -->
    
    <div class="box design-process">
        <div class="arrow-box" style="margin-top: 35px;">
            <img src="outsideImages/home_images/arrow.png">
            <h2 class=""><span class="smaller">The</span> <span class="bigger">Design</span> Process</h2>
        </div>
        <div class="steps" style="margin-top: 10px;">
            <div class="step">
                <div class="images">
                    <img src="outsideImages/home_images/step-1.jpg" >
                </div>
                <div class="number">1</div>
                <div class="name">Design Style</div>
                <div class="description">A fun &amp; easy questionnaire about your space and style.</div>
            </div>
            <div class="step">
                <div class="images">
                    <img src="outsideImages/home_images/step-2.jpg"><img
                        src="outsideImages/home_images/step-2-small.jpg">
                </div>
                <div class="number">2</div>
                <div class="name">Concept Boards</div>
                <div class="description">Two concept boards curated by your very own designer.</div>
            </div>
            <div class="step">
                <div class="images">
                    <img src="outsideImages/home_images/step-3.jpg"><img
                        src="outsideImages/home_images/step-3-small.jpg">
                </div>
                <div class="number">3</div>
                <div class="name">Room Rendering</div>
                <div class="description">a personalized rendering of your space.</div>
            </div>
            <div class="step">
                <div class="images">
                    <img src="outsideImages/home_images/step-4.jpg">
                </div>
                <div class="number">4</div>
                <div class="name">Shop The Room</div>
                <div class="description">our complimentary shopping service just for you!</div>
            </div>
        </div>
    </div>
    
    <div class="box room-design" style="background-image: url(outsideImages/home_images/room-design.jpg)">
        <div class="blocks">
            <div class="block">
                <h1>Find Your Fit</h1>
                <p>Create a brand new look with the full room design package!</p>
                <p>Spruce up your current space with our accessories package!</p>
            </div>
            <div class="packages">
                <div class="package">
                    <h3 class="border">Full Room Design Package</h3>
                    <div class="services">
                        <p>Your Very Own professional designer</p>
                        <p style="margin-top: 35px;">two personally curated concepts</p>
                        <p style="margin-top: 35px;">customized room rendering</p>
                        <p style="margin-top: 35px;">complimentary shopping service</p>
                    </div>
                    <div class="price">$385</div>
                </div>
                <div class="package">
                    <h3 class="border">Accessories Package</h3>
                    <div class="services">
                        <p>Your Very Own professional designer</p>
                        <p style="margin-top: 70px;">two personally curated concepts</p>
                        <p style="margin-top: 70px;">complimentary shopping service</p>
                    </div>
                    <div class="price">$285</div>
                </div>
                <form action="#">
                    <h4 class="get-started-button">
                        <button class="home_page_submit_button">get started</button>
                    </h4>
                </form>
            </div>
        </div>
    </div>
    
    <div class="box gift-cards" style="margin-top: -128px;">
        <div class="gift-card">
            <h3 class="border black">Gift Card</h3>
            <div class="images">
                <img src="outsideImages/home_images/gift-card-1.png">
                <img src="outsideImages/home_images/gift-card-1-round.png">
            </div>
            <p>Our personalized gift cards make the perfect gift for any occasion!</p>
            <a href="gift">Learn More</a>
        </div>
        <div class="gift-card">
            <h3 class="border black">The Registry</h3>
            <div class="images">
                <img src="outsideImages/home_images/gift-card-2.png">
                <img src="outsideImages/home_images/gift-card-2-round.png">
            </div>
            <p>a truly unique registry for a beautiful new beginning!</p>
            <a href="#">Learn More</a>
            <!-- <a href="#" class="disabled">Coming Soon</a> -->
            
        </div>
    </div>

    <div class="box your-block border black">
        <div class="block">
            <div class="name">Your Needs</div>
            <img src="outsideImages/home_images/home_3r1.jpg">
            <div class="text-wrapper">
                <p class="description">kids, pets, existing <br>furniture? our designers <br>take everything into
                    <br>consideration.</p>
            </div>
        </div>
        <div class="red line"></div>
        <div class="block">
            <div class="name">Your Style</div>
            <img src="outsideImages/home_images/home_3r2.jpg">
            <div class="text-wrapper">
                <p class="description">whether you have a <br>specific style in mind or <br>not, your designer is <br>here to guide
                    you.</p>
            </div>
        </div>
        <div class="red line"></div>
        <div class="block">
            <div class="name">Your Budget</div>
            <img src="outsideImages/home_images/home_3r3.jpg">
            <div class="text-wrapper">
                <p class="description">high or low, we source <br>from a wide range of <br>retailers so that style <br>always takes
                    front seat.</p>
            </div>
        </div>
    </div>
    
    
    <div class="box marble" style="background-image: url('outsideImages/home_images/marble.png'); margin-top: 50px;">
        <h1>Professional Interior Design Tailored To your needs, <br>your style, and your budget.</h1>
        <form action="#">
            <h4 class="get-started-button">
                <button class="home_page_submit_button">get started</button>
            </h4>
        </form>
    </div>

</div>
</body>
</html>