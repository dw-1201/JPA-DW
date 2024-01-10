let userId = $('#userId').val();
console.log(userId)

$(document).ready(function () {
    getGoodsPickList(getPickList);
    getGoodsPickList(updateTotalPrice);
});

function getGoodsPickList(callback){

    $.ajax({
        url : `/shops/goodsPickList`,
        type : "get",
        success : function(result){
            console.log(result);

            if (callback){
                callback(result)
            }
        },
        error: function(a, b, c) {
            console.error(c);
        }
    })
}

function getPickList(result){
    let text = '';
    let inputSection = $('.cart_list')

    result.forEach(r=>{
        text += `

        <div className="product-total">
            <span> ${r.goodsName} </span>
            <span class="goodsPrice">${addCommas(r.goodsPrice)}</span> x
            <span class="goodsQuantity">${r.goodsQuantity}</span> =
            <span id="price" class="goodsTotal" data-price="${r.goodsPrice}">${addCommas(r.goodsPrice * r.goodsQuantity)}</span>
        </div>

        `
    })
    inputSection.html(text);
}

// 콤마 찍기 함수
function addCommas(number) {
    return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}


// 총 결제 금액 업데이트 함수
function updateTotalPrice() {
    let dynamicPricesArray = [];

    $('.goodsTotal').each(function () {
        dynamicPricesArray.push(parseInt($(this).text().replace(/[^\d]+/g, ''), 10));
        // 숫자만 추출하여 배열에 추가
    });

    let totalPrice = dynamicPricesArray.reduce((sum, price) => sum + price, 0);
    $('#total').text(addCommas(totalPrice) + ' 원');
}

// 카카오 페이 API
$(".cart-button").click(function () {

    const payAmount = parseInt($('#total').text().replace(',',''))
    const orderUserName = ($('#userName')).val()
    const orderUserAddressNumber = ($('#addressPost')).val();
    const orderAddressNormal = $('#orderAddressNormal').val();
    const orderAddressDetail = ($('#addressDetail')).val();
    const orderAddressDetails = ($('#addressDetails')).val();
    const orderUserPhoneNumber = ($('#userPhone')).val();
    const orderUserEmail = ($('#userEmail')).val();
    const orderMemo = ($('#orderMemo')).val();

    console.log("주문자 이름: " + orderUserName);
    console.log("도로명 및 번지: " + orderAddressNormal);
    console.log("주문 메모: " + orderMemo);

    var IMP = window.IMP; // 생략가능
    IMP.init('imp24106650');
    // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
    // ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.
    IMP.request_pay({
        pg: 'kakaopay.TC0ONETIME',
        pay_method: 'card',
        merchant_uid: 'merchant_' + new Date().getTime(),

        name: '(주)산책갈께 카카오 결제',
        amount: payAmount,

        buyer_name: orderUserName,
        buyer_postcode: orderUserAddressNumber,
        buyer_addr : orderAddressNormal,
        buyer_addr_d : orderAddressDetail,
        buyer_addr_ds : orderAddressDetails,
        buyer_tel : orderUserPhoneNumber,
        buyer_email : orderUserEmail,
        buyer_memo : orderMemo,

    }, function (rsp) {
        console.log(rsp);
        if (rsp.success) {
            var msg = '결제가 완료되었습니다.';
            msg += '결제 금액 : ' + rsp.paid_amount;

            console.log("주소노말"+orderAddressNormal)
            console.log("메모"+orderMemo)

            $.ajax({
                url : `/orders/orderList`,
                type : "post",
                data : JSON.stringify({
                    payAmount : payAmount,
                    orderUserName : orderUserName,
                    orderUserAddressNumber : orderUserAddressNumber,
                    orderAddressNormal : orderAddressNormal,
                    orderAddressDetail : orderAddressDetail,
                    orderAddressDetails : orderAddressDetails,
                    orderUserPhoneNumber : orderUserPhoneNumber,
                    orderUserEmail : orderUserEmail,
                    orderMemo : orderMemo
                }),
                contentType : "application/json; charset=utf-8",
                success : function(response){
                    console.log(response);


                    // location.href = '';
                }
            })

        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }
        alert(msg);
    });
});






