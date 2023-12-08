package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsDetailDto is a Querydsl Projection type for GoodsDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsDetailDto extends ConstructorExpression<GoodsDetailDto> {

    private static final long serialVersionUID = 1464011167L;

    public QGoodsDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Long> goodsQuantity, com.querydsl.core.types.Expression<Long> goodsPrice, com.querydsl.core.types.Expression<String> goodsMade, com.querydsl.core.types.Expression<String> goodsCertify, com.querydsl.core.types.Expression<String> goodsDetailContent, com.querydsl.core.types.Expression<String> goodsRegisterDate, com.querydsl.core.types.Expression<String> goodsModifyDate, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<String> goodsMainImgName, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid, com.querydsl.core.types.Expression<Long> goodsDetailImgId, com.querydsl.core.types.Expression<String> goodsDetailImgName, com.querydsl.core.types.Expression<String> goodsDetailImgPath, com.querydsl.core.types.Expression<String> goodsDetailImgUuid) {
        super(GoodsDetailDto.class, new Class<?>[]{long.class, String.class, long.class, long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, long.class, String.class, String.class, String.class}, id, goodsName, goodsQuantity, goodsPrice, goodsMade, goodsCertify, goodsDetailContent, goodsRegisterDate, goodsModifyDate, goodsCategory, goodsMainImgName, goodsMainImgPath, goodsMainImgUuid, goodsDetailImgId, goodsDetailImgName, goodsDetailImgPath, goodsDetailImgUuid);
    }

}

