package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserDetailFreeBoardListDto is a Querydsl Projection type for AdminUserDetailFreeBoardListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserDetailFreeBoardListDto extends ConstructorExpression<AdminUserDetailFreeBoardListDto> {

    private static final long serialVersionUID = -2105228220L;

    public QAdminUserDetailFreeBoardListDto(com.querydsl.core.types.Expression<Long> freeBoardId, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardRd, com.querydsl.core.types.Expression<Long> viewCount, com.querydsl.core.types.Expression<Long> replyCount) {
        super(AdminUserDetailFreeBoardListDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, long.class, long.class}, freeBoardId, freeBoardTitle, freeBoardRd, viewCount, replyCount);
    }

}

