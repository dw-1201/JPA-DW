package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QQuestionDetailDto is a Querydsl Projection type for QuestionDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QQuestionDetailDto extends ConstructorExpression<QuestionDetailDto> {

    private static final long serialVersionUID = -1031332364L;

    public QQuestionDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> questionTitle, com.querydsl.core.types.Expression<String> questionContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionRd, com.querydsl.core.types.Expression<Long> questionImgId, com.querydsl.core.types.Expression<String> questionImgRoute, com.querydsl.core.types.Expression<String> questionImgUuid, com.querydsl.core.types.Expression<String> questionImgName, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userName) {
        super(QuestionDetailDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, long.class, String.class, String.class, String.class, long.class, String.class}, id, questionTitle, questionContent, questionRd, questionImgId, questionImgRoute, questionImgUuid, questionImgName, userId, userName);
    }

}

