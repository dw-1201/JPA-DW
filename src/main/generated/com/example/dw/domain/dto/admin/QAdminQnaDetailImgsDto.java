package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminQnaDetailImgsDto is a Querydsl Projection type for AdminQnaDetailImgsDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminQnaDetailImgsDto extends ConstructorExpression<AdminQnaDetailImgsDto> {

    private static final long serialVersionUID = -1403189285L;

    public QAdminQnaDetailImgsDto(com.querydsl.core.types.Expression<Long> questionImgId, com.querydsl.core.types.Expression<String> questionImgRoute, com.querydsl.core.types.Expression<String> questionImgUuid, com.querydsl.core.types.Expression<String> questionImgName) {
        super(AdminQnaDetailImgsDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, questionImgId, questionImgRoute, questionImgUuid, questionImgName);
    }

}

