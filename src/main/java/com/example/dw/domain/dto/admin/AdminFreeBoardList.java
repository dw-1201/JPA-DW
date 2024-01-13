package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminFreeBoardList {

    private Long freeBoardId;
    private Long userId;
    private String userAccount;
    private String freeBoardTitle;
    private LocalDateTime freeBoardRd;
    private Long viewCount;


    @QueryProjection
    public AdminFreeBoardList(Long freeBoardId, Long userId, String userAccount, String freeBoardTitle, LocalDateTime freeBoardRd, Long viewCount) {
        this.freeBoardId = freeBoardId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardRd = freeBoardRd;
        this.viewCount = viewCount;
    }
}
