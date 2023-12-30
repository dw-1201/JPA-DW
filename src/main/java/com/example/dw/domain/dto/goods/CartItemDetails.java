package com.example.dw.domain.dto.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemDetails {

    private Long id; //cartitem id

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


    public CartItemDetails(Long id, Long goodsId, String goodsName, int goodsQuantity, int goodsPrice, Long goodsMainImgId, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid) {
        this.id = id;
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
