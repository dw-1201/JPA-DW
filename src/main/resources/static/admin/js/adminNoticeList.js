import * as list from './module/list.js';
import  * as page from './module/pagination.js';


//공지게시판
//마우스 클릭 효과
$(document).ready(function(){
    $('.lists').on('click', 'rr',function(){

        let $currentSection = $(this).children('.row')
        $currentSection.toggleClass('active');


        $(this).parent().siblings().find('.row').removeClass('active');

    })
})



$(document).ready(function (){

    //faq등록
    $('.notice-faq-btn').on('click',function(){
        window.location.href="/admin/faqWrite";
    })

    //faq삭제
    $('.faq-list').on('click','.faq-delete-btn',function(){

        let faqBoardId = $('.faq-delete-btn').data('faqnum')

        if(confirm("삭제하시겠습니까?")){
            window.location.href="/admin/faqDelete/" + faqBoardId ;
        }

    })


    //공지사항 등록
    $('.notice-reg-btn').on('click',function(){
        window.location.href="/admin/noticeWrite";
    })

    //공지사항 삭제
    $('.notice-list').on('click','.notice-delete-btn',function(){
        let noticeBoardId = $(this).data('noticenum');

        if(confirm("삭제하시겠습니까?")){
            window.location.href="/admin/noticeDelete/" +noticeBoardId;
        }
    })


    //리스트 뿌리기
    list.list(0, searchFaqForm(), 'admins','faqList', showFaqList)
    list.list(0, searchNoticeForm(),'admins', 'noticeList', showNoticeList)

    //슬라이딩효과
    list.sliding('.admin-faq-list-container', '.faq-content');
    list.sliding('.admin-notice-list-container', '.notice-content');

    //검색창 엔터키 반응
    page.enterKey('#faq-search-keyword','.result-faq-submit-btn');
    page.enterKey('#notice-search-keyword','.result-notice-submit-btn');
})


//input에서 받은 결과를 넘긴다.
function searchFaqForm(){
    let cate = $('#faq-search-cate').val();
    let keyword = $('#faq-search-keyword').val();


    return {
        cate : cate,
        keyword : keyword
    };
}

function searchNoticeForm(){
    let cate = $('#notice-search-cate').val();
    let keyword = $('#notice-search-keyword').val();


    return {
        cate : cate,
        keyword : keyword
    };
}

//검색결과
$('.result-faq-submit-btn').on('click', function (){
    list.list(0, searchFaqForm(), 'admins','faqList', showFaqList)

})

$('.result-notice-submit-btn').on('click', function (){
    list.list(0, searchNoticeForm(),'admins', 'noticeList', showNoticeList)

})



function showFaqList(result){

    let text ='';
    let textInput = $('.faq-list');

    result.content.forEach(r=>{

        text+= `
            <div class="admin-notice-lists admin-faq-lists">
                    <div class="admin-notice-list-table rr">
                        <div class="notice-number row">${r.id}</div>
                        <div class="notice-title row">${r.faqBoardTitle}</div>
                        <div class="notice-reg-date row">${r.faqBoardRd}</div>
                        `;
        if(r.faqBoardMd != r.faqBoardRd){
            text+=`        <div class="notice-reg-date row">${r.faqBoardMd}</div>`;

            }else {
            text+=`        <div class="notice-reg-date row"> - </div>`;

            }
            text+=`       
                <div class="notice-view-count row">${r.faqBoardViewCount}</div>
                        
                    </div>
                        <section class="notice-content">
                            <p>${r.faqBoardContent}</p>
                            <div class="notice-etc">
                                <a href="/admin/faqModifyPage/${r.id}"><button class="faq-modify-btn btns" type="button" data-faqnum="${r.id}">수정</button></a>
                                <button class="faq-delete-btn btns" type="button" data-faqnum="${r.id}">삭제</button>
                            </div>
                        </section>
                 </div>
            
        
        `;

    })

    textInput.html(text);

    let paginations = $('.faq-pagination-ul');
    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.list(page, searchFaqForm(), 'admins','faqList', showFaqList);
    });
}



function showNoticeList(result){

    let text ='';
    let textInput = $('.notice-list');

    result.content.forEach(r=>{

        text+= `
            <div class="admin-notice-lists admin-faq-lists">
                    <div class="admin-notice-list-table rr">
                        <div class="notice-number row">${r.id}</div>
                        <div class="notice-title row">${r.noticeBoardTitle}</div>
                        <div class="notice-reg-date row">${r.noticeBoardRd}</div>
                        `;
        if(r.noticeBoardMd != r.noticeBoardRd){
            text+=`        <div class="notice-reg-date row">${r.noticeBoardMd}</div>`;

        }else {
            text+=`        <div class="notice-reg-date row"> - </div>`;

        }
        text+=`       
                <div class="notice-view-count row">${r.noticeBoardViewCount}</div>
                        
                    </div>
                        <section class="notice-content faq-content">
                            <p>${r.noticeBoardContent}</p>
                            <div class="notice-etc">
                                <a href="/admin/noticeModifyPage/${r.id}"><button class="notice-modify-btn btns" type="button" data-faqnum="${r.id}">수정</button></a>
                                <button class="notice-delete-btn btns" type="button" data-noticenum="${r.id}">삭제</button>
                            </div>
                        </section>
                 </div>
            
        
        `;

    })

    textInput.html(text);

    let paginations = $('.notice-pagination-ul');
    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.list(page, searchNoticeForm(), 'admins','noticeList', showNoticeList);
    });
}




