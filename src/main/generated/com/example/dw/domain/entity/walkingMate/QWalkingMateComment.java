package com.example.dw.domain.entity.walkingMate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWalkingMateComment is a Querydsl query type for WalkingMateComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWalkingMateComment extends EntityPathBase<WalkingMateComment> {

    private static final long serialVersionUID = 1218490780L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWalkingMateComment walkingMateComment = new QWalkingMateComment("walkingMateComment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QWalkingMate walkingMate;

    public final StringPath walkingMateCommentContent = createString("walkingMateCommentContent");

    public final DateTimePath<java.time.LocalDateTime> walkingMateCommentMd = createDateTime("walkingMateCommentMd", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> walkingMateCommentRd = createDateTime("walkingMateCommentRd", java.time.LocalDateTime.class);

    public QWalkingMateComment(String variable) {
        this(WalkingMateComment.class, forVariable(variable), INITS);
    }

    public QWalkingMateComment(Path<? extends WalkingMateComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWalkingMateComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWalkingMateComment(PathMetadata metadata, PathInits inits) {
        this(WalkingMateComment.class, metadata, inits);
    }

    public QWalkingMateComment(Class<? extends WalkingMateComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.walkingMate = inits.isInitialized("walkingMate") ? new QWalkingMate(forProperty("walkingMate")) : null;
    }

}

