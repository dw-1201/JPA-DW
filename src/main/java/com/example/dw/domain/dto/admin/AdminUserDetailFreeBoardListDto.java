package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminUserDetailFreeBoardListDto {



    private Long freeBoardId;
    private String freeBoardTitle;
    private LocalDateTime freeBoardRd;
    private Long viewCount;
    private Long replyCount;


    @QueryProjection
    public AdminUserDetailFreeBoardListDto(Long freeBoardId, String freeBoardTitle, LocalDateTime freeBoardRd, Long viewCount, Long replyCount) {
        this.freeBoardId = freeBoardId;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardRd = freeBoardRd;
        this.viewCount = viewCount;
        this.replyCount = replyCount;
    }
}
