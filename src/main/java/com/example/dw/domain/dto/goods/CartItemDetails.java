package com.example.dw.domain.dto.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemDetails {

    private Long id; //cartitem id
    private Integer cartItemQuantity;

    //상품
    private Long goodsId;
    private String goodsName;
    private int goodsPrice;
    //이미지
    private Long goodsMainImgId;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;


    public CartItemDetails(Long id, Integer cartItemQuantity, Long goodsId, String goodsName, int goodsPrice, Long goodsMainImgId, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid) {
        this.id = id;
        this.cartItemQuantity = cartItemQuantity;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
    }
}
