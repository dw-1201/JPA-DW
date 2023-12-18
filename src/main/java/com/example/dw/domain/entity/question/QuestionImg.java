package com.example.dw.domain.entity.question;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter

@Table(name = "question_img")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionImg {
    @Id
    @GeneratedValue
    @Column(name = "question_img_id")
    private Long id;

    private String questionImgRoute;
    private String questionImgName;
    private String questionImgUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Builder
    public QuestionImg(Long id, String questionImgRoute, String questionImgName, String questionImgUuid, Question question) {
        this.id = id;
        this.questionImgRoute = questionImgRoute;
        this.questionImgName = questionImgName;
        this.questionImgUuid = questionImgUuid;
        this.question = question;
    }


}
