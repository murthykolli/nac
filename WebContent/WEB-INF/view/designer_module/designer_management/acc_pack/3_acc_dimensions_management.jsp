<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 		var spDimension = '<c:out value="${spaceDimension}"/>'; 		
 			$("[name=dimension]").val(spDimension);
 			$("#DIMENSIONS").css("color","red");
 			$("#DIMENSIONS").css('border-bottom','1px solid red');

            var conceptApproved1 = '<c:out value="${conceptApproved}"/>';
            var renderingRequest1 = '<c:out value="${renderingRequest}"/>';
            var renderingApproved1 = '<c:out value="${renderingApproved}"/>';
            
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
        			<p class="package_info_disp_for_Dsn"><c:out value='${clientFullName}'/> - <c:out value='${typeOfSpaceVal}'/> - <font>ACCESSORIES PACKAGE</font> - <c:out value='${createdDate}'/></p>
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
        			<tr class="quest_frame_disp"><td><a href="accStyleManagement" class="ques_links_disp" id="STYLE">STYLE</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="accBudgetManagement" class="ques_links_disp" id="BUDGET">BUDGET</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="accDimensionsManagement" class="ques_links_disp" id="DIMENSIONS">DIMENSIONS</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="accColorManagement" class="ques_links_disp" id="COLOR">COLOR</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="accFurnitureManagement" class="ques_links_disp" id="FURNITURE">FURNITURE</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="accArtManagement" class="ques_links_disp" id="ART">ART</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="accMyRoomManagement" class="ques_links_disp" id="MYROOM">MY ROOM</a></td></tr>
        			<tr class="quest_frame_disp"><td><a href="accInspirationManagement" class="ques_links_disp" id="INSPIRATION">INSPIRATION</a></td></tr>
        			</table>
        			</div>        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-2 -->
        	
        <div class="col-md-5 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center" class="quest_bord_frame">
        			<div class="mod_cl_frm_dis"><input type="text" name="dimension" readonly class="mod_cl_input"></div>
        			</div>
        			
        			<form action="desnUploadAccPackConceptsAndRenderings" name="myDesign" method="get">
					<div class="text-center top_adjustment_40">
					<h4><button class="concepts_rend_submit_Btn" id="conceptsButtonId">UPLOAD CONCEPTS &amp; RENDERINGS</button></h4>
					</div>
					</form>
					
        			<form action="adminMessageClient" name="myDesign" method="get">
					<div class="text-center top_adjustment_40">
					<h4><button class="message_client_submit_Btn" id="conceptsButtonId">MESSAGE CLIENT</button></h4>
					</div>
					</form>
					
        			<form action="designerNotesDisplay" name="myDesign" method="get">
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
        				<div id="conceptApprovedId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/acc_pack/acc_ca_img.png" title="CONCEPTS APPROVED BY ADMIN - GREAT JOB ON THE CONCEPTS! YOUR CLIENT CAN NOW SEE THEIR CONCEPTS - SEND A BRIEF MESSAGE TO YOUR CLIENT ABOUT THEM."></div>
	        			
	        			<div id="renderingRequestId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/acc_pack/acc_fcr_img.png" title="FINAL CONCEPT REQUESTED BY CLIENT - USE FEEDBACK FROM YOUR CLIENT TO REVISE THE CONCEPT THEY LIKED BEST."></div>
	        			
	        			<div id="renderingApprovedId" class="acc_imgs_poss" style="display: none;"><img src="resources/images/designer/acc_pack/acc_fca_img.png" title="FINAL CONCEPT APPROVED BY ADMIN - YOUR REVISED CONCEPT HAS BEEN APPROVED AND CAN NOW BE SEEN BY YOUR CLIENT. SEND THEM A BRIEF MESSAGE ABOUT CHANGES MADE TO THE CONCEPT AND LET THEM KNOW THAT THEIR PERSONALIZED SHOPPING LIST IS READY!"></div>
	        			
        			</div>
        			        
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-1 -->
                	
        <div class="col-md-4 col-sm-6">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div id="designer_info_disp1" align="center">
        			<div class="background_color_display">
        			
        			<div><p class="pac_info_hedding_disp_for_Dsn">ACCESSORIES PACKAGE</p>
        			<p class="pac_info_hedding_disp_for_Dsn">CHECKLIST</p>
        			</div>
        			<form action="designerUpdateAccPackCheckList" method="post">               
                	
                	<table class="table_disply_in_dsn">                	
                    <tr><td colspan="2"></td></tr>
                    <tr style="height: 40px;"><td><div class="checkboxList"><input type="checkbox" id="option1" name="clientCheckList" value="InitialContact"><label for="option1"></label></div></td>
                    <td class="check_box_text_display" style="top: -5px; position: relative;">INITIAL CONTACT WITH CLIENT</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option2" name="clientCheckList" value="FurnitureAndConcepts"><label for="option2" class="bluebox"></label></div></td>
                    <td class="check_box_text_display" style="top: -13px; position: relative;">SUBMIT FURNITURE &amp; CONCEPTS TO ADMIN</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option3" name="clientCheckList" value="FollowUpWithClient"><label for="option3"></label></div></td>
                    <td class="check_box_text_display" style="top: -13px; position: relative;">FOLLOW UP WITH CLIENT &amp; GET FEEDBACK</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option4" name="clientCheckList" value="FinalRevision"><label for="option4" class="bluebox"></label></div></td>
                    <td class="check_box_text_display" style="top: -13px; position: relative;">FINAL REVISION &amp; SUBMISSION OF FURNITURE &amp; CONCEPTS</td></tr>
                    <tr><td colspan="2"></td></tr>
                    <tr><td><div class="checkboxList"><input type="checkbox" id="option5" name="clientCheckList" value="FinalFollowUpClient"><label for="option5"></label></div></td>
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