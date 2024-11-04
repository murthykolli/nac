<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="nookandcove">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="resources/css/registry_css/registry_static.css" type="text/css">    
    <script type="text/javascript" src="resources/js/registry/find_registry.js"></script>    
    
	<script type="text/javascript">
	$(document).ready(function(){  	
 		var foundNameStatus = "<c:out value="${findNameStatus}"/>"; if(foundNameStatus !== "") { alert("No records available"); } });
	</script>
	
	</head>	
		<body class="fin_reg_body_adj">							
		<div id="mainframe" class="section-content"> <div class="container"> <div class="row top_adjustment_40"> <div class="col-md-1 col-sm-1"></div> <div class="col-md-10 col-sm-10" align="center"> <img src="resources/images/registry/find_reg_img.png">        
        <div class="row"> <div class="col-md-4 col-sm-4"></div> <div class="col-md-4 col-sm-4 bot_adjustment_145" align="center"> <input type="text" id="reg_search_Input_id" onkeyup="regSearchNamesList()" placeholder="Enter name" title="Type in a name"> <ul id="reg_search_ul_id" class="top_adjustment_0">
		
		<% 	
			if (null != session.getAttribute("reg_User_Ids_List")) { @SuppressWarnings("rawtypes") ArrayList regUserIdsList = (ArrayList) session.getAttribute("reg_User_Ids_List"); if (null != regUserIdsList && regUserIdsList.size() > 0) {		
		   	if (null != session.getAttribute("reg_User_Images_List")) { @SuppressWarnings("rawtypes") ArrayList regUserImagesList = (ArrayList) session.getAttribute("reg_User_Images_List"); if (null != regUserImagesList && regUserImagesList.size() > 0) {
           	if (null != session.getAttribute("reg_User_Dates_List")) { @SuppressWarnings("rawtypes") ArrayList regUserNamesList = (ArrayList) session.getAttribute("reg_User_Names_List"); if (null != regUserNamesList && regUserNamesList.size() > 0) {
    	   	if (null != session.getAttribute("reg_User_Dates_List")) { @SuppressWarnings("rawtypes") ArrayList regUserDatesList = (ArrayList) session.getAttribute("reg_User_Dates_List"); if (null != regUserDatesList && regUserDatesList.size() > 0) {
           	if (null != session.getAttribute("reg_User_URLs_List")) { @SuppressWarnings("rawtypes") ArrayList regUserURLsList = (ArrayList) session.getAttribute("reg_User_URLs_List"); if (null != regUserURLsList && regUserURLsList.size() > 0) {
			for(int i=0;i<regUserIdsList.size(); i++) {  
		%>
				 
		<li><a href="registry/<%=regUserURLsList.get(i)%>">		
		<font class="fr_rpd_frame_adj"> <img align="left" class="reg_search_img_resize_dsp" src="<%=regUserImagesList.get(i)%>"/> </font>			
		<font class="finr_lpd_frame_adj"> <span class="fr_fr_name_fdsp"><%=regUserNamesList.get(i)%></span><br> <font class="fnr_text_name_fdsp"><%=regUserDatesList.get(i)%></font> </font> </a></li>		
		<% } } } } } } } } } } } %>
			
		<li class="fr_ln_text_dsp" id="noResultId"><a href="#" class="fn_reg_no_txt" onMouseOver="this.style.background='white';" onMouseOut="this.style.background='white';"><span class="find_reg_rg_no_dsp">Sorry, there's no registry under that name</span> </a></li> </ul> </div></div>
		<div class="col-md-4 col-sm-4"></div> </div> <div class="col-md-1 col-sm-1"></div> </div> <div class="fn_reg_height_adj_cl"></div> </div> </div> 
        <div style="display: none">Find A REGISTRY</div>
		</body>
</html>