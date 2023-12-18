package com.example.dw.domain.dto.admin;

import lombok.Data;

@Data
public class AdminGoodsDetailImgDto {


    private Long id;
    private String goodsDetailImgName;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;
    private Long goodsId;


    public AdminGoodsDetailImgDto(Long id, String goodsDetailImgName, String goodsDetailImgPath, String goodsDetailImgUuid, Long goodsId) {
        this.id = id;
        this.goodsDetailImgName = goodsDetailImgName;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
        this.goodsId = goodsId;
    }
}
