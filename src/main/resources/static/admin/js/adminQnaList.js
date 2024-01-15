import * as list from './module/list.js';
import * as page from './module/pagination.js';
import * as form from './module/form.js';


$(document).ready(function (){

    list.list(0, searchForm(), 'admins', 'qnaList', inputList)



    $('.result-qna-submit-btn').on('click', function (){

        list.list(0, searchForm(), 'admins', 'qnaList', inputList)
    })

})



function searchForm(){

    let cate = $('#qna-search-cate').val();
    let keyword = $('#qna-search-keyword').val();


    return {

        cate : cate,
        keyword : keyword

    }
}


function inputList(result){

    let text = '';
    let inputTextSection = $('.admin-qna-lists');
    let paginations = $('.pagination-ul');

    result.content.forEach(r=>{


        text += `
                    <div class="admin-qna-list-table rr">
                        <div class="notie-number row">${r.qnaBoardId}</div>
                        <div class="qna-id row">${r.userAccount}</div>
                        <div class="qna-title row">${r.qnaBoardTitle}</div>
                        <div class="qna-reg-date row">${form.formatDates(r.qnaBoardRd)}</div>
                        <div class="qna-view-count row">${r.viewCount}</div>
                        <div class="qna-etc btns row">
                            <a href="/admin/questionDetail/${r.qnaBoardId}" class="detail-btn">상세</a>
                        </div>
                    </div>
        
        
        `

    })

    inputTextSection.html(text);

    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.list(page, searchForm(), 'admins', 'qnaList', inputList)
    });
}