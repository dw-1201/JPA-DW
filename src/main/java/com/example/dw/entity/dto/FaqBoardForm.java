package com.example.dw.entity.dto;

import com.example.dw.entity.admin.FaqBoard;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class FaqBoardForm {

    private Long id;
    private String faqBoardTitle;
    private String faqBoardContent;

    @Builder
    public FaqBoardForm(Long id, String faqBoardTitle, String faqBoardContent) {
        this.id = id;
        this.faqBoardTitle = faqBoardTitle;
        this.faqBoardContent = faqBoardContent;
    }

    public FaqBoard toEntity(){
        return FaqBoard.builder()
                .id(id)
                .faqBoardTitle(faqBoardTitle)
                .faqBoardContent(faqBoardContent)
                .build();
    }
}
