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
 	
	function typtOfSpace(roomId) {
		$(".myRoomImgDisp").css("border-color","gray");
		var roomInfoVal = "roomInfo" + roomId;
		$("#"+roomInfoVal).css("border-color","red");
		document.clientsInfoDisplay.clientsDisplayName.value = roomId;		
	}

 	$(document).ready(function(){
 		$('.showImageClass').show();
    });
	
	</script> 
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">            
            <div class="row">            
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6">	                
	                <div class="myroom-title-section text-center">
                		<h4>MY ROOMS</h4>                
            		</div> <!-- /.title-section -->
            	</div> <!-- /.col-md-4 -->
                
                <div class="col-md-4 col-sm-6">                    
                </div> <!-- /.col-md-4 -->               
            </div> <!-- /.row -->          
			
		<form action="clientInfoDisplaySaving" name="clientsInfoDisplay" id="clientsInfoDisplayId" method="get">	
				
		<% if (null != session.getAttribute("client_Info_Ids_List")) {
		   @SuppressWarnings("rawtypes")
	       ArrayList clientInfoIdsList = (ArrayList) session.getAttribute("client_Info_Ids_List");
	       if (null != clientInfoIdsList && clientInfoIdsList.size() > 0) {
			   
		   if (null != session.getAttribute("type_Of_Space_List")) {
		   @SuppressWarnings("rawtypes")
           ArrayList typeOfSpaceList = (ArrayList) session.getAttribute("type_Of_Space_List");
		   if (null != typeOfSpaceList && typeOfSpaceList.size() > 0) {
        	   
    	   if (null != session.getAttribute("start_Dates_List")) {
    	   @SuppressWarnings("rawtypes")
           ArrayList startDatesList = (ArrayList) session.getAttribute("start_Dates_List");
           if (null != startDatesList && startDatesList.size() > 0) {
        	   
           if (null != session.getAttribute("new_Image_Status_List")) {
           @SuppressWarnings("rawtypes")
           ArrayList newImageStatusList = (ArrayList) session.getAttribute("new_Image_Status_List");
           if (null != newImageStatusList && newImageStatusList.size() > 0) {
        %>
        
        <div class="services">
        <% for(int i=0; i<5 && i<clientInfoIdsList.size(); i++){ %>        
        	<div class="service-item">                        
           		<div class="service-description text-center">
           		    <div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>       		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->
        <% } %>
       
        <% for(int i=5; i<10 && i<clientInfoIdsList.size(); i++){ %>        
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->               
        <% } %>
        
        <% for(int i=10; i<15 && i<clientInfoIdsList.size(); i++){ %>        
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->               
        <% } %>
        
        <% for(int i=15; i<20 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->
        <% } %>
        
        <% for(int i=20; i<25 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item --> 
        <% } %>
        
        <% for(int i=25; i<30 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->
        <% } %>
        
        <% for(int i=30; i<35 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->
        <% } %>
        
        <% for(int i=35; i<40 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->
        <% } %>
        
        <% for(int i=40; i<45 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->
        <% } %>
        
        <% for(int i=45; i<50 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->
        <% } %>
        
        <% for(int i=50; i<55 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item -->
        <% } %>
        
        <% for(int i=55; i<60 && i<clientInfoIdsList.size(); i++){ %>
        	<div class="service-item">                        
           		<div class="service-description text-center">
           			<div class="<%=newImageStatusList.get(i)%>" style="display: none;"><img class="mana_new_img_dsp" src="resources/images/designer/desn_new_img.png"></div>           		
           			<div id="roomInfo<%=clientInfoIdsList.get(i)%>" class="myRoomImgDisp" onclick="typtOfSpace('<%=clientInfoIdsList.get(i)%>');" ><%=typeOfSpaceList.get(i)%></div>
           			<div class="my_room_date_disp"><%=startDatesList.get(i)%></div>           		
           		</div> <!-- /.service-description -->
           	</div> <!-- /.service-item --> 
        <% } %>
        </div>        
        
        <% } } } } } } } } %>
        
             	
		<div class="services" style="margin-top: 40px;">
		<div class="text-center" style="margin-bottom: 30px; padding: 10px;">
		<h4><button class="management_submit_Btn" id="viewClientId" onclick="return modifyClient();">VIEW ROOM</button></h4>
		</div>
		<div class="text-center" style="margin-bottom: 30px; padding: 10px;">
		<h4><button class="management_submit_Btn" id="viewMessageId" onclick="return addClient();">START NEW ROOM</button></h4>
		</div>
				
		<input type="hidden" name="clientDisplayRefType"/>
		<input type="hidden" id="typeOfSpaceId" name="clientsDisplayName">				
        
		 </div>
        </form>
                   
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        
        <script type="text/javascript">        

        function modifyClient(){
	        document.clientsInfoDisplay.clientDisplayRefType.value = "Modify Client";
	        var clientsDisplayNames = document.clientsInfoDisplay.clientsDisplayName.value;
	        
	        if(clientsDisplayNames === ""){
	        	window.alert("Please select a room to view its details.");
	        return false;
	        } 
        }

        /* function deleteClient(){        	
        	var clientsDeleteNames = document.clientsInfoDisplay.clientsDisplayName.value;        	
                
        if(clientsDeleteNames != ""){         
        var where_to= confirm("Do you want to delete this client?");
	        if (where_to){
	        	document.clientsInfoDisplay.clientDisplayRefType.value = "Delete Client";
	        	return true;
	        } else {
	        	return false;
	        } 
        }
    
        else{
	        window.alert("Please select a client");
	        return false;
        }
        } */

        function addClient(){
	        document.clientsInfoDisplay.clientDisplayRefType.value = "Add Client";	        
        }
        
        </script>
                	
		</body>
</html>