package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsQueDetailDto is a Querydsl Projection type for AdminGoodsQueDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsQueDetailDto extends ConstructorExpression<AdminGoodsQueDetailDto> {

    private static final long serialVersionUID = 671598178L;

    public QAdminGoodsQueDetailDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> qnaContent, com.querydsl.core.types.Expression<String> qndRd, com.querydsl.core.types.Expression<String> qnaMd, com.querydsl.core.types.Expression<Integer> state, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<String> goodsMade, com.querydsl.core.types.Expression<String> goodsCertify, com.querydsl.core.types.Expression<String> goodsDetailContent, com.querydsl.core.types.Expression<String> goodsRegisterDate, com.querydsl.core.types.Expression<String> goodsModifyDate, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<String> goodsMainImgName, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid) {
        super(AdminGoodsQueDetailDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, int.class, long.class, String.class, String.class, long.class, String.class, int.class, int.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, id, qnaContent, qndRd, qnaMd, state, userId, userAccount, userNickName, goodsId, goodsName, goodsQuantity, goodsPrice, goodsMade, goodsCertify, goodsDetailContent, goodsRegisterDate, goodsModifyDate, goodsCategory, goodsMainImgName, goodsMainImgPath, goodsMainImgUuid);
    }

}

