package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QUserChartDto is a Querydsl Projection type for UserChartDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserChartDto extends ConstructorExpression<UserChartDto> {

    private static final long serialVersionUID = 785511674L;

    public QUserChartDto(com.querydsl.core.types.Expression<java.time.LocalDate> joinDate, com.querydsl.core.types.Expression<Long> counts) {
        super(UserChartDto.class, new Class<?>[]{java.time.LocalDate.class, long.class}, joinDate, counts);
    }

}

