package com.example.dw.domain.entity.question;

import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "question_comment")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class QuestionComment {
    @Id
    @GeneratedValue
    @Column(name = "question_comment_id")
    private Long id;

    private String questionCommentContent;
    @CreatedDate
    private LocalDateTime questionCommentRd;
    @LastModifiedDate
    private LocalDateTime questionCommentMd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @Builder
    public QuestionComment(Long id, String questionCommentContent, LocalDateTime questionCommentRd, LocalDateTime questionCommentMd, Question question, Users users) {
        this.id = id;
        this.questionCommentContent = questionCommentContent;
        this.questionCommentRd = questionCommentRd;
        this.questionCommentMd = questionCommentMd;
        this.question = question;
        this.users = users;
    }
}
