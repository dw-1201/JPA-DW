package com.example.dw.entity.dto;

import com.example.dw.entity.freeBoard.FreeBoard;
import com.example.dw.entity.freeBoard.FreeBoardComment;
import com.example.dw.entity.freeBoard.FreeBoardImg;
import com.example.dw.entity.freeBoard.FreeBoardLike;
import com.example.dw.entity.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
