package com.example.dw.domain.dto.goods;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.goods.QGoodsReviewImgDto is a Querydsl Projection type for GoodsReviewImgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGoodsReviewImgDto extends ConstructorExpression<GoodsReviewImgDto> {

    private static final long serialVersionUID = 1730993443L;

    public QGoodsReviewImgDto(com.querydsl.core.types.Expression<Long> reviewimgId, com.querydsl.core.types.Expression<String> reviewimgFileName, com.querydsl.core.types.Expression<String> reviewimgPath, com.querydsl.core.types.Expression<String> reviewimgUuid) {
        super(GoodsReviewImgDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, reviewimgId, reviewimgFileName, reviewimgPath, reviewimgUuid);
    }

}

