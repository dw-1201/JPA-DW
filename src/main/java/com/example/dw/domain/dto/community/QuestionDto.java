package com.example.dw.domain.dto.community;


import com.example.dw.domain.entity.user.Users;
import com.querydsl.core.annotations.QueryProjection;

import java.time.LocalDateTime;

public class QuestionDto {

    private Long id;
    private String questionTitle;
    private String questionContent;
    private LocalDateTime questionRd;
    private LocalDateTime questionMd;
    //조회수
//    private Long questionViewCount;

    private Users users;
    //댓글 수를 확인

    @QueryProjection
    public QuestionDto(Long id, String questionTitle, String questionContent, LocalDateTime questionRd, LocalDateTime questionMd, Users users) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.questionMd = questionMd;
        this.users = users;

    }
}
