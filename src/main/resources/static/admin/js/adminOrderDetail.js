import * as form from './module/form.js'


$(document).ready(function (){
    //주문 상품 더보기 버튼 on/off
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


    //포맷변경
    //주문날짜
    $('.order-date').text(form.formatDates($('#orderDate').val()))

    //개당 가격
    $('.goods-per-price').text(form.addCommas($('.each-price').val()) + '원')

    //수량 * 가격 = 금액
    $('.goods-total-price').text(form.addCommas($('.total-price').val()) +'원')
    
    
    //총 합계금액

    let totalPrice = 0;
    let $priceValues = $('.total-price');

    for (let i = 0; i < $priceValues.length; i++) {
        let priceValue = $($priceValues[i]).val();
        totalPrice += parseFloat(priceValue);
    }

    $('.order-result span').text(form.addCommas(totalPrice) + '원');
})


