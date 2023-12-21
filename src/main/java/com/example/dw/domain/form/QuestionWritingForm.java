package com.example.dw.domain.form;


import com.example.dw.domain.entity.question.Question;
import com.example.dw.domain.entity.question.QuestionImg;
import com.example.dw.domain.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionWritingForm {

    private Long id;

    private String questionTitle;
    private String questionContent;
    private Long userId;

    @Builder
    public QuestionWritingForm(Long id, String questionTitle, String questionContent, Long questionViewCount, Long userId) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.userId = userId;
    }

    // wriitingQna에서 작성한 이후 Form에 담아서 question 테이블에 저장하려고 하는데
    // toEntity로 보내면 Users에 insert가 되버립니다 ㅠㅠ
    public Question toEntity(){
        return  Question.builder()
            .id(id)
            .questionTitle(questionTitle)
            .questionContent(questionContent)
            .users(Users.builder().id(userId).build())
            .build();
    }



}
