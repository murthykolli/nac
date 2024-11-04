$(document).ready(function() {

	$(".portfolios").click(function(){
    window.scrollTo(0,0);            
   
    $("#bigPortfolio").attr("src",$(this).attr("src").replace("small","big")).css({'display': 'block', 'top': '30px'});
	$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
	$('#popUpBigMaskWindowId').fadeIn(100);	
	$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
	$("#imageBackgroundDspId").fadeIn(500);
	$('.window .close').click(function(e) {
	e.preventDefault();
	$('#popUpBigMaskWindowId, .window').hide();
	});
	});

	$(".portfoliosPopupImg").click(function(){
    window.scrollTo(0,0);            
   
    $("#bigPortfolio").attr("src",$(this).attr("src").replace("small","big")).css({'display': 'block', 'top': '30px'});
	$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
	$('#popUpBigMaskWindowId').fadeIn(100);	
	$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
	$("#imageBackgroundDspId").fadeIn(500);
	$('.window .close').click(function(e) {
	e.preventDefault();
	$('#popUpBigMaskWindowId, .window').hide();
	});
	});
	

/*Style Popup display jquery*/
	$(".styleOfProductsPopupImg1").click(function(){
    window.scrollTo(0,0);            
    var imgPath = "resources/images/style_images/classic_design.jpg";
    $("#bigPortfolio").attr("src",imgPath).css({'display': 'block', 'top': '30px'});
	$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
	$('#popUpBigMaskWindowId').fadeIn(100);	
	$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
	$("#imageBackgroundDspId").fadeIn(500);
	$('.window .close').click(function(e) {
	e.preventDefault();
	$('#popUpBigMaskWindowId, .window').hide();
	});
	});
	
	$(".styleOfProductsPopupImg2").click(function(){
    window.scrollTo(0,0);            
    var imgPath = "resources/images/style_images/modern_design.jpg";
    $("#bigPortfolio").attr("src",imgPath).css({'display': 'block', 'top': '30px'});
	$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
	$('#popUpBigMaskWindowId').fadeIn(100);	
	$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
	$("#imageBackgroundDspId").fadeIn(500);
	$('.window .close').click(function(e) {
	e.preventDefault();
	$('#popUpBigMaskWindowId, .window').hide();
	});
	});	
	
	$(".styleOfProductsPopupImg3").click(function(){
    window.scrollTo(0,0);            
    var imgPath = "resources/images/style_images/eclectic_design.jpg";
    $("#bigPortfolio").attr("src",imgPath).css({'display': 'block', 'top': '30px'});
	$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
	$('#popUpBigMaskWindowId').fadeIn(100);	
	$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
	$("#imageBackgroundDspId").fadeIn(500);
	$('.window .close').click(function(e) {
	e.preventDefault();
	$('#popUpBigMaskWindowId, .window').hide();
	});
	});

	$(".styleOfProductsPopupImg4").click(function(){
    window.scrollTo(0,0);            
    var imgPath = "resources/images/style_images/contemporary_design.jpg";
    $("#bigPortfolio").attr("src",imgPath).css({'display': 'block', 'top': '30px'});
	$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
	$('#popUpBigMaskWindowId').fadeIn(100);	
	$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
	$("#imageBackgroundDspId").fadeIn(500);
	$('.window .close').click(function(e) {
	e.preventDefault();
	$('#popUpBigMaskWindowId, .window').hide();
	});
	});
	

	/*Color Popup display jquery*/
		$(".colorOfProductsPopupImg1").click(function(){
	    window.scrollTo(0,0);            
	    var imgPath = "resources/images/color_imgs/neutrals.jpg";
	    $("#bigPortfolio").attr("src",imgPath).css({'display': 'block', 'top': '30px'});
		$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
		$('#popUpBigMaskWindowId').fadeIn(100);	
		$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
		$("#imageBackgroundDspId").fadeIn(500);
		$('.window .close').click(function(e) {
		e.preventDefault();
		$('#popUpBigMaskWindowId, .window').hide();
		});
		});
		
		$(".colorOfProductsPopupImg2").click(function(){
	    window.scrollTo(0,0);            
	    var imgPath = "resources/images/color_imgs/pops_of_color.jpg";
	    $("#bigPortfolio").attr("src",imgPath).css({'display': 'block', 'top': '30px'});
		$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
		$('#popUpBigMaskWindowId').fadeIn(100);	
		$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
		$("#imageBackgroundDspId").fadeIn(500);
		$('.window .close').click(function(e) {
		e.preventDefault();
		$('#popUpBigMaskWindowId, .window').hide();
		});
		});	
		
		$(".colorOfProductsPopupImg3").click(function(){
	    window.scrollTo(0,0);            
	    var imgPath = "resources/images/color_imgs/lots_of_color.jpg";
	    $("#bigPortfolio").attr("src",imgPath).css({'display': 'block', 'top': '30px'});
		$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
		$('#popUpBigMaskWindowId').fadeIn(100);	
		$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
		$("#imageBackgroundDspId").fadeIn(500);
		$('.window .close').click(function(e) {
		e.preventDefault();
		$('#popUpBigMaskWindowId, .window').hide();
		});
		});

		
/*Shopping cart EXCLUDES TAX & SHIPPING Payment Popup display jquery*/
		$(".excTaxtShippingPopupImg").click(function(){
	    window.scrollTo(0,0);            
	    var imgPath = "resources/images/concepts/excludes_tax_and_shipping.jpg";
	    $("#bigPortfolio").attr("src",imgPath).css({'display': 'block', 'top': '30px'});
		$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
		$('#popUpBigMaskWindowId').fadeIn(100);	
		$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
		$("#imageBackgroundDspId").fadeIn(500);
		$('.window .close').click(function(e) {
		e.preventDefault();
		$('#popUpBigMaskWindowId, .window').hide();
		});
		});
		
	
});

$(document).ready(function(){
	$.conceptsRenderingPopup = function(imgRedValue){		
		window.scrollTo(0,0);          
		 
		$("#bigConceptsRendPopupImgId").attr("src",imgRedValue).css({'display': 'block', 'top': '30px'});
		$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
		$('#popUpBigMaskWindowId').fadeIn(100);	
		$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
		$("#imageBackgroundDspId").fadeIn(500);
		$('.window .close').click(function(e) {
		e.preventDefault();
		$('#popUpBigMaskWindowId, .window').hide();
		});
	}
});



/*
$(document).ready(function(){
	$(".popup_with_in_popup_id").click(function(){		
		window.scrollTo(0,0);
		$('#boxes').hide();
		
		$("#bigPortfolio").attr("src",$(this).attr("src")).css({'display': 'block', 'top': '30px'});
		$('#popUpBigMaskWindowId').css({'width':$(window).width(),'height':$(document).height()});
		$('#popUpBigMaskWindowId').fadeIn(100);	
		$('#popUpBigMaskWindowId').fadeTo("fast",0.9);
		$("#imageBackgroundDspId").fadeIn(500);
		$('.window .close').click(function(e) {
		e.preventDefault();
		$('#popUpBigMaskWindowId, .window').hide();
		});
	});
});


$(document).ready(function(){
	$(".popup_close_butt_id").click(function(){	
		
	});
});*/

