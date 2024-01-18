import * as list from './module/list.js';
import  * as page from './module/pagination.js';
import * as form from './module/form.js';


//등록 페이지 이동
$('.move-to-reg ').on('click', function(){
    window.location.href="/admin/goodsReg";
})

function searchGoodsForm(){
    let cate = $('#search-cate').val();
    let keyword = $('#goods-search-keyword').val();

    if(cate ==='전체보기'){
        cate = '';
    }

    return {
        cate : cate,
        keyword : keyword
    };
}

//검색결과
$('.result-submit-btn').on('click', function (){
    list.list(0,searchGoodsForm(),'admins', 'goodsList', showGoodsList);

})


$(document).ready(function (){

    list.list(0,searchGoodsForm(),'admins', 'goodsList', showGoodsList);
    page.enterKey('#goods-search-keyword', '.goods-list-search-btn');

})


function showGoodsList(result){
    let text ='';
    let textInput = $('.goods-table-lists');
    
    result.content.forEach(r=>{


        text += `
                      <tr class="goods-lists">
                        <td>${r.id}</td>
                        <td>${r.goodsCategory}</td>
                        <td>${r.goodsName}</td>
                        <td>${form.addCommas(r.goodsPrice)}원</td>
                        <td>${form.addCommas(r.goodsQuantity - r.goodsSaleCount)} ea</td>
                        <td>${form.addCommas(r.goodsSaleCount)} ea</td>
                        <td>${form.formatDates(r.goodsRegisterDate)}</td>
                        `;
        if(r.goodsRegisterDate == r.goodsModifyDate){
           text += `    <td>-</td>`;
        } else {
            text += `   <td>${form.formatDates(r.goodsModifyDate)}</td>`;

        }
        text+=`
                        <td class="list-btns">
                            <a href="/admin/detail/${r.id}"><button type="button" class="detail-btn btn" data-goodsnum="${r.id}">상세보기</button></a>
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
        list.list(page, searchGoodsForm(),'admins', 'goodsList', showGoodsList);
    });

}