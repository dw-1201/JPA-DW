package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsReviewListDto {

    private Long orderReviewId;
    private String goodsCategory;
    private String goodsName;
    private String orderReviewContent;
    private Integer rating;
    private LocalDateTime orderReviewRd;
    private Integer adminReplyState;


    @QueryProjection
    public AdminGoodsReviewListDto(Long orderReviewId, String goodsCategory, String goodsName, String orderReviewContent, Integer rating, LocalDateTime orderReviewRd, Integer adminReplyState) {
        this.orderReviewId = orderReviewId;
        this.goodsCategory = goodsCategory;
        this.goodsName = goodsName;
        this.orderReviewContent = orderReviewContent;
        this.rating = rating;
        this.orderReviewRd = orderReviewRd;
        this.adminReplyState = adminReplyState;
    }



    public AdminGoodsReviewListDto(String goodsCategory, String goodsName, String orderReviewContent, LocalDateTime orderReviewRd, Integer adminReplyState) {
        this.goodsCategory = goodsCategory;
        this.goodsName = goodsName;
        this.orderReviewContent = orderReviewContent;
        this.orderReviewRd = orderReviewRd;
        this.adminReplyState = adminReplyState;
    }
}
