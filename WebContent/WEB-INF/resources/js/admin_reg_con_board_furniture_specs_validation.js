var loadFile1=function(t){var d=$("#productUploadedImage1").val();(void 0===d&&(d=""),""!==d)&&(document.getElementById("output1").src=URL.createObjectURL(t.target.files[0]),$("#image1BorderDisplayId").show())},loadFile2=function(t){var d=$("#productUploadedImage2").val();(void 0===d&&(d=""),""!==d)&&(document.getElementById("output2").src=URL.createObjectURL(t.target.files[0]),$("#image2BorderDisplayId").show())},loadFile3=function(t){var d=$("#productUploadedImage3").val();(void 0===d&&(d=""),""!==d)&&(document.getElementById("output3").src=URL.createObjectURL(t.target.files[0]),$("#image3BorderDisplayId").show())},loadFile4=function(t){var d=$("#productUploadedImage4").val();(void 0===d&&(d=""),""!==d)&&(document.getElementById("output4").src=URL.createObjectURL(t.target.files[0]),$("#image4BorderDisplayId").show())};$(document).ready(function(){$("#removeUPImg1Id").click(function(){return document.getElementById("output1").src="",$("#image1BorderDisplayId").hide(),$("#productUploadedImage1").val(null),!1}),$("#removeUPImg2Id").click(function(){return document.getElementById("output2").src="",$("#image2BorderDisplayId").hide(),$("#productUploadedImage2").val(null),!1}),$("#removeUPImg3Id").click(function(){return document.getElementById("output3").src="",$("#image3BorderDisplayId").hide(),$("#productUploadedImage3").val(null),!1}),$("#removeUPImg4Id").click(function(){return document.getElementById("output4").src="",$("#image4BorderDisplayId").hide(),$("#productUploadedImage4").val(null),!1})});var productStatus1="",productStatus2="",productStatus3="",productStatus4="";$(document).ready(function(){$("#clickAddProducts1Id").click(function(){return $(".addProductsButtCl1Dsp").hide(),$(".addProductsButtCl2Dsp").show(),$(".addProductsCl2Dsp").show(),productStatus1="Done",!1}),$("#clickAddProducts2Id").click(function(){return $(".addProductsButtCl1Dsp").hide(),$(".addProductsButtCl2Dsp").hide(),$(".addProductsButtCl3Dsp").show(),$(".addProductsCl2Dsp").show(),$(".addProductsCl3Dsp").show(),productStatus2="Done",!1}),$("#clickAddProducts3Id").click(function(){return $(".addProductsButtCl1Dsp").hide(),$(".addProductsButtCl2Dsp").hide(),$(".addProductsButtCl3Dsp").hide(),$(".addProductsButtCl4Dsp").show(),$(".addProductsCl2Dsp").show(),$(".addProductsCl3Dsp").show(),$(".addProductsCl4Dsp").show(),productStatus3="Done",!1}),$("#clickAddProducts4Id").click(function(){return $(".addProductsButtCl1Dsp").hide(),$(".addProductsButtCl2Dsp").hide(),$(".addProductsButtCl3Dsp").hide(),$(".addProductsButtCl4Dsp").hide(),$(".addProductsButtCl5Dsp").show(),$(".addProductsCl2Dsp").show(),$(".addProductsCl3Dsp").show(),$(".addProductsCl4Dsp").show(),$(".addProductsCl5Dsp").show(),productStatus4="Done",!1}),$("#clickRemoveProducts2Id").click(function(){return $(".addProductsCl5Dsp").hide(),$(".addProductsCl4Dsp").hide(),$(".addProductsCl3Dsp").hide(),$(".addProductsCl2Dsp").hide(),$(".addProductsCl1Dsp").show(),$(".addProductsButtCl5Dsp").hide(),$(".addProductsButtCl4Dsp").hide(),$(".addProductsButtCl3Dsp").hide(),$(".addProductsButtCl2Dsp").hide(),$(".addProductsButtCl1Dsp").show(),$("#productSize2Id").val(""),$("#productPrice2Id").val(""),productStatus1="",!1}),$("#clickRemoveProducts3Id").click(function(){return $(".addProductsCl5Dsp").hide(),$(".addProductsCl4Dsp").hide(),$(".addProductsCl3Dsp").hide(),$(".addProductsCl2Dsp").show(),$(".addProductsCl1Dsp").show(),$(".addProductsButtCl5Dsp").hide(),$(".addProductsButtCl4Dsp").hide(),$(".addProductsButtCl3Dsp").hide(),$(".addProductsButtCl2Dsp").show(),$(".addProductsButtCl1Dsp").hide(),$("#productSize3Id").val(""),$("#productPrice3Id").val(""),productStatus2="",!1}),$("#clickRemoveProducts4Id").click(function(){return $(".addProductsCl5Dsp").hide(),$(".addProductsCl4Dsp").hide(),$(".addProductsCl3Dsp").show(),$(".addProductsCl2Dsp").show(),$(".addProductsCl1Dsp").show(),$(".addProductsButtCl5Dsp").hide(),$(".addProductsButtCl4Dsp").hide(),$(".addProductsButtCl3Dsp").show(),$(".addProductsButtCl2Dsp").hide(),$(".addProductsButtCl1Dsp").hide(),$("#productSize4Id").val(""),$("#productPrice4Id").val(""),productStatus3="",!1}),$("#clickRemoveProducts5Id").click(function(){return $(".addProductsCl5Dsp").hide(),$(".addProductsCl4Dsp").show(),$(".addProductsCl3Dsp").show(),$(".addProductsCl2Dsp").show(),$(".addProductsCl1Dsp").show(),$(".addProductsButtCl5Dsp").hide(),$(".addProductsButtCl4Dsp").show(),$(".addProductsButtCl3Dsp").hide(),$(".addProductsButtCl2Dsp").hide(),$(".addProductsButtCl1Dsp").hide(),$("#productSize5Id").val(""),$("#productPrice5Id").val(""),productStatus4="",!1})}),$(document).ready(function(){var t=/^[A-Za-z 0-9 \-#:?|+<>={}!$%&*'()"_.@\/&;,-]*$/,d=/^[A-Za-z 0-9][A-Za-z 0-9 \-#:?|+<>={}!$%&*'()"_.@\/&;,-]*$/,o=/(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/,r=/^[0-9\$]*(?=.*\d)[0-9-,.]*$/,c=/^[A-Za-z 0-9][A-Za-z 0-9 \-#:?|+<>={}!$%&*'()"_.@\/&;,-]*$/;$("#admConFurnitureSpecsButtId").click(function(){var e=!0;t.test($("#productNameId").val())?$("#productNameId").css("border-bottom-color","black"):($("#productNameId").css("border-bottom-color","red"),e=!1),r.test($("#productPrice1Id").val())?$("#productPrice1Id").css("border-bottom-color","black"):($("#productPrice1Id").css("border-bottom-color","red"),e=!1),c.test($("#productDescription1Id").val())?$("#productDescription1Id").css("border-bottom-color","black"):($("#productDescription1Id").css("border-bottom-color","red"),e=!1),"Done"==productStatus1&&(r.test($("#productPrice2Id").val())?$("#productPrice2Id").css("border-bottom-color","black"):($("#productPrice2Id").css("border-bottom-color","red"),e=!1)),"Done"==productStatus2&&(r.test($("#productPrice3Id").val())?$("#productPrice3Id").css("border-bottom-color","black"):($("#productPrice3Id").css("border-bottom-color","red"),e=!1)),"Done"==productStatus3&&(r.test($("#productPrice4Id").val())?$("#productPrice4Id").css("border-bottom-color","black"):($("#productPrice4Id").css("border-bottom-color","red"),e=!1)),"Done"==productStatus4&&(r.test($("#productPrice5Id").val())?$("#productPrice5Id").css("border-bottom-color","black"):($("#productPrice5Id").css("border-bottom-color","red"),e=!1)),d.test($("#brandNameId").val())?$("#brandNameId").css("border-bottom-color","black"):($("#brandNameId").css("border-bottom-color","red"),e=!1),d.test($("#storeNameId").val())?$("#storeNameId").css("border-bottom-color","black"):($("#storeNameId").css("border-bottom-color","red"),e=!1),o.test($("#storeURLId").val())?$("#storeURLId").css("border-bottom-color","black"):($("#storeURLId").css("border-bottom-color","red"),e=!1),""!==$("#skuNameId").val()?$("#skuNameId").css("border-bottom-color","black"):($("#skuNameId").css("border-bottom-color","red"),e=!1);var s=$("#productUploadedImage1").val(),u=s.replace(/^.*\./,"").toLowerCase();if(""!==$("#productNameId").val()&&""!==$("#productPrice1Id").val()&&""!==$("#storeNameId").val()&&""!==$("#storeURLId").val()&&""!==$("#productDescription1Id").val()&&""!==$("#skuNameId").val())if(""===s)alert("Please upload a product image."),e=!1;else if("png"!==u&&"jpg"!==u&&"gif"!==u&&"jpeg"!==u)return alert("Please upload a JPG, GIF, or PNG file."),!1;return e}),$("#brandNameId").keyup(function(){d.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#productNameId").keyup(function(){t.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#productDescription1Id").keyup(function(){c.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#productPrice1Id").keyup(function(){r.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#productPrice2Id").keyup(function(){r.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#productPrice3Id").keyup(function(){r.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#productPrice4Id").keyup(function(){r.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#productPrice5Id").keyup(function(){r.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#storeNameId").keyup(function(){d.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#storeURLId").keyup(function(){o.test(this.value)?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#skuNameId").keyup(function(){""!=this.value?$(this).css("border-bottom-color","black"):$(this).css("border-bottom-color","red")}),$("#productPrice1Id").keypress(function(t){if(8!=t.which&&0!=t.which&&(t.which<45||t.which>57))return!1}),$("#productPrice2Id").keypress(function(t){if(8!=t.which&&0!=t.which&&(t.which<45||t.which>57))return!1}),$("#productPrice3Id").keypress(function(t){if(8!=t.which&&0!=t.which&&(t.which<45||t.which>57))return!1}),$("#productPrice4Id").keypress(function(t){if(8!=t.which&&0!=t.which&&(t.which<45||t.which>57))return!1}),$("#productPrice5Id").keypress(function(t){if(8!=t.which&&0!=t.which&&(t.which<45||t.which>57))return!1})});