package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminQnaDetailImgsDto {

    private Long questionImgId;
    private String questionImgRoute;
    private String questionImgUuid;
    private String questionImgName;

    @QueryProjection
    public AdminQnaDetailImgsDto(Long questionImgId, String questionImgRoute, String questionImgUuid, String questionImgName) {
        this.questionImgId = questionImgId;
        this.questionImgRoute = questionImgRoute;
        this.questionImgUuid = questionImgUuid;
        this.questionImgName = questionImgName;
    }
}
