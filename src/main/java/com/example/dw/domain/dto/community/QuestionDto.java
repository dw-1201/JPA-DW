package com.example.dw.domain.dto.community;


import com.example.dw.domain.entity.user.Users;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
//    List<QuestionImgDto> questionImgDtoList;

    @QueryProjection
    public QuestionDto(Long id, String questionTitle, String questionContent, LocalDateTime questionRd, LocalDateTime questionMd, Long userId, String userName) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.questionMd = questionMd;
        this.userId = userId;
        this.userName = userName;
    }
}
