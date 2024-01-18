package com.example.dw.domain.dto.notice;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.notice.QNoticeDetailDto is a Querydsl Projection type for NoticeDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QNoticeDetailDto extends ConstructorExpression<NoticeDetailDto> {

    private static final long serialVersionUID = -462722129L;

    public QNoticeDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> noticeBoardTitle, com.querydsl.core.types.Expression<String> noticeBoardContent, com.querydsl.core.types.Expression<Long> noticeBoardViewCount, com.querydsl.core.types.Expression<java.time.LocalDateTime> noticeBoardRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> noticeBoardMd) {
        super(NoticeDetailDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, noticeBoardTitle, noticeBoardContent, noticeBoardViewCount, noticeBoardRd, noticeBoardMd);
    }

}

