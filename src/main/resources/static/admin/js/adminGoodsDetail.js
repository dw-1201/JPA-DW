
//상품 수정 페이지 이동
$('.modify-btn').on('click', function(){

    let goodsId = $(this).data('goodsid')

    window.location.href="/admin/modify/" + goodsId;
})

//상품 삭제
$('.delete-btn').on('click', function (){

    let goodsId = $(this).data('goodsid')

    if(confirm("상품을 삭제하시겠습니까?")){
        window.location.href="/admin/delete/" + goodsId;

    }

})





$(document).ready(function(){
    $('.goods-related-info-title').on('click', function(){

        let add = $('.goods-related-q-container');
        add.stop().slideToggle(400);

    })
    $('.goods-related-review-title').on('click', function(){

        let add = $('.goods-related-review-container');
        add.stop().slideToggle(400);

    })
})



