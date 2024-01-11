package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QIndexWalkMateDto is a Querydsl Projection type for IndexWalkMateDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QIndexWalkMateDto extends ConstructorExpression<IndexWalkMateDto> {

    private static final long serialVersionUID = -1863308941L;

    public QIndexWalkMateDto(com.querydsl.core.types.Expression<Long> walkMateId, com.querydsl.core.types.Expression<String> walkCity, com.querydsl.core.types.Expression<String> walkCounty, com.querydsl.core.types.Expression<String> walkMateTitle, com.querydsl.core.types.Expression<Long> walkMateState, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> writerPetImgPath, com.querydsl.core.types.Expression<String> writerPetImgUuid, com.querydsl.core.types.Expression<String> writerPetImgName) {
        super(IndexWalkMateDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class, long.class, String.class, String.class, String.class}, walkMateId, walkCity, walkCounty, walkMateTitle, walkMateState, userId, writerPetImgPath, writerPetImgUuid, writerPetImgName);
    }

}

