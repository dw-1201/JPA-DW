package com.example.dw.domain.entity.user;

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

    private static final long serialVersionUID = 590920400L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsers users = new QUsers("users");

    public final com.example.dw.domain.embedded.QAddress address;

    public final ListPath<com.example.dw.domain.entity.freeBoard.FreeBoard, com.example.dw.domain.entity.freeBoard.QFreeBoard> freeBoard = this.<com.example.dw.domain.entity.freeBoard.FreeBoard, com.example.dw.domain.entity.freeBoard.QFreeBoard>createList("freeBoard", com.example.dw.domain.entity.freeBoard.FreeBoard.class, com.example.dw.domain.entity.freeBoard.QFreeBoard.class, PathInits.DIRECT2);

    public final ListPath<com.example.dw.domain.entity.freeBoard.FreeBoardComment, com.example.dw.domain.entity.freeBoard.QFreeBoardComment> freeBoardComments = this.<com.example.dw.domain.entity.freeBoard.FreeBoardComment, com.example.dw.domain.entity.freeBoard.QFreeBoardComment>createList("freeBoardComments", com.example.dw.domain.entity.freeBoard.FreeBoardComment.class, com.example.dw.domain.entity.freeBoard.QFreeBoardComment.class, PathInits.DIRECT2);

    public final ListPath<com.example.dw.domain.entity.goods.GoodsQueReply, com.example.dw.domain.entity.goods.QGoodsQueReply> goodsQueReplyList = this.<com.example.dw.domain.entity.goods.GoodsQueReply, com.example.dw.domain.entity.goods.QGoodsQueReply>createList("goodsQueReplyList", com.example.dw.domain.entity.goods.GoodsQueReply.class, com.example.dw.domain.entity.goods.QGoodsQueReply.class, PathInits.DIRECT2);

    public final ListPath<com.example.dw.domain.entity.goods.GoodsQue, com.example.dw.domain.entity.goods.QGoodsQue> goodsQues = this.<com.example.dw.domain.entity.goods.GoodsQue, com.example.dw.domain.entity.goods.QGoodsQue>createList("goodsQues", com.example.dw.domain.entity.goods.GoodsQue.class, com.example.dw.domain.entity.goods.QGoodsQue.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Pet, QPet> pet = this.<Pet, QPet>createList("pet", Pet.class, QPet.class, PathInits.DIRECT2);

    public final ListPath<com.example.dw.domain.entity.question.Question, com.example.dw.domain.entity.question.QQuestion> questions = this.<com.example.dw.domain.entity.question.Question, com.example.dw.domain.entity.question.QQuestion>createList("questions", com.example.dw.domain.entity.question.Question.class, com.example.dw.domain.entity.question.QQuestion.class, PathInits.DIRECT2);

    public final StringPath userAccount = createString("userAccount");

    public final DatePath<java.time.LocalDate> userDeleteDate = createDate("userDeleteDate", java.time.LocalDate.class);

    public final StringPath userEmail = createString("userEmail");

    public final ListPath<UserFile, QUserFile> userFile = this.<UserFile, QUserFile>createList("userFile", UserFile.class, QUserFile.class, PathInits.DIRECT2);

    public final StringPath userIntroduction = createString("userIntroduction");

    public final DatePath<java.time.LocalDate> userJoinDate = createDate("userJoinDate", java.time.LocalDate.class);

    public final StringPath userName = createString("userName");

    public final StringPath userNickName = createString("userNickName");

    public final StringPath userPassword = createString("userPassword");

    public final StringPath userPhone = createString("userPhone");

    public final NumberPath<Integer> userState = createNumber("userState", Integer.class);

    public final ListPath<com.example.dw.domain.entity.walkingMate.WalkingMate, com.example.dw.domain.entity.walkingMate.QWalkingMate> walkingMates = this.<com.example.dw.domain.entity.walkingMate.WalkingMate, com.example.dw.domain.entity.walkingMate.QWalkingMate>createList("walkingMates", com.example.dw.domain.entity.walkingMate.WalkingMate.class, com.example.dw.domain.entity.walkingMate.QWalkingMate.class, PathInits.DIRECT2);

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
        this.address = inits.isInitialized("address") ? new com.example.dw.domain.embedded.QAddress(forProperty("address")) : null;
    }

}

