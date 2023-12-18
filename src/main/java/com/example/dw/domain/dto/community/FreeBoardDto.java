package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

//freeBoardList 게시판 조회를 위한 DTO
@Data
@NoArgsConstructor
public class FreeBoardDto {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private String freeBoardRd;
    private String freeBoardMd;
    private Long freeBoardViewCount;
    private Long freeBoardCommentCount; // 댓글 수 추가

    //자유게시판 이미지 추가
    private Long freeBoardImgId;
    private String freeBoardImgRoute;
    private String freeBoardImgName;
    private String freeBoardImgUuid;

    //유저 정보 추가
    private Long userId;  // User의 id 필드
    private String userAccount;  // User의 userAccount 필드
    private String userNickName;  // User의 userNickName 필드

    @QueryProjection
    public FreeBoardDto(Long id, String freeBoardTitle, String freeBoardContent,
                        String freeBoardRd, String freeBoardMd, Long freeBoardViewCount,
            Long freeBoardCommentCount, Long freeBoardImgId, String freeBoardImgRoute, String freeBoardImgName,
                        String freeBoardImgUuid, Long userId, String userAccount,
                        String userNickName) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;

        this.freeBoardCommentCount = freeBoardCommentCount;

        //자유게시판 이미지 추가
        this.freeBoardImgId = freeBoardImgId;
        this.freeBoardImgRoute = freeBoardImgRoute;
        this.freeBoardImgName = freeBoardImgName;
        this.freeBoardImgUuid = freeBoardImgUuid;

        // 유저 정보 추가
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
    }

    public void setFreeBoardCommentCount(Long freeBoardCommentCount) {
        this.freeBoardCommentCount = freeBoardCommentCount;
    }
}
