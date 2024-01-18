package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QQuestionDetailReplyDto is a Querydsl Projection type for QuestionDetailReplyDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QQuestionDetailReplyDto extends ConstructorExpression<QuestionDetailReplyDto> {

    private static final long serialVersionUID = 1936934816L;

    public QQuestionDetailReplyDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> questionCommentContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionCommentRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionCommentMd, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Long> userImgId, com.querydsl.core.types.Expression<String> userImgPath, com.querydsl.core.types.Expression<String> userImgUuid, com.querydsl.core.types.Expression<String> userImgName) {
        super(QuestionDetailReplyDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class}, id, questionCommentContent, questionCommentRd, questionCommentMd, userId, userAccount, userNickName, userImgId, userImgPath, userImgUuid, userImgName);
    }

}

