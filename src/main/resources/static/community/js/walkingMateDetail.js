let map = null;
let marker = null;

// 지도 초기화 함수
function initMap() {
    window.kakao.maps.load(() => {
        const container = document.getElementById("map");
        const options = {
            center: new window.kakao.maps.LatLng(33.450701, 126.570667),
            level: 3,
        };

        map = new window.kakao.maps.Map(container, options);
        marker = new window.kakao.maps.Marker();

        //주소 정보 가져오기
        const retrievedAddress = $('#fullsAddress').val();

        if (retrievedAddress) {
            showMarkerOnMap(retrievedAddress);
        } else {
            console.error('가져온 주소가 비어 있습니다.');
        }
    });
}

// 주소를 지도에 표시하는 함수
function showMarkerOnMap(address) {
    const geocoder = new window.kakao.maps.services.Geocoder();

    // 주소를 좌표로 변환
    geocoder.addressSearch(address, function (result, status) {
        if (status === window.kakao.maps.services.Status.OK) {
            const currentPos = new window.kakao.maps.LatLng(result[0].y, result[0].x);

            // 기존 마커 삭제 후 새로운 마커 추가
            marker.setMap(null);
            marker.setPosition(currentPos);
            marker.setMap(map);

            // 지도 중심 이동
            map.panTo(currentPos);
        } else {
            console.error('주소를 찾을 수 없습니다.');
        }
    });
}

$(document).ready(function () {
    //지도 로드
    initMap();
});
