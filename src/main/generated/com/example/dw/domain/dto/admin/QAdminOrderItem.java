package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminOrderItem is a Querydsl Projection type for AdminOrderItem
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminOrderItem extends ConstructorExpression<AdminOrderItem> {

    private static final long serialVersionUID = -1668652960L;

    public QAdminOrderItem(com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<Integer> goodsQuantity) {
        super(AdminOrderItem.class, new Class<?>[]{long.class, String.class, int.class, int.class}, goodsId, goodsName, goodsPrice, goodsQuantity);
    }

}

