package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsDetailImgDto is a Querydsl Projection type for GoodsDetailImgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsDetailImgDto extends ConstructorExpression<GoodsDetailImgDto> {

    private static final long serialVersionUID = -899702948L;

    public QGoodsDetailImgDto(com.querydsl.core.types.Expression<Long> goodsDetailImgId, com.querydsl.core.types.Expression<String> goodsDetailImgName, com.querydsl.core.types.Expression<String> goodsDetailImgPath, com.querydsl.core.types.Expression<String> goodsDetailImgUuid) {
        super(GoodsDetailImgDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, goodsDetailImgId, goodsDetailImgName, goodsDetailImgPath, goodsDetailImgUuid);
    }

}

