package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminGoodsReviewImgList is a Querydsl Projection type for AdminGoodsReviewImgList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminGoodsReviewImgList extends ConstructorExpression<AdminGoodsReviewImgList> {

    private static final long serialVersionUID = -960147756L;

    public QAdminGoodsReviewImgList(com.querydsl.core.types.Expression<Long> orderReviewImgId, com.querydsl.core.types.Expression<String> oderReviewImgPath, com.querydsl.core.types.Expression<String> orderReviewImgUuid, com.querydsl.core.types.Expression<String> orderReviewImgName) {
        super(AdminGoodsReviewImgList.class, new Class<?>[]{long.class, String.class, String.class, String.class}, orderReviewImgId, oderReviewImgPath, orderReviewImgUuid, orderReviewImgName);
    }

}

