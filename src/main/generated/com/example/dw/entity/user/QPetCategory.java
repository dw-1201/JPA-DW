package com.example.dw.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPetCategory is a Querydsl query type for PetCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPetCategory extends EntityPathBase<PetCategory> {

    private static final long serialVersionUID = -448650661L;

    public static final QPetCategory petCategory = new QPetCategory("petCategory");

    public final StringPath categoryName = createString("categoryName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Pet, QPet> pet = this.<Pet, QPet>createList("pet", Pet.class, QPet.class, PathInits.DIRECT2);

    public QPetCategory(String variable) {
        super(PetCategory.class, forVariable(variable));
    }

    public QPetCategory(Path<? extends PetCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPetCategory(PathMetadata metadata) {
        super(PetCategory.class, metadata);
    }

}

