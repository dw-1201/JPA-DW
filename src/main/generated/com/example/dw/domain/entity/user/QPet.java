package com.example.dw.domain.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPet is a Querydsl query type for Pet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPet extends EntityPathBase<Pet> {

    private static final long serialVersionUID = -750227481L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPet pet = new QPet("pet");

    public final StringPath birthDate = createString("birthDate");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath neutering = createString("neutering");

    public final QPetCategory petCategory;

    public final StringPath petGender = createString("petGender");

    public final QPetImg petImg;

    public final QUsers users;

    public final NumberPath<Long> weight = createNumber("weight", Long.class);

    public QPet(String variable) {
        this(Pet.class, forVariable(variable), INITS);
    }

    public QPet(Path<? extends Pet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPet(PathMetadata metadata, PathInits inits) {
        this(Pet.class, metadata, inits);
    }

    public QPet(Class<? extends Pet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.petCategory = inits.isInitialized("petCategory") ? new QPetCategory(forProperty("petCategory")) : null;
        this.petImg = inits.isInitialized("petImg") ? new QPetImg(forProperty("petImg"), inits.get("petImg")) : null;
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

