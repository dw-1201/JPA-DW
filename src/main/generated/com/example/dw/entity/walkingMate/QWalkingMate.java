package com.example.dw.entity.walkingMate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWalkingMate is a Querydsl query type for WalkingMate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWalkingMate extends EntityPathBase<WalkingMate> {

    private static final long serialVersionUID = 46259757L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWalkingMate walkingMate = new QWalkingMate("walkingMate");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QWalkingMateAddress walkingMateAddress;

    public final ListPath<WalkingMateComment, QWalkingMateComment> walkingMateComment = this.<WalkingMateComment, QWalkingMateComment>createList("walkingMateComment", WalkingMateComment.class, QWalkingMateComment.class, PathInits.DIRECT2);

    public final StringPath walkingMateContent = createString("walkingMateContent");

    public final DateTimePath<java.time.LocalDateTime> walkingMateMd = createDateTime("walkingMateMd", java.time.LocalDateTime.class);

    public final NumberPath<Long> walkingMatePerson = createNumber("walkingMatePerson", Long.class);

    public final DateTimePath<java.time.LocalDateTime> walkingMateRd = createDateTime("walkingMateRd", java.time.LocalDateTime.class);

    public final NumberPath<Long> walkingMateState = createNumber("walkingMateState", Long.class);

    public final StringPath walkingMateTitle = createString("walkingMateTitle");

    public final NumberPath<Long> walkingMateToday = createNumber("walkingMateToday", Long.class);

    public final NumberPath<Long> walkingMateViewCount = createNumber("walkingMateViewCount", Long.class);

    public QWalkingMate(String variable) {
        this(WalkingMate.class, forVariable(variable), INITS);
    }

    public QWalkingMate(Path<? extends WalkingMate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWalkingMate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWalkingMate(PathMetadata metadata, PathInits inits) {
        this(WalkingMate.class, metadata, inits);
    }

    public QWalkingMate(Class<? extends WalkingMate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.walkingMateAddress = inits.isInitialized("walkingMateAddress") ? new QWalkingMateAddress(forProperty("walkingMateAddress"), inits.get("walkingMateAddress")) : null;
    }

}

