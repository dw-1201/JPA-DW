import * as form from './module/form.js';





let orderReviewId=$('.orderReviewId').val();


$(document).ready(function (){


    //상품정보이동
    $('.move-to-detail').on('click', function (){

        let goodsId = $(this).data('goodsid');

        window.location.href="/admin/detail/" + goodsId;

    })


    replyList(orderReviewId,getReplyList)

    //댓글등록
    $('.admin-reply-section').on('click', '.reply-section-btn',function (){

        addReply(goodsReviewReplyForm(), function (){

            replyList(orderReviewId,getReplyList);
        })
        $('#reply-content').val('');

    })




//답글 수정창 팝업
    $('.goods-review-content-container').on('click', '.modify-reply-btn', function () {


        let $content = $(this).closest('.goods-review-reply-container').find('.review-reply');
        $content.replaceWith(`
      <div class='modify-box'>
        <textarea class='modify-content' cols="30" rows="2">${$content.text()}</textarea>
        <div class="modify-btn">
        <button type='button' class='modify-content-btn btn'>수정 완료</button>
        </div>
      </div>
    
    `);
        $('.btns').addClass('none');

    });

    $('.goods-review-content-container').on('click', '.modify-content-btn', function () {

        let modifyContent = $(this).closest('.if-reply').find('.modify-content').val();
        let replyId=$(this).closest('.if-reply').find('.modify-reply-btn').data('replyid');


        replyModify(modifyContent, replyId, function (){

            replyList(orderReviewId,getReplyList)

        })

    })




    //댓글삭제
    $('.goods-review-reply-container').on('click', '.delete-reply-btn', function (){

        let replyId=$(this).closest('.btns').find('.delete-reply-btn').data('replyid');

        if(confirm("삭제하시겠습니까?")){
            deleteReply(replyId, orderReviewId,function (){
                replyList(orderReviewId,getReplyList);
            });

            $('#reply-content').val('');
        }

    })

    //날짜포맷
    $('.orderReviewRd-form').text(form.formatDates($('#orderReviewRd').val()))





//리뷰 이미지
    $('.review-imgs-btn').on('click', function(){

        let imgs = $('.review-imgs img');
        console.log(imgs);

        $('.review-imgs-slide').slideToggle()

        if(imgs.length == 1){

        }else if(imgs.length ==2){

            $('.review-imgs').css('width', '465px');

        } else {
            $('.review-imgs').css('width', '100%');

        }

        if($('.review-imgs-btn').text()=='리뷰 사진 열기'){
            $('.review-imgs-btn').text('리뷰 사진 접기')

        }else {
            $('.review-imgs-btn').text('리뷰 사진 열기')
        }

    })


})




function addReply(goodsReviewReplyForm, callback){

    $.ajax({

        url : '/admins/addGoodsReviewReply',
        type:'post',
        data : goodsReviewReplyForm,
        success : function (){

            $('.admin-reply-section').css('display', 'none')

            if(callback){
                callback()
            }

        },error : function (a,b,c){
            console.error(c);
        }
    })

}

function goodsReviewReplyForm(){

    let replyContent = $('#reply-content').val();
    let orderReviewId = $('.orderReviewId').val();

    return {
        goodsReviewReplyContent : replyContent,
        orderReviewId : orderReviewId

    }

}

function deleteReply(replyId, orderReviewId, callback){

    $.ajax({

        url : `/admins/deleteGoodsReviewReply/${replyId}/${orderReviewId}`,
        type: 'delete',
        success : function (){

            $('.admin-reply-section').css('display', 'block')

            if(callback){
                callback()
            }
        },error : function (a,b,c){
            console.error(c);
        }


    })

}

function replyList(orderReviewId, callback){

    $.ajax({

        url : `/admins/goodsReviewReplyList/${orderReviewId}`,
        type : 'get',
        success : function (result){
            if(callback){
                callback(result)
            }
        },error : function (a,b,c){
            console.error(c)
        }
    })

}


function replyModify(replyModContent, replyId, callback ){

    $.ajax({

        url : '/admins/modifyingGoodsReviewReply',
        type:'patch',
        data :{
            modContent : replyModContent,
            id : replyId
        },
        success : function (){

            if(callback){
                callback();
            }

        }, error : function (a,b,c){
            console.error(c)
        }

    })

}

function getReplyList(result){

    let text='';
    let inputSection = $('.goods-review-reply-container');

    let textSection = '';
    let inputTextSection = $('.admin-reply-section');


    if(result.goodsReviewApplyId != null){

        text += `
        
             <div class="if-reply">
                 <ul class="review-info-ul">
                    <li> <h5 class="reply-content-title">답변 내용</h5></li>
        
        
        `;

        if(result.goodsReviewReplyRd == result.goodsReviewReplyMd){

            text += `
                    <li class="review-reply-md"></li>
                    <li class="review-reply-rd">작성일 <span>${form.formatDates(result.goodsReviewReplyRd)}</span></li>
            `;

        }else {

            text += `
                    <li class="review-reply-md">수정일 <span>${form.formatDates(result.goodsReviewReplyMd)}</span></li>
                    <li class="review-reply-rd">작성일 <span>${form.formatDates(result.goodsReviewReplyRd)}</span></li>
            `
        }

        text += `
        
                </ul>
                    <div class="review-reply">${result.goodsReviewReplyContent}</div>
                    <div class="btns btn-none">
                        <button class="modify-reply-btn" type="button" data-replyid="${result.goodsReviewApplyId}">수정</button>
                        <button class="delete-reply-btn" type="button" data-replyid="${result.goodsReviewApplyId}">삭제</button>
                    </div>
                </div>
        `

        textSection = '';
    }else {
        text = `
        
                <div class="if-reply">
                     <h5 class="reply-content-title">답변 내용</h5>

                    <div class="review-reply">등록된 답변이 없습니다.</div>
                    
                </div>
        `


        textSection = `
        
            <div class="reply-section">
                <form action="" method="" id="reply-form">
                    <textarea name="reply-content" id="reply-content" ></textarea>
                    <div class="reply-btn">
                        <button type="button" class="reply-section-btn">답변제출</button>
                    </div>
                </form>
            </div>
        `
    }

    inputSection.html(text);
    inputTextSection.html(textSection)


}