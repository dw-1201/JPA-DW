package com.example.dw.domain.dto.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsPayDto {

    private Long id;
    private Long goodsId;
    private String goodsName;
    private Integer goodsQuantity;
    private Integer goodsPrice;
    private Long userId;

    public GoodsPayDto(Long id, Long goodsId, String goodsName, Integer goodsQuantity, Integer goodsPrice, Long userId) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.userId = userId;
    }
}
