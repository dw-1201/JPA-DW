package com.example.dw.domain.dto.admin.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.goods.QAdminGoods is a Querydsl Projection type for AdminGoods
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoods extends ConstructorExpression<AdminGoods> {

    private static final long serialVersionUID = -381525299L;

    public QAdminGoods(com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<Integer> goodsSaleCount, com.querydsl.core.types.Expression<String> goodsDetailContent, com.querydsl.core.types.Expression<String> goodsMate, com.querydsl.core.types.Expression<String> goodsCertify, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsMd, com.querydsl.core.types.Expression<Long> goodsMainImgId, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid, com.querydsl.core.types.Expression<String> goodsMainImgName, com.querydsl.core.types.Expression<Long> goodsDetailImgId, com.querydsl.core.types.Expression<String> goodsDetailImgPath, com.querydsl.core.types.Expression<String> goodsDetailImgUuid, com.querydsl.core.types.Expression<String> goodsDetailImgName) {
        super(AdminGoods.class, new Class<?>[]{long.class, String.class, String.class, int.class, int.class, int.class, String.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, String.class, String.class, long.class, String.class, String.class, String.class}, goodsId, goodsName, goodsCategory, goodsQuantity, goodsPrice, goodsSaleCount, goodsDetailContent, goodsMate, goodsCertify, goodsRd, goodsMd, goodsMainImgId, goodsMainImgPath, goodsMainImgUuid, goodsMainImgName, goodsDetailImgId, goodsDetailImgPath, goodsDetailImgUuid, goodsDetailImgName);
    }

}

