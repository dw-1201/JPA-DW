package com.example.dw.domain.entity.freeBoard;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.FreeBoardWritingForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder //@Builder는 setter 대신 사용
@Table(name = "free_board")
@NoArgsConstructor
        (access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
// 생성일 수정일 변경 이력 기록
public class FreeBoard {
    @Id
    @GeneratedValue
    @Column(name = "free_board_id")
    private Long id;

//    @Column(length = 100, nullable= false)
    private String freeBoardTitle;
    private String freeBoardContent;

    @CreatedDate
    private LocalDateTime freeBoardRd;

    @LastModifiedDate
    private LocalDateTime freeBoardMd;

    @Default
    private Long freeBoardViewCount = 0L;

    @Default
    private Long freeBoardCommentCount = 0L; // 댓글 수 추가

    @OneToMany(mappedBy = "freeBoard" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FreeBoardImg> freeBoardImg = new ArrayList<>();

    @OneToMany(mappedBy = "freeBoard" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FreeBoardComment> freeBoardComment = new ArrayList<>();

    @OneToOne(mappedBy = "freeBoard" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private FreeBoardLike freeBoardLike;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @Builder
    public FreeBoard(Long id, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long freeBoardViewCount, Long freeBoardCommentCount, List<FreeBoardImg> freeBoardImg, List<FreeBoardComment> freeBoardComment, FreeBoardLike freeBoardLike, Users users) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.freeBoardCommentCount = freeBoardCommentCount;
        this.freeBoardImg = freeBoardImg;
        this.freeBoardComment = freeBoardComment;
        this.freeBoardLike = freeBoardLike;
        this.users = users;
    }

    //자유게시판 수정
    public FreeBoard update(FreeBoardWritingForm freeBoardWritingForm) {
        this.freeBoardTitle = freeBoardWritingForm.getFreeBoardTitle();
        this.freeBoardContent = freeBoardWritingForm.getFreeBoardContent();
//        this.freeBoardMd = LocalDateTime.now();

        return this;
    }

}

/**
 * orphanRemoval = true
 * 1.일대다 관계에서 사용
 * 2.FreeBoard 에서 자식 엔터티를 삭제하면,
 * 해당 자식 엔터티가 데이터베이스에서도 자동으로 삭제
 * 3.특히 부모-자식 간의 라이프사이클이 긴밀하게 연결되어 있고,
 * 자식이 부모를 더 이상 참조하지 않을 때 자동으로 삭제되길 원할 때 유용
 */
