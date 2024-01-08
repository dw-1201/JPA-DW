package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WalkMateDetailReplyDto {


    private Long id;
    private String walkDetailReplyComment;
    private LocalDateTime walkCommendRd;
    private LocalDateTime walkCommentMd;
    private Long userId;
    private String userAccount;
    private String userNickName;
    private Long userImgId;
    private String userImgPath;
    private String userImgUuid;
    private String userImgName;

    @QueryProjection
    public WalkMateDetailReplyDto(Long id, String walkDetailReplyComment, LocalDateTime walkCommendRd, LocalDateTime walkCommentMd, Long userId, String userAccount, String userNickName, Long userImgId, String userImgPath, String userImgUuid, String userImgName) {
        this.id = id;
        this.walkDetailReplyComment = walkDetailReplyComment;
        this.walkCommendRd = walkCommendRd;
        this.walkCommentMd = walkCommentMd;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.userImgId = userImgId;
        this.userImgPath = userImgPath;
        this.userImgUuid = userImgUuid;
        this.userImgName = userImgName;
    }



    @QueryProjection
    public WalkMateDetailReplyDto(Long id, String walkDetailReplyComment, LocalDateTime walkCommendRd, LocalDateTime walkCommentMd, Long userId, String userAccount, String userNickName) {
        this.id = id;
        this.walkDetailReplyComment = walkDetailReplyComment;
        this.walkCommendRd = walkCommendRd;
        this.walkCommentMd = walkCommentMd;
        this.userId = userId;
        this.userAccount = userAccount;
    }
}
