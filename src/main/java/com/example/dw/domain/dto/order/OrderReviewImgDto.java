package com.example.dw.domain.dto.order;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderReviewImgDto {

    private Long id;
    private Long orderReviewId;

    private String reviewimgFileName;
    private String reviewimgPath;
    private String reviewimgUuid;

    @QueryProjection
    public OrderReviewImgDto(Long id, Long orderReviewId, String reviewimgFileName, String reviewimgPath, String reviewimgUuid) {
        this.id = id;
        this.orderReviewId = orderReviewId;
        this.reviewimgFileName = reviewimgFileName;
        this.reviewimgPath = reviewimgPath;
        this.reviewimgUuid = reviewimgUuid;
    }
}
