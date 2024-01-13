package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminQnaBoardList is a Querydsl Projection type for AdminQnaBoardList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminQnaBoardList extends ConstructorExpression<AdminQnaBoardList> {

    private static final long serialVersionUID = 520821217L;
    public StringExpression questionTitle;

    public QAdminQnaBoardList(com.querydsl.core.types.Expression<Long> qnaBoardId, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> qnaBoardTitle, com.querydsl.core.types.Expression<java.time.LocalDateTime> qnaBoardRd, com.querydsl.core.types.Expression<Long> viewCount) {
        super(AdminQnaBoardList.class, new Class<?>[]{long.class, long.class, String.class, String.class, java.time.LocalDateTime.class, long.class}, qnaBoardId, userId, userAccount, qnaBoardTitle, qnaBoardRd, viewCount);
    }

}

