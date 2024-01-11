package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsQnaListDto is a Querydsl Projection type for AdminGoodsQnaListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsQnaListDto extends ConstructorExpression<AdminGoodsQnaListDto> {

    private static final long serialVersionUID = -2094135438L;

    public QAdminGoodsQnaListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsCategory, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<String> qnaContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> qnaRd, com.querydsl.core.types.Expression<Integer> state) {
        super(AdminGoodsQnaListDto.class, new Class<?>[]{long.class, String.class, long.class, String.class, String.class, java.time.LocalDateTime.class, int.class}, id, goodsCategory, goodsId, goodsName, qnaContent, qnaRd, state);
    }

}

