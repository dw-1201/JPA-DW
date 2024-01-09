package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.order.OrderItem;
import com.example.dw.domain.entity.order.Orders;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsPayListFrom {

    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private String goodsQuantity;
    private String goodsPrice;

    @Builder
    public GoodsPayListFrom(Long orderId, Long goodsId, String goodsName, String goodsQuantity, String goodsPrice) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
    }

    public OrderItem toEntity(){
        return OrderItem.builder()
                .orders(Orders.builder().id(orderId).build())
                .goods(Goods.builder().id(goodsId).build())
                .orderQuantity(Integer.valueOf(goodsQuantity))
                .orderPrice(Integer.valueOf(goodsPrice))
                .build();
    }
}
