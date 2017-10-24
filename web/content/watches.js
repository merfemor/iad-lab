timeContainer = document.getElementById('time');
updateTime();
function updateTime() {
    curDateTime = new Date();
    curTime = curDateTime.toLocaleTimeString();
    timeContainer.innerHTML = curTime;
    setTimeout('updateTime()', 1000);
}