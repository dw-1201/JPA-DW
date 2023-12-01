package com.example.dw.entity.goods;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodsCategory is a Querydsl query type for GoodsCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsCategory extends EntityPathBase<GoodsCategory> {

    private static final long serialVersionUID = -2023009989L;

    public static final QGoodsCategory goodsCategory = new QGoodsCategory("goodsCategory");

    public final ListPath<Goods, QGoods> goods = this.<Goods, QGoods>createList("goods", Goods.class, QGoods.class, PathInits.DIRECT2);

    public final StringPath goodsCategoryName = createString("goodsCategoryName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGoodsCategory(String variable) {
        super(GoodsCategory.class, forVariable(variable));
    }

    public QGoodsCategory(Path<? extends GoodsCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodsCategory(PathMetadata metadata) {
        super(GoodsCategory.class, metadata);
    }

}

