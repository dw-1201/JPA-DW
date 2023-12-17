package com.example.dw.domain.entity.admin;


import com.example.dw.domain.form.FaqBoardForm;
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
@Table(name = "faq_board")
public class FaqBoard {
    @Id
    @GeneratedValue
    @Column(name = "faq_board_id")
    private Long id;

    private String faqBoardTitle;
    private String faqBoardContent;
    @Builder.Default
    private Long faqBoardViewCount = 0L;
    @CreatedDate
    private String faqBoardRd;
    @LastModifiedDate
    private String faqBoardMd;

    @Builder
    public FaqBoard(Long id, String faqBoardTitle, String faqBoardContent,
                    Long faqBoardViewCount, String faqBoardRd, String faqBoardMd) {
        this.id = id;
        this.faqBoardTitle = faqBoardTitle;
        this.faqBoardContent = faqBoardContent;
        this.faqBoardViewCount = faqBoardViewCount;
        this.faqBoardRd = faqBoardMd;
        this.faqBoardMd = faqBoardRd;
    }

    //faq 수정
    public FaqBoard update(FaqBoardForm faqBoardForm){
        this.id=faqBoardForm.getId();
        this.faqBoardTitle=faqBoardForm.getFaqBoardTitle();
        this.faqBoardContent =faqBoardForm.getFaqBoardContent();
        this.faqBoardMd=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        return this;
    }


    //날짜포맷
    @PrePersist
    public void onPrePersist(){
        this.faqBoardRd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        this.faqBoardMd=this.faqBoardRd;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.faqBoardMd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }

}
