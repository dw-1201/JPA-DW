//답글 수정창 팝업
$('.goods-q-content-container').on('click', '.modify-reply-btn', function () {

    //리플 수정창 팝업 시 작성시간(일자) 숨기기
    // let $hide = $('.reply-time');
    // $hide.css('display','none')

    let $content = $(this).closest('.goods-q-reply-container').find('.q-reply');
    $content.replaceWith(`
      <div class='modify-box'>
        <textarea class='modify-content' cols="30" rows="2">${$content.text()}</textarea>
        <div class="modify-btn">
        <button type='button' class='modify-content-btn'>수정 완료</button>
        </div>
      </div>
    
    `);
     $('.btns').addClass('none');

});





$('.reply-section-btn').on('click',function (){
    let qnaId = $('#qnaId').val();

    console.log(qnaId+"@@@@@@@@@@@@@@@@")
    addReply()
})
//상품 문의 답변 등록
function addReply(){
    let qnaReplyContent = $('#reply-content').val();
    let goodsQueId = $('#qnaId').val();
    let userId = $('#userId').val();

    $.ajax({

        url : '/admins/addQnaReply',
        type:'post',
        data: {
            qnaReplyContent : qnaReplyContent,
            goodsQueId : goodsQueId,
            userId : userId
        },
        success:function (){
            $('.admin-reply-section').css('display', 'none')
        }
    })
}
$(document).ready(function (){
    let qnaId = $('#qnaId').val();
    replyList(qnaId);
})



//상품 문의 답변 불러오기
function replyList(qnaId){
    $.ajax({

        url : `/admins/replyList/${qnaId}`,
        type: 'get',
        dataType : 'json',
        success : function (result){
            console.log(result);
        }

    })


}

//상품 문의 답변 삭제
function replyDelete(replyId){




}