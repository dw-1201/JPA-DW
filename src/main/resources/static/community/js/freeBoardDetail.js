// const slides = document.querySelector('.slider'); // 전체 슬라이드 컨테이너
// const slideImg = document.querySelectorAll('.slider li'); // 모든 슬라이드들
// let currentIdx = 0; // 현재 슬라이드 index
// const slideCount = slideImg.length; // 슬라이드 개수
// const prev = document.querySelector('.prev'); // 이전 버튼
// const next = document.querySelector('.next'); // 다음 버튼
// const slideWidth = 300; // 한개의 슬라이드 넓이
//
// // 전체 슬라이드 컨테이너 넓이 설정
// slides.style.width = slideWidth * slideCount + 'px';
//
// function moveSlide(num) {
//   slides.style.left = -num * slideWidth + 'px';
//   currentIdx = num;
// }
//
// prev.addEventListener('click', function () {
//   if (currentIdx !== 0) moveSlide(currentIdx - 1);
// });
//
// next.addEventListener('click', function () {
//   if (currentIdx !== slideCount - 1) {
//     moveSlide(currentIdx + 1);
//   }
// });

// 자유게시판 글 수정
$('.update-btn').on('click', function () {
  let freeBoardId = $(this).data('freeboardid');
  window.location.href = "/community/modify/" + freeBoardId;
});

// 자유게시판 글 삭제
$('.remove-btn').on('click', function () {
  let freeBoardId = $(this).data('freeboardid');
  if (confirm("글을 삭제하시겠습니까?")) {
    window.location.href = "/community/delete/" + freeBoardId;
  }
});

// 자유게시판 글 목록으로 이동
$('.list-btn').on('click', function () {
  window.location.href = "/community/freeBoardList";
});

/**
 * 여기서부터 댓글 js
 */
// 댓글 목록을 보여주는 함수를 호출하여 초기화면에 댓글을 표시
let freeBoardId = $('#freeBoardId').val();
showReplyList(freeBoardId);

// '댓글 저장' 버튼 클릭 이벤트 핸들러
$('.btn-reply').on('click', function () {
  let content = $('#reply-content').val();
  let freeBoardId = $('#freeBoardId').val();
  let userId = loginNumber;

  let replyObj = {

    freeBoardCommentContent: content,
    freeBoard : {id :freeBoardId },
    users : {id:userId}

  };
  console.log(replyObj.freeBoardCommentContent)
  console.log(content)
  if (!(content && loginNumber)) {
    alert('댓글을 입력해주세요!');
    return;
  }
  // 댓글 저장 함수 호출
  getReply(replyObj)

  // 댓글 저장 후 댓글 목록 갱신
  showReplyList(freeBoardId);
  $('#reply-content').val('');
});

//댓글 저장
function getReply(object){
  $.ajax({

    url:'/replies/writeComment',
    type:'post',
    data:JSON.stringify(object),
    contentType:'application/json; charset=utf-8',
    success : function (result){

    // 댓글 저장 후 댓글 목록 갱신
    showReplyList(freeBoardId);
    }
  })
}

export function modify(freeBoardCommentId, reply, callback){
  // jQuery의 $.ajax() 메서드를 사용하여 서버로 HTTP PATCH 요청을 보냄
  $.ajax({
    // 요청을 보낼 URL. URL 내에 freeBoardCommentId 변수 값을 포함함
    url : `/replies/modifyComment/${freeBoardCommentId}`,
    // HTTP 요청의 타입을 'patch'로 설정 (업데이트 요청)
    type : 'patch',
    // 서버에 전송할 데이터를 JSON 문자열로 변환하고 전송
    data : JSON.stringify(reply),
    // 요청의 Content-Type 헤더를 JSON 형식으로 설정
    contentType : 'application/json; charset=utf-8',
    // 요청이 성공했을 때 실행되는 함수
    success : function (){
      // 콜백 함수(callback)가 제공되었다면 실행
      if(callback){
        callback();
      }
    },
    // 요청이 실패했을 때 실행되는 함수
    error : function (a, b, c){
      // 콘솔에 오류 메시지 출력
      console.error(c);
    }
  });
}

export function remove(freeBoardCommentId, callback) {
  // jQuery를 사용하여 AJAX 요청을 보냅니다.
  $.ajax({
    url: `/replies/deleteComment/${freeBoardCommentId}`,
    // HTTP 요청 메서드를 'delete'로 설정하여 DELETE 요청을 보냅니다.
    type: 'delete',
    success: function () {
      if (callback) {
        callback();
      }
    },
    error: function (a, b, c) {
      console.error(c);
    }
  });
}

