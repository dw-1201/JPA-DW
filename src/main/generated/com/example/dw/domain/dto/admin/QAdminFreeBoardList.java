package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminFreeBoardList is a Querydsl Projection type for AdminFreeBoardList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminFreeBoardList extends ConstructorExpression<AdminFreeBoardList> {

    private static final long serialVersionUID = -1891472137L;
    public StringExpression freeBoardTitle;

    public QAdminFreeBoardList(com.querydsl.core.types.Expression<Long> freeBoardId, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardRd, com.querydsl.core.types.Expression<Long> viewCount) {
        super(AdminFreeBoardList.class, new Class<?>[]{long.class, long.class, String.class, String.class, java.time.LocalDateTime.class, long.class}, freeBoardId, userId, userAccount, freeBoardTitle, freeBoardRd, viewCount);
    }

}

