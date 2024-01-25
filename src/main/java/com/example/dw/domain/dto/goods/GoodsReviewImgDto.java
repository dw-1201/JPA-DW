package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

//리뷰 이미지 조회 Dto
@Data
public class GoodsReviewImgDto {

    //리뷰 이미지
    private Long reviewimgId;
    private String reviewimgFileName;
    private String reviewimgPath;
    private String reviewimgUuid;

    @QueryProjection
    public GoodsReviewImgDto(Long reviewimgId, String reviewimgFileName, String reviewimgPath, String reviewimgUuid) {
        this.reviewimgId = reviewimgId;
        this.reviewimgFileName = reviewimgFileName;
        this.reviewimgPath = reviewimgPath;
        this.reviewimgUuid = reviewimgUuid;
    }
}


