$(document).ready(function(){$("#furButton").click(function(){var i="#dialog";$("#mask").css({width:$(window).width(),height:$(document).height()}),$("#mask").fadeIn(100),$("#mask").fadeTo("fast",.9),$(i).css("top",$(window).height()/2-$(i).height()/2),$(i).css("left",$(window).width()/2-$(i).width()/2),$(i).fadeIn(500),$(".window .close").click(function(i){i.preventDefault(),$("#mask, .window").hide()})}),$("#removefav").click(function(){$("#removefav").hide(),$("#addfav").show()}),$("#addfav").click(function(){$("#removefav").show(),$("#addfav").hide()}),$("#subFur1").click(function(){$("#mainFur").attr("src","resources/images/popupimgs/chairtypebig1.png")}),$("#subFur2").click(function(){$("#mainFur").attr("src","resources/images/popupimgs/chairtypebig2.png")}),$("#subFur3").click(function(){$("#mainFur").attr("src","resources/images/popupimgs/chairtypebig3.png")}),$("#accePrice, #fullRoomPrice").click(function(){$("#accessories, #full_room").hide(),"accePrice"===$(this).attr("id")&&$("#accessories").show(),"fullRoomPrice"===$(this).attr("id")&&$("#full_room").show(),$("#imgmask").css({width:$(window).width(),height:$(document).height()}),$("#imgmask").fadeIn(100),$("#imgmask").fadeTo("fast",.8),$("#dialog1").fadeIn(500),$(".window1 .close").click(function(){$("#imgmask, .window1").hide()})})});