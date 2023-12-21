package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QPetDetailDto is a Querydsl Projection type for PetDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPetDetailDto extends ConstructorExpression<PetDetailDto> {

    private static final long serialVersionUID = -703993763L;

    public QPetDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> birthDate, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<Long> weight, com.querydsl.core.types.Expression<String> petGender, com.querydsl.core.types.Expression<String> neutering, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<Long> petImgId, com.querydsl.core.types.Expression<String> petFileName, com.querydsl.core.types.Expression<String> petPath, com.querydsl.core.types.Expression<String> petUuid, com.querydsl.core.types.Expression<String> petCategory) {
        super(PetDetailDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, String.class, String.class, long.class, long.class, String.class, String.class, String.class, String.class}, id, birthDate, name, weight, petGender, neutering, userId, petImgId, petFileName, petPath, petUuid, petCategory);
    }

}

