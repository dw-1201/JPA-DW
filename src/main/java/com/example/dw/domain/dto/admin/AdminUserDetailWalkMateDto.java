package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminUserDetailWalkMateDto {


        private Long walkMateId;
        private String walkMateTitle;
        private LocalDateTime walkMateRd;
        private Long viewCount;
        private Long replyCount;

        @QueryProjection
    public AdminUserDetailWalkMateDto(Long walkMateId, String walkMateTitle, LocalDateTime walkMateRd, Long viewCount, Long replyCount) {
        this.walkMateId = walkMateId;
        this.walkMateTitle = walkMateTitle;
        this.walkMateRd = walkMateRd;
        this.viewCount = viewCount;
        this.replyCount = replyCount;
    }
}
