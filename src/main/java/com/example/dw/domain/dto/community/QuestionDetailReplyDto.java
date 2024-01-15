package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class QuestionDetailReplyDto {

    private Long id;
    private String questionCommentContent;
    private LocalDateTime questionCommentRd;
    private LocalDateTime questionCommentMd;
    private Long userId;
    private String userAccount;
    private String userNickName;
    private Long userImgId;
    private String userImgPath;
    private String userImgUuid;
    private String userImgName;

    @QueryProjection
    public QuestionDetailReplyDto(Long id, String questionCommentContent, LocalDateTime questionCommentRd, LocalDateTime questionCommentMd, Long userId, String userAccount, String userNickName, Long userImgId, String userImgPath, String userImgUuid, String userImgName) {
        this.id = id;
        this.questionCommentContent = questionCommentContent;
        this.questionCommentRd = questionCommentRd;
        this.questionCommentMd = questionCommentMd;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.userImgId = userImgId;
        this.userImgPath = userImgPath;
        this.userImgUuid = userImgUuid;
        this.userImgName = userImgName;
    }
}
