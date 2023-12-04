package com.example.dw.domain.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPetImg is a Querydsl query type for PetImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPetImg extends EntityPathBase<PetImg> {

    private static final long serialVersionUID = 982995548L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPetImg petImg = new QPetImg("petImg");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPet pet;

    public final StringPath petFileName = createString("petFileName");

    public final StringPath petPath = createString("petPath");

    public final StringPath petUuid = createString("petUuid");

    public QPetImg(String variable) {
        this(PetImg.class, forVariable(variable), INITS);
    }

    public QPetImg(Path<? extends PetImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPetImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPetImg(PathMetadata metadata, PathInits inits) {
        this(PetImg.class, metadata, inits);
    }

    public QPetImg(Class<? extends PetImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pet = inits.isInitialized("pet") ? new QPet(forProperty("pet"), inits.get("pet")) : null;
    }

}

