const numberElement = document.getElementById("number");
const priceElement = document.getElementById("price");
const increaseButton = document.getElementById("increase");
const decreaseButton = document.getElementById("decrease");
const paymentButton = document.querySelector(".payment");

let quantity = 1;
let price = 13900;

function updatePriceAndQuantity() {
    priceElement.innerText = price.toLocaleString() + "";
    numberElement.innerText = quantity;
}

increaseButton.onclick = () => {
    quantity++;
    price = quantity * 13900;
    updatePriceAndQuantity();
};
decreaseButton.onclick = () => {
    quantity--;
    price = quantity * 13900;
    updatePriceAndQuantity();
};


// decreaseButton.onclick = () => {
//     if (quantity <= 1) {
//         alert("최소 결제는 1개월 입니다.");
//     } else {
//         quantity--;
//         price = quantity * 50000;
//         updatePriceAndQuantity();
//     }
// };

// paymentButton.addEventListener("click", () => {
//     // 페이지 이동을 원하는 URL로 변경
//     alert("일단 메인페이지로 이동합니다.")
//     window.location.href = "/html/index.html";
// });

// // 페이지 로드 시 초기 가격 설정
// updatePriceAndQuantity();