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



// faq 등록 페이지 이동
$('.notice-faq-btn').on('click',function(){
    window.location.href="/admin/faqWrite";
})
// //faq 수정 페이지 이동
// $('.faq-list').on('click','.faq-modify-btn',function(){
//
//     let faqBoardId = $('.faq-modify-btn').data('faqnum')
//     window.location.href="/admin/faqModify?faqBoardId=" + faqBoardId ;
//
//
//
// })

//faq 삭제
$('.faq-list').on('click','.faq-delete-btn',function(){

    let faqBoardId = $('.faq-delete-btn').data('faqnum')

    if(confirm("삭제하시겠습니까?")){
        window.location.href="/admin/faqDelete/" + faqBoardId ;
    }

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
    faqList(0,searchFaqForm());
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
    faqList(0, searchFaqForm());

})

function faqList( page,searchForm, callback){


    $.ajax({

        url:`/admins/noticeList/${page}`,
        type:'get',
        data:searchForm,
        dataType:'json',
        success :function (result){
            console.log(result.pageable)
            console.log(result.number)

            console.log(result.content)


           showFaqList(result.content)
            pagination(result)

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
                                <a href="/admin/faqModifyPage/${r.id}"><button class="faq-modify-btn btns" type="button" data-faqnum="${r.id}">수정</button></a>
                                <button class="faq-delete-btn btns" type="button" data-faqnum="${r.id}">삭제</button>
                            </div>
                        </section>
                 </div>
            
        
        `;

    })
    textInput.html(text);
}

function pagination(result) {
    let paginations = $('.faq-pagination-ul');
    paginations.empty();

    const totalPages = result.totalPages;
    const currentPage = result.number;

    if (totalPages > 0) {
        const maxButtons = 5;
        let startPage = Math.max(0, currentPage - Math.floor(maxButtons / 2));
        let endPage = Math.min(totalPages - 1, startPage + maxButtons - 1);

        if (totalPages <= maxButtons) {
            startPage = 0;
            endPage = totalPages - 1;
        } else if (endPage - startPage < maxButtons - 1) {
            startPage = Math.max(0, totalPages - maxButtons);
        }
        //화살표 <
        if (currentPage > 0) {
            paginations.append(`<li><a href="#" data-page="${currentPage - 1}">&lt;</a></li>`);
        }else{
            paginations.append(`<li></li>`)
        }

        //페이징 버튼
        for (let i = startPage; i <= endPage; i++) {
            if(i==currentPage){
                paginations.append(`<li><a href="#" class="active-btn" data-page="${i}">${i + 1}</a></li>`);

            }else{
                paginations.append(`<li><a href="#" data-page="${i}">${i + 1}</a></li>`);

            }
        }


        //화살표 >
        if (currentPage < totalPages - 1) {
            paginations.append(`<li><a href="#" data-page="${currentPage + 1}">&gt;</a></li>`);
        }else{
            paginations.append(`<li></li>`)
        }
    }

    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        faqList(page, searchFaqForm());
    });
}



$(function() {
    $("#faq-search-keyword").keypress(function(e){
        //검색어 입력 후 엔터키 입력하면 조회버튼 클릭
        if(e.keyCode && e.keyCode == 13){
            $(".result-faq-submit-btn").trigger("click");
            return false;
        }
        //엔터키 막기
        if(e.keyCode && e.keyCode == 13){
            e.preventDefault();
        }
    });

});








