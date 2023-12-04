package com.example.dw.domain.entity.question;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestionLike is a Querydsl query type for QuestionLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionLike extends EntityPathBase<QuestionLike> {

    private static final long serialVersionUID = 1154998298L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestionLike questionLike = new QQuestionLike("questionLike");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QQuestion question;

    public final NumberPath<Long> questionLikeDisLike = createNumber("questionLikeDisLike", Long.class);

    public final NumberPath<Long> questionLikeLike = createNumber("questionLikeLike", Long.class);

    public final NumberPath<Long> questionLikeState = createNumber("questionLikeState", Long.class);

    public QQuestionLike(String variable) {
        this(QuestionLike.class, forVariable(variable), INITS);
    }

    public QQuestionLike(Path<? extends QuestionLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestionLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestionLike(PathMetadata metadata, PathInits inits) {
        this(QuestionLike.class, metadata, inits);
    }

    public QQuestionLike(Class<? extends QuestionLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new QQuestion(forProperty("question"), inits.get("question")) : null;
    }

}

