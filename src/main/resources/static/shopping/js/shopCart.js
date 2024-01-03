let userId = $('#userId').val();
console.log(userId)

// 화면 진입 시 초기 데이터 로드
$(document).ready(function () {
    getCart(userId, function (result) {
        getCartList(result);
        updateTotalPrice();
    });
});

//비동기
function getCart(userId, callback){

    $.ajax({

        url : `/shops/shopCartList/${userId}`,
        type : "get",
        dataType : "json",
        success : function(result){
            console.log(result);

            if (callback){
                callback(result)
            }
        }
    })
}

// 리스트
function getCartList(result){
    let text = '';
    let inputSection = $('.cart_list');

    result.cartItemDetails.forEach(r=>{


        text += `
        <div class="cart_table">
          <div class="cart_form">
            <div class="remove-button">
              <button type="button"  class="remove-btn" data-cartitemid="${r.id}">X</button>
            </div>
            <div class="thumbnail">
          <a href="/shop/shopDetail/${r.goodsId}">
            <img src="/shops/shopImg?fileFullPath=${r.goodsMainImgPath +'/'+ r.goodsMainImgUuid +'_'+ r.goodsMainImgName}" alt="">
          </a>
              <div class="thumbnail-dox">
                <div class="thumbnail-dox-div">
                  <a href="/shop/shopDetail/${r.goodsId}">
                  <input type="hidden" class="goodsId" value="${r.goodsId}">
                    <p class="goodsName">${r.goodsName}</p>
                    <p id="price" class="item-price" data-price="${r.goodsPrice}">${addCommas(r.goodsPrice)} 원 </p>
                  </a>
                </div>
                <div class="quantity-button">
                  <div class="quantity-box">
                      <button id="increase" class="increase-btn"><strong>+</strong></button>
                      <div><span id="number" class="quantity" >${r.cartItemQuantity}</span></div>
                      <button id="decrease" class="decrease-btn" "><strong>-</strong></button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        `

    })
    inputSection.html(text);

}
    // Increase 및 Decrease 버튼 클릭 시 공통 로직 함수
    function handleQuantityChange(button, increase) {
        const quantityElement = button.closest('.quantity-box').find('.quantity');
        let quantity = parseInt(quantityElement.text(), 10);

        quantity += increase ? 1 : -1;
        quantity = Math.max(quantity, 1); // 최소값을 1로 유지

        quantityElement.text(quantity);

        let goodsPrice = button.closest('.thumbnail-dox').find('.item-price').data('price');
        let dynamicPrice = button.closest('.thumbnail-dox').find('.item-price');

        dynamicPrice.text(addCommas(goodsPrice * quantity) + ' 원');
        updateTotalPrice();
    }

// Increase 버튼 클릭 시
    $('.cart_list').on('click','.increase-btn', function() {
        handleQuantityChange($(this), true);
    });

// Decrease 버튼 클릭 시
    $('.cart_list').on('click','.decrease-btn', function () {
        handleQuantityChange($(this), false);
    });

// 총 결제 금액 업데이트 함수
function updateTotalPrice() {
    let dynamicPricesArray = [];

    $('.item-price').each(function () {
        dynamicPricesArray.push(parseInt($(this).text().replace(/[^\d]+/g, ''), 10));
        // 숫자만 추출하여 배열에 추가
    });

    let totalPrice = dynamicPricesArray.reduce((sum, price) => sum + price, 0);
    $('#total').text(addCommas(totalPrice) + ' 원');

}

    /**
     * collectData : 특정 선택자의 텍스트 데이터를 수집
     * collectInputData : 특정 선택자의 입력 필드 값을 수집
     */
    function collectData(selector) {
        let data = [];
        $(selector).each(function () {
            data.push($(this).text());
        });
        return data;
    }
    function collectInputData(selector) {
        let data = [];
        $(selector).each(function () {
            data.push($(this).val());
        });
        return data;
    }
    /**
     * 결제 버튼 클릭 시 데이터를 수집
     */
    $('.cart-button').on('click', function () {
        let order = [];
        let currentPrices = collectData('.item-price');
        let goodsName = collectData('.thumbnail-dox-div .goodsName');
        let goodsId = collectInputData('.thumbnail-dox-div .goodsId');
        let cartItemQuantity = collectData('.quantity-box .quantity');

        for (let i = 0; i < currentPrices.length; i++) {
            let product = {
                goodsId: goodsId[i],
                goodsName: goodsName[i],
                goodsQuantity: cartItemQuantity[i],
                goodsTotalPrice: currentPrices[i]
            };
            order.push(product);
        }
        console.log(order);

        $.ajax({
            url : '/shops/cartGoods',
            type : 'post',
            data: JSON.stringify(order),
            contentType:'application/json; charset=utf-8',
            success : function (result){

                window.location.href="/shop/cartGoods/" +userId;
                console.log(result)
            },error : function (a,b,c){
                console.error(c)
            }

        })

    });


