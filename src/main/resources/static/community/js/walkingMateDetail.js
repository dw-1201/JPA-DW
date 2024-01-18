import * as reply from './module/reply.js';
import * as date from './module/form.js';

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

    //날짜 포맷 변경
    let regDateString = $('#registeredDate').val();
    let modifyDateString = $('#modifiedDate').val();

    let formattedDateReg = date.formatDate(regDateString);
    let formattedDateModify = date.formatDate(modifyDateString);


    $('.walk-mate-modified-date span').text(formattedDateModify);
    $('.walk-mate-registered-date span').text(formattedDateReg);

    //지도 로드
    initMap();
    reply.limitText( $('#walkBoardComment'),'.comment-length-Check' )
    showReplyList(walkBoardId, replyList)
});

$('.reply-submit').on('click', function (){

    let commentSection = $('#walkBoardComment').val();

    if(!commentSection){
        alert("댓글 내용을 입력해주세요");
        return false;
    }

    if(reply.getTextLength(commentSection)>200){
        alert("200자 이내로 작성해주세요")
        return;
    }


    addReply()

    $('#walkBoardComment').val('')
    $('.comment-length-Check').text('');

})

//산책글 리스트 이동
$('.list-btn').on('click', function (){

    window.location.href="/walk/walkList";

})

//산책글 수정 페이지 이동
$('.modify-btn').on('click', function (){

    let walkBoardId = $(this).data('walkboardid');

    if(confirm("수정 페이지로 이동하시겠습니까?")){

        window.location.href="/walk/modify/" + walkBoardId;
    }

})

//산책글 삭제
$('.delete-btn').on('click', function (){

    let walkBoardId = $(this).data('walkboardid');

    if(confirm("해당 글을 삭제하시겠습니까?")){
            window.location.href="/walk/deleteWalkMate/" + +walkBoardId;
    }
})







//산책 댓글 영역////
//댓글 등록
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
        success : function (){


            showReplyList(walkBoardId, replyList)

        }
        ,error : function (a,b,c){
            console.error(c);
        }
    })

}
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
                            <div class="reply-date">
                                ${reply.timeForToday(r.walkCommentMd) + (r.walkCommendRd == r.walkCommentMd ? ' 작성' : ' 수정')}

                            </div>
                        </div>
                        <div class="reply-content-n-btns">
                            <div class="reply-content">${r.walkDetailReplyComment}</div>
                            `;
        if(r.userId == userId ){
            text += `
                            <span class="reply-section-btns "></span>
                            <div class="reply-btns none">
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


//댓글 수정 삭제버튼 팝업
$('.reply-list').on('click', '.reply-section-btns', function () {
    let replyBtnBox = $(this).closest('.reply-content-n-btns').find('.reply-btns');
    $('.reply-btns').addClass('none');
    replyBtnBox.toggleClass('none');



});

$('body').click(function (e) {
    if ($(e.target).hasClass('reply-section-btns')) {
        //console.log('aa');
        return;
    }
    if (!$('.reply-btns').has(e.target).length) {
        $('.reply-btns').addClass('none');
    }
});

//삭제버튼
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


//수정 버튼 클릭
$('.reply-list').on('click', '.update-reply a', function (e) {

    e.preventDefault();



    let letterLimit = $(this).closest('.reply').find('.reply-date');
    let modifyContentPopUp = $(this).closest('.reply-content-n-btns').find('.reply-content');
    let btnBox = $(this).closest('.reply-content-n-btns').find('.reply-btns');


    letterLimit.replaceWith(
        `
          <div class=modify-limit>
                <span class="textLengthCheck">
                ${reply.getTextLength(modifyContentPopUp.text()) + ' / 200 '}
                </span>
          </div>
          
        `
    );

    modifyContentPopUp.replaceWith(
        ` <div class="modify-box">
            <textarea class="modify-reply-content">${modifyContentPopUp.text()}</textarea>
            <button type="button" class="modify-reply-btn">수정</button>
          </div>
        `
    );

    //수정, 삭제버튼 감추기
    btnBox.css('display', 'none')

    //수정창 글자 수 실시간 카운팅
    reply.limitModifyText('.reply-list', '.modify-reply-content', '.textLengthCheck' ,'.modify-limit');

})

// 수정 완료 처리
$('.reply-list').on('click', '.modify-reply-btn', function (){

    let commentId = $(this).closest('.reply-content-n-btns').find('.update-reply a').data('commentid');
    let modifyContentVal = $(this).closest('.modify-box').find('.modify-reply-content').val();

    if(!modifyContentVal){
        alert("댓글 내용을 입력해주세요")
        return;
    }

    if(reply.getTextLength(modifyContentVal)>200){
        alert("200자 이내로 작성해주세요")
        return;
    }

    $.ajax({

        url:'/walks/walkReplyModify',
        type:'patch',
        data : {
            id : commentId,
            walkBoardComment : modifyContentVal,

        },
        success : function (){
            showReplyList(walkBoardId, replyList)
        },error : function (a,b,c){
            console.error(c);
        }

    })

})