// 댓글 목록을 보여주는 함수 정의
function showReplyList(freeBoardId) {
  // 댓글 목록을 비동기로 받아오기
  $.ajax({
    url: `/replies/readComment/${freeBoardId}`,
    type: 'get',
    dataType: 'json',
    success: function (result) {
      console.log(result)
      const text = freeBoardCommentList(result);
      $('.reply-list').html(text);

    },
    error: function (a, b, c) {
      console.error(c);
    }
  });
}

// 댓글 목록 HTML을 생성하는 함수
function freeBoardCommentList(result) {
  let text = '';

  result.forEach(r => {
    text += `
      <div class="reply" >
        <div class="id-and-date">
          <div class="reply-info">
            <div class="reply-img"><img src="/img/dogImg02.jpg" alt=""></div>
            <div class="reply-id">${r.userId}</div>
          </div>
          <div class="reply-date">${r.freeBoardCommentMd ? timeForToday(r.freeBoardCommentMd) : timeForToday(r.freeBoardCommentRd)}</div>
        </div>
        <div class="reply-content-n-btns">
          <div class="reply-content">${r.freeBoardCommentContent}</div>`;

    if (r.userId == loginNumber) {
      text += `
        <div class="reply-btns__box ">
          <button type="button" class="reply-modify-btn" data-num="${r.id}" >수정</button>
          <button type="button" class="reply-remove-btn" data-num="${r.id}" >삭제</button>
        </div>`;
    }

    text += `
        </div>
      </div>
    </div>`;
  });

  return text;
}

// 댓글 목록에서 댓글 버튼(.reply-btns)이 클릭되었을 때의 이벤트 핸들러
$('.reply-list').on('click', '.reply-btns', function () {
  // 클릭된 댓글 버튼의 부모 요소인 .reply-btn-box에서 .reply-btns__box를 찾아 저장
  let $replyBtnBox = $(this).closest('.reply-btn-box').find('.reply-btns__box');

  // 현재 화면에 있는 모든 .reply-btns__box에 'none' 클래스 추가 (숨김)
  $('.reply-btns__box').addClass('none');

  // 저장된 .reply-btns__box에 'none' 클래스를 토글 (숨김/보임 상태 전환)
  $replyBtnBox.toggleClass('none');
});

// 리플 삭제 버튼 처리
$('.reply-list').on('click', '.reply-remove-btn', function () {
  let freeBoardCommentId = $(this).closest('.reply').find('.reply-remove-btn').data('num');
  console.log(freeBoardCommentId)
  remove(freeBoardCommentId, function (){
    showReplyList(freeBoardId);
  });
});

// 리플 수정 버튼 처리
$('.reply-list').on('click', '.reply-modify-btn', function () {
  let $content = $(this).closest('.reply').find('.reply-content');

  $content.replaceWith(`
  <div class='modify-box'>
    <textarea class='modify-content'>${$content.text()}</textarea>
    <button type='button' class='modify-content-btn'>수정완료</button>
  </div>
  `);
  $('.reply-btns__box').addClass('none');
});

// 리플 수정 완료 처리
$('.reply-list').on('click', '.modify-content-btn', function () {
  console.log('modify!!!');
  let freeBoardCommentId = $(this).closest('.reply').find('.reply-modify-btn').data('num');
  console.log(freeBoardCommentId);

  let freeBoardCommentContent = $(this).closest('.modify-box').find('.modify-content').val();
  console.log(freeBoardCommentContent);

  let replyObj = {
    freeBoardCommentContent : freeBoardCommentContent,
    id : freeBoardCommentId
  };
  $('.reply-btns__box').removeClass('none');

  modify(freeBoardCommentId, replyObj, function (){
    showReplyList(freeBoardId);
  });
});

// 댓글 시간
export function timeForToday(value){
  const today = new Date(); //현재 날짜와 시간을 가진 객체
  const timeValue = new Date(value);

  // getTime() 1970년 1/1일을 기준으로 지금까지 몇 ms가 지났는지 알려준다.
  //Math.floor() 는 소수점을 버림 처리 해준다.
  const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);

  if(betweenTime < 1) { return "방금 전"; }

  if(betweenTime < 60) { return `${betweenTime}분 전`; }

  const betweenTimeHour = Math.floor(betweenTime/60);
  if(betweenTimeHour < 24) { return `${betweenTimeHour}시간 전`; }

  const betweenTimeDay = Math.floor(betweenTimeHour/ 24);
  if(betweenTimeDay < 365) { return `${betweenTimeDay}일 전`; }

  return `${Math.floor(betweenTimeDay / 365)}년 전`;
}