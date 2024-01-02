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

    public QGoodsReviewDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> queContent, com.querydsl.core.types.Expression<String> queRegisterDate, com.querydsl.core.types.Expression<String> queModifyDate, com.querydsl.core.types.Expression<Long> goodsQueReplyId, com.querydsl.core.types.Expression<String> queReplyContent, com.querydsl.core.types.Expression<String> queReplyRegisterDate, com.querydsl.core.types.Expression<String> queReplyModifyDate, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName) {
        super(GoodsReviewDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class, String.class, String.class, String.class, long.class, long.class, String.class, String.class}, id, queContent, queRegisterDate, queModifyDate, goodsQueReplyId, queReplyContent, queReplyRegisterDate, queReplyModifyDate, goodsId, userId, userAccount, userNickName);
    }

}

