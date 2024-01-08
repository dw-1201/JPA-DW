package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QIndexGoodsByCateDto is a Querydsl Projection type for IndexGoodsByCateDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QIndexGoodsByCateDto extends ConstructorExpression<IndexGoodsByCateDto> {

    private static final long serialVersionUID = 1051382350L;

    public QIndexGoodsByCateDto(com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<String> goodsCate, com.querydsl.core.types.Expression<Long> goodsImgId, com.querydsl.core.types.Expression<String> goodsImgPath, com.querydsl.core.types.Expression<String> goodsImgUuid, com.querydsl.core.types.Expression<String> goodsImgName) {
        super(IndexGoodsByCateDto.class, new Class<?>[]{long.class, String.class, int.class, String.class, long.class, String.class, String.class, String.class}, goodsId, goodsName, goodsPrice, goodsCate, goodsImgId, goodsImgPath, goodsImgUuid, goodsImgName);
    }

}

