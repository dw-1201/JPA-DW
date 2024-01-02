package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsInfoDto is a Querydsl Projection type for GoodsInfoDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsInfoDto extends ConstructorExpression<GoodsInfoDto> {

    private static final long serialVersionUID = -2073377694L;

    public QGoodsInfoDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<String> goodsMade, com.querydsl.core.types.Expression<String> goodsCertify) {
        super(GoodsInfoDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, id, goodsName, goodsMade, goodsCertify);
    }

}

