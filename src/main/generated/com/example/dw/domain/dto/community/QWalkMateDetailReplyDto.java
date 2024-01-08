package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QWalkMateDetailReplyDto is a Querydsl Projection type for WalkMateDetailReplyDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWalkMateDetailReplyDto extends ConstructorExpression<WalkMateDetailReplyDto> {

    private static final long serialVersionUID = 1314291240L;

    public QWalkMateDetailReplyDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> walkDetailReplyComment, com.querydsl.core.types.Expression<java.time.LocalDateTime> walkCommendRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> walkCommentMd, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Long> userImgId, com.querydsl.core.types.Expression<String> userImgPath, com.querydsl.core.types.Expression<String> userImgUuid, com.querydsl.core.types.Expression<String> userImgName) {
        super(WalkMateDetailReplyDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class}, id, walkDetailReplyComment, walkCommendRd, walkCommentMd, userId, userAccount, userNickName, userImgId, userImgPath, userImgUuid, userImgName);
    }

    public QWalkMateDetailReplyDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> walkDetailReplyComment, com.querydsl.core.types.Expression<java.time.LocalDateTime> walkCommendRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> walkCommentMd, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName) {
        super(WalkMateDetailReplyDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, String.class}, id, walkDetailReplyComment, walkCommendRd, walkCommentMd, userId, userAccount, userNickName);
    }

}

