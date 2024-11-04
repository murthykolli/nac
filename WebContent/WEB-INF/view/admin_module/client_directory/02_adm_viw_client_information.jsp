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
	<link type="text/css" rel="stylesheet" href="resources/css/0_concepts_rendering_frame_resolution.css" />
	
	<script type="text/javascript">
 	$(document).ready(function(){

		//Modern Style room images
        
        var modernInspStyle = '<c:out value='${modernInsStyle}'/>';
        var modInspStyle = modernInspStyle.split("_,_");
              
        var modernInsTab = $("#modInspRoomImages");
        modernInsTab.append("<tr>");
           	
        for (var i = 0; i < modInspStyle.length; i++){
        if(modInspStyle[i] !== ""){
        	$("#modInspImgsCountId").html(modInspStyle.length);
        var modenInspImage = "data:image/jpg;base64," + modInspStyle[i];        
        modernInsTab.append("<td style='padding-right: 10px;'><img src=" + modenInspImage + " class='adminViewImgDsp inspiredImgs'></td>");
        }
        }
        modernInsTab.append("</tr>");  
        //for room images
        
        var roomImage =  '<c:out value='${uploadPhForDes}'/>';
        var roomImg = roomImage.split("_,_");
        var roomTab = $("#roomImages");
        roomTab.append("<tr>");
        for (var i = 0; i < roomImg.length; i++){
        if(roomImg[i] !== ""){
        var uploadedSpImage = "data:image/jpg;base64," + roomImg[i];
        roomTab.append("<td style='padding-right: 10px;'><img src=" + uploadedSpImage + " class='adminViewImgDsp inspiredImgs'></td>");
        }
        }
        roomTab.append("</tr>");
        
        //for inspiration images
        
        var inspireImage =  '<c:out value='${insUploadPhoto}'/>';
        var inspireImg = inspireImage.split("_,_");
        var inspirationTab = $("#inspirationImages");
        inspirationTab.append("<tr>");
        for (var i = 0; i < inspireImg.length; i++){
        if(inspireImg[i] !== ""){
        var uploadedInsImage = "data:image/jpg;base64," + inspireImg[i];
        inspirationTab.append("<td style='padding-right: 10px;'><img src=" + uploadedInsImage + " class='adminViewImgDsp inspiredImgs'></td>");
        }
        }
        inspirationTab.append("</tr>");
        
        var desProfileImg =  '<c:out value='${desProfileImage}'/>';
        
        if(desProfileImg != "") {
        $("#DesStatusId").show();
        }
        
		var desProfileImg =  '<c:out value='${designerProfileImage}'/>';
        
        if(desProfileImg != "") {
        $("#desProfileStatusId").show();
        }
        
/* Bigger Image Display */

        $(".adminViewImgDsp").click(function(){        		
        var imgVal = $(this).attr("src");
        $.conceptsRenderingPopup(imgVal);
        });
        	
        	var clUpSpImgCount = "<c:out value="${uploadPhForDesCount}"/>";
        	var insUpSpImgCount = "<c:out value="${insUploadPhotoCount}"/>";
            if(clUpSpImgCount > 0){
            	$("#spImgCountDivId").show();            	
            }
            if(insUpSpImgCount > 0){
            	$("#insImgCountDivId").show();            	
            }

	    	var budgetFee = '<c:out value="${budgetVal}"/>';
	        var budgetPrice = budgetFee.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	        $("#budgetPriceId").html(budgetPrice);
	        
	        var likeColor = '<c:out value="${likeOfColor}"/>';
		    var dislikeColor = '<c:out value="${disLikeOfColor}"/>';
		    
		    $("[name=likeColor]").val(likeColor);
		    $("[name=dislikeColor]").val(dislikeColor);
		    
		    var otherItem = '<c:out value="${otherItem}"/>';
	        var alreadyHaveItem = '<c:out value="${alreadyHaveItem}"/>';
	        
	        $("[name=otherItems]").val(otherItem);
	        $("[name=alreadyHaveItems]").val(alreadyHaveItem);
	        
	        var moreAboutSpace1 = '<c:out value="${moreAboutSpace}"/>';
	        var shareInspiration1 = '<c:out value="${shareInspiration}"/>';
	        
	        $("[name=moreAboutSpace]").val(moreAboutSpace1);
	        $("[name=shareInspiration]").val(shareInspiration1);
        });
        </script>
	
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_view_bold_text_dsp"><c:out value='${typeOfSpaceVal}'/></p>                	 
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-10 -->		
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_view_nrm_text_dsp">Style:</p> 
                	 <p class="admn_view_nrm_text_dsp">Packages:</p>
                	 <p class="admn_view_nrm_text_dsp">Budget:</p>
                	 <p class="admn_view_nrm_text_dsp">Room Dimensions:</p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<p class="admn_view_bold_text_dsp"><c:out value='${typeOfStyleVal}'/></p> 
                	<p class="admn_view_bold_text_dsp"><c:out value='${designPackageVal}'/></p>
                	<p class="admn_view_bold_text_dsp">$<font id="budgetPriceId"></font></p>
                	<p class="admn_view_bold_text_dsp"><c:out value='${aboutSpaceDimnVal}'/></p>   
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
        
        <div class="col-md-4 col-sm-4">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="right" class="">
                	<table id="desProfileStatusId" style="display: none;">
			        <tr><td style="width:200px;font: 0.8em/1.25em sans-serif;vertical-align: middle;">${desMessage}</td>
			        <td><img class="desn_pro_img_reso_dsp_class" src="data:image/jpg;base64,<c:out value='${designerProfileImage}'/>" ></td></tr>
			        </table>   
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_10">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_view_nrm_text_dsp">Color:</p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<p class="admn_view_bold_text_dsp"><c:out value='${typeOfColor}'/></p>
                	<p class="admn_view_bold_text_dsp"><textarea name="likeColor" id="likeColorId" placeholder="COLORS I LOVE" class="av_color_inputbox_disp"> </textarea></p>
                	<p class="admn_view_bold_text_dsp"><textarea name="dislikeColor" id="dislikeColorId" placeholder="COLORS I DISLIKE" class="av_color_inputbox_disp"> </textarea></p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_view_nrm_text_dsp">Furniture:</p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<p class="admn_view_bold_text_dsp"><c:out value='${allItemsVal}'/></p>
                	<p class="admn_view_bold_text_dsp"><textarea name="otherItems" id="otherItemsId" placeholder="OTHER THINGS I NEED ..." class="av_color_inputbox_disp"> </textarea></p>
                	<p class="admn_view_bold_text_dsp"><textarea name="alreadyHaveItems" id="alreadyHaveItemsId" placeholder="I ALREADY HAVE ..." class="av_color_inputbox_disp"> </textarea></p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        
        <div class="row top_adjustment_20">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_view_nrm_text_dsp">Art:</p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<p class="admn_view_bold_text_dsp"><c:out value='${artAppValue}'/></p>
                	</div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_view_nrm_text_dsp">Room Images:<font id="spImgCountDivId" color="red" style="display: none;"><c:out value='${uploadPhForDesCount}'/></font></p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div style="overflow-x: auto; overflow-y: hidden;">        
			     	<table id="roomImages"></table>     	 
					</div>
					<p class="admn_view_bold_text_dsp"><textarea name="moreAboutSpace" id="moreAboutSpaceId" placeholder="I NEED MY SPACE TO BE PET FRIENDLY ..." class="av_color_inputbox_disp"> </textarea></p>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        
        
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-3 col-sm-3">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	 <p class="admn_view_nrm_text_dsp">Inspiration Images:<font id="insImgCountDivId" color="red" style="display: none;"><c:out value='${insUploadPhotoCount}'/></font></p>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
		<div class="col-md-7 col-sm-7">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div style="overflow-x: auto; overflow-y: hidden;">        
			     	<table id="inspirationImages"></table>     	 
					</div>
					<p class="admn_view_bold_text_dsp"><textarea name="shareInspiration" id="shareInspirationId" placeholder="PINTEREST BOARD URL" class="av_color_inputbox_disp"> </textarea></p>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-7 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
        
                
        <div class="row top_adjustment_30">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 --> 
        		
		<div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">                        
                	<div align="left">
                	<form action="admClientDirectory" method="get">
					<h4><input class="dash_board_back_submit_Btn" type="image" title="BACK" src="resources/images/backButton.png"></h4>
					</form>
	                </div>
            	</div> <!-- /.service-description -->
        	</div> <!-- /.service-item -->               
        </div> <!-- /.col-md-3 -->
		
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->        
        </div> <!-- /.row -->
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
		
		
		<script type="text/javascript" src="resources/js/json-minified.js" ></script>
    	<script type="text/javascript" src="resources/js/popup/01_all_popup_window_display.js" ></script>
		 
		 
		<div align="center" id="popupTotalWindowBoxId">
        <div align="center" style="display: none; left:0px; top:0px;" id="imageBackgroundDspId" class="window">
        
        <div align="center" class="popup_backgrond_img_display_cl">
        <div align="center"><img class="close popup_close_butt_dsp" src="resources/images/popup_close.png" title="Close"></div>
        <div align="center"><img class="popup_only_image_display_cl" id="bigConceptsRendPopupImgId" src="" ></div>
        </div>
        </div>
        <div align="center" class="popup_big_backgrond_display_cl" id="popUpBigMaskWindowId" style="display: none;"></div>
        </div>
        	
		</body>
</html>