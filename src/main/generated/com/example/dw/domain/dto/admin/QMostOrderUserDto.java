package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QMostOrderUserDto is a Querydsl Projection type for MostOrderUserDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMostOrderUserDto extends ConstructorExpression<MostOrderUserDto> {

    private static final long serialVersionUID = -775585289L;

    public QMostOrderUserDto(com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userName) {
        super(MostOrderUserDto.class, new Class<?>[]{long.class, String.class, String.class}, userId, userAccount, userName);
    }

}

