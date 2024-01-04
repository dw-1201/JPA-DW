package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QWalkDetailStateDto is a Querydsl Projection type for WalkDetailStateDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWalkDetailStateDto extends ConstructorExpression<WalkDetailStateDto> {

    private static final long serialVersionUID = -1807624388L;

    public QWalkDetailStateDto(com.querydsl.core.types.Expression<Long> walkMateId, com.querydsl.core.types.Expression<Long> walkMateStateId, com.querydsl.core.types.Expression<Long> applierUserId, com.querydsl.core.types.Expression<String> applierUserAccount, com.querydsl.core.types.Expression<String> applierUserNickName, com.querydsl.core.types.Expression<Long> applierPetId, com.querydsl.core.types.Expression<String> applierPetName, com.querydsl.core.types.Expression<Long> applierPetWeight, com.querydsl.core.types.Expression<String> applierPetGender, com.querydsl.core.types.Expression<String> applierPetAge, com.querydsl.core.types.Expression<String> applierPetCate, com.querydsl.core.types.Expression<String> applierPetNeutering, com.querydsl.core.types.Expression<String> applierPetImgName, com.querydsl.core.types.Expression<String> applierPetImgPath, com.querydsl.core.types.Expression<String> applierPetImgUuid, com.querydsl.core.types.Expression<Integer> state, com.querydsl.core.types.Expression<Integer> writerCheck) {
        super(WalkDetailStateDto.class, new Class<?>[]{long.class, long.class, long.class, String.class, String.class, long.class, String.class, long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, int.class, int.class}, walkMateId, walkMateStateId, applierUserId, applierUserAccount, applierUserNickName, applierPetId, applierPetName, applierPetWeight, applierPetGender, applierPetAge, applierPetCate, applierPetNeutering, applierPetImgName, applierPetImgPath, applierPetImgUuid, state, writerCheck);
    }

}

