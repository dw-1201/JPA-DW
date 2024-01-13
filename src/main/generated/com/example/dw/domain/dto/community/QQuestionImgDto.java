package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QQuestionImgDto is a Querydsl Projection type for QuestionImgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QQuestionImgDto extends ConstructorExpression<QuestionImgDto> {

    private static final long serialVersionUID = -1914141002L;

    public QQuestionImgDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> questionImgRoute, com.querydsl.core.types.Expression<String> questionImgName, com.querydsl.core.types.Expression<String> questionImgUuid, com.querydsl.core.types.Expression<Long> questionId) {
        super(QuestionImgDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class}, id, questionImgRoute, questionImgName, questionImgUuid, questionId);
    }

    public QQuestionImgDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> questionImgRoute, com.querydsl.core.types.Expression<String> questionImgName, com.querydsl.core.types.Expression<String> questionImgUuid) {
        super(QuestionImgDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, id, questionImgRoute, questionImgName, questionImgUuid);
    }

}

