import * as goodsReg from './imgModule/img.js'





// 상품 메인사진
let goodsMainImg = $('#goods-main-img');
let goodsMainImgList = $('.goods-main-img-p');


// file change이벤트로 미리보기 갱신하기
goodsMainImg.on('change', function () {
    let files = this.files;
    //   console.log(files);

    // 길이 체크함수 (files, 원하는 길이)
    let newFiles = goodsReg.checkLength(files, 1);

    goodsReg.appendImg(goodsMainImgList, newFiles, 1);
});

// 클릭 이벤트로 이미지 지우고 미리보기 갱신하기
goodsMainImgList.on('click', function (e) {
    let name = $(e.target).data('name');
    goodsReg.removeImg(goodsMainImg, name);
    goodsReg.appendImg(goodsMainImgList, goodsMainImg[0].files, 1);
});


//상품 설명사진
let goodsDetailImg = $('#goods-detail-img');
let goodsDetailImgList = $('.goods-detail-img-p');

// file change이벤트로 미리보기 갱신하기
goodsDetailImg.on('change', function () {
    let files = this.files;
    //   console.log(files);

    // 길이 체크함수 (files, 원하는 길이)
    let newFiles = goodsReg.checkLength(files, 4);

    goodsReg.appendImg(goodsDetailImgList, newFiles, 4);
});

// 클릭 이벤트로 이미지 지우고 미리보기 갱신하기
goodsDetailImgList.on('click', function (e) {
    let name = $(e.target).data('name');
    goodsReg.removeImg(goodsDetailImg, name);
    goodsReg.appendImg(goodsDetailImgList, goodsDetailImg[0].files, 4);
});



// 모든 정보 기입 유효성 검사
function goodsRegister(){

$('.reg-submit-btn').on('click', function(){


   
    

    let goodsCate = $('#goods-cate').val();
    let goodsName = $('#goods-name').val();
    let goodsQuantity =$('#goods-quantity').val();
    let goodsPrice = $('#goods-price').val();
    let goodsMadeIn = $('#goods-made-in').val();
    let goodsCertify = $('#goods-certify').val();
    let goodsContent = $('#goods-detail').val();
    let goodsMainImg = $('#goods-main-img').val();
    let goodsDetailImg = $('#goods-detail-img').val();

    // console.log('상품카테번호 : ' + goodsCate);
    // console.log('상품명 : ' + goodsName);
    // console.log('상품수량 : ' + goodsQuantity)
    // console.log('상품가격 : ' + goodsPrice);
    // console.log('상품원산지 : ' + goodsMadeIn);
    // console.log('인증허가 : ' + goodsCertify)
    // console.log('상품설명 : ' + goodsContent);
    // console.log('상품메인사진 : ' + goodsMainImg);
    // console.log('상품상세사진1 : ' + goodsDetailImg);

   
    

    if(!(goodsName && goodsQuantity && goodsPrice && goodsMadeIn && goodsCertify && goodsContent && goodsMainImg && goodsDetailImg)){
        alert("모든 정보를 입력해주세요")
        return false;
    }

    $('#goods-img-form').submit();
    return true;

})

}

$('document').ready(function(){
	goodsRegister();
})
