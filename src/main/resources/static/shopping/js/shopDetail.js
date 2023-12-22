
const numberElement = document.getElementById("number"); //갯수
const priceElement = document.getElementById("price"); //금액
const increaseButton = document.getElementById("increase");//증가
const decreaseButton = document.getElementById("decrease");//감소

// let quantity = 1;
// let unitPrice = parseFloat(priceElement.innerText.replace(" ", "").replace(",", ""));
//
// //수량과 가격을 계산한 후에 해당 값을 화면에 업데이트
// function updatePriceAndQuantity() {
//     priceElement.innerText = (quantity * unitPrice).toLocaleString() + " ";
//     numberElement.innerText = quantity;
// }
//
// //수량을 증가
// increaseButton.onclick = () => {
//     quantity++;
//     updatePriceAndQuantity();
// };
//
// //수량을 감소
// decreaseButton.onclick = () => {
//     if (quantity > 1) {
//         quantity--;
//         updatePriceAndQuantity();
//     }
// };

//상품 설명
//
let goodsId = $('#goodsId').val();
shopDetail(goodsId);
console.log(goodsId)
// 상품 설명 보여주는 함수
function shopDetail(goodsId) {
    // 댓글 목록을 비동기로 받아오기
    $.ajax({
        url: `/shops/shopDetail/${goodsId}`,
        type: 'get',
        dataType: 'json',
        success: function (result) {
            console.log(result)
            const text = shopDetailView(result);
            $('.main-content-contaniner-form3').html(text);
        },
        error: function (a, b, c) {
            console.error(c);
        }
    });
}
// 상세 페이지
function shopDetailView(result) {
    let text = '';

    result.forEach(r => {
        text += `
        <div class="form3-left">
            <div class="form3-left-box1">
                <img src="/shops/shopImg?fileFullPath=${r.goodsMainImgPath}/${r.goodsMainImgUuid}_${r.goodsMainImgName}" alt="" class="li-img" >
            </div>
        </div>
        `;

        text += `
        <div class="form3-right" >
            <div class="form3-right-box1">
                <div class="right-box1-box1">
                </div>
                <div class="right-box1-box1">
                    <span id="goods-name">${r.goodsName}</span>
                </div>
                <div class="right-box1-box1-1">
                    <span>${r.goodsPrice}</span>
                </div>
                <div class="right-box1-box2">
                    <span>
                    ★★★★★ 4.9점
                    </span>&nbsp;&nbsp;
                    <span class="evaluation">(10개의 고객 상품 평가)</span>
                </div>

                <div class="right-box1-box3">
                    <span>
                        제품 요약 설명
                    </span>
                </div>

                <div class="right-box1-box4">
                    <span>${r.goodsDetailContent}</span>
                </div>

                    <div class="pay-amount">
                        <div class="pay-name">${r.goodsName}</div>
                        <div class="pay-count">
                            <button id="increase"><strong>+</strong></button>
                            <div><span id="number">1</span></div>
                            <button id="decrease"><strong>-</strong></button>
                        </div>
                        <div class="pay-sum"><p>총 상품금액  : <strong id="price">${r.goodsPrice}</strong> 원</p></div>
                    </div>

                    <div class="right-box1-box9">
                        <div class="basket1">
                            <a href="/shop/shopCart" class="basket-button1">장바구니</a>
                        </div>
                        <div class="basket2">
                            <a href="/shop/shopPay" class="basket-button2">바로구매</a>
                        </div>
                    </div>
                </div>
                </div>
        `;
    });

    return text;
}
