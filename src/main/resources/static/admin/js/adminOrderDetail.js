
    let orderedGoods = $('.ordered-goods-info-dl');
    $('.show-more-btn button').text('더보기')

    if(orderedGoods.length > 3){
        $('.show-more-btn').show();
        $('.show-more-btn').on('click.', function(){
            $('.ordered-goods-info-container').toggleClass('on')

            if($('.show-more-btn button').text() == '더보기'){
                $('.show-more-btn button').text('간단히') 
            }else {
                $('.show-more-btn button').text('더보기')
            }
        })
    }




