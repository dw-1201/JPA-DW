function verifiedCode(){

    $('.submit-code-btn').on('click', function(){

        let userName = $('#userName').val();
        let userPhone = $('#userPhone').val();
        let userEmail = $('#userEmail').val();

        if(!(userName && userPhone && userEmail)){

            $('.input-userInfo').css('display','block')
            return false;
        }else {
            $('.input-userInfo').css('display','none')
            return true;
        }

    })

}
$('document').ready(function(){
    verifiedCode()
})



$('.mark').on('mouseenter', function(){
    $('.miss-info-content').toggleClass('on');
})



