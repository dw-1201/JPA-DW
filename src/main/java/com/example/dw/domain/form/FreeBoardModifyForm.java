package com.example.dw.domain.form;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.user.Users;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FreeBoardModifyForm {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDate freeBoardMd;
    private Long userId;  // 추가: 사용자 ID


    public FreeBoard toEntity(){
        return FreeBoard.builder()
                .id(id)
                .freeBoardTitle(freeBoardTitle)
                .freeBoardContent(freeBoardContent)
                .users(Users.builder().id(userId).build())  // 사용자 ID 설정
                .build();
    }

    @Builder
    public FreeBoardModifyForm(Long id, String freeBoardTitle,
                               String freeBoardContent, LocalDate freeBoardMd, Long userId) {
        this.id=id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardMd = freeBoardMd;
        this.userId = userId;

    }
}
