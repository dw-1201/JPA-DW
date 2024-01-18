package com.example.dw.domain.dto.index;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeeklyQnaListImg {


    private String questionImgRoute;
    private String questionImgUuid;
    private String questionImgName;

    @QueryProjection
    public WeeklyQnaListImg(String questionImgRoute, String questionImgUuid, String questionImgName) {
        this.questionImgRoute = questionImgRoute;
        this.questionImgUuid = questionImgUuid;
        this.questionImgName = questionImgName;
    }
}
