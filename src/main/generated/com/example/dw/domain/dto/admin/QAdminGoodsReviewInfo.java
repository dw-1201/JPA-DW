package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsReviewInfo is a Querydsl Projection type for AdminGoodsReviewInfo
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReviewInfo extends ConstructorExpression<AdminGoodsReviewInfo> {

    private static final long serialVersionUID = -1108409925L;

    public QAdminGoodsReviewInfo(com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<String> goodsContent, com.querydsl.core.types.Expression<Double> ratingAvg, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid, com.querydsl.core.types.Expression<String> goodsMainImgName) {
        super(AdminGoodsReviewInfo.class, new Class<?>[]{long.class, String.class, String.class, String.class, double.class, String.class, String.class, String.class}, goodsId, goodsCategory, goodsName, goodsContent, ratingAvg, goodsMainImgPath, goodsMainImgUuid, goodsMainImgName);
    }

}

