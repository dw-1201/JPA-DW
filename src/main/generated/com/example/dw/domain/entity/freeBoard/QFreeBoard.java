package com.example.dw.domain.entity.freeBoard;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFreeBoard is a Querydsl query type for FreeBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeBoard extends EntityPathBase<FreeBoard> {

    private static final long serialVersionUID = -2116276677L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFreeBoard freeBoard = new QFreeBoard("freeBoard");

    public final ListPath<FreeBoardComment, QFreeBoardComment> freeBoardComment = this.<FreeBoardComment, QFreeBoardComment>createList("freeBoardComment", FreeBoardComment.class, QFreeBoardComment.class, PathInits.DIRECT2);

    public final NumberPath<Long> freeBoardCommentCount = createNumber("freeBoardCommentCount", Long.class);

    public final StringPath freeBoardContent = createString("freeBoardContent");

    public final ListPath<FreeBoardImg, QFreeBoardImg> freeBoardImg = this.<FreeBoardImg, QFreeBoardImg>createList("freeBoardImg", FreeBoardImg.class, QFreeBoardImg.class, PathInits.DIRECT2);

    public final QFreeBoardLike freeBoardLike;

    public final DateTimePath<java.time.LocalDateTime> freeBoardMd = createDateTime("freeBoardMd", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> freeBoardRd = createDateTime("freeBoardRd", java.time.LocalDateTime.class);

    public final StringPath freeBoardTitle = createString("freeBoardTitle");

    public final NumberPath<Long> freeBoardViewCount = createNumber("freeBoardViewCount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.dw.domain.entity.user.QUsers users;

    public QFreeBoard(String variable) {
        this(FreeBoard.class, forVariable(variable), INITS);
    }

    public QFreeBoard(Path<? extends FreeBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFreeBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFreeBoard(PathMetadata metadata, PathInits inits) {
        this(FreeBoard.class, metadata, inits);
    }

    public QFreeBoard(Class<? extends FreeBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.freeBoardLike = inits.isInitialized("freeBoardLike") ? new QFreeBoardLike(forProperty("freeBoardLike"), inits.get("freeBoardLike")) : null;
        this.users = inits.isInitialized("users") ? new com.example.dw.domain.entity.user.QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

