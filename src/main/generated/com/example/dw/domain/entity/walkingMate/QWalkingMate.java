package com.example.dw.domain.entity.walkingMate;

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

    private static final long serialVersionUID = 1216164675L;

    public static final QWalkingMate walkingMate = new QWalkingMate("walkingMate");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath walkCity = createString("walkCity");

    public final StringPath walkCounty = createString("walkCounty");

    public final ListPath<WalkingMateComment, QWalkingMateComment> walkingMateComment = this.<WalkingMateComment, QWalkingMateComment>createList("walkingMateComment", WalkingMateComment.class, QWalkingMateComment.class, PathInits.DIRECT2);

    public final StringPath walkingMateContent = createString("walkingMateContent");

    public final StringPath walkingMateDate = createString("walkingMateDate");

    public final StringPath walkingMateFullAddress = createString("walkingMateFullAddress");

    public final StringPath walkingMateMd = createString("walkingMateMd");

    public final NumberPath<Long> walkingMatePerson = createNumber("walkingMatePerson", Long.class);

    public final StringPath walkingMateRd = createString("walkingMateRd");

    public final NumberPath<Long> walkingMateState = createNumber("walkingMateState", Long.class);

    public final StringPath walkingMateTime = createString("walkingMateTime");

    public final StringPath walkingMateTitle = createString("walkingMateTitle");

    public final NumberPath<Long> walkingMateToday = createNumber("walkingMateToday", Long.class);

    public final NumberPath<Long> walkingMateViewCount = createNumber("walkingMateViewCount", Long.class);

    public QWalkingMate(String variable) {
        super(WalkingMate.class, forVariable(variable));
    }

    public QWalkingMate(Path<? extends WalkingMate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWalkingMate(PathMetadata metadata) {
        super(WalkingMate.class, metadata);
    }

}

