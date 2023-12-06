package com.example.dw.domain.entity.freeBoard;

import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//@Setter
@Builder //@Builder는 setter 대신 사용
@Table(name = "free_board")
@NoArgsConstructor
        (access = AccessLevel.PROTECTED)
public class FreeBoard {
    @Id
    @GeneratedValue
    @Column(name = "free_board_id")
    private Long id;

    @Column(length = 100, nullable= false)
    private String freeBoardTitle;

//    @Column(columnDefinition = "TEXT" , nullable = false)
    private String freeBoardContent;

    @Default
    private LocalDate freeBoardRd = LocalDate.now();

    @Default
    private LocalDate freeBoardMd = LocalDate.now();

    @Default
    private Long freeBoardViewCount = 0L;

    @OneToMany(mappedBy = "freeBoard" ,fetch = FetchType.LAZY)
    private List<FreeBoardImg> freeBoardImg = new ArrayList<>();

    @OneToMany(mappedBy = "freeBoard" ,fetch = FetchType.LAZY)
    private List<FreeBoardComment> freeBoardComment = new ArrayList<>();

    @OneToOne(mappedBy = "freeBoard" ,fetch = FetchType.LAZY)
    private FreeBoardLike freeBoardLike;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;

    @Builder
    public FreeBoard(Long id, String freeBoardTitle, String freeBoardContent, LocalDate freeBoardRd, LocalDate freeBoardMd, Long freeBoardViewCount, List<FreeBoardImg> freeBoardImg, List<FreeBoardComment> freeBoardComment, FreeBoardLike freeBoardLike, Users users) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.freeBoardImg = freeBoardImg;
        this.freeBoardComment = freeBoardComment;
        this.freeBoardLike = freeBoardLike;
        this.users = users;
    }
}
