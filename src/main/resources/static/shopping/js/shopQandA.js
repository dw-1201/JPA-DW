//상품 설명
let goodsId = $('#goodsId').val();
console.log(goodsId)
//문의리스트 가져오기
function getGoodsQna(goodsId, callback){

    $.ajax({

        url : `/shops/shopQnaList/${goodsId}`,
        type: 'get',
        dataType: 'json',
        success : function (result){
            console.log(result)
            shopDetailView(result)


            if(callback){
                callback(result);
            }

        }, error : function (a,b,c){
            console.error(c);
        }

    })
}



$('.qna-btn').on('click', function (e){
    e.preventDefault();
    getGoodsQna(goodsId, shopDetailView);
})


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
          <!-- QandA li -->
          <div class="comments">
            <div class="commentlist">
                <div class="comment-text">
                  <div class="star-div">
                    <!-- <span>★★★★★</span> -->
                  </div>

                  <p class="reviewWriter">
                    <strong>${r.userAccount}</strong>
                    <span>-</span>
                    <time>${r.queRegisterDate}</time>
                  </p>

                  <div class="description">
                  <p>${r.queContent}</p>
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
            <!-- 관리자 QandA 끝 -->
            </div>
          </div>
          <!-- QandA li 끝 -->
      </div>
        `;
        }else {
          text += ` <div>등록된 문의글이 없습니다.</div>
        `}

    });

    inputSection.html(text)
}

$('.shop-form').on('click', '.review-button', function() {
    // 모달 창에 'show' 클래스를 추가하여 모달을 표시
    $('.modal').addClass('show');
});

$(document).ready(function() {




        $('.shop-form').on('click', '.modal', function (e){
            let modal = $('.modal');
            if (e.target === modal[0]) {
                modal.removeClass("show");
            }
        })
        // 모달 바깥을 클릭하면 모달 창 닫기
        // modal.on("click", function(e) {
        //
        // });

        // 모달 안의 등록 버튼 클릭 시 모달 창 닫기 및 폼 전송

    $('.shop-form').on("click", '.review-submit',function(e) {

        let modal = $('.modal');
        let id =$('#goodsId').val()
        let modalTextarea = $(".modal_textarea").val();

        console.log(modalTextarea)

            e.preventDefault();
            modal.removeClass("show");

            console.log(id)
            // 비동기 통신으로 서버에 데이터 전송 및 처리
            $.ajax({
                url: '/shops/shopQandaWriteModal',
                type: 'post',
                data: {
                    // 여기에 필요한 데이터를 추가 (예: goodsQandaWritingForm의 필드들)
                    queContent: modalTextarea,
                    goodsId: id,
                    // 필요한 다른 데이터도 추가
                },
                success: function (result) {
                    console.log(result);
                    getGoodsQna(goodsId, shopDetailView);

                    // 성공적으로 처리된 경우 추가적인 동작을 수행
                },
                error: function (error) {
                    console.error(error);
                    // 에러 처리 로직을 추가
                }
            });
        });


});

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
