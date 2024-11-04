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
    <link rel="shortcut icon" href="images/ico/favicon.ico" type="image/x-icon">

	<script type="text/javascript">
	
 	$(document).ready(function(){	
	/* $("#needSpaceButtonId").click(function (){	
    var result = true;	
	if(!$("input[name=typeOfItem]").is(':checked')) {
    alert("Please choose what items do you need for your space"); result=false;
    }

	if($('#otherStatusId').is(":checked")){		
    if($("#otherTextAreaId").val() === ""){
	alert("Please enter an item for your space");
	result=false;
    } }
	
	return result;
	}); */

	$("#needSpaceButtonId").click(function (){		
    	
    	var checkVal;
    	$('input:checkbox[name=typeOfItem]').each(function() {
    	var checkItem;
    	
    	if($(this).is(':checked')) {
    		checkItem = $(this).val();    		
    	}
    	
    	if(checkItem === "WALL ART" || checkItem === "wall art") {    		
    		document.myDesign.wallArtRef.value = checkItem;
    	}
    	checkVal = checkVal + ", " + checkItem;    	
    	});
    	var modVal = checkVal.replace("undefined, ", "");    	
    	document.myDesign.typeOfItem.value = modVal;
    	document.myDesign.otherItem.value = $("#otherItemsId").val();
    	document.myDesign.alreadyHaveItem.value = $("#alreadyHaveItemsId").val();
    });
		
        var typeOfItem = '<c:out value="${typeOfItem}"/>';
        var otherItem = '<c:out value="${otherItem}"/>';
        var alreadyHaveItem = '<c:out value="${alreadyHaveItem}"/>';
        
        $("[name='typeOfItem']").each(function (){    	
        if(typeOfItem.indexOf($(this).val()) !== -1){    
        $(this).attr("checked",true);   
        }   
        });        
        
        $("[name=otherItems]").val(otherItem);
        $("[name=alreadyHaveItems]").val(alreadyHaveItem);
    });
	</script>
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">            
        
		<div class="sl_items-title-section text-center">
        <h4>WHAT ITEMS DO YOU NEED FOR YOUR SPACE?</h4>                
        </div> <!-- /.title-section --> 
             
			
		<% if (null != session.getAttribute("item_Names_List")) {
		   @SuppressWarnings("rawtypes")
	       ArrayList itemNamesList = (ArrayList) session.getAttribute("item_Names_List");
	       if (null != itemNamesList && itemNamesList.size() > 0) {			
        %>
         
        <div class="row top_adjustment_35">        
		<% for(int i=0; i<4 && i<itemNamesList.size(); i++){ %>
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>
		<% } %>		 
		 
		<% for(int i=4; i<8 && i<itemNamesList.size(); i++){ %>
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>
		<% } %>		 
		
		<% for(int i=8; i<12 && i<itemNamesList.size(); i++){ %> 
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>		 
		<% } %>
		
		<% for(int i=12; i<16 && i<itemNamesList.size(); i++){ %> 
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>
		<% } %>		 
		
		<% for(int i=16; i<20 && i<itemNamesList.size(); i++){ %> 
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>		 
		<% } %>
		
		<% for(int i=20; i<24 && i<itemNamesList.size(); i++){ %> 
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>		 
		<% } %>
		
		<% for(int i=24; i<28 && i<itemNamesList.size(); i++){ %> 
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>		 
		<% } %>
		
		<% for(int i=28; i<32 && i<itemNamesList.size(); i++){ %> 
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>		 
		<% } %>
		
		<% for(int i=32; i<36 && i<itemNamesList.size(); i++){ %> 
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>		 
		<% } %>
		
		<% for(int i=36; i<40 && i<itemNamesList.size(); i++){ %> 
		<div class="col-md-3 col-sm-3 sel_item_adj"><input type="checkbox" name="typeOfItem" value="<%=itemNamesList.get(i)%>"><font class="chck_name_adj"><%=itemNamesList.get(i)%></font></div>		 
		<% } %>
				
		<% } } %>
		</div> <!-- /.row -->
		
		<div class="services" align="center" style="margin-top: 30px; margin-left: 250px; margin-right: 250px;">        
        	<div class="service-item">                        
            	<div align="center" class="service-description">
            		<textarea name="otherItems" id="otherItemsId" placeholder="OTHER THINGS I NEED ..." class="item-text_area_box-disp"></textarea>
         	   </div> <!-- /.service-description -->
         	   
         	   <div align="center" class="service-description">
            		<textarea name="alreadyHaveItems" id="alreadyHaveItemsId" placeholder="I ALREADY HAVE ..." class="item-text_area_box-disp"></textarea>
         	   </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->
        </div>
		
		        
        <div class="form-nav">
            <form action="needSpaceItemsBackMove" method="get">
                <h4><input class="back_submit_Btn" type="image" title="BACK"
                           src="resources/images/backButton.png"></h4>
            </form>
            <form action="needSpaceItemsDataSaving" name="myDesign" method="get">
                <h4>
                    <button class="continue_submit_Btn" id="needSpaceButtonId">CONTINUE</button>
                </h4>
                <input type="hidden" name="typeOfItem"/>
				<input type="hidden" name="otherItem"/>
				<input type="hidden" name="alreadyHaveItem">
				<input type="hidden" name="wallArtRef">
            </form>
        </div> 
		
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
    	    	
		</body>
</html>