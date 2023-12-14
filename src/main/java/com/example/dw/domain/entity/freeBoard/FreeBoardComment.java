package com.example.dw.domain.entity.freeBoard;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
    private LocalDateTime freeBoardCommentRd = LocalDateTime.now();
    private LocalDateTime freeBoardCommentMd = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "free_board_id")
    private FreeBoard freeBoard;

    @Builder
    public FreeBoardComment(Long id, String freeBoardCommentContent,
                LocalDateTime freeBoardCommentRd, LocalDateTime freeBoardCommentMd,
                FreeBoard freeBoard) {
        this.id = id;
        this.freeBoardCommentContent = freeBoardCommentContent;
        this.freeBoardCommentRd = freeBoardCommentRd;
        this.freeBoardCommentMd = freeBoardCommentMd;
        this.freeBoard = freeBoard;
    }
}
