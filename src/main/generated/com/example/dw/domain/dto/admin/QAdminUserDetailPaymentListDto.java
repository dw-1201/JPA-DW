package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserDetailPaymentListDto is a Querydsl Projection type for AdminUserDetailPaymentListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserDetailPaymentListDto extends ConstructorExpression<AdminUserDetailPaymentListDto> {

    private static final long serialVersionUID = -1214761000L;

    public QAdminUserDetailPaymentListDto(com.querydsl.core.types.Expression<Long> orderId, com.querydsl.core.types.Expression<java.time.LocalDateTime> orderTime, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> orderQuantity, com.querydsl.core.types.Expression<Integer> orderPrice) {
        super(AdminUserDetailPaymentListDto.class, new Class<?>[]{long.class, java.time.LocalDateTime.class, long.class, String.class, int.class, int.class}, orderId, orderTime, goodsId, goodsName, orderQuantity, orderPrice);
    }

}

