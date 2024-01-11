package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.order.OrderItem;
import com.example.dw.domain.entity.order.Orders;
import jakarta.persistence.EntityListeners;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class GoodsPaySingleFrom {

    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private String goodsQuantity;
    private String goodsPrice;
    @CreatedDate
    private LocalDateTime inputTime;
    @Builder
    public GoodsPaySingleFrom(Long orderId, Long goodsId, String goodsName, String goodsQuantity, String goodsPrice, LocalDateTime inputTime) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.inputTime = inputTime;
    }


    public OrderItem toEntity(){
        // 문자열에서 공백을 제거하고 정수로 변환
        int quantity = Integer.parseInt(goodsQuantity.trim());
        int price = Integer.parseInt(goodsPrice.trim());

        return OrderItem.builder()
                .orders(Orders.builder().id(orderId).build())
                .goods(Goods.builder().id(goodsId).build())
                .orderQuantity(quantity)
                .orderPrice(price)
                .build();
    }
}
