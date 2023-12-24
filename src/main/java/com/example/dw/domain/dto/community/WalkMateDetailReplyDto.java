package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkMateDetailReplyDto {


    private Long id;
    private String walkDetailReplyComment;
    private Long userId;
    private String userAccount;
    private String userNickName;
    private Long userImgId;
    private String userImgPath;
    private String userImgUuid;
    private String userImgName;

    @QueryProjection
    public WalkMateDetailReplyDto(Long id, String walkDetailReplyComment, Long userId, String userAccount, String userNickName, Long userImgId, String userImgPath, String userImgUuid, String userImgName) {
        this.id = id;
        this.walkDetailReplyComment = walkDetailReplyComment;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.userImgId = userImgId;
        this.userImgPath = userImgPath;
        this.userImgUuid = userImgUuid;
        this.userImgName = userImgName;
    }
}
