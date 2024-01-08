package com.example.dw.domain.dto.community;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.community.QWalkMateStateDto is a Querydsl Projection type for WalkMateStateDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWalkMateStateDto extends ConstructorExpression<WalkMateStateDto> {

    private static final long serialVersionUID = -395723472L;

    public QWalkMateStateDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> walkMateId, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userAccount, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<Integer> state, com.querydsl.core.types.Expression<Integer> writerCheck) {
        super(WalkMateStateDto.class, new Class<?>[]{long.class, long.class, long.class, String.class, String.class, int.class, int.class}, id, walkMateId, userId, userAccount, userNickName, state, writerCheck);
    }

}

