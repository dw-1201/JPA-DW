package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsReviewListDtoWithoutId {

    private String goodsCategory;
    private String goodsName;
    private String orderReviewContent;
    private Integer rating;
    private LocalDateTime orderReviewRd;
    private Integer adminReplyState;


    public AdminGoodsReviewListDtoWithoutId(String goodsCategory, String goodsName, String orderReviewContent, Integer rating, LocalDateTime orderReviewRd, Integer adminReplyState) {
        this.goodsCategory = goodsCategory;
        this.goodsName = goodsName;
        this.orderReviewContent = orderReviewContent;
        this.rating = rating;
        this.orderReviewRd = orderReviewRd;
        this.adminReplyState = adminReplyState;
    }
}
