package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsAddInfoDto is a Querydsl Projection type for GoodsAddInfoDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsAddInfoDto extends ConstructorExpression<GoodsAddInfoDto> {

    private static final long serialVersionUID = -1264872769L;

    public QGoodsAddInfoDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<String> goodsMade, com.querydsl.core.types.Expression<String> goodsCertify) {
        super(GoodsAddInfoDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, id, goodsName, goodsMade, goodsCertify);
    }

}

