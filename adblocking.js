document.getElementById('turn-off-ads').onclick = function() {
    var status = is_donated();
	if(status === true) {
	    alert('Thanks for donating!');
		document.getElementById("ad-unit").style.visibility = 'hidden';
	} else if (status === false) {
		alert('You have no power here.\nDonate, pls\n');
	}
};

var GET_INFO_URL = 'https://sheets.googleapis.com/v4/spreadsheets/1Hy3Nqjxm92540mfwli7DE3U2UBiP8NVrii7CUoa02xU/values/1!A2?key=AIzaSyD_Opt6qNmkiaFw_4NZvLrSr4n3WUZ8ryE';

function is_donated() {
    var content = get_page_content(GET_INFO_URL);
    if(content == null) {
        alert('Failed to load the donate information.\nPlease, check yout internet connection and try again.');
        return null;
    }
	return content.search("FALSE") === -1;
}

function get_page_content(url)
{
    xmlhttp=new XMLHttpRequest();
    xmlhttp.open("GET", url, false );
    try {
        xmlhttp.send(null);
    } catch (e) {
        return null;
    }
    if (xmlhttp.status==200) {
        return xmlhttp.responseText;
    }
    return null;
}
