package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminNoticeBoardDto is a Querydsl Projection type for AdminNoticeBoardDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminNoticeBoardDto extends ConstructorExpression<AdminNoticeBoardDto> {

    private static final long serialVersionUID = -533331310L;

    public QAdminNoticeBoardDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> noticeBoardTitle, com.querydsl.core.types.Expression<String> noticeBoardContent, com.querydsl.core.types.Expression<Long> noticeBoardViewCount, com.querydsl.core.types.Expression<java.time.LocalDateTime> noticeBoardRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> noticeBoardMd) {
        super(AdminNoticeBoardDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, noticeBoardTitle, noticeBoardContent, noticeBoardViewCount, noticeBoardRd, noticeBoardMd);
    }

}

