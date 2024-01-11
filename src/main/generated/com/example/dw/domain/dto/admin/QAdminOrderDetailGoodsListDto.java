package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminOrderDetailGoodsListDto is a Querydsl Projection type for AdminOrderDetailGoodsListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminOrderDetailGoodsListDto extends ConstructorExpression<AdminOrderDetailGoodsListDto> {

    private static final long serialVersionUID = 823654825L;

    public QAdminOrderDetailGoodsListDto(com.querydsl.core.types.Expression<Long> orderGoodsId, com.querydsl.core.types.Expression<String> orderGoodsName, com.querydsl.core.types.Expression<Integer> orderGoodsQuantity, com.querydsl.core.types.Expression<Integer> orderGoodsPrice, com.querydsl.core.types.Expression<String> orderGoodsMainImgPath, com.querydsl.core.types.Expression<String> orderGoodsMainImgUuid, com.querydsl.core.types.Expression<String> orderGoodsMainImgName) {
        super(AdminOrderDetailGoodsListDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, String.class, String.class, String.class}, orderGoodsId, orderGoodsName, orderGoodsQuantity, orderGoodsPrice, orderGoodsMainImgPath, orderGoodsMainImgUuid, orderGoodsMainImgName);
    }

}

