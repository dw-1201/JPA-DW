package com.example.dw.domain.entity.freeBoard;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.FreeBoardCommentForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
//@Setter
@Table(name = "free_board_comment")
@Builder
@NoArgsConstructor
        (access = AccessLevel.PROTECTED)
public class FreeBoardComment {
    @Id
    @GeneratedValue
    @Column(name = "free_board_comment_id")
    private Long id;

    private String freeBoardCommentContent;

    @Default
    private LocalDateTime freeBoardCommentRd = LocalDateTime.now();
    @Default
    private LocalDateTime freeBoardCommentMd = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_board_id")
    private FreeBoard freeBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @Builder
    public FreeBoardComment(Long id, String freeBoardCommentContent,
                LocalDateTime freeBoardCommentRd, LocalDateTime freeBoardCommentMd,
                FreeBoard freeBoard, Users users) {
        this.id = id;
        this.freeBoardCommentContent = freeBoardCommentContent;
        this.freeBoardCommentRd = freeBoardCommentRd;
        this.freeBoardCommentMd = freeBoardCommentMd;
        this.freeBoard = freeBoard;
        this.users = users;
    }

    //
    public void update(FreeBoardCommentForm freeBoardCommentForm){
        this.freeBoardCommentContent = freeBoardCommentForm.getFreeBoardCommentContent();
        this.freeBoardCommentMd = LocalDateTime.now();
    }
}
