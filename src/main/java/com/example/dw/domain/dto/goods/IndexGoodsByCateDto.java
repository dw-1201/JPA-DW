package com.example.dw.domain.dto.goods;

import com.example.dw.domain.entity.goods.GoodsCategory;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IndexGoodsByCateDto {

    private Long goodsId;
    private String goodsName;
    private Integer goodsPrice;
    private Double ratingAvg;
    private String goodsCate;
    private Long goodsImgId;
    private String goodsImgPath;
    private String goodsImgUuid;
    private String goodsImgName;


    @QueryProjection
    public IndexGoodsByCateDto(Long goodsId, String goodsName, Integer goodsPrice, Double ratingAvg, String goodsCate, Long goodsImgId, String goodsImgPath, String goodsImgUuid, String goodsImgName) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.ratingAvg = ratingAvg;
        this.goodsCate = goodsCate;
        this.goodsImgId = goodsImgId;
        this.goodsImgPath = goodsImgPath;
        this.goodsImgUuid = goodsImgUuid;
        this.goodsImgName = goodsImgName;
    }

    // 새로운 생성자 추가
    @QueryProjection
    public IndexGoodsByCateDto(Long goodsId, String goodsName, Integer goodsPrice, Double ratingAvg, GoodsCategory goodsCate, Long goodsImgId, String goodsImgPath, String goodsImgUuid, String goodsImgName) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.ratingAvg = ratingAvg;
        this.goodsCate = goodsCate != null ? goodsCate.toString() : null; // GoodsCategory를 문자열로 변환
        this.goodsImgId = goodsImgId;
        this.goodsImgPath = goodsImgPath;
        this.goodsImgUuid = goodsImgUuid;
        this.goodsImgName = goodsImgName;
    }
}
