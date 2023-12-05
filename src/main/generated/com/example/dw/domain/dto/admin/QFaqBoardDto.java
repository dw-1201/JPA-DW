package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QFaqBoardDto is a Querydsl Projection type for FaqBoardDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFaqBoardDto extends ConstructorExpression<FaqBoardDto> {

    private static final long serialVersionUID = 891089313L;

    public QFaqBoardDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> faqBoardTitle, com.querydsl.core.types.Expression<String> faqBoardContent, com.querydsl.core.types.Expression<Long> faqBoardViewCount, com.querydsl.core.types.Expression<java.time.LocalDate> faqBoardRd, com.querydsl.core.types.Expression<java.time.LocalDate> faqBoardMd) {
        super(FaqBoardDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, java.time.LocalDate.class, java.time.LocalDate.class}, id, faqBoardTitle, faqBoardContent, faqBoardViewCount, faqBoardRd, faqBoardMd);
    }

}

