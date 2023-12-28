package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

//상품 문의 조회 DTO
@Data
public class GoodsQueDto {

    //상품
    private Long id;
    private String goodsName;
    private int goodsQuantity; //수량
    private int goodsPrice;
    private String goodsMade;
    private String goodsDetailContent;
    private String goodsRegisterDate;
    private String goodsModifyDate;
    private String goodsCategory;

    //상품 이미지
    private Long goodsMainImgId;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;

    //상품 문의
    private Long goodsQueId;
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
    public GoodsQueDto(Long id, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, String goodsDetailContent, String goodsRegisterDate, String goodsModifyDate, String goodsCategory, Long goodsMainImgId, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid, Long goodsQueId, String queContent, String queRegisterDate, String queModifyDate, Long goodsQueReplyId, String queReplyContent, String queReplyRegisterDate, String queReplyModifyDate, Long userId, String userAccount, String userNickName) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsDetailContent = goodsDetailContent;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
        this.goodsCategory = goodsCategory;
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsQueId = goodsQueId;
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


