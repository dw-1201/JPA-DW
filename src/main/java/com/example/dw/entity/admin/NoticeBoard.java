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
    private LocalDateTime noticeBoardRd;
    private LocalDateTime noticeBoardMd;

}
