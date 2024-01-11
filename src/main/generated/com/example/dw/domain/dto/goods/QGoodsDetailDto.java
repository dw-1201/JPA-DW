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

    public QGoodsDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<String> goodsMade, com.querydsl.core.types.Expression<String> goodsDetailContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsRegisterDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsModifyDate, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<Long> goodsMainImgId, com.querydsl.core.types.Expression<String> goodsMainImgName, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid) {
        super(GoodsDetailDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, long.class, String.class, String.class, String.class}, id, goodsName, goodsQuantity, goodsPrice, goodsMade, goodsDetailContent, goodsRegisterDate, goodsModifyDate, goodsCategory, goodsMainImgId, goodsMainImgName, goodsMainImgPath, goodsMainImgUuid);
    }

}

