package com.example.dw.entity.freeBoard;

import com.example.dw.entity.goods.GoodsDetailImg;
import com.example.dw.entity.user.UserFile;
import com.example.dw.entity.user.Users;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder.Default;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.Builder.*;

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
    private LocalDateTime freeBoardRd = LocalDateTime.now();

    @Default
    private LocalDateTime freeBoardMd = LocalDateTime.now();

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
    public FreeBoard(Long id, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long freeBoardViewCount, List<FreeBoardImg> freeBoardImg, List<FreeBoardComment> freeBoardComment, FreeBoardLike freeBoardLike, Users users) {
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
