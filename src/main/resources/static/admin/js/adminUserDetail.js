import * as form from './module/form.js'
import * as page from './module/pagination.js';
let userId = $('#userId').val()


$(document).ready(function (){


    orderList(userId,0, orderListInput)
})



//회원 주문내역
function orderList(userId, page, callback){

    $.ajax({

        url:`/admins/userOrderList/${userId}/${page}`,
        type:'get',
        dataType:'json',
        success : function (result){

            console.log(result)

            if(callback){
                callback(result);
            }
        }
    })
}

function orderListInput(result) {
    let userId = $('#userId').val()
    let text = '';
    let textInputSection = $('.order-list');

    result.content.forEach(orderInfo => {

        //총 주문금액
        $('.total-price').text(form.addCommas(orderInfo.totalPrice) +'원')


        orderInfo.orders.forEach(order => {

            let totalQuantity = 0;
            let eachTotalPrice = 0;

            const orderItems = order.orderGoodsList;
            const orderItemsCount = orderItems.length;

            orderItems.forEach(item => {
                totalQuantity += item.orderQuantity;
                eachTotalPrice += item.orderQuantity * item.orderPrice
            });

            if (orderItemsCount > 1) {
                const restItemsCount = orderItemsCount - 1;
                text += `
                    <tr>
                        <td class="community-title"><a href="/admin/orderDetail/${userId}/${order.orderId}">${orderItems[0].goodsName} 외 ${restItemsCount}개 </a></td>

                `;
            } else {
                text += `
                    <tr>
                        <td class="community-title"><a href="/admin/orderDetail/${userId}/${order.orderId}">${orderItems[0].goodsName}</a> </td>

                `;
            }

            text += `
            <td class="community-reg-date">${form.formatDates(order.orderTime)}</td>
            <td class="community-count">${totalQuantity} ea</td>
            <td class="community-reply">${form.addCommas(eachTotalPrice)}원</td>
            </tr>
            `

        });

    });

    textInputSection.html(text);
    let paginations = $('.order-list-pagination');

    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        orderList(userId,page, orderListInput)
    });
}