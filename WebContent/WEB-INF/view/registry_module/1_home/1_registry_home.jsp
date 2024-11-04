<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="resources/css/registry_css/registry_home.css" type="text/css">
	<link rel="stylesheet" href="resources/css/registry_css/registry_static.css" type="text/css">
	<link rel="stylesheet" href="resources/css/slider/reg_home_page_slider.css" type="text/css">
	<script type="text/javascript" src="resources/js/slider/jquery.flexslider.js"></script>  
    
    <script type="text/javascript">
        history.pushState(null, document.title, location.href); window.addEventListener('popstate', function (event) {  history.pushState(null, document.title, location.href); });
    </script>
    <style type="text/css">
    @font-face { font-family: 'CochocibScriptLatinPro'; src: url('resources/sitefonts/CochocibScriptLatinPro.otf') format('truetype'); }
	.home_shop_links { font: bold 2.2em CochocibScriptLatinPro; color: black; letter-spacing: 1px; text-decoration: underline; cursor: pointer; white-space: nowrap; }
	.home_shop_links:hover { color: red; text-decoration: underline; }
    </style>
    
    <!-- <script type="text/javascript">
    $(document).ready(function(){
    $(function(){
      SyntaxHighlighter.all();
    });

      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          }
      });
    });
  </script> -->

</head>

