let map = null;
let marker = null;

//카카오맵
function initMap() {
    window.kakao.maps.load(() => {
        const container = document.getElementById("map");
        const options = {
            center: new window.kakao.maps.LatLng(33.450701, 126.570667),
            level: 3,
        };

        map = new window.kakao.maps.Map(container, options);
        marker = new window.kakao.maps.Marker();
    });
}

//다음주소API + 주소값에 따른 지도에 마커 생성
function onClickAddr() {
    new window.daum.Postcode({
        oncomplete: function (addrData) {
            const geocoder = new window.kakao.maps.services.Geocoder();
            geocoder.addressSearch(addrData.address, function (result, status) {
                if (status === window.kakao.maps.services.Status.OK) {
                    const currentPos = new window.kakao.maps.LatLng(result[0].y, result[0].x);
                    document.getElementById("addr").value = addrData.address;
                    document.getElementById("city").value = addrData.sido;
                    document.getElementById("county").value = addrData.sigungu;
                    map.panTo(currentPos);
                    marker.setMap(null);
                    marker.setPosition(currentPos);
                    marker.setMap(map);
                }
            });
        },
    }).open();
}


document.addEventListener('DOMContentLoaded', function () {

    //지도 함수 및 주소/마커생성
    initMap();
    document.getElementById("search-btn").addEventListener("click", onClickAddr);

    //달력 값에 따른 시간대 동적으로 생성
    const selectElement = document.getElementById('walkingMateTime');
    $('#datepicker').datepicker({
        // showOn: 'both',
        showButtonPanel: true,
        // buttonImage: "/img/calendarIcon.png",
        // buttonImageOnly:true,
        currentText: '오늘 날짜',
        closeText: '닫기',
        dateFormat: 'yy/mm/dd',
        minDate: 0,
        maxDate: '+7',
        onSelect: function (dateText, datePicker) {
            const selectedDate = new Date(dateText);
            const currentHour = new Date().getHours();

            if (!isNaN(selectedDate)) {
                const selectOptions = [];
                for (let i = 10; i <= 20; i += 2) {
                    if (selectedDate > new Date() || (selectedDate.getDate() !== new Date().getDate()) || (currentHour < i && i < 20)) {
                        const optionValue = `${i < 10 ? '0' : ''}${i}:00`;
                        selectOptions.push(`<option value="${optionValue}">${optionValue}</option>`);
                    }
                }
                selectElement.innerHTML = selectOptions.join('');
            } else {
                console.error('Invalid date selected.');
            }
        }
    });
});



