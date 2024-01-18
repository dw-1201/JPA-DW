package com.example.dw.domain.dto.index;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.dw.domain.dto.index.QWeeklyQnaListImg is a Querydsl Projection type for WeeklyQnaListImg
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QWeeklyQnaListImg extends ConstructorExpression<WeeklyQnaListImg> {

    private static final long serialVersionUID = -1700211731L;

    public QWeeklyQnaListImg(com.querydsl.core.types.Expression<String> questionImgRoute, com.querydsl.core.types.Expression<String> questionImgUuid, com.querydsl.core.types.Expression<String> questionImgName) {
        super(WeeklyQnaListImg.class, new Class<?>[]{String.class, String.class, String.class}, questionImgRoute, questionImgUuid, questionImgName);
    }

}

