package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsDetailReviewListDto {
    private Long orderReviewId;
    private String orderReviewContent;
    private Integer rating;
    private LocalDateTime orderReviewRd;
    private Integer state;

    @QueryProjection

    public AdminGoodsDetailReviewListDto(Long orderReviewId, String orderReviewContent, Integer rating, LocalDateTime orderReviewRd, Integer state) {
        this.orderReviewId = orderReviewId;
        this.orderReviewContent = orderReviewContent;
        this.rating = rating;
        this.orderReviewRd = orderReviewRd;
        this.state = state;
    }
}
