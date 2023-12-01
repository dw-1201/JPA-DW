//파일 추가 코드
let $input = $('#post-image');
let $img = $('.img-area');
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
    for (let i = 0; i <= 1; i++) {

        if (i <= files.length) {
            console.log(files.length);
            let src = URL.createObjectURL(files[i]);
            console.log(src);
            $('.img-area img').eq(i).attr('src', src).data('name', `${files[i].name}`);

            
        } else {
            $('.img-area img')
                .eq(i)
                .attr('src',"../img/b556fdf429d8de25c3acf62f8186ddb9.png")
                .data('name', null);
            
        }
    }
}

/**************************************************/ 

/* 닉네임 유효성검사 스크립트 */
function checkNick() {

    let nick = $(".inp-name").val();
    console.log(nick);
    let reg =/^[가-힣a-zA-Z0-9]{1,10}$/;

    let nickCheck = reg.test(nick);
    console.log(nickCheck);
    $('.inp-name').on('keyup',function () {

        if(nickCheck) {
            $('.nonename').css("display", "none");
            console.log("실행!");
        } else {
            $('.nonename').css("display", "block");
            console.log("미실행!")
        }

    });
}

/*날짜 기입 자동 - 생성*/ 
$('.inp-birth').on('input',function(){
    let inputDay = $(this).val().replace(/-/g,'');
    let reg = /^\d{8}$/;
    console.log(inputDay);
    if(reg.test(inputDay)){
            inputDay = inputDay.slice(0,4) + '-' + inputDay.slice(4,6) +  '-' + inputDay.slice(6, 8);
        }else {
            // 잘못된 입력이면 값을 지우고 다시 작성할 수 있도록 처리
            $(this).val('');
          }

    $(this).val(inputDay);
})

/*날짜 기입 유효성 검사 */ 
$('.inp-birth').on('keyup',function () {
    let day = $(".inp-birth").val();
    console.log(day);
    let reg =/^(19|20)\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;

    let dayCheck = reg.test(day);
    
    console.log(dayCheck);
    
    if(dayCheck) {
        $('.noneday').css("display", "none");
        console.log("성공!");
    } else {
        $('.noneday').css("display", "block");
        console.log("실패!")
    }

});

/*품종 한글로 작성 유효성검사 */ 
    // $('.inp-type').on('keyup',function () {
    //     let type = $(".inp-type").val();
    //     console.log(type);
    //     let reg =/^[가-힣]{2,10}$/;
    
    //     let typeCheck = reg.test(type);
    //     console.log(typeCheck);

    //     if(typeCheck) {
    //         $('.nonetype').css("display", "none");
    //         console.log("실행!");
    //     } else {
    //         $('.nonetype').css("display", "block");
    //         console.log("미실행!")
    //     }

    // });


/*등록 버튼 클릭시 확인 버튼 이벤트*/
$('.registerbtn').on('click',function(){
    
    if(confirm("등록하시겠습니까?")){
        alert("등록되었습니다.");
        window.location.href="/mypg/html/mypgpet.html";
         
    }else{
        alert("취소하였습니다.");
    }

});