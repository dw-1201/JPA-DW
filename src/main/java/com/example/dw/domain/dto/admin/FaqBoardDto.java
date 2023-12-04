package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//faq게시판 조회
@Data
@NoArgsConstructor
public class FaqBoardDto {

    private Long id;
    private String faqBoardTitle;
    private String faqBoardContent;
    private Long faqBoardViewCount;
    private LocalDate faqBoardRd;
    private LocalDate faqBoardMd;

    public FaqBoardDto(Long id, String faqBoardTitle, String faqBoardContent,
                       Long faqBoardViewCount, LocalDate faqBoardRd, LocalDate faqBoardMd) {
        this.id = id;
        this.faqBoardTitle = faqBoardTitle;
        this.faqBoardContent = faqBoardContent;
        this.faqBoardViewCount = faqBoardViewCount;
        this.faqBoardRd = faqBoardRd;
        this.faqBoardMd = faqBoardMd;
    }



}
