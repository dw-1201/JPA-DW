
//헤더 픽스
$(document).ready(function (){

    let headerInnerHeight = $('.header').innerHeight();

    $(window).scroll(function (){

        let currentScroll = $(this).scrollTop() >= headerInnerHeight;

        if(currentScroll){
            $('.header-section02').css('position', 'fixed');
            $('.header-section02').css('top', '0');
            //픽스 상태에서 좌우 스크롤
            $(".header-section02").css("left", 0 - $(this).scrollLeft());

        }else {
            $('.header-section02').css('position', 'relative');
            $(".header-section02").css("left", 0 );

        }
    })
})


