package com.example.dw.domain.entity.question;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Commit
class QuestionTest {

    @PersistenceContext
    private EntityManager em;

//    @Test
//    void EntityTest(){
////        Question question = new Question();
//        QuestionComment questionComment = new QuestionComment();
//        QuestionImg questionImg = new QuestionImg();
//        QuestionLike questionLike = new QuestionLike();
//
//        question.setQuestionTitle("제목");
//        question.setQuestionContent("내용");
//        question.setQuestionRd(LocalDateTime.now());
//        question.setQuestionMd(LocalDateTime.now());
//        question.setQuestionViewCount(1L);
//        em.persist(question);
//
//        questionComment.setQuestionCommentContent("댓글내용");
//        questionComment.setQuestionCommentRd(LocalDateTime.now());
//        questionComment.setQuestionCommentMd(LocalDateTime.now());
//        questionComment.setQuestion(question);
//        em.persist(questionComment);
//
//        questionImg.setQuestionImgName("이름");
//        questionImg.setQuestionImgRoute("경로");
//        questionImg.setQuestionImgUuid("uuid");
//        questionImg.setQuestion(question);
//        em.persist(questionImg);
//
//        questionLike.setQuestionLikeDisLike(2L);
//        questionLike.setQuestionLikeState(2L);
//        questionLike.setQuestion(question);
//        em.persist(questionLike);
//    }

}