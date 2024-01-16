package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminFreeDetailDto {

    private Long freeBoardId;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardRd;
    private LocalDateTime freeBoardMd;
    private Long userId;
    private String userAccount;
    private Long viewCount;


    private Long freeBoardImgId;
    private String freeBoardImgPath;
    private String freeBoardImgUuid;
    private String freeBoardImgName;

    @QueryProjection
    public AdminFreeDetailDto(Long freeBoardId, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long userId, String userAccount, Long viewCount) {
        this.freeBoardId = freeBoardId;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.userId = userId;
        this.userAccount = userAccount;
        this.viewCount = viewCount;
    }




    @QueryProjection
    public AdminFreeDetailDto(Long freeBoardImgId, String freeBoardImgPath, String freeBoardImgUuid, String freeBoardImgName) {
        this.freeBoardImgId = freeBoardImgId;
        this.freeBoardImgPath = freeBoardImgPath;
        this.freeBoardImgUuid = freeBoardImgUuid;
        this.freeBoardImgName = freeBoardImgName;
    }


    @QueryProjection

    public AdminFreeDetailDto(Long freeBoardId, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long userId, String userAccount, Long viewCount, Long freeBoardImgId, String freeBoardImgPath, String freeBoardImgUuid, String freeBoardImgName) {
        this.freeBoardId = freeBoardId;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.userId = userId;
        this.userAccount = userAccount;
        this.viewCount = viewCount;
        this.freeBoardImgId = freeBoardImgId;
        this.freeBoardImgPath = freeBoardImgPath;
        this.freeBoardImgUuid = freeBoardImgUuid;
        this.freeBoardImgName = freeBoardImgName;
    }
}
