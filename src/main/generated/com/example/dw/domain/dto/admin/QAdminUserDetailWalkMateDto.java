package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserDetailWalkMateDto is a Querydsl Projection type for AdminUserDetailWalkMateDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserDetailWalkMateDto extends ConstructorExpression<AdminUserDetailWalkMateDto> {

    private static final long serialVersionUID = -1893408940L;

    public QAdminUserDetailWalkMateDto(com.querydsl.core.types.Expression<Long> walkMateId, com.querydsl.core.types.Expression<String> walkMateTitle, com.querydsl.core.types.Expression<java.time.LocalDateTime> walkMateRd, com.querydsl.core.types.Expression<Long> viewCount, com.querydsl.core.types.Expression<Long> replyCount) {
        super(AdminUserDetailWalkMateDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, long.class, long.class}, walkMateId, walkMateTitle, walkMateRd, viewCount, replyCount);
    }

}

