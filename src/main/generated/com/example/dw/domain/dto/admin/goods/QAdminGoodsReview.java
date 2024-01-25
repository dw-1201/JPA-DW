package com.example.dw.domain.dto.admin.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.goods.QAdminGoodsReview is a Querydsl Projection type for AdminGoodsReview
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReview extends ConstructorExpression<AdminGoodsReview> {

    private static final long serialVersionUID = -2138949499L;

    public QAdminGoodsReview(com.querydsl.core.types.Expression<Long> goodsReviewId, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<String> goodsReviewContent, com.querydsl.core.types.Expression<Integer> rating, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsReviewRd, com.querydsl.core.types.Expression<Integer> replyState) {
        super(AdminGoodsReview.class, new Class<?>[]{long.class, String.class, String.class, String.class, int.class, java.time.LocalDateTime.class, int.class}, goodsReviewId, goodsCategory, goodsName, goodsReviewContent, rating, goodsReviewRd, replyState);
    }

}

