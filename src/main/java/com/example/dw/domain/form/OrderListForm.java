package com.example.dw.domain.form;

import com.example.dw.domain.entity.order.OrderList;
import com.example.dw.domain.entity.order.Orders;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderListForm {

    private Long id;
    private String orderDate;

    //주문서 Id
    private Long orderId;

    public OrderList toEntity(){
        return OrderList.builder()
                .id(id)
                .orderDate(orderDate)
                .orders(Orders.builder().id(orderId).build())
                .build();
    }

    @Builder
    public OrderListForm(Long id, String orderDate, Long orderId) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderId = orderId;
    }
}
