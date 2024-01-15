package com.example.dw.domain.dto.order;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.order.QOrderItemReviewListDto is a Querydsl Projection type for OrderItemReviewListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QOrderItemReviewListDto extends ConstructorExpression<OrderItemReviewListDto> {

    private static final long serialVersionUID = -193633673L;

    public QOrderItemReviewListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> orderItemId, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<Integer> rating, com.querydsl.core.types.Expression<java.time.LocalDateTime> reviewRd, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Long> orderId, com.querydsl.core.types.Expression<Long> userId) {
        super(OrderItemReviewListDto.class, new Class<?>[]{long.class, long.class, String.class, String.class, int.class, java.time.LocalDateTime.class, long.class, String.class, long.class, long.class}, id, orderItemId, title, content, rating, reviewRd, goodsId, goodsName, orderId, userId);
    }

}

