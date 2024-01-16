package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminFreeDetailDto is a Querydsl Projection type for AdminFreeDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminFreeDetailDto extends ConstructorExpression<AdminFreeDetailDto> {

    private static final long serialVersionUID = 2036859937L;

    public QAdminFreeDetailDto(com.querydsl.core.types.Expression<Long> freeBoardId, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<String> freeBoardContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardMd, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<Long> viewCount) {
        super(AdminFreeDetailDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, long.class}, freeBoardId, freeBoardTitle, freeBoardContent, freeBoardRd, freeBoardMd, userId, userAccount, viewCount);
    }

    public QAdminFreeDetailDto(com.querydsl.core.types.Expression<Long> freeBoardImgId, com.querydsl.core.types.Expression<String> freeBoardImgPath, com.querydsl.core.types.Expression<String> freeBoardImgUuid, com.querydsl.core.types.Expression<String> freeBoardImgName) {
        super(AdminFreeDetailDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, freeBoardImgId, freeBoardImgPath, freeBoardImgUuid, freeBoardImgName);
    }

    public QAdminFreeDetailDto(com.querydsl.core.types.Expression<Long> freeBoardId, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<String> freeBoardContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardMd, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<Long> viewCount, com.querydsl.core.types.Expression<Long> freeBoardImgId, com.querydsl.core.types.Expression<String> freeBoardImgPath, com.querydsl.core.types.Expression<String> freeBoardImgUuid, com.querydsl.core.types.Expression<String> freeBoardImgName) {
        super(AdminFreeDetailDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, String.class, long.class, long.class, String.class, String.class, String.class}, freeBoardId, freeBoardTitle, freeBoardContent, freeBoardRd, freeBoardMd, userId, userAccount, viewCount, freeBoardImgId, freeBoardImgPath, freeBoardImgUuid, freeBoardImgName);
    }

}

