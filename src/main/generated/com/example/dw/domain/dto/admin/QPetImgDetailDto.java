package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QPetImgDetailDto is a Querydsl Projection type for PetImgDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPetImgDetailDto extends ConstructorExpression<PetImgDetailDto> {

    private static final long serialVersionUID = -1113047972L;

    public QPetImgDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> petFileName, com.querydsl.core.types.Expression<String> petPath, com.querydsl.core.types.Expression<String> petUuid, com.querydsl.core.types.Expression<Long> petId) {
        super(PetImgDetailDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class}, id, petFileName, petPath, petUuid, petId);
    }

}

