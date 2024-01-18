package com.example.dw.domain.dto.admin;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

//전체조회한 것들 중에 상품 상세사진(여러개)를 리스트로 담기위한 DTO
@Data
public class AdminGoodsDetailResultDto {


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
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private int saleCount;
    private double ratingAvg;
    private List<AdminGoodsDetailImgDto> goodsDetailImgs;

    public AdminGoodsDetailResultDto(Long id, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, String goodsCertify, String goodsDetailContent, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate, String goodsCategory, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid, int saleCount, double ratingAvg) {
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
        this.saleCount = saleCount;
        this.ratingAvg = ratingAvg;
    }


    public AdminGoodsDetailResultDto(Long id, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, String goodsCertify, String goodsDetailContent, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate, String goodsCategory, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid, int saleCount, double ratingAvg, List<AdminGoodsDetailImgDto> goodsDetailImgs) {
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
        this.saleCount = saleCount;
        this.ratingAvg = ratingAvg;
        this.goodsDetailImgs = goodsDetailImgs;
    }
}
