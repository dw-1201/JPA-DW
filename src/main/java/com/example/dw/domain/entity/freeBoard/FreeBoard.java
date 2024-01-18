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

/** @EntityListeners(AuditingEntityListener.class)
 * => 해당 엔터티의 생성일자(@CreatedDate), 수정일자(@LastModifiedDate),
 * 생성자(@CreatedBy), 수정자(@LastModifiedBy) 등을 자동으로 관리
 *  (엔터티에 대한 변경 사항을 감지하고 그에 대한 일부 정보를 자동으로 유지하기 위한 리스너를 활성화하는데 사용)
 *
 *  @EntityListeners : JPA 엔터티 리스너를 지정
 * AuditingEntityListener.class : 엔터티의 생성 및 수정 시간을 자동으로 관리
 */

/**
 * orphanRemoval = true
 * 1.일대다 관계에서 사용
 * 2.FreeBoard 에서 자식 엔터티를 삭제하면,
 * 해당 자식 엔터티가 데이터베이스에서도 자동으로 삭제
 * 3.특히 부모-자식 간의 라이프사이클이 긴밀하게 연결되어 있고,
 * 자식이 부모를 더 이상 참조하지 않을 때 자동으로 삭제되길 원할 때 유용
 */
@Entity @Getter @Builder
@Table(name = "free_board")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
        (access = AccessLevel.PROTECTED)
public class FreeBoard {
    @Id @GeneratedValue @Column(name = "free_board_id")
    private Long id;

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

    @OneToMany(mappedBy = "freeBoard" ,fetch = FetchType.LAZY)
    private List<FreeBoardComment> freeBoardComment = new ArrayList<>();

    @OneToOne(mappedBy = "freeBoard" ,fetch = FetchType.LAZY)
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
        return this;
    }
}