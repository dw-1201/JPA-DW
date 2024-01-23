package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

import com.querydsl.core.types.Expression;

/**
 * com.example.dw.domain.dto.goods.QGoodsByCateDto is a Querydsl Projection type for GoodsByCateDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsByCateDto extends ConstructorExpression<GoodsByCateDto> {

    private static final long serialVersionUID = 752363914L;

    public QGoodsByCateDto(Expression<Long> goodsId, Expression<String> goodsName, Expression<Integer> goodsQuantity, Expression<Integer> goodsPrice, Expression<String> goodsMade, Expression<java.time.LocalDateTime> goodsRegisterDate, Expression<java.time.LocalDateTime> goodsModifyDate, Expression<String> goodsCate, Expression<Long> goodsMainImgId, Expression<String> goodsMainImgName, Expression<String> goodsMainImgPath, Expression<String> goodsMainImgUuid) {
        super(GoodsByCateDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, long.class, String.class, String.class, String.class}, goodsId, goodsName, goodsQuantity, goodsPrice, goodsMade, goodsRegisterDate, goodsModifyDate, goodsCate, goodsMainImgId, goodsMainImgName, goodsMainImgPath, goodsMainImgUuid);
    }

    public QGoodsByCateDto(NumberExpression<Long> goodsId, StringExpression goodsName, NumberExpression<Integer> goodsQuantity, NumberExpression<Integer> goodsPrice, StringExpression goodsMade, TemporalExpression<java.time.LocalDateTime> goodsRegisterDate, TemporalExpression<java.time.LocalDateTime> goodsModifyDate, EnumExpression<com.example.dw.domain.entity.goods.GoodsCategory> goodsCate, NumberExpression<Long> goodsMainImgId, StringExpression goodsMainImgName, StringExpression goodsMainImgPath, StringExpression goodsMainImgUuid) {
        super(GoodsByCateDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, com.example.dw.domain.entity.goods.GoodsCategory.class, long.class, String.class, String.class, String.class}, goodsId, goodsName, goodsQuantity, goodsPrice, goodsMade, goodsRegisterDate, goodsModifyDate, goodsCate, goodsMainImgId, goodsMainImgName, goodsMainImgPath, goodsMainImgUuid);
    }

}

