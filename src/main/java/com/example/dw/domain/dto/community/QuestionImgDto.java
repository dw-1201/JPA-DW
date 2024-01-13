package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

// 파일에 저장되어 있는 이미지 전체 뽑기
@Data
@NoArgsConstructor
public class QuestionImgDto {

    private Long id;
    private String questionImgRoute;
    private String questionImgName;
    private String questionImgUuid;

    // 질문 번호
    private Long questionId;
    @QueryProjection
    public QuestionImgDto(Long id, String questionImgRoute, String questionImgName, String questionImgUuid, Long questionId) {
        this.id = id;
        this.questionImgRoute = questionImgRoute;
        this.questionImgName = questionImgName;
        this.questionImgUuid = questionImgUuid;
        this.questionId = questionId;
    }

    @QueryProjection
    public QuestionImgDto(Long id, String questionImgRoute, String questionImgName, String questionImgUuid) {
        this.id = id;
        this.questionImgRoute = questionImgRoute;
        this.questionImgName = questionImgName;
        this.questionImgUuid = questionImgUuid;
    }

    public QuestionImgDto(Long id, String questionImgRoute, String questionImgUuid, Long questionId) {

    }
}
