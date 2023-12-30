package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsQueReplyDto is a Querydsl Projection type for AdminGoodsQueReplyDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsQueReplyDto extends ConstructorExpression<AdminGoodsQueReplyDto> {

    private static final long serialVersionUID = 2010970497L;

    public QAdminGoodsQueReplyDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> qnaReplyContent, com.querydsl.core.types.Expression<String> qnaReplyRd, com.querydsl.core.types.Expression<String> qnaReplyMd) {
        super(AdminGoodsQueReplyDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, id, qnaReplyContent, qnaReplyRd, qnaReplyMd);
    }

}

