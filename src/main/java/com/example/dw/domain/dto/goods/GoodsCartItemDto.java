package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

// 카트 리스트 조회를 위한 DTO
@Data
public class GoodsCartItemDto {

    //카트 아이템
    private Long id;
    private Integer cartItemQuantity;

    private Long cartId;
    private Long userId;
    //상품
    private Long goodsId;
    private String goodsName;
    private int goodsQuantity;
    private int goodsPrice;
    //이미지
    private Long goodsMainImgId;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;

    @QueryProjection
    public GoodsCartItemDto(Long id, Integer cartItemQuantity, Long cartId, Long userId, Long goodsId, String goodsName, int goodsQuantity, int goodsPrice, Long goodsMainImgId, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid) {
        this.id = id;
        this.cartItemQuantity = cartItemQuantity;
        this.cartId = cartId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
    }
}
