package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminOrderDetailDto is a Querydsl Projection type for AdminOrderDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminOrderDetailDto extends ConstructorExpression<AdminOrderDetailDto> {

    private static final long serialVersionUID = 775432865L;

    public QAdminOrderDetailDto(com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> orderAccount, com.querydsl.core.types.Expression<String> orderUserName, com.querydsl.core.types.Expression<String> oderEmail, com.querydsl.core.types.Expression<String> orderPhone, com.querydsl.core.types.Expression<String> orderZipcode, com.querydsl.core.types.Expression<String> orderAddress, com.querydsl.core.types.Expression<String> orderAddressDetail, com.querydsl.core.types.Expression<String> orderMemo, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderDate) {
        super(AdminOrderDetailDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, java.time.LocalDateTime.class}, userId, orderAccount, orderUserName, oderEmail, orderPhone, orderZipcode, orderAddress, orderAddressDetail, orderMemo, orderDate);
    }

}

