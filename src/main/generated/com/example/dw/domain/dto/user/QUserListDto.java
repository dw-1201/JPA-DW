package com.example.dw.domain.dto.user;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.user.QUserListDto is a Querydsl Projection type for UserListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserListDto extends ConstructorExpression<UserListDto> {

    private static final long serialVersionUID = -289560926L;

    public QUserListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<String> userPhone) {
        super(UserListDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class}, id, userAccount, userName, userEmail, userPhone);
    }

}

