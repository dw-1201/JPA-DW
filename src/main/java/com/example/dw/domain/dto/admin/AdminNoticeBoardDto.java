package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminNoticeBoardDto {

    private Long id;
    private String noticeBoardTitle;
    private String noticeBoardContent;
    private Long noticeBoardViewCount;
    private String noticeBoardRd;
    private String noticeBoardMd;

    @QueryProjection
    public AdminNoticeBoardDto(Long id, String noticeBoardTitle, String noticeBoardContent,
                               Long noticeBoardViewCount, String noticeBoardRd, String noticeBoardMd) {
        this.id = id;
        this.noticeBoardTitle = noticeBoardTitle;
        this.noticeBoardContent = noticeBoardContent;
        this.noticeBoardViewCount = noticeBoardViewCount;
        this.noticeBoardRd = noticeBoardRd;
        this.noticeBoardMd = noticeBoardMd;
    }


}
