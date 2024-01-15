package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminFreeDetailResultDto {


    private Long freeBoardId;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardRd;
    private LocalDateTime freeBoardMd;
    private Long userId;
    private String userAccount;
    private Long viewCount;

    private List<AdminFreeDetailImgDto> imgList;
    private List<AdminFreeDetailCommentDto> replyList;


    public AdminFreeDetailResultDto(Long freeBoardId, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long userId, String userAccount, Long viewCount, List<AdminFreeDetailImgDto> imgList, List<AdminFreeDetailCommentDto> replyList) {
        this.freeBoardId = freeBoardId;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.userId = userId;
        this.userAccount = userAccount;
        this.viewCount = viewCount;
        this.imgList = imgList;
        this.replyList = replyList;
    }
}
