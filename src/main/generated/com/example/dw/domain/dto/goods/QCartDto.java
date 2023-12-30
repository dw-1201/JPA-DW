package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QCartDto is a Querydsl Projection type for CartDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCartDto extends ConstructorExpression<CartDto> {

    private static final long serialVersionUID = -920199176L;

    public QCartDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> userId) {
        super(CartDto.class, new Class<?>[]{long.class, long.class}, id, userId);
    }

}

