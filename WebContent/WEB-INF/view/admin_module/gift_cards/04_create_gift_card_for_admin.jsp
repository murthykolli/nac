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

    function numeralsOnly(e) {
    var key; var keychar;
    if (window.event) key = window.event.keyCode;
    else if (e) key = e.which;
    else return true;
    keychar = String.fromCharCode(key);
    if ((key === null) || (key === 0) || (key === 8) ||  (key === 9) || (key === 13) || (key === 27) ) return true;
    else if ((("0123456789").indexOf(keychar) > -1)) return true;
    else return false;
    }
    
	$(document).ready(function(){
 		
 		$("#createGiftCardId").click(function (){	
 	    var result = true;
 	    
 	    var giftCardAmount = $("#giftCardAmount").val();
	    if(giftCardAmount !== "" && giftCardAmount > 0) {
	    	alert("Please enter valid amount");
	    	result = false;
	    } 	    
 		return result;
 		});
	});
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
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
		
		<div class="admin_gift_card_current_management">
		<a href="createGiftCards"><font class="pendGiftCardCurrentTab">&nbsp;CREATE GIFT CARDS&nbsp;</font></a> </div>
		
		<div class="admin_gift_card_management">
		<a href="manageGiftCards"><font class="pendGiftCardCurrentTab">&nbsp;MANAGE GIFT CARDS&nbsp;</font></a> </div>
		</div>
                        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        </div> <!-- /.row -->
        
        <form action="adminGiftCardDataSaving" name="designerClients" id="designerClientsId" method="post">      
        
        <div class="row">
		<div class="col-md-1 col-sm-1"></div>
		
		<div class="col-md-10 col-sm-10" align="center" style="border: 2px solid #cdcdcd; box-shadow: 5px 5px #999999; padding: 65px; margin-left: 15px; margin-right: 15px;">
                <div class="service-item">
                    <div class="service-description">
                        <div class="gift-marc-crd-hed type-of-gift-card-hd">
                            <h2>ADD GIFT CARD AMOUNT</h2>
                        </div>

                        <div class="text-center sp-but-height">
                            <font class="gift-box-font">$</font><input id="giftCardAmountId" name="giftCardAmount"
                                                                       placeholder="0" class="gift-mer-select-box"
                                                                       onkeypress="return numeralsOnly(event);">
                        </div>
                    </div> <!-- /.service-description -->
                </div> <!-- /.service-item -->
                
                <div class="text-center top_adjustment_50">
				<h4><button class="admin_cl_dir_submit_Btn" id="createGiftCardId">SAVE</button></h4>
				</div>
				
            </div>   
            <div class="col-md-1 col-sm-1"></div>    
            </div> <!-- /.row -->
                
        </form>
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
             	
		</body>
</html>