package com.example.dw.domain.dto.index;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.index.QWeeklyQnaList is a Querydsl Projection type for WeeklyQnaList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWeeklyQnaList extends ConstructorExpression<WeeklyQnaList> {

    private static final long serialVersionUID = -21250058L;

    public QWeeklyQnaList(com.querydsl.core.types.Expression<Long> qnaBoardId, com.querydsl.core.types.Expression<Long> writerUserId, com.querydsl.core.types.Expression<String> writerUserAccount, com.querydsl.core.types.Expression<String> writerUserNickName, com.querydsl.core.types.Expression<String> qnaBoardTitle, com.querydsl.core.types.Expression<Long> questionViewCount) {
        super(WeeklyQnaList.class, new Class<?>[]{long.class, long.class, String.class, String.class, String.class, long.class}, qnaBoardId, writerUserId, writerUserAccount, writerUserNickName, qnaBoardTitle, questionViewCount);
    }

}

