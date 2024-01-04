import * as list from './module/list.js';
import * as page from './module/page.js';


$(document).ready(function (){
    console.log("리스트")
    let userId = $('.qnamain').data('userid');
    console.log(userId);
    list.list(0,userId,'mypgs','myfreeBoardList',showUserFreeboardList);


})


function showUserFreeboardList(result) {
    let text = '';
    let textInput = $('.list-contents-box');


    console.log(result.length);
    if (result.content.length === 0) {
        console.log("값이 없다")
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

        $('.nonepage').css('display','block');
    }else{
        console.log("값이 있다.")
        result.content.forEach(r => {

            text += ` <div class="list-content" th:value="${r.id}">
                        <div class="content-text-box">
                            <div class="list-content-title">${r.freeBoardTitle}</div>
                            <div class="list-content-content">
                                <div class="list-content-content-detail">
                                    ${r.freeBoardContent}
                                </div> 
                            </div>
                        `;
                    if(r.userNickName == null){


                    text +=`<div class="list-content-etc">
                                <div class="list-content-id">
                                    <div class="list-content-id-img"><img src="/mypg/img/b556fdf429d8de25c3acf62f8186ddb9.png" alt=""></div>
                                    <span>${r.userAccount}</span>
                                </div>
                                <div class="list-content-reply">
                                    <span>댓글</span>
                                    <span class="reply-count">${r.freeBoardCommentCount}</span>
                                </div>
                              
                            </div>
                            `;
                            }else{
                        text +=`        <div class="list-content-etc">
                                <div class="list-content-id">
                                    <div class="list-content-id-img"><img src="/mypg/img/b556fdf429d8de25c3acf62f8186ddb9.png" alt=""></div>
                                    <span>${r.userNickName}</span>
                                </div>
                                <div class="list-content-reply">
                                    <span>댓글</span>
                                    <span class="reply-count">${r.freeBoardCommentCount}</span>
                                </div>
                              
                            </div>
                            `;
                    }

                     text+=`</div>
                        <div class="content-img-box">
                            <div class="content-img">
                                <img src="/mypg/img/강아지.png" alt="">
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
