export function formatDates(dateString) {
    let dateObj = new Date(dateString);
    let formattedDate = dateObj.getFullYear() +'-' + ('0' + (dateObj.getMonth() + 1)).slice(-2) +'-' +('0' + dateObj.getDate()).slice(-2) +' ' + ('0' + dateObj.getHours()).slice(-2) +':' +('0' + dateObj.getMinutes()).slice(-2);
    return formattedDate;

}

// 콤마 찍기 함수
export function addCommas(number) {
    return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
