package com.example.dw.domain.entity.walkingMate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWalkingMateAddress is a Querydsl query type for WalkingMateAddress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWalkingMateAddress extends EntityPathBase<WalkingMateAddress> {

    private static final long serialVersionUID = -879599823L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWalkingMateAddress walkingMateAddress = new QWalkingMateAddress("walkingMateAddress");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QWalkingMate walkingMate;

    public final StringPath walkingMateAddressCity = createString("walkingMateAddressCity");

    public final StringPath walkingMateAddressCountry = createString("walkingMateAddressCountry");

    public final StringPath walkingMateAddressDetail = createString("walkingMateAddressDetail");

    public QWalkingMateAddress(String variable) {
        this(WalkingMateAddress.class, forVariable(variable), INITS);
    }

    public QWalkingMateAddress(Path<? extends WalkingMateAddress> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWalkingMateAddress(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWalkingMateAddress(PathMetadata metadata, PathInits inits) {
        this(WalkingMateAddress.class, metadata, inits);
    }

    public QWalkingMateAddress(Class<? extends WalkingMateAddress> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.walkingMate = inits.isInitialized("walkingMate") ? new QWalkingMate(forProperty("walkingMate"), inits.get("walkingMate")) : null;
    }

}

