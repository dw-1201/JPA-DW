package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminNoticeBoardDto {

    private Long id;
    private String noticeBoardTitle;
    private String noticeBoardContent;
    private Long noticeBoardViewCount;
    private LocalDateTime noticeBoardRd;
    private LocalDateTime noticeBoardMd;

    @QueryProjection
    public AdminNoticeBoardDto(Long id, String noticeBoardTitle, String noticeBoardContent, Long noticeBoardViewCount, LocalDateTime noticeBoardRd, LocalDateTime noticeBoardMd) {
        this.id = id;
        this.noticeBoardTitle = noticeBoardTitle;
        this.noticeBoardContent = noticeBoardContent;
        this.noticeBoardViewCount = noticeBoardViewCount;
        this.noticeBoardRd = noticeBoardRd;
        this.noticeBoardMd = noticeBoardMd;
    }
}
