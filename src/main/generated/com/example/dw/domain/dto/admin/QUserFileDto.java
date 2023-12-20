package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QUserFileDto is a Querydsl Projection type for UserFileDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserFileDto extends ConstructorExpression<UserFileDto> {

    private static final long serialVersionUID = 925090762L;

    public QUserFileDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> route, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> uuid, com.querydsl.core.types.Expression<Long> userid) {
        super(UserFileDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class}, id, route, name, uuid, userid);
    }

}

