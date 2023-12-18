package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

//faq게시판 조회
@Data
@NoArgsConstructor
public class AdminFaqBoardDto {

    private Long id;
    private String faqBoardTitle;
    private String faqBoardContent;
    private Long faqBoardViewCount;
    private String faqBoardRd;
    private String faqBoardMd;


    @QueryProjection
    public AdminFaqBoardDto(Long id, String faqBoardTitle, String faqBoardContent,
                            Long faqBoardViewCount, String faqBoardRd, String faqBoardMd) {
        this.id = id;
        this.faqBoardTitle = faqBoardTitle;
        this.faqBoardContent = faqBoardContent;
        this.faqBoardViewCount = faqBoardViewCount;
        this.faqBoardRd = faqBoardRd;
        this.faqBoardMd = faqBoardMd;
    }





}
