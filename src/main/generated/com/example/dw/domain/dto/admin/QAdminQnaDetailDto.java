package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminQnaDetailDto is a Querydsl Projection type for AdminQnaDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminQnaDetailDto extends ConstructorExpression<AdminQnaDetailDto> {

    private static final long serialVersionUID = 154185995L;

    public QAdminQnaDetailDto(com.querydsl.core.types.Expression<String> questionTitle, com.querydsl.core.types.Expression<String> questionContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionRd, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<Long> viewCount) {
        super(AdminQnaDetailDto.class, new Class<?>[]{String.class, String.class, java.time.LocalDateTime.class, long.class, String.class, long.class}, questionTitle, questionContent, questionRd, userId, userAccount, viewCount);
    }

    public QAdminQnaDetailDto(com.querydsl.core.types.Expression<String> questionTitle, com.querydsl.core.types.Expression<String> questionContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> questionRd, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<Long> viewCount, com.querydsl.core.types.Expression<Long> questionImgId, com.querydsl.core.types.Expression<String> questionImgRoute, com.querydsl.core.types.Expression<String> questionImgUuid, com.querydsl.core.types.Expression<String> questionImgName) {
        super(AdminQnaDetailDto.class, new Class<?>[]{String.class, String.class, java.time.LocalDateTime.class, long.class, String.class, long.class, long.class, String.class, String.class, String.class}, questionTitle, questionContent, questionRd, userId, userAccount, viewCount, questionImgId, questionImgRoute, questionImgUuid, questionImgName);
    }

}

