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


    // $('.writer-pet-section').on('click', function (){
    //
    //     $(this).slideToggle(400);
    //
    // })
showReplyList(walkBoardId, replyList)
});

$('.reply-submit').on('click', function (){

    let commentSection =     $('#walkBoardComment').val();

    if(!commentSection){
        alert("댓글 내용을 입력해주세요");
        return false;
    }


    addReply()

    $('#walkBoardComment').val('')
})






function addReply(){

    let walkBoardComment = $('#walkBoardComment').val();
    let walkBoardId = $('#walkBoardId').val();
    let userId = $('#userId').val();

    $.ajax({

        url:'/walks/detailReply',
        type:'post',
        data : {
            walkBoardComment : walkBoardComment,
            walkBoardId : walkBoardId,
            userId : userId
        },
        success : function (result){

            showReplyList(walkBoardId, replyList)

        }
        ,error : function (a,b,c){
            console.error(c);
        }
    })

}
let walkBoardComment = $('#walkBoardComment').val();
let walkBoardId = $('#walkBoardId').val();
let userId = $('#userId').val();

function showReplyList(walkBoardId, callback){
    $.ajax({
        url:`/walks/showReplyList/${walkBoardId}`,
        type: 'get',
        dataType:'json',
        success : function (result){
            console.log(result)

            if(callback){
                callback(result)
            }

        },error : function (a,b,c){
            console.error(c);
        }
    })
}


function replyList(result){

    let text = '';
    let inputTextSection = $('.reply-list');


    result.forEach(r=>{

        text += `
 
                  <div class="reply">
                        <div class="id-and-date">
                            <div class="reply-info">
                            `;

        if(r.userImgId == null){
            text += ` 
                            <div class="reply-img"><img src="/img/dogImg02.jpg" alt="유저 디폴트 사진"></div>

            `;
        }else {
            text += `
                            <div class="reply-img"><img src="/walks/walkDetailImg?userImgPath=${r.userImgPath +'/' + r.userImgUuid +'_' + r.userImgName}" alt="유저 사진"></div>
            
            `;
        }

        if(r.userNickName == null){
            text += `
                             <div class="reply-id">${r.userAccount}</div>

            `;
        }else {
            text += `
                             <div class="reply-id">${r.userNickName}</div>

            `;
        }
            text+=`
                            </div>
                            <div class="reply-date">2023-11-24</div>
                        </div>
                        <div class="reply-content-n-btns">
                            <div class="reply-content">
                                ${r.walkDetailReplyComment}
                            </div>
                            `;
        if(r.userId == userId ){
            text += `
            
                            <div class="reply-btns">
                                <div class="update-reply"><a href="" data-commentid="${r.id}">수정</a></div>
                                <div class="delete-reply"><a href="" data-commentid="${r.id}">삭제</a></div>
                            </div>
            `;
        }


        text+=`
                        </div>
                    </div>
  
        `;



    })

    inputTextSection.html(text);
}

$('.reply-list').on('click', '.delete-reply a', function (e){

    e.preventDefault();

    let commentId = $(this).closest('.reply-btns').find('.delete-reply a').data('commentid');

    if(confirm("삭제하시겠습니까?")){

        $.ajax({
            url : '/walks/walkReplyDelete/'+commentId,
            type:'delete',
            success : function (){
                showReplyList(walkBoardId, replyList)
            }
        })
    }

})




