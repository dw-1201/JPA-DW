package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsReviewInfo {


    private Long goodsId;
    private String goodsCategory;
    private String goodsName;
    private String goodsContent;
    private double ratingAvg;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private String goodsMainImgName;

    @QueryProjection

    public AdminGoodsReviewInfo(Long goodsId, String goodsCategory, String goodsName, String goodsContent, double ratingAvg, String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName) {
        this.goodsId = goodsId;
        this.goodsCategory = goodsCategory;
        this.goodsName = goodsName;
        this.goodsContent = goodsContent;
        this.ratingAvg = ratingAvg;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsMainImgName = goodsMainImgName;
    }
}
