package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminQnaDetailCommentDto {


    private Long id;
    private String userAccount;
    private String questionCommentContent;
    private LocalDateTime questionCommentRd;
    private LocalDateTime questionCommentMd;

    @QueryProjection
    public AdminQnaDetailCommentDto(Long id, String userAccount, String questionCommentContent, LocalDateTime questionCommentRd, LocalDateTime questionCommentMd) {
        this.id = id;
        this.userAccount = userAccount;
        this.questionCommentContent = questionCommentContent;
        this.questionCommentRd = questionCommentRd;
        this.questionCommentMd = questionCommentMd;
    }
}
