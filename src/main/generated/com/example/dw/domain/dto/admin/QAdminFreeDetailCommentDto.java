package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminFreeDetailCommentDto is a Querydsl Projection type for AdminFreeDetailCommentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminFreeDetailCommentDto extends ConstructorExpression<AdminFreeDetailCommentDto> {

    private static final long serialVersionUID = 429187710L;

    public QAdminFreeDetailCommentDto(com.querydsl.core.types.Expression<Long> freeBoardCommentId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> freeBoardCommentContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardCommentRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardCommentMd) {
        super(AdminFreeDetailCommentDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, freeBoardCommentId, userAccount, freeBoardCommentContent, freeBoardCommentRd, freeBoardCommentMd);
    }

}

