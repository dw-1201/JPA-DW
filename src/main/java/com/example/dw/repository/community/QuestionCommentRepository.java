package com.example.dw.repository.community;


import com.example.dw.domain.entity.question.QuestionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionCommentRepository extends JpaRepository<QuestionComment,Long> {


    @Modifying
    @Query("update QuestionComment qc set qc.questionCommentContent=:modifyquestionComment, qc.questionCommentRd=current_date where qc.id=:id")
    void updateQuestionComment(@Param("modifyquestionComment")String modifyquestionComment,@Param("id")Long id);

}
