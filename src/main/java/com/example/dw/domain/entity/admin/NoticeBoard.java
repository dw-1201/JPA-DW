package com.example.dw.domain.entity.admin;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notice_board")
public class NoticeBoard {
    @Id
    @GeneratedValue
    @Column(name = "notice_board_id")
    private Long id;

    private String noticeBoardTitle;
    private String noticeBoardContent;

    @Default
    private Long noticeBoardViewCount = 0L;
    @Default
    private LocalDateTime noticeBoardRd = LocalDateTime.now();
    @Default
    private LocalDateTime noticeBoardMd = LocalDateTime.now();


    @Builder
    public NoticeBoard(Long id, String noticeBoardTitle, String noticeBoardContent,
                       Long noticeBoardViewCount, LocalDateTime noticeBoardRd,
                       LocalDateTime noticeBoardMd) {
        this.id = id;
        this.noticeBoardTitle = noticeBoardTitle;
        this.noticeBoardContent = noticeBoardContent;
        this.noticeBoardViewCount = noticeBoardViewCount;
        this.noticeBoardRd = noticeBoardRd;
        this.noticeBoardMd = noticeBoardMd;
    }
}
