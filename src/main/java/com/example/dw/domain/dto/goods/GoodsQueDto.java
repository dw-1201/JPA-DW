package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

//상품 문의 조회 DTO
@Data
public class GoodsQueDto {

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

    //유저정보
    private Long userId;
    private String userAccount;
    private String userNickName;

    @QueryProjection
    public GoodsQueDto(Long id, String queContent, String queRegisterDate, String queModifyDate, Long goodsQueReplyId, String queReplyContent, String queReplyRegisterDate, String queReplyModifyDate, Long userId, String userAccount, String userNickName) {
        this.id = id;
        this.queContent = queContent;
        this.queRegisterDate = queRegisterDate;
        this.queModifyDate = queModifyDate;
        this.goodsQueReplyId = goodsQueReplyId;
        this.queReplyContent = queReplyContent;
        this.queReplyRegisterDate = queReplyRegisterDate;
        this.queReplyModifyDate = queReplyModifyDate;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
    }
}


