package com.example.dw.domain.form;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.entity.walkingMate.WalkingMate;
import com.example.dw.domain.entity.walkingMate.WalkingMateComment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkingMateCommentForm {


    private Long id;
    private String walkBoardComment;
    private Long walkBoardId;
    private Long userId;


    public WalkingMateComment toEntity(){
        return WalkingMateComment.builder()
                .id(id)
                .walkingMateCommentContent(walkBoardComment)
                .walkingMate(WalkingMate.builder().id(walkBoardId).build())
                .users(Users.builder().id(userId).build())
                .build();
    }

}
