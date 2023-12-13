package com.example.dw.domain.form;


import com.example.dw.domain.entity.question.Question;
import com.example.dw.domain.entity.question.QuestionImg;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionImgForm {

    private Long id;

    private String questionImgRoute;
    private String questionImgName;
    private String questionImgUuid;

    private Question question;

    @Builder
    public QuestionImgForm(Long id, String questionImgRoute, String questionImgName, String questionImgUuid, Question question) {
        this.id = id;
        this.questionImgRoute = questionImgRoute;
        this.questionImgName = questionImgName;
        this.questionImgUuid = questionImgUuid;
        this.question = question;
    }

    public QuestionImg toEntity(){
        return QuestionImg.builder()
                .id(id)
                .questionImgRoute(questionImgRoute)
                .questionImgName(questionImgName)
                .questionImgUuid(questionImgUuid)
                .question(question)
                .build();
    }
}
