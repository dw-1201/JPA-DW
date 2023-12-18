package com.example.dw.repository.community;









import com.example.dw.domain.dto.community.*;

import com.querydsl.core.types.dsl.BooleanExpression;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import static com.example.dw.domain.entity.question.QQuestion.question;

import java.util.List;



@Repository
public class QuestionRepositoryImpl implements QuestionRepositoryCuston{

    private final JPAQueryFactory jpaQueryFactory;

    public QuestionRepositoryImpl(JPAQueryFactory jpaQueryFactory){this.jpaQueryFactory=jpaQueryFactory;}

    // qna 리스트 확인
//    @Override
//    public Page<QuestionListDto> findQnaListBySearch(Pageable pageable,String keyword,QuestionDto questionDto,QuestionImgDto questionImgDto) {
//
//
//
//
//
////        return new PageImpl<>(lists, pageable, count);
//        return null;
//    }

//    @Override
//    public List<QuestionDetailResultDto> findQnaById(Long id) {
//         List<QuestionDetailDto> list = getQueDetail(id);
//
//         List<QuestionDetailResultDto> result = list.stream().collect(groupingBy(r-> new QuestionDetailResultDto(
//            r.getId(),r.getQuestionTitle(),r.getQuestionContent(),r.getQuestionRd(),r.getUserId(),r.getUserName()),mapping( r->new QuestionImgDto(
//                    r.getQuestionImgId(),r.getQuestionImgRoute(),r.getQuestionImgName(),r.getQuestionImgUuid(),r.getId()),toList())
//         )).entrySet().stream().map(e->new QuestionDetailResultDto(
//                 e.getKey().getId(), e.getKey().getQuestionTitle(),e.getKey().getQuestionContent(),e.getKey().getQuestionRd(),e.getKey().getUserId(), e.getKey().getUserName(),
//                e.getValue()))
//                 .collect(Collectors.toList());
//
//        System.out.println(result.toString()+"나와라!!");
//
//        return result;
//    }

//    @Override
//    public List<QuestionImgDto> findAllByQuestionId(Long questionId) {
//        return jpaQueryFactory.select(new QQuestionImgDto(
//                questionImg.id,
//                questionImg.questionImgRoute,
//                questionImg.questionImgName,
//                questionImg.questionImgUuid,
//                questionImg.question.id
//        )).from(questionImg)
//                .where(questionImg.question.id.eq(questionId))
//                .fetch();
//    }

    //    전체 리스트 코드
//    private List<QuestionDto> getQuestionList(Pageable pageable, String keyword){
//
//
//        List<QuestionDto> contentList= jpaQueryFactory
//                .select(new QQuestionDto(
//                        question.id,
//                        question.questionTitle,
//                        question.questionContent,
//                        question.questionRd,
//                        question.questionMd,
//                        users.id,
//                        users.userName,
//                        questionImg.id,
//                        questionImg.questionImgRoute,
//                        questionImg.questionImgName,
//                        questionImg.questionImgUuid
//                ))
//                .from(question)
//                .leftJoin(question.questionImg,questionImg)
//                .leftJoin(question.users,users)
//                .where(
//                        qnatitleEq(keyword))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
//
//
//                contentList.forEach(r ->
//                        System.out.println(r.getId()+"나와랑!!")
//                       );
//
//
//
//            return contentList;
//    }
//
//
 // 전체 페이지 조회 및 검색어 확인
    private Long getCount(String keyword){

        Long count = jpaQueryFactory
                .select(question.count())
                .from(question)
                .where(qnatitleEq(keyword))
                .fetchOne();

        return count;

    }
//
//    // 검색 조건 코드
    private BooleanExpression qnatitleEq(String keyword){
        return StringUtils.hasText(keyword) ? question.questionTitle.containsIgnoreCase(keyword) : null;
    }

//    // 게시판 번호를 보내주면 데이터가 뽑히는지 확인
//
//    private List<QuestionDetailDto> getQueDetail(Long id){
//        System.out.println(id + "의 아이디 조회입니다.");
//        List<QuestionDetailDto> questionDetailDtos = jpaQueryFactory
//                .select(new QQuestionDetailDto(
//                        question.id,
//                        question.questionTitle,
//                        question.questionContent,
//                        question.questionRd,
//                        questionImg.id,
//                        questionImg.questionImgRoute,
//                        questionImg.questionImgUuid,
//                        questionImg.questionImgName,
//                        question.users.id,
//                        question.users.userName
//                ))
//                .from(question)
//                .leftJoin(question.questionImg,questionImg)
//
//                .where(question.id.eq(id))
//                .fetch();
//
//        questionDetailDtos.forEach(r-> System.out.println(r.toString()+"좋았어"));
//                return Optional.ofNullable(questionDetailDtos).orElseThrow(()->{
//                    throw new IllegalArgumentException("조회결과 없름");
//                });
//    }

// question의 값을 불러오기
    public List<QuestionListDto> getQuestion(Pageable pageable, String keyword){
//        List<QuestionListDto> questionListDtos = jpaQueryFactory
//                .select(new QQuestionListDto(
//                        question.id,
//                        question.questionTitle,
//                        question.questionContent,
//                        question.questionRd,
//                        question.questionMd,
//                        question.users.id,
//                        question.users.userName,
//                        new QQuestionImgDto(
//                                questionImg.id,
//                                questionImg.questionImgRoute,
//                                questionImg.questionImgName,
//                                questionImg.questionImgUuid,
//                                questionImg.question.id
//                        )
//                )).
//                .from(question)
//                .leftJoin(questionImg).on(question.id.eq(questionImg.question.id))
//                .where( qnatitleEq(keyword))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();

        return null;

    }



}
