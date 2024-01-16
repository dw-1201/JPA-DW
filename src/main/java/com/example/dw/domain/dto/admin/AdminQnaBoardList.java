package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminQnaBoardList {


    private Long qnaBoardId;
    private Long userId;
    private String userAccount;
    private String qnaBoardTitle;
    private LocalDateTime qnaBoardRd;
    private Long viewCount;

    @QueryProjection
    public AdminQnaBoardList(Long qnaBoardId, Long userId, String userAccount, String qnaBoardTitle, LocalDateTime qnaBoardRd, Long viewCount) {
        this.qnaBoardId = qnaBoardId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.qnaBoardTitle = qnaBoardTitle;
        this.qnaBoardRd = qnaBoardRd;
        this.viewCount = viewCount;
    }
}
