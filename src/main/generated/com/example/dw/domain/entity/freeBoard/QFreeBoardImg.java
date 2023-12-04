package com.example.dw.domain.entity.freeBoard;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFreeBoardImg is a Querydsl query type for FreeBoardImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeBoardImg extends EntityPathBase<FreeBoardImg> {

    private static final long serialVersionUID = -173472888L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFreeBoardImg freeBoardImg = new QFreeBoardImg("freeBoardImg");

    public final QFreeBoard freeBoard;

    public final StringPath freeBoardImgName = createString("freeBoardImgName");

    public final StringPath freeBoardImgRoute = createString("freeBoardImgRoute");

    public final StringPath freeBoardImgUuid = createString("freeBoardImgUuid");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QFreeBoardImg(String variable) {
        this(FreeBoardImg.class, forVariable(variable), INITS);
    }

    public QFreeBoardImg(Path<? extends FreeBoardImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFreeBoardImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFreeBoardImg(PathMetadata metadata, PathInits inits) {
        this(FreeBoardImg.class, metadata, inits);
    }

    public QFreeBoardImg(Class<? extends FreeBoardImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.freeBoard = inits.isInitialized("freeBoard") ? new QFreeBoard(forProperty("freeBoard"), inits.get("freeBoard")) : null;
    }

}

