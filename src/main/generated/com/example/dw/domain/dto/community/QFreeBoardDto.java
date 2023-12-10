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

    public QFreeBoardDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<String> freeBoardContent, com.querydsl.core.types.Expression<java.time.LocalDate> freeBoardRd, com.querydsl.core.types.Expression<java.time.LocalDate> freeBoardMd, com.querydsl.core.types.Expression<Long> freeBoardViewCount, com.querydsl.core.types.Expression<? extends java.util.List<com.example.dw.domain.entity.freeBoard.FreeBoardImg>> freeBoardImg, com.querydsl.core.types.Expression<? extends java.util.List<com.example.dw.domain.entity.freeBoard.FreeBoardComment>> freeBoardComment, com.querydsl.core.types.Expression<? extends com.example.dw.domain.entity.freeBoard.FreeBoardLike> freeBoardLike, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName) {
        super(FreeBoardDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDate.class, java.time.LocalDate.class, long.class, java.util.List.class, java.util.List.class, com.example.dw.domain.entity.freeBoard.FreeBoardLike.class, long.class, String.class, String.class}, id, freeBoardTitle, freeBoardContent, freeBoardRd, freeBoardMd, freeBoardViewCount, freeBoardImg, freeBoardComment, freeBoardLike, userId, userAccount, userNickName);
    }

}

