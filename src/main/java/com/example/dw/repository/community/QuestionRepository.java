package com.example.dw.repository.community;

import com.example.dw.domain.entity.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> {


    Optional<Question> findById(Long id);
}
