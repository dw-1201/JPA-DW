package com.example.dw.domain.entity.freeBoard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "free_board_comment")
public class FreeBoardComment {
    @Id
    @GeneratedValue
    @Column(name = "free_board_comment_id")
    private Long id;

    private String freeBoardCommentContent;
    private LocalDateTime freeBoardCommentRd;
    private LocalDateTime freeBoardCommentMd;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "free_board_id")
    private FreeBoard freeBoard;
}
