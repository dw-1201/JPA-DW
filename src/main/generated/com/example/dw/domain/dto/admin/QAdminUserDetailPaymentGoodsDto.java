package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserDetailPaymentGoodsDto is a Querydsl Projection type for AdminUserDetailPaymentGoodsDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserDetailPaymentGoodsDto extends ConstructorExpression<AdminUserDetailPaymentGoodsDto> {

    private static final long serialVersionUID = 1775113746L;

    public QAdminUserDetailPaymentGoodsDto(com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> orderQuantity, com.querydsl.core.types.Expression<Integer> orderPrice) {
        super(AdminUserDetailPaymentGoodsDto.class, new Class<?>[]{long.class, String.class, int.class, int.class}, goodsId, goodsName, orderQuantity, orderPrice);
    }

}

