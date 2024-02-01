package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//freeBoardList 게시판 조회를 위한 DTO
@Data
@NoArgsConstructor
public class FreeBoardDto {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardRd;
    private LocalDateTime freeBoardMd;
    private Long freeBoardViewCount;
    private Long freeBoardCommentCount;

    //유저 정보 추가
    private Long userId;
    private String userAccount;
    private String userNickName;
    //유저 간판 이미지
    private Long userFileId;
    private String route;
    private String name;
    private String uuid;

    @QueryProjection
    public FreeBoardDto(Long id, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long freeBoardViewCount, Long freeBoardCommentCount, Long userId, String userAccount, String userNickName, Long userFileId, String route, String name, String uuid) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.freeBoardCommentCount = freeBoardCommentCount;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.userFileId = userFileId;
        this.route = route;
        this.name = name;
        this.uuid = uuid;
    }
}
