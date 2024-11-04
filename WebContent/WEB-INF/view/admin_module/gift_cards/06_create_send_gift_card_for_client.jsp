<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="images/ico/favicon.ico" type="image/x-icon">
	
	<script type="text/javascript">

	$(document).ready(function(){ 				
 	   
        var zipRegExp = /^\d{5}$/;
        var nameRegExp = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; 
        var emailRegExp = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
        var numbRegExp = /^[0-9]+$/;
        
        $("#sendGiftCardCreationId").click(function (){	
            var result = true; 

            if($("input[name=typeOfDelivery][value='Gift Box']").is(':checked')){
            	if(nameRegExp.test($("#recGiftNameId").val())){ $("#recGiftNameId").css("border-bottom-color","black");
                } else{ $("#recGiftNameId").css("border-bottom-color","red"); result=false;
                }
            	
            	if(nameRegExp.test($("#recGiftAddressId").val())){ $("#recGiftAddressId").css("border-bottom-color","black");
                } else{ $("#recGiftAddressId").css("border-bottom-color","red"); result=false;
                }
            	
            	if(nameRegExp.test($("#recGiftCityId").val())){ $("#recGiftCityId").css("border-bottom-color","black");
                } else{ $("#recGiftCityId").css("border-bottom-color","red"); result=false;
                }
            	
            	if(nameRegExp.test($("#recGiftStateId").val())){ $("#recGiftStateId").css("border-bottom-color","black");
                } else{ $("#recGiftStateId").css("border-bottom-color","red"); result=false;
                }
            	
            	if(zipRegExp.test($("#recGiftZipCodeId").val())){ $("#recGiftZipCodeId").css("border-bottom-color","black");
                } else{ $("#recGiftZipCodeId").css("border-bottom-color","red"); result=false;
                }
            	
            	if(($("#recGiftNameId").val() === "") || ($("#recGiftAddressId").val() === "") || ($("#recGiftCityId").val() === "") || ($("#recGiftStateId").val() === "") || ($("#recGiftZipCodeId").val()) === "") {
                	alert("Please make sure all fields have been filled out correctly");
                	result = false;
                }            
            }
            else if($("input[name=typeOfDelivery][value='Email']").is(':checked')){
            	if(nameRegExp.test($("#recEmailarNameId").val())){ $("#recEmailarNameId").css("border-bottom-color","black");
                } else{ $("#recEmailarNameId").css("border-bottom-color","red"); result=false;
                }
            	
            	if(emailRegExp.test($("#recEmailAddressId").val())){ $("#recEmailAddressId").css("border-bottom-color","black");
                } else{ $("#recEmailAddressId").css("border-bottom-color","red"); result=false;
                }
            	
            	if(($("#recEmailarNameId").val() === "") || ($("#recEmailAddressId").val() === "")) {
                	alert("Please make sure all fields have been filled out correctly");
                	result = false;
                } 
            	
            } else {
            	alert("PLEASE SELECT A DELIVERY METHOD.");
            	result=false;
            }
     		return result;
        });
        
        
        $("#giftBoxDeliveryId").click(function (){
        	$("#giftBoxDeliveryRowId").show();
 			$("#barDivDisplayId").show();
 			$("#emailDeliveryRowId").hide();
 			$("#recEmailarNameId, #recEmailAddressId").val("");
 			$("body, html").animate({ scrollTop: $(this).offset().top + 40}, 1500 );
        });
        
        $("#emailDeliveryId").click(function (){
        	$("#emailDeliveryRowId").show();
 			$("#barDivDisplayId").show();
 			$("#giftBoxDeliveryRowId").hide();
 			$("#recGiftNameId, #recGiftAddressId, #recGiftCityId, #recGiftStateId, #recGiftZipCodeId").val("");
 			$("body, html").animate({ scrollTop: $(this).offset().top + 40}, 1500 );
        });        
        
    	var giftBoxDelivery = $("#giftBoxDeliveryId").val();
    	var emailDelivery = $("#emailDeliveryId").val();
    	
    	$("#recGiftNameId").keyup(function(){    		
        if(giftBoxDelivery === "Gift Box" && nameRegExp.test(this.value)){ $(this).css("border-bottom-color","black");
        } else{ $(this).css("border-bottom-color","red");
        } });

    	$("#recGiftAddressId").keyup(function(){    		
        if(giftBoxDelivery === "Gift Box" && nameRegExp.test(this.value)){ $(this).css("border-bottom-color","black");
        } else{ $(this).css("border-bottom-color","red");
        } });

    	$("#recGiftCityId").keyup(function(){
        if(giftBoxDelivery === "Gift Box" && nameRegExp.test(this.value)){ $(this).css("border-bottom-color","black");
        } else{ $(this).css("border-bottom-color","red");
        } });

    	$("#recGiftStateId").keyup(function(){
        if(giftBoxDelivery === "Gift Box" && nameRegExp.test(this.value)){ $(this).css("border-bottom-color","black");
        } else{ $(this).css("border-bottom-color","red");
        } });

    	$("#recGiftZipCodeId").keydown(function(){
        if(giftBoxDelivery === "Gift Box" && zipRegExp.test(this.value)){ $(this).css("border-bottom-color","black");
        } else{ $(this).css("border-bottom-color","red");
        } });
    	
    	$("#recGiftZipCodeId").keyup(function(){
        if(giftBoxDelivery === "Gift Box" && zipRegExp.test(this.value)){ $(this).css("border-bottom-color","black"); $("body, html").animate({ scrollTop: $(this).offset().top }, 1500 );
        } else{ $(this).css("border-bottom-color","red");
        } });
        

    	$("#recEmailarNameId").keyup(function(){
        if(emailDelivery === "Email" && nameRegExp.test(this.value)){ $(this).css("border-bottom-color","black");
        } else{ $(this).css("border-bottom-color","red");
        } });

    	$("#recEmailAddressId").keyup(function(){
        if(emailDelivery === "Email" && emailRegExp.test(this.value)){ $(this).css("border-bottom-color","black");
        } else{ $(this).css("border-bottom-color","red");
        } });
	});
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content gift">
        <div class="container">
         
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-5 col-sm-5">
        <div class="adm_new_cl_head_txt_dsp" align="left">CREATE GIFT CARDS</div>
        </div>
        <div class="col-md-5 col-sm-5">
        </div>
                
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
         
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        
        <div class="col-md-10 col-sm-10">
        <div class="admin_gift_card_management">
		<a href="newGiftCards"><font class="pendGiftCardCurrentTab">&nbsp;NEW GIFT CARDS&nbsp;</font></a> </div>
		
		<div class="admin_gift_card_management">
		<a href="sentGiftCards"><font class="pendGiftCardCurrentTab">&nbsp;SEND GIFT CARDS&nbsp;</font></a> </div>
		
		<div class="admin_gift_card_management">
		<a href="createGiftCards"><font class="pendGiftCardCurrentTab">&nbsp;CREATE GIFT CARDS&nbsp;</font></a> </div>
		
		<div class="admin_gift_card_current_management">
		<a href="manageGiftCards"><font class="pendGiftCardCurrentTab">&nbsp;MANAGE GIFT CARDS&nbsp;</font></a> </div>
		</div>
                        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <form action="adminSendGiftCardDataSaving" name="designerClients" id="designerClientsId" method="post">      
        
        <div class="row">
		<div class="col-md-1 col-sm-1"></div>
		
		<div class="col-md-10 col-sm-10" align="center" style="border: 2px solid #cdcdcd; box-shadow: 5px 5px #999999; padding: 65px; margin-left: 15px; margin-right: 15px;">
                
                
            <div class="row">
                    <div class="service-item">
                        <div class="service-description ">
                            <div class="gift-marc-crd-subhed type-of-gift-card-hd">
                                <h2>DELIVERY METHOD</h2>
                            </div>
                        </div> <!-- /.service-description -->
                    </div> <!-- /.service-item -->
            </div> <!-- /.row -->
            
            <div class="row">
            <div class="col-md-4 col-sm-4"></div>
			<div class="col-md-2 col-sm-2">
                <div class="delivery-item">
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/delivery_gift_box.jpg" id="giftBoxSelId" alt="gift box">
                    </div>
                    <div class="text-center"><input type="radio" id="giftBoxDeliveryId" name="typeOfDelivery"
                                                    value="Gift Box"></div>
                    <div class="text-center del-text-display">GIFT BOX</div>
                </div>
         	</div>

			<div class="col-md-2 col-sm-2">
                <div class="delivery-item">
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/delivery_email.jpg" id="emailSelId" alt="email">
                    </div>
                    <div class="text-center"><input type="radio" id="emailDeliveryId" name="typeOfDelivery"
                                                    value="Email"></div>
                    <div class="text-center del-text-display">EMAIL</div>
                </div>
       		</div>
       		<div class="col-md-4 col-sm-4"></div>
            </div> <!-- /.row -->
            
            <div id="giftBoxDeliveryRowId" class="row" style="display: none;">
            <div class="no-border"></div>
                    <div class="service-item">
                        <div class="service-description ">
                            <div class="gift-marc-crd-subhed type-of-gift-card-hd">
                                <h2>RECIPIENT INFO</h2>
                            </div>
                        </div> <!-- /.service-description -->

                        <div  class="service-description ">
                            <table style="margin-top: -20px;">
                                <tr>
                                    <td><input type="text" class="inputbox-display" id="recGiftNameId"
                                               name="giftRecipientName" placeholder="NAME"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" class="inputbox-display" id="recGiftAddressId"
                                               name="giftRecipientAddress" placeholder="STREET ADDRESS"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" class="inputbox-display" id="recGiftCityId"
                                               name="giftRecipientCity" placeholder="CITY"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" class="inputbox-display" id="recGiftStateId"
                                               name="giftRecipientState" placeholder="STATE"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" class="inputbox-display" maxlength="5" id="recGiftZipCodeId"
                                               name="giftRecipientZipCode" placeholder="ZIP CODE"
                                               onkeypress="return numeralsOnly(event);"></td>
                                </tr>
                            </table>
                        </div>
                    </div> <!-- /.service-item -->                    
            </div> <!-- /.row -->
            
            <div id="emailDeliveryRowId" class="row" style="display: none;">
            <div class="no-border"></div>
                    <div class="service-item">
                        <div class="service-description ">
                            <div class="gift-marc-crd-subhed type-of-gift-card-hd">
                                <h2>RECIPIENT INFO</h2>
                            </div>
                        </div> <!-- /.service-description -->

                        <div  class="service-description ">
                            <table style="margin-top: -20px;">
                                <tr>
                                    <td><input type="text" class="inputbox-display" id="recEmailarNameId"
                                               name="recEmailarName" placeholder="NAME"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" class="inputbox-display" id="recEmailAddressId"
                                               name="recEmailarAddress" placeholder="EMAIL"></td>
                                </tr>
                            </table>
                        </div>
                    </div> <!-- /.service-item -->                    
            </div> <!-- /.row -->            
            
               <div class="no-border"></div>
                <div class="text-center top_adjustment_50">
				<h4><button class="admin_cl_dir_submit_Btn" id="sendGiftCardCreationId">SAVE</button></h4>
				</div>
				
            </div>   
            <div class="col-md-1 col-sm-1"></div>    
            </div> <!-- /.row -->
            <input type="hidden" name="adminGiftCardID" value="${adminGiftCardID}">    
        </form>
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
             	
		</body>
</html>