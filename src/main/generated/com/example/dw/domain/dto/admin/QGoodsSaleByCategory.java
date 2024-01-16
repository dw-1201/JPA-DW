package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QGoodsSaleByCategory is a Querydsl Projection type for GoodsSaleByCategory
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsSaleByCategory extends ConstructorExpression<GoodsSaleByCategory> {

    private static final long serialVersionUID = -1490484124L;

    public QGoodsSaleByCategory(com.querydsl.core.types.Expression<com.example.dw.domain.entity.goods.GoodsCategory> goodsCategory, com.querydsl.core.types.Expression<Integer> goodsSaleCount) {
        super(GoodsSaleByCategory.class, new Class<?>[]{com.example.dw.domain.entity.goods.GoodsCategory.class, int.class}, goodsCategory, goodsSaleCount);
    }

}

