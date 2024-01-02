import * as pp from './module/pagination.js'


//상품 수정 페이지 이동
$('.modify-btn').on('click', function(){

    let goodsId = $(this).data('goodsid')

    window.location.href="/admin/modify/" + goodsId;
})

//상품 삭제
$('.delete-btn').on('click', function (){

    let goodsId = $(this).data('goodsid')

    if(confirm("상품을 삭제하시겠습니까?")){
        window.location.href="/admin/delete/" + goodsId;

    }

})





$(document).ready(function(){



    $('.goods-related-info-title').on('click', function(){

        let add = $('.goods-related-q-container');
        add.stop().slideToggle(400);

    })
    $('.goods-related-review-title').on('click', function(){

        let add = $('.goods-related-review-container');
        add.stop().slideToggle(400);

    })

    let goodsId = $('#goodsId').val();

    //상품 관련 문의사항 리스트
    getGoodsRelatedQna(0, '',goodsId);


    $("input[name='reply-state']").on('change', function (){

        let state = $(this).val();
        changeStateValue(state, goodsId);
    })



})

function changeStateValue(state, goodsId){
    getGoodsRelatedQna(0, state, goodsId);

}


//상품 관련 문의사항 리스트
function getGoodsRelatedQna(page, state, goodsId){

    $.ajax({

        url:`/admins/goodsRelatedQna/${goodsId}/${page}`,
        type:'get',
        data : {
          state : state
        },
        dataType:'json',
        success : function (result){

            let text = '';
            let inputTextSection = $('.goods-related-qna-list');

            result.content.forEach(r=>{
            text += `
                <tr >
                    <td > ${r.id}</td>
                    <td class="q-content">${r.qnaContent}</td>
                    <td>${r.qnaRd}</td>
                    <td id="reply-td">`
                if(r.state == 1){
                    text += `
                        <button type="button" class="reply-complete reply-btn"><a href="/admin/qnaDetail/${r.id}">답변완료</a></button>
`
                }else {
                    text += `
                        <button type="button" class="reply-need reply-btn"><a href="/admin/qnaDetail/${r.id}">답변하기</a></button>

                    `
                }
                text +=`
                    </td>
                </tr>
                `;
            })

            inputTextSection.html(text);

            let paginations = $('.goods-related-qna-pagination');

            pp.pagination(result, paginations)
            paginations.find('a').on('click', function (e) {
                e.preventDefault();
                const page = parseInt($(this).data('page'));
                getGoodsRelatedQna(page, $("input[name='reply-state']:checked").val(), goodsId);
            });


        },error : function (a,b,c){
            console.error(c)
        }
    })
}
goodsDetail()

function goodsDetail(){
    let goodsId = $('#goodsId').val();


    $.ajax({

        url : `/admins/detail/${goodsId}`,
        type:'get',
        dataType:'json',
        success : function (result){
            console.log(result)
        }
    })

}