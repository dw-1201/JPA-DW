package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminQnaDetailResultDto {

    private Long qnaBoardId;

    private String questionTitle;
    private String questionContent;
    private LocalDateTime questionRd;
    private Long userId;
    private String userAccount;
    private Long viewCount;
    private List<AdminQnaDetailImgsDto> adminQnaDetailImgsDtoList;
    private List<AdminQnaDetailCommentDto> adminQnaDetailCommentDtoList;


    public AdminQnaDetailResultDto(Long qnaBoardId, String questionTitle, String questionContent, LocalDateTime questionRd, Long userId, String userAccount, Long viewCount, List<AdminQnaDetailImgsDto> adminQnaDetailImgsDtoList, List<AdminQnaDetailCommentDto> adminQnaDetailCommentDtoList) {
        this.qnaBoardId = qnaBoardId;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.userId = userId;
        this.userAccount = userAccount;
        this.viewCount = viewCount;
        this.adminQnaDetailImgsDtoList = adminQnaDetailImgsDtoList;
        this.adminQnaDetailCommentDtoList = adminQnaDetailCommentDtoList;
    }
}
