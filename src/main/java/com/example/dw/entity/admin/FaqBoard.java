package com.example.dw.entity.admin;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static lombok.Builder.*;

@Entity
@Getter
@Setter
@Table(name = "faq_board")
public class FaqBoard {
    @Id
    @GeneratedValue
    @Column(name = "faq_board_id")
    private Long id;

    private String faqBoardTitle;
    private String faqBoardContent;
    @Default
    private Long faqBoardViewCount = 0L;
    private LocalDateTime faqBoardRd;
    private LocalDateTime faqBoardMd;

}
