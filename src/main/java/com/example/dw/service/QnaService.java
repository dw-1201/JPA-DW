package com.example.dw.service;


import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.QuestionWritingForm;
import com.example.dw.domain.entity.question.Question;
import com.example.dw.repository.UsersRepository;
import com.example.dw.repository.community.QuestionRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QnaService {

    private final QuestionRepository questionRepository;
    private final UsersRepository usersRepository;
    // 글 작성, 사진 파일 저장
    @Transactional
    public Long register(QuestionWritingForm questionWritingForm) throws IOException {
        System.out.println(questionWritingForm.toString()+"WW");
        Question question = questionRepository.save(questionWritingForm.toEntity());



        System.out.println(question.getUsers().getId()+"유저 아이디");
        System.out.println(question.getUsers().getUserName()+"유저 이름");
        return question.getId();

    }

    //질의 사항 전체 조회
    @Transactional
    public List<Question> qnaList(){
        List<Question> questionList = questionRepository.findAll();

        return questionList;
    }

}
