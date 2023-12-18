package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminUserChartDto is a Querydsl Projection type for AdminUserChartDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminUserChartDto extends ConstructorExpression<AdminUserChartDto> {

    private static final long serialVersionUID = 1068512461L;

    public QAdminUserChartDto(com.querydsl.core.types.Expression<java.time.LocalDate> joinDate, com.querydsl.core.types.Expression<Long> counts) {
        super(AdminUserChartDto.class, new Class<?>[]{java.time.LocalDate.class, long.class}, joinDate, counts);
    }

}

