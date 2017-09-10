function validator(){
    alert("Fuck!");
    s = this.value;
    var sf = false;
    for (var i = 0; i < s.length; i++){
        if (s[i] == '-'){
            if (sf) {
                s = s.substring(0, i);
                break;
            }
            else {
                sf = true;
            }
        }
        if (s[i] < '0' || s[i] > '9'){
            s = substring(0, i);
            break;
        }
    }
    return s;
}