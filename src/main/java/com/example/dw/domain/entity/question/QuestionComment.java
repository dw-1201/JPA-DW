package com.example.dw.domain.entity.question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter

@Table(name = "question_comment")
public class QuestionComment {
    @Id
    @GeneratedValue
    @Column(name = "question_comment_id")
    private Long id;

    private String questionCommentContent;
    private LocalDateTime questionCommentRd;
    private LocalDateTime questionCommentMd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
}
