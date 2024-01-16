package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsReviewImgList {

    private Long orderReviewImgId;
    private String oderReviewImgPath;
    private String orderReviewImgUuid;
    private String orderReviewImgName;


    @QueryProjection
    public AdminGoodsReviewImgList(Long orderReviewImgId, String oderReviewImgPath, String orderReviewImgUuid, String orderReviewImgName) {
        this.orderReviewImgId = orderReviewImgId;
        this.oderReviewImgPath = oderReviewImgPath;
        this.orderReviewImgUuid = orderReviewImgUuid;
        this.orderReviewImgName = orderReviewImgName;
    }
}
