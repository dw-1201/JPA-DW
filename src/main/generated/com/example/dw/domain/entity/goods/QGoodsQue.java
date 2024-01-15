package com.example.dw.domain.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodsQue is a Querydsl query type for GoodsQue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsQue extends EntityPathBase<GoodsQue> {

    private static final long serialVersionUID = -1779619186L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoodsQue goodsQue = new QGoodsQue("goodsQue");

    public final QGoods goods;

    public final ListPath<GoodsQueReply, QGoodsQueReply> goodsQueReply = this.<GoodsQueReply, QGoodsQueReply>createList("goodsQueReply", GoodsQueReply.class, QGoodsQueReply.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath queContent = createString("queContent");

    public final DateTimePath<java.time.LocalDateTime> queModifyDate = createDateTime("queModifyDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> queRegisterDate = createDateTime("queRegisterDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final com.example.dw.domain.entity.user.QUsers users;

    public QGoodsQue(String variable) {
        this(GoodsQue.class, forVariable(variable), INITS);
    }

    public QGoodsQue(Path<? extends GoodsQue> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoodsQue(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoodsQue(PathMetadata metadata, PathInits inits) {
        this(GoodsQue.class, metadata, inits);
    }

    public QGoodsQue(Class<? extends GoodsQue> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.goods = inits.isInitialized("goods") ? new QGoods(forProperty("goods")) : null;
        this.users = inits.isInitialized("users") ? new com.example.dw.domain.entity.user.QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

