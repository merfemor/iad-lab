function draw_points() {
    draw_a_plate(document.getElementById("Form:radius-input_input").value);
    res_table = document.getElementById("result_table");
    for (i = 1; i < res_table.rows.length; i++) {
        draw_point(res_table.rows[i].cells[0].textContent, res_table.rows[i].cells[1].textContent, res_table.rows[i].cells[2].textContent);
    }
    getPoint();
}


function getPoint() {
    var canvas = document.getElementById("plate");

    canvas.onclick = function (event) {
        var x = event.clientX - canvas.getBoundingClientRect().left;
        var y = event.clientY - canvas.getBoundingClientRect().top;
        var r = document.getElementById("Rrad").value;
        sendPoint(x, y, r);
        //draw_point(x, y, canvas);
    }
}

function draw_point(x, y, color) {
    x = x * 50 + 200;
    y = 200 - y * 50;
    canvas = document.getElementById("plate");
    var ctx = canvas.getContext("2d");
    var pi = Math.PI;
    ctx.beginPath();
    if (color == "true"){
        ctx.fillStyle = "green";
        ctx.strokeStyle = "green";
    }
    else {
        ctx.fillStyle = "red";
        ctx.strokeStyle = "red";
    }
    ctx.arc(x, y, 3, 0, 2*pi);
    ctx.stroke();
    ctx.fill();
    ctx.closePath();

    /*
    */
    //draw_point(x, y, data.localeCompare("true"));
}

function add_result(x, y, r, inarea) {
    var tbody = document.getElementById(id).getElementsByTagName("TBODY")[0];
    var row = document.createElement("TR")
    var td1 = document.createElement("TD")
    td1.appendChild(document.createTextNode("column 1"))
    var td2 = document.createElement("TD")
    td2.appendChild (document.createTextNode("column 2"))
    row.appendChild(td1);
    row.appendChild(td2);
    tbody.appendChild(row);
}

function sendPoint(x, y, r) {
    resX = Math.round(((x - 200) / 50) * 1000) / 1000;
    resY = Math.round(((200 - y) / 50) * 1000) / 1000;
    document.getElementById("Form:x-input").value = resX;
    document.getElementById("Form:y-input_hinput").value = resY;
    document.getElementById("Form:SubButton").click();
}

function draw_a_plate(val) {
    canvas = document.getElementById("plate");
    ctx = canvas.getContext("2d");
    pi = Math.PI;

    R = parseFloat(val.replace(",","."));
    ctx.fillStyle = "rgba(51, 123, 225, 0.8)";
    //square
    var xy = 200.00 - 50.00 * R;
    ctx.fillRect(xy, xy, 50 * R, 50 * R);

    //triangle
    ctx.strokeStyle = "rgba(51, 123, 225, 0.8)";
    ctx.beginPath();
    ctx.moveTo(200 - 25 * R, 200);
    ctx.lineTo(200, 200 + 25 * R);
    ctx.lineTo(200, 200);
    ctx.lineTo(200 - 25 * R, 200);
    ctx.fill();

    //circle
    ctx.arc(200, 200, 25 * R, 0, pi/2, false);
    ctx.stroke();
    ctx.fill();
    ctx.closePath();
}



getPoint();