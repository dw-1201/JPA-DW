package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QQuestionDto is a Querydsl Projection type for QuestionDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QQuestionDto extends ConstructorExpression<QuestionDto> {

    private static final long serialVersionUID = 1032908933L;

    public QQuestionDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> questionTitle, com.querydsl.core.types.Expression<String> questionContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionMd, com.querydsl.core.types.Expression<Long> userId) {
        super(QuestionDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class}, id, questionTitle, questionContent, questionRd, questionMd, userId);
    }

}

