function getPoint() {
    var canvas = document.getElementById("plate");

    canvas.onclick = function (event) {
        var x = event.clientX - canvas.getBoundingClientRect().left;
        var y = event.clientY - canvas.getBoundingClientRect().top;
        var r = document.getElementById("Rrad").value;
        sendPoint(x, y, r);
        draw_point(x, y, canvas);
    }
}

function draw_point(x, y, color) {
    canvas = document.getElementById("plate");
    var ctx = canvas.getContext("2d");
    var pi = Math.PI;
    ctx.beginPath();
    if (color == 1){
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
    $.ajax({
        type: "POST",
        url: "controller",
        data: ({Xcor:resX, Ycor:resY, Rrad:r, Ajax: true}),
        success: function (data) {
            table = document.getElementById("result_table");
            var row = document.createElement("TR");
            var number = document.createElement("TD");
            number.appendChild(document.createTextNode(table.rows.length));
            var xcol = document.createElement("TD");
            xcol.appendChild(document.createTextNode(resX));
            var ycol = document.createElement("TD");
            ycol.appendChild(document.createTextNode(resY));
            var rcol = document.createElement("TD");
            rcol.appendChild(document.createTextNode(r));
            var inarea_col = document.createElement("TD");
            if (data.localeCompare("true") == 1){
                inarea_col.appendChild(document.createTextNode("yes"));
            }
            else {
                inarea_col.appendChild(document.createTextNode("no"));
            }
            row.appendChild(number);
            row.appendChild(xcol);
            row.appendChild(ycol);
            row.appendChild(rcol);
            row.appendChild(inarea_col);
            table.appendChild(row);
            table.style.textAlign = "center";
            table.style.fontWeight = "bold";
            //table.style.
            if (data.localeCompare("true") == 1){
                table.rows[table.rows.length - 1].cells[4].style.color = "green";
            }
            else {
                table.rows[table.rows.length - 1].cells[4].style.color = "red";
            }
            draw_point(x, y, data.localeCompare("true"));
        }
    });
}

getPoint();
