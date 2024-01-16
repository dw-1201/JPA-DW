package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminQnaDetailDto {



    private String questionTitle;
    private String questionContent;
    private LocalDateTime questionRd;
    private Long userId;
    private String userAccount;
    private Long viewCount;

    private Long questionImgId;
    private String questionImgRoute;
    private String questionImgUuid;
    private String questionImgName;

    @QueryProjection
    public AdminQnaDetailDto(String questionTitle, String questionContent, LocalDateTime questionRd, Long userId, String userAccount, Long viewCount) {
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.userId = userId;
        this.userAccount = userAccount;
        this.viewCount = viewCount;
    }




    @QueryProjection

    public AdminQnaDetailDto(String questionTitle, String questionContent, LocalDateTime questionRd, Long userId, String userAccount, Long viewCount, Long questionImgId, String questionImgRoute, String questionImgUuid, String questionImgName) {
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.userId = userId;
        this.userAccount = userAccount;
        this.viewCount = viewCount;
        this.questionImgId = questionImgId;
        this.questionImgRoute = questionImgRoute;
        this.questionImgUuid = questionImgUuid;
        this.questionImgName = questionImgName;
    }
}
