package com.example.dw.domain.entity.question;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestion is a Querydsl query type for Question
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestion extends EntityPathBase<Question> {

    private static final long serialVersionUID = 2020566499L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestion question = new QQuestion("question");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<QuestionComment, QQuestionComment> questionComment = this.<QuestionComment, QQuestionComment>createList("questionComment", QuestionComment.class, QQuestionComment.class, PathInits.DIRECT2);

    public final StringPath questionContent = createString("questionContent");

    public final ListPath<QuestionImg, QQuestionImg> questionImg = this.<QuestionImg, QQuestionImg>createList("questionImg", QuestionImg.class, QQuestionImg.class, PathInits.DIRECT2);

    public final QQuestionLike questionLike;

    public final DateTimePath<java.time.LocalDateTime> questionMd = createDateTime("questionMd", java.time.LocalDateTime.class);

    public final StringPath questionRd = createString("questionRd");

    public final StringPath questionTitle = createString("questionTitle");

    public final NumberPath<Long> questionViewCount = createNumber("questionViewCount", Long.class);

    public final com.example.dw.domain.entity.user.QUsers users;

    public QQuestion(String variable) {
        this(Question.class, forVariable(variable), INITS);
    }

    public QQuestion(Path<? extends Question> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestion(PathMetadata metadata, PathInits inits) {
        this(Question.class, metadata, inits);
    }

    public QQuestion(Class<? extends Question> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.questionLike = inits.isInitialized("questionLike") ? new QQuestionLike(forProperty("questionLike"), inits.get("questionLike")) : null;
        this.users = inits.isInitialized("users") ? new com.example.dw.domain.entity.user.QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

