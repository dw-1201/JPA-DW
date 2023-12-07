import * as list from './module/list.js'
import  * as page from './module/pagination.js';


//등록 페이지 이동
$('.move-to-reg ').on('click', function(){
    window.location.href="/goods/goodsReg";
})


//상품 상세 보기
$('.detail-btn').on('click', function(){
    window.location.href="/admin/";
})

function searchGoodsForm(){
    let cate = $('#search-cate').val();
    let keyword = $('#search-keyword').val();


    return {
        cate : cate,
        keyword : keyword
    };
}


//검색결과
$('.result-submit-btn').on('click', function (){
    list.list(0,searchGoodsForm(),'goodsr', 'goodsList', showGoodsList);

})


$(document).ready(function (){

    list.list(0,searchGoodsForm(),'goodsr', 'goodsList', showGoodsList);
})


function showGoodsList(result){
    let text ='';
    let textInput = $('.goods-lists');
    
    result.content.forEach(r=>{


        text += `
        
                            <tr class="goods-lists">

                        <td>${r.goodsName}</td>
                        <td>${r.goodsPrice}원</td>
                        <td>${r.goodsQuantity} ea</td>
                        <td>추후 조인</td>
                        <td>${r.goodsRegisterDate}</td>
                        `;
        if(r.goodsRegisterDate = r.goodsModifyDate){
           text += ` <td>-</td>`;
        } else {
            text += `<td>${r.goodsModifyDate}</td>`;

        }
        text+=`
                        <td class="list-btns">
                            <button type="button" class="detail-btn btn">상세보기</button>
                        </td>
                                            </tr>

        `;

    })

    textInput.html(text);
    let paginations = $('.pagination-ul');


    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.list(page, searchGoodsForm(),'goodsr', 'goodsList', showGoodsList);
    });

}