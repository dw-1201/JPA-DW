package com.example.dw.service;


import com.example.dw.domain.form.QnaBoardForm;
import com.example.dw.domain.entity.question.Question;
import com.example.dw.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QnaService {

    private final QuestionRepository questionRepository;

    // 글 작성

    @Transactional
    public Long writer(QnaBoardForm qnaBoardForm){

        Question question =qnaBoardForm.toEntity();

        questionRepository.save(question);

        return question.getId();

    }

}
