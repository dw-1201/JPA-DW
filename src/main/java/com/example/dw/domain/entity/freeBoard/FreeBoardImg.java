package com.example.dw.domain.entity.freeBoard;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "free_board_img")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder
    public FreeBoardImg(Long id, String freeBoardImgRoute, String freeBoardImgName,
                        String freeBoardImgUuid, FreeBoard freeBoard) {
        this.id = id;
        this.freeBoardImgRoute = freeBoardImgRoute;
        this.freeBoardImgName = freeBoardImgName;
        this.freeBoardImgUuid = freeBoardImgUuid;
        this.freeBoard = freeBoard;
    }
}
