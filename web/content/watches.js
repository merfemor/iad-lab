dateContainer = document.getElementById('time');
updateTime();
function updateTime() {
    var curDateTime = new Date();
    var curTime = curDateTime.toLocaleTimeString();
    //var curDate = curDateTime.toLocaleDateString();
    dateContainer.innerHTML = curTime;
    //dateContainer.innerHTML = curDate;
    setTimeout('updateTime()', 5000);
}