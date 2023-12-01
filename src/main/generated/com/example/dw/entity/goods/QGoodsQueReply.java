package com.example.dw.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodsQueReply is a Querydsl query type for GoodsQueReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsQueReply extends EntityPathBase<GoodsQueReply> {

    private static final long serialVersionUID = 1024659686L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoodsQueReply goodsQueReply = new QGoodsQueReply("goodsQueReply");

    public final QGoodsQue goodsQue;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath queReplyContent = createString("queReplyContent");

    public final DateTimePath<java.time.LocalDateTime> queReplyModifyDate = createDateTime("queReplyModifyDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> queReplyRegisterDate = createDateTime("queReplyRegisterDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public QGoodsQueReply(String variable) {
        this(GoodsQueReply.class, forVariable(variable), INITS);
    }

    public QGoodsQueReply(Path<? extends GoodsQueReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoodsQueReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoodsQueReply(PathMetadata metadata, PathInits inits) {
        this(GoodsQueReply.class, metadata, inits);
    }

    public QGoodsQueReply(Class<? extends GoodsQueReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.goodsQue = inits.isInitialized("goodsQue") ? new QGoodsQue(forProperty("goodsQue"), inits.get("goodsQue")) : null;
    }

}

