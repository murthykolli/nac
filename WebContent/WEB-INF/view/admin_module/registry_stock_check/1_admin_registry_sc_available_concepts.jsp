<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="resources/js/admin_registry/admin_stock_check_price_update.js"></script>
	<link rel="stylesheet" href="resources/css/admin_registry/admin_stock_check_price_update.css">
		
	<script type="text/javascript">
 	$(document).ready(function() { 		
 	 	var typeOfRoomId1 = "<c:out value="${typeOfRoomId}"/>"; 	 	
 	 	$("#"+typeOfRoomId1).css('background-color','red'); 	 	
 	}); 	
    </script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        	<div class="row" style="margin-top: 10px; margin-bottom: 60px;"> 
        		<div class="col-md-6 col-sm-6"> <div class="row"> <div class="col-md-12 col-sm-12" align="left">
					<table> <tr>
						<td><a href="regConceptBoards"><font  class="adm_sub_reg_header_black_text_dsp">All Concepts</font></a></td>
						<!-- <td style="position: relative; left: 18px;"><a href="adminDesignerConcepts"><font class="adm_sub_reg_header_black_text_dsp">Designer Concepts</font></a></td> -->
						<td style="position: relative; left: 18px;"><a href="adminRegistryStockCheck"><font class="adm_sub_reg_header_red_text_dsp">Stock Check</font></a></td>				        
					</tr></table>
				</div> </div> </div>		   	
		   	
		   		<div class="col-md-6 col-sm-6"> <div class="row"> <div class="col-md-12 col-sm-12" align="right">
					<table> <tr>
				    	<td style="position: relative; left: -36px;"><a href="adminRoomFunds"><font class="adm_sub_reg_header_black_text_dsp">Room Funds</font></a></td>
					    <td style="position: relative; left: -18px;"><a href="adminCashFunds"><font class="adm_sub_reg_header_black_text_dsp">Cash Funds</font></a></td>
					    <td><a href="adminGiftsReceived"><font class="adm_sub_reg_header_black_text_dsp">Gifts Received</font></a></td>
					</tr></table>
				</div> </div> </div> </div>
		   	
			   	<div class="row" style="margin-top: -10px; margin-bottom: 70px;"> <div class="col-md-12 col-sm-12">
			    	<table> <tr>
						<td style="position: relative; left: 0px;"><form action="adminRegSCSelectedRoom"> <button class="room_sc_con_submit_btn" id="livingRoomId">Living Room</button> <input type="hidden" name="typeOfRoom" value="Living Room"> <input type="hidden" name="typeOfRoomId" value="livingRoomId"> </form></td>
						<td style="position: relative; left: 20px;"><form action="adminRegSCSelectedRoom"> <button class="room_sc_con_submit_btn" id="diningRoomId">Dining Room</button> <input type="hidden" name="typeOfRoom" value="Dining Room"> <input type="hidden" name="typeOfRoomId" value="diningRoomId"> </form></td>
						<td style="position: relative; left: 40px;"><form action="adminRegSCSelectedRoom"> <button class="room_sc_con_submit_btn" id="bedroomId">Bedroom</button> <input type="hidden" name="typeOfRoom" value="Bedroom"> <input type="hidden" name="typeOfRoomId" value="bedroomId"> </form></td>
						<td style="position: relative; left: 60px;"><form action="adminRegSCSelectedRoom"> <button class="room_sc_con_submit_btn" id="homeOfficeId">Home Office</button> <input type="hidden" name="typeOfRoom" value="Home Office"> <input type="hidden" name="typeOfRoomId" value="homeOfficeId"> </form></td>
						<td style="position: relative; left: 80px;"><form action="adminRegSCSelectedRoom"> <button class="room_sc_con_submit_btn" id="entrywayId">Entryway</button> <input type="hidden" name="typeOfRoom" value="Entryway"> <input type="hidden" name="typeOfRoomId" value="entrywayId"> </form></td>
						<td style="position: relative; left: 100px;"><form action="adminRegSCSelectedRoom"> <button class="room_sc_con_submit_btn" id="nurseryId">Nursery</button> <input type="hidden" name="typeOfRoom" value="Nursery"> <input type="hidden" name="typeOfRoomId" value="nurseryId"> </form></td>
						<td style="position: relative; left: 120px;"><form action="adminRegSCSelectedRoom"> <button class="room_sc_con_submit_btn" id="kidsBedroomId">Kids Bedroom</button> <input type="hidden" name="typeOfRoom" value="Kids Bedroom"> <input type="hidden" name="typeOfRoomId" value="kidsBedroomId"> </form></td>
						<td style="position: relative; left: 140px;"><form action="adminRegSCSelectedRoom"> <button class="room_sc_con_submit_btn" id="outdoorSpaceId">Outdoor Space</button> <input type="hidden" name="typeOfRoom" value="Outdoor Space"> <input type="hidden" name="typeOfRoomId" value="outdoorSpaceId"> </form></td>
					</tr></table>		        
			   	</div> </div>
		 	
		 		<div class="row"> <div class="col-md-12 col-sm-12"> <div class="row adm_reg_stock_check_frame_dsp">
			        <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
			        	<div class="adm_reg_stock_check_hd_txt_dsp">Room</div>			                    
					</div> </div> </div>            
		        
		        	<div class="col-md-9 col-sm-9"> <div class="row"> 
		        		<div class="col-md-6 col-sm-6"> <div class="service-item"> <div class="service-description">
				        	<div class="adm_reg_stock_check_hd_txt_dsp">Product Link</div>
					  	</div> </div> </div>         
			        
				        <div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
				        	<div class="adm_reg_stock_check_hd_txt_dsp" style="margin-left: 45px;">Status</div>
					  	</div> </div> </div>
				      	
				      	<div class="col-md-3 col-sm-3"> <div class="service-item"> <div class="service-description">
				        	<div class="adm_reg_stock_check_hd_txt_dsp" style="margin-left: 5px;">Price</div>
					    </div> </div> </div>				      	
				</div> </div> </div> </div> </div>
        	
        	<% 	int availableCount = 0; int backSoonCount = 0; int replaceCount = 0; int roomsCount = 0; %>
        	
        	<div id="statusUpdateReffId">		        
		        <% 
					if (null != session.getAttribute("admnRegConBdIdsListInSn")) {
				   	@SuppressWarnings("rawtypes")
			       	ArrayList admnRegConBdIdsList = (ArrayList) session.getAttribute("admnRegConBdIdsListInSn");
			       	if (null != admnRegConBdIdsList && admnRegConBdIdsList.size() > 0) {			       		
			       		
				   	if (null != session.getAttribute("admnRegConBdRoomNamesListInSn")) {
				   	@SuppressWarnings("rawtypes")
		           	ArrayList admnRegConBdRoomNamesList = (ArrayList) session.getAttribute("admnRegConBdRoomNamesListInSn");
		           	if (null != admnRegConBdRoomNamesList && admnRegConBdRoomNamesList.size() > 0) {
		           		
					if (null != session.getAttribute("admnRegConBdImagesListInSn")) {
					@SuppressWarnings("rawtypes")
			        ArrayList admnRegConBdImagesList = (ArrayList) session.getAttribute("admnRegConBdImagesListInSn");
			        if (null != admnRegConBdImagesList && admnRegConBdImagesList.size() > 0) {
		
		           	if (null != session.getAttribute("admnRegConBdCombinationListInSn")) {
		    	   	@SuppressWarnings("rawtypes")
		           	ArrayList admnRegConBdCombinationList = (ArrayList) session.getAttribute("admnRegConBdCombinationListInSn");
		           	if (null != admnRegConBdCombinationList && admnRegConBdCombinationList.size() > 0) { 		        	          
		        %>
		        
		        <div class="row top_adjustment_40"> <div class="col-md-12 col-sm-12">
		        <% 	for(int i = 0; i < admnRegConBdIdsList.size(); i++) {
			    	roomsCount = roomsCount + 1;
			      	byte[] cbIndividualProductsImageByte = (byte[]) admnRegConBdImagesList.get(i);
			        String cbIndividualProductsImage = null;
			        if(null != cbIndividualProductsImageByte) {
			        	String cbIndividualProductsImageB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(cbIndividualProductsImageByte);
			        	cbIndividualProductsImage = "data:image/jpg;base64," +cbIndividualProductsImageB64;
			        }
			  	%>
				<div class="row" style="padding-bottom: 50px;">
			    <div class="col-md-3 col-sm-3">
					<div align="center" class="adm_stock_check_cbname_dsp"><%=admnRegConBdRoomNamesList.get(i)%></div>
					<div align="center"><img align="middle" src="<%=cbIndividualProductsImage%>" class="admin_cb_big_image_dsp" ></div>
				</div>
							
				<div class="col-md-9 col-sm-9">
				<% 	String allCombnationValuesList = (String) admnRegConBdCombinationList.get(i);
					String[] allCombnationValuesSt = allCombnationValuesList.split("_&&_");
					for(int j = 0; j < allCombnationValuesSt.length; j++) {
						String[] individualValuesList = allCombnationValuesSt[j].split("___");													
				%>
							
				<div class="row adm_reg_stock_check_products_frame_dsp">
					<div class="col-md-6 col-sm-6"> <div class="url_text_frame_text_mid_adj"> <div class="url_text_frame_mid_adj">
						<div class="adm_reg_stock_check_status_txt_dsp"> &nbsp;</div> <div class="adm_reg_stock_check_link_txt_dsp"><a href="<%=individualValuesList[1]%>" target="_blank"> <%=individualValuesList[1]%> </a></div> <div class="adm_reg_stock_check_status_txt_dsp"> &nbsp;</div>
					</div> </div> </div>
										
					<div class="col-md-3 col-sm-3" align="center"> <div class="url_text_frame_text_mid_adj"> <div class="url_text_frame_mid_adj">
						<% String statusDbName = individualValuesList[2]; if(("Available").equals(statusDbName) && !("Back Soon").equals(statusDbName) && !("Replace").equals(statusDbName)) { availableCount = availableCount + 1; %> <button class="available_submit_btn" onclick="return stockCheckItemStatusUpdate(<%=individualValuesList[0]%>, 'Available');"> <%=individualValuesList[2]%> </button> <% } else { %> <button class="three_common_sub_button" onclick="return stockCheckItemStatusUpdate(<%=individualValuesList[0]%>, 'Available');"> Available </button> <% } %> 
						<% if(!("Available").equals(statusDbName) && ("Back Soon").equals(statusDbName) && !("Replace").equals(statusDbName)) { backSoonCount = backSoonCount + 1; %> <button class="back_soon_submit_btn" onclick="return stockCheckItemStatusUpdate(<%=individualValuesList[0]%>, 'Back Soon');"> <%=individualValuesList[2]%> </button><% } else { %> <button class="three_common_sub_button" onclick="return stockCheckItemStatusUpdate(<%=individualValuesList[0]%>, 'Back Soon');"> Back Soon </button> <% } %>
						<% if(!("Available").equals(statusDbName) && !("Back Soon").equals(statusDbName) && ("Replace").equals(statusDbName)) { replaceCount = replaceCount + 1; %> <button class="replace_submit_btn" onclick="return stockCheckItemStatusUpdate(<%=individualValuesList[0]%>, 'Replace');"> <%=individualValuesList[2]%> </button><% } else { %> <button class="three_common_sub_button" onclick="return stockCheckItemStatusUpdate(<%=individualValuesList[0]%>, 'Replace');"> Replace </button> <% } %>
					</div> </div> </div>
																		
					<div class="col-md-3 col-sm-3"> <div class="url_text_frame_text_mid_adj"> <div class="url_text_frame_mid_adj">
						<% if(!("0").equals(individualValuesList[3])) { %>
						<table><tr>
							<td><i class="sc_dollar_sym_dsp">$</i> <input type="text" maxLength="10" name="scProductPrice1Update" id="scProductPrice1Update<%=individualValuesList[0]%>Id" value="<%=individualValuesList[3]%>" class="st_check_price_frame" onkeypress="return numeralsOnly(event,this.id);" ></td>
							<td><button class="pro_price_save_btn" onclick="return stockCheckPrice1Update('<%=individualValuesList[3]%>', '<%=individualValuesList[0]%>');">Save</button></td> </tr>
							<tr style="height: 10px;"><td></td></tr>
						</table>
						<% } %>
									
						<% if(!("0").equals(individualValuesList[4])) { %>	
						<table><tr>
							<td><i class="sc_dollar_sym_dsp">$</i> <input type="text" maxLength="10" name="scProductPrice2Update" id="scProductPrice2Update<%=individualValuesList[0]%>Id" value="<%=individualValuesList[4]%>" class="st_check_price_frame" onkeypress="return numeralsOnly(event,this.id);" ></td>
							<td><button class="pro_price_save_btn" onclick="return stockCheckPrice2Update('<%=individualValuesList[4]%>', '<%=individualValuesList[0]%>');">Save</button></td> </tr>
							<tr style="height: 10px;"><td></td></tr>
						</table>
						<% } %>
										
						<% if(!("0").equals(individualValuesList[5])) { %>
						<table><tr>
							<td><i class="sc_dollar_sym_dsp">$</i> <input type="text" maxLength="10" name="scProductPrice3Update" id="scProductPrice3Update<%=individualValuesList[0]%>Id" value="<%=individualValuesList[5]%>" class="st_check_price_frame" onkeypress="return numeralsOnly(event,this.id);" ></td>
							<td><button class="pro_price_save_btn" onclick="return stockCheckPrice3Update('<%=individualValuesList[5]%>', '<%=individualValuesList[0]%>');">Save</button></td> </tr>
							<tr style="height: 10px;"><td></td></tr>
						</table>
						<% } %>
										
						<% if(!("0").equals(individualValuesList[6])) { %>
						<table><tr>
							<td><i class="sc_dollar_sym_dsp">$</i> <input type="text" maxLength="10" name="scProductPrice4Update" id="scProductPrice4Update<%=individualValuesList[0]%>Id" value="<%=individualValuesList[6]%>" class="st_check_price_frame" onkeypress="return numeralsOnly(event,this.id);" ></td>
							<td><button class="pro_price_save_btn" onclick="return stockCheckPrice4Update('<%=individualValuesList[6]%>', '<%=individualValuesList[0]%>');">Save</button></td> </tr>
							<tr style="height: 10px;"><td></td></tr>
						</table>
						<% } %>
										
						<% if(!("0").equals(individualValuesList[7])) { %>
						<table><tr>
							<td><i class="sc_dollar_sym_dsp">$</i> <input type="text" maxLength="10" name="scProductPrice5Update" id="scProductPrice5Update<%=individualValuesList[0]%>Id" value="<%=individualValuesList[7]%>" class="st_check_price_frame" onkeypress="return numeralsOnly(event,this.id);" ></td>
							<td><button class="pro_price_save_btn" onclick="return stockCheckPrice5Update('<%=individualValuesList[7]%>', '<%=individualValuesList[0]%>');">Save</button></td>
						</tr></table>
						<% } %>
						</div> </div> </div> </div>
						<% } %>
						</div> </div>
						<% } %>
				  	 	</div> </div>
		        
		        <% } } } } } } } } %>
		    
		  		<div style="position: absolute; top: 31%; left: 20%;">
		       	<font style="font: 500 1.5em/1.7em Georgia; letter-spacing: 1px; color: black;"> No. of Rooms : <font style="font-weight: bold;"><%=roomsCount%></font></font>
		       
		       	<font style="font: 500 1.5em/1.7em Georgia; letter-spacing: 1px; color: #009643; margin-left: 480px;"> Available : <font style="font-weight: bold;"><%=availableCount%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></font> 
		       	<font style="font: 500 1.5em/1.7em Georgia; letter-spacing: 1px; color: #006fbc;">Back Soon: <font style="font-weight: bold;"><%=backSoonCount%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font> </font>
		       	<font style="font: 500 1.5em/1.7em Georgia; letter-spacing: 1px; color: red;">Replace: <font style="font-weight: bold;"><%=replaceCount%></font> </font>
		       	</div> </div> </div> </div>
	        
	        <script type="text/javascript" src="resources/js/json-minified.js"></script>
		</body>
</html>
