package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

//freeBoardList 게시판 조회를 위한 DTO
@Data
@NoArgsConstructor
public class FreeBoardListDto {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardRd;
    private LocalDateTime freeBoardMd;
    private Long freeBoardViewCount;
//    private Long freeBoardCommentCount;

    //유저 정보 추가
    private Long userId;
    private String userAccount;
    private String userNickName;

    //댓글수
    private Long commentCount;

    //자유게시판 이미지 추가
    List<FreeBoardImgDto> freeBoardImgDtoList;

    @QueryProjection
    public FreeBoardListDto(Long id, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long freeBoardViewCount, Long userId, String userAccount, String userNickName, Long commentCount, List<FreeBoardImgDto> freeBoardImgDtoList) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.commentCount = commentCount;
        this.freeBoardImgDtoList = freeBoardImgDtoList;
    }

}
