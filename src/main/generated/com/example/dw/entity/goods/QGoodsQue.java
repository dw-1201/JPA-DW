package com.example.dw.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodsQue is a Querydsl query type for GoodsQue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsQue extends EntityPathBase<GoodsQue> {

    private static final long serialVersionUID = -26038172L;

    public static final QGoodsQue goodsQue = new QGoodsQue("goodsQue");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGoodsQue(String variable) {
        super(GoodsQue.class, forVariable(variable));
    }

    public QGoodsQue(Path<? extends GoodsQue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodsQue(PathMetadata metadata) {
        super(GoodsQue.class, metadata);
    }

}

