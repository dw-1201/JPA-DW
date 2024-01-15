// 검색어 입력 이벤트 감지
import * as list from './module/list.js'
import * as page from './module/page.js';

// 페이지에 리스트 뿌려주는 스크립트
$(document).ready(function (){
    console.log("시작")
    list.list(0,searchFreeBoardForm(),'communities','freeBoardList',showFreeBoardList);
    page.enterKey('.search-freeBoard','.search-btn');
    // keyword = $('#freeBoard-search-keyword').val(); // 전역 변수에 할당
    // freeBoardList(0, keyword);
});
// 검색버튼
$('.ddd').on('click', function (){
    list.list(0,searchFreeBoardForm(),'communities','freeBoardList',showFreeBoardList);
    // keyword = $('#freeBoard-search-keyword').val(); // 전역 변수에 할당
    // freeBoardList(0, keyword);
});

//input에서 검색한 내용 넘겨주기
function searchFreeBoardForm(){
    let keyword = $('.search-freeBoard').val();
    console.log(keyword);
    return {
        keyword : keyword
    };
}

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
<!--                    <input type="hidden" value="${r.id}" name="freeBoardId">-->
                    <div class="list-content-title">${r.freeBoardTitle}</div>
                    <div class="list-content-content">${r.freeBoardContent}</div>
                    <div class="list-content-etc">
                        <div class="list-content-id">
                            <div class="list-content-id-img"><img src="/img/dogImg.jpg" alt=""></div>
                            <span>${r.userAccount}</span>
                        </div>
                        <div class="list-content-reply">
                            <span> 조회수 ${r.freeBoardViewCount} </span>
                            <span class="reply-count"> (댓글 ${r.freeBoardCommentCount}) </span>
                        </div>
                        <div class="list-content-time">
                            <span>${timenow}</span>
                        </div>
                    </div>
                </div>
            `;

        // if (r.freeBoardImgDtoList && r.freeBoardImgDtoList.length > 0) {
            r.freeBoardImgDtoList.slice(0, 1).forEach(s => {
                text += `
            <div class="content-img-box">
                <div class="content-img">
                    <img src="/communities/freeImg?fileFullPath=${s.freeBoardImgRoute + '/' + s.freeBoardImgUuid + '_' + s.freeBoardImgName}" alt="">
                </div>
            </div>
        `;
            });
        // }

        text += `
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
        list.list(page,searchFreeBoardForm(),'communities','freeBoardList',showFreeBoardList);
    });
    console.log("list!");
}

//자유게시판 리스트
// function showFreeBoardList(result) {
//     let text = '';
//     let textInput = $('.list-contents-box');
//
//     result.forEach(r => {
//         text += createFreeBoardListItem(r);
//     });
//     textInput.html(text);
// }
// 리스트 아이템 생성 함수 만들기
// function createFreeBoardListItem(r) {
//     const postTime = new Date(r.freeBoardRd);
//     const timeAgo = getTimeAgo(postTime);
//
//     const modifiedTime = new Date(r.freeBoardMd);
//     const modifiedTimeAgo = getTimeAgo(modifiedTime);
//
//     let listItem = `
//         <a href="/community/freeBoardDetail/${r.id}">
//             <div class="list-content">
//                 <div class="content-text-box">
//                     <input type="hidden" value="${r.id}" name="freeBoardId">
//                     <div class="list-content-title">${r.freeBoardTitle}</div>
//                     <div class="list-content-content">${r.freeBoardContent}</div>
//                     <div class="list-content-etc">
//                         <div class="list-content-id">
//                             <div class="list-content-id-img"><img src="/img/dogImg.jpg" alt=""></div>
//                             <span>${r.userAccount}</span>
//                         </div>
//                         <div class="list-content-reply">
//                             <span> 조회수 ${r.freeBoardViewCount} </span>
//                             <span class="reply-count"> (댓글 ${r.freeBoardCommentCount}) </span>
//                         </div>
//                         <div class="list-content-time">
//                             ${r.freeBoardMd ? `<span>${modifiedTimeAgo}</span>` : `<span>${timeAgo}</span>`}
//                         </div>
//                     </div>
//                 </div>
//             `;
//
//
//     if (r.freeBoardImgDtoList && r.freeBoardImgDtoList.length > 0) {
//         r.freeBoardImgDtoList.slice(0, 1).forEach(s => {
//             listItem += `
//             <div class="content-img-box">
//                 <div class="content-img">
//                     <img src="/community/freeImg?fileFullPath=${s.freeBoardImgRoute + '/' + s.freeBoardImgUuid + '_' + s.freeBoardImgName}" alt="">
//                 </div>
//             </div>
//         `;
//         });
//     }
//
//     listItem += `
//     </a>
//     `;
//
//     return listItem;
//
//     let paginations = $('.pagination-ul');
//
//     page.pagination(r,paginations)
//     paginations.find('a').on('click', function (e) {
//         e.preventDefault();
//         const page = parseInt($(this).data('page'));
//         list.list(page,searchFreeBoardForm(),'communities','freeBoardList',showFreeBoardList);
//     });
//     console.log("list!");
// }

