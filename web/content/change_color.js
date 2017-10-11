circle_top = document.getElementById("top-circle");
circle_mid = document.getElementById("middle-circle");
circle_bot = document.getElementById("bottom-circle");

circle_top.onmouseenter = function() {
    circle_mid.style.background = "orange";
    circle_bot.style.background = "red";
}

circle_mid.onmouseenter = function() {
    circle_top.style.background = "violet";
    circle_bot.style.background = "purple";
}

circle_bot.onmouseenter = function () {
    circle_top.style.background = "yellow";
    circle_mid.style.background = "salmon";
}