import * as form from './module/form.js';
import * as page from './module/pagination.js';
import * as list from './module/list.js';

let userId = $('#userId').val();


$(document).ready(function () {

    // Qna - 첫 화면
    list.simpleList('admins', 'userQnaList', userId, 0, renderQnaBoardList);

    // 회원 주문내역
    list.simpleList('admins', 'userOrderList', userId, 0, orderListInput);

    $('.board-tap-ul li').on('click', function () {
        $('.board-tap-ul li').removeClass('active-btn');
        $(this).addClass('active-btn');
    });

    $('.qna-btn').on('click', function (e) {
        e.preventDefault();
        list.simpleList('admins', 'userQnaList', userId, 0, renderQnaBoardList);

    });

    $('.walk-btn').on('click', function (e) {
        e.preventDefault();
        list.simpleList('admins','userWalkList', userId, 0, renderWalkBoardList)
    });

});




function renderQnaBoardList(result) {
    let text = '';
    let textInputSection = $('.extra-info-list');
    let totalCount = $('.total-count');
    let paginations = $('.board-pagination-ul');


    totalCount.empty();
    totalCount.text(result.totalElements);


        result.content.forEach(r => {


                    text += `
                        <tr>
                            <td class="community-title"><a href="/admin/questionDetail/${r.qnaBoardId}">${r.qnaBoardTitle}</a></td>
                            <td class="community-reg-date">${form.formatDates(r.qnaBoardRd)}</td>
                            <td class="community-count">${r.viewCount}</td>
                            <td class="community-reply">${r.replyCount}</td>
                        </tr>`;

        });

    textInputSection.html(text);
    page.pagination(result, paginations);
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.simpleList('admins', 'userQnaList', userId, page, renderQnaBoardList);
    })
}



function renderWalkBoardList(result) {
    let text = '';
    let textInputSection = $('.extra-info-list');
    let totalCount = $('.total-count');
    let paginations = $('.board-pagination-ul');


    totalCount.empty();
    totalCount.text(result.totalElements);


    result.content.forEach(r => {


        text += `
                        <tr>
                            <td class="community-title"><a href="/admin/walkMateDetail/${r.walkMateId}">${r.walkMateTitle}</a></td>
                            <td class="community-reg-date">${form.formatDates(r.walkMateRd)}</td>
                            <td class="community-count">${r.viewCount}</td>
                            <td class="community-reply">${r.replyCount}</td>
                        </tr>`;

    });

    textInputSection.html(text);
    page.pagination(result, paginations);
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        list.simpleList('admins', 'userWalkList', userId, page, renderWalkBoardList);
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
        list.simpleList('admins', 'userOrderList', userId, page, orderListInput);
    });
}
