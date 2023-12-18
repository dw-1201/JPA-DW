package com.example.dw.domain.entity.freeBoard;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
//@Setter
@Table(name = "free_board_like")
@Builder
@NoArgsConstructor
        (access = AccessLevel.PROTECTED)
public class FreeBoardLike {
    @Id @GeneratedValue
    @Column(name = "free_board_like_id")
    private Long id;

    //    @Nullable
    private Long freeBoardLikeLike;
    private Long freeBoardLikeDisLike;
    private Long freeBoardLikeState;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "free_board_id")
    private FreeBoard freeBoard;

    @Builder
    public FreeBoardLike(Long id, @Nullable Long freeBoardLikeLike,
                     @Nullable Long freeBoardLikeDisLike, @Nullable Long freeBoardLikeState,
                         FreeBoard freeBoard) {
        this.id = id;
        this.freeBoardLikeLike = freeBoardLikeLike;
        this.freeBoardLikeDisLike = freeBoardLikeDisLike;
        this.freeBoardLikeState = freeBoardLikeState;
        this.freeBoard = freeBoard;
    }
}
