package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QUserListDto is a Querydsl Projection type for UserListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserListDto extends ConstructorExpression<UserListDto> {

    private static final long serialVersionUID = 1962057064L;

    public QUserListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<String> userPhone, com.querydsl.core.types.Expression<Integer> userState, com.querydsl.core.types.Expression<Long> freeBoardCount, com.querydsl.core.types.Expression<Long> qnaBoardCount) {
        super(UserListDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, int.class, long.class, long.class}, id, userAccount, userName, userEmail, userPhone, userState, freeBoardCount, qnaBoardCount);
    }

}

