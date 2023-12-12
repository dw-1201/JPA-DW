package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QGoodsDto is a Querydsl Projection type for GoodsDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsDto extends ConstructorExpression<GoodsDto> {

    private static final long serialVersionUID = 1656140951L;

    public QGoodsDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<String> categoryName, com.querydsl.core.types.Expression<String> goodsRegisterDate, com.querydsl.core.types.Expression<String> goodsModifyDate) {
        super(GoodsDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, String.class, String.class, String.class}, id, goodsName, goodsQuantity, goodsPrice, categoryName, goodsRegisterDate, goodsModifyDate);
    }

}

