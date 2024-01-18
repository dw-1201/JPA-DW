package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QMyFreeBoardDto is a Querydsl Projection type for MyFreeBoardDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMyFreeBoardDto extends ConstructorExpression<MyFreeBoardDto> {

    private static final long serialVersionUID = -1220467835L;

    public QMyFreeBoardDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<String> freeBoardContent, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Long> userFileId, com.querydsl.core.types.Expression<String> route, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> uuid) {
        super(MyFreeBoardDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class}, id, freeBoardTitle, freeBoardContent, userId, userAccount, userNickName, userFileId, route, name, uuid);
    }

}

