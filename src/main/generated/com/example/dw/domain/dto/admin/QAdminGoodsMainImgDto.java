package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsMainImgDto is a Querydsl Projection type for AdminGoodsMainImgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsMainImgDto extends ConstructorExpression<AdminGoodsMainImgDto> {

    private static final long serialVersionUID = 959863754L;

    public QAdminGoodsMainImgDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid, com.querydsl.core.types.Expression<String> goodsMainImgName, com.querydsl.core.types.Expression<Long> goodsId) {
        super(AdminGoodsMainImgDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class}, id, goodsMainImgPath, goodsMainImgUuid, goodsMainImgName, goodsId);
    }

}

