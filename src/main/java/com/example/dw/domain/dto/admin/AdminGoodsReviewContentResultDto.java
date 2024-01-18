package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminGoodsReviewContentResultDto {

    private String orderReviewContent;
    private String userAccount;
    private Integer rating;
    private LocalDateTime orderReviewRd;
    private List<AdminGoodsReviewImgList> reviewImg;


    public AdminGoodsReviewContentResultDto(String orderReviewContent, String userAccount, Integer rating, LocalDateTime orderReviewRd, List<AdminGoodsReviewImgList> reviewImg) {
        this.orderReviewContent = orderReviewContent;
        this.userAccount = userAccount;
        this.rating = rating;
        this.orderReviewRd = orderReviewRd;
        this.reviewImg = reviewImg;
    }
}
