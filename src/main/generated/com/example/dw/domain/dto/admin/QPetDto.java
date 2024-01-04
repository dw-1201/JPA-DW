package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QPetDto is a Querydsl Projection type for PetDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPetDto extends ConstructorExpression<PetDto> {

    private static final long serialVersionUID = 871497134L;

    public QPetDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> birthDate, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<Long> weight, com.querydsl.core.types.Expression<String> petGender, com.querydsl.core.types.Expression<String> neutering, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> petCategory) {
        super(PetDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, String.class, String.class, long.class, String.class}, id, birthDate, name, weight, petGender, neutering, userId, petCategory);
    }

}

