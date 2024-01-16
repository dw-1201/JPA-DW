package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsReviewReplyDto is a Querydsl Projection type for AdminGoodsReviewReplyDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReviewReplyDto extends ConstructorExpression<AdminGoodsReviewReplyDto> {

    private static final long serialVersionUID = 583166242L;

    public QAdminGoodsReviewReplyDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsReviewReplyContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsReviewReplyRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsReviewReplyMd) {
        super(AdminGoodsReviewReplyDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, goodsReviewReplyContent, goodsReviewReplyRd, goodsReviewReplyMd);
    }

}

