package com.example.dw.entity.question;

import com.example.dw.entity.freeBoard.FreeBoardComment;
import com.example.dw.entity.freeBoard.FreeBoardImg;
import com.example.dw.entity.freeBoard.FreeBoardLike;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    private String questionTitle;
    private String questionContent;
    private LocalDateTime questionRd;
    private LocalDateTime questionMd;
    private Long questionViewCount;

    @OneToMany(mappedBy = "question" ,fetch = FetchType.LAZY)
    private List<QuestionImg> questionImg = new ArrayList<>();

    @OneToMany(mappedBy = "question" ,fetch = FetchType.LAZY)
    private List<QuestionComment> questionComment = new ArrayList<>();

    @OneToOne(mappedBy = "question" ,fetch = FetchType.LAZY)
    private QuestionLike questionLike;
}
