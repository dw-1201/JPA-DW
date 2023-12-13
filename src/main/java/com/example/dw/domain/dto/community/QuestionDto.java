package com.example.dw.domain.dto.community;


import com.example.dw.domain.entity.user.Users;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class QuestionDto {

    private Long id;
    private String questionTitle;
    private String questionContent;
    private LocalDateTime questionRd;
    private LocalDateTime questionMd;
    //조회수
//    private Long questionViewCount;

    //유저정보 추가
    private Long userId;
    private String userName;

    //사용자 이미지



    @QueryProjection
    public QuestionDto(Long id, String questionTitle, String questionContent, LocalDateTime questionRd, LocalDateTime questionMd, Users user) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.questionMd = questionMd;

        // 유저 정보 추가
        if (user != null) {
            // Hibernate.initialize를 사용하지 않고 바로 값을 가져오도록 변경
            this.userId=user.getId();
            this.userName =user.getUserName();

        }


    }
}
