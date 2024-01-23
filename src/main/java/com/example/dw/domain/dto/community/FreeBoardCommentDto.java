package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FreeBoardCommentDto {

    private Long id;
    private String freeBoardCommentContent;
    private LocalDateTime freeBoardCommentRd;
    private LocalDateTime freeBoardCommentMd;

    //자유게시판 글 번호
    private Long freeBoardId;

    //유저 정보
    private Long userId;
    private String userAccount;
    private String userNickName;

    //유저 이미지
    private Long userImgId;
    private String userImgPath;
    private String userImgUuid;
    private String userImgName;

    @QueryProjection
    public FreeBoardCommentDto(Long id, String freeBoardCommentContent, LocalDateTime freeBoardCommentRd, LocalDateTime freeBoardCommentMd, Long freeBoardId, Long userId, String userAccount, String userNickName, Long userImgId, String userImgPath, String userImgUuid, String userImgName) {
        this.id = id;
        this.freeBoardCommentContent = freeBoardCommentContent;
        this.freeBoardCommentRd = freeBoardCommentRd;
        this.freeBoardCommentMd = freeBoardCommentMd;
        this.freeBoardId = freeBoardId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.userImgId = userImgId;
        this.userImgPath = userImgPath;
        this.userImgUuid = userImgUuid;
        this.userImgName = userImgName;
    }
}
