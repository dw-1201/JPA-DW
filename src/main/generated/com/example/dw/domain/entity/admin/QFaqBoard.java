package com.example.dw.domain.entity.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFaqBoard is a Querydsl query type for FaqBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFaqBoard extends EntityPathBase<FaqBoard> {

    private static final long serialVersionUID = -741427046L;

    public static final QFaqBoard faqBoard = new QFaqBoard("faqBoard");

    public final StringPath faqBoardContent = createString("faqBoardContent");

    public final StringPath faqBoardMd = createString("faqBoardMd");

    public final StringPath faqBoardRd = createString("faqBoardRd");

    public final StringPath faqBoardTitle = createString("faqBoardTitle");

    public final NumberPath<Long> faqBoardViewCount = createNumber("faqBoardViewCount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QFaqBoard(String variable) {
        super(FaqBoard.class, forVariable(variable));
    }

    public QFaqBoard(Path<? extends FaqBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFaqBoard(PathMetadata metadata) {
        super(FaqBoard.class, metadata);
    }

}

