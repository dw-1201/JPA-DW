//package com.example.dw.repository.community;
//
//
//
//
//
//
//
//import com.example.dw.domain.dto.community.QuestionDto;
//import com.example.dw.domain.form.SearchForm;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//import static com.example.dw.domain.entity.question.QQuestion.*;
//import static com.example.dw.domain.entity.question.QQuestionComment.*;
//
//
//@Repository
//public class QuestionRepositoryImpl implements QuestionRepositoryCuston{
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    public QuestionRepositoryImpl(JPAQueryFactory jpaQueryFactory){this.jpaQueryFactory=jpaQueryFactory;}
//
//    @Override
//    public Page<QuestionDto> findQnaListBySearch(Pageable pageable, SearchForm searchForm) {
//            List<QuestionDto> content = getQuestionList(pageable ,searchForm);
//            Long count = getCount(searchForm);
//            return new PageImpl<>(content,pageable,count);
//
//
//    }
//
//    //전체 페이지
//    private Long getCount(SearchForm searchForm){
////        StringPath cate = searchForm.getCate().equals("serchquestion") ? question.questionTitle : searchForm.getCate().equals("questioncontent") ?
////                question.questionContent : question.questionTitle;
//
//        Long count = jpaQueryFactory
//                .select(question.count())
//                .from(question)
////                .where(cate.like("%"+searchForm.getKeyword()+"%"))
//                .fetchOne();
//
//            return count;
//    }
//
//
////    전체 리스트 코드
//    private List<QuestionDto> getQuestionList(Pageable pageable , SearchForm searchForm){
////            StringPath cate = searchForm.getCate().equals("serchquestion") ? question.questionTitle : searchForm.getCate().equals("questioncontent") ?
////                        question.questionContent : question.questionTitle;
//
////        System.out.println("서치 내용 "+ cate+"---");
//        System.out.println("검색된 내용 "+ searchForm.getKeyword()+"++++");
//
//        List<QuestionDto> contentList= jpaQueryFactory
//                .select(new QQuestionDto(
//                        question.id,
//                        question.questionTitle,
//                        question.questionContent,
//                        question.questionRd,
//                        question.questionMd,
//                        question.users
//
//                ))
//                .from(question)
//                .join(questionComment)
//                .on(question.id.eq(questionComment.question.id))
////                .where(cate.like("%"+searchForm.getKeyword()+"%"))
//                .orderBy(question.questionRd.desc())
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
//
//            return contentList;
//    }
//
//
////    public Long getCommentCount(){
////
////        Long count = jpaQueryFactory
////                .select(questionComment.id.count())
////                .from(questionComment)
////                .join(question)
////                .on(questionComment.id.eq(question.id))
////                .fetchOne();
////        System.out.println(count+"-----");
////        return count;
////
////    }
//
//
//
//}
