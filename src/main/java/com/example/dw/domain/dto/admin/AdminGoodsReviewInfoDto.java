package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsReviewInfoDto {

    private Long goodsId;
    private String goodsCategory;
    private String goodsName;
    private String goodsDetailContent;
    private double ratingAvg;


    private AdminGoodsReviewMainImgDto goodsImg;


    public AdminGoodsReviewInfoDto(Long goodsId, String goodsCategory, String goodsName, String goodsDetailContent, double ratingAvg, AdminGoodsReviewMainImgDto goodsImg) {
        this.goodsId = goodsId;
        this.goodsCategory = goodsCategory;
        this.goodsName = goodsName;
        this.goodsDetailContent = goodsDetailContent;
        this.ratingAvg = ratingAvg;
        this.goodsImg = goodsImg;
    }
}
