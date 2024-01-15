package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

//상품 리스트 조회 DTO
@Data
public class GoodsDetailDto {

    private Long id;
    private String goodsName;
    private int goodsQuantity; //수량
    private int goodsPrice;
    private String goodsMade;
    private String goodsDetailContent;
    private LocalDateTime goodsRegisterDate;
    private LocalDateTime goodsModifyDate;
    private String goodsCategory;
    //상품 이미지
    private Long goodsMainImgId;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;

    @QueryProjection
    public GoodsDetailDto(Long id, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, String goodsDetailContent, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate, String goodsCategory, Long goodsMainImgId, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsDetailContent = goodsDetailContent;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
        this.goodsCategory = goodsCategory;
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
    }
}


