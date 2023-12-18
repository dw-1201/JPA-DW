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
//    private Long questionViewCount;

    //유저정보 추가
    private Long userId;
    private String userName;

    //사용자 이미지
    List<QuestionImgDto> questionImgDtoList;
//    private Long questionImgId;
//    private String questionImgRoute;
//    private String questionImgName;
//    private String questionImgUuid;

    @QueryProjection
    public QuestionListDto(Long id, String questionTitle, String questionContent, String questionRd, LocalDateTime questionMd, Long userId, String userName, List<QuestionImgDto> questionImgDtoList) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.questionMd = questionMd;
        this.userId = userId;
        this.userName = userName;
        this.questionImgDtoList = questionImgDtoList;
    }


}
