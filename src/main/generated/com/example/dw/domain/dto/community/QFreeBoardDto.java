package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QFreeBoardDto is a Querydsl Projection type for FreeBoardDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFreeBoardDto extends ConstructorExpression<FreeBoardDto> {

    private static final long serialVersionUID = 558618809L;

    public QFreeBoardDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<String> freeBoardContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardMd, com.querydsl.core.types.Expression<Long> freeBoardViewCount, com.querydsl.core.types.Expression<Long> freeBoardCommentCount, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Long> userFileId, com.querydsl.core.types.Expression<String> route, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> uuid) {
        super(FreeBoardDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, long.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class}, id, freeBoardTitle, freeBoardContent, freeBoardRd, freeBoardMd, freeBoardViewCount, freeBoardCommentCount, userId, userAccount, userNickName, userFileId, route, name, uuid);
    }

}