<body class="tbody_ove_x_dsp">
	<div class="desktop">
		
		<div class="flexslider" style="margin-top: 70px;">
        	<ul class="slides">
           		<!-- <li><img src="outsideImages/registry_home/home_page_main_image1.png" style="height: 720px;" class="reg_home_image_ht_adj"></li>
  	   			<li><img src="outsideImages/registry_home/home_page_main_image2.png" style="height: 720px;" class="reg_home_image_ht_adj"></li> -->
  	   			<li><img src="outsideImages/registry_home/home_page_main_image1.png"></li>
  	   			<li><img src="outsideImages/registry_home/home_page_main_image2.png"></li>
  	   			<li><img src="outsideImages/registry_home/home_page_main_image3.png"></li>
  	  		</ul>
        </div>
        
		<!-- <img src="outsideImages/registry_home/home_top_image.png" class="reg_top_home_bgi_adj"> -->		
		<div style="top: -61px; position: relative; z-index: 1000;"> <div align="left" class="reg_top_home_text_frame"> <div class="reg_top_home_text_frame_bg"> <div align="center"> <div class="registry_home_top_image_big_text"><h1><font class="home_top_txt_dsp">S</font>HOP <font class="home_top_smltxt_dsp">or</font> <font class="home_top_txt_dsp"> R</font>EGISTER <br>for life's next chapter...</h1></div> <div class="registry_home_top_image_small_text"><h3>FURNITURE &amp; DECOR CURATED <br>FROM YOUR FAVORITE BRANDS &amp; RETAILERS</h3></div> </div>
		<div align="left"> <table class="reg_top_home_sml_text_tbl"> <tr> 
		<td><form action="registryShop"> <h4><button class="reg_home_trc_sub_butt reg_top_home_sml_text_adj">SHOP</button></h4> </form></td> 
		<td><form action="createRegistry"> <h4><button class="reg_home_trc_sub_butt reg_top_home_sml_text_adj home_but_ladj">CREATE A REGISTRY</button></h4> </form></td> 
		<td><form action="findRegistry"> <h4><button class="reg_home_trc_sub_butt reg_top_home_sml_tl_adj home_but_ladj">FIND A REGISTRY</button></h4> </form></td> 
		</tr> </table> </div> </div> </div> </div> 	
				
		<div class="home_shop_text_bar_dsp" align="center" style="margin-top: -40px;"> <font class="home_shop_hdtxt_fl">H</font><font class="home_shop_hdtxt_nl">ERE'S&nbsp;</font> <font class="home_shop_hdtxt_fl">W</font><font class="home_shop_hdtxt_nl">HY&nbsp;</font> <font class="home_shop_hdtxt_bfl">E</font><font class="home_shop_hdtxt_bnl">VERYONE&nbsp;</font> <font class="home_shop_hdtxt_bfl">I</font><font class="home_shop_hdtxt_bnl">S&nbsp;</font> <font class="home_shop_hdtxt_bfl">R</font><font class="home_shop_hdtxt_bnl">AVING&nbsp;</font> <font class="home_shop_hdtxt_fl">A</font><font class="home_shop_hdtxt_nl">BOUT&nbsp;</font> <font class="home_shop_hdtxt_fl">U</font><font class="home_shop_hdtxt_nl">S</font><font class="home_shop_hdtxt_fl">!</font></div>
	    <div class="top_adjustment_10" align="center"><p class="home_shop_smlxt_nl"><font class="home_shop_smltxt_fl">D</font>ESIGNER CURATED ROOMS, GUARANTEED TO DELIVER A HIGH-END LOOK - WITHOUT THE HEFTY PRICE TAG.</p></div>
	    <div align="center"><p class="home_shop_smlxt_nl"><font class="home_shop_smltxt_fl">H</font>IGH-QUALITY FURNITURE AND DECOR FROM THE BEST BRANDS AND RETAILERS - ALL IN ONE PLACE.</p></div>
			
		<div class="row top_adjustment_40"> 
		<div class="col-sm-3 col-lg-3"> <div align="center"> <img src="outsideImages/registry_home/home_shop_imgs/home_living_room.jpeg" class="reg_shop_smal_img_wh_adj" alt=""/>  </div> 
	    <div align="center" class="top_adjustment_15"> <a class="home_shop_links" href="shopViewAllDesignsConcepts?selectedShopRoomName=Living+Room">Living Room</a> </div> </div>
	   	
	   	<div class="col-sm-3 col-lg-3"> <div align="center"> <img src="outsideImages/registry_home/home_shop_imgs/home_dining_room.jpeg" class="reg_shop_smal_img_wh_adj" alt=""/>  </div> 
	    <div align="center" class="top_adjustment_15"> <a class="home_shop_links" href="shopViewAllDesignsConcepts?selectedShopRoomName=Dining+Room">Dining Room</a> </div> </div>
	    
	    <div class="col-sm-3 col-lg-3"> <div align="center"> <img src="outsideImages/registry_home/home_shop_imgs/home_bedroom.jpeg" class="reg_shop_smal_img_wh_adj" alt=""/>  </div> 
	    <div align="center" class="top_adjustment_15"> <a class="home_shop_links" href="shopViewAllDesignsConcepts?selectedShopRoomName=Bedroom">Bedroom</a> </div> </div>
	    
	    <div class="col-sm-3 col-lg-3"> <div align="center"> <img src="outsideImages/registry_home/home_shop_imgs/home_office_room.jpeg" class="reg_shop_smal_img_wh_adj" alt=""/>  </div> 
	    <div align="center" class="top_adjustment_15"> <a class="home_shop_links" href="shopViewAllDesignsConcepts?selectedShopRoomName=Home+Office">Home Office</a> </div> </div>
	    </div>
	    	    	    
		<div class="row top_adjustment_40"> 
		<div class="col-sm-3 col-lg-3"> <div align="center"> <img src="outsideImages/registry_home/home_shop_imgs/home_nursery.jpeg" class="reg_shop_smal_img_wh_adj" alt=""/>  </div> 
	    <div align="center" class="top_adjustment_15"> <a class="home_shop_links" href="shopViewAllDesignsConcepts?selectedShopRoomName=Nursery">Nursery</a> </div> </div>
	   	
	   	<div class="col-sm-3 col-lg-3"> <div align="center"> <img src="outsideImages/registry_home/home_shop_imgs/home_kids_bedroom.jpeg" class="reg_shop_smal_img_wh_adj" alt=""/>  </div> 
	    <div align="center" class="top_adjustment_15"> <a class="home_shop_links" href="shopViewAllDesignsConcepts?selectedShopRoomName=Kids+Bedroom">Kids Bedroom</a> </div> </div>
	    
	    <div class="col-sm-3 col-lg-3"> <div align="center"> <img src="outsideImages/registry_home/home_shop_imgs/home_entryway.jpeg" class="reg_shop_smal_img_wh_adj" alt=""/>  </div> 
	    <div align="center" class="top_adjustment_15"> <a class="home_shop_links" href="shopViewAllDesignsConcepts?selectedShopRoomName=Entryway">Entryway</a> </div> </div>
	    
	    <div class="col-sm-3 col-lg-3"> <div align="center"> <img src="outsideImages/registry_home/home_shop_imgs/home_outdoor_space.jpeg" class="reg_shop_smal_img_wh_adj" alt=""/>  </div> 
	    <div align="center" class="top_adjustment_15"> <a class="home_shop_links" href="shopViewAllDesignsConcepts?selectedShopRoomName=Outdoor+Space">Outdoor Space</a> </div> </div>
	    </div>
		
		<div class="row" style="padding-bottom: 40px;"> <div class="col-sm-12 col-lg-12"> <div align="center" class="container-fluid top_adjustment_30"> <form action="registryShop"> <h4 class="get-started-button"> <button class="home_shop_submit_butt">SHOP ALL OF THE LOOKS</button> </h4> </form> </div> </div> </div>
				
		<div class="bot_adjustment_97"> <div id="home-page"> <div class="box design-process"> <div class="arrow-box reg_home_arrow_adj"> <img src="outsideImages/home_images/arrow.png" width="120" height="58"><h2 class="">&nbsp;A&nbsp;<span class="bigger">REGISTRY UNLIKE</span> &nbsp;ANY&nbsp; <span class="bigger">OTHER</span></h2> </div> </div> </div> </div>
		<div class="row"> <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="our-team" align="center"> <img src="outsideImages/registry_home/curated_design_boards.png" class="reg_smal_img_wh_adj" alt=""/> <div class="team-content top_adjustment_40"> <h3 class="title reg_top_home_rem_text_cl"><font class="reg_top_home_fst_text_cl">C</font>URATED <font class="reg_top_home_fst_text_cl">D</font>ESIGN <font class="reg_top_home_fst_text_cl">B</font>OARDS</h3></div> </div>
	    <div class="team-description" align="center"> <div align="center" class="reg_sh_main_txt_bdsp"></div> </div> <div class="team-description reg_sub_sml_txt_cl" id="g1"> <b>BROWSE DESIGNER CURATED BOARDS AND ADD FURNITURE AND DECOR TO YOUR REGISTRY. EASILY CONVERT EXPENSIVE GIFTS INTO GROUP GIFTS!</b><br> </div> <div align="center" id="flnm"> <a class="reg_home_learn_more_ntext_dsp" href="registryHowItWorks#s1">Learn More</a> </div> </div> </div>
	   	<div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="our-team" align="center"> <img src="outsideImages/registry_home/custom_cash_funds.png" class="reg_smal_img_wh_adj" alt="" /> <div class="team-content top_adjustment_40"> <h3 class="title reg_top_home_rem_text_cl"><font class="reg_top_home_fst_text_cl">C</font>USTOM <font class="reg_top_home_fst_text_cl">C</font>ASH <font class="reg_top_home_fst_text_cl">F</font>UNDS</h3> </div> </div> 
	  	<div class="team-description" align="center"> <div align="center" class="reg_sh_main_txt_bdsp"></div> </div> <div class="team-description reg_sub_sml_txt_cl" id="g1"> <b>CUSTOMIZE FUNDS FOR TRAVEL, CHARITY, A DOWN PAYMENT, EDUCATION, OR FOR WHATEVER THE FUTURE HOLDS!</b><br> </div> <div align="center" id="lnm"> <a class="reg_home_learn_more_ntext_dsp" href="registryHowItWorks#s2">Learn More</a> </div> </div> </div>
	    <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="our-team" align="center"> <img src="outsideImages/registry_home/room_funds.png" class="reg_smal_img_wh_adj" alt="" /> <div class="team-content top_adjustment_40"> <h3 class="title reg_top_home_rem_text_cl"><font class="reg_top_home_fst_text_cl">R</font>OOM <font class="reg_top_home_fst_text_cl">F</font>UNDS</h3> </div> </div>
	    <div class="team-description" align="center"> <div align="center" class="reg_sh_main_txt_bdsp"></div> </div> <div class="team-description reg_sub_sml_txt_cl" id="g1"> <b>CREATE FUNDS FOR ROOMS THAT YOU WANT TO DECORATE IN THE FUTURE. FUNDS CONVERT IN TO NOOK+COVE CREDIT THAT CAN BE USED ANYTI ME! </b><br> </div> <div align="center" id="flnm"> <a class="reg_home_learn_more_ntext_dsp" href="registryHowItWorks#s3">Learn More</a> </div> </div> </div> </div>
		<div class="row"> <div class="col-sm-12 col-lg-12"> <div align="center" class="container-fluid top_adjustment_70"> <form action="createRegistry"> <h4 class="get-started-button"> <button class="regi_home_page_submit_button">CREATE A REGISTRY</button> </h4> </form> </div> </div> </div>
		
		<div align="center" class="container-fluid reg_rb_text_img_frame"> <img src="outsideImages/registry_home/home_middle_top_image.png" class="reg_md_big_img_fsdsp"> <div align="center" class="reg_ben_frame_cldsp_cl"> <div class="reg_ben_bg_fulfrm_dsp"> 
		<div align="center"> <div> <font class="reg_home_logo_rb_text_disply">Registry &nbsp;</font> <font class="reg_home_reg_ben_text_dsp">BENEFITS</font> </div> <div class="reg_home_reg_ben_big_text_dsp"><font class="reg_home_reg_ben_big_first_text_dsp">W</font>HAT <font class="reg_home_reg_ben_big_first_text_dsp">M</font>AKES <font class="reg_home_reg_ben_big_first_text_dsp">U</font>S <font class="reg_home_reg_ben_big_first_text_dsp">T</font>RULY <font class="reg_home_reg_ben_big_first_text_dsp">U</font>NIQUE</div> </div> </div> </div> </div>
			
		<div class="row top_adjustment_50"> <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="team-content reg_ben_mid_frame_dspcl "> <h3 class="title reg_sub_sml_txtdsp_cl">FURNITURE &amp; DECOR</h3> </div> <div class="team-description reg_sub_sml_txt_cl" id="g2"> <b><font class="reg_ben_st_nor_font_cl">B</font>EAUTIFUL FURNISHINGS IN A VARIETY OF DESIGN STYLES THAT COMPLETE YOUR HOME</b><br> </div> </div> </div>
        <div class="col-sm-9 col-lg-4 reg_ben_devide_line_cl"> <div class="hover-team"> <div class="team-content reg_ben_mid_frame_dspcl "> <h3 class="title reg_ben_smtext_dsp_cl">DESIGNER'S TOUCH</h3> </div> <div class="team-description reg_sub_sml_txt_cl" id="g2"> <b><font class="reg_ben_st_nor_font_cl">P</font>RE-CURATED ROOMS BY EXPERTS TO ENSURE A HOME WITH THE DESIGNER LOOK, WITHOUT THE HEFTY PRICE TAG</b><br> </div> </div> </div>        
        <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="team-content reg_ben_mid_frame_dspcl "> <h3 class="title reg_sub_sml_txtdsp_cl">TOP RETAILERS</h3> </div> <div class="team-description reg_sub_sml_txt_cl" id="g2"> <b><font class="reg_ben_st_nor_font_cl">W</font>E SOURCE FROM A VARIETY OF TOP HOME DECOR AND DESIGN RETAILERS AND BRANDS </b><br> </div> </div> </div> </div>
		
		<div class="row reg_ben_main_top_adj"> <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="team-description" align="center"> <div align="center" class="reg_ben_bell_text_frame_dsp"></div> </div> </div> </div>                
        <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="team-description" align="center"> <div align="center" class="reg_ben_bell_text_frame_dsp"></div> </div> </div> </div>                
        <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="team-description" align="center"> <div align="center" class="reg_ben_bell_text_frame_dsp"></div> </div> </div> </div> </div>
	
		<div class="row"> <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="team-content reg_ben_mid_frame_dspcl "> <h3 class="title reg_ben_smtext_dsp_cl">GROUP GIFTING</h3> </div> <div class="team-description reg_sub_sml_txt_cl" id="g2"> <b><font class="reg_ben_st_nor_font_cl">C</font>ONVERT ANY GIFT INTO A GROUP GIFT, ALLOWING GUESTS TO CONTRIBUTE AT THEIR COMFORT LEVEL</b><br> </div> </div> </div>        
        <div class="col-sm-9 col-lg-4 reg_ben_devide_line_cl"> <div class="hover-team"> <div class="team-content reg_ben_mid_frame_dspcl "> <h3 class="title reg_ben_smtext_dsp_cl">CASH FUNDS</h3> </div> <div class="team-description reg_sub_sml_txt_cl" id="g2"> <b><font class="reg_ben_st_nor_font_cl">C</font>USTOMIZE FUNDS FOR TRAVEL, A DOWN PAYMENT, EDUCATION OR WHATEVER YOUR FUTURE HOLDS</b><br> </div> </div> </div>        
        <div class="col-sm-9 col-lg-4"> <div class="hover-team"> <div class="team-content reg_ben_mid_frame_dspcl "> <h3 class="title reg_sub_sml_txtdsp_cl">SHIP LATER</h3> </div> <div class="team-description reg_sub_sml_txt_cl" id="g2"> <b><font class="reg_ben_st_nor_font_cl">Y</font>OU DECIDE WHEN GIFTS SHIP. NOW OR LATER, WHATEVER IS CONVENIENT FOR YOU </b><br> </div> </div> </div> </div>
				
		<div class="row"> <div class="col-12"> <div align="center" class="top_adjustment_20"> <a class="reg_home_learn_more_ntext_dsp" href="registryBenefits">Learn More</a> </div> </div> </div>
		
		<div align="center" class="container-fluid top_adjustment_70"> <img src="outsideImages/registry_home/Home_Brands_image.png" class="reg_md_big_img_fsdsp"> </div>	
		<div align="center" class="container-fluid top_adjustment_60"> <div class="reg_brand_ret_main_page"> <div class="img-responsive reg_brand_width_adj_dsp"><font class="bott_first_big_letter_dsp">W</font>E &nbsp;<font class="bott_first_big_letter_dsp">W</font>ORK &nbsp;<font class="bott_first_big_letter_dsp">W</font>ITH &nbsp;<font class="bott_first_big_letter_dsp">T</font>OP &nbsp;<font class="bott_first_big_letter_dsp">H</font>OME &nbsp;<font class="bott_first_big_letter_dsp">B</font>RANDS &nbsp;&amp; &nbsp;<font class="bott_first_big_letter_dsp">R</font>ETAILERS</div>
		<div class="row reg_brand_frm_right_adj" align="center"> <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 reg_brand_pad3_dsp" align="center"> <img src="outsideImages/registry_home/compaines_names/CrateandBarrel.png" class="img-responsive"> </div> <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12" align="center"> <img src="outsideImages/registry_home/compaines_names/PotteryBarn.png" class="img-responsive"> </div>				
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 rbran_pd_toph_dsp" align="center" > <img src="outsideImages/registry_home/compaines_names/RestorationHardware.png" class="img-responsive"> </div> <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 rbran_pd_top2_dsp" align="center"  > <img src="outsideImages/registry_home/compaines_names/WestElm.png" class="img-responsive"> </div>				
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 rbran_pd_top1_dsp" align="center" > <img src="outsideImages/registry_home/compaines_names/Hayneedle.png" class="img-responsive"> </div> </div>
		<div class="row reg_brand_frm_right_adj" align="center"> <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 rbran_pad1_dsp"> <img src="outsideImages/registry_home/compaines_names/BedBathandBeyond.png" class="img-responsive"> </div> <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 rbran_pd_top2_dsp" align="center" > <img src="outsideImages/registry_home/compaines_names/Wayfair.png" class="img-responsive"> </div>
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 reg_brand_pad3_dsp" align="center" > <img src="outsideImages/registry_home/compaines_names/Anthropologie.png" class="img-responsive"> </div> <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 rbran_pad1_dsp" align="center"> <img src="outsideImages/registry_home/compaines_names/WilliamsSonoma.png" class="img-responsive"> </div>
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 rbran_pd_top2_dsp" align="center" > <img src="outsideImages/registry_home/compaines_names/TheLandOfNod.png" class="img-responsive"> </div> </div> <div class="reg_brand_bh_adj"></div> <div class="img-responsive reg_brand_btext_adj"><font class="reg_bot_more_textf">A</font>ND MANY MORE...</div> </div> </div>
		
		<div align="center" class="container-fluid top_adjustment_70"> <img src="outsideImages/registry_home/bottom_last_image.png" class="reg_bot_img_dsp"> <div class="reg_home_bott_img_bg_text"> <h3 class="title reg_home_bott_text_dsp">LIFE'S NEXT CHAPTER IS WAITING...</h3> </div>
		<div class="reg_bott_button_adj"> <form action="createRegistry"> <h4 class="get-started-button"> <button class="regi_home_page_submit_button">CREATE A REGISTRY</button> </h4> </form> </div> </div> <div class="reg_bott_height_dsp"></div> </div>	
</body>
</html>