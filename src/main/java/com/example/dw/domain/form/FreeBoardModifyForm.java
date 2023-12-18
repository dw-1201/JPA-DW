package com.example.dw.domain.form;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.user.Users;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FreeBoardModifyForm {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private Long userId;


    public FreeBoard toEntity(){
        return FreeBoard.builder()
                .id(id)
                .freeBoardTitle(freeBoardTitle)
                .freeBoardContent(freeBoardContent)
                .users(Users.builder().id(userId).build())  // 사용자 ID 설정
                .build();
    }

    @Builder
    public FreeBoardModifyForm(Long id, String freeBoardTitle, String freeBoardContent,
                                Long userId) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.userId = userId;
    }
}
