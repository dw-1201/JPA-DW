package com.example.dw.domain.dto.admin.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.goods.QAdminGoods_AdminGoodsList is a Querydsl Projection type for AdminGoodsList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoods_AdminGoodsList extends ConstructorExpression<AdminGoods.AdminGoodsList> {

    private static final long serialVersionUID = 1739944934L;

    public QAdminGoods_AdminGoodsList(com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsSaleCount, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsMd) {
        super(AdminGoods.AdminGoodsList.class, new Class<?>[]{long.class, String.class, String.class, int.class, int.class, int.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, goodsId, goodsCategory, goodsName, goodsQuantity, goodsSaleCount, goodsPrice, goodsRd, goodsMd);
    }

}

