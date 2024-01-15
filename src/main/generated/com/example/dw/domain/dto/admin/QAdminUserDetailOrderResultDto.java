package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserDetailOrderResultDto is a Querydsl Projection type for AdminUserDetailOrderResultDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserDetailOrderResultDto extends ConstructorExpression<AdminUserDetailOrderResultDto> {

    private static final long serialVersionUID = -1595066063L;

    public QAdminUserDetailOrderResultDto(com.querydsl.core.types.Expression<Long> orderId, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderTime) {
        super(AdminUserDetailOrderResultDto.class, new Class<?>[]{long.class, java.time.LocalDateTime.class}, orderId, orderTime);
    }

}

