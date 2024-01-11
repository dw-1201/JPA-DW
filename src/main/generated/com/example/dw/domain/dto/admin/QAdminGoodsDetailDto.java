package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsDetailDto is a Querydsl Projection type for AdminGoodsDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsDetailDto extends ConstructorExpression<AdminGoodsDetailDto> {

    private static final long serialVersionUID = 130524057L;

    public QAdminGoodsDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<String> goodsMade, com.querydsl.core.types.Expression<String> goodsCertify, com.querydsl.core.types.Expression<String> goodsDetailContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsRegisterDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> goodsModifyDate, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<Long> goodsMainImgId, com.querydsl.core.types.Expression<String> goodsMainImgName, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid, com.querydsl.core.types.Expression<Long> goodsDetailImgId, com.querydsl.core.types.Expression<String> goodsDetailImgName, com.querydsl.core.types.Expression<String> goodsDetailImgPath, com.querydsl.core.types.Expression<String> goodsDetailImgUuid, com.querydsl.core.types.Expression<Integer> saleCount) {
        super(AdminGoodsDetailDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, String.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, long.class, String.class, String.class, String.class, long.class, String.class, String.class, String.class, int.class}, id, goodsName, goodsQuantity, goodsPrice, goodsMade, goodsCertify, goodsDetailContent, goodsRegisterDate, goodsModifyDate, goodsCategory, goodsMainImgId, goodsMainImgName, goodsMainImgPath, goodsMainImgUuid, goodsDetailImgId, goodsDetailImgName, goodsDetailImgPath, goodsDetailImgUuid, saleCount);
    }

}

