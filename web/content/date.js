dateContainer = document.getElementById('date');
updateDate();
function updateDate() {
    curDateTime = new Date();
    curDate = curDateTime.toLocaleDateString();
    dateContainer.innerHTML = curDate;
    setTimeout('updateDate()', 5000);
}