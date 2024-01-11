package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminOrderItem {


    private Long goodsId;
    private String goodsName;
    private Integer goodsPrice;
    private Integer goodsQuantity;


    @QueryProjection
    public AdminOrderItem(Long goodsId, String goodsName, Integer goodsPrice, Integer goodsQuantity) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsQuantity = goodsQuantity;
    }
}
