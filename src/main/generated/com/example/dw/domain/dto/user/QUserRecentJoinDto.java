package com.example.dw.domain.dto.user;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.user.QUserRecentJoinDto is a Querydsl Projection type for UserRecentJoinDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserRecentJoinDto extends ConstructorExpression<UserRecentJoinDto> {

    private static final long serialVersionUID = 1009102587L;

    public QUserRecentJoinDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<String> userPhone, com.querydsl.core.types.Expression<java.time.LocalDate> userJoinDate) {
        super(UserRecentJoinDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, java.time.LocalDate.class}, id, userAccount, userName, userEmail, userPhone, userJoinDate);
    }

}

