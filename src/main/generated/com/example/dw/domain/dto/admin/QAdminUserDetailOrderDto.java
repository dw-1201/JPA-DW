package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserDetailOrderDto is a Querydsl Projection type for AdminUserDetailOrderDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserDetailOrderDto extends ConstructorExpression<AdminUserDetailOrderDto> {

    private static final long serialVersionUID = -1736164914L;

    public QAdminUserDetailOrderDto(com.querydsl.core.types.Expression<Long> orderId, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderRd) {
        super(AdminUserDetailOrderDto.class, new Class<?>[]{long.class, java.time.LocalDateTime.class}, orderId, orderRd);
    }

}

