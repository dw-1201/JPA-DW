package com.example.dw.entity.freeBoard;

import com.example.dw.entity.goods.GoodsDetailImg;
import com.example.dw.entity.user.UserFile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "free_board")
public class FreeBoard {
    @Id
    @GeneratedValue
    @Column(name = "free_board_id")
    private Long id;

    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardRd;
    private LocalDateTime freeBoardMd;
    private Long freeBoardViewCount;

    @OneToMany(mappedBy = "freeBoard" ,fetch = FetchType.LAZY)
    private List<FreeBoardImg> freeBoardImg = new ArrayList<>();

    @OneToMany(mappedBy = "freeBoard" ,fetch = FetchType.LAZY)
    private List<FreeBoardComment> freeBoardComment = new ArrayList<>();

    @OneToOne(mappedBy = "freeBoard" ,fetch = FetchType.LAZY)
    private FreeBoardLike freeBoardLike;

}
