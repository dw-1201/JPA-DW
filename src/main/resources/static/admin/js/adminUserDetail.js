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

function orderListInput(result){

    let text = '';
    let textInputSection = $('.order-list');
    let totalQuantity = 0;
    let totalPrice = 0;

    result.content.forEach(r=>{




            const orderItems = r.orderGoodsList;
            const orderItemsCount = orderItems.length;


            orderItems.forEach(etc =>{
                totalQuantity += etc.orderQuantity;
            })

            for(let i =0; i<orderItemsCount; i++){

                totalPrice += orderItems[i].orderPrice * orderItems[i].orderQuantity

            }

            if(orderItemsCount > 1){

                const restItemsCount = orderItemsCount - 1;

                text += `
                 <tr>
                    <td class="community-title" >${orderItems[0].goodsName} 외 ${restItemsCount}개 </td>
            `
            }else {
                text += `
                <tr>
                    <td class="community-title" >${orderItems[0].goodsName} </td>
                
                `;
            }


            text +=`
            <td class="community-reg-date">${form.formatDates(r.orderTime)}</td>
            <td class="community-count">${totalQuantity} ea</td>
            <td class="community-reply">${form.addCommas(totalPrice)}원</td>
         </tr>
        
        `;



    })

    textInputSection.html(text);
    let paginations = $('.order-list-pagination');

    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        orderList(userId,page, orderListInput)
    });
}