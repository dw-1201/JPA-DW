package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QUserDetailListDto is a Querydsl Projection type for UserDetailListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserDetailListDto extends ConstructorExpression<UserDetailListDto> {

    private static final long serialVersionUID = -1258606953L;

    public QUserDetailListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userPhone, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<java.time.LocalDate> userJoinDate, com.querydsl.core.types.Expression<String> zipCode, com.querydsl.core.types.Expression<String> address, com.querydsl.core.types.Expression<String> detail, com.querydsl.core.types.Expression<String> intro, com.querydsl.core.types.Expression<? extends java.util.List<UserFileDto>> userFileDtoList) {
        super(UserDetailListDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, java.time.LocalDate.class, String.class, String.class, String.class, String.class, java.util.List.class}, id, userAccount, userName, userNickName, userPhone, userEmail, userJoinDate, zipCode, address, detail, intro, userFileDtoList);
    }

}

