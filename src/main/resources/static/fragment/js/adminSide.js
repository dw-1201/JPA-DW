$(document).ready(function() {
    let floatPosition = parseInt($(".admin-fragment").css('top'));

    $(window).scroll(function() {
    let scrollTop = $(window).scrollTop() ;
    let attachedPosition = scrollTop + floatPosition + "px";

    $(".admin-fragment").css('top', attachedPosition);
    

    }).scroll();

    });

$(document).ready(function(){
    let adminHeaderHeight = $('.top-section').height();
    console.log(adminHeaderHeight)


    $(window).scroll(function(){
        let fixedAdminTitle = $(this).scrollTop()>=adminHeaderHeight;

        if(fixedAdminTitle){
            $('.admin-hidden-title').css('display', 'flex')
            $('.admin-hidden-title').fadeIn(100);
        }else {
            $('.admin-hidden-title').hide();

        }
    })
})
