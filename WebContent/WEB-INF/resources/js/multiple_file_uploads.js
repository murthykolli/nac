$(document).ready(function(){$(".buttonstyleClass").click(function(){$(".uploadForms").hide(),"uploadButn1"===this.id&&$("#concept1Form").show(),"uploadButn2"===this.id&&$("#concept2Form").show(),"uploadButn3"===this.id&&$("#3dRenderingForm").show(),$("#mask").css({width:$(window).width(),height:$(document).height()}),$("#mask").fadeIn(100),$("#mask").fadeTo("fast",.8),$("#imageDialog").fadeIn(500),$(".imageWindow .close").click(function(o){o.preventDefault(),$("#mask, .imageWindow").hide()})}),$(".buttonUploadClass").click(function(){var o="";"buttonUpload1"===this.id?o=$("#concept1Upload").val():"buttonUpload2"===this.id?o=$("#concept2Upload").val():"buttonUpload3"===this.id&&(o=$("#3dRendeingUpload").val());var e=o.replace(/^.*\./,"").toLowerCase();return""===o?(alert("Pleae select a image to upload."),!1):"png"===e||"jpg"===e||"gif"===e||"jpeg"===e||"bmp"===e||"heic"===e||"heif"===e||(alert("Please upload a JPG, JPEG, BMP, HEIC, HEIF, GIF, or PNG file."),!1)})});