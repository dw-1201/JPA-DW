package com.example.dw.domain.dto.order;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.order.QOrderReviewDto is a Querydsl Projection type for OrderReviewDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QOrderReviewDto extends ConstructorExpression<OrderReviewDto> {

    private static final long serialVersionUID = -1282236088L;

    public QOrderReviewDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<Integer> rating, com.querydsl.core.types.Expression<Long> state) {
        super(OrderReviewDto.class, new Class<?>[]{long.class, String.class, String.class, int.class, long.class}, id, title, content, rating, state);
    }

}

