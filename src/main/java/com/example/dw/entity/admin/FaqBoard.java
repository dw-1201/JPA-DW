package com.example.dw.entity.admin;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    @Default
    private LocalDate faqBoardRd = LocalDate.now();
    @Default
    private LocalDate faqBoardMd = LocalDate.now();

    @Builder
    public FaqBoard(Long id, String faqBoardTitle, String faqBoardContent,
                    Long faqBoardViewCount, LocalDate faqBoardRd, LocalDate faqBoardMd) {
        this.id = id;
        this.faqBoardTitle = faqBoardTitle;
        this.faqBoardContent = faqBoardContent;
        this.faqBoardViewCount = faqBoardViewCount;
        this.faqBoardRd = faqBoardRd;
        this.faqBoardMd = faqBoardMd;
    }

}
