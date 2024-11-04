<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
      
    <!-- Favicons -->
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon">    

	<script type="text/javascript">
 	$(document).ready(function(){
 		var typeOfItem = '<c:out value="${typeOfItem}"/>';
        var otherItem = '<c:out value="${otherItem}"/>';
        var alreadyHaveItem = '<c:out value="${alreadyHaveItem}"/>';        
 			
 			$("#FURNITURE").css("color","red");
 			$("#FURNITURE").css('border-bottom','1px solid red');
 			

 	        $("[name='typeOfItem']").each(function (){    	
 	        if(typeOfItem.indexOf($(this).val()) !== -1){ 	        	
 	        $(this).attr("checked",true);   
 	        }   
 	        });        
 	        
 	        $("[name=otherItems]").val(otherItem);
 	        $("[name=alreadyHaveItems]").val(alreadyHaveItem);

            var conceptApproved1 = '<c:out value="${conceptApproved}"/>';
            var renderingRequest1 = '<c:out value="${renderingRequest}"/>';
            var renderingApproved1 = '<c:out value="${renderingApproved}"/>';
            var secRendPurchage1 = '<c:out value="${secRendPurchage}"/>';
            var secRendApproved1 = '<c:out value="${secRendApproved}"/>';
            var revisionRequest1 = '<c:out value="${revisionRequest}"/>';
            var revisedRendApproved1 = '<c:out value="${revisedRendApproved}"/>';
            
            if(conceptApproved1 !== "") {
            	$("#conceptApprovedId").show();
            } else {
            	$("#conceptApprovedId").hide();
            }

            if(renderingRequest1 !== "") {
            	$("#renderingRequestId").show();
            } else {
            	$("#renderingRequestId").hide();
            }

            if(renderingApproved1 !== "") {
            	$("#renderingApprovedId").show();
            } else {
            	$("#renderingApprovedId").hide();
            }

            if(secRendPurchage1 !== "") {
            	$("#secRendPurchageId").show();
            } else {
            	$("#secRendPurchageId").hide();
            }

            if(secRendApproved1 !== "") {
            	$("#secRendApprovedId").show();
            } else {
            	$("#secRendApprovedId").hide();
            }

            if(revisionRequest1 !== "") {
            	$("#revisionRequestId").show();
            } else {
            	$("#revisionRequestId").hide();
            }

            if(revisedRendApproved1 !== "") {
            	$("#revisedRendApprovedId").show();
            } else {
            	$("#revisedRendApprovedId").hide();
            }

            var clCheckList = '<c:out value="${clientCheckList}"/>'; 		
     		$("[name='clientCheckList']").each(function (){    	
                if(clCheckList.indexOf($(this).val()) !== -1){    
                	$(this).attr("checked",true);   
                }   
            }); 
 	    });
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <div class="row">
        	
        <div class="col-md-12 col-sm-12">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="left">
        			<p class="package_info_disp_for_Dsn"><c:out value='${clientFullName}'/> - <c:out value='${typeOfSpaceVal}'/> - <font>FULL ROOM PACKAGE</font> - <c:out value='${createdDate}'/></p>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-12 -->
        </div> <!-- /.row -->
        
        
                
        <div class="row top_adjustment_50">
        	
        <div class="col-md-2 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="right">
        			<table class="room_sty_dis">
        			<tr class="quest_frame_disp"><td><a href="fullStyleManagement" class="ques_links_disp" id="STYLE">STYLE</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="fullBudgetManagement" class="ques_links_disp" id="BUDGET">BUDGET</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="fullDimensionsManagement" class="ques_links_disp" id="DIMENSIONS">DIMENSIONS</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="fullColorManagement" class="ques_links_disp" id="COLOR">COLOR</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="fullFurnitureManagement" class="ques_links_disp" id="FURNITURE">FURNITURE</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="fullArtManagement" class="ques_links_disp" id="ART">ART</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="fullMyRoomManagement" class="ques_links_disp" id="MYROOM">MY ROOM</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="fullInspirationManagement" class="ques_links_disp" id="INSPIRATION">INSPIRATION</a></td></tr>
        			</table>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-2 -->
        	
        <div class="col-md-5 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center" class="quest_bord_frame">
        			<div class="che_cl_frm_dis">
        			<% if (null != session.getAttribute("fur_item_Names_List")) {
					   @SuppressWarnings("rawtypes")
				       ArrayList itemNamesList = (ArrayList) session.getAttribute("fur_item_Names_List");					   
				       if (null != itemNamesList && itemNamesList.size() > 0) {			
			        %>
			        
			        <div align="left" class="check_info_adj">
			        <% for(int i=0; i<itemNamesList.size(); i++){ %>			        
        			<font class="item_row_dsply"><input type="checkbox" name="typeOfItem" disabled value="<%=itemNamesList.get(i)%>"><font class="cl_chck_name_adj"><%=itemNamesList.get(i)%></font></font>        			
        			<% } %>
        			</div>
        			
        			<% } } %>
        			</div>
        			<div class="txt_ar_frm_adj">
        			<div class="margin_top_adj_dis"><div class="top_on_input_box_text_dis">OTHER THINGS I NEED: </div></div>        			
        			<textarea name="otherItems" id="otherItemsId" placeholder="OTHER THINGS I NEED ..." readonly class="desn_item_txt_input_boxs_dis" style="margin-top: 10px;"></textarea>
        			<div class="margin_top_adj_dis"><div class="top_on_input_box_text_dis">I ALREADY HAVE: </div></div>
        			<textarea name="alreadyHaveItems" id="alreadyHaveItemsId" placeholder="I ALREADY HAVE ..." readonly class="desn_item_txt_input_boxs_dis" style="margin-top: 10px;"></textarea>
        			</div>
        			
        			</div>
        			
        			<form action="desnUploadFullRoomConceptsAndRenderings" name="myDesign" method="get">
					<div class="text-center top_adjustment_40">
					<h4><button class="concepts_rend_submit_Btn" id="conceptsButtonId">UPLOAD CONCEPTS &amp; RENDERINGS</button></h4>
					</div>
					</form>
					
        			<form action="adminMessageClient" name="myDesign" method="get">
					<div class="text-center top_adjustment_40">
					<h4><button class="message_client_submit_Btn" id="conceptsButtonId">MESSAGE CLIENT</button></h4>
					</div>
					</form>
					
        			<form action="fullRoomDesignerNotesDisplay" name="myDesign" method="get">
					<div class="text-center top_adjustment_40">
					<h4><button class="message_client_submit_Btn" id="conceptsButtonId">NOTES</button></h4>
					</div>
					</form> 
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-5 -->
          
        <div class="col-md-1 col-sm-1">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div class="acc_pack_dsn_imgs_dsp">
        				<div id="conceptApprovedId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/full_room/full_ca_img.png" title="CONCEPTS APPROVED BY ADMIN - GREAT JOB ON THE CONCEPTS! YOUR CLIENT CAN NOW SEE THEIR CONCEPTS - SEND A BRIEF MESSAGE TO YOUR CLIENT ABOUT THEM."></div>
	        			
	        			<div id="renderingRequestId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/full_room/full_rr_img.png" title="RENDERING REQUESTED BY CLIENT - USE FEEDBACK FROM YOUR CLIENT REGARDING THE CONCEPTS TO WORK ON A RENDERING FOR THE CONCEPT THEY LIKE BEST."></div>
	        			
	        			<div id="renderingApprovedId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/full_room/full_ra_img.png" title="RENDERING APPROVED BY ADMIN - YOUR RENDERING HAS BEEN APPROVED AND CAN NOW BE SEEN BY YOUR CLIENT. SEND THEM A BRIEF MESSAGE ABOUT THEIR RENDERING."></div>
	        			
	        			<div id="secRendPurchageId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/full_room/full_2nd_img.png" title="2 ND RENDERING PURCHASED BY CLIENT - BOTH OF YOUR CONCEPTS WERE SO AMAZING THAT YOUR CLIENT HAD A HARD TIME DECIDING WHICH ONE THEY LIKED BEST AND SO THEY PURCHASED A SECOND RENDERING! WE ALLOT THREE BUSINESS DAYS FROM THE TIME OF PURCHASE TO DELIVERY OF THE RENDERING."></div>
	        			
	        			<div id="secRendApprovedId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/full_room/full_ra_img.png" title="RENDERING APPROVED BY ADMIN - YOUR RENDERING HAS BEEN APPROVED AND CAN NOW BE SEEN BY YOUR CLIENT. SEND THEM A BRIEF MESSAGE ABOUT THEIR RENDERING."></div>
	        			
	        			<div id="revisionRequestId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/full_room/full_rr_img.png" title="REVISION REQUESTED BY CLIENT - USE FEEDBACK FROM YOUR CLIENT TO REVISE THEIR RENDERING."></div>
	        			
	        			<div id="revisedRendApprovedId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/full_room/full_ra_img.png" title="RENDERING APPROVED BY ADMIN - YOUR REVISED RENDERING HAS BEEN APPROVED AND CAN NOW BE SEEN BY YOUR CLIENT. SEND THEM A BRIEF MESSAGE ABOUT CHANGES MADE TO THE RENDERING AND LET THEM KNOW THAT THEIR PERSONALIZED SHOPPING LIST IS READY!"></div>
	        			
        			</div>
        			        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-1 -->
                	
        <div class="col-md-4 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div id="designer_info_disp1" align="center">
        			<div class="background_color_display">
        			
        			<div><p class="pac_info_hedding_disp_for_Dsn">FULL ROOM DESIGN PACKAGE</p>
        			<p class="pac_info_hedding_disp_for_Dsn">CHECKLIST</p>
        			</div>
        			<form action="designerUpdateFullPackCheckList" method="post">               
                	
                	<table class="table_disply_in_dsn">                	
                    <tr><td colspan="2"></td></tr>
                    <tr style="height: 40px;"><td><div class="checkboxList"><input type="checkbox" id="option1" name="clientCheckList" value="InitialContact"><label for="option1"></label></div></td>
                    <td class="check_box_text_display" style="top: -5px; position: relative;">INITIAL CONTACT WITH CLIENT</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option2" name="clientCheckList" value="SubmitFurnitureAndConcepts"><label for="option2" class="bluebox"></label></div></td>
                    <td class="check_box_text_display" style="top: -13px; position: relative;">SUBMIT FURNITURE &amp; CONCEPTS TO ADMIN</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option3" name="clientCheckList" value="FollowUpWithClientGF"><label for="option3"></label></div></td>
                    <td class="check_box_text_display" style="top: -13px; position: relative;">FOLLOW UP WITH CLIENT &amp; GET FEEDBACK</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option4" name="clientCheckList" value="SubmitFurnitureAndRoomRen"><label for="option4" class="bluebox"></label></div></td>
                    <td class="check_box_text_display" style="top: -13px; position: relative;">SUBMIT FURNITURE &amp; ROOM RENDERING TO ADMIN</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option5" name="clientCheckList" value="FollowUpWithClientFeedback"><label for="option5"></label></div></td>
                    <td class="check_box_text_display" style="top: -13px; position: relative;">FOLLOW UP WITH CLIENT &amp; GET FEEDBACK</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option6" name="clientCheckList" value="SubmitSecFurRendToAdmin"><label for="option6"></label></div></td>
                    <td class="check_box_text_display" style="top: -15px; position: relative;">SUBMIT 2ND FURNITURE &amp; ROOM RENDERING TO ADMIN <font color="red">(ONLY IF CLIENT HAS PURCHASED THIS)</font></td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option7" name="clientCheckList" value="FollowUpWithClientAndFed"><label for="option7"></label></div></td>
                    <td class="check_box_text_display" style="top: -13px; position: relative;">FOLLOW UP WITH CLIENT &amp; GET FEEDBACK</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option8" name="clientCheckList" value="FinalRevAndSubFurAndRed"><label for="option8"></label></div></td>
                    <td class="check_box_text_display" style="top: -15px; position: relative;">FINAL REVISION &amp; SUBMISSION OF FURNITURE &amp; RENDERING TO ADMIN</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option9" name="clientCheckList" value="FinalFollowUpWithClient"><label for="option9"></label></div></td>
                    <td class="check_box_text_display" style="top: -5px; position: relative;">FINAL FOLLOW UP WITH CLIENT</td></tr>
                                      
                    </table>
                	<div class="text-center top_adjustment_30">
					<h4><button class="continue_submit_Btn" id="spaceButtonId">SAVE</button></h4>
					</div>
                
                	</form>
        			</div>
        			        			
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-4 -->
                	
        </div> <!-- /.row -->
                  
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
         	
		</body>
</html>