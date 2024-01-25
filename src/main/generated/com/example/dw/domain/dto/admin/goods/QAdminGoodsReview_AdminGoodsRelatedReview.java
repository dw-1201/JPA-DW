package com.example.dw.domain.dto.admin.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.goods.QAdminGoodsReview_AdminGoodsRelatedReview is a Querydsl Projection type for AdminGoodsRelatedReview
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReview_AdminGoodsRelatedReview extends ConstructorExpression<AdminGoodsReview.AdminGoodsRelatedReview> {

    private static final long serialVersionUID = 1406340819L;

    public QAdminGoodsReview_AdminGoodsRelatedReview(com.querydsl.core.types.Expression<Long> goodsReviewId, com.querydsl.core.types.Expression<String> goodsReviewContent, com.querydsl.core.types.Expression<Integer> rating, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsReviewRd, com.querydsl.core.types.Expression<Integer> replyState) {
        super(AdminGoodsReview.AdminGoodsRelatedReview.class, new Class<?>[]{long.class, String.class, int.class, java.time.LocalDateTime.class, int.class}, goodsReviewId, goodsReviewContent, rating, goodsReviewRd, replyState);
    }

}

