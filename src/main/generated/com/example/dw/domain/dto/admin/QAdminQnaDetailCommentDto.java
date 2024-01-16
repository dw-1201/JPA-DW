package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminQnaDetailCommentDto is a Querydsl Projection type for AdminQnaDetailCommentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminQnaDetailCommentDto extends ConstructorExpression<AdminQnaDetailCommentDto> {

    private static final long serialVersionUID = -154813868L;

    public QAdminQnaDetailCommentDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> questionCommentContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionCommentRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionCommentMd) {
        super(AdminQnaDetailCommentDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, userAccount, questionCommentContent, questionCommentRd, questionCommentMd);
    }

}

