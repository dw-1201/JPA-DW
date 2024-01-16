import * as page from './module/pagination.js';
import * as form from './module/form.js';
import * as list from './module/list.js';





$(document).ready(function (){

    list.list(0, searchForm(), 'admins', 'freeBoardList',inputList);

    $('.result-free-submit-btn').on('click', function (){

        list.list(0, searchForm(), 'admins', 'freeBoardList',inputList);
    })


})





function searchForm(){

    let cate = $('#free-search-cate').val();
    let keyword = $('#free-search-keyword').val();


    return {

        cate : cate,
        keyword : keyword

    }
}


function inputList(result){

    let text = '';
    let inputTextSection = $('.admin-free-lists');
    let paginations = $('.pagination-ul');


    result.content.forEach(r=>{

        text+=`
        
                <div class="admin-free-list-table rr">
                        <div class="notie-number row">${r.freeBoardId}</div>
                        <div class="free-id row">${r.userAccount}</div>
                        <div class="free-title row">${r.freeBoardTitle}</div>
                        <div class="free-reg-date row">${form.formatDates(r.freeBoardRd)}</div>
                        <div class="free-view-count row">${r.viewCount}</div>
                        <div class="free-etc btns row">
                            <a href="/admin/freeBoardDetail/${r.freeBoardId}" class="detail-btn">상세</a>
                        </div>
                    </div>
        `



    })

    inputTextSection.html(text);
    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.list(page, searchForm(), 'admins', 'freeBoardList', inputList)
    });

}

