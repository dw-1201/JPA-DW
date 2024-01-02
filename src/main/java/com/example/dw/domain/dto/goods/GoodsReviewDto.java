package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

//상품 리스트 조회 DTO
@Data
public class GoodsReviewDto {
    //상품 문의
    private Long id;
    private String queContent;
    private String queRegisterDate;
    private String queModifyDate;
    //상품 답변
    private Long goodsQueReplyId;
    private String queReplyContent;
    private String queReplyRegisterDate;
    private String queReplyModifyDate;
    //상품
    private Long goodsId;
    //유저정보
    private Long userId;
    private String userAccount;
    private String userNickName;


    @QueryProjection

    public GoodsReviewDto(Long id, String queContent, String queRegisterDate, String queModifyDate,
                          Long goodsQueReplyId, String queReplyContent, String queReplyRegisterDate,
                          String queReplyModifyDate, Long goodsId, Long userId, String userAccount,
                          String userNickName) {
        this.id = id;
        this.queContent = queContent;
        this.queRegisterDate = queRegisterDate;
        this.queModifyDate = queModifyDate;
        this.goodsQueReplyId = goodsQueReplyId;
        this.queReplyContent = queReplyContent;
        this.queReplyRegisterDate = queReplyRegisterDate;
        this.queReplyModifyDate = queReplyModifyDate;
        this.goodsId = goodsId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
    }
}


