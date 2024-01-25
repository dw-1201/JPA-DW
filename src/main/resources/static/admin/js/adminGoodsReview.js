import * as page from './module/pagination.js';
import * as form from './module/form.js'


$('.review-list').on('click', '.detail-btn',function(){

    let orderReviewId = $(this).closest('.list-btns').find('.detail-btn').data('id');

    window.location.href="/admin/goodsReviewDetail/" + orderReviewId;
})



$(document).ready(function (){


    goodsReviewList(0, searchReviewForm(), inputSection)


    $("input[name='reply']").on('change', function (){

        let state = $(this).val();
        updateState(state);

    })


    $('.result-submit-btn').on('click', function (){

        goodsReviewList(0, searchReviewForm(), inputSection)

    })

})




function searchReviewForm(){

    let cate = $('#search-cate').val();
    let keyword = $('#search-keyword').val();
    let adminReplyState = $("input[name='reply']:checked").val();

    return {
        cate : cate,
        keyword : keyword,
        adminReplyState : adminReplyState
    }
}


function updateState(state){

    searchReviewForm().adminReplyState = state;

    goodsReviewList(0, searchReviewForm(), inputSection)


}


function goodsReviewList(page, searchReviewForm, callback){

    $.ajax({

        url :`/admins/goodsReviewList/${page}`,
        type :'get',
        data : searchReviewForm,
        dataType:'json',
        success : function (result){

            console.log(result);
            if(callback){
                callback(result)
            }

        }

    })

}

function inputSection(result){

    let text ='';
    let textInputSection = $('.review-list');
    let paginations = $('.pagination-ul')

    result.content.forEach(r=>{

        const reviewContent = r.reviewList;

        text +=`
 
                 <tr>
                    <td class="orderReviewId">${r.goodsReviewId}</td>
                    <td>${reviewContent.goodsCategory}</td>
                    <td class="goodsName">${reviewContent.goodsName}</td>
                    <td class="review-content">${reviewContent.goodsReviewContent}</td>
                    `;

        if(reviewContent.rating == 5) {
            text += `
                     <td >★★★★★</td>

            `
        }else if (reviewContent.rating == 4){
            text += `
                     <td >★★★★☆</td>

            `
        }else if (reviewContent.rating == 3){
            text += `
                     <td >★★★☆☆</td>

            `
        }else if(reviewContent.rating == 2){
            text += `
                     <td >★★☆☆☆</td>

            `
        }else if(reviewContent.rating == 1){
            text += `
                     <td >★☆☆☆☆</td>

            `
        }

        text +=     ` 
                    <td>${form.formatDates(reviewContent.goodsReviewRd)}</td>
                    `;

        if(reviewContent.replyState==0){
            text+= `                    
                    <td> X </td>
                    `
        }else {
            text+= `                    
                    <td> O </td>
                    `
        }

        text+=`     <td class="list-btns">
                        <button type="button" class="detail-btn btn" data-id="${r.goodsReviewId}" >상세보기</button>
                    </td>
                </tr>
        `
    })

    textInputSection.html(text);
    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        goodsReviewList(page, searchReviewForm(), inputSection)
    });
}