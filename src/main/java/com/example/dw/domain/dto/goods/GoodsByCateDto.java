package com.example.dw.domain.dto.goods;

import com.example.dw.domain.entity.goods.GoodsCategory;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//상품 카테코리 리스트 조회 DTO
@Data
@NoArgsConstructor
public class GoodsByCateDto {

    private Long goodsId;
    private String goodsName;
    private int goodsQuantity; //수량
    private int goodsPrice;
    private String goodsMade;
    private LocalDateTime goodsRegisterDate;
    private LocalDateTime goodsModifyDate;
    private String goodsCate;  // GoodsCategory를 문자열로 변환
    //상품 이미지
    private Long goodsMainImgId;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;

    @QueryProjection
    public GoodsByCateDto(Long goodsId, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate, String goodsCate, Long goodsMainImgId, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
        this.goodsCate = goodsCate;
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
    }

    // 새로운 생성자 추가
    @QueryProjection
    public GoodsByCateDto(Long goodsId, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate, GoodsCategory goodsCate, Long goodsMainImgId, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
        this.goodsCate = goodsCate != null ? goodsCate.toString() : null; // GoodsCategory를 문자열로 변환
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
    }
}


