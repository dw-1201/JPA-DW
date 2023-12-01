let $input = $('#post-image');
let $img = $('.img');
// console.log($input);

// file change이벤트로 미리보기 갱신하기
$input.on('change', function () {
    let files = this.files;
      console.log(files);
      console.log("안녕");  
    // 길이 체크함수 (files, 원하는 길이)
    let newFiles = checkLength(files, 1);
    console.log(newFiles);
    updateImg(newFiles);
});

// 클릭 이벤트로 이미지 지우고 미리보기 갱신하기
$img.on('click', function (e) {
    let name = $(e.target).data('name');
    console.log(e.target);
    console.log(name);
    removeImg(name);
    updateImg($input[0].files);
    
});

// //미리보기 삭제 함수
function removeImg(name) {
    let dt = new DataTransfer();

    let files = $input[0].files;

    for (let i = 0; i < files.length; i++) {
        if (files[i].name !== name) {
            dt.items.add(files[i]);
        }
    }
    $input[0].files = dt.files;
    console.log($input[0].files);
}

// //파일 길이 체크 함수(체크할 files객체, 제한할 길이)
function checkLength(files, num) {
    if (files.length > num) {
        alert(`파일은 ${num}개까지만 첨부 가능합니다.`);
        // 최대 수를 넘으면 비어있는 files객체 반환
        return new DataTransfer().files;
    }
    return files;
}


// // 이미지 수가 1개보다 적으면 기본이미지로 대체함
function updateImg(files) {
    for (let i = 0; i < 1; i++) {
        console.log(files);
        if (i < files.length) {
            console.log(files.length);
            let src = URL.createObjectURL(files[i]);
            console.log(src);
            $('.img').eq(i).css('background-image', `url(${src})`).css('background-size', 'cover').data('name', `${files[i].name}`);

            $('.img').addClass('x-box');
            console.log("성공!");
        } else {
            $('.img')
                .eq(i)
                .css(
                    'background',
                    'url(/mypg/img/b556fdf429d8de25c3acf62f8186ddb9.png) no-repeat'
                ).css(
                    'backgroundSize',
                    '150px 150px'
                )
                .data('name', null);
                $('.img').eq(i).removeClass('x-box');
            
        }
    }
}


//주소찾기 API
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

//간단소개 글자수 제한 코드 
function limitText(){
    $("#interduce-content").keyup(function(e) {
        let contents = $('#interduce-content').val();
      
        $(".interduce-length-check").html(`<span class="overWrite">  ${getTextLength(contents) + ' / 200'}  </span>`); //실시간 글자수 카운팅
        $('.overWrite').css('fontSize', '13px');
        $('.overWrite').css('float', 'right');
        if (getTextLength(contents) > 200) {
            $('.overWrite').css('color', 'red')
            
        }
    });
}

function getTextLength(text) {
    let len = 0;
    for (let i = 0; i < text.length; i++) {
        if (escape(text.charAt(i)).length == 6) {
            len++;
        }
        len++;
    }
    return len;
}

$('document').ready(function(){
    limitText();
})



$('.join-submit-btn').on('click', function () {
    let content = $('#interduce-content').val();


    if(commonReply.getTextLength(content)>200){
        alert("200자 이내로만 작성 가능합니다.");
        return;
    }
});




//회원탈퇴 클리시 확인 이벤트 
$('.user-delete-btn').on('click',function(){

    if(confirm("정말로 탈뢰하시겠습니까?")){

    }else{

    }

});


$('.join-submit-btn').on('click', function () {

    alert("수정이 완료되었습니다.");
    

});