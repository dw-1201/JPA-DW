// 검색어 입력 이벤트 감지
import * as list from './module/list.js'
import * as page from './module/page.js';

let userId = $('#userId').val()
console.log(userId)

// 검색폼 (카테, 키워드 반환)
function searchGoodsForm(){
    let cate = $('#search-cate').val();
    let keyword = $('#shop-search-keyword').val();

    if(cate ==='최신순'){
        cate = '';
    }
    return {
        cate : cate,
        keyword : keyword
    };
}

// 검색 결과 조회
$('.result-submit-btn').on('click', function (){
    shopList(0,searchGoodsForm(),'goods', 'goodsList', showShopList);

});

// 문서가 준비되면 초기 데이터로 쇼핑 리스트 조회
$(document).ready(function (){

    shopList(0,searchGoodsForm(),'goods', 'goodsList', showShopList);
    enterKey('#shop-search-keyword', '.goods-list-search-btn');

})

function shopList(page, searchForm){
    $.ajax({
        url:`/shops/shopList/${page}`,
        type:'get',
        data: searchForm,
        dataType:'json',
        success: function(result) {
            console.log(result.pageable);
            console.log(result.content);
            showShopList(result.content);
            pagination(result);
        },
        error: function(a, b, c) {
            console.error(c);
        }
    });
}
//엔터키
function enterKey(a,b){
    $(a).keypress(function(e){
        //검색어 입력 후 엔터키 입력하면 조회버튼 클릭
        if(e.keyCode && e.keyCode == 13){
            $(b).trigger("click");
            return false;
        }
        //엔터키 막기
        if(e.keyCode && e.keyCode == 13){
            e.preventDefault();
        }
    });
}

// 검색어 입력창에서 검색 버튼 클릭 시 동작
$('.result-submit-btn').on('click', function () {
    // 전역 변수에 할당하지 않고, 함수 호출 시에 값을 전달
    shopList(0, searchGoodsForm());
});

//리스트
function showShopList(result) {
    let text = '';
    let textInput = $('.ul-list');

    result.forEach(r => {
        text += createShopListItem(r);
    });

    textInput.html(text);
}

// 리스트 아이템 생성 함수
function createShopListItem(r) {
    let listItem = `
        <li class="li-list">
            <a href="/shop/shopDetail/${r.id}">
                <div class="list-div"> 
        `;

    listItem += `
            <div class="li-list-full-img">
                <img src="/shops/shopImg?fileFullPath=${r.goodsMainImgPath}/${r.goodsMainImgUuid}_${r.goodsMainImgName}" alt="" class="li-img" >
            </div>
        `;

    listItem += `
            <div>
                <div class="list-name1"></div>
                <div class="list-name2">${r.goodsName}</div>
            </div>
            <div class="reviw">
                <img src="https://store.bemypet.kr/wp-content/themes/bemypet-store-child/assets/images/star_rate@3x.png" alt="" width="16">
                &nbsp;
                <div>4.9</div>
                <div class="reviw1">
                    <span>리뷰</span>
                    <span>&nbsp;10</span>
                </div>
            </div>
            <div class="won">
                <span id="price">${addCommas(r.goodsPrice)}</span>
                <span>&nbsp;원</span>
            </div>
        </div>
    </a>
    <div class="basket">
    `;
    if(userId != null){
        listItem += `
     <a href="/shop/shopCart/${userId}"><img src="/img/shoppingcart.png" alt=""></a>
    `;
    }else{
        listItem += `
     <a href="/user/enterLogin"><img src="/img/shoppingcart.png" alt=""></a>
    `;
    }
    listItem += `
    
    </div>
    </li>
    `;

    return listItem;
}

function pagination(result) {
    let paginations = $('.pagination-ul');
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

        if (currentPage > 0) {
            paginations.append(`<li><a href="#" data-page="${currentPage - 1}">&lt;</a></li>`);
        }

        for (let i = startPage; i <= endPage; i++) {
            paginations.append(`<li><a href="#" data-page="${i}">${i + 1}</a></li>`);
        }

        if (currentPage < totalPages - 1) {
            paginations.append(`<li><a href="#" data-page="${currentPage + 1}">&gt;</a></li>`);
        }
    }

    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        shopList(page, searchGoodsForm());
    });
}

// 콤마 찍기 함수
function addCommas(number) {
    return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
