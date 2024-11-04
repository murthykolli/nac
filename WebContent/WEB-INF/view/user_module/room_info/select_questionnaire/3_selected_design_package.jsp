<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    
	<style type="text/css">
	@font-face { font-family: 'AR BERKLEY'; src: url('resources/sitefonts/ARBERKLEY.ttf') format('truetype'); }
	.room_pack_amount_text_dsp { font-size: 3.5em; font-weight: 500; font-family: "AR BERKLEY"; color: black; letter-spacing: 2px; }
	.room_pack_dollor_text_dsp { font-size: 2.2em; font-style: italic; font-weight: 500; font-family: "AR BERKLEY"; color: black; letter-spacing: 2px; }	
	</style> 
	 
    <!-- Favicons -->
    <link rel="shortcut icon" href="images/ico/favicon.ico" type="image/x-icon">

	<script type="text/javascript">
 	$(document).ready(function(){
 		
 		var packagePrice = '<c:out value="${packagePrice}"/>';
 		
		var packageType;
		var packageValue;
    	$("#fullRoomPackButtonId").click(function (){ 			
 			$("#full-room-dsn-pack-id").css("border-color","black");
 			$("#acc-pack-id").css("border-color","white");
 			packageType = "Full Room Design Package";
 			packageValue = "385";
 			return false;
 	    }); 		

 		$("#accPackButtonId").click(function (){
 			$("#acc-pack-id").css("border-color","black");
 			$("#full-room-dsn-pack-id").css("border-color","white");
 			packageType = "Accessories Package";
 			packageValue = "285";
 			return false;
 	    });
 		
 		if(packagePrice > 0 && packagePrice === "385"){    	
 	    	$("#full-room-dsn-pack-id").css("border-color","black");
 			$("#acc-pack-id").css("border-color","white");
 			packageType = "Full Room Design Package";
 			packageValue = "385";
 	    } else if(packagePrice > 0 && packagePrice === "285"){
 	    	$("#acc-pack-id").css("border-color","black");
 			$("#full-room-dsn-pack-id").css("border-color","white");
 			packageType = "Accessories Package";
 			packageValue = "285";
 	    } else{}
	
	$("#designButtonId").click(function (){	
    var result = true;
    if(packageValue > 0) {        	
    	document.myDesign.typeOfPackage.value = packageType;
    	document.myDesign.packagePrice.value = packageValue;
    } else {
    	alert("PLEASE SELECT A PACKAGE.");
    	result=false;
    }
	
	return result;
	});
	
	var desPackageList = "<c:out value="${selectedDesignPack}"/>";
    $("[name='designPackage']").each(function (){    	
    if(desPackageList.indexOf($(this).val()) !== -1){    
    $(this).attr("checked",true);   
    }   
    });

    });
	</script>
	</head>
		<body>
