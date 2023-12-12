//인증번호 전송
function verifiedCode(){

    $('.submit-code-btn').on('click', function(){

        let userName = $('#userName').val();
        let userPhone = $('#userPhone').val();
        let userEmail = $('#userEmail').val();

        if(!(userName && userPhone && userEmail)){

            $('.input-userInfo').css('display','block');
            $('.send-email').css('display','none');

            return;
        }
         else{
            $('.input-userInfo').css('display','none');
            $('.email-form').css('display', 'none');
            $('.send-email').css('display','block');

            alert("인증메일이 전송되었습니다.")

            $.ajax({

                url:'/mail/mail',
                type:'post',
                data :{mail : userEmail},
                success : function (result){
                    $('#verifiedCode').attr("readonly", false);
                    $('#confirm').attr("value", result);
                }
            })
        }
    }
)}

//인증번호 확인 및 계정 정보 메일 전송
function confirmNumber() {

    $('.result-submit-btn').on('click', function () {
        let number1 = $("#verifiedCode").val();
        let number2 = $("#confirm").val();
        let userName = $('#userName').val();
        let userPhone = $('#userPhone').val();
        let userEmail = $('#userEmail').val();

        if (userName && userPhone && userEmail) {
            $.ajax({

                url: '/user/accountCheck',
                type: 'post',
                data: {
                    userName: userName,
                    userPhone: userPhone,
                    userEmail: userEmail
                },
                success: function (result) {
                    console.log(result);

                        if(number1 == number2 && number1){
                            if(result){
                                $.ajax({

                                    url:'/mail/userAccountCheck',
                                    type:'post',
                                    data:{
                                        userName :userName,
                                        userEmail:userEmail,
                                        userPhone:userPhone
                                    },
                                    success:function (result){


                                        window.location.href="/user/enterLogin"

                                    }

                                })
                                alert("일치하는 회원정보를 찾았습니다.");
                                alert("이메일로 회원정보를 발송했습니다. 로그인 페이지로 이동합니다.");
                            }else{
                                $('.non-search-result').css('display','block');
                                $('.input-number-validation').css('display','none');

                                alert("회원 정보를 찾을 수 없습니다.");
                            }
                        } else {
                            $('.input-number-validation').css('display','block');
                            $('.non-search-result').css('display','none');

                            // alert("인증번호를 다시 확인해주세요.")

                        }


                },
                error : function (a,b,c){
                    console.error(c);
                }


            })

        }else {
            alert("계정 정보를 입력해주세요")
        }
    })
}


$('document').ready(function(){
    verifiedCode()
    confirmNumber()
})



$('.mark').on('mouseenter', function(){
    $('.miss-info-content').toggleClass('on');
})
$('.miss-info-content').on('mouseleave', function(){
    $('.miss-info-content').removeClass('on');
});


