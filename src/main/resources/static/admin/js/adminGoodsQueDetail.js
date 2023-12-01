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
