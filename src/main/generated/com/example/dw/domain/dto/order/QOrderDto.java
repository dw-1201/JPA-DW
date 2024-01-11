package com.example.dw.domain.dto.order;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.order.QOrderDto is a Querydsl Projection type for OrderDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QOrderDto extends ConstructorExpression<OrderDto> {

    private static final long serialVersionUID = -883250048L;

    public QOrderDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderRegisterDate, com.querydsl.core.types.Expression<Long> userId) {
        super(OrderDto.class, new Class<?>[]{long.class, java.time.LocalDateTime.class, long.class}, id, orderRegisterDate, userId);
    }

}

