package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QWalkMateDetailDto is a Querydsl Projection type for WalkMateDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWalkMateDetailDto extends ConstructorExpression<WalkMateDetailDto> {

    private static final long serialVersionUID = 730722924L;

    public QWalkMateDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> registeredDate, com.querydsl.core.types.Expression<String> modifiedDate, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<Long> currentPerson, com.querydsl.core.types.Expression<Long> matePerson, com.querydsl.core.types.Expression<String> mateDate, com.querydsl.core.types.Expression<String> mateTime, com.querydsl.core.types.Expression<String> fullAddress, com.querydsl.core.types.Expression<String> walkCity, com.querydsl.core.types.Expression<String> walkCounty, com.querydsl.core.types.Expression<Long> petId, com.querydsl.core.types.Expression<String> petName, com.querydsl.core.types.Expression<String> petCate, com.querydsl.core.types.Expression<Long> petWeight, com.querydsl.core.types.Expression<String> neutering, com.querydsl.core.types.Expression<String> petGender, com.querydsl.core.types.Expression<Long> petImgId, com.querydsl.core.types.Expression<String> petImgPath, com.querydsl.core.types.Expression<String> petImgUuid, com.querydsl.core.types.Expression<String> petImgName, com.querydsl.core.types.Expression<Long> viewCount) {
        super(WalkMateDetailDto.class, new Class<?>[]{long.class, long.class, String.class, String.class, String.class, String.class, String.class, String.class, long.class, long.class, String.class, String.class, String.class, String.class, String.class, long.class, String.class, String.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class, long.class}, id, userId, userNickName, userAccount, registeredDate, modifiedDate, title, content, currentPerson, matePerson, mateDate, mateTime, fullAddress, walkCity, walkCounty, petId, petName, petCate, petWeight, neutering, petGender, petImgId, petImgPath, petImgUuid, petImgName, viewCount);
    }

}

