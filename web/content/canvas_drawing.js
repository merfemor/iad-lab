var canvas = document.getElementById("plate");
var ctx = canvas.getContext("2d");
var pi = Math.PI;

ctx.fillStyle = "rgba(51, 123, 225, 0.8)"
ctx.fillRect(50, 50, 150, 150);

ctx.strokeStyle = "rgba(51, 123, 225, 0.8)"
ctx.beginPath();
ctx.moveTo(125, 200);
ctx.lineTo(200, 275);
ctx.lineTo(200, 200);
ctx.lineTo(125, 200);
ctx.fill();

ctx.arc(200, 200, 75, 0, pi/2, false);
ctx.stroke();
ctx.fill();