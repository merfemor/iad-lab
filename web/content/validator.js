function validator(event){
    var s = this.value;
    var sf = false;
    var pf = false;
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
        else if (s[i] == '.'){
            if (pf) {
                s = s.substring(0, i);
                break;
            }
            else {
                pf = true;
            }
        }
        else if (s[i] < '0' || s[i] > '9') {
            s = s.substring(0, i);
            break;
        }
        else if (s[i] === '0' && i > 0 && s[i-1] === s[i]){
            s = s.substring(0, i);
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

Ycor.addEventListener("keyup", validator);