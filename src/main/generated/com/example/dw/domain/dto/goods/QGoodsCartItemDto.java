package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsCartItemDto is a Querydsl Projection type for GoodsCartItemDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsCartItemDto extends ConstructorExpression<GoodsCartItemDto> {

    private static final long serialVersionUID = 745979933L;

    public QGoodsCartItemDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> cartId, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<Long> goodsId, com.querydsl.core.types.Expression<String> goodsName, com.querydsl.core.types.Expression<Integer> goodsQuantity, com.querydsl.core.types.Expression<Integer> goodsPrice, com.querydsl.core.types.Expression<Long> goodsMainImgId, com.querydsl.core.types.Expression<String> goodsMainImgName, com.querydsl.core.types.Expression<String> goodsMainImgPath, com.querydsl.core.types.Expression<String> goodsMainImgUuid) {
        super(GoodsCartItemDto.class, new Class<?>[]{long.class, long.class, long.class, long.class, String.class, int.class, int.class, long.class, String.class, String.class, String.class}, id, cartId, userId, goodsId, goodsName, goodsQuantity, goodsPrice, goodsMainImgId, goodsMainImgName, goodsMainImgPath, goodsMainImgUuid);
    }

}

