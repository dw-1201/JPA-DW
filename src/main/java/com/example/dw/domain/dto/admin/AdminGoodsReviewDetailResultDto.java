package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsReviewDetailResultDto {

    private Long orderReviewId;
    private AdminGoodsReviewInfoDto goodsInfo;
    private AdminGoodsReviewContentResultDto reviewContent;


    public AdminGoodsReviewDetailResultDto(Long orderReviewId, AdminGoodsReviewInfoDto goodsInfo, AdminGoodsReviewContentResultDto reviewContent) {
        this.orderReviewId = orderReviewId;
        this.goodsInfo = goodsInfo;
        this.reviewContent = reviewContent;
    }
}
