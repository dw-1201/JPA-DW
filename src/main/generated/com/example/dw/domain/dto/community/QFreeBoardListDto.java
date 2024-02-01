package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QFreeBoardListDto is a Querydsl Projection type for FreeBoardListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFreeBoardListDto extends ConstructorExpression<FreeBoardListDto> {

    private static final long serialVersionUID = 111773243L;

    public QFreeBoardListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<String> freeBoardContent, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardRd, com.querydsl.core.types.Expression<java.time.LocalDateTime> freeBoardMd, com.querydsl.core.types.Expression<Long> freeBoardViewCount, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Long> userFileId, com.querydsl.core.types.Expression<String> route, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> uuid, com.querydsl.core.types.Expression<Long> commentCount, com.querydsl.core.types.Expression<? extends java.util.List<FreeBoardImgDto>> freeBoardImgDtoList) {
        super(FreeBoardListDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class, long.class, java.util.List.class}, id, freeBoardTitle, freeBoardContent, freeBoardRd, freeBoardMd, freeBoardViewCount, userId, userAccount, userNickName, userFileId, route, name, uuid, commentCount, freeBoardImgDtoList);
    }

}

