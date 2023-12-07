package com.example.dw.domain.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoods is a Querydsl query type for Goods
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoods extends EntityPathBase<Goods> {

    private static final long serialVersionUID = 1739350835L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoods goods = new QGoods("goods");

    public final EnumPath<GoodsCategory> goodsCategory = createEnum("goodsCategory", GoodsCategory.class);

    public final StringPath goodsCertify = createString("goodsCertify");

    public final StringPath goodsDetailContent = createString("goodsDetailContent");

    public final ListPath<GoodsDetailImg, QGoodsDetailImg> goodsDetailImg = this.<GoodsDetailImg, QGoodsDetailImg>createList("goodsDetailImg", GoodsDetailImg.class, QGoodsDetailImg.class, PathInits.DIRECT2);

    public final StringPath goodsMade = createString("goodsMade");

    public final QGoodsMainImg goodsMainImg;

    public final StringPath goodsModifyDate = createString("goodsModifyDate");

    public final StringPath goodsName = createString("goodsName");

    public final NumberPath<Long> goodsPrice = createNumber("goodsPrice", Long.class);

    public final NumberPath<Long> goodsQuantity = createNumber("goodsQuantity", Long.class);

    public final StringPath goodsRegisterDate = createString("goodsRegisterDate");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGoods(String variable) {
        this(Goods.class, forVariable(variable), INITS);
    }

    public QGoods(Path<? extends Goods> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoods(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoods(PathMetadata metadata, PathInits inits) {
        this(Goods.class, metadata, inits);
    }

    public QGoods(Class<? extends Goods> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.goodsMainImg = inits.isInitialized("goodsMainImg") ? new QGoodsMainImg(forProperty("goodsMainImg"), inits.get("goodsMainImg")) : null;
    }

}

