
//상품 설명
let goodsId = $('#goodsId').val();
shopDetail(goodsId);
console.log(goodsId)
// 상품 설명 보여주는 함수
function shopDetail(goodsId, callback){
    // 댓글 목록을 비동기로 받아오기
    $.ajax({
        url: `/shops/shopReview/${goodsId}`,
        type: 'get',
        dataType: 'json',
        success: function (result) {
            console.log(result)
            const text = shopDetailView(result);
            $('.shop-form').html(text);

            if(callback){
                callback(result);
            }
        },
        error: function (a, b, c) {
            console.error(c);
        }
    });
}


// 상세 페이지
function shopDetailView(result) {
    let text = '';
    let inputSection = $('.row-content');
    text = `

          <div class="review-div">
            <img src="/img/ICON-24px-Search.svg" alt="" class="input-img">
            <input type="text" placeholder="문의 검색" class="selecReview" maxlength="130">
         <form action="/shops/shopQandaWriteModal" method="post" class="writingForm">
             <button type="button" class="review-button">문의하기</button>

                 <tbody class="content">

                    <!-- 모달 창 들어 가는 부분  -->
                <div class="modal">
                    <div class="modal_body">
                        <strong style="font-size: 30px; " class="modal__userName">
                            문의하기
                        </strong>
                      <textarea name="queContent" class="modal_textarea" cols="30" rows="10" placeholder="문의 내용을 입력해주세요"></textarea>

                      <button type="button" class="review-submit">등록</button>
                    </div>
                </div>
                    <!-- 모달 창 들어 가는 부분 끝 -->

                </tbody>
            </form>
          </div>
        `;


    result.forEach(r => {

        if(r.id != null){
            text +=`
          <!-- 리뷰 li -->
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
        }else {
            text += ` <div>등록된 문의글이 없습니다.</div>
        `}

    });

    inputSection.html(text)
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
