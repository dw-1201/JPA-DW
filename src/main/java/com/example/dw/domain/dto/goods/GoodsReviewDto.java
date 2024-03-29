package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

//문의 리스트 조회 DTO
@Data
public class GoodsReviewDto {
    //리뷰 번호
    private Long id;
    private String title;
    private String content;
    private LocalDateTime reviewRd;
    private Integer rating;
    //리뷰 답변
    private Long goodsReviewReplyId;
    private String goodsReviewReplyContent;
    private LocalDateTime  goodsReviewReplyRD;
    private LocalDateTime  goodsReviewReplyMD;
    //상품
    private Long goodsId;
    //상품아이템
    private Long orderItemId;
    //유저정보
    private Long userId;
    private String userAccount;
    private String userNickName;

    private Long reviewimgId;
    private String reviewimgFileName;
    private String reviewimgPath;
    private String reviewimgUuid;


    @QueryProjection
    public GoodsReviewDto(Long id, String title, String content, LocalDateTime reviewRd, Integer rating, Long goodsReviewReplyId, String goodsReviewReplyContent, LocalDateTime goodsReviewReplyRD, LocalDateTime goodsReviewReplyMD, Long goodsId, Long orderItemId, Long userId, String userAccount, String userNickName, Long reviewimgId, String reviewimgFileName, String reviewimgPath, String reviewimgUuid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.reviewRd = reviewRd;
        this.rating = rating;
        this.goodsReviewReplyId = goodsReviewReplyId;
        this.goodsReviewReplyContent = goodsReviewReplyContent;
        this.goodsReviewReplyRD = goodsReviewReplyRD;
        this.goodsReviewReplyMD = goodsReviewReplyMD;
        this.goodsId = goodsId;
        this.orderItemId = orderItemId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.reviewimgId = reviewimgId;
        this.reviewimgFileName = reviewimgFileName;
        this.reviewimgPath = reviewimgPath;
        this.reviewimgUuid = reviewimgUuid;
    }
}


