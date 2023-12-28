package com.example.dw.domain.entity.walkingMate;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.WalkingMateCommentForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "walking_mate_comment")
public class WalkingMateComment {
    @Id
    @GeneratedValue
    @Column(name = "walking_mate_comment_id")
    private Long id;

    private String walkingMateCommentContent;

    @CreatedDate
    private LocalDateTime walkingMateCommentRd;

    @LastModifiedDate
    private LocalDateTime walkingMateCommentMd;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walking_mate_id")
    private WalkingMate walkingMate;


    @Builder
    public WalkingMateComment(Long id, String walkingMateCommentContent, LocalDateTime walkingMateCommentRd, LocalDateTime walkingMateCommentMd, Users users, WalkingMate walkingMate) {
        this.id = id;
        this.walkingMateCommentContent = walkingMateCommentContent;
        this.walkingMateCommentRd = walkingMateCommentRd;
        this.walkingMateCommentMd = walkingMateCommentMd;
        this.users = users;
        this.walkingMate = walkingMate;
    }



    public WalkingMateComment update(WalkingMateCommentForm walkingMateCommentForm){

        this.walkingMateCommentContent=walkingMateCommentForm.getWalkBoardComment();
        this.walkingMateCommentMd=LocalDateTime.now();

        return this;
    }

}
