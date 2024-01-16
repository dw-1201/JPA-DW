package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminFreeDetailCommentDto {


    private Long freeBoardCommentId;
    private String userAccount;
    private String freeBoardCommentContent;
    private LocalDateTime freeBoardCommentRd;
    private LocalDateTime freeBoardCommentMd;

    @QueryProjection
    public AdminFreeDetailCommentDto(Long freeBoardCommentId, String userAccount, String freeBoardCommentContent, LocalDateTime freeBoardCommentRd, LocalDateTime freeBoardCommentMd) {
        this.freeBoardCommentId = freeBoardCommentId;
        this.userAccount = userAccount;
        this.freeBoardCommentContent = freeBoardCommentContent;
        this.freeBoardCommentRd = freeBoardCommentRd;
        this.freeBoardCommentMd = freeBoardCommentMd;
    }
}
