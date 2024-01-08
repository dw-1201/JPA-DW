package com.example.dw.domain.entity.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderList is a Querydsl query type for OrderList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderList extends EntityPathBase<OrderList> {

    private static final long serialVersionUID = 1692353633L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderList orderList = new QOrderList("orderList");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orderDate = createString("orderDate");

    public final QOrderReview orderReview;

    public final QOrders orders;

    public QOrderList(String variable) {
        this(OrderList.class, forVariable(variable), INITS);
    }

    public QOrderList(Path<? extends OrderList> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderList(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderList(PathMetadata metadata, PathInits inits) {
        this(OrderList.class, metadata, inits);
    }

    public QOrderList(Class<? extends OrderList> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.orderReview = inits.isInitialized("orderReview") ? new QOrderReview(forProperty("orderReview"), inits.get("orderReview")) : null;
        this.orders = inits.isInitialized("orders") ? new QOrders(forProperty("orders"), inits.get("orders")) : null;
    }

}

