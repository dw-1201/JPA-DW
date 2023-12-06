package com.example.dw.service;


import com.example.dw.domain.form.QnaBoardForm;
import com.example.dw.domain.entity.question.Question;
import com.example.dw.repository.community.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //질의 사항 전체 조회
    @Transactional
    public List<Question> qnaList(){
        List<Question> questionList = questionRepository.findAll();

        return questionList;
    }

}
