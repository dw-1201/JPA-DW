package com.example.dw.domain.dto.community;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

//freeBoardList 게시판 조회를 위한 DTO
// 세부 페이지에 담기위해 뿌려줘야하는 데이터를 모두 집어넣는다.
@Data
@NoArgsConstructor
public class FreeBoardResultDetailDto {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardRd;
    private LocalDateTime freeBoardMd;
    private Long freeBoardViewCount;

    //유저 정보 추가
    private Long userId;
    private String userAccount;
    private String userNickName;

    //자유게시판 이미지
    private List<FreeBoardImgDto> freeBoardImgDtoList;

//    @QueryProjection
    public FreeBoardResultDetailDto(Long id, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long freeBoardViewCount, Long userId, String userAccount, String userNickName, List<FreeBoardImgDto> freeBoardImgDtoList) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.freeBoardImgDtoList = freeBoardImgDtoList;
    }

    public FreeBoardResultDetailDto(Long id, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long freeBoardViewCount, Long userId, String userAccount, String userNickName) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
    }
}
