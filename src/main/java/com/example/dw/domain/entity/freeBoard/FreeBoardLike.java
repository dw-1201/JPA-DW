package com.example.dw.domain.entity.freeBoard;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "free_board_like")
public class FreeBoardLike {
    @Id
    @GeneratedValue
    @Column(name = "free_board_like_id")
    private Long id;

    @Nullable
    private Long freeBoardLikeLike;
    @Nullable
    private Long freeBoardLikeDisLike;
    @Nullable
    private Long freeBoardLikeState;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "free_board_id")
    private FreeBoard freeBoard;
}
