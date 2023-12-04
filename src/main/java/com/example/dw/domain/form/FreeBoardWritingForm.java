package com.example.dw.domain.form;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FreeBoardWritingForm {

    private String freeBoardTitle;
    private String freeBoardContent;


    public FreeBoard toEntity(){
        return FreeBoard.builder()
                .freeBoardTitle(freeBoardTitle)
                .freeBoardContent(freeBoardContent)
                .build();
    }

    @Builder
    public FreeBoardWritingForm(String freeBoardTitle, String freeBoardContent) {
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;

    }
}
