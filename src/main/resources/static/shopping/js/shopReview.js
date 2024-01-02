
//상품 설명
let goodsId = $('#goodsId').val();
shopDetail(goodsId);
console.log(goodsId)
// 상품 설명 보여주는 함수
function shopDetail(goodsId) {
    // 댓글 목록을 비동기로 받아오기
    $.ajax({
        url: `/shops/shopReview/${goodsId}`,
        type: 'get',
        dataType: 'json',
        success: function (result) {
            console.log(result)
            const text = shopDetailView(result);
            $('.shop-form').html(text);
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
<div class="main-content-contaniner-form3">
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
            </div>
            
             <div class="middle-content">
                <ul>
                    <span>|</span>
                    <li>
                        <a href="/shop/shopDetail/${r.id}" >
                            <span class="middle-span" >설명</span>
                        </a>
                    </li>
                    <span>|</span>
                    <li>
                        <a href="/shop/shopAddInfo/${r.id}">
                            <span class="middle-span">추가정보</span>
                        </a>
                    </li>
                    <span>|</span>
                    <li>
                        <a href="/shop/shopReview/${r.id}" id="descriptionLink">
                            <span class="middle-span1">리뷰</span>
                        </a>
                    </li>
                    <span>|</span>
                    <li>
                        <a href="/shop/shopQandA/${r.id}">
                            <span class="middle-span">문의</span>
                        </a>
                    </li>
                    <span>|</span>
                </ul>

            </div>

        <div class="row-content">
<div class="comments">
            <div class="commentlist">
                <div class="comment-text">
                  <div class="star-div">
                    <span>★★★★★</span>
                  </div>
                  
                  <p class="reviewWriter">
                    <strong>두부**</strong>
                    <span>-</span>
                    <time>2023년 11월 22일</time>
                  </p>

                  <div class="description">
                  <p>평소 식탐이 많아서, 간식을 안줄수가 없는</p>
                  <p>노즈워크 훈련용이라 그런지 크기도 알맞고
                  </p>
                  <p>아주 잘 먹어줍니다! 아주 찹찹찹 거리면서 야무지게 씹어먹어요</p>
                  <p>노즈워크놀이할 때에도 별도로 잘라줄 필요없어서</p>
                  <p>너무 편안하고, 부스러기 안나와서 깔끔하게 놀수 있어요</p>
                  <p>비마이펫으로부터 제품을 무상으로 받아 작성된 후기입니다.</p>
                  </div>

                <div class="reviewImg">
                  <div class="imgbox">
                    <a href="/img/reviewImg01.jpg">
                      <img src="/img/reviewImg01.jpg" alt="" class="imgs">
                    </a>
                  </div>
                  <div class="imgbox">
                    <a href="/img/reviewImg02.jpg">
                      <img src="/img/reviewImg02.jpg" alt="" class="imgs">
                    </a>
                  </div>
                  <div class="imgbox">
                    <a href="/img/reviewImg03.jpg">
                      <img src="/img/reviewImg03.jpg" alt="" class="imgs">
                    </a>
                  </div>
                </div>
              </div>
            <!-- 관리자 리뷰 -->
            <div class="admin-review-box">
            <div class="admin-review">
              <div>
                <span>관리자</span>
                <span>- 2023년 11월 22일</span>
                <p>소중한 후기 감사합니다~ 견주님과 멍이 맘에 쏙! 들도록 더더욱 연구해서 좋은 제품으로 찾아뵐게요 😀</p>
              </div>

            </div>
          </div>
            <!-- 관리자 리뷰 끝 -->
            </div>
          </div>
          <!-- 리뷰 li 끝 -->
        </div>
        `;
    });

    return text;
}

// 수정된 부분
// document.addEventListener("DOMContentLoaded", function () {
//     const numberElement = document.getElementById("number"); // 갯수
//     const priceElement = document.getElementById("price"); // 금액
//     const increaseButton = document.getElementById("increase"); // 증가
//     const decreaseButton = document.getElementById("decrease"); // 감소
//
//     let quantity = 1;
//     let unitPrice = parseFloat(priceElement.innerText.replace(" ", "").replace(",", ""));
//
//     // 수량과 가격을 계산한 후에 해당 값을 화면에 업데이트
//     function updatePriceAndQuantity() {
//         const totalPrice = quantity * unitPrice;
//         priceElement.innerText = totalPrice.toLocaleString() + " 원";
//         numberElement.innerText = quantity;
//     }
//
//     // 수량을 증가
//     increaseButton.onclick = () => {
//         quantity++;
//         updatePriceAndQuantity();
//     };
//
//     // 수량을 감소
//     decreaseButton.onclick = () => {
//         if (quantity > 1) {
//             quantity--;
//             updatePriceAndQuantity();
//         }
//     };
// });
