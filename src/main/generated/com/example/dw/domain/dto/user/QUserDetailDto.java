package com.example.dw.domain.dto.user;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.user.QUserDetailDto is a Querydsl Projection type for UserDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserDetailDto extends ConstructorExpression<UserDetailDto> {

    private static final long serialVersionUID = 180728271L;

    public QUserDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userPhone, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<String> userJoinDate, com.querydsl.core.types.Expression<String> zipCode, com.querydsl.core.types.Expression<String> address, com.querydsl.core.types.Expression<String> detail, com.querydsl.core.types.Expression<String> intro) {
        super(UserDetailDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, id, userAccount, userName, userNickName, userPhone, userEmail, userJoinDate, zipCode, address, detail, intro);
    }

}

