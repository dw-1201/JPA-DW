package com.example.dw.domain.form;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import com.example.dw.domain.entity.user.Users;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FreeBoardCommentForm {
    private Long id;
    private String freeBoardCommentContent;
    private FreeBoard freeBoard;
    private Users users;

    @Builder
    public FreeBoardCommentForm(Long id, String freeBoardCommentContent, FreeBoard freeBoard, Users users) {
        this.id = id;
        this.freeBoardCommentContent = freeBoardCommentContent;
        this.freeBoard = freeBoard;
        this.users = users;
    }

    public FreeBoardComment toEntity(){
        return FreeBoardComment.builder()
                .id(id)
                .freeBoardCommentContent(freeBoardCommentContent)
                .freeBoard(freeBoard)
                .users(users)
                .build();
    }
}
