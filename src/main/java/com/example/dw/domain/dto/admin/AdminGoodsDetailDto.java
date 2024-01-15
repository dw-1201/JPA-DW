package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

//전체 조회 DTO
@Data
public class AdminGoodsDetailDto {


    private Long id;
    private String goodsName;
    private int goodsQuantity;
    private int goodsPrice;
    private String goodsMade;
    private String goodsCertify;
    private String goodsDetailContent;
    private LocalDateTime goodsRegisterDate;
    private LocalDateTime goodsModifyDate;
    private String goodsCategory;
    private Long goodsMainImgId;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private Long goodsDetailImgId;
    private String goodsDetailImgName;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;
    private int saleCount;

    @QueryProjection
    public AdminGoodsDetailDto(Long id, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, String goodsCertify, String goodsDetailContent, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate, String goodsCategory, Long goodsMainImgId, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid, Long goodsDetailImgId, String goodsDetailImgName, String goodsDetailImgPath, String goodsDetailImgUuid, int saleCount) {
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
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsDetailImgId = goodsDetailImgId;
        this.goodsDetailImgName = goodsDetailImgName;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
        this.saleCount = saleCount;
    }
}


