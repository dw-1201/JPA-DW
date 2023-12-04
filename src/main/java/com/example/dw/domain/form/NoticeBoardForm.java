package com.example.dw.domain.form;


import com.example.dw.domain.entity.admin.NoticeBoard;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeBoardForm {

    private Long id;
    private String noticeBoardTitle;
    private String noticeBoardContent;

    public NoticeBoardForm(Long id, String noticeBoardTitle, String noticeBoardContent
                           ) {
        this.id = id;
        this.noticeBoardTitle = noticeBoardTitle;
        this.noticeBoardContent = noticeBoardContent;
    }

    @Builder

    public NoticeBoard toEntity(){
        return NoticeBoard.builder()
                .id(id)
                .noticeBoardTitle(noticeBoardTitle)
                .noticeBoardContent(noticeBoardContent)
                .build();
    }

}
