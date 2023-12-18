package com.example.dw.domain.entity.admin;

import com.example.dw.domain.form.NoticeBoardForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Builder.Default
    private Long noticeBoardViewCount = 0L;
    @CreatedDate
    private String noticeBoardRd;
    @LastModifiedDate
    private String noticeBoardMd ;


    @Builder
    public NoticeBoard(Long id, String noticeBoardTitle, String noticeBoardContent,
                       Long noticeBoardViewCount, String noticeBoardRd,
                       String noticeBoardMd) {
        this.id = id;
        this.noticeBoardTitle = noticeBoardTitle;
        this.noticeBoardContent = noticeBoardContent;
        this.noticeBoardViewCount = noticeBoardViewCount;
        this.noticeBoardRd = noticeBoardRd;
        this.noticeBoardMd = noticeBoardMd;



    }
    //공지사항 수정
    public NoticeBoard update(NoticeBoardForm noticeBoardForm){
        this.noticeBoardTitle=noticeBoardForm.getNoticeBoardTitle();
        this.noticeBoardContent=noticeBoardForm.getNoticeBoardContent();
        this.noticeBoardMd  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));

        return this;
    }


    @PrePersist
    public void onPrePersist(){
        this.noticeBoardRd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        this.noticeBoardMd=this.noticeBoardRd;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.noticeBoardMd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }


}