//다음 주소API
function addressFind() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                } console.log(extraAddr);
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById('addressDetail').value = extraAddr;
            
            } else {
                document.getElementById('addressDetail').value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('addressPost').value = data.zonecode;
            document.getElementById('orderAddressNormal').value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('addressDetails').focus();
        }
    }).open();
    console.log("성공!");
}


//약관 체크
let $all = $("#total-check");
let $inputs = $(".term");
let terms = $('.terms')

$all.on('click', function(){
    if($(this).is(":checked")){
        $inputs.prop('checked', true);
        $('.join-term').slideUp(500)
    }else{
        $inputs.prop('checked', false);
        $('.join-term').slideDown(500)
    }
});

$inputs.on('click', function(){
    if(!$(this).is(":checked")){
        $all.prop('checked', false);
        $('.join-term').slideDown(500)

    }
    if($inputs.filter(":checked").length === $inputs.length){
        $all.prop('checked', true);
        $('.join-term').slideUp(500)

    }
});

//회원가입 유효성 검사
function join(){
   
    $('.cart-button').on('click', function(){

        let userName = $("#userName").val();
        let userEmail = $("#userEmail").val();
        let userPhone = $("#userPhone").val();
        let userPostCode = $('#addressPost').val();
        let userAddress = $("#orderAddressNormal").val();
        let userAddressDetails = $("#addressDetails").val();

            if($('.userPhoneCh').css('display')=='block'){
                alert("휴대폰 번호 양식을 확인해주세요");
                return false;
            }

            if($('.userEmailCh').css('display')=='block'){
                alert("이메일 양식을 확인해주세요");
                return false;
            }

            if (!(userEmail && userName && userPhone && userPostCode && userAddress && userAddressDetails)) {

                alert("모든 정보를 입력해주세요")
                return false;
            }
            $('#join_form').submit();
	        alert("결제가 진행 됩니다!")
	        return true;
    })


}
$('document').ready(function(){
	join();
})


//휴대폰번호 양식 체크
$('#userPhone').keyup(function(){
	let userPhone = $(this).val();
    const pattern = /^(010)[0-9]{3,4}[0-9]{4}$/;

    let phoneCheck = pattern.test(userPhone);
	
	if(!phoneCheck) {
		$('.userPhoneCh').css('display', 'block');
		
		return;
	}else {
		$('.userPhoneCh').css('display', 'none');

	}
	
})


//이메일 양식 체크
$('#userEmail').keyup(function() {
	let userEmail = $(this).val();
	// console.log(userEmail);
	const pattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z]+/;
	
	let emailCheck = pattern.test(userEmail);
	
	if (emailCheck) {
		$('.userEmailCh').css('display', 'none')
	} else {
		$('.userEmailCh').css('display', 'block')
		return;
	}
})


//특수문자(이메일용)
function characterCheck(obj){
    var regExp = /[ \{\}\[\]\/?,;:|\)*~`!^\-_+┼<>\#$%&\'\"\\\(\=]/gi;
    if( regExp.test(obj.value) ){
        alert("@제외한 특수문자는 입력하실 수 없습니다.");
        obj.value = obj.value.substring( 0 , obj.value.length - 1 ); // 입력한 특수문자 한자리 지움
    }
}

//모든특수문자용
function AllCharacterCheck(obj){
    var regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>\#$%&\'\"\\@\(\=]/gi;
    if( regExp.test(obj.value) ){
        alert("특수문자는 입력하실수 없습니다.");
        obj.value = obj.value.substring( 0 , obj.value.length - 1 ); // 입력한 특수문자 한자리 지움
    }
}


