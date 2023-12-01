package com.example.dw.entity.walkingMate;

import com.example.dw.entity.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "walking_mate_comment")
public class WalkingMateComment {
    @Id
    @GeneratedValue
    @Column(name = "walking_mate_comment_id")
    private Long id;

    private String walkingMateCommentContent;
    private LocalDateTime walkingMateCommentRd;
    private LocalDateTime walkingMateCommentMd;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "walking_mate_id")
    private WalkingMate walkingMate;
}
