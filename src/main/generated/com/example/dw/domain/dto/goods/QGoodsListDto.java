package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsListDto is a Querydsl Projection type for GoodsListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsListDto extends ConstructorExpression<GoodsListDto> {

    private static final long serialVersionUID = 458142322L;

    public QGoodsListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<String> goodsMade, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsRegisterDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsModifyDate, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<Long> goodsMainImgId, com.querydsl.core.types.Expression<String> goodsMainImgName, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid, com.querydsl.core.types.Expression<Double> ratingAvg, com.querydsl.core.types.Expression<Long> reviewCount) {
        super(GoodsListDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, long.class, String.class, String.class, String.class, double.class, long.class}, id, goodsName, goodsQuantity, goodsPrice, goodsMade, goodsRegisterDate, goodsModifyDate, goodsCategory, goodsMainImgId, goodsMainImgName, goodsMainImgPath, goodsMainImgUuid, ratingAvg, reviewCount);
    }

}

