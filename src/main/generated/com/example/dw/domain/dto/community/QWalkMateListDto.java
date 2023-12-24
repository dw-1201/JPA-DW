package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QWalkMateListDto is a Querydsl Projection type for WalkMateListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWalkMateListDto extends ConstructorExpression<WalkMateListDto> {

    private static final long serialVersionUID = 1927768703L;

    public QWalkMateListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> walkingMateTitle, com.querydsl.core.types.Expression<String> walkingMateRd, com.querydsl.core.types.Expression<Long> walkingMateViewCount, com.querydsl.core.types.Expression<Long> walkingMateState, com.querydsl.core.types.Expression<Long> walkingMatePerson, com.querydsl.core.types.Expression<Long> walkingMateToday, com.querydsl.core.types.Expression<String> walkingMateDate, com.querydsl.core.types.Expression<String> walkingMateTime, com.querydsl.core.types.Expression<String> walkCity, com.querydsl.core.types.Expression<String> walkCounty, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userAccount) {
        super(WalkMateListDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, long.class, long.class, long.class, String.class, String.class, String.class, String.class, long.class, String.class, String.class}, id, walkingMateTitle, walkingMateRd, walkingMateViewCount, walkingMateState, walkingMatePerson, walkingMateToday, walkingMateDate, walkingMateTime, walkCity, walkCounty, userId, userNickName, userAccount);
    }

}

