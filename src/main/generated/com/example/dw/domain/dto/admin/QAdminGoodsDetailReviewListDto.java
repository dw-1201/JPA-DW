package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsDetailReviewListDto is a Querydsl Projection type for AdminGoodsDetailReviewListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsDetailReviewListDto extends ConstructorExpression<AdminGoodsDetailReviewListDto> {

    private static final long serialVersionUID = -396027101L;

    public QAdminGoodsDetailReviewListDto(com.querydsl.core.types.Expression<Long> orderReviewId, com.querydsl.core.types.Expression<String> orderReviewContent, com.querydsl.core.types.Expression<Integer> rating, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderReviewRd, com.querydsl.core.types.Expression<Integer> state) {
        super(AdminGoodsDetailReviewListDto.class, new Class<?>[]{long.class, String.class, int.class, java.time.LocalDateTime.class, int.class}, orderReviewId, orderReviewContent, rating, orderReviewRd, state);
    }

}

