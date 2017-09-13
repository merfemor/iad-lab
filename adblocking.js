document.getElementById('turn-off-ads').onclick = function() {
	var status = is_donated(function(status) {
		console.log("is_donated status: " + status);
		if(status === true) {
			hide_ads(true);
		} else if (status === false) {
			alert('You have no power here.\nDonate, pls\n');
		} else if(status == null) {
			alert('Failed to load the donate information.\nPlease, check yout internet connection and try again.');
		}
	});
};

function hide_ads(alert_message = false) {
    document.getElementById("ad-unit-r").style.display = "none";
    document.getElementById("ad-unit-l").style.display = "none";
    if(alert_message) {
        alert('Thanks for donating!')
    }
}

function show_ads() {
	document.getElementById("ad-unit-l").style.display="block";
	document.getElementById("ad-unit-r").style.display="block";
}

var GET_INFO_URL = 'https://sheets.googleapis.com/v4/spreadsheets/1Hy3Nqjxm92540mfwli7DE3U2UBiP8NVrii7CUoa02xU/values/1!A2?key=AIzaSyD_Opt6qNmkiaFw_4NZvLrSr4n3WUZ8ryE';

function is_donated(func) {
    get_page_content(GET_INFO_URL, function(content) {
		if(content != null) {
			var ret = content.search("FALSE") === -1;
		}
		func(ret);
	});
}

function get_page_content(url, func) {
	if(window.XMLHttpRequest){  
		xmlhttp=new XMLHttpRequest();
	} else if(window.ActiveXObject){  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");  
	}  
    try {
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4) {
				if(xmlhttp.status!=200) {
					console.error('Bad xmlhttp.status = ' + xmlhttp.status);
					func(null);
				} else {
					func(xmlhttp.responseText);
				}
			}
		};  
		xmlhttp.open("GET", url, true);
        xmlhttp.send();
    } catch (e) {
		console.error('Exception: ' + e);
        return null;
    }
    
    return null;
}
