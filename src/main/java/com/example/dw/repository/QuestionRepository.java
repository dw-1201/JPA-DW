package com.example.dw.repository;

import com.example.dw.domain.entity.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
