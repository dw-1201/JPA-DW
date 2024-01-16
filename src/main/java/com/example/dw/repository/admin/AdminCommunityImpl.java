package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.dw.domain.entity.freeBoard.QFreeBoard.freeBoard;
import static com.example.dw.domain.entity.freeBoard.QFreeBoardImg.freeBoardImg;
import static com.example.dw.domain.entity.freeBoard.QFreeBoardComment.freeBoardComment;
import static com.example.dw.domain.entity.question.QQuestion.question;
import static com.example.dw.domain.entity.question.QQuestionComment.questionComment;
import static com.example.dw.domain.entity.question.QQuestionImg.questionImg;
import static com.example.dw.domain.entity.user.QUsers.users;


@Repository
@RequiredArgsConstructor
public class AdminCommunityImpl implements AdminCommunityRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    //qna목록
    @Override
    public Page<AdminQnaBoardList> qnaBoardList(Pageable pageable, SearchForm searchForm) {
        List<AdminQnaBoardList> qnaList= jpaQueryFactory.select(new QAdminQnaBoardList(
                question.id,
                question.users.id,
                question.users.userAccount,
                question.questionTitle,
                question.questionRd,
                question.questionViewCount
        ))
                .from(question)
                .leftJoin(question.users, users)
                .where(
                        qnaBoardSearchCriteria(searchForm)

                )
                .orderBy(question.id.desc())
                .fetch();

        Long getTotal = jpaQueryFactory.select(
                question.count()
        )
                .from(question)
                .where(
                        qnaBoardSearchCriteria(searchForm)
                )
                .fetchOne();


        return new PageImpl<>(qnaList, pageable, getTotal);

    }

    //qna 상세
    @Override
    public AdminQnaDetailResultDto qnaDetail(Long qnaId) {

        if (qnaId == null) {
            throw new IllegalArgumentException("게시번호 누락");
        }
        //게시글 정보
        List<AdminQnaDetailDto> qnaInfo = jpaQueryFactory.select(new QAdminQnaDetailDto(
                question.questionTitle,
                question.questionContent,
                question.questionRd,
                question.users.id,
                question.users.userAccount,
                question.questionViewCount,
                questionImg.id,
                questionImg.questionImgRoute,
                questionImg.questionImgUuid,
                questionImg.questionImgName
        ))
                .from(question)
                .leftJoin(question.users, users)
                .leftJoin(question.questionImg, questionImg)
                .where(question.id.eq(qnaId))
                .fetch();


        //게시글 댓글
        List<AdminQnaDetailCommentDto> qnaComments = jpaQueryFactory.select(new QAdminQnaDetailCommentDto(
                questionComment.id,
                questionComment.question.users.userAccount,
                questionComment.questionCommentContent,
                questionComment.questionCommentRd,
                questionComment.questionCommentMd
        ))
                .from(questionComment)
                .leftJoin(questionComment.question, question)
                .leftJoin(question.users, users)
                .where(questionComment.question.id.eq(qnaId))
                .fetch();

        return Optional.ofNullable(
                new AdminQnaDetailResultDto(
                        qnaId,

                        qnaInfo.stream().findFirst().get().getQuestionTitle(),
                        qnaInfo.stream().findFirst().get().getQuestionContent(),
                        qnaInfo.stream().findFirst().get().getQuestionRd(),
                        qnaInfo.stream().findFirst().get().getUserId(),
                        qnaInfo.stream().findFirst().get().getUserAccount(),
                        qnaInfo.stream().findFirst().get().getViewCount()
                        ,
                        qnaInfo.stream().map(o -> new AdminQnaDetailImgsDto(o.getQuestionImgId(), o.getQuestionImgRoute(), o.getQuestionImgUuid(),
                                o.getQuestionImgName())).collect(Collectors.toList()),
                        qnaComments
                )
        ).orElseThrow(()->{
            throw new IllegalArgumentException("정보 없음");
        });

    }

    //자유게시판 상세
    @Override
    public AdminFreeDetailResultDto freeBoardDetail(Long freeBoardId) {

        List<AdminFreeDetailDto> freeContent = jpaQueryFactory.select(new QAdminFreeDetailDto(
                freeBoard.id,
                freeBoard.freeBoardTitle,
                freeBoard.freeBoardContent,
                freeBoard.freeBoardRd,
                freeBoard.freeBoardMd,
                freeBoard.users.id,
                freeBoard.users.userAccount,
                freeBoard.freeBoardViewCount,
                freeBoardImg.id,
                freeBoardImg.freeBoardImgRoute,
                freeBoardImg.freeBoardImgUuid,
                freeBoardImg.freeBoardImgName
        ))
                .from(freeBoard)
                .leftJoin(freeBoard.users, users)
                .leftJoin(freeBoard.freeBoardImg, freeBoardImg)
                .where(freeBoard.id.eq(freeBoardId))
                .fetch();


        AdminFreeDetailResultDto result = freeContent.stream().map(
                o -> {

                    List<AdminFreeDetailCommentDto> commentDto = jpaQueryFactory.select(
                            new QAdminFreeDetailCommentDto(
                                    freeBoardComment.id,
                                    freeBoardComment.users.userAccount,
                                    freeBoardComment.freeBoardCommentContent,
                                    freeBoardComment.freeBoardCommentRd,
                                    freeBoardComment.freeBoardCommentMd
                            )

                    )       .from(freeBoardComment)
                            .leftJoin(freeBoardComment.users, users)
                            .where(freeBoardComment.freeBoard.id.eq(freeContent.stream().findFirst().get().getFreeBoardId()))
                            .fetch();

                    List<AdminFreeDetailImgDto> imgList =
                            freeContent.stream().map(
                                    img -> new AdminFreeDetailImgDto(img.getFreeBoardImgId(), img.getFreeBoardImgPath(), img.getFreeBoardImgUuid(), img.getFreeBoardImgName())
                            ).collect(Collectors.toList());

                    return new AdminFreeDetailResultDto(
                        o.getFreeBoardId(), o.getFreeBoardTitle(), o.getFreeBoardContent(), o.getFreeBoardRd(), o.getFreeBoardMd(), o.getUserId(), o.getUserAccount(),o.getViewCount(),
                            imgList,
                            commentDto
                    );

                }
        ).findFirst().get();


        return Optional.ofNullable(result).orElseThrow(()->{
            throw new IllegalArgumentException("정보 없음");
        });
    }


    //자유게시판 목록
    @Override
    public Page<AdminFreeBoardList> freeBoardList(Pageable pageable, SearchForm searchForm) {

        List<AdminFreeBoardList> freeBoardList = jpaQueryFactory.select(new QAdminFreeBoardList(
                freeBoard.id,
                freeBoard.users.id,
                freeBoard.users.userAccount,
                freeBoard.freeBoardTitle,
                freeBoard.freeBoardRd,
                freeBoard.freeBoardViewCount
        ))
                .from(freeBoard)
                .leftJoin(freeBoard.users, users)
                .where(
                        freeBoardSearchCriteria(searchForm)
                )
                .orderBy(freeBoard.id.desc())
                .fetch();


        Long getTotal = jpaQueryFactory.select(
                freeBoard.count()
        )
                .from(freeBoard)
                .where(
                        freeBoardSearchCriteria(searchForm)
                )
                .fetchOne();


        return new PageImpl<>(freeBoardList, pageable, getTotal);
    }

 


    public BooleanExpression qnaBoardSearchCriteria(SearchForm searchForm) {
        if (StringUtils.hasText(searchForm.getCate()) && StringUtils.hasText(searchForm.getKeyword())) {
            switch (searchForm.getCate()) {
                case "title":
                    return question.questionTitle.containsIgnoreCase(searchForm.getKeyword());
                case "writer":
                    return question.users.userAccount.containsIgnoreCase(searchForm.getKeyword());
                default:
                    break;
            }
        }
        return question.id.isNotNull();
    }

    public BooleanExpression freeBoardSearchCriteria(SearchForm searchForm) {
        if (StringUtils.hasText(searchForm.getCate()) && StringUtils.hasText(searchForm.getKeyword())) {
            switch (searchForm.getCate()) {
                case "title":
                    return freeBoard.freeBoardTitle.containsIgnoreCase(searchForm.getKeyword());
                case "writer":
                    return freeBoard.users.userAccount.containsIgnoreCase(searchForm.getKeyword());
                default:
                    break;
            }
        }
        return freeBoard.id.isNotNull();
    }

}
