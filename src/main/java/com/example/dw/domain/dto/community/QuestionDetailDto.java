package com.example.dw.domain.dto.community;


import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class QuestionDetailDto {

    private Long id; // questionId
    private String questionTitle;
    private String questionContent;
    private String questionRd;

    private Long questionImgId;
    private String questionImgRoute;
    private String questionImgUuid;
    private String questionImgName;



    private Long userId;
    private String userName;

    @QueryProjection
    public QuestionDetailDto(Long id, String questionTitle, String questionContent, String questionRd, Long questionImgId, String questionImgRoute, String questionImgUuid, String questionImgName, Long userId, String userName) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.questionImgId = questionImgId;
        this.questionImgRoute = questionImgRoute;
        this.questionImgUuid = questionImgUuid;
        this.questionImgName = questionImgName;
        this.userId = userId;
        this.userName = userName;
    }
}
