package com.example.dw.domain.entity.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrders is a Querydsl query type for Orders
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrders extends EntityPathBase<Orders> {

    private static final long serialVersionUID = 1159904176L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrders orders = new QOrders("orders");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orderAddressDetail = createString("orderAddressDetail");

    public final StringPath orderAddressDetails = createString("orderAddressDetails");

    public final StringPath orderAddressNormal = createString("orderAddressNormal");

    public final QOrderList orderList;

    public final StringPath orderMemo = createString("orderMemo");

    public final StringPath orderUserAddressNumber = createString("orderUserAddressNumber");

    public final StringPath orderUserEmail = createString("orderUserEmail");

    public final StringPath orderUserName = createString("orderUserName");

    public final StringPath orderUserPhoneNumber = createString("orderUserPhoneNumber");

    public final com.example.dw.domain.entity.user.QUsers user;

    public QOrders(String variable) {
        this(Orders.class, forVariable(variable), INITS);
    }

    public QOrders(Path<? extends Orders> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrders(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrders(PathMetadata metadata, PathInits inits) {
        this(Orders.class, metadata, inits);
    }

    public QOrders(Class<? extends Orders> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.orderList = inits.isInitialized("orderList") ? new QOrderList(forProperty("orderList"), inits.get("orderList")) : null;
        this.user = inits.isInitialized("user") ? new com.example.dw.domain.entity.user.QUsers(forProperty("user"), inits.get("user")) : null;
    }

}

