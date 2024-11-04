<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon"/>

    <!-- CSS files -->
    <link rel="stylesheet" type="text/css" href="resources/css/date_picker.css"/>

    <!-- JS files -->
    <script type="text/javascript" src="resources/js/date_picker_min.js"></script>
    <script type="text/javascript" src="resources/js/designer_registry_validation.js"></script>
    <script type="text/javascript" src="resources/js/frequently_asked_questions_validation.js"></script>

    <style type="text/css">
        .fix {
            position: fixed;
            bottom: 8%;
            right: 5%;
            z-index: 1000;
        }
    </style>
    <script type="text/javascript">
    $(window).ready(function(){
   		$("#scrolltop").click(function() {
        	$("html").animate({ scrollTop: 0 }, "fast");
        	$( "#leftSideTopAdjustmentId" ).animate({ marginTop: "0"}, 500 );
      	});   	
	});
    </script>
</head>
<body>

<div id="mainframe" class="section-content faq">
    <div class="container">
        <div class="service-item">
            <div class="service-description faq-welcome">
                <img src="resources/images/home_images/hello.png">
                <h1 class="faq-header">got <span class="bigger">questions?</span> we've got <span class="bigger">answers!</span>
                </h1>
            </div> <!-- /.service-description -->
        </div> <!-- /.service-item -->
        <div class="questions" id="links" style="min-height: 50px;">
            <div class="service-item question-links" >
                <div class="service-description" id="leftSideTopAdjustmentId">
                    <div class="fre_ask_qes_head"><h3>frequently asked questions</h3></div>

                    <!-- ABOUT US DIV -->
                    <div class="fre_ask_qes_sub_head"><h4>ABOUT US</h4></div>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink1Id">WHAT IS NOOK+COVE</a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink2Id">HOW ARE WE DIFFERENT FROM OTHERS
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink3Id">WHY US</a>

                    <!-- THE DESIGN PROCESS DIV -->
                    <div class="fre_ask_qes_sub_head"><h4>THE DESIGN PROCESS</h4></div>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink4Id">WHICH DESIGN PACKAGE IS THE BEST FIT
                        FOR
                        ME
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink5Id">HOW LONG DOES THE DESIGN PROCESS TAKE
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink6Id">CAN MY DESIGNER WORK WITH ANY BUDGET
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink7Id">DO I NEED TO SHARE ANY PICTURES</a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink8Id">CAN MY DESIGNER INCORPORATE EXISTING
                        ITEMS
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink9Id">WHERE DO WE SOURCE FROM</a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink10Id">HOW LONG WILL MY DESIGNS BE
                        AVAILABLE
                    </a>

                    <!-- DESIGNERS DIV -->
                    <div class="fre_ask_qes_sub_head"><h4>DESIGNERS</h4></div>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink11Id">WHO ARE NOOK+COVE'S E-DESIGNERS
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink12Id">CAN I REQUEST A PARTICULAR DESIGNER
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink13Id">HOW DO I COMMUNICATE WITH MY
                        DESIGNER
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink14Id">HOW MUCH TIME DO I GET WITH MY
                        DESIGNER
                    </a>

                    <!-- ORDERING WITH US DIV -->
                    <div class="fre_ask_qes_sub_head"><h4>ORDERING WITH US</h4></div>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink15Id">ORDERING</a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink16Id">SHIPPING &amp; DELIVERY</a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink17Id">RETURNS &amp; CANCELLATIONS</a>

                    <!-- GIFT CARDS DIV -->
                    <div class="fre_ask_qes_sub_head"><h4>GIFT CARDS</h4></div>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink18Id">WHERE CAN I PURCHASE GIFT CARDS
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink19Id">CAN THE GIFT CARD BE FOR ANY
                        DENOMINATION
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink20Id">HOW WILL THE GIFT CARD BE DELIVERED
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink21Id">WHEN WILL THE GIFT CARD BE DELIVERED
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink22Id">HOW DO I REDEEM MY GIFT CARD</a>

                    <!-- CUSTOMER SERVICE DIV -->
                    <div class="fre_ask_qes_sub_head"><h4>CUSTOMER SERVICE</h4></div>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink23Id">WHAT IS THE BEST WAY TO CONTACT US
                    </a>
                    <a class="fre_ask_qes_link_actions" id="faqsLeftSideLink24Id">DO WE OFFER REFUNDS ON DESIGN
                        PACKAGES
                    </a>


                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <div class="service-item question-answers">
                <div class="service-description">

                    <!-- ABOUT US DIV -->
                    <div class="fre_ask_qes_and_ans_head" id="faqsRightSideAnimationId"><h2>about us...</h2></div>
                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead1Id">WHAT IS NOOK+COVE?</h3>
                    </div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Nook + Cove is an interior design service that allows
                        you
                        to work with a professional to help create the space you've always wanted. Our unique service is
                        100% online and makes decorating your home affordable, convenient, personal and fun!</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead2Id">HOW ARE WE DIFFERENT FROM
                        OTHERS?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>One of the biggest drawbacks of traditional interior
                        design
                        services is that it can get to be very expensive. When designers charge by the hour, the budget
                        that
                        you are able to dedicate to the decor itself can take a hit. With our one time low flat fee per
                        room, your budget always stays intact!</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>Since our design services are 100%
                        online, you have the convenience of reaching out to your designer at any time you like. Our
                        step-by-step notifications allow you to set the pace for your design deliverables so there's no
                        need
                        to worry about where you are in the process or what's next.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead3Id">WHY US?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Because our design process backed by our talented
                        designers
                        ensures your satisfaction and happiness! We have meticulously crafted our platform to provide
                        you
                        with a comprehensive unique design experience. The process is comprehensive yet not complex,
                        making
                        it a fun experience for everyone!</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>Our designers are professionals who
                        take
                        the time to listen to you and understand your needs. They work hard to execute beautiful and
                        thoughtful concepts that you are sure to love!</p></div>

                    <!-- THE DESIGN PROCESS DIV -->
                    <div class="fre_ask_qes_and_ans_head top_adjustment_25"><h2>the design process...</h2></div>
                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead4Id">WHICH DESIGN PACKAGE IS THE
                        BEST
                        FIT FOR ME?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Our Full Room Design Package is perfect for someone who
                        is
                        starting afresh and looking to create a brand new space. A Full Room Design Package generally
                        includes recommendations from large and small furniture pieces to personally curated accessories
                        to
                        create a cohesive finished look.</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>The Accessories Package is a great
                        fit if
                        you are looking to spruce up your existing space. Your designer will work with your existing
                        pieces
                        to find the best accessories that fit your space and style. Anything from new throw pillows to
                        wall
                        art are a great way to redefine your decor style!</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead5Id">HOW LONG DOES THE DESIGN
                        PROCESS
                        TAKE?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>With either of our design packages, the entire design
                        process can be completed in as little as 7 business days! From the time you submit your
                        questionnaire to the time you get your first design concepts is 4 business days. Once you have
                        submitted your feedback to your designer, your final concepts or renderings will be ready for
                        you in
                        3 business days. You can always go at a slower pace and take more time to provide feedback and
                        make
                        decisions.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead6Id">CAN MY DESIGNER WORK WITH
                        ANY
                        BUDGET?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Our designers have experience and enjoy working with
                        budgets of all ranges! Based on your needs and style, your designer will be able to gauge the
                        necessary budget to achieve the desired look. If you are unclear as to how much your budget
                        should
                        be, your designer will work with you and guide you towards options that fall within your comfort
                        zone.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead7Id">DO I NEED TO SHARE ANY
                        PICTURES?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>You are not required to share any pictures but we
                        highly
                        recommend you doing so. Pictures of the room you are seeking to transform from different
                        directions
                        help the designer understand the space they are working with. Also pictures of spaces that you
                        love
                        or spaces that inspire you give your designer a sense of your style.</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>You have the opportunity to upload
                        pictures during the questionnaire process and you can always upload new pictures at any time.
                        When
                        it comes to conveying design style, pictures truly are worth a thousand words!</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead8Id">CAN MY DESIGNER INCORPORATE
                        EXISTING ITEMS?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Yes! Your designer will work with any existing items
                        that
                        you would like to keep and include in your final room design. Just provide clear pictures of
                        these
                        items so that they can be seamlessly incorporated into your final designs.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead9Id">WHERE DO WE SOURCE
                        FROM?</h3>
                    </div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>We source items from a variety of popular retailers as
                        well
                        as from trade-only sources. We also support small vendors who make homemade quality d�cor items
                        such
                        as a plush knit throw in your favorite shade of blue, made just for you! If there is a
                        particular
                        store that you love, don't hesitate to let your designer know!</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead10Id">HOW LONG WILL MY DESIGNS BE
                        AVAILABLE?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>You will always have access to your designs via your
                        account at NOOK+COVE. However, if you are interested in purchasing items from your personalized
                        shopping menu, we recommend you don't wait too long as items might be discontinued or vary in
                        price
                        over time.</p></div>

                    <!-- DESIGNERS DIV -->
                    <div class="fre_ask_qes_and_ans_head top_adjustment_25"><h2>designers...</h2></div>
                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead11Id">WHO ARE NOOK+COVE'S
                        E-DESIGNERS?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>All of our E-Designers are professionals who have a
                        passion
                        for interior design and are experienced and comfortable in designing in many styles. Designers'
                        professional certifications, experience, and portfolio are all taken into consideration during
                        our
                        screening process. We hold all of our designers to our standard of excellence ensuring the
                        highest
                        quality in your design deliverables.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead12Id">CAN I REQUEST A PARTICULAR
                        DESIGNER?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Absolutely! If you've worked with a specific designer
                        in
                        the past that you really liked or if certain designer has been recommended to you, you have the
                        opportunity to request a specific designer during the questionnaire process.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead13Id">HOW DO I COMMUNICATE WITH
                        MY
                        DESIGNER?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Once you log into your account at NOOK+COVE, you will
                        be
                        able to communicate with your designer via our messaging feature. Feel free to message your
                        designer
                        as much as you would like throughout the design process.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead14Id">HOW MUCH TIME DO I GET WITH
                        MY
                        DESIGNER?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>From the time you purchase a design package, you will
                        have
                        access to your designer for 12 weeks. This gives you plenty of time to go through the design
                        process
                        and finalize all finishing touches.</p></div>

                    <!-- ORDERING WITH US DIV -->
                    <div class="fre_ask_qes_and_ans_head top_adjustment_25"><h2>ordering with us...</h2></div>
                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead15Id">ORDERING</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>There is no obligation for you to buy but when you
                        order
                        your merchandise through us you get to experience our hassle-free complimentary shopping
                        service!
                        One effortless transaction with us and we take care of the ordering process with various vendors
                        for
                        you.</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>Before we place orders on your
                        behalf, we
                        cross check every order for any price changes and to make sure all items are in stock. If the
                        status
                        of any item has changed we notify you before moving forward.</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>Did we mention that when you order
                        through us you also get access to exclusive products from vendors that are available to the
                        trade
                        only!</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead16Id">SHIPPING &amp; DELIVERY</h3>
                    </div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Shipping costs and delivery times vary for orders that
                        are
                        placed with different vendors. Shipping costs and taxes are not included at the time you place
                        your
                        order with us. We email you an invoice generally within one business day with all shipping
                        costs,
                        taxes and delivery estimates for every item in your order. You can let us know if you would like
                        us
                        to place your order before or after you review your invoice.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead17Id">RETURNS &amp; CANCELATIONS</h3>
                    </div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Returns and cancelations are allowed when ordering
                        through
                        NOOK+COVE. Depending on the vendor from which your item is being ordered from, certain
                        restrictions
                        and limitations may apply.</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>Some general rules:</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_5"><p><font
                            class="fre_ask_qes_bullets">.</font>Cancelations
                        of any orders must be placed with us within 24 hours of placing the order.</p></div>
                    <div class="fre_ask_qes_and_ans_bull_text_dsp"><p><font class="fre_ask_qes_bullets">.</font>Most
                        items
                        are returnable if they are in new condition.</p></div>
                    <div class="fre_ask_qes_and_ans_bull_text_dsp"><p><font class="fre_ask_qes_bullets">.</font>Custom
                        items
                        are generally non-returnable and non-refundable.</p></div>
                    <div class="fre_ask_qes_and_ans_bull_text_dsp"><p><font class="fre_ask_qes_bullets">.</font>If an
                        item
                        is damaged or defective, the vendor will cover return shipping.</p></div>
                    <div class="fre_ask_qes_and_ans_bull_text_dsp"><p><font class="fre_ask_qes_bullets">.</font>If you
                        have
                        changed your mind about an item, you are responsible for return shipping.</p></div>
                    <div class="fre_ask_qes_and_ans_bull_text_dsp"><p><font class="fre_ask_qes_bullets">.</font>Restocking
                        fees may apply in some cases.</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>Please contact us via email or phone
                        in
                        order to initiate a return or cancelation of an order.</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>If you are interested in learning
                        specifics about the return policy for a product, or have any questions regarding returns and
                        cancelations please reach out to us via email or phone and we will be glad to assist you.</p>
                    </div>


                    <!-- GIFT CARDS DIV -->
                    <div class="fre_ask_qes_and_ans_head top_adjustment_25"><h2>gift cards...</h2></div>
                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead18Id">WHERE CAN I PURCHASE GIFT
                        CARDS?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>You can purchase NOOK+COVE gift cards for friends and
                        family right <a href="gift" class="fre_ask_qes_gft_link_actions">here</a>! Our gift cards make
                        for a
                        unique gift for any occasion. The NOOK+COVE design experience is one they will never forget!</p>
                    </div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead19Id">CAN THE GIFT CARD BE FOR
                        ANY
                        DENOMINATION?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>Yes, you can purchase our gift cards for any
                        denomination.
                        However, via our website we only offer gift cards for our two design packages, the Full Room
                        Design
                        Package for $185 and the Accessories Package for $75. You can add merchandise credit to either
                        of
                        these packages as well. If you would like to purchase a gift card for any other denomination,
                        please
                        give us a call and we can assist you over the phone and have your gift card on its' way!</p>
                    </div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead20Id">HOW WILL THE GIFT CARD BE
                        DELIVERED?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>You have the option to have your gift card delivered to
                        your recipient via email or post. Both options include a personal message from you along with
                        instructions to redeem the gift card.</p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>With the post option, your recipient
                        will
                        be mailed a beautifully packaged gift card to their front door.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead21Id">WHEN WILL THE GIFT CARD BE
                        DELIVERED?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>You have the option to choose a future date for
                        delivery of
                        your gift card. While an e-gift card can be sent to the recipient's email by the end of the day,
                        the
                        via post option generally takes 3-5 business days for delivery.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead22Id">HOW DO I REDEEM MY GIFT
                        CARD
                        ?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>You will be provided with a unique code on your gift
                        card
                        that can be entered on any payment page for purchase of a design package or merchandise.</p>
                    </div>


                    <!-- CUSTOMER SERVICE DIV -->
                    <div class="fre_ask_qes_and_ans_head top_adjustment_25"><h2>customer service...</h2></div>
                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead23Id">WHAT IS THE BEST WAY TO
                        REACH
                        US?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>You can always reach us via email at <font
                            color="#1467bc"
                            style="text-decoration: underline;">hello@nookandcove.com</font>.
                    </p></div>
                    <div class="fre_ask_qes_and_ans_text_dsp top_adjustment_20"><p>We are also available during our
                        business
                        hours from 8am-4pm Central Time at 888.580.2030.</p></div>

                    <div class="fre_ask_qes_and_ans_sub_head"><h3 id="faqsRightSideHead24Id">DO WE OFFER REFUNDS ON
                        DESIGN
                        PACKAGES?</h3></div>
                    <div class="fre_ask_qes_and_ans_text_dsp"><p>We understand that design is very personal, hence we
                        work
                        extra hard for all of our clients to be happy with their designs. In order to request a refund
                        on
                        one of our design packages, please give us a call so we can get your feedback about your
                        experience
                        at NOOK+COVE.</p></div>

                    <div class="fre_ask_qes_cost_ser_text_dsp top_adjustment_50"><p>FOR ANY OTHER QUESTIONS OR CONCERNS
                        <br>PLEASE
                        REACH OUT TO US <br>@<font color="#1467bc"
                                                   style="text-decoration: underline;">hello@nookandcove.com</font> OR
                        @888.580.2030.</p></div>
                    <div style="height: 50px;"></div>

                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
            <img src="resources/images/home_images/faqs_top_adj_img.png"
                 class="faqs_top_adjm_img go_to_top_class fix"
                 id="scrolltop">
        </div>
    </div> <!-- /.container -->
</div> <!-- /.Main Frame -->

</body>
</html>