package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QPetImgDto is a Querydsl Projection type for PetImgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPetImgDto extends ConstructorExpression<PetImgDto> {

    private static final long serialVersionUID = -169673491L;

    public QPetImgDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> petFileName, com.querydsl.core.types.Expression<String> petPath, com.querydsl.core.types.Expression<String> petUuid, com.querydsl.core.types.Expression<Long> petId) {
        super(PetImgDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class}, id, petFileName, petPath, petUuid, petId);
    }

}

