package com.example.dw.domain.entity.walkingMate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWalkingMateState is a Querydsl query type for WalkingMateState
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWalkingMateState extends EntityPathBase<WalkingMateState> {

    private static final long serialVersionUID = -68734194L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWalkingMateState walkingMateState = new QWalkingMateState("walkingMateState");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.dw.domain.entity.user.QPet pet;

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final com.example.dw.domain.entity.user.QUsers users;

    public final QWalkingMate walkingMate;

    public QWalkingMateState(String variable) {
        this(WalkingMateState.class, forVariable(variable), INITS);
    }

    public QWalkingMateState(Path<? extends WalkingMateState> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWalkingMateState(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWalkingMateState(PathMetadata metadata, PathInits inits) {
        this(WalkingMateState.class, metadata, inits);
    }

    public QWalkingMateState(Class<? extends WalkingMateState> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pet = inits.isInitialized("pet") ? new com.example.dw.domain.entity.user.QPet(forProperty("pet"), inits.get("pet")) : null;
        this.users = inits.isInitialized("users") ? new com.example.dw.domain.entity.user.QUsers(forProperty("users"), inits.get("users")) : null;
        this.walkingMate = inits.isInitialized("walkingMate") ? new QWalkingMate(forProperty("walkingMate"), inits.get("walkingMate")) : null;
    }

}

