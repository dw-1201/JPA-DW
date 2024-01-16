package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsReviewResultDto {



    private Long orderReviewId;
    private AdminGoodsReviewListDtoWithoutId orderReviewContent;

    public AdminGoodsReviewResultDto(Long orderReviewId, AdminGoodsReviewListDtoWithoutId orderReviewContent) {
        this.orderReviewId = orderReviewId;
        this.orderReviewContent = orderReviewContent;
    }
}
