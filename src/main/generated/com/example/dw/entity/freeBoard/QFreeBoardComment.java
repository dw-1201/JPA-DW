package com.example.dw.entity.freeBoard;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFreeBoardComment is a Querydsl query type for FreeBoardComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeBoardComment extends EntityPathBase<FreeBoardComment> {

    private static final long serialVersionUID = 778396794L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFreeBoardComment freeBoardComment = new QFreeBoardComment("freeBoardComment");

    public final QFreeBoard freeBoard;

    public final StringPath freeBoardCommentContent = createString("freeBoardCommentContent");

    public final DateTimePath<java.time.LocalDateTime> freeBoardCommentMd = createDateTime("freeBoardCommentMd", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> freeBoardCommentRd = createDateTime("freeBoardCommentRd", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QFreeBoardComment(String variable) {
        this(FreeBoardComment.class, forVariable(variable), INITS);
    }

    public QFreeBoardComment(Path<? extends FreeBoardComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFreeBoardComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFreeBoardComment(PathMetadata metadata, PathInits inits) {
        this(FreeBoardComment.class, metadata, inits);
    }

    public QFreeBoardComment(Class<? extends FreeBoardComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.freeBoard = inits.isInitialized("freeBoard") ? new QFreeBoard(forProperty("freeBoard"), inits.get("freeBoard")) : null;
    }

}

