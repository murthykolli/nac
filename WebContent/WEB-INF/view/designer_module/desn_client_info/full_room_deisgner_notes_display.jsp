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
    $(document).ready(function() {
    var desigerNotes1 = '<c:out value="${desigerNotes}"/>';
    $("[name=desigerNotes]").val(desigerNotes1);
    });
    </script>
    
	</head>
	
		<body>		
		<div id="mainframe" class="section-content">
        <div class="container">
        
        <form action="fullRoomDesignerNotesDataSaving" method="post">
        <div class="row">
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        
        <div class="col-md-10 col-sm-10">
        	<div class="service-item">                        
            	<div class="service-description">
        			<div align="center">
        			<textarea name="desigerNotes" id="designerNotesId" placeholder="DESIGNER NOTES" class="design_notes_bord_frame"></textarea>
        			</div>
                </div> <!-- /.service-description -->
            </div> <!-- /.service-item -->               
        </div> <!-- /.col-md-10 -->
        
        <div class="col-md-1 col-sm-1">
        </div> <!-- /.col-md-1 -->
        </div>
        
        <div class="row top_adjustment_30">                			
		<div class="col-md-6 col-sm-6 text-right">
		<a href="fullStyleManagement"><img class="back_submit_Btn" style="margin-right: -7px;" src="resources/images/backButton.png"></a>
		</div>
		
		<div class="col-md-6 col-sm-6 text-left">
		<h4><button class="management_submit_Btn" style="margin-left: -7px;" id="viewClientId">SAVE</button></h4>
		</div>	     
        </div> <!-- /.row -->
        </form>
                          
        </div> <!-- /.container -->
        </div> <!-- /.Main Frame -->
        	
		</body>
</html>