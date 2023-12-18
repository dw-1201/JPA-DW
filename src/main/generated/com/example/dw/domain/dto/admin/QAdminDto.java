package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminDto is a Querydsl Projection type for AdminDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminDto extends ConstructorExpression<AdminDto> {

    private static final long serialVersionUID = -1436182018L;

    public QAdminDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> adminAccount, com.querydsl.core.types.Expression<String> adminPassword) {
        super(AdminDto.class, new Class<?>[]{long.class, String.class, String.class}, id, adminAccount, adminPassword);
    }

}

