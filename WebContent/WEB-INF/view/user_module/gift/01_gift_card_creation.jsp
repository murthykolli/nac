<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/resources/images/ico/favicon.ico">

    <!-- CSS files -->
    <link rel="stylesheet" type="text/css" href="resources/css/date_picker.css"/>

    <!-- JS files -->
    <script type="text/javascript" src="resources/js/date_picker_min.js"></script>
    <script type="text/javascript" src="resources/js/gift_validation.js"></script>
    <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=sessionTimeOut"/>

	<style type="text/css">
	@font-face { font-family: 'AR BERKLEY'; src: url('resources/sitefonts/ARBERKLEY.ttf') format('truetype'); }
	.room_pack_amount_text_dsp { font-size: 3.5em; font-weight: 500; font-family: "AR BERKLEY"; color: black; letter-spacing: 2px; }
	.room_pack_dollor_text_dsp { font-size: 2.2em; font-style: italic; font-weight: 500; font-family: "AR BERKLEY"; color: black; letter-spacing: 2px; }	
	</style> 
	 
</head>

<body>
<div id="mainframe" class="section-content gift">
    <div class="container">
        <div class="gift-hero">
            <img src="resources/images/gift-imgs/gift-hero.jpg" alt="the perfect gift for any occasion">
            <h1 class="title box" style="font-size: 1.35em; letter-spacing: 3px;">The Perfect Gift For Any Occasion!</h1>
        </div>
    </div>
    <div class="container sub-container">
        <form name="giftForm" action="giftDataSaving" method="post">
            <div class="row">
                <%--                <!-- <div class="col-md-12 col-sm-12">
                                <div class="text-center"><img src="resources/images/gift-imgs/gift-img-01.png"></div>
                                </div> -->--%>
                <div class="service-item opt-1">
                    <div class="service-description">
                        <div class="gift_full_room_dsn_pack" id="gift-full-room-dsn-pack-id">
                            
                        <div align="center" class="room_des_package_frame_dsp">
                        <div class="room_des_pack_hd_text_dsp">FULL ROOM<br>DESIGN PACKAGE</div>
                        
                        <div align="center" style="margin-top: 25px;"><font class="room_pack_dollor_text_dsp">$</font><font class="room_pack_amount_text_dsp">185</font></div>
                        <div class="room_des_pack_incd_text_dsp" style="margin-top: 8px;">INCLUDES:</div>
                        
                        <div align="center" style="margin-top: 20px;">
                        <p class="room_des_pack_sub_text_dsp">&#10003; THEIR VERY OWN PROFESSIONAL DESIGNER</p>
                        <p class="room_des_pack_sub_text_dsp">&#10003; TWO PERSONALLY CURATED CONCEPTS</p>
                        <p class="room_des_pack_sub_text_dsp">&#10003; CUSTOMIZED ROOM RENDERING</p>
                        <p class="room_des_pack_sub_text_dsp">&#10003; COMPLIMENTARY SHOPPING SERVICE</p>
                        </div>
                        </div>
                            <div class="text-center">
                                <h4>
                                    <button class="gift-submit-Btn" style="margin-left: 18px;"
                                            id="giftFullRoomPackButtonId">SELECT
                                    </button>
                                </h4>
                            </div>
                        </div>
                    </div> <!-- /.service-description -->
                </div> <!-- /.service-item -->

                <div class="service-item opt-2">
                    <div class="service-description">
                        <div class="gift_acc_dsn_pack" id="gift-acc-pack-id">
                            <div align="center" class="room_des_package_frame_dsp">
                        <div class="room_des_pack_hd_text_dsp">ACCESSORIES<br>PACKAGE</div>
                        
                        <div align="center" style="margin-top: 25px;"><font class="room_pack_dollor_text_dsp">$</font><font class="room_pack_amount_text_dsp">85</font></div>
                        <div class="room_des_pack_incd_text_dsp" style="margin-top: 8px;">INCLUDES:</div>
                        
                        <div align="center" style="margin-top: 20px;">
                        <p class="room_des_pack_sub_text_dsp">&#10003; THEIR VERY OWN PROFESSIONAL DESIGNER</p>
                        <p class="room_des_pack_sub_text_dsp">&#10003; TWO PERSONALLY CURATED CONCEPTS</p>                        
                        <p class="room_des_pack_sub_text_dsp">&#10003; COMPLIMENTARY SHOPPING SERVICE</p>
                        <p class="room_des_pack_sub_text_dsp">&nbsp;&nbsp;</p>
                        </div>
                        </div>
                            <div class="text-center">
                                <h4>
                                    <button class="gift-submit-Btn" style="margin-left: -18px;"
                                            id="giftAccPackButtonId">SELECT
                                    </button>
                                </h4>
                            </div>
                        </div>
                    </div> <!-- /.service-description -->
                </div>   <!-- /.service-item -->

            </div> <!-- /.row -->

            <div class="row">

                <div class="service-item">
                    <div class="service-description ">
                        <div class="gift-marc-crd-hed type-of-gift-card-hd">
                            <h2>ADD MERCHANDISE CREDIT</h2>
                        </div>

                        <div class="text-center sp-but-height">
                            <font class="gift-box-font">$</font><input id="merchandiseCreditId" name="merchandiseCredit"
                                                                       placeholder="None" class="gift-mer-select-box"
                                                                       onkeypress="return numeralsOnly(event);">
                        </div>
                    </div> <!-- /.service-description -->
                </div> <!-- /.service-item -->
            </div> <!-- /.row -->


            <div class="row no-border">

                <div class="service-item">
                    <div class="service-description ">
                        <div class="type-of-gift-card-hd">
                            <h2>TYPE OF GIFT CARD</h2>
                        </div>
                    </div> <!-- /.service-description -->
                </div> <!-- /.service-item -->

            </div> <!-- /.row -->


            <div class="row sp-but-height">

                <div>
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/type-of-gift-card-01.png" id="giftCardSel1" alt="a gift for you">
                    </div>
                    <div class="text-center"><input type="radio" class="giftCardJump" name="typeOfGiftcard"
                                                    value="A Gift For You"></div>
                </div>
                <div>
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/type-of-gift-card-02.png" id="giftCardSel2" alt="happy birthday">
                    </div>
                    <div class="text-center"><input type="radio" class="giftCardJump" name="typeOfGiftcard"
                                                    value="Happy Birthday"></div>
                </div>
                <div>
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/type-of-gift-card-03.png" id="giftCardSel3" alt="baby shower">
                    </div>
                    <div class="text-center"><input type="radio" class="giftCardJump" name="typeOfGiftcard"
                                                    value="Baby Shower"></div>
                </div>
                <div>
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/type-of-gift-card-04.png" id="giftCardSel4" alt="home sweet home">
                    </div>
                    <div class="text-center"><input type="radio" class="giftCardJump" name="typeOfGiftcard"
                                                    value="Home Sweet Home"></div>
                </div>
                <div>
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/type-of-gift-card-05.png" id="giftCardSel5" alt="congrats">
                    </div>
                    <div class="text-center"><input type="radio" class="giftCardJump" name="typeOfGiftcard"
                                                    value="Congrats"></div>
                </div>

            </div> <!-- /.row -->


            <div class="row no-border">


                    <div class="service-item">
                        <div class="service-description ">
                            <div class="type-of-gift-card-hd">
                                <h2>DELIVERY METHOD</h2>
                            </div>
                        </div> <!-- /.service-description -->
                    </div> <!-- /.service-item -->
            </div> <!-- /.row -->


            <div class="row sp-but-height">

                <div class="delivery-item">
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/delivery_gift_box.jpg" id="giftBoxSelId" alt="gift box">
                    </div>
                    <div class="text-center"><input type="radio" id="giftBoxDeliveryId" name="typeOfDelivery"
                                                    value="Gift Box"></div>
                    <div class="text-center del-text-display">GIFT BOX</div>
                </div>

                <div class="delivery-item">
                    <div  class="typeOfGC">
                        <img src="resources/images/gift-imgs/delivery_email.jpg" id="emailSelId" alt="email">
                    </div>
                    <div class="text-center"><input type="radio" id="emailDeliveryId" name="typeOfDelivery"
                                                    value="Email"></div>
                    <div class="text-center del-text-display">EMAIL</div>
                </div>


            </div> <!-- /.row -->


            <div id="giftBoxDeliveryRowId" class="row" style="display: none;">


                    <div class="service-item">
                        <div class="service-description ">
                            <div class="type-of-gift-card-hd">
                                <h2>RECIPIENT INFO</h2>
                            </div>
                        </div> <!-- /.service-description -->

                        <div  class="service-description ">
                            <table>
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


                    <div class="service-item">
                        <div class="service-description ">
                            <div class="type-of-gift-card-hd">
                                <h2>RECIPIENT INFO</h2>
                            </div>
                        </div> <!-- /.service-description -->

                        <div  class="service-description ">
                            <table>
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
            <div class="row">


                    <div class="service-item">
                        <div class="service-description ">
                            <div class="type-of-your-info-hd">
                                <h2>YOUR INFO</h2>
                            </div>
                        </div> <!-- /.service-description -->

                        <div  class="service-description ">
                            <table>
                                <tr>
                                    <td><input type="text" class="inputbox-display" id="yourNameId" name="yourName"
                                               placeholder="NAME"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" class="inputbox-display" id="yourEmailId" name="yourEmail"
                                               placeholder="EMAIL"></td>
                                </tr>
                            </table>

                            <table>
                                <tr>
                                    <td class="gift-msg-dis cret-registry">GIFT MESSAGE:</td>
                                </tr>
                                <tr>
                                    <td><textarea rows="5" cols="23" class="text-areabox-display" id="giftMessageId"
                                                  name="giftMessage"></textarea>
                                </tr>
                            </table>
                        </div>


                    </div> <!-- /.service-item -->

            </div> <!-- /.row -->


            <!-- delivery gift card date display -->
            <div class="row no-border">


                    <div class="service-item">
                        <div class="service-description ">
                            <div class="type-of-gift-card-hd">
                                <h2>DELIVERY DATE</h2>
                            </div>
                        </div> <!-- /.service-description -->
                    </div> <!-- /.service-item -->

            </div> <!-- /.row -->


            <div class="row column">

                    <div class="service-item">
                        <div class="service-description ">
                            <div  class="del_date_for_gc_dsp"><p>DELIVERY DATE IS THE DATE THE GIFT CARD
                                WILL BE SENT OUT BY US EITHER VIA POST OR EMAIL DELIVERY VIA POST WILL GENERALLY
                                TAKE 3-5 BUSINESS DAYS</p></div>
                        </div> <!-- /.service-description -->
                    </div> <!-- /.service-item -->
                <div class="service-item">
                    <div  class="service-description">
                        <table>
                            <tr>
                                <td><input type="text" id="deliveryDateId" class="datepicker inputbox-display"
                                           name="deliveryDate" readonly placeholder="DELIVERY DATE"></td>
                            </tr>
                        </table>
                    </div>
                </div> <!-- /.service-item -->
            </div> <!-- /.row -->


            <div class="row subbutt" id="barDivDisplayId">
                    <div class="text-center">
                        <h4>
                            <button class="gift-submit-Btn" id="giftCheckOutId">CHECKOUT</button>
                        </h4>
                    </div>
            </div> <!-- /.row -->
            <input type="hidden" id="typeOfPackageId" name="typeOfPackage">
            <input type="hidden" id="packagePriceId" name="packagePrice">
        </form>
    </div> <!-- /.container -->
</div> <!-- /.site-footer -->
<div style="disply: none;">
    <p></p>
</div>
</body>
</html>
