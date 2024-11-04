
	function checkFirstChar(key, txt) {
	if(key == 32 && txt.value.length<=0) {
	return false;
	}
	else if(txt.value.length>0) {
	if(txt.value.charCodeAt(0) == 32) {
	txt.value=txt.value.substring(1,txt.value.length);
	return true;
	}
	}
	return true;
	}
	
	function regSearchNamesList() {	
		var input, filter, ul, li, a, i;
	    input = document.getElementById("reg_search_Input_id");    
	    filter = input.value.toUpperCase();
	    ul = document.getElementById("reg_search_ul_id");
	    li = ul.getElementsByTagName("li");
	    
		if(filter !== "") {
			ul.style.display = "block";
		} else {
			ul.style.display = "none";
		}
		var totCount = li.length;		
		var chCount = 0;
	    for (i = 0; i < li.length; i++) {	
	        a = li[i].getElementsByTagName("span")[0];
	        var ancVal = a.innerHTML.toUpperCase().replace(/\&AMP;/g,"&");	        
	        if (ancVal.indexOf(filter) > -1) {
	            li[i].style.display = "";				
	        } else {
				chCount = chCount + 1;
	            li[i].style.display = "none";	            
	        }	        
	    }
	    
		if(totCount === chCount) {
			document.getElementById("noResultId").style.display = "block";
		} else {
			document.getElementById("noResultId").style.display = "none";
		}	
	}