// 검색어 입력 이벤트 감지
import * as list from './module/list.js'
import * as page from './module/page.js';

// 검색버튼
$('.search-btn').on('click', function (){
    list.listSearchDto(0,searchFreeBoardForm(),'communities','freeBoardList',showFreeBoardList);
});

// 페이지에 리스트 뿌려주는 스크립트
$(document).ready(function (){
    console.log("시작")
    list.listSearchDto(0,searchFreeBoardForm(),'communities','freeBoardList',showFreeBoardList);
    page.enterKey('.search-freeBoard','.search-btn');

    //라디오 버튼 변경시 동적으로 조회
    $("input[name='freeBoard_radio']").on('change',function(){
        let cate = $(this).val();
        freeBoardRadio(cate);
    })
});
//자유게시판 라디오 버튼 처리
function freeBoardRadio(cate){
    //cate 속성에 선택된 카테고리 값을 설정합니다.
    searchFreeBoardForm().cate = cate;
    // list.listSearchDto 함수를 호출, (페이지 0초기화, 검색 폼 객체, 컨트롤러명, 액션명, 콜백)
    // 자유게시판 목록을 가져오고 화면에 표시
    list.listSearchDto(0,searchFreeBoardForm(),'communities','freeBoardList',showFreeBoardList);
}

//input에서 검색한 내용 넘겨주기
function searchFreeBoardForm(){
    let cate = $("input[name='freeBoard_radio']:checked").val();
    let keyword = $('.search-freeBoard').val();
    console.log(cate);
    return {
        cate : cate,
        keyword : keyword
    };
}

/**
 * 자유게시판 비동기 리스트
 * 시간, 페이징
 */
function showFreeBoardList(result) {
    let text = '';
    let textInput = $('.list-contents-box');
    console.log("list")

    result.content.forEach(r => {
        let nowTime = new Date();
        let rdTime = new Date(r.freeBoardRd);
        let time = nowTime-rdTime;
        let timedi = Math.floor(time/(1000*60));
        let timenow = "";
        if(timedi <60){
            timenow = timedi +"분 전"
        }else{
            let ttdi = Math.floor(timedi/ 60);
            if(ttdi < 24){
                timenow = ttdi +"시간 전"
            }else {
                let ddi = Math.floor(ttdi / 24);
                timenow = ddi + "일 전";
            }
        }
        text += `
        <a href="/community/freeBoardDetail/${r.id}">
            <div class="list-content">
                <div class="content-text-box">
                    <div class="list-content-title">${r.freeBoardTitle}</div>
                    <div class="list-content-content"><p>${r.freeBoardContent}</p></div>
                    <div class="list-content-etc">
                        <div class="list-content-id">
                            <div class="list-content-id-img"><img src="/img/dogImg.jpg" alt=""></div>
                            <span>${r.userAccount}</span>
                        </div>
                        <div class="list-content-reply">
                            <span> 조회수 ${r.freeBoardViewCount} </span>
                            <span class="reply-count"> (댓글 ${r.commentCount}) </span>
                        </div>
                        <div class="list-content-time">
                            <span>${timenow}</span>
                        </div>
                    </div>
                </div>
            `;
            r.freeBoardImgDtoList.slice(0, 1).forEach(s => {
                text += `
            <div class="content-img-box">
                <div class="content-img">
                    <img src="/communities/freeImg?fileFullPath=${s.freeBoardImgRoute + '/' + s.freeBoardImgUuid + '_' + s.freeBoardImgName}" alt="">
                </div>
            </div>
        `;
    })
    text += `
                </div>
            </a>
        `;
    })

    console.log($('.userAccount').text());
    textInput.html(text);

    let paginations = $('.pagination-ul');

    page.pagination(result,paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.listSearchDto(page,searchFreeBoardForm(),'communities','freeBoardList',showFreeBoardList);
    });
    console.log("list!");
}
//자유게시판 인기글 top3
//날짜 포맷 변경
function formatDates(dateString) {
let dateObj = new Date(dateString);
let formattedDate =
dateObj.getFullYear() +
'-' +
('0' + (dateObj.getMonth() + 1)).slice(-2) +
'-' +
('0' + dateObj.getDate()).slice(-2) +
' ' +
('0' + dateObj.getHours()).slice(-2) +
':' +
('0' + dateObj.getMinutes()).slice(-2);
return formattedDate;
}
//날짜 요소 선택
let dateElements = $('.best-content-date');
// 각 날짜 요소에 대해 처리
dateElements.each(function (index, element) {
    // .info-date .best-content-date 요소 찾기
    let originalDate = $(element).closest('.best-container-content').find('.info-date .best-content-date').text();
    // 날짜 포맷 변경
    let formattedDate = formatDates(originalDate);
    // 변경된 형식으로 날짜를 설정
    $(element).text(formattedDate);
});

