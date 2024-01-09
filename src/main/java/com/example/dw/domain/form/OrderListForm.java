package com.example.dw.domain.form;

import com.example.dw.domain.entity.order.OrderList;
import com.example.dw.domain.entity.order.Orders;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderListForm {

    //주문서 Id
    private Long orderId;

    public OrderList toEntity(){
        return OrderList.builder()
                .orders(Orders.builder().id(orderId).build())
                .build();
    }

    @Builder
    public OrderListForm(Long orderId) {
        this.orderId = orderId;
    }
}
