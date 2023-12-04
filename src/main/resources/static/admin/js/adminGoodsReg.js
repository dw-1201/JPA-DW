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



