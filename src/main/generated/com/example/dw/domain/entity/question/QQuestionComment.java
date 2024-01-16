package com.example.dw.domain.entity.question;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestionComment is a Querydsl query type for QuestionComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionComment extends EntityPathBase<QuestionComment> {

    private static final long serialVersionUID = -1947317508L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestionComment questionComment = new QQuestionComment("questionComment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QQuestion question;

    public final StringPath questionCommentContent = createString("questionCommentContent");

    public final DateTimePath<java.time.LocalDateTime> questionCommentMd = createDateTime("questionCommentMd", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> questionCommentRd = createDateTime("questionCommentRd", java.time.LocalDateTime.class);

    public final com.example.dw.domain.entity.user.QUsers users;

    public QQuestionComment(String variable) {
        this(QuestionComment.class, forVariable(variable), INITS);
    }

    public QQuestionComment(Path<? extends QuestionComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestionComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestionComment(PathMetadata metadata, PathInits inits) {
        this(QuestionComment.class, metadata, inits);
    }

    public QQuestionComment(Class<? extends QuestionComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new QQuestion(forProperty("question"), inits.get("question")) : null;
        this.users = inits.isInitialized("users") ? new com.example.dw.domain.entity.user.QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

