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

function draw_point(x, y, canvas) {
    var ctx = canvas.getContext("2d");
    var pi = Math.PI;
    ctx.beginPath();
    ctx.fillStyle = "red";
    ctx.strokeStyle = "red";
    ctx.arc(x, y, 3, 0, 2*pi);
    ctx.stroke();
    ctx.fill();
    ctx.closePath();
}

function sendPoint(x, y, r) {
    resX = Math.round(((x - 200) / 50) * 1000) / 1000;
    resY = Math.round(((200 - y) / 50) * 1000) / 1000;
    $.ajax({
        type: "POST",
        url: "controller",
        data: ({Xcor:resX, Ycor:resY, Rrad:r, Ajax: true}),
        //success:
    });
}

getPoint();
