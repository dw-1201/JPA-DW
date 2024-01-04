package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionListDto {

    private Long id;
    private String questionTitle;
    private String questionContent;
    private String questionRd;
    private LocalDateTime questionMd;
    //조회수

    //유저정보 추가
    private Long userId;
    private String userName;

    private Long commentCount;

    //사용자 이미지
    List<QuestionImgDto> questionImgDtoList;


    @QueryProjection

    public QuestionListDto(Long id, String questionTitle, String questionContent, String questionRd, LocalDateTime questionMd, Long userId, String userName, Long commentCount, List<QuestionImgDto> questionImgDtoList) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.questionMd = questionMd;
        this.userId = userId;
        this.userName = userName;
        this.commentCount = commentCount;
        this.questionImgDtoList = questionImgDtoList;
    }
}
