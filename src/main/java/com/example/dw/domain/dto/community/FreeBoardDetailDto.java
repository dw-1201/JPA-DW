package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//freeBoardList 게시판 조회를 위한 DTO
@Data
@NoArgsConstructor
public class FreeBoardDetailDto {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardRd;
    private LocalDateTime freeBoardMd;
    private Long freeBoardViewCount;

    //자유게시판 이미지 추가
    private Long freeBoardImgId;
    private String freeBoardImgRoute;
    private String freeBoardImgName;
    private String freeBoardImgUuid;

    //유저 정보 추가
    private Long userId;
    private String userAccount;
    private String userNickName;

    @QueryProjection
    public FreeBoardDetailDto(Long id, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long freeBoardViewCount, Long freeBoardImgId, String freeBoardImgRoute, String freeBoardImgName, String freeBoardImgUuid, Long userId, String userAccount, String userNickName) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.freeBoardImgId = freeBoardImgId;
        this.freeBoardImgRoute = freeBoardImgRoute;
        this.freeBoardImgName = freeBoardImgName;
        this.freeBoardImgUuid = freeBoardImgUuid;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
    }
}
