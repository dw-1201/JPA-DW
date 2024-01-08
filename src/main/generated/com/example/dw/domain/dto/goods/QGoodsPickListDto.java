package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsPickListDto is a Querydsl Projection type for GoodsPickListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsPickListDto extends ConstructorExpression<GoodsPickListDto> {

    private static final long serialVersionUID = -1809309039L;

    public QGoodsPickListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Long> userId) {
        super(GoodsPickListDto.class, new Class<?>[]{long.class, int.class, int.class, long.class, String.class, long.class}, id, goodsQuantity, goodsPrice, goodsId, goodsName, userId);
    }

}

