function draw_a_plate(val) {
    var canvas = document.getElementById("plate");
    var ctx = canvas.getContext("2d");
    var pi = Math.PI;

    var R = val;
    ctx.fillStyle = "rgba(51, 123, 225, 0.8)";
    //square
    var xy = 200 - 50 * R;
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
document.getElementById("Rrad").value = 3;
draw_a_plate(3);