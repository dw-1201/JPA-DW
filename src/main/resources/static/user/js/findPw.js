function verifiedCode(){

    $('.submit-code-btn').on('click', function(){

        let userName = $('#userName').val();
        let userId = $('#userId').val();
        let userEmail = $('#userEmail').val();

        if(!(userName && userId && userEmail)){

            $('.input-userInfo').css('display','block')
            $('.send-email').css('display','none');

            return;
        }else {
            $('.input-userInfo').css('display','none');
            $('.email-form').css('display', 'none');
            $('.send-email').css('display','block');
            $.ajax({

                url:'/mail/mail',
                type:'post',
                data:{
                    mail : userEmail
                },
                success : function (result){
                    $('#verifiedCode').attr("readonly", false);
                    $('#confirm').attr("value", result);
                }

            })

        }

    })

}


function confirmNumber(){

    $('.result-submit-btn').on('click', function (){

        let number1 = $("#verifiedCode").val();
        let number2 = $("#confirm").val();
        let userName = $('#userName').val();
        let userAccount = $('#userId').val();
        let userEmail = $('#userEmail').val();

        if(userName && userAccount && userEmail){

            $.ajax({

                url:'/user/accountCheckForPw',
                type: 'post',
                data:{
                    userName : userName,
                    userAccount : userAccount,
                    userEmail : userEmail
                },
                success : function (result){
                    console.log(result)

                    if(number1 == number2 && number1){

                        if(result){

                            $.ajax({
                                url : '/mail/userPassword',
                                type:'post',
                                data : {
                                    userName : userName,
                                    userAccount : userAccount,
                                    userEmail : userEmail
                                },
                                success : function (result){
                                    window.location.href="/user/enterLogin"
                                }
                            })

                            alert("일치하는 회원정보를 찾았습니다.");
                            alert("이메일로 임시 비밀번호를 발송했습니다. 로그인 페이지로 이동합니다.");
                        }else {
                            $('.non-search-result').css('display','block');
                            $('.input-number-validation').css('display','none');

                            alert("회원 정보를 찾을 수 없습니다.");
                        }

                    }else {
                        $('.input-number-validation').css('display','block');
                        $('.non-search-result').css('display','none');
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


