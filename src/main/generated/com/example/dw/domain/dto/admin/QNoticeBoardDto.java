package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QNoticeBoardDto is a Querydsl Projection type for NoticeBoardDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QNoticeBoardDto extends ConstructorExpression<NoticeBoardDto> {

    private static final long serialVersionUID = -1914147969L;

    public QNoticeBoardDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> noticeBoardTitle, com.querydsl.core.types.Expression<String> noticeBoardContent, com.querydsl.core.types.Expression<Long> noticeBoardViewCount, com.querydsl.core.types.Expression<String> noticeBoardRd, com.querydsl.core.types.Expression<String> noticeBoardMd) {
        super(NoticeBoardDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, String.class, String.class}, id, noticeBoardTitle, noticeBoardContent, noticeBoardViewCount, noticeBoardRd, noticeBoardMd);
    }

}

