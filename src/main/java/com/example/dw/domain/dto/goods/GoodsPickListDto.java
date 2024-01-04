package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

//고객의 주문내역 조회
@Data
@NoArgsConstructor
public class GoodsPickListDto {
    //goodspaylist
    private Long id;
    private Integer goodsQuantity;
    private Integer goodsPrice;
    //goods
    private Long goodsId;
    private String goodsName;
    //user
    private Long userId;

    @QueryProjection
    public GoodsPickListDto(Long id, Integer goodsQuantity, Integer goodsPrice, Long goodsId, String goodsName, Long userId) {
        this.id = id;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.userId = userId;
    }
}
