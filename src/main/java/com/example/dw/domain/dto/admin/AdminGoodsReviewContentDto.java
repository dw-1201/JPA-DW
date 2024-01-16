package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsReviewContentDto {

    private String orderReviewContent;
    private String userAccount;
    private LocalDateTime orderReviewRd;

    private Long orderReviewImgId;
    private String oderReviewImgPath;
    private String orderReviewImgUuid;
    private String orderReviewImgName;

    @QueryProjection
    public AdminGoodsReviewContentDto(String orderReviewContent, String userAccount, LocalDateTime orderReviewRd, Long orderReviewImgId, String oderReviewImgPath, String orderReviewImgUuid, String orderReviewImgName) {
        this.orderReviewContent = orderReviewContent;
        this.userAccount = userAccount;
        this.orderReviewRd = orderReviewRd;
        this.orderReviewImgId = orderReviewImgId;
        this.oderReviewImgPath = oderReviewImgPath;
        this.orderReviewImgUuid = orderReviewImgUuid;
        this.orderReviewImgName = orderReviewImgName;
    }
}
