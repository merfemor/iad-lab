document.getElementById('turn-off-ads').onclick = function() {
    setTimeout(function(){
        var status = is_donated();
        if(status === true) {
            hide_ads(true);
        } else if (status === false) {
            alert('You have no power here.\nDonate, pls\n');
        } else if(status === null) {
            alert('Failed to load the donate information.\nPlease, check yout internet connection and try again.');
        }
    }, 1);
};

function hide_ads(alert_message = false) {
    document.getElementById("ad-unit-r").style.display = "none";
    document.getElementById("ad-unit-l").style.display = "none";
    if(alert_message) {
        alert('Thanks for donating!')
    }
}

var GET_INFO_URL = 'https://sheets.googleapis.com/v4/spreadsheets/1Hy3Nqjxm92540mfwli7DE3U2UBiP8NVrii7CUoa02xU/values/1!A2?key=AIzaSyD_Opt6qNmkiaFw_4NZvLrSr4n3WUZ8ryE';

function is_donated() {
    var content = get_page_content(GET_INFO_URL);
    if(content == null) {
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