// 시간 차이 계산 및 출력할 시간 설정 함수
// function getTimeAgo(postTime) {
//     const currentTime = new Date();
//     const timeDifference = currentTime - postTime;
//     const seconds = Math.floor(timeDifference / 1000);
//     const minutes = Math.floor(seconds / 60);
//     const hours = Math.floor(minutes / 60);
//     const days = Math.floor(hours / 24);
//     const months = Math.floor(days / 30);
//     const years = Math.floor(months / 12);
//
//     let timeAgo;
//     if (seconds < 60) {
//         timeAgo = `${seconds}초 전`;
//     } else if (minutes < 60) {
//         timeAgo = `${minutes}분 전`;
//     } else if (hours < 24) {
//         timeAgo = `${hours}시간 전`;
//     } else if (days < 30) {
//         timeAgo = `${days}일 전`;
//     } else if (months < 12) {
//         timeAgo = `${months}달 전`;
//     } else {
//         timeAgo = `${years}년 전`;
//     }
//     return timeAgo;
// }
// let keyword; // 전역 변수로 변경
// $('#freeBoard-search-keyword').on('input', function() {
//     keyword = $(this).val();
// });
// 엔터 키 입력 시 검색 실행
// $('#freeBoard-search-keyword').on('keyup', function(event) {
//     if (event.key === 'Enter') {
//         freeBoardList(0, keyword);
//     }
// });
// function freeBoardList(page, keyword, callback){
//     $.ajax({
//         url:`/communities/freeBoardList/${page}`,
//         type:'get',
//         data: { keyword: keyword,
//         }, // 데이터 전달 수정
//         dataType:'json',
//         success: function(result) {
//             console.log(result.pageable);
//             console.log(result.number);
//             console.log(result.content);
//             console.log(result.commentCount);
//             showFreeBoardList(result.content);
//             pagination(result);
//         },
//         error: function(a, b, c) {
//             console.error(c);
//         }
//     });
// }
// function pagination(result, paginations) {
//     paginations.empty();
//
//     const totalPages = result.totalPages;
//     const currentPage = result.number;
//
//     if (totalPages > 0) {
//         const maxButtons = 5;
//         let startPage = Math.max(0, currentPage - Math.floor(maxButtons / 2));
//         let endPage = Math.min(totalPages - 1, startPage + maxButtons - 1);
//
//         if (totalPages <= maxButtons) {
//             startPage = 0;
//             endPage = totalPages - 1;
//         } else if (endPage - startPage < maxButtons - 1) {
//             startPage = Math.max(0, totalPages - maxButtons);
//         }
//         //화살표 <
//         if (currentPage > 0) {
//             paginations.append(`<li><a href="#" data-page="${currentPage - 1}">&lt;</a></li>`);
//         }else{
//             paginations.append(`<li></li>`)
//         }
//
//         //페이징 버튼
//         for (let i = startPage; i <= endPage; i++) {
//             if(i==currentPage){
//                 paginations.append(`<li><a href="#" class="active-btn" data-page="${i}">${i + 1}</a></li>`);
//
//             }else{
//                 paginations.append(`<li><a href="#" data-page="${i}">${i + 1}</a></li>`);
//
//             }
//         }
//         //화살표 >
//         if (currentPage < totalPages - 1) {
//             paginations.append(`<li><a href="#" data-page="${currentPage + 1}">&gt;</a></li>`);
//         }else{
//             paginations.append(`<li></li>`)
//         }
//     }
// }

// function pagination(result) {
//     let paginations = $('.pagination-ul');
//     paginations.empty();
//
//     const totalPages = result.totalPages;
//     const currentPage = result.number;
//
//     if (totalPages > 0) {
//         const maxButtons = 5;
//         let startPage = Math.max(0, currentPage - Math.floor(maxButtons / 2));
//         let endPage = Math.min(totalPages - 1, startPage + maxButtons - 1);
//
//         if (totalPages <= maxButtons) {
//             startPage = 0;
//             endPage = totalPages - 1;
//         } else if (endPage - startPage < maxButtons - 1) {
//             startPage = Math.max(0, totalPages - maxButtons);
//         }
//
//         if (currentPage > 0) {
//             paginations.append(`<li><a href="#" data-page="${currentPage - 1}">&lt;</a></li>`);
//         }
//
//         for (let i = startPage; i <= endPage; i++) {
//             paginations.append(`<li><a href="#" data-page="${i}">${i + 1}</a></li>`);
//         }
//
//         if (currentPage < totalPages - 1) {
//             paginations.append(`<li><a href="#" data-page="${currentPage + 1}">&gt;</a></li>`);
//         }
//     }
//
//     paginations.find('a').on('click', function (e) {
//         e.preventDefault();
//         const page = parseInt($(this).data('page'));
//         freeBoardList(page, searchFreeBoardForm());
//     });
// }


// 자유게시판 게시글 조회
// $(function() {
//     $("#freeBoard-search-keyword").keypress(function(e){
//         //검색어 입력 후 엔터키 입력하면 조회버튼 클릭
//         if(e.keyCode && e.keyCode == 13){
//             $(".result-btn").trigger("click");
//             return false;
//         }
//         //엔터키 막기
//         if(e.keyCode && e.keyCode == 13){
//             e.preventDefault();
//         }
//     });
// });

// 정렬 라디오 버튼에 이벤트 추가
// $('.input-radio').on('change', function() {
//     const sort = $(this).val();
//     keyword = $('#freeBoard-search-keyword').val();
//     freeBoardList(0, keyword, sort);
// });
//
// // 초기 로딩 시 최신순으로 데이터 가져오기
// $(document).ready(function() {
//     keyword = $('#freeBoard-search-keyword').val();
//     const sort = 'recent'; // 기본 정렬 기준
//     freeBoardList(0, keyword, sort);
// });





