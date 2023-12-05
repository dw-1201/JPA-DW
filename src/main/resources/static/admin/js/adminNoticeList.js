//faq 슬라이딩
$(document).ready(function() {
    // Use event delegation to bind click event to a static parent element
    $('.admin-faq-list-container').on('click', '.admin-notice-lists .rr', function() {
        let $currentSection = $(this).next('.notice-content');

        // Toggle the current section
        $currentSection.stop().slideToggle(400);
        // Collapse other sections
        $(this).parent().siblings().find('.notice-content').slideUp(400);
    });
});



//공지게시판
//슬라이드 업다운
// $(document).ready(function() {
//     $('.admin-notice-lists').each(function() {
//         let $toggle = $(this).find('.rr');
//
//         $toggle.click(function() {
//             let $currentSection = $(this).next('.notice-content');
//
//             // 현재 항목 열고/닫기
//             $currentSection.stop().slideToggle(400);
//             // 다른 항목 닫기
//             $(this).parent().siblings().find('.notice-content').slideUp(400);
//         });
//     });
// });

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
    window.location.href="/admin/faqWrite";
})

//faq 수정 페이지 이동
$('.faq-modify-btn').on('click',function(){
    window.location.href="/admin/html/adminFaqModify.html";
})

//공지사항 등록 페이지 이동
$('.notice-reg-btn').on('click',function(){
    window.location.href="/admin/noticeWrite";
})

//공지사항 수정 페이지 이동
$('.notice-modify-btn').on('click',function(){
    window.location.href="/admin/html/adminNoticeModify.html";
})

$(document).ready(function (){
    faqList(searchFaqForm());
})

//input에서 받은 결과를 넘긴다.
function searchFaqForm(){
    let cate = $('#faq-search-cate').val();
    let keyword = $('#faq-search-keyword').val();


    return {
        cate : cate,
        keyword : keyword
    };
}


$('.result-faq-submit-btn').on('click', function (){
    faqList(searchFaqForm());

})

function faqList( searchForm, callback){


    $.ajax({

        url:'/admins/noticeList',
        type:'get',
        data:searchForm,
        dataType:'json',
        success :function (result){
            console.log(result)
           showFaqList(result)

        },error : function (a,b,c){
            console.error(c);
        }


    })
}





function showFaqList(result){

    let text ='';
    let textInput = $('.faq-list');

    result.forEach(r=>{

        text+= `
            <div class="admin-notice-lists admin-faq-lists">
                    <div class="admin-notice-list-table rr">
                        <div class="notice-number row">${r.id}</div>
                        <div class="notice-title row">${r.faqBoardTitle}</div>
                        <div class="notice-reg-date row">${r.faqBoardRd}</div>
                        `;
        if(r.faqBoardMd != r.faqBoardRd){
            text+=`        <div class="notice-reg-date row">${r.faqBoardMd}</div>`;

            }else {
            text+=`        <div class="notice-reg-date row"> - </div>`;

            }
            text+=`       
                <div class="notice-view-count row">${r.faqBoardViewCount}</div>
                        
                    </div>
                        <section class="notice-content">
                            <p>${r.faqBoardContent}</p>
                            <div class="notice-etc">
                                <button class="faq-modify-btn btns" type="button" ${r.id}>수정</button>
                                <button class="faq-delete-btn btns" type="button" ${r.id}>삭제</button>
                            </div>
                        </section>
                 </div>
            
        
        
        `;

    })
    textInput.html(text);

}












