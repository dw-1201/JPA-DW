package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsReviewDto is a Querydsl Projection type for GoodsReviewDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsReviewDto extends ConstructorExpression<GoodsReviewDto> {

    private static final long serialVersionUID = -364840648L;

    public QGoodsReviewDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<java.time.LocalDateTime> reviewRd, com.querydsl.core.types.Expression<Integer> rating, com.querydsl.core.types.Expression<Long> goodsReviewReplyId, com.querydsl.core.types.Expression<String> goodsReviewReplyContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsReviewReplyRD, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsReviewReplyMD, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<Long> orderItemId, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Long> reviewimgId, com.querydsl.core.types.Expression<String> reviewimgFileName, com.querydsl.core.types.Expression<String> reviewimgPath, com.querydsl.core.types.Expression<String> reviewimgUuid) {
        super(GoodsReviewDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, int.class, long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, long.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class}, id, title, content, reviewRd, rating, goodsReviewReplyId, goodsReviewReplyContent, goodsReviewReplyRD, goodsReviewReplyMD, goodsId, orderItemId, userId, userAccount, userNickName, reviewimgId, reviewimgFileName, reviewimgPath, reviewimgUuid);
    }

}

