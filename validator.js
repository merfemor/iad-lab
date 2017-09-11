function validator(){
    var s = this.value;
    var sf = false;
    for (var i = 0; i < s.length; i++) {
        if (s[i] == "-") {
            if (sf) {
                s = s.substring(0, i);
                break;
            }
            else {
                sf = true;
            }
        }
        else if (s[i] < '0' || s[i] > '9') {
            s = s.substring(0, i);
            break;
        }
	else {
	    sf = true;
	}
    }
    if (Number(s) < -5){
        document.getElementById(this.id).value = "-5";
    }
    else if (Number(s) > 3) {
        document.getElementById(this.id).value = "3";
    }
    else {
        document.getElementById(this.id).value = s;
    }
    return s;
}

function radiusValidator() {
    var s = this.value;
    for (var i = 0; i < s.length; i++) {
        if (s[i] < '0' || s[i] > '9') {
            s = s.substring(0, i);
            break;
        }
    }
    if (Number(s) < 2 && s != ""){
        document.getElementById(this.id).value = "2";
    }
    else if (Number(s) > 5) {
        document.getElementById(this.id).value = "5";
    }
    else {
        document.getElementById(this.id).value = s;
    }
    return s;
}

Ycor.addEventListener("keyup", validator);
Rrad.addEventListener("keyup", radiusValidator);
