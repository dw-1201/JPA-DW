import * as list from './module/list.js';
import * as page from './module/page.js';

$(document).ready(function (){
    console.log("리스트")
    let userId = $('.qnamain').data('userid');
    console.log(userId);
    list.list(0,userId,'mypgs','myWriteList',showUserQnAList);


})

function showUserQnAList(result) {
    let text = '';
    let textInput = $('.list-contents-box');



    if (result == null) {
        text = `<div className="nonepage">
            <div className="none-img-area">
                <div className="none-img">
                    <img src="../img/b556fdf429d8de25c3acf62f8186ddb9.png"/>
                </div>
            </div>
            <div className="nonetext-area">
                <p>등록된 내용이 없습니다.</p>
            </div>
        </div>
        `;
    }else{
        result.content.forEach(r => {

            text += `<div class="list-content" th:value="${r.id}">
                        <div class="list-content-title">${r.questionTitle}</div>
                        <div class="list-content-content">
                            <div  class="list-content-content-detail">
                                ${r.questionContent}
                            </div>
                        </div>     <!-- 차후 확인하여 아디값을로 할지 닉네임으로 할지 확인후 조정
                        if(r.usernicknamee == null ){
                        text += <div class="list-content-etc">
                            <div class="list-content-id">
                                <div class="list-content-id-img"><img src="/img/dogImg.jpg" alt=""></div>
                                <span>${r.userAccount}</span>
                            </div>
                            <div class="list-content-reply">
                                <span>댓글</span>
                                <span class="reply-count">${r.commentCount}</span>
                            </div>
                        </div>}else{ text += <div class="list-content-etc">
                            <div class="list-content-id">
                                <div class="list-content-id-img"><img src="/img/dogImg.jpg" alt=""></div>
                                <span>${r.userNickName}</span>
                            </div>
                            <div class="list-content-reply">
                                <span>댓글</span>
                                <span class="reply-count">${r.commentCount}</span>
                            </div>
                        </div>
                        } }-->
                        <div class="list-content-etc">
                            <div class="list-content-id">
                                <div class="list-content-id-img"><img src="/img/dogImg.jpg" alt=""></div>
                                <span>${r.userName}</span>
                            </div>
                            <div class="list-content-reply">
                                <span>댓글</span>
                                <span class="reply-count">${r.commentCount}</span>
                            </div>
                        </div>
                    </div>
        `;
        })

    }
    console.log(text);
    textInput.html(text);

    let paginations = $('.list-pagestion');
    console.log("페이징 실행!")
    page.pagination(result,paginations)
    console.log("페이징 미실행!")
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        let userId = $('.qnamain').data('userid');
        const page = parseInt($(this).data('page'));
        list.list(page, userId,'mypgs','myWriteList', showUserQnAList);
    });
    console.log("list~")


}



