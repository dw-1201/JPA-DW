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
@Builder
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

    @Builder.Default
    private Long questionViewCount=0L;

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
    public Question(Long id, String questionTitle, String questionContent, String questionRd, LocalDateTime questionMd, Long questionViewCount, List<QuestionImg> questionImg, List<QuestionComment> questionComment, QuestionLike questionLike, Users users) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.questionMd = questionMd;
        this.questionViewCount = questionViewCount;
        this.questionImg = questionImg;
        this.questionComment = questionComment;
        this.questionLike = questionLike;
        this.users = users;
    }

    public Question(Long id,String questionTitle,String questionContent,List<QuestionImg>questionImg, Users users ,Long questionViewCount){
        this.id = id;
        this.questionTitle=questionTitle;
        this.questionImg=questionImg;
        this.users =users;
        this.questionViewCount = questionViewCount;
        this.questionContent=questionContent;
    }


    @PrePersist
    public void onPrePersist(){
        this.questionRd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }




    //question수정
    public Question update(QuestionWritingForm questionWritingForm){
        this.questionTitle=questionWritingForm.getQuestionTitle();
        this.questionContent=questionWritingForm.getQuestionContent();


        return this;
    }

    // 조회수 증가
    public void increaseViewCount(){

        this.questionViewCount++;


    }

}
