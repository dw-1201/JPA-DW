package com.example.dw.domain.entity.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNoticeBoard is a Querydsl query type for NoticeBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNoticeBoard extends EntityPathBase<NoticeBoard> {

    private static final long serialVersionUID = 1644945284L;

    public static final QNoticeBoard noticeBoard = new QNoticeBoard("noticeBoard");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath noticeBoardContent = createString("noticeBoardContent");

    public final StringPath noticeBoardMd = createString("noticeBoardMd");

    public final StringPath noticeBoardRd = createString("noticeBoardRd");

    public final StringPath noticeBoardTitle = createString("noticeBoardTitle");

    public final NumberPath<Long> noticeBoardViewCount = createNumber("noticeBoardViewCount", Long.class);

    public QNoticeBoard(String variable) {
        super(NoticeBoard.class, forVariable(variable));
    }

    public QNoticeBoard(Path<? extends NoticeBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNoticeBoard(PathMetadata metadata) {
        super(NoticeBoard.class, metadata);
    }

}

