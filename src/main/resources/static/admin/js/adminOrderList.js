import * as date from './module/form.js'


$('.detail-btn').on('click', function(){

    window.location.href="/admin/html/adminOrderDetail.html";

})

$(document).ready(function (){
    //첫화면
    orderList(0, searchForm(), showList)


    //상세보기 이동

    $('.order-list').on('click', '.detail-btn', function (){
        let userId = $(this).closest('.list-btns').find('#userId').val();
        let orderId = $(this).closest('.list-btns').find('.detail-btn').data('orderid')

        window.location.href="/admin/orderDetail/" +userId +'/'  + orderId;

    })

})


$('.result-submit-btn').on('click', function (){

    orderList(0, searchForm(), showList)


})








function searchForm(){

    let cate = $('#search-cate').val();
    let keyword = $('#search-keyword').val();
    let prev = $('#prev-order').val();
    let next = $('#next-order').val();

    return {

        cate :cate,
        keyword : keyword,
        prev : prev,
        next : next
    }
}





function orderList(page, searchForm,callback){

    $.ajax({

        url:`/admins/orderList/${page}`,
        type:'get',
        data : searchForm,
        success : function (result){

            console.log(result)
            if(callback){
                callback(result)
            }

        },error : function (a,b,c){
            console.error(c);
        }

    })
}


function showList(result) {
    let text = '';
    let textInputSection = $('.order-list');

    result.content.forEach(order => {


        let totalQuantity = 0;
        let totalPrice = 0;


        text += `
            <tr>
                <td>${order.adminOrderInfo.orderId}</td>
                <td>${order.adminOrderInfo.userAccount}</td>
        `;

        const items = order.adminOrderInfo.adminOrderItems;
        const itemsCount = items.length;

        if (itemsCount > 0) {

            items.forEach(etc => {
                totalQuantity += etc.goodsQuantity;

            })

            if (itemsCount > 1) {
                const restItemsCount = itemsCount - 1;
                text += `<td>${items[0].goodsName} 외 ${restItemsCount}개</td>`;
            }else {
                text += `<td>${items[0].goodsName}</td>`;
            }
        }

        text += `
                <td>${totalQuantity}EA</td>`;

            for(let i = 0; i<itemsCount; i++){
                totalPrice += items[i].goodsQuantity * items[i].goodsPrice;

            }

        text+=` <td>${totalPrice}원</td>
                <td>${date.formatDates(order.payDatetime)}</td>
                <td class="list-btns">
                    <input type="hidden" value="${order.adminOrderInfo.userId}" id="userId"/>
                    <button type="button" class="detail-btn btn" data-orderid="${order.adminOrderInfo.orderId}">상세보기</button>
                </td>
            </tr>
        `;
    });

    textInputSection.html(text);
}





$(function (){

    $('#prev-order').datepicker({
        showOn: 'both',
        showButtonPanel: true,
        buttonImage: "/img/calendarIcon.png",
        buttonImageOnly:true,
        currentText: '오늘 날짜',
        closeText: '닫기',
        dateFormat: 'yy-mm-dd'

    })

    $('#next-order').datepicker({
        showOn: 'both',
        showButtonPanel: true,
        buttonImage: "/img/calendarIcon.png",
        buttonImageOnly:true,
        currentText: '오늘 날짜',
        closeText: '닫기',
        dateFormat: 'yy-mm-dd'
    })

})
