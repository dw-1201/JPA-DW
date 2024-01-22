package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

import com.querydsl.core.types.Expression;

/**
 * com.example.dw.domain.dto.goods.QIndexGoodsByCateDto is a Querydsl Projection type for IndexGoodsByCateDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QIndexGoodsByCateDto extends ConstructorExpression<IndexGoodsByCateDto> {

    private static final long serialVersionUID = 1051382350L;

    public QIndexGoodsByCateDto(Expression<Long> goodsId, Expression<String> goodsName, Expression<Integer> goodsPrice, Expression<Double> ratingAvg, Expression<String> goodsCate, Expression<Long> goodsImgId, Expression<String> goodsImgPath, Expression<String> goodsImgUuid, Expression<String> goodsImgName) {
        super(IndexGoodsByCateDto.class, new Class<?>[]{long.class, String.class, int.class, double.class, String.class, long.class, String.class, String.class, String.class}, goodsId, goodsName, goodsPrice, ratingAvg, goodsCate, goodsImgId, goodsImgPath, goodsImgUuid, goodsImgName);
    }

    public QIndexGoodsByCateDto(NumberExpression<Long> goodsId, StringExpression goodsName, NumberExpression<Integer> goodsPrice, NumberExpression<Double> ratingAvg, EnumExpression<com.example.dw.domain.entity.goods.GoodsCategory> goodsCate, NumberExpression<Long> goodsImgId, StringExpression goodsImgPath, StringExpression goodsImgUuid, StringExpression goodsImgName) {
        super(IndexGoodsByCateDto.class, new Class<?>[]{long.class, String.class, int.class, double.class, com.example.dw.domain.entity.goods.GoodsCategory.class, long.class, String.class, String.class, String.class}, goodsId, goodsName, goodsPrice, ratingAvg, goodsCate, goodsImgId, goodsImgPath, goodsImgUuid, goodsImgName);
    }

}

