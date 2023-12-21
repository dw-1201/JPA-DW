package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QUserDto is a Querydsl Projection type for UserDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserDto extends ConstructorExpression<UserDto> {

    private static final long serialVersionUID = 1777438310L;

    public QUserDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userPhone, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<java.time.LocalDate> userJoinDate, com.querydsl.core.types.Expression<String> zipCode, com.querydsl.core.types.Expression<String> address, com.querydsl.core.types.Expression<String> detail, com.querydsl.core.types.Expression<String> intro) {
        super(UserDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, java.time.LocalDate.class, String.class, String.class, String.class, String.class}, id, userAccount, userName, userNickName, userPhone, userEmail, userJoinDate, zipCode, address, detail, intro);
    }

}

