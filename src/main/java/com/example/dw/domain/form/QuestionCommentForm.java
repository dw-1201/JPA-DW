package com.example.dw.domain.form;


import com.example.dw.domain.entity.question.Question;
import com.example.dw.domain.entity.question.QuestionComment;
import com.example.dw.domain.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionCommentForm {

    private Long id;
    private String questionCommentContent;
    private Long questionId;
    private Long userId;


    @Builder
    public QuestionCommentForm(Long id, String questionCommentContent, Long questionId, Long userId) {
        this.id = id;
        this.questionCommentContent = questionCommentContent;
        this.questionId = questionId;
        this.userId = userId;
    }

    public QuestionComment toEntity(){
        return QuestionComment.builder()
                .id(id)
                .questionCommentContent(questionCommentContent)
                .question(Question.builder().id(questionId).build())
                .users(Users.builder().id(userId).build())
                .build();
    }
}
