import * as list from './module/list.js'
import  * as page from './module/page.js';



// 페이지에 리스트 뿌려주는 스크립트

$(document).ready(function (){
    console.log("들어왔다")

    list.list(0,searchQnaBoardForm(),'qnar','qnalist',showQnaBoardList);

    page.enterKey('.search-question','.search-btn');
})

// 검색버튼
$('.sbtn').on('click',function (){
    list.list(0,searchQnaBoardForm(),'qnar','qnalist',showQnaBoardList);

})


//input에서 검색한 내용 넘겨주기
function searchQnaBoardForm(){
    let keyword = $('.search-question').val();
    console.log(keyword);
    return {
        keyword : keyword
    };
}


function showQnaBoardList(result) {
    let text = '';
    let textInput = $('.list-contents-box');
    console.log("list")
    result.content.forEach(r => {
        text += `
                <a href="/qna/qnaDetail?qnaId=${r.id}" class="qnadetailbtn">
                        <div class="list-content">
                            <div class="list-content-title">${r.questionTitle}
                            </div>
                            <div class="list-content-content">${r.questionContent}
                            </div>
                            <div class="list-content-etc">
                                <div class="list-content-id">
                                    <div class="list-content-id-img"><img src="/img/dogImg.jpg" alt="">
                                    </div>
                                    <span class="userName">${r.userName}</span>
                                </div>
                                <div class="list-content-reply">
                                    <span>댓글</span>
                                    <span class="reply-count">5</span>
                                </div>
                                <div class="list-content-time">
                                    <span>${r.questionRd}</span>
                                </div>
                            </div>
                        </div>
               </a>
            `;


    });
    console.log($('.userName').text());
    textInput.html(text);

    let paginations = $('.list-pagestions');

    page.pagination(result,paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.list(page, searchQnaBoardForm(),'qnar','qnalist', showQnaBoardList);
    });
    console.log("list~")
}




