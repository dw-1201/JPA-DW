package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QQuestionCommentDto is a Querydsl Projection type for QuestionCommentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QQuestionCommentDto extends ConstructorExpression<QuestionCommentDto> {

    private static final long serialVersionUID = 29359514L;

    public QQuestionCommentDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> questionCommentContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionCommentRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionCommentMd, com.querydsl.core.types.Expression<? extends com.example.dw.domain.entity.question.Question> question) {
        super(QuestionCommentDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, com.example.dw.domain.entity.question.Question.class}, id, questionCommentContent, questionCommentRd, questionCommentMd, question);
    }

}

