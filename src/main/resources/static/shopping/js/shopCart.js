let userId = $('#userId').val();
console.log(userId)

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

getCart(userId, getCartList)
function getCartList(result){
    let text = '';
    let inputSection = $('.cart_list');

    result.cartItemDetails.forEach(r=>{


        text += `
        <div class="cart_table">
<!--        <input type="hidden" th:value="${r.id}" id="cartItemId">-->
          <div class="cart_form">
            <div class="remove-button">
              <button type="button"  class="remove-btn" data-cartitemid="${r.id}">X</button>
            </div>
            <div class="thumbnail">
            <img src="/shops/shopImg?fileFullPath=${r.goodsMainImgPath +'/'+ r.goodsMainImgUuid +'_'+ r.goodsMainImgName}" alt="">
              <div class="thumbnail-dox">
                <div class="thumbnail-dox-div">
                  <a href="/shop/shopDetail/${r.goodsId}">
                    <p>${r.goodsName}</p>
                    <p id="price" class="item-price">${addCommas(r.goodsPrice)} 원 </p>
                  </a>
                </div>
                <div class="quantity-button">
                  <div class="quantity-box">
                      <button id="increase"><strong>+</strong></button>
                      <div><span id="number">${r.cartItemQuantity}</span></div>
                      <button id="decrease"><strong>-</strong></button>
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

// 콤마 찍기 함수
function addCommas(number) {
    return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}



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


$('.cart_list').on('click', '.remove-btn',function(){
    let cartItemId = $(this).data('cartitemid');
    console.log(cartItemId)
    if(confirm("상품을 삭제 하시겠습니까?")){
        removeCartItem(cartItemId, function (){
            getCart(userId, getCartList)

        })

    }
})