package com.example.dw.domain.dto.user;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.user.QUserPetDto is a Querydsl Projection type for UserPetDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserPetDto extends ConstructorExpression<UserPetDto> {

    private static final long serialVersionUID = -314175009L;

    public QUserPetDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> petName) {
        super(UserPetDto.class, new Class<?>[]{long.class, String.class}, id, petName);
    }

}

