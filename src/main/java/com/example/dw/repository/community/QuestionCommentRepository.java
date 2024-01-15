package com.example.dw.repository.community;


import com.example.dw.domain.entity.question.QuestionComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionCommentRepository extends JpaRepository<QuestionComment,Long> {


}
