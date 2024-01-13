package com.example.dw.domain.dto.admin;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.admin.QAdminWeeklyOrderState is a Querydsl Projection type for AdminWeeklyOrderState
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAdminWeeklyOrderState extends ConstructorExpression<AdminWeeklyOrderState> {

    private static final long serialVersionUID = 1671689093L;

    public QAdminWeeklyOrderState(com.querydsl.core.types.Expression<java.time.LocalDate> saleDate, com.querydsl.core.types.Expression<Long> saleCounts) {
        super(AdminWeeklyOrderState.class, new Class<?>[]{java.time.LocalDate.class, long.class}, saleDate, saleCounts);
    }

}

