package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsQueDto is a Querydsl Projection type for GoodsQueDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsQueDto extends ConstructorExpression<GoodsQueDto> {

    private static final long serialVersionUID = 168545069L;

    public QGoodsQueDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> queContent, com.querydsl.core.types.Expression<String> queRegisterDate, com.querydsl.core.types.Expression<String> queModifyDate, com.querydsl.core.types.Expression<Long> goodsQueReplyId, com.querydsl.core.types.Expression<String> queReplyContent, com.querydsl.core.types.Expression<String> queReplyRegisterDate, com.querydsl.core.types.Expression<String> queReplyModifyDate, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName) {
        super(GoodsQueDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class, String.class, String.class, String.class, long.class, String.class, String.class}, id, queContent, queRegisterDate, queModifyDate, goodsQueReplyId, queReplyContent, queReplyRegisterDate, queReplyModifyDate, userId, userAccount, userNickName);
    }

}

