package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserDetailQnaListDto is a Querydsl Projection type for AdminUserDetailQnaListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserDetailQnaListDto extends ConstructorExpression<AdminUserDetailQnaListDto> {

    private static final long serialVersionUID = -1325861702L;

    public QAdminUserDetailQnaListDto(com.querydsl.core.types.Expression<Long> qnaBoardId, com.querydsl.core.types.Expression<String> qnaBoardTitle, com.querydsl.core.types.Expression<java.time.LocalDateTime> qnaBoardRd, com.querydsl.core.types.Expression<Long> viewCount, com.querydsl.core.types.Expression<Long> replyCount) {
        super(AdminUserDetailQnaListDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, long.class, long.class}, qnaBoardId, qnaBoardTitle, qnaBoardRd, viewCount, replyCount);
    }

}

