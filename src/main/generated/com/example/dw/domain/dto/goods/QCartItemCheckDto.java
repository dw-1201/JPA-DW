package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QCartItemCheckDto is a Querydsl Projection type for CartItemCheckDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCartItemCheckDto extends ConstructorExpression<CartItemCheckDto> {

    private static final long serialVersionUID = -562316815L;

    public QCartItemCheckDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<Long> cartId, com.querydsl.core.types.Expression<Long> userId) {
        super(CartItemCheckDto.class, new Class<?>[]{long.class, long.class, long.class, long.class}, id, goodsId, cartId, userId);
    }

}

