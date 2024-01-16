package com.example.dw.domain.dto.index;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.index.QWeeklyFreeBoardList is a Querydsl Projection type for WeeklyFreeBoardList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWeeklyFreeBoardList extends ConstructorExpression<WeeklyFreeBoardList> {

    private static final long serialVersionUID = 351755244L;

    public QWeeklyFreeBoardList(com.querydsl.core.types.Expression<Long> freeBoardId, com.querydsl.core.types.Expression<String> freeBoardTitle, com.querydsl.core.types.Expression<Integer> viewCount) {
        super(WeeklyFreeBoardList.class, new Class<?>[]{long.class, String.class, int.class}, freeBoardId, freeBoardTitle, viewCount);
    }

}

