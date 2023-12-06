package com.example.dw.domain.entity.question;

import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.Builder.*;

@Entity
@Getter
@Setter
@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    private String questionTitle;
    private String questionContent;

    @Default
    private LocalDateTime questionRd= LocalDateTime.now();
    @Default
    private LocalDateTime questionMd=LocalDateTime.now();
    private Long questionViewCount;

    @OneToMany(mappedBy = "question" ,fetch = FetchType.LAZY)
    private List<QuestionImg> questionImg = new ArrayList<>();

    @OneToMany(mappedBy = "question" ,fetch = FetchType.LAZY)
    private List<QuestionComment> questionComment = new ArrayList<>();

    @OneToOne(mappedBy = "question" ,fetch = FetchType.LAZY)
    private QuestionLike questionLike;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    @Builder
    public Question(Long id,String questionTitle,String questionContent,List<QuestionImg>questionImg){
        this.id = id;
        this.questionTitle=questionTitle;
        this.questionContent=questionContent;
        this.questionImg=questionImg;


    }



}
