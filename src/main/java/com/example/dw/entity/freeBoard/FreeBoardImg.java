package com.example.dw.entity.freeBoard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "free_board_img")
public class FreeBoardImg {
    @Id
    @GeneratedValue
    @Column(name = "free_board_img_id")
    private Long id;

    private String freeBoardImgRoute;
    private String freeBoardImgName;
    private String freeBoardImgUuid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "free_board_id")
    private FreeBoard freeBoard;
}
