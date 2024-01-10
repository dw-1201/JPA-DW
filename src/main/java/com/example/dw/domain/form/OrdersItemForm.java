package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.order.OrderItem;
import com.example.dw.domain.entity.order.Orders;
import lombok.*;

// 결제 완료시 저장되는 주문성 상품 내용
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrdersItemForm {

    //주문번호
    private Long orderId;
    //상품번호
    private Long goodsId;

    private Integer orderQuantity;
    private Integer orderPrice;

    public OrderItem toEntity(){
        return OrderItem.builder()
                .orders(Orders.builder().id(orderId).build())
                .goods(Goods.builder().id(goodsId).build())
                .orderQuantity(orderQuantity)
                .orderPrice(orderPrice)
                .build();

    }

    @Builder
    public OrdersItemForm(Long orderId, Long goodsId, Integer orderQuantity, Integer orderPrice) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }
}
