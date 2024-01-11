package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsQueDetailDto {

    private Long id;
    private String qnaContent;
    private LocalDateTime qndRd;
    private LocalDateTime qnaMd;
    private Integer state;
    private Long userId;
    private String userAccount;
    private String userNickName;
    private Long goodsId;
    private String goodsName;
    private int goodsQuantity;
    private int goodsPrice;
    private String goodsMade;
    private String goodsCertify;
    private String goodsDetailContent;
    private LocalDateTime goodsRegisterDate;
    private LocalDateTime goodsModifyDate;
    private String goodsCategory;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;


    @QueryProjection
    public AdminGoodsQueDetailDto(Long id, String qnaContent, LocalDateTime qndRd, LocalDateTime qnaMd, Integer state, Long userId, String userAccount, String userNickName, Long goodsId, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, String goodsCertify, String goodsDetailContent, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate, String goodsCategory, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid) {
        this.id = id;
        this.qnaContent = qnaContent;
        this.qndRd = qndRd;
        this.qnaMd = qnaMd;
        this.state = state;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsCertify = goodsCertify;
        this.goodsDetailContent = goodsDetailContent;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
        this.goodsCategory = goodsCategory;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
    }
}
