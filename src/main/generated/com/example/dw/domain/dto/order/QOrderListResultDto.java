package com.example.dw.domain.dto.order;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.order.QOrderListResultDto is a Querydsl Projection type for OrderListResultDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QOrderListResultDto extends ConstructorExpression<OrderListResultDto> {

    private static final long serialVersionUID = 748340965L;

    public QOrderListResultDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderDate, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<? extends java.util.List<OrderItemDto>> orderItemDtoList) {
        super(OrderListResultDto.class, new Class<?>[]{long.class, java.time.LocalDateTime.class, long.class, java.util.List.class}, id, orderDate, userId, orderItemDtoList);
    }

}

