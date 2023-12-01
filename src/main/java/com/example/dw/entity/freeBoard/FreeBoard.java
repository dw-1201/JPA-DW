package com.example.dw.entity.freeBoard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime freeBoardDate;
    private Long freeBoardViewCount;
}
