
//공지게시판
//슬라이드 업다운
$(document).ready(function() {
    $('.admin-notice-lists').each(function() {
        let $toggle = $(this).find('.rr');

        $toggle.click(function() {
            let $currentSection = $(this).next('.notice-content');

            // 현재 항목 열고/닫기
            $currentSection.stop().slideToggle(400);
            // 다른 항목 닫기
            $(this).parent().siblings().find('.notice-content').slideUp(400);
        });
    });
});

//공지게시판
//마우스 클릭 효과
$(document).ready(function(){
    $('.rr').on('click', function(){

        let $currentSection = $(this).children('.row')
        $currentSection.toggleClass('active');


        $(this).parent().siblings().find('.row').removeClass('active');

    })
})



//faq 등록 페이지 이동
$('.notice-faq-btn').on('click',function(){
    window.location.href="/admin/html/adminFaqReg.html";
})

//faq 수정 페이지 이동
$('.faq-modify-btn').on('click',function(){
    window.location.href="/admin/html/adminFaqModify.html";
})

//공지사항 등록 페이지 이동
$('.notice-reg-btn').on('click',function(){
    window.location.href="/admin/html/adminNoticeReg.html";
})

//공지사항 수정 페이지 이동
$('.notice-modify-btn').on('click',function(){
    window.location.href="/admin/html/adminNoticeModify.html";
})