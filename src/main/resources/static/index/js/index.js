$(document).ready(function (){


    $('.walk-mate-more-btn').on('click', function (){

        location.href="/walk/walkList";

    })



    indexGoodsByCategoryList('간식', goodsByCategory)
    
    $('.shop-item-category li').on('click', function (){
        $('.shop-item-category li').removeClass('active-cate');
        $(this).addClass('active-cate');

        let cate = $(this).text();
        console.log(cate)
        indexGoodsByCategoryList(cate, goodsByCategory)

    })
})







function indexGoodsByCategoryList(cate, callback){

    $.ajax({

        url : '/indexes/goodsByCate',
        type:'get',
        data : {
            cate : cate
        },
        success : function (result){
            if(callback){
                callback(result)
            }

        },error : function (a,b,c){
            console.error(c)
        }

    })

}


function goodsByCategory(result){

    let text = '';
    let textInputSection = $('.shop-lists')

    result.forEach(r=>{

        text +=`
    <div class="shop-main-img">`;


        if(r.goodsCate == '간식'){
            text += `<img src="/img/goods-snack.jpg" alt="상품 카테 메인 사진"/>`;
            
        }else if(r.goodsCate =='영양제'){
            text += `<img src="/img/1.jpg" alt="상품 카테 메인 사진"/>`;

        }else if(r.goodsCate =='위생용품'){
            text += `<img src="/img/1.jpg" alt="상품 카테 메인 사진"/>`;

        }else if(r.goodsCate =='이동장'){
            text += `<img src="/img/1.jpg" alt="상품 카테 메인 사진"/>`;

        }else if(r.goodsCate =='장난감'){
            text += `<img src="/img/1.jpg" alt="상품 카테 메인 사진"/>`;

        }else if(r.goodsCate =='하네스/줄'){
            text += `<img src="/img/1.jpg" alt="상품 카테 메인 사진"/>`;

        }


        text +=` 
        </div>
        <div class="shop-item-list">
            <ul class="shop-item-list-ul">
          <li>
            <a href="#">
            <div class="item-img">
                <img src="/indexes/goodsImg?fileFullPath=${r.goodsImgPath +'/'+ r.goodsImgUuid +'_'+ r.goodsImgName}" alt="상품 사진"/>
            </div>
            <div class="item-detail">
                <ul class="item-detail-ul">
                    <li class="review-avg">★★★★★</li>
                    <li class="item-name">${r.goodsName}</li>
                    <li class="item-price">${r.goodsPrice}원</li>
                </ul>
            </div>
            </a>
        </li>
            </ul>
        </div>
        
        `;



    })

    textInputSection.html(text);
}


