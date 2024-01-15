package com.example.dw.domain.dto.order;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.order.QOrderReviewImgDto is a Querydsl Projection type for OrderReviewImgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QOrderReviewImgDto extends ConstructorExpression<OrderReviewImgDto> {

    private static final long serialVersionUID = 480344851L;

    public QOrderReviewImgDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> orderReviewId, com.querydsl.core.types.Expression<String> reviewimgFileName, com.querydsl.core.types.Expression<String> reviewimgPath, com.querydsl.core.types.Expression<String> reviewimgUuid) {
        super(OrderReviewImgDto.class, new Class<?>[]{long.class, long.class, String.class, String.class, String.class}, id, orderReviewId, reviewimgFileName, reviewimgPath, reviewimgUuid);
    }

}

