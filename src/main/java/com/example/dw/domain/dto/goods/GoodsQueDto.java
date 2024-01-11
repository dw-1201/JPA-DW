package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

//상품 문의 조회 DTO
@Data
public class GoodsQueDto {

    //상품 문의
    private Long id;
    private String queContent;
    private LocalDateTime queRegisterDate;
    private LocalDateTime queModifyDate;

    //상품 답변
    private Long goodsQueReplyId;
    private String queReplyContent;
    private LocalDateTime queReplyRegisterDate;
    private LocalDateTime queReplyModifyDate;

    //유저정보
    private Long userId;
    private String userAccount;
    private String userNickName;

    @QueryProjection
    public GoodsQueDto(Long id, String queContent, LocalDateTime queRegisterDate, LocalDateTime queModifyDate, Long goodsQueReplyId, String queReplyContent, LocalDateTime queReplyRegisterDate, LocalDateTime queReplyModifyDate, Long userId, String userAccount, String userNickName) {
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


