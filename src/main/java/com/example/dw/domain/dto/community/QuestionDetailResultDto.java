package com.example.dw.domain.dto.community;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class QuestionDetailResultDto {
// 세부 페이지에 담기위해 뿌려줘야하는 데이터를 모두 집어넣는다.

    private Long id;
    private String questionTitle;
    private String questionContent;
    private String questionRd;
    private Long userId;
    private String userName;
    private List<QuestionImgDto> questionDetailDtoList;

    public QuestionDetailResultDto(Long id, String questionTitle, String questionContent, String questionRd, Long userId, String userName, List<QuestionImgDto> questionDetailDtoList) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.userId = userId;
        this.userName = userName;
        this.questionDetailDtoList = questionDetailDtoList;
    }

    public QuestionDetailResultDto(Long id, String questionTitle, String questionContent, String questionRd, Long userId, String userName) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.userId = userId;
        this.userName = userName;
    }
}
