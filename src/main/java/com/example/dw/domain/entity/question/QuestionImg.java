package com.example.dw.domain.entity.question;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;
}
