package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminUserDetailPaymentListDto {


    private Long orderId;
    private LocalDateTime orderTime;

    private Long goodsId;
    private String goodsName;
    private Integer orderQuantity;
    private Integer orderPrice;


    @QueryProjection
    public AdminUserDetailPaymentListDto(Long orderId, LocalDateTime orderTime, Long goodsId, String goodsName, Integer orderQuantity, Integer orderPrice) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }
}
