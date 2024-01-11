package com.example.dw.domain.entity.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderReview is a Querydsl query type for OrderReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderReview extends EntityPathBase<OrderReview> {

    private static final long serialVersionUID = -1272600997L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderReview orderReview = new QOrderReview("orderReview");

    public final StringPath content = createString("content");

    public final QGoodsReviewReply goodsReviewReply;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOrderItem orderItem;

    public final ListPath<OrderReviewImg, QOrderReviewImg> orderReviewImgList = this.<OrderReviewImg, QOrderReviewImg>createList("orderReviewImgList", OrderReviewImg.class, QOrderReviewImg.class, PathInits.DIRECT2);

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> reviewRd = createDateTime("reviewRd", java.time.LocalDateTime.class);

    public final NumberPath<Long> state = createNumber("state", Long.class);

    public final StringPath title = createString("title");

    public QOrderReview(String variable) {
        this(OrderReview.class, forVariable(variable), INITS);
    }

    public QOrderReview(Path<? extends OrderReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderReview(PathMetadata metadata, PathInits inits) {
        this(OrderReview.class, metadata, inits);
    }

    public QOrderReview(Class<? extends OrderReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.goodsReviewReply = inits.isInitialized("goodsReviewReply") ? new QGoodsReviewReply(forProperty("goodsReviewReply"), inits.get("goodsReviewReply")) : null;
        this.orderItem = inits.isInitialized("orderItem") ? new QOrderItem(forProperty("orderItem"), inits.get("orderItem")) : null;
    }

}

