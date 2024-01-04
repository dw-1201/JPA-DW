package com.example.dw.domain.dto.community;

import com.example.dw.domain.entity.question.Question;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuestionCommentDto {

    private Long id;
    private String questionCommentContent;
    private LocalDateTime questionCommentRd;
    private LocalDateTime questionCommentMd;
    private Question question;

    @QueryProjection
    public QuestionCommentDto(Long id, String questionCommentContent, LocalDateTime questionCommentRd, LocalDateTime questionCommentMd, Question question) {
        this.id = id;
        this.questionCommentContent = questionCommentContent;
        this.questionCommentRd = questionCommentRd;
        this.questionCommentMd = questionCommentMd;
        this.question = question;
    }
}
