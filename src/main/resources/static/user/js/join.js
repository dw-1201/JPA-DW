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
            document.getElementById('address').value = addr;
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
   
    $('.join-submit-btn').on('click', function(){


        let userId = $("#userId").val();
        let userEmail = $("#userEmail").val();
        let userName = $("#userName").val();
        let pwCh = $("#userPassword").val();
        let pwCh2 = $("#userPasswordCh").val();
        let userPhone = $("#userPhone").val();
        let userPostCode = $('#addressPost').val();
        let userAddress = $("#address").val();
        let userAddressDetails = $("#addressDetails").val();


            if($inputs.filter(":checked").length < $inputs.length){
                alert("약관 동의를 확인해주세요")
                return false;
            }

            if($('.userIdCh').css('display')=='block'){
                alert("아이디 양식을 확인해주세요.")
                return false;
            }

            if($('.userPw-unavailable').css('display')=='block'){
                alert("비밀번호 양식을 확인해주세요.")
                return false;
            }


            if($('.userPwCh').css('display')=='block'){
                alert("비밀번호 확인이 일치하지 않습니다.")
                return false;
            }

            if($('.userPhoneCh').css('display')=='block'){
                alert("휴대폰 번호 양식을 확인해주세요");
                return false;
            }

            if($('.userEmailCh').css('display')=='block'){
                alert("이메일 양식을 확인해주세요");
                return false;
            }

            if (!(userId && userEmail && userName && pwCh && pwCh2 && userPhone && userPostCode && userAddress && userAddressDetails)) {

                alert("모든 정보를 입력해주세요")
                return false;
            }
            $('#join_form').submit();
	        alert(userName + " 님 환영합니다.")
	        return true;
    })


}
$('document').ready(function(){
	join();
})

//아이디 양식 체크
function checkId(){
    $('#userId').keyup(function(){
        let userId = $(this).val();
        const idCheck = /^[a-z0-9][a-z0-9]*$/;

        let id = idCheck.test(userId);

        if(id && (userId.length>=6 && userId.length <=13)){
            $('.userIdCh').css('display', 'none')
        }else {
            $('.userIdCh').css('display', 'block')

        }

    })
}
checkId();



//비밀번호 양식 체크
function checkPw() {

	let pw = $("#userPassword").val();
	let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_=+])(?=.*[0-9]).{8,15}$/;

	let pwCheck = reg.test(pw);

	$('#userPassword').on('keyup', function() {

		if (pwCheck) {
			$('.userPw-unavailable').css("display", "none");
			$('.userPw-available').css('display', 'block');
		} else {
			$('.userPw-unavailable').css("display", "block");
			$('.userPw-available').css('display', 'none');
		}
	});
}

// 비밀번호 확인 체크
$('#userPasswordCh').keyup(function() {

	let pw = $("#userPassword").val();
	let pwCh = $("#userPasswordCh").val();

	if (pw != pwCh) {
		$('.userPwCh').css('display', 'block');
        $('.userPwChOk').css('display', 'none');

	
		return;
	} else {
		$('.userPwCh').css('display', 'none');
        $('.userPwChOk').css('display', 'block');

	}

});

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