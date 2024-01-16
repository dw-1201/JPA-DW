package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsReviewListDto is a Querydsl Projection type for AdminGoodsReviewListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReviewListDto extends ConstructorExpression<AdminGoodsReviewListDto> {

    private static final long serialVersionUID = 1600085044L;

    public QAdminGoodsReviewListDto(com.querydsl.core.types.Expression<Long> orderReviewId, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<String> orderReviewContent, com.querydsl.core.types.Expression<Integer> rating, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderReviewRd, com.querydsl.core.types.Expression<Integer> adminReplyState) {
        super(AdminGoodsReviewListDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, int.class, java.time.LocalDateTime.class, int.class}, orderReviewId, goodsCategory, goodsName, orderReviewContent, rating, orderReviewRd, adminReplyState);
    }

}

