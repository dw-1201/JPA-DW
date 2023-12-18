package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminFaqBoardDto is a Querydsl Projection type for AdminFaqBoardDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminFaqBoardDto extends ConstructorExpression<AdminFaqBoardDto> {

    private static final long serialVersionUID = 207481710L;

    public QAdminFaqBoardDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> faqBoardTitle, com.querydsl.core.types.Expression<String> faqBoardContent, com.querydsl.core.types.Expression<Long> faqBoardViewCount, com.querydsl.core.types.Expression<String> faqBoardRd, com.querydsl.core.types.Expression<String> faqBoardMd) {
        super(AdminFaqBoardDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, String.class, String.class}, id, faqBoardTitle, faqBoardContent, faqBoardViewCount, faqBoardRd, faqBoardMd);
    }

}

