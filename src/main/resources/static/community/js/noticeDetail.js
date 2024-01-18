//포맷변경
//날짜
function formatDates(dateString) {
    let dateObj = new Date(dateString);
    let formattedDate = dateObj.getFullYear() +'-' + ('0' + (dateObj.getMonth() + 1)).slice(-2) +'-' +('0' + dateObj.getDate()).slice(-2) +' ' + ('0' + dateObj.getHours()).slice(-2) +':' +('0' + dateObj.getMinutes()).slice(-2);
    return formattedDate;
}
$('.info-date').text(formatDates($('.written-date').text()))