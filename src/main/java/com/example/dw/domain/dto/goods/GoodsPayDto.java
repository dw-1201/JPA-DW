package com.example.dw.domain.dto.goods;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class GoodsPayDto {

    private Long id;
    //임의 추가
    private Long orderId;

    private Long goodsId;
    private String goodsName;
    private Integer goodsQuantity;
    private Integer goodsPrice;
    private Long userId;

    public GoodsPayDto(Long id, Long orderId, Long goodsId, String goodsName, Integer goodsQuantity, Integer goodsPrice, Long userId) {
        this.id = id;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.userId = userId;
    }

    public GoodsPayDto(Long orderId, Long goodsId, String goodsName, Integer goodsQuantity, Integer goodsPrice, Long userId) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.userId = userId;
    }
}
