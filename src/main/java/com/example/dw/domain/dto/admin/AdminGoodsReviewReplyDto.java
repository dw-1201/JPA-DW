package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsReviewReplyDto {

    private Long id;
    private String goodsReviewReplyContent;
    private LocalDateTime goodsReviewReplyRd;
    private LocalDateTime goodsReviewReplyMd;



    @QueryProjection
    public AdminGoodsReviewReplyDto(Long id, String goodsReviewReplyContent, LocalDateTime goodsReviewReplyRd, LocalDateTime goodsReviewReplyMd) {
        this.id = id;
        this.goodsReviewReplyContent = goodsReviewReplyContent;
        this.goodsReviewReplyRd = goodsReviewReplyRd;
        this.goodsReviewReplyMd = goodsReviewReplyMd;
    }
}
