package com.example.dw.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodsDetailImg is a Querydsl query type for GoodsDetailImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsDetailImg extends EntityPathBase<GoodsDetailImg> {

    private static final long serialVersionUID = -1827746539L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoodsDetailImg goodsDetailImg = new QGoodsDetailImg("goodsDetailImg");

    public final QGoods goods;

    public final StringPath goodsDetailImgName = createString("goodsDetailImgName");

    public final StringPath goodsDetailImgPath = createString("goodsDetailImgPath");

    public final StringPath goodsDetailImgUuid = createString("goodsDetailImgUuid");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGoodsDetailImg(String variable) {
        this(GoodsDetailImg.class, forVariable(variable), INITS);
    }

    public QGoodsDetailImg(Path<? extends GoodsDetailImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoodsDetailImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoodsDetailImg(PathMetadata metadata, PathInits inits) {
        this(GoodsDetailImg.class, metadata, inits);
    }

    public QGoodsDetailImg(Class<? extends GoodsDetailImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.goods = inits.isInitialized("goods") ? new QGoods(forProperty("goods"), inits.get("goods")) : null;
    }

}

