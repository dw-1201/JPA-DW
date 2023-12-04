package com.example.dw.domain.entity.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderReviewImg is a Querydsl query type for OrderReviewImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderReviewImg extends EntityPathBase<OrderReviewImg> {

    private static final long serialVersionUID = -379906200L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderReviewImg orderReviewImg = new QOrderReviewImg("orderReviewImg");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOrderReview orderReview;

    public final StringPath reviewimgFileName = createString("reviewimgFileName");

    public final StringPath reviewimgPath = createString("reviewimgPath");

    public final StringPath reviewimgUuid = createString("reviewimgUuid");

    public QOrderReviewImg(String variable) {
        this(OrderReviewImg.class, forVariable(variable), INITS);
    }

    public QOrderReviewImg(Path<? extends OrderReviewImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderReviewImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderReviewImg(PathMetadata metadata, PathInits inits) {
        this(OrderReviewImg.class, metadata, inits);
    }

    public QOrderReviewImg(Class<? extends OrderReviewImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.orderReview = inits.isInitialized("orderReview") ? new QOrderReview(forProperty("orderReview"), inits.get("orderReview")) : null;
    }

}

