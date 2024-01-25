package com.example.dw.domain.dto.admin.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.goods.QAdminGoodsReview_AdminGoodsReviewApply is a Querydsl Projection type for AdminGoodsReviewApply
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReview_AdminGoodsReviewApply extends ConstructorExpression<AdminGoodsReview.AdminGoodsReviewApply> {

    private static final long serialVersionUID = 877603430L;

    public QAdminGoodsReview_AdminGoodsReviewApply(com.querydsl.core.types.Expression<Long> goodsReviewApplyId, com.querydsl.core.types.Expression<String> goodsReviewReplyContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsReviewReplyRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsReviewReplyMd) {
        super(AdminGoodsReview.AdminGoodsReviewApply.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, goodsReviewApplyId, goodsReviewReplyContent, goodsReviewReplyRd, goodsReviewReplyMd);
    }

}

