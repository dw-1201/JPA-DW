package com.example.dw.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodsQueReply is a Querydsl query type for GoodsQueReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsQueReply extends EntityPathBase<GoodsQueReply> {

    private static final long serialVersionUID = 1024659686L;

    public static final QGoodsQueReply goodsQueReply = new QGoodsQueReply("goodsQueReply");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGoodsQueReply(String variable) {
        super(GoodsQueReply.class, forVariable(variable));
    }

    public QGoodsQueReply(Path<? extends GoodsQueReply> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodsQueReply(PathMetadata metadata) {
        super(GoodsQueReply.class, metadata);
    }

}

