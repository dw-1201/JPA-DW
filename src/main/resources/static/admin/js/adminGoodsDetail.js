import * as pp from './module/pagination.js'
import * as form from './module/form.js';

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

    //날짜포맷
    $('#goods-reg-date').val(form.formatDates($('.goodsRegDate').val()))
    $('#goods-last-modify-date').val(form.formatDates($('.goodsModDate').val()))

    //숫자포맷
    $('#goods-quantity').val(form.addCommas($('.goodsQuantity').val()))
    $('#goods-price').val(form.addCommas($('.goodPrice').val()))
    $('#goods-sale-count').val(form.addCommas($('.saleCount').val()))
    $('#goods-total-sale').val(form.addCommas($('.totalPrice').val()) + '원')



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
        changeStateValue('qna',state, goodsId);
    })


    //상품 관련 리뷰 리스트
    getGoodsRelatedReview(0, '', goodsId)
    $("input[name='review-state']").on('change', function (){

        let state = $(this).val();
        changeStateValue('review', state,goodsId)
    })

})

function changeStateValue(sectionName,state, goodsId){

    if(sectionName =='qna'){
        getGoodsRelatedQna(0, state, goodsId);

    }else if(sectionName=='review'){
        getGoodsRelatedReview(0, state, goodsId)
    }

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
                    <td>${form.formatDates(r.qnaRd)}</td>
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


function getGoodsRelatedReview(page, state, goodsId){

    $.ajax({

        url : `/admins/goodsRelatedReview/${goodsId}/${page}`,
        type:'get',
        data : {
            state : state
        },
        dataType:'json',
        success : function (result){

            let text = '';
            let inputTextSection = $('.goods-review-list');

            result.content.forEach(r=>{

                text += `
                    
                     <tr>`;


                if(r.rating == 5) {
                    text += `
                     <td >★★★★★</td>

            `
                }else if (r.rating == 4){
                    text += `
                     <td >★★★★☆</td>

            `
                }else if (r.rating == 3){
                    text += `
                     <td >★★★☆☆</td>

            `
                }else if(r.rating == 2){
                    text += `
                     <td >★★☆☆☆</td>

            `
                }else if(r.rating == 1){
                    text += `
                     <td >★☆☆☆☆</td>

            `
                }



                text +=`        
                        <td class="q-content">${r.orderReviewContent}</td>
                        <td>${form.formatDates(r.orderReviewRd)}</td>
                        
                        `;


                if(r.state ==1){
                    text +=`    
    
    
    
                         <td id="reply-td"><button type="button" class="reply-complete reply-btn"><a href="/admin/goodsReviewDetail/${r.orderReviewId}">답변완료</a></button></td>
                    </tr>
                
                `;
                }else {
                    text += `
                     <td id="reply-td"><button type="button" class="reply-wait reply-btn"><a href="/admin/goodsReviewDetail/${r.orderReviewId}">답변대기</a></button></td>
                    </tr>
                    
                    `;
                }
               


            })


            inputTextSection.html(text);
            let paginations = $('.goods-related-review-pagination');

            pp.pagination(result, paginations)
            paginations.find('a').on('click', function (e) {
                e.preventDefault();
                const page = parseInt($(this).data('page'));
                getGoodsRelatedReview(page, $("input[name='review-state']:checked").val(), goodsId);
            });

        }

    })

}








// goodsDetail()
//
// function goodsDetail(){
//     let goodsId = $('#goodsId').val();
//
//     $.ajax({
//
//         url : `/admins/detail/${goodsId}`,
//         type:'get',
//         dataType:'json',
//         success : function (result){
//             console.log(result)
//         }
//     })
//
// }