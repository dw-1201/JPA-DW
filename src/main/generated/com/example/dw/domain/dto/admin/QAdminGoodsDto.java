package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsDto is a Querydsl Projection type for AdminGoodsDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsDto extends ConstructorExpression<AdminGoodsDto> {

    private static final long serialVersionUID = 142333418L;

    public QAdminGoodsDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsSaleCount, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsRegisterDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsModifyDate) {
        super(AdminGoodsDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, int.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, goodsName, goodsQuantity, goodsSaleCount, goodsPrice, goodsCategory, goodsRegisterDate, goodsModifyDate);
    }

}

