package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QFreeBoardImgDto is a Querydsl Projection type for FreeBoardImgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFreeBoardImgDto extends ConstructorExpression<FreeBoardImgDto> {

    private static final long serialVersionUID = -1048821246L;

    public QFreeBoardImgDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> freeBoardImgRoute, com.querydsl.core.types.Expression<String> freeBoardImgName, com.querydsl.core.types.Expression<String> freeBoardImgUuid, com.querydsl.core.types.Expression<Long> freeBoarId) {
        super(FreeBoardImgDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class}, id, freeBoardImgRoute, freeBoardImgName, freeBoardImgUuid, freeBoarId);
    }

}

