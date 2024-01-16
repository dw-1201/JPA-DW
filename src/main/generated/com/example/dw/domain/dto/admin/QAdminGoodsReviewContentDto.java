package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsReviewContentDto is a Querydsl Projection type for AdminGoodsReviewContentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReviewContentDto extends ConstructorExpression<AdminGoodsReviewContentDto> {

    private static final long serialVersionUID = -1379321357L;

    public QAdminGoodsReviewContentDto(com.querydsl.core.types.Expression<String> orderReviewContent, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderReviewRd, com.querydsl.core.types.Expression<Long> orderReviewImgId, com.querydsl.core.types.Expression<String> oderReviewImgPath, com.querydsl.core.types.Expression<String> orderReviewImgUuid, com.querydsl.core.types.Expression<String> orderReviewImgName) {
        super(AdminGoodsReviewContentDto.class, new Class<?>[]{String.class, String.class, java.time.LocalDateTime.class, long.class, String.class, String.class, String.class}, orderReviewContent, userAccount, orderReviewRd, orderReviewImgId, oderReviewImgPath, orderReviewImgUuid, orderReviewImgName);
    }

}