<div id="mainframe" class="section-content design-package">
    <div class="container">

        <div class="desn_pk-title-section text-center">
            <h4>SELECT YOUR DESIGN PACKAGE</h4>
        </div> <!-- /.title-section -->
        <div class="services">
            <div class="service-item">
                <div class="service-description">
                    <div class="desn-package_disp full_rm_dsn_box_size" id="full-room-dsn-pack-id">
                        
                        <div align="center" class="room_des_package_frame_dsp">
                        <div class="room_des_pack_hd_text_dsp">FULL ROOM<br>DESIGN PACKAGE</div>
                        
                        <div align="center" style="margin-top: 25px;"><font class="room_pack_dollor_text_dsp">$</font><font class="room_pack_amount_text_dsp">385</font></div>
                        <div class="room_des_pack_incd_text_dsp" style="margin-top: 8px;">INCLUDES:</div>
                        
                        <div align="center" style="margin-top: 20px;">
                        <p class="room_des_pack_sub_text_dsp">&#10003; YOUR VERY OWN PROFESSIONAL DESIGNER</p>
                        <p class="room_des_pack_sub_text_dsp">&#10003; TWO PERSONALLY CURATED CONCEPTS</p>
                        <p class="room_des_pack_sub_text_dsp">&#10003; CUSTOMIZED ROOM RENDERING</p>
                        <p class="room_des_pack_sub_text_dsp">&#10003; COMPLIMENTARY SHOPPING SERVICE</p>
                        </div>
                        </div>
                        <div class="text-center">
                            <h4>
                                <button class="gift-submit-Btn" id="fullRoomPackButtonId">SELECT</button>
                            </h4>
                        </div>
                        <div align="center" class="desn_pack_sub_link full_rm_ln_more"><a class="style_link_dis"
                                                                                          href="howItWorks">&nbsp;LEARN
                            MORE&nbsp;</a></div>
                    </div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item">
                <div class="service-description">
                    <div class="desn-package_disp ass_dsn_box_size" id="acc-pack-id">
                        <div align="center" class="room_des_package_frame_dsp">
                        <div class="room_des_pack_hd_text_dsp">ACCESSORIES<br>PACKAGE</div>
                        
                        <div align="center" style="margin-top: 25px;"><font class="room_pack_dollor_text_dsp">$</font><font class="room_pack_amount_text_dsp">285</font></div>
                        <div class="room_des_pack_incd_text_dsp" style="margin-top: 8px;">INCLUDES:</div>
                        
                        <div align="center" style="margin-top: 20px;">
                        <p class="room_des_pack_sub_text_dsp">&#10003; YOUR VERY OWN PROFESSIONAL DESIGNER</p>
                        <p class="room_des_pack_sub_text_dsp">&#10003; TWO PERSONALLY CURATED CONCEPTS</p>                        
                        <p class="room_des_pack_sub_text_dsp">&#10003; COMPLIMENTARY SHOPPING SERVICE</p>
                        <p class="room_des_pack_sub_text_dsp">&nbsp;&nbsp;</p>
                        </div>
                        </div>
                        <div class="text-center">
                            <h4>
                                <button class="gift-submit-Btn" id="accPackButtonId">SELECT</button>
                            </h4>
                        </div>
                        <div align="center" class="desn_pack_sub_link acces_ln_more"><a class="style_link_dis"
                                                                                        href="howItWorks">&nbsp;LEARN
                            MORE&nbsp;</a></div>
                    </div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div>

        <div class="form-nav">
            <form action="desnPackageBackMove" method="get">
                <h4><input class="back_submit_Btn" type="image" title="BACK"
                           src="resources/images/backButton.png"></h4>
                <input type="hidden" name="typeOfSpace"
                       value="<c:out value='${selectedSpace}'/>">
                <input type="hidden" name="typeOfStyle"
                       value="<c:out value='${selectedStyle}'/>">
            </form>
            <form action="selectedDesignPackage" name="myDesign" method="get">
                <h4>
                    <button class="continue_submit_Btn" id="designButtonId">CONTINUE</button>
                </h4>
                <input type="hidden" name="typeOfSpace"
                       value="<c:out value='${selectedSpace}'/>">
                <input type="hidden" name="typeOfStyle"
                       value="<c:out value='${selectedStyle}'/>">

                <input type="hidden" id="typeOfPackageId" name="typeOfPackage">
                <input type="hidden" id="packagePriceId" name="packagePrice">
            </form>
        </div>
    </div> <!-- /.container -->
</div> <!-- /.Main Frame -->

<div style="display: none;">
    <p>FULL ROOM DESIGN PACKAGE $385 ACCESSORIES PACKAGE $285</p>
    <p>INCLUDES: YOUR VERY OWN PROFESSIONAL DESIGNER TWO PERSONALLY CURATED CONCEPTS CUSTOMIZED ROOM RENDERING
        COMPLIMENTARY SHOPPING SERVICE</p>
    <p>INCLUDES: YOUR VERY OWN PROFESSIONAL DESIGNER TWO PERSONALLY CURATED CONCEPTS COMPLIMENTARY SHOPPING SERVICE</p>
</div>

</body>
</html>
