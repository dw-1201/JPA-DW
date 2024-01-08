package com.example.dw.domain.dto.goods;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsPayListDto {

    private Long goodsId;
    private String goodsName;
    private String goodsQuantity;
    private String goodsPrice;

    @Builder

    public GoodsPayListDto(Long goodsId, String goodsName, String goodsQuantity, String goodsPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
    }
}
