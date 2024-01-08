package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QRecentViewGoodsDto is a Querydsl Projection type for RecentViewGoodsDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRecentViewGoodsDto extends ConstructorExpression<RecentViewGoodsDto> {

    private static final long serialVersionUID = -787185808L;

    public QRecentViewGoodsDto(com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<String> goodsImgPath, com.querydsl.core.types.Expression<String> goodsImgUuid, com.querydsl.core.types.Expression<String> goodsImgName) {
        super(RecentViewGoodsDto.class, new Class<?>[]{long.class, String.class, int.class, String.class, String.class, String.class}, goodsId, goodsName, goodsPrice, goodsImgPath, goodsImgUuid, goodsImgName);
    }

}

