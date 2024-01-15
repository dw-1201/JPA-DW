package com.example.dw.repository.community;

import com.example.dw.domain.dto.community.*;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.dw.domain.entity.question.QQuestion.question;
import static com.example.dw.domain.entity.question.QQuestionComment.questionComment;
import static com.example.dw.domain.entity.question.QQuestionImg.questionImg;
import static java.util.stream.Collectors.*;


@Repository
public class QuestionRepositoryImpl implements QuestionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public QuestionRepositoryImpl(JPAQueryFactory jpaQueryFactory){this.jpaQueryFactory=jpaQueryFactory;}

    // qna 리스트 확인
    @Override
    public Page<QuestionListDto> findQnaListBySearch(Pageable pageable, String keyword) {
        //검색어
        BooleanExpression keywordTitle = qnatitleEq(keyword);

        //페이징 및 검색조건을 적용하여 question 엔티티 조회
        List<QuestionDto> content = jpaQueryFactory
                .select(new QQuestionDto(
                        question.id,
                        question.questionTitle,
                        question.questionContent,
                        question.questionRd,
                        question.questionMd,
                        question.users.id,
                        question.users.userName
                ))
                .from(question)
                .where( keywordTitle )
                .orderBy(question.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 페이징을 위한 전체 데이터 수 조회
        Long count = getCount(keyword);


        List<QuestionListDto> contents =
                content.stream().map(questionDto -> {

                    Long commentCount = jpaQueryFactory
                            .select(questionComment.id.count())
                            .from(questionComment)
                            .where(questionComment.question.id.eq(questionDto.getId()))
                            .fetchOne();

                    System.out.println(commentCount+"댓글수 입니다.");

                    List<QuestionImgDto> questionImgDto = jpaQueryFactory
                            .select(new QQuestionImgDto(
                                    questionImg.id,
                                    questionImg.questionImgRoute,
                                    questionImg.questionImgName,
                                    questionImg.questionImgUuid,
                                    question.id
                            ))
                            .from(questionImg)
                            .leftJoin(questionImg.question, question)
                            .where(question.id.eq(questionDto.getId()))
                            .fetch();

                    List<QuestionImgDto> imgDto = questionImgDto.stream()
                            .map(imgDtos -> new QuestionImgDto(
                                    imgDtos.getId(),
                                    imgDtos.getQuestionImgRoute(),
                                    imgDtos.getQuestionImgName(),
                                    imgDtos.getQuestionImgUuid(),
                                    imgDtos.getQuestionId()
                            ))
                            .collect(toList());

                    return new QuestionListDto(
                            questionDto.getId(),
                            questionDto.getQuestionTitle(),
                            questionDto.getQuestionContent(),
                            questionDto.getQuestionRd(),
                            questionDto.getQuestionMd(),
                            questionDto.getUserId(),
                            questionDto.getUserName(),
                            commentCount,
                            imgDto

                    );
                }).collect(Collectors.toList());




        System.out.println(contents.toString()+"리스트 ");




        return new PageImpl<>(contents, pageable,count);
    }

//
//    // 전체 페이지 조회 및 검색어 확인
    private Long getCount(String keyword){

        Long count = jpaQueryFactory
                .select(question.count())
                .from(question)
                .where(qnatitleEq(keyword))
                .fetchOne();

        return count;

    }
//
//
    private BooleanExpression qnatitleEq(String keyword){
        return StringUtils.hasText(keyword) ? question.questionTitle.containsIgnoreCase(keyword) : null;
    }

    @Override
    public List<QuestionDetailResultDto> findQnaById(Long id) {
        List<QuestionDetailDto> list = getQueDetail(id);


            List<QuestionDetailResultDto> result = list.stream().collect(groupingBy(r -> new QuestionDetailResultDto(
                    r.getId(),r.getQuestionTitle(),r.getQuestionContent(),r.getQuestionRd(),r.getUserId(),r.getUserName()),mapping(r->new QuestionImgDto(
                            r.getQuestionImgId(),r.getQuestionImgRoute(),r.getQuestionImgName(),r.getQuestionImgUuid(),r.getId()),toList())
            )).entrySet().stream().map(e -> new QuestionDetailResultDto(
                    e.getKey().getId(), e.getKey().getQuestionTitle(),e.getKey().getQuestionContent(),e.getKey().getQuestionRd(),e.getKey().getUserId(), e.getKey().getUserName(),
                    e.getValue()))
                    .collect(Collectors.toList());




        System.out.println(result.toString()+"나와라!!");

        return result;
    }

    @Override
    public List<QuestionImgDto> findAllByQuestionId(Long questionId) {
        return jpaQueryFactory.select(new QQuestionImgDto(
                questionImg.id,
                questionImg.questionImgRoute,
                questionImg.questionImgName,
                questionImg.questionImgUuid,
                questionImg.question.id
        )).from(questionImg)
                .where(questionImg.question.id.eq(questionId))
                .fetch();
    }




//    // 게시판 번호를 보내주면 데이터가 뽑히는지 확인

    private List<QuestionDetailDto> getQueDetail(Long id){
        System.out.println(id + "의 아이디 조회입니다.");
        List<QuestionDetailDto> questionDetailDtos = jpaQueryFactory
                .select(new QQuestionDetailDto(
                        question.id,
                        question.questionTitle,
                        question.questionContent,
                        question.questionRd,
                        questionImg.id,
                        questionImg.questionImgRoute,
                        questionImg.questionImgUuid,
                        questionImg.questionImgName,
                        question.users.id,
                        question.users.userName
                ))
                .from(question)
                .leftJoin(question.questionImg,questionImg)

                .where(question.id.eq(id))
                .fetch();

        questionDetailDtos.forEach(r-> System.out.println(r.toString()+"좋았어"));

        return questionDetailDtos;

    }


    // 특정 유저 작성글 마이 페이지에 조회
    @Override
    public Page<QuestionListDto> findQnaListById(Pageable pageable,Long userId) {
        System.out.println(userId + "마이페이지 글 조회를 위한 유저아이디 번호입니다");
        List<QuestionDto> content = jpaQueryFactory
                .select(new QQuestionDto(
                        question.id,
                        question.questionTitle,
                        question.questionContent,
                        question.questionRd,
                        question.questionMd,
                        question.users.id,
                        question.users.userName
                ))
                .from(question)
                .where(question.users.id.eq(userId))
                .orderBy(question.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 페이징을 위한 전체 데이터 수 조회
        Long count = getMypageCount(userId);


        List<QuestionListDto> contents =
                content.stream().map(questionDto -> {
                    Long commentCount = jpaQueryFactory
                            .select(questionComment.id.count())
                            .from(questionComment)
                            .where(questionComment.question.id.eq(questionDto.getId()))
                            .fetchOne();

                    System.out.println(commentCount+"마이 댓글수 ");

                    List<QuestionImgDto> questionImgDto = jpaQueryFactory
                            .select(new QQuestionImgDto(
                                    questionImg.id,
                                    questionImg.questionImgRoute,
                                    questionImg.questionImgName,
                                    questionImg.questionImgUuid,
                                    question.id
                            ))
                            .from(questionImg)
                            .leftJoin(questionImg.question, question)
                            .where(question.id.eq(questionDto.getId()))
                            .fetch();

                    List<QuestionImgDto> imgDto = questionImgDto.stream()
                            .map(imgDtos -> new QuestionImgDto(
                                    imgDtos.getId(),
                                    imgDtos.getQuestionImgRoute(),
                                    imgDtos.getQuestionImgName(),
                                    imgDtos.getQuestionImgUuid(),
                                    imgDtos.getQuestionId()
                            ))
                            .collect(toList());


                    return new QuestionListDto(
                            questionDto.getId(),
                            questionDto.getQuestionTitle(),
                            questionDto.getQuestionContent(),
                            questionDto.getQuestionRd(),
                            questionDto.getQuestionMd(),
                            questionDto.getUserId(),
                            questionDto.getUserName(),
                            commentCount,
                            imgDto
                    );
                }).collect(Collectors.toList());

        contents.forEach(r-> System.out.println(r.getId()+"항목"));




        return new PageImpl<>(contents, pageable,count);



    }



    // 마이 페이지 조회
    private Long getMypageCount(Long userId){

        Long count = jpaQueryFactory
                .select(question.count())
                .from(question)
                .where(question.users.id.eq(userId))
                .fetchOne();
        System.out.println(count);

        return count;

    }

    // 댓글수 조회
//    private Long getComment(Long questionId){
//
//    }

}


