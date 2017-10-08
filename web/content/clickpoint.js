function getPoint() {
    var canvas = document.getElementById("plate");

    canvas.onclick = function (event) {
        var x = event.clientX - canvas.getBoundingClientRect().left - 200;
        var y = event.clientY - canvas.getBoundingClientRect().top - 200;
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
    $.ajax({
        type: "POST",
        url: "controller",
        data: ({Xcor:x, Ycor:y, Rrad:r, Ajax: true}),
    });
}

getPoint();
