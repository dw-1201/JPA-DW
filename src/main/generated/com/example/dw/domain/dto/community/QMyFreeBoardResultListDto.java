package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QMyFreeBoardResultListDto is a Querydsl Projection type for MyFreeBoardResultListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMyFreeBoardResultListDto extends ConstructorExpression<MyFreeBoardResultListDto> {

    private static final long serialVersionUID = -1759552598L;

    public QMyFreeBoardResultListDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<String> freeBoardContent, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Long> userFileId, com.querydsl.core.types.Expression<String> route, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> uuid, com.querydsl.core.types.Expression<Long> commentCount, com.querydsl.core.types.Expression<? extends java.util.List<FreeBoardImgDto>> freeBoardImgDtos) {
        super(MyFreeBoardResultListDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, String.class, String.class, long.class, String.class, String.class, String.class, long.class, java.util.List.class}, id, freeBoardTitle, freeBoardContent, userId, userAccount, userNickName, userFileId, route, name, uuid, commentCount, freeBoardImgDtos);
    }

}

