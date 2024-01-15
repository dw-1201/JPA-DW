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

    public QGoodsQueDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> queContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> queRegisterDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> queModifyDate, com.querydsl.core.types.Expression<Long> goodsQueReplyId, com.querydsl.core.types.Expression<String> queReplyContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> queReplyRegisterDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> queReplyModifyDate, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName) {
        super(GoodsQueDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, String.class}, id, queContent, queRegisterDate, queModifyDate, goodsQueReplyId, queReplyContent, queReplyRegisterDate, queReplyModifyDate, userId, userAccount, userNickName);
    }

}

