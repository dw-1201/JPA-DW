package com.example.dw.domain.entity.question;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "question_like")
public class QuestionLike {
    @Id
    @GeneratedValue
    @Column(name = "question_like_id")
    private Long id;

    @Nullable
    private Long questionLikeLike;
    @Nullable
    private Long questionLikeDisLike;
    @Nullable
    private Long questionLikeState;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;
}
