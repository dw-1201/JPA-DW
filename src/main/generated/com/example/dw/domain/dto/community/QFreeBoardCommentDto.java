package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QFreeBoardCommentDto is a Querydsl Projection type for FreeBoardCommentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFreeBoardCommentDto extends ConstructorExpression<FreeBoardCommentDto> {

    private static final long serialVersionUID = -2094189850L;

    public QFreeBoardCommentDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> freeBoardCommentContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardCommentRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardCommentMd, com.querydsl.core.types.Expression<Long> freeBoardId, com.querydsl.core.types.Expression<Long> userId) {
        super(FreeBoardCommentDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, long.class}, id, freeBoardCommentContent, freeBoardCommentRd, freeBoardCommentMd, freeBoardId, userId);
    }

}

