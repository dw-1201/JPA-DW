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













//답글 수정창 팝업
$('.goods-review-content-container').on('click', '.modify-reply-btn', function () {

    //리플 수정창 팝업 시 작성시간(일자) 숨기기
    // let $hide = $('.reply-time');
    // $hide.css('display','none')

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
    console.log(modifyContent)

})