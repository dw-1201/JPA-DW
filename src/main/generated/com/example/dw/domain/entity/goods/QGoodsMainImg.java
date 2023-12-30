package com.example.dw.domain.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodsMainImg is a Querydsl query type for GoodsMainImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsMainImg extends EntityPathBase<GoodsMainImg> {

    private static final long serialVersionUID = 969595031L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoodsMainImg goodsMainImg = new QGoodsMainImg("goodsMainImg");

    public final QGoods goods;

    public final StringPath goodsMainImgName = createString("goodsMainImgName");

    public final StringPath goodsMainImgPath = createString("goodsMainImgPath");

    public final StringPath goodsMainImgUuid = createString("goodsMainImgUuid");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGoodsMainImg(String variable) {
        this(GoodsMainImg.class, forVariable(variable), INITS);
    }

    public QGoodsMainImg(Path<? extends GoodsMainImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoodsMainImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoodsMainImg(PathMetadata metadata, PathInits inits) {
        this(GoodsMainImg.class, metadata, inits);
    }

    public QGoodsMainImg(Class<? extends GoodsMainImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.goods = inits.isInitialized("goods") ? new QGoods(forProperty("goods")) : null;
    }

}

