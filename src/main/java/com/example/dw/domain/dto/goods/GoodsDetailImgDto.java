package com.example.dw.domain.dto.goods;

import lombok.Data;

@Data
public class GoodsDetailImgDto {


    private Long id;
    private String goodsDetailImgName;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;
    private Long goodsDetailImgId;


    public GoodsDetailImgDto(Long id, String goodsDetailImgName, String goodsDetailImgPath, String goodsDetailImgUuid
    ,Long goodsDetailImgId) {
        this.id = id;
        this.goodsDetailImgName = goodsDetailImgName;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
        this.goodsDetailImgId=goodsDetailImgId;
    }



}
