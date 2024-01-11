package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QWalkMateMyDetailListDto is a Querydsl Projection type for WalkMateMyDetailListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWalkMateMyDetailListDto extends ConstructorExpression<WalkMateMyDetailListDto> {

    private static final long serialVersionUID = 1257560226L;

    public QWalkMateMyDetailListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> walkingMateTitle, com.querydsl.core.types.Expression<String> walkingMateContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> walkingMateRd, com.querydsl.core.types.Expression<Long> walkingMateViewCount, com.querydsl.core.types.Expression<Long> walkingMateState, com.querydsl.core.types.Expression<Long> walkingMatePerson, com.querydsl.core.types.Expression<Long> walkingMateToday, com.querydsl.core.types.Expression<String> walkingMateDate, com.querydsl.core.types.Expression<String> walkingMateTime, com.querydsl.core.types.Expression<String> walkCity, com.querydsl.core.types.Expression<String> walkCounty, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<? extends java.util.List<WalkMateStateDto>> walkMateStateDtoList) {
        super(WalkMateMyDetailListDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, long.class, long.class, long.class, long.class, String.class, String.class, String.class, String.class, long.class, String.class, String.class, java.util.List.class}, id, walkingMateTitle, walkingMateContent, walkingMateRd, walkingMateViewCount, walkingMateState, walkingMatePerson, walkingMateToday, walkingMateDate, walkingMateTime, walkCity, walkCounty, userId, userNickName, userAccount, walkMateStateDtoList);
    }

}

