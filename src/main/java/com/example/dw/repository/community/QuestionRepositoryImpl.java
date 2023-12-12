package com.example.dw.repository.community;







import com.example.dw.domain.dto.community.QQuestionDto;
import com.example.dw.domain.dto.community.QuestionDto;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.dw.domain.entity.question.QQuestion.question;
import static com.example.dw.domain.entity.question.QQuestionComment.*;


@Repository
public class QuestionRepositoryImpl implements QuestionRepositoryCuston{

    private final JPAQueryFactory jpaQueryFactory;

    public QuestionRepositoryImpl(JPAQueryFactory jpaQueryFactory){this.jpaQueryFactory=jpaQueryFactory;}

    // qna 리스트 확인
    @Override
    public Page<QuestionDto> findQnaListBySearch(Pageable pageable,String keyword) {
        List<QuestionDto> content =getQuestionList(pageable,keyword);
        Long count = getCount(keyword);

        System.out.println("[상품 개수]"+count+"개");
        System.out.println("검색 내용"+keyword);
        content.forEach(r-> System.out.println("[리스트제목]"+r.getQuestionTitle()+" 입니다."));

        return new PageImpl<>(content,pageable,count);
    }



//    전체 리스트 코드
    private List<QuestionDto> getQuestionList(Pageable pageable, String keyword){


        List<QuestionDto> contentList= jpaQueryFactory
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
                .where(qnatitleEq(keyword))
                .orderBy(question.questionRd.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

                contentList.forEach(r ->
                        System.out.println(r.getId()+r.getUserName()+"나와랑!!")
                       );

        System.out.println(keyword+"검색내용이비낟");
            return contentList;
    }


 // 전체 페이지 조회 및 검색어 확인
    private Long getCount(String keyword){

        Long count = jpaQueryFactory
                .select(question.count())
                .from(question)
                .where(qnatitleEq(keyword))
                .fetchOne();

        return count;

    }

    // 검색 조건 코드
    private BooleanExpression qnatitleEq(String keyword){
        return StringUtils.hasText(keyword) ? question.questionTitle.containsIgnoreCase(keyword) : null;
    }

    //
}
