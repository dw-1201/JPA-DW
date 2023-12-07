package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

//전체 조회 DTO
@Data
@NoArgsConstructor
public class GoodsDetailDto {


    private Long id;
    private String goodsName;
    private Long goodsQuantity;
    private Long goodsPrice;
    private String goodsMade;
    private String goodsCertify;
    private String goodsDetailContent;
    private String goodsRegisterDate;
    private String goodsModifyDate;
    private String goodsCategory;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private String goodsDetailImgName;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;

    @QueryProjection
    public GoodsDetailDto(Long id, String goodsName, Long goodsQuantity, Long goodsPrice,
                          String goodsMade, String goodsCertify, String goodsDetailContent, String goodsRegisterDate,
                          String goodsModifyDate, String goodsCategory, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid,
                          String goodsDetailImgName, String goodsDetailImgPath, String goodsDetailImgUuid) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsCertify = goodsCertify;
        this.goodsDetailContent = goodsDetailContent;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
        this.goodsCategory = goodsCategory;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsDetailImgName = goodsDetailImgName;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
    }
}

