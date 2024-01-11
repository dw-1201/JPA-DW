package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QQuestionListDto is a Querydsl Projection type for QuestionListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QQuestionListDto extends ConstructorExpression<QuestionListDto> {

    private static final long serialVersionUID = -943335417L;

    public QQuestionListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> questionTitle, com.querydsl.core.types.Expression<String> questionContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionMd, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<Long> commentCount, com.querydsl.core.types.Expression<? extends java.util.List<QuestionImgDto>> questionImgDtoList) {
        super(QuestionListDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, long.class, java.util.List.class}, id, questionTitle, questionContent, questionRd, questionMd, userId, userName, commentCount, questionImgDtoList);
    }

}

