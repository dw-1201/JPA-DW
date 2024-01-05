package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QApplierUserList is a Querydsl Projection type for ApplierUserList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QApplierUserList extends ConstructorExpression<ApplierUserList> {

    private static final long serialVersionUID = 1040424710L;

    public QApplierUserList(com.querydsl.core.types.Expression<Long> stateId, com.querydsl.core.types.Expression<Long> applierUserId, com.querydsl.core.types.Expression<Long> applierPetId, com.querydsl.core.types.Expression<String> applierPetCate, com.querydsl.core.types.Expression<String> applierPetName, com.querydsl.core.types.Expression<Long> applierPetWeight, com.querydsl.core.types.Expression<String> applierPetGender, com.querydsl.core.types.Expression<String> applierPetNeutering, com.querydsl.core.types.Expression<String> applierPetBirth, com.querydsl.core.types.Expression<String> applierPetImgPath, com.querydsl.core.types.Expression<String> applierPetImgUuid, com.querydsl.core.types.Expression<String> applierPetImgName, com.querydsl.core.types.Expression<Integer> state) {
        super(ApplierUserList.class, new Class<?>[]{long.class, long.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class, String.class, String.class, String.class, int.class}, stateId, applierUserId, applierPetId, applierPetCate, applierPetName, applierPetWeight, applierPetGender, applierPetNeutering, applierPetBirth, applierPetImgPath, applierPetImgUuid, applierPetImgName, state);
    }

}

