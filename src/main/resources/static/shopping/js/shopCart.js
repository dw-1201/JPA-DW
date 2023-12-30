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

    result.forEach(r => {

        text += `
        <div class="cart_table">
          <div class="cart_form">
            <div class="remove-button">
              <a href="">X</a>
            </div>
            <div class="thumbnail">
              <img src="/img/thumbnail.png" alt="">
              <div class="thumbnail-dox">
                <div class="thumbnail-dox-div">
                  <a href="">
                    <p>${r.goodsName}</p>
                    <p id="price" class="item-price" data-price="33000">${r.goodsPrice} 원 </p>
                  </a>
                </div>
                <div class="quantity-button">
                  <div class="quantity-box">
                      <button id="increase" onclick="changeQuantity(1)"><strong>+</strong></button>
                      <div><span id="number">${r.goodsQuantity}</span></div>
                      <button id="decrease" onclick="changeQuantity(-1)"><strong>-</strong></button>
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








//수량과 금액에 대한 js 수정예정
// let quantity = 1;
// let price = 33000;
//
// function changeQuantity(amount) {
//     quantity += amount;
//
//     if (quantity < 1) {
//         quantity = 1;
//     }
//
//     document.getElementById('number').innerText = quantity;
//
//     updatePrice();
// }
//
// function updatePrice() {
//     price = quantity * 33000;
//
//     const formattedPrice = price.toLocaleString();
//
//     document.getElementById('price').innerText = formattedPrice  + ' 원';
// }
//
// //
// function updateTotalPrice() {
//     const priceElements = document.querySelectorAll('.item-price');
//
//     let totalPrice = 0;
//     priceElements.forEach(element => {
//         const price = parseInt(element.getAttribute('data-price'));
//
//         totalPrice += price;
//     });
//
//     const formattedTotalPrice = totalPrice.toLocaleString();
//
//     document.getElementById('total').innerText = formattedTotalPrice + ' 원';
// }
//
// updateTotalPrice();

