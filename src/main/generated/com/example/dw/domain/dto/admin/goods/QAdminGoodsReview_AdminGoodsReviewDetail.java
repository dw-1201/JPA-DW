package com.example.dw.domain.dto.admin.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.goods.QAdminGoodsReview_AdminGoodsReviewDetail is a Querydsl Projection type for AdminGoodsReviewDetail
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReview_AdminGoodsReviewDetail extends ConstructorExpression<AdminGoodsReview.AdminGoodsReviewDetail> {

    private static final long serialVersionUID = 1511739481L;

    public QAdminGoodsReview_AdminGoodsReviewDetail(com.querydsl.core.types.Expression<String> orderReviewContent, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<Integer> rating, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderReviewRd, com.querydsl.core.types.Expression<Long> orderReviewImgId, com.querydsl.core.types.Expression<String> orderReviewImgPath, com.querydsl.core.types.Expression<String> orderReviewImgUuid, com.querydsl.core.types.Expression<String> orderReviewImgName) {
        super(AdminGoodsReview.AdminGoodsReviewDetail.class, new Class<?>[]{String.class, String.class, int.class, java.time.LocalDateTime.class, long.class, String.class, String.class, String.class}, orderReviewContent, userAccount, rating, orderReviewRd, orderReviewImgId, orderReviewImgPath, orderReviewImgUuid, orderReviewImgName);
    }

    public QAdminGoodsReview_AdminGoodsReviewDetail(com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<String> goodsDetailContent, com.querydsl.core.types.Expression<Double> ratingAvg, com.querydsl.core.types.Expression<Long> goodsMainImgId, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid, com.querydsl.core.types.Expression<String> goodsMainImgName) {
        super(AdminGoodsReview.AdminGoodsReviewDetail.class, new Class<?>[]{long.class, String.class, String.class, String.class, double.class, long.class, String.class, String.class, String.class}, goodsId, goodsCategory, goodsName, goodsDetailContent, ratingAvg, goodsMainImgId, goodsMainImgPath, goodsMainImgUuid, goodsMainImgName);
    }

}

