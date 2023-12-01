package com.example.dw.entity.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodsReviewReply is a Querydsl query type for GoodsReviewReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsReviewReply extends EntityPathBase<GoodsReviewReply> {

    private static final long serialVersionUID = 1164486685L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoodsReviewReply goodsReviewReply = new QGoodsReviewReply("goodsReviewReply");

    public final StringPath goodsReviewReplyContent = createString("goodsReviewReplyContent");

    public final DateTimePath<java.time.LocalDateTime> goodsReviewReplyMD = createDateTime("goodsReviewReplyMD", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> goodsReviewReplyRD = createDateTime("goodsReviewReplyRD", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOrderReview orderReview;

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public QGoodsReviewReply(String variable) {
        this(GoodsReviewReply.class, forVariable(variable), INITS);
    }

    public QGoodsReviewReply(Path<? extends GoodsReviewReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoodsReviewReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoodsReviewReply(PathMetadata metadata, PathInits inits) {
        this(GoodsReviewReply.class, metadata, inits);
    }

    public QGoodsReviewReply(Class<? extends GoodsReviewReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.orderReview = inits.isInitialized("orderReview") ? new QOrderReview(forProperty("orderReview"), inits.get("orderReview")) : null;
    }

}

