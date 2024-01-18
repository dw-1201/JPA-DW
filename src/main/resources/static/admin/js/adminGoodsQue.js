import  * as page from './module/pagination.js';
import * as form from './module/form.js';


//문의 상세 페이지 이동
$('.qna-list').on('click','.detail-btn', function(){

    let qnaId = $(this).data('qnaid')
    console.log(qnaId);

    window.location.href="/admin/qnaDetail/" + qnaId;
})


$(document).ready(function (){
    //첫로드 화면
    getGoodsQue(0, '',  searchQnaForm(),qnaList);

    $("input[name='reply']").on('change', function () {
        let qnaState = $(this).val();
        updateBasedOnState(qnaState);
    });

    $('.result-submit-btn').on('click', function() {
        let qnaState = $("input[name='reply']:checked").val();
        $(this).data('clicked', true);
        updateBasedOnState(qnaState);
    });
});


//회원 상태에 따라 리스트 불러오는 함수
function updateBasedOnState(qnaState) {
    getGoodsQue(0, qnaState,  searchQnaForm(),qnaList);
}

function searchQnaForm(){
    let cate = $('#search-cate').val();
    let keyword = $('#search-keyword').val();

    if(cate ==='전체보기'){
        cate = '';
    }

    return {
        cate : cate,
        keyword : keyword
    };
}






function getGoodsQue(page, qnaState, searchQnaForm ,callback){

    $.ajax({

        url:`/admins/goodsQnaList/${page}`,
        type: 'get',
        data : {
            qnaState : qnaState,
            cate : searchQnaForm.cate,
            keyword: searchQnaForm.keyword
        },
        dataType:'json',
        success : function (result){
            console.log(result)
            if(callback){
                callback(result)
            }

        }

    })

}


function qnaList(result){

    let text = '';
    let inputSection = $('.qna-list');


    result.content.forEach(r=> {
        text += `
        
                     <tr>
                        <td>${r.id}</td>
                        <td>${r.goodsId}</td>
                        <td>${r.goodsCategory}</td>
                        <td class="q-content">${r.qnaContent}</td>
                        <td>${form.formatDates(r.qnaRd)}</td>
                        `;
        if(r.state == 0){
            text += `   <td> X </td>
                    `;
        }else {
            text += `<td> O </td>
                    `;
        }

        text +=`
                        <td class="list-btns">
                            <button type="button" class="detail-btn btn" data-qnaid="${r.id}">상세보기</button>
                        </td>
                    </tr>
        `;


    })

    inputSection.html(text);
    let paginations = $('.pagination-ul');
    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        getGoodsQue(page, $("input[name='reply']:checked").val(), searchQnaForm(),qnaList);

    });

}


