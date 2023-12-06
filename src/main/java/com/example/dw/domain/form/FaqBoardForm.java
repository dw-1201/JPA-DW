package com.example.dw.domain.form;

import com.example.dw.domain.entity.admin.FaqBoard;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class FaqBoardForm {

    private Long id;
    private String faqBoardTitle;
    private String faqBoardContent;




    public FaqBoardForm(String faqBoardTitle, String faqBoardContent){
        this.faqBoardTitle = faqBoardTitle;
        this.faqBoardContent = faqBoardContent;
    }


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
