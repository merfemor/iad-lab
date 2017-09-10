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
    }
    document.getElementById(this.id).value = s;
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
    document.getElementById(this.id).value = s;
    return s;
}

Xcor.addEventListener("keyup", validator);
Ycor.addEventListener("keyup", validator);
Rrad.addEventListener("keyup", radiusValidator);