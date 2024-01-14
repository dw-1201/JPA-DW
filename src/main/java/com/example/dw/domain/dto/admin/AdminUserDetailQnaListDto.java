package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminUserDetailQnaListDto {


    private Long qnaBoardId;
    private String qnaBoardTitle;
    private LocalDateTime qnaBoardRd;
    private Long viewCount;
    private Long replyCount;

    @QueryProjection

    public AdminUserDetailQnaListDto(Long qnaBoardId, String qnaBoardTitle, LocalDateTime qnaBoardRd, Long viewCount, Long replyCount) {
        this.qnaBoardId = qnaBoardId;
        this.qnaBoardTitle = qnaBoardTitle;
        this.qnaBoardRd = qnaBoardRd;
        this.viewCount = viewCount;
        this.replyCount = replyCount;
    }
}
