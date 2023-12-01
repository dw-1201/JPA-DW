//클릭시 해당 리뷰 삭제 (비동기 succes에 넣기)
$('.rebtn').on('click',function(){
   let ids = $('.rebtn').data();
    if(confirm("정말 삭제하시겠습니까?")){
        window.location.href=''+ids;
    }else{
        window.location.href='';
    }   
})


// 리뷰 게시판 클릭스 수정하기 페이지 이동
$('.list-content').on('click',function(){
    // let ids = $('.list-content').data();
     window.location.href='/mypg/html/reviewupdate.html';
 })