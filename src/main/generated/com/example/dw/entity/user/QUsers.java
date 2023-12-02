package com.example.dw.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 1239849894L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsers users = new QUsers("users");

    public final StringPath address = createString("address");

    public final StringPath detail = createString("detail");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Pet, QPet> pet = this.<Pet, QPet>createList("pet", Pet.class, QPet.class, PathInits.DIRECT2);

    public final StringPath userAccount = createString("userAccount");

    public final StringPath userEmail = createString("userEmail");

    public final QUserFile userFile;

    public final StringPath userIntroduction = createString("userIntroduction");

    public final DateTimePath<java.time.LocalDateTime> userJoinDate = createDateTime("userJoinDate", java.time.LocalDateTime.class);

    public final StringPath userName = createString("userName");

    public final StringPath userNickName = createString("userNickName");

    public final StringPath userPassword = createString("userPassword");

    public final StringPath userPhone = createString("userPhone");

    public final StringPath zipCode = createString("zipCode");

    public QUsers(String variable) {
        this(Users.class, forVariable(variable), INITS);
    }

    public QUsers(Path<? extends Users> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsers(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsers(PathMetadata metadata, PathInits inits) {
        this(Users.class, metadata, inits);
    }

    public QUsers(Class<? extends Users> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userFile = inits.isInitialized("userFile") ? new QUserFile(forProperty("userFile"), inits.get("userFile")) : null;
    }

}
