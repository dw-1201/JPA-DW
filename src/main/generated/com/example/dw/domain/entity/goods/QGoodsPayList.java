package com.example.dw.domain.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodsPayList is a Querydsl query type for GoodsPayList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsPayList extends EntityPathBase<GoodsPayList> {

    private static final long serialVersionUID = -649066829L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoodsPayList goodsPayList = new QGoodsPayList("goodsPayList");

    public final QGoods goods;

    public final NumberPath<Integer> goodsPrice = createNumber("goodsPrice", Integer.class);

    public final NumberPath<Integer> goodsQuantity = createNumber("goodsQuantity", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.dw.domain.entity.user.QUsers users;

    public QGoodsPayList(String variable) {
        this(GoodsPayList.class, forVariable(variable), INITS);
    }

    public QGoodsPayList(Path<? extends GoodsPayList> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoodsPayList(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoodsPayList(PathMetadata metadata, PathInits inits) {
        this(GoodsPayList.class, metadata, inits);
    }

    public QGoodsPayList(Class<? extends GoodsPayList> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.goods = inits.isInitialized("goods") ? new QGoods(forProperty("goods")) : null;
        this.users = inits.isInitialized("users") ? new com.example.dw.domain.entity.user.QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