// 콤마 찍기 함수
function addCommas(number) {
    return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//카트 아이템 삭제
function removeCartItem(cartItemId, callback){

    $.ajax({
        url : `/shops/delete/${cartItemId}`,
        type : "get",
        success : function (result){
            console.log(result);

            if (callback){
                callback(result);
            }
        }
    })
}

//카트 아이템 삭제 버튼 이벤트
$('.cart_list').on('click', '.remove-btn',function(){
    let cartItemId = $(this).data('cartitemid');
    console.log(cartItemId)
    if(confirm("상품을 삭제 하시겠습니까?")){
        removeCartItem(cartItemId, function (){
            getCart(userId, getCartList)

        })

    }
})

// $('.cart-button').on('click', function(){
//     window.location.href="/order/order";
// })

//수정전
// 결제 버튼 클릭시 값을 받아 오는 이벤트
//     $('.cart-button').on('click',  function (){
//
//         let order = [];
//         let goodsId = [];
//         let goodsName= [];
//         let cartItemQuantity= [];
//         let currentPrices = [];
//
//
//         $('.item-price').each(function() {
//             currentPrices.push($(this).text());
//         });
//         $('.thumbnail-dox-div .goodsName').each(function() {
//             goodsName.push($(this).text());
//         });
//         $('.thumbnail-dox-div .goodsId').each(function() {
//             goodsId.push($(this).val());
//         });
//         $('.quantity-box .quantity').each(function() {
//             cartItemQuantity.push($(this).text());
//         });
//
//
//         for(let i=0; i<currentPrices.length;i++){
//         let Product = {
//                 goodsId : goodsId[i],
//                 goodsName : goodsName[i],
//                 goodsQuantity : cartItemQuantity[i],
//                 goodsTotalPrice : currentPrices[i]
//
//             }
//
//             order.push(Product)
//             console.log(order)
//         }
//
//     } )
// 수정전
// // Increase 버튼 클릭 시
//     $('.cart_list').on('click','.increase-btn', function() {
//         const quantityElement = $(this).closest('.quantity-box').find('.quantity');
//         let quantity = parseInt(quantityElement.text(), 10);
//
//
//         quantity++;
//         quantityElement.text(quantity);
//
//         let goodsPrice = $(this).closest('.thumbnail-dox').find('.item-price').data('price')
//
//         let dynamicPrice = $(this).closest('.thumbnail-dox').find('.item-price');
//
//         dynamicPrice.text(addCommas(goodsPrice * quantity)+ ' 원');
//
//         updateTotalPrice(); // 호출하여 총 결제 금액 업데이트
//     });
//
// // Decrease 버튼 클릭 시
// $('.cart_list').on('click','.decrease-btn', function (){
//     const quantityElement = $(this).closest('.quantity-box').find('.quantity');
//     let quantity = parseInt(quantityElement.text(), 10);
//
//     quantity--;
//     quantityElement.text(quantity);
//
//     let goodsPrice = $(this).closest('.thumbnail-dox').find('.item-price').data('price');
//
//     let dynamicPrice = $(this).closest('.thumbnail-dox').find('.item-price');
//
//     dynamicPrice.text(addCommas(goodsPrice * quantity) + ' 원');
//
//     updateTotalPrice();
// });
