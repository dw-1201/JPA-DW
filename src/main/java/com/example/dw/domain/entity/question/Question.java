package com.example.dw.domain.entity.question;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.QuestionWritingForm;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static lombok.Builder.*;

@Entity
@Getter

@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    private String questionTitle;
    private String questionContent;

    @CreatedDate
    private String questionRd;
    @Default
    private LocalDateTime questionMd=LocalDateTime.now();

    private Long questionViewCount;

    @OneToMany(mappedBy = "question" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QuestionImg> questionImg = new ArrayList<>();

    @OneToMany(mappedBy = "question" ,fetch = FetchType.LAZY)
    private List<QuestionComment> questionComment = new ArrayList<>();

    @OneToOne(mappedBy = "question" ,fetch = FetchType.LAZY)
    private QuestionLike questionLike;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @Builder
    public Question(Long id,String questionTitle,String questionContent,List<QuestionImg>questionImg, Users users){
        this.id = id;
        this.questionTitle=questionTitle;
        this.questionContent=questionContent;
        this.questionImg=questionImg;
        this.users =users;
    }

    @PrePersist
    public void onPrePersist(){
        this.questionRd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }

    // questionViewCount 업데이트


    //question 업데이트
    public Question update(QuestionWritingForm questionWritingForm){
        this.questionTitle=questionWritingForm.getQuestionTitle();
        this.questionContent=questionWritingForm.getQuestionContent();


        return this;
    }

}
