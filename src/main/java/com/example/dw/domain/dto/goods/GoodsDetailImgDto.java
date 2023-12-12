package com.example.dw.domain.dto.goods;

import lombok.Data;

@Data
public class GoodsDetailImgDto {


    private Long id;
    private String goodsDetailImgName;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;
    private Long goodsId;


    public GoodsDetailImgDto(Long id, String goodsDetailImgName, String goodsDetailImgPath, String goodsDetailImgUuid, Long goodsId) {
        this.id = id;
        this.goodsDetailImgName = goodsDetailImgName;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
        this.goodsId = goodsId;
    }
}
