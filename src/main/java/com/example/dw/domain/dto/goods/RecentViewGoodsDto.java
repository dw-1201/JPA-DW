package com.example.dw.domain.dto.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecentViewGoodsDto {


    private Long goodsId;
    private String goodsName;
    private Long goodsPrice;


    public RecentViewGoodsDto(Long goodsId, String goodsName, Long goodsPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }
}
