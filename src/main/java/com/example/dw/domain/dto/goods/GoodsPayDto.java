package com.example.dw.domain.dto.goods;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsPayDto {

    private Long goodsId;
    private String goodsName;
    private String goodsQuantity;
    private String goodsTotalPrice;

    @Builder
    public GoodsPayDto(Long goodsId, String goodsName, String goodsQuantity, String goodsTotalPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsTotalPrice = goodsTotalPrice;
    }
}
